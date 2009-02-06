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
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * A figure made of a group of controls. The section calls createControls, which in turn calls the following methods : - createControls - initializeControls - aboutToBeShown - aboutToBeHidden -
 * dispose()
 * 
 * @author dumoulin
 */
public interface ControlGroup extends PropertyEditor, ControlGroupChild {

	/**
	 * Add a control to the list.
	 * 
	 * @param control
	 */
	public void add(ControlGroupChild control);

	/**
	 * Add a control to the list.
	 * 
	 * @param control
	 */
	public void add(PropertyEditor control);

	/**
	 * Create all the controls. Also dispatch to the children.
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage);

	/**
	 * Return the associated main control.
	 */
	public Composite getControl();

	/**
	 * Create figures children of this Group. This method should be implemented by the class. Each created child should be added using add(ControlGroup).
	 * 
	 * @return ControlNode
	 */
	public void createDirectChildren();

	/**
	 * Create controls owned by this group. The returned control is used as parent of children' controls.
	 * 
	 * @param parent
	 */
	public Control createLocalControls(Composite parent);

	/**
	 * Give a chance to initialize locally created controls. This method should be implemented by the class.
	 */
	public void initializeLocalControl();

}