/*
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 * 
 * 
 */
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

	//RS: New Palette generation
	//Generates the ID for the tool elements
	//Generate the tool factory (if(ID) createtool...)
	/**
	 * @generated
	 */
	private final static String CREATEPACKAGE1CREATIONTOOL = "createPackage1CreationTool";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEPROFILE2CREATIONTOOL = "createProfile2CreationTool";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECOMMENT3CREATIONTOOL = "createComment3CreationTool";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECONSTRAINT4CREATIONTOOL = "createConstraint4CreationTool";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATESTEREOTYPE5CREATIONTOOL = "createStereotype5CreationTool";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECLASS6CREATIONTOOL = "createClass6CreationTool";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEIMPORTMETACLASS7CREATIONTOOL = "createImportMetaclass7CreationTool";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEENUMERATION8CREATIONTOOL = "createEnumeration8CreationTool";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEDATATYPE9CREATIONTOOL = "createDataType9CreationTool";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEPRIMITIVETYPE10CREATIONTOOL = "createPrimitiveType10CreationTool";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEPROPERTY11CREATIONTOOL = "createProperty11CreationTool";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEOPERATION12CREATIONTOOL = "createOperation12CreationTool";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEENUMERATIONLITERAL13CREATIONTOOL = "createEnumerationLiteral13CreationTool";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEEXTENSION1CREATIONTOOL = "createExtension1CreationTool";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEGENERALIZATION2CREATIONTOOL = "createGeneralization2CreationTool";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATELINK3CREATIONTOOL = "createLink3CreationTool";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEPROFILEAPPLICATION4CREATIONTOOL = "createProfileApplication4CreationTool";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEASSOCIATION5CREATIONTOOL = "createAssociation5CreationTool";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECONTEXTLINK6CREATIONTOOL = "createContextLink6CreationTool";//$NON-NLS-1$

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
		if(toolId.equals(CREATESTEREOTYPE5CREATIONTOOL)) {
			return createStereotype5CreationTool();
		}
		if(toolId.equals(CREATECLASS6CREATIONTOOL)) {
			return createClass6CreationTool();
		}
		if(toolId.equals(CREATEIMPORTMETACLASS7CREATIONTOOL)) {
			return createImportMetaclass7CreationTool();
		}
		if(toolId.equals(CREATEENUMERATION8CREATIONTOOL)) {
			return createEnumeration8CreationTool();
		}
		if(toolId.equals(CREATEDATATYPE9CREATIONTOOL)) {
			return createDataType9CreationTool();
		}
		if(toolId.equals(CREATEPRIMITIVETYPE10CREATIONTOOL)) {
			return createPrimitiveType10CreationTool();
		}
		if(toolId.equals(CREATEPROPERTY11CREATIONTOOL)) {
			return createProperty11CreationTool();
		}
		if(toolId.equals(CREATEOPERATION12CREATIONTOOL)) {
			return createOperation12CreationTool();
		}
		if(toolId.equals(CREATEENUMERATIONLITERAL13CREATIONTOOL)) {
			return createEnumerationLiteral13CreationTool();
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
	private Tool createStereotype5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Stereotype_1023);
		types.add(UMLElementTypes.Stereotype_1026);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createClass6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Class_3010);
		types.add(UMLElementTypes.Class_2008);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createImportMetaclass7CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Class_1031);
		types.add(UMLElementTypes.Class_3028);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createEnumeration8CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Enumeration_2006);
		types.add(UMLElementTypes.Enumeration_3025);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDataType9CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.DataType_2010);
		types.add(UMLElementTypes.DataType_3027);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPrimitiveType10CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.PrimitiveType_2009);
		types.add(UMLElementTypes.PrimitiveType_3026);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createProperty11CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Property_3002);
		types.add(UMLElementTypes.Property_3018);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createOperation12CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Operation_3019);
		types.add(UMLElementTypes.Operation_3020);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createEnumerationLiteral13CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.EnumerationLiteral_1037);
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
}
