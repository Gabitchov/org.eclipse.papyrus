/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.providers;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.papyrus.diagram.clazz.custom.parsers.AppliedStereotypeParser;
import org.eclipse.papyrus.diagram.clazz.custom.parsers.CustomMessageFormatParser;
import org.eclipse.papyrus.diagram.clazz.custom.parsers.OperationParser;
import org.eclipse.papyrus.diagram.clazz.custom.parsers.PropertyParser;
import org.eclipse.papyrus.diagram.clazz.parsers.MessageFormatParser;
import org.eclipse.papyrus.diagram.clazz.providers.UMLParserProvider;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * this class is used to overload specific parsers
 * 
 * @author patrick Tessier
 */
public class CustomUMLParserProvider extends UMLParserProvider {

	public CustomUMLParserProvider() {
		super();
	}

	/**
	 * @generated
	 */
	protected IParser createAbstractionName_6015Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	protected IParser createAssociationClassName_5065Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationName_6001Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationName_6002Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationName_6003Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		IParser parser = new CustomMessageFormatParser(features, UMLPackage.eINSTANCE.getAssociation_MemberEnd(), 0);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createAssociationName_6004Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getMultiplicityElement_Lower(), UMLPackage.eINSTANCE.getMultiplicityElement_Upper(), };
		CustomMessageFormatParser parser = new CustomMessageFormatParser(features, UMLPackage.eINSTANCE.getAssociation_MemberEnd(), 0);
		parser.setViewPattern("{0}..{1}");
		parser.setEditorPattern("{0}..{1}");
		parser.setEditPattern("{0}..{1}");
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationName_6005Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getMultiplicityElement_Lower(), UMLPackage.eINSTANCE.getMultiplicityElement_Upper(), };
		CustomMessageFormatParser parser = new CustomMessageFormatParser(features, UMLPackage.eINSTANCE.getAssociation_MemberEnd(), 1);
		parser.setViewPattern("{0}..{1}");
		parser.setEditorPattern("{0}..{1}");
		parser.setEditPattern("{0}..{1}");
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationName_6006Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		IParser parser = new CustomMessageFormatParser(features, UMLPackage.eINSTANCE.getAssociation_MemberEnd(), 1);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createClassName_5013Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createClassName_5028Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createComponentName_5004Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	protected IParser createComponentName_5042Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected IParser createCustomPropertyParser() {
		return new PropertyParser();
	}

	/**
	 * @generated
	 */
	protected IParser createDataTypeName_5034Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected IParser createDataTypeName_5060Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createDataTypeQualifiedName_5036Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("({0})");
		parser.setEditorPattern("({0})");
		parser.setEditPattern("({0})");
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createDependencyName_6027Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createElementImportAlias_6021Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEnumerationName_5022Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEnumerationName_5054Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createGeneralizationIsSubstitutable_6007Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInstanceSpecificationName_5001Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected IParser createInstanceSpecificationName_5039Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInterfaceName_5010Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected IParser createInterfaceName_5048Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createInterfaceRealizationName_6008Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createModelName_5019Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected IParser createModelName_5051Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createOperation_3003Parser() {
		return createOperationParser();
	}

	/**
	 * @generated
	 */
	protected IParser createOperation_3007Parser() {
		return createOperationParser();
	}

	/**
	 * @generated
	 */
	protected IParser createOperation_3013Parser() {
		return createOperationParser();
	}

	/**
	 * @generated
	 */
	protected IParser createOperation_3019Parser() {
		return createOperationParser();
	}

	private IParser createOperationParser() {
		OperationParser operationParser = new OperationParser();
		return operationParser;
	}

	/**
	 * @generated
	 */
	protected IParser createPackageImportVisibility_6022Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPackageName_5016Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPackageName_5025Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPrimitiveTypeName_5031Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected IParser createPrimitiveTypeName_5057Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createProperty_3002Parser() {
		return createCustomPropertyParser();
	}

	/**
	 * @generated
	 */
	protected IParser createProperty_3005Parser() {
		return createCustomPropertyParser();
	}

	/**
	 * @generated
	 */
	protected IParser createProperty_3006Parser() {
		return createCustomPropertyParser();
	}

	/**
	 * @generated
	 */
	protected IParser createProperty_3012Parser() {
		return createCustomPropertyParser();
	}

	/**
	 * @generated
	 */
	protected IParser createProperty_3018Parser() {
		return createCustomPropertyParser();
	}

	/**
	 * @generated
	 */
	protected IParser createRealizationName_6012Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createSignalName_5007Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	protected IParser createSignalName_5045Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createSubstitutionName_6010Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createUsageName_6017Parser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

}