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

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.papyrus.parsers.texteditor.CompletionFilterSourceViewerConfiguration;
import org.eclipse.papyrus.parsers.texteditor.CompletionFilterSourceViewerConfiguration.ICompletionFilter;
import org.eclipse.papyrus.umlutils.PackageUtil;
import org.eclipse.papyrus.umlutils.TemplateSignatureUtil;
import org.eclipse.papyrus.umlutils.TypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.TemplateableElement;
import org.eclipse.uml2.uml.Type;

/**
 * 
 */
public class TypeCompletionProposalComputer implements ICompletionProposalComputer {

	private static final String UNDEFINED_TYPE = "<Undefined>";

	private Element element;

	/** set up a filter for choice of values */
	private ICompletionFilter completionFilter;

	/** Type of the filtered property */
	private final int propertyType;

	/**
	 * Instantiates a new type completion proposal computer without active filter
	 */
	public TypeCompletionProposalComputer() {
		this.completionFilter = new CompletionFilterSourceViewerConfiguration.NullCompletionFilter();
		this.propertyType = -1;
	}

	/**
	 * Instantiates a new type completion proposal computer with active filter on property
	 * 
	 * @param completionFilter the i completion filter
	 * @param propertyType the property type
	 */
	public TypeCompletionProposalComputer(ICompletionFilter completionFilter, int propertyType) {
		this.completionFilter = completionFilter == null ? new CompletionFilterSourceViewerConfiguration.NullCompletionFilter()
				: completionFilter;
		this.propertyType = propertyType;
	}

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
	 *            the element to set
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
		if (UNDEFINED_TYPE.startsWith(prefix)) {
			proposal = new CompletionProposal(UNDEFINED_TYPE, documentOffset - prefix.length(), prefix.length()
					+ selectionRange, UNDEFINED_TYPE.length(), null, UNDEFINED_TYPE, null, "Undefined Type");
			v.add(proposal);
		}

		if (element != null) {
			// then, all accessible types, by alphabetic order...
			Set<Type> types = computeAccessibleTypeList(element);
			// generate the list of types, in alphabetical order
			Iterator<Type> it = types.iterator();
			while (it.hasNext()) {
				Type type = it.next();
				if (!completionFilter.filter(propertyType, type)) {
					String name = type.getName();
					if (name != null && name.startsWith(prefix)) {
						// create a completion processor for the type if prefix
						// corresponds
						proposal = new CompletionProposal(name, documentOffset - prefix.length(), prefix.length()
								+ selectionRange, name.length(), null, TypeUtil.getInfoString(type), null, "");
						v.add(proposal);
					}
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
	public Set<Type> computeAccessibleTypeList(Element element) {
		LinkedHashSet<Type> list = new LinkedHashSet<Type>();
		// adds directly accessible elements
		list.addAll(PackageUtil.getAccessibleTypes(element.getNearestPackage()));

		// In the context where element is owned by a template,
		// types declared in the context of the template must also be added
		if (element.getOwner() != null && element.getOwner() instanceof TemplateableElement) {
			TemplateableElement template = (TemplateableElement) element.getOwner();
			if (template.isTemplate()) {
				list.addAll(TemplateSignatureUtil.getAccessibleTypes(template.getOwnedTemplateSignature()));
			}
		}

		// adds all elements
		list.addAll(PackageUtil.getAllTypes(element.getNearestPackage()));

		return list;
	}

	/**
	 * Simple comparator for types, based on their names.
	 */
	private class TypeNameComparator implements Comparator<Type> {

		/**
		 * 
		 * 
		 * @param o2
		 * @param o1
		 * 
		 * @return
		 */
		public int compare(Type o1, Type o2) {
			return o1.getName().compareTo(o2.getName());
		}

	}
}
