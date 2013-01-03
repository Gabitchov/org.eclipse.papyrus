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
package org.eclipse.papyrus.uml.diagram.timing.custom.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.util.CrossReferencerUtil;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineTimelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimingDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLViewProvider;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.StateInvariant;

/** Utility class for manipulating {@link Lifeline}s */
public final class LifelineUtils {

	public enum LifelineType {
		full, compact
	}

	/** The key for the EAnnotation on a Lifeline that indicates whether the Lifeline is a compact or full lifeline */
	private static final String LIFELINE_ANNOTATION = "org.eclipse.papyrus.uml.diagram.timing.lifeline"; //$NON-NLS-1$
	private static final String LIFELINE_TYPE = "type"; //$NON-NLS-1$

	private LifelineUtils() {
		// utility class
	}

	/**
	 * Get the type of the given lifeline
	 * 
	 * @param lifeline
	 *            the lifeline whose type to get
	 * @return the type
	 */
	public static LifelineType getLifelineType(final Lifeline lifeline) {
		final EAnnotation eAnnotation = lifeline.getEAnnotation(LIFELINE_ANNOTATION);
		if (eAnnotation != null) {
			final String type = eAnnotation.getDetails().get(LIFELINE_TYPE);
			if (type != null) {
				return LifelineType.valueOf(type);
			}
		}
		// a non-annotated Lifeline is full by default
		return LifelineType.full;
	}

	/**
	 * Set the type of the given lifeline (between compact and full) using an annotation. This is needed in order to let
	 * {@link UMLViewProvider} choose the right view depending on this annotation.
	 * 
	 * @param lifeline
	 *            the lifeline whose type to set
	 * @param lifelineType
	 *            the type to set
	 */
	public static void setLifelineType(final Lifeline lifeline, final LifelineType lifelineType) {
		EAnnotation eAnnotation = lifeline.getEAnnotation(LIFELINE_ANNOTATION);
		if (eAnnotation == null) {
			eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(LIFELINE_ANNOTATION);
			lifeline.getEAnnotations().add(eAnnotation);
		}
		eAnnotation.getDetails().put(LIFELINE_TYPE, lifelineType.name());
	}

	/**
	 * Update the names of StateInvariants and OccurrenceSpecifications in the given Lifeline, so that StateInvariants
	 * have a number suffix to distinguish multiple occurrences of the same state, and OccurrenceSpecifications that
	 * indicate a state change have a name that indicates their incoming and outgoing state.
	 * 
	 * @param lifeline
	 *            the Lifeline to update
	 * @param lifelineView
	 *            the Lifeline's view, containing the StateDefinitions (ignored for a Compact lifeline)
	 */
	@SuppressWarnings("boxing")
	public static void updateFragmentNames(final Lifeline lifeline, final View lifelineView) {
		View fullLifelineView = lifelineView;
		if (lifelineView != null && !Integer.toString(FullLifelineEditPartCN.VISUAL_ID).equals(lifelineView.getType())) {
			fullLifelineView = null;
		}
		final Map<String, Integer> stateInvariantCounts = new HashMap<String, Integer>();
		final EList<InteractionFragment> fragments = lifeline.getCoveredBys();
		final Map<StateInvariant, String> stateInvariantNames = new HashMap<StateInvariant, String>();

		// first, handle StateInvariant names
		for (int i = 0; i < fragments.size(); i++) {
			final InteractionFragment interactionFragment = fragments.get(i);
			if (interactionFragment instanceof StateInvariant) {
				final StateInvariant stateInvariant = (StateInvariant) interactionFragment;
				final String stateInvariantId = StateInvariantUtils.getStateInvariantId(stateInvariant);
				final String baseStateInvariantName;
				if (stateInvariantId != null && fullLifelineView != null) {
					// in a full lifeline,
					final View stateDefinitionView = StateDefinitionUtils.getStateDefinitionViewWithId(stateInvariantId, fullLifelineView);
					baseStateInvariantName = StateDefinitionUtils.getStateDefinitionName(stateDefinitionView);
					// update the StateInvariant name based on the corresponding StateDefinition name
					StateInvariantUtils.setInnerStateInvariantName(stateInvariant, baseStateInvariantName);
				} else {
					baseStateInvariantName = StateInvariantUtils.getInnerStateInvariantName(stateInvariant);
				}

				if (baseStateInvariantName == null) {
					continue;
				}
				Integer count = stateInvariantCounts.get(baseStateInvariantName);
				if (count == null) {
					count = 0;
				}
				count++;
				// set the StateInvariant's name with its ordering number
				final String stateInvariantName = baseStateInvariantName + "_" + count; //$NON-NLS-1$
				stateInvariant.setName(stateInvariantName);
				stateInvariantCounts.put(baseStateInvariantName, count);
				stateInvariantNames.put(stateInvariant, stateInvariantName);
			}
		}

		// then, handle OccurrenceSpecification names (since they depend on StateInvariant names)
		// start at 1 and end at (size - 1) since we only care about OccurrenceSpecifications that
		// appear between StateInvariants
		final int nFragments = fragments.size();
		for (int i = 0; i < nFragments; i++) {
			final InteractionFragment interactionFragment = fragments.get(i);
			if (interactionFragment instanceof OccurrenceSpecification) {
				final OccurrenceSpecification occurrenceSpecification = (OccurrenceSpecification) interactionFragment;
				// don't override user modifications
				if (!OccurrenceSpecificationUtils.isAutogeneratedName(occurrenceSpecification)) {
					continue;
				}

				if (i == 0) {
					// first fragment is an occurrence => creation
					occurrenceSpecification.setName(Messages.LifelineUtils_CreationOccurrence);
					continue;
				}
				if (i == nFragments - 1) {
					// last fragment is an occurrence => destruction
					occurrenceSpecification.setName(Messages.LifelineUtils_DestructionOccurrence);
					continue;
				}

				final InteractionFragment previous = fragments.get(i - 1);
				final InteractionFragment next = fragments.get(i + 1);
				if (!(previous instanceof StateInvariant) || !(next instanceof StateInvariant)) {
					continue;
				}
				final StateInvariant precedingStateInvariant = (StateInvariant) previous;
				final StateInvariant followingStateInvariant = (StateInvariant) next;
				String previousName = stateInvariantNames.get(precedingStateInvariant);
				String followingName = stateInvariantNames.get(followingStateInvariant);
				if (previousName == null) {
					previousName = "<unnamed>"; //$NON-NLS-1$
				}
				if (followingName == null) {
					followingName = "<unnamed>"; //$NON-NLS-1$
				}
				occurrenceSpecification.setName(previousName + "_To_" + followingName); //$NON-NLS-1$ 
			}
		}
	}

