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
package org.eclipse.papyrus.infra.emf.compare.ui.provider;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;

/**
 * 
 * The classes implements this interface when they are in charge of resfreshing Viewer
 * 
 */
public interface ILabelProviderRefreshingViewer extends IBaseLabelProvider{

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
