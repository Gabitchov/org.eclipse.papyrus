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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.diagram.composite.providers.UMLElementTypes;

/**
 * @generated
 */
public class UMLPaletteFactory extends PaletteFactory.Adapter {

	/**
	 * @generated
	 */
	private final static String CREATECLASS1CREATIONTOOL = "createClass1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEPROPERTY2CREATIONTOOL = "createProperty2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEPORT3CREATIONTOOL = "createPort3CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECOLLABORATION4CREATIONTOOL = "createCollaboration4CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECOLLABORATIONROLE5CREATIONTOOL = "createCollaborationRole5CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECOLLABORATIONUSE6CREATIONTOOL = "createCollaborationUse6CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECOMMENT7CREATIONTOOL = "createComment7CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECONTRAINT8CREATIONTOOL = "createContraint8CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATELINK1CREATIONTOOL = "createLink1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECONNECTOR2CREATIONTOOL = "createConnector2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEROLEBINDING3CREATIONTOOL = "createRoleBinding3CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEGENERALIZATION4CREATIONTOOL = "createGeneralization4CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEREALIZATION5CREATIONTOOL = "createRealization5CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATESUBSTITUTION6CREATIONTOOL = "createSubstitution6CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEABSTRACTION7CREATIONTOOL = "createAbstraction7CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEUSAGE8CREATIONTOOL = "createUsage8CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEDEPENDENCY9CREATIONTOOL = "createDependency9CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public UMLPaletteFactory() {

	}

	/**
	 * @generated
	 */
	public Tool createTool(String toolId) {
		if (toolId.equals(CREATECLASS1CREATIONTOOL)) {
			return createClass1CreationTool();
		}
		if (toolId.equals(CREATEPROPERTY2CREATIONTOOL)) {
			return createProperty2CreationTool();
		}
		if (toolId.equals(CREATEPORT3CREATIONTOOL)) {
			return createPort3CreationTool();
		}
		if (toolId.equals(CREATECOLLABORATION4CREATIONTOOL)) {
			return createCollaboration4CreationTool();
		}
		if (toolId.equals(CREATECOLLABORATIONROLE5CREATIONTOOL)) {
			return createCollaborationRole5CreationTool();
		}
		if (toolId.equals(CREATECOLLABORATIONUSE6CREATIONTOOL)) {
			return createCollaborationUse6CreationTool();
		}
		if (toolId.equals(CREATECOMMENT7CREATIONTOOL)) {
			return createComment7CreationTool();
		}
		if (toolId.equals(CREATECONTRAINT8CREATIONTOOL)) {
			return createContraint8CreationTool();
		}
		if (toolId.equals(CREATELINK1CREATIONTOOL)) {
			return createLink1CreationTool();
		}
		if (toolId.equals(CREATECONNECTOR2CREATIONTOOL)) {
			return createConnector2CreationTool();
		}
		if (toolId.equals(CREATEROLEBINDING3CREATIONTOOL)) {
			return createRoleBinding3CreationTool();
		}
		if (toolId.equals(CREATEGENERALIZATION4CREATIONTOOL)) {
			return createGeneralization4CreationTool();
		}
		if (toolId.equals(CREATEREALIZATION5CREATIONTOOL)) {
			return createRealization5CreationTool();
		}
		if (toolId.equals(CREATESUBSTITUTION6CREATIONTOOL)) {
			return createSubstitution6CreationTool();
		}
		if (toolId.equals(CREATEABSTRACTION7CREATIONTOOL)) {
			return createAbstraction7CreationTool();
		}
		if (toolId.equals(CREATEUSAGE8CREATIONTOOL)) {
			return createUsage8CreationTool();
		}
		if (toolId.equals(CREATEDEPENDENCY9CREATIONTOOL)) {
			return createDependency9CreationTool();
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
	private Tool createClass1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Class_2073);
		types.add(UMLElementTypes.Class_3085);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createProperty2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Property_3070);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPort3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Port_3069);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCollaboration4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Collaboration_3086);
		types.add(UMLElementTypes.Collaboration_2075);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCollaborationRole5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ConnectableElement_3115);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCollaborationUse6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CollaborationUse_3071);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createComment7CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Comment_3097);
		types.add(UMLElementTypes.Comment_2109);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createContraint8CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Constraint_2114);
		Tool tool = new UnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLink1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4003);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConnector2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Connector_4013);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createRoleBinding3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Dependency_4017);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createGeneralization4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Generalization_4015);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createRealization5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Realization_4006);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createSubstitution6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Substitution_4011);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAbstraction7CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Abstraction_4007);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createUsage8CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Usage_4008);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDependency9CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Dependency_4010);
		Tool tool = new UnspecifiedTypeConnectionTool(types);
		return tool;
	}

}
