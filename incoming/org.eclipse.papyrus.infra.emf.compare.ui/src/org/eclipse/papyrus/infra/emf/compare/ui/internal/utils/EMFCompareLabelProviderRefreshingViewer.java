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

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.emf.compare.ui.provider.EMFCompareLabelProvider;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;

/**
 * 
 * This Label provider is used when the editor doesn't manage itself the viewers.
 * This label provider allows to refresh the viewers which used it
 * 
 */
//this class must have a package visibility
final class EMFCompareLabelProviderRefreshingViewer extends EMFCompareLabelProvider implements ILabelProviderRefreshingViewer {

	/** the list of the registered viewer */
	private final Collection<TreeViewer> viewers;

	public EMFCompareLabelProviderRefreshingViewer(final CustomizationManager customizationManager) {
		super(customizationManager);
		this.viewers = new HashSet<TreeViewer>();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.compare.ui.internal.utils.ILabelProviderRefreshingViewer#registerViewer(org.eclipse.jface.viewers.TreeViewer)
	 * 
	 * @param viewer
	 */
	public void registerViewer(final TreeViewer viewer) {
		final DisposeListener listener = new DisposeListener() {

			public void widgetDisposed(final DisposeEvent e) {
				viewer.getTree().removeDisposeListener(this);
				unregisterViewer(viewer);
			}
		};
		viewer.getTree().addDisposeListener(listener);
		viewers.add(viewer);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.compare.ui.internal.utils.ILabelProviderRefreshingViewer#refreshViewer()
	 * 
	 */
	public void refreshViewer() {
		for(TreeViewer current : viewers) {
			if(!current.getTree().isDisposed()) {
				current.refresh();
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.compare.ui.internal.utils.ILabelProviderRefreshingViewer#unregisterViewer(org.eclipse.jface.viewers.TreeViewer)
	 * 
	 * @param viewer
	 */
	public void unregisterViewer(final TreeViewer viewer) {
		viewers.remove(viewer);
	}
}
