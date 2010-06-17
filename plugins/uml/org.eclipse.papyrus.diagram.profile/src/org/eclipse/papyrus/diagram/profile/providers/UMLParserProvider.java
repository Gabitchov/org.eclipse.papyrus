/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.providers;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.diagram.common.parser.CommentParser;
import org.eclipse.papyrus.diagram.common.parser.packageimport.PackageImportVisibilityParser;
import org.eclipse.papyrus.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.papyrus.diagram.profile.parsers.MessageFormatParser;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider {

	/**
	 * @generated
	 */
	private IParser dependencyName_1Parser;

	/**
	 * @generated
	 */
	public IParser getDependencyName_1Parser() {
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
	private IParser stereotypeName_1034Parser;

	/**
	 * @generated
	 */
	public IParser getStereotypeName_1034Parser() {
		if(stereotypeName_1034Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			stereotypeName_1034Parser = parser;
		}
		return stereotypeName_1034Parser;
	}

	/**
	 * @generated
	 */
	private IParser className_1084Parser;

	/**
	 * @generated
	 */
	public IParser getClassName_1084Parser() {
		if(className_1084Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			className_1084Parser = parser;
		}
		return className_1084Parser;
	}

	/**
	 * @generated
	 */
	private CommentParser commentBody_3Parser;

	/**
	 * @generated
	 */
	public IParser getCommentBody_3Parser() {
		if(commentBody_3Parser == null) {
			commentBody_3Parser = new CommentParser();
		}
		return commentBody_3Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_1015Parser;

	/**
	 * @generated
	 */
	public IParser getConstraintName_1015Parser() {
		if(constraintName_1015Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintName_1015Parser = parser;
		}
		return constraintName_1015Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelName_5020Parser;

	/**
	 * @generated
	 */
	public IParser getModelName_5020Parser() {
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
	private IParser profileName_1047Parser;

	/**
	 * @generated
	 */
	public IParser getProfileName_1047Parser() {
		if(profileName_1047Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			profileName_1047Parser = parser;
		}
		return profileName_1047Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_5026Parser;

	/**
	 * @generated
	 */
	public IParser getPackageName_5026Parser() {
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
	private IParser enumerationName_5023Parser;

	/**
	 * @generated
	 */
	public IParser getEnumerationName_5023Parser() {
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
	private IParser dataTypeName_5035Parser;

	/**
	 * @generated
	 */
	public IParser getDataTypeName_5035Parser() {
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
	private IParser diagramName_2Parser;

	/**
	 * @generated
	 */
	public IParser getDiagramName_2Parser() {
		if(diagramName_2Parser == null) {
			EAttribute[] features = new EAttribute[]{ NotationPackage.eINSTANCE.getDiagram_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			diagramName_2Parser = parser;
		}
		return diagramName_2Parser;
	}

	/**
	 * @generated
	 */
	private IParser operation_3019Parser;

	/**
	 * @generated
	 */
	public IParser getOperation_3019Parser() {
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
	private IParser enumerationLiteral_1037Parser;

	/**
	 * @generated
	 */
	public IParser getEnumerationLiteral_1037Parser() {
		if(enumerationLiteral_1037Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			enumerationLiteral_1037Parser = parser;
		}
		return enumerationLiteral_1037Parser;
	}

	/**
	 * @generated
	 */
	private IParser property_3018Parser;

	/**
	 * @generated
	 */
	public IParser getProperty_3018Parser() {
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
	private IParser property_3002Parser;

	/**
	 * @generated
	 */
	public IParser getProperty_3002Parser() {
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
	private IParser operation_3020Parser;

	/**
	 * @generated
	 */
	public IParser getOperation_3020Parser() {
		if(operation_3020Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			operation_3020Parser = parser;
		}
		return operation_3020Parser;
	}

	/**
	 * @generated
	 */
	private IParser stereotypeName_1046Parser;

	/**
	 * @generated
	 */
	public IParser getStereotypeName_1046Parser() {
		if(stereotypeName_1046Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			stereotypeName_1046Parser = parser;
		}
		return stereotypeName_1046Parser;
	}

	/**
	 * @generated
	 */
	private IParser className_5062Parser;

	/**
	 * @generated
	 */
	public IParser getClassName_5062Parser() {
		if(className_5062Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			className_5062Parser = parser;
		}
		return className_5062Parser;
	}

	/**
	 * @generated
	 */
	private CommentParser commentBody_1008Parser;

	/**
	 * @generated
	 */
	public IParser getCommentBody_1008Parser() {
		if(commentBody_1008Parser == null) {
			commentBody_1008Parser = new CommentParser();
		}
		return commentBody_1008Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelName_1056Parser;

	/**
	 * @generated
	 */
	public IParser getModelName_1056Parser() {
		if(modelName_1056Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			modelName_1056Parser = parser;
		}
		return modelName_1056Parser;
	}

	/**
	 * @generated
	 */
	private IParser profileName_1050Parser;

	/**
	 * @generated
	 */
	public IParser getProfileName_1050Parser() {
		if(profileName_1050Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			profileName_1050Parser = parser;
		}
		return profileName_1050Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_1010Parser;

	/**
	 * @generated
	 */
	public IParser getPackageName_1010Parser() {
		if(packageName_1010Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			packageName_1010Parser = parser;
		}
		return packageName_1010Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_1059Parser;

	/**
	 * @generated
	 */
	public IParser getConstraintName_1059Parser() {
		if(constraintName_1059Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintName_1059Parser = parser;
		}
		return constraintName_1059Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumerationName_5055Parser;

	/**
	 * @generated
	 */
	public IParser getEnumerationName_5055Parser() {
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
	private IParser dataTypeName_5061Parser;

	/**
	 * @generated
	 */
	public IParser getDataTypeName_5061Parser() {
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
	private AppliedStereotypeParser associationName_6001Parser;

	/**
	 * @generated
	 */
	public IParser getAssociationName_6001Parser() {
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
	public IParser getAssociationName_6002Parser() {
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
	public IParser getAssociationName_6003Parser() {
		if(associationName_6003Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
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
	public IParser getAssociationName_6005Parser() {
		if(associationName_6005Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			associationName_6005Parser = parser;
		}
		return associationName_6005Parser;
	}

	/**
	 * @generated
	 */
	private IParser generalizationIsSubstitutable_6007Parser;

	/**
	 * @generated
	 */
	public IParser getGeneralizationIsSubstitutable_6007Parser() {
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
	private IParser dependencyName_6026Parser;

	/**
	 * @generated
	 */
	public IParser getDependencyName_6026Parser() {
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
	public IParser getDependencyName_6027Parser() {
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
	public IParser getElementImportAlias_6020Parser() {
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
	public IParser getElementImportAlias_6021Parser() {
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
	public IParser getPackageImportVisibility_6022Parser() {
		if(packageImportVisibility_6022Parser == null) {
			packageImportVisibility_6022Parser = new PackageImportVisibilityParser();
		}
		return packageImportVisibility_6022Parser;
	}

	private static org.eclipse.papyrus.diagram.profile.providers.UMLParserProvider ourInstance;

	public static org.eclipse.papyrus.diagram.profile.providers.UMLParserProvider get() {
		if(ourInstance == null) {
			ourInstance = new org.eclipse.papyrus.diagram.profile.providers.UMLParserProvider();
		}
		return ourInstance;
	}
}
