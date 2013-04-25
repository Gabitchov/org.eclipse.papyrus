/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.providers;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * Content provider for the history table
 * 
 * @deprecated Use the generic {@link org.eclipse.papyrus.infra.widgets.providers.CollectionContentProvider#instance} instead
 */
@Deprecated
public class HistoryContentProvider implements IStructuredContentProvider {

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		// nothing here
	}

	/**
	 * {@inheritDoc}
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// nothing here
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof List<?>) {
			return ((List<?>)inputElement).toArray();
		}
		return new Object[0];
	}
}
