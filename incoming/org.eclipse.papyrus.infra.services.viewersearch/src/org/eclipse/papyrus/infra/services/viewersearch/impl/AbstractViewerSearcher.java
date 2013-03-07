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
package org.eclipse.papyrus.infra.services.viewersearch.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.services.viewersearch.IViewerSearcher;

/**
 * Abstract implementation of a ViewerSearcher.
 */
public abstract class AbstractViewerSearcher implements IViewerSearcher {

	/**
	 * Generic implementation of this method that shouldn't be overridden
	 * 
	 * @see org.eclipse.papyrus.infra.services.viewersearch.IViewerSearcher#getViewers(java.util.Collection,
	 *      org.eclipse.papyrus.infra.core.resource.ModelSet)
	 * 
	 * @param modelElements
	 * @param modelSet
	 * @return
	 */

	public Map<Object, Map<Object, Object>> getViewers(Collection<Object> modelElements, ModelSet modelSet) {
		List<ModelSet> listModelSet = new ArrayList<ModelSet>();
		listModelSet.add(modelSet);

		return getViewers(modelElements, listModelSet);

	}

	/**
	 * Generic implementation of this method that shouldn't be overridden
	 * 
	 * @see org.eclipse.papyrus.infra.services.viewersearch.IViewerSearcher#getViewers(java.lang.Object,
	 *      org.eclipse.papyrus.infra.core.resource.ModelSet)
	 * 
	 * @param modelElement
	 * @param modelSet
	 * @return
	 */

	public Map<Object, Map<Object, Object>> getViewers(Object modelElement, ModelSet modelSet) {
		List<ModelSet> listModelSet = new ArrayList<ModelSet>();
		listModelSet.add(modelSet);

		List<Object> listModelElement = new ArrayList<Object>();
		listModelElement.add(modelElement);

		return getViewers(listModelElement, listModelSet);
	}

	/**
	 * @see org.eclipse.papyrus.infra.services.viewersearch.IViewerSearcher#getViewers(java.util.Collection, java.util.Collection)
	 * 
	 * @param modelElements
	 * @param models
	 * @return
	 */

	public abstract Map<Object, Map<Object, Object>> getViewers(Collection<Object> modelElements, Collection<ModelSet> models);
}
