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
package org.eclipse.papyrus.diagram.sequence.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * Add the diagram preferece page to the initialization
	 * 
	 * @generated NOT
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();

		InteractionOperandPreferencePage.initDefaults(store);


		InteractionPreferencePage.initDefaults(store);


		ContinuationPreferencePage.initDefaults(store);


		CommentPreferencePage.initDefaults(store);


		ConstraintPreferencePage.initDefaults(store);


		ConsiderIgnoreFragmentPreferencePage.initDefaults(store);


		InteractionUsePreferencePage.initDefaults(store);


		LifelinePreferencePage.initDefaults(store);


		CombinedFragmentPreferencePage.initDefaults(store);


		BehaviorExecutionSpecificationPreferencePage.initDefaults(store);


		ActionExecutionSpecificationPreferencePage.initDefaults(store);




		MessagePreferencePage.initDefaults(store);

		DiagramGeneralPreferencePage.initDefaults(store);


	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
