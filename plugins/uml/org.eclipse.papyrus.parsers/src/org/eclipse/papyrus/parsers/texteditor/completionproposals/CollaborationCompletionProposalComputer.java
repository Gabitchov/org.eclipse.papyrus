/*****************************************************************************
 * Copyright (c) 2008, 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *  Yann TANGUY (CEA LIST) yann.tanguy@cea.fr
 *
 *****************************************************************************/
package org.eclipse.papyrus.parsers.texteditor.completionproposals;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.papyrus.umlutils.PackageUtil;
import org.eclipse.papyrus.umlutils.TypeUtil;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.Element;

/**
 * 
 */
public class CollaborationCompletionProposalComputer implements ICompletionProposalComputer {

	/**
	 * 
	 */
	private Element element;

	/**
	 * 
	 */
	private static final String UNDEFINED_TYPE = "<Undefined>";

	/**
	 * 
	 * 
	 * @return the element
	 */
	public Element getElement() {
		return element;
	}

	/**
	 * 
	 * 
	 * @param element
	 *        the element to set
	 */
	public void setElement(Element element) {
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
			proposal = new CompletionProposal(UNDEFINED_TYPE, documentOffset - prefix.length(), prefix.length()
					+ selectionRange, UNDEFINED_TYPE.length(), null, UNDEFINED_TYPE, null, "Undefined Type");
			v.add(proposal);
		}

		if(element != null) {
			// then, all accessible types, by alphabetic order...
			Set<Collaboration> types = computeAccessibleCollaborationList(element);
			// generate the list of types, in alphabetical order
			Iterator<Collaboration> it = types.iterator();
			while(it.hasNext()) {
				Collaboration type = it.next();
				String name = type.getName();
				if(name.startsWith(prefix)) {
					// create a completion processor for the type if prefix
					// corresponds
					proposal = new CompletionProposal(name, documentOffset - prefix.length(), prefix.length()
							+ selectionRange, name.length(), null, TypeUtil.getInfoString(type), null, "");
					v.add(proposal);
				}
			}
		}
		return v;
	}

	/**
	 * 
	 * 
	 * @param element
	 * 
	 * @return
	 */
	public Set<Collaboration> computeAccessibleCollaborationList(Element element) {
		LinkedHashSet<Collaboration> list = new LinkedHashSet<Collaboration>();
		// adds directly accessible elements
		list.addAll(PackageUtil.getAccessibleCollaborations(element.getNearestPackage()));

		// adds all elements
		list.addAll(PackageUtil.getAllCollaborations(element.getNearestPackage()));

		return list;
	}
}
