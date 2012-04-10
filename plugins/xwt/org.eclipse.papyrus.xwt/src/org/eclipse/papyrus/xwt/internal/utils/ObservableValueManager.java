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
package org.eclipse.papyrus.xwt.internal.utils;

import java.util.HashMap;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.papyrus.xwt.IEventGroup;
import org.eclipse.papyrus.xwt.IObservableValueListener;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.EventProperty;
import org.eclipse.papyrus.xwt.metadata.IMetaclass;
import org.eclipse.papyrus.xwt.metadata.IProperty;
import org.eclipse.papyrus.xwt.metadata.ModelUtils;
import org.eclipse.swt.widgets.Event;

public class ObservableValueManager implements IObservableValueListener {

	protected HashMap<String, IObservableValue> map;

	protected Object host;

	public ObservableValueManager(Object host) {
		this.host = host;
	}

	public Object getHost() {
		return host;
	}

	public void changeValueHandle(Object object, Event event) {
		// TODO the cast is not clean. 
		EventProperty property = (EventProperty)object;
		IObservableValue value = map.get(property.getName());
		if(value != null) {
			Boolean oldValue = (Boolean)value.getValue();
			if(oldValue == null) {
				oldValue = false;
			}
			value.setValue(!oldValue);
		}

		IMetaclass metaclass = XWT.getMetaclass(host);

		// TODO this conversion should be simplied
		String eventName = ModelUtils.normalizePropertyName(property.getEvent().getName());
		IEventGroup eventGroup = metaclass.getEventGroup(eventName);
		if(eventGroup != null) {
			eventGroup.fireEvent(this, property);
		}
	}

	public void registerValue(IProperty property, IObservableValue observableValue) {
		if(map == null) {
			map = new HashMap<String, IObservableValue>();
		}
		map.put(property.getName(), observableValue);

		IMetaclass metaclass = XWT.getMetaclass(host);
		// TODO it is not clean. 
		EventProperty eventProperty = (EventProperty)property;

		// TODO this conversion should be simplied
		String eventName = ModelUtils.normalizePropertyName(eventProperty.getEvent().getName());
		IEventGroup eventGroup = metaclass.getEventGroup(eventName);
		if(eventGroup != null) {
			eventGroup.registerEvent(this, property);
		}
	}

	public IObservableValue getValue(IProperty property) {
		if(map == null) {
			return null;
		}
		return map.get(property.getName());
	}
}
