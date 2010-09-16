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

		ShapeNamedElementPreferencePage.initDefaults(store);

		TimeConstraintPreferencePage.initDefaults(store);

		ExpansionNodePreferencePage.initDefaults(store);

		ValuePinPreferencePage.initDefaults(store);

		LoopNodePreferencePage.initDefaults(store);

		MergeNodePreferencePage.initDefaults(store);

		ActionInputPinPreferencePage.initDefaults(store);

		CallOperationActionPreferencePage.initDefaults(store);

		CallBehaviorActionPreferencePage.initDefaults(store);

		ActivityPartitionPreferencePage.initDefaults(store);

		InputPinPreferencePage.initDefaults(store);

		SendObjectActionPreferencePage.initDefaults(store);

		InitialNodePreferencePage.initDefaults(store);

		OutputPinPreferencePage.initDefaults(store);

		DurationConstraintPreferencePage.initDefaults(store);

		StructuredActivityNodePreferencePage.initDefaults(store);

		SequenceNodePreferencePage.initDefaults(store);

		ActivityParameterNodePreferencePage.initDefaults(store);

		ActivityPreferencePage.initDefaults(store);

		OpaqueActionPreferencePage.initDefaults(store);

		DecisionNodePreferencePage.initDefaults(store);

		ValueSpecificationActionPreferencePage.initDefaults(store);

		JoinNodePreferencePage.initDefaults(store);

		ConstraintPreferencePage.initDefaults(store);

		SendSignalActionPreferencePage.initDefaults(store);

		FlowFinalNodePreferencePage.initDefaults(store);

		InterruptibleActivityRegionPreferencePage.initDefaults(store);

		InteractionConstraintPreferencePage.initDefaults(store);

		IntervalConstraintPreferencePage.initDefaults(store);

		DataStoreNodePreferencePage.initDefaults(store);

		ActivityFinalNodePreferencePage.initDefaults(store);

		ParameterPreferencePage.initDefaults(store);

		ExpansionRegionPreferencePage.initDefaults(store);

		AcceptEventActionPreferencePage.initDefaults(store);

		ForkNodePreferencePage.initDefaults(store);

		ConditionalNodePreferencePage.initDefaults(store);

		ControlFlowPreferencePage.initDefaults(store);

		ExceptionHandlerPreferencePage.initDefaults(store);

		ObjectFlowPreferencePage.initDefaults(store);

	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
