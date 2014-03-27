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
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.configuration.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * Represents a content provider for a hierarchy of Ecore objects
 * @author Laurent Wouters
 */
public class ECoreModelContentProvider implements ITreeContentProvider {
	/**
	 * Represents the top object to be passed as input for to the viewer using this provider
	 */
	public static final Object ROOT = new Object();
	
	private EObject root;
	
	/**
	 * Initializes this provider with the given object as root
	 * @param root The root object
	 */
	public ECoreModelContentProvider(EObject root) {
		this.root = root;
	}
	
	public void dispose() { }

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) { }

	public Object[] getElements(Object inputElement) {
		return new Object[] { root };
	}

	public Object[] getChildren(Object parentElement) {
		if (parentElement == ROOT)
			return new Object[] { root };
		EObject origin = (EObject)parentElement;
		return origin.eContents().toArray();
	}

	public Object getParent(Object element) {
		if (element == ROOT)
			return null;
		EObject child = (EObject)element;
		return child.eContainer();
	}

	public boolean hasChildren(Object element) {
		if (element == ROOT)
			return true;
		EObject origin = (EObject)element;
		return !origin.eContents().isEmpty();
	}
}
