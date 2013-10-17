/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.factory; 

import java.util.Arrays;
import java.util.HashMap;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.sysml.diagram.parametric.provider.ElementTypes;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;

@SuppressWarnings("serial")
public class DiagramPaletteFactory extends PaletteFactory.Adapter {

	private static HashMap<String, IElementType[]> nodesToolIdTypesMap = new HashMap<String, IElementType[]>() {

		{
			put("parametric.tool.blockcomposite", new IElementType[]{ SysMLElementTypes.BLOCK });	
			put("parametric.tool.blockpropertycomposite", new IElementType[]{ SysMLElementTypes.PART_PROPERTY });	
			put("parametric.tool.reference", new IElementType[]{ SysMLElementTypes.REFERENCE_PROPERTY });	
			put("parametric.tool.value", new IElementType[]{ SysMLElementTypes.VALUE_PROPERTY });	
			put("parametric.tool.constraintblockpropertycomposite", new IElementType[]{ SysMLElementTypes.CONSTRAINT_PROPERTY });	
			put("parametric.tool.flowport", new IElementType[]{ SysMLElementTypes.FLOW_PORT });	
			put("parametric.tool.port", new IElementType[]{ UMLElementTypes.PORT });	
			put("parametric.tool.parameter", new IElementType[]{ UMLElementTypes.PROPERTY });	
			//Start of user code Custom nodes
			put("parametric.tool.constraint", new IElementType[]{ UMLElementTypes.CONSTRAINT });
			put("parametric.tool.comment", new IElementType[]{ UMLElementTypes.COMMENT });				
			//End of user code
		}
	};

	private static HashMap<String, IElementType[]> edgesToolIdTypesMap = new HashMap<String, IElementType[]>() {

		{
			put("parametric.tool.connector", new IElementType[]{ UMLElementTypes.CONNECTOR });	
			put("parametric.tool.dependency", new IElementType[]{ UMLElementTypes.DEPENDENCY });	
			//Start of user code Custom edges
			put("parametric.tool.comment_constraint_link", new IElementType[]{ ElementTypes.COMMENT_ANNOTATED_ELEMENT });	
			put("parametric.tool.context_link", new IElementType[]{ ElementTypes.CONTEXT_LINK });	
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
