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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionEndsCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.command.CreateGateViewCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragment2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.GateHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
@SuppressWarnings("unchecked")
public class GateGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy#getConnectionCompleteCommand(org.eclipse.gef.requests.CreateConnectionRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		request.getExtendedData().put(SequenceRequestConstant.TARGET_MODEL_CONTAINER, getInteractionFragment(request.getLocation()));
		Command command = super.getConnectionCompleteCommand(request);
		if(request instanceof CreateConnectionViewAndElementRequest) {
			CreateConnectionViewAndElementRequest viewRequest = (CreateConnectionViewAndElementRequest)request;
			EditPart sourceEP = viewRequest.getSourceEditPart();
			EObject source = ViewUtil.resolveSemanticElement((View)sourceEP.getModel());
			/*
			 * Create Graphical Gate if needed, See: https://bugs.eclipse.org/bugs/show_bug.cgi?id=389531
			 */
			String semanticHint = viewRequest.getConnectionViewAndElementDescriptor().getSemanticHint();
			//Ignore CoRegion.
			if(!(sourceEP instanceof CombinedFragment2EditPart) && (((IHintedType)(UMLElementTypes.Message_4004)).getSemanticHint().equals(semanticHint) || ((IHintedType)(UMLElementTypes.Message_4005)).getSemanticHint().equals(semanticHint))) {
				if(source instanceof CombinedFragment || source instanceof Interaction || source instanceof InteractionUse) {
					CompoundCommand cc = new CompoundCommand("Redirect to Gate");
					Point location = null;
					IGraphicalEditPart adapter = (IGraphicalEditPart)sourceEP.getAdapter(IGraphicalEditPart.class);
					if(adapter != null) {
						Point sourceLocation = request.getLocation();
						Object object = request.getExtendedData().get(SequenceRequestConstant.SOURCE_LOCATION_DATA);
						if(object instanceof Point) {
							sourceLocation = (Point)object;
						}
						location = GateHelper.computeGateLocation(sourceLocation, adapter.getFigure(), null);
					}
					ConnectionViewDescriptor edgeAdapter = viewRequest.getConnectionViewDescriptor();
					final IAdaptable elementAdapter = edgeAdapter.getElementAdapter();
					if(elementAdapter != null) {
						IAdaptable gateAdapter = new IAdaptable() {

							public Object getAdapter(Class adapter) {
								if(Gate.class == adapter) {
									Message message = (Message)elementAdapter.getAdapter(Message.class);
									MessageEnd sendEvent = message.getSendEvent();
									if(sendEvent instanceof Gate) {
										return sendEvent;
									}
								}
								return null;
							}
						};
						TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
						CreateGateViewCommand createGateCommand = new CreateGateViewCommand(editingDomain, sourceEP, location, gateAdapter);
						cc.add(new ICommandProxy(createGateCommand));
						SetConnectionEndsCommand resetSourceCommand = new SetConnectionEndsCommand(editingDomain, null);
						resetSourceCommand.setEdgeAdaptor(edgeAdapter);
						resetSourceCommand.setNewSourceAdaptor(createGateCommand.getResult());
						cc.add(new ICommandProxy(resetSourceCommand));
						if(cc.canExecute()) {
							command = command.chain(cc);
						}
					}
				}
			}
		}
		return command;
	}

	private Gate resolveSemanticElement() {
		return (Gate)((GateEditPart)getHost()).resolveSemanticElement();
	}

	/**
	 * Fix bug to find a correct InteractionOperand when connecting on CombinedFragment.
	 * 
	 * @param location
	 * @return
	 */
	private InteractionFragment getInteractionFragment(Point location) {
		Gate gate = resolveSemanticElement();
		if(gate != null) {
			InteractionFragment fragment = (InteractionFragment)gate.eContainer();
			if(fragment instanceof CombinedFragment) {
				fragment = SequenceUtil.findInteractionFragmentContainerAt(location, getHost());
				if(!(fragment instanceof InteractionOperand)) {
					Rectangle rect = SequenceUtil.getAbsoluteBounds((IGraphicalEditPart)getHost());
					fragment = SequenceUtil.findInteractionFragmentContainerAt(rect.getRight(), getHost());
					if(!(fragment instanceof InteractionOperand)) {
						fragment = SequenceUtil.findInteractionFragmentContainerAt(rect.getLeft(), getHost());
					}
				}
			}
			return fragment;
		}
		return null;
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy#getConnectionAndRelationshipCompleteCommand(org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Command getConnectionAndRelationshipCompleteCommand(CreateConnectionViewAndElementRequest request) {
		request.getExtendedData().put(SequenceRequestConstant.TARGET_MODEL_CONTAINER, getInteractionFragment(request.getLocation()));
		return super.getConnectionAndRelationshipCompleteCommand(request);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy#getConnectionCreateCommand(org.eclipse.gef.requests.CreateConnectionRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		if(request.getSourceEditPart() != null && request.getSourceEditPart() != getHost()) {
			return null;
		}
		request.getExtendedData().put(SequenceRequestConstant.SOURCE_MODEL_CONTAINER, getInteractionFragment(request.getLocation()));
		Rectangle rect = SequenceUtil.getAbsoluteBounds((IGraphicalEditPart)getHost());
		request.getExtendedData().put(SequenceRequestConstant.SOURCE_LOCATION_DATA, rect.getLocation());
		return super.getConnectionCreateCommand(request);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy#getConnectionAndRelationshipCreateCommand(org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Command getConnectionAndRelationshipCreateCommand(CreateConnectionViewAndElementRequest request) {
		if(request.getSourceEditPart() != null && request.getSourceEditPart() != getHost()) {
			return null;
		}
		request.getExtendedData().put(SequenceRequestConstant.SOURCE_MODEL_CONTAINER, getInteractionFragment(request.getLocation()));
		Rectangle rect = SequenceUtil.getAbsoluteBounds((IGraphicalEditPart)getHost());
		request.getExtendedData().put(SequenceRequestConstant.SOURCE_LOCATION_DATA, rect.getLocation());
		return super.getConnectionAndRelationshipCreateCommand(request);
	}

	protected Connection createDummyConnection(Request req) {
		PolylineConnection c = (PolylineConnection)super.createDummyConnection(req);
		c.setLineStyle(Graphics.LINE_DASHDOT);
		c.setForegroundColor(ColorConstants.black);
		return c;
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy#getDummyConnectionRouter(org.eclipse.gef.requests.CreateConnectionRequest)
	 * 
	 * @param arg0
	 * @return
	 */
	@Override
	protected ConnectionRouter getDummyConnectionRouter(CreateConnectionRequest arg0) {
		return LifelineChildGraphicalNodeEditPolicy.messageRouter;
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy#getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		ConnectionEditPart connectionEditPart = request.getConnectionEditPart();
		IGraphicalEditPart adapter = (IGraphicalEditPart)connectionEditPart.getAdapter(IGraphicalEditPart.class);
		if(adapter != null && adapter.resolveSemanticElement() instanceof Message) {
			Message oldMessage = (Message)adapter.resolveSemanticElement();
			Gate gate = resolveSemanticElement();
			if(gate == null || (gate.getMessage() != null && oldMessage != gate.getMessage())) {
				return UnexecutableCommand.INSTANCE;
			}
		}
		return super.getReconnectTargetCommand(request);
	}
}
