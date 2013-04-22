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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;

/**
 * @generated
 */
public class UMLPaletteFactory extends PaletteFactory.Adapter {

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_CLASS = "clazz.tool.class"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_CLASSIFIERTEMPLATEPARAMETER = "clazz.tool.classifiertemplateparameter"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_COMMENT = "clazz.tool.comment"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_COMPONENT = "clazz.tool.component"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_CONSTRAINT = "clazz.tool.constraint"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_DATATYPE = "clazz.tool.datatype"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEDURATIONOBSERVATION7CREATIONTOOL = "createDurationObservation7CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_ENUMERATION = "clazz.tool.enumeration"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_ENUMERATIONLITERAL = "clazz.tool.enumerationliteral"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_INTERFACE = "clazz.tool.interface"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_INSTANCESPECIFICATION = "clazz.tool.instancespecification"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_INFORMATIONITEM = "clazz.tool.informationitem"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_PRIMITIVETYPE = "clazz.tool.primitivetype"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_MODEL = "clazz.tool.model"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_OPERATION = "clazz.tool.operation"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_OPERATIONTEMPLATEPARAMETER = "clazz.tool.OperationTemplateParameter"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_PACKAGE = "clazz.tool.package"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_PROPERTY = "clazz.tool.property"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_RECEPTION = "clazz.tool.reception"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_REDEFINABLETEMPLATESIGNATURE = "clazz.tool.redefinabletemplatesignature"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_SIGNAL = "clazz.tool.signal"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_SLOT = "clazz.tool.slot"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_TEMPLATEPARAMETER = "clazz.tool.templateparameter"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_TEMPLATESIGNATURE = "clazz.tool.templatesignature"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATETIMEOBSERVATION22CREATIONTOOL = "createTimeObservation22CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_CONNECTABLEELEMENTTEMPLATEPARAMETER = "clazz.tool.connectableelementtemplateparameter"; //$NON-NLS-1$

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
	private final static String CLAZZ_TOOL_CONTAINMENTLINK = "clazz.tool.containmentlink"; //$NON-NLS-1$

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
	private final static String CLAZZ_TOOL_GENERALIZATIONSET = "clazz.tool.generalizationset"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_INFORMATIONFLOWLINK = "clazz.tool.informationflowlink"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_INSTANCESPECIFICATIONLINK = "clazz.tool.instancespecificationlink"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_INTERFACEREALIZATION = "clazz.tool.interfacerealization"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_LINK = "clazz.tool.link"; //$NON-NLS-1$

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
	public UMLPaletteFactory() {
	}

