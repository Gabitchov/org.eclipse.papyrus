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
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;


/**
 * A subclass registering events
 * For tests purpose.
 * @author cedric dumoulin
 *
 */
public class LayerStackSynchronizerSubclass extends LayerStackSynchronizer {

	/**
	 * List of recorded events.
	 */
	public TriggeredEventTraces traces ;
	
	/**
	 * Constructor.
	 *
	 * @param layersStack
	 */
	public LayerStackSynchronizerSubclass(LayersStack layersStack) {
		super(layersStack);
		traces = new TriggeredEventTraces();
	}

	/**
	 * @see org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#propertyValueAdded(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void propertyValueAdded(Notification notification) {
		traces.addTrace( "propertyValueAdded", notification);
		super.propertyValueAdded(notification);
	}

	/**
	 * @see org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#propertyValueRemoved(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void propertyValueRemoved(Notification notification) {
		traces.addTrace( "propertyValueRemoved", notification);
		super.propertyValueRemoved(notification);
	}

	/**
	 * @see org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#propertyValueChanged(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void propertyValueChanged(Notification notification) {
		traces.addTrace( "propertyValueChanged", notification);
		super.propertyValueChanged(notification);
	}

	/**
	 * @see org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#layerAdded(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void layerAdded(Notification notification) {
		traces.addTrace( "layerAdded", notification);
		super.layerAdded(notification);
	}

	/**
	 * @see org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#layerRemoved(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void layerRemoved(Notification notification) {
		traces.addTrace( "layerRemoved", notification);
		super.layerRemoved(notification);
	}

	/**
	 * @see org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#layerMoved(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void layerMoved(Notification notification) {
		traces.addTrace( "layerMoved", notification);
		super.layerMoved(notification);
	}

	/**
	 * @see org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#layerSet(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void layerSet(Notification notification) {
		traces.addTrace( "layerSet", notification);
		super.layerSet(notification);
	}

	/**
	 * @see org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#viewAddedToLayer(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void viewAddedToLayer(Notification notification) {
		traces.addTrace( "viewAddedToLayer", notification);
		super.viewAddedToLayer(notification);
	}

	/**
	 * @see org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#viewRemovedFromLayer(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void viewRemovedFromLayer(Notification notification) {
		traces.addTrace( "viewRemovedFromLayer", notification);
		super.viewRemovedFromLayer(notification);
	}

	/**
	 * @see org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#viewMovedBetweenLayer(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void viewMovedBetweenLayer(Notification notification) {
		traces.addTrace( "viewMovedBetweenLayer", notification);
		super.viewMovedBetweenLayer(notification);
	}

	/**
	 * @see org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#diagramViewAdded(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param msg
	 */
	@Override
	public void diagramViewAdded(Notification msg) {
		traces.addTrace( "diagramViewAdded", msg);
		super.diagramViewAdded(msg);
	}

	/**
	 * @see org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#diagramViewRemoved(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param msg
	 */
	@Override
	public void diagramViewRemoved(Notification msg) {
		traces.addTrace( "diagramViewRemoved", msg);
		super.diagramViewRemoved(msg);
	}

	
}
