/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Javier Muñoz (Prodevelop) – Added ISemanticParser implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.parser.custom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

public class TagsAdderParser implements ISemanticParser {

	private IParser realParser = null;

	public TagsAdderParser(IParser parser) {
		realParser = parser;
	}

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		if (realParser != null) {
			return realParser.getCompletionProcessor(element);
		}
		return null;
	}

	public String getEditString(IAdaptable element, int flags) {
		if (realParser != null) {
			return realParser.getEditString(element, flags);
		}
		return null;
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		if (realParser != null) {
			return realParser.getParseCommand(element, newString, flags);
		}
		return null;
	}

	public String getPrintString(IAdaptable element, int flags) {
		if (realParser != null) {
			String printString = realParser.getPrintString(element, flags);

			return AddTagsToString(printString, element);
		}
		return null;
	}

	public boolean isAffectingEvent(Object event, int flags) {
		if (realParser != null) {
			return realParser.isAffectingEvent(event, flags);
		}
		return false;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		if (realParser != null) {
			return realParser.isValidEditString(element, editString);
		}
		return null;
	}

	private String AddTagsToString(String string, IAdaptable adapter) {
		// TODO: support more tags

		String str = null;

		Element element = (Element) adapter.getAdapter(Element.class);

		List<String> stereotypesNames = getStereotypesNames(element);

		str = StereotypesNamesListToString(stereotypesNames) + " " + string;

		return str;
	}

	/**
	 * @generated NOT
	 */
	protected List<String> getStereotypesNames(Element element) {
		List<String> stereotypesNames = new java.util.LinkedList<String>();

		List<Stereotype> stereotypes = element.getAppliedStereotypes();

		for (Stereotype st : stereotypes) {
			String name = st.getName();
			if (name != null) {
				stereotypesNames.add(name);
			} else {
				stereotypesNames.add("");
			}
		}

		return stereotypesNames;
	}

	/**
	 * @generated NOT
	 */
	protected String StereotypesNamesListToString(List<String> names) {
		String str = "";

		if (names != null) {
			if (names.size() > 0) {
				str += ((char) 171);
				for (Iterator<String> it = names.iterator(); it.hasNext();) {
					str += it.next();
					if (it.hasNext()) {
						str += ", ";
					}
				}
				str += ((char) 187);
			}
		}

		return str;
	}

	public boolean areSemanticElementsAffected(EObject arg0, Object arg1) {
		if (this.realParser instanceof ISemanticParser) {
			return ((ISemanticParser) this.realParser).areSemanticElementsAffected(arg0, arg1);
		} else {
			return false;
		}
	}

	public List getSemanticElementsBeingParsed(EObject arg0) {
		if (this.realParser instanceof ISemanticParser) {

			return ((ISemanticParser) this.realParser).getSemanticElementsBeingParsed(arg0);
		} else {

			List<EObject> semanticElements = new ArrayList<EObject>();
			semanticElements.add(arg0);
			return semanticElements;
		}
	}

}
