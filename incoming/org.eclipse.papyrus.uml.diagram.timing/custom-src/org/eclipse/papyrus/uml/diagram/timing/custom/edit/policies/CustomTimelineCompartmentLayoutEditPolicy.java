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
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForDo;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForUndo;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.FigureUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.GeneralOrderingUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.LifelineUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.OccurrenceSpecificationUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.RequestUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateDefinitionUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateInvariantUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.TimeElementUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineTimelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullStateInvariantVerticalLineEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.StateDefinitionEditPart;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This edit policy handles moving (through drag&drop) the elements in a Timeline compartment: StateInvariants,
 * OccurrenceSpecifications, etc.
 */
public class CustomTimelineCompartmentLayoutEditPolicy extends AbstractTimelineLayoutPolicy {

	private static final String ALL_MOVED_EDITPARTS = "ALL_MOVED_EDITPARTS"; //$NON-NLS-1$
	/** The height of the feedback figure when moving StateInvariants up or down. */
	private static final int LAYOUT_FEEDBACK_HEIGHT = 4;

	private final List<IFigure> layoutFeedbackFigures = new ArrayList<IFigure>();

	@Override
	protected Command getMoveChildrenCommand(final Request request) {
		if (RequestUtils.isChangeBoundsRequestFor(request, UMLPackage.eINSTANCE.getStateInvariant())) {
			return getMoveStateInvariantCommand(request);
		} else if (RequestUtils.isChangeBoundsRequestFor(request, FullStateInvariantVerticalLineEditPart.class)) {
			return getMoveVerticalLinesCommand(request);
		} else if (RequestUtils.isChangeBoundsRequestFor(request, UMLPackage.eINSTANCE.getOccurrenceSpecification())) {
			return getMoveOccurrenceSpecificationsCommand(request);
		}
		return super.getMoveChildrenCommand(request);
	}

