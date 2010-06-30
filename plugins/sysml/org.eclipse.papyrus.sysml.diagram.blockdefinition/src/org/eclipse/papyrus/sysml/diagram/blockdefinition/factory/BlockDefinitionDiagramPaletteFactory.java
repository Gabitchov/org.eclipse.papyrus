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

import java.util.Arrays;
import java.util.HashMap;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.BlockDefinitionDiagramElementTypes;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

@SuppressWarnings("serial")
public class BlockDefinitionDiagramPaletteFactory extends PaletteFactory.Adapter {
	
	private static HashMap<String, IElementType[]> nodesToolIdTypesMap = new HashMap<String, IElementType[]>()
	{{
		put("blockdefinition.tool.block", new IElementType[] {BlockDefinitionDiagramElementTypes.BLOCK});
		put("blockdefinition.tool.flowport", new IElementType[] {BlockDefinitionDiagramElementTypes.FLOW_PORT});
		put("blockdefinition.tool.port", new IElementType[] {BlockDefinitionDiagramElementTypes.PORT});
		
		put("blockdefinition.tool.constraint", new IElementType[] {
			UMLElementTypes.Constraint_3029,
			UMLElementTypes.Constraint_2011,
			BlockDefinitionDiagramElementTypes.CONSTRAINT
			});
	}};
	
	private static HashMap<String, IElementType[]> edgesToolIdTypesMap = new HashMap<String, IElementType[]>()
	{{
		put("blockdefinition.tool.connector", new IElementType[] {BlockDefinitionDiagramElementTypes.CONNECTOR});
	}};

	public Tool createTool(String toolId) {
		IElementType[] types = nodesToolIdTypesMap.get(toolId);
		if(types != null) {
			return new AspectUnspecifiedTypeCreationTool(Arrays.asList(types));
		}
		
		types = edgesToolIdTypesMap.get(toolId);
		if(types != null) {
			return new AspectUnspecifiedTypeConnectionTool(Arrays.asList(types));
		}
		return null;
	}
}
