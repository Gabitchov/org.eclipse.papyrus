/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.properties.fieldeditor;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;


/**
 * Implementation of dynamic combo field editor. Add {@link IDynamicFieldEditor} interface behavior to standard combo field editor.
 * 
 * @see org.eclipse.jface.preference.ComboFieldEditor
 * 
 * @author gpascual
 *
 */
public class InputComboFieldEditor extends FieldEditor implements IDynamicFieldEditor {

	/**
	 * The <code>Combo</code> widget.
	 */
	private Combo combo = null;

	/**
	 * The value (not the name) of the currently selected item in the Combo widget.
	 */
	private String value = null;

	/**
	 * The names (labels) and underlying values to populate the combo widget. These should be
	 * arranged as: { {name1, value1}, {name2, value2}, ...}
	 */
	private String[][] fEntryNamesAndValues = null;

	/**
	 * Create the combo box field editor.
	 * 
	 * @param name
	 *        the name of the preference this field editor works on
	 * @param labelText
	 *        the label text of the field editor
	 * @param entryNamesAndValues
	 *        the names (labels) and underlying values to populate the combo widget. These should be
	 *        arranged as: { {name1, value1}, {name2, value2}, ...}
	 * @param parent
	 *        the parent composite
	 */
	public InputComboFieldEditor(String name, String labelText, String[][] entryNamesAndValues, Composite parent) {
		init(name, labelText);
		Assert.isTrue(checkArray(entryNamesAndValues));
		fEntryNamesAndValues = entryNamesAndValues;
		createControl(parent);
	}

	/**
	 * Checks whether given <code>String[][]</code> is of "type" <code>String[][2]</code>.
	 *
	 * @return <code>true</code> if it is ok, and <code>false</code> otherwise
	 */
	private boolean checkArray(String[][] table) {
		if(table == null) {
			return false;
		}
		for(int i = 0; i < table.length; i++) {
			String[] array = table[i];
			if(array == null || array.length != 2) {
				return false;
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#adjustForNumColumns(int)
	 */
	@Override
	protected void adjustForNumColumns(int numColumns) {
		if(numColumns > 1) {
			Control control = getLabelControl();
			int left = numColumns;
			if(control != null) {
				((GridData)control.getLayoutData()).horizontalSpan = 1;
				left = left - 1;
			}
			((GridData)combo.getLayoutData()).horizontalSpan = left;
		} else {
			Control control = getLabelControl();
			if(control != null) {
				((GridData)control.getLayoutData()).horizontalSpan = 1;
			}
			((GridData)combo.getLayoutData()).horizontalSpan = 1;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#doFillIntoGrid(org.eclipse.swt.widgets.Composite, int)
	 */
	@Override
	protected void doFillIntoGrid(Composite parent, int numColumns) {
		int comboC = 1;
		if(numColumns > 1) {
			comboC = numColumns - 1;
		}
		Control control = getLabelControl(parent);
		GridData gd = new GridData();
		gd.horizontalSpan = 1;
		control.setLayoutData(gd);
		control = getComboBoxControl(parent);
		gd = new GridData();
		gd.horizontalSpan = comboC;
		gd.horizontalAlignment = GridData.FILL;
		control.setLayoutData(gd);
		control.setFont(parent.getFont());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#doLoad()
	 */
	@Override
	protected void doLoad() {
		updateComboForValue(getPreferenceStore().getString(getPreferenceName()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#doLoadDefault()
	 */
	@Override
	protected void doLoadDefault() {
		updateComboForValue(getPreferenceStore().getDefaultString(getPreferenceName()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#doStore()
	 */
	@Override
	protected void doStore() {
		if(value == null) {
			getPreferenceStore().setToDefault(getPreferenceName());
			return;
		}
		getPreferenceStore().setValue(getPreferenceName(), value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#getNumberOfControls()
	 */
	@Override
	public int getNumberOfControls() {
		return 2;
	}

	/*
	 * Lazily create and return the Combo control.
	 */
	private Combo getComboBoxControl(Composite parent) {
		if(combo == null) {
			combo = new Combo(parent, SWT.READ_ONLY);
			combo.setFont(parent.getFont());
			for(int i = 0; i < fEntryNamesAndValues.length; i++) {
				combo.add(fEntryNamesAndValues[i][0], i);
			}

			combo.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent evt) {
					String oldValue = value;
					String name = combo.getText();
					value = getValueForName(name);
					setPresentsDefaultValue(false);
					fireValueChanged(VALUE, oldValue, value);
				}
			});
		}
		return combo;
	}

	/*
	 * Given the name (label) of an entry, return the corresponding value.
	 */
	private String getValueForName(String name) {
		for(int i = 0; i < fEntryNamesAndValues.length; i++) {
			String[] entry = fEntryNamesAndValues[i];
			if(name.equals(entry[0])) {
				return entry[1];
			}
		}
		return fEntryNamesAndValues[0][0];
	}

	/*
	 * Set the name in the combo widget to match the specified value.
	 */
	private void updateComboForValue(String value) {
		this.value = value;
		for(int i = 0; i < fEntryNamesAndValues.length; i++) {
			if(value.equals(fEntryNamesAndValues[i][1])) {
				combo.setText(fEntryNamesAndValues[i][0]);
				return;
			}
		}
		if(fEntryNamesAndValues.length > 0) {
			value = fEntryNamesAndValues[0][1];
			combo.setText(fEntryNamesAndValues[0][0]);
		}
	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditor#setEnabled(boolean, org.eclipse.swt.widgets.Composite)
	 *
	 * @param enabled
	 * @param parent
	 */
	@Override
	public void setEnabled(boolean enabled, Composite parent) {
		super.setEnabled(enabled, parent);
		getComboBoxControl(parent).setEnabled(enabled);
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.properties.fieldeditor.IDynamicFieldEditor#setInput(java.lang.Object)
	 *
	 * @param input
	 */
	public void setInput(Object input) {

		if(input.getClass().equals(fEntryNamesAndValues.getClass())) {
			fEntryNamesAndValues = (String[][])input;
		}

		combo.removeAll();
		for(int i = 0; i < fEntryNamesAndValues.length; i++) {
			combo.add(fEntryNamesAndValues[i][0], i);
		}

		doLoad();

	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.properties.fieldeditor.IDynamicFieldEditor#setSelection(java.lang.String)
	 *
	 * @param newValue
	 */
	public void setSelection(String newValue) {
		String oldValue = this.value;
		updateComboForValue(newValue);
		fireValueChanged(VALUE, oldValue, newValue);

	}
}
