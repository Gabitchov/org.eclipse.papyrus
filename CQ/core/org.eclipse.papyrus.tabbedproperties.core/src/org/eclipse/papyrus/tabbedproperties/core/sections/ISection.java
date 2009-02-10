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
package org.eclipse.papyrus.tabbedproperties.core.sections;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.tabbedproperties.core.forms.PropertyEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public interface ISection {

	/**
	 * Delegate construction of the figure to createFigure
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage);

	/**
	 * Create the figure associated to the section. Subclass should implements this method.
	 * 
	 * @return
	 */
	public PropertyEditor createFigure();

	/**
	 * Get the associated figure.
	 * 
	 * @return
	 */
	public PropertyEditor getFigure();

	/**
     * 
     */
	public void aboutToBeShown();

	/**
     * 
     */
	public void aboutToBeHidden();

	/**
     * 
     */
	public void dispose();

	/**
     * 
     */
	public void refresh();

	/**
	 * 
	 * @param part
	 * @param childSelection
	 */
	public void setInput(IWorkbenchPart part, ISelection childSelection);

}