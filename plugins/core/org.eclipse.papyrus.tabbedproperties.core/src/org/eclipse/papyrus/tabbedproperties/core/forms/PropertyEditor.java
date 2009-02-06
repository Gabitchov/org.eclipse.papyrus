/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.tabbedproperties.core.forms;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * Represent a single property Editor. Such Editor are generally bound to primitive type, not to bussiness complexe Classes.
 */
public interface PropertyEditor {

	/**
     */
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage);

	/**
	 * Return the associated main control.
	 */
	// public Composite getControl();
	/**
	 * Initialize the controls. TODO Remove this method from the interface
	 * 
	 * @deprecated
	 */
	// public void initializeControls();
	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#aboutToBeShown()
	 */
	public void aboutToBeShown();

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#aboutToBeHidden()
	 */
	public void aboutToBeHidden();

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#dispose()
	 */
	public void dispose();

}
