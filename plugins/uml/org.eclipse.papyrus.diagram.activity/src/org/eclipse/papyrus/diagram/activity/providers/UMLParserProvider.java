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
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCBActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCBActValueEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCOActAsTargetLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCOActAsTargetValueEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCOActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCOActValueEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInOActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInOActValueEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityAsSelectionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityAsTransformationNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityIsSingleExecutionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallBehaviorActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallOperationActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPostcondNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPrecondNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintInActivityAsPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintInActivityAsPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowWeightEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DurationConstraintAsLocalPostcondNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DurationConstraintAsLocalPrecondNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCBActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCOActAsTargetLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCOActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInOActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InteractionConstraintAsLocalPostcondNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InteractionConstraintAsLocalPrecondNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.IntervalConstraintAsLocalPostcondNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.IntervalConstraintAsLocalPrecondNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowWeightEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInCBActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInCOActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInOActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ParameterEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.TimeConstraintAsLocalPostcondNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.TimeConstraintAsLocalPrecondNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCBActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCBActValueEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCOActAsTargetLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCOActAsTargetValueEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCOActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCOActValueEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInOActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInOActValueEditPart;
import org.eclipse.papyrus.diagram.activity.parser.custom.ActivityEdgeWeightParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.ActivitySingleExecutionParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.CallBehaviorActionParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.CallOperationActionParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.ParameterParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.PinParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.PinValueParser;
import org.eclipse.papyrus.diagram.activity.parsers.MessageFormatParser;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
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
	private IParser activityName_5032Parser;

	/**
	 * @generated
	 */
	private IParser getActivityName_5032Parser() {
		if(activityName_5032Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("<<selection>>\n{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			activityName_5032Parser = parser;
		}
		return activityName_5032Parser;
	}

	/**
	 * @generated
	 */
	private IParser activityName_5033Parser;

	/**
	 * @generated
	 */
	private IParser getActivityName_5033Parser() {
		if(activityName_5033Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("<<transformation>>\n{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			activityName_5033Parser = parser;
		}
		return activityName_5033Parser;
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
		case OpaqueActionNameEditPart.VISUAL_ID:
			return getOpaqueActionName_5003Parser();
		case ValuePinInOActLabelEditPart.VISUAL_ID:
			return getValuePinLabel_5011Parser();
		case ValuePinInOActValueEditPart.VISUAL_ID:
			return getValuePinLabel_5024Parser();
		case ActionInputPinInOActLabelEditPart.VISUAL_ID:
			return getActionInputPinLabel_5012Parser();
		case ActionInputPinInOActValueEditPart.VISUAL_ID:
			return getActionInputPinLabel_5025Parser();
		case InputPinInOActLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5009Parser();
		case OutputPinInOActLabelEditPart.VISUAL_ID:
			return getOutputPinLabel_5010Parser();
		case CallBehaviorActionNameEditPart.VISUAL_ID:
			return getCallBehaviorActionLabel_5004Parser();
		case ValuePinInCBActLabelEditPart.VISUAL_ID:
			return getValuePinLabel_5013Parser();
		case ValuePinInCBActValueEditPart.VISUAL_ID:
			return getValuePinLabel_5026Parser();
		case ActionInputPinInCBActLabelEditPart.VISUAL_ID:
			return getActionInputPinLabel_5014Parser();
		case ActionInputPinInCBActValueEditPart.VISUAL_ID:
			return getActionInputPinLabel_5027Parser();
		case InputPinInCBActLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5015Parser();
		case OutputPinInCBActLabelEditPart.VISUAL_ID:
			return getOutputPinLabel_5016Parser();
		case CallOperationActionNameEditPart.VISUAL_ID:
			return getCallOperationActionLabel_5006Parser();
		case ActionInputPinInCOActLabelEditPart.VISUAL_ID:
			return getActionInputPinLabel_5017Parser();
		case ActionInputPinInCOActValueEditPart.VISUAL_ID:
			return getActionInputPinLabel_5028Parser();
		case ValuePinInCOActLabelEditPart.VISUAL_ID:
			return getValuePinLabel_5018Parser();
		case ValuePinInCOActValueEditPart.VISUAL_ID:
			return getValuePinLabel_5029Parser();
		case InputPinInCOActLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5019Parser();
		case OutputPinInCOActLabelEditPart.VISUAL_ID:
			return getOutputPinLabel_5020Parser();
		case ValuePinInCOActAsTargetLabelEditPart.VISUAL_ID:
			return getValuePinLabel_5021Parser();
		case ValuePinInCOActAsTargetValueEditPart.VISUAL_ID:
			return getValuePinLabel_5030Parser();
		case ActionInputPinInCOActAsTargetLabelEditPart.VISUAL_ID:
			return getActionInputPinLabel_5022Parser();
		case ActionInputPinInCOActAsTargetValueEditPart.VISUAL_ID:
			return getActionInputPinLabel_5031Parser();
		case InputPinInCOActAsTargetLabelEditPart.VISUAL_ID:
			return getInputPinLabel_5023Parser();
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
		case ActivityAsSelectionNameEditPart.VISUAL_ID:
			return getActivityName_5032Parser();
		case ActivityAsTransformationNameEditPart.VISUAL_ID:
			return getActivityName_5033Parser();
		case ObjectFlowNameEditPart.VISUAL_ID:
			return getObjectFlowName_6001Parser();
		case ObjectFlowWeightEditPart.VISUAL_ID:
			return getObjectFlowLabel_6002Parser();
		case ControlFlowNameEditPart.VISUAL_ID:
			return getControlFlowName_6003Parser();
		case ControlFlowWeightEditPart.VISUAL_ID:
			return getControlFlowLabel_6004Parser();
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
