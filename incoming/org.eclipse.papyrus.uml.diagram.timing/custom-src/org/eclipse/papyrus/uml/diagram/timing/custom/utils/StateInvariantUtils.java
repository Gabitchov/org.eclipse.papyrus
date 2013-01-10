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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.util.CrossReferencerUtil;
import org.eclipse.papyrus.uml.diagram.timing.custom.OperationForbiddenException;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineTimelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionEditPartTN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimingDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLViewProvider;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

public final class StateInvariantUtils {

	private StateInvariantUtils() {
		// utility class
	}

	/** The key for the EAnnotation on a {@link StateInvariant} */
	private static final String STATE_INVARIANT_KEY = "org.eclipse.papyrus.uml.diagram.timing.StateInvariant"; //$NON-NLS-1$

	/** The key for the corresponding StateDefinition, defined in the details map in the EAnnotation on a StateInvariant */
	private static final String STATE_INVARIANT_STATE_DEFINITION_ID_KEY = "org.eclipse.papyrus.uml.diagram.timing.StateInvariantStateDefinitionId"; //$NON-NLS-1$

	/**
	 * Create a StateInvariant and its View.
	 * 
	 * @param stateDefinitionId
	 *        the id of the state definition that the state invariant will be set to
	 * @param lifelineEditPart
	 *        the Lifeline in which the StateInvariant must be added
	 * @param indexInFragments
	 *        index to insert the state invariant in the Interaction's fragments list (-1 to insert at the end)
	 * @param indexInCoveredBys
	 *        index to insert the state invariant in the Lifeline's coveredBys list (-1 to insert at the end)
	 * @param indexInCompartment
	 *        index to insert the state invariant in the Compartment's children list (-1 to insert at the end)
	 * @return the Node that represents the StateInvariant in the GMF model
	 */
	public static Node createStateInvariant(final String stateDefinitionId, final FullLifelineEditPartCN lifelineEditPart, final int indexInFragments, final int indexInCoveredBys, final int indexInCompartment) {
		final View timelineCompartmentView = (View)EditPartUtils.findFirstChildEditPartWithId(lifelineEditPart, FullLifelineTimelineCompartmentEditPartCN.VISUAL_ID).getModel();
		final View lifelineView = (View)lifelineEditPart.getModel();
		final Lifeline lifeline = (Lifeline)lifelineView.getElement();

		// create the StateInvariant
		final StateInvariant newStateInvariant = UMLFactory.eINSTANCE.createStateInvariant();
		final Constraint newConstraint = UMLFactory.eINSTANCE.createConstraint();
		newStateInvariant.setInvariant(newConstraint);
		final OpaqueExpression newOpaqueExpression = UMLFactory.eINSTANCE.createOpaqueExpression();
		final View stateDefinitionView = StateDefinitionUtils.getStateDefinitionViewWithId(stateDefinitionId, lifelineView);
		final String stateDefinitionName = StateDefinitionUtils.getStateDefinitionName(stateDefinitionView);
		newConstraint.setSpecification(newOpaqueExpression);

		if(indexInFragments == -1) {
			lifeline.getInteraction().getFragments().add(newStateInvariant);
		} else {
			lifeline.getInteraction().getFragments().add(indexInFragments, newStateInvariant);
		}
		if(indexInCoveredBys == -1) {
			lifeline.getCoveredBys().add(newStateInvariant);
		} else {
			lifeline.getCoveredBys().add(indexInCoveredBys, newStateInvariant);
		}

		// associate the StateInvariant with the StateDefinition through the same id
		setStateInvariantId(newStateInvariant, stateDefinitionId);
		setInnerStateInvariantName(newStateInvariant, stateDefinitionName);

		// create the View for the new state invariant
		final UMLViewProvider umlViewProvider = new UMLViewProvider();
		final Node stateInvariantNode = umlViewProvider.createStateInvariant_11(newStateInvariant, timelineCompartmentView, indexInCompartment, true, PreferencesHint.USE_DEFAULTS);
		return stateInvariantNode;
	}

	public static Node createCompactStateInvariant(final View lifelineCompartmentView, final int indexInFragments, final int indexInCoveredBys, final int indexInCompartment) {

		final Lifeline lifeline = (Lifeline)lifelineCompartmentView.getElement();

		// create the StateInvariant
		final StateInvariant newStateInvariant = UMLFactory.eINSTANCE.createStateInvariant();
		final Constraint newConstraint = UMLFactory.eINSTANCE.createConstraint();
		newStateInvariant.setInvariant(newConstraint);
		final OpaqueExpression newOpaqueExpression = UMLFactory.eINSTANCE.createOpaqueExpression();

		newConstraint.setSpecification(newOpaqueExpression);

		if(indexInFragments == -1) {
			lifeline.getInteraction().getFragments().add(newStateInvariant);
		} else {
			lifeline.getInteraction().getFragments().add(indexInFragments, newStateInvariant);
		}
		if(indexInCoveredBys == -1) {
			lifeline.getCoveredBys().add(newStateInvariant);
		} else {
			lifeline.getCoveredBys().add(indexInCoveredBys, newStateInvariant);
		}

		// create the View for the new state invariant
		final UMLViewProvider umlViewProvider = new UMLViewProvider();
		final Node stateInvariantNode = umlViewProvider.createStateInvariant_28(newStateInvariant, lifelineCompartmentView, indexInCompartment, true, PreferencesHint.USE_DEFAULTS);
		return stateInvariantNode;
	}

