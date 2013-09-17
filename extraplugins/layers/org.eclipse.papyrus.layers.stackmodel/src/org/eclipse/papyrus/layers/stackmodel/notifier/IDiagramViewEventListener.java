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
package org.eclipse.papyrus.layers.stackmodel.notifier;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;


/**
 * Class implementing this interface can listen to event from a {@link LayersStackApplication}.
 * 
 * @author cedric dumoulin
 *
 */
public interface IDiagramViewEventListener {

	/**
	 * Called by events when a {@link View} is added to the {@link Diagram} or one of its contained
	 * elements.
	 * @param msg
	 */
	public void diagramViewAdded(Notification msg) ;
	
	/**
	 * Called by events when a {@link View} is removed from the {@link Diagram} or one of its contained
	 * elements.
	 * @param msg
	 */
	public void diagramViewRemoved(Notification msg) ;
	

}
