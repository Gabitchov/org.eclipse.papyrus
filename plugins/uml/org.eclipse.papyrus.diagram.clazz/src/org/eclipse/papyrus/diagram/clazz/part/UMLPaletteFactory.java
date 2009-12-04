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
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class UMLPaletteFactory extends PaletteFactory.Adapter {

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_MODEL = "clazz.tool.model"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_PACKAGE = "clazz.tool.package"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_CONSTRAINT = "clazz.tool.constraint"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_CONSTRAINTLINK = "clazz.tool.constraintLink"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_COMMENT = "clazz.tool.comment"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_COMMENTLINK = "clazz.tool.commentlink"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_CLASS = "clazz.tool.class"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_COMPONENT = "clazz.tool.component"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_DATATYPE = "clazz.tool.datatype"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_ENUMERATION = "clazz.tool.enumeration"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_INTERFACE = "clazz.tool.interface"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_PRIMITIVETYPE = "clazz.tool.primitivetype"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_SIGNAL = "clazz.tool.signal"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_INSTANCESPECIFICATION = "clazz.tool.instancespecification"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_ABSTRACTION = "clazz.tool.abstraction"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_ASSOCIATION = "clazz.tool.association"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_ASSOCIATIONBRANCH = "clazz.tool.associationbranch"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_ASSOCIATIONCLASS = "clazz.tool.associationclass"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_DEPENDENCY = "clazz.tool.dependency"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_DEPENDENCYBRANCH = "clazz.tool.dependencybranch"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_ELEMENTIMPORT = "clazz.tool.elementimport"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_GENERALIZATION = "clazz.tool.generalization"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_INTERFACEREALIZATION = "clazz.tool.interfacerealization"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_PACKAGEIMPORT = "clazz.tool.packageimport"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_PACKAGEMERGE = "clazz.tool.packagemerge"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_PROFILEAPPLICATION = "clazz.tool.profileapplication"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_REALIZATION = "clazz.tool.realization"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_SUBSTITUTION = "clazz.tool.substitution"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_USAGE = "clazz.tool.usage"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_TEMPLATEBINDING = "clazz.tool.templatebinding"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_GENERALIZATIONSET = "clazz.tool.generalizationset"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_INSTANCESPECIFICATIONLINK = "clazz.tool.instancespecificationlink"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_RECEPTION = "clazz.tool.reception"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_PROPERTY = "clazz.tool.property"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_OPERATION = "clazz.tool.operation"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_SLOT = "clazz.tool.slot"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_ENUMERATIONLITERAL = "clazz.tool.enumerationliteral"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_REDEFINABLETEMPLATESIGNATURE = "clazz.tool.redefinabletemplatesignature"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_TEMPLATEPARAMETER = "clazz.tool.templateparameter"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_CLASSIFIERTEMPLATEPARAMETER = "clazz.tool.classifiertemplateparameter"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public UMLPaletteFactory() {

	}

	/**
	 * @generated
	 */
	public Tool createTool(String toolId) {
		if(toolId.equals(CLAZZ_TOOL_MODEL)) {
			return createModel1CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_PACKAGE)) {
			return createPackage2CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_CONSTRAINT)) {
			return createConstraint3CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_CONSTRAINTLINK)) {
			return createConstraintlink4CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_COMMENT)) {
			return createComment5CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_COMMENTLINK)) {
			return createCommentlink6CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_CLASS)) {
			return createClass1CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_COMPONENT)) {
			return createComponent2CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_DATATYPE)) {
			return createDataType3CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_ENUMERATION)) {
			return createEnumeration4CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_INTERFACE)) {
			return createInterface5CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_PRIMITIVETYPE)) {
			return createPrimitiveType6CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_SIGNAL)) {
			return createSignal7CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_INSTANCESPECIFICATION)) {
			return createInstanceSpecification8CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_ABSTRACTION)) {
			return createAbstraction1CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_ASSOCIATION)) {
			return createAssociation2CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_ASSOCIATIONBRANCH)) {
			return createAssociationBranch3CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_ASSOCIATIONCLASS)) {
			return createAssociationClass4CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_DEPENDENCY)) {
			return createDependency5CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_DEPENDENCYBRANCH)) {
			return createDependencyBranch6CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_ELEMENTIMPORT)) {
			return createElementImport7CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_GENERALIZATION)) {
			return createGeneralization8CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_INTERFACEREALIZATION)) {
			return createInterfaceRealization9CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_PACKAGEIMPORT)) {
			return createPackageImport10CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_PACKAGEMERGE)) {
			return createPackageMerge11CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_PROFILEAPPLICATION)) {
			return createProfileApplication12CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_REALIZATION)) {
			return createRealization13CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_SUBSTITUTION)) {
			return createSubstitution14CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_USAGE)) {
			return createUsage15CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_TEMPLATEBINDING)) {
			return createTemplateBinding16CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_GENERALIZATIONSET)) {
			return createGeneralizationSet17CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_INSTANCESPECIFICATIONLINK)) {
			return createInstanceSpecification18CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_RECEPTION)) {
			return createReception1CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_PROPERTY)) {
			return createProperty2CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_OPERATION)) {
			return createOperation3CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_SLOT)) {
			return createSlot4CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_ENUMERATIONLITERAL)) {
			return createEnumerationliteral5CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_REDEFINABLETEMPLATESIGNATURE)) {
			return createRedefinableTemplateSignature1CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_TEMPLATEPARAMETER)) {
			return createTemplateParameter2CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_CLASSIFIERTEMPLATEPARAMETER)) {
			return createClassifierTemplateParameter3CreationTool();
		}

		// default return: null
		return null;
	}

	public Object getTemplate(String templateId) {

		// default return: null
		return null;
	}

	/**
	 * @generated
	 */
	private Tool createModel1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Model_2005);
		types.add(UMLElementTypes.Model_3024);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPackage2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Package_3009);
		types.add(UMLElementTypes.Package_2007);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConstraint3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Constraint_3029);
		types.add(UMLElementTypes.Constraint_2011);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConstraintlink4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4014);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createComment5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Comment_3028);
		types.add(UMLElementTypes.Comment_2012);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCommentlink6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CommentAnnotatedElement_4013);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createClass1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(UMLElementTypes.Class_3004);
		types.add(UMLElementTypes.Class_3008);
		types.add(UMLElementTypes.Class_3010);
		types.add(UMLElementTypes.Class_3014);
		types.add(UMLElementTypes.Class_2008);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createComponent2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Component_2002);
		types.add(UMLElementTypes.Component_3021);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDataType3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.DataType_3027);
		types.add(UMLElementTypes.DataType_2010);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createEnumeration4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Enumeration_3025);
		types.add(UMLElementTypes.Enumeration_2006);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInterface5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Interface_2004);
		types.add(UMLElementTypes.Interface_3023);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPrimitiveType6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.PrimitiveType_3026);
		types.add(UMLElementTypes.PrimitiveType_2009);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createSignal7CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Signal_2003);
		types.add(UMLElementTypes.Signal_3022);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInstanceSpecification8CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.InstanceSpecification_2001);
		types.add(UMLElementTypes.InstanceSpecification_3020);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAbstraction1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Abstraction_4006);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAssociation2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Association_4001);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAssociationBranch3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Association_4019);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAssociationClass4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.AssociationClass_4017);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDependency5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Dependency_4008);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDependencyBranch6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Dependency_4018);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createElementImport7CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ElementImport_4009);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createGeneralization8CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Generalization_4002);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInterfaceRealization9CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.InterfaceRealization_4003);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPackageImport10CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.PackageImport_4010);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPackageMerge11CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.PackageMerge_4011);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createProfileApplication12CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ProfileApplication_4012);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createRealization13CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Realization_4005);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createSubstitution14CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Substitution_4004);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createUsage15CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Usage_4007);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createTemplateBinding16CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TemplateBinding_4015);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createGeneralizationSet17CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.GeneralizationSet_4020);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInstanceSpecification18CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Link_4021);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createReception1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Reception_3011);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createProperty2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(UMLElementTypes.Property_3002);
		types.add(UMLElementTypes.Property_3005);
		types.add(UMLElementTypes.Property_3006);
		types.add(UMLElementTypes.Property_3012);
		types.add(UMLElementTypes.Property_3018);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createOperation3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(UMLElementTypes.Operation_3003);
		types.add(UMLElementTypes.Operation_3007);
		types.add(UMLElementTypes.Operation_3013);
		types.add(UMLElementTypes.Operation_3019);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createSlot4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Slot_3030);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createEnumerationliteral5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.EnumerationLiteral_3017);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createRedefinableTemplateSignature1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createTemplateParameter2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TemplateParameter_3016);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createClassifierTemplateParameter3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ClassifierTemplateParameter_3031);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

}
