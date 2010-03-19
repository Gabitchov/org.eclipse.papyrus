/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdiagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.providers.SysmlElementTypes;

/**
 * @generated
 */
public class SysmlPaletteFactory extends org.eclipse.papyrus.diagram.clazz.part.UMLPaletteFactory {

	/**
	 * @generated
	 */
	private final static String BLOCK_TOOL_BLOCK = "block.tool.block"; //$NON-NLS-1$

	private final static String CLAZZ_TOOL_OPERATION = "clazz.tool.operation"; //$NON-NLS-1$

	private final static String CLAZZ_TOOL_PROPERTY = "clazz.tool.property"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public SysmlPaletteFactory() {

	}

	/**
	 * @generated NOT
	 */
	@Override
	public Tool createTool(String toolId) {
		if(toolId.equals(CLAZZ_TOOL_PROPERTY)) {
			return createProperty1CreationTool();
		}
		if(toolId.equals(CLAZZ_TOOL_OPERATION)) {
			return createOperation2CreationTool();
		}
		if(toolId.equals(BLOCK_TOOL_BLOCK)) {
			return createBlock1CreationTool();
		}
		return super.createTool(toolId);
	}

	public Object getTemplate(String templateId) {

		// default return: null
		return null;
	}

	/**
	 * @generated
	 */
	private Tool createBlock1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(SysmlElementTypes.Block_2001);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated NOT
	 */
	private Tool createProperty1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(6);
		// SysML
		types.add(SysmlElementTypes.Property_3001);

		// UML
		types.add(UMLElementTypes.Property_3002);
		types.add(UMLElementTypes.Property_3005);
		types.add(UMLElementTypes.Property_3006);
		types.add(UMLElementTypes.Property_3012);
		types.add(UMLElementTypes.Property_3018);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated NOT
	 */
	private Tool createOperation2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(5);
		// SYSML
		types.add(SysmlElementTypes.Operation_3102);

		// UML
		types.add(UMLElementTypes.Operation_3003);
		types.add(UMLElementTypes.Operation_3007);
		types.add(UMLElementTypes.Operation_3013);
		types.add(UMLElementTypes.Operation_3019);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

}
