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

package org.eclipse.papyrus.layers.stackmodel.util;

import com.google.common.eventbus.Subscribe;

/**
 * A class listening on events, and recording them.
 * 
 * @author cedric dumoulin
 *
 */
public class FakeObservableListListener<E> {

	/**
	 * Trace object tracking events
	 */
	public TriggeredEventTraces<ObservableListView<E>.ObservableListEvent> traces = new TriggeredEventTraces<ObservableListView<E>.ObservableListEvent>();

	
	/**
	 * Method listeneing to the list event.
	 * @param event
	 */
	@Subscribe 
	public void elementAddedToList(ObservableListView<E>.ObservableListEvent event) {
		traces.addTrace("elementAddedToList", event);
	}
}
