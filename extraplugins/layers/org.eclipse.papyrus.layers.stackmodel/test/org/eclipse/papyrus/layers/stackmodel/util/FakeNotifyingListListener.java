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
public class FakeNotifyingListListener<E> {

	/**
	 * Trace object tracking events
	 */
	public TriggeredEventTraces<NotyfyingList<E>.NotifyingListEvent> traces = new TriggeredEventTraces<NotyfyingList<E>.NotifyingListEvent>();

	
	/**
	 * Method listeneing to the list event.
	 * @param event
	 */
	@Subscribe 
	public void elementAddedToList(NotyfyingList<E>.NotifyingListEvent event) {
		traces.addTrace("elementAddedToList", event);
	}
}
