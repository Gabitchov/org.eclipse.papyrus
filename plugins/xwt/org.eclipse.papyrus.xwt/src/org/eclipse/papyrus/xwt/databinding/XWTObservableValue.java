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

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.jface.util.Util;
import org.eclipse.papyrus.xwt.XWT;

/**
 * Notes: Binding type is java.lang.String.
 * 
 * @author jliu (jin.liu@soyatec.com)
 */
public abstract class XWTObservableValue extends AbstractObservableValue implements IObserving {

	private Object observed;

	private Class<?> valueType;

	private EventManager eventManager;

	private EventListener eventListener;

	private String path;

	private boolean updating = false;

	/**
	 * 
	 */
	public XWTObservableValue(Class<?> valueType, Object observed, String path) {
		super(XWT.getRealm());
		this.valueType = valueType;
		this.observed = observed;
		this.path = path;
		init();
	}

	/**
	 * Add listener to observed.
	 */
	private void init() {
		if(eventListener == null) {
			eventListener = new EventListener() {

				public void handleEvent(Event evt) {
					if(!updating) {
						final ValueDiff diff = Diffs.createValueDiff(evt.getOldValue(), evt.getNewValue());
						getRealm().exec(new Runnable() {

							public void run() {
								fireValueChange(diff);
							}
						});
					}
				}
			};
		}
		eventManager = EventManager.getEventManager(observed, getRealm());
		eventManager.addEventListener(path, eventListener);
	}

	/**
	 * @return the observed
	 */
	public Object getObserved() {
		return observed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.observable.value.AbstractObservableValue#doSetValue(java.lang.Object)
	 */
	protected void doSetValue(Object value) {
		updating = true;
		Object oldValue = doGetValue();
		value = convert(oldValue == null ? null : oldValue.getClass(), value);
		if(!Util.equals(oldValue, value)) {
			doSetApprovedValue(value);
			fireValueChange(Diffs.createValueDiff(oldValue, value));
			eventManager.dispatchEvent(new Event(observed, oldValue, value, getPath()));
		}
		updating = false;
	}

	/**
	 * @param value
	 * @return
	 */
	protected Object convert(Class type, Object value) {
		if(value != null) {
			if(type != null && type.isEnum() && value instanceof String) {
				return Enum.valueOf(type, (String)value);
			}
			IConverter c = XWT.findConvertor(value.getClass(), (Class<?>)getValueType());
			if(c != null) {
				return c.convert(value);
			}
		}
		return value;
	}

	/**
	 * @param value
	 */
	protected abstract void doSetApprovedValue(Object value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.observable.value.AbstractObservableValue#doGetValue()
	 */
	protected Object doGetValue() {
		return observed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.observable.value.IObservableValue#getValueType()
	 */
	public Class<?> getValueType() {
		return valueType;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
