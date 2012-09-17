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
package org.eclipse.papyrus.infra.widgets.databinding;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.papyrus.infra.tools.databinding.AggregatedObservable;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;

/**
 * An ObservableValue for {@link Button}s with the {@link SWT.CHECK} style
 * Allows the checkbox to take four states ; one for each possible combination
 * of {@link Button#getSelection()} and {@link Button#getGrayed()}
 * 
 * @author Camille Letavernier
 */
public class GrayedCheckboxObservableValue extends AbstractObservableValue implements SelectionListener {

	private Button checkbox;

	private Boolean currentValue;

	private AggregatedObservable aggregated;

	/**
	 * Constructor
	 * 
	 * @param checkbox
	 *        The observed checkbox
	 * @param aggregated
	 *        The Observable aggregating the various observable booleans
	 */
	public GrayedCheckboxObservableValue(Button checkbox, AggregatedObservable aggregated) {
		this.checkbox = checkbox;
		this.checkbox.addSelectionListener(this);
		this.aggregated = aggregated;
	}

	public Object getValueType() {
		return Object.class; //Can be either Boolean or BooleanWithDefaultState
	}

	@Override
	protected Boolean doGetValue() {
		return checkbox.getSelection();
	}

	@Override
	protected void doSetValue(Object value) {
		if(aggregated.hasDifferentValues()) {
			checkbox.setSelection(true);
			checkbox.setGrayed(true);
			return;
		} else {
			checkbox.setGrayed(false);
		}

		if(value instanceof Boolean) {
			Boolean booleanValue = (Boolean)value;
			checkbox.setSelection(booleanValue);

			this.currentValue = booleanValue;
		} else if(value == null) {
			checkbox.setSelection(false);
		}
	}

	@Override
	public synchronized void dispose() {
		checkbox.removeSelectionListener(this);
		super.dispose();
	}

	public void widgetSelected(SelectionEvent e) {
		final Boolean oldValue = currentValue;
		final Boolean newValue = checkbox.getSelection();

		currentValue = newValue;
		checkbox.setGrayed(false);

		fireValueChange(new ValueDiff() {

			@Override
			public Object getOldValue() {
				return oldValue;
			}

			@Override
			public Object getNewValue() {
				return newValue;
			}
		});
	}

	public void widgetDefaultSelected(SelectionEvent e) {
		//Nothing
	}

}
