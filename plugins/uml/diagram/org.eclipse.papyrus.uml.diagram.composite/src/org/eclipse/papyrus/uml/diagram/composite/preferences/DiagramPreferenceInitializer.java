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
package org.eclipse.papyrus.uml.diagram.composite.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLDiagramEditorPlugin;

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
		DataTypePreferencePage.initDefaults(store);
		InformationItemPreferencePage.initDefaults(store);
		PropertyPreferencePage.initDefaults(store);
		InstanceValuePreferencePage.initDefaults(store);
		OpaqueExpressionPreferencePage.initDefaults(store);
		SignalPreferencePage.initDefaults(store);
		CommentPreferencePage.initDefaults(store);
		PortPreferencePage.initDefaults(store);
		ActivityPreferencePage.initDefaults(store);
		NodePreferencePage.initDefaults(store);
		ClassPreferencePage.initDefaults(store);
		LiteralStringPreferencePage.initDefaults(store);
		FunctionBehaviorPreferencePage.initDefaults(store);
		IntervalPreferencePage.initDefaults(store);
		UseCasePreferencePage.initDefaults(store);
		ProtocolStateMachinePreferencePage.initDefaults(store);
		ConstraintPreferencePage.initDefaults(store);
		TimeIntervalPreferencePage.initDefaults(store);
		OpaqueBehaviorPreferencePage.initDefaults(store);
		PrimitiveTypePreferencePage.initDefaults(store);
		IntervalConstraintPreferencePage.initDefaults(store);
		ExpressionPreferencePage.initDefaults(store);
		TimeEventPreferencePage.initDefaults(store);
		ChangeEventPreferencePage.initDefaults(store);
		DeploymentSpecificationPreferencePage.initDefaults(store);
		ReceptionPreferencePage.initDefaults(store);
		SignalEventPreferencePage.initDefaults(store);
		OperationPreferencePage.initDefaults(store);
		TimeConstraintPreferencePage.initDefaults(store);
		ActorPreferencePage.initDefaults(store);
		ComponentPreferencePage.initDefaults(store);
		LiteralBooleanPreferencePage.initDefaults(store);
		InteractionPreferencePage.initDefaults(store);
		LiteralIntegerPreferencePage.initDefaults(store);
		CollaborationUsePreferencePage.initDefaults(store);
		LiteralNullPreferencePage.initDefaults(store);
		DurationConstraintPreferencePage.initDefaults(store);
		DurationObservationPreferencePage.initDefaults(store);
		InterfacePreferencePage.initDefaults(store);
		ArtifactPreferencePage.initDefaults(store);
		StateMachinePreferencePage.initDefaults(store);
		CollaborationPreferencePage.initDefaults(store);
		StringExpressionPreferencePage.initDefaults(store);
		TimeObservationPreferencePage.initDefaults(store);
		AnyReceiveEventPreferencePage.initDefaults(store);
		DevicePreferencePage.initDefaults(store);
		CallEventPreferencePage.initDefaults(store);
		EnumerationLiteralPreferencePage.initDefaults(store);
		InteractionConstraintPreferencePage.initDefaults(store);
		DurationPreferencePage.initDefaults(store);
		ParameterPreferencePage.initDefaults(store);
		DurationIntervalPreferencePage.initDefaults(store);
		LiteralUnlimitedNaturalPreferencePage.initDefaults(store);
		EnumerationPreferencePage.initDefaults(store);
		CollaborationRolePreferencePage.initDefaults(store);
		TimeExpressionPreferencePage.initDefaults(store);
		ConstraintConstrainedElementPreferencePage.initDefaults(store);
		AbstractionPreferencePage.initDefaults(store);
		DurationObservationEventPreferencePage.initDefaults(store);
		InformationFlowPreferencePage.initDefaults(store);
		GeneralizationPreferencePage.initDefaults(store);
		ConnectorPreferencePage.initDefaults(store);
		ManifestationPreferencePage.initDefaults(store);
		TimeObservationEventPreferencePage.initDefaults(store);
		DependencyPreferencePage.initDefaults(store);
		RealizationPreferencePage.initDefaults(store);
		UsagePreferencePage.initDefaults(store);
		InterfaceRealizationPreferencePage.initDefaults(store);
		ComponentRealizationPreferencePage.initDefaults(store);
		SubstitutionPreferencePage.initDefaults(store);
		CommentAnnotatedElementPreferencePage.initDefaults(store);
		RoleBindingPreferencePage.initDefaults(store);
		DeploymentPreferencePage.initDefaults(store);
	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
