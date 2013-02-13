/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal;

import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder;


/**
 * Simple implementation of {@link ICurrentFolderAndPageMngr}.
 * This implementation always return the first valid folder in the SashModel.
 * Setting the active page as no effect.
 * 
 * @author cedric dumoulin
 *
 */
public class DefaultCurrentFolderAndPageMngr implements ICurrentFolderAndPageMngr {

	protected SashWindowsMngr diSashModel;
	
	public DefaultCurrentFolderAndPageMngr(SashWindowsMngr diSashModel) {
		this.diSashModel = diSashModel;
	}

	/**
	 * Get the first valid folder.
	 *
	 * @return
	 */
	public TabFolder getCurrentFolder() {
		return diSashModel.getSashModel().lookupFirstFolder();
	}

	/**
	 * Do nothing
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal.ICurrentFolderAndPageMngr#setActivePage(java.lang.Object)
	 *
	 * @param pageIdentifier
	 */
	public void setActivePage(Object pageIdentifier) {
		// do nothing

	}

}
