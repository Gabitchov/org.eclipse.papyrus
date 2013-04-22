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
	 * @generated
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		InteractionPreferencePage.initDefaults(store);
		TimeConstraintPreferencePage.initDefaults(store);
		TimeObservationPreferencePage.initDefaults(store);
		CommentPreferencePage.initDefaults(store);
		ConstraintPreferencePage.initDefaults(store);
		LifelinePreferencePage.initDefaults(store);
		InteractionUsePreferencePage.initDefaults(store);
		CombinedFragmentPreferencePage.initDefaults(store);
		DurationConstraintPreferencePage.initDefaults(store);
		BehaviorExecutionSpecificationPreferencePage.initDefaults(store);
		DurationObservationPreferencePage.initDefaults(store);
		ActionExecutionSpecificationPreferencePage.initDefaults(store);
		InteractionOperandPreferencePage.initDefaults(store);
		ContinuationPreferencePage.initDefaults(store);
		StateInvariantPreferencePage.initDefaults(store);
		DestructionOccurrenceSpecificationPreferencePage.initDefaults(store);
		ConsiderIgnoreFragmentPreferencePage.initDefaults(store);
		MessagePreferencePage.initDefaults(store);
		GeneralOrderingPreferencePage.initDefaults(store);
	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
