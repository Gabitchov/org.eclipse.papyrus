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
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Adaptation to AbstractTreeFilter
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.widgets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.facet.infra.facet.FacetReference;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.widgets.providers.AbstractTreeFilter;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;
import org.eclipse.papyrus.views.modelexplorer.SemanticFromModelExplorer;

/**
 * 
 * This a View Filter that use a IHierarchicContentProvider
 *
 */
public class HierarchicViewerFilter extends AbstractTreeFilter {

	/**
	 * a constructor
	 * @param contentProvider that contains isValidValue() in order to know element to filter
	 */
	public HierarchicViewerFilter(IHierarchicContentProvider contentProvider) {
		super();
		this.contentProvider = contentProvider;
	}

	/**
	 *  the content provider
	 */
	protected IHierarchicContentProvider contentProvider;

	@Override
	public boolean hasOneVisibleChild(Viewer viewer, Object element, ITreeContentProvider contentProvider, Set<Object> visitedElements) {
		//TODO : divide this method
		if(useCache && visibleChild.containsKey(element)) {
			return visibleChild.get(element);
		}

		boolean result = false;

		if(visitedElements.add(element)) {
			SemanticFromModelExplorer bridge = new SemanticFromModelExplorer();

			EObject semanticObject = null;
			if(element instanceof IAdaptable) {
				semanticObject = (EObject)bridge.getSemanticElement(element);
			}
			if(element instanceof EObject) {
				semanticObject = (EObject)element;
			}

			if(semanticObject != null) {//it contains nothing
				if(semanticObject instanceof EReference) {
					//Do not display references that are not containment kind
					EReference eReference = (EReference)semanticObject;
					if(isValidReference(eReference)) {
						//this an ereference maybe it references something that is interesting
						Object[] children = contentProvider.getChildren(element);
						for(Object child : children) {
							if(isVisible(viewer, element, child) || hasOneVisibleChild(viewer, child, contentProvider, visitedElements)) {
								result = true;
							}
						}
					}
				}

				if(!result) {

					//it contains something so we have to test children before
					Iterator<EObject> iter = semanticObject.eAllContents();
					while(iter.hasNext()) {
						EObject subEObject = iter.next();
						if(isVisible(viewer, semanticObject, subEObject) || hasOneVisibleChild(viewer, subEObject, contentProvider, visitedElements)) {
							result = true;
							break;
						}
					}

					if(!result) {
						for(EReference eReference : getReferencesToBrowse(semanticObject)) {
							Object values = semanticObject.eGet(eReference);
							if(values instanceof EList) {
								for(Object value : (EList<?>)values) {
									if(isVisible(viewer, semanticObject, value) || hasOneVisibleChild(viewer, value, contentProvider, visitedElements)) {
										result = true;
										break;
									}
								}
							} else if(isVisible(viewer, semanticObject, values) || hasOneVisibleChild(viewer, values, contentProvider, visitedElements)) {
								result = true;
							}
						}
					}
				}
			}

		}

		if(useCache) {
			visibleChild.put(element, result);
		}

		return result;
	}

	protected Set<EReference> getReferencesToBrowse(EObject element) {
		return new HashSet<EReference>();
	}

	protected boolean isValidReference(EReference eReference) {
		return eReference.isContainment() || eReference instanceof FacetReference || getReferencesToBrowse(null).contains(eReference);
	}

	@Override
	public boolean isVisible(Viewer viewer, Object parentElement, Object element) {
		return contentProvider.isValidValue(element);
	}

}
