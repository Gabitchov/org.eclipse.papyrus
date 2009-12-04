/*
 * Copyright (c) 2007 Borland Software Corporation
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Copyright (c) of modifications Conselleria de Infraestructuras y
 * Transporte, Generalitat de la Comunitat Valenciana. All rights reserved.
 * Modifications are made available under the terms of the Eclipse Public
 * License v1.0.
 *
 * Contributors:
 *  Sergey Gribovsky (Borland) - initial API and implementation
 *  Francisco Javier Cano Mu�oz (Prodevelop)
 *  Marc Gil Sendra (Prodevelop)
 */
package org.eclipse.papyrus.diagram.statemachine.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteStack;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;


/**
 * @generated
 */
public class UMLPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createNodes1Group());
		paletteRoot.add(createLinks2Group());
		paletteRoot.add(createComments3Group());
	}

	/**
	 * Creates "Nodes" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Nodes1Group_title);
		paletteContainer.add(createStateMachine1CreationTool());
		paletteContainer.add(createState2Group());
		paletteContainer.add(createRegion3CreationTool());
		paletteContainer.add(createFinalState4CreationTool());
		paletteContainer.add(createInitial5CreationTool());
		paletteContainer.add(createShallowHistory6CreationTool());
		paletteContainer.add(createDeepHistory7CreationTool());
		paletteContainer.add(createFork8CreationTool());
		paletteContainer.add(createJoin9CreationTool());
		paletteContainer.add(createJunction10CreationTool());
		paletteContainer.add(createChoice11CreationTool());
		paletteContainer.add(createTerminate12CreationTool());
		paletteContainer.add(createEntryPoint13CreationTool());
		paletteContainer.add(createExitPoint14CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Links" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createLinks2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Links2Group_title);
		paletteContainer.add(createTransition1CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Comments" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createComments3Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Comments3Group_title);
		paletteContainer.add(createComment1CreationTool());
		paletteContainer.add(createCommentLink2CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "State" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createState2Group() {
		PaletteStack paletteContainer = new PaletteStack(
				Messages.State2Group_title, null, null);
		paletteContainer.setDescription(Messages.State2Group_desc);
		paletteContainer.add(createSimpleState1CreationTool());
		paletteContainer.add(createCompositeState2CreationTool());
		paletteContainer.add(createSubmachineState3CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStateMachine1CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.StateMachine_1001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.StateMachine1CreationTool_title,
				Messages.StateMachine1CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.StateMachine_1001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRegion3CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.Region_2001);
		types.add(UMLElementTypes.Region_2004);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Region3CreationTool_title,
				Messages.Region3CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Region_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFinalState4CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.FinalState_2008);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.FinalState4CreationTool_title,
				Messages.FinalState4CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.FinalState_2008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInitial5CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Pseudostate_2009);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Initial5CreationTool_title,
				Messages.Initial5CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Pseudostate_2009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createShallowHistory6CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Pseudostate_2010);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ShallowHistory6CreationTool_title,
				Messages.ShallowHistory6CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Pseudostate_2010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDeepHistory7CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Pseudostate_2011);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.DeepHistory7CreationTool_title,
				Messages.DeepHistory7CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Pseudostate_2011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFork8CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Pseudostate_2012);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Fork8CreationTool_title,
				Messages.Fork8CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Pseudostate_2012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createJoin9CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Pseudostate_2013);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Join9CreationTool_title,
				Messages.Join9CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Pseudostate_2013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createJunction10CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Pseudostate_2014);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Junction10CreationTool_title,
				Messages.Junction10CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Pseudostate_2014));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createChoice11CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Pseudostate_2015);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Choice11CreationTool_title,
				Messages.Choice11CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Pseudostate_2015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTerminate12CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Pseudostate_2016);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Terminate12CreationTool_title,
				Messages.Terminate12CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Pseudostate_2016));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEntryPoint13CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(4);
		types.add(UMLElementTypes.ConnectionPointReference_2006);
		types.add(UMLElementTypes.Pseudostate_2018);
		types.add(UMLElementTypes.Pseudostate_2020);
		types.add(UMLElementTypes.Pseudostate_2022);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.EntryPoint13CreationTool_title,
				Messages.EntryPoint13CreationTool_desc, types);
		entry
				.setSmallIcon(UMLDiagramEditorPlugin
				.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_entryPoint.gif")); //$NON-NLS-1$
		entry
				.setLargeIcon(UMLDiagramEditorPlugin
				.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_entryPoint.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExitPoint14CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(4);
		types.add(UMLElementTypes.ConnectionPointReference_2007);
		types.add(UMLElementTypes.Pseudostate_2019);
		types.add(UMLElementTypes.Pseudostate_2021);
		types.add(UMLElementTypes.Pseudostate_2023);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ExitPoint14CreationTool_title,
				Messages.ExitPoint14CreationTool_desc, types);
		entry
				.setSmallIcon(UMLDiagramEditorPlugin
				.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_exitPoint.gif")); //$NON-NLS-1$
		entry
				.setLargeIcon(UMLDiagramEditorPlugin
				.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_exitPoint.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTransition1CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Transition_3001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Transition1CreationTool_title,
				Messages.Transition1CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Transition_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComment1CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Comment_2024);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Comment1CreationTool_title,
				Messages.Comment1CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Comment_2024));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCommentLink2CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.ElementOwnedComment_3002);
		types.add(UMLElementTypes.CommentAnnotatedElement_3003);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.CommentLink2CreationTool_title,
				Messages.CommentLink2CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.ElementOwnedComment_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSimpleState1CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.State_2002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SimpleState1CreationTool_title,
				Messages.SimpleState1CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.State_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCompositeState2CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.State_2003);
		types.add(UMLElementTypes.State_2017);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.CompositeState2CreationTool_title,
				Messages.CompositeState2CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.State_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSubmachineState3CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.State_2005);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SubmachineState3CreationTool_title,
				Messages.SubmachineState3CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.State_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		private boolean fixedSize = false;

		private Dimension size = null;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		private NodeToolEntry(String title, String description,
				List elementTypes, Dimension size) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
			fixedSize = true;
			this.size = size.getCopy();
		}

		/**
		 * @generated
		 */
		public Tool createToolGen() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}

		/**
		 * @generated NOT
		 */
		@Override
		public Tool createTool() {
			// fjcano: if there is a toolClass defined,
			// that tool must be employed
			boolean fixedSize = false;
			Tool superTool = super.createTool();
			if(superTool != null) {
				return superTool;
			}

			Tool tool = null;
			if(!fixedSize) {
				tool = new UnspecifiedTypeCreationTool(elementTypes);
			} else {
				//mgil: changed the way to create a new UnspecifiedFixedSizeType Creation element
				//tool = new UnspecifiedFixedSizeTypeCreationTool(elementTypes,	size);
				tool = (new UMLPaletteFactory()).new UnspecifiedFixedSizeTypeCreationTool(
						elementTypes, size);
			}
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	private class UnspecifiedFixedSizeTypeCreationTool extends
			UnspecifiedTypeCreationTool {

		private Dimension size = null;

		public UnspecifiedFixedSizeTypeCreationTool(List elementTypes,
				Dimension size) {
			super(elementTypes);
			this.size = size.getCopy();
		}

		@Override
		protected void updateTargetRequest() {
			super.updateTargetRequest();
			Dimension d = getCreateRequest().getSize();
			if(d == null) {
				return;
			}
			int x = 0, y = 0;
			if(d.width > size.width) {
				x = d.width - size.width;
				d.width = size.width;
			}
			if(d.height > size.height) {
				y = d.height - size.height;
				d.height = size.height;
			}
			Point p = getCreateRequest().getLocation();
			if(p.x < getStartLocation().x) {
				p.x += x;
			}
			if(p.y < getStartLocation().y) {
				p.y += y;
			}
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
