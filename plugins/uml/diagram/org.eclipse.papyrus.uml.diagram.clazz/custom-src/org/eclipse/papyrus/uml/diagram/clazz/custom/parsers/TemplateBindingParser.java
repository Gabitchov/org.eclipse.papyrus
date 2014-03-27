/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.custom.parsers;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;

/**
 * this is a parser for binding substitution
 * 
 */
public class TemplateBindingParser implements IParser {

	final ILabelProvider labelProvider = new AdapterFactoryLabelProvider(org.eclipse.papyrus.uml.diagram.clazz.part.UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getEditString(org.eclipse.core.runtime.IAdaptable, int)
	 * 
	 */
	public String getEditString(IAdaptable element, int flags) {
		return getPrintString(element, flags);
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#isValidEditString(org.eclipse.core.runtime.IAdaptable, java.lang.String)
	 * 
	 */
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		// TODO Auto-generated method stub
		return new ParserEditStatus(UMLDiagramEditorPlugin.ID, IParserEditStatus.OK, "");
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getParseCommand(org.eclipse.core.runtime.IAdaptable, java.lang.String, int)
	 * 
	 */
	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		// TODO Auto-generated method stub
		return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getPrintString(org.eclipse.core.runtime.IAdaptable, int)
	 * 
	 */
	public String getPrintString(IAdaptable element, int flags) {
		String out = "";
		if (element instanceof EObjectAdapter) {
			final TemplateBinding binding = ((TemplateBinding) ((EObjectAdapter) element).getRealObject());
			Iterator<TemplateParameterSubstitution> bindIter = binding.getParameterSubstitutions().iterator();
			while (bindIter.hasNext()) {
				TemplateParameterSubstitution substitution = bindIter.next();
				if (substitution.getFormal() != null && substitution.getFormal().getParameteredElement() instanceof NamedElement) {
					out = out + ((NamedElement) substitution.getFormal().getParameteredElement()).getName();
				}
				if (substitution.getActual() instanceof NamedElement) {
					out = out + " -> " + ((NamedElement) substitution.getActual()).getName() + "\n";
				}
			}
		}
		if (out.equals("")) {
			return "<No Binding Substitution>";
		}
		return out;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#isAffectingEvent(java.lang.Object, int)
	 * 
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getCompletionProcessor(org.eclipse.core.runtime.IAdaptable)
	 * 
	 */
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		// TODO Auto-generated method stub
		return null;
	}
}
