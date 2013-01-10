/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.DescriptionStyle;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.handlers.GraphicalCommandHandler;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts.CustomCompactLifelineCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.DropUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateDefinitionUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateInvariantUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.TickUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.TimeRulerUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.Utils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.ViewUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FreeTimeRulerCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TickNameEditPart;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLViewProvider;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.UMLPackage;

public class SwitchLifelineCommand extends GraphicalCommandHandler {

	private Command switchLifeline(final IGraphicalEditPart lifelineEditPart) {
		final EditPartViewer viewer = lifelineEditPart.getViewer();
		final View lifelineView = (View)lifelineEditPart.getModel();
		final View timeRulerCompartmentView = ViewUtils.findTimeRulerCompartmentView(lifelineView);
		final boolean timeRulerVisible = timeRulerCompartmentView.isVisible();
		final Lifeline lifeline = (Lifeline)lifelineView.getElement();
		final CompoundCommand cc = new CompoundCommand(Messages.SwitchLifelineCommand_switchLifeline);

		// we need to re-associate ticks in the Interaction time ruler to their new OccurrenceSpecification Views
		final Map<OccurrenceSpecification, List<Node>> ticksAssociations = computeAllTicksAssociations(lifelineView);
		// we need to re-create ticks in the Lifeline time ruler (since they get destroyed when destroying the Lifeline)
		final Map<OccurrenceSpecification, String> lifelineTicksAssociations = computeLifelineTicksAssociations(lifelineView);

		if(lifelineEditPart instanceof CompactLifelineEditPartCN) {
			cc.add(new RefreshCommandForUndo((GraphicalEditPart)lifelineEditPart.getParent()));
			cc.add(new ICommandProxy(getNameUnnamedStateInvariants(lifeline)));
			final ICommand createCommand = new ChangeLifelineFromCompactToFull(getEditingDomain(), lifelineEditPart);
			cc.add(new ICommandProxy(createCommand));
			cc.add(new ICommandProxy(getFreeTimeRulerCreationCommand(createCommand, timeRulerVisible)));
			cc.add(new ICommandProxy(getStateDefinitionCreationForFullLifelineCommand(lifeline, createCommand)));
			cc.add(new ICommandProxy(getFragmentsCreationForFullLifelineCommand(lifeline, createCommand)));
			cc.add(new ICommandProxy(getTicksAssociationCommand(createCommand, ticksAssociations)));
			cc.add(new ICommandProxy(getLifelineTicksCreationCommand(createCommand, lifelineTicksAssociations)));
			addDestroyViewsAndEdgesRecursivelyCommand(cc, lifelineView);
			// we need to create the EditParts corresponding to the MessageEnd Views before trying to reconnect Messages
			cc.add(new RefreshCommandForDo((GraphicalEditPart)lifelineEditPart.getParent()));
			cc.add(new ICommandProxy(getMessagesCreationCommand(createCommand, viewer)));
			cc.add(new ICommandProxy(getLinkedElementsCreationCommand(createCommand, viewer)));
			cc.add(new RefreshCommandForDo((GraphicalEditPart)lifelineEditPart.getParent()));
			return cc;
		} else if(lifelineEditPart instanceof FullLifelineEditPartCN) {
			cc.add(new RefreshCommandForUndo((GraphicalEditPart)lifelineEditPart.getParent()));
			final ICommand createCommand = new ChangeLifelineFromFullToCompact(getEditingDomain(), lifelineEditPart);
			cc.add(new ICommandProxy(createCommand));
			cc.add(new ICommandProxy(getFreeTimeRulerCreationCommand(createCommand, timeRulerVisible)));
			cc.add(new ICommandProxy(getFragmentsCreationForCompactLifelineCommand(lifeline, createCommand)));
			cc.add(new ICommandProxy(getTicksAssociationCommand(createCommand, ticksAssociations)));
			cc.add(new ICommandProxy(getLifelineTicksCreationCommand(createCommand, lifelineTicksAssociations)));
			addDestroyViewsAndEdgesRecursivelyCommand(cc, lifelineView);
			// we need to create the EditParts corresponding to the MessageEnd Views before trying to reconnect Messages
			cc.add(new RefreshCommandForDo((GraphicalEditPart)lifelineEditPart.getParent()));
			cc.add(new ICommandProxy(getMessagesCreationCommand(createCommand, viewer)));
			cc.add(new ICommandProxy(getLinkedElementsCreationCommand(createCommand, viewer)));
			cc.add(new RefreshCommandForDo((GraphicalEditPart)lifelineEditPart.getParent()));
			return cc;
		}
		throw new IllegalArgumentException("expected a Lifeline edit part"); //$NON-NLS-1$
	}

