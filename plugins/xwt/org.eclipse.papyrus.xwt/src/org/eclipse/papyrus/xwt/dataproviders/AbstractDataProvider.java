/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.       *
 * All rights reserved. This program and the accompanying materials            *
 * are made available under the terms of the Eclipse Public License v1.0       *
 * which accompanies this distribution, and is available at                    *
 * http://www.eclipse.org/legal/epl-v10.html                                   *
 *                                                                             *
 * Contributors:                                                               *
 *     Soyatec - initial API and implementation                                *
 *******************************************************************************/
package org.eclipse.papyrus.xwt.dataproviders;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.papyrus.xwt.IDataProvider;
import org.eclipse.papyrus.xwt.core.IBinding;
import org.eclipse.papyrus.xwt.internal.core.ScopeManager;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public abstract class AbstractDataProvider implements IDataProvider {

	private HashMap<String, Object> properties = new HashMap<String, Object>();

	public Object getProperty(String property) {
		return properties.get(property);
	}

	public void setProperty(String property, Object value) {
		properties.put(property, value);
	}

	public boolean hasProperty(String property) {
		return properties.containsKey(property);
	}

	public void removeProperty(String property) {
		properties.remove(property);
	}

	public boolean isPropertyReadOnly(String path) {
		return false;
	}

	public IObservable observe(Object data, String path, Object elementType, int observeKind) {
		Object type = null;
		if(elementType == null) {
			type = getModelService().toModelType(data);
		} else {
			type = elementType;
		}
		Object propertyType = getModelService().toModelPropertyType(type, path);
		Class<?> propertyTypeClass = null;

		if(propertyType instanceof Class<?>) {
			propertyTypeClass = (Class<?>)propertyType;
			if(IBinding.class.isAssignableFrom(propertyTypeClass)) {
				return null;
			}
		}

		switch(observeKind) {
		case ScopeManager.AUTO:
			if(propertyTypeClass != null && (propertyTypeClass.isArray() || List.class.isAssignableFrom(propertyTypeClass))) {
				if(data instanceof IObservableValue) {
					IObservableValue observable = (IObservableValue)data;
					return observeDetailList(observable, type, path, propertyType);
				}
				return observeList(data, path);
			} else if(propertyTypeClass != null && (Set.class.isAssignableFrom(propertyTypeClass))) {
				if(data instanceof IObservableValue) {
					IObservableValue observable = (IObservableValue)data;
					return observeDetailSet(observable, type, path, propertyType);
				}
				return observeSet(data, path);
			} else {
				if(data instanceof IObservableValue) {
					IObservableValue observable = (IObservableValue)data;
					return observeDetailValue(observable, type, path, propertyType);
				}
				return observeValue(data, path);
			}
		case ScopeManager.VALUE:
			if(data instanceof IObservableValue) {
				IObservableValue observable = (IObservableValue)data;
				return observeDetailValue(observable, type, path, propertyType);
			}
			return observeValue(data, path);
		case ScopeManager.COLLECTION:
			if(propertyTypeClass != null && Set.class.isAssignableFrom(propertyTypeClass)) {
				if(data instanceof IObservableValue) {
					IObservableValue observable = (IObservableValue)data;
					return observeDetailSet(observable, type, path, propertyType);
				}
				return observeSet(data, path);
			}
			if(data instanceof IObservableValue) {
				IObservableValue observable = (IObservableValue)data;
				return observeDetailList(observable, type, path, propertyType);
			}
			return observeList(data, path);
		case ScopeManager.SET:
			if(data instanceof IObservableValue) {
				IObservableValue observable = (IObservableValue)data;
				return observeDetailSet(observable, type, path, propertyType);
			}
			return observeSet(data, path);
		case ScopeManager.LIST:
			if(data instanceof IObservableValue) {
				IObservableValue observable = (IObservableValue)data;
				return observeDetailList(observable, type, path, propertyType);
			}
			return observeList(data, path);
		}
		return null;
	}

	protected abstract IObservableValue observeValue(Object bean, String propertyName);

	protected IObservableList observeList(Object bean, String propertyName) {
		return null;
	}

	protected IObservableSet observeSet(Object bean, String propertyName) {
		return null;
	}

	protected IObservableList observeDetailList(IObservableValue bean, Object elementType, String propertyName, Object propertyType) {
		return null;
	}

	protected IObservableSet observeDetailSet(IObservableValue bean, Object elementType, String propertyName, Object propertyType) {
		return null;
	}

	protected abstract IObservableValue observeDetailValue(IObservableValue bean, Object elementType, String propertyName, Object propertyType);

	// TODO to remove
	public IValueProperty createValueProperty(Object type, String fullPath) {
		throw new UnsupportedOperationException("to remove this method");
	}
}
