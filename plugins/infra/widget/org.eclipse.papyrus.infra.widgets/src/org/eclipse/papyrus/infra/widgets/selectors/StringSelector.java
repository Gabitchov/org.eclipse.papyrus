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
package org.eclipse.papyrus.infra.widgets.selectors;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.papyrus.infra.widgets.editors.IElementSelectionListener;
import org.eclipse.papyrus.infra.widgets.editors.IElementSelector;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
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

	public static final String LINE_SEPARATOR = System.getProperty("line.separator");

	/**
	 * The text box used to enter a value for this selector
	 */
	protected Text text;

	/**
	 * Indicates if this StringSelector is multiline
	 */
	protected boolean multiline;

	protected Set<IElementSelectionListener> elementSelectionListeners = new HashSet<IElementSelectionListener>();

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
	 * {@link IElementSelector#getSelectedElements()}
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
		text = new Text(parent, SWT.MULTI | SWT.BORDER);
		text.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				//Nothing
			}

			public void keyReleased(KeyEvent e) {
				if((e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR) && ((e.stateMask == SWT.NONE && !multiline) || ((e.stateMask & SWT.CTRL) != 0 && multiline))) {
					if(!elementSelectionListeners.isEmpty()) {
						String str = (String)getSelectedElements()[0];
						if(str.endsWith(LINE_SEPARATOR)) {
							str = str.substring(0, str.length() - LINE_SEPARATOR.length());
						}
						if(!"".equals(str)) { //$NON-NLS-1$
							for(IElementSelectionListener listener : elementSelectionListeners) {
								listener.addElements(new Object[]{ str });
							}
						}
					}
				}
			}

		});
	}

	/**
	 * Returns the same value as getSelectedElements
	 * 
	 * {@link IElementSelector#getAllElements()}
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

	public void addElementSelectionListener(IElementSelectionListener listener) {
		elementSelectionListeners.add(listener);
	}
}
