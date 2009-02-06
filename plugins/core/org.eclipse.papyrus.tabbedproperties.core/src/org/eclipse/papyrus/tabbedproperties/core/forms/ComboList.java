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
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * An editors made of a combo list. Only one item can be selected at a time. The items are created from a descriptor made of couple (label, value) where label is the label associated to the item, and
 * value is the value associated to the item.
 * 
 * @author dumoulin
 * 
 */
public class ComboList<ReturnedValueType> implements PropertyEditor, ControlWrapper {

	/**
	 * The resulting figure
	 */
	protected CCombo combo;

	// protected Object[] buttonDescriptor;
	protected String[] names;

	protected ReturnedValueType[] values;

	/**
	 * Client listener
	 */
	protected PropertyChangeListener<ReturnedValueType> propertyChangeListener;

	protected ReturnedValueType lastSelectedValue;

	/**
	 * Listen to user inputs
	 */
	private SelectionListener listener;

	/**
	 * Create empty combo list
	 */
	public ComboList() {
		names = new String[0];
		values = (ReturnedValueType[]) new Object[0];
	}

	/**
	 * 
	 * @param buttonDescriptor
	 */
	public ComboList(String[] names, ReturnedValueType[] values) {
		if (names.length != values.length)
			throw new IllegalArgumentException("Array sizes must be equals.");
		this.names = names;
		this.values = values;
	}

	/**
	 * 
	 * @param buttonDescriptor
	 */
	public ComboList(Object[] labelsAndValues) {
		setInternalLists(labelsAndValues);
	}

	/**
	 * Set or reset the selectable values (shown and returned).
	 * 
	 * @param labelsAndValues
	 *            An array of couples (item, value)
	 */
	public void setSelectableValues(Object[] labelsAndValues) {
		if (combo == null) {
			setInternalLists(labelsAndValues);
			return;
		}

		// Combo already exists
		combo.removeAll();
		setInternalLists(labelsAndValues);

		// Add names to combo
		for (int i = 0; i < names.length; i++) {
			// Create one button
			combo.add(names[i]);
		} // end loop
	}

	/**
	 * Set the internal list from provided couple of arguments.
	 * 
	 * @param labelsAndValues
	 */
	@SuppressWarnings("unchecked")
	private void setInternalLists(Object[] labelsAndValues) {
		// Reset internal lists
		int itemCount = labelsAndValues.length / 2;
		names = new String[itemCount];
		values = (ReturnedValueType[]) new Object[itemCount];

		for (int i = 0; i < itemCount; i++) {
			names[i] = (String) labelsAndValues[i * 2];
			values[i] = (ReturnedValueType) labelsAndValues[(i * 2) + 1];
		}
	}

	/**
	 * Create the buttons.
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		// super.createControls(parent, tabbedPropertySheetPage);

		combo = new CCombo(parent, SWT.NONE);

		for (int i = 0; i < names.length; i++) {
			// Create one button
			combo.add(names[i]);
		} // end loop

		// Listen on change
		listener = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				checkPropertyChanged();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};
		combo.addSelectionListener(listener);

		// return combo;
	}

	/**
	 * Get the associated
	 * 
	 * @return
	 */
	public Composite getControl() {
		return combo;
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

		// Check if all is ok
		if (combo.isDisposed())
			return;

		removeAllListener();
		// set the values
		combo.select(getIndexByType(newValue));

		// Set last selection
		lastSelectedValue = newValue;

		// set listener
		addAllListener();
	}

	/**
	 * Get index in the combo by the associated type
	 * 
	 * @param newValue
	 * @return
	 */
	private int getIndexByType(ReturnedValueType newValue) {

		for (int i = 0; i < values.length; i++) {
			if (values[i].equals(newValue))
				return i;
		}
		// Not found : use default
		return 0;
	}

	/**
	 * Get index in the combo by the associated type
	 * 
	 * @param newValue
	 * @return
	 */
	private ReturnedValueType getTypeByIndex(int index) {

		return values[index];
	}

	/**
	 * Remove all local listener
	 */
	private void addAllListener() {
		combo.addSelectionListener(listener);
	}

	/**
	 * Remove local listener
	 */
	private void removeAllListener() {
		if (combo.isDisposed() == false) {
			combo.removeSelectionListener(listener);
		}
	}

	/**
	 * @param listener
	 */
	public void setPropertyChangeListener(PropertyChangeListener<ReturnedValueType> listener) {
		propertyChangeListener = listener;
	}

	/**
	 * Check if the property has change. If true, fire an event.
	 * 
	 * @param newValue
	 */
	public void checkPropertyChanged() {

		int selectedIndex = combo.getSelectionIndex();
		ReturnedValueType selectedType = getTypeByIndex(selectedIndex);

		if (selectedType.equals(lastSelectedValue))
			return;

		firePropertyChanged(selectedType);
	}

	/**
	 * @param newValue
	 */
	public void firePropertyChanged(ReturnedValueType newValue) {
		if (propertyChangeListener == null)
			return;

		propertyChangeListener.propertyChanged(this, newValue);
	}

	public void aboutToBeShown() {
		// super.aboutToBeShown();
		// Listen to the model
		addAllListener();
	}

	public void aboutToBeHidden() {
		// Stop listening
		removeAllListener();
		// super.aboutToBeHidden();
	}

	public void dispose() {
		// stop listening
		removeAllListener();
		combo.dispose();
		// super.dispose();
	}

	public void setValue(Object v) {
		setSelected((ReturnedValueType) v);
	}

}
