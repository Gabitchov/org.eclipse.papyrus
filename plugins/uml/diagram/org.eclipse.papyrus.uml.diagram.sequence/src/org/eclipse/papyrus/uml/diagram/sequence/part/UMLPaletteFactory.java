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
package org.eclipse.papyrus.uml.diagram.sequence.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;

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
	private final static String CREATECONTINUATION7CREATIONTOOL = "createContinuation7CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATESTATEINVARIANT8CREATIONTOOL = "createStateInvariant8CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECOMMENT9CREATIONTOOL = "createComment9CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECONSTRAINT10CREATIONTOOL = "createConstraint10CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECOREGION11CREATIONTOOL = "createCoRegion11CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEDURATIONOBSERVATION12CREATIONTOOL = "createDurationObservation12CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATETIMECONSTRAINT13CREATIONTOOL = "createTimeConstraint13CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATETIMEOBSERVATION14CREATIONTOOL = "createTimeObservation14CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEDURATIONCONSTRAINT15CREATIONTOOL = "createDurationConstraint15CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEDESTRUCTIONEVENT16CREATIONTOOL = "createDestructionEvent16CreationTool"; //$NON-NLS-1$

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
	private final static String CREATEGENERALORDERING8CREATIONTOOL = "createGeneralOrdering8CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECOMMENTLINK9CREATIONTOOL = "createCommentlink9CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECONSTRAINTLINK10CREATIONTOOL = "createConstraintlink10CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECONTEXTLINK11CREATIONTOOL = "createContextLink11CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public UMLPaletteFactory() {
	}

	/**
	 * @generated
	 */
	@Override
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
		if(toolId.equals(CREATECONTINUATION7CREATIONTOOL)) {
			return createContinuation7CreationTool();
		}
		if(toolId.equals(CREATESTATEINVARIANT8CREATIONTOOL)) {
			return createStateInvariant8CreationTool();
		}
		if(toolId.equals(CREATECOMMENT9CREATIONTOOL)) {
			return createComment9CreationTool();
		}
		if(toolId.equals(CREATECONSTRAINT10CREATIONTOOL)) {
			return createConstraint10CreationTool();
		}
		if(toolId.equals(CREATECOREGION11CREATIONTOOL)) {
			return createCoRegion11CreationTool();
		}
		if(toolId.equals(CREATEDURATIONOBSERVATION12CREATIONTOOL)) {
			return createDurationObservation12CreationTool();
		}
		if(toolId.equals(CREATETIMECONSTRAINT13CREATIONTOOL)) {
			return createTimeConstraint13CreationTool();
		}
		if(toolId.equals(CREATETIMEOBSERVATION14CREATIONTOOL)) {
			return createTimeObservation14CreationTool();
		}
		if(toolId.equals(CREATEDURATIONCONSTRAINT15CREATIONTOOL)) {
			return createDurationConstraint15CreationTool();
		}
		if(toolId.equals(CREATEDESTRUCTIONEVENT16CREATIONTOOL)) {
			return createDestructionEvent16CreationTool();
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
		if(toolId.equals(CREATEGENERALORDERING8CREATIONTOOL)) {
			return createGeneralOrdering8CreationTool();
		}
		if(toolId.equals(CREATECOMMENTLINK9CREATIONTOOL)) {
			return createCommentlink9CreationTool();
		}
		if(toolId.equals(CREATECONSTRAINTLINK10CREATIONTOOL)) {
			return createConstraintlink10CreationTool();
		}
		if(toolId.equals(CREATECONTEXTLINK11CREATIONTOOL)) {
			return createContextLink11CreationTool();
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
	private Tool createContinuation7CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Continuation_3016);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createStateInvariant8CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.StateInvariant_3017);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createComment9CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Comment_3009);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConstraint10CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Constraint_3008);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCoRegion11CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CombinedFragment_3018);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDurationObservation12CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DurationObservation_3024);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createTimeConstraint13CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TimeConstraint_3019);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createTimeObservation14CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TimeObservation_3020);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDurationConstraint15CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.DurationConstraint_3021);
		types.add(UMLElementTypes.DurationConstraint_3023);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDestructionEvent16CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
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
	private Tool createGeneralOrdering8CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.GeneralOrdering_4012);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCommentlink9CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConstraintlink10CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createContextLink11CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ConstraintContext_8500);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}
}
