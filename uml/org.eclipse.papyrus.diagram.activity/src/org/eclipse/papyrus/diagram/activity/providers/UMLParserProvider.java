/*******************************************************************************
 * Copyright (c) 2008 
 * Conselleria de Infraestructuras y Transporte, Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *	  Francisco Javier Cano Muñoz (Prodevelop) - initial API implementation
 ******************************************************************************/
package org.eclipse.papyrus.diagram.activity.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.parts.AcceptEventActionName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.AcceptEventActionName3EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.AcceptEventActionName4EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.AcceptEventActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityFinalNodeNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityParameterNodeNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartitionName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartitionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallBehaviorActionName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallBehaviorActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallOperationActionName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallOperationActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CreateObjectActionName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CreateObjectActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DataStoreNodeNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DecisionNodeNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.FlowFinalNodeNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InitialNodeNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinName3EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinName4EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinName5EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinName6EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.MergeNodeNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionName3EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionName4EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinName3EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinName4EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.PinNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendObjectActionName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendObjectActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendSignalActionName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendSignalActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinNameEditPart;
import org.eclipse.papyrus.diagram.activity.parser.ObjectNodeInStateParser;
import org.eclipse.papyrus.diagram.activity.parser.ObjectNodeTypeParser;
import org.eclipse.papyrus.diagram.activity.parsers.MessageFormatParser;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.common.parser.custom.OnlyStereotypesNamesParser;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser activityName_4042Parser;

	/**
	 * @generated
	 */
	private IParser getActivityName_4042Parser() {
		if (activityName_4042Parser == null) {
			activityName_4042Parser = createActivityName_4042Parser();
		}
		return activityName_4042Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createActivityName_4042Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser commentBody_4039Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_4039Parser() {
		if (commentBody_4039Parser == null) {
			commentBody_4039Parser = createCommentBody_4039Parser();
		}
		return commentBody_4039Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCommentBody_4039Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getComment_Body(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser sendObjectActionName_4004Parser;

	/**
	 * @generated
	 */
	private IParser getSendObjectActionName_4004Parser() {
		if (sendObjectActionName_4004Parser == null) {
			sendObjectActionName_4004Parser = createSendObjectActionName_4004Parser();
		}
		return sendObjectActionName_4004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createSendObjectActionName_4004Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser sendObjectActionName_4005Parser;

	/**
	 * @generated
	 */
	private IParser getSendObjectActionName_4005Parser() {
		if (sendObjectActionName_4005Parser == null) {
			sendObjectActionName_4005Parser = createSendObjectActionName_4005Parser();
		}
		return sendObjectActionName_4005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createSendObjectActionName_4005Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		return new OnlyStereotypesNamesParser();

	}

	/**
	 * @generated
	 */
	private IParser inputPinName_4001Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinName_4001Parser() {
		if (inputPinName_4001Parser == null) {
			inputPinName_4001Parser = createInputPinName_4001Parser();
		}
		return inputPinName_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInputPinName_4001Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser inputPinName_4002Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinName_4002Parser() {
		if (inputPinName_4002Parser == null) {
			inputPinName_4002Parser = createInputPinName_4002Parser();
		}
		return inputPinName_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInputPinName_4002Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser valuePinName_4003Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinName_4003Parser() {
		if (valuePinName_4003Parser == null) {
			valuePinName_4003Parser = createValuePinName_4003Parser();
		}
		return valuePinName_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createValuePinName_4003Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser sendSignalActionName_4007Parser;

	/**
	 * @generated
	 */
	private IParser getSendSignalActionName_4007Parser() {
		if (sendSignalActionName_4007Parser == null) {
			sendSignalActionName_4007Parser = createSendSignalActionName_4007Parser();
		}
		return sendSignalActionName_4007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createSendSignalActionName_4007Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser sendSignalActionName_4008Parser;

	/**
	 * @generated
	 */
	private IParser getSendSignalActionName_4008Parser() {
		if (sendSignalActionName_4008Parser == null) {
			sendSignalActionName_4008Parser = createSendSignalActionName_4008Parser();
		}
		return sendSignalActionName_4008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createSendSignalActionName_4008Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		return new OnlyStereotypesNamesParser();

	}

	/**
	 * @generated
	 */
	private IParser inputPinName_4006Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinName_4006Parser() {
		if (inputPinName_4006Parser == null) {
			inputPinName_4006Parser = createInputPinName_4006Parser();
		}
		return inputPinName_4006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInputPinName_4006Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser acceptEventActionName_4010Parser;

	/**
	 * @generated
	 */
	private IParser getAcceptEventActionName_4010Parser() {
		if (acceptEventActionName_4010Parser == null) {
			acceptEventActionName_4010Parser = createAcceptEventActionName_4010Parser();
		}
		return acceptEventActionName_4010Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAcceptEventActionName_4010Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser acceptEventActionName_4011Parser;

	/**
	 * @generated
	 */
	private IParser getAcceptEventActionName_4011Parser() {
		if (acceptEventActionName_4011Parser == null) {
			acceptEventActionName_4011Parser = createAcceptEventActionName_4011Parser();
		}
		return acceptEventActionName_4011Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAcceptEventActionName_4011Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		return new OnlyStereotypesNamesParser();

	}

	/**
	 * @generated
	 */
	private IParser outputPinName_4009Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinName_4009Parser() {
		if (outputPinName_4009Parser == null) {
			outputPinName_4009Parser = createOutputPinName_4009Parser();
		}
		return outputPinName_4009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createOutputPinName_4009Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser activityFinalNodeName_4012Parser;

	/**
	 * @generated
	 */
	private IParser getActivityFinalNodeName_4012Parser() {
		if (activityFinalNodeName_4012Parser == null) {
			activityFinalNodeName_4012Parser = createActivityFinalNodeName_4012Parser();
		}
		return activityFinalNodeName_4012Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createActivityFinalNodeName_4012Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser decisionNodeName_4013Parser;

	/**
	 * @generated
	 */
	private IParser getDecisionNodeName_4013Parser() {
		if (decisionNodeName_4013Parser == null) {
			decisionNodeName_4013Parser = createDecisionNodeName_4013Parser();
		}
		return decisionNodeName_4013Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createDecisionNodeName_4013Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser mergeNodeName_4014Parser;

	/**
	 * @generated
	 */
	private IParser getMergeNodeName_4014Parser() {
		if (mergeNodeName_4014Parser == null) {
			mergeNodeName_4014Parser = createMergeNodeName_4014Parser();
		}
		return mergeNodeName_4014Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createMergeNodeName_4014Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser initialNodeName_4015Parser;

	/**
	 * @generated
	 */
	private IParser getInitialNodeName_4015Parser() {
		if (initialNodeName_4015Parser == null) {
			initialNodeName_4015Parser = createInitialNodeName_4015Parser();
		}
		return initialNodeName_4015Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInitialNodeName_4015Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser dataStoreNodeName_4016Parser;

	/**
	 * @generated
	 */
	private IParser getDataStoreNodeName_4016Parser() {
		if (dataStoreNodeName_4016Parser == null) {
			dataStoreNodeName_4016Parser = createDataStoreNodeName_4016Parser();
		}
		return dataStoreNodeName_4016Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createDataStoreNodeName_4016Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser opaqueActionName_4020Parser;

	/**
	 * @generated
	 */
	private IParser getOpaqueActionName_4020Parser() {
		if (opaqueActionName_4020Parser == null) {
			opaqueActionName_4020Parser = createOpaqueActionName_4020Parser();
		}
		return opaqueActionName_4020Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createOpaqueActionName_4020Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser opaqueActionName_4021Parser;

	/**
	 * @generated
	 */
	private IParser getOpaqueActionName_4021Parser() {
		if (opaqueActionName_4021Parser == null) {
			opaqueActionName_4021Parser = createOpaqueActionName_4021Parser();
		}
		return opaqueActionName_4021Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createOpaqueActionName_4021Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		return new OnlyStereotypesNamesParser();

	}

	/**
	 * @generated
	 */
	private IParser outputPinName_4017Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinName_4017Parser() {
		if (outputPinName_4017Parser == null) {
			outputPinName_4017Parser = createOutputPinName_4017Parser();
		}
		return outputPinName_4017Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createOutputPinName_4017Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser inputPinName_4018Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinName_4018Parser() {
		if (inputPinName_4018Parser == null) {
			inputPinName_4018Parser = createInputPinName_4018Parser();
		}
		return inputPinName_4018Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInputPinName_4018Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser valuePinName_4019Parser;

	/**
	 * @generated
	 */
	private IParser getValuePinName_4019Parser() {
		if (valuePinName_4019Parser == null) {
			valuePinName_4019Parser = createValuePinName_4019Parser();
		}
		return valuePinName_4019Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createValuePinName_4019Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser flowFinalNodeName_4022Parser;

	/**
	 * @generated
	 */
	private IParser getFlowFinalNodeName_4022Parser() {
		if (flowFinalNodeName_4022Parser == null) {
			flowFinalNodeName_4022Parser = createFlowFinalNodeName_4022Parser();
		}
		return flowFinalNodeName_4022Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createFlowFinalNodeName_4022Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser pinName_4023Parser;

	/**
	 * @generated
	 */
	private IParser getPinName_4023Parser() {
		if (pinName_4023Parser == null) {
			pinName_4023Parser = createPinName_4023Parser();
		}
		return pinName_4023Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPinName_4023Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser createObjectActionName_4025Parser;

	/**
	 * @generated
	 */
	private IParser getCreateObjectActionName_4025Parser() {
		if (createObjectActionName_4025Parser == null) {
			createObjectActionName_4025Parser = createCreateObjectActionName_4025Parser();
		}
		return createObjectActionName_4025Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCreateObjectActionName_4025Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser createObjectActionName_4026Parser;

	/**
	 * @generated
	 */
	private IParser getCreateObjectActionName_4026Parser() {
		if (createObjectActionName_4026Parser == null) {
			createObjectActionName_4026Parser = createCreateObjectActionName_4026Parser();
		}
		return createObjectActionName_4026Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCreateObjectActionName_4026Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		return new OnlyStereotypesNamesParser();

	}

	/**
	 * @generated
	 */
	private IParser outputPinName_4024Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinName_4024Parser() {
		if (outputPinName_4024Parser == null) {
			outputPinName_4024Parser = createOutputPinName_4024Parser();
		}
		return outputPinName_4024Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createOutputPinName_4024Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser callBehaviorActionName_4029Parser;

	/**
	 * @generated
	 */
	private IParser getCallBehaviorActionName_4029Parser() {
		if (callBehaviorActionName_4029Parser == null) {
			callBehaviorActionName_4029Parser = createCallBehaviorActionName_4029Parser();
		}
		return callBehaviorActionName_4029Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCallBehaviorActionName_4029Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser callBehaviorActionName_4030Parser;

	/**
	 * @generated
	 */
	private IParser getCallBehaviorActionName_4030Parser() {
		if (callBehaviorActionName_4030Parser == null) {
			callBehaviorActionName_4030Parser = createCallBehaviorActionName_4030Parser();
		}
		return callBehaviorActionName_4030Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCallBehaviorActionName_4030Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		return new OnlyStereotypesNamesParser();

	}

	/**
	 * @generated
	 */
	private IParser outputPinName_4027Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinName_4027Parser() {
		if (outputPinName_4027Parser == null) {
			outputPinName_4027Parser = createOutputPinName_4027Parser();
		}
		return outputPinName_4027Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createOutputPinName_4027Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser inputPinName_4028Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinName_4028Parser() {
		if (inputPinName_4028Parser == null) {
			inputPinName_4028Parser = createInputPinName_4028Parser();
		}
		return inputPinName_4028Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInputPinName_4028Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser callOperationActionName_4032Parser;

	/**
	 * @generated
	 */
	private IParser getCallOperationActionName_4032Parser() {
		if (callOperationActionName_4032Parser == null) {
			callOperationActionName_4032Parser = createCallOperationActionName_4032Parser();
		}
		return callOperationActionName_4032Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCallOperationActionName_4032Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser callOperationActionName_4033Parser;

	/**
	 * @generated
	 */
	private IParser getCallOperationActionName_4033Parser() {
		if (callOperationActionName_4033Parser == null) {
			callOperationActionName_4033Parser = createCallOperationActionName_4033Parser();
		}
		return callOperationActionName_4033Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCallOperationActionName_4033Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		return new OnlyStereotypesNamesParser();

	}

	/**
	 * @generated
	 */
	private IParser inputPinName_4031Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinName_4031Parser() {
		if (inputPinName_4031Parser == null) {
			inputPinName_4031Parser = createInputPinName_4031Parser();
		}
		return inputPinName_4031Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInputPinName_4031Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser activityParameterNodeName_4034Parser;

	/**
	 * @generated
	 */
	private IParser getActivityParameterNodeName_4034Parser() {
		if (activityParameterNodeName_4034Parser == null) {
			activityParameterNodeName_4034Parser = createActivityParameterNodeName_4034Parser();
		}
		return activityParameterNodeName_4034Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createActivityParameterNodeName_4034Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser activityPartitionName_4041Parser;

	/**
	 * @generated
	 */
	private IParser getActivityPartitionName_4041Parser() {
		if (activityPartitionName_4041Parser == null) {
			activityPartitionName_4041Parser = createActivityPartitionName_4041Parser();
		}
		return activityPartitionName_4041Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createActivityPartitionName_4041Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser activityPartitionName_4040Parser;

	/**
	 * @generated
	 */
	private IParser getActivityPartitionName_4040Parser() {
		if (activityPartitionName_4040Parser == null) {
			activityPartitionName_4040Parser = createActivityPartitionName_4040Parser();
		}
		return activityPartitionName_4040Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createActivityPartitionName_4040Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser opaqueActionName_4035Parser;

	/**
	 * @generated
	 */
	private IParser getOpaqueActionName_4035Parser() {
		if (opaqueActionName_4035Parser == null) {
			opaqueActionName_4035Parser = createOpaqueActionName_4035Parser();
		}
		return opaqueActionName_4035Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createOpaqueActionName_4035Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser opaqueActionName_4036Parser;

	/**
	 * @generated
	 */
	private IParser getOpaqueActionName_4036Parser() {
		if (opaqueActionName_4036Parser == null) {
			opaqueActionName_4036Parser = createOpaqueActionName_4036Parser();
		}
		return opaqueActionName_4036Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createOpaqueActionName_4036Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		return new OnlyStereotypesNamesParser();

	}

	/**
	 * @generated
	 */
	private IParser acceptEventActionName_4037Parser;

	/**
	 * @generated
	 */
	private IParser getAcceptEventActionName_4037Parser() {
		if (acceptEventActionName_4037Parser == null) {
			acceptEventActionName_4037Parser = createAcceptEventActionName_4037Parser();
		}
		return acceptEventActionName_4037Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAcceptEventActionName_4037Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser acceptEventActionName_4038Parser;

	/**
	 * @generated
	 */
	private IParser getAcceptEventActionName_4038Parser() {
		if (acceptEventActionName_4038Parser == null) {
			acceptEventActionName_4038Parser = createAcceptEventActionName_4038Parser();
		}
		return acceptEventActionName_4038Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAcceptEventActionName_4038Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		return new OnlyStereotypesNamesParser();

	}

	/**
	 * @generated
	 */
	private IParser controlFlowName_4043Parser;

	/**
	 * @generated
	 */
	private IParser getControlFlowName_4043Parser() {
		if (controlFlowName_4043Parser == null) {
			controlFlowName_4043Parser = createControlFlowName_4043Parser();
		}
		return controlFlowName_4043Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createControlFlowName_4043Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser objectFlowName_4044Parser;

	/**
	 * @generated
	 */
	private IParser getObjectFlowName_4044Parser() {
		if (objectFlowName_4044Parser == null) {
			objectFlowName_4044Parser = createObjectFlowName_4044Parser();
		}
		return objectFlowName_4044Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createObjectFlowName_4044Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createDataStoreNodeName_5034Parser() {
		return new ObjectNodeTypeParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createDataStoreNodeName_5036Parser() {
		return new ObjectNodeInStateParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createOutputPinName_5003Parser() {
		return new ObjectNodeTypeParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPinName_5024Parser() {
		return new ObjectNodeTypeParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createOutputPinName_5004Parser() {
		return new ObjectNodeTypeParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createInputPinName_5006Parser() {
		return new ObjectNodeTypeParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createInputPinName_5007Parser() {
		return new ObjectNodeTypeParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createInputPinName_5008Parser() {
		return new ObjectNodeTypeParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createOutputPinName_5010Parser() {
		return new ObjectNodeTypeParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createInputPinName_5011Parser() {
		return new ObjectNodeTypeParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createInputPinName_5013Parser() {
		return new ObjectNodeTypeParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPinName_5016Parser() {
		return new ObjectNodeTypeParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createDataStoreNodeName_5035Parser() {
		return new ObjectNodeTypeParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createDataStoreNodeName_5037Parser() {
		return new ObjectNodeInStateParser();
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ActivityNameEditPart.VISUAL_ID:
			return getActivityName_4042Parser();
		case CommentBodyEditPart.VISUAL_ID:
			return getCommentBody_4039Parser();
		case SendObjectActionNameEditPart.VISUAL_ID:
			return getSendObjectActionName_4004Parser();
		case SendObjectActionName2EditPart.VISUAL_ID:
			return getSendObjectActionName_4005Parser();
		case InputPinNameEditPart.VISUAL_ID:
			return getInputPinName_4001Parser();
		case InputPinName2EditPart.VISUAL_ID:
			return getInputPinName_4002Parser();
		case ValuePinNameEditPart.VISUAL_ID:
			return getValuePinName_4003Parser();
		case SendSignalActionNameEditPart.VISUAL_ID:
			return getSendSignalActionName_4007Parser();
		case SendSignalActionName2EditPart.VISUAL_ID:
			return getSendSignalActionName_4008Parser();
		case InputPinName3EditPart.VISUAL_ID:
			return getInputPinName_4006Parser();
		case AcceptEventActionNameEditPart.VISUAL_ID:
			return getAcceptEventActionName_4010Parser();
		case AcceptEventActionName2EditPart.VISUAL_ID:
			return getAcceptEventActionName_4011Parser();
		case OutputPinNameEditPart.VISUAL_ID:
			return getOutputPinName_4009Parser();
		case ActivityFinalNodeNameEditPart.VISUAL_ID:
			return getActivityFinalNodeName_4012Parser();
		case DecisionNodeNameEditPart.VISUAL_ID:
			return getDecisionNodeName_4013Parser();
		case MergeNodeNameEditPart.VISUAL_ID:
			return getMergeNodeName_4014Parser();
		case InitialNodeNameEditPart.VISUAL_ID:
			return getInitialNodeName_4015Parser();
		case DataStoreNodeNameEditPart.VISUAL_ID:
			return getDataStoreNodeName_4016Parser();
		case OpaqueActionNameEditPart.VISUAL_ID:
			return getOpaqueActionName_4020Parser();
		case OpaqueActionName2EditPart.VISUAL_ID:
			return getOpaqueActionName_4021Parser();
		case OutputPinName2EditPart.VISUAL_ID:
			return getOutputPinName_4017Parser();
		case InputPinName4EditPart.VISUAL_ID:
			return getInputPinName_4018Parser();
		case ValuePinName2EditPart.VISUAL_ID:
			return getValuePinName_4019Parser();
		case FlowFinalNodeNameEditPart.VISUAL_ID:
			return getFlowFinalNodeName_4022Parser();
		case PinNameEditPart.VISUAL_ID:
			return getPinName_4023Parser();
		case CreateObjectActionNameEditPart.VISUAL_ID:
			return getCreateObjectActionName_4025Parser();
		case CreateObjectActionName2EditPart.VISUAL_ID:
			return getCreateObjectActionName_4026Parser();
		case OutputPinName3EditPart.VISUAL_ID:
			return getOutputPinName_4024Parser();
		case CallBehaviorActionNameEditPart.VISUAL_ID:
			return getCallBehaviorActionName_4029Parser();
		case CallBehaviorActionName2EditPart.VISUAL_ID:
			return getCallBehaviorActionName_4030Parser();
		case OutputPinName4EditPart.VISUAL_ID:
			return getOutputPinName_4027Parser();
		case InputPinName5EditPart.VISUAL_ID:
			return getInputPinName_4028Parser();
		case CallOperationActionNameEditPart.VISUAL_ID:
			return getCallOperationActionName_4032Parser();
		case CallOperationActionName2EditPart.VISUAL_ID:
			return getCallOperationActionName_4033Parser();
		case InputPinName6EditPart.VISUAL_ID:
			return getInputPinName_4031Parser();
		case ActivityParameterNodeNameEditPart.VISUAL_ID:
			return getActivityParameterNodeName_4034Parser();
		case ActivityPartitionNameEditPart.VISUAL_ID:
			return getActivityPartitionName_4041Parser();
		case ActivityPartitionName2EditPart.VISUAL_ID:
			return getActivityPartitionName_4040Parser();
		case OpaqueActionName3EditPart.VISUAL_ID:
			return getOpaqueActionName_4035Parser();
		case OpaqueActionName4EditPart.VISUAL_ID:
			return getOpaqueActionName_4036Parser();
		case AcceptEventActionName3EditPart.VISUAL_ID:
			return getAcceptEventActionName_4037Parser();
		case AcceptEventActionName4EditPart.VISUAL_ID:
			return getAcceptEventActionName_4038Parser();
		case ControlFlowNameEditPart.VISUAL_ID:
			return getControlFlowName_4043Parser();
		case ObjectFlowNameEditPart.VISUAL_ID:
			return getObjectFlowName_4044Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (UMLElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static class HintAdapter extends ParserHintAdapter {

		private final IElementType elementType;

		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		@Override
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
