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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;


/**
 * Class implementing this interface can listen to diagram removed event from a {@link Resource}.
 * 
 * @author cedric dumoulin
 *
 */
public interface INotationDiagramRemovedEventListener {

	/**
	 * Called by events when a {@link Diagram} is removed from the {@link NotationModel}
	 * @param msg
	 */
	public void diagramRemoved(Notification msg) ;
	

}
