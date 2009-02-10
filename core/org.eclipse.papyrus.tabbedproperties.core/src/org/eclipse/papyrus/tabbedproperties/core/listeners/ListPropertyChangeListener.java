/*******************************************************************************
 * Copyright (c) 2008 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.tabbedproperties.core.listeners;

import org.eclipse.papyrus.tabbedproperties.core.forms.PropertyEditor;

/**
 * A listener used to listen to property change in the editor.
 * 
 * @author Patrick Tessier
 */
public interface ListPropertyChangeListener<PropertyType> {

	/**
	 * used to remove a value
	 * 
	 * @param editor
	 *            the section
	 * @param removedValue
	 *            the value that will be removed
	 */
	public void removeValue(PropertyEditor editor, PropertyType removedValue);

	/**
	 * used to add a value
	 * 
	 * @param editor
	 *            the section
	 * @param newValue
	 *            the value that will be added
	 */
	public void addValue(PropertyEditor editor, PropertyType newValue);

	/**
	 * used to move a value
	 * 
	 * @param editor
	 *            the section
	 * @param newValue
	 *            the value that will be moved at the new index
	 * @param newIndex
	 *            the new position in the list
	 */
	public void moveValue(PropertyEditor editor, PropertyType newValue, int newIndex);
}
