/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
package org.eclipse.papyrus.diagram.clazz.providers;

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
import org.eclipse.papyrus.diagram.clazz.custom.parsers.ClassifierTemplateParameterParser;
import org.eclipse.papyrus.diagram.clazz.custom.parsers.GeneralizationSetConstraintParser;
import org.eclipse.papyrus.diagram.clazz.custom.parsers.SlotParser;
import org.eclipse.papyrus.diagram.clazz.custom.parsers.TemplateParameterParser;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AbstractionNameEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AppliedStereotypeAbstractionEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AppliedStereotypeAssociationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AppliedStereotypeDependency3EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AppliedStereotypeDependencyEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AppliedStereotypeElementImportEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AppliedStereotypeInterfaceRealizationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AppliedStereotypePackageImportEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AppliedStereotypePackageMergeEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AppliedStereotypeRealizationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AppliedStereotypeSubstitutionEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AppliedStereotypeUsageEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AppliedStereotyperGeneralizationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationClassName2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationName2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationName3EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationName5EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Class2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Class3EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Class5EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassNameEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassNameEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassifierTemplateParameterEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.CommentBody2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ComponentNameEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ComponentNameEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConstraintLabelEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConstraintName2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataTypeNameEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataTypeNameEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DependencyName3EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DependencyNameEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DiagramNameEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ElementImportAliasEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.EnumerationLiteralEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.EnumerationNameEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.EnumerationNameEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InstanceSpecificationNameEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InstanceSpecificationNameEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceNameEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceNameEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceRealizationName2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelNameEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelNameEditPartTN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Operation2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Operation4EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.OperationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageNameEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageNameEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PrimitiveTypeNameEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PrimitiveTypeNameEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Property2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Property3EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Property5EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PropertyEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.RealizationName2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ReceptionEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.SignalNameEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.SignalNameEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.SlotEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.SubstitutionName2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.TemplateParameterEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.UsageNameEditPart;
import org.eclipse.papyrus.diagram.clazz.parsers.MessageFormatParser;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.common.parser.CommentParser;
import org.eclipse.papyrus.diagram.common.parser.packageimport.PackageImportVisibilityParser;
import org.eclipse.papyrus.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements IParserProvider {

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
	private IParser abstractionName_6014Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser abstractionName_6015Parser;

	/**
	 * @generated
	 */
	private IParser associationClassName_5066Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser associationName_6001Parser;

	/**
	 * @generated
	 */
	private IParser associationName_6002Parser;

	/**
	 * @generated
	 */
	private IParser associationName_6003Parser;

	/**
	 * @generated
	 */
	private IParser associationName_6005Parser;

	/**
	 * @generated
	 */
	private IParser class_3004Parser;

	/**
	 * @generated
	 */
	private IParser class_3008Parser;

	/**
	 * @generated
	 */
	private IParser class_3014Parser;

	/**
	 * @generated
	 */
	private IParser className_5014Parser;

	/**
	 * @generated
	 */
	private IParser className_5029Parser;

	/**
	 * @generated
	 */
	private CommentParser commentBody_5038Parser;

	/**
	 * @generated
	 */
	private CommentParser commentBody_5063Parser;

	/**
	 * @generated
	 */
	private IParser componentName_5005Parser;

	/**
	 * @generated
	 */
	private IParser componentName_5043Parser;

	/**
	 * @generated
	 */
	private IParser constraintName_5037Parser;

	/**
	 * @generated
	 */
	private IParser constraintName_5064Parser;

	/**
	 * @generated
	 */
	private IParser dataTypeName_5035Parser;

	/**
	 * @generated
	 */
	private IParser dataTypeName_5061Parser;

	/**
	 * @generated
	 */
	private IParser dependencyName_6026Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser dependencyName_6027Parser;

	/**
	 * @generated
	 */
	private IParser dependencyName_6028Parser;

	/**
	 * @generated
	 */
	private IParser dependencyName_6029Parser;

	/**
	 * @generated
	 */
	private IParser diagramName_0Parser;

	/**
	 * @generated
	 */
	private IParser elementImportAlias_6020Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser elementImportAlias_6021Parser;

	/**
	 * @generated
	 */
	private IParser enumerationLiteral_3017Parser;

	/**
	 * @generated
	 */
	private IParser enumerationName_5023Parser;

	/**
	 * @generated
	 */
	private IParser enumerationName_5055Parser;

	/**
	 * @generated
	 */
	private IParser generalizationIsSubstitutable_6007Parser;

	/**
	 * @generated
	 */
	private GeneralizationSetConstraintParser generalizationSetIsCoveringIsDisjoint_5067Parser;

	/**
	 * @generated
	 */
	private IParser instanceSpecificationName_5002Parser;

	/**
	 * @generated
	 */
	private IParser instanceSpecificationName_5040Parser;

	/**
	 * @generated
	 */
	private IParser interfaceName_5011Parser;

	/**
	 * @generated
	 */
	private IParser interfaceName_5049Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser interfaceRealizationName_6008Parser;

	/**
	 * @generated
	 */
	private IParser interfaceRealizationName_6009Parser;

	/**
	 * @generated
	 */
	private IParser modelName_5020Parser;

	/**
	 * @generated
	 */
	private IParser modelName_5052Parser;

	/**
	 * @generated
	 */
	private IParser operation_3003Parser;

	/**
	 * @generated
	 */
	private IParser operation_3007Parser;

	/**
	 * @generated
	 */
	private IParser operation_3019Parser;

	/**
	 * @generated
	 */
	private PackageImportVisibilityParser packageImportVisibility_6022Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser packageMergeLabel_6030Parser;

	/**
	 * @generated
	 */
	private IParser packageName_5017Parser;

	/**
	 * @generated
	 */
	private IParser packageName_5026Parser;

	/**
	 * @generated
	 */
	private IParser primitiveTypeName_5032Parser;

	/**
	 * @generated
	 */
	private IParser primitiveTypeName_5058Parser;

	/**
	 * @generated
	 */
	private IParser property_3002Parser;

	/**
	 * @generated
	 */
	private IParser property_3005Parser;

	/**
	 * @generated
	 */
	private IParser property_3006Parser;

	/**
	 * @generated
	 */
	private IParser property_3018Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser realizationName_6012Parser;

	/**
	 * @generated
	 */
	private IParser realizationName_6013Parser;

	/**
	 * @generated
	 */
	private IParser reception_3011Parser;

	/**
	 * @generated
	 */
	private IParser signalName_5008Parser;

	/**
	 * @generated
	 */
	private IParser signalName_5046Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser substitutionName_6010Parser;

	/**
	 * @generated
	 */
	private IParser substitutionName_6011Parser;

	/**
	 * @generated
	 */
	private IParser usageName_6016Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser usageName_6017Parser;

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
	private IParser getAbstractionName_6015Parser() {
		if(abstractionName_6015Parser == null) {
			abstractionName_6015Parser = new AppliedStereotypeParser();
		}
		return abstractionName_6015Parser;
	}

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
	private IParser getAssociationName_6001Parser() {
		if(associationName_6001Parser == null) {
			associationName_6001Parser = new AppliedStereotypeParser();
		}
		return associationName_6001Parser;
	}

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
	private IParser getCommentBody_5038Parser() {
		if(commentBody_5038Parser == null) {
			commentBody_5038Parser = new CommentParser();
		}
		return commentBody_5038Parser;
	}

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
	private ClassifierTemplateParameterParser classifierTemplateParameter_3031Parser;

	/**
	 * @generated
	 */
	private IParser getClassifierTemplateParameter_3031Parser() {
		if(classifierTemplateParameter_3031Parser == null) {
			classifierTemplateParameter_3031Parser = new ClassifierTemplateParameterParser();
		}
		return classifierTemplateParameter_3031Parser;
	}

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
	private IParser getDependencyName_6027Parser() {
		if(dependencyName_6027Parser == null) {
			dependencyName_6027Parser = new AppliedStereotypeParser();
		}
		return dependencyName_6027Parser;
	}

	/**
	 * @generated
	 */
	private IParser getDependencyName_6028Parser() {
		if(dependencyName_6028Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dependencyName_6028Parser = parser;
		}
		return dependencyName_6028Parser;
	}

	/**
	 * @generated
	 */
	private IParser getDependencyName_6029Parser() {
		if(dependencyName_6029Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			dependencyName_6029Parser = parser;
		}
		return dependencyName_6029Parser;
	}

	/**
	 * @generated
	 */
	private IParser getDiagramName_0Parser() {
		if(diagramName_0Parser == null) {
			EAttribute[] features = new EAttribute[]{ NotationPackage.eINSTANCE.getDiagram_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			diagramName_0Parser = parser;
		}
		return diagramName_0Parser;
	}

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
	private IParser getElementImportAlias_6021Parser() {
		if(elementImportAlias_6021Parser == null) {
			elementImportAlias_6021Parser = new AppliedStereotypeParser();
		}
		return elementImportAlias_6021Parser;
	}

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
	private IParser getGeneralizationSetIsCoveringIsDisjoint_5067Parser() {
		if(generalizationSetIsCoveringIsDisjoint_5067Parser == null) {
			generalizationSetIsCoveringIsDisjoint_5067Parser = new GeneralizationSetConstraintParser();
		}
		return generalizationSetIsCoveringIsDisjoint_5067Parser;
	}

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
	private IParser getInterfaceRealizationName_6008Parser() {
		if(interfaceRealizationName_6008Parser == null) {
			interfaceRealizationName_6008Parser = new AppliedStereotypeParser();
		}
		return interfaceRealizationName_6008Parser;
	}

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
	private IParser getPackageImportVisibility_6022Parser() {
		if(packageImportVisibility_6022Parser == null) {
			packageImportVisibility_6022Parser = new PackageImportVisibilityParser();
		}
		return packageImportVisibility_6022Parser;
	}

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
	protected IParser getParser(int visualID) {
		switch(visualID) {
		case AssociationClassName2EditPart.VISUAL_ID:
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
		case ClassNameEditPart.VISUAL_ID:
			return getClassName_5029Parser();
		case PrimitiveTypeNameEditPart.VISUAL_ID:
			return getPrimitiveTypeName_5032Parser();
		case DataTypeNameEditPart.VISUAL_ID:
			return getDataTypeName_5035Parser();
		case ConstraintNameEditPart.VISUAL_ID:
			return getConstraintName_5037Parser();
		case CommentBodyEditPart.VISUAL_ID:
			return getCommentBody_5038Parser();
		case DiagramNameEditPart.VISUAL_ID:
			return getDiagramName_0Parser();
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3002Parser();
		case OperationEditPart.VISUAL_ID:
			return getOperation_3003Parser();
		case Class2EditPart.VISUAL_ID:
			return getClass_3004Parser();
		case ClassifierTemplateParameterEditPart.VISUAL_ID:
			return getClassifierTemplateParameter_3031Parser();
		case TemplateParameterEditPart.VISUAL_ID:
			return getTemplateParameter_3016Parser();
		case Property2EditPart.VISUAL_ID:
			return getProperty_3005Parser();
		case Property3EditPart.VISUAL_ID:
			return getProperty_3006Parser();
		case Operation2EditPart.VISUAL_ID:
			return getOperation_3007Parser();
		case Class3EditPart.VISUAL_ID:
			return getClass_3008Parser();
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
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_3017Parser();
		case PackageNameEditPartCN.VISUAL_ID:
			return getPackageName_5017Parser();
		case ClassNameEditPartCN.VISUAL_ID:
			return getClassName_5014Parser();
		case ReceptionEditPart.VISUAL_ID:
			return getReception_3011Parser();
		case Class5EditPart.VISUAL_ID:
			return getClass_3014Parser();
		case PrimitiveTypeNameEditPartCN.VISUAL_ID:
			return getPrimitiveTypeName_5058Parser();
		case DataTypeNameEditPartCN.VISUAL_ID:
			return getDataTypeName_5061Parser();
		case Property5EditPart.VISUAL_ID:
			return getProperty_3018Parser();
		case Operation4EditPart.VISUAL_ID:
			return getOperation_3019Parser();
		case CommentBody2EditPart.VISUAL_ID:
			return getCommentBody_5063Parser();
		case ConstraintName2EditPart.VISUAL_ID:
			return getConstraintName_5064Parser();
		case SlotEditPart.VISUAL_ID:
			return getSlot_3030Parser();
		case AppliedStereotypeAssociationEditPart.VISUAL_ID:
			return getAssociationName_6001Parser();
		case AssociationName2EditPart.VISUAL_ID:
			return getAssociationName_6002Parser();
		case AssociationName3EditPart.VISUAL_ID:
			return getAssociationName_6003Parser();
		case AssociationName5EditPart.VISUAL_ID:
			return getAssociationName_6005Parser();
		case AppliedStereotyperGeneralizationEditPart.VISUAL_ID:
			return getGeneralizationIsSubstitutable_6007Parser();
		case AppliedStereotypeInterfaceRealizationEditPart.VISUAL_ID:
			return getInterfaceRealizationName_6008Parser();
		case InterfaceRealizationName2EditPart.VISUAL_ID:
			return getInterfaceRealizationName_6009Parser();
		case AppliedStereotypeSubstitutionEditPart.VISUAL_ID:
			return getSubstitutionName_6010Parser();
		case SubstitutionName2EditPart.VISUAL_ID:
			return getSubstitutionName_6011Parser();
		case AppliedStereotypeRealizationEditPart.VISUAL_ID:
			return getRealizationName_6012Parser();
		case RealizationName2EditPart.VISUAL_ID:
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
		case DependencyName3EditPart.VISUAL_ID:
			return getDependencyName_6028Parser();
		case AppliedStereotypeDependency3EditPart.VISUAL_ID:
			return getDependencyName_6029Parser();
		case ElementImportAliasEditPart.VISUAL_ID:
			return getElementImportAlias_6020Parser();
		case AppliedStereotypeElementImportEditPart.VISUAL_ID:
			return getElementImportAlias_6021Parser();
		case AppliedStereotypePackageImportEditPart.VISUAL_ID:
			return getPackageImportVisibility_6022Parser();
		case AppliedStereotypePackageMergeEditPart.VISUAL_ID:
			return getPackageMergeLabel_6030Parser();
		case ConstraintLabelEditPart.VISUAL_ID:
			return getGeneralizationSetIsCoveringIsDisjoint_5067Parser();
		}
		return null;
	}

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
	private IParser getRealizationName_6012Parser() {
		if(realizationName_6012Parser == null) {
			realizationName_6012Parser = new AppliedStereotypeParser();
		}
		return realizationName_6012Parser;
	}

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
	private IParser getReception_3011Parser() {
		if(reception_3011Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			reception_3011Parser = parser;
		}
		return reception_3011Parser;
	}

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
	private IParser getSubstitutionName_6010Parser() {
		if(substitutionName_6010Parser == null) {
			substitutionName_6010Parser = new AppliedStereotypeParser();
		}
		return substitutionName_6010Parser;
	}

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
	private IParser getUsageName_6017Parser() {
		if(usageName_6017Parser == null) {
			usageName_6017Parser = new AppliedStereotypeParser();
		}
		return usageName_6017Parser;
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

}
