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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *  manage label for package import visibility
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.providers;

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
import org.eclipse.papyrus.diagram.common.parser.CommentParser;
import org.eclipse.papyrus.diagram.common.parser.packageimport.PackageImportVisibilityParser;
import org.eclipse.papyrus.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AbstractionNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorAppliedStereotypeEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorAsRectangleNameEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorInComponentAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorInComponentNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorInPackageAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorInPackageNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorNameEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AppliedStereotypeAbstractionEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AppliedStereotypePackageMergeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AppliedStereotypeUsageEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentBodyEditPartCN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentBodyEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentInComponentNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentInPackageNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentNameEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintInComponentNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintInPackageNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintNameEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.DependencyAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.DependencyNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.DiagramNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtendAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtensionPointEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtensionPointInRectangleEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.GeneralizationAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.IncludeAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageImportAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageImportVisibilityEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageNameEditPartCN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageNameEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.RealizationAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.RealizationNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UsageNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseAsRectangleNameEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseInComponentNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseInPackageNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseNameEditPartTN;
import org.eclipse.papyrus.diagram.usecase.parsers.MessageFormatParser;
import org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser actorName_5014Parser;

	/**
	 * @generated
	 */
	private IParser getActorName_5014Parser() {
		if(actorName_5014Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			actorName_5014Parser = parser;
		}
		return actorName_5014Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser actorLabel_6029Parser;

	/**
	 * @generated
	 */
	private IParser getActorLabel_6029Parser() {
		if(actorLabel_6029Parser == null) {
			actorLabel_6029Parser = new AppliedStereotypeParser();
		}
		return actorLabel_6029Parser;
	}

	/**
	 * @generated
	 */
	private IParser actorName_5015Parser;

	/**
	 * @generated
	 */
	private IParser getActorName_5015Parser() {
		if(actorName_5015Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			actorName_5015Parser = parser;
		}
		return actorName_5015Parser;
	}

	/**
	 * @generated
	 */
	private IParser useCaseName_5016Parser;

	/**
	 * @generated
	 */
	private IParser getUseCaseName_5016Parser() {
		if(useCaseName_5016Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			useCaseName_5016Parser = parser;
		}
		return useCaseName_5016Parser;
	}

	/**
	 * @generated
	 */
	private IParser useCaseName_5017Parser;

	/**
	 * @generated
	 */
	private IParser getUseCaseName_5017Parser() {
		if(useCaseName_5017Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			useCaseName_5017Parser = parser;
		}
		return useCaseName_5017Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentName_5019Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_5019Parser() {
		if(componentName_5019Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			componentName_5019Parser = parser;
		}
		return componentName_5019Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_5025Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_5025Parser() {
		if(packageName_5025Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			packageName_5025Parser = parser;
		}
		return packageName_5025Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_5026Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_5026Parser() {
		if(constraintName_5026Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintName_5026Parser = parser;
		}
		return constraintName_5026Parser;
	}

	/**
	 * @generated
	 */
	private CommentParser commentBody_5027Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_5027Parser() {
		if(commentBody_5027Parser == null) {
			commentBody_5027Parser = new CommentParser();
		}
		return commentBody_5027Parser;
	}

	/**
	 * @generated
	 */
	private IParser diagramName_5032Parser;

	/**
	 * @generated
	 */
	private IParser getDiagramName_5032Parser() {
		if(diagramName_5032Parser == null) {
			EAttribute[] features = new EAttribute[]{ NotationPackage.eINSTANCE.getDiagram_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			diagramName_5032Parser = parser;
		}
		return diagramName_5032Parser;
	}

	/**
	 * @generated
	 */
	private IParser extensionPoint_3007Parser;

	/**
	 * @generated
	 */
	private IParser getExtensionPoint_3007Parser() {
		if(extensionPoint_3007Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			extensionPoint_3007Parser = parser;
		}
		return extensionPoint_3007Parser;
	}

	/**
	 * @generated
	 */
	private IParser extensionPoint_3008Parser;

	/**
	 * @generated
	 */
	private IParser getExtensionPoint_3008Parser() {
		if(extensionPoint_3008Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			extensionPoint_3008Parser = parser;
		}
		return extensionPoint_3008Parser;
	}

	/**
	 * @generated
	 */
	private IParser useCaseName_5018Parser;

	/**
	 * @generated
	 */
	private IParser getUseCaseName_5018Parser() {
		if(useCaseName_5018Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			useCaseName_5018Parser = parser;
		}
		return useCaseName_5018Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentName_5030Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_5030Parser() {
		if(componentName_5030Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			componentName_5030Parser = parser;
		}
		return componentName_5030Parser;
	}

	/**
	 * @generated
	 */
	private CommentParser commentBody_5028Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_5028Parser() {
		if(commentBody_5028Parser == null) {
			commentBody_5028Parser = new CommentParser();
		}
		return commentBody_5028Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_5029Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_5029Parser() {
		if(constraintName_5029Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintName_5029Parser = parser;
		}
		return constraintName_5029Parser;
	}

	/**
	 * @generated
	 */
	private IParser actorName_5031Parser;

	/**
	 * @generated
	 */
	private IParser getActorName_5031Parser() {
		if(actorName_5031Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			actorName_5031Parser = parser;
		}
		return actorName_5031Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser actorLabel_6027Parser;

	/**
	 * @generated
	 */
	private IParser getActorLabel_6027Parser() {
		if(actorLabel_6027Parser == null) {
			actorLabel_6027Parser = new AppliedStereotypeParser();
		}
		return actorLabel_6027Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_5020Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_5020Parser() {
		if(constraintName_5020Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintName_5020Parser = parser;
		}
		return constraintName_5020Parser;
	}

	/**
	 * @generated
	 */
	private IParser actorName_5021Parser;

	/**
	 * @generated
	 */
	private IParser getActorName_5021Parser() {
		if(actorName_5021Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			actorName_5021Parser = parser;
		}
		return actorName_5021Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser actorLabel_6028Parser;

	/**
	 * @generated
	 */
	private IParser getActorLabel_6028Parser() {
		if(actorLabel_6028Parser == null) {
			actorLabel_6028Parser = new AppliedStereotypeParser();
		}
		return actorLabel_6028Parser;
	}

	/**
	 * @generated
	 */
	private IParser useCaseName_5022Parser;

	/**
	 * @generated
	 */
	private IParser getUseCaseName_5022Parser() {
		if(useCaseName_5022Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			useCaseName_5022Parser = parser;
		}
		return useCaseName_5022Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentName_5023Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_5023Parser() {
		if(componentName_5023Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			componentName_5023Parser = parser;
		}
		return componentName_5023Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_5024Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_5024Parser() {
		if(packageName_5024Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			packageName_5024Parser = parser;
		}
		return packageName_5024Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser includeLabel_6030Parser;

	/**
	 * @generated
	 */
	private IParser getIncludeLabel_6030Parser() {
		if(includeLabel_6030Parser == null) {
			includeLabel_6030Parser = new AppliedStereotypeParser();
		}
		return includeLabel_6030Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser extendLabel_6031Parser;

	/**
	 * @generated
	 */
	private IParser getExtendLabel_6031Parser() {
		if(extendLabel_6031Parser == null) {
			extendLabel_6031Parser = new AppliedStereotypeParser();
		}
		return extendLabel_6031Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser generalizationLabel_6032Parser;

	/**
	 * @generated
	 */
	private IParser getGeneralizationLabel_6032Parser() {
		if(generalizationLabel_6032Parser == null) {
			generalizationLabel_6032Parser = new AppliedStereotypeParser();
		}
		return generalizationLabel_6032Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_6008Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6008Parser() {
		if(associationName_6008Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			associationName_6008Parser = parser;
		}
		return associationName_6008Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser associationLabel_6033Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationLabel_6033Parser() {
		if(associationLabel_6033Parser == null) {
			associationLabel_6033Parser = new AppliedStereotypeParser();
		}
		return associationLabel_6033Parser;
	}

	/**
	 * @generated
	 */
	private IParser dependencyName_6010Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_6010Parser() {
		if(dependencyName_6010Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dependencyName_6010Parser = parser;
		}
		return dependencyName_6010Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser dependencyLabel_6034Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyLabel_6034Parser() {
		if(dependencyLabel_6034Parser == null) {
			dependencyLabel_6034Parser = new AppliedStereotypeParser();
		}
		return dependencyLabel_6034Parser;
	}

	/**
	 * @generated
	 */
	private IParser abstractionName_6011Parser;

	/**
	 * @generated
	 */
	private IParser getAbstractionName_6011Parser() {
		if(abstractionName_6011Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			abstractionName_6011Parser = parser;
		}
		return abstractionName_6011Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser abstractionLabel_6014Parser;

	/**
	 * @generated
	 */
	private IParser getAbstractionLabel_6014Parser() {
		if(abstractionLabel_6014Parser == null) {
			abstractionLabel_6014Parser = new AppliedStereotypeParser();
		}
		return abstractionLabel_6014Parser;
	}

	/**
	 * @generated
	 */
	private IParser usageName_6012Parser;

	/**
	 * @generated
	 */
	private IParser getUsageName_6012Parser() {
		if(usageName_6012Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			usageName_6012Parser = parser;
		}
		return usageName_6012Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser usageLabel_6013Parser;

	/**
	 * @generated
	 */
	private IParser getUsageLabel_6013Parser() {
		if(usageLabel_6013Parser == null) {
			usageLabel_6013Parser = new AppliedStereotypeParser();
		}
		return usageLabel_6013Parser;
	}

	/**
	 * @generated
	 */
	private IParser realizationName_6015Parser;

	/**
	 * @generated
	 */
	private IParser getRealizationName_6015Parser() {
		if(realizationName_6015Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			realizationName_6015Parser = parser;
		}
		return realizationName_6015Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser realizationLabel_6035Parser;

	/**
	 * @generated
	 */
	private IParser getRealizationLabel_6035Parser() {
		if(realizationLabel_6035Parser == null) {
			realizationLabel_6035Parser = new AppliedStereotypeParser();
		}
		return realizationLabel_6035Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser packageMergeLabel_0Parser;

	/**
	 * @generated
	 */
	private IParser getPackageMergeLabel_0Parser() {
		if(packageMergeLabel_0Parser == null) {
			packageMergeLabel_0Parser = new AppliedStereotypeParser();
		}
		return packageMergeLabel_0Parser;
	}

	/**
	 * @generated
	 */
	private PackageImportVisibilityParser packageImportVisibility_6017Parser;

	/**
	 * @generated
	 */
	private IParser getPackageImportVisibility_6017Parser() {
		if(packageImportVisibility_6017Parser == null) {
			packageImportVisibility_6017Parser = new PackageImportVisibilityParser();
		}
		return packageImportVisibility_6017Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser packageImportLabel_6036Parser;

	/**
	 * @generated
	 */
	private IParser getPackageImportLabel_6036Parser() {
		if(packageImportLabel_6036Parser == null) {
			packageImportLabel_6036Parser = new AppliedStereotypeParser();
		}
		return packageImportLabel_6036Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch(visualID) {
		case ActorNameEditPartTN.VISUAL_ID:
			return getActorName_5014Parser();
		case ActorAppliedStereotypeEditPartTN.VISUAL_ID:
			return getActorLabel_6029Parser();
		case ActorAsRectangleNameEditPartTN.VISUAL_ID:
			return getActorName_5015Parser();
		case UseCaseNameEditPartTN.VISUAL_ID:
			return getUseCaseName_5016Parser();
		case UseCaseAsRectangleNameEditPartTN.VISUAL_ID:
			return getUseCaseName_5017Parser();
		case ComponentNameEditPartTN.VISUAL_ID:
			return getComponentName_5019Parser();
		case PackageNameEditPartTN.VISUAL_ID:
			return getPackageName_5025Parser();
		case ConstraintNameEditPartTN.VISUAL_ID:
			return getConstraintName_5026Parser();
		case CommentBodyEditPartTN.VISUAL_ID:
			return getCommentBody_5027Parser();
		case DiagramNameEditPart.VISUAL_ID:
			return getDiagramName_5032Parser();
		case ExtensionPointEditPart.VISUAL_ID:
			return getExtensionPoint_3007Parser();
		case ExtensionPointInRectangleEditPart.VISUAL_ID:
			return getExtensionPoint_3008Parser();
		case UseCaseInComponentNameEditPart.VISUAL_ID:
			return getUseCaseName_5018Parser();
		case ComponentInComponentNameEditPart.VISUAL_ID:
			return getComponentName_5030Parser();
		case CommentBodyEditPartCN.VISUAL_ID:
			return getCommentBody_5028Parser();
		case ConstraintInComponentNameEditPart.VISUAL_ID:
			return getConstraintName_5029Parser();
		case ActorInComponentNameEditPart.VISUAL_ID:
			return getActorName_5031Parser();
		case ActorInComponentAppliedStereotypeEditPart.VISUAL_ID:
			return getActorLabel_6027Parser();
		case ConstraintInPackageNameEditPart.VISUAL_ID:
			return getConstraintName_5020Parser();
		case ActorInPackageNameEditPart.VISUAL_ID:
			return getActorName_5021Parser();
		case ActorInPackageAppliedStereotypeEditPart.VISUAL_ID:
			return getActorLabel_6028Parser();
		case UseCaseInPackageNameEditPart.VISUAL_ID:
			return getUseCaseName_5022Parser();
		case ComponentInPackageNameEditPart.VISUAL_ID:
			return getComponentName_5023Parser();
		case PackageNameEditPartCN.VISUAL_ID:
			return getPackageName_5024Parser();
		case IncludeAppliedStereotypeEditPart.VISUAL_ID:
			return getIncludeLabel_6030Parser();
		case ExtendAppliedStereotypeEditPart.VISUAL_ID:
			return getExtendLabel_6031Parser();
		case GeneralizationAppliedStereotypeEditPart.VISUAL_ID:
			return getGeneralizationLabel_6032Parser();
		case AssociationNameEditPart.VISUAL_ID:
			return getAssociationName_6008Parser();
		case AssociationAppliedStereotypeEditPart.VISUAL_ID:
			return getAssociationLabel_6033Parser();
		case DependencyNameEditPart.VISUAL_ID:
			return getDependencyName_6010Parser();
		case DependencyAppliedStereotypeEditPart.VISUAL_ID:
			return getDependencyLabel_6034Parser();
		case AbstractionNameEditPart.VISUAL_ID:
			return getAbstractionName_6011Parser();
		case AppliedStereotypeAbstractionEditPart.VISUAL_ID:
			return getAbstractionLabel_6014Parser();
		case UsageNameEditPart.VISUAL_ID:
			return getUsageName_6012Parser();
		case AppliedStereotypeUsageEditPart.VISUAL_ID:
			return getUsageLabel_6013Parser();
		case RealizationNameEditPart.VISUAL_ID:
			return getRealizationName_6015Parser();
		case RealizationAppliedStereotypeEditPart.VISUAL_ID:
			return getRealizationLabel_6035Parser();
		case AppliedStereotypePackageMergeEditPart.VISUAL_ID:
			return getPackageMergeLabel_0Parser();
		case PackageImportVisibilityEditPart.VISUAL_ID:
			return getPackageImportVisibility_6017Parser();
		case PackageImportAppliedStereotypeEditPart.VISUAL_ID:
			return getPackageImportLabel_6036Parser();
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
