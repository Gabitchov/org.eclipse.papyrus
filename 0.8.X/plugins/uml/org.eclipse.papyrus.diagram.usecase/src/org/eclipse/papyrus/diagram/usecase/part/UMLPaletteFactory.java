/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.diagram.usecase.providers.UMLElementTypes;

/**
 * @generated
 */
public class UMLPaletteFactory extends PaletteFactory.Adapter {

	/**
	 * @generated
	 */
	private final static String USECASE_TOOL_PACKAGE = "usecase.tool.package"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String USECASE_TOOL_SUBJECT = "usecase.tool.subject"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String USECASE_TOOL_ACTOR = "usecase.tool.actor"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String USECASE_TOOL_USECASE = "usecase.tool.usecase"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String USECASE_TOOL_CONSTRAINT = "usecase.tool.constraint"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String USECASE_TOOL_COMMENT = "usecase.tool.comment"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String USECASE_TOOL_EXTENSIONPOINT = "usecase.tool.extensionpoint"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String USECASE_TOOL_ASSOCIATION = "usecase.tool.association"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String USECASE_TOOL_GENERALIZATION = "usecase.tool.generalization"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String USECASE_TOOL_DEPENDENCY = "usecase.tool.dependency"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String USECASE_TOOL_ABSTRACTION = "usecase.tool.abstraction"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String USECASE_TOOL_REALIZATION = "usecase.tool.realization"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String USECASE_TOOL_USAGE = "usecase.tool.usage"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String USECASE_TOOL_PACKAGEMERGE = "usecase.tool.packagemerge"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String USECASE_TOOL_PACKAGEIMPORT = "usecase.tool.packageimport"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String USECASE_TOOL_INCLUDE = "usecase.tool.include"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String USECASE_TOOL_EXTEND = "usecase.tool.extend"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String USECASE_TOOL_CONSTRAINTLINK = "usecase.tool.constraintlink"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String USECASE_TOOL_COMMENTLINK = "usecase.tool.commentlink"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public UMLPaletteFactory() {

	}

	/**
	 * @generated
	 */
	public Tool createTool(String toolId) {
		if(toolId.equals(USECASE_TOOL_PACKAGE)) {
			return createPackage1CreationTool();
		}
		if(toolId.equals(USECASE_TOOL_SUBJECT)) {
			return createSubject2CreationTool();
		}
		if(toolId.equals(USECASE_TOOL_ACTOR)) {
			return createActor3CreationTool();
		}
		if(toolId.equals(USECASE_TOOL_USECASE)) {
			return createUseCase4CreationTool();
		}
		if(toolId.equals(USECASE_TOOL_CONSTRAINT)) {
			return createConstraint5CreationTool();
		}
		if(toolId.equals(USECASE_TOOL_COMMENT)) {
			return createComment6CreationTool();
		}
		if(toolId.equals(USECASE_TOOL_EXTENSIONPOINT)) {
			return createExtensionPoint1CreationTool();
		}
		if(toolId.equals(USECASE_TOOL_ASSOCIATION)) {
			return createAssociation1CreationTool();
		}
		if(toolId.equals(USECASE_TOOL_GENERALIZATION)) {
			return createGeneralization2CreationTool();
		}
		if(toolId.equals(USECASE_TOOL_DEPENDENCY)) {
			return createDependency3CreationTool();
		}
		if(toolId.equals(USECASE_TOOL_ABSTRACTION)) {
			return createAbstraction4CreationTool();
		}
		if(toolId.equals(USECASE_TOOL_REALIZATION)) {
			return createRealization5CreationTool();
		}
		if(toolId.equals(USECASE_TOOL_USAGE)) {
			return createUsage6CreationTool();
		}
		if(toolId.equals(USECASE_TOOL_PACKAGEMERGE)) {
			return createPackageMerge7CreationTool();
		}
		if(toolId.equals(USECASE_TOOL_PACKAGEIMPORT)) {
			return createPackageImport8CreationTool();
		}
		if(toolId.equals(USECASE_TOOL_INCLUDE)) {
			return createInclude9CreationTool();
		}
		if(toolId.equals(USECASE_TOOL_EXTEND)) {
			return createExtend10CreationTool();
		}
		if(toolId.equals(USECASE_TOOL_CONSTRAINTLINK)) {
			return createConstrainedElement11CreationTool();
		}
		if(toolId.equals(USECASE_TOOL_COMMENTLINK)) {
			return createCommentlink12CreationTool();
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
	private Tool createPackage1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Package_3014);
		types.add(UMLElementTypes.Package_2016);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createSubject2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(UMLElementTypes.Component_2015);
		types.add(UMLElementTypes.Component_3016);
		types.add(UMLElementTypes.Component_3013);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createActor3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(UMLElementTypes.Actor_2011);
		types.add(UMLElementTypes.Actor_3018);
		types.add(UMLElementTypes.Actor_3011);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createUseCase4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(UMLElementTypes.UseCase_2013);
		types.add(UMLElementTypes.UseCase_3009);
		types.add(UMLElementTypes.UseCase_3012);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConstraint5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(UMLElementTypes.Constraint_3017);
		types.add(UMLElementTypes.Constraint_3010);
		types.add(UMLElementTypes.Constraint_2017);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createComment6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Comment_3015);
		types.add(UMLElementTypes.Comment_2018);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createExtensionPoint1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.ExtensionPoint_3007);
		types.add(UMLElementTypes.ExtensionPoint_3008);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAssociation1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Association_4011);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createGeneralization2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Generalization_4010);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDependency3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Dependency_4013);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAbstraction4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Abstraction_4015);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createRealization5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Realization_4017);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createUsage6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Usage_4016);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPackageMerge7CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.PackageMerge_4018);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPackageImport8CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.PackageImport_4019);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInclude9CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Include_4008);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createExtend10CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Extend_4009);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConstrainedElement11CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4012);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCommentlink12CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CommentAnnotatedElement_4014);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

}