	/** Compute the map of OccurrenceSpecifications to corresponding tick Views. */
	private static Map<OccurrenceSpecification, List<Node>> computeAllTicksAssociations(final View lifelineView) {
		final Map<OccurrenceSpecification, List<Node>> map = new HashMap<OccurrenceSpecification, List<Node>>();
		final View timelineCompartmentView = ViewUtils.findChildTimelineCompartmentView(lifelineView);
		@SuppressWarnings("unchecked")
		final EList<View> children = timelineCompartmentView.getChildren();
		for(final View child : children) {
			if(ViewUtils.isViewFor(child, UMLPackage.eINSTANCE.getOccurrenceSpecification())) {
				final OccurrenceSpecification occurrenceSpecification = (OccurrenceSpecification)child.getElement();
				final List<Node> associatedTickViews = TickUtils.getAssociatedTickViews(child);
				map.put(occurrenceSpecification, associatedTickViews);
			}
		}
		return map;
	}

	/**
	 * Compute the map of OccurrenceSpecifications to corresponding tick names, for the ticks found in the given
	 * Lifeline's time ruler.
	 */
	private static Map<OccurrenceSpecification, String> computeLifelineTicksAssociations(final View lifelineView) {
		// there should be a single tick corresponding to an OccurrenceSpecification in this lifeline time ruler
		// hence this map from OccurrenceSpecification to a tick name
		final Map<OccurrenceSpecification, String> map = new HashMap<OccurrenceSpecification, String>();
		final View timeRulerCompartment = ViewUtils.findFirstChildViewWithId(lifelineView, FreeTimeRulerCompartmentEditPart.VISUAL_ID);
		@SuppressWarnings("unchecked")
		final EList<View> children = timeRulerCompartment.getChildren();
		for(final View tickView : children) {
			final Node associatedOccurrenceView = TickUtils.getAssociatedOccurrenceView(tickView);
			final OccurrenceSpecification occurrenceSpecification = (OccurrenceSpecification)associatedOccurrenceView.getElement();
			final String description = getTickLabelDescription(tickView);
			map.put(occurrenceSpecification, description);
		}
		return map;
	}

	protected static void setTickLabelDescription(final Node tickNode, final String tickName) {
		final View labelView = ViewUtils.findFirstChildViewWithId(tickNode, TickNameEditPart.VISUAL_ID);
		if(labelView != null) {
			@SuppressWarnings("unchecked")
			final EList<Style> styles = labelView.getStyles();
			for(final Object style : styles) {
				if(style instanceof DescriptionStyle) {
					final DescriptionStyle descriptionStyle = (DescriptionStyle)style;
					descriptionStyle.setDescription(tickName);
				}
			}
		}
	}

	private static String getTickLabelDescription(final View tickView) {
		final View labelView = ViewUtils.findFirstChildViewWithId(tickView, TickNameEditPart.VISUAL_ID);
		if(labelView != null) {
			@SuppressWarnings("unchecked")
			final EList<Style> styles = labelView.getStyles();
			for(final Object style : styles) {
				if(style instanceof DescriptionStyle) {
					final DescriptionStyle descriptionStyle = (DescriptionStyle)style;
					return descriptionStyle.getDescription();
				}
			}
		}
		return ""; //$NON-NLS-1$
	}

