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

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.papyrus.widgets.databinding.TextObservableValue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Text;

/**
 * A Property Editor representing a single-line or multi-line String value
 * as a Text.
 * This editor's content is validated when the focus is lost,
 * or, if the editor is single-line, when the Carriage Return is pressed.
 * For a multi-line editor, ctrl+enter will also validate the editor's content.
 * 
 * @see SWT#MULTI
 * 
 * @author Camille Letavernier
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

		GridData data = getDefaultLayoutData();

		if((style & SWT.MULTI) != 0) {
			data.heightHint = 55;
			style = style | SWT.V_SCROLL;
		}

		text = factory.createText(this, null, style);
		text.setLayoutData(data);

		if(label != null) {
			super.label.setLayoutData(getLabelLayoutData());
		}

		text.addKeyListener(this);

		setCommitOnFocusLost(text);
	}

	@Override
	protected GridData getLabelLayoutData() {
		GridData result = super.getLabelLayoutData();
		if(text != null) {
			if((text.getStyle() & SWT.MULTI) != 0) {
				result.verticalAlignment = SWT.BEGINNING;
			}
		}
		return result;
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
	 * - Ctrl + [CR | Keypad CR] released
	 * 
	 * @see org.eclipse.swt.events.KeyListener#keyReleased(org.eclipse.swt.events.KeyEvent)
	 * 
	 * @param e
	 */
	public void keyReleased(KeyEvent e) {
		//We listen on Carriage Return or Ctrl+ Carriage return, depending on
		//whether the editor is single- or multi-line
		if(e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR) {
			if((text.getStyle() & SWT.MULTI) == 0) { //Single-line : Enter
				if(e.stateMask == SWT.NONE) {
					notifyChange();
				}
			} else { //Multi-line : Ctrl+Enter
				if(e.stateMask == SWT.CTRL) {
					notifyChange();
				}
			}
		}
	}

	@Override
	public void setModelObservable(IObservableValue observable) {
		setWidgetObservable(new TextObservableValue(text, observable, SWT.FocusOut), true);
		super.setModelObservable(observable);
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

	protected void notifyChange() {
		text.notifyListeners(SWT.FocusOut, new Event());
		commit();
	}

	@Override
	public void setToolTipText(String tooltip) {
		text.setToolTipText(tooltip);
		super.setLabelToolTipText(tooltip);
	}

	/**
	 * Sets the current text value for this editor
	 * 
	 * @param value
	 */
	public void setValue(String value) {
		this.text.setText(value);
	}
}
