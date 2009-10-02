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
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;

/**
 * @generated
 */
public class UMLPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createObjects1Group());
		paletteRoot.add(createMessage2Group());
	}

	/**
	 * Creates "Objects" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createObjects1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Objects1Group_title);
		paletteContainer.setId("createObjects1Group"); //$NON-NLS-1$
		paletteContainer.add(createLifeline1CreationTool());
		paletteContainer.add(createExecutionAction2CreationTool());
		paletteContainer.add(createExecutionBehaviour3CreationTool());
		paletteContainer.add(createInteractionUse4CreationTool());
		paletteContainer.add(createCombinedFragment5CreationTool());
		paletteContainer.add(createInteractionOperand6CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Message" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createMessage2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Message2Group_title);
		paletteContainer.setId("createMessage2Group"); //$NON-NLS-1$
		paletteContainer.add(createMessageSync1CreationTool());
		paletteContainer.add(createMessageAsync2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLifeline1CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Lifeline_3001);
		NodeToolEntry entry = new NodeToolEntry(Messages.Lifeline1CreationTool_title,
				Messages.Lifeline1CreationTool_desc, types);
		entry.setId("createLifeline1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Lifeline_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExecutionAction2CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		NodeToolEntry entry = new NodeToolEntry(Messages.ExecutionAction2CreationTool_title,
				Messages.ExecutionAction2CreationTool_desc, types);
		entry.setId("createExecutionAction2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ActionExecutionSpecification_3006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExecutionBehaviour3CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		NodeToolEntry entry = new NodeToolEntry(Messages.ExecutionBehaviour3CreationTool_title,
				Messages.ExecutionBehaviour3CreationTool_desc, types);
		entry.setId("createExecutionBehaviour3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.BehaviorExecutionSpecification_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInteractionUse4CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.InteractionUse_3002);
		NodeToolEntry entry = new NodeToolEntry(Messages.InteractionUse4CreationTool_title,
				Messages.InteractionUse4CreationTool_desc, types);
		entry.setId("createInteractionUse4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.InteractionUse_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCombinedFragment5CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.CombinedFragment_3004);
		NodeToolEntry entry = new NodeToolEntry(Messages.CombinedFragment5CreationTool_title,
				Messages.CombinedFragment5CreationTool_desc, types);
		entry.setId("createCombinedFragment5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.CombinedFragment_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInteractionOperand6CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.InteractionOperand_3005);
		NodeToolEntry entry = new NodeToolEntry(Messages.InteractionOperand6CreationTool_title,
				Messages.InteractionOperand6CreationTool_desc, types);
		entry.setId("createInteractionOperand6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.InteractionOperand_3005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createMessageSync1CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Message_4003);
		LinkToolEntry entry = new LinkToolEntry(Messages.MessageSync1CreationTool_title,
				Messages.MessageSync1CreationTool_desc, types);
		entry.setId("createMessageSync1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Message_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createMessageAsync2CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Message_4004);
		LinkToolEntry entry = new LinkToolEntry(Messages.MessageAsync2CreationTool_title,
				Messages.MessageAsync2CreationTool_desc, types);
		entry.setId("createMessageAsync2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Message_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description, List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description, List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
