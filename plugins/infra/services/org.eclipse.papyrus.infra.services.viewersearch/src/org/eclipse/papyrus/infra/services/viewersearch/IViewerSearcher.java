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
package org.eclipse.papyrus.infra.services.viewersearch;

import java.util.Collection;
import java.util.Map;

import org.eclipse.papyrus.infra.core.resource.ModelSet;

/**
 * The Interface for the viewersearchservice that viewersearch must implement to contribute to this service
 */
public interface IViewerSearcher {

	/**
	 * Gets the modelElements's viewers in a collection of modelSet.
	 * 
	 * @param modelElements
	 *        the model elements to find viewers for
	 * @param models
	 *        the collection of modelSet to search in
	 * @return (modelset, (viewer, modelElement)): for each modelset, a map of (viewer, modelElement)
	 */
	Map<Object, Map<Object, Object>> getViewers(Collection<Object> modelElements, Collection<ModelSet> models);

	/**
	 * Gets the modelElements's viewers in a modelSet.
	 * 
	 * @param modelElements
	 *        the model elements to find viewers for
	 * @param model
	 *        the modelSet to search in
	 * @return (modelset, (viewer, modelElement)): for each modelset, a map of (viewer, modelElement)
	 */
	Map<Object, Map<Object, Object>> getViewers(Collection<Object> modelElements, ModelSet model);

	/**
	 * Gets the modelElement's viewers in a modelSet.
	 * 
	 * @param modelElement
	 *        the model element to find viewers for
	 * @param model
	 *        the modelSet to search in
	 * @return (modelset, (viewer, modelElement)): for each modelset, a map of (viewer, modelElement)
	 */
	Map<Object, Map<Object, Object>> getViewers(Object modelElement, ModelSet model);

}
