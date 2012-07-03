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
package org.eclipse.papyrus.uml.diagram.activity.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.*;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.AcceptEventActionParser;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.AcceptTimeEventActionParser;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.ActivityEdgeWeightParser;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.ActivityParameterNodeParser;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.ActivitySingleExecutionParser;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.CallBehaviorActionParser;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.CallOperationActionParser;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.DecisionInputFlowParser;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.EdgeGuardParser;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.ExceptionHandlerTypeParser;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.InputDecisionParser;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.JoinSpecParser;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.ObjectFlowSelectionParser;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.ObjectFlowTransformationParser;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.ObjectNodeParser;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.ObjectNodeSelectionParser;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.ParameterParser;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.PinParser;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.PinValueParser;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.PostConditionConstraintLabelParser;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.PreConditionConstraintLabelParser;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.StructuredActivityNodeKeywordParser;
import org.eclipse.papyrus.uml.diagram.activity.parsers.MessageFormatParser;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.common.parser.CommentParser;
import org.eclipse.papyrus.uml.diagram.common.parser.ConstraintParser;
import org.eclipse.papyrus.uml.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser activityName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getActivityName_5001Parser() {
		if(activityName_5001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			activityName_5001Parser = parser;
		}
		return activityName_5001Parser;
	}

	/**
	 * @generated
	 */
	private ActivitySingleExecutionParser activityIsSingleExecution_5002Parser;

	/**
	 * @generated
	 */
	private IParser getActivityIsSingleExecution_5002Parser() {
		if(activityIsSingleExecution_5002Parser == null) {
			activityIsSingleExecution_5002Parser = new ActivitySingleExecutionParser();
		}
		return activityIsSingleExecution_5002Parser;
	}

	/**
	 * @generated
	 */
	private ParameterParser parameter_3001Parser;

	/**
	 * @generated
	 */
	private IParser getParameter_3001Parser() {
		if(parameter_3001Parser == null) {
			parameter_3001Parser = new ParameterParser();
		}
		return parameter_3001Parser;
	}

	/**
	 * @generated
	 */
	private PreConditionConstraintLabelParser constraint_3002Parser;

	/**
	 * @generated
	 */
	private IParser getConstraint_3002Parser() {
		if(constraint_3002Parser == null) {
			constraint_3002Parser = new PreConditionConstraintLabelParser();
		}
		return constraint_3002Parser;
	}

	/**
	 * @generated
	 */
	private PostConditionConstraintLabelParser constraint_3003Parser;

	/**
	 * @generated
	 */
	private IParser getConstraint_3003Parser() {
		if(constraint_3003Parser == null) {
			constraint_3003Parser = new PostConditionConstraintLabelParser();
		}
		return constraint_3003Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser initialNodeLabel_5080Parser;

	/**
	 * @generated
	 */
	private IParser getInitialNodeLabel_5080Parser() {
		if(initialNodeLabel_5080Parser == null) {
			initialNodeLabel_5080Parser = new AppliedStereotypeParser();
		}
		return initialNodeLabel_5080Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser activityFinalNodeLabel_5081Parser;

	/**
	 * @generated
	 */
	private IParser getActivityFinalNodeLabel_5081Parser() {
		if(activityFinalNodeLabel_5081Parser == null) {
			activityFinalNodeLabel_5081Parser = new AppliedStereotypeParser();
		}
		return activityFinalNodeLabel_5081Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser flowFinalNodeLabel_5082Parser;

	/**
	 * @generated
	 */
	private IParser getFlowFinalNodeLabel_5082Parser() {
		if(flowFinalNodeLabel_5082Parser == null) {
			flowFinalNodeLabel_5082Parser = new AppliedStereotypeParser();
		}
		return flowFinalNodeLabel_5082Parser;
	}

	/**
	 * @generated
	 */
	private IParser opaqueActionName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getOpaqueActionName_5003Parser() {
		if(opaqueActionName_5003Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			opaqueActionName_5003Parser = parser;
		}
		return opaqueActionName_5003Parser;
	}

	/**
	 * @generated
	 */
	private PinParser valuePinLabel_5011Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5011Parser() {
		if(valuePinLabel_5011Parser == null) {
			valuePinLabel_5011Parser = new PinParser();
		}
		return valuePinLabel_5011Parser;
	}

	/**
	 * @generated
	 */
	private PinValueParser valuePinLabel_5024Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5024Parser() {
		if(valuePinLabel_5024Parser == null) {
			valuePinLabel_5024Parser = new PinValueParser();
		}
		return valuePinLabel_5024Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser valuePinLabel_5083Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5083Parser() {
		if(valuePinLabel_5083Parser == null) {
			valuePinLabel_5083Parser = new AppliedStereotypeParser();
		}
		return valuePinLabel_5083Parser;
	}

	/**
	 * @generated
	 */
	private PinParser actionInputPinLabel_5012Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5012Parser() {
		if(actionInputPinLabel_5012Parser == null) {
			actionInputPinLabel_5012Parser = new PinParser();
		}
		return actionInputPinLabel_5012Parser;
	}

	/**
	 * @generated
	 */
	private PinValueParser actionInputPinLabel_5025Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5025Parser() {
		if(actionInputPinLabel_5025Parser == null) {
			actionInputPinLabel_5025Parser = new PinValueParser();
		}
		return actionInputPinLabel_5025Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser actionInputPinLabel_5084Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5084Parser() {
		if(actionInputPinLabel_5084Parser == null) {
			actionInputPinLabel_5084Parser = new AppliedStereotypeParser();
		}
		return actionInputPinLabel_5084Parser;
	}

	/**
	 * @generated
	 */
	private PinParser inputPinLabel_5009Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5009Parser() {
		if(inputPinLabel_5009Parser == null) {
			inputPinLabel_5009Parser = new PinParser();
		}
		return inputPinLabel_5009Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser inputPinLabel_5085Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5085Parser() {
		if(inputPinLabel_5085Parser == null) {
			inputPinLabel_5085Parser = new AppliedStereotypeParser();
		}
		return inputPinLabel_5085Parser;
	}

	/**
	 * @generated
	 */
	private PinParser outputPinLabel_5010Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5010Parser() {
		if(outputPinLabel_5010Parser == null) {
			outputPinLabel_5010Parser = new PinParser();
		}
		return outputPinLabel_5010Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser outputPinLabel_5086Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5086Parser() {
		if(outputPinLabel_5086Parser == null) {
			outputPinLabel_5086Parser = new AppliedStereotypeParser();
		}
		return outputPinLabel_5086Parser;
	}

	/**
	 * @generated
	 */
	private CallBehaviorActionParser callBehaviorActionLabel_5004Parser;

	/**
	 * @generated
	 */
	private IParser getCallBehaviorActionLabel_5004Parser() {
		if(callBehaviorActionLabel_5004Parser == null) {
			callBehaviorActionLabel_5004Parser = new CallBehaviorActionParser();
		}
		return callBehaviorActionLabel_5004Parser;
	}

	/**
	 * @generated
	 */
	private PinParser valuePinLabel_5013Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5013Parser() {
		if(valuePinLabel_5013Parser == null) {
			valuePinLabel_5013Parser = new PinParser();
		}
		return valuePinLabel_5013Parser;
	}

	/**
	 * @generated
	 */
	private PinValueParser valuePinLabel_5026Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5026Parser() {
		if(valuePinLabel_5026Parser == null) {
			valuePinLabel_5026Parser = new PinValueParser();
		}
		return valuePinLabel_5026Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser valuePinLabel_5087Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5087Parser() {
		if(valuePinLabel_5087Parser == null) {
			valuePinLabel_5087Parser = new AppliedStereotypeParser();
		}
		return valuePinLabel_5087Parser;
	}

	/**
	 * @generated
	 */
	private PinParser actionInputPinLabel_5014Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5014Parser() {
		if(actionInputPinLabel_5014Parser == null) {
			actionInputPinLabel_5014Parser = new PinParser();
		}
		return actionInputPinLabel_5014Parser;
	}

	/**
	 * @generated
	 */
	private PinValueParser actionInputPinLabel_5027Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5027Parser() {
		if(actionInputPinLabel_5027Parser == null) {
			actionInputPinLabel_5027Parser = new PinValueParser();
		}
		return actionInputPinLabel_5027Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser actionInputPinLabel_5088Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5088Parser() {
		if(actionInputPinLabel_5088Parser == null) {
			actionInputPinLabel_5088Parser = new AppliedStereotypeParser();
		}
		return actionInputPinLabel_5088Parser;
	}

	/**
	 * @generated
	 */
	private PinParser inputPinLabel_5015Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5015Parser() {
		if(inputPinLabel_5015Parser == null) {
			inputPinLabel_5015Parser = new PinParser();
		}
		return inputPinLabel_5015Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser inputPinLabel_5089Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5089Parser() {
		if(inputPinLabel_5089Parser == null) {
			inputPinLabel_5089Parser = new AppliedStereotypeParser();
		}
		return inputPinLabel_5089Parser;
	}

	/**
	 * @generated
	 */
	private PinParser outputPinLabel_5016Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5016Parser() {
		if(outputPinLabel_5016Parser == null) {
			outputPinLabel_5016Parser = new PinParser();
		}
		return outputPinLabel_5016Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser outputPinLabel_5090Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5090Parser() {
		if(outputPinLabel_5090Parser == null) {
			outputPinLabel_5090Parser = new AppliedStereotypeParser();
		}
		return outputPinLabel_5090Parser;
	}

	/**
	 * @generated
	 */
	private CallOperationActionParser callOperationActionLabel_5006Parser;

	/**
	 * @generated
	 */
	private IParser getCallOperationActionLabel_5006Parser() {
		if(callOperationActionLabel_5006Parser == null) {
			callOperationActionLabel_5006Parser = new CallOperationActionParser();
		}
		return callOperationActionLabel_5006Parser;
	}

	/**
	 * @generated
	 */
	private PinParser actionInputPinLabel_5017Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5017Parser() {
		if(actionInputPinLabel_5017Parser == null) {
			actionInputPinLabel_5017Parser = new PinParser();
		}
		return actionInputPinLabel_5017Parser;
	}

	/**
	 * @generated
	 */
	private PinValueParser actionInputPinLabel_5028Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5028Parser() {
		if(actionInputPinLabel_5028Parser == null) {
			actionInputPinLabel_5028Parser = new PinValueParser();
		}
		return actionInputPinLabel_5028Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser actionInputPinLabel_5091Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5091Parser() {
		if(actionInputPinLabel_5091Parser == null) {
			actionInputPinLabel_5091Parser = new AppliedStereotypeParser();
		}
		return actionInputPinLabel_5091Parser;
	}

	/**
	 * @generated
	 */
	private PinParser valuePinLabel_5018Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5018Parser() {
		if(valuePinLabel_5018Parser == null) {
			valuePinLabel_5018Parser = new PinParser();
		}
		return valuePinLabel_5018Parser;
	}

	/**
	 * @generated
	 */
	private PinValueParser valuePinLabel_5029Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5029Parser() {
		if(valuePinLabel_5029Parser == null) {
			valuePinLabel_5029Parser = new PinValueParser();
		}
		return valuePinLabel_5029Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser valuePinLabel_5092Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5092Parser() {
		if(valuePinLabel_5092Parser == null) {
			valuePinLabel_5092Parser = new AppliedStereotypeParser();
		}
		return valuePinLabel_5092Parser;
	}

	/**
	 * @generated
	 */
	private PinParser inputPinLabel_5019Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5019Parser() {
		if(inputPinLabel_5019Parser == null) {
			inputPinLabel_5019Parser = new PinParser();
		}
		return inputPinLabel_5019Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser inputPinLabel_5093Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5093Parser() {
		if(inputPinLabel_5093Parser == null) {
			inputPinLabel_5093Parser = new AppliedStereotypeParser();
		}
		return inputPinLabel_5093Parser;
	}

	/**
	 * @generated
	 */
	private PinParser outputPinLabel_5020Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5020Parser() {
		if(outputPinLabel_5020Parser == null) {
			outputPinLabel_5020Parser = new PinParser();
		}
		return outputPinLabel_5020Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser outputPinLabel_5094Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5094Parser() {
		if(outputPinLabel_5094Parser == null) {
			outputPinLabel_5094Parser = new AppliedStereotypeParser();
		}
		return outputPinLabel_5094Parser;
	}

	/**
	 * @generated
	 */
	private PinParser valuePinLabel_5021Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5021Parser() {
		if(valuePinLabel_5021Parser == null) {
			valuePinLabel_5021Parser = new PinParser();
		}
		return valuePinLabel_5021Parser;
	}

	/**
	 * @generated
	 */
	private PinValueParser valuePinLabel_5030Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5030Parser() {
		if(valuePinLabel_5030Parser == null) {
			valuePinLabel_5030Parser = new PinValueParser();
		}
		return valuePinLabel_5030Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser valuePinLabel_5095Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5095Parser() {
		if(valuePinLabel_5095Parser == null) {
			valuePinLabel_5095Parser = new AppliedStereotypeParser();
		}
		return valuePinLabel_5095Parser;
	}

	/**
	 * @generated
	 */
	private PinParser actionInputPinLabel_5022Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5022Parser() {
		if(actionInputPinLabel_5022Parser == null) {
			actionInputPinLabel_5022Parser = new PinParser();
		}
		return actionInputPinLabel_5022Parser;
	}

	/**
	 * @generated
	 */
	private PinValueParser actionInputPinLabel_5031Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5031Parser() {
		if(actionInputPinLabel_5031Parser == null) {
			actionInputPinLabel_5031Parser = new PinValueParser();
		}
		return actionInputPinLabel_5031Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser actionInputPinLabel_5096Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5096Parser() {
		if(actionInputPinLabel_5096Parser == null) {
			actionInputPinLabel_5096Parser = new AppliedStereotypeParser();
		}
		return actionInputPinLabel_5096Parser;
	}

	/**
	 * @generated
	 */
	private PinParser inputPinLabel_5023Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5023Parser() {
		if(inputPinLabel_5023Parser == null) {
			inputPinLabel_5023Parser = new PinParser();
		}
		return inputPinLabel_5023Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser inputPinLabel_5097Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5097Parser() {
		if(inputPinLabel_5097Parser == null) {
			inputPinLabel_5097Parser = new AppliedStereotypeParser();
		}
		return inputPinLabel_5097Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_5007Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_5007Parser() {
		if(constraintName_5007Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintName_5007Parser = parser;
		}
		return constraintName_5007Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser constraintLabel_5136Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintLabel_5136Parser() {
		if(constraintLabel_5136Parser == null) {
			constraintLabel_5136Parser = new ConstraintParser();
		}
		return constraintLabel_5136Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_5008Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_5008Parser() {
		if(constraintName_5008Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintName_5008Parser = parser;
		}
		return constraintName_5008Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser constraintLabel_5137Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintLabel_5137Parser() {
		if(constraintLabel_5137Parser == null) {
			constraintLabel_5137Parser = new ConstraintParser();
		}
		return constraintLabel_5137Parser;
	}

	/**
	 * @generated
	 */
	private InputDecisionParser decisionNodeLabel_5043Parser;

	/**
	 * @generated
	 */
	private IParser getDecisionNodeLabel_5043Parser() {
		if(decisionNodeLabel_5043Parser == null) {
			decisionNodeLabel_5043Parser = new InputDecisionParser();
		}
		return decisionNodeLabel_5043Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser decisionNodeLabel_5098Parser;

	/**
	 * @generated
	 */
	private IParser getDecisionNodeLabel_5098Parser() {
		if(decisionNodeLabel_5098Parser == null) {
			decisionNodeLabel_5098Parser = new AppliedStereotypeParser();
		}
		return decisionNodeLabel_5098Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser mergeNodeLabel_5099Parser;

	/**
	 * @generated
	 */
	private IParser getMergeNodeLabel_5099Parser() {
		if(mergeNodeLabel_5099Parser == null) {
			mergeNodeLabel_5099Parser = new AppliedStereotypeParser();
		}
		return mergeNodeLabel_5099Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser forkNodeLabel_5100Parser;

	/**
	 * @generated
	 */
	private IParser getForkNodeLabel_5100Parser() {
		if(forkNodeLabel_5100Parser == null) {
			forkNodeLabel_5100Parser = new AppliedStereotypeParser();
		}
		return forkNodeLabel_5100Parser;
	}

	/**
	 * @generated
	 */
	private JoinSpecParser joinNodeLabel_5042Parser;

	/**
	 * @generated
	 */
	private IParser getJoinNodeLabel_5042Parser() {
		if(joinNodeLabel_5042Parser == null) {
			joinNodeLabel_5042Parser = new JoinSpecParser();
		}
		return joinNodeLabel_5042Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser joinNodeLabel_5101Parser;

	/**
	 * @generated
	 */
	private IParser getJoinNodeLabel_5101Parser() {
		if(joinNodeLabel_5101Parser == null) {
			joinNodeLabel_5101Parser = new AppliedStereotypeParser();
		}
		return joinNodeLabel_5101Parser;
	}

	/**
	 * @generated
	 */
	private IParser sendObjectActionName_5059Parser;

	/**
	 * @generated
	 */
	private IParser getSendObjectActionName_5059Parser() {
		if(sendObjectActionName_5059Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			sendObjectActionName_5059Parser = parser;
		}
		return sendObjectActionName_5059Parser;
	}

	/**
	 * @generated
	 */
	private PinParser valuePinLabel_5049Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5049Parser() {
		if(valuePinLabel_5049Parser == null) {
			valuePinLabel_5049Parser = new PinParser();
		}
		return valuePinLabel_5049Parser;
	}

	/**
	 * @generated
	 */
	private PinValueParser valuePinLabel_5050Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5050Parser() {
		if(valuePinLabel_5050Parser == null) {
			valuePinLabel_5050Parser = new PinValueParser();
		}
		return valuePinLabel_5050Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser valuePinLabel_5102Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5102Parser() {
		if(valuePinLabel_5102Parser == null) {
			valuePinLabel_5102Parser = new AppliedStereotypeParser();
		}
		return valuePinLabel_5102Parser;
	}

	/**
	 * @generated
	 */
	private PinParser actionInputPinLabel_5051Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5051Parser() {
		if(actionInputPinLabel_5051Parser == null) {
			actionInputPinLabel_5051Parser = new PinParser();
		}
		return actionInputPinLabel_5051Parser;
	}

	/**
	 * @generated
	 */
	private PinValueParser actionInputPinLabel_5052Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5052Parser() {
		if(actionInputPinLabel_5052Parser == null) {
			actionInputPinLabel_5052Parser = new PinValueParser();
		}
		return actionInputPinLabel_5052Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser actionInputPinLabel_5103Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5103Parser() {
		if(actionInputPinLabel_5103Parser == null) {
			actionInputPinLabel_5103Parser = new AppliedStereotypeParser();
		}
		return actionInputPinLabel_5103Parser;
	}

	/**
	 * @generated
	 */
	private PinParser inputPinLabel_5053Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5053Parser() {
		if(inputPinLabel_5053Parser == null) {
			inputPinLabel_5053Parser = new PinParser();
		}
		return inputPinLabel_5053Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser inputPinLabel_5104Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5104Parser() {
		if(inputPinLabel_5104Parser == null) {
			inputPinLabel_5104Parser = new AppliedStereotypeParser();
		}
		return inputPinLabel_5104Parser;
	}

	/**
	 * @generated
	 */
	private PinParser valuePinLabel_5054Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5054Parser() {
		if(valuePinLabel_5054Parser == null) {
			valuePinLabel_5054Parser = new PinParser();
		}
		return valuePinLabel_5054Parser;
	}

	/**
	 * @generated
	 */
	private PinValueParser valuePinLabel_5055Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5055Parser() {
		if(valuePinLabel_5055Parser == null) {
			valuePinLabel_5055Parser = new PinValueParser();
		}
		return valuePinLabel_5055Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser valuePinLabel_5105Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5105Parser() {
		if(valuePinLabel_5105Parser == null) {
			valuePinLabel_5105Parser = new AppliedStereotypeParser();
		}
		return valuePinLabel_5105Parser;
	}

	/**
	 * @generated
	 */
	private PinParser actionInputPinLabel_5056Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5056Parser() {
		if(actionInputPinLabel_5056Parser == null) {
			actionInputPinLabel_5056Parser = new PinParser();
		}
		return actionInputPinLabel_5056Parser;
	}

	/**
	 * @generated
	 */
	private PinValueParser actionInputPinLabel_5057Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5057Parser() {
		if(actionInputPinLabel_5057Parser == null) {
			actionInputPinLabel_5057Parser = new PinValueParser();
		}
		return actionInputPinLabel_5057Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser actionInputPinLabel_5106Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5106Parser() {
		if(actionInputPinLabel_5106Parser == null) {
			actionInputPinLabel_5106Parser = new AppliedStereotypeParser();
		}
		return actionInputPinLabel_5106Parser;
	}

	/**
	 * @generated
	 */
	private PinParser inputPinLabel_5058Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5058Parser() {
		if(inputPinLabel_5058Parser == null) {
			inputPinLabel_5058Parser = new PinParser();
		}
		return inputPinLabel_5058Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser inputPinLabel_5107Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5107Parser() {
		if(inputPinLabel_5107Parser == null) {
			inputPinLabel_5107Parser = new AppliedStereotypeParser();
		}
		return inputPinLabel_5107Parser;
	}

	/**
	 * @generated
	 */
	private IParser sendSignalActionName_5060Parser;

	/**
	 * @generated
	 */
	private IParser getSendSignalActionName_5060Parser() {
		if(sendSignalActionName_5060Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			sendSignalActionName_5060Parser = parser;
		}
		return sendSignalActionName_5060Parser;
	}

	/**
	 * @generated
	 */
	private PinParser actionInputPinLabel_5061Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5061Parser() {
		if(actionInputPinLabel_5061Parser == null) {
			actionInputPinLabel_5061Parser = new PinParser();
		}
		return actionInputPinLabel_5061Parser;
	}

	/**
	 * @generated
	 */
	private PinValueParser actionInputPinLabel_5062Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5062Parser() {
		if(actionInputPinLabel_5062Parser == null) {
			actionInputPinLabel_5062Parser = new PinValueParser();
		}
		return actionInputPinLabel_5062Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser actionInputPinLabel_5108Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5108Parser() {
		if(actionInputPinLabel_5108Parser == null) {
			actionInputPinLabel_5108Parser = new AppliedStereotypeParser();
		}
		return actionInputPinLabel_5108Parser;
	}

	/**
	 * @generated
	 */
	private PinParser valuePinLabel_5063Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5063Parser() {
		if(valuePinLabel_5063Parser == null) {
			valuePinLabel_5063Parser = new PinParser();
		}
		return valuePinLabel_5063Parser;
	}

	/**
	 * @generated
	 */
	private PinValueParser valuePinLabel_5064Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5064Parser() {
		if(valuePinLabel_5064Parser == null) {
			valuePinLabel_5064Parser = new PinValueParser();
		}
		return valuePinLabel_5064Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser valuePinLabel_5109Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5109Parser() {
		if(valuePinLabel_5109Parser == null) {
			valuePinLabel_5109Parser = new AppliedStereotypeParser();
		}
		return valuePinLabel_5109Parser;
	}

	/**
	 * @generated
	 */
	private PinParser inputPinLabel_5065Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5065Parser() {
		if(inputPinLabel_5065Parser == null) {
			inputPinLabel_5065Parser = new PinParser();
		}
		return inputPinLabel_5065Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser inputPinLabel_5110Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5110Parser() {
		if(inputPinLabel_5110Parser == null) {
			inputPinLabel_5110Parser = new AppliedStereotypeParser();
		}
		return inputPinLabel_5110Parser;
	}

	/**
	 * @generated
	 */
	private PinParser valuePinLabel_5072Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5072Parser() {
		if(valuePinLabel_5072Parser == null) {
			valuePinLabel_5072Parser = new PinParser();
		}
		return valuePinLabel_5072Parser;
	}

	/**
	 * @generated
	 */
	private PinValueParser valuePinLabel_5073Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5073Parser() {
		if(valuePinLabel_5073Parser == null) {
			valuePinLabel_5073Parser = new PinValueParser();
		}
		return valuePinLabel_5073Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser valuePinLabel_5111Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinLabel_5111Parser() {
		if(valuePinLabel_5111Parser == null) {
			valuePinLabel_5111Parser = new AppliedStereotypeParser();
		}
		return valuePinLabel_5111Parser;
	}

	/**
	 * @generated
	 */
	private PinParser actionInputPinLabel_5074Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5074Parser() {
		if(actionInputPinLabel_5074Parser == null) {
			actionInputPinLabel_5074Parser = new PinParser();
		}
		return actionInputPinLabel_5074Parser;
	}

	/**
	 * @generated
	 */
	private PinValueParser actionInputPinLabel_5075Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5075Parser() {
		if(actionInputPinLabel_5075Parser == null) {
			actionInputPinLabel_5075Parser = new PinValueParser();
		}
		return actionInputPinLabel_5075Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser actionInputPinLabel_5112Parser;

	/**
	 * @generated
	 */
	private IParser getActionInputPinLabel_5112Parser() {
		if(actionInputPinLabel_5112Parser == null) {
			actionInputPinLabel_5112Parser = new AppliedStereotypeParser();
		}
		return actionInputPinLabel_5112Parser;
	}

	/**
	 * @generated
	 */
	private PinParser inputPinLabel_5076Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5076Parser() {
		if(inputPinLabel_5076Parser == null) {
			inputPinLabel_5076Parser = new PinParser();
		}
		return inputPinLabel_5076Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser inputPinLabel_5113Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5113Parser() {
		if(inputPinLabel_5113Parser == null) {
			inputPinLabel_5113Parser = new AppliedStereotypeParser();
		}
		return inputPinLabel_5113Parser;
	}

	/**
	 * @generated
	 */
	private ActivityParameterNodeParser activityParameterNodeLabel_5071Parser;

	/**
	 * @generated
	 */
	private IParser getActivityParameterNodeLabel_5071Parser() {
		if(activityParameterNodeLabel_5071Parser == null) {
			activityParameterNodeLabel_5071Parser = new ActivityParameterNodeParser();
		}
		return activityParameterNodeLabel_5071Parser;
	}

	/**
	 * @generated
	 */
	private AcceptEventActionParser acceptEventActionLabel_5078Parser;

	/**
	 * @generated
	 */
	private IParser getAcceptEventActionLabel_5078Parser() {
		if(acceptEventActionLabel_5078Parser == null) {
			acceptEventActionLabel_5078Parser = new AcceptEventActionParser();
		}
		return acceptEventActionLabel_5078Parser;
	}

	/**
	 * @generated
	 */
	private AcceptTimeEventActionParser acceptEventActionLabel_5079Parser;

	/**
	 * @generated
	 */
	private IParser getAcceptEventActionLabel_5079Parser() {
		if(acceptEventActionLabel_5079Parser == null) {
			acceptEventActionLabel_5079Parser = new AcceptTimeEventActionParser();
		}
		return acceptEventActionLabel_5079Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser acceptEventActionLabel_5115Parser;

	/**
	 * @generated
	 */
	private IParser getAcceptEventActionLabel_5115Parser() {
		if(acceptEventActionLabel_5115Parser == null) {
			acceptEventActionLabel_5115Parser = new AppliedStereotypeParser();
		}
		return acceptEventActionLabel_5115Parser;
	}

	/**
	 * @generated
	 */
	private PinParser outputPinLabel_5077Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5077Parser() {
		if(outputPinLabel_5077Parser == null) {
			outputPinLabel_5077Parser = new PinParser();
		}
		return outputPinLabel_5077Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser outputPinLabel_5114Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5114Parser() {
		if(outputPinLabel_5114Parser == null) {
			outputPinLabel_5114Parser = new AppliedStereotypeParser();
		}
		return outputPinLabel_5114Parser;
	}

	/**
	 * @generated
	 */
	private StructuredActivityNodeKeywordParser structuredActivityNodeLabel_5117Parser;

	/**
	 * @generated
	 */
	private IParser getStructuredActivityNodeLabel_5117Parser() {
		if(structuredActivityNodeLabel_5117Parser == null) {
			structuredActivityNodeLabel_5117Parser = new StructuredActivityNodeKeywordParser();
		}
		return structuredActivityNodeLabel_5117Parser;
	}

	/**
	 * @generated
	 */
	private PinParser inputPinLabel_5178Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5178Parser() {
		if(inputPinLabel_5178Parser == null) {
			inputPinLabel_5178Parser = new PinParser();
		}
		return inputPinLabel_5178Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser inputPinLabel_5179Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5179Parser() {
		if(inputPinLabel_5179Parser == null) {
			inputPinLabel_5179Parser = new AppliedStereotypeParser();
		}
		return inputPinLabel_5179Parser;
	}

	/**
	 * @generated
	 */
	private IParser activityPartitionName_5118Parser;

	/**
	 * @generated
	 */
	private IParser getActivityPartitionName_5118Parser() {
		if(activityPartitionName_5118Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			activityPartitionName_5118Parser = parser;
		}
		return activityPartitionName_5118Parser;
	}

	/**
	 * @generated
	 */
	private ActivitySingleExecutionParser namedElementName_5129Parser;

	/**
	 * @generated
	 */
	private IParser getNamedElementName_5129Parser() {
		if(namedElementName_5129Parser == null) {
			namedElementName_5129Parser = new ActivitySingleExecutionParser();
		}
		return namedElementName_5129Parser;
	}

	/**
	 * @generated
	 */
	private IParser createObjectActionName_5148Parser;

	/**
	 * @generated
	 */
	private IParser getCreateObjectActionName_5148Parser() {
		if(createObjectActionName_5148Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			createObjectActionName_5148Parser = parser;
		}
		return createObjectActionName_5148Parser;
	}

	/**
	 * @generated
	 */
	private PinParser outputPinLabel_5146Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5146Parser() {
		if(outputPinLabel_5146Parser == null) {
			outputPinLabel_5146Parser = new PinParser();
		}
		return outputPinLabel_5146Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser outputPinLabel_5147Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5147Parser() {
		if(outputPinLabel_5147Parser == null) {
			outputPinLabel_5147Parser = new AppliedStereotypeParser();
		}
		return outputPinLabel_5147Parser;
	}

	/**
	 * @generated
	 */
	private IParser readStructuralFeatureActionName_5153Parser;

	/**
	 * @generated
	 */
	private IParser getReadStructuralFeatureActionName_5153Parser() {
		if(readStructuralFeatureActionName_5153Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			readStructuralFeatureActionName_5153Parser = parser;
		}
		return readStructuralFeatureActionName_5153Parser;
	}

	/**
	 * @generated
	 */
	private PinParser inputPinLabel_5149Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5149Parser() {
		if(inputPinLabel_5149Parser == null) {
			inputPinLabel_5149Parser = new PinParser();
		}
		return inputPinLabel_5149Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser inputPinLabel_5150Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5150Parser() {
		if(inputPinLabel_5150Parser == null) {
			inputPinLabel_5150Parser = new AppliedStereotypeParser();
		}
		return inputPinLabel_5150Parser;
	}

	/**
	 * @generated
	 */
	private PinParser outputPinLabel_5151Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5151Parser() {
		if(outputPinLabel_5151Parser == null) {
			outputPinLabel_5151Parser = new PinParser();
		}
		return outputPinLabel_5151Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser outputPinLabel_5152Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5152Parser() {
		if(outputPinLabel_5152Parser == null) {
			outputPinLabel_5152Parser = new AppliedStereotypeParser();
		}
		return outputPinLabel_5152Parser;
	}

	/**
	 * @generated
	 */
	private IParser addStructuralFeatureValueActionName_5160Parser;

	/**
	 * @generated
	 */
	private IParser getAddStructuralFeatureValueActionName_5160Parser() {
		if(addStructuralFeatureValueActionName_5160Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			addStructuralFeatureValueActionName_5160Parser = parser;
		}
		return addStructuralFeatureValueActionName_5160Parser;
	}

	/**
	 * @generated
	 */
	private PinParser inputPinLabel_5154Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5154Parser() {
		if(inputPinLabel_5154Parser == null) {
			inputPinLabel_5154Parser = new PinParser();
		}
		return inputPinLabel_5154Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser inputPinLabel_5155Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5155Parser() {
		if(inputPinLabel_5155Parser == null) {
			inputPinLabel_5155Parser = new AppliedStereotypeParser();
		}
		return inputPinLabel_5155Parser;
	}

	/**
	 * @generated
	 */
	private PinParser inputPinLabel_5156Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5156Parser() {
		if(inputPinLabel_5156Parser == null) {
			inputPinLabel_5156Parser = new PinParser();
		}
		return inputPinLabel_5156Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser inputPinLabel_5157Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5157Parser() {
		if(inputPinLabel_5157Parser == null) {
			inputPinLabel_5157Parser = new AppliedStereotypeParser();
		}
		return inputPinLabel_5157Parser;
	}

	/**
	 * @generated
	 */
	private PinParser outputPinLabel_5158Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5158Parser() {
		if(outputPinLabel_5158Parser == null) {
			outputPinLabel_5158Parser = new PinParser();
		}
		return outputPinLabel_5158Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser outputPinLabel_5159Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5159Parser() {
		if(outputPinLabel_5159Parser == null) {
			outputPinLabel_5159Parser = new AppliedStereotypeParser();
		}
		return outputPinLabel_5159Parser;
	}

	/**
	 * @generated
	 */
	private IParser destroyObjectActionName_5163Parser;

	/**
	 * @generated
	 */
	private IParser getDestroyObjectActionName_5163Parser() {
		if(destroyObjectActionName_5163Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			destroyObjectActionName_5163Parser = parser;
		}
		return destroyObjectActionName_5163Parser;
	}

	/**
	 * @generated
	 */
	private PinParser inputPinLabel_5161Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5161Parser() {
		if(inputPinLabel_5161Parser == null) {
			inputPinLabel_5161Parser = new PinParser();
		}
		return inputPinLabel_5161Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser inputPinLabel_5162Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5162Parser() {
		if(inputPinLabel_5162Parser == null) {
			inputPinLabel_5162Parser = new AppliedStereotypeParser();
		}
		return inputPinLabel_5162Parser;
	}

	/**
	 * @generated
	 */
	private IParser readVariableActionName_5166Parser;

	/**
	 * @generated
	 */
	private IParser getReadVariableActionName_5166Parser() {
		if(readVariableActionName_5166Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			readVariableActionName_5166Parser = parser;
		}
		return readVariableActionName_5166Parser;
	}

	/**
	 * @generated
	 */
	private PinParser outputPinLabel_5164Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5164Parser() {
		if(outputPinLabel_5164Parser == null) {
			outputPinLabel_5164Parser = new PinParser();
		}
		return outputPinLabel_5164Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser outputPinLabel_5165Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5165Parser() {
		if(outputPinLabel_5165Parser == null) {
			outputPinLabel_5165Parser = new AppliedStereotypeParser();
		}
		return outputPinLabel_5165Parser;
	}

	/**
	 * @generated
	 */
	private IParser addVariableValueActionName_5171Parser;

	/**
	 * @generated
	 */
	private IParser getAddVariableValueActionName_5171Parser() {
		if(addVariableValueActionName_5171Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			addVariableValueActionName_5171Parser = parser;
		}
		return addVariableValueActionName_5171Parser;
	}

	/**
	 * @generated
	 */
	private PinParser inputPinLabel_5167Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5167Parser() {
		if(inputPinLabel_5167Parser == null) {
			inputPinLabel_5167Parser = new PinParser();
		}
		return inputPinLabel_5167Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser inputPinLabel_5168Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5168Parser() {
		if(inputPinLabel_5168Parser == null) {
			inputPinLabel_5168Parser = new AppliedStereotypeParser();
		}
		return inputPinLabel_5168Parser;
	}

	/**
	 * @generated
	 */
	private PinParser inputPinLabel_5169Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5169Parser() {
		if(inputPinLabel_5169Parser == null) {
			inputPinLabel_5169Parser = new PinParser();
		}
		return inputPinLabel_5169Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser inputPinLabel_5170Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5170Parser() {
		if(inputPinLabel_5170Parser == null) {
			inputPinLabel_5170Parser = new AppliedStereotypeParser();
		}
		return inputPinLabel_5170Parser;
	}

	/**
	 * @generated
	 */
	private IParser broadcastSignalActionName_5175Parser;

	/**
	 * @generated
	 */
	private IParser getBroadcastSignalActionName_5175Parser() {
		if(broadcastSignalActionName_5175Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			broadcastSignalActionName_5175Parser = parser;
		}
		return broadcastSignalActionName_5175Parser;
	}

	/**
	 * @generated
	 */
	private PinParser inputPinLabel_5172Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5172Parser() {
		if(inputPinLabel_5172Parser == null) {
			inputPinLabel_5172Parser = new PinParser();
		}
		return inputPinLabel_5172Parser;
	}

	/**
	 * @generated
	 */
	private PinValueParser inputPinLabel_5173Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5173Parser() {
		if(inputPinLabel_5173Parser == null) {
			inputPinLabel_5173Parser = new PinValueParser();
		}
		return inputPinLabel_5173Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser inputPinLabel_5174Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinLabel_5174Parser() {
		if(inputPinLabel_5174Parser == null) {
			inputPinLabel_5174Parser = new AppliedStereotypeParser();
		}
		return inputPinLabel_5174Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeParser centralBufferNodeLabel_5176Parser;

	/**
	 * @generated
	 */
	private IParser getCentralBufferNodeLabel_5176Parser() {
		if(centralBufferNodeLabel_5176Parser == null) {
			centralBufferNodeLabel_5176Parser = new ObjectNodeParser();
		}
		return centralBufferNodeLabel_5176Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeSelectionParser centralBufferNodeLabel_5177Parser;

	/**
	 * @generated
	 */
	private IParser getCentralBufferNodeLabel_5177Parser() {
		if(centralBufferNodeLabel_5177Parser == null) {
			centralBufferNodeLabel_5177Parser = new ObjectNodeSelectionParser();
		}
		return centralBufferNodeLabel_5177Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_5189Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_5189Parser() {
		if(constraintName_5189Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintName_5189Parser = parser;
		}
		return constraintName_5189Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser constraintSpecification_5190Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintSpecification_5190Parser() {
		if(constraintSpecification_5190Parser == null) {
			constraintSpecification_5190Parser = new ConstraintParser();
		}
		return constraintSpecification_5190Parser;
	}

	/**
	 * @generated
	 */
	private CommentParser commentBody_5138Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_5138Parser() {
		if(commentBody_5138Parser == null) {
			commentBody_5138Parser = new CommentParser();
		}
		return commentBody_5138Parser;
	}

	/**
	 * @generated
	 */
	private IParser readSelfActionName_5139Parser;

	/**
	 * @generated
	 */
	private IParser getReadSelfActionName_5139Parser() {
		if(readSelfActionName_5139Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			readSelfActionName_5139Parser = parser;
		}
		return readSelfActionName_5139Parser;
	}

	/**
	 * @generated
	 */
	private PinParser outputPinLabel_5144Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5144Parser() {
		if(outputPinLabel_5144Parser == null) {
			outputPinLabel_5144Parser = new PinParser();
		}
		return outputPinLabel_5144Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser outputPinLabel_5145Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5145Parser() {
		if(outputPinLabel_5145Parser == null) {
			outputPinLabel_5145Parser = new AppliedStereotypeParser();
		}
		return outputPinLabel_5145Parser;
	}

	/**
	 * @generated
	 */
	private IParser activityName_5142Parser;

	/**
	 * @generated
	 */
	private IParser getActivityName_5142Parser() {
		if(activityName_5142Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			activityName_5142Parser = parser;
		}
		return activityName_5142Parser;
	}

	/**
	 * @generated
	 */
	private ActivitySingleExecutionParser activityIsSingleExecution_5143Parser;

	/**
	 * @generated
	 */
	private IParser getActivityIsSingleExecution_5143Parser() {
		if(activityIsSingleExecution_5143Parser == null) {
			activityIsSingleExecution_5143Parser = new ActivitySingleExecutionParser();
		}
		return activityIsSingleExecution_5143Parser;
	}

	/**
	 * @generated
	 */
	private IParser valueSpecificationActionName_5126Parser;

	/**
	 * @generated
	 */
	private IParser getValueSpecificationActionName_5126Parser() {
		if(valueSpecificationActionName_5126Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			valueSpecificationActionName_5126Parser = parser;
		}
		return valueSpecificationActionName_5126Parser;
	}

	/**
	 * @generated
	 */
	private PinParser outputPinLabel_5124Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5124Parser() {
		if(outputPinLabel_5124Parser == null) {
			outputPinLabel_5124Parser = new PinParser();
		}
		return outputPinLabel_5124Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser outputPinLabel_5125Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5125Parser() {
		if(outputPinLabel_5125Parser == null) {
			outputPinLabel_5125Parser = new AppliedStereotypeParser();
		}
		return outputPinLabel_5125Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeParser dataStoreNodeLabel_5127Parser;

	/**
	 * @generated
	 */
	private IParser getDataStoreNodeLabel_5127Parser() {
		if(dataStoreNodeLabel_5127Parser == null) {
			dataStoreNodeLabel_5127Parser = new ObjectNodeParser();
		}
		return dataStoreNodeLabel_5127Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeSelectionParser dataStoreNodeLabel_5128Parser;

	/**
	 * @generated
	 */
	private IParser getDataStoreNodeLabel_5128Parser() {
		if(dataStoreNodeLabel_5128Parser == null) {
			dataStoreNodeLabel_5128Parser = new ObjectNodeSelectionParser();
		}
		return dataStoreNodeLabel_5128Parser;
	}

	/**
	 * @generated
	 */
	private StructuredActivityNodeKeywordParser conditionalNodeLabel_5119Parser;

	/**
	 * @generated
	 */
	private IParser getConditionalNodeLabel_5119Parser() {
		if(conditionalNodeLabel_5119Parser == null) {
			conditionalNodeLabel_5119Parser = new StructuredActivityNodeKeywordParser();
		}
		return conditionalNodeLabel_5119Parser;
	}

	/**
	 * @generated
	 */
	private StructuredActivityNodeKeywordParser expansionRegionLabel_5120Parser;

	/**
	 * @generated
	 */
	private IParser getExpansionRegionLabel_5120Parser() {
		if(expansionRegionLabel_5120Parser == null) {
			expansionRegionLabel_5120Parser = new StructuredActivityNodeKeywordParser();
		}
		return expansionRegionLabel_5120Parser;
	}

	/**
	 * @generated
	 */
	private StructuredActivityNodeKeywordParser loopNodeLabel_5121Parser;

	/**
	 * @generated
	 */
	private IParser getLoopNodeLabel_5121Parser() {
		if(loopNodeLabel_5121Parser == null) {
			loopNodeLabel_5121Parser = new StructuredActivityNodeKeywordParser();
		}
		return loopNodeLabel_5121Parser;
	}

	/**
	 * @generated
	 */
	private PinParser outputPinLabel_5184Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5184Parser() {
		if(outputPinLabel_5184Parser == null) {
			outputPinLabel_5184Parser = new PinParser();
		}
		return outputPinLabel_5184Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser outputPinLabel_5185Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5185Parser() {
		if(outputPinLabel_5185Parser == null) {
			outputPinLabel_5185Parser = new AppliedStereotypeParser();
		}
		return outputPinLabel_5185Parser;
	}

	/**
	 * @generated
	 */
	private PinParser outputPinLabel_5186Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5186Parser() {
		if(outputPinLabel_5186Parser == null) {
			outputPinLabel_5186Parser = new PinParser();
		}
		return outputPinLabel_5186Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser outputPinLabel_5183Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5183Parser() {
		if(outputPinLabel_5183Parser == null) {
			outputPinLabel_5183Parser = new AppliedStereotypeParser();
		}
		return outputPinLabel_5183Parser;
	}

	/**
	 * @generated
	 */
	private PinParser outputPinLabel_5187Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5187Parser() {
		if(outputPinLabel_5187Parser == null) {
			outputPinLabel_5187Parser = new PinParser();
		}
		return outputPinLabel_5187Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser outputPinLabel_5188Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinLabel_5188Parser() {
		if(outputPinLabel_5188Parser == null) {
			outputPinLabel_5188Parser = new AppliedStereotypeParser();
		}
		return outputPinLabel_5188Parser;
	}

	/**
	 * @generated
	 */
	private StructuredActivityNodeKeywordParser sequenceNodeLabel_5123Parser;

	/**
	 * @generated
	 */
	private IParser getSequenceNodeLabel_5123Parser() {
		if(sequenceNodeLabel_5123Parser == null) {
			sequenceNodeLabel_5123Parser = new StructuredActivityNodeKeywordParser();
		}
		return sequenceNodeLabel_5123Parser;
	}

	/**
	 * @generated
	 */
	private IParser intervalConstraintName_5036Parser;

	/**
	 * @generated
	 */
	private IParser getIntervalConstraintName_5036Parser() {
		if(intervalConstraintName_5036Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			intervalConstraintName_5036Parser = parser;
		}
		return intervalConstraintName_5036Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser intervalConstraintLabel_5134Parser;

	/**
	 * @generated
	 */
	private IParser getIntervalConstraintLabel_5134Parser() {
		if(intervalConstraintLabel_5134Parser == null) {
			intervalConstraintLabel_5134Parser = new ConstraintParser();
		}
		return intervalConstraintLabel_5134Parser;
	}

	/**
	 * @generated
	 */
	private IParser intervalConstraintName_5037Parser;

	/**
	 * @generated
	 */
	private IParser getIntervalConstraintName_5037Parser() {
		if(intervalConstraintName_5037Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			intervalConstraintName_5037Parser = parser;
		}
		return intervalConstraintName_5037Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser intervalConstraintLabel_5135Parser;

	/**
	 * @generated
	 */
	private IParser getIntervalConstraintLabel_5135Parser() {
		if(intervalConstraintLabel_5135Parser == null) {
			intervalConstraintLabel_5135Parser = new ConstraintParser();
		}
		return intervalConstraintLabel_5135Parser;
	}

	/**
	 * @generated
	 */
	private IParser durationConstraintName_5038Parser;

	/**
	 * @generated
	 */
	private IParser getDurationConstraintName_5038Parser() {
		if(durationConstraintName_5038Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			durationConstraintName_5038Parser = parser;
		}
		return durationConstraintName_5038Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser durationConstraintLabel_5130Parser;

	/**
	 * @generated
	 */
	private IParser getDurationConstraintLabel_5130Parser() {
		if(durationConstraintLabel_5130Parser == null) {
			durationConstraintLabel_5130Parser = new ConstraintParser();
		}
		return durationConstraintLabel_5130Parser;
	}

	/**
	 * @generated
	 */
	private IParser durationConstraintName_5039Parser;

	/**
	 * @generated
	 */
	private IParser getDurationConstraintName_5039Parser() {
		if(durationConstraintName_5039Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			durationConstraintName_5039Parser = parser;
		}
		return durationConstraintName_5039Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser durationConstraintLabel_5131Parser;

	/**
	 * @generated
	 */
	private IParser getDurationConstraintLabel_5131Parser() {
		if(durationConstraintLabel_5131Parser == null) {
			durationConstraintLabel_5131Parser = new ConstraintParser();
		}
		return durationConstraintLabel_5131Parser;
	}

	/**
	 * @generated
	 */
	private IParser timeConstraintName_5040Parser;

	/**
	 * @generated
	 */
	private IParser getTimeConstraintName_5040Parser() {
		if(timeConstraintName_5040Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			timeConstraintName_5040Parser = parser;
		}
		return timeConstraintName_5040Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser timeConstraintLabel_5132Parser;

	/**
	 * @generated
	 */
	private IParser getTimeConstraintLabel_5132Parser() {
		if(timeConstraintLabel_5132Parser == null) {
			timeConstraintLabel_5132Parser = new ConstraintParser();
		}
		return timeConstraintLabel_5132Parser;
	}

	/**
	 * @generated
	 */
	private IParser timeConstraintName_5041Parser;

	/**
	 * @generated
	 */
	private IParser getTimeConstraintName_5041Parser() {
		if(timeConstraintName_5041Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			timeConstraintName_5041Parser = parser;
		}
		return timeConstraintName_5041Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser timeConstraintLabel_5133Parser;

	/**
	 * @generated
	 */
	private IParser getTimeConstraintLabel_5133Parser() {
		if(timeConstraintLabel_5133Parser == null) {
			timeConstraintLabel_5133Parser = new ConstraintParser();
		}
		return timeConstraintLabel_5133Parser;
	}

	/**
	 * @generated
	 */
	private IParser objectFlowName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getObjectFlowName_6001Parser() {
		if(objectFlowName_6001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			objectFlowName_6001Parser = parser;
		}
		return objectFlowName_6001Parser;
	}

	/**
	 * @generated
	 */
	private ActivityEdgeWeightParser objectFlowLabel_6002Parser;

	/**
	 * @generated
	 */
	private IParser getObjectFlowLabel_6002Parser() {
		if(objectFlowLabel_6002Parser == null) {
			objectFlowLabel_6002Parser = new ActivityEdgeWeightParser();
		}
		return objectFlowLabel_6002Parser;
	}

	/**
	 * @generated
	 */
	private ObjectFlowSelectionParser objectFlowLabel_6005Parser;

	/**
	 * @generated
	 */
	private IParser getObjectFlowLabel_6005Parser() {
		if(objectFlowLabel_6005Parser == null) {
			objectFlowLabel_6005Parser = new ObjectFlowSelectionParser();
		}
		return objectFlowLabel_6005Parser;
	}

	/**
	 * @generated
	 */
	private ObjectFlowTransformationParser objectFlowLabel_6006Parser;

	/**
	 * @generated
	 */
	private IParser getObjectFlowLabel_6006Parser() {
		if(objectFlowLabel_6006Parser == null) {
			objectFlowLabel_6006Parser = new ObjectFlowTransformationParser();
		}
		return objectFlowLabel_6006Parser;
	}

	/**
	 * @generated
	 */
	private DecisionInputFlowParser objectFlowLabel_6007Parser;

	/**
	 * @generated
	 */
	private IParser getObjectFlowLabel_6007Parser() {
		if(objectFlowLabel_6007Parser == null) {
			objectFlowLabel_6007Parser = new DecisionInputFlowParser();
		}
		return objectFlowLabel_6007Parser;
	}

	/**
	 * @generated
	 */
	private EdgeGuardParser objectFlowLabel_6008Parser;

	/**
	 * @generated
	 */
	private IParser getObjectFlowLabel_6008Parser() {
		if(objectFlowLabel_6008Parser == null) {
			objectFlowLabel_6008Parser = new EdgeGuardParser();
		}
		return objectFlowLabel_6008Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser objectFlowLabel_6010Parser;

	/**
	 * @generated
	 */
	private IParser getObjectFlowLabel_6010Parser() {
		if(objectFlowLabel_6010Parser == null) {
			objectFlowLabel_6010Parser = new AppliedStereotypeParser();
		}
		return objectFlowLabel_6010Parser;
	}

	/**
	 * @generated
	 */
	private IParser controlFlowName_6003Parser;

	/**
	 * @generated
	 */
	private IParser getControlFlowName_6003Parser() {
		if(controlFlowName_6003Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			controlFlowName_6003Parser = parser;
		}
		return controlFlowName_6003Parser;
	}

	/**
	 * @generated
	 */
	private ActivityEdgeWeightParser controlFlowLabel_6004Parser;

	/**
	 * @generated
	 */
	private IParser getControlFlowLabel_6004Parser() {
		if(controlFlowLabel_6004Parser == null) {
			controlFlowLabel_6004Parser = new ActivityEdgeWeightParser();
		}
		return controlFlowLabel_6004Parser;
	}

	/**
	 * @generated
	 */
	private EdgeGuardParser controlFlowLabel_6009Parser;

	/**
	 * @generated
	 */
	private IParser getControlFlowLabel_6009Parser() {
		if(controlFlowLabel_6009Parser == null) {
			controlFlowLabel_6009Parser = new EdgeGuardParser();
		}
		return controlFlowLabel_6009Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser controlFlowLabel_6011Parser;

	/**
	 * @generated
	 */
	private IParser getControlFlowLabel_6011Parser() {
		if(controlFlowLabel_6011Parser == null) {
			controlFlowLabel_6011Parser = new AppliedStereotypeParser();
		}
		return controlFlowLabel_6011Parser;
	}

	/**
	 * @generated
	 */
	private ExceptionHandlerTypeParser exceptionHandlerLabel_6012Parser;

	/**
	 * @generated
	 */
	private IParser getExceptionHandlerLabel_6012Parser() {
		if(exceptionHandlerLabel_6012Parser == null) {
			exceptionHandlerLabel_6012Parser = new ExceptionHandlerTypeParser();
		}
		return exceptionHandlerLabel_6012Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch(visualID) {
		case ActivityNameEditPart.VISUAL_ID:
			return getActivityName_5001Parser();
		case ActivityIsSingleExecutionEditPart.VISUAL_ID:
			return getActivityIsSingleExecution_5002Parser();
		case ParameterEditPart.VISUAL_ID:
			return getParameter_3001Parser();
		case ConstraintInActivityAsPrecondEditPart.VISUAL_ID:
			return getConstraint_3002Parser();
		case ConstraintInActivityAsPostcondEditPart.VISUAL_ID:
			return getConstraint_3003Parser();
		case InitialNodeAppliedStereotypeEditPart.VISUAL_ID:
			return getInitialNodeLabel_5080Parser();
		case ActivityFinalNodeAppliedStereotypeEditPart.VISUAL_ID:
			return getActivityFinalNodeLabel_5081Parser();
		case FlowFinalNodeAppliedStereotypeEditPart.VISUAL_ID:
			return getFlowFinalNodeLabel_5082Parser();
		case OpaqueActionNameEditPart.VISUAL_ID:
			return getOpaqueActionName_5003Parser();
		case ValuePinInOActLabelEditPart.VISUAL_ID:
			return getValuePinLabel_5011Parser();
		case ValuePinInOActValueEditPart.VISUAL_ID:
			return getValuePinLabel_5024Parser();
		case ValuePinInOActAppliedStereotypeEditPart.VISUAL_ID:
			return getValuePinLabel_5083Parser();
		case ActionInputPinInOActLabelEditPart.VISUAL_ID:
			return getActionInputPinLabel_5012Parser();
		case ActionInputPinInOActValueEditPart.VISUAL_ID:
			return getActionInputPinLabel_5025Parser();
		case ActionInputPinInOActAppliedStereotypeEditPart.VISUAL_ID:
			return getActionInputPinLabel_5084Parser();
		case InputPinInOActLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5009Parser();
		case InputPinInOActAppliedStereotypeEditPart.VISUAL_ID:
			return getInputPinLabel_5085Parser();
		case OutputPinInOActLabelEditPart.VISUAL_ID:
			return getOutputPinLabel_5010Parser();
		case OutputPinInOActAppliedStereotypeEditPart.VISUAL_ID:
			return getOutputPinLabel_5086Parser();
		case CallBehaviorActionNameEditPart.VISUAL_ID:
			return getCallBehaviorActionLabel_5004Parser();
		case ValuePinInCBActLabelEditPart.VISUAL_ID:
			return getValuePinLabel_5013Parser();
		case ValuePinInCBActValueEditPart.VISUAL_ID:
			return getValuePinLabel_5026Parser();
		case ValuePinInCBActAppliedStereotypeEditPart.VISUAL_ID:
			return getValuePinLabel_5087Parser();
		case ActionInputPinInCBActLabelEditPart.VISUAL_ID:
			return getActionInputPinLabel_5014Parser();
		case ActionInputPinInCBActValueEditPart.VISUAL_ID:
			return getActionInputPinLabel_5027Parser();
		case ActionInputPinInCBActAppliedStereotypeEditPart.VISUAL_ID:
			return getActionInputPinLabel_5088Parser();
		case InputPinInCBActLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5015Parser();
		case InputPinInCBActAppliedStereotypeEditPart.VISUAL_ID:
			return getInputPinLabel_5089Parser();
		case OutputPinInCBActLabelEditPart.VISUAL_ID:
			return getOutputPinLabel_5016Parser();
		case OutputPinInCBActAppliedStereotypeEditPart.VISUAL_ID:
			return getOutputPinLabel_5090Parser();
		case CallOperationActionNameEditPart.VISUAL_ID:
			return getCallOperationActionLabel_5006Parser();
		case ActionInputPinInCOActLabelEditPart.VISUAL_ID:
			return getActionInputPinLabel_5017Parser();
		case ActionInputPinInCOActValueEditPart.VISUAL_ID:
			return getActionInputPinLabel_5028Parser();
		case ActionInputPinInCOActAppliedStereotypeEditPart.VISUAL_ID:
			return getActionInputPinLabel_5091Parser();
		case ValuePinInCOActLabelEditPart.VISUAL_ID:
			return getValuePinLabel_5018Parser();
		case ValuePinInCOActValueEditPart.VISUAL_ID:
			return getValuePinLabel_5029Parser();
		case ValuePinInCOActAppliedStereotypeEditPart.VISUAL_ID:
			return getValuePinLabel_5092Parser();
		case InputPinInCOActLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5019Parser();
		case InputPinInCOActAppliedStereotypeEditPart.VISUAL_ID:
			return getInputPinLabel_5093Parser();
		case OutputPinInCOActLabelEditPart.VISUAL_ID:
			return getOutputPinLabel_5020Parser();
		case OutputPinInCOActAppliedStereotypeEditPart.VISUAL_ID:
			return getOutputPinLabel_5094Parser();
		case ValuePinInCOActAsTargetLabelEditPart.VISUAL_ID:
			return getValuePinLabel_5021Parser();
		case ValuePinInCOActAsTargetValueEditPart.VISUAL_ID:
			return getValuePinLabel_5030Parser();
		case ValuePinInCOActAsTargetAppliedStereotypeEditPart.VISUAL_ID:
			return getValuePinLabel_5095Parser();
		case ActionInputPinInCOActAsTargetLabelEditPart.VISUAL_ID:
			return getActionInputPinLabel_5022Parser();
		case ActionInputPinInCOActAsTargetValueEditPart.VISUAL_ID:
			return getActionInputPinLabel_5031Parser();
		case ActionInputPinInCOActAsTargetAppliedStereotypeEditPart.VISUAL_ID:
			return getActionInputPinLabel_5096Parser();
		case InputPinInCOActAsTargetLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5023Parser();
		case InputPinInCOActAsTargetAppliedStereotypeEditPart.VISUAL_ID:
			return getInputPinLabel_5097Parser();
		case DurationConstraintAsLocalPrecondNameEditPart.VISUAL_ID:
			return getDurationConstraintName_5038Parser();
		case DurationConstraintAsLocalPrecondBodyEditPart.VISUAL_ID:
			return getDurationConstraintLabel_5130Parser();
		case DurationConstraintAsLocalPostcondNameEditPart.VISUAL_ID:
			return getDurationConstraintName_5039Parser();
		case DurationConstraintAsLocalPostcondBodyEditPart.VISUAL_ID:
			return getDurationConstraintLabel_5131Parser();
		case TimeConstraintAsLocalPrecondNameEditPart.VISUAL_ID:
			return getTimeConstraintName_5040Parser();
		case TimeConstraintAsLocalPrecondBodyEditPart.VISUAL_ID:
			return getTimeConstraintLabel_5132Parser();
		case TimeConstraintAsLocalPostcondNameEditPart.VISUAL_ID:
			return getTimeConstraintName_5041Parser();
		case TimeConstraintAsLocalPostcondBodyEditPart.VISUAL_ID:
			return getTimeConstraintLabel_5133Parser();
		case IntervalConstraintAsLocalPrecondNameEditPart.VISUAL_ID:
			return getIntervalConstraintName_5036Parser();
		case IntervalConstraintAsLocalPrecondBodyEditPart.VISUAL_ID:
			return getIntervalConstraintLabel_5134Parser();
		case IntervalConstraintAsLocalPostcondNameEditPart.VISUAL_ID:
			return getIntervalConstraintName_5037Parser();
		case IntervalConstraintAsLocalPostcondBodyEditPart.VISUAL_ID:
			return getIntervalConstraintLabel_5135Parser();
		case ConstraintAsLocalPrecondNameEditPart.VISUAL_ID:
			return getConstraintName_5007Parser();
		case ConstraintAsLocalPrecondBodyEditPart.VISUAL_ID:
			return getConstraintLabel_5136Parser();
		case ConstraintAsLocalPostcondNameEditPart.VISUAL_ID:
			return getConstraintName_5008Parser();
		case ConstraintAsLocalPostcondBodyEditPart.VISUAL_ID:
			return getConstraintLabel_5137Parser();
		case DecisionInputEditPart.VISUAL_ID:
			return getDecisionNodeLabel_5043Parser();
		case DecisionNodeAppliedStereotypeEditPart.VISUAL_ID:
			return getDecisionNodeLabel_5098Parser();
		case MergeNodeAppliedStereotypeEditPart.VISUAL_ID:
			return getMergeNodeLabel_5099Parser();
		case ForkNodeAppliedStereotypeEditPart.VISUAL_ID:
			return getForkNodeLabel_5100Parser();
		case JoinSpecEditPart.VISUAL_ID:
			return getJoinNodeLabel_5042Parser();
		case JoinNodeAppliedStereotypeEditPart.VISUAL_ID:
			return getJoinNodeLabel_5101Parser();
		case DataStoreNodeLabelEditPart.VISUAL_ID:
			return getDataStoreNodeLabel_5127Parser();
		case DataStoreSelectionEditPart.VISUAL_ID:
			return getDataStoreNodeLabel_5128Parser();
		case SendObjectActionNameEditPart.VISUAL_ID:
			return getSendObjectActionName_5059Parser();
		case ValuePinInSendObjActAsReqLabelEditPart.VISUAL_ID:
			return getValuePinLabel_5049Parser();
		case ValuePinInSendObjActAsReqValueEditPart.VISUAL_ID:
			return getValuePinLabel_5050Parser();
		case ValuePinInSendObjActAsReqAppliedStereotypeEditPart.VISUAL_ID:
			return getValuePinLabel_5102Parser();
		case ActionInputPinInSendObjActAsReqLabelEditPart.VISUAL_ID:
			return getActionInputPinLabel_5051Parser();
		case ActionInputPinInSendObjActAsReqValueEditPart.VISUAL_ID:
			return getActionInputPinLabel_5052Parser();
		case ActionInputPinInSendObjActAsReqAppliedStereotypeEditPart.VISUAL_ID:
			return getActionInputPinLabel_5103Parser();
		case InputPinInSendObjActAsReqLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5053Parser();
		case InputPinInSendObjActAsReqAppliedStereotypeEditPart.VISUAL_ID:
			return getInputPinLabel_5104Parser();
		case ValuePinInSendObjActAsTargetLabelEditPart.VISUAL_ID:
			return getValuePinLabel_5054Parser();
		case ValuePinInSendObjActAsTargetValueEditPart.VISUAL_ID:
			return getValuePinLabel_5055Parser();
		case ValuePinInSendObjActAsTargetAppliedStereotypeEditPart.VISUAL_ID:
			return getValuePinLabel_5105Parser();
		case ActionInputPinInSendObjActAsTargetLabelEditPart.VISUAL_ID:
			return getActionInputPinLabel_5056Parser();
		case ActionInputPinInSendObjActAsTargetValueEditPart.VISUAL_ID:
			return getActionInputPinLabel_5057Parser();
		case ActionInputPinInSendObjActAsTargetAppliedStereotypeEditPart.VISUAL_ID:
			return getActionInputPinLabel_5106Parser();
		case InputPinInSendObjActAsTargetLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5058Parser();
		case InputPinInSendObjActAsTargetAppliedStereotypeEditPart.VISUAL_ID:
			return getInputPinLabel_5107Parser();
		case SendSignalActionNameEditPart.VISUAL_ID:
			return getSendSignalActionName_5060Parser();
		case ActionInputPinInSendSigActLabelEditPart.VISUAL_ID:
			return getActionInputPinLabel_5061Parser();
		case ActionInputPinInSendSigActValueEditPart.VISUAL_ID:
			return getActionInputPinLabel_5062Parser();
		case ActionInputPinInSendSigActAppliedStereotypeEditPart.VISUAL_ID:
			return getActionInputPinLabel_5108Parser();
		case ValuePinInSendSigActLabelEditPart.VISUAL_ID:
			return getValuePinLabel_5063Parser();
		case ValuePinInSendSigActValueEditPart.VISUAL_ID:
			return getValuePinLabel_5064Parser();
		case ValuePinInSendSigActAppliedStereotypeEditPart.VISUAL_ID:
			return getValuePinLabel_5109Parser();
		case InputPinInSendSigActLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5065Parser();
		case InputPinInSendSigActAppliedStereotypeEditPart.VISUAL_ID:
			return getInputPinLabel_5110Parser();
		case ValuePinInSendSigActAsTargetLabelEditPart.VISUAL_ID:
			return getValuePinLabel_5072Parser();
		case ValuePinInSendSigActAsTargetValueEditPart.VISUAL_ID:
			return getValuePinLabel_5073Parser();
		case ValuePinInSendSigActAsTargetAppliedStereotypeEditPart.VISUAL_ID:
			return getValuePinLabel_5111Parser();
		case ActionInputPinInSendSigActAsTargetLabelEditPart.VISUAL_ID:
			return getActionInputPinLabel_5074Parser();
		case ActionInputPinInSendSigActAsTargetValueEditPart.VISUAL_ID:
			return getActionInputPinLabel_5075Parser();
		case ActionInputPinInSendSigActAsTargetAppliedStereotypeEditPart.VISUAL_ID:
			return getActionInputPinLabel_5112Parser();
		case InputPinInSendSigActAsTargetLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5076Parser();
		case InputPinInSendSigActAsTargetAppliedStereotypeEditPart.VISUAL_ID:
			return getInputPinLabel_5113Parser();
		case ParameterNodeNameEditPart.VISUAL_ID:
			return getActivityParameterNodeLabel_5071Parser();
		case AcceptEventActionLabelEditPart.VISUAL_ID:
			return getAcceptEventActionLabel_5078Parser();
		case AcceptTimeEventActionLabelEditPart.VISUAL_ID:
			return getAcceptEventActionLabel_5079Parser();
		case AcceptTimeEventActionAppliedStereotypeEditPart.VISUAL_ID:
			return getAcceptEventActionLabel_5115Parser();
		case OutputPinInAcceptEventActionLabelEditPart.VISUAL_ID:
			return getOutputPinLabel_5077Parser();
		case OutputPinInAcceptEventActionAppliedStereotypeEditPart.VISUAL_ID:
			return getOutputPinLabel_5114Parser();
		case ValueSpecificationActionNameEditPart.VISUAL_ID:
			return getValueSpecificationActionName_5126Parser();
		case OutputPinInValSpecActLabelEditPart.VISUAL_ID:
			return getOutputPinLabel_5124Parser();
		case OutputPinInValSpecActAppliedStereotypeEditPart.VISUAL_ID:
			return getOutputPinLabel_5125Parser();
		case ConditionalNodeKeywordEditPart.VISUAL_ID:
			return getConditionalNodeLabel_5119Parser();
		case ExpansionRegionKeywordEditPart.VISUAL_ID:
			return getExpansionRegionLabel_5120Parser();
		case LoopNodeKeywordEditPart.VISUAL_ID:
			return getLoopNodeLabel_5121Parser();
		case OutputPinInLoopNodeAsBodyOutputLabelEditPart.VISUAL_ID:
			return getOutputPinLabel_5184Parser();
		case OutputPinInLoopNodeAsBodyOutputAppliedStereotypeEditPart.VISUAL_ID:
			return getOutputPinLabel_5185Parser();
		case OutputPinInLoopNodeAsLoopVariableLabelEditPart.VISUAL_ID:
			return getOutputPinLabel_5186Parser();
		case OutputPinInLoopNodeAsLoopVariableAppliedStereotypeEditPart.VISUAL_ID:
			return getOutputPinLabel_5183Parser();
		case OutputPinInLoopNodeAsResultLabelEditPart.VISUAL_ID:
			return getOutputPinLabel_5187Parser();
		case OutputPinInLoopNodeAsResultAppliedStereotypeEditPart.VISUAL_ID:
			return getOutputPinLabel_5188Parser();
		case SequenceNodeKeywordEditPart.VISUAL_ID:
			return getSequenceNodeLabel_5123Parser();
		case StructuredActivityNodeKeywordEditPart.VISUAL_ID:
			return getStructuredActivityNodeLabel_5117Parser();
		case InputPinInLoopNodeAsVariableLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5178Parser();
		case InputPinInStructuredActivityNodeAppliedStereotypeEditPart.VISUAL_ID:
			return getInputPinLabel_5179Parser();
		case ActivityPartitionNameEditPart.VISUAL_ID:
			return getActivityPartitionName_5118Parser();
		case CommentBodyLabelEditPart.VISUAL_ID:
			return getCommentBody_5138Parser();
		case ReadSelfActionNameEditPart.VISUAL_ID:
			return getReadSelfActionName_5139Parser();
		case OutputPinInReadSelfActionLabelEditPart.VISUAL_ID:
			return getOutputPinLabel_5144Parser();
		case OutputPinInReadSelfActionAppliedStereotypeEditPart.VISUAL_ID:
			return getOutputPinLabel_5145Parser();
		case ActivityNameEditPartCN.VISUAL_ID:
			return getActivityName_5142Parser();
		case ActivityIsSingleExecutionCNEditPart.VISUAL_ID:
			return getActivityIsSingleExecution_5143Parser();
		case CreateObjectActionNameEditPart.VISUAL_ID:
			return getCreateObjectActionName_5148Parser();
		case OutputPinInCreateObjectActionAsResultLabelEditPart.VISUAL_ID:
			return getOutputPinLabel_5146Parser();
		case OutputPinInCreateObjectActionAsResultAppliedStereotypeWrappingLabelEditPart.VISUAL_ID:
			return getOutputPinLabel_5147Parser();
		case ShapeNamedElementNameEditPart.VISUAL_ID:
			return getNamedElementName_5129Parser();
		case ReadStructuralFeatureActionNameEditPart.VISUAL_ID:
			return getReadStructuralFeatureActionName_5153Parser();
		case InputPinInReadStructuralFeatureAsObjectLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5149Parser();
		case InputPinInReadStructuralFeatureAsObjectAppliedStereotypeWrappingLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5150Parser();
		case OutputPinInReadStructuralFeatureAsResultLabelEditPart.VISUAL_ID:
			return getOutputPinLabel_5151Parser();
		case InputPinInReadStructuralFeatureAsResultWrappingLabelEditPart.VISUAL_ID:
			return getOutputPinLabel_5152Parser();
		case AddStructuralFeatureValueActionNameEditPart.VISUAL_ID:
			return getAddStructuralFeatureValueActionName_5160Parser();
		case InputPinInAddStructuralFeatureValueActionAsObjectLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5154Parser();
		case InputPinInAddStructuralFeatureValueActionAsObjectAppliedStereotypeWrappingLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5155Parser();
		case InputPinInAddStructuralFeatureValueActionAsValueLabel2EditPart.VISUAL_ID:
			return getInputPinLabel_5156Parser();
		case InputPinInAddStructuralFeatureValueActionAsValueAppliedStereotypeWrappingLabel2EditPart.VISUAL_ID:
			return getInputPinLabel_5157Parser();
		case OutputPinInAddStructuralFeatureValueActionAsResultLabel3EditPart.VISUAL_ID:
			return getOutputPinLabel_5158Parser();
		case OutputPinInAddStructuralFeatureValueActionAsResultAppliedStereotypeWrappingLabel3EditPart.VISUAL_ID:
			return getOutputPinLabel_5159Parser();
		case DestroyObjectActionNameEditPart.VISUAL_ID:
			return getDestroyObjectActionName_5163Parser();
		case InputPinInDestroyObjectActionLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5161Parser();
		case InputPinInDestroyObjectActionAppliedStereotypeWrappingLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5162Parser();
		case ReadVariableActionNameEditPart.VISUAL_ID:
			return getReadVariableActionName_5166Parser();
		case OutputPinInReadVariableActionAsResultLabelEditPart.VISUAL_ID:
			return getOutputPinLabel_5164Parser();
		case OutputPinInReadVariableActionAsResultAppliedStereotypeWrappingLabelEditPart.VISUAL_ID:
			return getOutputPinLabel_5165Parser();
		case AddVariableValueActionNameEditPart.VISUAL_ID:
			return getAddVariableValueActionName_5171Parser();
		case InputPinInAddVariableValueActionAsInsertAtLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5167Parser();
		case InputPinInAddVariableValueActionAsInsertAtAppliedStereotypeWrappingLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5168Parser();
		case InputPinInAddVariableValueActionAsValueLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5169Parser();
		case InputPinInAddVariableValueActionAsValueAppliedStereotypeWrappingLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5170Parser();
		case BroadcastSignalActionNameEditPart.VISUAL_ID:
			return getBroadcastSignalActionName_5175Parser();
		case InputPinInBroadcastSignalActionLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5172Parser();
		case InputPinInBroadcastSignalActionValueLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5173Parser();
		case InputPinInBroadcastSignalActionAppliedStereotypeWrappingLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5174Parser();
		case CentralBufferNodeLabelEditPart.VISUAL_ID:
			return getCentralBufferNodeLabel_5176Parser();
		case CentralBufferNodeSelectionEditPart.VISUAL_ID:
			return getCentralBufferNodeLabel_5177Parser();
		case ConstraintNameEditPartCN.VISUAL_ID:
			return getConstraintName_5189Parser();
		case ConstraintBodyEditPartCN.VISUAL_ID:
			return getConstraintSpecification_5190Parser();
		case ObjectFlowNameEditPart.VISUAL_ID:
			return getObjectFlowName_6001Parser();
		case ObjectFlowWeightEditPart.VISUAL_ID:
			return getObjectFlowLabel_6002Parser();
		case ObjectFlowSelectionEditPart.VISUAL_ID:
			return getObjectFlowLabel_6005Parser();
		case ObjectFlowTransformationEditPart.VISUAL_ID:
			return getObjectFlowLabel_6006Parser();
		case DecisionInputFlowEditPart.VISUAL_ID:
			return getObjectFlowLabel_6007Parser();
		case ObjectFlowGuardEditPart.VISUAL_ID:
			return getObjectFlowLabel_6008Parser();
		case ObjectFlowAppliedStereotypeEditPart.VISUAL_ID:
			return getObjectFlowLabel_6010Parser();
		case ControlFlowNameEditPart.VISUAL_ID:
			return getControlFlowName_6003Parser();
		case ControlFlowWeightEditPart.VISUAL_ID:
			return getControlFlowLabel_6004Parser();
		case ControlFlowGuardEditPart.VISUAL_ID:
			return getControlFlowLabel_6009Parser();
		case ControlFlowAppliedStereotypeEditPart.VISUAL_ID:
			return getControlFlowLabel_6011Parser();
		case ExceptionHandlerTypeEditPart.VISUAL_ID:
			return getExceptionHandlerLabel_6012Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * 
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String)hint.getAdapter(String.class);
		if(vid != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(vid));
		}
		View view = (View)hint.getAdapter(View.class);
		if(view != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if(operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation)operation).getHint();
			if(UMLElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if(IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}
}
