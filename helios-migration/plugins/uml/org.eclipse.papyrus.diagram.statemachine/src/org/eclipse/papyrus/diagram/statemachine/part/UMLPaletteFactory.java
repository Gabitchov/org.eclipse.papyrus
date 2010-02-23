package org.eclipse.papyrus.diagram.statemachine.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
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

}
