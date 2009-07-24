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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteStack;
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
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Nodes1Group_title);
		paletteContainer.setId("createNodes1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Nodes1Group_desc);
		paletteContainer.add(createPackage1CreationTool());
		paletteContainer.add(createSubject2CreationTool());
		paletteContainer.add(createActor3CreationTool());
		paletteContainer.add(createUseCase4CreationTool());
		paletteContainer.add(createConstraint5CreationTool());
		paletteContainer.add(createComment6CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Children" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createChildren2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Children2Group_title);
		paletteContainer.setId("createChildren2Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Children2Group_desc);
		paletteContainer.add(createExtensionPoint1CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Links" palette tool group
	 * 
	 * @generated NOT
	 */
	private PaletteContainer createLinks3Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Links3Group_title);
		paletteContainer.setId("createLinks3Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Links3Group_desc);
		paletteContainer.add(createAssociation1CreationTool());
		paletteContainer.add(createGeneralization2CreationTool());

		createLinksStack(paletteContainer);

		paletteContainer.add(createInclude9CreationTool());
		paletteContainer.add(createExtend10CreationTool());
		paletteContainer.add(createConstrainedElement11CreationTool());
		paletteContainer.add(createCommentlink12CreationTool());
		return paletteContainer;
	}

	/**
	 * @param paletteContainer
	 */
	private void createLinksStack(PaletteDrawer paletteContainer) {
		PaletteStack stack = new PaletteStack(null, null, null);
		stack.add(createDependency3CreationTool());
		stack.add(createAbstraction4CreationTool());
		stack.add(createRealization5CreationTool());
		stack.add(createUsage6CreationTool());
		stack.add(createPackageMerge7CreationTool());
		stack.add(createPackageImport8CreationTool());

		paletteContainer.add(stack);
	}

	/**
	 * @generated
	 */
	private ToolEntry createPackage1CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.Package_3014);
		types.add(UMLElementTypes.Package_2016);
		NodeToolEntry entry = new NodeToolEntry(Messages.Package1CreationTool_title,
				Messages.Package1CreationTool_desc, types);
		entry.setId("createPackage1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Package_3014));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSubject2CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(3);
		types.add(UMLElementTypes.Component_2015);
		types.add(UMLElementTypes.Component_3016);
		types.add(UMLElementTypes.Component_3013);
		NodeToolEntry entry = new NodeToolEntry(Messages.Subject2CreationTool_title,
				Messages.Subject2CreationTool_desc, types);
		entry.setId("createSubject2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Component_2015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActor3CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(3);
		types.add(UMLElementTypes.Actor_2011);
		types.add(UMLElementTypes.Actor_3018);
		types.add(UMLElementTypes.Actor_3011);
		NodeToolEntry entry = new NodeToolEntry(Messages.Actor3CreationTool_title, Messages.Actor3CreationTool_desc,
				types);
		entry.setId("createActor3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Actor_2011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUseCase4CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(3);
		types.add(UMLElementTypes.UseCase_2013);
		types.add(UMLElementTypes.UseCase_3009);
		types.add(UMLElementTypes.UseCase_3012);
		NodeToolEntry entry = new NodeToolEntry(Messages.UseCase4CreationTool_title,
				Messages.UseCase4CreationTool_desc, types);
		entry.setId("createUseCase4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.UseCase_2013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstraint5CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(3);
		types.add(UMLElementTypes.Constraint_3017);
		types.add(UMLElementTypes.Constraint_3010);
		types.add(UMLElementTypes.Constraint_2017);
		NodeToolEntry entry = new NodeToolEntry(Messages.Constraint5CreationTool_title,
				Messages.Constraint5CreationTool_desc, types);
		entry.setId("createConstraint5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Constraint_3017));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComment6CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.Comment_3015);
		types.add(UMLElementTypes.Comment_2018);
		NodeToolEntry entry = new NodeToolEntry(Messages.Comment6CreationTool_title,
				Messages.Comment6CreationTool_desc, types);
		entry.setId("createComment6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Comment_3015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExtensionPoint1CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(UMLElementTypes.ExtensionPoint_3007);
		types.add(UMLElementTypes.ExtensionPoint_3008);
		NodeToolEntry entry = new NodeToolEntry(Messages.ExtensionPoint1CreationTool_title,
				Messages.ExtensionPoint1CreationTool_desc, types);
		entry.setId("createExtensionPoint1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ExtensionPoint_3007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociation1CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Association_4011);
		LinkToolEntry entry = new LinkToolEntry(Messages.Association1CreationTool_title,
				Messages.Association1CreationTool_desc, types);
		entry.setId("createAssociation1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Association_4011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGeneralization2CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Generalization_4010);
		LinkToolEntry entry = new LinkToolEntry(Messages.Generalization2CreationTool_title,
				Messages.Generalization2CreationTool_desc, types);
		entry.setId("createGeneralization2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Generalization_4010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependency3CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Dependency_4013);
		LinkToolEntry entry = new LinkToolEntry(Messages.Dependency3CreationTool_title,
				Messages.Dependency3CreationTool_desc, types);
		entry.setId("createDependency3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Dependency_4013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAbstraction4CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Abstraction_4015);
		LinkToolEntry entry = new LinkToolEntry(Messages.Abstraction4CreationTool_title,
				Messages.Abstraction4CreationTool_desc, types);
		entry.setId("createAbstraction4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Abstraction_4015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRealization5CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Realization_4017);
		LinkToolEntry entry = new LinkToolEntry(Messages.Realization5CreationTool_title,
				Messages.Realization5CreationTool_desc, types);
		entry.setId("createRealization5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Realization_4017));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUsage6CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Usage_4016);
		LinkToolEntry entry = new LinkToolEntry(Messages.Usage6CreationTool_title, Messages.Usage6CreationTool_desc,
				types);
		entry.setId("createUsage6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Usage_4016));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPackageMerge7CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.PackageMerge_4018);
		LinkToolEntry entry = new LinkToolEntry(Messages.PackageMerge7CreationTool_title,
				Messages.PackageMerge7CreationTool_desc, types);
		entry.setId("createPackageMerge7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.PackageMerge_4018));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPackageImport8CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.PackageImport_4019);
		LinkToolEntry entry = new LinkToolEntry(Messages.PackageImport8CreationTool_title,
				Messages.PackageImport8CreationTool_desc, types);
		entry.setId("createPackageImport8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.PackageImport_4019));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInclude9CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Include_4008);
		LinkToolEntry entry = new LinkToolEntry(Messages.Include9CreationTool_title,
				Messages.Include9CreationTool_desc, types);
		entry.setId("createInclude9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Include_4008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExtend10CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.Extend_4009);
		LinkToolEntry entry = new LinkToolEntry(Messages.Extend10CreationTool_title,
				Messages.Extend10CreationTool_desc, types);
		entry.setId("createExtend10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Extend_4009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstrainedElement11CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4012);
		LinkToolEntry entry = new LinkToolEntry(Messages.ConstrainedElement11CreationTool_title,
				Messages.ConstrainedElement11CreationTool_desc, types);
		entry.setId("createConstrainedElement11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ConstraintConstrainedElement_4012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCommentlink12CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(UMLElementTypes.CommentAnnotatedElement_4014);
		LinkToolEntry entry = new LinkToolEntry(Messages.Commentlink12CreationTool_title,
				Messages.Commentlink12CreationTool_desc, types);
		entry.setId("createCommentlink12CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.CommentAnnotatedElement_4014));
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
