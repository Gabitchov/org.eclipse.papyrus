/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
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
		paletteRoot.add(createInteraction1Group());
		paletteRoot.add(createObjects2Group());
		paletteRoot.add(createMessages3Group());
		paletteRoot.add(createComments4Group());
	}

	/**
	 * Creates "Interaction" palette tool group
	 * @generated
	 */
	private PaletteContainer createInteraction1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Interaction1Group_title);
		paletteContainer.setDescription(Messages.Interaction1Group_desc);
		paletteContainer.add(createInteraction1CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Objects" palette tool group
	 * @generated
	 */
	private PaletteContainer createObjects2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Objects2Group_title);
		paletteContainer.setDescription(Messages.Objects2Group_desc);
		paletteContainer.add(createLifeline1CreationTool());
		paletteContainer.add(createExecutionBehaviour2CreationTool());
		paletteContainer.add(createCombinedFragment3CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Messages" palette tool group
	 * @generated
	 */
	private PaletteContainer createMessages3Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Messages3Group_title);
		paletteContainer.add(createCallsynch1CreationTool());
		paletteContainer.add(createCallasynch2CreationTool());
		paletteContainer.add(createReply3CreationTool());
		paletteContainer.add(new PaletteSeparator());
		paletteContainer.add(createSendSignal5CreationTool());
		paletteContainer.add(createCreationEvent6CreationTool());
		paletteContainer.add(createDestructionEvent7CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Comments" palette tool group
	 * @generated
	 */
	private PaletteContainer createComments4Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Comments4Group_title);
		paletteContainer.add(createComment1CreationTool());
		paletteContainer.add(createCommentLink2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInteraction1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Interaction_1001);
		types.add(UMLElementTypes.Interaction_2001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Interaction1CreationTool_title,
				Messages.Interaction1CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Interaction_1001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLifeline1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Lifeline_2002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Lifeline1CreationTool_title,
				Messages.Lifeline1CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Lifeline_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExecutionBehaviour2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.BehaviorExecutionSpecification_2003);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ExecutionBehaviour2CreationTool_title,
				Messages.ExecutionBehaviour2CreationTool_desc, types);
		entry
				.setSmallIcon(UMLElementTypes
						.getImageDescriptor(UMLElementTypes.BehaviorExecutionSpecification_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCombinedFragment3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.CombinedFragment_2004);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.CombinedFragment3CreationTool_title,
				Messages.CombinedFragment3CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.CombinedFragment_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCallsynch1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Message_3001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Callsynch1CreationTool_title,
				Messages.Callsynch1CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Message_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCallasynch2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Message_3002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Callasynch2CreationTool_title,
				Messages.Callasynch2CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Message_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createReply3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Message_3003);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Reply3CreationTool_title,
				Messages.Reply3CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Message_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSendSignal5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Message_3004);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.SendSignal5CreationTool_title, null, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Message_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCreationEvent6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Message_3005);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.CreationEvent6CreationTool_title, null, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Message_3005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDestructionEvent7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Message_3006);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.DestructionEvent7CreationTool_title, null, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Message_3006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComment1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Comment_2005);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Comment1CreationTool_title,
				Messages.Comment1CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Comment_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCommentLink2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.ElementOwnedComment_3007);
		types.add(UMLElementTypes.CommentAnnotatedElement_3008);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.CommentLink2CreationTool_title,
				Messages.CommentLink2CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.ElementOwnedComment_3007));
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
		private NodeToolEntry(String title, String description,
				List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		@Override
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
		private LinkToolEntry(String title, String description,
				List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		@Override
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
