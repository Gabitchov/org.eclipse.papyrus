/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.properties.observable;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * Abstract Observable Value to update axis configuration
 * 
 * @author vl222926
 * 
 */
public abstract class AbstractAxisHeaderConfigurationElementObservableValue extends AbstractObservableValue implements Listener {

	/**
	 * the managed table
	 */
	private Table table;

	/**
	 * the managed feature
	 */
	private EStructuralFeature managedFeature;

	/**
	 * the last value of the managed feature
	 */
	private Object oldValue;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 *        the managed table
	 * @param managedFeature
	 *        the managed feature
	 */
	public AbstractAxisHeaderConfigurationElementObservableValue(final Table table, final EStructuralFeature managedFeature) {
		this.table = table;
		this.managedFeature = managedFeature;
		oldValue = doGetValue();
	}

	/**
	 * 
	 * @see org.eclipse.core.databinding.observable.value.AbstractObservableValue#doGetValue()
	 * 
	 * @return
	 *         the current value
	 */
	@Override
	protected Object doGetValue() {
		return getManagedConfiguration().eGet(managedFeature);
	}


	/**
	 * 
	 * @return
	 *         the managed feature
	 */
	public EStructuralFeature getManagedFeature() {
		return managedFeature;
	}

	/**
	 * 
	 * @return
	 *         the managed axis configuration
	 */
	protected abstract AbstractHeaderAxisConfiguration getManagedConfiguration();

	/**
	 * 
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 * 
	 * @param event
	 */
	@Override
	public void handleEvent(Event event) {
		final Object newValue = doGetValue();
		if(!oldValue.equals(newValue)) {
			final Object localOldValue = oldValue;
			oldValue = newValue;
			fireValueChange(new ValueDiff() {

				@Override
				public Object getOldValue() {
					return localOldValue;
				}

				@Override
				public Object getNewValue() {
					return newValue;
				}
			});
		}
	}

	/**
	 * 
	 * @return
	 *         the managed table
	 */
	public Table getTable() {
		return table;
	}

}
