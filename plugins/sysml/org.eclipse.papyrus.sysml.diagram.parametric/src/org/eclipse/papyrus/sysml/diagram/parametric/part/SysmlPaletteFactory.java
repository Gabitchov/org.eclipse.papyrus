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
package org.eclipse.papyrus.sysml.diagram.parametric.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.sysml.diagram.parametric.providers.SysmlElementTypes;

/**
 * @generated NOT
 */
public class SysmlPaletteFactory extends PaletteFactory.Adapter {

	/**
	 * @generated
	 */
	private final static String CREATEPROPERTYCREATIONTOOL = "createPropertyCreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECONSTRAINTPROPERTY2CREATIONTOOL = "createConstraintProperty2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public SysmlPaletteFactory() {

	}

	/**
	 * @generated
	 */
	public Tool createTool(String toolId) {
		if (toolId.equals(CREATEPROPERTYCREATIONTOOL)) {
			return createConstraintBlock1CreationTool();
		}
		if (toolId.equals(CREATECONSTRAINTPROPERTY2CREATIONTOOL)) {
			return createConstraintProperty2CreationTool();
		}

		// default return: null
		return null;
	}

	public Object getTemplate(String templateId) {

		// default return: null
		return null;
	}

	/**
	 * @generated NOT
	 */
	private Tool createConstraintBlock1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(SysmlElementTypes.Property_2005);
		types.add(SysmlElementTypes.Property_3002);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConstraintProperty2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(SysmlElementTypes.ConstraintProperty_2003);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

}
