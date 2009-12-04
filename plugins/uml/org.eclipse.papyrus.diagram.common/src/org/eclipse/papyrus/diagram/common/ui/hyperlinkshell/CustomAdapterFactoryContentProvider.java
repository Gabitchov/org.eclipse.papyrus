/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.ui.hyperlinkshell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr;

/**
 * The Class CustomAdapterFactoryContentProvider to display uml element + attached diagrams
 */
public class CustomAdapterFactoryContentProvider extends AdapterFactoryContentProvider {

	/**
	 * Instantiates a new custom adapter factory content provider.
	 * 
	 * @param adapterFactory
	 *        the adapter factory
	 */
	public CustomAdapterFactoryContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getChildren(Object object) {
		Object[] result = super.getChildren(object);
		ArrayList diagfound = lookForAttachedDiagram(object);
		if(diagfound.size() == 0) {
			return result;
		}
		diagfound.addAll(Arrays.asList(result));

		return diagfound.toArray();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasChildren(Object object) {
		if(object instanceof Diagram) {
			return false;
		}
		ArrayList diagfound = lookForAttachedDiagram(object);

		return super.hasChildren(object) || diagfound.isEmpty();
	}

	/**
	 * Look for attached diagram.
	 * 
	 * @param object
	 *        the object
	 * 
	 * @return the array list
	 */
	public ArrayList lookForAttachedDiagram(Object object) {
		ArrayList result = new ArrayList();
		IPageMngr iPageMngr = (IPageMngr)EditorUtils.getIPageMngr();
		Iterator iter = iPageMngr.allPages().iterator();
		while(iter.hasNext()) {
			Diagram diag = (Diagram)iter.next();
			if(diag.getElement().equals(object)) {
				result.add(diag);
			}
		}
		return result;
	}

}
