package org.eclipse.papyrus.uml.diagram.activity.providers;

import org.eclipse.papyrus.uml.diagram.activity.expressions.UMLOCLFactory;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.common.actions.LabelHelper;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.ActionInputPin;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.AddStructuralFeatureValueAction;
import org.eclipse.uml2.uml.AddVariableValueAction;
import org.eclipse.uml2.uml.BroadcastSignalAction;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.CentralBufferNode;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConditionalNode;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.CreateObjectAction;
import org.eclipse.uml2.uml.DataStoreNode;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.DestroyObjectAction;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationInterval;
import org.eclipse.uml2.uml.ExpansionNode;
import org.eclipse.uml2.uml.ExpansionRegion;
import org.eclipse.uml2.uml.FlowFinalNode;
import org.eclipse.uml2.uml.ForkNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.Interval;
import org.eclipse.uml2.uml.IntervalConstraint;
import org.eclipse.uml2.uml.JoinNode;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.MergeNode;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ReadSelfAction;
import org.eclipse.uml2.uml.ReadStructuralFeatureAction;
import org.eclipse.uml2.uml.ReadVariableAction;
import org.eclipse.uml2.uml.SendObjectAction;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.SequenceNode;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeInterval;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValuePin;
import org.eclipse.uml2.uml.ValueSpecification;
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
	 * @generated
	 */
	public void init_IntervalConstraint_3032(IntervalConstraint instance) {
		try {
			Object value_0 = name_IntervalConstraint_3032(instance);
			instance.setName((String)value_0);
			Interval newInstance_1_0 = UMLFactory.eINSTANCE.createInterval();
			instance.setSpecification(newInstance_1_0);
			Object value_1_0_0 = name_specification_IntervalConstraint_3032(newInstance_1_0);
			newInstance_1_0.setName((String)value_1_0_0);
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
			Interval newInstance_1_0 = UMLFactory.eINSTANCE.createInterval();
			instance.setSpecification(newInstance_1_0);
			Object value_1_0_0 = name_specification_IntervalConstraint_3033(newInstance_1_0);
			newInstance_1_0.setName((String)value_1_0_0);
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
			OpaqueExpression newInstance_1_0 = UMLFactory.eINSTANCE.createOpaqueExpression();
			instance.setSpecification(newInstance_1_0);
			Object value_1_0_0 = name_specification_Constraint_3011(newInstance_1_0);
			newInstance_1_0.setName((String)value_1_0_0);
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
			OpaqueExpression newInstance_1_0 = UMLFactory.eINSTANCE.createOpaqueExpression();
			instance.setSpecification(newInstance_1_0);
			Object value_1_0_0 = name_specification_Constraint_3012(newInstance_1_0);
			newInstance_1_0.setName((String)value_1_0_0);
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
			Object value_1 = isControlType_ActivityParameterNode_3059(instance);
			instance.setIsControlType(((Boolean)value_1).booleanValue());
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
	public void init_OutputPin_3109(OutputPin instance) {
		try {
			Object value_0 = name_OutputPin_3109(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_OutputPin_3110(OutputPin instance) {
		try {
			Object value_0 = name_OutputPin_3110(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_OutputPin_3111(OutputPin instance) {
		try {
			Object value_0 = name_OutputPin_3111(instance);
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
	public void init_InputPin_3105(InputPin instance) {
		try {
			Object value_0 = name_InputPin_3105(instance);
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
	public void init_Comment_3080(Comment instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(28, UMLPackage.eINSTANCE.getComment(), null).evaluate(instance);
			instance.setBody((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ReadSelfAction_3081(ReadSelfAction instance) {
		try {
			Object value_0 = name_ReadSelfAction_3081(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_OutputPin_3084(OutputPin instance) {
		try {
			Object value_0 = name_OutputPin_3084(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Activity_3083(Activity instance) {
		try {
			Object value_0 = name_Activity_3083(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_CreateObjectAction_3086(CreateObjectAction instance) {
		try {
			Object value_0 = name_CreateObjectAction_3086(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_OutputPin_3087(OutputPin instance) {
		try {
			Object value_0 = name_OutputPin_3087(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ReadStructuralFeatureAction_3088(ReadStructuralFeatureAction instance) {
		try {
			Object value_0 = name_ReadStructuralFeatureAction_3088(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InputPin_3089(InputPin instance) {
		try {
			Object value_0 = name_InputPin_3089(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_OutputPin_3090(OutputPin instance) {
		try {
			Object value_0 = name_OutputPin_3090(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_AddStructuralFeatureValueAction_3091(AddStructuralFeatureValueAction instance) {
		try {
			Object value_0 = name_AddStructuralFeatureValueAction_3091(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InputPin_3092(InputPin instance) {
		try {
			Object value_0 = name_InputPin_3092(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InputPin_3093(InputPin instance) {
		try {
			Object value_0 = name_InputPin_3093(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_OutputPin_3094(OutputPin instance) {
		try {
			Object value_0 = name_OutputPin_3094(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DestroyObjectAction_3095(DestroyObjectAction instance) {
		try {
			Object value_0 = name_DestroyObjectAction_3095(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InputPin_3096(InputPin instance) {
		try {
			Object value_0 = name_InputPin_3096(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ReadVariableAction_3097(ReadVariableAction instance) {
		try {
			Object value_0 = name_ReadVariableAction_3097(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_OutputPin_3098(OutputPin instance) {
		try {
			Object value_0 = name_OutputPin_3098(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_AddVariableValueAction_3099(AddVariableValueAction instance) {
		try {
			Object value_0 = name_AddVariableValueAction_3099(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InputPin_3100(InputPin instance) {
		try {
			Object value_0 = name_InputPin_3100(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InputPin_3101(InputPin instance) {
		try {
			Object value_0 = name_InputPin_3101(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_BroadcastSignalAction_3102(BroadcastSignalAction instance) {
		try {
			Object value_0 = name_BroadcastSignalAction_3102(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InputPin_3103(InputPin instance) {
		try {
			Object value_0 = name_InputPin_3103(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_CentralBufferNode_3104(CentralBufferNode instance) {
		try {
			Object value_0 = name_CentralBufferNode_3104(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Constraint_3112(Constraint instance) {
		try {
			Object value_0 = name_Constraint_3112(instance);
			instance.setName((String)value_0);
			Object value_1 = specification_Constraint_3112(instance);
			instance.setSpecification((ValueSpecification)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ObjectFlow_4003(ObjectFlow instance) {
		try {
			Object value_0 = name_ObjectFlow_4003(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated NOT
	 */
	public void init_ControlFlow_4004(ControlFlow instance) {
		try {
			Object value_0 = name_ControlFlow_4004(instance);
			instance.setName((String)value_0);
			// Initialize the guard to true
			LiteralBoolean lBoolean = UMLFactory.eINSTANCE.createLiteralBoolean();
			lBoolean.setValue(true);
			instance.setGuard(lBoolean);
			// Initialize the weight to 0
			LiteralInteger lInteger = UMLFactory.eINSTANCE.createLiteralInteger();
			lInteger.setValue(0);
			instance.setWeight(lInteger);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	private String name_Activity_2001(Activity self) {
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
	 * @generated
	 */
	private String name_CallBehaviorAction_3008(CallBehaviorAction self) {
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
	private String name_specification_DurationConstraint_3034(DurationInterval self) {
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
	private String name_DurationConstraint_3035(DurationConstraint self) {
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
	private String name_TimeConstraint_3036(TimeConstraint self) {
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
	private String name_TimeConstraint_3037(TimeConstraint self) {
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
	private String name_IntervalConstraint_3032(IntervalConstraint self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_specification_IntervalConstraint_3032(Interval self) {
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
	private String name_specification_IntervalConstraint_3033(Interval self) {
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
	private String name_specification_Constraint_3011(OpaqueExpression self) {
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
	private String name_specification_Constraint_3012(OpaqueExpression self) {
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
	private String name_DataStoreNode_3078(DataStoreNode self) {
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
	private Boolean isControlType_ActivityParameterNode_3059(ActivityParameterNode self) {
		return true;
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
	private String name_OutputPin_3109(OutputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_OutputPin_3110(OutputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_OutputPin_3111(OutputPin self) {
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
	private String name_InputPin_3105(InputPin self) {
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
	private String name_ReadSelfAction_3081(ReadSelfAction self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_OutputPin_3084(OutputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_Activity_3083(Activity self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_CreateObjectAction_3086(CreateObjectAction self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_OutputPin_3087(OutputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ReadStructuralFeatureAction_3088(ReadStructuralFeatureAction self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_InputPin_3089(InputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_OutputPin_3090(OutputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_AddStructuralFeatureValueAction_3091(AddStructuralFeatureValueAction self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_InputPin_3092(InputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_InputPin_3093(InputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_OutputPin_3094(OutputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_DestroyObjectAction_3095(DestroyObjectAction self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_InputPin_3096(InputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_ReadVariableAction_3097(ReadVariableAction self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_OutputPin_3098(OutputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_AddVariableValueAction_3099(AddVariableValueAction self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_InputPin_3100(InputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_InputPin_3101(InputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_BroadcastSignalAction_3102(BroadcastSignalAction self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_InputPin_3103(InputPin self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_CentralBufferNode_3104(CentralBufferNode self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private String name_Constraint_3112(Constraint self) {
		return LabelHelper.INSTANCE.findName(self.eContainer(), self);
	}

	/**
	 * @generated
	 */
	private ValueSpecification specification_Constraint_3112(Constraint self) {
		LiteralString literalString = UMLFactory.eINSTANCE.createLiteralString();
		literalString.setValue("");
		return literalString;
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
}
