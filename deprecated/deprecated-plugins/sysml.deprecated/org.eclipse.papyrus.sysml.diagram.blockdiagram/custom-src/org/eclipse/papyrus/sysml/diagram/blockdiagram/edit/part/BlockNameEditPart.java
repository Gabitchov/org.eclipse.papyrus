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
package org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.part;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassNameEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.part.SysmlVisualIDRegistry;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.providers.SysmlElementTypes;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.providers.SysmlParserProvider;


public class BlockNameEditPart extends ClassNameEditPart {

	public static final int VISUAL_ID = 5129;

	private IParser parser;

	public BlockNameEditPart(View view) {
		super(view);
	}

	@Override
	public IParser getParser() {
		if(parser == null) {
			parser = SysmlParserProvider.getParser(SysmlElementTypes.Block_2001, getParserElement(), SysmlVisualIDRegistry.getType(VISUAL_ID));
		}
		return parser;
	}
}