	/**
	 * Set the value of the body in the ValueSpecification (which must be an OpaqueExpression) of the Constraint of this
	 * StateInvariant and the name of the Constraint.
	 * 
	 * @param stateInvariant
	 *        the StateInvariant whose name to update
	 * @param newName
	 *        the new name for the StateInvariant (which is the name of the corresponding StateDefinition in a full
	 *        Lifeline)
	 */
	public static void setInnerStateInvariantName(final StateInvariant stateInvariant, final String newName) {
		final Constraint constraint = stateInvariant.getInvariant();
		Assert.isNotNull(constraint, "The StateInvariant must have a Constraint"); //$NON-NLS-1$
		// set the constraint's name
		constraint.setName("InState_" + newName); //$NON-NLS-1$
		final ValueSpecification specification = constraint.getSpecification();
		Assert.isNotNull(specification, "The Constraint must have a ValueSpecification"); //$NON-NLS-1$
		Assert.isLegal(specification instanceof OpaqueExpression, "The ValueSpecification must be an OpaqueExpression"); //$NON-NLS-1$
		final OpaqueExpression opaqueExpression = (OpaqueExpression)specification;
		// (re-)set the body
		opaqueExpression.getBodies().clear();
		opaqueExpression.getBodies().add(newName);
	}

	/**
	 * Return the value of the body in the ValueSpecification (which must be an OpaqueExpression) of the Constraint of
	 * this StateInvariant.
	 * <p>
	 * In a compact Lifeline, the name is duplicated:
	 * <ul>
	 * <li>the StateInvariant's name
	 * <li>the body in the OpaqueExpression of the Constraint of the StateInvariant
	 * </ul>
	 * In addition to this, in a full Lifeline, the name appears in a third place:
	 * <ul>
	 * <li>the name of the corresponding StateDefinition (defined in the EAnnotation on the Lifeline) which has an id matching the id stored in the
	 * StateInvariant's EAnnotation: this is the canonical name when in a full Lifeline (see {@link StateDefinitionUtils})
	 * </ul>
	 * 
	 * */
	public static String getInnerStateInvariantName(final StateInvariant stateInvariant) {
		final Constraint constraint = stateInvariant.getInvariant();
		if(constraint == null) {
			return null;
		}
		final ValueSpecification specification = constraint.getSpecification();
		if(specification == null || !(specification instanceof OpaqueExpression)) {
			return null;
		}
		final OpaqueExpression opaqueExpression = (OpaqueExpression)specification;
		final EList<String> bodies = opaqueExpression.getBodies();
		if(bodies == null || bodies.size() < 1) {
			return null;
		}
		return bodies.get(0);
	}

	public static void setStateInvariantId(final StateInvariant stateInvariant, final String id) {
		final EAnnotation eAnnotation = getOrCreateStateInvariantEAnnotation(stateInvariant);
		eAnnotation.getDetails().put(STATE_INVARIANT_STATE_DEFINITION_ID_KEY, id);
	}

	public static String getStateInvariantId(final StateInvariant stateInvariant) {
		final EAnnotation eAnnotation = stateInvariant.getEAnnotation(STATE_INVARIANT_KEY);
		if(eAnnotation != null) {
			return eAnnotation.getDetails().get(STATE_INVARIANT_STATE_DEFINITION_ID_KEY);
		}
		return null;
	}

	private static EAnnotation getOrCreateStateInvariantEAnnotation(final StateInvariant stateInvariant) {
		EAnnotation eAnnotation = stateInvariant.getEAnnotation(STATE_INVARIANT_KEY);
		if(eAnnotation == null) {
			eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(STATE_INVARIANT_KEY);
			stateInvariant.getEAnnotations().add(eAnnotation);
		}
		return eAnnotation;
	}

