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

		ValueSpecificationActionPreferencePage.initDefaults(store);

		CommentPreferencePage.initDefaults(store);

		SendObjectActionPreferencePage.initDefaults(store);

		SequenceNodePreferencePage.initDefaults(store);

		SendSignalActionPreferencePage.initDefaults(store);

		DataStoreNodePreferencePage.initDefaults(store);

		LoopNodePreferencePage.initDefaults(store);

		CallBehaviorActionPreferencePage.initDefaults(store);

		FlowFinalNodePreferencePage.initDefaults(store);

		AcceptEventActionPreferencePage.initDefaults(store);

		ConditionalNodePreferencePage.initDefaults(store);

		DecisionNodePreferencePage.initDefaults(store);

		ActivityFinalNodePreferencePage.initDefaults(store);

		ActivityPreferencePage.initDefaults(store);

		ShapeNamedElementPreferencePage.initDefaults(store);

		ActivityPartitionPreferencePage.initDefaults(store);

		ForkNodePreferencePage.initDefaults(store);

		ValuePinPreferencePage.initDefaults(store);

		CallOperationActionPreferencePage.initDefaults(store);

		ActionInputPinPreferencePage.initDefaults(store);

		StructuredActivityNodePreferencePage.initDefaults(store);

		IntervalConstraintPreferencePage.initDefaults(store);

		ReadSelfActionPreferencePage.initDefaults(store);

		OpaqueActionPreferencePage.initDefaults(store);

		InitialNodePreferencePage.initDefaults(store);

		DurationConstraintPreferencePage.initDefaults(store);

		ExpansionRegionPreferencePage.initDefaults(store);

		OutputPinPreferencePage.initDefaults(store);

		MergeNodePreferencePage.initDefaults(store);

		ConstraintPreferencePage.initDefaults(store);

		InputPinPreferencePage.initDefaults(store);

		ExpansionNodePreferencePage.initDefaults(store);

		ActivityParameterNodePreferencePage.initDefaults(store);

		TimeConstraintPreferencePage.initDefaults(store);

		InterruptibleActivityRegionPreferencePage.initDefaults(store);

		JoinNodePreferencePage.initDefaults(store);

		ParameterPreferencePage.initDefaults(store);

		ObjectFlowPreferencePage.initDefaults(store);

		ControlFlowPreferencePage.initDefaults(store);

		ExceptionHandlerPreferencePage.initDefaults(store);

	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
