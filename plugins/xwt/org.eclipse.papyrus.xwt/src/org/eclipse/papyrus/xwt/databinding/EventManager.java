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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.Realm;

/**
 * This class <code>EventManager</code> is used to manage all event listeners for a observed object.
 * 
 * @author jliu jin.liu@soyatec.com
 */
public class EventManager {

	private static Map<Object, EventManager> managers = new HashMap<Object, EventManager>();

	private Realm realm;

	private Map<String, List<EventListener>> type2listeners = new HashMap<String, List<EventListener>>();

	/**
	 * private constructor, lazy creating.
	 */
	private EventManager(Object observed, Realm realm) {
		this.realm = realm;
	}

	public static EventManager getEventManager(Object eventTarget, Realm realm) {
		EventManager eventManager = managers.get(eventTarget);
		if(eventManager == null || eventManager.realm != realm) {
			eventManager = new EventManager(eventTarget, realm);
			managers.put(eventTarget, eventManager);
		}
		return eventManager;
	}

	public void dispatchEvent(Event event) {
		String eventType = event.getEventType();
		List<EventListener> listeners = type2listeners.get(eventType);
		for(EventListener l : listeners) {
			l.handleEvent(event);
		}
	}

	public void addEventListener(String eventType, EventListener eventListener) {
		List<EventListener> listeners = type2listeners.get(eventType);
		if(listeners == null) {
			listeners = new ArrayList<EventListener>();
			type2listeners.put(eventType, listeners);
		}
		listeners.add(eventListener);
	}

	public void removeEventListener(String eventType, EventListener eventListener) {
		List<EventListener> listeners = type2listeners.get(eventType);
		if(listeners != null) {
			listeners.remove(eventListener);
		}
	}
}
