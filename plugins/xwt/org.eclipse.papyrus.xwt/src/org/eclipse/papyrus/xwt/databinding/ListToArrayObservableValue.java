/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.xwt.databinding;

import java.lang.reflect.Array;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.DisposeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IDisposeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;

/**
 * Manage the Array to List and then update from List to Array
 * 
 * @author yyang
 */
public class ListToArrayObservableValue extends AbstractObservableValue {

	protected IObservableList source;

	protected IObservableValue target;

	protected Object valueType;

	protected Object cacheData;

	public ListToArrayObservableValue(IObservableList source, IObservableValue target) {
		super(source.getRealm());
		this.source = source;
		this.target = target;

		source.addChangeListener(new IChangeListener() {

			public void handleChange(ChangeEvent event) {
				ListToArrayObservableValue.this.handleChange();
			}
		});

		source.addDisposeListener(new IDisposeListener() {

			public void handleDispose(DisposeEvent event) {
				ListToArrayObservableValue.this.dispose();
			}
		});
	}

	protected Object doGetValue() {
		return source;
	}

	protected void doSetValue(Object value) {
		super.doSetValue(value);
	}

	public Object getValueType() {
		return source.getElementType();
	}

	@Override
	public synchronized void dispose() {
		super.dispose();
		source.dispose();
		target.dispose();
		source = null;
		target = null;
	}

	protected void handleChange() {
		try {
			Object elements = Array.newInstance((Class<?>)getValueType(), source.size());
			Object[] objects = source.toArray((Object[])elements);
			if(cacheData == null) {
				cacheData = target.getValue();
			}
			target.setValue(objects);
			fireValueChange(Diffs.createValueDiff(cacheData, objects));
			cacheData = objects;
		} catch (NegativeArraySizeException e) {
			e.printStackTrace();
		}
	}
}
