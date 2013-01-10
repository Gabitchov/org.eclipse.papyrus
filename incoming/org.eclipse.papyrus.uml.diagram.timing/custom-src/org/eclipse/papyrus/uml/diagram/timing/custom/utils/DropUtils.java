/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.commands.CommonDeferredCreateConnectionViewCommand;
import org.eclipse.papyrus.uml.diagram.common.util.CrossReferencerUtil;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForDo;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForUndo;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.policies.AbstractTimelineLayoutPolicy;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionEditPartTN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimingDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLViewProvider;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageKind;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeObservation;

public final class DropUtils {

	private DropUtils() {
		// utility class
	}

	public static ICommand getDropMessageCommand(final Message message, final View dropTarget, final EditPartViewer viewer) {
		if(message.getMessageKind() == MessageKind.LOST_LITERAL) {
			return getDropLostMessageCommand(message, dropTarget, viewer);
		}
		if(message.getMessageKind() == MessageKind.FOUND_LITERAL) {
			return getDropFoundMessageCommand(message, dropTarget, viewer);
		}

		final MessageEnd sendEvent = message.getSendEvent();
		final MessageEnd receiveEvent = message.getReceiveEvent();
		if(sendEvent == null || receiveEvent == null) {
			return UnexecutableCommand.INSTANCE;
		}

		final List<View> sourceViews = new ArrayList<View>(CrossReferencerUtil.getCrossReferencingViews(sendEvent, TimingDiagramEditPart.MODEL_ID));
		final List<View> targetViews = new ArrayList<View>(CrossReferencerUtil.getCrossReferencingViews(receiveEvent, TimingDiagramEditPart.MODEL_ID));

		// Messages can only be created between MessageEnds
		filterMessageSourceOrTargetViews(sourceViews);
		filterMessageSourceOrTargetViews(targetViews);

		if(sourceViews.size() != 1 || targetViews.size() != 1) {
			return UnexecutableCommand.INSTANCE;
		}
		final View sourceView = sourceViews.get(0);
		final View targetView = targetViews.get(0);

		if(sourceView == null || sourceView.getDiagram() == null || targetView == null || targetView.getDiagram() == null) {
			return UnexecutableCommand.INSTANCE;
		}

		final View interactionView = ViewUtils.findSuperViewWithId(dropTarget, InteractionEditPartTN.VISUAL_ID);
		// the drop must be targeted inside the interaction
		if(interactionView == null) {
			return UnexecutableCommand.INSTANCE;
		}

		// the source and target views must be inside the interaction view
		if(!ViewUtils.isContained(sourceView, interactionView) || !ViewUtils.isContained(targetView, interactionView)) {
			return UnexecutableCommand.INSTANCE;
		}

		// don't allow multiple Views for the same Message in the same Diagram
		if(ViewUtils.containsConnectorFor(dropTarget, message)) {
			return UnexecutableCommand.INSTANCE;
		}
		// create the connection for the existing message, from the sourceView to the targetView
		return createMessageConnectionView(message, viewer, sourceView, targetView);
	}

	private static ICommand getDropLostMessageCommand(final Message message, final View dropTarget, final EditPartViewer viewer) {
		final MessageEnd sendEvent = message.getSendEvent();
		if(sendEvent == null) {
			return UnexecutableCommand.INSTANCE;
		}
		return getDropLostOrFoundMessage(message, dropTarget, viewer, sendEvent);
	}

	private static ICommand getDropFoundMessageCommand(final Message message, final View dropTarget, final EditPartViewer viewer) {
		final MessageEnd receiveEvent = message.getReceiveEvent();
		if(receiveEvent == null) {
			return UnexecutableCommand.INSTANCE;
		}
		return getDropLostOrFoundMessage(message, dropTarget, viewer, receiveEvent);
	}

