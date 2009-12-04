/***********************************************************************
 * Copyright (c) 2008, 2009 Anyware Technologies, Obeo
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Obeo
 * 
 **********************************************************************/
package org.eclipse.papyrus.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * Provide the content of the given diagram.
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques Lescot</a>
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class DiagramOrientedContentProvider implements ITreeContentProvider {

	private AdapterFactoryContentProvider myAdapterFactoryContentProvider;

	private static final Object[] EMPTY_ARRAY = new Object[0];

	private Diagram diagram;

	public DiagramOrientedContentProvider(AdapterFactoryContentProvider adapterContentProvider) {
		this.myAdapterFactoryContentProvider = adapterContentProvider;
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		// Dispose objects
		myAdapterFactoryContentProvider.dispose();
	}

	/**
	 * {@inheritDoc}
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myAdapterFactoryContentProvider.inputChanged(viewer, oldInput, newInput);
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof Diagram) {
			this.diagram = (Diagram)inputElement;
			List<Object> children = new ArrayList<Object>();
			for(Object object : diagram.getChildren()) {
				if(object instanceof View) {
					View view = (View)object;
					EObject modelElement = ViewUtil.resolveSemanticElement(view);
					children.add(modelElement);
				}
			}
			return children.toArray();
		}
		return EMPTY_ARRAY;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getChildren(Object parentElement) {
		return EMPTY_ARRAY;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getParent(Object element) {
		// The parent of a diagram is the model object that contains it.
		if(element instanceof Diagram) {
			return ((Diagram)element).getElement();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

}
