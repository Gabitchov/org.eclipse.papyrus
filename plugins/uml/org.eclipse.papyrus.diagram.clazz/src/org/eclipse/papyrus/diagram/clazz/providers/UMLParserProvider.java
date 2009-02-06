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
package org.eclipse.papyrus.diagram.clazz.providers;

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
import org.eclipse.papyrus.diagram.clazz.custom.parsers.AppliedStereotypeParser;
import org.eclipse.papyrus.diagram.clazz.edit.parts.*;
import org.eclipse.papyrus.diagram.clazz.parsers.MessageFormatParser;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	public static class HintAdapter extends ParserHintAdapter {

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
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

	/**
	 * @generated
	 */
	private IParser abstractionName_6014Parser;

	/**
	 * @generated
	 */
	private IParser abstractionName_6015Parser;

	/**
	 * @generated
	 */
	private IParser associationClassName_5065Parser;

	/**
	 * @generated
	 */
	private IParser associationClassName_5066Parser;

	/**
	 * @generated
	 */
	private IParser associationClassQualifiedName_5067Parser;

	/**
	 * @generated
	 */
	private IParser associationName_6001Parser;

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
	private IParser associationName_6004Parser;

	/**
	 * @generated
	 */
	private IParser associationName_6005Parser;

	/**
	 * @generated
	 */
	private IParser associationName_6006Parser;

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
	private IParser className_5013Parser;

	/**
	 * @generated
	 */
	private IParser className_5014Parser;

	/**
	 * @generated
	 */
	private IParser className_5028Parser;

	/**
	 * @generated
	 */
	private IParser className_5029Parser;

	/**
	 * @generated
	 */
	private IParser classQualifiedName_5015Parser;

	/**
	 * @generated
	 */
	private IParser classQualifiedName_5030Parser;

	/**
	 * @generated
	 */
	private IParser commentBody_5038Parser;

	/**
	 * @generated
	 */
	private IParser commentBody_5063Parser;

	/**
	 * @generated
	 */
	private IParser componentName_5004Parser;

	/**
	 * @generated
	 */
	private IParser componentName_5005Parser;

	/**
	 * @generated
	 */
	private IParser componentName_5042Parser;

	/**
	 * @generated
	 */
	private IParser componentName_5043Parser;

	/**
	 * @generated
	 */
	private IParser componentQualifiedName_5006Parser;

	/**
	 * @generated
	 */
	private IParser componentQualifiedName_5044Parser;

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
	private IParser dataTypeName_5034Parser;

	/**
	 * @generated
	 */
	private IParser dataTypeName_5035Parser;

	/**
	 * @generated
	 */
	private IParser dataTypeName_5060Parser;

	/**
	 * @generated
	 */
	private IParser dataTypeName_5061Parser;

	/**
	 * @generated
	 */
	private IParser dataTypeQualifiedName_5036Parser;

	/**
	 * @generated
	 */
	private IParser dataTypeQualifiedName_5062Parser;

	/**
	 * @generated
	 */
	private IParser dependencyName_6026Parser;

	/**
	 * @generated
	 */
	private IParser dependencyName_6027Parser;

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
	private IParser elementImportAlias_6020Parser;

	/**
	 * @generated
	 */
	private IParser elementImportAlias_6021Parser;

	/**
	 * @generated
	 */
	private IParser enumerationLiteral_3017Parser;

	/**
	 * @generated
	 */
	private IParser enumerationName_5022Parser;

	/**
	 * @generated
	 */
	private IParser enumerationName_5023Parser;

	/**
	 * @generated
	 */
	private IParser enumerationName_5054Parser;

	/**
	 * @generated
	 */
	private IParser enumerationName_5055Parser;

	/**
	 * @generated
	 */
	private IParser enumerationQualifiedName_5024Parser;

	/**
	 * @generated
	 */
	private IParser enumerationQualifiedName_5056Parser;

	/**
	 * @generated
	 */
	private IParser generalizationIsSubstitutable_6007Parser;

	/**
	 * @generated
	 */
	private IParser instanceSpecificationName_5001Parser;

	/**
	 * @generated
	 */
	private IParser instanceSpecificationName_5002Parser;

	/**
	 * @generated
	 */
	private IParser instanceSpecificationName_5039Parser;

	/**
	 * @generated
	 */
	private IParser instanceSpecificationName_5040Parser;

	/**
	 * @generated
	 */
	private IParser instanceSpecificationQualifiedName_5003Parser;

	/**
	 * @generated
	 */
	private IParser instanceSpecificationQualifiedName_5041Parser;

	/**
	 * @generated
	 */
	private IParser interfaceName_5010Parser;

	/**
	 * @generated
	 */
	private IParser interfaceName_5011Parser;

	/**
	 * @generated
	 */
	private IParser interfaceName_5048Parser;

	/**
	 * @generated
	 */
	private IParser interfaceName_5049Parser;

	/**
	 * @generated
	 */
	private IParser interfaceQualifiedName_5012Parser;

	/**
	 * @generated
	 */
	private IParser interfaceQualifiedName_5050Parser;

	/**
	 * @generated
	 */
	private IParser interfaceRealizationName_6008Parser;

	/**
	 * @generated
	 */
	private IParser interfaceRealizationName_6009Parser;

	/**
	 * @generated
	 */
	private IParser modelName_5019Parser;

	/**
	 * @generated
	 */
	private IParser modelName_5020Parser;

	/**
	 * @generated
	 */
	private IParser modelName_5051Parser;

	/**
	 * @generated
	 */
	private IParser modelName_5052Parser;

	/**
	 * @generated
	 */
	private IParser modelQualifiedName_5021Parser;

	/**
	 * @generated
	 */
	private IParser modelQualifiedName_5053Parser;

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
	private IParser operation_3013Parser;

	/**
	 * @generated
	 */
	private IParser operation_3019Parser;

	/**
	 * @generated
	 */
	private IParser packageImportVisibility_6022Parser;

	/**
	 * @generated
	 */
	private IParser packageName_5016Parser;

	/**
	 * @generated
	 */
	private IParser packageName_5017Parser;

	/**
	 * @generated
	 */
	private IParser packageName_5025Parser;

	/**
	 * @generated
	 */
	private IParser packageName_5026Parser;

	/**
	 * @generated
	 */
	private IParser packageQualifiedName_5018Parser;

	/**
	 * @generated
	 */
	private IParser packageQualifiedName_5027Parser;

	/**
	 * @generated
	 */
	private IParser primitiveTypeName_5031Parser;

	/**
	 * @generated
	 */
	private IParser primitiveTypeName_5032Parser;

	/**
	 * @generated
	 */
	private IParser primitiveTypeName_5057Parser;

	/**
	 * @generated
	 */
	private IParser primitiveTypeName_5058Parser;

	/**
	 * @generated
	 */
	private IParser primitiveTypeQualifiedName_5033Parser;

	/**
	 * @generated
	 */
	private IParser primitiveTypeQualifiedName_5059Parser;

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
	private IParser property_3012Parser;

	/**
	 * @generated
	 */
	private IParser property_3018Parser;

	/**
	 * @generated
	 */
	private IParser realizationName_6012Parser;

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
	private IParser signalName_5007Parser;

	/**
	 * @generated
	 */
	private IParser signalName_5008Parser;

	/**
	 * @generated
	 */
	private IParser signalName_5045Parser;

	/**
	 * @generated
	 */
	private IParser signalName_5046Parser;

	/**
	 * @generated
	 */
	private IParser signalQualifiedName_5009Parser;

	/**
	 * @generated
	 */
	private IParser signalQualifiedName_5047Parser;

	/**
	 * @generated
	 */
	private IParser substitutionName_6010Parser;

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
	private IParser usageName_6017Parser;

	/**
	 * @generated
	 */
	protected IParser createAbstractionName_6014Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createAbstractionName_6015Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createAssociationClassName_5065Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createAssociationClassName_5066Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createAssociationClassQualifiedName_5067Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createAssociationName_6001Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
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
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("srcRole{0}");
		parser.setEditorPattern("srcRole{0}");
		parser.setEditPattern("srcRole{0}");
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createAssociationName_6004Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("srcMul{0}");
		parser.setEditorPattern("srcMul{0}");
		parser.setEditPattern("srcMul{0}");
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createAssociationName_6005Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("targMul{0}");
		parser.setEditorPattern("targMul{0}");
		parser.setEditPattern("targMul{0}");
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createAssociationName_6006Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("targRole{0}");
		parser.setEditorPattern("targRole{0}");
		parser.setEditPattern("targRole{0}");
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createClass_3004Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createClass_3008Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createClass_3014Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createClassName_5013Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createClassName_5014Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createClassName_5028Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createClassName_5029Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createClassQualifiedName_5015Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createClassQualifiedName_5030Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createCommentBody_5038Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getComment_Body(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createCommentBody_5063Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getComment_Body(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createComponentName_5004Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createComponentName_5005Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createComponentName_5042Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createComponentName_5043Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createComponentQualifiedName_5006Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createComponentQualifiedName_5044Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createConstraintName_5037Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createConstraintName_5064Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createDataTypeName_5034Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createDataTypeName_5035Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createDataTypeName_5060Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createDataTypeName_5061Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
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
	protected IParser createDataTypeQualifiedName_5062Parser() {

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
	protected IParser createDependencyName_6026Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createDependencyName_6027Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createDependencyName_6028Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createDependencyName_6029Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createElementImportAlias_6020Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getElementImport_Alias(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createElementImportAlias_6021Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createEnumerationLiteral_3017Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createEnumerationName_5022Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createEnumerationName_5023Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createEnumerationName_5054Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createEnumerationName_5055Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createEnumerationQualifiedName_5024Parser() {

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
	protected IParser createEnumerationQualifiedName_5056Parser() {

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
	protected IParser createGeneralizationIsSubstitutable_6007Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createInstanceSpecificationName_5001Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createInstanceSpecificationName_5002Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createInstanceSpecificationName_5039Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createInstanceSpecificationName_5040Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createInstanceSpecificationQualifiedName_5003Parser() {

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
	protected IParser createInstanceSpecificationQualifiedName_5041Parser() {

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
	protected IParser createInterfaceName_5010Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createInterfaceName_5011Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createInterfaceName_5048Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createInterfaceName_5049Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createInterfaceQualifiedName_5012Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createInterfaceQualifiedName_5050Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createInterfaceRealizationName_6008Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createInterfaceRealizationName_6009Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createModelName_5019Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createModelName_5020Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createModelName_5051Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createModelName_5052Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createModelQualifiedName_5021Parser() {

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
	protected IParser createModelQualifiedName_5053Parser() {

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
	protected IParser createOperation_3003Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createOperation_3007Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createOperation_3013Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createOperation_3019Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createPackageImportVisibility_6022Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createPackageName_5016Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createPackageName_5017Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createPackageName_5025Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createPackageName_5026Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createPackageQualifiedName_5018Parser() {

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
	protected IParser createPackageQualifiedName_5027Parser() {

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
	protected IParser createPrimitiveTypeName_5031Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createPrimitiveTypeName_5032Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createPrimitiveTypeName_5057Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createPrimitiveTypeName_5058Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createPrimitiveTypeQualifiedName_5033Parser() {

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
	protected IParser createPrimitiveTypeQualifiedName_5059Parser() {

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
	protected IParser createProperty_3002Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createProperty_3005Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createProperty_3006Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createProperty_3012Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createProperty_3018Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createRealizationName_6012Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createRealizationName_6013Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createReception_3011Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createSignalName_5007Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createSignalName_5008Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createSignalName_5045Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createSignalName_5046Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createSignalQualifiedName_5009Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createSignalQualifiedName_5047Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createSubstitutionName_6010Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createSubstitutionName_6011Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createUsageName_6016Parser() {

		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;

	}

	/**
	 * @generated
	 */
	protected IParser createUsageName_6017Parser() {

		// Papyrus Gen code
		// This code is replaced by a simple parser of apliedstereotype
		IParser parser = new AppliedStereotypeParser();
		return parser;

	}

	/**
	 * @generated
	 */
	private IParser getAbstractionName_6014Parser() {
		if (abstractionName_6014Parser == null) {
			abstractionName_6014Parser = createAbstractionName_6014Parser();
		}
		return abstractionName_6014Parser;
	}

	/**
	 * @generated
	 */
	private IParser getAbstractionName_6015Parser() {
		if (abstractionName_6015Parser == null) {
			abstractionName_6015Parser = createAbstractionName_6015Parser();
		}
		return abstractionName_6015Parser;
	}

	/**
	 * @generated
	 */
	private IParser getAssociationClassName_5065Parser() {
		if (associationClassName_5065Parser == null) {
			associationClassName_5065Parser = createAssociationClassName_5065Parser();
		}
		return associationClassName_5065Parser;
	}

	/**
	 * @generated
	 */
	private IParser getAssociationClassName_5066Parser() {
		if (associationClassName_5066Parser == null) {
			associationClassName_5066Parser = createAssociationClassName_5066Parser();
		}
		return associationClassName_5066Parser;
	}

	/**
	 * @generated
	 */
	private IParser getAssociationClassQualifiedName_5067Parser() {
		if (associationClassQualifiedName_5067Parser == null) {
			associationClassQualifiedName_5067Parser = createAssociationClassQualifiedName_5067Parser();
		}
		return associationClassQualifiedName_5067Parser;
	}

	/**
	 * @generated
	 */
	private IParser getAssociationName_6001Parser() {
		if (associationName_6001Parser == null) {
			associationName_6001Parser = createAssociationName_6001Parser();
		}
		return associationName_6001Parser;
	}

	/**
	 * @generated
	 */
	private IParser getAssociationName_6002Parser() {
		if (associationName_6002Parser == null) {
			associationName_6002Parser = createAssociationName_6002Parser();
		}
		return associationName_6002Parser;
	}

	/**
	 * @generated
	 */
	private IParser getAssociationName_6003Parser() {
		if (associationName_6003Parser == null) {
			associationName_6003Parser = createAssociationName_6003Parser();
		}
		return associationName_6003Parser;
	}

	/**
	 * @generated
	 */
	private IParser getAssociationName_6004Parser() {
		if (associationName_6004Parser == null) {
			associationName_6004Parser = createAssociationName_6004Parser();
		}
		return associationName_6004Parser;
	}

	/**
	 * @generated
	 */
	private IParser getAssociationName_6005Parser() {
		if (associationName_6005Parser == null) {
			associationName_6005Parser = createAssociationName_6005Parser();
		}
		return associationName_6005Parser;
	}

	/**
	 * @generated
	 */
	private IParser getAssociationName_6006Parser() {
		if (associationName_6006Parser == null) {
			associationName_6006Parser = createAssociationName_6006Parser();
		}
		return associationName_6006Parser;
	}

	/**
	 * @generated
	 */
	private IParser getClass_3004Parser() {
		if (class_3004Parser == null) {
			class_3004Parser = createClass_3004Parser();
		}
		return class_3004Parser;
	}

	/**
	 * @generated
	 */
	private IParser getClass_3008Parser() {
		if (class_3008Parser == null) {
			class_3008Parser = createClass_3008Parser();
		}
		return class_3008Parser;
	}

	/**
	 * @generated
	 */
	private IParser getClass_3014Parser() {
		if (class_3014Parser == null) {
			class_3014Parser = createClass_3014Parser();
		}
		return class_3014Parser;
	}

	/**
	 * @generated
	 */
	private IParser getClassName_5013Parser() {
		if (className_5013Parser == null) {
			className_5013Parser = createClassName_5013Parser();
		}
		return className_5013Parser;
	}

	/**
	 * @generated
	 */
	private IParser getClassName_5014Parser() {
		if (className_5014Parser == null) {
			className_5014Parser = createClassName_5014Parser();
		}
		return className_5014Parser;
	}

	/**
	 * @generated
	 */
	private IParser getClassName_5028Parser() {
		if (className_5028Parser == null) {
			className_5028Parser = createClassName_5028Parser();
		}
		return className_5028Parser;
	}

	/**
	 * @generated
	 */
	private IParser getClassName_5029Parser() {
		if (className_5029Parser == null) {
			className_5029Parser = createClassName_5029Parser();
		}
		return className_5029Parser;
	}

	/**
	 * @generated
	 */
	private IParser getClassQualifiedName_5015Parser() {
		if (classQualifiedName_5015Parser == null) {
			classQualifiedName_5015Parser = createClassQualifiedName_5015Parser();
		}
		return classQualifiedName_5015Parser;
	}

	/**
	 * @generated
	 */
	private IParser getClassQualifiedName_5030Parser() {
		if (classQualifiedName_5030Parser == null) {
			classQualifiedName_5030Parser = createClassQualifiedName_5030Parser();
		}
		return classQualifiedName_5030Parser;
	}

	/**
	 * @generated
	 */
	private IParser getCommentBody_5038Parser() {
		if (commentBody_5038Parser == null) {
			commentBody_5038Parser = createCommentBody_5038Parser();
		}
		return commentBody_5038Parser;
	}

	/**
	 * @generated
	 */
	private IParser getCommentBody_5063Parser() {
		if (commentBody_5063Parser == null) {
			commentBody_5063Parser = createCommentBody_5063Parser();
		}
		return commentBody_5063Parser;
	}

	/**
	 * @generated
	 */
	private IParser getComponentName_5004Parser() {
		if (componentName_5004Parser == null) {
			componentName_5004Parser = createComponentName_5004Parser();
		}
		return componentName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser getComponentName_5005Parser() {
		if (componentName_5005Parser == null) {
			componentName_5005Parser = createComponentName_5005Parser();
		}
		return componentName_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser getComponentName_5042Parser() {
		if (componentName_5042Parser == null) {
			componentName_5042Parser = createComponentName_5042Parser();
		}
		return componentName_5042Parser;
	}

	/**
	 * @generated
	 */
	private IParser getComponentName_5043Parser() {
		if (componentName_5043Parser == null) {
			componentName_5043Parser = createComponentName_5043Parser();
		}
		return componentName_5043Parser;
	}

	/**
	 * @generated
	 */
	private IParser getComponentQualifiedName_5006Parser() {
		if (componentQualifiedName_5006Parser == null) {
			componentQualifiedName_5006Parser = createComponentQualifiedName_5006Parser();
		}
		return componentQualifiedName_5006Parser;
	}

	/**
	 * @generated
	 */
	private IParser getComponentQualifiedName_5044Parser() {
		if (componentQualifiedName_5044Parser == null) {
			componentQualifiedName_5044Parser = createComponentQualifiedName_5044Parser();
		}
		return componentQualifiedName_5044Parser;
	}

	/**
	 * @generated
	 */
	private IParser getConstraintName_5037Parser() {
		if (constraintName_5037Parser == null) {
			constraintName_5037Parser = createConstraintName_5037Parser();
		}
		return constraintName_5037Parser;
	}

	/**
	 * @generated
	 */
	private IParser getConstraintName_5064Parser() {
		if (constraintName_5064Parser == null) {
			constraintName_5064Parser = createConstraintName_5064Parser();
		}
		return constraintName_5064Parser;
	}

	/**
	 * @generated
	 */
	private IParser getDataTypeName_5034Parser() {
		if (dataTypeName_5034Parser == null) {
			dataTypeName_5034Parser = createDataTypeName_5034Parser();
		}
		return dataTypeName_5034Parser;
	}

	/**
	 * @generated
	 */
	private IParser getDataTypeName_5035Parser() {
		if (dataTypeName_5035Parser == null) {
			dataTypeName_5035Parser = createDataTypeName_5035Parser();
		}
		return dataTypeName_5035Parser;
	}

	/**
	 * @generated
	 */
	private IParser getDataTypeName_5060Parser() {
		if (dataTypeName_5060Parser == null) {
			dataTypeName_5060Parser = createDataTypeName_5060Parser();
		}
		return dataTypeName_5060Parser;
	}

	/**
	 * @generated
	 */
	private IParser getDataTypeName_5061Parser() {
		if (dataTypeName_5061Parser == null) {
			dataTypeName_5061Parser = createDataTypeName_5061Parser();
		}
		return dataTypeName_5061Parser;
	}

	/**
	 * @generated
	 */
	private IParser getDataTypeQualifiedName_5036Parser() {
		if (dataTypeQualifiedName_5036Parser == null) {
			dataTypeQualifiedName_5036Parser = createDataTypeQualifiedName_5036Parser();
		}
		return dataTypeQualifiedName_5036Parser;
	}

	/**
	 * @generated
	 */
	private IParser getDataTypeQualifiedName_5062Parser() {
		if (dataTypeQualifiedName_5062Parser == null) {
			dataTypeQualifiedName_5062Parser = createDataTypeQualifiedName_5062Parser();
		}
		return dataTypeQualifiedName_5062Parser;
	}

	/**
	 * @generated
	 */
	private IParser getDependencyName_6026Parser() {
		if (dependencyName_6026Parser == null) {
			dependencyName_6026Parser = createDependencyName_6026Parser();
		}
		return dependencyName_6026Parser;
	}

	/**
	 * @generated
	 */
	private IParser getDependencyName_6027Parser() {
		if (dependencyName_6027Parser == null) {
			dependencyName_6027Parser = createDependencyName_6027Parser();
		}
		return dependencyName_6027Parser;
	}

	/**
	 * @generated
	 */
	private IParser getDependencyName_6028Parser() {
		if (dependencyName_6028Parser == null) {
			dependencyName_6028Parser = createDependencyName_6028Parser();
		}
		return dependencyName_6028Parser;
	}

	/**
	 * @generated
	 */
	private IParser getDependencyName_6029Parser() {
		if (dependencyName_6029Parser == null) {
			dependencyName_6029Parser = createDependencyName_6029Parser();
		}
		return dependencyName_6029Parser;
	}

	/**
	 * @generated
	 */
	private IParser getElementImportAlias_6020Parser() {
		if (elementImportAlias_6020Parser == null) {
			elementImportAlias_6020Parser = createElementImportAlias_6020Parser();
		}
		return elementImportAlias_6020Parser;
	}

	/**
	 * @generated
	 */
	private IParser getElementImportAlias_6021Parser() {
		if (elementImportAlias_6021Parser == null) {
			elementImportAlias_6021Parser = createElementImportAlias_6021Parser();
		}
		return elementImportAlias_6021Parser;
	}

	/**
	 * @generated
	 */
	private IParser getEnumerationLiteral_3017Parser() {
		if (enumerationLiteral_3017Parser == null) {
			enumerationLiteral_3017Parser = createEnumerationLiteral_3017Parser();
		}
		return enumerationLiteral_3017Parser;
	}

	/**
	 * @generated
	 */
	private IParser getEnumerationName_5022Parser() {
		if (enumerationName_5022Parser == null) {
			enumerationName_5022Parser = createEnumerationName_5022Parser();
		}
		return enumerationName_5022Parser;
	}

	/**
	 * @generated
	 */
	private IParser getEnumerationName_5023Parser() {
		if (enumerationName_5023Parser == null) {
			enumerationName_5023Parser = createEnumerationName_5023Parser();
		}
		return enumerationName_5023Parser;
	}

	/**
	 * @generated
	 */
	private IParser getEnumerationName_5054Parser() {
		if (enumerationName_5054Parser == null) {
			enumerationName_5054Parser = createEnumerationName_5054Parser();
		}
		return enumerationName_5054Parser;
	}

	/**
	 * @generated
	 */
	private IParser getEnumerationName_5055Parser() {
		if (enumerationName_5055Parser == null) {
			enumerationName_5055Parser = createEnumerationName_5055Parser();
		}
		return enumerationName_5055Parser;
	}

	/**
	 * @generated
	 */
	private IParser getEnumerationQualifiedName_5024Parser() {
		if (enumerationQualifiedName_5024Parser == null) {
			enumerationQualifiedName_5024Parser = createEnumerationQualifiedName_5024Parser();
		}
		return enumerationQualifiedName_5024Parser;
	}

	/**
	 * @generated
	 */
	private IParser getEnumerationQualifiedName_5056Parser() {
		if (enumerationQualifiedName_5056Parser == null) {
			enumerationQualifiedName_5056Parser = createEnumerationQualifiedName_5056Parser();
		}
		return enumerationQualifiedName_5056Parser;
	}

	/**
	 * @generated
	 */
	private IParser getGeneralizationIsSubstitutable_6007Parser() {
		if (generalizationIsSubstitutable_6007Parser == null) {
			generalizationIsSubstitutable_6007Parser = createGeneralizationIsSubstitutable_6007Parser();
		}
		return generalizationIsSubstitutable_6007Parser;
	}

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationName_5001Parser() {
		if (instanceSpecificationName_5001Parser == null) {
			instanceSpecificationName_5001Parser = createInstanceSpecificationName_5001Parser();
		}
		return instanceSpecificationName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationName_5002Parser() {
		if (instanceSpecificationName_5002Parser == null) {
			instanceSpecificationName_5002Parser = createInstanceSpecificationName_5002Parser();
		}
		return instanceSpecificationName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationName_5039Parser() {
		if (instanceSpecificationName_5039Parser == null) {
			instanceSpecificationName_5039Parser = createInstanceSpecificationName_5039Parser();
		}
		return instanceSpecificationName_5039Parser;
	}

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationName_5040Parser() {
		if (instanceSpecificationName_5040Parser == null) {
			instanceSpecificationName_5040Parser = createInstanceSpecificationName_5040Parser();
		}
		return instanceSpecificationName_5040Parser;
	}

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationQualifiedName_5003Parser() {
		if (instanceSpecificationQualifiedName_5003Parser == null) {
			instanceSpecificationQualifiedName_5003Parser = createInstanceSpecificationQualifiedName_5003Parser();
		}
		return instanceSpecificationQualifiedName_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationQualifiedName_5041Parser() {
		if (instanceSpecificationQualifiedName_5041Parser == null) {
			instanceSpecificationQualifiedName_5041Parser = createInstanceSpecificationQualifiedName_5041Parser();
		}
		return instanceSpecificationQualifiedName_5041Parser;
	}

	/**
	 * @generated
	 */
	private IParser getInterfaceName_5010Parser() {
		if (interfaceName_5010Parser == null) {
			interfaceName_5010Parser = createInterfaceName_5010Parser();
		}
		return interfaceName_5010Parser;
	}

	/**
	 * @generated
	 */
	private IParser getInterfaceName_5011Parser() {
		if (interfaceName_5011Parser == null) {
			interfaceName_5011Parser = createInterfaceName_5011Parser();
		}
		return interfaceName_5011Parser;
	}

	/**
	 * @generated
	 */
	private IParser getInterfaceName_5048Parser() {
		if (interfaceName_5048Parser == null) {
			interfaceName_5048Parser = createInterfaceName_5048Parser();
		}
		return interfaceName_5048Parser;
	}

	/**
	 * @generated
	 */
	private IParser getInterfaceName_5049Parser() {
		if (interfaceName_5049Parser == null) {
			interfaceName_5049Parser = createInterfaceName_5049Parser();
		}
		return interfaceName_5049Parser;
	}

	/**
	 * @generated
	 */
	private IParser getInterfaceQualifiedName_5012Parser() {
		if (interfaceQualifiedName_5012Parser == null) {
			interfaceQualifiedName_5012Parser = createInterfaceQualifiedName_5012Parser();
		}
		return interfaceQualifiedName_5012Parser;
	}

	/**
	 * @generated
	 */
	private IParser getInterfaceQualifiedName_5050Parser() {
		if (interfaceQualifiedName_5050Parser == null) {
			interfaceQualifiedName_5050Parser = createInterfaceQualifiedName_5050Parser();
		}
		return interfaceQualifiedName_5050Parser;
	}

	/**
	 * @generated
	 */
	private IParser getInterfaceRealizationName_6008Parser() {
		if (interfaceRealizationName_6008Parser == null) {
			interfaceRealizationName_6008Parser = createInterfaceRealizationName_6008Parser();
		}
		return interfaceRealizationName_6008Parser;
	}

	/**
	 * @generated
	 */
	private IParser getInterfaceRealizationName_6009Parser() {
		if (interfaceRealizationName_6009Parser == null) {
			interfaceRealizationName_6009Parser = createInterfaceRealizationName_6009Parser();
		}
		return interfaceRealizationName_6009Parser;
	}

	/**
	 * @generated
	 */
	private IParser getModelName_5019Parser() {
		if (modelName_5019Parser == null) {
			modelName_5019Parser = createModelName_5019Parser();
		}
		return modelName_5019Parser;
	}

	/**
	 * @generated
	 */
	private IParser getModelName_5020Parser() {
		if (modelName_5020Parser == null) {
			modelName_5020Parser = createModelName_5020Parser();
		}
		return modelName_5020Parser;
	}

	/**
	 * @generated
	 */
	private IParser getModelName_5051Parser() {
		if (modelName_5051Parser == null) {
			modelName_5051Parser = createModelName_5051Parser();
		}
		return modelName_5051Parser;
	}

	/**
	 * @generated
	 */
	private IParser getModelName_5052Parser() {
		if (modelName_5052Parser == null) {
			modelName_5052Parser = createModelName_5052Parser();
		}
		return modelName_5052Parser;
	}

	/**
	 * @generated
	 */
	private IParser getModelQualifiedName_5021Parser() {
		if (modelQualifiedName_5021Parser == null) {
			modelQualifiedName_5021Parser = createModelQualifiedName_5021Parser();
		}
		return modelQualifiedName_5021Parser;
	}

	/**
	 * @generated
	 */
	private IParser getModelQualifiedName_5053Parser() {
		if (modelQualifiedName_5053Parser == null) {
			modelQualifiedName_5053Parser = createModelQualifiedName_5053Parser();
		}
		return modelQualifiedName_5053Parser;
	}

	/**
	 * @generated
	 */
	private IParser getOperation_3003Parser() {
		if (operation_3003Parser == null) {
			operation_3003Parser = createOperation_3003Parser();
		}
		return operation_3003Parser;
	}

	/**
	 * @generated
	 */
	private IParser getOperation_3007Parser() {
		if (operation_3007Parser == null) {
			operation_3007Parser = createOperation_3007Parser();
		}
		return operation_3007Parser;
	}

	/**
	 * @generated
	 */
	private IParser getOperation_3013Parser() {
		if (operation_3013Parser == null) {
			operation_3013Parser = createOperation_3013Parser();
		}
		return operation_3013Parser;
	}

	/**
	 * @generated
	 */
	private IParser getOperation_3019Parser() {
		if (operation_3019Parser == null) {
			operation_3019Parser = createOperation_3019Parser();
		}
		return operation_3019Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPackageImportVisibility_6022Parser() {
		if (packageImportVisibility_6022Parser == null) {
			packageImportVisibility_6022Parser = createPackageImportVisibility_6022Parser();
		}
		return packageImportVisibility_6022Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPackageName_5016Parser() {
		if (packageName_5016Parser == null) {
			packageName_5016Parser = createPackageName_5016Parser();
		}
		return packageName_5016Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPackageName_5017Parser() {
		if (packageName_5017Parser == null) {
			packageName_5017Parser = createPackageName_5017Parser();
		}
		return packageName_5017Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPackageName_5025Parser() {
		if (packageName_5025Parser == null) {
			packageName_5025Parser = createPackageName_5025Parser();
		}
		return packageName_5025Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPackageName_5026Parser() {
		if (packageName_5026Parser == null) {
			packageName_5026Parser = createPackageName_5026Parser();
		}
		return packageName_5026Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPackageQualifiedName_5018Parser() {
		if (packageQualifiedName_5018Parser == null) {
			packageQualifiedName_5018Parser = createPackageQualifiedName_5018Parser();
		}
		return packageQualifiedName_5018Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPackageQualifiedName_5027Parser() {
		if (packageQualifiedName_5027Parser == null) {
			packageQualifiedName_5027Parser = createPackageQualifiedName_5027Parser();
		}
		return packageQualifiedName_5027Parser;
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
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case AppliedStereotypeAssociationClassEditPart.VISUAL_ID:
			return getAssociationClassName_5065Parser();
		case AssociationClassName2EditPart.VISUAL_ID:
			return getAssociationClassName_5066Parser();
		case AssociationClassQualifiedNameEditPart.VISUAL_ID:
			return getAssociationClassQualifiedName_5067Parser();
		case AppliedStereotypeInstanceSpecificationEditPart.VISUAL_ID:
			return getInstanceSpecificationName_5001Parser();
		case InstanceSpecificationName2EditPart.VISUAL_ID:
			return getInstanceSpecificationName_5002Parser();
		case InstanceSpecificationQualifiedNameEditPart.VISUAL_ID:
			return getInstanceSpecificationQualifiedName_5003Parser();
		case AppliedStereotypeComponentEditPart.VISUAL_ID:
			return getComponentName_5004Parser();
		case ComponentName2EditPart.VISUAL_ID:
			return getComponentName_5005Parser();
		case ComponentQualifiedNameEditPart.VISUAL_ID:
			return getComponentQualifiedName_5006Parser();
		case AppliedStereotypeSignalEditPart.VISUAL_ID:
			return getSignalName_5007Parser();
		case SignalName2EditPart.VISUAL_ID:
			return getSignalName_5008Parser();
		case SignalQualifiedNameEditPart.VISUAL_ID:
			return getSignalQualifiedName_5009Parser();
		case AppliedStereotypeInterfaceEditPart.VISUAL_ID:
			return getInterfaceName_5010Parser();
		case InterfaceName2EditPart.VISUAL_ID:
			return getInterfaceName_5011Parser();
		case InterfaceQualifiedNameEditPart.VISUAL_ID:
			return getInterfaceQualifiedName_5012Parser();
		case AppliedStereotypeModelEditPart.VISUAL_ID:
			return getModelName_5019Parser();
		case ModelName2EditPart.VISUAL_ID:
			return getModelName_5020Parser();
		case ModelQualifiedNameEditPart.VISUAL_ID:
			return getModelQualifiedName_5021Parser();
		case AppliedStereotypeEnumerationEditPart.VISUAL_ID:
			return getEnumerationName_5022Parser();
		case EnumerationName2EditPart.VISUAL_ID:
			return getEnumerationName_5023Parser();
		case EnumerationQualifiedNameEditPart.VISUAL_ID:
			return getEnumerationQualifiedName_5024Parser();
		case AppliedStereotypePackageEditPart.VISUAL_ID:
			return getPackageName_5025Parser();
		case PackageName2EditPart.VISUAL_ID:
			return getPackageName_5026Parser();
		case PackageQualifiedNameEditPart.VISUAL_ID:
			return getPackageQualifiedName_5027Parser();
		case AppliedStereotypeClassEditPart.VISUAL_ID:
			return getClassName_5028Parser();
		case ClassName2EditPart.VISUAL_ID:
			return getClassName_5029Parser();
		case ClassQualifiedNameEditPart.VISUAL_ID:
			return getClassQualifiedName_5030Parser();
		case AppliedStereotypePrimitiveTypeEditPart.VISUAL_ID:
			return getPrimitiveTypeName_5031Parser();
		case PrimitiveTypeName2EditPart.VISUAL_ID:
			return getPrimitiveTypeName_5032Parser();
		case PrimitiveTypeQualifiedNameEditPart.VISUAL_ID:
			return getPrimitiveTypeQualifiedName_5033Parser();
		case AppliedStereotypeDataTypeEditPart.VISUAL_ID:
			return getDataTypeName_5034Parser();
		case DataTypeName2EditPart.VISUAL_ID:
			return getDataTypeName_5035Parser();
		case DataTypeQualifiedNameEditPart.VISUAL_ID:
			return getDataTypeQualifiedName_5036Parser();
		case ConstraintNameEditPart.VISUAL_ID:
			return getConstraintName_5037Parser();
		case CommentBodyEditPart.VISUAL_ID:
			return getCommentBody_5038Parser();
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3002Parser();
		case OperationEditPart.VISUAL_ID:
			return getOperation_3003Parser();
		case Class2EditPart.VISUAL_ID:
			return getClass_3004Parser();
		case Property2EditPart.VISUAL_ID:
			return getProperty_3005Parser();
		case Property3EditPart.VISUAL_ID:
			return getProperty_3006Parser();
		case Operation2EditPart.VISUAL_ID:
			return getOperation_3007Parser();
		case Class3EditPart.VISUAL_ID:
			return getClass_3008Parser();
		case AppliedStereotypeChildNodeInstanceSpecificationEditPart.VISUAL_ID:
			return getInstanceSpecificationName_5039Parser();
		case InstanceSpecificationName4EditPart.VISUAL_ID:
			return getInstanceSpecificationName_5040Parser();
		case InstanceSpecificationQualifiedName2EditPart.VISUAL_ID:
			return getInstanceSpecificationQualifiedName_5041Parser();
		case AppliedStereotypeChildNodeComponentEditPart.VISUAL_ID:
			return getComponentName_5042Parser();
		case ComponentName4EditPart.VISUAL_ID:
			return getComponentName_5043Parser();
		case ComponentQualifiedName2EditPart.VISUAL_ID:
			return getComponentQualifiedName_5044Parser();
		case AppliedStereotypeChildNodeSignalEditPart.VISUAL_ID:
			return getSignalName_5045Parser();
		case SignalName4EditPart.VISUAL_ID:
			return getSignalName_5046Parser();
		case SignalQualifiedName2EditPart.VISUAL_ID:
			return getSignalQualifiedName_5047Parser();
		case AppliedStereotypeChildNodeInterfaceEditPart.VISUAL_ID:
			return getInterfaceName_5048Parser();
		case InterfaceName4EditPart.VISUAL_ID:
			return getInterfaceName_5049Parser();
		case InterfaceQualifiedName2EditPart.VISUAL_ID:
			return getInterfaceQualifiedName_5050Parser();
		case AppliedStereotypeChildNodeModelEditPart.VISUAL_ID:
			return getModelName_5051Parser();
		case ModelName4EditPart.VISUAL_ID:
			return getModelName_5052Parser();
		case ModelQualifiedName2EditPart.VISUAL_ID:
			return getModelQualifiedName_5053Parser();
		case AppliedStereotypeChildNodeEnumerationEditPart.VISUAL_ID:
			return getEnumerationName_5054Parser();
		case EnumerationName4EditPart.VISUAL_ID:
			return getEnumerationName_5055Parser();
		case EnumerationQualifiedName2EditPart.VISUAL_ID:
			return getEnumerationQualifiedName_5056Parser();
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_3017Parser();
		case AppliedStereotypeChildNodePackageEditPart.VISUAL_ID:
			return getPackageName_5016Parser();
		case PackageName4EditPart.VISUAL_ID:
			return getPackageName_5017Parser();
		case PackageQualifiedName2EditPart.VISUAL_ID:
			return getPackageQualifiedName_5018Parser();
		case AppliedStereotypeChildNodeClassEditPart.VISUAL_ID:
			return getClassName_5013Parser();
		case ClassName4EditPart.VISUAL_ID:
			return getClassName_5014Parser();
		case ClassQualifiedName2EditPart.VISUAL_ID:
			return getClassQualifiedName_5015Parser();
		case ReceptionEditPart.VISUAL_ID:
			return getReception_3011Parser();
		case Property4EditPart.VISUAL_ID:
			return getProperty_3012Parser();
		case Operation3EditPart.VISUAL_ID:
			return getOperation_3013Parser();
		case Class5EditPart.VISUAL_ID:
			return getClass_3014Parser();
		case AppliedStereotypeChildNodePrimitiveTypeEditPart.VISUAL_ID:
			return getPrimitiveTypeName_5057Parser();
		case PrimitiveTypeName4EditPart.VISUAL_ID:
			return getPrimitiveTypeName_5058Parser();
		case PrimitiveTypeQualifiedName2EditPart.VISUAL_ID:
			return getPrimitiveTypeQualifiedName_5059Parser();
		case AppliedStereotypeChildNodeDataTypeEditPart.VISUAL_ID:
			return getDataTypeName_5060Parser();
		case DataTypeName4EditPart.VISUAL_ID:
			return getDataTypeName_5061Parser();
		case DataTypeQualifiedName2EditPart.VISUAL_ID:
			return getDataTypeQualifiedName_5062Parser();
		case Property5EditPart.VISUAL_ID:
			return getProperty_3018Parser();
		case Operation4EditPart.VISUAL_ID:
			return getOperation_3019Parser();
		case CommentBody2EditPart.VISUAL_ID:
			return getCommentBody_5063Parser();
		case ConstraintName2EditPart.VISUAL_ID:
			return getConstraintName_5064Parser();
		case AppliedStereotypeAssociationEditPart.VISUAL_ID:
			return getAssociationName_6001Parser();
		case AssociationName2EditPart.VISUAL_ID:
			return getAssociationName_6002Parser();
		case AssociationName3EditPart.VISUAL_ID:
			return getAssociationName_6003Parser();
		case AssociationName4EditPart.VISUAL_ID:
			return getAssociationName_6004Parser();
		case AssociationName5EditPart.VISUAL_ID:
			return getAssociationName_6005Parser();
		case AssociationName6EditPart.VISUAL_ID:
			return getAssociationName_6006Parser();
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
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IParser getPrimitiveTypeName_5031Parser() {
		if (primitiveTypeName_5031Parser == null) {
			primitiveTypeName_5031Parser = createPrimitiveTypeName_5031Parser();
		}
		return primitiveTypeName_5031Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPrimitiveTypeName_5032Parser() {
		if (primitiveTypeName_5032Parser == null) {
			primitiveTypeName_5032Parser = createPrimitiveTypeName_5032Parser();
		}
		return primitiveTypeName_5032Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPrimitiveTypeName_5057Parser() {
		if (primitiveTypeName_5057Parser == null) {
			primitiveTypeName_5057Parser = createPrimitiveTypeName_5057Parser();
		}
		return primitiveTypeName_5057Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPrimitiveTypeName_5058Parser() {
		if (primitiveTypeName_5058Parser == null) {
			primitiveTypeName_5058Parser = createPrimitiveTypeName_5058Parser();
		}
		return primitiveTypeName_5058Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPrimitiveTypeQualifiedName_5033Parser() {
		if (primitiveTypeQualifiedName_5033Parser == null) {
			primitiveTypeQualifiedName_5033Parser = createPrimitiveTypeQualifiedName_5033Parser();
		}
		return primitiveTypeQualifiedName_5033Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPrimitiveTypeQualifiedName_5059Parser() {
		if (primitiveTypeQualifiedName_5059Parser == null) {
			primitiveTypeQualifiedName_5059Parser = createPrimitiveTypeQualifiedName_5059Parser();
		}
		return primitiveTypeQualifiedName_5059Parser;
	}

	/**
	 * @generated
	 */
	private IParser getProperty_3002Parser() {
		if (property_3002Parser == null) {
			property_3002Parser = createProperty_3002Parser();
		}
		return property_3002Parser;
	}

	/**
	 * @generated
	 */
	private IParser getProperty_3005Parser() {
		if (property_3005Parser == null) {
			property_3005Parser = createProperty_3005Parser();
		}
		return property_3005Parser;
	}

	/**
	 * @generated
	 */
	private IParser getProperty_3006Parser() {
		if (property_3006Parser == null) {
			property_3006Parser = createProperty_3006Parser();
		}
		return property_3006Parser;
	}

	/**
	 * @generated
	 */
	private IParser getProperty_3012Parser() {
		if (property_3012Parser == null) {
			property_3012Parser = createProperty_3012Parser();
		}
		return property_3012Parser;
	}

	/**
	 * @generated
	 */
	private IParser getProperty_3018Parser() {
		if (property_3018Parser == null) {
			property_3018Parser = createProperty_3018Parser();
		}
		return property_3018Parser;
	}

	/**
	 * @generated
	 */
	private IParser getRealizationName_6012Parser() {
		if (realizationName_6012Parser == null) {
			realizationName_6012Parser = createRealizationName_6012Parser();
		}
		return realizationName_6012Parser;
	}

	/**
	 * @generated
	 */
	private IParser getRealizationName_6013Parser() {
		if (realizationName_6013Parser == null) {
			realizationName_6013Parser = createRealizationName_6013Parser();
		}
		return realizationName_6013Parser;
	}

	/**
	 * @generated
	 */
	private IParser getReception_3011Parser() {
		if (reception_3011Parser == null) {
			reception_3011Parser = createReception_3011Parser();
		}
		return reception_3011Parser;
	}

	/**
	 * @generated
	 */
	private IParser getSignalName_5007Parser() {
		if (signalName_5007Parser == null) {
			signalName_5007Parser = createSignalName_5007Parser();
		}
		return signalName_5007Parser;
	}

	/**
	 * @generated
	 */
	private IParser getSignalName_5008Parser() {
		if (signalName_5008Parser == null) {
			signalName_5008Parser = createSignalName_5008Parser();
		}
		return signalName_5008Parser;
	}

	/**
	 * @generated
	 */
	private IParser getSignalName_5045Parser() {
		if (signalName_5045Parser == null) {
			signalName_5045Parser = createSignalName_5045Parser();
		}
		return signalName_5045Parser;
	}

	/**
	 * @generated
	 */
	private IParser getSignalName_5046Parser() {
		if (signalName_5046Parser == null) {
			signalName_5046Parser = createSignalName_5046Parser();
		}
		return signalName_5046Parser;
	}

	/**
	 * @generated
	 */
	private IParser getSignalQualifiedName_5009Parser() {
		if (signalQualifiedName_5009Parser == null) {
			signalQualifiedName_5009Parser = createSignalQualifiedName_5009Parser();
		}
		return signalQualifiedName_5009Parser;
	}

	/**
	 * @generated
	 */
	private IParser getSignalQualifiedName_5047Parser() {
		if (signalQualifiedName_5047Parser == null) {
			signalQualifiedName_5047Parser = createSignalQualifiedName_5047Parser();
		}
		return signalQualifiedName_5047Parser;
	}

	/**
	 * @generated
	 */
	private IParser getSubstitutionName_6010Parser() {
		if (substitutionName_6010Parser == null) {
			substitutionName_6010Parser = createSubstitutionName_6010Parser();
		}
		return substitutionName_6010Parser;
	}

	/**
	 * @generated
	 */
	private IParser getSubstitutionName_6011Parser() {
		if (substitutionName_6011Parser == null) {
			substitutionName_6011Parser = createSubstitutionName_6011Parser();
		}
		return substitutionName_6011Parser;
	}

	/**
	 * @generated
	 */
	private IParser getUsageName_6016Parser() {
		if (usageName_6016Parser == null) {
			usageName_6016Parser = createUsageName_6016Parser();
		}
		return usageName_6016Parser;
	}

	/**
	 * @generated
	 */
	private IParser getUsageName_6017Parser() {
		if (usageName_6017Parser == null) {
			usageName_6017Parser = createUsageName_6017Parser();
		}
		return usageName_6017Parser;
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

}