	private static ICommand getDropLostOrFoundMessage(final Message message, final View dropTarget, final EditPartViewer viewer, final MessageEnd endEvent) {
		final List<View> endViews = DiagramEditPartsUtil.findViews(endEvent, viewer);
		filterMessageSourceOrTargetViews(endViews);
		if(endViews.size() != 1) {
			return UnexecutableCommand.INSTANCE;
		}
		final View endView = endViews.get(0);
		final View interactionView = ViewUtils.findSuperViewWithId(dropTarget, InteractionEditPartTN.VISUAL_ID);
		View lifelineView = ViewUtils.findSuperViewWithId(endView, FullLifelineEditPartCN.VISUAL_ID);
		if(lifelineView == null) {
			lifelineView = ViewUtils.findSuperViewWithId(endView, CompactLifelineEditPartCN.VISUAL_ID);
		}
		if(interactionView == null || lifelineView == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if(!ViewUtils.isContained(endView, interactionView)) {
			return UnexecutableCommand.INSTANCE;
		}
		if(ViewUtils.containsConnectorFor(dropTarget, message)) {
			return UnexecutableCommand.INSTANCE;
		}

		// create the connection for the lost message, from the endView to the lifelineView
		if(message.getMessageKind() == MessageKind.LOST_LITERAL) {
			return createMessageConnectionView(message, viewer, endView, lifelineView);
		}
		// create the connection for the found message, from the lifelineView to the endView
		return createMessageConnectionView(message, viewer, lifelineView, endView);
	}

	private static ICommand createMessageConnectionView(final Message message, final EditPartViewer viewer, final View sourceView, final View targetView) {
		final IElementType elementType = MessageUtils.getElementType(message);
		final String semanticHint = ((IHintedType)elementType).getSemanticHint();
		final ConnectionViewDescriptor connectionViewDescriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(elementType, semanticHint, ViewUtil.APPEND, true, PreferencesHint.USE_DEFAULTS);
		final IAdaptable sourceViewAdapter = new EObjectAdapter(sourceView);
		final IAdaptable targetViewAdapter = new EObjectAdapter(targetView);
		final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(message);
		final CommonDeferredCreateConnectionViewCommand createConnectionViewCommand = new CommonDeferredCreateConnectionViewCommand(editingDomain, semanticHint, sourceViewAdapter, targetViewAdapter, viewer, PreferencesHint.USE_DEFAULTS, connectionViewDescriptor, null);
		createConnectionViewCommand.setElement(message);
		return createConnectionViewCommand;
	}

	private static void filterMessageSourceOrTargetViews(final List<View> views) {
		final ListIterator<View> listIterator = views.listIterator();
		while(listIterator.hasNext()) {
			final View view = listIterator.next();
			final int visualID = UMLVisualIDRegistry.getVisualID(view);
			if(!OccurrenceSpecificationUtils.isOccurrenceSpecificationEditPart(visualID) && visualID != GateEditPart.VISUAL_ID) {
				listIterator.remove();
			}
		}
	}

	private interface IDropLinkedNodeInLifelineAction<T extends EObject> {

		void drop(T element, View compartmentView);
	}

	public static ICommand getDropLinkedNodeInLifelineCommand(final EObject droppedElement, final Collection<EObject> linkedElements, final View dropTarget, final EditPartViewer viewer, final IDropLinkedNodeInLifelineAction<? extends EObject> dropAction) {
		final View interactionView = ViewUtils.findSuperViewWithId(dropTarget, InteractionEditPartTN.VISUAL_ID);
		// the drop must be targeted inside the interaction
		if(interactionView == null || ViewUtils.containsViewFor(interactionView, droppedElement)) {
			return UnexecutableCommand.INSTANCE;
		}

		final Set<View> targetLifelines = new HashSet<View>();
		for(final EObject eObject : linkedElements) {
			if(eObject instanceof InteractionFragment) {
				final InteractionFragment interactionFragment = (InteractionFragment)eObject;
				final EList<Lifeline> covereds = interactionFragment.getCovereds();
				for(final Lifeline lifeline : covereds) {
					final List<View> lifelineViews = DiagramEditPartsUtil.findViews(lifeline, viewer);
					for(final View lifelineView : lifelineViews) {
						if(LifelineUtils.isLifelineView(lifelineView) && ViewUtils.isContained(lifelineView, interactionView)) {
							targetLifelines.add(lifelineView);
						}
					}
				}
			}
		}
		final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(interactionView);
		final CompositeCommand compositeCommand = new CompositeCommand(Messages.DropUtils_DropElement);

		compositeCommand.add(new AbstractTransactionalCommand(editingDomain, Messages.DropUtils_DropElement, null) {

			@SuppressWarnings("unchecked")
			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				for(final View targetLifeline : targetLifelines) {
					final View compartmentView = ViewUtils.findChildTimelineCompartmentView(targetLifeline);
					((IDropLinkedNodeInLifelineAction<EObject>)dropAction).drop(droppedElement, compartmentView);
				}
				return CommandResult.newOKCommandResult();
			}
		});

		// add command to layout the new Node
		for(final View targetLifeline : targetLifelines) {
			final EditPart lifelineEditPart = (EditPart)viewer.getEditPartRegistry().get(targetLifeline);
			final EditPart compartmentEditPart = LifelineUtils.getLifelineCompartment(lifelineEditPart);
			compositeCommand.add(new CommandProxy(compartmentEditPart.getCommand(AbstractTimelineLayoutPolicy.UPDATE_LAYOUT_REQUEST)));
		}

		return compositeCommand;
	}

