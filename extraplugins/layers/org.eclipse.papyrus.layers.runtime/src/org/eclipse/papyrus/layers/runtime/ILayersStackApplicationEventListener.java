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
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;


/**
 * Class implementing this interface can listen to event from a {@link LayersStackApplication}.
 * 
 * @author cedric dumoulin
 *
 */
public interface ILayersStackApplicationEventListener {

	/**
	 * Called by events when a {@link LayersStack} is added to the {@link LayersStackApplication}
	 * @param msg
	 */
	public void layerStackAdded(Notification msg) ;
	
	/**
	 * Called by events when a {@link LayersStack} is removed from the {@link LayersStackApplication}
	 * @param msg
	 */
	public void layerStackRemoved(Notification msg) ;
	

}
