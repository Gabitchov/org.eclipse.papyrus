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
package org.eclipse.papyrus.layers.stackmodel.notifier;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.papyrus.layers.stackmodel.util.TriggeredEventTraces;


/**
 * A listener on {@link LayersModelEventNotifier}. This listener trace events from
 * the notifier.
 * 
 * @author cedric dumoulin
 *
 */
public class TraceDiagramViewChangedEventListener implements IDiagramViewEventListener {

	public TriggeredEventTraces<Notification> traces = new TriggeredEventTraces<Notification>();
	
	/**
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#layerAdded(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void diagramViewAdded(Notification notification) {
		traces.addTrace("diagramViewAdded", notification);
		
	}
	
	/**
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#layerAdded(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void diagramViewRemoved(Notification notification) {
		traces.addTrace("diagramViewRemoved", notification);
	}

	/**
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#layerRemoved(org.eclipse.emf.common.notify.Notification)
	 * This does not exist actually.
	 * @param notification
	 */
	public void diagramViewMoved(Notification notification) {
		traces.addTrace("diagramViewMoved", notification);
	}


}
