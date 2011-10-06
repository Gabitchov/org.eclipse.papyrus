/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
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

		PropertyPreferencePage.initDefaults(store);

		InteractionConstraintPreferencePage.initDefaults(store);

		CommentPreferencePage.initDefaults(store);

		ClassPreferencePage.initDefaults(store);

		ActorPreferencePage.initDefaults(store);

		TimeEventPreferencePage.initDefaults(store);

		StateMachinePreferencePage.initDefaults(store);

		ProtocolStateMachinePreferencePage.initDefaults(store);

		OpaqueBehaviorPreferencePage.initDefaults(store);

		TimeIntervalPreferencePage.initDefaults(store);

		TimeExpressionPreferencePage.initDefaults(store);

		LiteralStringPreferencePage.initDefaults(store);

		ExecutionEnvironmentPreferencePage.initDefaults(store);

		LiteralNullPreferencePage.initDefaults(store);

		ArtifactPreferencePage.initDefaults(store);

		DurationConstraintPreferencePage.initDefaults(store);

		SignalPreferencePage.initDefaults(store);

		AnyReceiveEventPreferencePage.initDefaults(store);

		ReceptionPreferencePage.initDefaults(store);

		CollaborationUsePreferencePage.initDefaults(store);

		LiteralUnlimitedNaturalPreferencePage.initDefaults(store);

		StringExpressionPreferencePage.initDefaults(store);

		LiteralBooleanPreferencePage.initDefaults(store);

		CollaborationRolePreferencePage.initDefaults(store);

		SendSignalEventPreferencePage.initDefaults(store);

		OpaqueExpressionPreferencePage.initDefaults(store);

		ParameterPreferencePage.initDefaults(store);

		InformationItemPreferencePage.initDefaults(store);

		DataTypePreferencePage.initDefaults(store);

		EnumerationLiteralPreferencePage.initDefaults(store);

		ChangeEventPreferencePage.initDefaults(store);

		InstanceValuePreferencePage.initDefaults(store);

		NodePreferencePage.initDefaults(store);

		LiteralIntegerPreferencePage.initDefaults(store);

		InterfacePreferencePage.initDefaults(store);

		SignalEventPreferencePage.initDefaults(store);

		PrimitiveTypePreferencePage.initDefaults(store);

		OperationPreferencePage.initDefaults(store);

		ActivityPreferencePage.initDefaults(store);

		InteractionPreferencePage.initDefaults(store);

		IntervalPreferencePage.initDefaults(store);

		DurationPreferencePage.initDefaults(store);

		IntervalConstraintPreferencePage.initDefaults(store);

		TimeObservationPreferencePage.initDefaults(store);

		CollaborationPreferencePage.initDefaults(store);

		CallEventPreferencePage.initDefaults(store);

		ComponentPreferencePage.initDefaults(store);

		PortPreferencePage.initDefaults(store);

		FunctionBehaviorPreferencePage.initDefaults(store);

		DeploymentSpecificationPreferencePage.initDefaults(store);

		DestructionEventPreferencePage.initDefaults(store);

		UseCasePreferencePage.initDefaults(store);

		DevicePreferencePage.initDefaults(store);

		DurationObservationPreferencePage.initDefaults(store);

		CreationEventPreferencePage.initDefaults(store);

		SendOperationEventPreferencePage.initDefaults(store);

		EnumerationPreferencePage.initDefaults(store);

		ConstraintPreferencePage.initDefaults(store);

		DurationIntervalPreferencePage.initDefaults(store);

		ExpressionPreferencePage.initDefaults(store);

		TimeConstraintPreferencePage.initDefaults(store);

		ExecutionEventPreferencePage.initDefaults(store);

		DurationObservationEventPreferencePage.initDefaults(store);

		DependencyPreferencePage.initDefaults(store);

		GeneralizationPreferencePage.initDefaults(store);

		ComponentRealizationPreferencePage.initDefaults(store);

		ConnectorPreferencePage.initDefaults(store);

		ConstraintConstrainedElementPreferencePage.initDefaults(store);

		UsagePreferencePage.initDefaults(store);

		ManifestationPreferencePage.initDefaults(store);

		TimeObservationEventPreferencePage.initDefaults(store);

		SubstitutionPreferencePage.initDefaults(store);

		AbstractionPreferencePage.initDefaults(store);

		DeploymentPreferencePage.initDefaults(store);

		CommentAnnotatedElementPreferencePage.initDefaults(store);

		RoleBindingPreferencePage.initDefaults(store);

		RealizationPreferencePage.initDefaults(store);

		InterfaceRealizationPreferencePage.initDefaults(store);

		InformationFlowPreferencePage.initDefaults(store);

	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
