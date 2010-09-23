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
package org.eclipse.papyrus.diagram.activity.providers;

import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.common.actions.LabelHelper;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.ActionInputPin;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.ConditionalNode;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.DataStoreNode;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationInterval;
import org.eclipse.uml2.uml.ExpansionNode;
import org.eclipse.uml2.uml.ExpansionRegion;
import org.eclipse.uml2.uml.FlowFinalNode;
import org.eclipse.uml2.uml.ForkNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.IntervalConstraint;
import org.eclipse.uml2.uml.JoinNode;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.MergeNode;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.SendObjectAction;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.SequenceNode;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeInterval;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValuePin;
import org.eclipse.uml2.uml.ValueSpecificationAction;

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
	public void init_Activity_2001(Activity instance) {
		try {
			Object value_0 = name_Activity_2001(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Parameter_3001(Parameter instance) {
		try {
			Object value_0 = name_Parameter_3001(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Constraint_3002(Constraint instance) {
		try {
			Object value_0 = name_Constraint_3002(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Constraint_3003(Constraint instance) {
		try {
			Object value_0 = name_Constraint_3003(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InitialNode_3004(InitialNode instance) {
		try {
			Object value_0 = name_InitialNode_3004(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ActivityFinalNode_3005(ActivityFinalNode instance) {
		try {
			Object value_0 = name_ActivityFinalNode_3005(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_FlowFinalNode_3006(FlowFinalNode instance) {
		try {
			Object value_0 = name_FlowFinalNode_3006(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_OpaqueAction_3007(OpaqueAction instance) {
		try {
			Object value_0 = name_OpaqueAction_3007(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ValuePin_3015(ValuePin instance) {
		try {
			Object value_0 = name_ValuePin_3015(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ActionInputPin_3016(ActionInputPin instance) {
		try {
			Object value_0 = name_ActionInputPin_3016(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InputPin_3013(InputPin instance) {
		try {
			Object value_0 = name_InputPin_3013(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_OutputPin_3014(OutputPin instance) {
		try {
			Object value_0 = name_OutputPin_3014(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_CallBehaviorAction_3008(CallBehaviorAction instance) {
		try {
			Object value_0 = name_CallBehaviorAction_3008(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ValuePin_3017(ValuePin instance) {
		try {
			Object value_0 = name_ValuePin_3017(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ActionInputPin_3018(ActionInputPin instance) {
		try {
			Object value_0 = name_ActionInputPin_3018(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InputPin_3019(InputPin instance) {
		try {
			Object value_0 = name_InputPin_3019(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_OutputPin_3020(OutputPin instance) {
		try {
			Object value_0 = name_OutputPin_3020(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_CallOperationAction_3010(CallOperationAction instance) {
		try {
			Object value_0 = name_CallOperationAction_3010(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ActionInputPin_3021(ActionInputPin instance) {
		try {
			Object value_0 = name_ActionInputPin_3021(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ValuePin_3022(ValuePin instance) {
		try {
			Object value_0 = name_ValuePin_3022(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InputPin_3023(InputPin instance) {
		try {
			Object value_0 = name_InputPin_3023(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_OutputPin_3024(OutputPin instance) {
		try {
			Object value_0 = name_OutputPin_3024(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ValuePin_3025(ValuePin instance) {
		try {
			Object value_0 = name_ValuePin_3025(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ActionInputPin_3026(ActionInputPin instance) {
		try {
			Object value_0 = name_ActionInputPin_3026(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InputPin_3027(InputPin instance) {
		try {
			Object value_0 = name_InputPin_3027(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Constraint_3011(Constraint instance) {
		try {
			Object value_0 = name_Constraint_3011(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Constraint_3012(Constraint instance) {
		try {
			Object value_0 = name_Constraint_3012(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DecisionNode_3038(DecisionNode instance) {
		try {
			Object value_0 = name_DecisionNode_3038(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_MergeNode_3039(MergeNode instance) {
		try {
			Object value_0 = name_MergeNode_3039(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ForkNode_3040(ForkNode instance) {
		try {
			Object value_0 = name_ForkNode_3040(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_JoinNode_3041(JoinNode instance) {
		try {
			Object value_0 = name_JoinNode_3041(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_SendObjectAction_3042(SendObjectAction instance) {
		try {
			Object value_0 = name_SendObjectAction_3042(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ValuePin_3046(ValuePin instance) {
		try {
			Object value_0 = name_ValuePin_3046(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ActionInputPin_3047(ActionInputPin instance) {
		try {
			Object value_0 = name_ActionInputPin_3047(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InputPin_3048(InputPin instance) {
		try {
			Object value_0 = name_InputPin_3048(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ValuePin_3049(ValuePin instance) {
		try {
			Object value_0 = name_ValuePin_3049(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ActionInputPin_3050(ActionInputPin instance) {
		try {
			Object value_0 = name_ActionInputPin_3050(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InputPin_3051(InputPin instance) {
		try {
			Object value_0 = name_InputPin_3051(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_SendSignalAction_3052(SendSignalAction instance) {
		try {
			Object value_0 = name_SendSignalAction_3052(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ActionInputPin_3053(ActionInputPin instance) {
		try {
			Object value_0 = name_ActionInputPin_3053(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ValuePin_3054(ValuePin instance) {
		try {
			Object value_0 = name_ValuePin_3054(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InputPin_3055(InputPin instance) {
		try {
			Object value_0 = name_InputPin_3055(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ValuePin_3060(ValuePin instance) {
		try {
			Object value_0 = name_ValuePin_3060(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ActionInputPin_3061(ActionInputPin instance) {
		try {
			Object value_0 = name_ActionInputPin_3061(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InputPin_3062(InputPin instance) {
		try {
			Object value_0 = name_InputPin_3062(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ActivityParameterNode_3059(ActivityParameterNode instance) {
		try {
			Object value_0 = name_ActivityParameterNode_3059(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_AcceptEventAction_3063(AcceptEventAction instance) {
		try {
			Object value_0 = name_AcceptEventAction_3063(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_OutputPin_3064(OutputPin instance) {
		try {
			Object value_0 = name_OutputPin_3064(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ConditionalNode_3069(ConditionalNode instance) {
		try {
			Object value_0 = name_ConditionalNode_3069(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ExpansionRegion_3070(ExpansionRegion instance) {
		try {
			Object value_0 = name_ExpansionRegion_3070(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ExpansionNode_3074(ExpansionNode instance) {
		try {
			Object value_0 = name_ExpansionNode_3074(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ExpansionNode_3075(ExpansionNode instance) {
		try {
			Object value_0 = name_ExpansionNode_3075(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_LoopNode_3071(LoopNode instance) {
		try {
			Object value_0 = name_LoopNode_3071(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_SequenceNode_3073(SequenceNode instance) {
		try {
			Object value_0 = name_SequenceNode_3073(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_StructuredActivityNode_3065(StructuredActivityNode instance) {
		try {
			Object value_0 = name_StructuredActivityNode_3065(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ActivityPartition_3067(ActivityPartition instance) {
		try {
			Object value_0 = name_ActivityPartition_3067(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ValueSpecificationAction_3076(ValueSpecificationAction instance) {
		try {
			Object value_0 = name_ValueSpecificationAction_3076(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_OutputPin_3077(OutputPin instance) {
		try {
			Object value_0 = name_OutputPin_3077(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DataStoreNode_3078(DataStoreNode instance) {
		try {
			Object value_0 = name_DataStoreNode_3078(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_IntervalConstraint_3032(IntervalConstraint instance) {
		try {
			Object value_0 = name_IntervalConstraint_3032(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_IntervalConstraint_3033(IntervalConstraint instance) {
		try {
			Object value_0 = name_IntervalConstraint_3033(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DurationConstraint_3034(DurationConstraint instance) {
		try {
			Object value_0 = name_DurationConstraint_3034(instance);
			instance.setName((String)value_0);
			DurationInterval newInstance_1_0 = UMLFactory.eINSTANCE.createDurationInterval();
			instance.setSpecification(newInstance_1_0);
			Object value_1_0_0 = name_specification_DurationConstraint_3034(newInstance_1_0);
			newInstance_1_0.setName((String)value_1_0_0);

		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DurationConstraint_3035(DurationConstraint instance) {
		try {
			Object value_0 = name_DurationConstraint_3035(instance);
			instance.setName((String)value_0);
			DurationInterval newInstance_1_0 = UMLFactory.eINSTANCE.createDurationInterval();
			instance.setSpecification(newInstance_1_0);
			Object value_1_0_0 = name_specification_DurationConstraint_3035(newInstance_1_0);
			newInstance_1_0.setName((String)value_1_0_0);

		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_TimeConstraint_3036(TimeConstraint instance) {
		try {
			Object value_0 = name_TimeConstraint_3036(instance);
			instance.setName((String)value_0);
			TimeInterval newInstance_1_0 = UMLFactory.eINSTANCE.createTimeInterval();
			instance.setSpecification(newInstance_1_0);
			Object value_1_0_0 = name_specification_TimeConstraint_3036(newInstance_1_0);
			newInstance_1_0.setName((String)value_1_0_0);

		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_TimeConstraint_3037(TimeConstraint instance) {
		try {
			Object value_0 = name_TimeConstraint_3037(instance);
			instance.setName((String)value_0);
			TimeInterval newInstance_1_0 = UMLFactory.eINSTANCE.createTimeInterval();
			instance.setSpecification(newInstance_1_0);
			Object value_1_0_0 = name_specification_TimeConstraint_3037(newInstance_1_0);
			newInstance_1_0.setName((String)value_1_0_0);

		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated NOT initialize the guard
	 */
	public void init_ObjectFlow_4003(ObjectFlow instance) {
		try {
			Object value_0 = name_ObjectFlow_4003(instance);
			instance.setName((String)value_0);
			// initialize the guard
			createGuardForFlow(instance);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated NOT initialize the guard
	 */
	public void init_ControlFlow_4004(ControlFlow instance) {
		try {
			Object value_0 = name_ControlFlow_4004(instance);
			instance.setName((String)value_0);
			// initialize the guard
			createGuardForFlow(instance);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated NOT if name is already set, return it
	 */
	private static String name_Activity_2001(Activity self) {
		if(self.getName() != null) {
			return self.getName();
		}
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_Parameter_3001(Parameter self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_Constraint_3002(Constraint self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_Constraint_3003(Constraint self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_InitialNode_3004(InitialNode self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ActivityFinalNode_3005(ActivityFinalNode self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_FlowFinalNode_3006(FlowFinalNode self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_OpaqueAction_3007(OpaqueAction self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ValuePin_3015(ValuePin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ActionInputPin_3016(ActionInputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_InputPin_3013(InputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_OutputPin_3014(OutputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated NOT initialize name with the behavior's name when possible.
	 */
	private static String name_CallBehaviorAction_3008(CallBehaviorAction self) {
		//initialize name with the behavior's name when possible.
		if(self.getBehavior() != null) {
			String behaviorName = self.getBehavior().getName();
			if(behaviorName != null && !"".equals(behaviorName.trim())) {
				return behaviorName;
			}
		}
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ValuePin_3017(ValuePin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ActionInputPin_3018(ActionInputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_InputPin_3019(InputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_OutputPin_3020(OutputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_CallOperationAction_3010(CallOperationAction self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ActionInputPin_3021(ActionInputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ValuePin_3022(ValuePin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_InputPin_3023(InputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_OutputPin_3024(OutputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ValuePin_3025(ValuePin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ActionInputPin_3026(ActionInputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_InputPin_3027(InputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_Constraint_3011(Constraint self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_Constraint_3012(Constraint self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_DecisionNode_3038(DecisionNode self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_MergeNode_3039(MergeNode self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ForkNode_3040(ForkNode self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_JoinNode_3041(JoinNode self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_SendObjectAction_3042(SendObjectAction self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ValuePin_3046(ValuePin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ActionInputPin_3047(ActionInputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_InputPin_3048(InputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ValuePin_3049(ValuePin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ActionInputPin_3050(ActionInputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_InputPin_3051(InputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_SendSignalAction_3052(SendSignalAction self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ActionInputPin_3053(ActionInputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ValuePin_3054(ValuePin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_InputPin_3055(InputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ValuePin_3060(ValuePin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ActionInputPin_3061(ActionInputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_InputPin_3062(InputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ActivityParameterNode_3059(ActivityParameterNode self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_AcceptEventAction_3063(AcceptEventAction self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_OutputPin_3064(OutputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ConditionalNode_3069(ConditionalNode self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ExpansionRegion_3070(ExpansionRegion self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ExpansionNode_3074(ExpansionNode self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ExpansionNode_3075(ExpansionNode self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_LoopNode_3071(LoopNode self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_SequenceNode_3073(SequenceNode self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_StructuredActivityNode_3065(StructuredActivityNode self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ActivityPartition_3067(ActivityPartition self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ValueSpecificationAction_3076(ValueSpecificationAction self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_OutputPin_3077(OutputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_DataStoreNode_3078(DataStoreNode self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_IntervalConstraint_3032(IntervalConstraint self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_IntervalConstraint_3033(IntervalConstraint self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_DurationConstraint_3034(DurationConstraint self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_specification_DurationConstraint_3035(DurationInterval self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_specification_DurationConstraint_3034(DurationInterval self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_DurationConstraint_3035(DurationConstraint self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_specification_TimeConstraint_3036(TimeInterval self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_TimeConstraint_3036(TimeConstraint self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_specification_TimeConstraint_3037(TimeInterval self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_TimeConstraint_3037(TimeConstraint self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ObjectFlow_4003(ObjectFlow self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ControlFlow_4004(ControlFlow self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
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

	/**
	 * Creates the guard for flow.
	 * 
	 * @param edge
	 *        the edge
	 */
	private static void createGuardForFlow(ActivityEdge edge) {
		if(edge.getGuard() == null) {
			OpaqueExpression expression = UMLFactory.eINSTANCE.createOpaqueExpression();
			expression.getLanguages().add("OCL");
			expression.getBodies().add("true");
			edge.setGuard(expression);
		}
	}

}
