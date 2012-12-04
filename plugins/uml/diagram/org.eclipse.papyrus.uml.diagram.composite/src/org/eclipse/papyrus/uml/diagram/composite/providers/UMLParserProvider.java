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
package org.eclipse.papyrus.uml.diagram.composite.providers;

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
import org.eclipse.papyrus.uml.diagram.common.parser.CommentParser;
import org.eclipse.papyrus.uml.diagram.common.parser.ConstraintParser;
import org.eclipse.papyrus.uml.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.papyrus.uml.diagram.composite.custom.parsers.RoleBindingRoleNameParser;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.*;
import org.eclipse.papyrus.uml.diagram.composite.parsers.MessageFormatParser;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser activityName_5112Parser;

	/**
	 * @generated
	 */
	private IParser getActivityName_5112Parser() {
		if(activityName_5112Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			activityName_5112Parser = parser;
		}
		return activityName_5112Parser;
	}

	/**
	 * @generated
	 */
	private IParser interactionName_5113Parser;

	/**
	 * @generated
	 */
	private IParser getInteractionName_5113Parser() {
		if(interactionName_5113Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			interactionName_5113Parser = parser;
		}
		return interactionName_5113Parser;
	}

	/**
	 * @generated
	 */
	private IParser protocolStateMachineName_5114Parser;

	/**
	 * @generated
	 */
	private IParser getProtocolStateMachineName_5114Parser() {
		if(protocolStateMachineName_5114Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			protocolStateMachineName_5114Parser = parser;
		}
		return protocolStateMachineName_5114Parser;
	}

	/**
	 * @generated
	 */
	private IParser stateMachineName_5115Parser;

	/**
	 * @generated
	 */
	private IParser getStateMachineName_5115Parser() {
		if(stateMachineName_5115Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			stateMachineName_5115Parser = parser;
		}
		return stateMachineName_5115Parser;
	}

	/**
	 * @generated
	 */
	private IParser functionBehaviorName_5116Parser;

	/**
	 * @generated
	 */
	private IParser getFunctionBehaviorName_5116Parser() {
		if(functionBehaviorName_5116Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			functionBehaviorName_5116Parser = parser;
		}
		return functionBehaviorName_5116Parser;
	}

	/**
	 * @generated
	 */
	private IParser opaqueBehaviorName_5117Parser;

	/**
	 * @generated
	 */
	private IParser getOpaqueBehaviorName_5117Parser() {
		if(opaqueBehaviorName_5117Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			opaqueBehaviorName_5117Parser = parser;
		}
		return opaqueBehaviorName_5117Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentName_5121Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_5121Parser() {
		if(componentName_5121Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			componentName_5121Parser = parser;
		}
		return componentName_5121Parser;
	}

	/**
	 * @generated
	 */
	private IParser deviceName_5122Parser;

	/**
	 * @generated
	 */
	private IParser getDeviceName_5122Parser() {
		if(deviceName_5122Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			deviceName_5122Parser = parser;
		}
		return deviceName_5122Parser;
	}

	/**
	 * @generated
	 */
	private IParser executionEnvironmentName_5123Parser;

	/**
	 * @generated
	 */
	private IParser getExecutionEnvironmentName_5123Parser() {
		if(executionEnvironmentName_5123Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			executionEnvironmentName_5123Parser = parser;
		}
		return executionEnvironmentName_5123Parser;
	}

	/**
	 * @generated
	 */
	private IParser nodeName_5124Parser;

	/**
	 * @generated
	 */
	private IParser getNodeName_5124Parser() {
		if(nodeName_5124Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			nodeName_5124Parser = parser;
		}
		return nodeName_5124Parser;
	}

	/**
	 * @generated
	 */
	private IParser className_5156Parser;

	/**
	 * @generated
	 */
	private IParser getClassName_5156Parser() {
		if(className_5156Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			className_5156Parser = parser;
		}
		return className_5156Parser;
	}

	/**
	 * @generated
	 */
	private IParser collaborationName_5158Parser;

	/**
	 * @generated
	 */
	private IParser getCollaborationName_5158Parser() {
		if(collaborationName_5158Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			collaborationName_5158Parser = parser;
		}
		return collaborationName_5158Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceName_5159Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceName_5159Parser() {
		if(interfaceName_5159Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			interfaceName_5159Parser = parser;
		}
		return interfaceName_5159Parser;
	}

	/**
	 * @generated
	 */
	private IParser primitiveTypeName_5118Parser;

	/**
	 * @generated
	 */
	private IParser getPrimitiveTypeName_5118Parser() {
		if(primitiveTypeName_5118Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			primitiveTypeName_5118Parser = parser;
		}
		return primitiveTypeName_5118Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumerationName_5119Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationName_5119Parser() {
		if(enumerationName_5119Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			enumerationName_5119Parser = parser;
		}
		return enumerationName_5119Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataTypeName_5120Parser;

	/**
	 * @generated
	 */
	private IParser getDataTypeName_5120Parser() {
		if(dataTypeName_5120Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataTypeName_5120Parser = parser;
		}
		return dataTypeName_5120Parser;
	}

	/**
	 * @generated
	 */
	private IParser actorName_5160Parser;

	/**
	 * @generated
	 */
	private IParser getActorName_5160Parser() {
		if(actorName_5160Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			actorName_5160Parser = parser;
		}
		return actorName_5160Parser;
	}

	/**
	 * @generated
	 */
	private IParser deploymentSpecificationName_5161Parser;

	/**
	 * @generated
	 */
	private IParser getDeploymentSpecificationName_5161Parser() {
		if(deploymentSpecificationName_5161Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			deploymentSpecificationName_5161Parser = parser;
		}
		return deploymentSpecificationName_5161Parser;
	}

	/**
	 * @generated
	 */
	private IParser artifactName_5162Parser;

	/**
	 * @generated
	 */
	private IParser getArtifactName_5162Parser() {
		if(artifactName_5162Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			artifactName_5162Parser = parser;
		}
		return artifactName_5162Parser;
	}

	/**
	 * @generated
	 */
	private IParser informationItemName_5163Parser;

	/**
	 * @generated
	 */
	private IParser getInformationItemName_5163Parser() {
		if(informationItemName_5163Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			informationItemName_5163Parser = parser;
		}
		return informationItemName_5163Parser;
	}

	/**
	 * @generated
	 */
	private IParser signalName_5164Parser;

	/**
	 * @generated
	 */
	private IParser getSignalName_5164Parser() {
		if(signalName_5164Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			signalName_5164Parser = parser;
		}
		return signalName_5164Parser;
	}

	/**
	 * @generated
	 */
	private IParser useCaseName_5165Parser;

	/**
	 * @generated
	 */
	private IParser getUseCaseName_5165Parser() {
		if(useCaseName_5165Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			useCaseName_5165Parser = parser;
		}
		return useCaseName_5165Parser;
	}

	/**
	 * @generated
	 */
	private IParser signalEventName_5166Parser;

	/**
	 * @generated
	 */
	private IParser getSignalEventName_5166Parser() {
		if(signalEventName_5166Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			signalEventName_5166Parser = parser;
		}
		return signalEventName_5166Parser;
	}

	/**
	 * @generated
	 */
	private IParser callEventName_5167Parser;

	/**
	 * @generated
	 */
	private IParser getCallEventName_5167Parser() {
		if(callEventName_5167Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			callEventName_5167Parser = parser;
		}
		return callEventName_5167Parser;
	}

	/**
	 * @generated
	 */
	private IParser anyReceiveEventName_5168Parser;

	/**
	 * @generated
	 */
	private IParser getAnyReceiveEventName_5168Parser() {
		if(anyReceiveEventName_5168Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			anyReceiveEventName_5168Parser = parser;
		}
		return anyReceiveEventName_5168Parser;
	}

	/**
	 * @generated
	 */
	private IParser changeEventName_5171Parser;

	/**
	 * @generated
	 */
	private IParser getChangeEventName_5171Parser() {
		if(changeEventName_5171Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			changeEventName_5171Parser = parser;
		}
		return changeEventName_5171Parser;
	}

	/**
	 * @generated
	 */
	private IParser timeEventName_5172Parser;

	/**
	 * @generated
	 */
	private IParser getTimeEventName_5172Parser() {
		if(timeEventName_5172Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			timeEventName_5172Parser = parser;
		}
		return timeEventName_5172Parser;
	}

	/**
	 * @generated
	 */
	private IParser durationObservationName_5151Parser;

	/**
	 * @generated
	 */
	private IParser getDurationObservationName_5151Parser() {
		if(durationObservationName_5151Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			durationObservationName_5151Parser = parser;
		}
		return durationObservationName_5151Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser durationObservationName_5152Parser;

	/**
	 * @generated
	 */
	private IParser getDurationObservationName_5152Parser() {
		if(durationObservationName_5152Parser == null) {
			durationObservationName_5152Parser = new AppliedStereotypeParser();
		}
		return durationObservationName_5152Parser;
	}

	/**
	 * @generated
	 */
	private IParser timeObservationName_5142Parser;

	/**
	 * @generated
	 */
	private IParser getTimeObservationName_5142Parser() {
		if(timeObservationName_5142Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			timeObservationName_5142Parser = parser;
		}
		return timeObservationName_5142Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser timeObservationName_5143Parser;

	/**
	 * @generated
	 */
	private IParser getTimeObservationName_5143Parser() {
		if(timeObservationName_5143Parser == null) {
			timeObservationName_5143Parser = new AppliedStereotypeParser();
		}
		return timeObservationName_5143Parser;
	}

	/**
	 * @generated
	 */
	private IParser literalBooleanName_5178Parser;

	/**
	 * @generated
	 */
	private IParser getLiteralBooleanName_5178Parser() {
		if(literalBooleanName_5178Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			literalBooleanName_5178Parser = parser;
		}
		return literalBooleanName_5178Parser;
	}

	/**
	 * @generated
	 */
	private IParser literalIntegerName_5179Parser;

	/**
	 * @generated
	 */
	private IParser getLiteralIntegerName_5179Parser() {
		if(literalIntegerName_5179Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			literalIntegerName_5179Parser = parser;
		}
		return literalIntegerName_5179Parser;
	}

	/**
	 * @generated
	 */
	private IParser literalNullName_5180Parser;

	/**
	 * @generated
	 */
	private IParser getLiteralNullName_5180Parser() {
		if(literalNullName_5180Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			literalNullName_5180Parser = parser;
		}
		return literalNullName_5180Parser;
	}

	/**
	 * @generated
	 */
	private IParser literalStringName_5181Parser;

	/**
	 * @generated
	 */
	private IParser getLiteralStringName_5181Parser() {
		if(literalStringName_5181Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			literalStringName_5181Parser = parser;
		}
		return literalStringName_5181Parser;
	}

	/**
	 * @generated
	 */
	private IParser literalUnlimitedNaturalName_5182Parser;

	/**
	 * @generated
	 */
	private IParser getLiteralUnlimitedNaturalName_5182Parser() {
		if(literalUnlimitedNaturalName_5182Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			literalUnlimitedNaturalName_5182Parser = parser;
		}
		return literalUnlimitedNaturalName_5182Parser;
	}

	/**
	 * @generated
	 */
	private IParser stringExpressionName_5183Parser;

	/**
	 * @generated
	 */
	private IParser getStringExpressionName_5183Parser() {
		if(stringExpressionName_5183Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			stringExpressionName_5183Parser = parser;
		}
		return stringExpressionName_5183Parser;
	}

	/**
	 * @generated
	 */
	private IParser opaqueExpressionName_5184Parser;

	/**
	 * @generated
	 */
	private IParser getOpaqueExpressionName_5184Parser() {
		if(opaqueExpressionName_5184Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			opaqueExpressionName_5184Parser = parser;
		}
		return opaqueExpressionName_5184Parser;
	}

	/**
	 * @generated
	 */
	private IParser timeExpressionName_5185Parser;

	/**
	 * @generated
	 */
	private IParser getTimeExpressionName_5185Parser() {
		if(timeExpressionName_5185Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			timeExpressionName_5185Parser = parser;
		}
		return timeExpressionName_5185Parser;
	}

	/**
	 * @generated
	 */
	private IParser expressionName_5186Parser;

	/**
	 * @generated
	 */
	private IParser getExpressionName_5186Parser() {
		if(expressionName_5186Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			expressionName_5186Parser = parser;
		}
		return expressionName_5186Parser;
	}

	/**
	 * @generated
	 */
	private IParser durationName_5187Parser;

	/**
	 * @generated
	 */
	private IParser getDurationName_5187Parser() {
		if(durationName_5187Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			durationName_5187Parser = parser;
		}
		return durationName_5187Parser;
	}

	/**
	 * @generated
	 */
	private IParser timeIntervalName_5188Parser;

	/**
	 * @generated
	 */
	private IParser getTimeIntervalName_5188Parser() {
		if(timeIntervalName_5188Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			timeIntervalName_5188Parser = parser;
		}
		return timeIntervalName_5188Parser;
	}

	/**
	 * @generated
	 */
	private IParser durationIntervalName_5189Parser;

	/**
	 * @generated
	 */
	private IParser getDurationIntervalName_5189Parser() {
		if(durationIntervalName_5189Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			durationIntervalName_5189Parser = parser;
		}
		return durationIntervalName_5189Parser;
	}

	/**
	 * @generated
	 */
	private IParser intervalName_5190Parser;

	/**
	 * @generated
	 */
	private IParser getIntervalName_5190Parser() {
		if(intervalName_5190Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			intervalName_5190Parser = parser;
		}
		return intervalName_5190Parser;
	}

	/**
	 * @generated
	 */
	private IParser instanceValueName_5191Parser;

	/**
	 * @generated
	 */
	private IParser getInstanceValueName_5191Parser() {
		if(instanceValueName_5191Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			instanceValueName_5191Parser = parser;
		}
		return instanceValueName_5191Parser;
	}

	/**
	 * @generated
	 */
	private CommentParser commentBody_5192Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_5192Parser() {
		if(commentBody_5192Parser == null) {
			commentBody_5192Parser = new CommentParser();
		}
		return commentBody_5192Parser;
	}

	/**
	 * @generated
	 */
	private IParser durationConstraintName_5193Parser;

	/**
	 * @generated
	 */
	private IParser getDurationConstraintName_5193Parser() {
		if(durationConstraintName_5193Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			durationConstraintName_5193Parser = parser;
		}
		return durationConstraintName_5193Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser durationConstraintSpecification_6035Parser;

	/**
	 * @generated
	 */
	private IParser getDurationConstraintSpecification_6035Parser() {
		if(durationConstraintSpecification_6035Parser == null) {
			durationConstraintSpecification_6035Parser = new ConstraintParser();
		}
		return durationConstraintSpecification_6035Parser;
	}

	/**
	 * @generated
	 */
	private IParser timeConstraintName_5194Parser;

	/**
	 * @generated
	 */
	private IParser getTimeConstraintName_5194Parser() {
		if(timeConstraintName_5194Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			timeConstraintName_5194Parser = parser;
		}
		return timeConstraintName_5194Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser timeConstraintSpecification_6036Parser;

	/**
	 * @generated
	 */
	private IParser getTimeConstraintSpecification_6036Parser() {
		if(timeConstraintSpecification_6036Parser == null) {
			timeConstraintSpecification_6036Parser = new ConstraintParser();
		}
		return timeConstraintSpecification_6036Parser;
	}

	/**
	 * @generated
	 */
	private IParser intervalConstraintName_5195Parser;

	/**
	 * @generated
	 */
	private IParser getIntervalConstraintName_5195Parser() {
		if(intervalConstraintName_5195Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			intervalConstraintName_5195Parser = parser;
		}
		return intervalConstraintName_5195Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser intervalConstraintSpecification_6037Parser;

	/**
	 * @generated
	 */
	private IParser getIntervalConstraintSpecification_6037Parser() {
		if(intervalConstraintSpecification_6037Parser == null) {
			intervalConstraintSpecification_6037Parser = new ConstraintParser();
		}
		return intervalConstraintSpecification_6037Parser;
	}

	/**
	 * @generated
	 */
	private IParser interactionConstraintName_5196Parser;

	/**
	 * @generated
	 */
	private IParser getInteractionConstraintName_5196Parser() {
		if(interactionConstraintName_5196Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			interactionConstraintName_5196Parser = parser;
		}
		return interactionConstraintName_5196Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser interactionConstraintSpecification_6038Parser;

	/**
	 * @generated
	 */
	private IParser getInteractionConstraintSpecification_6038Parser() {
		if(interactionConstraintSpecification_6038Parser == null) {
			interactionConstraintSpecification_6038Parser = new ConstraintParser();
		}
		return interactionConstraintSpecification_6038Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_5197Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_5197Parser() {
		if(constraintName_5197Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintName_5197Parser = parser;
		}
		return constraintName_5197Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser constraintSpecification_6039Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintSpecification_6039Parser() {
		if(constraintSpecification_6039Parser == null) {
			constraintSpecification_6039Parser = new ConstraintParser();
		}
		return constraintSpecification_6039Parser;
	}

	/**
	 * @generated
	 */
	private IParser portName_5125Parser;

	/**
	 * @generated
	 */
	private IParser getPortName_5125Parser() {
		if(portName_5125Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			portName_5125Parser = parser;
		}
		return portName_5125Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser portName_6029Parser;

	/**
	 * @generated
	 */
	private IParser getPortName_6029Parser() {
		if(portName_6029Parser == null) {
			portName_6029Parser = new AppliedStereotypeParser();
		}
		return portName_6029Parser;
	}

	/**
	 * @generated
	 */
	private IParser parameterName_6033Parser;

	/**
	 * @generated
	 */
	private IParser getParameterName_6033Parser() {
		if(parameterName_6033Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parameterName_6033Parser = parser;
		}
		return parameterName_6033Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser parameterName_6034Parser;

	/**
	 * @generated
	 */
	private IParser getParameterName_6034Parser() {
		if(parameterName_6034Parser == null) {
			parameterName_6034Parser = new AppliedStereotypeParser();
		}
		return parameterName_6034Parser;
	}

	/**
	 * @generated
	 */
	private IParser propertyName_5126Parser;

	/**
	 * @generated
	 */
	private IParser getPropertyName_5126Parser() {
		if(propertyName_5126Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			propertyName_5126Parser = parser;
		}
		return propertyName_5126Parser;
	}

	/**
	 * @generated
	 */
	private IParser connectableElementName_5198Parser;

	/**
	 * @generated
	 */
	private IParser getConnectableElementName_5198Parser() {
		if(connectableElementName_5198Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			connectableElementName_5198Parser = parser;
		}
		return connectableElementName_5198Parser;
	}

	/**
	 * @generated
	 */
	private IParser collaborationUseName_5127Parser;

	/**
	 * @generated
	 */
	private IParser getCollaborationUseName_5127Parser() {
		if(collaborationUseName_5127Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			collaborationUseName_5127Parser = parser;
		}
		return collaborationUseName_5127Parser;
	}

	/**
	 * @generated
	 */
	private IParser activityName_5128Parser;

	/**
	 * @generated
	 */
	private IParser getActivityName_5128Parser() {
		if(activityName_5128Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			activityName_5128Parser = parser;
		}
		return activityName_5128Parser;
	}

	/**
	 * @generated
	 */
	private IParser interactionName_5129Parser;

	/**
	 * @generated
	 */
	private IParser getInteractionName_5129Parser() {
		if(interactionName_5129Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			interactionName_5129Parser = parser;
		}
		return interactionName_5129Parser;
	}

	/**
	 * @generated
	 */
	private IParser protocolStateMachineName_5130Parser;

	/**
	 * @generated
	 */
	private IParser getProtocolStateMachineName_5130Parser() {
		if(protocolStateMachineName_5130Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			protocolStateMachineName_5130Parser = parser;
		}
		return protocolStateMachineName_5130Parser;
	}

	/**
	 * @generated
	 */
	private IParser stateMachineName_5131Parser;

	/**
	 * @generated
	 */
	private IParser getStateMachineName_5131Parser() {
		if(stateMachineName_5131Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			stateMachineName_5131Parser = parser;
		}
		return stateMachineName_5131Parser;
	}

	/**
	 * @generated
	 */
	private IParser functionBehaviorName_5132Parser;

	/**
	 * @generated
	 */
	private IParser getFunctionBehaviorName_5132Parser() {
		if(functionBehaviorName_5132Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			functionBehaviorName_5132Parser = parser;
		}
		return functionBehaviorName_5132Parser;
	}

	/**
	 * @generated
	 */
	private IParser opaqueBehaviorName_5133Parser;

	/**
	 * @generated
	 */
	private IParser getOpaqueBehaviorName_5133Parser() {
		if(opaqueBehaviorName_5133Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			opaqueBehaviorName_5133Parser = parser;
		}
		return opaqueBehaviorName_5133Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentName_5137Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_5137Parser() {
		if(componentName_5137Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			componentName_5137Parser = parser;
		}
		return componentName_5137Parser;
	}

	/**
	 * @generated
	 */
	private IParser deviceName_5138Parser;

	/**
	 * @generated
	 */
	private IParser getDeviceName_5138Parser() {
		if(deviceName_5138Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			deviceName_5138Parser = parser;
		}
		return deviceName_5138Parser;
	}

	/**
	 * @generated
	 */
	private IParser executionEnvironmentName_5139Parser;

	/**
	 * @generated
	 */
	private IParser getExecutionEnvironmentName_5139Parser() {
		if(executionEnvironmentName_5139Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			executionEnvironmentName_5139Parser = parser;
		}
		return executionEnvironmentName_5139Parser;
	}

	/**
	 * @generated
	 */
	private IParser nodeName_5140Parser;

	/**
	 * @generated
	 */
	private IParser getNodeName_5140Parser() {
		if(nodeName_5140Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			nodeName_5140Parser = parser;
		}
		return nodeName_5140Parser;
	}

	/**
	 * @generated
	 */
	private IParser className_5155Parser;

	/**
	 * @generated
	 */
	private IParser getClassName_5155Parser() {
		if(className_5155Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			className_5155Parser = parser;
		}
		return className_5155Parser;
	}

	/**
	 * @generated
	 */
	private IParser collaborationName_5141Parser;

	/**
	 * @generated
	 */
	private IParser getCollaborationName_5141Parser() {
		if(collaborationName_5141Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			collaborationName_5141Parser = parser;
		}
		return collaborationName_5141Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceName_5154Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceName_5154Parser() {
		if(interfaceName_5154Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			interfaceName_5154Parser = parser;
		}
		return interfaceName_5154Parser;
	}

	/**
	 * @generated
	 */
	private IParser primitiveTypeName_5134Parser;

	/**
	 * @generated
	 */
	private IParser getPrimitiveTypeName_5134Parser() {
		if(primitiveTypeName_5134Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			primitiveTypeName_5134Parser = parser;
		}
		return primitiveTypeName_5134Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumerationName_5135Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationName_5135Parser() {
		if(enumerationName_5135Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			enumerationName_5135Parser = parser;
		}
		return enumerationName_5135Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataTypeName_5136Parser;

	/**
	 * @generated
	 */
	private IParser getDataTypeName_5136Parser() {
		if(dataTypeName_5136Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataTypeName_5136Parser = parser;
		}
		return dataTypeName_5136Parser;
	}

	/**
	 * @generated
	 */
	private IParser actorName_5144Parser;

	/**
	 * @generated
	 */
	private IParser getActorName_5144Parser() {
		if(actorName_5144Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			actorName_5144Parser = parser;
		}
		return actorName_5144Parser;
	}

	/**
	 * @generated
	 */
	private IParser deploymentSpecificationName_5145Parser;

	/**
	 * @generated
	 */
	private IParser getDeploymentSpecificationName_5145Parser() {
		if(deploymentSpecificationName_5145Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			deploymentSpecificationName_5145Parser = parser;
		}
		return deploymentSpecificationName_5145Parser;
	}

	/**
	 * @generated
	 */
	private IParser artifactName_5146Parser;

	/**
	 * @generated
	 */
	private IParser getArtifactName_5146Parser() {
		if(artifactName_5146Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			artifactName_5146Parser = parser;
		}
		return artifactName_5146Parser;
	}

	/**
	 * @generated
	 */
	private IParser informationItemName_5147Parser;

	/**
	 * @generated
	 */
	private IParser getInformationItemName_5147Parser() {
		if(informationItemName_5147Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			informationItemName_5147Parser = parser;
		}
		return informationItemName_5147Parser;
	}

	/**
	 * @generated
	 */
	private IParser signalName_5148Parser;

	/**
	 * @generated
	 */
	private IParser getSignalName_5148Parser() {
		if(signalName_5148Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			signalName_5148Parser = parser;
		}
		return signalName_5148Parser;
	}

	/**
	 * @generated
	 */
	private IParser useCaseName_5149Parser;

	/**
	 * @generated
	 */
	private IParser getUseCaseName_5149Parser() {
		if(useCaseName_5149Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			useCaseName_5149Parser = parser;
		}
		return useCaseName_5149Parser;
	}

	/**
	 * @generated
	 */
	private CommentParser commentBody_5150Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_5150Parser() {
		if(commentBody_5150Parser == null) {
			commentBody_5150Parser = new CommentParser();
		}
		return commentBody_5150Parser;
	}

	/**
	 * @generated
	 */
	private IParser durationConstraintName_6040Parser;

	/**
	 * @generated
	 */
	private IParser getDurationConstraintName_6040Parser() {
		if(durationConstraintName_6040Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			durationConstraintName_6040Parser = parser;
		}
		return durationConstraintName_6040Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser durationConstraintSpecification_6041Parser;

	/**
	 * @generated
	 */
	private IParser getDurationConstraintSpecification_6041Parser() {
		if(durationConstraintSpecification_6041Parser == null) {
			durationConstraintSpecification_6041Parser = new ConstraintParser();
		}
		return durationConstraintSpecification_6041Parser;
	}

	/**
	 * @generated
	 */
	private IParser timeConstraintName_6042Parser;

	/**
	 * @generated
	 */
	private IParser getTimeConstraintName_6042Parser() {
		if(timeConstraintName_6042Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			timeConstraintName_6042Parser = parser;
		}
		return timeConstraintName_6042Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser timeConstraintSpecification_6043Parser;

	/**
	 * @generated
	 */
	private IParser getTimeConstraintSpecification_6043Parser() {
		if(timeConstraintSpecification_6043Parser == null) {
			timeConstraintSpecification_6043Parser = new ConstraintParser();
		}
		return timeConstraintSpecification_6043Parser;
	}

	/**
	 * @generated
	 */
	private IParser intervalConstraintName_6044Parser;

	/**
	 * @generated
	 */
	private IParser getIntervalConstraintName_6044Parser() {
		if(intervalConstraintName_6044Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			intervalConstraintName_6044Parser = parser;
		}
		return intervalConstraintName_6044Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser intervalConstraintSpecification_6045Parser;

	/**
	 * @generated
	 */
	private IParser getIntervalConstraintSpecification_6045Parser() {
		if(intervalConstraintSpecification_6045Parser == null) {
			intervalConstraintSpecification_6045Parser = new ConstraintParser();
		}
		return intervalConstraintSpecification_6045Parser;
	}

	/**
	 * @generated
	 */
	private IParser interactionConstraintName_6046Parser;

	/**
	 * @generated
	 */
	private IParser getInteractionConstraintName_6046Parser() {
		if(interactionConstraintName_6046Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			interactionConstraintName_6046Parser = parser;
		}
		return interactionConstraintName_6046Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser interactionConstraintSpecification_6047Parser;

	/**
	 * @generated
	 */
	private IParser getInteractionConstraintSpecification_6047Parser() {
		if(interactionConstraintSpecification_6047Parser == null) {
			interactionConstraintSpecification_6047Parser = new ConstraintParser();
		}
		return interactionConstraintSpecification_6047Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_6048Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_6048Parser() {
		if(constraintName_6048Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintName_6048Parser = parser;
		}
		return constraintName_6048Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser constraintSpecification_6049Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintSpecification_6049Parser() {
		if(constraintSpecification_6049Parser == null) {
			constraintSpecification_6049Parser = new ConstraintParser();
		}
		return constraintSpecification_6049Parser;
	}

	/**
	 * @generated
	 */
	private IParser property_3101Parser;

	/**
	 * @generated
	 */
	private IParser getProperty_3101Parser() {
		if(property_3101Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			property_3101Parser = parser;
		}
		return property_3101Parser;
	}

	/**
	 * @generated
	 */
	private IParser operation_3102Parser;

	/**
	 * @generated
	 */
	private IParser getOperation_3102Parser() {
		if(operation_3102Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			operation_3102Parser = parser;
		}
		return operation_3102Parser;
	}

	/**
	 * @generated
	 */
	private IParser reception_3100Parser;

	/**
	 * @generated
	 */
	private IParser getReception_3100Parser() {
		if(reception_3100Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			reception_3100Parser = parser;
		}
		return reception_3100Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumerationLiteral_3066Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationLiteral_3066Parser() {
		if(enumerationLiteral_3066Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			enumerationLiteral_3066Parser = parser;
		}
		return enumerationLiteral_3066Parser;
	}

	/**
	 * @generated
	 */
	private IParser activity_3103Parser;

	/**
	 * @generated
	 */
	private IParser getActivity_3103Parser() {
		if(activity_3103Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			activity_3103Parser = parser;
		}
		return activity_3103Parser;
	}

	/**
	 * @generated
	 */
	private IParser interaction_3104Parser;

	/**
	 * @generated
	 */
	private IParser getInteraction_3104Parser() {
		if(interaction_3104Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			interaction_3104Parser = parser;
		}
		return interaction_3104Parser;
	}

	/**
	 * @generated
	 */
	private IParser protocolStateMachine_3105Parser;

	/**
	 * @generated
	 */
	private IParser getProtocolStateMachine_3105Parser() {
		if(protocolStateMachine_3105Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			protocolStateMachine_3105Parser = parser;
		}
		return protocolStateMachine_3105Parser;
	}

	/**
	 * @generated
	 */
	private IParser stateMachine_3106Parser;

	/**
	 * @generated
	 */
	private IParser getStateMachine_3106Parser() {
		if(stateMachine_3106Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			stateMachine_3106Parser = parser;
		}
		return stateMachine_3106Parser;
	}

	/**
	 * @generated
	 */
	private IParser functionBehavior_3107Parser;

	/**
	 * @generated
	 */
	private IParser getFunctionBehavior_3107Parser() {
		if(functionBehavior_3107Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			functionBehavior_3107Parser = parser;
		}
		return functionBehavior_3107Parser;
	}

	/**
	 * @generated
	 */
	private IParser opaqueBehavior_3108Parser;

	/**
	 * @generated
	 */
	private IParser getOpaqueBehavior_3108Parser() {
		if(opaqueBehavior_3108Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			opaqueBehavior_3108Parser = parser;
		}
		return opaqueBehavior_3108Parser;
	}

	/**
	 * @generated
	 */
	private IParser collaboration_3109Parser;

	/**
	 * @generated
	 */
	private IParser getCollaboration_3109Parser() {
		if(collaboration_3109Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			collaboration_3109Parser = parser;
		}
		return collaboration_3109Parser;
	}

	/**
	 * @generated
	 */
	private IParser interface_3110Parser;

	/**
	 * @generated
	 */
	private IParser getInterface_3110Parser() {
		if(interface_3110Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			interface_3110Parser = parser;
		}
		return interface_3110Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumeration_3111Parser;

	/**
	 * @generated
	 */
	private IParser getEnumeration_3111Parser() {
		if(enumeration_3111Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			enumeration_3111Parser = parser;
		}
		return enumeration_3111Parser;
	}

	/**
	 * @generated
	 */
	private IParser primitiveType_3112Parser;

	/**
	 * @generated
	 */
	private IParser getPrimitiveType_3112Parser() {
		if(primitiveType_3112Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			primitiveType_3112Parser = parser;
		}
		return primitiveType_3112Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataType_3113Parser;

	/**
	 * @generated
	 */
	private IParser getDataType_3113Parser() {
		if(dataType_3113Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataType_3113Parser = parser;
		}
		return dataType_3113Parser;
	}

	/**
	 * @generated
	 */
	private IParser class_3114Parser;

	/**
	 * @generated
	 */
	private IParser getClass_3114Parser() {
		if(class_3114Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}  "); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			class_3114Parser = parser;
		}
		return class_3114Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentRealizationName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getComponentRealizationName_6001Parser() {
		if(componentRealizationName_6001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			componentRealizationName_6001Parser = parser;
		}
		return componentRealizationName_6001Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser componentRealizationName_6015Parser;

	/**
	 * @generated
	 */
	private IParser getComponentRealizationName_6015Parser() {
		if(componentRealizationName_6015Parser == null) {
			componentRealizationName_6015Parser = new AppliedStereotypeParser();
		}
		return componentRealizationName_6015Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceRealizationName_6002Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceRealizationName_6002Parser() {
		if(interfaceRealizationName_6002Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			interfaceRealizationName_6002Parser = parser;
		}
		return interfaceRealizationName_6002Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser interfaceRealizationName_6016Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceRealizationName_6016Parser() {
		if(interfaceRealizationName_6016Parser == null) {
			interfaceRealizationName_6016Parser = new AppliedStereotypeParser();
		}
		return interfaceRealizationName_6016Parser;
	}

	/**
	 * @generated
	 */
	private IParser substitutionName_6003Parser;

	/**
	 * @generated
	 */
	private IParser getSubstitutionName_6003Parser() {
		if(substitutionName_6003Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			substitutionName_6003Parser = parser;
		}
		return substitutionName_6003Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser substitutionName_6017Parser;

	/**
	 * @generated
	 */
	private IParser getSubstitutionName_6017Parser() {
		if(substitutionName_6017Parser == null) {
			substitutionName_6017Parser = new AppliedStereotypeParser();
		}
		return substitutionName_6017Parser;
	}

	/**
	 * @generated
	 */
	private IParser realizationName_6004Parser;

	/**
	 * @generated
	 */
	private IParser getRealizationName_6004Parser() {
		if(realizationName_6004Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			realizationName_6004Parser = parser;
		}
		return realizationName_6004Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser realizationName_6018Parser;

	/**
	 * @generated
	 */
	private IParser getRealizationName_6018Parser() {
		if(realizationName_6018Parser == null) {
			realizationName_6018Parser = new AppliedStereotypeParser();
		}
		return realizationName_6018Parser;
	}

	/**
	 * @generated
	 */
	private IParser manifestationName_6005Parser;

	/**
	 * @generated
	 */
	private IParser getManifestationName_6005Parser() {
		if(manifestationName_6005Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			manifestationName_6005Parser = parser;
		}
		return manifestationName_6005Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser manifestationName_6019Parser;

	/**
	 * @generated
	 */
	private IParser getManifestationName_6019Parser() {
		if(manifestationName_6019Parser == null) {
			manifestationName_6019Parser = new AppliedStereotypeParser();
		}
		return manifestationName_6019Parser;
	}

	/**
	 * @generated
	 */
	private IParser abstractionName_6006Parser;

	/**
	 * @generated
	 */
	private IParser getAbstractionName_6006Parser() {
		if(abstractionName_6006Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			abstractionName_6006Parser = parser;
		}
		return abstractionName_6006Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser abstractionName_6020Parser;

	/**
	 * @generated
	 */
	private IParser getAbstractionName_6020Parser() {
		if(abstractionName_6020Parser == null) {
			abstractionName_6020Parser = new AppliedStereotypeParser();
		}
		return abstractionName_6020Parser;
	}

	/**
	 * @generated
	 */
	private IParser usageName_6007Parser;

	/**
	 * @generated
	 */
	private IParser getUsageName_6007Parser() {
		if(usageName_6007Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			usageName_6007Parser = parser;
		}
		return usageName_6007Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser usageName_6021Parser;

	/**
	 * @generated
	 */
	private IParser getUsageName_6021Parser() {
		if(usageName_6021Parser == null) {
			usageName_6021Parser = new AppliedStereotypeParser();
		}
		return usageName_6021Parser;
	}

	/**
	 * @generated
	 */
	private IParser deploymentName_6008Parser;

	/**
	 * @generated
	 */
	private IParser getDeploymentName_6008Parser() {
		if(deploymentName_6008Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			deploymentName_6008Parser = parser;
		}
		return deploymentName_6008Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser deploymentName_6022Parser;

	/**
	 * @generated
	 */
	private IParser getDeploymentName_6022Parser() {
		if(deploymentName_6022Parser == null) {
			deploymentName_6022Parser = new AppliedStereotypeParser();
		}
		return deploymentName_6022Parser;
	}

	/**
	 * @generated
	 */
	private RoleBindingRoleNameParser dependencyName_6027Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_6027Parser() {
		if(dependencyName_6027Parser == null) {
			dependencyName_6027Parser = new RoleBindingRoleNameParser();
		}
		return dependencyName_6027Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser dependencyName_6028Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_6028Parser() {
		if(dependencyName_6028Parser == null) {
			dependencyName_6028Parser = new AppliedStereotypeParser();
		}
		return dependencyName_6028Parser;
	}

	/**
	 * @generated
	 */
	private IParser dependencyName_6009Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_6009Parser() {
		if(dependencyName_6009Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dependencyName_6009Parser = parser;
		}
		return dependencyName_6009Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser dependencyName_6023Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_6023Parser() {
		if(dependencyName_6023Parser == null) {
			dependencyName_6023Parser = new AppliedStereotypeParser();
		}
		return dependencyName_6023Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser connectorName_6025Parser;

	/**
	 * @generated
	 */
	private IParser getConnectorName_6025Parser() {
		if(connectorName_6025Parser == null) {
			connectorName_6025Parser = new AppliedStereotypeParser();
		}
		return connectorName_6025Parser;
	}

	/**
	 * @generated
	 */
	private IParser connectorName_6050Parser;

	/**
	 * @generated
	 */
	private IParser getConnectorName_6050Parser() {
		if(connectorName_6050Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			connectorName_6050Parser = parser;
		}
		return connectorName_6050Parser;
	}

	/**
	 * @generated
	 */
	private IParser connectorName_6051Parser;

	/**
	 * @generated
	 */
	private IParser getConnectorName_6051Parser() {
		if(connectorName_6051Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("sourceMul{0}"); //$NON-NLS-1$
			parser.setEditorPattern("sourceMul{0}"); //$NON-NLS-1$
			parser.setEditPattern("sourceMul{0}"); //$NON-NLS-1$
			connectorName_6051Parser = parser;
		}
		return connectorName_6051Parser;
	}

	/**
	 * @generated
	 */
	private IParser connectorName_6052Parser;

	/**
	 * @generated
	 */
	private IParser getConnectorName_6052Parser() {
		if(connectorName_6052Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("targetMul{0}"); //$NON-NLS-1$
			parser.setEditorPattern("targetMul{0}"); //$NON-NLS-1$
			parser.setEditPattern("targetMul{0}"); //$NON-NLS-1$
			connectorName_6052Parser = parser;
		}
		return connectorName_6052Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser generalizationIsSubstitutable_6024Parser;

	/**
	 * @generated
	 */
	private IParser getGeneralizationIsSubstitutable_6024Parser() {
		if(generalizationIsSubstitutable_6024Parser == null) {
			generalizationIsSubstitutable_6024Parser = new AppliedStereotypeParser();
		}
		return generalizationIsSubstitutable_6024Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser informationFlowName_6032Parser;

	/**
	 * @generated
	 */
	private IParser getInformationFlowName_6032Parser() {
		if(informationFlowName_6032Parser == null) {
			informationFlowName_6032Parser = new AppliedStereotypeParser();
		}
		return informationFlowName_6032Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch(visualID) {
		case ActivityCompositeNameEditPart.VISUAL_ID:
			return getActivityName_5112Parser();
		case InteractionCompositeNameEditPart.VISUAL_ID:
			return getInteractionName_5113Parser();
		case ProtocolStateMachineCompositeNameEditPart.VISUAL_ID:
			return getProtocolStateMachineName_5114Parser();
		case StateMachineCompositeNameEditPart.VISUAL_ID:
			return getStateMachineName_5115Parser();
		case FunctionBehaviorCompositeNameEditPart.VISUAL_ID:
			return getFunctionBehaviorName_5116Parser();
		case OpaqueBehaviorCompositeNameEditPart.VISUAL_ID:
			return getOpaqueBehaviorName_5117Parser();
		case ComponentCompositeNameEditPart.VISUAL_ID:
			return getComponentName_5121Parser();
		case DeviceCompositeNameEditPart.VISUAL_ID:
			return getDeviceName_5122Parser();
		case ExecutionEnvironmentCompositeNameEditPart.VISUAL_ID:
			return getExecutionEnvironmentName_5123Parser();
		case NodeCompositeNameEditPart.VISUAL_ID:
			return getNodeName_5124Parser();
		case ClassCompositeNameEditPart.VISUAL_ID:
			return getClassName_5156Parser();
		case CollaborationCompositeNameEditPart.VISUAL_ID:
			return getCollaborationName_5158Parser();
		case InterfaceNameEditPart.VISUAL_ID:
			return getInterfaceName_5159Parser();
		case PrimitiveTypeNameEditPart.VISUAL_ID:
			return getPrimitiveTypeName_5118Parser();
		case EnumerationNameEditPart.VISUAL_ID:
			return getEnumerationName_5119Parser();
		case DataTypeNameEditPart.VISUAL_ID:
			return getDataTypeName_5120Parser();
		case ActorNameEditPart.VISUAL_ID:
			return getActorName_5160Parser();
		case DeploymentSpecificationNameEditPart.VISUAL_ID:
			return getDeploymentSpecificationName_5161Parser();
		case ArtifactNameEditPart.VISUAL_ID:
			return getArtifactName_5162Parser();
		case InformationItemNameEditPart.VISUAL_ID:
			return getInformationItemName_5163Parser();
		case SignalNameEditPart.VISUAL_ID:
			return getSignalName_5164Parser();
		case UseCaseNameEditPart.VISUAL_ID:
			return getUseCaseName_5165Parser();
		case SignalEventNameEditPart.VISUAL_ID:
			return getSignalEventName_5166Parser();
		case CallEventNameEditPart.VISUAL_ID:
			return getCallEventName_5167Parser();
		case AnyReceiveEventNameEditPart.VISUAL_ID:
			return getAnyReceiveEventName_5168Parser();
		case ChangeEventNameEditPart.VISUAL_ID:
			return getChangeEventName_5171Parser();
		case TimeEventNameEditPart.VISUAL_ID:
			return getTimeEventName_5172Parser();
		case DurationObservationNameEditPart.VISUAL_ID:
			return getDurationObservationName_5151Parser();
		case DurationObservationStereotypeLabelEditPart.VISUAL_ID:
			return getDurationObservationName_5152Parser();
		case TimeObservationNameEditPart.VISUAL_ID:
			return getTimeObservationName_5142Parser();
		case TimeObservationStereotypeLabelEditPart.VISUAL_ID:
			return getTimeObservationName_5143Parser();
		case LiteralBooleanNameEditPart.VISUAL_ID:
			return getLiteralBooleanName_5178Parser();
		case LiteralIntegerNameEditPart.VISUAL_ID:
			return getLiteralIntegerName_5179Parser();
		case LiteralNullNameEditPart.VISUAL_ID:
			return getLiteralNullName_5180Parser();
		case LiteralStringNameEditPart.VISUAL_ID:
			return getLiteralStringName_5181Parser();
		case LiteralUnlimitedNaturalNameEditPart.VISUAL_ID:
			return getLiteralUnlimitedNaturalName_5182Parser();
		case StringExpressionNameEditPart.VISUAL_ID:
			return getStringExpressionName_5183Parser();
		case OpaqueExpressionNameEditPart.VISUAL_ID:
			return getOpaqueExpressionName_5184Parser();
		case TimeExpressionNameEditPart.VISUAL_ID:
			return getTimeExpressionName_5185Parser();
		case ExpressionNameEditPart.VISUAL_ID:
			return getExpressionName_5186Parser();
		case DurationNameEditPart.VISUAL_ID:
			return getDurationName_5187Parser();
		case TimeIntervalNameEditPart.VISUAL_ID:
			return getTimeIntervalName_5188Parser();
		case DurationIntervalNameEditPart.VISUAL_ID:
			return getDurationIntervalName_5189Parser();
		case IntervalNameEditPart.VISUAL_ID:
			return getIntervalName_5190Parser();
		case InstanceValueNameEditPart.VISUAL_ID:
			return getInstanceValueName_5191Parser();
		case CommentBodyEditPart.VISUAL_ID:
			return getCommentBody_5192Parser();
		case DurationConstraintNameEditPart.VISUAL_ID:
			return getDurationConstraintName_5193Parser();
		case DurationConstraintSpecificationEditPart.VISUAL_ID:
			return getDurationConstraintSpecification_6035Parser();
		case TimeConstraintNameEditPart.VISUAL_ID:
			return getTimeConstraintName_5194Parser();
		case TimeConstraintSpecificationEditPart.VISUAL_ID:
			return getTimeConstraintSpecification_6036Parser();
		case IntervalConstraintNameEditPart.VISUAL_ID:
			return getIntervalConstraintName_5195Parser();
		case IntervalConstraintSpecificationEditPart.VISUAL_ID:
			return getIntervalConstraintSpecification_6037Parser();
		case InteractionConstraintNameEditPart.VISUAL_ID:
			return getInteractionConstraintName_5196Parser();
		case InteractionConstraintSpecificationEditPart.VISUAL_ID:
			return getInteractionConstraintSpecification_6038Parser();
		case ConstraintNameEditPart.VISUAL_ID:
			return getConstraintName_5197Parser();
		case ConstraintSpecificationEditPart.VISUAL_ID:
			return getConstraintSpecification_6039Parser();
		case PortNameEditPart.VISUAL_ID:
			return getPortName_5125Parser();
		case PortAppliedStereotypeEditPart.VISUAL_ID:
			return getPortName_6029Parser();
		case ParameterNameEditPart.VISUAL_ID:
			return getParameterName_6033Parser();
		case ParameterAppliedStereotypeEditPart.VISUAL_ID:
			return getParameterName_6034Parser();
		case PropertyPartNameEditPartCN.VISUAL_ID:
			return getPropertyName_5126Parser();
		case CollaborationRoleNameEditPartCN.VISUAL_ID:
			return getConnectableElementName_5198Parser();
		case CollaborationUseNameEditPart.VISUAL_ID:
			return getCollaborationUseName_5127Parser();
		case ActivityCompositeNameEditPartCN.VISUAL_ID:
			return getActivityName_5128Parser();
		case InteractionCompositeNameEditPartCN.VISUAL_ID:
			return getInteractionName_5129Parser();
		case ProtocolStateMachineCompositeNameEditPartCN.VISUAL_ID:
			return getProtocolStateMachineName_5130Parser();
		case StateMachineCompositeNameEditPartCN.VISUAL_ID:
			return getStateMachineName_5131Parser();
		case FunctionBehaviorCompositeNameEditPartCN.VISUAL_ID:
			return getFunctionBehaviorName_5132Parser();
		case OpaqueBehaviorCompositeNameEditPartCN.VISUAL_ID:
			return getOpaqueBehaviorName_5133Parser();
		case ComponentCompositeNameEditPartCN.VISUAL_ID:
			return getComponentName_5137Parser();
		case DeviceCompositeNameEditPartCN.VISUAL_ID:
			return getDeviceName_5138Parser();
		case ExecutionEnvironmentCompositeNameEditPartCN.VISUAL_ID:
			return getExecutionEnvironmentName_5139Parser();
		case NodeCompositeNameEditPartCN.VISUAL_ID:
			return getNodeName_5140Parser();
		case ClassCompositeNameEditPartCN.VISUAL_ID:
			return getClassName_5155Parser();
		case CollaborationCompositeNameEditPartCN.VISUAL_ID:
			return getCollaborationName_5141Parser();
		case InterfaceNameEditPartCN.VISUAL_ID:
			return getInterfaceName_5154Parser();
		case PrimitiveTypeNameEditPartCN.VISUAL_ID:
			return getPrimitiveTypeName_5134Parser();
		case EnumerationNameEditPartCN.VISUAL_ID:
			return getEnumerationName_5135Parser();
		case DataTypeNameEditPartCN.VISUAL_ID:
			return getDataTypeName_5136Parser();
		case ActorNameEditPartCN.VISUAL_ID:
			return getActorName_5144Parser();
		case DeploymentSpecificationNameEditPartCN.VISUAL_ID:
			return getDeploymentSpecificationName_5145Parser();
		case ArtifactNameEditPartCN.VISUAL_ID:
			return getArtifactName_5146Parser();
		case InformationItemNameEditPartCN.VISUAL_ID:
			return getInformationItemName_5147Parser();
		case SignalNameEditPartCN.VISUAL_ID:
			return getSignalName_5148Parser();
		case UseCaseNameEditPartCN.VISUAL_ID:
			return getUseCaseName_5149Parser();
		case CommentBodyEditPartCN.VISUAL_ID:
			return getCommentBody_5150Parser();
		case DurationConstraintNameEditPartCN.VISUAL_ID:
			return getDurationConstraintName_6040Parser();
		case DurationConstraintSpecificationEditPartCN.VISUAL_ID:
			return getDurationConstraintSpecification_6041Parser();
		case TimeConstraintNameEditPartCN.VISUAL_ID:
			return getTimeConstraintName_6042Parser();
		case TimeConstraintSpecificationEditPartCN.VISUAL_ID:
			return getTimeConstraintSpecification_6043Parser();
		case IntervalConstraintNameEditPartCN.VISUAL_ID:
			return getIntervalConstraintName_6044Parser();
		case IntervalConstraintSpecificationEditPartCN.VISUAL_ID:
			return getIntervalConstraintSpecification_6045Parser();
		case InteractionConstraintNameEditPartCN.VISUAL_ID:
			return getInteractionConstraintName_6046Parser();
		case InteractionConstraintSpecificationEditPartCN.VISUAL_ID:
			return getInteractionConstraintSpecification_6047Parser();
		case ConstraintNameEditPartCN.VISUAL_ID:
			return getConstraintName_6048Parser();
		case ConstraintSpecificationEditPartCN.VISUAL_ID:
			return getConstraintSpecification_6049Parser();
		case PropertyEditPartCLN.VISUAL_ID:
			return getProperty_3101Parser();
		case OperationEditPartCLN.VISUAL_ID:
			return getOperation_3102Parser();
		case ReceptionEditPartCLN.VISUAL_ID:
			return getReception_3100Parser();
		case EnumerationLiteralEditPartCLN.VISUAL_ID:
			return getEnumerationLiteral_3066Parser();
		case ActivityEditPartCLN.VISUAL_ID:
			return getActivity_3103Parser();
		case InteractionEditPartCLN.VISUAL_ID:
			return getInteraction_3104Parser();
		case ProtocolStateMachineEditPartCLN.VISUAL_ID:
			return getProtocolStateMachine_3105Parser();
		case StateMachineEditPartCLN.VISUAL_ID:
			return getStateMachine_3106Parser();
		case FunctionBehaviorEditPartCLN.VISUAL_ID:
			return getFunctionBehavior_3107Parser();
		case OpaqueBehaviorEditPartCLN.VISUAL_ID:
			return getOpaqueBehavior_3108Parser();
		case CollaborationEditPartCLN.VISUAL_ID:
			return getCollaboration_3109Parser();
		case InterfaceEditPartCLN.VISUAL_ID:
			return getInterface_3110Parser();
		case EnumerationEditPartCLN.VISUAL_ID:
			return getEnumeration_3111Parser();
		case PrimitiveTypeEditPartCLN.VISUAL_ID:
			return getPrimitiveType_3112Parser();
		case DataTypeEditPartCLN.VISUAL_ID:
			return getDataType_3113Parser();
		case ClassEditPartCLN.VISUAL_ID:
			return getClass_3114Parser();
		case ComponentRealizationNameEditPart.VISUAL_ID:
			return getComponentRealizationName_6001Parser();
		case ComponentRealizationAppliedStereotypeEditPart.VISUAL_ID:
			return getComponentRealizationName_6015Parser();
		case InterfaceRealizationNameEditPart.VISUAL_ID:
			return getInterfaceRealizationName_6002Parser();
		case InterfaceRealizationAppliedStereotypeEditPart.VISUAL_ID:
			return getInterfaceRealizationName_6016Parser();
		case SubstitutionNameEditPart.VISUAL_ID:
			return getSubstitutionName_6003Parser();
		case SubstitutionAppliedStereotypeEditPart.VISUAL_ID:
			return getSubstitutionName_6017Parser();
		case RealizationNameEditPart.VISUAL_ID:
			return getRealizationName_6004Parser();
		case RealizationAppliedStereotypeEditPart.VISUAL_ID:
			return getRealizationName_6018Parser();
		case ManifestationNameEditPart.VISUAL_ID:
			return getManifestationName_6005Parser();
		case ManifestationAppliedStereotypeEditPart.VISUAL_ID:
			return getManifestationName_6019Parser();
		case AbstractionNameEditPart.VISUAL_ID:
			return getAbstractionName_6006Parser();
		case AbstractionAppliedStereotypeEditPart.VISUAL_ID:
			return getAbstractionName_6020Parser();
		case UsageNameEditPart.VISUAL_ID:
			return getUsageName_6007Parser();
		case UsageAppliedStereotypeEditPart.VISUAL_ID:
			return getUsageName_6021Parser();
		case DeploymentNameEditPart.VISUAL_ID:
			return getDeploymentName_6008Parser();
		case DeploymentAppliedStereotypeEditPart.VISUAL_ID:
			return getDeploymentName_6022Parser();
		case RoleBindingRoleNameEditPart.VISUAL_ID:
			return getDependencyName_6027Parser();
		case RoleBindingAppliedStereotypeEditPart.VISUAL_ID:
			return getDependencyName_6028Parser();
		case DependencyNameEditPart.VISUAL_ID:
			return getDependencyName_6009Parser();
		case DependencyAppliedStereotypeEditPart.VISUAL_ID:
			return getDependencyName_6023Parser();
		case ConnectorAppliedStereotypeEditPart.VISUAL_ID:
			return getConnectorName_6025Parser();
		case ConnectorNameEditPart.VISUAL_ID:
			return getConnectorName_6050Parser();
		case ConnectorMultiplicitySourceEditPart.VISUAL_ID:
			return getConnectorName_6051Parser();
		case ConnectorMultiplicityTargetEditPart.VISUAL_ID:
			return getConnectorName_6052Parser();
		case GeneralizationAppliedStereotypeEditPart.VISUAL_ID:
			return getGeneralizationIsSubstitutable_6024Parser();
		case InformationFlowAppliedStereotypeEditPart.VISUAL_ID:
			return getInformationFlowName_6032Parser();
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
