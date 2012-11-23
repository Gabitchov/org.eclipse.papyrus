/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.service.shape;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;


/**
 * Operation that ask the shape provider to add notification listeners to the interesting objects.
 */
public class CreateProviderNotificationManagersOperation implements IOperation, IShapeProviderOperation {

	/** diagram event broker that dispatches the notifications to interested elements */
	private DiagramEventBroker diagramEventBroker;

	/** view from which objects to listen are retrieved */
	private EObject view;

	/** notification listener to be notified of modifications */
	private NotificationListener notificationListener;

	/**
	 * Creates a new AddNotificationListenersOperation.
	 *
	 * @param diagramEventBroker diagram event broker that dispatches the notifications to interested elements 
	 * @param view view from which objects to listen are retrieved 
	 * @param notificationListener 
	 */
	public CreateProviderNotificationManagersOperation(DiagramEventBroker diagramEventBroker, EObject view, NotificationListener notificationListener) {
		this.diagramEventBroker = diagramEventBroker;
		this.view = view;
		this.notificationListener = notificationListener;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object execute(IProvider provider) {
		if(provider instanceof IShapeProvider) {
			return ((IShapeProvider)provider).createProviderNotificationManager(getDiagramEventBroker(), getView(), getNotificationListener());	
		}
		return null;
	}

	protected EObject getView() {
		return view;
	}

	protected DiagramEventBroker getDiagramEventBroker() {
		return diagramEventBroker;
	}
	
	protected NotificationListener getNotificationListener() {
		return notificationListener;
	}
}
