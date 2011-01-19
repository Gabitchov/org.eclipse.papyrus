/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.widgets.providers;

import java.util.Collection;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * A Content Provider converting the input list to an array containing the same elements
 * 
 * @author Camille Letavernier
 * 
 */
public class CollectionContentProvider implements IStructuredContentProvider {

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		//Nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		//Nothing
	}

	/**
	 * Converts the input List to an Array containing the same elements
	 * 
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 * 
	 * @param inputElement
	 * @return
	 *         The Array containing the input elements
	 */
	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof Collection) {
			return ((Collection<?>)inputElement).toArray();
		} else if(inputElement instanceof Object[]) {
			return (Object[])inputElement;
		}

		return new Object[]{};
	}
}
