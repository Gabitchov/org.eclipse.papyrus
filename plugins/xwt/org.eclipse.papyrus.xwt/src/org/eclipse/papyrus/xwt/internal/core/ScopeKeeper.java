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
package org.eclipse.papyrus.xwt.internal.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.papyrus.xwt.internal.utils.UserData;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

public class ScopeKeeper implements DisposeListener {

	protected HashMap<String, Object> nameMap = new HashMap<String, Object>();

	protected HashMap<Widget, HashMap<Object, HashMap<String, IObservable>>> bindingData = new HashMap<Widget, HashMap<Object, HashMap<String, IObservable>>>();

	protected Widget host;

	private final ScopeKeeper parent;

	private ChangeListenerSupport changeListenerSupport = new ChangeListenerSupport();

	class ChangeListenerSupport implements IChangeListener {

		private List<IChangeListener> changeListeners = Collections.emptyList();

		public void handleChange(ChangeEvent event) {
			for(IChangeListener changeListener : changeListeners) {
				changeListener.handleChange(event);
			}

			// notify to parent as well.
			Widget parent = UserData.getTreeParent(host);
			ScopeKeeper scopeKeeper = UserData.findScopeKeeper(parent);
			if(scopeKeeper != null) {
				scopeKeeper.fireChangeListener(event);
			}
		}

		public boolean addChangeListener(IChangeListener listener) {
			if(changeListeners.contains(listener)) {
				return false;
			}
			if(changeListeners == Collections.EMPTY_LIST) {
				changeListeners = new ArrayList<IChangeListener>();
			}
			changeListeners.add(listener);
			return true;
		}

		public void removeChangeListener(IChangeListener listener) {
			changeListeners.remove(listener);
		}

		public void dispose() {
			changeListeners = null;
		}
	}

	public ScopeKeeper(ScopeKeeper parent, Widget host) {
		super();
		this.parent = parent;
		host.addDisposeListener(this);
		this.host = host;
	}

	public void widgetDisposed(DisposeEvent e) {
		Widget source = e.widget;
		if(source == host) {
			for(HashMap<Object, HashMap<String, IObservable>> hashMap : bindingData.values()) {
				for(HashMap<String, IObservable> map : hashMap.values()) {
					for(IObservable observable : map.values()) {
						observable.removeChangeListener(changeListenerSupport);
					}
				}
			}
			changeListenerSupport.dispose();
		}
		HashMap<Object, HashMap<String, IObservable>> hashMap = bindingData.get(source);
		if(hashMap != null) {
			for(HashMap<String, IObservable> map : hashMap.values()) {
				for(IObservable observable : map.values()) {
					observable.removeChangeListener(changeListenerSupport);
				}
			}
			bindingData.remove(source);
		}
	}

	public void addNamedObject(String name, Object object) {
		nameMap.put(name, object);
	}

	public Widget getHost() {
		return host;
	}

	public Object getNamedObject(String name) {
		Object object = nameMap.get(name);
		if(object != null) {
			return object;
		}
		return parent == null ? null : parent.getNamedObject(name);
	}

	public Collection<String> names() {
		return nameMap.keySet();
	}

	public boolean containsName(String name) {
		if(nameMap.containsKey(name)) {
			return true;
		}
		return parent == null ? false : parent.containsName(name);
	}

	/**
	 * Register a change listener. The second call to register a same listener
	 * has no effect.
	 * 
	 * @param listener
	 */
	public boolean addChangeListener(IChangeListener listener) {
		return changeListenerSupport.addChangeListener(listener);
	}

	/**
	 * Remove the registered change listener
	 * 
	 * @param listener
	 */
	public void removeChangeListener(IChangeListener listener) {
		changeListenerSupport.removeChangeListener(listener);
	}

	public void fireChangeListener(ChangeEvent event) {
		changeListenerSupport.handleChange(event);
	}

	void addObservableValue(Widget widget, Object data, String property, IObservable value) {
		if(widget == null) {
			widget = host;
		} else {
			widget.addDisposeListener(this);
		}

		HashMap<Object, HashMap<String, IObservable>> widgetData = bindingData.get(widget);
		if(widgetData == null) {
			widgetData = new HashMap<Object, HashMap<String, IObservable>>();
			bindingData.put(widget, widgetData);
		}

		HashMap<String, IObservable> objectData = widgetData.get(data);
		if(objectData == null) {
			objectData = new HashMap<String, IObservable>();
			widgetData.put(data, objectData);
		}
		if(objectData.containsKey(property)) {
			throw new IllegalStateException();
		}
		objectData.put(property, value);

		value.addChangeListener(changeListenerSupport);
	}

	IObservableValue getObservableValue(Widget control, Object data, String property) {
		IObservable observable = getObservable(control, data, property);
		if(observable instanceof IObservableValue) {
			return (IObservableValue)observable;
		}

		return null;
	}

	IObservableList getObservableList(Widget control, Object data, String property) {
		IObservable observable = getObservable(control, data, property);
		if(observable instanceof IObservableList) {
			return (IObservableList)observable;
		}
		return null;
	}

	IObservableSet getObservableSet(Widget control, Object data, String property) {
		IObservable observable = getObservable(control, data, property);
		if(observable instanceof IObservableSet) {
			return (IObservableSet)observable;
		}
		return null;
	}

	IObservable localGetObservable(Widget control, Object data, String property) {
		// find locally
		for(HashMap<Object, HashMap<String, IObservable>> widgetData : bindingData.values()) {
			if(widgetData != null) {
				HashMap<String, IObservable> objectData = widgetData.get(data);
				if(objectData != null) {
					IObservable observable = objectData.get(property);
					if(observable != null) {
						return observable;
					}
				}
			}
		}
		return null;
	}

	IObservable getObservable(Widget control, Object data, String property) {
		// find locally
		IObservable observable = localGetObservable(control, data, property);
		if(observable != null) {
			return observable;
		}

		// find in other ScopeKeeper and then keep it in this ScopeKeeper.
		Widget rootWidget = UserData.findRootWidget(control);
		observable = deepFindObservable(rootWidget, data, property);
		if(observable != null) {
			addObservableValue(control, data, property, observable);
		}
		return observable;
	}

	static IObservable deepFindObservable(Widget control, Object data, String property) {
		ScopeKeeper scopeKeeper = UserData.getLocalScopeKeeper(control);
		if(scopeKeeper != null) {
			IObservable observable = scopeKeeper.localGetObservable(control, data, property);
			if(observable != null) {
				return observable;
			}
		}
		if(control instanceof Composite) {
			Composite composite = (Composite)control;
			for(Control child : composite.getChildren()) {
				IObservable observable = deepFindObservable(child, data, property);
				if(observable != null) {
					return observable;
				}
			}
		}
		return null;
	}
}
