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
package org.eclipse.papyrus.uml.diagram.interactionoverview.provider;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CallBehaviorActionNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLParserProvider;
import org.eclipse.papyrus.uml.diagram.interactionoverview.parser.CustomCallBehaviorActionParser;


public class CustomUMLParserProvider extends UMLParserProvider {

	@Override
	public boolean provides(IOperation operation) {
		if(operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation)operation).getHint();
			
			if(hint!=null) {
				Diagram diagram = (Diagram)hint.getAdapter(Diagram.class);
				if(diagram!=null) {
					if(ElementTypes.DIAGRAM_ID.equals(diagram.getType())) {
						if(UMLElementTypes.getElement(hint) == null) {
							return false;
						}
						return getParser(hint) != null;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return super.provides(operation);
	}



	/**
	 * @see org.eclipse.papyrus.uml.diagram.activity.providers.UMLParserProvider#getParser(int)
	 * 
	 * @param visualID
	 * @return
	 */

	@Override
	protected IParser getParser(final int visualID) {
		switch(visualID) {
		case CallBehaviorActionNameEditPart.VISUAL_ID:
			return getCallBehaviorActionLabel_5004Parser();
		default:
			return super.getParser(visualID);
		}
		// TODO Auto-generated method stub

	}

	private IParser getCallBehaviorActionLabel_5004Parser() {
		if(custom_callBehaviorActionLabel_5004Parser == null) {
			final CustomCallBehaviorActionParser parser = new CustomCallBehaviorActionParser();
			custom_callBehaviorActionLabel_5004Parser = parser;
		}
		return custom_callBehaviorActionLabel_5004Parser;
	}

	private IParser custom_callBehaviorActionLabel_5004Parser;
}
