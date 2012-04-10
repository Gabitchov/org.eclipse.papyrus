/*******************************************************************************
 * Copyright (c) 2005, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Brad Reynolds - bug 164653
 *******************************************************************************/
package org.eclipse.papyrus.xwt.databinding;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.papyrus.xwt.IMultiValueConverter;
import org.eclipse.papyrus.xwt.XWT;

/**
 * @since 3.2
 * 
 */
public class AggregateObservableValue extends AbstractObservableValue {

	private IObservableValue[] observableValues;

	private boolean updating = false;

	private IMultiValueConverter converter;

	private Object currentValue;

	private IValueChangeListener listener = new IValueChangeListener() {

		public void handleValueChange(ValueChangeEvent event) {
			if(!updating) {
				fireValueChange(Diffs.createValueDiff(currentValue, doGetValue()));
			}
		}
	};

	/**
	 * @param observableValues
	 * @param delimiter
	 */
	public AggregateObservableValue(IObservableValue[] observableValues, IMultiValueConverter converter) {
		super(findRealm(observableValues));
		this.converter = converter;

		this.observableValues = observableValues;
		for(int i = 0; i < observableValues.length; i++) {
			observableValues[i].addValueChangeListener(listener);
		}
		doGetValue();
	}

	private static Realm findRealm(IObservableValue[] observableValues) {
		for(IObservableValue observableValue : observableValues) {
			return observableValue.getRealm();
		}
		return XWT.getRealm();
	}

	public void doSetValue(Object value) {
		Object oldValue = doGetValue();

		try {
			updating = true;
			Object[] values = converter.convertBack(value);
			for(int i = 0; i < observableValues.length; i++) {
				if(i < values.length) {
					observableValues[i].setValue(values[i]);
				} else {
					observableValues[i].setValue(null);
				}
			}
		} finally {
			updating = false;
		}
		doGetValue();
		currentValue = value;
		fireValueChange(Diffs.createValueDiff(oldValue, value));
	}

	public Object doGetValue() {
		Object[] values = new Object[observableValues.length];
		for(int i = 0; i < values.length; i++) {
			values[i] = observableValues[i].getValue();
		}
		return converter.convert(values);
	}

	public Object getValueType() {
		return String[].class;
	}

	public synchronized void dispose() {
		for(int i = 0; i < observableValues.length; i++) {
			observableValues[i].removeValueChangeListener(listener);
		}
		super.dispose();
	}

}
