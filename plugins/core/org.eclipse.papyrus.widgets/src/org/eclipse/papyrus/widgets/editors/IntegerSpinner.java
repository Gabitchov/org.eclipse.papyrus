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

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.conversion.StringToNumberConverter;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Spinner;

/**
 * A widget for editing Integer values with a SWT Spinner
 * 
 * @author Camille Letavernier
 * 
 * @see Spinner
 */
public class IntegerSpinner extends AbstractValueEditor {

	/**
	 * The SWT Spinner
	 */
	protected Spinner spinner;

	/**
	 * The String to Integer converter
	 */
	protected IConverter targetToModelConverter;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *        The Composite in which the editor will be created
	 * @param style
	 *        The SWT style to apply
	 */
	public IntegerSpinner(Composite parent, int style) {
		super(parent, style);
		spinner = new Spinner(this, factory.getBorderStyle());

		setWidgetObservable(new AbstractObservableValue() {

			public Object getValueType() {
				return Integer.class;
			}

			@Override
			protected Integer doGetValue() {
				return (Integer)targetToModelConverter.convert(spinner.getText());
			}

			@Override
			protected void doSetValue(Object value) {
				spinner.setSelection((Integer)value);
			}

		});

		targetToModelConverter = StringToNumberConverter.toInteger(false);
	}

	@Override
	public void doBinding() {

		spinner.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				//Nothing
			}

			public void focusLost(FocusEvent e) {
				binding.updateTargetToModel();
			}

		});

		super.doBinding();
	}

	@Override
	public Object getValue() {
		String value = spinner.getText();
		return targetToModelConverter.convert(value);
	}

	@Override
	public Object getEditableType() {
		return Integer.class;
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		spinner.setEnabled(!readOnly);
	}

	@Override
	public boolean isReadOnly() {
		return !spinner.isEnabled();
	}

	@Override
	public void setToolTipText(String text) {
		spinner.setToolTipText(text);
		super.setLabelToolTipText(text);
	}

	/**
	 * Sets the minimum value for the spinner
	 * 
	 * @param minimum
	 * @see Spinner#setMinimum(int)
	 */
	public void setMinimum(int minimum) {
		spinner.setMinimum(minimum);
	}

	/**
	 * Sets the maximum value for the spinner
	 * 
	 * @param maximum
	 * @see Spinner#setMaximum(int)
	 */
	public void setMaximum(int maximum) {
		spinner.setMaximum(maximum);
	}

	/**
	 * Sets the increment value for the spinner
	 * 
	 * @param increment
	 * @see Spinner#setIncrement(int)
	 */
	public void setIncrement(int increment) {
		spinner.setIncrement(increment);
	}

}
