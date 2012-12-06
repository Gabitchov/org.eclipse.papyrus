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
package org.eclipse.papyrus.infra.emf.databinding;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;

/**
 * MultipleObservableValue is used to map a single element
 * to a collection of model elements.
 * 
 * It is especially used when displaying a Property View for multiple elements,
 * when we want to edit the same property for all of them.
 * 
 * All sub-elements will be edited at the same time, with the same value.
 */
//TODO : Add listeners on sub-observables, and remove them on dispose
public class MultipleObservableValue extends AbstractObservableValue implements AggregatedObservable, IChangeListener {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param values
	 *        The collection of sub-elements for this MultipleObservableValue
	 * 
	 */
	public MultipleObservableValue(Collection<IObservableValue> values) {
		if(values != null) {
			observableValues.addAll(values);
		}
	}

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public MultipleObservableValue() {

	}

	public Object getValueType() {
		if(observableValues.isEmpty()) {
			return null;
		}

		return observableValues.get(0).getValueType();
	}

	/**
	 * If all objects have the same value, returns this value
	 * Otherwise, returns the defaultGetValue
	 * If the defaultGetValue hasn't been set, returns null
	 */
	@Override
	protected Object doGetValue() {
		if(hasDifferentValues() || observableValues.isEmpty()) {
			return null;
		}

		return observableValues.get(0).getValue();
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

	public AggregatedObservable aggregate(IObservable observable) {
		if(observable instanceof IObservableValue) {
			observableValues.add((IObservableValue)observable);
			observable.addChangeListener(this);
			return this;
		}
		return null;
	}

	/**
	 * @return the list of sub-observable values
	 */
	public List<IObservableValue> getObservableValues() {
		return observableValues;
	}

	/**
	 * @return the list of observed values
	 */
	public List<Object> getObservedValues() {
		List<Object> result = new LinkedList<Object>();
		for(IObservableValue value : getObservableValues()) {
			result.add(value.getValue());
		}
		return result;
	}

	@Override
	public synchronized void dispose() {
		super.dispose();
		for(IObservableValue observable : observableValues) {
			observable.removeChangeListener(this);
			observable.dispose();
		}
	}

	/**
	 * The {@link IObservableValue}s aggregated by this Observable
	 */
	protected List<IObservableValue> observableValues = new LinkedList<IObservableValue>();

	public boolean hasDifferentValues() {
		if(observableValues.isEmpty()) {
			return false;
		}

		Object currentValue = null;
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
				return true;
			}
		}

		return false;
	}

	public void handleChange(ChangeEvent event) {
		//We're not interested in the old and new values
		//We just return two different values so that a change event is fired
		super.fireValueChange(new ValueDiff() {

			@Override
			public Object getOldValue() {
				return true;
			}

			@Override
			public Object getNewValue() {
				return false;
			}
		});
	}

}
