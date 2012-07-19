/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.factory;

import java.util.Arrays;
import java.util.HashMap;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.sysml.diagram.internalblock.provider.ElementTypes;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;

@SuppressWarnings("serial")
public class DiagramPaletteFactory extends PaletteFactory.Adapter {

	private static HashMap<String, IElementType[]> nodesToolIdTypesMap = new HashMap<String, IElementType[]>() {

		{
			put("internalblock.tool.blockcomposite", new IElementType[]{ SysMLElementTypes.BLOCK });
			put("internalblock.tool.blockpropertycomposite", new IElementType[]{ SysMLElementTypes.PART_PROPERTY, SysMLElementTypes.REFERENCE_PROPERTY, SysMLElementTypes.ACTOR_PART_PROPERTY,
				SysMLElementTypes.VALUE_PROPERTY, UMLElementTypes.PROPERTY });
			put("internalblock.tool.flowport", new IElementType[]{ SysMLElementTypes.FLOW_PORT });
			put("internalblock.tool.port", new IElementType[]{ UMLElementTypes.PORT });
			//Start of user code Custom nodes
			put("internalblock.tool.part", new IElementType[]{ SysMLElementTypes.PART_PROPERTY });
			put("internalblock.tool.reference", new IElementType[]{ SysMLElementTypes.REFERENCE_PROPERTY });
			put("internalblock.tool.actorpart", new IElementType[]{ SysMLElementTypes.ACTOR_PART_PROPERTY });
			put("internalblock.tool.value", new IElementType[]{ SysMLElementTypes.VALUE_PROPERTY });
			put("internalblock.tool.property", new IElementType[]{ UMLElementTypes.PROPERTY });

			put("internalblock.tool.flowport_na", new IElementType[]{ SysMLElementTypes.FLOW_PORT_NA });
			put("internalblock.tool.flowport_in", new IElementType[]{ SysMLElementTypes.FLOW_PORT_IN });
			put("internalblock.tool.flowport_out", new IElementType[]{ SysMLElementTypes.FLOW_PORT_OUT });
			put("internalblock.tool.flowport_inout", new IElementType[]{ SysMLElementTypes.FLOW_PORT_IN_OUT });

			put("internalblock.tool.constraint", new IElementType[]{ UMLElementTypes.CONSTRAINT });
			put("internalblock.tool.comment", new IElementType[]{ UMLElementTypes.COMMENT });
			//End of user code
		}
	};

	private static HashMap<String, IElementType[]> edgesToolIdTypesMap = new HashMap<String, IElementType[]>() {

		{
			put("internalblock.tool.connector", new IElementType[]{ UMLElementTypes.CONNECTOR });
			put("internalblock.tool.dependency", new IElementType[]{ UMLElementTypes.DEPENDENCY });
			//Start of user code Custom edges
			put("internalblock.tool.comment_constraint_link", new IElementType[]{ ElementTypes.COMMENT_ANNOTATED_ELEMENT, ElementTypes.CONSTRAINT_CONSTRAINED_ELEMENT });
			//End of user code
		}
	};

	public Tool createTool(String toolId) {

		IElementType[] types;

		types = nodesToolIdTypesMap.get(toolId);
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
