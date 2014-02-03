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
package org.eclipse.papyrus.uml.diagram.sequence.preferences;

import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomDiagramPreferenceInitializer extends DiagramPreferenceInitializer {

	/**
	 * Add the diagram preference page to the initialization
	 * 
	 * @Override (update at each gmf change) diagram preference page
	 */
	@Override
	public void initializeDefaultPreferences() {
		super.initializeDefaultPreferences();
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

		//Custom preference pages.
		CustomCombinedFragmentPreferencePage.initDefaults(store);
		CustomConsiderIgnoreFragmentPreferencePage.initDefaults(store);
		CustomDestructionOccurrenceSpecificationPreferencePage.initDefaults(store);
		CustomInteractionOperandPreferencePage.initDefaults(store);
	}
}
