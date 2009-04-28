package org.eclipse.papyrus.diagram.clazzBis.providers;

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
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser associationClassName_4001Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationClassName_4001Parser() {
		if (associationClassName_4001Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			associationClassName_4001Parser = parser;
		}
		return associationClassName_4001Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationClassName_4002Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationClassName_4002Parser() {
		if (associationClassName_4002Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			associationClassName_4002Parser = parser;
		}
		return associationClassName_4002Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationClassQualifiedName_4003Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationClassQualifiedName_4003Parser() {
		if (associationClassQualifiedName_4003Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			associationClassQualifiedName_4003Parser = parser;
		}
		return associationClassQualifiedName_4003Parser;
	}

	/**
	 * @generated
	 */
	private IParser instanceSpecificationName_4004Parser;

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationName_4004Parser() {
		if (instanceSpecificationName_4004Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			instanceSpecificationName_4004Parser = parser;
		}
		return instanceSpecificationName_4004Parser;
	}

	/**
	 * @generated
	 */
	private IParser instanceSpecificationName_4005Parser;

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationName_4005Parser() {
		if (instanceSpecificationName_4005Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			instanceSpecificationName_4005Parser = parser;
		}
		return instanceSpecificationName_4005Parser;
	}

	/**
	 * @generated
	 */
	private IParser instanceSpecificationQualifiedName_4006Parser;

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationQualifiedName_4006Parser() {
		if (instanceSpecificationQualifiedName_4006Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("({0})"); //$NON-NLS-1$
			parser.setEditorPattern("({0})"); //$NON-NLS-1$
			parser.setEditPattern("({0})"); //$NON-NLS-1$
			instanceSpecificationQualifiedName_4006Parser = parser;
		}
		return instanceSpecificationQualifiedName_4006Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentName_4007Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_4007Parser() {
		if (componentName_4007Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			componentName_4007Parser = parser;
		}
		return componentName_4007Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentName_4008Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_4008Parser() {
		if (componentName_4008Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			componentName_4008Parser = parser;
		}
		return componentName_4008Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentQualifiedName_4009Parser;

	/**
	 * @generated
	 */
	private IParser getComponentQualifiedName_4009Parser() {
		if (componentQualifiedName_4009Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			componentQualifiedName_4009Parser = parser;
		}
		return componentQualifiedName_4009Parser;
	}

	/**
	 * @generated
	 */
	private IParser signalName_4010Parser;

	/**
	 * @generated
	 */
	private IParser getSignalName_4010Parser() {
		if (signalName_4010Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			signalName_4010Parser = parser;
		}
		return signalName_4010Parser;
	}

	/**
	 * @generated
	 */
	private IParser signalName_4011Parser;

	/**
	 * @generated
	 */
	private IParser getSignalName_4011Parser() {
		if (signalName_4011Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			signalName_4011Parser = parser;
		}
		return signalName_4011Parser;
	}

	/**
	 * @generated
	 */
	private IParser signalQualifiedName_4012Parser;

	/**
	 * @generated
	 */
	private IParser getSignalQualifiedName_4012Parser() {
		if (signalQualifiedName_4012Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			signalQualifiedName_4012Parser = parser;
		}
		return signalQualifiedName_4012Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceName_4013Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceName_4013Parser() {
		if (interfaceName_4013Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			interfaceName_4013Parser = parser;
		}
		return interfaceName_4013Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceName_4014Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceName_4014Parser() {
		if (interfaceName_4014Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			interfaceName_4014Parser = parser;
		}
		return interfaceName_4014Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceQualifiedName_4015Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceQualifiedName_4015Parser() {
		if (interfaceQualifiedName_4015Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			interfaceQualifiedName_4015Parser = parser;
		}
		return interfaceQualifiedName_4015Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelName_4048Parser;

	/**
	 * @generated
	 */
	private IParser getModelName_4048Parser() {
		if (modelName_4048Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			modelName_4048Parser = parser;
		}
		return modelName_4048Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelName_4049Parser;

	/**
	 * @generated
	 */
	private IParser getModelName_4049Parser() {
		if (modelName_4049Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			modelName_4049Parser = parser;
		}
		return modelName_4049Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelQualifiedName_4050Parser;

	/**
	 * @generated
	 */
	private IParser getModelQualifiedName_4050Parser() {
		if (modelQualifiedName_4050Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("({0})"); //$NON-NLS-1$
			parser.setEditorPattern("({0})"); //$NON-NLS-1$
			parser.setEditPattern("({0})"); //$NON-NLS-1$
			modelQualifiedName_4050Parser = parser;
		}
		return modelQualifiedName_4050Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumerationName_4051Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationName_4051Parser() {
		if (enumerationName_4051Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			enumerationName_4051Parser = parser;
		}
		return enumerationName_4051Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumerationName_4052Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationName_4052Parser() {
		if (enumerationName_4052Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			enumerationName_4052Parser = parser;
		}
		return enumerationName_4052Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumerationQualifiedName_4053Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationQualifiedName_4053Parser() {
		if (enumerationQualifiedName_4053Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("({0})"); //$NON-NLS-1$
			parser.setEditorPattern("({0})"); //$NON-NLS-1$
			parser.setEditPattern("({0})"); //$NON-NLS-1$
			enumerationQualifiedName_4053Parser = parser;
		}
		return enumerationQualifiedName_4053Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_4054Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_4054Parser() {
		if (packageName_4054Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			packageName_4054Parser = parser;
		}
		return packageName_4054Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_4055Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_4055Parser() {
		if (packageName_4055Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			packageName_4055Parser = parser;
		}
		return packageName_4055Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageQualifiedName_4056Parser;

	/**
	 * @generated
	 */
	private IParser getPackageQualifiedName_4056Parser() {
		if (packageQualifiedName_4056Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("({0})"); //$NON-NLS-1$
			parser.setEditorPattern("({0})"); //$NON-NLS-1$
			parser.setEditPattern("({0})"); //$NON-NLS-1$
			packageQualifiedName_4056Parser = parser;
		}
		return packageQualifiedName_4056Parser;
	}

	/**
	 * @generated
	 */
	private IParser className_4057Parser;

	/**
	 * @generated
	 */
	private IParser getClassName_4057Parser() {
		if (className_4057Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			className_4057Parser = parser;
		}
		return className_4057Parser;
	}

	/**
	 * @generated
	 */
	private IParser className_4058Parser;

	/**
	 * @generated
	 */
	private IParser getClassName_4058Parser() {
		if (className_4058Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			className_4058Parser = parser;
		}
		return className_4058Parser;
	}

	/**
	 * @generated
	 */
	private IParser classQualifiedName_4059Parser;

	/**
	 * @generated
	 */
	private IParser getClassQualifiedName_4059Parser() {
		if (classQualifiedName_4059Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			classQualifiedName_4059Parser = parser;
		}
		return classQualifiedName_4059Parser;
	}

	/**
	 * @generated
	 */
	private IParser primitiveTypeName_4060Parser;

	/**
	 * @generated
	 */
	private IParser getPrimitiveTypeName_4060Parser() {
		if (primitiveTypeName_4060Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			primitiveTypeName_4060Parser = parser;
		}
		return primitiveTypeName_4060Parser;
	}

	/**
	 * @generated
	 */
	private IParser primitiveTypeName_4061Parser;

	/**
	 * @generated
	 */
	private IParser getPrimitiveTypeName_4061Parser() {
		if (primitiveTypeName_4061Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			primitiveTypeName_4061Parser = parser;
		}
		return primitiveTypeName_4061Parser;
	}

	/**
	 * @generated
	 */
	private IParser primitiveTypeQualifiedName_4062Parser;

	/**
	 * @generated
	 */
	private IParser getPrimitiveTypeQualifiedName_4062Parser() {
		if (primitiveTypeQualifiedName_4062Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("({0})"); //$NON-NLS-1$
			parser.setEditorPattern("({0})"); //$NON-NLS-1$
			parser.setEditPattern("({0})"); //$NON-NLS-1$
			primitiveTypeQualifiedName_4062Parser = parser;
		}
		return primitiveTypeQualifiedName_4062Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataTypeName_4063Parser;

	/**
	 * @generated
	 */
	private IParser getDataTypeName_4063Parser() {
		if (dataTypeName_4063Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			dataTypeName_4063Parser = parser;
		}
		return dataTypeName_4063Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataTypeName_4064Parser;

	/**
	 * @generated
	 */
	private IParser getDataTypeName_4064Parser() {
		if (dataTypeName_4064Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			dataTypeName_4064Parser = parser;
		}
		return dataTypeName_4064Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataTypeQualifiedName_4065Parser;

	/**
	 * @generated
	 */
	private IParser getDataTypeQualifiedName_4065Parser() {
		if (dataTypeQualifiedName_4065Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("({0})"); //$NON-NLS-1$
			parser.setEditorPattern("({0})"); //$NON-NLS-1$
			parser.setEditPattern("({0})"); //$NON-NLS-1$
			dataTypeQualifiedName_4065Parser = parser;
		}
		return dataTypeQualifiedName_4065Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_4066Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_4066Parser() {
		if (constraintName_4066Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			constraintName_4066Parser = parser;
		}
		return constraintName_4066Parser;
	}

	/**
	 * @generated
	 */
	private IParser commentBody_4067Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_4067Parser() {
		if (commentBody_4067Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getComment_Body() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			commentBody_4067Parser = parser;
		}
		return commentBody_4067Parser;
	}

	/**
	 * @generated
	 */
	private IParser property_2001Parser;

	/**
	 * @generated
	 */
	private IParser getProperty_2001Parser() {
		if (property_2001Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			property_2001Parser = parser;
		}
		return property_2001Parser;
	}

	/**
	 * @generated
	 */
	private IParser operation_2003Parser;

	/**
	 * @generated
	 */
	private IParser getOperation_2003Parser() {
		if (operation_2003Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			operation_2003Parser = parser;
		}
		return operation_2003Parser;
	}

	/**
	 * @generated
	 */
	private IParser class_2004Parser;

	/**
	 * @generated
	 */
	private IParser getClass_2004Parser() {
		if (class_2004Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			class_2004Parser = parser;
		}
		return class_2004Parser;
	}

	/**
	 * @generated
	 */
	private IParser property_2007Parser;

	/**
	 * @generated
	 */
	private IParser getProperty_2007Parser() {
		if (property_2007Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			property_2007Parser = parser;
		}
		return property_2007Parser;
	}

	/**
	 * @generated
	 */
	private IParser property_2008Parser;

	/**
	 * @generated
	 */
	private IParser getProperty_2008Parser() {
		if (property_2008Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			property_2008Parser = parser;
		}
		return property_2008Parser;
	}

	/**
	 * @generated
	 */
	private IParser operation_2009Parser;

	/**
	 * @generated
	 */
	private IParser getOperation_2009Parser() {
		if (operation_2009Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			operation_2009Parser = parser;
		}
		return operation_2009Parser;
	}

	/**
	 * @generated
	 */
	private IParser class_2010Parser;

	/**
	 * @generated
	 */
	private IParser getClass_2010Parser() {
		if (class_2010Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			class_2010Parser = parser;
		}
		return class_2010Parser;
	}

	/**
	 * @generated
	 */
	private IParser instanceSpecificationName_4016Parser;

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationName_4016Parser() {
		if (instanceSpecificationName_4016Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			instanceSpecificationName_4016Parser = parser;
		}
		return instanceSpecificationName_4016Parser;
	}

	/**
	 * @generated
	 */
	private IParser instanceSpecificationName_4017Parser;

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationName_4017Parser() {
		if (instanceSpecificationName_4017Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			instanceSpecificationName_4017Parser = parser;
		}
		return instanceSpecificationName_4017Parser;
	}

	/**
	 * @generated
	 */
	private IParser instanceSpecificationQualifiedName_4018Parser;

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationQualifiedName_4018Parser() {
		if (instanceSpecificationQualifiedName_4018Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("({0})"); //$NON-NLS-1$
			parser.setEditorPattern("({0})"); //$NON-NLS-1$
			parser.setEditPattern("({0})"); //$NON-NLS-1$
			instanceSpecificationQualifiedName_4018Parser = parser;
		}
		return instanceSpecificationQualifiedName_4018Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentName_4019Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_4019Parser() {
		if (componentName_4019Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			componentName_4019Parser = parser;
		}
		return componentName_4019Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentName_4020Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_4020Parser() {
		if (componentName_4020Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			componentName_4020Parser = parser;
		}
		return componentName_4020Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentQualifiedName_4021Parser;

	/**
	 * @generated
	 */
	private IParser getComponentQualifiedName_4021Parser() {
		if (componentQualifiedName_4021Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			componentQualifiedName_4021Parser = parser;
		}
		return componentQualifiedName_4021Parser;
	}

	/**
	 * @generated
	 */
	private IParser signalName_4022Parser;

	/**
	 * @generated
	 */
	private IParser getSignalName_4022Parser() {
		if (signalName_4022Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			signalName_4022Parser = parser;
		}
		return signalName_4022Parser;
	}

	/**
	 * @generated
	 */
	private IParser signalName_4023Parser;

	/**
	 * @generated
	 */
	private IParser getSignalName_4023Parser() {
		if (signalName_4023Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			signalName_4023Parser = parser;
		}
		return signalName_4023Parser;
	}

	/**
	 * @generated
	 */
	private IParser signalQualifiedName_4024Parser;

	/**
	 * @generated
	 */
	private IParser getSignalQualifiedName_4024Parser() {
		if (signalQualifiedName_4024Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			signalQualifiedName_4024Parser = parser;
		}
		return signalQualifiedName_4024Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceName_4025Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceName_4025Parser() {
		if (interfaceName_4025Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			interfaceName_4025Parser = parser;
		}
		return interfaceName_4025Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceName_4026Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceName_4026Parser() {
		if (interfaceName_4026Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			interfaceName_4026Parser = parser;
		}
		return interfaceName_4026Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceQualifiedName_4027Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceQualifiedName_4027Parser() {
		if (interfaceQualifiedName_4027Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			interfaceQualifiedName_4027Parser = parser;
		}
		return interfaceQualifiedName_4027Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelName_4045Parser;

	/**
	 * @generated
	 */
	private IParser getModelName_4045Parser() {
		if (modelName_4045Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			modelName_4045Parser = parser;
		}
		return modelName_4045Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelName_4046Parser;

	/**
	 * @generated
	 */
	private IParser getModelName_4046Parser() {
		if (modelName_4046Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			modelName_4046Parser = parser;
		}
		return modelName_4046Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelQualifiedName_4047Parser;

	/**
	 * @generated
	 */
	private IParser getModelQualifiedName_4047Parser() {
		if (modelQualifiedName_4047Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("({0})"); //$NON-NLS-1$
			parser.setEditorPattern("({0})"); //$NON-NLS-1$
			parser.setEditPattern("({0})"); //$NON-NLS-1$
			modelQualifiedName_4047Parser = parser;
		}
		return modelQualifiedName_4047Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumerationName_4028Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationName_4028Parser() {
		if (enumerationName_4028Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			enumerationName_4028Parser = parser;
		}
		return enumerationName_4028Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumerationName_4029Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationName_4029Parser() {
		if (enumerationName_4029Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			enumerationName_4029Parser = parser;
		}
		return enumerationName_4029Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumerationQualifiedName_4030Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationQualifiedName_4030Parser() {
		if (enumerationQualifiedName_4030Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("({0})"); //$NON-NLS-1$
			parser.setEditorPattern("({0})"); //$NON-NLS-1$
			parser.setEditPattern("({0})"); //$NON-NLS-1$
			enumerationQualifiedName_4030Parser = parser;
		}
		return enumerationQualifiedName_4030Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumerationLiteral_2017Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationLiteral_2017Parser() {
		if (enumerationLiteral_2017Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			enumerationLiteral_2017Parser = parser;
		}
		return enumerationLiteral_2017Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_4042Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_4042Parser() {
		if (packageName_4042Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			packageName_4042Parser = parser;
		}
		return packageName_4042Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_4043Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_4043Parser() {
		if (packageName_4043Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			packageName_4043Parser = parser;
		}
		return packageName_4043Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageQualifiedName_4044Parser;

	/**
	 * @generated
	 */
	private IParser getPackageQualifiedName_4044Parser() {
		if (packageQualifiedName_4044Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("({0})"); //$NON-NLS-1$
			parser.setEditorPattern("({0})"); //$NON-NLS-1$
			parser.setEditPattern("({0})"); //$NON-NLS-1$
			packageQualifiedName_4044Parser = parser;
		}
		return packageQualifiedName_4044Parser;
	}

	/**
	 * @generated
	 */
	private IParser className_4031Parser;

	/**
	 * @generated
	 */
	private IParser getClassName_4031Parser() {
		if (className_4031Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			className_4031Parser = parser;
		}
		return className_4031Parser;
	}

	/**
	 * @generated
	 */
	private IParser className_4032Parser;

	/**
	 * @generated
	 */
	private IParser getClassName_4032Parser() {
		if (className_4032Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			className_4032Parser = parser;
		}
		return className_4032Parser;
	}

	/**
	 * @generated
	 */
	private IParser classQualifiedName_4033Parser;

	/**
	 * @generated
	 */
	private IParser getClassQualifiedName_4033Parser() {
		if (classQualifiedName_4033Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			classQualifiedName_4033Parser = parser;
		}
		return classQualifiedName_4033Parser;
	}

	/**
	 * @generated
	 */
	private IParser reception_2020Parser;

	/**
	 * @generated
	 */
	private IParser getReception_2020Parser() {
		if (reception_2020Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			reception_2020Parser = parser;
		}
		return reception_2020Parser;
	}

	/**
	 * @generated
	 */
	private IParser property_2021Parser;

	/**
	 * @generated
	 */
	private IParser getProperty_2021Parser() {
		if (property_2021Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			property_2021Parser = parser;
		}
		return property_2021Parser;
	}

	/**
	 * @generated
	 */
	private IParser operation_2022Parser;

	/**
	 * @generated
	 */
	private IParser getOperation_2022Parser() {
		if (operation_2022Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			operation_2022Parser = parser;
		}
		return operation_2022Parser;
	}

	/**
	 * @generated
	 */
	private IParser class_2023Parser;

	/**
	 * @generated
	 */
	private IParser getClass_2023Parser() {
		if (class_2023Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			class_2023Parser = parser;
		}
		return class_2023Parser;
	}

	/**
	 * @generated
	 */
	private IParser primitiveTypeName_4034Parser;

	/**
	 * @generated
	 */
	private IParser getPrimitiveTypeName_4034Parser() {
		if (primitiveTypeName_4034Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			primitiveTypeName_4034Parser = parser;
		}
		return primitiveTypeName_4034Parser;
	}

	/**
	 * @generated
	 */
	private IParser primitiveTypeName_4035Parser;

	/**
	 * @generated
	 */
	private IParser getPrimitiveTypeName_4035Parser() {
		if (primitiveTypeName_4035Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			primitiveTypeName_4035Parser = parser;
		}
		return primitiveTypeName_4035Parser;
	}

	/**
	 * @generated
	 */
	private IParser primitiveTypeQualifiedName_4036Parser;

	/**
	 * @generated
	 */
	private IParser getPrimitiveTypeQualifiedName_4036Parser() {
		if (primitiveTypeQualifiedName_4036Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("({0})"); //$NON-NLS-1$
			parser.setEditorPattern("({0})"); //$NON-NLS-1$
			parser.setEditPattern("({0})"); //$NON-NLS-1$
			primitiveTypeQualifiedName_4036Parser = parser;
		}
		return primitiveTypeQualifiedName_4036Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataTypeName_4037Parser;

	/**
	 * @generated
	 */
	private IParser getDataTypeName_4037Parser() {
		if (dataTypeName_4037Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			dataTypeName_4037Parser = parser;
		}
		return dataTypeName_4037Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataTypeName_4038Parser;

	/**
	 * @generated
	 */
	private IParser getDataTypeName_4038Parser() {
		if (dataTypeName_4038Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			dataTypeName_4038Parser = parser;
		}
		return dataTypeName_4038Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataTypeQualifiedName_4039Parser;

	/**
	 * @generated
	 */
	private IParser getDataTypeQualifiedName_4039Parser() {
		if (dataTypeQualifiedName_4039Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("({0})"); //$NON-NLS-1$
			parser.setEditorPattern("({0})"); //$NON-NLS-1$
			parser.setEditPattern("({0})"); //$NON-NLS-1$
			dataTypeQualifiedName_4039Parser = parser;
		}
		return dataTypeQualifiedName_4039Parser;
	}

	/**
	 * @generated
	 */
	private IParser property_2026Parser;

	/**
	 * @generated
	 */
	private IParser getProperty_2026Parser() {
		if (property_2026Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			property_2026Parser = parser;
		}
		return property_2026Parser;
	}

	/**
	 * @generated
	 */
	private IParser operation_2027Parser;

	/**
	 * @generated
	 */
	private IParser getOperation_2027Parser() {
		if (operation_2027Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			operation_2027Parser = parser;
		}
		return operation_2027Parser;
	}

	/**
	 * @generated
	 */
	private IParser commentBody_4040Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_4040Parser() {
		if (commentBody_4040Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getComment_Body() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			commentBody_4040Parser = parser;
		}
		return commentBody_4040Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_4041Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_4041Parser() {
		if (constraintName_4041Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			constraintName_4041Parser = parser;
		}
		return constraintName_4041Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_4068Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_4068Parser() {
		if (associationName_4068Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			associationName_4068Parser = parser;
		}
		return associationName_4068Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_4069Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_4069Parser() {
		if (associationName_4069Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			associationName_4069Parser = parser;
		}
		return associationName_4069Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_4070Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_4070Parser() {
		if (associationName_4070Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("srcRole{0}"); //$NON-NLS-1$
			parser.setEditorPattern("srcRole{0}"); //$NON-NLS-1$
			parser.setEditPattern("srcRole{0}"); //$NON-NLS-1$
			associationName_4070Parser = parser;
		}
		return associationName_4070Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_4071Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_4071Parser() {
		if (associationName_4071Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("srcMul{0}"); //$NON-NLS-1$
			parser.setEditorPattern("srcMul{0}"); //$NON-NLS-1$
			parser.setEditPattern("srcMul{0}"); //$NON-NLS-1$
			associationName_4071Parser = parser;
		}
		return associationName_4071Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_4072Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_4072Parser() {
		if (associationName_4072Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("targMul{0}"); //$NON-NLS-1$
			parser.setEditorPattern("targMul{0}"); //$NON-NLS-1$
			parser.setEditPattern("targMul{0}"); //$NON-NLS-1$
			associationName_4072Parser = parser;
		}
		return associationName_4072Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_4073Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_4073Parser() {
		if (associationName_4073Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("targRole{0}"); //$NON-NLS-1$
			parser.setEditorPattern("targRole{0}"); //$NON-NLS-1$
			parser.setEditPattern("targRole{0}"); //$NON-NLS-1$
			associationName_4073Parser = parser;
		}
		return associationName_4073Parser;
	}

	/**
	 * @generated
	 */
	private IParser generalizationIsSubstitutable_4074Parser;

	/**
	 * @generated
	 */
	private IParser getGeneralizationIsSubstitutable_4074Parser() {
		if (generalizationIsSubstitutable_4074Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getGeneralization_IsSubstitutable() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			generalizationIsSubstitutable_4074Parser = parser;
		}
		return generalizationIsSubstitutable_4074Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceRealizationName_4075Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceRealizationName_4075Parser() {
		if (interfaceRealizationName_4075Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			interfaceRealizationName_4075Parser = parser;
		}
		return interfaceRealizationName_4075Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceRealizationName_4076Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceRealizationName_4076Parser() {
		if (interfaceRealizationName_4076Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			interfaceRealizationName_4076Parser = parser;
		}
		return interfaceRealizationName_4076Parser;
	}

	/**
	 * @generated
	 */
	private IParser substitutionName_4077Parser;

	/**
	 * @generated
	 */
	private IParser getSubstitutionName_4077Parser() {
		if (substitutionName_4077Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			substitutionName_4077Parser = parser;
		}
		return substitutionName_4077Parser;
	}

	/**
	 * @generated
	 */
	private IParser substitutionName_4078Parser;

	/**
	 * @generated
	 */
	private IParser getSubstitutionName_4078Parser() {
		if (substitutionName_4078Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			substitutionName_4078Parser = parser;
		}
		return substitutionName_4078Parser;
	}

	/**
	 * @generated
	 */
	private IParser realizationName_4079Parser;

	/**
	 * @generated
	 */
	private IParser getRealizationName_4079Parser() {
		if (realizationName_4079Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			realizationName_4079Parser = parser;
		}
		return realizationName_4079Parser;
	}

	/**
	 * @generated
	 */
	private IParser realizationName_4080Parser;

	/**
	 * @generated
	 */
	private IParser getRealizationName_4080Parser() {
		if (realizationName_4080Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			realizationName_4080Parser = parser;
		}
		return realizationName_4080Parser;
	}

	/**
	 * @generated
	 */
	private IParser abstractionName_4081Parser;

	/**
	 * @generated
	 */
	private IParser getAbstractionName_4081Parser() {
		if (abstractionName_4081Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			abstractionName_4081Parser = parser;
		}
		return abstractionName_4081Parser;
	}

	/**
	 * @generated
	 */
	private IParser abstractionName_4082Parser;

	/**
	 * @generated
	 */
	private IParser getAbstractionName_4082Parser() {
		if (abstractionName_4082Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			abstractionName_4082Parser = parser;
		}
		return abstractionName_4082Parser;
	}

	/**
	 * @generated
	 */
	private IParser usageName_4083Parser;

	/**
	 * @generated
	 */
	private IParser getUsageName_4083Parser() {
		if (usageName_4083Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			usageName_4083Parser = parser;
		}
		return usageName_4083Parser;
	}

	/**
	 * @generated
	 */
	private IParser usageName_4084Parser;

	/**
	 * @generated
	 */
	private IParser getUsageName_4084Parser() {
		if (usageName_4084Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			usageName_4084Parser = parser;
		}
		return usageName_4084Parser;
	}

	/**
	 * @generated
	 */
	private IParser dependencyName_4085Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_4085Parser() {
		if (dependencyName_4085Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			dependencyName_4085Parser = parser;
		}
		return dependencyName_4085Parser;
	}

	/**
	 * @generated
	 */
	private IParser dependencyName_4086Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_4086Parser() {
		if (dependencyName_4086Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			dependencyName_4086Parser = parser;
		}
		return dependencyName_4086Parser;
	}

	/**
	 * @generated
	 */
	private IParser dependencyName_4087Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_4087Parser() {
		if (dependencyName_4087Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			dependencyName_4087Parser = parser;
		}
		return dependencyName_4087Parser;
	}

	/**
	 * @generated
	 */
	private IParser dependencyName_4088Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_4088Parser() {
		if (dependencyName_4088Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			dependencyName_4088Parser = parser;
		}
		return dependencyName_4088Parser;
	}

	/**
	 * @generated
	 */
	private IParser elementImportAlias_4089Parser;

	/**
	 * @generated
	 */
	private IParser getElementImportAlias_4089Parser() {
		if (elementImportAlias_4089Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getElementImport_Alias() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			elementImportAlias_4089Parser = parser;
		}
		return elementImportAlias_4089Parser;
	}

	/**
	 * @generated
	 */
	private IParser elementImportAlias_4090Parser;

	/**
	 * @generated
	 */
	private IParser getElementImportAlias_4090Parser() {
		if (elementImportAlias_4090Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getElementImport_Alias() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			elementImportAlias_4090Parser = parser;
		}
		return elementImportAlias_4090Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageImportVisibility_4091Parser;

	/**
	 * @generated
	 */
	private IParser getPackageImportVisibility_4091Parser() {
		if (packageImportVisibility_4091Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getPackageImport_Visibility() };
			org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser parser = new org.eclipse.papyrus.diagram.clazzBis.parsers.MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			packageImportVisibility_4091Parser = parser;
		}
		return packageImportVisibility_4091Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassNameEditPart.VISUAL_ID:
			return getAssociationClassName_4001Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassName2EditPart.VISUAL_ID:
			return getAssociationClassName_4002Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassQualifiedNameEditPart.VISUAL_ID:
			return getAssociationClassQualifiedName_4003Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationNameEditPart.VISUAL_ID:
			return getInstanceSpecificationName_4004Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationName2EditPart.VISUAL_ID:
			return getInstanceSpecificationName_4005Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationQualifiedNameEditPart.VISUAL_ID:
			return getInstanceSpecificationQualifiedName_4006Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNameEditPart.VISUAL_ID:
			return getComponentName_4007Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentName2EditPart.VISUAL_ID:
			return getComponentName_4008Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentQualifiedNameEditPart.VISUAL_ID:
			return getComponentQualifiedName_4009Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalNameEditPart.VISUAL_ID:
			return getSignalName_4010Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalName2EditPart.VISUAL_ID:
			return getSignalName_4011Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalQualifiedNameEditPart.VISUAL_ID:
			return getSignalQualifiedName_4012Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNameEditPart.VISUAL_ID:
			return getInterfaceName_4013Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceName2EditPart.VISUAL_ID:
			return getInterfaceName_4014Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceQualifiedNameEditPart.VISUAL_ID:
			return getInterfaceQualifiedName_4015Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelNameEditPart.VISUAL_ID:
			return getModelName_4048Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelName2EditPart.VISUAL_ID:
			return getModelName_4049Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelQualifiedNameEditPart.VISUAL_ID:
			return getModelQualifiedName_4050Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationNameEditPart.VISUAL_ID:
			return getEnumerationName_4051Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationName2EditPart.VISUAL_ID:
			return getEnumerationName_4052Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationQualifiedNameEditPart.VISUAL_ID:
			return getEnumerationQualifiedName_4053Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageNameEditPart.VISUAL_ID:
			return getPackageName_4054Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageName2EditPart.VISUAL_ID:
			return getPackageName_4055Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageQualifiedNameEditPart.VISUAL_ID:
			return getPackageQualifiedName_4056Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNameEditPart.VISUAL_ID:
			return getClassName_4057Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassName2EditPart.VISUAL_ID:
			return getClassName_4058Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassQualifiedNameEditPart.VISUAL_ID:
			return getClassQualifiedName_4059Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeNameEditPart.VISUAL_ID:
			return getPrimitiveTypeName_4060Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeName2EditPart.VISUAL_ID:
			return getPrimitiveTypeName_4061Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeQualifiedNameEditPart.VISUAL_ID:
			return getPrimitiveTypeQualifiedName_4062Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeNameEditPart.VISUAL_ID:
			return getDataTypeName_4063Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeName2EditPart.VISUAL_ID:
			return getDataTypeName_4064Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeQualifiedNameEditPart.VISUAL_ID:
			return getDataTypeQualifiedName_4065Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintNameEditPart.VISUAL_ID:
			return getConstraintName_4066Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentBodyEditPart.VISUAL_ID:
			return getCommentBody_4067Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID:
			return getProperty_2001Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID:
			return getOperation_2003Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID:
			return getClass_2004Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID:
			return getProperty_2007Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID:
			return getProperty_2008Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID:
			return getOperation_2009Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID:
			return getClass_2010Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationName3EditPart.VISUAL_ID:
			return getInstanceSpecificationName_4016Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationName4EditPart.VISUAL_ID:
			return getInstanceSpecificationName_4017Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationQualifiedName2EditPart.VISUAL_ID:
			return getInstanceSpecificationQualifiedName_4018Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentName3EditPart.VISUAL_ID:
			return getComponentName_4019Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentName4EditPart.VISUAL_ID:
			return getComponentName_4020Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentQualifiedName2EditPart.VISUAL_ID:
			return getComponentQualifiedName_4021Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalName3EditPart.VISUAL_ID:
			return getSignalName_4022Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalName4EditPart.VISUAL_ID:
			return getSignalName_4023Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalQualifiedName2EditPart.VISUAL_ID:
			return getSignalQualifiedName_4024Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceName3EditPart.VISUAL_ID:
			return getInterfaceName_4025Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceName4EditPart.VISUAL_ID:
			return getInterfaceName_4026Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceQualifiedName2EditPart.VISUAL_ID:
			return getInterfaceQualifiedName_4027Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelName3EditPart.VISUAL_ID:
			return getModelName_4045Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelName4EditPart.VISUAL_ID:
			return getModelName_4046Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelQualifiedName2EditPart.VISUAL_ID:
			return getModelQualifiedName_4047Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationName3EditPart.VISUAL_ID:
			return getEnumerationName_4028Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationName4EditPart.VISUAL_ID:
			return getEnumerationName_4029Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationQualifiedName2EditPart.VISUAL_ID:
			return getEnumerationQualifiedName_4030Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_2017Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageName3EditPart.VISUAL_ID:
			return getPackageName_4042Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageName4EditPart.VISUAL_ID:
			return getPackageName_4043Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageQualifiedName2EditPart.VISUAL_ID:
			return getPackageQualifiedName_4044Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassName3EditPart.VISUAL_ID:
			return getClassName_4031Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassName4EditPart.VISUAL_ID:
			return getClassName_4032Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassQualifiedName2EditPart.VISUAL_ID:
			return getClassQualifiedName_4033Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID:
			return getReception_2020Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID:
			return getProperty_2021Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID:
			return getOperation_2022Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID:
			return getClass_2023Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeName3EditPart.VISUAL_ID:
			return getPrimitiveTypeName_4034Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeName4EditPart.VISUAL_ID:
			return getPrimitiveTypeName_4035Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeQualifiedName2EditPart.VISUAL_ID:
			return getPrimitiveTypeQualifiedName_4036Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeName3EditPart.VISUAL_ID:
			return getDataTypeName_4037Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeName4EditPart.VISUAL_ID:
			return getDataTypeName_4038Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeQualifiedName2EditPart.VISUAL_ID:
			return getDataTypeQualifiedName_4039Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID:
			return getProperty_2026Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID:
			return getOperation_2027Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentBody2EditPart.VISUAL_ID:
			return getCommentBody_4040Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintName2EditPart.VISUAL_ID:
			return getConstraintName_4041Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationNameEditPart.VISUAL_ID:
			return getAssociationName_4068Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName2EditPart.VISUAL_ID:
			return getAssociationName_4069Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName3EditPart.VISUAL_ID:
			return getAssociationName_4070Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName4EditPart.VISUAL_ID:
			return getAssociationName_4071Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName5EditPart.VISUAL_ID:
			return getAssociationName_4072Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName6EditPart.VISUAL_ID:
			return getAssociationName_4073Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationIsSubstitutableEditPart.VISUAL_ID:
			return getGeneralizationIsSubstitutable_4074Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationNameEditPart.VISUAL_ID:
			return getInterfaceRealizationName_4075Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationName2EditPart.VISUAL_ID:
			return getInterfaceRealizationName_4076Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionNameEditPart.VISUAL_ID:
			return getSubstitutionName_4077Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionName2EditPart.VISUAL_ID:
			return getSubstitutionName_4078Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationNameEditPart.VISUAL_ID:
			return getRealizationName_4079Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationName2EditPart.VISUAL_ID:
			return getRealizationName_4080Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionNameEditPart.VISUAL_ID:
			return getAbstractionName_4081Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionName2EditPart.VISUAL_ID:
			return getAbstractionName_4082Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageNameEditPart.VISUAL_ID:
			return getUsageName_4083Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageName2EditPart.VISUAL_ID:
			return getUsageName_4084Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyNameEditPart.VISUAL_ID:
			return getDependencyName_4085Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyName2EditPart.VISUAL_ID:
			return getDependencyName_4086Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyName3EditPart.VISUAL_ID:
			return getDependencyName_4087Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyName4EditPart.VISUAL_ID:
			return getDependencyName_4088Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportAliasEditPart.VISUAL_ID:
			return getElementImportAlias_4089Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportAlias2EditPart.VISUAL_ID:
			return getElementImportAlias_4090Parser();
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportVisibilityEditPart.VISUAL_ID:
			return getPackageImportVisibility_4091Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.getElement(hint) == null) {
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
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
