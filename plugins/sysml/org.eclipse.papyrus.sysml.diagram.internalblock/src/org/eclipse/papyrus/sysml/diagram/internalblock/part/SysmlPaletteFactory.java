/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.diagram.composite.part.UMLPaletteFactory;
import org.eclipse.papyrus.sysml.diagram.internalblock.providers.SysmlElementTypes;

/**
 * @generated
 */
public class SysmlPaletteFactory extends UMLPaletteFactory {

	private final static String CREATEFLOWPORT = "createFlowPortCreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createSysml1Group());
	}

	/**
	 * Creates "sysml" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createSysml1Group() {
		// PaletteGroup paletteContainer = new PaletteGroup(Messages.Sysml1Group_title);
		//		paletteContainer.setId("createSysml1Group"); //$NON-NLS-1$
		// paletteContainer.add(createFlowPortCreationTool());
		return null;
	}

	@Override
	public Tool createTool(String toolId) {
		Tool result = super.createTool(toolId);
		if (result == null) {
			if (CREATEFLOWPORT.equals(toolId)) {
				return createFlowPortCreationTool();
			}
			return null;
		}
		return result;
	}

	private Tool createFlowPortCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(SysmlElementTypes.FlowPort_2001);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	// private ToolEntry createFlowPortCreationTool() {
	// List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
	// types.add(SysmlElementTypes.FlowPort_2001);
	// NodeToolEntry entry = new NodeToolEntry(Messages.FlowPort1CreationTool_title,
	// Messages.FlowPort1CreationTool_desc, types);
	//		entry.setId("createFlowPort1CreationTool"); //$NON-NLS-1$
	// entry.setSmallIcon(SysmlElementTypes.getImageDescriptor(SysmlElementTypes.FlowPort_2001));
	// entry.setLargeIcon(entry.getSmallIcon());
	// return entry;
	// }

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
}
