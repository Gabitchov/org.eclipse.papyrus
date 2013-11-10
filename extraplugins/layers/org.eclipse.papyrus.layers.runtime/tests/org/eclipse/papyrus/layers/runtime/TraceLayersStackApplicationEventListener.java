/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.runtime;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.papyrus.layers.runtime.utils.TriggeredEventTraces;


/**
 * A listener on {@link LayersStackApplicationEventNotifier}. This listener trace events from
 * the notifier.
 * 
 * @author cedric dumoulin
 *
 */
public class TraceLayersStackApplicationEventListener implements ILayersStackApplicationEventListener {

	public TriggeredEventTraces traces = new TriggeredEventTraces();
	
	/**
	 * @see org.eclipse.papyrus.layers.runtime.ILayersStackApplicationEventListener#layerStackAdded(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param msg
	 */
	@Override
	public void layerStackAdded(Notification msg) {
		traces.addTrace("layerStackAdded", msg);

	}

	/**
	 * @see org.eclipse.papyrus.layers.runtime.ILayersStackApplicationEventListener#layerStackRemoved(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param msg
	 */
	@Override
	public void layerStackRemoved(Notification msg) {
		traces.addTrace("layerStackRemoved", msg);

	}

}
