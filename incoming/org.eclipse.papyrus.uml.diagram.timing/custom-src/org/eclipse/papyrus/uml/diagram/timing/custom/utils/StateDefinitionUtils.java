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
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineStateDefinitionCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.StateDefinitionEditPart;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.StateInvariant;

/**
 * Utility class for the creation and retrieval of StateDefinition names through EAnnotations on Lifeline and
 * StateDefinition View
 */
public final class StateDefinitionUtils {

	/** The key for the EAnnotation on a Lifeline in which the StateDefinition (id,name) detail map is contained */
	private static final String LIFELINE_STATE_DEFINITIONS_KEY = "org.eclipse.papyrus.uml.diagram.timing.LifelineStateDefinitions"; //$NON-NLS-1$
	/**
	 * The key for the EAnnotation on a StateDefinition View in which the id (STATE_DEFINITION_VIEW_ID_KEY) and name
	 * (STATE_DEFINITION_VIEW_NAME_KEY) are defined
	 */
	private static final String STATE_DEFINITION_VIEW_KEY = "org.eclipse.papyrus.uml.diagram.timing.StateDefinitionView"; //$NON-NLS-1$
	/** The key for the name of a StateDefinition in the details map of a StateDefinition View's annotations */
	private static final String STATE_DEFINITION_VIEW_ID_KEY = "org.eclipse.papyrus.uml.diagram.timing.StateDefinitionViewID"; //$NON-NLS-1$
	/** The key for the id of a StateDefinition in the details map of a StateDefinition View's annotations */
	private static final String STATE_DEFINITION_VIEW_NAME_KEY = "org.eclipse.papyrus.uml.diagram.timing.StateDefinitionViewName"; //$NON-NLS-1$

	private StateDefinitionUtils() {
		// utility class
	}

	public static boolean hasStateDefinitionEAnnotation(final Lifeline lifeline) {
		final EAnnotation eAnnotation = lifeline.getEAnnotation(LIFELINE_STATE_DEFINITIONS_KEY);
		if (eAnnotation == null) {
			return false;
		}
		return !eAnnotation.getDetails().isEmpty();
	}

	/** Get or create an EAnnotation in the given Lifeline, to hold the map of state definition IDs and names */
	public static EAnnotation getOrCreateStateDefinitionsEAnnotation(final Lifeline lifeline) {
		EAnnotation eAnnotation = lifeline.getEAnnotation(LIFELINE_STATE_DEFINITIONS_KEY);
		if (eAnnotation == null) {
			eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(LIFELINE_STATE_DEFINITIONS_KEY);
			lifeline.getEAnnotations().add(eAnnotation);
		}
		return eAnnotation;
	}

	/**
	 * Get the EAnnotation that contains a Details map (stateDefinitionId,stateDefinitionName) on the given Lifeline, or
	 * <code>null</code> if none was created
	 */
	public static EAnnotation getStateDefinitionsEAnnotation(final Lifeline lifeline) {
		return lifeline.getEAnnotation(LIFELINE_STATE_DEFINITIONS_KEY);
	}

	public static String getStateDefinitionViewID(final View stateDefinitionView) {
		final EAnnotation eAnnotation = stateDefinitionView.getEAnnotation(STATE_DEFINITION_VIEW_KEY);
		if (eAnnotation != null) {
			return eAnnotation.getDetails().get(STATE_DEFINITION_VIEW_ID_KEY);
		}
		return null;
	}

	private static EAnnotation getOrCreateStateDefinitionViewAnnotation(final View stateDefinitionView) {
		EAnnotation eAnnotation = stateDefinitionView.getEAnnotation(STATE_DEFINITION_VIEW_KEY);
		if (eAnnotation == null) {
			eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(STATE_DEFINITION_VIEW_KEY);
			stateDefinitionView.getEAnnotations().add(eAnnotation);
		}
		return eAnnotation;
	}

	public static void setStateDefinitionViewID(final View stateDefinitionView, final String id) {
		final EAnnotation eAnnotation = getOrCreateStateDefinitionViewAnnotation(stateDefinitionView);
		eAnnotation.getDetails().put(STATE_DEFINITION_VIEW_ID_KEY, id);
	}

	private static void setStateDefinitionViewName(final View stateDefinitionView, final String name) {
		final EAnnotation eAnnotation = getOrCreateStateDefinitionViewAnnotation(stateDefinitionView);
		eAnnotation.getDetails().put(STATE_DEFINITION_VIEW_NAME_KEY, name);
	}

