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
 *  Thibault Le Ouay t.leouay@sherpa-eng.com - Add binding implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.papyrus.infra.tools.databinding.AggregatedObservable;
import org.eclipse.papyrus.infra.widgets.databinding.GrayedCheckboxObservableValue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * A Property Editor representing a Boolean value
 * as a Checkbox.
 *
 * @author Camille Letavernier
 */
public class BooleanCheckbox extends AbstractValueEditor {

	private final Button checkbox;

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

		IObservableValue widgetObservable = WidgetProperties.selection().observe(checkbox);
		setWidgetObservable(widgetObservable, true);
		GridData gridData = getDefaultLayoutData();
		checkbox.setLayoutData(gridData);
		gridData.horizontalIndent = FieldDecorationRegistry.getDefault().getMaximumDecorationWidth();


	}

	@Override
	public void setModelObservable(IObservableValue modelProperty) {
		IObservableValue newWidgetObservable;

		if(this.widgetObservable != null) {
			this.widgetObservable.dispose();
		}

		if(modelProperty instanceof AggregatedObservable) {
			this.aggregated = (AggregatedObservable)modelProperty;
			newWidgetObservable = new GrayedCheckboxObservableValue(checkbox, aggregated);
		} else {
			newWidgetObservable = WidgetProperties.selection().observe(checkbox);
		}
		setWidgetObservable(newWidgetObservable, true);
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
	public Boolean getValue() {
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

	/**
	 * Sets this widget's value
	 *
	 * @param selected
	 *        Whether the checkbox should be selected or not
	 */
	public void setValue(Boolean selected) {
		if(modelProperty != null) {
			modelProperty.setValue(selected);
		}
		widgetObservable.setValue(selected);
	}
}