	protected static class DropTimeObservationAction implements IDropLinkedNodeInLifelineAction<TimeObservation> {

		public void drop(final TimeObservation timeObservation, final View compartmentView) {
			final Node timeObservationNode = new UMLViewProvider().createTimeObservation_16(timeObservation, compartmentView, ViewUtil.APPEND, true, PreferencesHint.USE_DEFAULTS);
			if(timeObservationNode != null) {
				final Location loc = NotationFactory.eINSTANCE.createLocation();
				loc.setX(0);
				loc.setY(40);
				timeObservationNode.setLayoutConstraint(loc);
			}
		}
	}

	public static ICommand getDropTimeObservationCommand(final TimeObservation timeObservation, final View dropTarget, final EditPartViewer viewer) {
		final NamedElement event = timeObservation.getEvent();
		return getDropLinkedNodeInLifelineCommand(timeObservation, Collections.<EObject> singletonList(event), dropTarget, viewer, new DropTimeObservationAction());
	}

	protected static class DropTimeConstraintAction implements IDropLinkedNodeInLifelineAction<TimeConstraint> {

		public void drop(final TimeConstraint timeConstraint, final View compartmentView) {
			final Node timeConstraintNode = new UMLViewProvider().createTimeConstraint_15(timeConstraint, compartmentView, ViewUtil.APPEND, true, PreferencesHint.USE_DEFAULTS);
			if(timeConstraintNode != null) {
				final Bounds bounds = NotationFactory.eINSTANCE.createBounds();
				bounds.setY(40);
				timeConstraintNode.setLayoutConstraint(bounds);
			}
		}
	}

	public static ICommand getDropTimeConstraintCommand(final TimeConstraint timeConstraint, final View dropTarget, final EditPartViewer viewer) {
		final Collection<EObject> linkedElements = new ArrayList<EObject>();
		linkedElements.addAll(timeConstraint.getConstrainedElements());
		return getDropLinkedNodeInLifelineCommand(timeConstraint, linkedElements, dropTarget, viewer, new DropTimeConstraintAction());
	}

	protected static class DropDurationObservationAction implements IDropLinkedNodeInLifelineAction<DurationObservation> {

		public void drop(final DurationObservation durationObservation, final View compartmentView) {
			final Node durationObservationNode = new UMLViewProvider().createDurationObservation_17(durationObservation, compartmentView, ViewUtil.APPEND, true, PreferencesHint.USE_DEFAULTS);
			if(durationObservationNode != null) {
				final Location loc = NotationFactory.eINSTANCE.createLocation();
				loc.setX(0);
				loc.setY(40);
				durationObservationNode.setLayoutConstraint(loc);
			}
		}
	}

	public static ICommand getDropDurationObservationCommand(final DurationObservation durationObservation, final View dropTarget, final EditPartViewer viewer) {
		final Collection<EObject> linkedElements = new ArrayList<EObject>();
		linkedElements.addAll(durationObservation.getEvents());
		return getDropLinkedNodeInLifelineCommand(durationObservation, linkedElements, dropTarget, viewer, new DropDurationObservationAction());
	}

