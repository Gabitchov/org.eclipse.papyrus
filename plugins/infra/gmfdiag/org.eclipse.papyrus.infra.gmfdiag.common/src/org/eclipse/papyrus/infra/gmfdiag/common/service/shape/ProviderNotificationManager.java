/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.service.shape;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;

/**
 * Abstract notification manager for a given {@link IShapeProvider}.
 */
public abstract class ProviderNotificationManager {

	protected DiagramEventBroker diagramEventBroker;
	protected EObject view;
	protected NotificationListener listener;

	/**
	 * Creates a new ProviderNotificationManager.
	 *
	 * @param diagramEventBroker event broker specific to the diargam displaying the shapes.
	 * @param view the view from which all elements to listen will be computed.
	 * @param listener the listener to which notifications will be forwarded. 
	 */
	public ProviderNotificationManager(DiagramEventBroker diagramEventBroker, EObject view, NotificationListener listener) {
		this.diagramEventBroker = diagramEventBroker;
		this.view = view;
		this.listener = listener;
		registerListeners();
	}

	/**
	 * Register all the required elements in the diagram event broker. 
	 */
	protected abstract void registerListeners() ;
	
	/**
	 * Makes the object ready for GC.
	 */
	public void dispose() {
		view = null;
		diagramEventBroker = null;
		listener = null;
	}

}
