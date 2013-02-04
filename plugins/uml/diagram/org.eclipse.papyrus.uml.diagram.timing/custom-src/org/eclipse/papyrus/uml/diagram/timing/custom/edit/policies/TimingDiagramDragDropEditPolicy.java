/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.policies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.ValidateInteractionCommand;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts.CustomCompactLifelineCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.timing.custom.helper.TimingDiagramLinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.DropUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.InteractionUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.LifelineUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.LifelineUtils.LifelineType;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.MessageUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateDefinitionUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateInvariantUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.Utils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.ViewUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DurationConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DurationObservationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.GeneralOrderingEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionCompartmentEditPartTN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionEditPartTN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageAsyncEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageCreateEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageDeleteEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageFoundEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageLostEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageReplyEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageSyncEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimeConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLViewProvider;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeObservation;

public class TimingDiagramDragDropEditPolicy extends CommonDiagramDragDropEditPolicy {

	/** Elements for which we want to specialize the drop */
	@SuppressWarnings("boxing")
	private static final Integer[] SPECIFIC_DROP_ELEMENT_IDS = { InteractionEditPartTN.VISUAL_ID, FullLifelineEditPartCN.VISUAL_ID, CompactLifelineEditPartCN.VISUAL_ID, MessageSyncEditPart.VISUAL_ID, MessageAsyncEditPart.VISUAL_ID, MessageReplyEditPart.VISUAL_ID, MessageCreateEditPart.VISUAL_ID, MessageDeleteEditPart.VISUAL_ID, MessageFoundEditPart.VISUAL_ID, MessageLostEditPart.VISUAL_ID, TimeObservationEditPart.VISUAL_ID, TimeConstraintEditPart.VISUAL_ID, DurationObservationEditPartCN.VISUAL_ID, DurationConstraintEditPartCN.VISUAL_ID, GeneralOrderingEditPart.VISUAL_ID, GateEditPart.VISUAL_ID };

	public TimingDiagramDragDropEditPolicy() {
		super(TimingDiagramLinkMappingHelper.getInstance());
	}

	/** override the drop command */
	@Override
	protected Command getSpecificDropCommand(final DropObjectsRequest dropRequest, final Element semanticElement, final int nodeVISUALID, final int linkVISUALID) {
		switch(nodeVISUALID) {
		case InteractionEditPartTN.VISUAL_ID:
			return new ICommandProxy(dropMainElement(dropRequest, semanticElement, nodeVISUALID));
		case FullLifelineEditPartCN.VISUAL_ID:
		case CompactLifelineEditPartCN.VISUAL_ID:
			return new ICommandProxy(dropLifeline(dropRequest, semanticElement, nodeVISUALID));
		default:
		}

		if(getHost().getModel() instanceof View) {
			final View hostView = (View)getHost().getModel();
			if(MessageUtils.isMessage(linkVISUALID)) {
				if(semanticElement instanceof Message) {
					return new ICommandProxy(DropUtils.getDropMessageCommand((Message)semanticElement, hostView, getViewer()));
				}
			}
			if(nodeVISUALID == TimeObservationEditPart.VISUAL_ID) {
				return new ICommandProxy(DropUtils.getDropTimeObservationCommand((TimeObservation)semanticElement, hostView, getViewer()));
			}
			if(nodeVISUALID == TimeConstraintEditPart.VISUAL_ID) {
				return new ICommandProxy(DropUtils.getDropTimeConstraintCommand((TimeConstraint)semanticElement, hostView, getViewer()));
			}
			if(nodeVISUALID == DurationObservationEditPartCN.VISUAL_ID) {
				return new ICommandProxy(DropUtils.getDropDurationObservationCommand((DurationObservation)semanticElement, hostView, getViewer()));
			}
			if(nodeVISUALID == DurationConstraintEditPartCN.VISUAL_ID) {
				return new ICommandProxy(DropUtils.getDropDurationConstraintCommand((DurationConstraint)semanticElement, hostView, getViewer()));
			}
			if(nodeVISUALID == GeneralOrderingEditPart.VISUAL_ID) {
				return new ICommandProxy(DropUtils.getDropGeneralOrderingCommand((GeneralOrdering)semanticElement, hostView, getViewer()));
			}
			if(nodeVISUALID == GateEditPart.VISUAL_ID) {
				return new ICommandProxy(DropUtils.getDropGateCommand((Gate)semanticElement, hostView, getViewer()));
			}
		}

		return super.getSpecificDropCommand(dropRequest, semanticElement, nodeVISUALID, linkVISUALID);

	}

