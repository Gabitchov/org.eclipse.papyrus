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
package org.eclipse.papyrus.uml.diagram.activity.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;

/**
 * @generated
 */
public class UMLPaletteFactory extends PaletteFactory.Adapter {

	/**
	 * @generated
	 */
	private final static String CREATEACTIVITYPARTITION1CREATIONTOOL = "createActivityPartition1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEINTERRUPTIBLEACTIVITYREGION2CREATIONTOOL = "createInterruptibleActivityRegion2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEINITIALNODE1CREATIONTOOL = "createInitialnode1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEACTIVITYFINAL2CREATIONTOOL = "createActivityfinal2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEFLOWFINAL3CREATIONTOOL = "createFlowfinal3CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEDECISIONNODE4CREATIONTOOL = "createDecisionnode4CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEMERGENODE5CREATIONTOOL = "createMergenode5CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEJOINNODE6CREATIONTOOL = "createJoinnode6CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEFORKNODE7CREATIONTOOL = "createForknode7CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEACTIVITY1CREATIONTOOL = "createActivity1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEACTIVITYPARAMETERNODE2CREATIONTOOL = "createActivityParameterNode2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECENTRALBUFFERNODE3CREATIONTOOL = "createCentralBufferNode3CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEDATASTORENODE4CREATIONTOOL = "createDataStoreNode4CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECOMMENT5CREATIONTOOL = "createComment5CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECONSTRAINT6CREATIONTOOL = "createConstraint6CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECONTROLFLOW1CREATIONTOOL = "createControlFlow1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEEXCEPTIONHANDLER2CREATIONTOOL = "createExceptionHandler2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEOBJECTFLOW3CREATIONTOOL = "createObjectFlow3CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATELINK4CREATIONTOOL = "createLink4CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATELOCALPRECONDITIONCONSTRAINT1CREATIONTOOL = "createLocalPreconditionConstraint1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATELOCALPRECONDITIONINTERVALCONSTRAINT3CREATIONTOOL = "createLocalPreconditionIntervalConstraint3CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATELOCALPRECONDITIONDURATIONCONSTRAINT4CREATIONTOOL = "createLocalPreconditionDurationConstraint4CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATELOCALPRECONDITIONTIMECONSTRAINT5CREATIONTOOL = "createLocalPreconditionTimeConstraint5CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATELOCALPOSTCONDITIONCONSTRAINT6CREATIONTOOL = "createLocalPostconditionConstraint6CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATELOCALPOSTCONDITIONINTERVALCONSTRAINT8CREATIONTOOL = "createLocalPostconditionIntervalConstraint8CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATELOCALPOSTCONDITIONDURATIONCONSTRAINT9CREATIONTOOL = "createLocalPostconditionDurationConstraint9CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATELOCALPOSTCONDITIONTIMECONSTRAINT10CREATIONTOOL = "createLocalPostconditionTimeConstraint10CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEOUTPUTPIN1CREATIONTOOL = "createOutputPin1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEINPUTPIN2CREATIONTOOL = "createInputPin2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEACTIONINPUTPIN3CREATIONTOOL = "createActionInputPin3CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEVALUEPIN4CREATIONTOOL = "createValuePin4CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEEXPANSIONREGION1CREATIONTOOL = "createExpansionRegion1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEINPUTEXPANSIONNODE2CREATIONTOOL = "createInputExpansionNode2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEOUTPUTEXPANSIONNODE3CREATIONTOOL = "createOutputExpansionNode3CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEBROADCASTSIGNALACTION1CREATIONTOOL = "createBroadcastSignalAction1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECALLBEHAVIORACTION2CREATIONTOOL = "createCallBehaviorAction2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECALLOPERATIONACTION3CREATIONTOOL = "createCallOperationAction3CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATESENDOBJECTACTION4CREATIONTOOL = "createSendObjectAction4CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATESENDSIGNALACTION5CREATIONTOOL = "createSendSignalAction5CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECREATEOBJECTACTION1CREATIONTOOL = "createCreateObjectAction1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEDESTROYOBJECTACTION2CREATIONTOOL = "createDestroyObjectAction2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEREADSELFACTION3CREATIONTOOL = "createReadSelfAction3CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATESTRUCTUREDACTIVITYNODE1CREATIONTOOL = "createStructuredActivityNode1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATELOOPNODE2CREATIONTOOL = "createLoopNode2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATESEQUENCENODE3CREATIONTOOL = "createSequenceNode3CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECONDITIONALNODE4CREATIONTOOL = "createConditionalNode4CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEREADSTRUCTURALFEATUREACTION1CREATIONTOOL = "createReadStructuralFeatureAction1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEADDSTRUCTURALFEATUREVALUEACTION2CREATIONTOOL = "createAddStructuralFeatureValueAction2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEADDSTRUCTURALFEATUREVALUEACTION3CREATIONTOOL = "createAddStructuralFeatureValueAction3CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEREADSTRUCTURALFEATUREACTION4CREATIONTOOL = "createReadStructuralFeatureAction4CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEADDVARIABLEVALUEACTION1CREATIONTOOL = "createAddVariableValueAction1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEREADVARIABLEACTION2CREATIONTOOL = "createReadVariableAction2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEOPAQUEACTION1CREATIONTOOL = "createOpaqueAction1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEVALUESPECIFICATIONACTION2CREATIONTOOL = "createValueSpecificationAction2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEACCEPTEVENTACTION1CREATIONTOOL = "createAcceptEventAction1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public UMLPaletteFactory() {
	}

	/**
	 * @generated
	 */
	public Tool createTool(String toolId) {
		if(toolId.equals(CREATEACTIVITYPARTITION1CREATIONTOOL)) {
			return createActivityPartition1CreationTool();
		}
		if(toolId.equals(CREATEINTERRUPTIBLEACTIVITYREGION2CREATIONTOOL)) {
			return createInterruptibleActivityRegion2CreationTool();
		}
		if(toolId.equals(CREATEINITIALNODE1CREATIONTOOL)) {
			return createInitialnode1CreationTool();
		}
		if(toolId.equals(CREATEACTIVITYFINAL2CREATIONTOOL)) {
			return createActivityfinal2CreationTool();
		}
		if(toolId.equals(CREATEFLOWFINAL3CREATIONTOOL)) {
			return createFlowfinal3CreationTool();
		}
		if(toolId.equals(CREATEDECISIONNODE4CREATIONTOOL)) {
			return createDecisionnode4CreationTool();
		}
		if(toolId.equals(CREATEMERGENODE5CREATIONTOOL)) {
			return createMergenode5CreationTool();
		}
		if(toolId.equals(CREATEJOINNODE6CREATIONTOOL)) {
			return createJoinnode6CreationTool();
		}
		if(toolId.equals(CREATEFORKNODE7CREATIONTOOL)) {
			return createForknode7CreationTool();
		}
		if(toolId.equals(CREATEACTIVITY1CREATIONTOOL)) {
			return createActivity1CreationTool();
		}
		if(toolId.equals(CREATEACTIVITYPARAMETERNODE2CREATIONTOOL)) {
			return createActivityParameterNode2CreationTool();
		}
		if(toolId.equals(CREATECENTRALBUFFERNODE3CREATIONTOOL)) {
			return createCentralBufferNode3CreationTool();
		}
		if(toolId.equals(CREATEDATASTORENODE4CREATIONTOOL)) {
			return createDataStoreNode4CreationTool();
		}
		if(toolId.equals(CREATECOMMENT5CREATIONTOOL)) {
			return createComment5CreationTool();
		}
		if(toolId.equals(CREATECONSTRAINT6CREATIONTOOL)) {
			return createConstraint6CreationTool();
		}
		if(toolId.equals(CREATECONTROLFLOW1CREATIONTOOL)) {
			return createControlFlow1CreationTool();
		}
		if(toolId.equals(CREATEEXCEPTIONHANDLER2CREATIONTOOL)) {
			return createExceptionHandler2CreationTool();
		}
		if(toolId.equals(CREATEOBJECTFLOW3CREATIONTOOL)) {
			return createObjectFlow3CreationTool();
		}
		if(toolId.equals(CREATELINK4CREATIONTOOL)) {
			return createLink4CreationTool();
		}
		if(toolId.equals(CREATELOCALPRECONDITIONCONSTRAINT1CREATIONTOOL)) {
			return createLocalPreconditionConstraint1CreationTool();
		}
		if(toolId.equals(CREATELOCALPRECONDITIONINTERVALCONSTRAINT3CREATIONTOOL)) {
			return createLocalPreconditionIntervalConstraint3CreationTool();
		}
		if(toolId.equals(CREATELOCALPRECONDITIONDURATIONCONSTRAINT4CREATIONTOOL)) {
			return createLocalPreconditionDurationConstraint4CreationTool();
		}
		if(toolId.equals(CREATELOCALPRECONDITIONTIMECONSTRAINT5CREATIONTOOL)) {
			return createLocalPreconditionTimeConstraint5CreationTool();
		}
		if(toolId.equals(CREATELOCALPOSTCONDITIONCONSTRAINT6CREATIONTOOL)) {
			return createLocalPostconditionConstraint6CreationTool();
		}
		if(toolId.equals(CREATELOCALPOSTCONDITIONINTERVALCONSTRAINT8CREATIONTOOL)) {
			return createLocalPostconditionIntervalConstraint8CreationTool();
		}
		if(toolId.equals(CREATELOCALPOSTCONDITIONDURATIONCONSTRAINT9CREATIONTOOL)) {
			return createLocalPostconditionDurationConstraint9CreationTool();
		}
		if(toolId.equals(CREATELOCALPOSTCONDITIONTIMECONSTRAINT10CREATIONTOOL)) {
			return createLocalPostconditionTimeConstraint10CreationTool();
		}
		if(toolId.equals(CREATEOUTPUTPIN1CREATIONTOOL)) {
			return createOutputPin1CreationTool();
		}
		if(toolId.equals(CREATEINPUTPIN2CREATIONTOOL)) {
			return createInputPin2CreationTool();
		}
		if(toolId.equals(CREATEACTIONINPUTPIN3CREATIONTOOL)) {
			return createActionInputPin3CreationTool();
		}
		if(toolId.equals(CREATEVALUEPIN4CREATIONTOOL)) {
			return createValuePin4CreationTool();
		}
		if(toolId.equals(CREATEEXPANSIONREGION1CREATIONTOOL)) {
			return createExpansionRegion1CreationTool();
		}
		if(toolId.equals(CREATEINPUTEXPANSIONNODE2CREATIONTOOL)) {
			return createInputExpansionNode2CreationTool();
		}
		if(toolId.equals(CREATEOUTPUTEXPANSIONNODE3CREATIONTOOL)) {
			return createOutputExpansionNode3CreationTool();
		}
		if(toolId.equals(CREATEBROADCASTSIGNALACTION1CREATIONTOOL)) {
			return createBroadcastSignalAction1CreationTool();
		}
		if(toolId.equals(CREATECALLBEHAVIORACTION2CREATIONTOOL)) {
			return createCallBehaviorAction2CreationTool();
		}
		if(toolId.equals(CREATECALLOPERATIONACTION3CREATIONTOOL)) {
			return createCallOperationAction3CreationTool();
		}
		if(toolId.equals(CREATESENDOBJECTACTION4CREATIONTOOL)) {
			return createSendObjectAction4CreationTool();
		}
		if(toolId.equals(CREATESENDSIGNALACTION5CREATIONTOOL)) {
			return createSendSignalAction5CreationTool();
		}
		if(toolId.equals(CREATECREATEOBJECTACTION1CREATIONTOOL)) {
			return createCreateObjectAction1CreationTool();
		}
		if(toolId.equals(CREATEDESTROYOBJECTACTION2CREATIONTOOL)) {
			return createDestroyObjectAction2CreationTool();
		}
		if(toolId.equals(CREATEREADSELFACTION3CREATIONTOOL)) {
			return createReadSelfAction3CreationTool();
		}
		if(toolId.equals(CREATESTRUCTUREDACTIVITYNODE1CREATIONTOOL)) {
			return createStructuredActivityNode1CreationTool();
		}
		if(toolId.equals(CREATELOOPNODE2CREATIONTOOL)) {
			return createLoopNode2CreationTool();
		}
		if(toolId.equals(CREATESEQUENCENODE3CREATIONTOOL)) {
			return createSequenceNode3CreationTool();
		}
		if(toolId.equals(CREATECONDITIONALNODE4CREATIONTOOL)) {
			return createConditionalNode4CreationTool();
		}
		if(toolId.equals(CREATEREADSTRUCTURALFEATUREACTION1CREATIONTOOL)) {
			return createReadStructuralFeatureAction1CreationTool();
		}
		if(toolId.equals(CREATEADDSTRUCTURALFEATUREVALUEACTION2CREATIONTOOL)) {
			return createAddStructuralFeatureValueAction2CreationTool();
		}
		if(toolId.equals(CREATEADDSTRUCTURALFEATUREVALUEACTION3CREATIONTOOL)) {
			return createAddStructuralFeatureValueAction3CreationTool();
		}
		if(toolId.equals(CREATEREADSTRUCTURALFEATUREACTION4CREATIONTOOL)) {
			return createReadStructuralFeatureAction4CreationTool();
		}
		if(toolId.equals(CREATEADDVARIABLEVALUEACTION1CREATIONTOOL)) {
			return createAddVariableValueAction1CreationTool();
		}
		if(toolId.equals(CREATEREADVARIABLEACTION2CREATIONTOOL)) {
			return createReadVariableAction2CreationTool();
		}
		if(toolId.equals(CREATEOPAQUEACTION1CREATIONTOOL)) {
			return createOpaqueAction1CreationTool();
		}
		if(toolId.equals(CREATEVALUESPECIFICATIONACTION2CREATIONTOOL)) {
			return createValueSpecificationAction2CreationTool();
		}
		if(toolId.equals(CREATEACCEPTEVENTACTION1CREATIONTOOL)) {
			return createAcceptEventAction1CreationTool();
		}
		// default return: null
		return null;
	}

	public Object getTemplate(String templateId) {
		// default return: null
		return null;
	}

	/**
	 * @generated
	 */
	private Tool createActivityPartition1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ActivityPartition_3067);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInterruptibleActivityRegion2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.InterruptibleActivityRegion_3068);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInitialnode1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.InitialNode_3004);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createActivityfinal2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ActivityFinalNode_3005);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createFlowfinal3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.FlowFinalNode_3006);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDecisionnode4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DecisionNode_3038);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createMergenode5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.MergeNode_3039);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createJoinnode6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.JoinNode_3041);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createForknode7CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ForkNode_3040);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createActivity1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Activity_2001);
		types.add(UMLElementTypes.Activity_3083);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createActivityParameterNode2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ActivityParameterNode_3059);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCentralBufferNode3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CentralBufferNode_3104);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDataStoreNode4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DataStoreNode_3078);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createComment5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Comment_3080);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConstraint6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Constraint_3112);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createControlFlow1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ControlFlow_4004);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createExceptionHandler2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ExceptionHandler_4005);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createObjectFlow3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ObjectFlow_4003);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLink4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.CommentAnnotatedElement_4006);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4007);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLocalPreconditionConstraint1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Constraint_3011);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLocalPreconditionIntervalConstraint3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.IntervalConstraint_3032);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLocalPreconditionDurationConstraint4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DurationConstraint_3034);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLocalPreconditionTimeConstraint5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TimeConstraint_3036);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLocalPostconditionConstraint6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Constraint_3012);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLocalPostconditionIntervalConstraint8CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.IntervalConstraint_3033);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLocalPostconditionDurationConstraint9CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DurationConstraint_3035);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLocalPostconditionTimeConstraint10CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TimeConstraint_3037);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createOutputPin1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(9);
		types.add(UMLElementTypes.OutputPin_3014);
		types.add(UMLElementTypes.OutputPin_3020);
		types.add(UMLElementTypes.OutputPin_3024);
		types.add(UMLElementTypes.OutputPin_3064);
		types.add(UMLElementTypes.OutputPin_3077);
		types.add(UMLElementTypes.OutputPin_3084);
		types.add(UMLElementTypes.OutputPin_3109);
		types.add(UMLElementTypes.OutputPin_3110);
		types.add(UMLElementTypes.OutputPin_3111);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInputPin2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(UMLElementTypes.InputPin_3013);
		types.add(UMLElementTypes.InputPin_3019);
		types.add(UMLElementTypes.InputPin_3023);
		types.add(UMLElementTypes.InputPin_3055);
		types.add(UMLElementTypes.InputPin_3105);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createActionInputPin3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(UMLElementTypes.ActionInputPin_3016);
		types.add(UMLElementTypes.ActionInputPin_3018);
		types.add(UMLElementTypes.ActionInputPin_3021);
		types.add(UMLElementTypes.ActionInputPin_3053);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createValuePin4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(UMLElementTypes.ValuePin_3015);
		types.add(UMLElementTypes.ValuePin_3017);
		types.add(UMLElementTypes.ValuePin_3022);
		types.add(UMLElementTypes.ValuePin_3054);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createExpansionRegion1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ExpansionRegion_3070);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInputExpansionNode2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ExpansionNode_3074);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createOutputExpansionNode3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ExpansionNode_3075);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createBroadcastSignalAction1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.BroadcastSignalAction_3102);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCallBehaviorAction2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CallBehaviorAction_3008);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCallOperationAction3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CallOperationAction_3010);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createSendObjectAction4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.SendObjectAction_3042);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createSendSignalAction5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.SendSignalAction_3052);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCreateObjectAction1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CreateObjectAction_3086);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDestroyObjectAction2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DestroyObjectAction_3095);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createReadSelfAction3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ReadSelfAction_3081);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createStructuredActivityNode1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.StructuredActivityNode_3065);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLoopNode2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.LoopNode_3071);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createSequenceNode3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.SequenceNode_3073);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConditionalNode4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ConditionalNode_3069);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createReadStructuralFeatureAction1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ReadStructuralFeatureAction_3088);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAddStructuralFeatureValueAction2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.AddStructuralFeatureValueAction_3091);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAddStructuralFeatureValueAction3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.AddStructuralFeatureValueAction_3091);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createReadStructuralFeatureAction4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ReadStructuralFeatureAction_3088);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAddVariableValueAction1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.AddVariableValueAction_3099);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createReadVariableAction2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ReadVariableAction_3097);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createOpaqueAction1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.OpaqueAction_3007);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createValueSpecificationAction2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ValueSpecificationAction_3076);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAcceptEventAction1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.AcceptEventAction_3063);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}
}
