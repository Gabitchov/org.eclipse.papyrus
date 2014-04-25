/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.providers;

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
import org.eclipse.papyrus.uml.diagram.clazz.custom.parsers.GeneralizationSetConstraintParser;
import org.eclipse.papyrus.uml.diagram.clazz.custom.parsers.RoleInstanceSpecificationLinkParser;
import org.eclipse.papyrus.uml.diagram.clazz.custom.parsers.SlotParser;
import org.eclipse.papyrus.uml.diagram.clazz.custom.parsers.TemplateBindingParser;
import org.eclipse.papyrus.uml.diagram.clazz.custom.parsers.TemplateParameterParser;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.*;
import org.eclipse.papyrus.uml.diagram.clazz.parsers.MessageFormatParser;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.common.parser.CommentParser;
import org.eclipse.papyrus.uml.diagram.common.parser.ConstraintParser;
import org.eclipse.papyrus.uml.diagram.common.parser.ShortcutDiagramParser;
import org.eclipse.papyrus.uml.diagram.common.parser.packageimport.PackageImportVisibilityParser;
import org.eclipse.papyrus.uml.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser dependencyName_1Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_1Parser() {
		if(dependencyName_1Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dependencyName_1Parser = parser;
		}
		return dependencyName_1Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationClassName_5066Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationClassName_5066Parser() {
		if(associationClassName_5066Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			associationClassName_5066Parser = parser;
		}
		return associationClassName_5066Parser;
	}

	/**
	 * @generated
	 */
	private IParser instanceSpecificationName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationName_5002Parser() {
		if(instanceSpecificationName_5002Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			instanceSpecificationName_5002Parser = parser;
		}
		return instanceSpecificationName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_5005Parser() {
		if(componentName_5005Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			componentName_5005Parser = parser;
		}
		return componentName_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser signalName_5008Parser;

	/**
	 * @generated
	 */
	private IParser getSignalName_5008Parser() {
		if(signalName_5008Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			signalName_5008Parser = parser;
		}
		return signalName_5008Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceName_5011Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceName_5011Parser() {
		if(interfaceName_5011Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			interfaceName_5011Parser = parser;
		}
		return interfaceName_5011Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelName_5020Parser;

	/**
	 * @generated
	 */
	private IParser getModelName_5020Parser() {
		if(modelName_5020Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			modelName_5020Parser = parser;
		}
		return modelName_5020Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumerationName_5023Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationName_5023Parser() {
		if(enumerationName_5023Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			enumerationName_5023Parser = parser;
		}
		return enumerationName_5023Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_5026Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_5026Parser() {
		if(packageName_5026Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			packageName_5026Parser = parser;
		}
		return packageName_5026Parser;
	}

	/**
	 * @generated
	 */
	private IParser informationItemName_5161Parser;

	/**
	 * @generated
	 */
	private IParser getInformationItemName_5161Parser() {
		if(informationItemName_5161Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			informationItemName_5161Parser = parser;
		}
		return informationItemName_5161Parser;
	}

	/**
	 * @generated
	 */
	private IParser className_5029Parser;

	/**
	 * @generated
	 */
	private IParser getClassName_5029Parser() {
		if(className_5029Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			className_5029Parser = parser;
		}
		return className_5029Parser;
	}

	/**
	 * @generated
	 */
	private IParser primitiveTypeName_5032Parser;

	/**
	 * @generated
	 */
	private IParser getPrimitiveTypeName_5032Parser() {
		if(primitiveTypeName_5032Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			primitiveTypeName_5032Parser = parser;
		}
		return primitiveTypeName_5032Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataTypeName_5035Parser;

	/**
	 * @generated
	 */
	private IParser getDataTypeName_5035Parser() {
		if(dataTypeName_5035Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dataTypeName_5035Parser = parser;
		}
		return dataTypeName_5035Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_5037Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_5037Parser() {
		if(constraintName_5037Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintName_5037Parser = parser;
		}
		return constraintName_5037Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser constraintSpecification_5159Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintSpecification_5159Parser() {
		if(constraintSpecification_5159Parser == null) {
			constraintSpecification_5159Parser = new ConstraintParser();
		}
		return constraintSpecification_5159Parser;
	}

	/**
	 * @generated
	 */
	private CommentParser commentBody_5038Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_5038Parser() {
		if(commentBody_5038Parser == null) {
			commentBody_5038Parser = new CommentParser();
		}
		return commentBody_5038Parser;
	}

	/**
	 * @generated
	 */
	private ShortcutDiagramParser diagramName_0Parser;

	/**
	 * @generated
	 */
	private IParser getDiagramName_0Parser() {
		if(diagramName_0Parser == null) {
			diagramName_0Parser = new ShortcutDiagramParser();
		}
		return diagramName_0Parser;
	}

	/**
	 * @generated
	 */
	private IParser durationObservationName_5155Parser;

	/**
	 * @generated
	 */
	private IParser getDurationObservationName_5155Parser() {
		if(durationObservationName_5155Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			durationObservationName_5155Parser = parser;
		}
		return durationObservationName_5155Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser durationObservationName_5156Parser;

	/**
	 * @generated
	 */
	private IParser getDurationObservationName_5156Parser() {
		if(durationObservationName_5156Parser == null) {
			durationObservationName_5156Parser = new AppliedStereotypeParser();
		}
		return durationObservationName_5156Parser;
	}

	/**
	 * @generated
	 */
	private IParser timeObservationName_5153Parser;

	/**
	 * @generated
	 */
	private IParser getTimeObservationName_5153Parser() {
		if(timeObservationName_5153Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			timeObservationName_5153Parser = parser;
		}
		return timeObservationName_5153Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser timeObservationName_5154Parser;

	/**
	 * @generated
	 */
	private IParser getTimeObservationName_5154Parser() {
		if(timeObservationName_5154Parser == null) {
			timeObservationName_5154Parser = new AppliedStereotypeParser();
		}
		return timeObservationName_5154Parser;
	}

	/**
	 * @generated
	 */
	private IParser namedElementName_5157Parser;

	/**
	 * @generated
	 */
	private IParser getNamedElementName_5157Parser() {
		if(namedElementName_5157Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			namedElementName_5157Parser = parser;
		}
		return namedElementName_5157Parser;
	}

	/**
	 * @generated
	 */
	private IParser property_3002Parser;

	/**
	 * @generated
	 */
	private IParser getProperty_3002Parser() {
		if(property_3002Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			property_3002Parser = parser;
		}
		return property_3002Parser;
	}

	/**
	 * @generated
	 */
	private IParser property_3005Parser;

	/**
	 * @generated
	 */
	private IParser getProperty_3005Parser() {
		if(property_3005Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			property_3005Parser = parser;
		}
		return property_3005Parser;
	}

	/**
	 * @generated
	 */
	private IParser property_3006Parser;

	/**
	 * @generated
	 */
	private IParser getProperty_3006Parser() {
		if(property_3006Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			property_3006Parser = parser;
		}
		return property_3006Parser;
	}

	/**
	 * @generated
	 */
	private IParser property_3041Parser;

	/**
	 * @generated
	 */
	private IParser getProperty_3041Parser() {
		if(property_3041Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			property_3041Parser = parser;
		}
		return property_3041Parser;
	}

	/**
	 * @generated
	 */
	private IParser property_3018Parser;

	/**
	 * @generated
	 */
	private IParser getProperty_3018Parser() {
		if(property_3018Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			property_3018Parser = parser;
		}
		return property_3018Parser;
	}

	/**
	 * @generated
	 */
	private IParser class_3014Parser;

	/**
	 * @generated
	 */
	private IParser getClass_3014Parser() {
		if(class_3014Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			class_3014Parser = parser;
		}
		return class_3014Parser;
	}

	/**
	 * @generated
	 */
	private IParser class_3004Parser;

	/**
	 * @generated
	 */
	private IParser getClass_3004Parser() {
		if(class_3004Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			class_3004Parser = parser;
		}
		return class_3004Parser;
	}

	/**
	 * @generated
	 */
	private IParser class_3008Parser;

	/**
	 * @generated
	 */
	private IParser getClass_3008Parser() {
		if(class_3008Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			class_3008Parser = parser;
		}
		return class_3008Parser;
	}

	/**
	 * @generated
	 */
	private IParser operation_3003Parser;

	/**
	 * @generated
	 */
	private IParser getOperation_3003Parser() {
		if(operation_3003Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			operation_3003Parser = parser;
		}
		return operation_3003Parser;
	}

	/**
	 * @generated
	 */
	private IParser operation_3007Parser;

	/**
	 * @generated
	 */
	private IParser getOperation_3007Parser() {
		if(operation_3007Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			operation_3007Parser = parser;
		}
		return operation_3007Parser;
	}

	/**
	 * @generated
	 */
	private IParser operation_3042Parser;

	/**
	 * @generated
	 */
	private IParser getOperation_3042Parser() {
		if(operation_3042Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			operation_3042Parser = parser;
		}
		return operation_3042Parser;
	}

	/**
	 * @generated
	 */
	private IParser operation_3019Parser;

	/**
	 * @generated
	 */
	private IParser getOperation_3019Parser() {
		if(operation_3019Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			operation_3019Parser = parser;
		}
		return operation_3019Parser;
	}

	/**
	 * @generated
	 */
	private TemplateParameterParser connectableElementTemplateParameter_3034Parser;

	/**
	 * @generated
	 */
	private IParser getConnectableElementTemplateParameter_3034Parser() {
		if(connectableElementTemplateParameter_3034Parser == null) {
			connectableElementTemplateParameter_3034Parser = new TemplateParameterParser();
		}
		return connectableElementTemplateParameter_3034Parser;
	}

	/**
	 * @generated
	 */
	private TemplateParameterParser operationTemplateParameter_3035Parser;

	/**
	 * @generated
	 */
	private IParser getOperationTemplateParameter_3035Parser() {
		if(operationTemplateParameter_3035Parser == null) {
			operationTemplateParameter_3035Parser = new TemplateParameterParser();
		}
		return operationTemplateParameter_3035Parser;
	}

	/**
	 * @generated
	 */
	private TemplateParameterParser classifierTemplateParameter_3031Parser;

	/**
	 * @generated
	 */
	private IParser getClassifierTemplateParameter_3031Parser() {
		if(classifierTemplateParameter_3031Parser == null) {
			classifierTemplateParameter_3031Parser = new TemplateParameterParser();
		}
		return classifierTemplateParameter_3031Parser;
	}

	/**
	 * @generated
	 */
	private TemplateParameterParser templateParameter_3016Parser;

	/**
	 * @generated
	 */
	private IParser getTemplateParameter_3016Parser() {
		if(templateParameter_3016Parser == null) {
			templateParameter_3016Parser = new TemplateParameterParser();
		}
		return templateParameter_3016Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumerationLiteral_3017Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationLiteral_3017Parser() {
		if(enumerationLiteral_3017Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			enumerationLiteral_3017Parser = parser;
		}
		return enumerationLiteral_3017Parser;
	}

	/**
	 * @generated
	 */
	private IParser reception_3011Parser;

	/**
	 * @generated
	 */
	private IParser getReception_3011Parser() {
		if(reception_3011Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("\u00ABSignal\u00BB {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			reception_3011Parser = parser;
		}
		return reception_3011Parser;
	}

	/**
	 * @generated
	 */
	private IParser reception_3039Parser;

	/**
	 * @generated
	 */
	private IParser getReception_3039Parser() {
		if(reception_3039Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("\u00ABSignal\u00BB {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			reception_3039Parser = parser;
		}
		return reception_3039Parser;
	}

	/**
	 * @generated
	 */
	private SlotParser slot_3030Parser;

	/**
	 * @generated
	 */
	private IParser getSlot_3030Parser() {
		if(slot_3030Parser == null) {
			slot_3030Parser = new SlotParser();
		}
		return slot_3030Parser;
	}

	/**
	 * @generated
	 */
	private IParser instanceSpecificationName_5040Parser;

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationName_5040Parser() {
		if(instanceSpecificationName_5040Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			instanceSpecificationName_5040Parser = parser;
		}
		return instanceSpecificationName_5040Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentName_5043Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_5043Parser() {
		if(componentName_5043Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			componentName_5043Parser = parser;
		}
		return componentName_5043Parser;
	}

	/**
	 * @generated
	 */
	private IParser signalName_5046Parser;

	/**
	 * @generated
	 */
	private IParser getSignalName_5046Parser() {
		if(signalName_5046Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			signalName_5046Parser = parser;
		}
		return signalName_5046Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceName_5049Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceName_5049Parser() {
		if(interfaceName_5049Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			interfaceName_5049Parser = parser;
		}
		return interfaceName_5049Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelName_5052Parser;

	/**
	 * @generated
	 */
	private IParser getModelName_5052Parser() {
		if(modelName_5052Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			modelName_5052Parser = parser;
		}
		return modelName_5052Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumerationName_5055Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationName_5055Parser() {
		if(enumerationName_5055Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			enumerationName_5055Parser = parser;
		}
		return enumerationName_5055Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_5017Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_5017Parser() {
		if(packageName_5017Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			packageName_5017Parser = parser;
		}
		return packageName_5017Parser;
	}

	/**
	 * @generated
	 */
	private IParser informationItemName_5162Parser;

	/**
	 * @generated
	 */
	private IParser getInformationItemName_5162Parser() {
		if(informationItemName_5162Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			informationItemName_5162Parser = parser;
		}
		return informationItemName_5162Parser;
	}

	/**
	 * @generated
	 */
	private IParser className_5014Parser;

	/**
	 * @generated
	 */
	private IParser getClassName_5014Parser() {
		if(className_5014Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			className_5014Parser = parser;
		}
		return className_5014Parser;
	}

	/**
	 * @generated
	 */
	private IParser primitiveTypeName_5058Parser;

	/**
	 * @generated
	 */
	private IParser getPrimitiveTypeName_5058Parser() {
		if(primitiveTypeName_5058Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			primitiveTypeName_5058Parser = parser;
		}
		return primitiveTypeName_5058Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataTypeName_5061Parser;

	/**
	 * @generated
	 */
	private IParser getDataTypeName_5061Parser() {
		if(dataTypeName_5061Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dataTypeName_5061Parser = parser;
		}
		return dataTypeName_5061Parser;
	}

	/**
	 * @generated
	 */
	private CommentParser commentBody_5063Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_5063Parser() {
		if(commentBody_5063Parser == null) {
			commentBody_5063Parser = new CommentParser();
		}
		return commentBody_5063Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_5064Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_5064Parser() {
		if(constraintName_5064Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintName_5064Parser = parser;
		}
		return constraintName_5064Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser constraintSpecification_5160Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintSpecification_5160Parser() {
		if(constraintSpecification_5160Parser == null) {
			constraintSpecification_5160Parser = new ConstraintParser();
		}
		return constraintSpecification_5160Parser;
	}

	/**
	 * @generated
	 */
	private IParser interface_3036Parser;

	/**
	 * @generated
	 */
	private IParser getInterface_3036Parser() {
		if(interface_3036Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			interface_3036Parser = parser;
		}
		return interface_3036Parser;
	}

	/**
	 * @generated
	 */
	private IParser interface_3037Parser;

	/**
	 * @generated
	 */
	private IParser getInterface_3037Parser() {
		if(interface_3037Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			interface_3037Parser = parser;
		}
		return interface_3037Parser;
	}

	/**
	 * @generated
	 */
	private IParser interface_3038Parser;

	/**
	 * @generated
	 */
	private IParser getInterface_3038Parser() {
		if(interface_3038Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			interface_3038Parser = parser;
		}
		return interface_3038Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumeration_3052Parser;

	/**
	 * @generated
	 */
	private IParser getEnumeration_3052Parser() {
		if(enumeration_3052Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			enumeration_3052Parser = parser;
		}
		return enumeration_3052Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumeration_3053Parser;

	/**
	 * @generated
	 */
	private IParser getEnumeration_3053Parser() {
		if(enumeration_3053Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			enumeration_3053Parser = parser;
		}
		return enumeration_3053Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumeration_3054Parser;

	/**
	 * @generated
	 */
	private IParser getEnumeration_3054Parser() {
		if(enumeration_3054Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			enumeration_3054Parser = parser;
		}
		return enumeration_3054Parser;
	}

	/**
	 * @generated
	 */
	private IParser primitiveType_3047Parser;

	/**
	 * @generated
	 */
	private IParser getPrimitiveType_3047Parser() {
		if(primitiveType_3047Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			primitiveType_3047Parser = parser;
		}
		return primitiveType_3047Parser;
	}

	/**
	 * @generated
	 */
	private IParser primitiveType_3046Parser;

	/**
	 * @generated
	 */
	private IParser getPrimitiveType_3046Parser() {
		if(primitiveType_3046Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			primitiveType_3046Parser = parser;
		}
		return primitiveType_3046Parser;
	}

	/**
	 * @generated
	 */
	private IParser primitiveType_3048Parser;

	/**
	 * @generated
	 */
	private IParser getPrimitiveType_3048Parser() {
		if(primitiveType_3048Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			primitiveType_3048Parser = parser;
		}
		return primitiveType_3048Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataType_3044Parser;

	/**
	 * @generated
	 */
	private IParser getDataType_3044Parser() {
		if(dataType_3044Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dataType_3044Parser = parser;
		}
		return dataType_3044Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataType_3045Parser;

	/**
	 * @generated
	 */
	private IParser getDataType_3045Parser() {
		if(dataType_3045Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dataType_3045Parser = parser;
		}
		return dataType_3045Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataType_3043Parser;

	/**
	 * @generated
	 */
	private IParser getDataType_3043Parser() {
		if(dataType_3043Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dataType_3043Parser = parser;
		}
		return dataType_3043Parser;
	}

	/**
	 * @generated
	 */
	private IParser signal_3050Parser;

	/**
	 * @generated
	 */
	private IParser getSignal_3050Parser() {
		if(signal_3050Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			signal_3050Parser = parser;
		}
		return signal_3050Parser;
	}

	/**
	 * @generated
	 */
	private IParser signal_3051Parser;

	/**
	 * @generated
	 */
	private IParser getSignal_3051Parser() {
		if(signal_3051Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			signal_3051Parser = parser;
		}
		return signal_3051Parser;
	}

	/**
	 * @generated
	 */
	private IParser signal_3049Parser;

	/**
	 * @generated
	 */
	private IParser getSignal_3049Parser() {
		if(signal_3049Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			signal_3049Parser = parser;
		}
		return signal_3049Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationClassName_6031Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationClassName_6031Parser() {
		if(associationClassName_6031Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("srcRole{0}"); //$NON-NLS-1$
			parser.setEditorPattern("srcRole{0}"); //$NON-NLS-1$
			parser.setEditPattern("srcRole{0}"); //$NON-NLS-1$
			associationClassName_6031Parser = parser;
		}
		return associationClassName_6031Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationClassName_6032Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationClassName_6032Parser() {
		if(associationClassName_6032Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("targetRole{0}"); //$NON-NLS-1$
			parser.setEditorPattern("targetRole{0}"); //$NON-NLS-1$
			parser.setEditPattern("targetRole{0}"); //$NON-NLS-1$
			associationClassName_6032Parser = parser;
		}
		return associationClassName_6032Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser associationName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6001Parser() {
		if(associationName_6001Parser == null) {
			associationName_6001Parser = new AppliedStereotypeParser();
		}
		return associationName_6001Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_6002Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6002Parser() {
		if(associationName_6002Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			associationName_6002Parser = parser;
		}
		return associationName_6002Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_6003Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6003Parser() {
		if(associationName_6003Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("srcRole{0}"); //$NON-NLS-1$
			parser.setEditorPattern("srcRole{0}"); //$NON-NLS-1$
			parser.setEditPattern("srcRole{0}"); //$NON-NLS-1$
			associationName_6003Parser = parser;
		}
		return associationName_6003Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_6005Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6005Parser() {
		if(associationName_6005Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("targMul{0}"); //$NON-NLS-1$
			parser.setEditorPattern("targMul{0}"); //$NON-NLS-1$
			parser.setEditPattern("targMul{0}"); //$NON-NLS-1$
			associationName_6005Parser = parser;
		}
		return associationName_6005Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_6033Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6033Parser() {
		if(associationName_6033Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("srcMul{0}"); //$NON-NLS-1$
			parser.setEditorPattern("srcMul{0}"); //$NON-NLS-1$
			parser.setEditPattern("srcMul{0}"); //$NON-NLS-1$
			associationName_6033Parser = parser;
		}
		return associationName_6033Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_6034Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6034Parser() {
		if(associationName_6034Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("srcMul{0}"); //$NON-NLS-1$
			parser.setEditorPattern("srcMul{0}"); //$NON-NLS-1$
			parser.setEditPattern("srcMul{0}"); //$NON-NLS-1$
			associationName_6034Parser = parser;
		}
		return associationName_6034Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_6035Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6035Parser() {
		if(associationName_6035Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("srcRole{0}"); //$NON-NLS-1$
			parser.setEditorPattern("srcRole{0}"); //$NON-NLS-1$
			parser.setEditPattern("srcRole{0}"); //$NON-NLS-1$
			associationName_6035Parser = parser;
		}
		return associationName_6035Parser;
	}

	/**
	 * @generated
	 */
	private IParser generalizationIsSubstitutable_6007Parser;

	/**
	 * @generated
	 */
	private IParser getGeneralizationIsSubstitutable_6007Parser() {
		if(generalizationIsSubstitutable_6007Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getGeneralization_IsSubstitutable() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			generalizationIsSubstitutable_6007Parser = parser;
		}
		return generalizationIsSubstitutable_6007Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser interfaceRealizationName_6008Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceRealizationName_6008Parser() {
		if(interfaceRealizationName_6008Parser == null) {
			interfaceRealizationName_6008Parser = new AppliedStereotypeParser();
		}
		return interfaceRealizationName_6008Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceRealizationName_6009Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceRealizationName_6009Parser() {
		if(interfaceRealizationName_6009Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			interfaceRealizationName_6009Parser = parser;
		}
		return interfaceRealizationName_6009Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser substitutionName_6010Parser;

	/**
	 * @generated
	 */
	private IParser getSubstitutionName_6010Parser() {
		if(substitutionName_6010Parser == null) {
			substitutionName_6010Parser = new AppliedStereotypeParser();
		}
		return substitutionName_6010Parser;
	}

	/**
	 * @generated
	 */
	private IParser substitutionName_6011Parser;

	/**
	 * @generated
	 */
	private IParser getSubstitutionName_6011Parser() {
		if(substitutionName_6011Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			substitutionName_6011Parser = parser;
		}
		return substitutionName_6011Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser realizationName_6012Parser;

	/**
	 * @generated
	 */
	private IParser getRealizationName_6012Parser() {
		if(realizationName_6012Parser == null) {
			realizationName_6012Parser = new AppliedStereotypeParser();
		}
		return realizationName_6012Parser;
	}

	/**
	 * @generated
	 */
	private IParser realizationName_6013Parser;

	/**
	 * @generated
	 */
	private IParser getRealizationName_6013Parser() {
		if(realizationName_6013Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			realizationName_6013Parser = parser;
		}
		return realizationName_6013Parser;
	}

	/**
	 * @generated
	 */
	private IParser abstractionName_6014Parser;

	/**
	 * @generated
	 */
	private IParser getAbstractionName_6014Parser() {
		if(abstractionName_6014Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			abstractionName_6014Parser = parser;
		}
		return abstractionName_6014Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser abstractionName_6015Parser;

	/**
	 * @generated
	 */
	private IParser getAbstractionName_6015Parser() {
		if(abstractionName_6015Parser == null) {
			abstractionName_6015Parser = new AppliedStereotypeParser();
		}
		return abstractionName_6015Parser;
	}

	/**
	 * @generated
	 */
	private IParser usageName_6016Parser;

	/**
	 * @generated
	 */
	private IParser getUsageName_6016Parser() {
		if(usageName_6016Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			usageName_6016Parser = parser;
		}
		return usageName_6016Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser usageName_6017Parser;

	/**
	 * @generated
	 */
	private IParser getUsageName_6017Parser() {
		if(usageName_6017Parser == null) {
			usageName_6017Parser = new AppliedStereotypeParser();
		}
		return usageName_6017Parser;
	}

	/**
	 * @generated
	 */
	private IParser dependencyName_6026Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_6026Parser() {
		if(dependencyName_6026Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dependencyName_6026Parser = parser;
		}
		return dependencyName_6026Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser dependencyName_6027Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_6027Parser() {
		if(dependencyName_6027Parser == null) {
			dependencyName_6027Parser = new AppliedStereotypeParser();
		}
		return dependencyName_6027Parser;
	}

	/**
	 * @generated
	 */
	private IParser elementImportAlias_6020Parser;

	/**
	 * @generated
	 */
	private IParser getElementImportAlias_6020Parser() {
		if(elementImportAlias_6020Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getElementImport_Alias() };
			MessageFormatParser parser = new MessageFormatParser(features);
			elementImportAlias_6020Parser = parser;
		}
		return elementImportAlias_6020Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser elementImportAlias_6021Parser;

	/**
	 * @generated
	 */
	private IParser getElementImportAlias_6021Parser() {
		if(elementImportAlias_6021Parser == null) {
			elementImportAlias_6021Parser = new AppliedStereotypeParser();
		}
		return elementImportAlias_6021Parser;
	}

	/**
	 * @generated
	 */
	private PackageImportVisibilityParser packageImportVisibility_6022Parser;

	/**
	 * @generated
	 */
	private IParser getPackageImportVisibility_6022Parser() {
		if(packageImportVisibility_6022Parser == null) {
			packageImportVisibility_6022Parser = new PackageImportVisibilityParser();
		}
		return packageImportVisibility_6022Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser packageMergeLabel_6030Parser;

	/**
	 * @generated
	 */
	private IParser getPackageMergeLabel_6030Parser() {
		if(packageMergeLabel_6030Parser == null) {
			packageMergeLabel_6030Parser = new AppliedStereotypeParser();
		}
		return packageMergeLabel_6030Parser;
	}

	/**
	 * @generated
	 */
	private TemplateBindingParser templateBindingLabel_6023Parser;

	/**
	 * @generated
	 */
	private IParser getTemplateBindingLabel_6023Parser() {
		if(templateBindingLabel_6023Parser == null) {
			templateBindingLabel_6023Parser = new TemplateBindingParser();
		}
		return templateBindingLabel_6023Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser templateBindingLabel_6036Parser;

	/**
	 * @generated
	 */
	private IParser getTemplateBindingLabel_6036Parser() {
		if(templateBindingLabel_6036Parser == null) {
			templateBindingLabel_6036Parser = new AppliedStereotypeParser();
		}
		return templateBindingLabel_6036Parser;
	}

	/**
	 * @generated
	 */
	private GeneralizationSetConstraintParser generalizationSetIsCoveringIsDisjoint_5067Parser;

	/**
	 * @generated
	 */
	private IParser getGeneralizationSetIsCoveringIsDisjoint_5067Parser() {
		if(generalizationSetIsCoveringIsDisjoint_5067Parser == null) {
			generalizationSetIsCoveringIsDisjoint_5067Parser = new GeneralizationSetConstraintParser();
		}
		return generalizationSetIsCoveringIsDisjoint_5067Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser generalizationSetLabel_6037Parser;

	/**
	 * @generated
	 */
	private IParser getGeneralizationSetLabel_6037Parser() {
		if(generalizationSetLabel_6037Parser == null) {
			generalizationSetLabel_6037Parser = new AppliedStereotypeParser();
		}
		return generalizationSetLabel_6037Parser;
	}

	/**
	 * @generated
	 */
	private RoleInstanceSpecificationLinkParser instanceSpecificationLabel_6039Parser;

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationLabel_6039Parser() {
		if(instanceSpecificationLabel_6039Parser == null) {
			instanceSpecificationLabel_6039Parser = new RoleInstanceSpecificationLinkParser();
		}
		return instanceSpecificationLabel_6039Parser;
	}

	/**
	 * @generated
	 */
	private RoleInstanceSpecificationLinkParser instanceSpecificationLabel_6038Parser;

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationLabel_6038Parser() {
		if(instanceSpecificationLabel_6038Parser == null) {
			instanceSpecificationLabel_6038Parser = new RoleInstanceSpecificationLinkParser();
		}
		return instanceSpecificationLabel_6038Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser informationFlowName_6041Parser;

	/**
	 * @generated
	 */
	private IParser getInformationFlowName_6041Parser() {
		if(informationFlowName_6041Parser == null) {
			informationFlowName_6041Parser = new AppliedStereotypeParser();
		}
		return informationFlowName_6041Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch(visualID) {
		case MultiDependencyLabelEditPart.VISUAL_ID:
			return getDependencyName_1Parser();
		case AssociationClassNameEditPart.VISUAL_ID:
			return getAssociationClassName_5066Parser();
		case InstanceSpecificationNameEditPart.VISUAL_ID:
			return getInstanceSpecificationName_5002Parser();
		case ComponentNameEditPart.VISUAL_ID:
			return getComponentName_5005Parser();
		case SignalNameEditPart.VISUAL_ID:
			return getSignalName_5008Parser();
		case InterfaceNameEditPart.VISUAL_ID:
			return getInterfaceName_5011Parser();
		case ModelNameEditPartTN.VISUAL_ID:
			return getModelName_5020Parser();
		case EnumerationNameEditPart.VISUAL_ID:
			return getEnumerationName_5023Parser();
		case PackageNameEditPart.VISUAL_ID:
			return getPackageName_5026Parser();
		case InformationItemNameEditPart.VISUAL_ID:
			return getInformationItemName_5161Parser();
		case ClassNameEditPart.VISUAL_ID:
			return getClassName_5029Parser();
		case PrimitiveTypeNameEditPart.VISUAL_ID:
			return getPrimitiveTypeName_5032Parser();
		case DataTypeNameEditPart.VISUAL_ID:
			return getDataTypeName_5035Parser();
		case ConstraintNameEditPart.VISUAL_ID:
			return getConstraintName_5037Parser();
		case ConstraintBodyEditPart.VISUAL_ID:
			return getConstraintSpecification_5159Parser();
		case CommentBodyEditPart.VISUAL_ID:
			return getCommentBody_5038Parser();
		case DiagramNameEditPart.VISUAL_ID:
			return getDiagramName_0Parser();
		case DurationObservationNameEditPart.VISUAL_ID:
			return getDurationObservationName_5155Parser();
		case DurationObservationStereotypeLabelEditPart.VISUAL_ID:
			return getDurationObservationName_5156Parser();
		case TimeObservationNameEditPart.VISUAL_ID:
			return getTimeObservationName_5153Parser();
		case TimeObservationStereotypeLabelEditPart.VISUAL_ID:
			return getTimeObservationName_5154Parser();
		case DefaultNamedElementNameEditPart.VISUAL_ID:
			return getNamedElementName_5157Parser();
		case PropertyForComponentEditPart.VISUAL_ID:
			return getProperty_3002Parser();
		case PropertyForSignalEditPart.VISUAL_ID:
			return getProperty_3005Parser();
		case PropertyForInterfaceEditPart.VISUAL_ID:
			return getProperty_3006Parser();
		case PropertyforPrimitiveTypeEditPart.VISUAL_ID:
			return getProperty_3041Parser();
		case PropertyforDataTypeEditPart.VISUAL_ID:
			return getProperty_3018Parser();
		case NestedClassForClassEditPart.VISUAL_ID:
			return getClass_3014Parser();
		case NestedClassForComponentEditPart.VISUAL_ID:
			return getClass_3004Parser();
		case NestedClassForInterfaceEditPart.VISUAL_ID:
			return getClass_3008Parser();
		case OperationForComponentEditPart.VISUAL_ID:
			return getOperation_3003Parser();
		case OperationForInterfaceEditpart.VISUAL_ID:
			return getOperation_3007Parser();
		case OperationForPrimitiveTypeEditPart.VISUAL_ID:
			return getOperation_3042Parser();
		case OperationForDataTypeEditPart.VISUAL_ID:
			return getOperation_3019Parser();
		case ConnectableElementTemplateParameterEditPart.VISUAL_ID:
			return getConnectableElementTemplateParameter_3034Parser();
		case OperationTemplateParameterEditPart.VISUAL_ID:
			return getOperationTemplateParameter_3035Parser();
		case ClassifierTemplateParameterEditPart.VISUAL_ID:
			return getClassifierTemplateParameter_3031Parser();
		case TemplateParameterEditPart.VISUAL_ID:
			return getTemplateParameter_3016Parser();
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_3017Parser();
		case ReceptionEditPart.VISUAL_ID:
			return getReception_3011Parser();
		case ReceptionInInterfaceEditPart.VISUAL_ID:
			return getReception_3039Parser();
		case SlotEditPart.VISUAL_ID:
			return getSlot_3030Parser();
		case InstanceSpecificationNameEditPartCN.VISUAL_ID:
			return getInstanceSpecificationName_5040Parser();
		case ComponentNameEditPartCN.VISUAL_ID:
			return getComponentName_5043Parser();
		case SignalNameEditPartCN.VISUAL_ID:
			return getSignalName_5046Parser();
		case InterfaceNameEditPartCN.VISUAL_ID:
			return getInterfaceName_5049Parser();
		case ModelNameEditPartCN.VISUAL_ID:
			return getModelName_5052Parser();
		case EnumerationNameEditPartCN.VISUAL_ID:
			return getEnumerationName_5055Parser();
		case PackageNameEditPartCN.VISUAL_ID:
			return getPackageName_5017Parser();
		case InformationItemNameEditPartCN.VISUAL_ID:
			return getInformationItemName_5162Parser();
		case ClassNameEditPartCN.VISUAL_ID:
			return getClassName_5014Parser();
		case PrimitiveTypeNameEditPartCN.VISUAL_ID:
			return getPrimitiveTypeName_5058Parser();
		case DataTypeNameEditPartCN.VISUAL_ID:
			return getDataTypeName_5061Parser();
		case CommentBodyEditPartCN.VISUAL_ID:
			return getCommentBody_5063Parser();
		case ConstraintNameEditPartCN.VISUAL_ID:
			return getConstraintName_5064Parser();
		case ConstraintBodyEditPartCN.VISUAL_ID:
			return getConstraintSpecification_5160Parser();
		case NestedInterfaceForClassEditPart.VISUAL_ID:
			return getInterface_3036Parser();
		case NestedInterfaceForComponentEditPart.VISUAL_ID:
			return getInterface_3037Parser();
		case NestedInterfaceForInterfaceEditPart.VISUAL_ID:
			return getInterface_3038Parser();
		case NestedEnumerationForClassEditPart.VISUAL_ID:
			return getEnumeration_3052Parser();
		case NestedEnumerationForComponentEditPart.VISUAL_ID:
			return getEnumeration_3053Parser();
		case NestedEnumerationForInterfaceEditPart.VISUAL_ID:
			return getEnumeration_3054Parser();
		case NestedPrimitiveTypeForClassEditPart.VISUAL_ID:
			return getPrimitiveType_3047Parser();
		case NestedPrimitiveTypeForComponentEditPart.VISUAL_ID:
			return getPrimitiveType_3046Parser();
		case NestedPrimitiveTypeForInterfaceEditPart.VISUAL_ID:
			return getPrimitiveType_3048Parser();
		case NestedDataTypeForClassEditPart.VISUAL_ID:
			return getDataType_3044Parser();
		case NestedDataTypeForComponentEditPart.VISUAL_ID:
			return getDataType_3045Parser();
		case NestedDataTypeForInterfaceEditPart.VISUAL_ID:
			return getDataType_3043Parser();
		case NestedSignalForClassEditPart.VISUAL_ID:
			return getSignal_3050Parser();
		case NestedSignalForComponentEditPart.VISUAL_ID:
			return getSignal_3051Parser();
		case NestedSignalForInterfaceEditPart.VISUAL_ID:
			return getSignal_3049Parser();
		case AssociationClassRoleSourceEditPart.VISUAL_ID:
			return getAssociationClassName_6031Parser();
		case AssociationClassRoleTargetEditPart.VISUAL_ID:
			return getAssociationClassName_6032Parser();
		case AppliedStereotypeAssociationEditPart.VISUAL_ID:
			return getAssociationName_6001Parser();
		case AssociationNameEditPart.VISUAL_ID:
			return getAssociationName_6002Parser();
		case AssociationTargetNameEditPart.VISUAL_ID:
			return getAssociationName_6003Parser();
		case AssociationSourceNameEditPart.VISUAL_ID:
			return getAssociationName_6005Parser();
		case AssociationMultiplicitySourceEditPart.VISUAL_ID:
			return getAssociationName_6033Parser();
		case AssociationMultiplicityTargetEditPart.VISUAL_ID:
			return getAssociationName_6034Parser();
		case AssociationBranchMutliplicityEditPart.VISUAL_ID:
			return getAssociationName_6035Parser();
		case AppliedStereotyperGeneralizationEditPart.VISUAL_ID:
			return getGeneralizationIsSubstitutable_6007Parser();
		case AppliedStereotypeInterfaceRealizationEditPart.VISUAL_ID:
			return getInterfaceRealizationName_6008Parser();
		case InterfaceRealizationNameEditPart.VISUAL_ID:
			return getInterfaceRealizationName_6009Parser();
		case AppliedStereotypeSubstitutionEditPart.VISUAL_ID:
			return getSubstitutionName_6010Parser();
		case SubstitutionNameEditPart.VISUAL_ID:
			return getSubstitutionName_6011Parser();
		case AppliedStereotypeRealizationEditPart.VISUAL_ID:
			return getRealizationName_6012Parser();
		case RealizationNameEditPart.VISUAL_ID:
			return getRealizationName_6013Parser();
		case AbstractionNameEditPart.VISUAL_ID:
			return getAbstractionName_6014Parser();
		case AppliedStereotypeAbstractionEditPart.VISUAL_ID:
			return getAbstractionName_6015Parser();
		case UsageNameEditPart.VISUAL_ID:
			return getUsageName_6016Parser();
		case AppliedStereotypeUsageEditPart.VISUAL_ID:
			return getUsageName_6017Parser();
		case DependencyNameEditPart.VISUAL_ID:
			return getDependencyName_6026Parser();
		case AppliedStereotypeDependencyEditPart.VISUAL_ID:
			return getDependencyName_6027Parser();
		case ElementImportAliasEditPart.VISUAL_ID:
			return getElementImportAlias_6020Parser();
		case AppliedStereotypeElementImportEditPart.VISUAL_ID:
			return getElementImportAlias_6021Parser();
		case AppliedStereotypePackageImportEditPart.VISUAL_ID:
			return getPackageImportVisibility_6022Parser();
		case AppliedStereotypePackageMergeEditPart.VISUAL_ID:
			return getPackageMergeLabel_6030Parser();
		case BindingSubstitutionEditPart.VISUAL_ID:
			return getTemplateBindingLabel_6023Parser();
		case AppliedStereotypeTemplateBindingEditPart.VISUAL_ID:
			return getTemplateBindingLabel_6036Parser();
		case ConstraintLabelEditPart.VISUAL_ID:
			return getGeneralizationSetIsCoveringIsDisjoint_5067Parser();
		case AppliedStereotypeGeneralizationSetLabelEditPart.VISUAL_ID:
			return getGeneralizationSetLabel_6037Parser();
		case SourceISLinkLabelEditPart.VISUAL_ID:
			return getInstanceSpecificationLabel_6039Parser();
		case TargetISLinkLabelEditPart.VISUAL_ID:
			return getInstanceSpecificationLabel_6038Parser();
		case InformationFlowAppliedStereotypeEditPart.VISUAL_ID:
			return getInformationFlowName_6041Parser();
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
		public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
			if(IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}
}
