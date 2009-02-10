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

import org.eclipse.papyrus.tabbedproperties.core.listeners.PropertyChangeListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * A Property section with a Label and an input text.
 * 
 * @author dumoulin
 * 
 */
public class InputTextControls extends LabeledPropertyEditor implements PropertyEditor {

	/**
	 * The label with its value to be set.
	 */
	protected Text labelText;

	protected String oldTextValue;

	protected PropertyChangeListener<String> propertyChangeListener;

	/**
	 * Listen to user inputs
	 */
	private DirectEditFocusListener listener = new DirectEditFocusListener();

	protected EditKeyAdapter keyAdapter = new EditKeyAdapter();

	public InputTextControls(String label) {
		this(label, "");
	}

	public InputTextControls(String label, String description) {
		super(label, description);
		// label should extends to right
		setRightJustified(true);
	}

	/**
	 * Create the input text.
	 */
	@Override
	protected Control createRightControl(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		// The input Text
		labelText = getWidgetFactory().createText(parent, ""); //$NON-NLS-1$
		labelText.addFocusListener(listener);
		labelText.addKeyListener(keyAdapter);

		return labelText;
	}

	/**
	 * Create controls, with no parent.
	 * 
	 * @param parent
	 * @param aTabbedPropertySheetPage
	 */
	public void createControlsOld(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		// Composite composite = parent;
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		FormData data;

		// The input Text
		labelText = getWidgetFactory().createText(composite, ""); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		labelText.setLayoutData(data);
		labelText.addFocusListener(listener);
		labelText.addKeyListener(keyAdapter);

		// The label, placed
		CLabel labelLabel = getWidgetFactory().createCLabel(composite, "label"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(labelText, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(labelText, 0, SWT.CENTER);
		labelLabel.setLayoutData(data);

		// return composite;
	}

	/**
	 * Set text to be shown.
	 * 
	 * @param text
	 */
	public void setText(String text) {
		if (labelText == null)
			return;
		labelText.removeFocusListener(listener);
		labelText.removeKeyListener(keyAdapter);
		if (text == null)
			text = "";
		oldTextValue = text;
		labelText.setText(text);
		labelText.addFocusListener(listener);
		labelText.addKeyListener(keyAdapter);
	}

	/**
	 * @param listener
	 */
	public void setPropertyChangeListener(PropertyChangeListener<String> listener) {
		propertyChangeListener = listener;
	}

	/**
	 * Read the label value, check if it has change, fireProperty changed if needed.
	 * 
	 * @param newValue
	 */
	protected void checkPropertyChanged() {
		String newValue = labelText.getText().trim();
		// Skip if no change
		if (newValue.equals(oldTextValue))
			return;

		oldTextValue = newValue;
		firePropertyChanged(newValue);
	}

	/**
	 * @param newValue
	 */
	public void firePropertyChanged(String newValue) {
		if (propertyChangeListener == null)
			return;

		propertyChangeListener.propertyChanged(this, newValue);
	}

	@Override
	public void dispose() {
		super.dispose();
		if (!labelText.isDisposed()) {
			labelText.removeFocusListener(listener);
			labelText.removeKeyListener(keyAdapter);
		}
	}

	/**
	 * Sets the value of the text widget
	 * 
	 * @param v
	 *            the value to display
	 */
	public void setValue(Object v) {
		if (v != null) {
			if (labelText != null && !(labelText.isDisposed())) {
				labelText.setText(v.toString());
			}
		}
	}

	/**
	 * Listener for a direct edit manager.
	 * 
	 * @author Remi SCHNEKENBURGER
	 */
	private class DirectEditFocusListener implements org.eclipse.swt.events.FocusListener {

		// check if the name has been changed or not
		/**
		 * 
		 * 
		 * @param e
		 */
		public void focusGained(FocusEvent e) {
			oldTextValue = labelText.getText().trim();
		}

		/**
		 * 
		 * 
		 * @param e
		 */
		public void focusLost(FocusEvent e) {
			checkPropertyChanged();

		}
	}

	/**
	 * 
	 */
	private class EditKeyAdapter extends KeyAdapter {

		/**
		 * @param e
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			// close the text editor and copy the data over
			// when the user hits "ENTER"
			if (e.character == SWT.CR) {
				checkPropertyChanged();

			}
			// close the text editor when the user hits "ESC"
			if (e.character == SWT.ESC) {
				checkPropertyChanged();
			}
		}
	}

}
