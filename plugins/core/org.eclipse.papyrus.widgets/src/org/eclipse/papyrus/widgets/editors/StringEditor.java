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
package org.eclipse.papyrus.widgets.editors;

import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Text;

/**
 * A Property Editor representing a single-line String value
 * as a Text.
 * This editor's content is validated when the focus is lost,
 * or when the Carriage Return is pressed.
 * 
 * @author Camille Letavernier
 * 
 */
public class StringEditor extends AbstractValueEditor implements KeyListener {

	/**
	 * The text box for editing this editor's value
	 */
	protected Text text;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        The composite in which this editor should be displayed
	 * @param style
	 *        The style for this editor's text box
	 */
	public StringEditor(Composite parent, int style) {
		this(parent, style, null);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        The composite in which this editor should be displayed
	 * @param style
	 *        The style for this editor's text box
	 * @param label
	 *        The label for this editor
	 */
	public StringEditor(Composite parent, int style, String label) {
		super(parent, label);

		text = factory.createText(this, null, style);
		text.setLayoutData(getDefaultLayoutData());
		//text = new Text(this, style);

		//We listen on Carriage Return only if the editor isn't multiline
		if((style & SWT.MULTI) == 0)
			text.addKeyListener(this);

		setWidgetObservable(WidgetProperties.text(SWT.FocusOut).observe(text), true);
	}

	/**
	 * Ignored
	 */
	public void keyPressed(KeyEvent e) {
		//Nothing
	}

	/**
	 * Validates this editor when one of the following events occur :
	 * - CR released
	 * - Keypad CR released
	 * 
	 * @see org.eclipse.swt.events.KeyListener#keyReleased(org.eclipse.swt.events.KeyEvent)
	 * 
	 * @param e
	 */
	public void keyReleased(KeyEvent e) {
		if((e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR) && e.stateMask == SWT.NONE) {
			text.notifyListeners(SWT.FocusOut, new Event());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getEditableType() {
		return String.class;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValue() {
		return text.getText();
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		text.setEnabled(!readOnly);
	}

	@Override
	public boolean isReadOnly() {
		return !text.isEnabled();
	}
}