	protected static class DropDurationConstraintAction implements IDropLinkedNodeInLifelineAction<DurationConstraint> {

		public void drop(final DurationConstraint durationConstraint, final View compartmentView) {
			final Node durationConstraintNode = new UMLViewProvider().createDurationConstraint_18(durationConstraint, compartmentView, ViewUtil.APPEND, true, PreferencesHint.USE_DEFAULTS);
			if(durationConstraintNode != null) {
				final Bounds bounds = NotationFactory.eINSTANCE.createBounds();
				bounds.setY(5);
				durationConstraintNode.setLayoutConstraint(bounds);
			}
		}
	}

	public static ICommand getDropDurationConstraintCommand(final DurationConstraint durationConstraint, final View dropTarget, final EditPartViewer viewer) {
		final Collection<EObject> linkedElements = new ArrayList<EObject>();
		linkedElements.addAll(durationConstraint.getConstrainedElements());
		return getDropLinkedNodeInLifelineCommand(durationConstraint, linkedElements, dropTarget, viewer, new DropDurationConstraintAction());
	}

	protected static class DropGeneralOrderingAction implements IDropLinkedNodeInLifelineAction<GeneralOrdering> {

		public void drop(final GeneralOrdering generalOrdering, final View compartmentView) {
			final Node generalOrderingNode = new UMLViewProvider().createGeneralOrdering_67(generalOrdering, compartmentView, ViewUtil.APPEND, true, PreferencesHint.USE_DEFAULTS);
			if(generalOrderingNode != null) {
				final Bounds bounds = NotationFactory.eINSTANCE.createBounds();
				bounds.setY(30);
				generalOrderingNode.setLayoutConstraint(bounds);
			}
		}
	}

	public static ICommand getDropGeneralOrderingCommand(final GeneralOrdering generalOrdering, final View dropTarget, final EditPartViewer viewer) {
		final Collection<EObject> linkedElements = new ArrayList<EObject>();
		linkedElements.add(generalOrdering.getBefore());
		linkedElements.add(generalOrdering.getAfter());
		return getDropLinkedNodeInLifelineCommand(generalOrdering, linkedElements, dropTarget, viewer, new DropGeneralOrderingAction());
	}

	public static ICommand getDropGateCommand(final Gate gate, final View dropTarget, final EditPartViewer viewer) {
		final Node interactionView = (Node)ViewUtils.findSuperViewWithId(dropTarget, InteractionEditPartTN.VISUAL_ID);
		// the drop must be targeted on the interaction
		if(interactionView == null || ViewUtils.containsViewFor(interactionView, gate)) {
			return UnexecutableCommand.INSTANCE;
		}
		final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(interactionView);
		final CompositeCommand compositeCommand = new CompositeCommand(Messages.DropUtils_DropGate);
		compositeCommand.add(new CommandProxy(new RefreshCommandForUndo((GraphicalEditPart)viewer.getRootEditPart())));
		compositeCommand.add(new AbstractTransactionalCommand(editingDomain, Messages.DropUtils_DropGate, null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				final Node gateNode = new UMLViewProvider().createGate_69(gate, interactionView, ViewUtil.APPEND, true, PreferencesHint.USE_DEFAULTS);
				try {
					final int index = ((Interaction)gate.eContainer()).getFormalGates().indexOf(gate);
					final Location loc = NotationFactory.eINSTANCE.createLocation();
					// space Gates regularly (useful when dropping several Gates)
					loc.setX(-10);
					loc.setY(30 + index * 20);
					gateNode.setLayoutConstraint(loc);
				} catch (final Exception e) {
					Activator.log.error("Couldn't layout dropped Gates", e); //$NON-NLS-1$
				}
				return CommandResult.newOKCommandResult();
			}
		});
		compositeCommand.add(new CommandProxy(new RefreshCommandForDo((GraphicalEditPart)viewer.getRootEditPart())));

		return compositeCommand;
	}

}