	private ICommand dropLifeline(final DropObjectsRequest dropRequest, final Element semanticElement, final int nodeVISUALID) {
		if(!(semanticElement instanceof Lifeline)) {
			throw new IllegalArgumentException();
		}
		final Lifeline lifeline = (Lifeline)semanticElement;

		final CompositeCommand cc = new CompositeCommand(Messages.TimingDiagramDragDropEditPolicy_DropLifeline);
		final ICommand dropMainElementCommand = dropMainElement(dropRequest, semanticElement, nodeVISUALID);
		cc.add(dropMainElementCommand);
		final LifelineType lifelineType = LifelineUtils.getLifelineType(lifeline);
		if(lifelineType == LifelineType.full) {
			cc.add(dropStateDefinitions(lifeline, dropMainElementCommand.getCommandResult()));
		}
		cc.add(dropLifelineFragments(lifeline, dropMainElementCommand.getCommandResult(), lifelineType));
		return cc;
	}

	private static ICommand dropStateDefinitions(final Lifeline lifeline, final CommandResult lifelineCreateViewCommandResult) {
		if(lifelineCreateViewCommandResult == null) {
			return UnexecutableCommand.INSTANCE;
		}
		final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(lifeline);
		final Object returnValue = lifelineCreateViewCommandResult.getReturnValue();
		return new AbstractTransactionalCommand(editingDomain, Messages.TimingDiagramDragDropEditPolicy_DropStateDefinitions, null, null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				if(returnValue instanceof IAdaptable) {
					final IAdaptable adaptable = (IAdaptable)returnValue;
					final View lifelineView = (View)adaptable.getAdapter(View.class);
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

				}
				return CommandResult.newOKCommandResult();
			}
		};
	}

	private static ICommand dropLifelineFragments(final Lifeline lifeline, final CommandResult lifelineCreateViewCommandResult, final LifelineType lifelineType) {
		if(lifelineCreateViewCommandResult == null) {
			return UnexecutableCommand.INSTANCE;
		}
		final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(lifeline);
		final Object returnValue = lifelineCreateViewCommandResult.getReturnValue();
		return new AbstractTransactionalCommand(editingDomain, Messages.TimingDiagramDragDropEditPolicy_DropLifelineFragments, null, null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				if(returnValue instanceof IAdaptable) {
					final IAdaptable adaptable = (IAdaptable)returnValue;
					final View lifelineView = (View)adaptable.getAdapter(View.class);
					if(lifelineView == null) {
						return CommandResult.newErrorCommandResult("Parent Lifeline not found"); //$NON-NLS-1$
					}

					final View compartmentView = (lifelineType == LifelineType.full ? ViewUtils.findFullLifelineCompartmentView(lifelineView) : ViewUtils.findCompactTimelineCompartmentView(lifelineView));

					final EList<InteractionFragment> fragments = lifeline.getCoveredBys();
					final UMLViewProvider umlViewProvider = new UMLViewProvider();
					int x = lifelineType == LifelineType.full ? 20 : CustomCompactLifelineCompartmentEditPart.FIRST_STATE_OFFSET;
					boolean firstStateInvariant = true;
					String previousStateInvariantName = ""; //$NON-NLS-1$
					for(final InteractionFragment fragment : fragments) {
						if(fragment instanceof StateInvariant) {
							if(!firstStateInvariant && lifelineType == LifelineType.full) {
								// add a vertical line
								umlViewProvider.createNode_39(null, compartmentView, -1, true, PreferencesHint.USE_DEFAULTS);
							}
							final StateInvariant stateInvariant = (StateInvariant)fragment;
							final String stateInvariantName = StateInvariantUtils.getInnerStateInvariantName(stateInvariant);

							if(lifelineType == LifelineType.full) {
								if(Utils.safeEquals(stateInvariantName, previousStateInvariantName)) {
									x += 10;
								} else {
									x += 25;
								}
							} else {
								x += 60;
							}

							// create the View for the state invariant
							if(lifelineType == LifelineType.full) {
								umlViewProvider.createStateInvariant_11(stateInvariant, compartmentView, -1, true, PreferencesHint.USE_DEFAULTS);
							} else if(lifelineType == LifelineType.compact) {
								umlViewProvider.createStateInvariant_28(stateInvariant, compartmentView, -1, true, PreferencesHint.USE_DEFAULTS);
							}
							firstStateInvariant = false;
							previousStateInvariantName = stateInvariantName;
						} else if(fragment instanceof DestructionOccurrenceSpecification) {
							final DestructionOccurrenceSpecification destructionOccurrenceSpecification = (DestructionOccurrenceSpecification)fragment;
							// create the View for the occurrence specification
							final Node occurrenceSpecificationView = umlViewProvider.createDestructionOccurrenceSpecification_27(destructionOccurrenceSpecification, compartmentView, -1, true, PreferencesHint.USE_DEFAULTS);

							final Location loc = NotationFactory.eINSTANCE.createLocation();
							loc.setX(x);
							loc.setY(0);
							occurrenceSpecificationView.setLayoutConstraint(loc);
							x += 10;
						} else if(fragment instanceof MessageOccurrenceSpecification) {
							final MessageOccurrenceSpecification occurrenceSpecification = (MessageOccurrenceSpecification)fragment;
							// create the View for the occurrence specification
							final Node occurrenceSpecificationView = umlViewProvider.createMessageOccurrenceSpecification_13(occurrenceSpecification, compartmentView, -1, true, PreferencesHint.USE_DEFAULTS);

							final Location loc = NotationFactory.eINSTANCE.createLocation();
							loc.setX(x);
							loc.setY(0);
							occurrenceSpecificationView.setLayoutConstraint(loc);
							x += 10;
						} else if(fragment instanceof OccurrenceSpecification) {
							final OccurrenceSpecification occurrenceSpecification = (OccurrenceSpecification)fragment;
							// create the View for the occurrence specification
							final Node occurrenceSpecificationView = umlViewProvider.createOccurrenceSpecification_12(occurrenceSpecification, compartmentView, -1, true, PreferencesHint.USE_DEFAULTS);

							final Location loc = NotationFactory.eINSTANCE.createLocation();
							loc.setX(x);
							loc.setY(0);
							occurrenceSpecificationView.setLayoutConstraint(loc);
							x += 10;
						}

					}
				}

				return CommandResult.newOKCommandResult();
			}
		};
	}

	private ICommand dropMainElement(final DropObjectsRequest dropRequest, final Element semanticElement, final int nodeVISUALID) {
		if(canBeDropped(semanticElement)) {
			final IHintedType type = ((IHintedType)getUMLElementType(nodeVISUALID));
			String semanticHint = null;
			if(type != null) {
				semanticHint = type.getSemanticHint();
			}
			return getDefaultDropNodeCommand(getHost(), semanticHint, dropRequest.getLocation(), semanticElement, dropRequest);
		}
		return UnexecutableCommand.INSTANCE;
	}

	private boolean canBeDropped(final Element semanticElement) {
		final GraphicalEditPart graphicalParentEditPart = (GraphicalEditPart)getHost();
		final EObject graphicalParentObject = graphicalParentEditPart.resolveSemanticElement();
		return (graphicalParentObject instanceof org.eclipse.uml2.uml.Package && semanticElement instanceof Interaction) || (graphicalParentObject instanceof Interaction && semanticElement instanceof Lifeline);
	}

	/** @return the set of element ids for which we want to specialize the drop */
	@Override
	protected Set<Integer> getDroppableElementVisualId() {
		return new HashSet<Integer>(Arrays.asList(SPECIFIC_DROP_ELEMENT_IDS));
	}

	@Override
	public IElementType getUMLElementType(final int elementID) {
		return UMLElementTypes.getElementType(elementID);
	}

	@Override
	public int getNodeVisualID(final View containerView, final EObject domainElement) {
		if(domainElement instanceof Gate && (String.valueOf(InteractionEditPartTN.VISUAL_ID).equals(containerView.getType()) || String.valueOf(InteractionCompartmentEditPartTN.VISUAL_ID).equals(containerView.getType()))) {
			// allow dropping a Gate directly on an Interaction or Interaction compartment
			return GateEditPart.VISUAL_ID;
		}
		return UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
	}

	@Override
	public int getLinkWithClassVisualID(final EObject domainElement) {
		return UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement);
	}

	@Override
	protected Command getDropCommand(final ChangeBoundsRequest request) {
		return getDropObjectsCommand(castToDropObjectsRequest(request));
	}

	/** Overridden to add validation */
	@Override
	public Command getDropObjectsCommand(final DropObjectsRequest dropRequest) {

		final CompoundCommand cc = new CompoundCommand(Messages.TimingDiagramDragDropEditPolicy_Drop);

		final List<Interaction> updatedInteractionsCache = new ArrayList<Interaction>();
		final List<?> droppedObjects = dropRequest.getObjects();

		for(final Object droppedObject : droppedObjects) {
			if(droppedObject instanceof EObject) {
				final EObject droppedEObject = (EObject)droppedObject;
				final Interaction interaction = InteractionUtils.getContainingInteraction(droppedEObject);
				if(interaction != null) {
					if(!updatedInteractionsCache.contains(interaction)) {
						final ValidateInteractionCommand validateCommand = new ValidateInteractionCommand(getEditingDomain(), interaction, true);
						cc.add(new ICommandProxy(validateCommand));
						updatedInteractionsCache.add(interaction);
					}
				}
			}
		}

		cc.add(super.getDropObjectsCommand(dropRequest));
		return cc;
	}
}
