/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.providers;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.views.search.results.AbstractResultEntry;
import org.eclipse.papyrus.views.search.utils.MatchUtils;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.uml2.uml.Element;

/**
 * 
 * Content provider used by the filter dialog to list available types in a search result
 * 
 */
public class FilterTypeContentProvider implements ITreeContentProvider {

	public void dispose() {

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	public Object[] getElements(Object inputElement) {
		Set<Object> results = new HashSet<Object>();

		if(inputElement instanceof AbstractTextSearchResult) {

			Collection<AbstractResultEntry> matches = MatchUtils.getMatches((AbstractTextSearchResult)inputElement, Element.class, false);

			for(AbstractResultEntry match : matches) {

				results.add(((EObject)match.elementToCheckFilterFor()).eClass());
				results.addAll(((Element)match.elementToCheckFilterFor()).getAppliedStereotypes());

			}
		}

		return results.toArray();
	}

	public Object[] getChildren(Object parentElement) {
		Set<Object> results = new HashSet<Object>();

		return results.toArray();
	}

	public Object getParent(Object element) {
		return null;
	}

	public boolean hasChildren(Object element) {

		return false;
	}

}
