/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.parsers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.TemplateParameter;

public class TemplateParameterParser implements IParser {

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEditString(IAdaptable element, int flags) {
		// TODO Auto-generated method stub
		return null;
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrintString(IAdaptable element, int flags) {
		if (element instanceof EObjectAdapter) {
			final TemplateParameter templateParam = ((TemplateParameter) ((EObjectAdapter) element).getRealObject());
			if (templateParam.getOwnedParameteredElement() == null) {
				return "<UNDEFINED>";
			}
			if (templateParam.getOwnedParameteredElement() instanceof NamedElement) {
				NamedElement namedElement = (NamedElement) templateParam.getOwnedParameteredElement();
				return namedElement.getName() + ": " + namedElement.eClass().getName();
			}

		}

		return "<UNDEFINED>";
	}

	public boolean isAffectingEvent(Object event, int flags) {
		// TODO Auto-generated method stub
		return true;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		// TODO Auto-generated method stub
		return null;
	}

}
