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
package org.eclipse.papyrus.sysml.diagram.blockdefinition.factory;

import java.util.Arrays;
import java.util.HashMap;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;

@SuppressWarnings("serial")
public class DiagramPaletteFactory extends PaletteFactory.Adapter {

	private static HashMap<String, IElementType[]> nodesToolIdTypesMap = new HashMap<String, IElementType[]>() {

		{
			put("blockdefinition.tool.actor", new IElementType[]{ UMLElementTypes.ACTOR });
			put("blockdefinition.tool.block", new IElementType[]{ SysMLElementTypes.BLOCK });
			put("blockdefinition.tool.constraint", new IElementType[]{ UMLElementTypes.CONSTRAINT });
			put("blockdefinition.tool.constraintblock", new IElementType[]{ SysMLElementTypes.CONSTRAINT_BLOCK });
			put("blockdefinition.tool.constraintproperty", new IElementType[]{ SysMLElementTypes.CONSTRAINT_PROPERTY });
			put("blockdefinition.tool.datatype", new IElementType[]{ UMLElementTypes.DATA_TYPE });
			put("blockdefinition.tool.dimension", new IElementType[]{ SysMLElementTypes.DIMENSION });
			put("blockdefinition.tool.enumeration", new IElementType[]{ UMLElementTypes.ENUMERATION });
			put("blockdefinition.tool.enumerationliteral", new IElementType[]{ UMLElementTypes.ENUMERATION_LITERAL });
			put("blockdefinition.tool.flowport", new IElementType[]{ SysMLElementTypes.FLOW_PORT });
			put("blockdefinition.tool.flowproperty", new IElementType[]{ SysMLElementTypes.FLOW_PROPERTY });
			put("blockdefinition.tool.flowspecification", new IElementType[]{ SysMLElementTypes.FLOW_SPECIFICATION });
			put("blockdefinition.tool.interface", new IElementType[]{ UMLElementTypes.INTERFACE });
			put("blockdefinition.tool.operation", new IElementType[]{ UMLElementTypes.OPERATION });
			put("blockdefinition.tool.part", new IElementType[]{ SysMLElementTypes.PART_PROPERTY });
			put("blockdefinition.tool.port", new IElementType[]{ UMLElementTypes.PORT });
			put("blockdefinition.tool.primitivetype", new IElementType[]{ UMLElementTypes.PRIMITIVE_TYPE });
			put("blockdefinition.tool.property", new IElementType[]{ UMLElementTypes.PROPERTY });
			put("blockdefinition.tool.reception", new IElementType[]{ UMLElementTypes.RECEPTION });
			put("blockdefinition.tool.reference", new IElementType[]{ SysMLElementTypes.REFERENCE_PROPERTY });
			put("blockdefinition.tool.signal", new IElementType[]{ UMLElementTypes.SIGNAL });
			put("blockdefinition.tool.unit", new IElementType[]{ SysMLElementTypes.UNIT });
			put("blockdefinition.tool.value", new IElementType[]{ SysMLElementTypes.VALUE_PROPERTY });
			put("blockdefinition.tool.valuetype", new IElementType[]{ SysMLElementTypes.VALUE_TYPE });
		}
	};

	private static HashMap<String, IElementType[]> edgesToolIdTypesMap = new HashMap<String, IElementType[]>() {

		{

		}
	};


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
