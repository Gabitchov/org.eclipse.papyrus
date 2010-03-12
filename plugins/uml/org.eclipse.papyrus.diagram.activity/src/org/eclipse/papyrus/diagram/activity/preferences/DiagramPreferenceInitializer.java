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
package org.eclipse.papyrus.diagram.activity.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();

		InteractionConstraintPreferencePage.initDefaults(store);


		SendObjectActionPreferencePage.initDefaults(store);


		SendSignalActionPreferencePage.initDefaults(store);


		CallBehaviorActionPreferencePage.initDefaults(store);


		FlowFinalNodePreferencePage.initDefaults(store);


		DecisionNodePreferencePage.initDefaults(store);


		ActivityFinalNodePreferencePage.initDefaults(store);


		ActivityPreferencePage.initDefaults(store);


		ForkNodePreferencePage.initDefaults(store);


		ValuePinPreferencePage.initDefaults(store);


		CallOperationActionPreferencePage.initDefaults(store);


		ActionInputPinPreferencePage.initDefaults(store);


		IntervalConstraintPreferencePage.initDefaults(store);


		OpaqueActionPreferencePage.initDefaults(store);


		InitialNodePreferencePage.initDefaults(store);


		DurationConstraintPreferencePage.initDefaults(store);


		OutputPinPreferencePage.initDefaults(store);


		MergeNodePreferencePage.initDefaults(store);


		ConstraintPreferencePage.initDefaults(store);


		InputPinPreferencePage.initDefaults(store);


		ActivityParameterNodePreferencePage.initDefaults(store);


		TimeConstraintPreferencePage.initDefaults(store);


		JoinNodePreferencePage.initDefaults(store);


		ParameterPreferencePage.initDefaults(store);




		ObjectFlowPreferencePage.initDefaults(store);



		ControlFlowPreferencePage.initDefaults(store);


	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
