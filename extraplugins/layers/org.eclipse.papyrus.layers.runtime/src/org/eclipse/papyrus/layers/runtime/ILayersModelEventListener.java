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
package org.eclipse.papyrus.layers.runtime;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;


/**
 * Class implementing this interface can listen to event from a {@link LayersStack}.
 * 
 * @author cedric dumoulin
 *
 */
public interface ILayersModelEventListener {

	/**
	 * Method called when a value is added to one layer.
	 * The vent contains: the layer, the property name, the new value.
	 * 
	 * @param notification
	 */
	public void propertyValueAdded( Notification notification );
	public void propertyValueRemoved( Notification notification );
	public void propertyValueChanged( Notification notification );
	
	/**
	 * Method called when a layer is added to one layer.
	 * The event contains: the layer.
	 * 
	 * @param notification
	 */
	public void layerAdded( Notification notification );
	public void layerRemoved( Notification notification );
	public void layerMoved( Notification notification );
	public void layerSet( Notification notification );

	/**
	 * Method called when a view is added to one layer.
	 * The event contains: the layer, the view.
	 * 
	 * @param notification
	 */
	public void viewAddedToLayer( Notification notification );
	public void viewRemovedFromLayer( Notification notification );
	/**
	 * Method called when a view is moved from one layer to another.
	 * The event contains: the layer, the view.
	 * Warning : this handler is never called in the current implementation.
	 * @param notification
	 */
	public void viewMovedBetweenLayer( Notification notification );

}
