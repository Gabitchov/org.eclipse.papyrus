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
	 * 
	 * {@inheritDoc}
	 */
	protected IParser createCustomPropertyParser() {
		return new PropertyParser();
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

}