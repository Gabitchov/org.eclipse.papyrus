/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.policies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForDo;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForUndo;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts.CustomCompactLifelineCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.FigureUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.GeneralOrderingUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.OccurrenceSpecificationUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.RequestUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.TimeElementUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This edit policy handles moving (through drag&drop) the elements in the compartment of a compact Lifeline.
 */
public class CustomCompactLifelineCompartmentLayoutEditPolicy extends AbstractTimelineLayoutPolicy {

	@Override
	protected Command getMoveChildrenCommand(final Request request) {
		if(RequestUtils.isChangeBoundsRequestFor(request, UMLPackage.eINSTANCE.getOccurrenceSpecification())) {
			return getMoveOccurrenceSpecificationsCommand(request);
		}
		return super.getMoveChildrenCommand(request);
	}

	@Override
	protected Command getResizeChildrenCommand(final ChangeBoundsRequest request) {
		if(RequestUtils.isChangeBoundsRequestFor(request, UMLPackage.eINSTANCE.getStateInvariant())) {
			return getResizeStateInvariantsCommand(request);
		}
		return super.getResizeChildrenCommand(request);
	}

	private Command getResizeStateInvariantsCommand(final ChangeBoundsRequest request) {
		if(request.getResizeDirection() != PositionConstants.EAST) {
			return UnexecutableCommand.INSTANCE;
		}
		final CompoundCommand compoundCommand = new CompoundCommand(Messages.CustomCompactLifelineCompartmentLayoutEditPolicy_ResizeStateInvariant);
		final CompactLifelineEditPartCN lifelineEditPart = (CompactLifelineEditPartCN)getHost().getParent();
		compoundCommand.add(new RefreshCommandForUndo(lifelineEditPart));
		final CompactLifelineCompartmentEditPartCN compartmentEditPart = (CompactLifelineCompartmentEditPartCN)EditPartUtils.findFirstChildEditPartWithId(lifelineEditPart, CompactLifelineCompartmentEditPartCN.VISUAL_ID);

		final int widthDelta = FigureUtils.scaleByZoom(new Point(request.getSizeDelta().width, 0), lifelineEditPart.getFigure()).x;
		@SuppressWarnings("unchecked")
		final List<EditPart> editPartsToResize = request.getEditParts();
		@SuppressWarnings("unchecked")
		final List<EditPart> children = compartmentEditPart.getChildren();
		int deltaX = 0;
		boolean moved = false;
		for(int i = 0; i < children.size(); i++) {
			final EditPart childEditPart = children.get(i);
			EditPart nextChildEditPart = null;
			if(i < children.size() - 1) {
				nextChildEditPart = children.get(i + 1);
			}

			final Object model = childEditPart.getModel();
			if(model instanceof Node) {
				final Node childNode = (Node)model;
				boolean move = deltaX != 0;
				if(OccurrenceSpecificationUtils.isOccurrenceSpecificationEditPart(childEditPart)) {
					// only move OccurrenceSpecifications followed by a StateInvariant (state changes)
					move = move && nextChildEditPart instanceof CompactStateInvariantEditPartCN;
				}
				// if the element needs to be moved, then create the move command
				if(move && !TimeElementUtils.isTimeElementEditPart(childEditPart) && !GeneralOrderingUtils.isGeneralOrderingEditPart(childEditPart)) {
					final LayoutConstraint layoutConstraint = childNode.getLayoutConstraint();
					if(!(layoutConstraint instanceof Location)) {
						Activator.log.error("Expected a LayoutConstraint", new Exception()); //$NON-NLS-1$
						continue;
					}
					final Location location = (Location)layoutConstraint;
					final int newX = location.getX() + deltaX;
					final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(childNode);
					compoundCommand.add(new ICommandProxy(new AbstractTransactionalCommand(editingDomain, Messages.CustomCompactLifelineCompartmentLayoutEditPolicy_MoveElement, null) {

						@Override
						protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
							final Location loc = NotationFactory.eINSTANCE.createLocation();
							loc.setX(newX);
							childNode.setLayoutConstraint(loc);
							return CommandResult.newOKCommandResult();
						}
					}));
					moved = true;
				}
				if(editPartsToResize.contains(childEditPart)) {
					// resizing a StateInvariant moves all the elements after it
					deltaX += widthDelta;
				}
			}
		}
		if(!moved) {
			return UnexecutableCommand.INSTANCE;
		}
		compoundCommand.add(new RefreshCommandForDo(lifelineEditPart));
		return compoundCommand;
	}

	/** returns a NonResizableEditPolicy instead of a ResizableEditPolicy for some children */
	@Override
	protected EditPolicy createChildEditPolicy(final EditPart child) {
		final View childView = (View)child.getModel();
		final int visualID = UMLVisualIDRegistry.getVisualID(childView);
		// make OccurrenceSpecifications, time and duration elements and general orderings non-resizable
		if(OccurrenceSpecificationUtils.isOccurrenceSpecificationEditPart(visualID) || TimeElementUtils.isTimeElementEditPart(visualID) || GeneralOrderingUtils.isGeneralOrderingEditPart(visualID)) {
			return new NonResizableEditPolicyEx() {

				/** Override the command in order to pass all the moved EditParts in the request */
				@Override
				protected Command getMoveCommand(final ChangeBoundsRequest request) {
					final ChangeBoundsRequest req = new ChangeBoundsRequest(REQ_MOVE_CHILDREN);
					// all the request's EditParts instead of just the host
					req.setEditParts(request.getEditParts());
					req.setMoveDelta(request.getMoveDelta());
					req.setSizeDelta(request.getSizeDelta());
					req.setLocation(request.getLocation());
					req.setExtendedData(request.getExtendedData());
					return getHost().getParent().getCommand(req);
				}
			};
		}
		return new ResizableShapeEditPolicy() {

			/** Override the command in order to pass all the resized EditParts in the request */
			@Override
			protected Command getResizeCommand(final ChangeBoundsRequest request) {
				final ChangeBoundsRequest req = new ChangeBoundsRequest(REQ_RESIZE_CHILDREN);
				// all the request's EditParts instead of just the host
				req.setEditParts(request.getEditParts());
				req.setMoveDelta(request.getMoveDelta());
				req.setSizeDelta(request.getSizeDelta());
				req.setLocation(request.getLocation());
				req.setExtendedData(request.getExtendedData());
				req.setResizeDirection(request.getResizeDirection());
				return getHost().getParent().getCommand(req);
			}

			@Override
			public boolean isDragAllowed() {
				return false;
			}
		};
	}

	private Command getMoveOccurrenceSpecificationsCommand(final Request request) {
		final ChangeBoundsRequest changeBoundsRequest = (ChangeBoundsRequest)request;

		final CompoundCommand compoundCommand = new CompoundCommand(Messages.CustomCompactLifelineCompartmentLayoutEditPolicy_MoveOccurrenceSpecification);
		final CompactLifelineEditPartCN lifelineEditPart = (CompactLifelineEditPartCN)getHost().getParent();
		compoundCommand.add(new RefreshCommandForUndo(lifelineEditPart));

		final CompactLifelineCompartmentEditPartCN timelineCompartmentEditPart = (CompactLifelineCompartmentEditPartCN)EditPartUtils.findFirstChildEditPartWithId(lifelineEditPart, CompactLifelineCompartmentEditPartCN.VISUAL_ID);
		final View timelineCompartmentView = (View)timelineCompartmentEditPart.getModel();

		@SuppressWarnings("unchecked")
		final List<EditPart> editParts = changeBoundsRequest.getEditParts();
		final List<Node> nodesToMove = new ArrayList<Node>();
		for(final EditPart editPart : editParts) {
			final Object model = editPart.getModel();
			if(model instanceof Node) {
				final Node node = (Node)model;
				if(node.getElement() instanceof OccurrenceSpecification) {
					nodesToMove.add(node);
				}
			}
		}
		for(final Node node : nodesToMove) {
			final int index = timelineCompartmentView.getChildren().indexOf(node);
			if(index >= 0) {
				compoundCommand.add(getMoveOccurrenceSpecificationCommand(node, FigureUtils.scaleByZoom(changeBoundsRequest.getMoveDelta(), lifelineEditPart.getFigure()), timelineCompartmentView, index, nodesToMove));
			}
		}

		compoundCommand.add(new RefreshCommandForDo(lifelineEditPart));
		return compoundCommand;
	}

	@Override
	protected int getOriginX() {
		return CustomCompactLifelineCompartmentEditPart.FIRST_STATE_OFFSET;
	}
}
