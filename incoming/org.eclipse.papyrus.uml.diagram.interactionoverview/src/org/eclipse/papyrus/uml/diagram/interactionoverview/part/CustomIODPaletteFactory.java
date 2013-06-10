/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLPaletteFactory;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.uml.diagram.interactionoverview.provider.UMLElementTypes;


public class CustomIODPaletteFactory extends UMLPaletteFactory {

	private final static String CREATECALLBEHAVIORACTIONASCREATIONTOOL = "createCallBehaviorActionAsInteractionCreationTool"; //$NON-NLS-1$

	@Override
	public Tool createTool(final String toolId) {
		if(toolId.equals(CREATECALLBEHAVIORACTIONASCREATIONTOOL)) {
			return createCallBehaviorActionAsInteractionCreationTool();
		}
		return super.createTool(toolId);
	}

	private static Tool createCallBehaviorActionAsInteractionCreationTool() {
		final List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CallBehaviorAction_5000);
		final Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}
}