	private Command getMoveStateInvariantCommand(final Request request) {
		final ChangeBoundsRequest changeBoundsRequest = (ChangeBoundsRequest) request;

		final Point location = changeBoundsRequest.getLocation();
		if (location == null) {
			Activator.log.warn("Ignoring ChangeBoundsRequest without a Location"); //$NON-NLS-1$
			return UnexecutableCommand.INSTANCE;
		}
		final int ordinate = location.y;
		final CompoundCommand compoundCommand = new CompoundCommand(Messages.CustomTimelineCompartmentLayoutEditPolicy_MoveStateInvariant);
		final FullLifelineEditPartCN lifelineEditPart = (FullLifelineEditPartCN) getHost().getParent();
		compoundCommand.add(new RefreshCommandForUndo(lifelineEditPart));
		final StateDefinitionEditPart stateDefinitionEditPart = StateDefinitionUtils.findStateDefinitionClosestToOrdinate(lifelineEditPart, ordinate);
		if (stateDefinitionEditPart == null) {
			return UnexecutableCommand.INSTANCE;
		}
		final View stateDefinitionView = ((View) stateDefinitionEditPart.getModel());
		final String closestStateDefinitionName = StateDefinitionUtils.getStateDefinitionName(stateDefinitionView);
		final String closestStateDefinitionId = StateDefinitionUtils.getStateDefinitionViewID(stateDefinitionView);

		@SuppressWarnings("unchecked")
		final List<EditPart> editParts = changeBoundsRequest.getEditParts();
		for (final EditPart editPart : editParts) {
			if (editPart instanceof FullStateInvariantEditPartCN) {
				final FullStateInvariantEditPartCN fullStateInvariantEditPart = (FullStateInvariantEditPartCN) editPart;
				final StateInvariant stateInvariant = (StateInvariant) ((View) (fullStateInvariantEditPart.getModel())).getElement();
				final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(stateInvariant);
				if (editingDomain == null) {
					throw new IllegalStateException("no editing domain"); //$NON-NLS-1$
				}

				final AbstractTransactionalCommand updateStateInvariantCommand = new AbstractTransactionalCommand(editingDomain,
						Messages.CustomTimelineCompartmentLayoutEditPolicy_UpdateStateInvariant, null) {
					@Override
					protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
						StateInvariantUtils.setStateInvariantId(stateInvariant, closestStateDefinitionId);
						StateInvariantUtils.setInnerStateInvariantName(stateInvariant, closestStateDefinitionName);
						final View lifelineView = (View) lifelineEditPart.getModel();
						final Lifeline lifeline = (Lifeline) lifelineView.getElement();
						LifelineUtils.updateFragmentNames(lifeline, lifelineView);
						return CommandResult.newOKCommandResult();
					}
				};
				compoundCommand.add(new ICommandProxy(updateStateInvariantCommand));
			}
		}
		compoundCommand.add(new RefreshCommandForDo(lifelineEditPart));
		return compoundCommand;
	}

	/**
	 * When moving a VerticalLine, we actually move the OccurrenceSpecification that precedes it (that is important for
	 * the layout).
	 */
	private Command getMoveVerticalLinesCommand(final Request request) {
		final ChangeBoundsRequest changeBoundsRequest = (ChangeBoundsRequest) request;

		final CompoundCommand compoundCommand = new CompoundCommand(Messages.CustomTimelineCompartmentLayoutEditPolicy_MoveVerticalLine);
		final FullLifelineEditPartCN lifelineEditPart = (FullLifelineEditPartCN) getHost().getParent();
		compoundCommand.add(new RefreshCommandForUndo(lifelineEditPart));

		final FullLifelineTimelineCompartmentEditPartCN timelineCompartmentEditPart = (FullLifelineTimelineCompartmentEditPartCN) EditPartUtils
				.findFirstChildEditPartWithId(lifelineEditPart, FullLifelineTimelineCompartmentEditPartCN.VISUAL_ID);
		final View timelineCompartmentView = (View) timelineCompartmentEditPart.getModel();

		@SuppressWarnings("unchecked")
		final List<EditPart> editParts = changeBoundsRequest.getEditParts();
		final Point moveDelta = FigureUtils.scaleByZoom(changeBoundsRequest.getMoveDelta(), lifelineEditPart.getFigure());
		// no vertical move
		moveDelta.y = 0;
		final List<Node> nodesToMove = new ArrayList<Node>();
		final List<Integer> indexes = new ArrayList<Integer>();
		final List<Node> allMovedNodes = getAllMovedNodes(request);
		for (final EditPart editPart : editParts) {
			if (editPart instanceof FullStateInvariantVerticalLineEditPart) {
				final FullStateInvariantVerticalLineEditPart verticalLineEditPart = (FullStateInvariantVerticalLineEditPart) editPart;
				final View verticalLineView = (View) verticalLineEditPart.getModel();
				final int index = timelineCompartmentView.getChildren().indexOf(verticalLineView);
				if (index > 0) {
					final int occurrenceSpecificationIndex = index - 1;
					final View previousView = (View) timelineCompartmentView.getChildren().get(occurrenceSpecificationIndex);
					if (previousView.getElement() instanceof OccurrenceSpecification) {
						final Node occurrenceSpecificationNode = (Node) previousView;
						nodesToMove.add(occurrenceSpecificationNode);
						indexes.add(Integer.valueOf(occurrenceSpecificationIndex));
					}
				}
			}
		}
		int i = 0;
		for (final Node node : nodesToMove) {
			compoundCommand.add(getMoveOccurrenceSpecificationCommand(node, moveDelta, timelineCompartmentView, indexes.get(i).intValue(), allMovedNodes));
			i++;
		}
		compoundCommand.add(new RefreshCommandForDo(lifelineEditPart));
		return compoundCommand;
	}

	private Command getMoveOccurrenceSpecificationsCommand(final Request request) {
		final ChangeBoundsRequest changeBoundsRequest = (ChangeBoundsRequest) request;

		final CompoundCommand compoundCommand = new CompoundCommand(Messages.CustomTimelineCompartmentLayoutEditPolicy_MoveOccurrenceSpecification);
		final FullLifelineEditPartCN lifelineEditPart = (FullLifelineEditPartCN) getHost().getParent();
		compoundCommand.add(new RefreshCommandForUndo(lifelineEditPart));

		final FullLifelineTimelineCompartmentEditPartCN timelineCompartmentEditPart = (FullLifelineTimelineCompartmentEditPartCN) EditPartUtils
				.findFirstChildEditPartWithId(lifelineEditPart, FullLifelineTimelineCompartmentEditPartCN.VISUAL_ID);
		final View timelineCompartmentView = (View) timelineCompartmentEditPart.getModel();
		@SuppressWarnings("unchecked")
		final List<EditPart> editParts = changeBoundsRequest.getEditParts();
		final Point moveDelta = FigureUtils.scaleByZoom(changeBoundsRequest.getMoveDelta(), lifelineEditPart.getFigure());
		// no vertical move
		moveDelta.y = 0;
		final List<Node> nodesToMove = new ArrayList<Node>();
		final List<Node> allMovedNodes = getAllMovedNodes(request);
		for (final EditPart editPart : editParts) {
			if (OccurrenceSpecificationUtils.isOccurrenceSpecificationEditPart(editPart)) {
				final Node occurrenceSpecificationNode = (Node) editPart.getModel();
				final Rectangle figureBounds = ((GraphicalEditPart) editPart).getFigure().getBounds();
				// constrain the move inside the timeline
				moveDelta.x = Math.min(moveDelta.x, getHostFigure().getBounds().width - figureBounds.x - figureBounds.width - 2);
				nodesToMove.add(occurrenceSpecificationNode);
			}
		}
		for (final Node node : nodesToMove) {
			final int index = timelineCompartmentView.getChildren().indexOf(node);
			if (index >= 0) {
				compoundCommand.add(getMoveOccurrenceSpecificationCommand(node, moveDelta, timelineCompartmentView, index, allMovedNodes));
			}
		}

		compoundCommand.add(new RefreshCommandForDo(lifelineEditPart));
		return compoundCommand;
	}

	@SuppressWarnings("unchecked")
	private static List<Node> getAllMovedNodes(final Request request) {
		final List<Node> allMovedNodes = new ArrayList<Node>();
		final Map<Object, Object> extendedData = request.getExtendedData();
		if (extendedData != null) {
			List<EditPart> editParts = (List<EditPart>) extendedData.get(ALL_MOVED_EDITPARTS);
			// when the request is sent directly, for example in unit tests
			if (editParts == null) {
				if (request instanceof GroupRequest) {
					final GroupRequest groupRequest = (GroupRequest) request;
					editParts = groupRequest.getEditParts();
				}
			}
			if (editParts != null) {
				for (final EditPart editPart : editParts) {
					if (editPart instanceof GraphicalEditPart) {
						final GraphicalEditPart graphicalEditPart = (GraphicalEditPart) editPart;
						final Object model = graphicalEditPart.getModel();
						if (model instanceof Node) {
							final Node node = (Node) model;
							allMovedNodes.add(node);
						}
					}
				}
			}
		}
		return allMovedNodes;
	}

	/** returns a NonResizableEditPolicy instead of a ResizableEditPolicy for some children */
	@Override
	protected EditPolicy createChildEditPolicy(final EditPart child) {
		final View childView = (View) child.getModel();
		final int visualID = UMLVisualIDRegistry.getVisualID(childView);
		// make these EditParts non-resizable
		if (visualID == FullStateInvariantEditPartCN.VISUAL_ID || OccurrenceSpecificationUtils.isOccurrenceSpecificationEditPart(visualID)
				|| visualID == FullStateInvariantVerticalLineEditPart.VISUAL_ID || TimeElementUtils.isTimeElementEditPart(visualID)
				|| GeneralOrderingUtils.isGeneralOrderingEditPart(visualID)) {
			return createNonResizableEditPolicy();
		}
		return super.createChildEditPolicy(child);
	}

	private NonResizableEditPolicy createNonResizableEditPolicy() {
		return new NonResizableEditPolicyEx() {
			/**
			 * Overridden in order to keep the information about all EditParts being dragged simultaneously (the GEF
			 * NonResizableEditPolicy redirects a multi-part move to several moves each on a single part)
			 */
			@Override
			protected Command getMoveCommand(final ChangeBoundsRequest request) {
				final ChangeBoundsRequest req = new ChangeBoundsRequest(REQ_MOVE_CHILDREN);
				// we lose the information when we do that:
				req.setEditParts(getHost());
				@SuppressWarnings("unchecked")
				final Map<Object, Object> extendedData = request.getExtendedData();
				// so we store it in the extended data
				extendedData.put(ALL_MOVED_EDITPARTS, request.getEditParts());
				req.setMoveDelta(request.getMoveDelta());
				req.setSizeDelta(request.getSizeDelta());
				req.setLocation(request.getLocation());
				req.setExtendedData(extendedData);
				return getHost().getParent().getCommand(req);
			}
		};
	}

	@Override
	protected void showLayoutTargetFeedback(final Request request) {
		if (!RequestUtils.isChangeBoundsRequestFor(request, UMLPackage.eINSTANCE.getStateInvariant())) {
			return;
		}
		eraseLayoutTargetFeedback();
		final ChangeBoundsRequest changeBoundsRequest = (ChangeBoundsRequest) request;
		final int targetY = computeTargetOrdinate(changeBoundsRequest);
		@SuppressWarnings("unchecked")
		final List<GraphicalEditPart> editParts = changeBoundsRequest.getEditParts();

		final double scale = FigureUtils.getScale(getHostFigure());
		for (final GraphicalEditPart editPart : editParts) {
			final Rectangle figureBounds = editPart.getFigure().getBounds();
			final Rectangle containerBounds = ((GraphicalEditPart) getHost()).getFigure().getBounds();
			final Rectangle feedbackBounds = new Rectangle(containerBounds.x + figureBounds.x, targetY - LAYOUT_FEEDBACK_HEIGHT / 2, figureBounds.width,
					LAYOUT_FEEDBACK_HEIGHT);
			feedbackBounds.scale(scale);
			this.layoutFeedbackFigures.add(createLayoutTargetFeedbackFigure(feedbackBounds));
		}
	}

	private int computeTargetOrdinate(final ChangeBoundsRequest request) {
		final int ordinate = request.getLocation().y;
		final FullLifelineEditPartCN lifelineEditPart = (FullLifelineEditPartCN) getHost().getParent();
		final StateDefinitionEditPart stateDefinitionEditPart = StateDefinitionUtils.findStateDefinitionClosestToOrdinate(lifelineEditPart, ordinate);

		final Rectangle figureBounds = stateDefinitionEditPart.getFigure().getBounds();
		return figureBounds.y + figureBounds.height / 2;
	}

	protected IFigure createLayoutTargetFeedbackFigure(final Rectangle bounds) {
		final RectangleFigure r = new RectangleFigure();
		r.setForegroundColor(ColorConstants.darkBlue);
		r.setBackgroundColor(ColorConstants.lightBlue);
		r.setBounds(bounds);
		r.validate();
		addFeedback(r);
		return r;
	}

	@Override
	protected void eraseLayoutTargetFeedback(final Request request) {
		if (!RequestUtils.isChangeBoundsRequestFor(request, UMLPackage.eINSTANCE.getStateInvariant())) {
			return;
		}
		eraseLayoutTargetFeedback();
	}

	private void eraseLayoutTargetFeedback() {
		for (final IFigure figure : this.layoutFeedbackFigures) {
			removeFeedback(figure);
		}
		this.layoutFeedbackFigures.clear();
	}
}
