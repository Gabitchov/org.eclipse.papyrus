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
package org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CallBehaviorActionNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLParserProvider;


public class CustomInteractionUseNameEditPart extends CallBehaviorActionNameEditPart {

	/**
	 * @see org.eclipse.papyrus.uml.diagram.activity.edit.parts.CallBehaviorActionNameEditPart#getParser()
	 * 
	 * @return
	 */

	IParser customParser;

	@Override
	public IParser getParser() {
		if(customParser == null) {
			customParser = UMLParserProvider.getParser(UMLElementTypes.CallBehaviorAction_3008, getParserElement(), UMLVisualIDRegistry.getType(org.eclipse.papyrus.uml.diagram.activity.edit.parts.CallBehaviorActionNameEditPart.VISUAL_ID));
		}
		return customParser;
	}

	public CustomInteractionUseNameEditPart(final View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

}
