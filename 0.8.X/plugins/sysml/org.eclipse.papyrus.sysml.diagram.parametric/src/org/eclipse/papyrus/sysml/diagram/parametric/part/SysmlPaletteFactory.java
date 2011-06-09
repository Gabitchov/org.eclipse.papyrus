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
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.sysml.diagram.parametric.providers.SysmlElementTypes;

/**
 * @generated
 */
public class SysmlPaletteFactory extends PaletteFactory.Adapter {

	/**
	 * @generated
	 */
	private final static String CREATECONSTRAINTPROPERTY1CREATIONTOOL = "createConstraintProperty1CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEPROPERTY2CREATIONTOOL = "createProperty2CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATECONNECTOR3CREATIONTOOL = "createConnector3CreationTool"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public SysmlPaletteFactory() {

	}

	/**
	 * @generated
	 */
	public Tool createTool(String toolId) {
		if (toolId.equals(CREATECONSTRAINTPROPERTY1CREATIONTOOL)) {
			return createConstraintProperty1CreationTool();
		}
		if (toolId.equals(CREATEPROPERTY2CREATIONTOOL)) {
			return createProperty2CreationTool();
		}
		if (toolId.equals(CREATECONNECTOR3CREATIONTOOL)) {
			return createConnector3CreationTool();
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
	private Tool createConstraintProperty1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(SysmlElementTypes.ConstraintProperty_2003);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createProperty2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(SysmlElementTypes.Property_3002);
		types.add(SysmlElementTypes.Property_2005);

		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConnector3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(SysmlElementTypes.Connector_4001);

		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

}
