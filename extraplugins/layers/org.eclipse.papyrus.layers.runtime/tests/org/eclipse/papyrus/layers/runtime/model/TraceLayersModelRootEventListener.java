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
package org.eclipse.papyrus.layers.runtime.model;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.papyrus.layers.runtime.utils.TriggeredEventTraces;


/**
 * A listener on {@link NotationDiagramRemovedFromResourceEventNotifier}. This listener trace events from
 * the notifier.
 * 
 * @author cedric dumoulin
 *
 */
public class TraceLayersModelRootEventListener implements ILayersModelRootEventListener {

	public TriggeredEventTraces traces = new TriggeredEventTraces();
	

	@Override
	public void layersModelRootAdded(Notification msg) {
		traces.addTrace("layersModelRootAdded", msg);
	}


	@Override
	public void layersModelRootRemoved(Notification msg) {
		traces.addTrace("layersModelRootRemoved", msg);
	}

}
