/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.parsers.texteditor.completionproposals;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.TemplateableElement;

/**
 * 
 */
public class TypeCompletionProposalComputer implements ICompletionProposalComputer {

	/**
	 * 
	 */
	private org.eclipse.papyrus.umlutils.Element element;

	/**
	 * 
	 */
	private static final String UNDEFINED_TYPE = "<Undefined>";

	/**
	 * 
	 * 
	 * @return the element
	 */
	public org.eclipse.papyrus.umlutils.Element getElement() {
		return element;
	}

	/**
	 * 
	 * 
	 * @param element the element to set
	 */
	public void setElement(org.eclipse.papyrus.umlutils.Element element) {
		this.element = element;
	}

	/**
	 * 
	 * 
	 * @param selectionRange 
	 * @param prefix 
	 * @param documentOffset 
	 * 
	 * @return 
	 */
	public List<ICompletionProposal> generateCompletionProposals(int documentOffset, int selectionRange, String prefix) {
		Vector<ICompletionProposal> v = new Vector<ICompletionProposal>();

		// adds each Completion proposal
		ICompletionProposal proposal = null;

		// first, add <Undefined> 
		if(UNDEFINED_TYPE.startsWith(prefix)) {
			proposal = new CompletionProposal(UNDEFINED_TYPE, documentOffset-prefix.length(), prefix.length()+selectionRange, UNDEFINED_TYPE.length(), null, UNDEFINED_TYPE, null, "Undefined Type");
			v.add(proposal);
		}

		if(element != null) {
			// then, all accesible types, by alphabetic order...
			List<org.eclipse.papyrus.umlutils.Type> types = computeAccessibleTypeList(element);
			//generate the list of types, in alphabetical order
			Iterator<org.eclipse.papyrus.umlutils.Type> it = types.iterator();
			while(it.hasNext()) {
				org.eclipse.papyrus.umlutils.Type type = it.next();
				String name = type.getName();
				if(name.startsWith(prefix)) {
					// create a completion processor for the type if prefix corresponds
					proposal = new CompletionProposal(name, documentOffset-prefix.length(), prefix.length()+selectionRange, name.length(), null, type.getInfoString(), null, "");
					v.add(proposal);
				}
			}
		}
		return v;
	}

	/**
	 * 
	 * 
	 * @param utilsElement 
	 * 
	 * @return 
	 */
	public List<org.eclipse.papyrus.umlutils.Type> computeAccessibleTypeList(org.eclipse.papyrus.umlutils.Element utilsElement) {
		return computeAccessibleTypeList(utilsElement.getUml2Element());
	}

	/**
	 * 
	 * 
	 * @param element 
	 * 
	 * @return 
	 */
	public List<org.eclipse.papyrus.umlutils.Type> computeAccessibleTypeList(Element element) {
		List<org.eclipse.papyrus.umlutils.Type> list= new Vector<org.eclipse.papyrus.umlutils.Type>();
		org.eclipse.papyrus.umlutils.Package contextPackage = new org.eclipse.papyrus.umlutils.Package(element.getNearestPackage());

		// get the list in alphabetical order.
		list.addAll(contextPackage.getAccessibleTypes());

		// In the context where element is owned by a template,
		// types declared in the context of the template must also be added
		if (element.getOwner() != null && element.getOwner() instanceof TemplateableElement) {
			TemplateableElement template = (TemplateableElement)element.getOwner() ;
			if (template.isTemplate()) {
				list.addAll(new org.eclipse.papyrus.umlutils.TemplateSignature(template.getOwnedTemplateSignature()).getAccessibleTypes()) ;
			}
		}
		
		orderByName(list);
		return list;
	}

	/**
	 * 
	 * 
	 * @param types 
	 */
	private void orderByName(List<org.eclipse.papyrus.umlutils.Type> types) {
		Collections.sort(types, new TypeNameComparator());
	}

	/**
	 * Simple comparator for types, based on their names.
	 */
	private class TypeNameComparator implements Comparator<org.eclipse.papyrus.umlutils.Type> {
		
		/**
		 * 
		 * 
		 * @param o2 
		 * @param o1 
		 * 
		 * @return 
		 */
		public int compare(org.eclipse.papyrus.umlutils.Type o1, org.eclipse.papyrus.umlutils.Type o2) {
			return o1.getName().compareTo(o2.getName());
		}

	}
}