	/**
	 * @generated
	 */
	public Tool createTool(String toolId) {
		if(toolId.equals(CLAZZ_TOOL_CLASS)) {
			return createClass1CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_CLASSIFIERTEMPLATEPARAMETER)) {
			return createClassifierTemplateParameter2CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_COMMENT)) {
			return createComment5CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_COMPONENT)) {
			return createComponent4CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_CONSTRAINT)) {
			return createConstraint5CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_DATATYPE)) {
			return createDataType6CreationTool();
		}
		if(toolId.equals(CREATEDURATIONOBSERVATION7CREATIONTOOL)) {
			return createDurationObservation7CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_ENUMERATION)) {
			return createEnumeration8CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_ENUMERATIONLITERAL)) {
			return createEnumerationliteral9CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_INTERFACE)) {
			return createInterface10CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_INSTANCESPECIFICATION)) {
			return createInstanceSpecification11CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_INFORMATIONITEM)) {
			return createInformationItem12CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_PRIMITIVETYPE)) {
			return createPrimitiveType13CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_MODEL)) {
			return createModel14CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_OPERATION)) {
			return createOperation15CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_OPERATIONTEMPLATEPARAMETER)) {
			return createOperationTemplateParameterCreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_PACKAGE)) {
			return createPackage17CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_PROPERTY)) {
			return createProperty18CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_RECEPTION)) {
			return createReception19CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_REDEFINABLETEMPLATESIGNATURE)) {
			return createRedefinableTemplateSignature20CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_SIGNAL)) {
			return createSignal21CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_SLOT)) {
			return createSlot22CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_TEMPLATEPARAMETER)) {
			return createTemplateParameter23CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_TEMPLATESIGNATURE)) {
			return createTemplateSignatureCreationTool();
		}
		if(toolId.equals(CREATETIMEOBSERVATION22CREATIONTOOL)) {
			return createTimeObservation22CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_CONNECTABLEELEMENTTEMPLATEPARAMETER)) {
			return createConnectableElementTemplateParameter26CreationTool();
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
		if(toolId.equals(CLAZZ_TOOL_CONTAINMENTLINK)) {
			return createContainmentLink5CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_DEPENDENCY)) {
			return createDependency6CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_DEPENDENCYBRANCH)) {
			return createDependencyBranch7CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_ELEMENTIMPORT)) {
			return createElementImport8CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_GENERALIZATION)) {
			return createGeneralization9CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_GENERALIZATIONSET)) {
			return createGeneralizationSet10CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_INFORMATIONFLOWLINK)) {
			return createInformationFlowLinkCreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_INSTANCESPECIFICATIONLINK)) {
			return createInstanceSpecificationLinkCreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_INTERFACEREALIZATION)) {
			return createInterfaceRealization13CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_LINK)) {
			return createLink14CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_PACKAGEIMPORT)) {
			return createPackageImport15CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_PACKAGEMERGE)) {
			return createPackageMerge16CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_PROFILEAPPLICATION)) {
			return createProfileApplication17CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_REALIZATION)) {
			return createRealization18CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_SUBSTITUTION)) {
			return createSubstitution19CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_USAGE)) {
			return createUsage20CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_TEMPLATEBINDING)) {
			return createTemplateBinding21CreationTool();
		}
		// default return: null
		return null;
	}

	/**
	 * @generated
	 */
	public Object getTemplate(String templateId) {
		// default return: null
		return null;
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
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createClassifierTemplateParameter2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ClassifierTemplateParameter_3031);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createComment5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Comment_3028);
		types.add(UMLElementTypes.Comment_2012);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createComponent4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Component_2002);
		types.add(UMLElementTypes.Component_3021);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConstraint5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Constraint_3029);
		types.add(UMLElementTypes.Constraint_2011);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDataType6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(UMLElementTypes.DataType_3027);
		types.add(UMLElementTypes.DataType_2010);
		types.add(UMLElementTypes.DataType_3044);
		types.add(UMLElementTypes.DataType_3045);
		types.add(UMLElementTypes.DataType_3043);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDurationObservation7CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DurationObservation_2095);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createEnumeration8CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(UMLElementTypes.Enumeration_3025);
		types.add(UMLElementTypes.Enumeration_2006);
		types.add(UMLElementTypes.Enumeration_3052);
		types.add(UMLElementTypes.Enumeration_3053);
		types.add(UMLElementTypes.Enumeration_3054);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createEnumerationliteral9CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.EnumerationLiteral_3017);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInterface10CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(UMLElementTypes.Interface_2004);
		types.add(UMLElementTypes.Interface_3023);
		types.add(UMLElementTypes.Interface_3036);
		types.add(UMLElementTypes.Interface_3037);
		types.add(UMLElementTypes.Interface_3038);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInstanceSpecification11CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.InstanceSpecification_2001);
		types.add(UMLElementTypes.InstanceSpecification_3020);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInformationItem12CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.InformationItem_2099);
		types.add(UMLElementTypes.InformationItem_3040);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPrimitiveType13CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(UMLElementTypes.PrimitiveType_3026);
		types.add(UMLElementTypes.PrimitiveType_2009);
		types.add(UMLElementTypes.PrimitiveType_3047);
		types.add(UMLElementTypes.PrimitiveType_3046);
		types.add(UMLElementTypes.PrimitiveType_3048);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createModel14CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Model_2005);
		types.add(UMLElementTypes.Model_3024);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createOperation15CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(UMLElementTypes.Operation_3003);
		types.add(UMLElementTypes.Operation_3007);
		types.add(UMLElementTypes.Operation_3013);
		types.add(UMLElementTypes.Operation_3019);
		types.add(UMLElementTypes.Operation_3042);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createOperationTemplateParameterCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.OperationTemplateParameter_3035);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPackage17CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Package_3009);
		types.add(UMLElementTypes.Package_2007);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createProperty18CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(6);
		types.add(UMLElementTypes.Property_3002);
		types.add(UMLElementTypes.Property_3005);
		types.add(UMLElementTypes.Property_3006);
		types.add(UMLElementTypes.Property_3012);
		types.add(UMLElementTypes.Property_3018);
		types.add(UMLElementTypes.Property_3041);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createReception19CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Reception_3011);
		types.add(UMLElementTypes.Reception_3039);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createRedefinableTemplateSignature20CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createSignal21CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(UMLElementTypes.Signal_2003);
		types.add(UMLElementTypes.Signal_3022);
		types.add(UMLElementTypes.Signal_3050);
		types.add(UMLElementTypes.Signal_3051);
		types.add(UMLElementTypes.Signal_3049);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createSlot22CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Slot_3030);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createTemplateParameter23CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TemplateParameter_3016);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createTemplateSignatureCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TemplateSignature_3033);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createTimeObservation22CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TimeObservation_2096);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConnectableElementTemplateParameter26CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ConnectableElementTemplateParameter_3034);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAbstraction1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Abstraction_4006);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAssociation2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Association_4001);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAssociationBranch3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Association_4019);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAssociationClass4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.AssociationClass_4017);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createContainmentLink5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Link_4023);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDependency6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Dependency_4008);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDependencyBranch7CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Dependency_4018);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createElementImport8CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ElementImport_4009);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createGeneralization9CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Generalization_4002);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createGeneralizationSet10CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.GeneralizationSet_4020);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInformationFlowLinkCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.InformationFlow_4026);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInstanceSpecificationLinkCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.InstanceSpecification_4021);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInterfaceRealization13CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.InterfaceRealization_4003);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLink14CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(UMLElementTypes.CommentAnnotatedElement_4013);
		types.add(UMLElementTypes.TimeObservationEvent_4024);
		types.add(UMLElementTypes.DurationObservationEvent_4025);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4014);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPackageImport15CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.PackageImport_4010);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPackageMerge16CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.PackageMerge_4011);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createProfileApplication17CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ProfileApplication_4012);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createRealization18CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Realization_4005);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createSubstitution19CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Substitution_4004);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createUsage20CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Usage_4007);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createTemplateBinding21CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TemplateBinding_4015);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}
}
