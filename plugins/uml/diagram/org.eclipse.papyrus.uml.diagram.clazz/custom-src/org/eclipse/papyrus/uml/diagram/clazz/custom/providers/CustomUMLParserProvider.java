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
package org.eclipse.papyrus.uml.diagram.clazz.custom.providers;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.papyrus.uml.diagram.clazz.custom.parsers.CustomMessageFormatParser;
import org.eclipse.papyrus.uml.diagram.clazz.custom.parsers.OperationParser;
import org.eclipse.papyrus.uml.diagram.clazz.custom.parsers.PropertyParser;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AppliedStereotypeAbstractionEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AppliedStereotypeAssociationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AppliedStereotypeDependencyEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AppliedStereotypeElementImportEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AppliedStereotypeInterfaceRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AppliedStereotypePackageImportEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AppliedStereotypeRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AppliedStereotypeSubstitutionEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AppliedStereotypeUsageEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AppliedStereotyperGeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationBranchMutliplicityEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationBranchRoleEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationNameEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationSourceNameEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationTargetNameEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.OperationForClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.OperationForComponentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.OperationForDataTypeEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.OperationForInterfaceEditpart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PropertyForClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PropertyForComponentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PropertyForInterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PropertyForSignalEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PropertyforDataTypeEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.parsers.MessageFormatParser;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLParserProvider;
import org.eclipse.papyrus.uml.diagram.common.parser.custom.AssociationEndParser;
import org.eclipse.papyrus.uml.diagram.common.parser.custom.AssociationMultiplicityParser;
import org.eclipse.papyrus.uml.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * this class is used to overload specific parsers
 * 
 * @author patrick Tessier
 */
public class CustomUMLParserProvider extends UMLParserProvider {

	private static final int ASSOCIATION_SOURCE = 0;

	private static final int ASSOCIATION_TARGET = 1;

	public CustomUMLParserProvider() {
		super();
	}

	protected IParser getAppliedStereotypeParser() {
		IParser parser = new AppliedStereotypeParser();
		return parser;
	}

	protected IParser getAssociationBranchRole() {
		EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name(), };
		IParser parser = new CustomMessageFormatParser(features, UMLPackage.eINSTANCE.getAssociation_MemberEnd(), 0);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getAssociationName_6002Parser() {
		EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getAssociationSourceMultiplicity() {
		return new AssociationMultiplicityParser(ASSOCIATION_SOURCE);
	}

	/**
	 * @generated
	 */
	protected IParser getAssociationSourceRole() {
		return new AssociationEndParser(ASSOCIATION_SOURCE);
	}

	/**
	 * @generated
	 */
	protected IParser getAssociationTargetMultiplicity() {
		return new AssociationMultiplicityParser(ASSOCIATION_TARGET);
	}

	/**
	 * @generated
	 */
	protected IParser getAssociationTargetRole() {
		return new AssociationEndParser(ASSOCIATION_TARGET);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected IParser getCustomPropertyParser() {
		return new PropertyParser();
	}

	private IParser getOperationParser() {
		OperationParser operationParser = new OperationParser();
		return operationParser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch(visualID) {
		case PropertyForComponentEditPart.VISUAL_ID:
			return getCustomPropertyParser();
		case OperationForComponentEditPart.VISUAL_ID:
			return getOperationParser();
		case PropertyForSignalEditPart.VISUAL_ID:
			return getCustomPropertyParser();
		case PropertyForInterfaceEditPart.VISUAL_ID:
			return getCustomPropertyParser();
		case OperationForInterfaceEditpart.VISUAL_ID:
			return getOperationParser();
		case PropertyForClassEditPart.VISUAL_ID:
			return getCustomPropertyParser();
		case OperationForClassEditPart.VISUAL_ID:
			return getOperationParser();
		case PropertyforDataTypeEditPart.VISUAL_ID:
			return getCustomPropertyParser();
		case OperationForDataTypeEditPart.VISUAL_ID:
			return getOperationParser();
		case AssociationNameEditPart.VISUAL_ID:
			return getAssociationName_6002Parser();
		case AssociationTargetNameEditPart.VISUAL_ID:
			return getAssociationTargetRole();
		case AssociationSourceNameEditPart.VISUAL_ID:
			return getAssociationSourceMultiplicity();
		case AssociationBranchRoleEditPart.VISUAL_ID:
			return getAssociationSourceRole();
		case AssociationBranchMutliplicityEditPart.VISUAL_ID:
			return getAssociationSourceMultiplicity();
		case AppliedStereotypeAssociationEditPart.VISUAL_ID:
			return getAppliedStereotypeParser();
		case AppliedStereotyperGeneralizationEditPart.VISUAL_ID:
			return getAppliedStereotypeParser();
		case AppliedStereotypeInterfaceRealizationEditPart.VISUAL_ID:
			return getAppliedStereotypeParser();
		case AppliedStereotypeSubstitutionEditPart.VISUAL_ID:
			return getAppliedStereotypeParser();
		case AppliedStereotypeRealizationEditPart.VISUAL_ID:
			return getAppliedStereotypeParser();
		case AppliedStereotypeAbstractionEditPart.VISUAL_ID:
			return getAppliedStereotypeParser();
		case AppliedStereotypeUsageEditPart.VISUAL_ID:
			return getAppliedStereotypeParser();
		case AppliedStereotypeDependencyEditPart.VISUAL_ID:
			return getAppliedStereotypeParser();
		case AppliedStereotypeElementImportEditPart.VISUAL_ID:
			return getAppliedStereotypeParser();
		case AppliedStereotypePackageImportEditPart.VISUAL_ID:
			return getAppliedStereotypeParser();
		}
		return super.getParser(visualID);
	}
}