	/**
	 * Returns a command that updates fragment names for Lifeline Views contained by Views referencing the given
	 * element.
	 * 
	 * @param element
	 *            an element contained in a Lifeline
	 * @return a command to update the names of Lifeline fragments
	 */
	public static IUndoableOperation getUpdateFragmentNamesCommand(final EObject element) {
		final Set<View> impactedLifelines = new HashSet<View>();
		final Set<View> crossReferencingViews = CrossReferencerUtil.getCrossReferencingViews(element, TimingDiagramEditPart.MODEL_ID);
		for (final View referencingView : crossReferencingViews) {
			View lifeline = ViewUtils.findSuperViewWithId(referencingView, FullLifelineEditPartCN.VISUAL_ID);
			if (lifeline == null) {
				lifeline = ViewUtils.findSuperViewWithId(referencingView, CompactLifelineEditPartCN.VISUAL_ID);
			}
			if (lifeline != null) {
				impactedLifelines.add(lifeline);
			}
		}
		if (impactedLifelines.isEmpty()) {
			return null;
		}

		final CompositeCommand compositeCommand = new CompositeCommand(Messages.LifelineUtils_UpdateFragmentNames);
		// update fragment names
		for (final View lifelineView : impactedLifelines) {
			Assert.isLegal(lifelineView.getElement() instanceof Lifeline);
			final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(lifelineView);
			compositeCommand.add(new AbstractTransactionalCommand(editingDomain, Messages.LifelineUtils_UpdateLifelineFragmentNames, null) {
				@Override
				protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
					final EObject element = lifelineView.getElement();
					// note: the element becomes the Interaction when the Lifeline is deleted
					if (element instanceof Lifeline) {
						final Lifeline lifeline = (Lifeline) element;
						updateFragmentNames(lifeline, lifelineView);
					}
					return CommandResult.newOKCommandResult();
				}
			});
		}
		return compositeCommand;
	}

	public static boolean isLifelineEditPart(final int visualID) {
		return visualID == FullLifelineEditPartCN.VISUAL_ID || visualID == CompactLifelineEditPartCN.VISUAL_ID;
	}

	public static boolean isLifelineEditPart(final EditPart editPart) {
		return editPart instanceof FullLifelineEditPartCN || editPart instanceof CompactLifelineEditPartCN;
	}

	public static boolean isLifelineView(final View view) {
		final int visualID = UMLVisualIDRegistry.getVisualID(view);
		return isLifelineEditPart(visualID);
	}

	public static EditPart getLifelineCompartment(final EditPart lifelineEditPart) {
		EditPart compartment;
		if (lifelineEditPart instanceof FullLifelineEditPartCN) {
			compartment = EditPartUtils.findFirstChildEditPartWithId(lifelineEditPart, FullLifelineTimelineCompartmentEditPartCN.VISUAL_ID);
		} else {
			compartment = EditPartUtils.findFirstChildEditPartWithId(lifelineEditPart, CompactLifelineCompartmentEditPartCN.VISUAL_ID);
		}
		if (compartment == null) {
			throw new IllegalStateException("No compartment in Lifeline"); //$NON-NLS-1$
		}
		return compartment;
	}
}
