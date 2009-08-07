/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.composite.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();

		ExecutionEnvironmentPreferencePage.initDefaults(store);

		OperationPreferencePage.initDefaults(store);

		TimeConstraintPreferencePage.initDefaults(store);

		DataTypePreferencePage.initDefaults(store);

		InformationItemPreferencePage.initDefaults(store);

		PropertyPreferencePage.initDefaults(store);

		SendSignalEventPreferencePage.initDefaults(store);

		ExecutionEventPreferencePage.initDefaults(store);

		ActorPreferencePage.initDefaults(store);

		ComponentPreferencePage.initDefaults(store);

		LiteralBooleanPreferencePage.initDefaults(store);

		InteractionPreferencePage.initDefaults(store);

		LiteralIntegerPreferencePage.initDefaults(store);

		OpaqueExpressionPreferencePage.initDefaults(store);

		InstanceValuePreferencePage.initDefaults(store);

		SignalPreferencePage.initDefaults(store);

		CollaborationUsePreferencePage.initDefaults(store);

		CommentPreferencePage.initDefaults(store);

		LiteralNullPreferencePage.initDefaults(store);

		DurationConstraintPreferencePage.initDefaults(store);

		DestructionEventPreferencePage.initDefaults(store);

		DurationObservationPreferencePage.initDefaults(store);

		InterfacePreferencePage.initDefaults(store);

		PortPreferencePage.initDefaults(store);

		ActivityPreferencePage.initDefaults(store);

		ArtifactPreferencePage.initDefaults(store);

		StateMachinePreferencePage.initDefaults(store);

		NodePreferencePage.initDefaults(store);

		ClassPreferencePage.initDefaults(store);

		CollaborationPreferencePage.initDefaults(store);

		LiteralStringPreferencePage.initDefaults(store);

		StringExpressionPreferencePage.initDefaults(store);

		FunctionBehaviorPreferencePage.initDefaults(store);

		TimeObservationPreferencePage.initDefaults(store);

		IntervalPreferencePage.initDefaults(store);

		DevicePreferencePage.initDefaults(store);

		UseCasePreferencePage.initDefaults(store);

		AnyReceiveEventPreferencePage.initDefaults(store);

		SendOperationEventPreferencePage.initDefaults(store);

		ProtocolStateMachinePreferencePage.initDefaults(store);

		ConstraintPreferencePage.initDefaults(store);

		CallEventPreferencePage.initDefaults(store);

		EnumerationLiteralPreferencePage.initDefaults(store);

		OpaqueBehaviorPreferencePage.initDefaults(store);

		TimeIntervalPreferencePage.initDefaults(store);

		InteractionConstraintPreferencePage.initDefaults(store);

		PrimitiveTypePreferencePage.initDefaults(store);

		IntervalConstraintPreferencePage.initDefaults(store);

		DurationPreferencePage.initDefaults(store);

		ExpressionPreferencePage.initDefaults(store);

		TimeEventPreferencePage.initDefaults(store);

		LiteralUnlimitedNaturalPreferencePage.initDefaults(store);

		DurationIntervalPreferencePage.initDefaults(store);

		CreationEventPreferencePage.initDefaults(store);

		ChangeEventPreferencePage.initDefaults(store);

		EnumerationPreferencePage.initDefaults(store);

		DeploymentSpecificationPreferencePage.initDefaults(store);

		ReceptionPreferencePage.initDefaults(store);

		SignalEventPreferencePage.initDefaults(store);

		TimeExpressionPreferencePage.initDefaults(store);

		AbstractionPreferencePage.initDefaults(store);

		InformationFlowPreferencePage.initDefaults(store);

		GeneralizationPreferencePage.initDefaults(store);

		ConnectorPreferencePage.initDefaults(store);

		ManifestationPreferencePage.initDefaults(store);

		DependencyPreferencePage.initDefaults(store);

		RealizationPreferencePage.initDefaults(store);

		UsagePreferencePage.initDefaults(store);

		InterfaceRealizationPreferencePage.initDefaults(store);

		ComponentRealizationPreferencePage.initDefaults(store);

		SubstitutionPreferencePage.initDefaults(store);

		DeploymentPreferencePage.initDefaults(store);

	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
