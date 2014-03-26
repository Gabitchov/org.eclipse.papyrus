/*****************************************************************************
 * Copyright (c) 2011, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 392301
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.sasheditor.contentprovider;

import org.eclipse.swt.graphics.Image;

/**
 * This interface is the root of the hierarchy of models representing Pages.
 * This represent the final element shown in the sashes window.
 * It can be an Editor or a simple control.
 * This interface is used by the sashes window to interact with the model describing the element to be
 * shown in the TabItem.
 * 
 * @author dumoulin
 * 
 */
public abstract interface IPageModel {

	/**
	 * Get the title to be shown in the tab
	 * 
	 * @return
	 */
	public String getTabTitle();

	/**
	 * Get the icon to be shown in the tab
	 * 
	 * @return
	 */
	public Image getTabIcon();

	/**
	 * Get the raw model corresponding to this node.
	 * This is the object provided to {@link ITabFolderModel.getChildren()}
	 * 
	 * @return
	 */
	public Object getRawModel();
	
	/**
	 * Dispose any resources that I have allocated, such as (for example), an {@linkplain #getTabIcon() image}.
	 */
	public void dispose();

}
