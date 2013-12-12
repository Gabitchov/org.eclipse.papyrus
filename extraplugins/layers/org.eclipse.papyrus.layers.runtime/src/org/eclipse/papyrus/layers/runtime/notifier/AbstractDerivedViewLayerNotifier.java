/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.layers.runtime.notifier;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer;

/**
 * Common ancestor of DerivedViewLayerNotifier.
 * This class maintains a list of listeners. It allows to add and remove listeners.
 * If there is no more listener, stop listening on external events.
 * Start listening on external events as soon as there is a listener.
 * 
 * @author cedric dumoulin
 *
 */
public abstract class AbstractDerivedViewLayerNotifier {

	/**
	 * List of listeners that should be notified.
	 */
	protected List<RegExpLayer> listeners = new ArrayList<RegExpLayer>();
	
	/**
	 * Indicate if this Notifier is listening on externals events
	 */
	private boolean isListening = false;
	
	/**
	 * Attach the listener to this notifier.
	 * 
	 * @param layer
	 */
	public void addListener(RegExpLayer listener) {
		if(!listeners.contains(listener)) {
			listeners.add(listener);
			checkStartListening();
		}
	}
	
	/**
	 * Attach the listener to this notifier.
	 * 
	 * @param layer
	 */
	public void removeListener(RegExpLayer listener) {
			listeners.remove(listener);
			checkStopListening();
		
	}
	
	/**
	 * Attach the listener to this notifier.
	 * 
	 * @param layer
	 */
	public void removeAllListeners() {
		isListening = false;
		listeners.clear();
		stopListening();
	}
	
	/**
	 * Check if we should start listening. 
	 * If the class is not listening on externals events, and there is some listeners, then 
	 * start listening (call {@link #startListening()} and set {@link #isListening()} to true.
	 */
	private void checkStartListening() {
		if( !isListening() && listeners.size() > 0) {
			isListening=true;
			startListening();
		}
	}

	/**
	 * Check if we should stop listening.
	 * If the class is  listening on externals events, and there is no more listeners, then 
	 * stop listening (call {@link #stopListening()} and set {@link #isListening()} to false.
	 */
	private void checkStopListening() {
		if(isListening() && listeners.size() == 0) {
			isListening = false;
			stopListening();
		}
	}

	/**
	 * fire the event to all registered listeners.
	 */
	public void fireEvent( ) {
		for( RegExpLayer listener : listeners) {
			listener.evaluateExpr();
		}
	}
	
	/**
	 * Start listening on external events.
	 * Should be implemented by subclass
	 */
	abstract protected void startListening();
	
	/**
	 * Stop listening on external events.
	 * Should be implemented by subclass
	 */
	abstract protected void stopListening();

	/**
	 * Return true if this Notifier is listening on externals events.
	 * @return
	 */
	public boolean isListening() {
		// This notifier is listening if there is some listener in the list
		return isListening;
	}

	

}
