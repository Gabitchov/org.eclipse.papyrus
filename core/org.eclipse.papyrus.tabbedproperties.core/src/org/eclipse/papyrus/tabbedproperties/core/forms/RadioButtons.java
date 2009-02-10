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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.tabbedproperties.core.listeners.PropertyChangeListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * An editors made of radio buttons. Only one button is selected at a time. The buttons are created from a descriptor made of couple (label, value) where label is the label associated to the button,
 * and value is the value associated to the button.
 * 
 * @author dumoulin
 * 
 */
public class RadioButtons<ReturnedValueType> extends AbstractPropertyEditor implements ControlWrapper {

	/**
	 * List of created controls
	 */
	protected List<Button> buttons = new ArrayList<Button>();

	/**
	 * The resulting figure
	 */
	protected Composite compositeFigure;

	protected Object[] buttonDescriptor;

	protected PropertyChangeListener<ReturnedValueType> propertyChangeListener;

	protected ReturnedValueType lastSelectedValue;

	/**
	 * Listen to user inputs
	 */
	private DirectEditSelectionListener listener = new DirectEditSelectionListener();

	private String label = "";

	/**
	 * 
	 * @param buttonDescriptor
	 */
	public RadioButtons(String label, Object[] labelsAndValues) {
		this.buttonDescriptor = labelsAndValues;
		this.label = label;
	}

	/**
	 * Create the buttons.
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		Composite composite = getWidgetFactory().createComposite(parent);
		if (parent instanceof ExpandableComposite) {
			((ExpandableComposite) parent).setClient(composite);
		}
		composite.setLayout(new FormLayout());
		FormData data;

		final CLabel displayLabel = getWidgetFactory().createCLabel(composite, label); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 10);
		data.top = new FormAttachment(0, 1);
		displayLabel.setLayoutData(data);

		Button previousButton = null;
		Button button;
		for (int i = 0; i < buttonDescriptor.length; i += 2) {
			// Create one button
			String buttonName = (String) buttonDescriptor[i];

			button = getWidgetFactory().createButton(composite, buttonName, SWT.RADIO);
			data = new FormData();
			// Set positions
			if (i == 0) { // First element
				data.left = new FormAttachment(displayLabel, 20);
				data.top = new FormAttachment(0, 0);
			} else if (i + 1 == buttonDescriptor.length) { // last element
				data.left = new FormAttachment(previousButton, 20);
				data.right = new FormAttachment(100, 0);
				data.top = new FormAttachment(0, 0);
			} else { // middle elements
				data.left = new FormAttachment(previousButton, 20);
				data.top = new FormAttachment(0, 0);
			}

			button.setLayoutData(data);
			button.addSelectionListener(listener);

			buttons.add(button);
			previousButton = button;
		} // end loop
		compositeFigure = composite;

		// return composite;
	}

	public Composite getControl() {
		return compositeFigure;
	}

	/**
	 * Set the selected button by its value.
	 * 
	 * @param value
	 */
	public void setSelected(ReturnedValueType newValue) {

		// Do nothing if it is already set
		if (lastSelectedValue == newValue)
			return;

		// Check if all buttons are ok
		for (Button button : buttons) {
			if (button.isDisposed())
				return;
		} // end loop

		removeAllButtonsListener();
		// set the values
		int i = 0;
		for (Button button : buttons) {
			// System.out.println(this.getClass().getName() + ".setSelected(" + getButtonValue(i) + "==" + newValue + ")");

			button.setSelection(getButtonValue(i++).equals(newValue));
		} // end loop

		// Set last selection
		lastSelectedValue = newValue;

		// set listener
		addAllButtonListener();
	}

	/**
	 * Get the value associated to the button at the specified index.
	 * 
	 * @param i
	 * @return
	 */
	private Object getButtonValue(int i) {

		return buttonDescriptor[i * 2 + 1];
	}

	/**
	 * Remove the listener for each button
	 */
	private void addAllButtonListener() {
		for (Button button : buttons) {
			button.addSelectionListener(listener);
		} // end loop

	}

	private void removeAllButtonsListener() {
		for (Button button : buttons) {
			if (!button.isDisposed()) {
				button.removeSelectionListener(listener);
			}
		} // end loop
	}

	/**
	 * @param listener
	 */
	public void setPropertyChangeListener(PropertyChangeListener<ReturnedValueType> listener) {
		propertyChangeListener = listener;
	}

	/**
	 * @param newValue
	 */
	public void firePropertyChanged(ReturnedValueType newValue) {
		if (propertyChangeListener == null)
			return;

		propertyChangeListener.propertyChanged(this, newValue);
	}

	/**
	 * Listener for a direct edit manager.
	 * 
	 */
	protected class DirectEditSelectionListener implements org.eclipse.swt.events.SelectionListener {

		/**
		 * A button has been selected
		 * 
		 * @param e
		 */
		@SuppressWarnings("unchecked")
		public void widgetSelected(SelectionEvent e) {
			// Look up which button trigger the event
			int index = buttons.indexOf(e.getSource());

			if (index == -1)
				throw new Error("Can't find selected item for radio button.");

			// Return the corresponding value
			ReturnedValueType newValue = (ReturnedValueType) buttonDescriptor[index * 2 + 1];

			if (newValue != lastSelectedValue) {
				lastSelectedValue = newValue;
				firePropertyChanged(newValue);
			}
		}

		/**
		 * 
		 * 
		 * @param e
		 */
		public void widgetDefaultSelected(SelectionEvent e) {
		}
	}

	/**
	 * Get the left button, that is the first one.
	 * 
	 * @return
	 */
	public List<Button> getControls() {
		return buttons;
	};

	@Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		addAllButtonListener();
	}

	@Override
	public void aboutToBeHidden() {
		// Stop listening
		removeAllButtonsListener();
		super.aboutToBeHidden();
	}

	@Override
	public void dispose() {
		// stop listening
		removeAllButtonsListener();
		super.dispose();
	}

}
