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
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.papyrus.diagram.composite.providers.UMLElementTypes;

/**
 * @generated
 */
public class UMLPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createNodes1Group());
		paletteRoot.add(createEdges2Group());
	}

	/**
	 * Creates "Nodes" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Nodes1Group_title);
		paletteContainer.setId("createNodes1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Nodes1Group_desc);
		paletteContainer.add(createClass1CreationTool());
		paletteContainer.add(createProperty2CreationTool());
		paletteContainer.add(createPort3CreationTool());
		paletteContainer.add(createCollaboration4CreationTool());
		paletteContainer.add(createCollaborationRole5CreationTool());
		paletteContainer.add(createCollaborationUse6CreationTool());
		paletteContainer.add(createComment7CreationTool());
		paletteContainer.add(createContraint8CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Edges" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createEdges2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Edges2Group_title);
		paletteContainer.setId("createEdges2Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Edges2Group_desc);
		paletteContainer.add(createLink1CreationTool());
		paletteContainer.add(createConnector2CreationTool());
		paletteContainer.add(createRoleBinding3CreationTool());
		paletteContainer.add(createGeneralization4CreationTool());
		paletteContainer.add(createRealization5CreationTool());
		paletteContainer.add(createSubstitution6CreationTool());
		paletteContainer.add(createAbstraction7CreationTool());
		paletteContainer.add(createUsage8CreationTool());
		paletteContainer.add(createDependency9CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createClass1CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.Class_2073);
		types.add(UMLElementTypes.Class_3085);
		NodeToolEntry entry = new NodeToolEntry(Messages.Class1CreationTool_title, Messages.Class1CreationTool_desc,
				types);
		entry.setId("createClass1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Class_2073));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProperty2CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Property_3070);
		NodeToolEntry entry = new NodeToolEntry(Messages.Property2CreationTool_title,
				Messages.Property2CreationTool_desc, types);
		entry.setId("createProperty2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Property_3070));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPort3CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Port_3069);
		NodeToolEntry entry = new NodeToolEntry(Messages.Port3CreationTool_title, Messages.Port3CreationTool_desc,
				types);
		entry.setId("createPort3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Port_3069));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCollaboration4CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.Collaboration_3086);
		types.add(UMLElementTypes.Collaboration_2075);
		NodeToolEntry entry = new NodeToolEntry(Messages.Collaboration4CreationTool_title,
				Messages.Collaboration4CreationTool_desc, types);
		entry.setId("createCollaboration4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Collaboration_3086));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCollaborationRole5CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.ConnectableElement_3115);
		NodeToolEntry entry = new NodeToolEntry(Messages.CollaborationRole5CreationTool_title,
				Messages.CollaborationRole5CreationTool_desc, types);
		entry.setId("createCollaborationRole5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLDiagramEditorPlugin.findImageDescriptor("icons/obj16/CollaborationRole.gif")); //$NON-NLS-1$
		entry.setLargeIcon(UMLDiagramEditorPlugin.findImageDescriptor("icons/obj16/CollaborationRole.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCollaborationUse6CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.CollaborationUse_3071);
		NodeToolEntry entry = new NodeToolEntry(Messages.CollaborationUse6CreationTool_title,
				Messages.CollaborationUse6CreationTool_desc, types);
		entry.setId("createCollaborationUse6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.CollaborationUse_3071));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComment7CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.Comment_3097);
		types.add(UMLElementTypes.Comment_2109);
		NodeToolEntry entry = new NodeToolEntry(Messages.Comment7CreationTool_title,
				Messages.Comment7CreationTool_desc, types);
		entry.setId("createComment7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Comment_3097));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createContraint8CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Constraint_2114);
		NodeToolEntry entry = new NodeToolEntry(Messages.Contraint8CreationTool_title,
				Messages.Contraint8CreationTool_desc, types);
		entry.setId("createContraint8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Constraint_2114));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLink1CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.CommentAnnotatedElement_4002);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4003);
		LinkToolEntry entry = new LinkToolEntry(Messages.Link1CreationTool_title, Messages.Link1CreationTool_desc,
				types);
		entry.setId("createLink1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.CommentAnnotatedElement_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConnector2CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Connector_4013);
		LinkToolEntry entry = new LinkToolEntry(Messages.Connector2CreationTool_title,
				Messages.Connector2CreationTool_desc, types);
		entry.setId("createConnector2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Connector_4013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRoleBinding3CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Dependency_4017);
		LinkToolEntry entry = new LinkToolEntry(Messages.RoleBinding3CreationTool_title,
				Messages.RoleBinding3CreationTool_desc, types);
		entry.setId("createRoleBinding3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLDiagramEditorPlugin.findImageDescriptor("icons/obj16/CollaborationRoleBinding.gif")); //$NON-NLS-1$
		entry.setLargeIcon(UMLDiagramEditorPlugin.findImageDescriptor("icons/obj16/CollaborationRoleBinding.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGeneralization4CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Generalization_4015);
		LinkToolEntry entry = new LinkToolEntry(Messages.Generalization4CreationTool_title,
				Messages.Generalization4CreationTool_desc, types);
		entry.setId("createGeneralization4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Generalization_4015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRealization5CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Realization_4006);
		LinkToolEntry entry = new LinkToolEntry(Messages.Realization5CreationTool_title,
				Messages.Realization5CreationTool_desc, types);
		entry.setId("createRealization5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Realization_4006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSubstitution6CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Substitution_4011);
		LinkToolEntry entry = new LinkToolEntry(Messages.Substitution6CreationTool_title,
				Messages.Substitution6CreationTool_desc, types);
		entry.setId("createSubstitution6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Substitution_4011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAbstraction7CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Abstraction_4007);
		LinkToolEntry entry = new LinkToolEntry(Messages.Abstraction7CreationTool_title,
				Messages.Abstraction7CreationTool_desc, types);
		entry.setId("createAbstraction7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Abstraction_4007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUsage8CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Usage_4008);
		LinkToolEntry entry = new LinkToolEntry(Messages.Usage8CreationTool_title, Messages.Usage8CreationTool_desc,
				types);
		entry.setId("createUsage8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Usage_4008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependency9CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Dependency_4010);
		LinkToolEntry entry = new LinkToolEntry(Messages.Dependency9CreationTool_title,
				Messages.Dependency9CreationTool_desc, types);
		entry.setId("createDependency9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Dependency_4010));
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
