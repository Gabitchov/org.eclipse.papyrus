/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.observable;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;


public class PreferencesObservableValue extends AbstractObservableValue implements IPropertyChangeListener {

	protected String key;

	protected IPreferenceStore store;

	public PreferencesObservableValue(String key, IPreferenceStore store) {
		this.key = key;
		this.store = store;
		store.addPropertyChangeListener(this);
	}

	public Object getValueType() {
		return String.class;
	}

	@Override
	protected Object doGetValue() {
		if(store.contains(key)) {
			return store.getString(key);
		}
		return null;
	}

	@Override
	protected void doSetValue(Object value) {
		if(value instanceof String) {
			store.setValue(key, (String)value);
		}
	}

	public void propertyChange(PropertyChangeEvent event) {
		if(event.getProperty().equals(key)) {
			fireValueChange(Diffs.createValueDiff(event.getOldValue(), event.getNewValue()));
		}
	}

	@Override
	public void dispose() {
		store.removePropertyChangeListener(this);
		super.dispose();
	}
}
