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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeCreationTool;

/**
 * @generated
 */
public class UMLPaletteFactory extends PaletteFactory.Adapter {

	/**
	 * @generated
	 */
	private final static String CREATEINITIALNODE1CREATIONTOOL = "createInitialnode1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEACTIVITYFINAL2CREATIONTOOL = "createActivityfinal2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEFLOWFINAL3CREATIONTOOL = "createFlowfinal3CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public UMLPaletteFactory() {

	}

	/**
	 * @generated
	 */
	public Tool createTool(String toolId) {
		if(toolId.equals(CREATEINITIALNODE1CREATIONTOOL)) {
			return createInitialnode1CreationTool();
		}
		if(toolId.equals(CREATEACTIVITYFINAL2CREATIONTOOL)) {
			return createActivityfinal2CreationTool();
		}
		if(toolId.equals(CREATEFLOWFINAL3CREATIONTOOL)) {
			return createFlowfinal3CreationTool();
		}

		// default return: null
		return null;
	}

	public Object getTemplate(String templateId) {

		// default return: null
		return null;
	}

	/**
	 * @generated
	 */
	private Tool createInitialnode1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.InitialNode_3004);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createActivityfinal2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ActivityFinalNode_3005);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createFlowfinal3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.FlowFinalNode_3006);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

}
