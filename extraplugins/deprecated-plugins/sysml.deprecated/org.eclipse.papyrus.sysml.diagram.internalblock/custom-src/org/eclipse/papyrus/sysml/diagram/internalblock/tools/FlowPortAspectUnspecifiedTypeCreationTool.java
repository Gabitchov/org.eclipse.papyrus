/*****************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN.
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
package org.eclipse.papyrus.sysml.diagram.internalblock.tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.Request;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.sysml.diagram.internalblock.part.SysmlPaletteFactory;
import org.eclipse.papyrus.sysml.diagram.internalblock.part.SysmlPaletteFactory.PORT_TYPE;

public class FlowPortAspectUnspecifiedTypeCreationTool extends AspectUnspecifiedTypeCreationTool {

	private PORT_TYPE type;

	public FlowPortAspectUnspecifiedTypeCreationTool(List elementTypes, SysmlPaletteFactory.PORT_TYPE type) {
		super(elementTypes);
		this.type = type;
	}

	@Override
	protected Request getTargetRequest() {
		Request request = super.getTargetRequest();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put(SysmlPaletteFactory.FLOW_PORT_TOOL_TYPE, type);
		request.setExtendedData(map);
		return request;
	}

}
