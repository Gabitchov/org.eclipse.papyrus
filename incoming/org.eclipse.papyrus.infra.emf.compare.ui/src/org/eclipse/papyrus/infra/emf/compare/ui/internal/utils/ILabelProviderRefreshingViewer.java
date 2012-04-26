/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.ui.internal.utils;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TreeViewer;

/**
 * 
 * The classes implements this interface when they are in charge of resfreshing Viewer
 * 
 */
//this interface must have a package visibility
interface ILabelProviderRefreshingViewer extends ILabelProvider {

	/**
	 * Register a viewer to refresh it
	 * 
	 * @param viewer
	 *        a viewer
	 */
	public void registerViewer(TreeViewer viewer);

	/**
	 * viewer are refresh in this methods
	 */
	public void refreshViewer();

	/**
	 * Unregister a viewer
	 * 
	 * @param viewer
	 *        a viewer
	 */
	public void unregisterViewer(final TreeViewer viewer);
}
