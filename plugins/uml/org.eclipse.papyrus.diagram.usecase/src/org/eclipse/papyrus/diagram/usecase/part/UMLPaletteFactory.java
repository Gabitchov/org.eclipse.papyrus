/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.papyrus.diagram.usecase.providers.UMLElementTypes;

/**
 * @generated
 */
public class UMLPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createNodes1Group());
		paletteRoot.add(createChildren2Group());
		paletteRoot.add(createLinks3Group());
	}

	/**
	 * Creates "Nodes" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Nodes1Group_title);
		paletteContainer.setDescription(Messages.Nodes1Group_desc);
		paletteContainer.add(createUseCase1CreationTool());
		paletteContainer.add(createActor2CreationTool());
		paletteContainer.add(createSubject3CreationTool());
		paletteContainer.add(createPackage4CreationTool());
		paletteContainer.add(createConstraint5CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Children" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createChildren2Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Children2Group_title);
		paletteContainer.setDescription(Messages.Children2Group_desc);
		paletteContainer.add(createExtensionPoint1CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Links" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createLinks3Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Links3Group_title);
		paletteContainer.setDescription(Messages.Links3Group_desc);
		paletteContainer.add(createAssociation1CreationTool());
		paletteContainer.add(createExtend2CreationTool());
		paletteContainer.add(createInclude3CreationTool());
		paletteContainer.add(createGeneralization4CreationTool());
		paletteContainer.add(createConstrainedElement5CreationTool());
		paletteContainer.add(createDependency6CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUseCase1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.UseCase_2004);
		types.add(UMLElementTypes.UseCase_3004);
		types.add(UMLElementTypes.UseCase_3006);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.UseCase1CreationTool_title,
				Messages.UseCase1CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.UseCase_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActor2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Actor_2002);
		types.add(UMLElementTypes.Actor_3005);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Actor2CreationTool_title,
				Messages.Actor2CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Actor_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSubject3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Component_2006);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Subject3CreationTool_title,
				Messages.Subject3CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Component_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPackage4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Package_2009);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Package4CreationTool_title,
				Messages.Package4CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Package_2009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstraint5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Constraint_2008);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Constraint5CreationTool_title,
				Messages.Constraint5CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Constraint_2008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExtensionPoint1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.ExtensionPoint_3002);
		types.add(UMLElementTypes.ExtensionPoint_3003);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ExtensionPoint1CreationTool_title,
				Messages.ExtensionPoint1CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.ExtensionPoint_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociation1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Association_4004);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Association1CreationTool_title,
				Messages.Association1CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Association_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExtend2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Extend_4002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Extend2CreationTool_title,
				Messages.Extend2CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Extend_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInclude3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Include_4001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Include3CreationTool_title,
				Messages.Include3CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Include_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGeneralization4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Generalization_4003);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Generalization4CreationTool_title,
				Messages.Generalization4CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Generalization_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstrainedElement5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4005);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ConstrainedElement5CreationTool_title,
				Messages.ConstrainedElement5CreationTool_desc, types);
		entry
				.setSmallIcon(UMLElementTypes
						.getImageDescriptor(UMLElementTypes.ConstraintConstrainedElement_4005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependency6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Dependency_4006);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Dependency6CreationTool_title,
				Messages.Dependency6CreationTool_desc, types);
		entry.setSmallIcon(UMLElementTypes
				.getImageDescriptor(UMLElementTypes.Dependency_4006));
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
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
