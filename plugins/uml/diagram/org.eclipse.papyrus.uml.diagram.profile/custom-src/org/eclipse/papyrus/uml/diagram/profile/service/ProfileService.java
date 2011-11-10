/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.service;

import org.eclipse.papyrus.infra.core.lifecycleevents.ILifeCycleEventsProvider;
import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;


/**
 * This class monitor the life cycle event
 * from the multi editor
 * This class is registered as a Papyrus service.
 * It then registered itself to the {@link LifeCycleEventsProvider}.
 * 
 */
public class ProfileService implements IService {

	/**
	 * the servicesRegistry
	 */
	protected ServicesRegistry servicesRegistry;

	/**
	 * The object firing event about the Editor lifecycle.
	 */
	protected ILifeCycleEventsProvider eventProvider;

	/**
	 * Listener on aboutToSave events.
	 */
	protected PreSaveProfileListener aboutToSaveListener;

	/**
	 * Constructor.
	 * This constructor is called by the ServiceRegistry when this service is created. The
	 * parameter is provided by the ServiceRegistry itself.
	 * 
	 * @param servicesRegistry
	 */
	public ProfileService() {
		aboutToSaveListener = new PreSaveProfileListener();
		//	System.out.println("ProfileService created"); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#disposeService()
	 * 
	 */
	public void disposeService() {
		deactivate();
		//	System.out.println("ProfileService disposed"); //$NON-NLS-1$

	}

	/**
	 * Initialize the service. Set the {@link ServicesRegistry} that can be used to retrieve other services.
	 * This method is called after the object instanciation, and before the service start.
	 * 
	 * @see org.eclipse.papyrus.infra.core.services.IService#init(org.eclipse.papyrus.infra.core.services.ServicesRegistry)
	 * 
	 * @param servicesRegistry
	 */
	public void init(ServicesRegistry servicesRegistry) {
		this.servicesRegistry = servicesRegistry;

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#startService()
	 * 
	 */
	public void startService() {
		activate();
		//	System.out.println("ProfileService started"); //$NON-NLS-1$
	}

	/**
	 * Activate listeners.
	 */
	private void activate() {
		//on enregistre un listener auprès du lifecycle
		try {
			eventProvider = servicesRegistry.getService(ILifeCycleEventsProvider.class);
			eventProvider.addAboutToDoSaveListener(aboutToSaveListener);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	/**
	 * Deactivate listeners
	 */
	private void deactivate() {
		eventProvider.removeAboutToDoSaveListener(aboutToSaveListener);

	}

}
