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
import org.eclipse.papyrus.diagram.activity.edit.parts.*;
import org.eclipse.papyrus.diagram.activity.parser.custom.AcceptEventActionParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.AcceptTimeEventActionParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.ActivityEdgeWeightParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.ActivityParameterNodeParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.ActivitySingleExecutionParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.CallBehaviorActionParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.CallOperationActionParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.DecisionInputFlowParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.EdgeGuardParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.ExceptionHandlerTypeParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.InputDecisionParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.JoinSpecParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.ObjectFlowSelectionParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.ObjectFlowTransformationParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.ObjectNodeParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.ParameterParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.PinParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.PinValueParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.StructuredActivityNodeKeywordParser;
import org.eclipse.papyrus.diagram.activity.parsers.MessageFormatParser;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.common.parser.stereotype.AppliedStereotypeParser;
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
	private IParser constraint_3002Parser;

	/**
	 * @generated
	 */
	private IParser getConstraint_3002Parser() {
		if(constraint_3002Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("<<precondition>> {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			constraint_3002Parser = parser;
		}
		return constraint_3002Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraint_3003Parser;

	/**
	 * @generated
	 */
	private IParser getConstraint_3003Parser() {
		if(constraint_3003Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("<<postcondition>> {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			constraint_3003Parser = parser;
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
			parser.setViewPattern("<<localPrecondition>>\n{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			constraintName_5007Parser = parser;
		}
		return constraintName_5007Parser;
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
			parser.setViewPattern("<<localPostcondition>>\n{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			constraintName_5008Parser = parser;
		}
		return constraintName_5008Parser;
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
	private IParser interactionConstraintName_5034Parser;

	/**
	 * @generated
	 */
	private IParser getInteractionConstraintName_5034Parser() {
		if(interactionConstraintName_5034Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("<<localPrecondition>>\n{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			interactionConstraintName_5034Parser = parser;
		}
		return interactionConstraintName_5034Parser;
	}

	/**
	 * @generated
	 */
	private IParser interactionConstraintName_5035Parser;

	/**
	 * @generated
	 */
	private IParser getInteractionConstraintName_5035Parser() {
		if(interactionConstraintName_5035Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("<<localPostcondition>>\n{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			interactionConstraintName_5035Parser = parser;
		}
		return interactionConstraintName_5035Parser;
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
			parser.setViewPattern("<<localPrecondition>>\n{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			intervalConstraintName_5036Parser = parser;
		}
		return intervalConstraintName_5036Parser;
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
			parser.setViewPattern("<<localPostcondition>>\n{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			intervalConstraintName_5037Parser = parser;
		}
		return intervalConstraintName_5037Parser;
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
			parser.setViewPattern("<<localPrecondition>>\n{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			durationConstraintName_5038Parser = parser;
		}
		return durationConstraintName_5038Parser;
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
			parser.setViewPattern("<<localPostcondition>>\n{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			durationConstraintName_5039Parser = parser;
		}
		return durationConstraintName_5039Parser;
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
			parser.setViewPattern("<<localPrecondition>>\n{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			timeConstraintName_5040Parser = parser;
		}
		return timeConstraintName_5040Parser;
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
			parser.setViewPattern("<<localPostcondition>>\n{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			timeConstraintName_5041Parser = parser;
		}
		return timeConstraintName_5041Parser;
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
		case DurationConstraintAsLocalPostcondNameEditPart.VISUAL_ID:
			return getDurationConstraintName_5039Parser();
		case TimeConstraintAsLocalPrecondNameEditPart.VISUAL_ID:
			return getTimeConstraintName_5040Parser();
		case TimeConstraintAsLocalPostcondNameEditPart.VISUAL_ID:
			return getTimeConstraintName_5041Parser();
		case InteractionConstraintAsLocalPrecondNameEditPart.VISUAL_ID:
			return getInteractionConstraintName_5034Parser();
		case InteractionConstraintAsLocalPostcondNameEditPart.VISUAL_ID:
			return getInteractionConstraintName_5035Parser();
		case IntervalConstraintAsLocalPrecondNameEditPart.VISUAL_ID:
			return getIntervalConstraintName_5036Parser();
		case IntervalConstraintAsLocalPostcondNameEditPart.VISUAL_ID:
			return getIntervalConstraintName_5037Parser();
		case ConstraintAsLocalPrecondNameEditPart.VISUAL_ID:
			return getConstraintName_5007Parser();
		case ConstraintAsLocalPostcondNameEditPart.VISUAL_ID:
			return getConstraintName_5008Parser();
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
		case CenteredWrappedLabelEditPart.VISUAL_ID:
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
		case ConditionalNodeKeywordEditPart.VISUAL_ID:
			return getConditionalNodeLabel_5119Parser();
		case ExpansionRegionKeywordEditPart.VISUAL_ID:
			return getExpansionRegionLabel_5120Parser();
		case LoopNodeKeywordEditPart.VISUAL_ID:
			return getLoopNodeLabel_5121Parser();
		case SequenceNodeKeywordEditPart.VISUAL_ID:
			return getSequenceNodeLabel_5123Parser();
		case StructuredActivityNodeKeywordEditPart.VISUAL_ID:
			return getStructuredActivityNodeLabel_5117Parser();
		case ActivityPartitionNameEditPart.VISUAL_ID:
			return getActivityPartitionName_5118Parser();
		case ValueSpecificationActionNameEditPart.VISUAL_ID:
			return getValueSpecificationActionName_5126Parser();
		case OutputPinInValSpecActLabelEditPart.VISUAL_ID:
			return getOutputPinLabel_5124Parser();
		case OutputPinInValSpecActAppliedStereotypeEditPart.VISUAL_ID:
			return getOutputPinLabel_5125Parser();
		case DataStoreNodeLabelEditPart.VISUAL_ID:
			return getDataStoreNodeLabel_5127Parser();
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
