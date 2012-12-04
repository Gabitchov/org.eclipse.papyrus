/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.composite.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes;

/**
 * @generated
 */
public class UMLPaletteFactory extends PaletteFactory.Adapter {

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_CLASS = "composite.tool.class"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_PROPERTY = "composite.tool.property"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_PORT = "composite.tool.port"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_COLLABORATION = "composite.tool.collaboration"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_COLLABORATIONROLE = "composite.tool.collaborationrole"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_COLLABORATIONUSE = "composite.tool.collaborationuse"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_COMMENT = "composite.tool.comment"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_CONSTRAINT = "composite.tool.constraint"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_TIMEOBSERVATION = "composite.tool.timeobservation"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_DURATIONOBSERVATION = "composite.tool.durationobservation"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_INFORMATIONITEM = "composite.tool.informationitem"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_PARAMETER = "composite.tool.parameter"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_ACTIVITY = "composite.tool.activity"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_INTERACTION = "composite.tool.interaction"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_PROTOCOLSTATEMACHINE = "composite.tool.protocolstatemachine"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_STATEMACHINE = "composite.tool.statemachine"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_FUNCTIONBEHAVIOR = "composite.tool.functionbehavior"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_OPAQUEBEHAVIOR = "composite.tool.opaquebehavior"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_LINK = "composite.tool.link"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_CONNECTOR = "composite.tool.connector"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_ROLEBINDING = "composite.tool.rolebinding"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_GENERALIZATION = "composite.tool.generalization"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_REALIZATION = "composite.tool.realization"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_SUBSTITUTION = "composite.tool.substitution"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_ABSTRACTION = "composite.tool.abstraction"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_USAGE = "composite.tool.usage"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_DEPENDENCY = "composite.tool.dependency"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_REPRESENTATION = "composite.tool.representation"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_INFORMATIONFLOW = "composite.tool.informationflow"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public UMLPaletteFactory() {
	}

	/**
	 * @generated
	 */
	public Tool createTool(String toolId) {
		if(toolId.equals(COMPOSITE_TOOL_CLASS)) {
			return createClassCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_PROPERTY)) {
			return createPropertyCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_PORT)) {
			return createPortCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_COLLABORATION)) {
			return createCollaborationCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_COLLABORATIONROLE)) {
			return createCollaborationRoleCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_COLLABORATIONUSE)) {
			return createCollaborationUseCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_COMMENT)) {
			return createCommentCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_CONSTRAINT)) {
			return createConstraintCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_TIMEOBSERVATION)) {
			return createTimeObservationCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_DURATIONOBSERVATION)) {
			return createDurationObservationCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_INFORMATIONITEM)) {
			return createInformationItemCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_PARAMETER)) {
			return createParameterCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_ACTIVITY)) {
			return createActivityCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_INTERACTION)) {
			return createInteractionCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_PROTOCOLSTATEMACHINE)) {
			return createProtocolStateMachineCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_STATEMACHINE)) {
			return createStateMachineCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_FUNCTIONBEHAVIOR)) {
			return createFunctionBehaviorCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_OPAQUEBEHAVIOR)) {
			return createOpaqueBehaviorCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_LINK)) {
			return createLinkCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_CONNECTOR)) {
			return createConnectorCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_ROLEBINDING)) {
			return createRoleBindingCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_GENERALIZATION)) {
			return createGeneralizationCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_REALIZATION)) {
			return createRealizationCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_SUBSTITUTION)) {
			return createSubstitutionCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_ABSTRACTION)) {
			return createAbstractionCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_USAGE)) {
			return createUsageCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_DEPENDENCY)) {
			return createDependencyCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_REPRESENTATION)) {
			return createRepresentationCreationTool();
		}
		if(toolId.equals(COMPOSITE_TOOL_INFORMATIONFLOW)) {
			return createInformationFlowCreationTool();
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
	private Tool createClassCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Class_2073);
		types.add(UMLElementTypes.Class_3085);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPropertyCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Property_3070);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPortCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Port_3069);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCollaborationCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Collaboration_3086);
		types.add(UMLElementTypes.Collaboration_2075);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCollaborationRoleCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ConnectableElement_3115);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCollaborationUseCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CollaborationUse_3071);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCommentCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Comment_3097);
		types.add(UMLElementTypes.Comment_2109);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConstraintCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Constraint_2114);
		types.add(UMLElementTypes.Constraint_3120);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createTimeObservationCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TimeObservation_2094);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDurationObservationCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DurationObservation_2093);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInformationItemCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.InformationItem_3094);
		types.add(UMLElementTypes.InformationItem_2080);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createParameterCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Parameter_3088);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createActivityCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Activity_3072);
		types.add(UMLElementTypes.Activity_2060);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInteractionCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Interaction_3073);
		types.add(UMLElementTypes.Interaction_2061);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createProtocolStateMachineCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.ProtocolStateMachine_3074);
		types.add(UMLElementTypes.ProtocolStateMachine_2062);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createStateMachineCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.StateMachine_3075);
		types.add(UMLElementTypes.StateMachine_2063);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createFunctionBehaviorCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.FunctionBehavior_3076);
		types.add(UMLElementTypes.FunctionBehavior_2064);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createOpaqueBehaviorCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.OpaqueBehavior_3077);
		types.add(UMLElementTypes.OpaqueBehavior_2065);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLinkCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4003);
		types.add(UMLElementTypes.TimeObservationEvent_4018);
		types.add(UMLElementTypes.DurationObservationEvent_4019);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConnectorCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Connector_4013);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createRoleBindingCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Dependency_4017);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createGeneralizationCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Generalization_4015);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createRealizationCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Realization_4006);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createSubstitutionCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Substitution_4011);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAbstractionCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Abstraction_4007);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createUsageCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Usage_4008);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDependencyCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Dependency_4010);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createRepresentationCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.InformationItemRepresented_4020);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInformationFlowCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.InformationFlow_4021);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}
}
