/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.propertyeditor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IBoundedValuesPropertyEditorDescriptor;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;


/**
 * Property editors for enumeration
 */
public class ComboPropertyEditor extends AbstractPropertyEditor {

	/** id of this editor */
	public static final String ID = "org.eclipse.papyrus.views.properties.runtime.comboPropertyEditor";

	/** main composite created by this property editor */
	private Composite composite;

	/** list of available elements */
	protected List<String> values = new ArrayList<String>();

	/** combo that edit values */
	private CCombo combo;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Composite createContent(Composite parent) {
		composite = getWidgetFactory().createComposite(parent, SWT.NONE);
		int columnNu = getColumnNumber();
		GridLayout layout = new GridLayout(columnNu, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		composite.setLayout(layout);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		composite.setLayoutData(data);

		if((getDescriptor().getLabelPosition() & (SWT.LEFT | SWT.TOP)) != 0) {
			createLabel(composite);
		}

		combo = getWidgetFactory().createCCombo(composite, SWT.FLAT | SWT.BORDER | SWT.READ_ONLY);
		combo.setItems(values.toArray(new String[]{}));
		data = new GridData(SWT.FILL, SWT.FILL, true, false);
		combo.setLayoutData(data);
		getWidgetFactory().adapt(combo);
		combo.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				handleContentChanged();
			}

			public void focusGained(FocusEvent e) {
			}
		});
		combo.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				handleContentChanged();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		combo.setEnabled(!getIsReadOnly());

		if((getDescriptor().getLabelPosition() & (SWT.RIGHT | SWT.BOTTOM)) != 0) {
			createLabel(composite);
		}

		combo.setToolTipText(getTooltipText());

		return composite;
	}

	/**
	 * Returns the number of column for the composite
	 * 
	 * @return the number of column for the composite
	 */
	protected int getColumnNumber() {
		if((getDescriptor().getLabelPosition() & (SWT.TOP | SWT.BOTTOM)) != 0) {
			return 1;
		}
		return 2;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		if(isValid(composite)) {
			composite.dispose();
			composite = null;
			setController(null);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDisposed() {
		if(composite == null) {
			return true;
		}
		return composite.isDisposed();
	}

	/**
	 * Returns the current String value or <code>null</code> if no elements were selected
	 */
	@Override
	public Object getValue() {
		if(isValid(combo)) {
			int index = combo.getSelectionIndex();
			if(index >= 0 && index < values.size()) {
				return values.get(index);
			}
		} else {
			Activator.log.error("trying to read the value of the combo whereas the combo is disposed", null);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleContentChanged() {
		// this should tells the controller that the input has to be applied to the model
		getController().updateModel();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus init(IPropertyEditorDescriptor descriptor) {
		setDescriptor(descriptor);
		setTooltipText(descriptor.getTooltipText());
		if(descriptor instanceof IBoundedValuesPropertyEditorDescriptor) {
			List<?> values = ((IBoundedValuesPropertyEditorDescriptor)descriptor).getAvailableValues();
			if(values != null) {
				for(Object object : values) {
					this.values.add(object.toString());
				}
			}
			return Status.OK_STATUS;
		}
		return new Status(IStatus.ERROR, Activator.ID, "Impossible to initialize the editor using descriptor :" + descriptor);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(Object valueToEdit) {
		if(!isValid(combo)) {
			return;
		}
		if(valueToEdit instanceof String) {
			String newValue = (String)valueToEdit;
			if(values == null) {
				return;
			}
			int index = values.indexOf(newValue);
			if(index >= 0) {
				combo.select(values.indexOf(newValue));
			} else {
				Activator.log.error("Impossible to get the value " + valueToEdit + " in the list of available values", null);
			}
		}
	}
}
