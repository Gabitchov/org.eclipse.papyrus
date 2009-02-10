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
 * Editor implementing this interface can be added as child of a group of controls.
 * 
 * @author dumoulin
 * 
 */
public interface ControlGroupChild {

	/**
	 * Dispatch to children.
	 */
	public void aboutToBeHidden();

	/**
	 * Dispatch to children.
	 */
	public void aboutToBeShown();

	/**
	 * Dispatch to children.
	 */
	public void dispose();

	/**
	 * Create all figures children of this group, if any.
	 * 
	 * @return ControlNode
	 */
	public void createAllChildren();

	/**
	 * Create all controls, local and children of this group. This method should not be implemented by the class.
	 * 
	 * @param parent
	 * @param aTabbedPropertySheetPage
	 */
	public void createAllControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage);

	/**
	 * Give a chance to initialize controls after all controls have been created.
	 */
	public void initializeAllControls();

}