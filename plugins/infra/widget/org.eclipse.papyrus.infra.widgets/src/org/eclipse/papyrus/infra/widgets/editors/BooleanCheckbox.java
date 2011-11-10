/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.papyrus.infra.widgets.databinding.AggregatedObservable;
import org.eclipse.papyrus.infra.widgets.databinding.GrayedCheckboxObservableValue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * A Property Editor representing a Boolean value
 * as a Checkbox.
 * 
 * @author Camille Letavernier
 */
public class BooleanCheckbox extends AbstractValueEditor {

	private Button checkbox;

	private AggregatedObservable aggregated;

	/**
	 * 
	 * Constructor. Creates a new Property Editor for a Boolean
	 * value, represented as a Checkbox.
	 * 
	 * @param parent
	 *        This editor's parent composite
	 * @param style
	 *        The style applied to this editor's checkbox
	 */
	public BooleanCheckbox(Composite parent, int style) {
		this(parent, style, null);
	}

	/**
	 * 
	 * Constructor. Creates a new Property Editor for a Boolean
	 * value, represented as a Checkbox, with the given label
	 * 
	 * @param parent
	 *        This editor's parent composite
	 * @param style
	 *        The style applied to this editor's checkbox
	 * @param label
	 *        The label for this editor
	 */
	public BooleanCheckbox(Composite parent, int style, String label) {
		super(parent);
		checkbox = factory.createButton(this, label, SWT.CHECK | style);

		setCommitOnFocusLost(checkbox);
	}

	@Override
	public void setModelObservable(IObservableValue modelProperty) {
		IObservableValue widgetObservable;
		if(modelProperty instanceof AggregatedObservable) {
			this.aggregated = (AggregatedObservable)modelProperty;
			widgetObservable = new GrayedCheckboxObservableValue(checkbox, aggregated);
		} else {
			widgetObservable = WidgetProperties.selection().observe(checkbox);
		}
		setWidgetObservable(widgetObservable, true);
		super.setModelObservable(modelProperty);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getEditableType() {
		return Boolean.class;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValue() {
		return checkbox.getSelection();
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		checkbox.setEnabled(!readOnly);
	}

	@Override
	public boolean isReadOnly() {
		return !checkbox.isEnabled();
	}

	@Override
	public void setToolTipText(String text) {
		checkbox.setToolTipText(text);
		super.setLabelToolTipText(text);
	}

	@Override
	public void setLabel(String label) {
		checkbox.setText(label);
	}
}
