/*****************************************************************************
 * Copyright (c) 2009-2010 CEA LIST.
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
package org.eclipse.papyrus.diagram.composite.providers;

import org.eclipse.papyrus.diagram.common.helper.NamedElementHelper;
import org.eclipse.papyrus.diagram.composite.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.AnyReceiveEvent;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.ChangeEvent;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.ComponentRealization;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.CreationEvent;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.DeploymentSpecification;
import org.eclipse.uml2.uml.DestructionEvent;
import org.eclipse.uml2.uml.Device;
import org.eclipse.uml2.uml.Duration;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationInterval;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.ExecutionEnvironment;
import org.eclipse.uml2.uml.ExecutionEvent;
import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.FunctionBehavior;
import org.eclipse.uml2.uml.InformationFlow;
import org.eclipse.uml2.uml.InformationItem;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Interval;
import org.eclipse.uml2.uml.IntervalConstraint;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.Node;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ProtocolStateMachine;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.SendOperationEvent;
import org.eclipse.uml2.uml.SendSignalEvent;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.TimeInterval;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.Usage;
import org.eclipse.uml2.uml.UseCase;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public void init_Activity_2060(Activity instance) {
		try {
			Object value_0 = name_Activity_2060(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Interaction_2061(Interaction instance) {
		try {
			Object value_0 = name_Interaction_2061(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ProtocolStateMachine_2062(ProtocolStateMachine instance) {
		try {
			Object value_0 = name_ProtocolStateMachine_2062(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_StateMachine_2063(StateMachine instance) {
		try {
			Object value_0 = name_StateMachine_2063(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_FunctionBehavior_2064(FunctionBehavior instance) {
		try {
			Object value_0 = name_FunctionBehavior_2064(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_OpaqueBehavior_2065(OpaqueBehavior instance) {
		try {
			Object value_0 = name_OpaqueBehavior_2065(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Component_2069(Component instance) {
		try {
			Object value_0 = name_Component_2069(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Device_2070(Device instance) {
		try {
			Object value_0 = name_Device_2070(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ExecutionEnvironment_2071(ExecutionEnvironment instance) {
		try {
			Object value_0 = name_ExecutionEnvironment_2071(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Node_2072(Node instance) {
		try {
			Object value_0 = name_Node_2072(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Class_2073(Class instance) {
		try {
			Object value_0 = name_Class_2073(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Class_2074(Class instance) {
		try {
			Object value_0 = name_Class_2074(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Collaboration_2075(Collaboration instance) {
		try {
			Object value_0 = name_Collaboration_2075(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Interface_2076(Interface instance) {
		try {
			Object value_0 = name_Interface_2076(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_PrimitiveType_2066(PrimitiveType instance) {
		try {
			Object value_0 = name_PrimitiveType_2066(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Enumeration_2067(Enumeration instance) {
		try {
			Object value_0 = name_Enumeration_2067(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DataType_2068(DataType instance) {
		try {
			Object value_0 = name_DataType_2068(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Actor_2077(Actor instance) {
		try {
			Object value_0 = name_Actor_2077(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DeploymentSpecification_2078(DeploymentSpecification instance) {
		try {
			Object value_0 = name_DeploymentSpecification_2078(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Artifact_2079(Artifact instance) {
		try {
			Object value_0 = name_Artifact_2079(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InformationItem_2080(InformationItem instance) {
		try {
			Object value_0 = name_InformationItem_2080(instance);
			instance.setName((String)value_0);
			Object value_1 = isAbstract_InformationItem_2080(instance);
			instance.setIsAbstract(((Boolean)value_1).booleanValue());
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Signal_2081(Signal instance) {
		try {
			Object value_0 = name_Signal_2081(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_UseCase_2082(UseCase instance) {
		try {
			Object value_0 = name_UseCase_2082(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_SignalEvent_2083(SignalEvent instance) {
		try {
			Object value_0 = name_SignalEvent_2083(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_CallEvent_2084(CallEvent instance) {
		try {
			Object value_0 = name_CallEvent_2084(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_AnyReceiveEvent_2085(AnyReceiveEvent instance) {
		try {
			Object value_0 = name_AnyReceiveEvent_2085(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_SendSignalEvent_2086(SendSignalEvent instance) {
		try {
			Object value_0 = name_SendSignalEvent_2086(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_SendOperationEvent_2087(SendOperationEvent instance) {
		try {
			Object value_0 = name_SendOperationEvent_2087(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ChangeEvent_2088(ChangeEvent instance) {
		try {
			Object value_0 = name_ChangeEvent_2088(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_TimeEvent_2089(TimeEvent instance) {
		try {
			Object value_0 = name_TimeEvent_2089(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_CreationEvent_2090(CreationEvent instance) {
		try {
			Object value_0 = name_CreationEvent_2090(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DestructionEvent_2091(DestructionEvent instance) {
		try {
			Object value_0 = name_DestructionEvent_2091(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ExecutionEvent_2092(ExecutionEvent instance) {
		try {
			Object value_0 = name_ExecutionEvent_2092(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DurationObservation_2093(DurationObservation instance) {
		try {
			Object value_0 = name_DurationObservation_2093(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_TimeObservation_2094(TimeObservation instance) {
		try {
			Object value_0 = name_TimeObservation_2094(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_LiteralBoolean_2095(LiteralBoolean instance) {
		try {
			Object value_0 = name_LiteralBoolean_2095(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_LiteralInteger_2096(LiteralInteger instance) {
		try {
			Object value_0 = name_LiteralInteger_2096(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_LiteralNull_2097(LiteralNull instance) {
		try {
			Object value_0 = name_LiteralNull_2097(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_LiteralString_2098(LiteralString instance) {
		try {
			Object value_0 = name_LiteralString_2098(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_LiteralUnlimitedNatural_2099(LiteralUnlimitedNatural instance) {
		try {
			Object value_0 = name_LiteralUnlimitedNatural_2099(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_StringExpression_2100(StringExpression instance) {
		try {
			Object value_0 = name_StringExpression_2100(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_OpaqueExpression_2101(OpaqueExpression instance) {
		try {
			Object value_0 = name_OpaqueExpression_2101(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_TimeExpression_2102(TimeExpression instance) {
		try {
			Object value_0 = name_TimeExpression_2102(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Expression_2103(Expression instance) {
		try {
			Object value_0 = name_Expression_2103(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Duration_2104(Duration instance) {
		try {
			Object value_0 = name_Duration_2104(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_TimeInterval_2105(TimeInterval instance) {
		try {
			Object value_0 = name_TimeInterval_2105(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DurationInterval_2106(DurationInterval instance) {
		try {
			Object value_0 = name_DurationInterval_2106(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Interval_2107(Interval instance) {
		try {
			Object value_0 = name_Interval_2107(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InstanceValue_2108(InstanceValue instance) {
		try {
			Object value_0 = name_InstanceValue_2108(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Comment_2109(Comment instance) {
		try {
			Object value_0 = body_Comment_2109(instance);
			instance.setBody((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DurationConstraint_2110(DurationConstraint instance) {
		try {
			Object value_0 = name_DurationConstraint_2110(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_TimeConstraint_2111(TimeConstraint instance) {
		try {
			Object value_0 = name_TimeConstraint_2111(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_IntervalConstraint_2112(IntervalConstraint instance) {
		try {
			Object value_0 = name_IntervalConstraint_2112(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InteractionConstraint_2113(InteractionConstraint instance) {
		try {
			Object value_0 = name_InteractionConstraint_2113(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Constraint_2114(Constraint instance) {
		try {
			Object value_0 = name_Constraint_2114(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Port_3069(Port instance) {
		try {
			Object value_0 = name_Port_3069(instance);
			instance.setName((String)value_0);
			instance.setAggregation(AggregationKind.COMPOSITE_LITERAL);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Parameter_3088(Parameter instance) {
		try {
			Object value_0 = name_Parameter_3088(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Property_3070(Property instance) {
		try {
			Object value_0 = name_Property_3070(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ConnectableElement_3115(ConnectableElement instance) {
		try {
			Object value_0 = name_ConnectableElement_3115(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_CollaborationUse_3071(CollaborationUse instance) {
		try {
			Object value_0 = name_CollaborationUse_3071(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Activity_3072(Activity instance) {
		try {
			Object value_0 = name_Activity_3072(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Interaction_3073(Interaction instance) {
		try {
			Object value_0 = name_Interaction_3073(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ProtocolStateMachine_3074(ProtocolStateMachine instance) {
		try {
			Object value_0 = name_ProtocolStateMachine_3074(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_StateMachine_3075(StateMachine instance) {
		try {
			Object value_0 = name_StateMachine_3075(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_FunctionBehavior_3076(FunctionBehavior instance) {
		try {
			Object value_0 = name_FunctionBehavior_3076(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_OpaqueBehavior_3077(OpaqueBehavior instance) {
		try {
			Object value_0 = name_OpaqueBehavior_3077(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Component_3081(Component instance) {
		try {
			Object value_0 = name_Component_3081(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Device_3082(Device instance) {
		try {
			Object value_0 = name_Device_3082(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ExecutionEnvironment_3083(ExecutionEnvironment instance) {
		try {
			Object value_0 = name_ExecutionEnvironment_3083(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Node_3084(Node instance) {
		try {
			Object value_0 = name_Node_3084(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Class_3085(Class instance) {
		try {
			Object value_0 = name_Class_3085(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Collaboration_3086(Collaboration instance) {
		try {
			Object value_0 = name_Collaboration_3086(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Interface_3087(Interface instance) {
		try {
			Object value_0 = name_Interface_3087(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_PrimitiveType_3078(PrimitiveType instance) {
		try {
			Object value_0 = name_PrimitiveType_3078(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Enumeration_3079(Enumeration instance) {
		try {
			Object value_0 = name_Enumeration_3079(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DataType_3080(DataType instance) {
		try {
			Object value_0 = name_DataType_3080(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Actor_3091(Actor instance) {
		try {
			Object value_0 = name_Actor_3091(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DeploymentSpecification_3092(DeploymentSpecification instance) {
		try {
			Object value_0 = name_DeploymentSpecification_3092(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Artifact_3093(Artifact instance) {
		try {
			Object value_0 = name_Artifact_3093(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InformationItem_3094(InformationItem instance) {
		try {
			Object value_0 = name_InformationItem_3094(instance);
			instance.setName((String)value_0);
			Object value_1 = isAbstract_InformationItem_3094(instance);
			instance.setIsAbstract(((Boolean)value_1).booleanValue());
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Signal_3095(Signal instance) {
		try {
			Object value_0 = name_Signal_3095(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_UseCase_3096(UseCase instance) {
		try {
			Object value_0 = name_UseCase_3096(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Comment_3097(Comment instance) {
		try {
			Object value_0 = body_Comment_3097(instance);
			instance.setBody((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Property_3101(Property instance) {
		try {
			Object value_0 = name_Property_3101(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Operation_3102(Operation instance) {
		try {
			Object value_0 = name_Operation_3102(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Reception_3100(Reception instance) {
		try {
			Object value_0 = name_Reception_3100(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_EnumerationLiteral_3066(EnumerationLiteral instance) {
		try {
			Object value_0 = name_EnumerationLiteral_3066(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Activity_3103(Activity instance) {
		try {
			Object value_0 = name_Activity_3103(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Interaction_3104(Interaction instance) {
		try {
			Object value_0 = name_Interaction_3104(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ProtocolStateMachine_3105(ProtocolStateMachine instance) {
		try {
			Object value_0 = name_ProtocolStateMachine_3105(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_StateMachine_3106(StateMachine instance) {
		try {
			Object value_0 = name_StateMachine_3106(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_FunctionBehavior_3107(FunctionBehavior instance) {
		try {
			Object value_0 = name_FunctionBehavior_3107(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_OpaqueBehavior_3108(OpaqueBehavior instance) {
		try {
			Object value_0 = name_OpaqueBehavior_3108(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Collaboration_3109(Collaboration instance) {
		try {
			Object value_0 = name_Collaboration_3109(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Interface_3110(Interface instance) {
		try {
			Object value_0 = name_Interface_3110(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Enumeration_3111(Enumeration instance) {
		try {
			Object value_0 = name_Enumeration_3111(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_PrimitiveType_3112(PrimitiveType instance) {
		try {
			Object value_0 = name_PrimitiveType_3112(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DataType_3113(DataType instance) {
		try {
			Object value_0 = name_DataType_3113(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Class_3114(Class instance) {
		try {
			Object value_0 = name_Class_3114(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ComponentRealization_4004(ComponentRealization instance) {
		try {
			Object value_0 = name_ComponentRealization_4004(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InterfaceRealization_4005(InterfaceRealization instance) {
		try {
			Object value_0 = name_InterfaceRealization_4005(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Substitution_4011(Substitution instance) {
		try {
			Object value_0 = name_Substitution_4011(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Realization_4006(Realization instance) {
		try {
			Object value_0 = name_Realization_4006(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Manifestation_4012(Manifestation instance) {
		try {
			Object value_0 = name_Manifestation_4012(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Abstraction_4007(Abstraction instance) {
		try {
			Object value_0 = name_Abstraction_4007(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Usage_4008(Usage instance) {
		try {
			Object value_0 = name_Usage_4008(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Deployment_4009(Deployment instance) {
		try {
			Object value_0 = name_Deployment_4009(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Dependency_4010(Dependency instance) {
		try {
			Object value_0 = name_Dependency_4010(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Connector_4013(Connector instance) {
		try {
			Object value_0 = name_Connector_4013(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InformationFlow_4021(InformationFlow instance) {
		try {
			Object value_0 = name_InformationFlow_4021(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	private String name_Activity_2060(Activity self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Interaction_2061(Interaction self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_ProtocolStateMachine_2062(ProtocolStateMachine self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_StateMachine_2063(StateMachine self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_FunctionBehavior_2064(FunctionBehavior self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_OpaqueBehavior_2065(OpaqueBehavior self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Component_2069(Component self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Device_2070(Device self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_ExecutionEnvironment_2071(ExecutionEnvironment self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Node_2072(Node self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Class_2073(Class self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Class_2074(Class self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Collaboration_2075(Collaboration self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Interface_2076(Interface self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_PrimitiveType_2066(PrimitiveType self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Enumeration_2067(Enumeration self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_DataType_2068(DataType self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Actor_2077(Actor self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_DeploymentSpecification_2078(DeploymentSpecification self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Artifact_2079(Artifact self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_InformationItem_2080(InformationItem self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private Boolean isAbstract_InformationItem_2080(InformationItem self) {
		// InformationItem is Abstract
		return true;
	}

	/**
	 * @generated
	 */
	private String name_Signal_2081(Signal self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_UseCase_2082(UseCase self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_SignalEvent_2083(SignalEvent self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_CallEvent_2084(CallEvent self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_AnyReceiveEvent_2085(AnyReceiveEvent self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_SendSignalEvent_2086(SendSignalEvent self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_SendOperationEvent_2087(SendOperationEvent self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_ChangeEvent_2088(ChangeEvent self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_TimeEvent_2089(TimeEvent self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_CreationEvent_2090(CreationEvent self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_DestructionEvent_2091(DestructionEvent self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_ExecutionEvent_2092(ExecutionEvent self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_DurationObservation_2093(DurationObservation self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_TimeObservation_2094(TimeObservation self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_LiteralBoolean_2095(LiteralBoolean self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_LiteralInteger_2096(LiteralInteger self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_LiteralNull_2097(LiteralNull self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_LiteralString_2098(LiteralString self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_LiteralUnlimitedNatural_2099(LiteralUnlimitedNatural self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_StringExpression_2100(StringExpression self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_OpaqueExpression_2101(OpaqueExpression self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_TimeExpression_2102(TimeExpression self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Expression_2103(Expression self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Duration_2104(Duration self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_TimeInterval_2105(TimeInterval self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_DurationInterval_2106(DurationInterval self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Interval_2107(Interval self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_InstanceValue_2108(InstanceValue self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String body_Comment_2109(Comment self) {
		return self.getBody();
	}

	/**
	 * @generated
	 */
	private String name_DurationConstraint_2110(DurationConstraint self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_TimeConstraint_2111(TimeConstraint self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_IntervalConstraint_2112(IntervalConstraint self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_InteractionConstraint_2113(InteractionConstraint self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Constraint_2114(Constraint self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Port_3069(Port self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Parameter_3088(Parameter self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Property_3070(Property self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_ConnectableElement_3115(ConnectableElement self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_CollaborationUse_3071(CollaborationUse self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Activity_3072(Activity self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Interaction_3073(Interaction self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_ProtocolStateMachine_3074(ProtocolStateMachine self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_StateMachine_3075(StateMachine self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_FunctionBehavior_3076(FunctionBehavior self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_OpaqueBehavior_3077(OpaqueBehavior self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Component_3081(Component self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Device_3082(Device self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_ExecutionEnvironment_3083(ExecutionEnvironment self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Node_3084(Node self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Class_3085(Class self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Collaboration_3086(Collaboration self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Interface_3087(Interface self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_PrimitiveType_3078(PrimitiveType self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Enumeration_3079(Enumeration self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_DataType_3080(DataType self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Actor_3091(Actor self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_DeploymentSpecification_3092(DeploymentSpecification self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Artifact_3093(Artifact self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_InformationItem_3094(InformationItem self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private Boolean isAbstract_InformationItem_3094(InformationItem self) {
		// InformationItem is Abstract
		return true;
	}

	/**
	 * @generated
	 */
	private String name_Signal_3095(Signal self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_UseCase_3096(UseCase self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String body_Comment_3097(Comment self) {
		return self.getBody();
	}

	/**
	 * @generated
	 */
	private String name_Property_3101(Property self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Operation_3102(Operation self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Reception_3100(Reception self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_EnumerationLiteral_3066(EnumerationLiteral self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Activity_3103(Activity self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Interaction_3104(Interaction self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_ProtocolStateMachine_3105(ProtocolStateMachine self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_StateMachine_3106(StateMachine self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_FunctionBehavior_3107(FunctionBehavior self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_OpaqueBehavior_3108(OpaqueBehavior self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Collaboration_3109(Collaboration self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Interface_3110(Interface self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Enumeration_3111(Enumeration self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_PrimitiveType_3112(PrimitiveType self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_DataType_3113(DataType self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Class_3114(Class self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_ComponentRealization_4004(ComponentRealization self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_InterfaceRealization_4005(InterfaceRealization self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Substitution_4011(Substitution self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Realization_4006(Realization self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Manifestation_4012(Manifestation self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Abstraction_4007(Abstraction self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Usage_4008(Usage self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Deployment_4009(Deployment self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Dependency_4010(Dependency self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_Connector_4013(Connector self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private String name_InformationFlow_4021(InformationFlow self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}


	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = UMLDiagramEditorPlugin.getInstance().getElementInitializers();
		if(cached == null) {
			UMLDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
