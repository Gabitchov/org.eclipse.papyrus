/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.controller;

import java.util.List;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ViewerFilter;



/**
 * Interface for bounded values controller (references, etc)
 */
public interface IBoundedValuesController extends ILabelProviderController {

	/**
	 * Returns the list of available elements
	 * 
	 * @return the list of available elements
	 */
	public Object getAvailableValues();

	/**
	 * Returns the list of current values
	 * 
	 * @return the list of current values
	 */
	public Object[] getCurrentValues();

	/**
	 * Returns the set of filters used to display the tree
	 * 
	 * @return the set of filters used to display the tree
	 */
	public List<ViewerFilter> getViewerFilters();

	/**
	 * Returns the content provider for the viewer
	 * 
	 * @return the content provider for the viewer
	 */
	public IContentProvider getContentProvider();

	/**
	 * Returns the label provider used to display elements in the reference browser
	 * 
	 * @return the label provider used to display elements in the reference browser
	 */
	public ILabelProvider getBrowserLabelProvider();

}
