/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.factory;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.BlockDefinitionDiagramElementTypes;

public class BlockDefinitionDiagramPaletteFactory extends PaletteFactory.Adapter {

	private final static String BDD_TOOL_BLOCK = "blockdefinition.tool.block"; //$NON-NLS-1$

	public Tool createTool(String toolId) {
		if(BDD_TOOL_BLOCK.equals(toolId)) {
			return createBlockCreationTool();
		}

		return null;
	}

	private Tool createBlockCreationTool() {

		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(BlockDefinitionDiagramElementTypes.BLOCK);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}
}
