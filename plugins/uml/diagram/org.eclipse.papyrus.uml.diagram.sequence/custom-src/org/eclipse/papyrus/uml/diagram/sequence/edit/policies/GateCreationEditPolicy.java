/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.command.CreateGateElementAndViewCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.locator.GateLocator;
import org.eclipse.papyrus.uml.diagram.sequence.util.GateHelper;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class GateCreationEditPolicy extends LayoutEditPolicy {

	private static final String GATE_LOCATION_DATA = "Gate location data";

	private IFigure gateFeedback;

	/**
	 * Constructor.
	 * 
	 */
	public GateCreationEditPolicy() {
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy#getTargetEditPart(org.eclipse.gef.Request)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	public EditPart getTargetEditPart(Request request) {
		//Fixed bug when creating Gate, take care of CustomizableDropEditPolicy.
		if(isGateCreation(request)) {
			if(getHost() instanceof InteractionEditPart && !touchesInteractionBounds((GraphicalEditPart)getHost(), ((CreateRequest)request).getLocation())) {
				return null;
			}
			return getHost();
		}
		return null;
	}

	private boolean touchesInteractionBounds(GraphicalEditPart interaction, Point location) {
		Point p = location.getCopy();
		IFigure figure = interaction.getFigure();
		figure.translateToRelative(p);
		// if mouse location is far from border, do not handle connection event 
		Rectangle r = figure.getBounds().getCopy();
		Rectangle innerRetangle = r.getShrinked(20, 20);
		if(innerRetangle.contains(p)) {
			return false;
		}
		return r.getExpanded(1, 1).contains(p);
	}

	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#showTargetFeedback(org.eclipse.gef.Request)
	 * 
	 * @param request
	 */
	@Override
	public void showTargetFeedback(Request request) {
		if(isGateCreation(request)) {
			showCreateGateFeedback((CreateRequest)request);
		}
		super.showTargetFeedback(request);
	}

	/**
	 * @param request
	 */
	private void showCreateGateFeedback(CreateRequest request) {
		if(gateFeedback == null) {
			gateFeedback = new RectangleFigure();
			((RectangleFigure)gateFeedback).setLineWidth(2);
			gateFeedback.setSize(GateEditPart.DEFAULT_SIZE);
			getFeedbackLayer().add(gateFeedback);
		}
		GateLocator locator = new GateLocator(getHostFigure());
		Rectangle proposedLocation = new Rectangle();
		proposedLocation.setLocation(request.getLocation());
		proposedLocation.setSize(GateEditPart.DEFAULT_SIZE);
		getHostFigure().translateToRelative(proposedLocation);
		Rectangle rect = locator.getValidLocation(proposedLocation, gateFeedback);
		getHostFigure().translateToAbsolute(rect);
		gateFeedback.translateToRelative(rect);
		gateFeedback.setBounds(rect);
		Point location = rect.getLocation().getCopy();
		gateFeedback.translateToAbsolute(location);
		getHostFigure().translateToRelative(location);
		request.getExtendedData().put(GATE_LOCATION_DATA, location);
	}

	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#eraseTargetFeedback(org.eclipse.gef.Request)
	 * 
	 * @param request
	 */
	@Override
	public void eraseTargetFeedback(Request request) {
		super.eraseTargetFeedback(request);
		if(gateFeedback != null && gateFeedback.getParent() != null) {
			gateFeedback.getParent().remove(gateFeedback);
			gateFeedback = null;
		}
	}

	private boolean isGateCreation(Request request) {
		if(!(request instanceof CreateRequest)) {
			return false;
		}
		CreateRequest createReq = (CreateRequest)request;
		try {
			Object newObjectType = createReq.getNewObjectType();
			return GateEditPart.GATE_TYPE.equals(newObjectType);
		} catch (Exception e) {
			//There's no CreationFactory set.
			return false;
		}
	}

	/**
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#createChildEditPolicy(org.eclipse.gef.EditPart)
	 * 
	 * @param child
	 * @return
	 */
	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		return child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
	}

	/**
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Command getCreateCommand(CreateRequest request) {
		if(isGateCreation(request)) {
			EditPart targetEditPart = getTargetEditPart(request);
			if(targetEditPart == null) {
				return UnexecutableCommand.INSTANCE;
			}
			//Disable creation when there's no refersTo set for InteractionUse.
			//			IGraphicalEditPart adapter = (IGraphicalEditPart)targetEditPart.getAdapter(IGraphicalEditPart.class);
			//			if(adapter != null) {
			//				EObject semanticElement = adapter.resolveSemanticElement();
			//				if(semanticElement instanceof InteractionUse && ((InteractionUse)semanticElement).getRefersTo() == null) {
			//					return UnexecutableCommand.INSTANCE;
			//				}
			//			}
			if(targetEditPart instanceof InteractionEditPart) {
				if(!touchesInteractionBounds((InteractionEditPart)targetEditPart, ((CreateRequest)request).getLocation())) {
					return UnexecutableCommand.INSTANCE;
				}
			}
			Point location = (Point)request.getExtendedData().get(GATE_LOCATION_DATA);
			if(location == null) {
				location = GateHelper.computeGateLocation(request.getLocation(), getHostFigure(), null);
			}
			return getCreateGateCommand(location);
		}
		return null;
	}

	/**
	 * Create Gate Element and View.
	 */
	protected Command getCreateGateCommand(Point location) {
		return new ICommandProxy(new CreateGateElementAndViewCommand(getEditingDomain(), getHost(), location));
	}

	private TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart)getHost()).getEditingDomain();
	}

	/**
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getMoveChildrenCommand(org.eclipse.gef.Request)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Command getMoveChildrenCommand(Request request) {
		return null;
	}

	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#understandsRequest(org.eclipse.gef.Request)
	 * 
	 * @param req
	 * @return
	 */
	@Override
	public boolean understandsRequest(Request req) {
		//Fixed bug when creating Gate, take care of CustomizableDropEditPolicy.
		if(isGateCreation(req)) {
			EditPart targetEditPart = getTargetEditPart(req);
			if(targetEditPart == null) {
				return false;
			}
			return true;
		}
		return false;
	}
}
