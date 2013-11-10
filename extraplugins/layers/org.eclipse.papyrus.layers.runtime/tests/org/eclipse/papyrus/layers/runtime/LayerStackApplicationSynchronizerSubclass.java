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
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.layers.runtime.model.LayersModel;
import org.eclipse.papyrus.layers.runtime.utils.TriggeredEventTraces;


/**
 * This class subclass the {@link LayerStackApplicationSynchronizer} in order to record
 * the calls to the method catching the events from the superclass.
 * 
 * @author cedric dumoulin
 *
 */
public class LayerStackApplicationSynchronizerSubclass extends LayerStackApplicationSynchronizer {

	/**
	 * List of recorded events.
	 */
	public TriggeredEventTraces traces ;
	
	/**
	 * Constructor.
	 *
	 * @param layersModel
	 * @param notationModel
	 */
	public LayerStackApplicationSynchronizerSubclass(LayersModel layersModel, NotationModel notationModel) {
		super(layersModel, notationModel);
		traces = new TriggeredEventTraces();
	}

	
	/**
	 * Constructor.
	 *
	 * @param layersModel
	 * @param notationModel
	 * @param traces
	 */
	public LayerStackApplicationSynchronizerSubclass(LayersModel layersModel, NotationModel notationModel, TriggeredEventTraces traces) {
		super(layersModel, notationModel);
		this.traces = traces;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.layers.runtime.LayerStackApplicationSynchronizer#layerStackAdded(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param msg
	 */
	@Override
	public void layerStackAdded(Notification msg) {
		traces.addTrace( "layerStackAdded", msg);
		super.layerStackAdded(msg);
	}
	
	/**
	 * 
	 * @see org.eclipse.papyrus.layers.runtime.LayerStackApplicationSynchronizer#layerStackRemoved(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param msg
	 */
	@Override
	public void layerStackRemoved(Notification msg) {
		traces.addTrace("layerStackRemoved", msg);
		super.layerStackRemoved(msg);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.layers.runtime.LayerStackApplicationSynchronizer#diagramRemoved(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param msg
	 */
	@Override
	public void diagramRemoved(Notification msg) {
		traces.addTrace("diagramRemoved", msg);
		super.diagramRemoved(msg);
	}
}
