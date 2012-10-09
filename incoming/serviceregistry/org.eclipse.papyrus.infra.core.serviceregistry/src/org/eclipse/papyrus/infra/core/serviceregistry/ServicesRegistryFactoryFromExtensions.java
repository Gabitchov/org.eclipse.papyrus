/*****************************************************************************
 * Copyright (c) 2012 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.serviceregistry;


/**
 * Factory used to create and populate a {@link ServicesRegistry} from declarations in Eclipse extensions.
 * 
 * @author cedric dumoulin
 *
 */
public class ServicesRegistryFactoryFromExtensions {

	/**
	 * Instance that can be used to create Registries.
	 */
	public static ServicesRegistryFactoryFromExtensions instance = new ServicesRegistryFactoryFromExtensions();
	
	
	/**
	 * Create a new {@link ServicesRegistry} and initialized it from the configuration found in the 
	 * eclipse extension under the specified name.
	 * 
	 * @param registryName The name of the configuration to use to initialize the registry.
	 * @return A new ServicesRegistry initialized according to the specified configuration.
	 */
	public ServicesRegistry createServicesRegistry(String registryName) throws ServiceException {
		
		// Create registry
		ServicesRegistry registry = new ServicesRegistry();
		// Load its configuration
		loadServicesRegistryConfiguration(registry, registryName);
		// Start the registry
		registry.startNewServices();
		return registry;
	}
	
	/**
	 * Update the specified {@link ServicesRegistry} with the specified configuration. The configuration is read from
	 * the eclipse extension "registry".
	 * <br>
	 * The services found into the specified configuration are added to the registry if they are not
	 * already present.
	 * <br>
	 * The services are started.
	 * 
	 * @param registry The registry to update.
	 * @param registryName The name of the configuration to use to update the registry.

	 * @return
	 */
	public ServicesRegistry updateServicesRegistry(ServicesRegistry registry, String registryName) throws ServiceException {
		// Load its configuration
		loadServicesRegistryConfiguration(registry, registryName);
		// Start the registry
		registry.startNewServices();
		return registry;		
	}

	/**
	 * Load the specified configuration into the {@link ServicesRegistry}. Do not start the services.
	 * 
	 * @param registry The registry to update
	 * @param registryName The name of the configuration to load.
	 * @throws ServiceException
	 */
	public void loadServicesRegistryConfiguration(ServicesRegistry registry, String registryName) throws ServiceException {
		
	}

	/**
	 * Add the services to the {@link ServicesRegistry}. Do not start them. Services descriptions are loaded from 
	 * the specified servicesSetName in the eclipse extensions "servicesSet".
	 * 
	 * @param registry The registry to populate
	 * @param servicesSetName The set to load
	 * @throws ServiceException If a error occurs.
	 */
	public void addNewServices(ServicesRegistry registry, String serviceSetName ) throws ServiceException {
		
	}
}
