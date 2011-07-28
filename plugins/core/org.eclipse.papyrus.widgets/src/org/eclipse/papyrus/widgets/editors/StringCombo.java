/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.papyrus.widgets.providers.EncapsulatedContentProvider;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;

/**
 * A Widget for editing a String with an editable combo.
 * The combo proposes a set of default values.
 * 
 * @author Camille Letavernier
 */
public class StringCombo extends ReferenceCombo {

	public StringCombo(Composite parent, int style) {
		super(parent, style);
		combo.setEditable(true);
	}

	public StringCombo(Composite parent, int style, String label) {
		super(parent, style, label);
	}

	@Override
	public Object getEditableType() {
		return String.class;
	}

	/**
	 * Sets the content provider for this combo. The Content provider should
	 * specify the objects that can be referred by this property
	 * 
	 * @param provider
	 */
	@Override
	public void setContentProvider(IStaticContentProvider provider) {
		if(provider != null) {
			viewer.setContentProvider(new EncapsulatedContentProvider(provider));
			viewer.setInput(""); //$NON-NLS-1$
		}

		setWidgetObservable(new CComboObservableValue());
	}

	class CComboObservableValue extends AbstractObservableValue implements SelectionListener, KeyListener, FocusListener {

		private String previousValue;

		public CComboObservableValue() {
			previousValue = combo.getText();
			combo.addSelectionListener(this); //Selection change
			combo.addKeyListener(this); //Enter pressed
			combo.addFocusListener(this); //Focus lost
		}

		public Object getValueType() {
			return String.class;
		}

		@Override
		protected String doGetValue() {
			return combo.getText();
		}

		@Override
		protected void doSetValue(Object value) {
			if(value instanceof String) {
				previousValue = combo.getText();
				combo.setText((String)value);
			}
		}

		//Enter pressed
		public void keyReleased(KeyEvent e) {
			if((e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR) && e.stateMask == SWT.NONE) {
				doFireChange();
				e.doit = false; //Stops the propagation of the event
			}
		}

		//Selection change
		public void widgetSelected(SelectionEvent e) {
			doFireChange();
		}

		//Focus lost
		public void focusLost(FocusEvent e) {
			doFireChange();
		}

		private void doFireChange() {
			final String oldValue = previousValue;
			final String currentValue = previousValue = doGetValue();
			fireValueChange(new ValueDiff() {

				@Override
				public Object getOldValue() {
					return oldValue;
				}

				@Override
				public Object getNewValue() {
					return currentValue;
				}
			});
		}

		public void widgetDefaultSelected(SelectionEvent e) {
			//Nothing
		}

		public void focusGained(FocusEvent e) {
			//Nothing
		}

		public void keyPressed(KeyEvent e) {
			//Nothing
		}

	}

}
