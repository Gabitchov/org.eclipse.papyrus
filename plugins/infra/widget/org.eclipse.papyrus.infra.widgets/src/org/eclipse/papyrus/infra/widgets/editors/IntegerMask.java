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
 *  Thibault Le Ouay t.leouay@sherpa-eng.com - Add binding implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.infra.widgets.messages.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class IntegerMask extends AbstractValueEditor implements SelectionListener, IChangeListener, DisposeListener {

	private Button[] checkboxes;

	private int currentValue;

	private final Composite checkboxContainer;

	private boolean refreshCheckboxes = true;

	public IntegerMask(final Composite parent, final int style) {
		super(parent, style);
		checkboxContainer = new Composite(this, style);
		checkboxContainer.setLayoutData(getDefaultLayoutData());
		checkboxContainer.setLayout(new GridLayout(2, true));
		checkboxContainer.addDisposeListener(this);
	}

	@Override
	protected GridData getLabelLayoutData() {
		GridData data = super.getLabelLayoutData();
		data.verticalAlignment = SWT.BEGINNING;
		return data;
	}

	@Override
	public Object getValue() {
		int totalValue = 0;
		for(Button button : checkboxes) {
			int value = (Integer)button.getData("IntValue"); //$NON-NLS-1$
			if(button.getSelection()) {
				totalValue |= value;
			}
		}
		return totalValue;
	}

	@Override
	public void dispose() {
		if(modelProperty != null) {
			modelProperty.removeChangeListener(this);
		}
		super.dispose();
	}

	@Override
	public Object getEditableType() {
		return Integer.class;
	}

	@Override
	public void setReadOnly(final boolean readOnly) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isReadOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setMasks(final String[] values) {
		Map<Integer, String> masks = new HashMap<Integer, String>();
		int intValue = 1;
		for(String value : values) {
			masks.put(intValue, value);
			intValue <<= 1;
		}
		setMasks(masks);
	}

	public void setMasks(final Map<Integer, String> values) {
		if(values.size() > 32) {
			StringLabel label = new StringLabel(checkboxContainer, SWT.NONE);
			label.getValueLabel().setImage(Activator.getDefault().getImage("/icons/error.gif")); //$NON-NLS-1$
			label.getValueLabel().setText(Messages.IntegerMask_ErrorTooManyValues);
			checkboxes = new Button[0];
		} else {
			if(checkboxes != null) {
				disposeCheckboxes();
			}

			checkboxes = new Button[values.size()];

			int i = 0;
			for(Entry<Integer, String> mask : values.entrySet()) {
				int intValue = mask.getKey();
				String value = mask.getValue();
				checkboxes[i] = new Button(checkboxContainer, SWT.CHECK);
				checkboxes[i].setText(value);
				checkboxes[i].setData("IntValue", intValue); //$NON-NLS-1$
				checkboxes[i].addSelectionListener(this);
				i++;
			}
		}
	}

	protected void disposeCheckboxes() {
		for(Button button : checkboxes) {
			button.removeSelectionListener(this);
			button.dispose();
		}
	}

	public void setNumColumns(final int numColumns) {
		((GridLayout)checkboxContainer.getLayout()).numColumns = numColumns;
		checkboxContainer.layout();
		layout();
	}

	@Override
	public void doBinding() {
		// We don't do a real databinding here
		modelProperty.addChangeListener(this);

		refreshCheckboxes();
	}

	protected void refreshCheckboxes() {
		if(!refreshCheckboxes) {
			return;
		}

		int totalValue = getCurrentValue();
		for(Button button : checkboxes) {
			int value = (Integer)button.getData("IntValue"); //$NON-NLS-1$
			button.setSelection((totalValue & value) != 0);
		}
	}

	@Override
	public void setToolTipText(final String text) {
		super.setLabelToolTipText(text);
	}

	@Override
	public void widgetSelected(final SelectionEvent e) {
		Button button = (Button)e.widget;
		int value = (Integer)button.getData("IntValue"); //$NON-NLS-1$
		int totalValue = getCurrentValue();
		if(button.getSelection()) {
			totalValue |= value;
		} else {
			totalValue &= ~value;
		}
		setCurrentValue(totalValue);
	}

	protected void setCurrentValue(final int value) {
		if(modelProperty != null) {
			refreshCheckboxes = false;
			modelProperty.setValue(value);
			refreshCheckboxes = true;
		}
		currentValue = value;

		commit();
	}

	protected Integer getCurrentValue() {
		if(modelProperty != null) {
			Object value = modelProperty.getValue();
			return value == null ? 0 : (Integer)value;
		} else {
			return currentValue;
		}
	}

	@Override
	public void widgetDefaultSelected(final SelectionEvent e) {
		// Nothing
	}

	public int getNumColumns() {
		return ((GridLayout)checkboxContainer.getLayout()).numColumns;
	}

	@Override
	public void handleChange(final ChangeEvent event) {
		refreshCheckboxes();
	}


}
