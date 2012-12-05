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
package org.eclipse.papyrus.uml.diagram.profile.providers;

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
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.parser.CommentParser;
import org.eclipse.papyrus.uml.diagram.common.parser.ConstraintParser;
import org.eclipse.papyrus.uml.diagram.common.parser.packageimport.PackageImportVisibilityParser;
import org.eclipse.papyrus.uml.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AppliedStereotypeElementImportEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationBranchMultiplicityEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationMultiplicitySourceEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationMultiplicityTargetEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationNameEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationRoleSourceEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationRoleTargetEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ClassOperationEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ClassPropertyEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.CommentBodyEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ConstraintBodyEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ConstraintBondyEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ConstraintNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DataTypeNameEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DataTypeNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DataTypeOperationEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DataTypePropertyEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DependencyAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DependencyNameEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DiagramNameEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ElementImportAliasEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.EnumerationLiteralEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.EnumerationNameEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.EnumerationNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.GeneralizationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.MetaclassNameEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.MetaclassNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ModelNameEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ModelNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.MultiDependencyLabelEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PackageImportAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PackageNameEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PackageNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PrimitiveTypeNameEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PrimitiveTypeNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ProfileNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ProfileNameEditPartTN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.StereotypeNameEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.StereotypeNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.parsers.MessageFormatParser;
import org.eclipse.papyrus.uml.diagram.profile.part.UMLVisualIDRegistry;
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
	private IParser stereotypeName_1034Parser;

	/**
	 * @generated
	 */
	private IParser getStereotypeName_1034Parser() {
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
	private IParser getClassName_1084Parser() {
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
	private IParser getCommentBody_3Parser() {
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
	private IParser getConstraintName_1015Parser() {
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
	private ConstraintParser constraintSpecification_5063Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintSpecification_5063Parser() {
		if(constraintSpecification_5063Parser == null) {
			constraintSpecification_5063Parser = new ConstraintParser();
		}
		return constraintSpecification_5063Parser;
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
	private IParser profileName_1047Parser;

	/**
	 * @generated
	 */
	private IParser getProfileName_1047Parser() {
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
	private IParser diagramName_2Parser;

	/**
	 * @generated
	 */
	private IParser getDiagramName_2Parser() {
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
	private IParser enumerationLiteral_1037Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationLiteral_1037Parser() {
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
	private IParser operation_3020Parser;

	/**
	 * @generated
	 */
	private IParser getOperation_3020Parser() {
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
	private IParser getStereotypeName_1046Parser() {
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
	private IParser getClassName_5062Parser() {
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
	private IParser getCommentBody_1008Parser() {
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
	private IParser getModelName_1056Parser() {
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
	private IParser getProfileName_1050Parser() {
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
	private IParser getPackageName_1010Parser() {
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
	private IParser getConstraintName_1059Parser() {
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
	private ConstraintParser constraintSpecification_5064Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintSpecification_5064Parser() {
		if(constraintSpecification_5064Parser == null) {
			constraintSpecification_5064Parser = new ConstraintParser();
		}
		return constraintSpecification_5064Parser;
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
	protected IParser getParser(int visualID) {
		switch(visualID) {
		case MultiDependencyLabelEditPart.VISUAL_ID:
			return getDependencyName_1Parser();
		case StereotypeNameEditPart.VISUAL_ID:
			return getStereotypeName_1034Parser();
		case MetaclassNameEditPart.VISUAL_ID:
			return getClassName_1084Parser();
		case CommentBodyEditPart.VISUAL_ID:
			return getCommentBody_3Parser();
		case ConstraintNameEditPart.VISUAL_ID:
			return getConstraintName_1015Parser();
		case ConstraintBodyEditPart.VISUAL_ID:
			return getConstraintSpecification_5063Parser();
		case ModelNameEditPart.VISUAL_ID:
			return getModelName_5020Parser();
		case ProfileNameEditPartTN.VISUAL_ID:
			return getProfileName_1047Parser();
		case PackageNameEditPart.VISUAL_ID:
			return getPackageName_5026Parser();
		case EnumerationNameEditPart.VISUAL_ID:
			return getEnumerationName_5023Parser();
		case PrimitiveTypeNameEditPart.VISUAL_ID:
			return getPrimitiveTypeName_5032Parser();
		case DataTypeNameEditPart.VISUAL_ID:
			return getDataTypeName_5035Parser();
		case DiagramNameEditPart.VISUAL_ID:
			return getDiagramName_2Parser();
		case PrimitiveTypeNameEditPartCN.VISUAL_ID:
			return getPrimitiveTypeName_5058Parser();
		case DataTypeOperationEditPart.VISUAL_ID:
			return getOperation_3019Parser();
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_1037Parser();
		case DataTypePropertyEditPart.VISUAL_ID:
			return getProperty_3018Parser();
		case ClassPropertyEditPart.VISUAL_ID:
			return getProperty_3002Parser();
		case ClassOperationEditPart.VISUAL_ID:
			return getOperation_3020Parser();
		case StereotypeNameEditPartCN.VISUAL_ID:
			return getStereotypeName_1046Parser();
		case MetaclassNameEditPartCN.VISUAL_ID:
			return getClassName_5062Parser();
		case CommentBodyEditPartCN.VISUAL_ID:
			return getCommentBody_1008Parser();
		case ModelNameEditPartCN.VISUAL_ID:
			return getModelName_1056Parser();
		case ProfileNameEditPartCN.VISUAL_ID:
			return getProfileName_1050Parser();
		case PackageNameEditPartCN.VISUAL_ID:
			return getPackageName_1010Parser();
		case ConstraintNameEditPartCN.VISUAL_ID:
			return getConstraintName_1059Parser();
		case ConstraintBondyEditPartCN.VISUAL_ID:
			return getConstraintSpecification_5064Parser();
		case EnumerationNameEditPartCN.VISUAL_ID:
			return getEnumerationName_5055Parser();
		case DataTypeNameEditPartCN.VISUAL_ID:
			return getDataTypeName_5061Parser();
		case AssociationAppliedStereotypeEditPart.VISUAL_ID:
			return getAssociationName_6001Parser();
		case AssociationNameEditPart.VISUAL_ID:
			return getAssociationName_6002Parser();
		case AssociationRoleTargetEditPart.VISUAL_ID:
			return getAssociationName_6003Parser();
		case AssociationRoleSourceEditPart.VISUAL_ID:
			return getAssociationName_6005Parser();
		case AssociationMultiplicitySourceEditPart.VISUAL_ID:
			return getAssociationName_6033Parser();
		case AssociationMultiplicityTargetEditPart.VISUAL_ID:
			return getAssociationName_6034Parser();
		case AssociationBranchMultiplicityEditPart.VISUAL_ID:
			return getAssociationName_6035Parser();
		case GeneralizationAppliedStereotypeEditPart.VISUAL_ID:
			return getGeneralizationIsSubstitutable_6007Parser();
		case DependencyNameEditPart.VISUAL_ID:
			return getDependencyName_6026Parser();
		case DependencyAppliedStereotypeEditPart.VISUAL_ID:
			return getDependencyName_6027Parser();
		case ElementImportAliasEditPart.VISUAL_ID:
			return getElementImportAlias_6020Parser();
		case AppliedStereotypeElementImportEditPart.VISUAL_ID:
			return getElementImportAlias_6021Parser();
		case PackageImportAppliedStereotypeEditPart.VISUAL_ID:
			return getPackageImportVisibility_6022Parser();
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
