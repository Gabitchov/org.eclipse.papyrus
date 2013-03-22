/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.papyrus.uml.diagram.common.providers.UIAdapterImpl;

public class NotificationHelper {

	private UIAdapterImpl modelListener;

	private List<Notifier> listeners = new ArrayList<Notifier>();

	public NotificationHelper(UIAdapterImpl modelListener) {
		this.modelListener = modelListener;
	}

	/**
	 * Add listener on a element
	 * 
	 * @param element
	 *        The object to listen
	 */
	public void listenObject(Notifier element) {
		// Only listen the object if it isn't yet listened
		if(element != null && !element.eAdapters().contains(modelListener)) {
			element.eAdapters().add(modelListener);
			listeners.add(element);
		}
	}

	/**
	 * Remove listener on a element
	 * 
	 * @param element
	 *        The object to unlisten
	 */
	public void unlistenObject(Notifier element) {
		// Only listen the object if it isn't yet listened
		if(element != null && element.eAdapters().contains(modelListener)) {
			element.eAdapters().remove(modelListener);
		}
		listeners.remove(element);
	}

	/**
	 * Remove all listeners
	 */
	public void unlistenAll() {
		if(listeners.size() > 0) {
			for(Notifier listener : listeners) {
				if(listener != null && listener.eAdapters().contains(modelListener)) {
					listener.eAdapters().remove(modelListener);
				}
			}
			listeners.clear();
		}
	}

}
