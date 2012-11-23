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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * Notification Manager for the Shape Service. 
 * <P>This manager will centralized for a given view all elements that have to be watched in order to react to changes.</P>
 */
public class NotificationManager {

	/** view that listens for modifications */
	private EObject view;
	
	/** list of provider notification manager */
	private List<ProviderNotificationManager> providerNotificationManagers;
	
	/**
	 * Creates a new NotificationManager.
	 *
	 * @param view the main object that have to listen for notifications
	 */ 
	public NotificationManager(EObject view) {
		this.view = view;
		providerNotificationManagers = new ArrayList<ProviderNotificationManager>();
	}
	
	/**
	 * Returns the view that listens for modifications
	 * @return the view that listens for modifications
	 */
	public EObject getView() {
		return view;
	}

	/**
	 * Returns the list of provider notification manager
	 * @return the providerNotificationManager
	 */
	public List<ProviderNotificationManager> getProviderNotificationManagers() {
		return providerNotificationManagers;
	}

	/**
	 * Makes the object ready for GC.
	 */
	public void dispose() {
		//remove all listeners 
		for(ProviderNotificationManager providerNotificationManager : getProviderNotificationManagers()) {
			if(providerNotificationManager !=null) {
				providerNotificationManager.dispose();
			}
		}
		providerNotificationManagers.clear();
		providerNotificationManagers = null;
		view = null;
	}
}
