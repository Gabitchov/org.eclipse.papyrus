/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Support for AdaptableContentProvider
 *
 *****************************************************************************/

package org.eclipse.papyrus.views.modelexplorer.widgets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.BigListItem;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.widgets.providers.IAdaptableContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.views.modelexplorer.MoDiscoContentProvider;
import org.eclipse.papyrus.views.modelexplorer.SemanticFromModelExplorer;

/**
 * This is a modisco content provider on which we can parameter the root element
 */
public class ModelContentProvider extends MoDiscoContentProvider implements IStaticContentProvider, IAdaptableContentProvider {

	/**
	 * the root element of the tree explorer
	 */
	protected EObject semanticRoot = null;


	/**
	 * The StructuredViewer on which this content provider is applied
	 */
	protected StructuredViewer viewer;

	public ModelContentProvider(EObject semanticRoot) {
		this.semanticRoot = semanticRoot;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getElements() {
		return super.getElements(EditorUtils.getMultiDiagramEditor().getServicesRegistry());
	}

	@Override
	public EObject[] getRootElements(Object inputElement) {
		//if the semantic root is null, we use the default behavior
		if(semanticRoot == null) {
			return super.getRootElements(inputElement);
		} else {
			//we call the super, to ensure that all variable are initialized
			super.getRootElements(inputElement);
			EObject[] eobjectArray = { semanticRoot };
			return eobjectArray;
		}
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if(viewer instanceof StructuredViewer) {
			this.viewer = (StructuredViewer)viewer;
		} else {
			this.viewer = null;
		}
	}

	public Object getAdaptedValue(Object selection) {
		if(selection instanceof IAdaptable) {
			EObject adapted = (EObject)((IAdaptable)selection).getAdapter(EObject.class);
			if(adapted != null) {
				return adapted;
			}
		}
		return selection;
	}

	public Object getContainerValue(Object selection) {
		if(selection instanceof EObject && viewer != null) {
			Object root = viewer.getInput();
			List<Object> rootElements = Arrays.asList(((ITreeContentProvider)viewer.getContentProvider()).getElements(root));
			List<Object> path = searchPath((EObject)selection, rootElements, new HashSet<Object>());
			if(!path.isEmpty()) {
				Object treeElement = path.get(path.size() - 1);
				return treeElement;
			}
		}
		return selection;
	}

	/**
	 * look for the path the list of element (comes from the content provider) to go the eObject
	 * 
	 * @param eobject
	 *        that we look for.
	 * @param wrappers
	 *        a list of elements where eobject can be wrapped.
	 * @param visitedElements
	 *        this parameters maintains the list of visited semantic elements,
	 *        to avoid infinite loops in infinite trees
	 * @return the list of modelElementItem ( from the root to the element that wrap the eobject)
	 */
	protected List<Object> searchPath(EObject lookFor, List<Object> wrappers, Set<Object> visitedElements) {

		if(lookFor == null) {
			return Collections.emptyList();
		}
		SemanticFromModelExplorer semanticGetter = new SemanticFromModelExplorer();
		List<Object> path = new ArrayList<Object>();

		for(Object wrapper : wrappers) {
			Object semanticElement = semanticGetter.getSemanticElement(wrapper);
			if(visitedElements.contains(semanticElement)) {
				continue;
			}

			if(!(semanticElement instanceof EReference)) {
				// Don't mark references themselves as visited, as they are meta-level singletons that should always be re-visited.
				visitedElements.add(semanticElement);
			}

			if(!isVisible(wrapper)) {
				continue;
			}

			// Search matches in this level
			if(!(wrapper instanceof Diagram) && wrapper instanceof IAdaptable) {
				if(lookFor.equals(semanticElement)) {
					path.add(wrapper);
					return path;
				}
			}

			// Find childs only for feature container and BigListItems
			//FIXME : Actually, we currently browse all references. We should only browse containment references
			//and a few specific references (To be determined by implementers, such as importPackage for UML)
			Object[] children = getChildren(wrapper);
			for(Object treeItem : children) {
				List<Object> tmppath = new ArrayList<Object>();
				if(treeItem instanceof BigListItem) {
					List<Object> childs = new ArrayList<Object>();
					childs.add(treeItem);
					tmppath = searchPath(lookFor, childs, visitedElements);
				} else {
					//can  be change into IADAPTER by using new API of modisco
					Object element = semanticGetter.getSemanticElement(treeItem);
					if(element != null) {
						if(element instanceof EReference) {
							List<Object> childs = new ArrayList<Object>();
							childs.add(treeItem);
							tmppath = searchPath(lookFor, childs, visitedElements);
						} else if(element instanceof EObject) {
							List<Object> childs = new ArrayList<Object>();
							childs.add(treeItem);
							tmppath = searchPath(lookFor, childs, visitedElements);
						}
					}
				}

				// if tmppath contains the wrapped eobject we have find the good path
				if(tmppath.size() > 0) {
					if(tmppath.get(tmppath.size() - 1) instanceof IAdaptable) {
						if(lookFor.equals(semanticGetter.getSemanticElement(tmppath.get(tmppath.size() - 1)))) {
							path.add(wrapper);
							path.addAll(tmppath);
							return path;
						}
					}
				}
			}
		}

		return new ArrayList<Object>();
	}

	protected boolean isVisible(Object wrapper) {
		for(ViewerFilter filter : viewer.getFilters()) {
			if(!filter.select(viewer, null, wrapper)) {
				return false;
			}
		}
		return true;
	}
}
