package org.eclipse.papyrus.diagram.statemachine.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;

/**
 * @generated
 */
public class UMLPaletteFactory extends PaletteFactory.Adapter {

	/**
	 * @generated
	 */
	private final static String CREATESTATEMACHINECREATIONTOOL = "createStateMachineCreationTool"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private final static String CREATEREGIONCREATIONTOOL = "createRegionCreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATESTATE3CREATIONTOOL = "createState3CreationTool"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private final static String CREATEFINALSTATE4CREATIONTOOL = "createFinalState4CreationTool"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private final static String CREATEPSEUDOSTATE1CREATIONTOOL = "createPseudoState1CreationTool"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private final static String CREATETRANSITION1CREATIONTOOL = "createTransition1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public UMLPaletteFactory() {

	}

	/**
	 * @generated
	 */
	public Tool createTool(String toolId) {
		if (toolId.equals(CREATESTATEMACHINECREATIONTOOL)) {
			return createStateMachineCreationTool();
		}
		if (toolId.equals(CREATEREGIONCREATIONTOOL)) {
			return createRegionCreationTool();
		}
		if (toolId.equals(CREATESTATE3CREATIONTOOL)) {
			return createState3CreationTool();
		}
		if (toolId.equals(CREATEFINALSTATE4CREATIONTOOL)) {
			return createFinalState4CreationTool();
		}
		if (toolId.equals(CREATEPSEUDOSTATE1CREATIONTOOL)) {
			return createPseudoState1CreationTool();
		}
		if (toolId.equals(CREATETRANSITION1CREATIONTOOL)) {
			return createTransition1CreationTool();
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
	private Tool createStateMachineCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.StateMachine_2000);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createRegionCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Region_3000);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createState3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.State_3006);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createFinalState4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.FinalState_3005);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPseudoState1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Pseudostate_3004);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createTransition1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Transition_5000);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

}
