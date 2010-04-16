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
package org.eclipse.papyrus.properties.runtime.controller;

import java.util.List;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ViewerFilter;



/**
 * Interface for bounded values controller (references, etc)
 */
public interface IBoundedValuesController extends IPropertyEditorController {

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
	 * Returns the label provider used to display elements in the dialog which looks for values
	 * 
	 * @return the label provider used to display elements in the list which looks for values
	 */
	public ILabelProvider getLabelProvider();

	/**
	 * Returns the label provider used to display elements in the editor
	 * 
	 * @return the label provider used to display elements in the editor
	 */
	public ILabelProvider getEditorLabelProvider();

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

}
