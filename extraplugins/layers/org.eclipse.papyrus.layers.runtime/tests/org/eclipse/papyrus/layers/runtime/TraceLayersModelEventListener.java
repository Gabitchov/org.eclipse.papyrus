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
 * A listener on {@link LayersModelEventNotifier}. This listener trace events from
 * the notifier.
 * 
 * @author cedric dumoulin
 *
 */
public class TraceLayersModelEventListener implements ILayersModelEventListener {

	public TriggeredEventTraces traces = new TriggeredEventTraces();
	
	/**
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#propertyValueAdded(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void propertyValueAdded(Notification notification) {
		traces.addTrace("propertyValueAdded", notification);

	}

	/**
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#propertyValueRemoved(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void propertyValueRemoved(Notification notification) {
		traces.addTrace("propertyValueRemoved", notification);
	}

	/**
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#propertyValueChanged(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void propertyValueChanged(Notification notification) {
		traces.addTrace("propertyValueChanged", notification);
	}

	
	/**
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#layerAdded(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void layerSet(Notification notification) {
		traces.addTrace("layerSet", notification);
		
	}
	
	/**
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#layerAdded(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void layerAdded(Notification notification) {
		traces.addTrace("layerAdded", notification);
	}

	/**
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#layerRemoved(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void layerRemoved(Notification notification) {
		traces.addTrace("layerRemoved", notification);
	}

	/**
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#layerMoved(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void layerMoved(Notification notification) {
		traces.addTrace("layerMoved", notification);
	}

	/**
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#viewAddedToLayer(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void viewAddedToLayer(Notification notification) {
		traces.addTrace("viewAddedToLayer", notification);
	}

	/**
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#viewRemovedFromLayer(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void viewRemovedFromLayer(Notification notification) {
		traces.addTrace("viewRemovedFromLayer", notification);
	}

	/**
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#viewMovedBetweenLayer(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void viewMovedBetweenLayer(Notification notification) {
		traces.addTrace("viewMovedBetweenLayer", notification);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#multiViewsRemovedFromLayer(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void multiViewsRemovedFromLayer(Notification notification) {
		traces.addTrace("multiViewsRemovedFromLayer", notification);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#multiViewsAddedToLayer(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void multiViewsAddedToLayer(Notification notification) {
		traces.addTrace("multiViewsAddedToLayer", notification);
	}

}
