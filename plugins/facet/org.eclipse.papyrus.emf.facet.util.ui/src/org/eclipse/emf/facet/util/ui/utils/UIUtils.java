/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.emf.facet.util.ui.utils;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

/**
 * This util class provides methods for the creation of basics ui components
 * like buttons or text field.
 * 
 * @since 0.3
 */
public final class UIUtils {

	private static final int WIDTH_HINT = 110;

	private UIUtils() {
		// Private constructor.
	}

	/**
	 * Create the label (with the given labelName) in the given composite. The
	 * layoutData of the label is {@link #getLabelGridData()}.
	 * 
	 * @param parent
	 *            the composite parent.
	 * @param labelName
	 *            the label name.
	 */
	public static Label createLabel(final Composite parent,
			final String labelName) {
		final Label label = new Label(parent, SWT.NONE);
		label.setText(labelName);
		label.setLayoutData(getLabelGridData());
		return label;
	}

	/**
	 * Create and return a new button.
	 * 
	 * @param parent
	 *            the button parent.
	 * @param text
	 *            the text to display on the button.
	 * @param enabled
	 *            set if the button can be pressed or not.
	 * @param selectionListener
	 *            the listener when the button is pressed (can be null).
	 * @return the new button.
	 */
	public static Button createButton(final Composite parent,
			final String text, final boolean enabled,
			final SelectionListener selectionListener) {
		final Button button = new Button(parent, SWT.NONE);
		button.setText(text);
		button.setEnabled(enabled);
		if (selectionListener != null) {
			button.addSelectionListener(selectionListener);
		}
		return button;
	}

	/**
	 * Create and return a new text field.
	 * 
	 * @param parent
	 *            the text field parent.
	 * @param text
	 *            the text to display on the text field.
	 * @param enabled
	 *            set if the text field can be edit or not.
	 * @param selectListener
	 *            the listener when the text field is edited (can be null).
	 * @return the new text field.
	 */
	public static Text createTextField(final Composite parent,
			final String text, final boolean enabled,
			final ModifyListener modifyListener) {
		final Text textField = new Text(parent, SWT.BORDER);
		textField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		textField.setEnabled(enabled);
		if (text != null) {
			textField.setText(text);
		}
		if (modifyListener != null) {
			textField.addModifyListener(modifyListener);
		}
		return textField;
	}

	/**
	 * Create a combobox with a label.
	 * 
	 * @param parent
	 *            the parent of the combobox.
	 * @param enabled
	 *            if the combobox is enabled.
	 * @param elements
	 *            the elements of the combobox
	 * @param listener
	 *            the listener of the combobox (can be null)
	 * @return the combobox created.
	 */
	public static Combo createCombobox(final Composite parent,
			final boolean enabled, final List<String> elements,
			final String label, final SelectionListener listener) {
		final Composite composite = new Composite(parent, SWT.NONE);
		final GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 0;
		composite.setLayout(gridLayout);
		final Label comboboxLabel = new Label(composite, SWT.NONE);
		comboboxLabel.setText(label);
		final GridData gridData = new GridData(SWT.FILL);
		comboboxLabel.setLayoutData(gridData);
		final Combo combobox = new Combo(composite, SWT.DROP_DOWN
				| SWT.READ_ONLY);
		combobox.setLayoutData(new GridData(SWT.FILL));
		combobox.setEnabled(enabled);
		for (final String element : elements) {
			combobox.add(element);
		}
		combobox.select(0);
		if (listener != null) {
			combobox.addSelectionListener(listener);
		}
		return combobox;
	}

	/**
	 * Create and return a new text field.
	 * 
	 * @param parent
	 *            the text field parent.
	 * @param text
	 *            the text to display on the text field.
	 * @param enabled
	 *            set if the text field can be edit or not.
	 * @param selectListener
	 *            the listener when the text field is edited (can be null).
	 * @return the new text field.
	 */
	public static Text createTextArea(final Composite parent,
			final String text, final boolean enabled,
			final ModifyListener modifyListener) {
		final Text textArea = new Text(parent, SWT.MULTI | SWT.BORDER
				| SWT.WRAP | SWT.V_SCROLL);
		textArea.setLayoutData(new GridData(GridData.FILL_BOTH));
		textArea.setEnabled(enabled);
		if (text != null) {
			textArea.setText(text);
		}
		if (modifyListener != null) {
			textArea.addModifyListener(modifyListener);
		}
		return textArea;
	}

	/**
	 * @return the labelGridData
	 */
	public static GridData getLabelGridData() {
		final GridData labelGridData = new GridData(SWT.FILL);
		labelGridData.widthHint = WIDTH_HINT;
		return labelGridData;
	}

	/**
	 * Create and return a new checkbox.
	 * 
	 * @param parent
	 *            the checkbox parent.
	 * @param enabled
	 *            set if the checkbox can be checked or not.
	 * @param selected
	 *            set if the checkbox is initially selected or not.
	 * @param selectionListener
	 *            the listener when the checkbox is selected (can be null).
	 * @return the new checkbox.
	 */
	public static Button createCheckbox(final Composite composite,
			final boolean enabled, final boolean selected,
			final SelectionListener selectionListener) {
		final Button checkbox = new Button(composite, SWT.CHECK);
		checkbox.setEnabled(enabled);
		checkbox.setSelection(selected);
		checkbox.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		if (selectionListener != null) {
			checkbox.addSelectionListener(selectionListener);
		}
		return checkbox;
	}

	/**
	 * Create and return a new spinner.
	 * 
	 * @param parent
	 *            the parent of the spinner.
	 * @param maxValue
	 *            the max value the spinner can reach.
	 * @param minValue
	 *            the min value the spinner can reach.
	 * @param increment
	 *            the increment of the spinner.
	 * @param changeable
	 *            if the spinner is changeable or not.
	 * @param modifyListener
	 *            the listener when the spinner is changed (can be null).
	 * @return the new spinner.
	 * 
	 * @see Spinner
	 */
	public static Spinner createSpinner(final Composite parent,
			final int maxValue, final int minValue, final int increment,
			final boolean changeable, final ModifyListener modifyListener) {
		final Spinner spinner = new Spinner(parent, SWT.BORDER);
		spinner.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		spinner.setMaximum(maxValue);
		spinner.setMinimum(minValue);
		spinner.setIncrement(increment);
		spinner.setEnabled(changeable);
		if (modifyListener != null) {
			spinner.addModifyListener(modifyListener);
		}
		return spinner;
	}

}
