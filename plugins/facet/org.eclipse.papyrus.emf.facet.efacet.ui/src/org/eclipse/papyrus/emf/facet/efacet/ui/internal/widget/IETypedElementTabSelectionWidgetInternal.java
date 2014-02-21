/*******************************************************************************
 * Copyright (c) 2012 CEA-LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Vincent Lorenzo (CEA-LIST) -  Bug 372644 - Create Customizable tooltips for the TreeViewer using a CustomizableLabelProvider
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.ui.internal.widget;

import org.eclipse.swt.graphics.Image;

/**
 * 
 * Each tab in ETypedElementSectionDialog should implements this interface
 * 
 */
public interface IETypedElementTabSelectionWidgetInternal extends
		IETypedElementSelectionWidgetInternal {

	/**
	 * 
	 * @return the title for the tab
	 */
	String getTitle();

	/**
	 * 
	 * @return the tooltip for the tab
	 */
	String getToolTipText();

	/**
	 * 
	 * @return the image for the tab
	 */
	Image getImage();

	/**
	 * 
	 * @return the id for the tab
	 */
	String getTabId();

}