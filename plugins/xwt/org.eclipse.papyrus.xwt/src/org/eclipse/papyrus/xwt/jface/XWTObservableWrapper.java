/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.jface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IDisposeListener;
import org.eclipse.core.databinding.observable.IStaleListener;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.papyrus.xwt.internal.core.BindingExpressionPath;
import org.eclipse.papyrus.xwt.internal.core.ScopeManager;

public class XWTObservableWrapper implements IObservableMap {

	private IObservableMap delegate;

	private IObservableSet domain;

	private Object control;

	private Object data;

	private String path;

	private List<IMapChangeListener> changeListeners = Collections.emptyList();

	public XWTObservableWrapper(IObservableSet domain, Object control, String path) {
		this.control = control;
		this.domain = domain;
		this.path = path;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void addMapChangeListener(IMapChangeListener listener) {
		if(delegate == null) {
			if(changeListeners.isEmpty()) {
				changeListeners = new ArrayList<IMapChangeListener>();
			}
			changeListeners.add(listener);
		} else {
			delegate.addMapChangeListener(listener);
		}
	}

	public void clear() {
		checkDelegated();
		delegate.clear();
	}

	public boolean containsKey(Object key) {
		checkDelegated();
		return delegate.containsKey(key);
	}

	public boolean containsValue(Object value) {
		checkDelegated();
		return delegate.containsValue(value);
	}

	public Set entrySet() {
		checkDelegated();
		return delegate.entrySet();
	}

	public boolean equals(Object o) {
		checkDelegated();
		return delegate.equals(o);
	}

	public Object get(Object key) {
		if(data == null) {
			data = key;
		}
		checkDelegated();
		return delegate.get(key);
	}

	public Object getKeyType() {
		checkDelegated();
		return delegate.getKeyType();
	}

	public Object getValueType() {
		checkDelegated();
		return delegate.getValueType();
	}

	public int hashCode() {
		checkDelegated();
		return delegate.hashCode();
	}

	public boolean isEmpty() {
		checkDelegated();
		return delegate.isEmpty();
	}

	public Set keySet() {
		checkDelegated();
		return delegate.keySet();
	}

	public Object put(Object key, Object value) {
		checkDelegated();
		return delegate.put(key, value);
	}

	public void putAll(Map t) {
		checkDelegated();
		delegate.putAll(t);
	}

	public Object remove(Object key) {
		checkDelegated();
		return delegate.remove(key);
	}

	public void removeMapChangeListener(IMapChangeListener listener) {
		if(delegate == null) {
			changeListeners.remove(listener);
		} else {
			delegate.removeMapChangeListener(listener);
		}
	}

	public int size() {
		checkDelegated();
		return delegate.size();
	}

	public Collection values() {
		checkDelegated();
		return delegate.values();
	}

	public void addChangeListener(IChangeListener listener) {
		checkDelegated();
		delegate.addChangeListener(listener);
	}

	public void addDisposeListener(IDisposeListener listener) {
		checkDelegated();
		delegate.addDisposeListener(listener);
	}

	public void addStaleListener(IStaleListener listener) {
		checkDelegated();
		delegate.addStaleListener(listener);
	}

	public void dispose() {
		if(delegate != null) {
			delegate.dispose();
		}
	}

	public Realm getRealm() {
		checkDelegated();
		return delegate.getRealm();
	}

	public boolean isDisposed() {
		checkDelegated();
		return delegate.isDisposed();
	}

	public boolean isStale() {
		checkDelegated();
		return delegate.isStale();
	}

	public void removeChangeListener(IChangeListener listener) {
		checkDelegated();
		delegate.removeChangeListener(listener);
	}

	public void removeDisposeListener(IDisposeListener listener) {
		checkDelegated();
		delegate.removeDisposeListener(listener);
	}

	public void removeStaleListener(IStaleListener listener) {
		checkDelegated();
		delegate.removeStaleListener(listener);
	}

	protected void checkDelegated() {
		if(delegate == null) {
			IValueProperty property = ScopeManager.createValueProperty(control, data, new BindingExpressionPath(path));
			delegate = property.observeDetail(domain);
			for(IMapChangeListener listener : changeListeners) {
				delegate.addMapChangeListener(listener);
			}
			changeListeners.clear();
		}
	}
}