	/** Find and return all the StateInvariants defined in the given Interaction that have the given id. */
	public static List<StateInvariant> findStateInvariantsWithId(final String id, final Interaction interaction) {
		final List<StateInvariant> stateInvariants = new ArrayList<StateInvariant>();
		final EList<InteractionFragment> fragments = interaction.getFragments();
		for(final InteractionFragment interactionFragment : fragments) {
			if(interactionFragment instanceof StateInvariant) {
				final StateInvariant stateInvariant = (StateInvariant)interactionFragment;
				final String stateInvariantId = getStateInvariantId(stateInvariant);
				if(id.equals(stateInvariantId)) {
					stateInvariants.add(stateInvariant);
				}
			}
		}
		return stateInvariants;
	}

	/**
	 * Get all elements to delete when deleting a StateInvariant.
	 * 
	 * @param stateInvariant
	 *        the StateInvariant being deleted
	 * @return the elements (EObjects and Views) that should be deleted together with the StateInvariant
	 * @throws OperationForbiddenException
	 *         if the StateInvariant should not be deleted
	 */
	public static Collection<EObject> getElementsToDelete(final StateInvariant stateInvariant) throws OperationForbiddenException {
		final Set<EObject> elementsToDestroy = new HashSet<EObject>();
		final Set<View> crossReferencingViews = CrossReferencerUtil.getCrossReferencingViews(stateInvariant, TimingDiagramEditPart.MODEL_ID);
		for(final View view : crossReferencingViews) {
			elementsToDestroy.addAll(getElementsToRemove(view, false));
		}
		return elementsToDestroy;
	}

	/**
	 * Get all Views to remove when hiding a StateInvariant (i.e., deleting a StateInvariant's View).
	 * 
	 * @param stateInvariant
	 *        the StateInvariant being hidden
	 * @return the Views that should be hidden together with the given StateInvariant View
	 * @throws OperationForbiddenException
	 *         if the StateInvariant should not be hidden
	 */
	public static Collection<View> getViewsToHide(final View stateInvariantView) throws OperationForbiddenException {

		final Set<View> viewsToHide = new HashSet<View>();
		final Collection<EObject> elementsToRemove = getElementsToRemove(stateInvariantView, true);
		for(final EObject eObject : elementsToRemove) {
			if(eObject instanceof View) {
				viewsToHide.add((View)eObject);
			} else {
				throw new IllegalStateException("Only views should be returned"); //$NON-NLS-1$
			}
		}
		return viewsToHide;
	}

	/**
	 * Get all elements to remove when removing a StateInvariant.
	 * 
	 * @param view
	 *        the StateInvariant View being removed
	 * @param hideOnly
	 *        if <code>true</code>, only return the Views, not the semantic elements
	 * @return the elements (Views and EObjects if <code>hideOnly</code> is <code>false</code>) that should be removed
	 *         together with the StateInvariant
	 * @throws OperationForbiddenException
	 *         if the StateInvariant should not be removed
	 */
	public static Collection<EObject> getElementsToRemove(final View view, final boolean hideOnly) throws OperationForbiddenException {
		final Set<EObject> elementsToRemove = new HashSet<EObject>();
		final boolean fullStateInvariant = view.getType().equals(Constants.fullStateInvariantId);
		final boolean compactStateInvariant = view.getType().equals(Constants.compactStateInvariantId);

		if(fullStateInvariant || compactStateInvariant) {
			// only remove Views under the same Interaction
			final View interactionView = ViewUtils.findSuperViewWithId(view, InteractionEditPartTN.VISUAL_ID);

			final StateInvariant stateInvariant = (StateInvariant)view.getElement();
			elementsToRemove.addAll(getRelatedElementsToRemove(stateInvariant, hideOnly, interactionView));

			final EObject eContainer = view.eContainer();
			if(eContainer instanceof Node) {
				final Node node = (Node)eContainer;
				@SuppressWarnings("unchecked")
				final EList<View> children = node.getChildren();
				int nStateInvariants = 0;
				for(final View childView : children) {
					if(childView.getType().equals(Constants.fullStateInvariantId) || childView.getType().equals(Constants.compactStateInvariantId)) {
						nStateInvariants++;
					}
				}
				if(nStateInvariants <= 1) {
					// don't allow deleting the only StateInvariant (since this renders the diagram unusable)
					throw new OperationForbiddenException();
				}
				if(fullStateInvariant) {
					elementsToRemove.addAll(getElementsToRemoveForFullStateInvariant(view, children, hideOnly, interactionView));
				} else if(compactStateInvariant) {
					elementsToRemove.addAll(getElementsToRemoveForCompactStateInvariant(view, children, hideOnly, interactionView));
				}
			}
		}
		return elementsToRemove;
	}

	public static Collection<? extends EObject> getRelatedElementsToRemove(final EObject stateInvariant, final boolean hideOnly, final View interactionView) {
		Assert.isLegal(stateInvariant instanceof StateInvariant);
		final Set<EObject> elementsToRemove = new HashSet<EObject>();
		elementsToRemove.addAll(TimeElementUtils.getTimeElementsToRemove(stateInvariant, hideOnly, interactionView));
		elementsToRemove.addAll(GeneralOrderingUtils.getReferencingGeneralOrderingsToRemove(stateInvariant, hideOnly, interactionView));
		return elementsToRemove;
	}

