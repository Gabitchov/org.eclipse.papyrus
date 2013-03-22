/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * Add the diagram preference page to the initialization
	 * 
	 * @generated NOT (update at each gmf change) diagram preference page
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();

		TimeObservationPreferencePage.initDefaults(store);

		CommentPreferencePage.initDefaults(store);

		StateInvariantPreferencePage.initDefaults(store);

		CombinedFragmentPreferencePage.initDefaults(store);

		ConstraintPreferencePage.initDefaults(store);

		ActionExecutionSpecificationPreferencePage.initDefaults(store);

		InteractionOperandPreferencePage.initDefaults(store);

		DestructionEventPreferencePage.initDefaults(store);

		InteractionPreferencePage.initDefaults(store);

		DurationConstraintPreferencePage.initDefaults(store);

		InteractionUsePreferencePage.initDefaults(store);

		ContinuationPreferencePage.initDefaults(store);

		ConsiderIgnoreFragmentPreferencePage.initDefaults(store);

		DurationObservationPreferencePage.initDefaults(store);

		TimeConstraintPreferencePage.initDefaults(store);

		LifelinePreferencePage.initDefaults(store);

		BehaviorExecutionSpecificationPreferencePage.initDefaults(store);

		MessagePreferencePage.initDefaults(store);

		GeneralOrderingPreferencePage.initDefaults(store);

		// diagram preference page
		DiagramGeneralPreferencePage.initDefaults(store);
		
		DestructionOccurrenceSpecificationPreferencePage.initDefaults(store);

	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
