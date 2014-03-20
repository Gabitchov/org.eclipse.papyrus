/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.preferences;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Represents a preference combo field, which content can be updated
 * @author Laurent Wouters
 */
public class UpdatableComboBoxFieldEditor extends FieldEditor {

	private Control label;
	private Combo widget;
	private EObject prefValue;
	private List<EObject> data;
	private EAttribute attribute;
	
	/**
	 * Initializes the field
	 * @param preference The target preference
	 * @param label The displayed label
	 * @param parent The parent component
	 */
	public UpdatableComboBoxFieldEditor(String preference, String label, Composite parent) {
		init(preference, label);
		this.data = new ArrayList<EObject>();
		this.label = getLabelControl(parent);
		this.widget = new Combo(parent, SWT.READ_ONLY);
		this.widget.setFont(parent.getFont());
		this.widget.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				EObject oldValue = prefValue;
				prefValue = null;
				String name = widget.getText();
				if (name != null) {
					for (EObject obj : data) {
						if (name.equals(getLabelFor(obj))) {
							prefValue = obj;
							break;
						}
					}
				}
				setPresentsDefaultValue(false);
				fireValueChanged(VALUE, oldValue, prefValue);					
			}
		});
		createControl(parent);
	}
	
	/**
	 * Gets the selected value
	 * @return The selection
	 */
	public EObject getSelection() { return prefValue; }
	
	/**
	 * Sets the selected value
	 * @param obj The selection as an EObject
	 */
	public void setSelection(EObject obj) {
		prefValue = obj;
		widget.setText(getLabelFor(prefValue));
	}
	
	/**
	 * Sets the selected value
	 * @param value The selection as its display value
	 */
	public void setSelection(String value) {
		load(value);
	}
	
	
	/**
	 * Changes the content of the combo
	 * @param data The new data
	 * @param attribute The attribute used to get readable text from the data
	 */
	public void setContent(List<? extends EObject> data, EAttribute attribute) {
		this.data = new ArrayList<EObject>(data);
		this.attribute = attribute;
		widget.removeAll();
		for (EObject obj : this.data)
			widget.add(getLabelFor(obj));
		prefValue = this.data.get(0);
		widget.setText(getLabelFor(prefValue));
	}
	
	/**
	 * Removes all content
	 */
	public void clearContent() {
		data = new ArrayList<EObject>();
		prefValue = null;
		widget.removeAll();
	}
	
	/**
	 * Gets the string representation of the given object
	 * @param object An object
	 * @return Its string representation
	 */
	private String getValueFor(EObject object) {
		Object value = object.eGet(attribute);
		return (value == null ? null : value.toString());
	}
	
	/**
	 * Gets the display string of the given object
	 * @param object An object
	 * @return The display string
	 */
	private String getLabelFor(EObject object) {
		Object value = object.eGet(attribute);
		return (value == null ? null : value.toString());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.FieldEditor#adjustForNumColumns(int)
	 */
	protected void adjustForNumColumns(int numColumns) {
		return;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.FieldEditor#doFillIntoGrid(org.eclipse.swt.widgets.Composite, int)
	 */
	protected void doFillIntoGrid(Composite parent, int numColumns) {
		int comboC = 1;
		if (numColumns > 1) {
			comboC = numColumns - 1;
		}
		GridData gd = new GridData();
		gd.horizontalSpan = 1;
		label.setLayoutData(gd);
		
		gd = new GridData();
		gd.horizontalSpan = comboC;
		gd.horizontalAlignment = GridData.FILL;
		widget.setLayoutData(gd);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.FieldEditor#doLoad()
	 */
	protected void doLoad() {
		load(getPreferenceStore().getString(getPreferenceName()));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.FieldEditor#doLoadDefault()
	 */
	protected void doLoadDefault() {
		load(getPreferenceStore().getDefaultString(getPreferenceName()));
	}
	
	/**
	 * Loads the display data from the given value for selection
	 * @param value
	 */
	private void load(String value) {
		prefValue = null;
		if (value != null) {
			for (EObject obj : data) {
				if (value.equals(getValueFor(obj))) {
					prefValue = obj;
					widget.setText(getLabelFor(obj));
					return;
				}
			}
		}
		if (data.size() > 0) {
			prefValue = data.get(0);
			widget.setText(getLabelFor(prefValue));
		} else {
			widget.setText(null);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.FieldEditor#doStore()
	 */
	protected void doStore() {
		if (prefValue == null) {
			getPreferenceStore().setToDefault(getPreferenceName());
			return;
		}
		getPreferenceStore().setValue(getPreferenceName(), getValueFor(prefValue));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.FieldEditor#getNumberOfControls()
	 */
	public int getNumberOfControls() {
		return 2;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#setEnabled(boolean,
	 *      org.eclipse.swt.widgets.Composite)
	 */
	public void setEnabled(boolean enabled, Composite parent) {
		super.setEnabled(enabled, parent);
		widget.setEnabled(enabled);
	}
}
