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
package org.eclipse.papyrus.widgets.selectors;

import org.eclipse.papyrus.widgets.editors.IElementSelector;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * A selector for String values, or values that can be represented
 * as text in general.
 * Displays a field where the user can enter the new values.
 * The field can be multiline or single line
 * 
 * @author Camille Letavernier
 * 
 */
public class StringSelector implements IElementSelector {

	/**
	 * The text box used to enter a value for this selector
	 */
	protected Text text;

	/**
	 * Indicates if this StringSelector is multiline
	 */
	protected boolean multiline;

	/**
	 * Constructs a single-line String Selector
	 */
	public StringSelector() {
		this(false);
	}

	/**
	 * Constructs a String Selector
	 * 
	 * @param multiline
	 *        True if the string values can contain more than one line
	 */
	public StringSelector(boolean multiline) {
		this.multiline = multiline;
	}

	/**
	 * Returns a single-element array containing the current text
	 * 
	 * @see org.eclipse.papyrus.widgets.IElementSelector#getSelectedElements()
	 */
	public Object[] getSelectedElements() {
		String[] result = new String[]{ text.getText() };
		text.setText(""); //$NON-NLS-1$
		return result;
	}

	/**
	 * Ignored
	 */
	public void setSelectedElements(Object[] elements) {
		//Nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControls(Composite parent) {
		text = new Text(parent, (multiline ? SWT.MULTI : SWT.NONE) | SWT.BORDER);
	}

	/**
	 * Returns the same value as getSelectedElements
	 * 
	 * @see org.eclipse.papyrus.widgets.IElementSelector#getAllElements()
	 */
	public Object[] getAllElements() {
		return getSelectedElements();
	}

	/**
	 * {@inheritDoc}
	 */
	public void newObjectCreated(Object newObject) {
		//Ignored
	}

	/**
	 * {@inheritDoc}
	 */
	public void clearTemporaryElements() {
		//Ignored
	}
}
