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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;

/**
 * @generated
 */
public class UMLPaletteFactory extends PaletteFactory.Adapter {

	/**
	 * @generated
	 */
	private final static String CREATELIFELINE1CREATIONTOOL = "createLifeline1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEACTIONEXECUTIONSPECIFICATION2CREATIONTOOL = "createActionExecutionSpecification2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEBEHAVIOREXECUTIONSPECIFICATION3CREATIONTOOL = "createBehaviorExecutionSpecification3CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEINTERACTIONUSE4CREATIONTOOL = "createInteractionUse4CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECOMBINEDFRAGMENT5CREATIONTOOL = "createCombinedFragment5CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEINTERACTIONOPERAND6CREATIONTOOL = "createInteractionOperand6CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEMESSAGESYNC1CREATIONTOOL = "createMessageSync1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEMESSAGEASYNC2CREATIONTOOL = "createMessageAsync2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEMESSAGEREPLY3CREATIONTOOL = "createMessageReply3CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEMESSAGECREATE4CREATIONTOOL = "createMessageCreate4CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEMESSAGEDELETE5CREATIONTOOL = "createMessageDelete5CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEMESSAGELOST6CREATIONTOOL = "createMessageLost6CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEMESSAGEFOUND7CREATIONTOOL = "createMessageFound7CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECOMMENT1CREATIONTOOL = "createComment1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECOMMENTLINK2CREATIONTOOL = "createCommentlink2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECONSTRAINT3CREATIONTOOL = "createConstraint3CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECONSTRAINTLINK4CREATIONTOOL = "createConstraintlink4CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public UMLPaletteFactory() {

	}

	/**
	 * @generated
	 */
	public Tool createTool(String toolId) {
		if(toolId.equals(CREATELIFELINE1CREATIONTOOL)) {
			return createLifeline1CreationTool();
		}
		if(toolId.equals(CREATEACTIONEXECUTIONSPECIFICATION2CREATIONTOOL)) {
			return createActionExecutionSpecification2CreationTool();
		}
		if(toolId.equals(CREATEBEHAVIOREXECUTIONSPECIFICATION3CREATIONTOOL)) {
			return createBehaviorExecutionSpecification3CreationTool();
		}
		if(toolId.equals(CREATEINTERACTIONUSE4CREATIONTOOL)) {
			return createInteractionUse4CreationTool();
		}
		if(toolId.equals(CREATECOMBINEDFRAGMENT5CREATIONTOOL)) {
			return createCombinedFragment5CreationTool();
		}
		if(toolId.equals(CREATEINTERACTIONOPERAND6CREATIONTOOL)) {
			return createInteractionOperand6CreationTool();
		}
		if(toolId.equals(CREATEMESSAGESYNC1CREATIONTOOL)) {
			return createMessageSync1CreationTool();
		}
		if(toolId.equals(CREATEMESSAGEASYNC2CREATIONTOOL)) {
			return createMessageAsync2CreationTool();
		}
		if(toolId.equals(CREATEMESSAGEREPLY3CREATIONTOOL)) {
			return createMessageReply3CreationTool();
		}
		if(toolId.equals(CREATEMESSAGECREATE4CREATIONTOOL)) {
			return createMessageCreate4CreationTool();
		}
		if(toolId.equals(CREATEMESSAGEDELETE5CREATIONTOOL)) {
			return createMessageDelete5CreationTool();
		}
		if(toolId.equals(CREATEMESSAGELOST6CREATIONTOOL)) {
			return createMessageLost6CreationTool();
		}
		if(toolId.equals(CREATEMESSAGEFOUND7CREATIONTOOL)) {
			return createMessageFound7CreationTool();
		}
		if(toolId.equals(CREATECOMMENT1CREATIONTOOL)) {
			return createComment1CreationTool();
		}
		if(toolId.equals(CREATECOMMENTLINK2CREATIONTOOL)) {
			return createCommentlink2CreationTool();
		}
		if(toolId.equals(CREATECONSTRAINT3CREATIONTOOL)) {
			return createConstraint3CreationTool();
		}
		if(toolId.equals(CREATECONSTRAINTLINK4CREATIONTOOL)) {
			return createConstraintlink4CreationTool();
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
	private Tool createLifeline1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Lifeline_3001);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createActionExecutionSpecification2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ActionExecutionSpecification_3006);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createBehaviorExecutionSpecification3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInteractionUse4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.InteractionUse_3002);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCombinedFragment5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		types.add(UMLElementTypes.CombinedFragment_3004);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInteractionOperand6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.InteractionOperand_3005);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createMessageSync1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Message_4003);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createMessageAsync2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Message_4004);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createMessageReply3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Message_4005);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createMessageCreate4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Message_4006);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createMessageDelete5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Message_4007);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createMessageLost6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Message_4008);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createMessageFound7CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Message_4009);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createComment1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Comment_3009);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCommentlink2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CommentAnnotatedElement_4010);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConstraint3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Constraint_3008);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConstraintlink4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4011);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}
}
