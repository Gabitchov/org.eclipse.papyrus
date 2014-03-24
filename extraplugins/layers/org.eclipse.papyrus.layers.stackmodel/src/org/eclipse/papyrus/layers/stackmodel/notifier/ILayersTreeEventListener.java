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
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;


/**
 * Class implementing this interface can listen to event from a {@link LayersStack}.
 * Interface for listeners whising to be informed of change in the Tree of Layers structure.
 * <br>
 * Listeners of such events should register themself to the notifier {@link LayersTreeEventNotifier}.
 * <br>
 * The following events are fired:
 * <ul>
 *   <li>LayerAdded</li>
 *   <li>LayerRemoved</li>
 *   <li>LayerMoved</li>
 *   <li>LayerSet</li>
 *  </ul>
 * 
 * @author cedric dumoulin
 *
 */
public interface ILayersTreeEventListener {
	
	/**
	 * Method called when a layer is added to one layer.
	 * The event contains: the layer.
	 * 
	 * @param notification
	 */
	public void layerAdded( Notification notification );
	/**
	 * Method called when a layer is removed from one layer.
	 * The event contains: the layer.
	 * 
	 * @param notification
	 */
	public void layerRemoved( Notification notification );
	/**
	 * Method called when a layer is moved inside a {@link LayerOperator}.
	 * The event contains: the layer.
	 * 
	 * @param notification
	 */
	public void layerMoved( Notification notification );
	/**
	 * Method called when a layer is set.
	 * The event contains: the layer.
	 * 
	 * @param notification
	 */
	public void layerSet( Notification notification );

}
