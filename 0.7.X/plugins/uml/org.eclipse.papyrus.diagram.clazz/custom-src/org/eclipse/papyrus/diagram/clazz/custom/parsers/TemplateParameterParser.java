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
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ClassifierTemplateParameter;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.UMLPackage;
/**
 *this parser is used to display parameter of a template 
 *
 */
public class TemplateParameterParser implements IParser {

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getCompletionProcessor(org.eclipse.core.runtime.IAdaptable)
	 *
	 * @param element
	 * @return
	 */
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEditString(IAdaptable element, int flags) {
		return getPrintString(element, flags);
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {

		ICommand command=UnexecutableCommand.INSTANCE;
		if(element instanceof EObjectAdapter) {
			final TemplateParameter templateParam = ((TemplateParameter)((EObjectAdapter)element).getRealObject());
			if(newString.contains("<UNDEFINED>")) {
				return UnexecutableCommand.INSTANCE;
			}


			if(templateParam.getParameteredElement() instanceof NamedElement) {
				NamedElement namedElement = (NamedElement)templateParam.getParameteredElement();
				String name=newString.substring(0, newString.indexOf(":"));

				SetRequest request = new SetRequest(namedElement, UMLPackage.eINSTANCE.getNamedElement_Name(),name.trim());
				command=new SetValueCommand(request);
			}
		}
		return command;


	}

	public String getPrintString(IAdaptable element, int flags) {
		if(element instanceof EObjectAdapter) {
			final TemplateParameter templateParam = ((TemplateParameter)((EObjectAdapter)element).getRealObject());
			if(templateParam.getParameteredElement() == null) {
				return "<UNDEFINED>";
			}
			String out = "";


			if(templateParam.getParameteredElement() instanceof NamedElement) {
				NamedElement namedElement = (NamedElement)templateParam.getParameteredElement();
				out = namedElement.getName() + ": " + namedElement.eClass().getName();
			}
			if( templateParam instanceof ClassifierTemplateParameter){
				if(!((ClassifierTemplateParameter)templateParam).getConstrainingClassifiers().isEmpty()) {
					out = out + ">";
					for(int i = 0; i < ((ClassifierTemplateParameter)templateParam).getConstrainingClassifiers().size(); i++) {
						out = out + ((ClassifierTemplateParameter)templateParam).getConstrainingClassifiers().get(i).getName();
						if(i < ((ClassifierTemplateParameter)templateParam).getConstrainingClassifiers().size() - 1) {
							out = out + ", ";
						}
					}

				}
			}
			return out;

		}

		return "<UNDEFINED>";
	}

	public boolean isAffectingEvent(Object event, int flags) {
		return true;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.EDITABLE_STATUS;
	}


}
