/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
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

package org.eclipse.papyrus.sasheditor.contentprovider.di.internal;

import java.util.List;

import org.eclipse.papyrus.sasheditor.contentprovider.IAbstractPanelModel;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashPanelModel;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageModelFactory;
import org.eclipse.papyrus.sashwindows.di.SashPanel;
import org.eclipse.papyrus.sashwindows.di.TabFolder;


/**
 * @author cedric dumoulin
 */
public class SashPanelModel implements IAbstractPanelModel, ISashPanelModel {

	/**
	 * Factory used to create PageModel.
	 */
	private IPageModelFactory pageModelFactory;
	
	/**
	 * The underlying di node.
	 */
	private SashPanel sashPanel;
	
	/**
	 * 
	 * @param sashPanel
	 */
	public SashPanelModel(SashPanel sashPanel, IPageModelFactory pageModelFactory) {
		this.sashPanel = sashPanel;
		this.pageModelFactory = pageModelFactory;
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.ISashPanelModel#getChildren()
	 *
	 * @return
	 */
	public List<?> getChildren() {
		return sashPanel.getChildren();
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.ISashPanelModel#createChildSashModel(java.lang.Object)
	 *
	 * @param child
	 * @return
	 */
	public IAbstractPanelModel createChildSashModel(Object child) {
		if(child instanceof SashPanel)
			return new SashPanelModel((SashPanel)child, pageModelFactory);
		else if(child instanceof TabFolder)
			return new TabFolderModel((TabFolder)child, pageModelFactory);
		else
			throw new IllegalArgumentException("Can't create IPanelModel from raw model '" + child + "'.");
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.ISashPanelModel#getSashDirection()
	 *
	 * @return
	 */
	public int getSashDirection() {
		return sashPanel.getDirection();
	}

}
