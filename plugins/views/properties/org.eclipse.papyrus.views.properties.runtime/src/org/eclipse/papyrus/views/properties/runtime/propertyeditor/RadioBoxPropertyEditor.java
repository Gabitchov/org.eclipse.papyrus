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
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;


/**
 * Property editors for enumeration
 */
public class RadioBoxPropertyEditor extends AbstractPropertyEditor {

	/** id of this editor */
	public static final String ID = "org.eclipse.papyrus.views.properties.runtime.radioBoxPropertyEditor";

	/** main composite created by this property editor */
	protected Composite composite;

	/** list of available elements */
	protected List<String> values = new ArrayList<String>();

	/** list of radio buttons */
	protected List<Button> buttons = new ArrayList<Button>();

	/** listener for the radio buttons */
	protected SelectionListener listener = new RadioButtonListener();

	/**
	 * Creates a new RadioBoxPropertyEditor
	 */
	public RadioBoxPropertyEditor() {
	}

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

		// create the set of radio-boxes. Does not know the size of the grid used for this editor
		for(String value : values) {
			Button button = getWidgetFactory().createButton(composite, (!value.equals("") ? value : "<Unset>"), SWT.RADIO);
			if(!getIsReadOnly()) {
				button.setEnabled(true);
				button.addSelectionListener(listener);	
			} else {
				button.setEnabled(false);
			}
			buttons.add(button);
			button.setToolTipText(getTooltipText());
		}

		if((getDescriptor().getLabelPosition() & (SWT.RIGHT | SWT.BOTTOM)) != 0) {
			createLabel(composite);
		}

		return composite;
	}

	/**
	 * Returns the number of column for the composite
	 * 
	 * @return the number of column for the composite
	 */
	protected int getColumnNumber() {
		return values.size() + ((((getDescriptor().getLabelPosition() & SWT.RIGHT | SWT.LEFT)) != 0) ? 1 : 0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		if(isValid(composite)) {
			composite.dispose();
			composite = null;
			buttons.clear();
			listener = null;
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
		if(isValid(buttons)) {
			for(Button button : buttons) {
				// check if the button is selected
				if(button.getSelection()) {
					// returns the value in the list at the same index of the index of the button in the list of buttons 
					return values.get(buttons.indexOf(button));
				}
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
			if(((IBoundedValuesPropertyEditorDescriptor)descriptor).getAvailableValues() != null) {
				for(Object object : ((IBoundedValuesPropertyEditorDescriptor)descriptor).getAvailableValues()) {
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
		if(!isValid(buttons)) {
			return;
		}
		if(valueToEdit instanceof String) {
			String newValue = (String)valueToEdit;
			int index = values.indexOf(newValue);
			if(index >= 0) {
				// force all to not selected. Prefer to set all to false, then the right one to true. 
				// this should be faster than testing for each button
				for(Button button : buttons) {
					button.setSelection(false);
				}

				// select only the right one
				buttons.get(index).setSelection(true);
			} else {
				Activator.log.error("Impossible to get the value " + valueToEdit + " in the list of available values", null);
			}
		}
	}

	/**
	 * Returns <code>true</code> if the list is not <code>null</code> neither empty and buttons inside list are not <code>null</code>.
	 * 
	 * @param buttons
	 *        the list of buttons to test
	 * @return <code>true</code> if the list is not <code>null</code> neither empty and buttons inside list are not <code>null</code>.
	 */
	protected boolean isValid(List<Button> buttons) {
		return buttons != null && !buttons.isEmpty() && !(buttons.get(0).isDisposed());
	}

	/**
	 * Selection Listener for a list of radio buttons
	 */
	protected class RadioButtonListener implements SelectionListener {

		/**
		 * {@inheritDoc}
		 */
		public void widgetSelected(SelectionEvent e) {
			for(Button button : buttons) {
				button.setSelection(false);
			}
			((Button)e.widget).setSelection(true);
			handleContentChanged();
		}

		/**
		 * {@inheritDoc}
		 */
		public void widgetDefaultSelected(SelectionEvent e) {

		}
	}

}
