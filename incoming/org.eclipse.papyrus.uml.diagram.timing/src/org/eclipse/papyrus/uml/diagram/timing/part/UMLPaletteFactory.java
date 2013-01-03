/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLElementTypes;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class UMLPaletteFactory extends PaletteFactory.Adapter {

	/**
	 * @generated
	 */
	private final static String CREATEINTERACTIONCREATIONTOOL = "createInteractionCreationTool"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private final static String CREATELIFELINECREATIONTOOL = "createLifelineCreationTool"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private final static String CREATESTATEDEFINITIONCREATIONTOOL = "createStateDefinitionCreationTool"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private final static String CREATETIMEOBSERVATIONCREATIONTOOL = "createTimeObservationCreationTool"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private final static String CREATETIMECONSTRAINTCREATIONTOOL = "createTimeConstraintCreationTool"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private final static String CREATEDURATIONOBSERVATIONCREATIONTOOL = "createDurationObservationCreationTool"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private final static String CREATEDURATIONCONSTRAINTCREATIONTOOL = "createDurationConstraintCreationTool"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private final static String CREATEOCCURRENCESPECIFICATIONCREATIONTOOL = "createOccurrenceSpecificationCreationTool"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private final static String CREATEDESTRUCTIONOCCURRENCESPECIFICATIONCREATIONTOOL = "createDestructionOccurrenceSpecificationCreationTool"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private final static String CREATEGATECREATIONTOOL = "createGateCreationTool"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private final static String CREATEGENERALORDERINGCREATIONTOOL = "createGeneralOrderingCreationTool"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private final static String CREATEMESSAGESYNCCREATIONTOOL = "createMessageSyncCreationTool"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private final static String CREATEMESSAGEASYNCCREATIONTOOL = "createMessageAsyncCreationTool"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private final static String CREATEMESSAGEREPLYCREATIONTOOL = "createMessageReplyCreationTool"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private final static String CREATECREATEMESSAGECREATIONTOOL = "createCreateMessageCreationTool"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private final static String CREATEDELETEMESSAGECREATIONTOOL = "createDeleteMessageCreationTool"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private final static String CREATELOSTMESSAGECREATIONTOOL = "createLostMessageCreationTool"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private final static String CREATEFOUNDMESSAGECREATIONTOOL = "createFoundMessageCreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public UMLPaletteFactory() {

	}

	/**
	 * @generated
	 */
	@Override
	public Tool createTool(final String toolId) {
		if (toolId.equals(CREATEINTERACTIONCREATIONTOOL)) {
			return createInteractionCreationTool();
		}
		if (toolId.equals(CREATELIFELINECREATIONTOOL)) {
			return createLifelineCreationTool();
		}
		if (toolId.equals(CREATESTATEDEFINITIONCREATIONTOOL)) {
			return createStateDefinitionCreationTool();
		}
		if (toolId.equals(CREATETIMEOBSERVATIONCREATIONTOOL)) {
			return createTimeObservationCreationTool();
		}
		if (toolId.equals(CREATETIMECONSTRAINTCREATIONTOOL)) {
			return createTimeConstraintCreationTool();
		}
		if (toolId.equals(CREATEDURATIONOBSERVATIONCREATIONTOOL)) {
			return createDurationObservationCreationTool();
		}
		if (toolId.equals(CREATEDURATIONCONSTRAINTCREATIONTOOL)) {
			return createDurationConstraintCreationTool();
		}
		if (toolId.equals(CREATEOCCURRENCESPECIFICATIONCREATIONTOOL)) {
			return createOccurrenceSpecificationCreationTool();
		}
		if (toolId.equals(CREATEDESTRUCTIONOCCURRENCESPECIFICATIONCREATIONTOOL)) {
			return createDestructionOccurrenceSpecificationCreationTool();
		}
		if (toolId.equals(CREATEGATECREATIONTOOL)) {
			return createGateCreationTool();
		}
		if (toolId.equals(CREATEGENERALORDERINGCREATIONTOOL)) {
			return createGeneralOrderingCreationTool();
		}
		if (toolId.equals(CREATEMESSAGESYNCCREATIONTOOL)) {
			return createMessageSyncCreationTool();
		}
		if (toolId.equals(CREATEMESSAGEASYNCCREATIONTOOL)) {
			return createMessageAsyncCreationTool();
		}
		if (toolId.equals(CREATEMESSAGEREPLYCREATIONTOOL)) {
			return createMessageReplyCreationTool();
		}
		if (toolId.equals(CREATECREATEMESSAGECREATIONTOOL)) {
			return createCreateMessageCreationTool();
		}
		if (toolId.equals(CREATEDELETEMESSAGECREATIONTOOL)) {
			return createDeleteMessageCreationTool();
		}
		if (toolId.equals(CREATELOSTMESSAGECREATIONTOOL)) {
			return createLostMessageCreationTool();
		}
		if (toolId.equals(CREATEFOUNDMESSAGECREATIONTOOL)) {
			return createFoundMessageCreationTool();
		}

		// default return: null
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	public Object getTemplate(final String templateId) {

		// default return: null
		return null;
	}

	/**
	 * @generated
	 */
	private Tool createInteractionCreationTool() {
		final List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Interaction_2);

		final Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLifelineCreationTool() {
		final List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Lifeline_19);
		types.add(UMLElementTypes.Lifeline_20);

		final Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createStateDefinitionCreationTool() {
		final List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Node_9);

		final Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createTimeObservationCreationTool() {
		final List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TimeObservation_16);

		final Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createTimeConstraintCreationTool() {
		final List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TimeConstraint_15);

		final Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDurationObservationCreationTool() {
		final List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DurationObservation_17);

		final Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDurationConstraintCreationTool() {
		final List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DurationConstraint_18);

		final Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createOccurrenceSpecificationCreationTool() {
		final List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.OccurrenceSpecification_12);

		final Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDestructionOccurrenceSpecificationCreationTool() {
		final List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DestructionOccurrenceSpecification_27);

		final Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createGateCreationTool() {
		final List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Gate_69);

		final Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createGeneralOrderingCreationTool() {
		final List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.GeneralOrdering_67);

		final Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createMessageSyncCreationTool() {
		final List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Message_3);

		final Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createMessageAsyncCreationTool() {
		final List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Message_4);

		final Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createMessageReplyCreationTool() {
		final List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Message_41);

		final Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCreateMessageCreationTool() {
		final List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Message_44);

		final Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDeleteMessageCreationTool() {
		final List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Message_47);

		final Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLostMessageCreationTool() {
		final List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Message_50);

		final Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createFoundMessageCreationTool() {
		final List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Message_53);

		final Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

}
