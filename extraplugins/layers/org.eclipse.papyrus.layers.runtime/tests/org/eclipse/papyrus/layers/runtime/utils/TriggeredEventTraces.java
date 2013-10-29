/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.runtime.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;


/**
 * This class is used to record a list of traces.
 * Traces are for event triggered by a method.
 * This class is for tests purpose.
 * 
 * @author cedric dumoulin
 *
 */
public class TriggeredEventTraces  {


	/**
	 * List of recorded events
	 */
	public List<TriggeredEvent> traces = new ArrayList<TriggeredEvent>();

	/**
	 * Clear all traces.
	 */
	public void clear() {
		traces.clear();
	}
	
	/**
	 * Add a trace to the list of traces
	 * @param name
	 * @param notification
	 */
	public void addTrace(String name, Notification notification) {
		traces.add(new TriggeredEvent(name, notification));
	}

	/**
	 * Return true if one of the trace has the specified name.
	 * @param name
	 * @return
	 */
	public boolean contains(String name) {
		if( name == null)
			return false;
		
		for(TriggeredEvent event : traces) {
			if(name.equals(event.name))
				return true;
		}
		return false;
	}

	/**
	 * Return true if one of the trace has the specified name.
	 * @param name Name of the event to found
	 * @return the first event with the specified name, or null if nothing is found.
	 */
	public TriggeredEvent getFirstEvent(String name) {
		if( name == null)
			return null;
		
		for(TriggeredEvent event : traces) {
			if(name.equals(event.name))
				return event;
		}
		return null;
	}


	/**
	 * A record of an event
	 *
	 */
	public class TriggeredEvent {
		public String name;
		public Notification notifier;
		public Object object;
		/**
		 * Constructor.
		 *
		 * @param name
		 * @param notifier
		 */
		public TriggeredEvent(String name, Notification notifier) {
			this.name = name;
			this.notifier = notifier;
		}
		/**
		 * Constructor.
		 *
		 * @param name
		 * @param object
		 */
		public TriggeredEvent(String name, Object object) {
			this.name = name;
			this.object = object;
		}
		
	}


	/**
	 * Return the number of traces
	 * @return
	 */
	public int size() {
		return traces.size();
	}

	/**
	 * Get the specified trace.
	 * @param i
	 * @return
	 */
	public TriggeredEvent get(int index) {
		return traces.get(index);
	}
}