	private static Collection<EObject> getElementsToRemoveForFullStateInvariant(final View stateInvariantView, final EList<View> children, final boolean hideOnly, final View interactionView) {
		final Set<EObject> elementsToRemove = new HashSet<EObject>();
		final int childrenSize = children.size();
		final int index = children.indexOf(stateInvariantView);
		if(index == 0) {
			// first StateInvariant: remove the OccurrenceSpecification and VerticalLine AFTER it
			if(index + 1 < childrenSize) {
				final View following = children.get(index + 1);
				if(OccurrenceSpecificationUtils.isOccurrenceSpecificationView(following)) {
					addElementToRemove(following, hideOnly, interactionView, elementsToRemove);
				}
			}
			if(index + 2 < childrenSize) {
				final View following = children.get(index + 2);
				if(following.getType().equals(Constants.verticalLineId)) {
					elementsToRemove.add(following);
				}
			}
		} else {
			// other StateInvariant: remove the VerticalLine and OccurrenceSpecification BEFORE it
			if(index >= 1) {
				final View preceding = children.get(index - 1);
				if(preceding.getType().equals(Constants.verticalLineId)) {
					elementsToRemove.add(preceding);
				}
				// in the case of a creation Message
				if(OccurrenceSpecificationUtils.isOccurrenceSpecificationView(preceding)) {
					addElementToRemove(preceding, hideOnly, interactionView, elementsToRemove);
				}
			}
			if(index >= 2) {
				final View preceding = children.get(index - 2);
				if(OccurrenceSpecificationUtils.isOccurrenceSpecificationView(preceding)) {
					addElementToRemove(preceding, hideOnly, interactionView, elementsToRemove);
				}
			}
		}
		return elementsToRemove;
	}

	private static Collection<EObject> getElementsToRemoveForCompactStateInvariant(final View stateInvariantView, final EList<View> children, final boolean hideOnly, final View interactionView) {
		final Set<EObject> elementsToRemove = new HashSet<EObject>();
		final int index = children.indexOf(stateInvariantView);
		if(index == 0) {
			// first StateInvariant: remove the OccurrenceSpecification AFTER it
			// (and all the OccurrenceSpecifications on top of it)
			for(int i = index + 1; i < children.size(); i++) {
				final View view = children.get(i);
				if(OccurrenceSpecificationUtils.isOccurrenceSpecificationView(view)) {
					addElementToRemove(view, hideOnly, interactionView, elementsToRemove);
				} else {
					break;
				}
			}
		} else {
			// other StateInvariant: remove the OccurrenceSpecification BEFORE it
			if(index >= 1) {
				final View preceding = children.get(index - 1);
				if(OccurrenceSpecificationUtils.isOccurrenceSpecificationView(preceding)) {
					addElementToRemove(preceding, hideOnly, interactionView, elementsToRemove);
				}
			}
			// and all the OccurrenceSpecifications on top of it (until a state change occurrence)
			for(int i = index + 1; i < children.size(); i++) {
				View following = null;
				if(i + 1 < children.size()) {
					following = children.get(i + 1);
				}
				final View view = children.get(i);
				// if this is not a state change occurrence then delete it
				if(OccurrenceSpecificationUtils.isOccurrenceSpecificationView(view) && (following == null || !StateInvariantUtils.isStateInvariantView(following))) {
					addElementToRemove(view, hideOnly, interactionView, elementsToRemove);
				} else {
					break;
				}

			}
		}
		return elementsToRemove;
	}

	private static void addElementToRemove(final View viewToRemove, final boolean hideOnly, final View interactionView, final Set<EObject> elementsToRemove) {
		final EObject element = viewToRemove.getElement();
		elementsToRemove.add(viewToRemove);
		if(!hideOnly) {
			elementsToRemove.add(element);
		}
		if(element instanceof StateInvariant) {
			elementsToRemove.addAll(StateInvariantUtils.getRelatedElementsToRemove(element, hideOnly, interactionView));
		} else if(element instanceof OccurrenceSpecification) {
			elementsToRemove.addAll(OccurrenceSpecificationUtils.getRelatedElementsToRemove(element, hideOnly, interactionView));
		} else {
			throw new UnsupportedOperationException();
		}
	}

	public static boolean isStateInvariantView(final View view) {
		final int visualID = UMLVisualIDRegistry.getVisualID(view);
		return isStateInvariantEditPart(visualID);
	}

	public static boolean isStateInvariantEditPart(final int visualID) {
		return visualID == FullStateInvariantEditPartCN.VISUAL_ID || visualID == CompactStateInvariantEditPartCN.VISUAL_ID;
	}
}
