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
package org.eclipse.papyrus.properties.databinding;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;

/**
 * MultipleObservableValue is used to map a single element
 * to a collection of model elements.
 * 
 * It is especially used when displaying a Property View for multiple elements,
 * when we want to edit the same property for all of them.
 * 
 * All sub-elements will be edited at the same time, with the same value.
 */
public class MultipleObservableValue extends AbstractObservableValue implements MultipleObservable {

	/**
	 * Constructor.
	 * 
	 * @param defaultGetValue
	 *        When the different sub-elements don't have the same value, the defaultGetValue is returned
	 */
	public MultipleObservableValue(Object defaultGetValue) {
		this(null, defaultGetValue);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param values
	 *        The collection of sub-elements for this MultipleObservableValue
	 * @param defaultGetValue
	 *        When the different sub-elements don't have the same value, the defaultGetValue is returned
	 * 
	 */
	public MultipleObservableValue(Collection<IObservableValue> values, Object defaultGetValue) {
		if(values != null) {
			observableValues.addAll(values);
		}

		this.defaultGetValue = defaultGetValue;
	}

	public Object getValueType() {
		if(observableValues.isEmpty()) {
			return null;
		}
		return observableValues.get(0);
	}

	/**
	 * If all objects have the same value, returns this value
	 * Otherwise, returns the defaultGetValue
	 * If the defaultGetValue hasn't been set, returns null
	 */
	@Override
	protected Object doGetValue() {
		if(observableValues.isEmpty()) {
			return null;
		}
		Object currentValue = defaultGetValue;
		boolean firstValue = true;
		for(IObservableValue observable : observableValues) {
			if(firstValue) {
				firstValue = false;
				currentValue = observable.getValue();
			} else {
				Object value = observable.getValue();
				if(equals(value, currentValue)) {
					continue;
				}
				return defaultGetValue;
			}
		}
		return currentValue;
	}

	private boolean equals(Object value, Object currentValue) {
		if(value == currentValue) {
			return true;
		}
		if(value == null) {
			return false;
		}
		return value.equals(currentValue);
	}

	@Override
	protected void doSetValue(Object value) {
		for(IObservableValue observable : observableValues) {
			observable.setValue(value);
		}
	}

	public boolean add(IObservable observable) {
		if(observable instanceof IObservableValue) {
			observableValues.add((IObservableValue)observable);
			return true;
		}
		return false;
	}

	public List<IObservableValue> getObservableValues() {
		return observableValues;
	}

	public List<Object> getObservedValues() {
		List<Object> result = new LinkedList<Object>();
		for(IObservableValue value : getObservableValues()) {
			result.add(value.getValue());
		}
		return result;
	}

	private List<IObservableValue> observableValues = new LinkedList<IObservableValue>();

	private Object defaultGetValue;

}
