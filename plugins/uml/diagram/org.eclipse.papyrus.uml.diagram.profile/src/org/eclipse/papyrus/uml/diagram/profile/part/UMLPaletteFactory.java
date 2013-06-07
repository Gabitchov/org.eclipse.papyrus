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
package org.eclipse.papyrus.uml.diagram.profile.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.uml.diagram.profile.providers.UMLElementTypes;

/**
 * @generated
 */
public class UMLPaletteFactory extends PaletteFactory.Adapter {

	/**
	 * @generated
	 */
	private final static String CREATEPACKAGE1CREATIONTOOL = "createPackage1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEPROFILE2CREATIONTOOL = "createProfile2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECOMMENT3CREATIONTOOL = "createComment3CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECONSTRAINT4CREATIONTOOL = "createConstraint4CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATESTEREOTYPE1CREATIONTOOL = "createStereotype1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEIMPORTMETACLASS2CREATIONTOOL = "createImportMetaclass2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEENUMERATION3CREATIONTOOL = "createEnumeration3CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEDATATYPE4CREATIONTOOL = "createDataType4CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEPRIMITIVETYPE5CREATIONTOOL = "createPrimitiveType5CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEEXTENSION1CREATIONTOOL = "createExtension1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEGENERALIZATION2CREATIONTOOL = "createGeneralization2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATELINK3CREATIONTOOL = "createLink3CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEPROFILEAPPLICATION4CREATIONTOOL = "createProfileApplication4CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEASSOCIATION5CREATIONTOOL = "createAssociation5CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECONTEXTLINK6CREATIONTOOL = "createContextLink6CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEPROPERTY1CREATIONTOOL = "createProperty1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEOPERATION2CREATIONTOOL = "createOperation2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEENUMERATIONLITERAL3CREATIONTOOL = "createEnumerationLiteral3CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public UMLPaletteFactory() {
	}

	/**
	 * @generated
	 */
	public Tool createTool(String toolId) {
		if(toolId.equals(CREATEPACKAGE1CREATIONTOOL)) {
			return createPackage1CreationTool();
		}
		if(toolId.equals(CREATEPROFILE2CREATIONTOOL)) {
			return createProfile2CreationTool();
		}
		if(toolId.equals(CREATECOMMENT3CREATIONTOOL)) {
			return createComment3CreationTool();
		}
		if(toolId.equals(CREATECONSTRAINT4CREATIONTOOL)) {
			return createConstraint4CreationTool();
		}
		if(toolId.equals(CREATESTEREOTYPE1CREATIONTOOL)) {
			return createStereotype1CreationTool();
		}
		if(toolId.equals(CREATEIMPORTMETACLASS2CREATIONTOOL)) {
			return createImportMetaclass2CreationTool();
		}
		if(toolId.equals(CREATEENUMERATION3CREATIONTOOL)) {
			return createEnumeration3CreationTool();
		}
		if(toolId.equals(CREATEDATATYPE4CREATIONTOOL)) {
			return createDataType4CreationTool();
		}
		if(toolId.equals(CREATEPRIMITIVETYPE5CREATIONTOOL)) {
			return createPrimitiveType5CreationTool();
		}
		if(toolId.equals(CREATEEXTENSION1CREATIONTOOL)) {
			return createExtension1CreationTool();
		}
		if(toolId.equals(CREATEGENERALIZATION2CREATIONTOOL)) {
			return createGeneralization2CreationTool();
		}
		if(toolId.equals(CREATELINK3CREATIONTOOL)) {
			return createLink3CreationTool();
		}
		if(toolId.equals(CREATEPROFILEAPPLICATION4CREATIONTOOL)) {
			return createProfileApplication4CreationTool();
		}
		if(toolId.equals(CREATEASSOCIATION5CREATIONTOOL)) {
			return createAssociation5CreationTool();
		}
		if(toolId.equals(CREATECONTEXTLINK6CREATIONTOOL)) {
			return createContextLink6CreationTool();
		}
		if(toolId.equals(CREATEPROPERTY1CREATIONTOOL)) {
			return createProperty1CreationTool();
		}
		if(toolId.equals(CREATEOPERATION2CREATIONTOOL)) {
			return createOperation2CreationTool();
		}
		if(toolId.equals(CREATEENUMERATIONLITERAL3CREATIONTOOL)) {
			return createEnumerationLiteral3CreationTool();
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
	private Tool createPackage1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Package_2007);
		types.add(UMLElementTypes.Package_1012);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createProfile2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Profile_1030);
		types.add(UMLElementTypes.Profile_1024);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createComment3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Comment_1002);
		types.add(UMLElementTypes.Comment_1007);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConstraint4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Constraint_1014);
		types.add(UMLElementTypes.Constraint_1028);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createStereotype1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Stereotype_1023);
		types.add(UMLElementTypes.Stereotype_1026);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createImportMetaclass2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Class_1031);
		types.add(UMLElementTypes.Class_3028);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createEnumeration3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Enumeration_2006);
		types.add(UMLElementTypes.Enumeration_3025);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDataType4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.DataType_2010);
		types.add(UMLElementTypes.DataType_3027);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPrimitiveType5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.PrimitiveType_2009);
		types.add(UMLElementTypes.PrimitiveType_3026);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createExtension1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Extension_1013);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createGeneralization2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Generalization_4002);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLink3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.CommentAnnotatedElement_1022);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4014);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createProfileApplication4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ProfileApplication_1045);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAssociation5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Association_4001);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createContextLink6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ConstraintContext_8500);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createProperty1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Property_3002);
		types.add(UMLElementTypes.Property_3018);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createOperation2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Operation_3019);
		types.add(UMLElementTypes.Operation_3020);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createEnumerationLiteral3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.EnumerationLiteral_1037);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}
}
