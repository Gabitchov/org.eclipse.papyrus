/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;

import org.eclipse.swt.widgets.Composite;

/**
 * An interface for defining widgets that can return
 * some values.
 * 
 * @author Camille Letavernier
 * 
 */
public interface IElementSelector {

	/**
	 * 
	 * @return The currently selected elements
	 */
	public Object[] getSelectedElements();

	/**
	 * Sets the elements that have already been chosen.
	 * 
	 * @param elements
	 */
	public void setSelectedElements(Object[] elements);

	/**
	 * 
	 * @return all displayed elements. If the widget uses a filter,
	 *         only the filtered elements should be returned
	 */
	public Object[] getAllElements();

	/**
	 * Creates the widgets to display this selector
	 * 
	 * @param parent
	 */
	public void createControls(Composite parent);

	/**
	 * Handles the "newObjectCreated" event
	 * 
	 * @param newObject
	 *        The object that has been created
	 */
	public void newObjectCreated(Object newObject);

	/**
	 * Clears this selector. Removes all temporary elements that
	 * may have been created.
	 */
	public void clearTemporaryElements();

	/**
	 * Adds a new listener to this selector.
	 * The selector can inform the listener that new elements have
	 * been selected
	 * 
	 * @param listener
	 */
	public void addElementSelectionListener(IElementSelectionListener listener);

	/**
	 * Removes the element selection listener
	 * 
	 * @param listener
	 * 
	 * @see {@link #addElementSelectionListener(IElementSelectionListener)}
	 */
	public void removeElementSelectionListener(IElementSelectionListener listener);

}