	/** Re-associates Interaction time ruler ticks to their new OccurrenceSpecification Views. */
	private ICommand getTicksAssociationCommand(final ICommand createCommand, final Map<OccurrenceSpecification, List<Node>> ticksAssociations) {
		return new AbstractTransactionalCommand(getEditingDomain(), Messages.SwitchLifelineCommand_ReAssociateTicks, null, null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				final View lifelineView = (View)createCommand.getCommandResult().getReturnValue();
				if(lifelineView == null) {
					return CommandResult.newErrorCommandResult("Parent Lifeline not found"); //$NON-NLS-1$
				}
				final View timelineCompartmentView = ViewUtils.findChildTimelineCompartmentView(lifelineView);
				@SuppressWarnings("unchecked")
				final EList<View> children = timelineCompartmentView.getChildren();
				for(final View child : children) {
					if(ViewUtils.isViewFor(child, UMLPackage.eINSTANCE.getOccurrenceSpecification())) {
						final OccurrenceSpecification occurrenceSpecification = (OccurrenceSpecification)child.getElement();
						final List<Node> tickNodes = ticksAssociations.get(occurrenceSpecification);
						if(tickNodes != null) {
							for(final Node tickNode : tickNodes) {
								TickUtils.associateTickNodeToOccurrenceNode(tickNode, (Node)child, true);
							}
						}
					}
				}
				return CommandResult.newOKCommandResult();
			}
		};
	}

	/** Re-creates Lifeline time ruler ticks, and associate them to their new OccurrenceSpecification Views. */
	private ICommand getLifelineTicksCreationCommand(final ICommand createCommand, final Map<OccurrenceSpecification, String> lifelineTicksAssociations) {
		return new AbstractTransactionalCommand(getEditingDomain(), Messages.SwitchLifelineCommand_ReAssociateTicks, null, null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				final View lifelineView = (View)createCommand.getCommandResult().getReturnValue();
				if(lifelineView == null) {
					return CommandResult.newErrorCommandResult("Parent Lifeline not found"); //$NON-NLS-1$
				}
				final View timeRulerCompartment = ViewUtils.findFirstChildViewWithId(lifelineView, FreeTimeRulerCompartmentEditPart.VISUAL_ID);
				final View timelineCompartmentView = ViewUtils.findChildTimelineCompartmentView(lifelineView);

				final UMLViewProvider umlViewProvider = new UMLViewProvider();
				for(final Entry<OccurrenceSpecification, String> entry : lifelineTicksAssociations.entrySet()) {
					final OccurrenceSpecification occurrenceSpecification = entry.getKey();
					final Node occurrenceView = findOccurrenceView(occurrenceSpecification, timelineCompartmentView);
					final String tickName = entry.getValue();
					final Node tickNode = umlViewProvider.createNode_26(null, timeRulerCompartment, ViewUtil.APPEND, true, UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
					setTickLabelDescription(tickNode, tickName);
					TickUtils.associateTickNodeToOccurrenceNode(tickNode, occurrenceView, false);
				}
				return CommandResult.newOKCommandResult();
			}
		};
	}

	/** Find the View corresponding to the given OccurrenceSpecification in the given timeline compartment View */
	protected static Node findOccurrenceView(final OccurrenceSpecification occurrenceSpecification, final View timelineCompartmentView) {
		@SuppressWarnings("unchecked")
		final EList<View> children = timelineCompartmentView.getChildren();
		for(final View child : children) {
			if(child.getElement() == occurrenceSpecification) {
				return (Node)child;
			}
		}
		return null;
	}

	/**
	 * Unnamed state invariants cause issues because they have no attached StateDefinition, so we set a name and update
	 * the StateDefinitions.
	 */
	private ICommand getNameUnnamedStateInvariants(final Lifeline lifeline) {
		return new AbstractTransactionalCommand(getEditingDomain(), Messages.SwitchLifelineCommand_NameUnnamedStateInvariants, null, null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				final EList<InteractionFragment> coveredBys = lifeline.getCoveredBys();
				boolean containsUnnamedStateInvariants = false;
				for(final InteractionFragment interactionFragment : coveredBys) {
					if(interactionFragment instanceof StateInvariant) {
						final StateInvariant stateInvariant = (StateInvariant)interactionFragment;
						if(StateInvariantUtils.getInnerStateInvariantName(stateInvariant) == null) {
							containsUnnamedStateInvariants = true;
							StateInvariantUtils.setInnerStateInvariantName(stateInvariant, Messages.SwitchLifelineCommand_unnamed);
						}
					}
				}
				if(containsUnnamedStateInvariants) {
					StateDefinitionUtils.updateStateDefinitionNamesForCompactLifeline(lifeline);
				}
				return CommandResult.newOKCommandResult();
			}
		};
	}

	private static void addDestroyViewsAndEdgesRecursivelyCommand(final CompoundCommand cc, final View view) {
		@SuppressWarnings("unchecked")
		final EList<View> children = view.getChildren();
		for(final View childView : children) {
			addDestroyViewsAndEdgesRecursivelyCommand(cc, childView);
		}
		@SuppressWarnings("unchecked")
		final EList<Edge> sourceEdges = view.getSourceEdges();
		@SuppressWarnings("unchecked")
		final EList<Edge> targetEdges = view.getTargetEdges();
		for(final Edge edge : sourceEdges) {
			cc.add(new ICommandProxy(new DestroyElementCommand(new DestroyElementRequest(edge, false))));
		}
		for(final Edge edge : targetEdges) {
			cc.add(new ICommandProxy(new DestroyElementCommand(new DestroyElementRequest(edge, false))));
		}
		cc.add(new ICommandProxy(new DestroyElementCommand(new DestroyElementRequest(view, false))));

	}

	private ICommand getMessagesCreationCommand(final ICommand createCommand, final EditPartViewer viewer) {
		return new AbstractTransactionalCommand(getEditingDomain(), Messages.SwitchLifelineCommand_createMessages, null, null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				final View lifelineView = (View)createCommand.getCommandResult().getReturnValue();
				if(lifelineView == null) {
					return CommandResult.newErrorCommandResult("Parent Lifeline not found"); //$NON-NLS-1$
				}
				final Lifeline lifeline = (Lifeline)lifelineView.getElement();

				// find Messages linked to fragments in the Lifeline
				final EReference[] references = new EReference[]{ UMLPackage.eINSTANCE.getMessage_ReceiveEvent(), UMLPackage.eINSTANCE.getMessage_SendEvent() };
				final Class<?>[] expectedClasses = new Class<?>[]{ Message.class };
				final EList<InteractionFragment> coveredBys = lifeline.getCoveredBys();
				final Set<EObject> referencingElements = new HashSet<EObject>();
				for(final InteractionFragment interactionFragment : coveredBys) {
					referencingElements.addAll(Utils.findReferencingElements(interactionFragment, references, expectedClasses));
				}
				// drop the Messages
				for(final EObject referencingElement : referencingElements) {
					final Message referencingMessage = (Message)referencingElement;
					executeCommand(DropUtils.getDropMessageCommand(referencingMessage, lifelineView, viewer));
				}
				return CommandResult.newOKCommandResult();
			}
		};
	}

	private ICommand getLinkedElementsCreationCommand(final ICommand createCommand, final EditPartViewer viewer) {
		return new AbstractTransactionalCommand(getEditingDomain(), Messages.SwitchLifelineCommand_CreateLinkedElements, null, null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				final View lifelineView = (View)createCommand.getCommandResult().getReturnValue();
				if(lifelineView == null) {
					return CommandResult.newErrorCommandResult("Parent Lifeline not found"); //$NON-NLS-1$
				}

				// find time elements and general orderings linked to fragments in the Lifeline
				final EReference[] references = new EReference[]{ UMLPackage.eINSTANCE.getGeneralOrdering_Before(), UMLPackage.eINSTANCE.getGeneralOrdering_After(), UMLPackage.eINSTANCE.getDurationObservation_Event(), UMLPackage.eINSTANCE.getTimeObservation_Event(), UMLPackage.eINSTANCE.getConstraint_ConstrainedElement() };
				final Class<?>[] expectedClasses = new Class<?>[]{ GeneralOrdering.class, TimeObservation.class, DurationObservation.class, TimeConstraint.class, DurationConstraint.class };

				final Lifeline lifeline = (Lifeline)lifelineView.getElement();
				final EList<InteractionFragment> coveredBys = lifeline.getCoveredBys();
				final Set<EObject> referencingElements = new HashSet<EObject>();
				for(final InteractionFragment interactionFragment : coveredBys) {
					referencingElements.addAll(Utils.findReferencingElements(interactionFragment, references, expectedClasses));
				}

				// drop the elements
				for(final EObject eObject : referencingElements) {
					if(eObject instanceof TimeObservation) {
						final TimeObservation timeObservation = (TimeObservation)eObject;
						executeCommand(DropUtils.getDropTimeObservationCommand(timeObservation, lifelineView, viewer));
					} else if(eObject instanceof TimeConstraint) {
						final TimeConstraint timeConstraint = (TimeConstraint)eObject;
						executeCommand(DropUtils.getDropTimeConstraintCommand(timeConstraint, lifelineView, viewer));
					} else if(eObject instanceof DurationObservation) {
						final DurationObservation durationObservation = (DurationObservation)eObject;
						executeCommand(DropUtils.getDropDurationObservationCommand(durationObservation, lifelineView, viewer));
					} else if(eObject instanceof DurationConstraint) {
						final DurationConstraint durationConstraint = (DurationConstraint)eObject;
						executeCommand(DropUtils.getDropDurationConstraintCommand(durationConstraint, lifelineView, viewer));
					} else if(eObject instanceof GeneralOrdering) {
						final GeneralOrdering generalOrdering = (GeneralOrdering)eObject;
						executeCommand(DropUtils.getDropGeneralOrderingCommand(generalOrdering, lifelineView, viewer));
					}
				}
				return CommandResult.newOKCommandResult();
			}
		};
	}

	private ICommand getStateDefinitionCreationForFullLifelineCommand(final Lifeline lifeline, final ICommand createCommand) {

		return new AbstractTransactionalCommand(getEditingDomain(), Messages.SwitchLifelineCommand_createStateDefinitions, null, null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {

				final View lifelineView = (View)createCommand.getCommandResult().getReturnValue();
				if(lifelineView == null) {
					return CommandResult.newErrorCommandResult("Parent Lifeline not found"); //$NON-NLS-1$
				}
				final View stateDefinitionCompartmentView = ViewUtils.findStateDefinitionCompartmentView(lifelineView);
				final List<String> stateDefinitionIds = StateDefinitionUtils.getStateDefinitionIds(lifeline);
				for(final String stateDefinitionId : stateDefinitionIds) {
					final String stateDefinitionName = StateDefinitionUtils.getStateDefinitionName(stateDefinitionId, lifeline);

					// create the View for the state definition
					final UMLViewProvider umlViewProvider = new UMLViewProvider();
					final Node stateDefinitionView = umlViewProvider.createNode_9(null, stateDefinitionCompartmentView, -1, true, PreferencesHint.USE_DEFAULTS);
					// restore the same id
					StateDefinitionUtils.setStateDefinitionViewID(stateDefinitionView, stateDefinitionId);
					// set the name on the View
					StateDefinitionUtils.setStateDefinitionName(stateDefinitionView, stateDefinitionName);
				}

				return CommandResult.newOKCommandResult();
			}
		};
	}

	private ICommand getFreeTimeRulerCreationCommand(final ICommand createCommand, final boolean timeRulerVisible) {
		return new AbstractTransactionalCommand(getEditingDomain(), Messages.SwitchLifelineCommand_CreateTimeRuler, null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				final View lifelineView = (View)createCommand.getCommandResult().getReturnValue();
				if(lifelineView == null) {
					return CommandResult.newErrorCommandResult("Parent Lifeline not found"); //$NON-NLS-1$
				}
				TimeRulerUtils.createFreeTimeRuler(lifelineView);
				final View timeRulerCompartmentView = ViewUtils.findTimeRulerCompartmentView(lifelineView);
				// restore the same visibility as before the switch
				timeRulerCompartmentView.setVisible(timeRulerVisible);
				return CommandResult.newOKCommandResult();
			}
		};
	}

	private ICommand getFragmentsCreationForCompactLifelineCommand(final Lifeline lifeline, final ICommand createCommand) {

		return new AbstractTransactionalCommand(getEditingDomain(), Messages.SwitchLifelineCommand_createLifelineFragments, null, null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {

				final View lifelineView = (View)createCommand.getCommandResult().getReturnValue();
				if(lifelineView == null) {
					return CommandResult.newErrorCommandResult("Parent Lifeline not found"); //$NON-NLS-1$
				}
				final UMLViewProvider umlViewProvider = new UMLViewProvider();
				final View stateInvariantCompartmentView = ViewUtils.findCompactTimelineCompartmentView(lifelineView);
				String previousStateInvariantName = ""; //$NON-NLS-1$
				int indexInCompartment = 0;
				int x = CustomCompactLifelineCompartmentEditPart.FIRST_STATE_OFFSET;
				for(final InteractionFragment fragment : lifeline.getCoveredBys()) {
					final Location loc = NotationFactory.eINSTANCE.createLocation();
					loc.setX(x);
					loc.setY(0);
					if(fragment instanceof StateInvariant) {
						final StateInvariant stateInvariant = (StateInvariant)fragment;
						final String stateInvariantName = StateInvariantUtils.getInnerStateInvariantName(stateInvariant);
						if(!Utils.safeEquals(stateInvariantName, previousStateInvariantName)) {
							umlViewProvider.createStateInvariant_28(stateInvariant, stateInvariantCompartmentView, indexInCompartment, true, PreferencesHint.USE_DEFAULTS);
							indexInCompartment++;
							x += 60;
						}
						previousStateInvariantName = stateInvariantName;

					} else if(fragment instanceof DestructionOccurrenceSpecification) {
						final DestructionOccurrenceSpecification occurrence = (DestructionOccurrenceSpecification)fragment;
						final Node occurrenceSpecificationView = umlViewProvider.createDestructionOccurrenceSpecification_27(occurrence, stateInvariantCompartmentView, indexInCompartment, true, PreferencesHint.USE_DEFAULTS);
						indexInCompartment++;
						occurrenceSpecificationView.setLayoutConstraint(loc);
						x += 10;

					} else if(fragment instanceof MessageOccurrenceSpecification) {
						final MessageOccurrenceSpecification occurrence = (MessageOccurrenceSpecification)fragment;
						final Node occurrenceSpecificationView = umlViewProvider.createMessageOccurrenceSpecification_13(occurrence, stateInvariantCompartmentView, indexInCompartment, true, PreferencesHint.USE_DEFAULTS);
						indexInCompartment++;
						occurrenceSpecificationView.setLayoutConstraint(loc);
						x += 10;

					} else if(fragment instanceof OccurrenceSpecification) {
						final OccurrenceSpecification occurrence = (OccurrenceSpecification)fragment;
						final Node occurrenceSpecificationView = umlViewProvider.createOccurrenceSpecification_12(occurrence, stateInvariantCompartmentView, indexInCompartment, true, PreferencesHint.USE_DEFAULTS);
						indexInCompartment++;
						occurrenceSpecificationView.setLayoutConstraint(loc);
						x += 10;
					}
				}

				return CommandResult.newOKCommandResult();
			}
		};
	}

	private ICommand getFragmentsCreationForFullLifelineCommand(final Lifeline lifeline, final ICommand createCommand) {

		return new AbstractTransactionalCommand(getEditingDomain(), Messages.SwitchLifelineCommand_createLifelineFragments, null, null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				final View lifelineView = (View)createCommand.getCommandResult().getReturnValue();
				if(lifelineView == null) {
					return CommandResult.newErrorCommandResult("Parent Lifeline not found"); //$NON-NLS-1$
				}
				final View timelineCompartmentView = ViewUtils.findFullLifelineCompartmentView(lifelineView);

				final EList<InteractionFragment> fragments = lifeline.getCoveredBys();
				final UMLViewProvider umlViewProvider = new UMLViewProvider();
				int x = 20;
				boolean firstStateInvariant = true;
				String previousStateInvariantName = ""; //$NON-NLS-1$
				StateInvariant previousStateInvariant = null;
				boolean needStateInvariant = false;
				for(final InteractionFragment fragment : fragments) {
					final Location loc = NotationFactory.eINSTANCE.createLocation();
					loc.setX(x);
					loc.setY(0);

					// we always need a StateInvariant between OccurrenceSpecifications
					// (otherwise we would be leaving a gap in the timeline)
					if(!(fragment instanceof StateInvariant) && needStateInvariant && previousStateInvariant != null) {
						umlViewProvider.createStateInvariant_11(previousStateInvariant, timelineCompartmentView, -1, true, PreferencesHint.USE_DEFAULTS);
					}

					if(fragment instanceof StateInvariant) {
						if(!firstStateInvariant) {
							// add a vertical line
							umlViewProvider.createNode_39(null, timelineCompartmentView, -1, true, PreferencesHint.USE_DEFAULTS);
						}
						final StateInvariant stateInvariant = (StateInvariant)fragment;
						final String stateInvariantName = StateInvariantUtils.getInnerStateInvariantName(stateInvariant);
						if(Utils.safeEquals(stateInvariantName, previousStateInvariantName)) {
							x += 10;
						} else {
							x += 25;
						}
						// create the View for the state invariant
						umlViewProvider.createStateInvariant_11(stateInvariant, timelineCompartmentView, -1, true, PreferencesHint.USE_DEFAULTS);
						firstStateInvariant = false;
						previousStateInvariantName = stateInvariantName;
						previousStateInvariant = stateInvariant;
						needStateInvariant = false;
					} else if(fragment instanceof DestructionOccurrenceSpecification) {
						final DestructionOccurrenceSpecification destructionOccurrenceSpecification = (DestructionOccurrenceSpecification)fragment;
						// create the View for the occurrence specification
						final Node occurrenceSpecificationView = umlViewProvider.createDestructionOccurrenceSpecification_27(destructionOccurrenceSpecification, timelineCompartmentView, -1, true, PreferencesHint.USE_DEFAULTS);
						occurrenceSpecificationView.setLayoutConstraint(loc);
						needStateInvariant = false;
						x += 10;
					} else if(fragment instanceof MessageOccurrenceSpecification) {
						final MessageOccurrenceSpecification occurrenceSpecification = (MessageOccurrenceSpecification)fragment;
						// create the View for the occurrence specification
						final Node occurrenceSpecificationView = umlViewProvider.createMessageOccurrenceSpecification_13(occurrenceSpecification, timelineCompartmentView, -1, true, PreferencesHint.USE_DEFAULTS);
						occurrenceSpecificationView.setLayoutConstraint(loc);
						needStateInvariant = true;
						x += 10;
					} else if(fragment instanceof OccurrenceSpecification) {
						final OccurrenceSpecification occurrenceSpecification = (OccurrenceSpecification)fragment;
						// create the View for the occurrence specification
						final Node occurrenceSpecificationView = umlViewProvider.createOccurrenceSpecification_12(occurrenceSpecification, timelineCompartmentView, -1, true, PreferencesHint.USE_DEFAULTS);
						occurrenceSpecificationView.setLayoutConstraint(loc);
						needStateInvariant = true;
						x += 10;
					}
				}

				// we always need the timeline to end with a StateInvariant
				if(needStateInvariant && previousStateInvariant != null) {
					umlViewProvider.createStateInvariant_11(previousStateInvariant, timelineCompartmentView, -1, true, PreferencesHint.USE_DEFAULTS);
				}

				return CommandResult.newOKCommandResult();
			}
		};
	}

	@Override
	protected Command getCommand() throws ExecutionException {
		final CompoundCommand cmd = new CompoundCommand(Messages.SwitchLifelineCommand_switchLifeline);
		final List<IGraphicalEditPart> selectedElements = getSelectedElements();
		for(final IGraphicalEditPart selectedElement : selectedElements) {
			if(selectedElement instanceof FullLifelineEditPartCN || selectedElement instanceof CompactLifelineEditPartCN) {
				cmd.add(switchLifeline(selectedElement));
			}
		}
		return cmd;
	}

	protected static void executeCommand(final ICommand command) throws ExecutionException {
		if(command.canExecute()) {
			command.execute(new NullProgressMonitor(), null);
		} else {
			Activator.log.warn("Cannot execute command for lifeline switch: " + command.getLabel()); //$NON-NLS-1$
		}
	}
}