	public static void setStateDefinitionName(final View stateDefinitionView, final String newName) {
		checkStateDefinitionView(stateDefinitionView);
		String stateDefinitionViewID = getStateDefinitionViewID(stateDefinitionView);
		if (stateDefinitionViewID == null) {
			// generate a unique ID that we will use to link the StateDefinition Figure to its name in the
			// EAnnotation: we have a map (ID,name) in the Lifeline's EAnnotation and an entry (View,ID) in the
			// StateDefinition Figure's EAnnotation
			stateDefinitionViewID = EcoreUtil.generateUUID();
			setStateDefinitionViewID(stateDefinitionView, stateDefinitionViewID);
		}
		final Lifeline lifeline = StateDefinitionUtils.getParentLifeline(stateDefinitionView);
		final EAnnotation lifelineEAnnotation = getOrCreateStateDefinitionsEAnnotation(lifeline);
		lifelineEAnnotation.getDetails().put(stateDefinitionViewID, newName);
		// setting the name on the View too lets the Label refresh, since the refresh is only listening on the DI model
		setStateDefinitionViewName(stateDefinitionView, newName);
	}

	public static void removeStateDefinitionEAnnotationFromLifeline(final String id, final Lifeline lifeline) {
		final EAnnotation lifelineEAnnotation = getStateDefinitionsEAnnotation(lifeline);
		if (lifelineEAnnotation != null) {
			lifelineEAnnotation.getDetails().removeKey(id);
		}
	}

	public static String getStateDefinitionName(final View stateDefinitionView) {
		checkStateDefinitionView(stateDefinitionView);
		final String stateDefinitionViewID = getStateDefinitionViewID(stateDefinitionView);
		if (stateDefinitionViewID == null) {
			return null;
		}
		final Lifeline lifeline = StateDefinitionUtils.getParentLifeline(stateDefinitionView);
		return getStateDefinitionName(stateDefinitionViewID, lifeline);
	}

	public static String getStateDefinitionName(final String stateDefinitionViewID, final Lifeline lifeline) {
		if (stateDefinitionViewID == null || lifeline == null) {
			return null;
		}
		final EAnnotation lifelineEAnnotation = getStateDefinitionsEAnnotation(lifeline);
		if (lifelineEAnnotation == null) {
			return null;
		}
		return lifelineEAnnotation.getDetails().get(stateDefinitionViewID);
	}

	public static View getParentLifelineView(final View view) {
		final String id = Integer.toString(FullLifelineEditPartCN.VISUAL_ID);
		View parent = view;
		while (parent != null) {
			if (id.equals(parent.getType())) {
				return parent;
			}
			parent = (View) parent.eContainer();
		}
		throw new IllegalStateException("Parent Lifeline not found"); //$NON-NLS-1$
	}

	public static Lifeline getParentLifeline(final View view) {
		final View parentLifelineView = getParentLifelineView(view);
		if (parentLifelineView != null) {
			return (Lifeline) parentLifelineView.getElement();
		}
		return null;
	}

	/** Set a new name on the given StateDefinition view */
	public static void initNewStateDefinitionName(final View stateDefinitionView) {
		checkStateDefinitionView(stateDefinitionView);
		final View stateDefinitionsCompartment = ViewUtils.findSuperViewWithId(stateDefinitionView, FullLifelineStateDefinitionCompartmentEditPartCN.VISUAL_ID);
		final List<View> allStateDefinitionViews = ViewUtils.findSubViewsWithId(stateDefinitionsCompartment, StateDefinitionEditPart.VISUAL_ID);
		final Set<String> existingNames = new HashSet<String>();
		for (final View aStateDefinitionView : allStateDefinitionViews) {
			existingNames.add(getStateDefinitionName(aStateDefinitionView));
		}
		setStateDefinitionName(stateDefinitionView, findNewStateName(existingNames));
	}

	private static String findNewStateName(final Set<String> existingNames) {
		String newName = ""; //$NON-NLS-1$
		final String prefix = Messages.StateDefinitionUtils_State;
		int suffix = 1;
		while (true) {
			newName = prefix + suffix;
			if (!existingNames.contains(newName)) {
				break;
			}
			suffix++;
		}
		return newName;
	}

	public static View getStateDefinitionViewWithId(final String id, final View lifelineView) {
		checkLifelineView(lifelineView);
		final List<View> stateDefinitionViews = ViewUtils.findSubViewsWithId(lifelineView, StateDefinitionEditPart.VISUAL_ID);
		for (final View stateDefinitionView : stateDefinitionViews) {
			if (id.equals(getStateDefinitionViewID(stateDefinitionView))) {
				return stateDefinitionView;
			}
		}
		return null;
	}

