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

import static org.junit.Assert.*;

import java.io.IOException;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class ServiceRegistryFactoryTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Integration test.
	 * Test method for {@link org.eclipse.papyrus.infra.core.serviceregistry.ServiceRegistryFactory#getServicesRegistry(java.lang.String)}.
	 * @throws DeclarationException 
	 * @throws IOException 
	 * @throws ServiceMultiException 
	 */
	@Test
	public void testGetServicesRegistryString() throws DeclarationException, ServiceException, IOException {


		// Initialize Factory
		IExtensionRegistry extensionRegistry = EclipseExtensionUtils.instance.createRegistry("resources/plugin.xml");
		
		IServiceDescriptorsWithIdProvider declarationsProvider = new ExtensionServiceDescriptorsWithIdProviderFromFile(extensionRegistry);
		ServiceRegistryFactory factory = new ServiceRegistryFactory(declarationsProvider);
		
		
		String serviceA = FakeServiceA.class.getName();
		String serviceB = FakeServiceB.class.getName();
		// Create ServiceRegistry from factory
		ServicesRegistry servicesRegistry = factory.getServicesRegistry("simpleTestRegistry");
		servicesRegistry.startNewServices();
		
		// Check result
		assertNotNull("registry created", servicesRegistry);
		
		assertNotNull("Get registered service", servicesRegistry.getService(serviceA));
		assertNotNull("Get registered service", servicesRegistry.getService(serviceB));
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.serviceregistry.ServiceRegistryFactory#extendsServicesRegistry(org.eclipse.papyrus.infra.core.serviceregistry.ServicesRegistry, java.lang.String)}.
	 */
	@Test
	public void testExtendsServicesRegistryServicesRegistryString() {
		fail("Not yet implemented");
	}

}