	public static View getStateDefinitionViewWithName(final String name, final View lifelineView) {
		checkLifelineView(lifelineView);
		final List<View> stateDefinitionViews = ViewUtils.findSubViewsWithId(lifelineView, StateDefinitionEditPart.VISUAL_ID);
		for (final View stateDefinitionView : stateDefinitionViews) {
			if (name.equals(getStateDefinitionName(stateDefinitionView))) {
				return stateDefinitionView;
			}
		}
		return null;
	}

	public static List<String> getStateDefinitionIds(final Lifeline lifeline) {
		final EAnnotation eAnnotation = getStateDefinitionsEAnnotation(lifeline);
		if (eAnnotation != null) {
			final EMap<String, String> details = eAnnotation.getDetails();
			final List<String> result = new ArrayList<String>();
			// note: using the iterator preserves the order
			final Iterator<Entry<String, String>> iterator = details.iterator();
			while (iterator.hasNext()) {
				final Entry<String, String> entry = iterator.next();
				result.add(entry.getKey());
			}
			return result;
		}
		return Collections.emptyList();
	}

	private static void checkStateDefinitionView(final View stateDefinitionView) {
		if (!Integer.toString(StateDefinitionEditPart.VISUAL_ID).equals(stateDefinitionView.getType())) {
			throw new IllegalArgumentException(
					"The parameter must be a StateDefinition View (id = " + StateDefinitionEditPart.VISUAL_ID + "). The id was " + stateDefinitionView.getType()); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	private static void checkLifelineView(final View lifelineView) {
		if (!Integer.toString(FullLifelineEditPartCN.VISUAL_ID).equals(lifelineView.getType())) {
			throw new IllegalArgumentException(
					"The parameter must be a Lifeline View (id = " + FullLifelineEditPartCN.VISUAL_ID + "). The id was " + lifelineView.getType()); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/** Find the StateDefinition closest to the given y-coordinate and return it. */
	public static StateDefinitionEditPart findStateDefinitionClosestToOrdinate(final FullLifelineEditPartCN lifelineEditPart, final int ordinate) {
		@SuppressWarnings("unchecked")
		final List<GraphicalEditPart> editParts = (List<GraphicalEditPart>) EditPartUtils.findChildEditPartsWithId(lifelineEditPart,
				StateDefinitionEditPart.VISUAL_ID);
		return (StateDefinitionEditPart) EditPartUtils.findEditPartClosestToOrdinate(ordinate, editParts);
	}

	/**
	 * Updates the StateDefinitions of the given Lifeline so that they match the names of the fragments covered by this
	 * Lifeline. This should only be called on a compact lifeline. The purpose of this operation is to make sure that
	 * the UML model is the same for a compact lifeline as a full lifeline, so that the two types of lifelines can be
	 * switched easily at any time.
	 * 
	 * @param lifeline
	 *            the lifeline to update
	 */
	public static void updateStateDefinitionNamesForCompactLifeline(final Lifeline lifeline) {
		final EList<InteractionFragment> coveredBys = lifeline.getCoveredBys();
		final Map<String, String> nameIdMap = new LinkedHashMap<String, String>();
		// first, get all the unique state invariant names and generate the associated ids
		for (final InteractionFragment interactionFragment : coveredBys) {
			if (interactionFragment instanceof StateInvariant) {
				final StateInvariant stateInvariant = (StateInvariant) interactionFragment;
				final String name = StateInvariantUtils.getInnerStateInvariantName(stateInvariant);
				nameIdMap.put(name, EcoreUtil.generateUUID());
			}
		}
		// then, (re-)create the StateDefinitions
		final EAnnotation stateDefinitionsEAnnotation = getOrCreateStateDefinitionsEAnnotation(lifeline);
		stateDefinitionsEAnnotation.getDetails().clear();
		for (final Entry<String, String> entry : nameIdMap.entrySet()) {
			final String name = entry.getKey();
			final String id = entry.getValue();
			stateDefinitionsEAnnotation.getDetails().put(id, name);
		}
		// then, set the IDs on the state invariants
		for (final InteractionFragment interactionFragment : coveredBys) {
			if (interactionFragment instanceof StateInvariant) {
				final StateInvariant stateInvariant = (StateInvariant) interactionFragment;
				final String name = StateInvariantUtils.getInnerStateInvariantName(stateInvariant);
				final String id = nameIdMap.get(name);
				StateInvariantUtils.setStateInvariantId(stateInvariant, id);
			}
		}
	}
}
