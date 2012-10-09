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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class ExtensionServiceDescriptorsWithIdProviderIntegrationTest {

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
	 * Test method for {@link org.eclipse.papyrus.infra.core.serviceregistry.internal.ServicesRegistryConfigurationReaderFromExtensions#loadServicesRegistryConfiguration(org.eclipse.papyrus.infra.core.serviceregistry.ServicesRegistry, java.lang.String)}.
	 * @throws IOException 
	 * @throws ServiceException 
	 * @throws DeclarationException 
	 */
	@Test
	public void testLoadServicesSetConfiguration() throws IOException, ServiceException, DeclarationException {
		
		// Create a declaration provider, and a factory
		IExtensionRegistry extensionRegistry = EclipseExtensionUtils.instance.createRegistry("resources/plugin.xml");
		IServiceDescriptorsWithIdProvider declarationsProvider = new ExtensionServiceDescriptorsWithIdProviderFromFile(extensionRegistry);
		ServiceRegistryFactory factory = new ServiceRegistryFactory(declarationsProvider);	
		// Create ServiceRegistry from factory
		ServicesRegistry registry = factory.getServicesRegistry("simpleTestRegistry");
		
//		String servicesSetName = "simpleTest";
		
		// Check if specified service are in the registry
		Class<?> serviceA = FakeServiceA.class;
		Class<?> serviceC = FakeServiceC.class;

		assertNotNull( "service registered", registry.serviceState(serviceA) );
		assertSame( "service registered", ServiceState.registered, registry.serviceState(serviceA) );
		assertSame( "service registered", ServiceState.registered, registry.serviceState(serviceC) );
		
		registry.startNewServices();
		assertNotNull( "service found", registry.getService(serviceA) );
		assertNotNull( "service found", registry.getService(serviceC) );
		
		registry.disposeRegistry(true);
	}

	/**
	 * Test a set extending another set.
	 * 	 * @throws IOException 
	 * @throws ServiceException 
	 * @throws DeclarationException 
	 */
	@Test
	public void testLoadServicesSetWithExtends() throws IOException, ServiceException, DeclarationException {
		
		// Create a declaration provider, and a factory
		IExtensionRegistry extensionRegistry = EclipseExtensionUtils.instance.createRegistry("resources/plugin.xml");
		IServiceDescriptorsWithIdProvider declarationsProvider = new ExtensionServiceDescriptorsWithIdProviderFromFile(extensionRegistry);
		ServiceRegistryFactory factory = new ServiceRegistryFactory(declarationsProvider);	
		// Create ServiceRegistry from factory
		ServicesRegistry registry = factory.getServicesRegistry("extendingSetRegistry");
		
		// Create a ServiceRegistry
//		String servicesSetName = "extendingSet";
		
		// set(A, B) --> set(C)
		
		// Check if specified service are in the registry
		// C should be in the registry
		Class<?> serviceA = FakeServiceA.class;
		Class<?> serviceB = FakeServiceB.class;
		Class<?> serviceC = FakeServiceC.class;

		assertNotNull( "service registered", registry.serviceState(serviceA) );
		assertSame( "service registered", ServiceState.registered, registry.serviceState(serviceA) );
		assertSame( "service registered", ServiceState.registered, registry.serviceState(serviceB) );
		assertSame( "service registered", ServiceState.registered, registry.serviceState(serviceC) );
		
		registry.startNewServices();
		assertNotNull( "service found", registry.getService(serviceA) );
		assertNotNull( "service found", registry.getService(serviceC) );
		
		registry.disposeRegistry(true);
	}

	/**
	 * Test a set extending another set.
	 * 	 * @throws IOException 
	 * @throws ServiceException 
	 * @throws DeclarationException 
	 */
	@Test
	public void testBadDeclaration() throws IOException, ServiceException, DeclarationException {
		// Create a declaration provider, and a factory
		IExtensionRegistry extensionRegistry = EclipseExtensionUtils.instance.createRegistry("resources/plugin.xml");
		IServiceDescriptorsWithIdProvider declarationsProvider = new ExtensionServiceDescriptorsWithIdProviderFromFile(extensionRegistry);
		ServiceRegistryFactory factory = new ServiceRegistryFactory(declarationsProvider);	
		// Create ServiceRegistry from factory
		
		// Create a ServiceRegistry
		ServicesRegistry registry ;
//		String servicesSetName = "badSetExtendsIdMissing";
		try {
			registry = factory.getServicesRegistry("badSetExtendsIdMissingRegistry");
			registry.startNewServices();
			fail("Exception should be thrown");
		} catch (DeclarationException e) {
//			e.printStackTrace();
		}

	}
	
	/**
	 * Test a set extending another set.
	 * 	 * @throws IOException 
	 * @throws ServiceException 
	 * @throws DeclarationException 
	 */
	@Test
	public void testMissingBadServiceSetName() throws IOException, ServiceException, DeclarationException {
		// Create a declaration provider, and a factory
		IExtensionRegistry extensionRegistry = EclipseExtensionUtils.instance.createRegistry("resources/plugin.xml");
		IServiceDescriptorsWithIdProvider declarationsProvider = new ExtensionServiceDescriptorsWithIdProviderFromFile(extensionRegistry);
		ServiceRegistryFactory factory = new ServiceRegistryFactory(declarationsProvider);	
		
		// Create a ServiceRegistry
		ServicesRegistry registry ;
//		String servicesSetName = "NonExistingName";
		try {
			// Create ServiceRegistry from factory
			 registry = factory.getServicesRegistry("NonExistingName");
			registry.startNewServices();
			fail("Exception should be thrown");
		} catch (DeclarationException e) {
//			e.printStackTrace();
		}

	}
	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.serviceregistry.internal.ServicesRegistryConfigurationReaderFromExtensions#loadServicesRegistryConfiguration(org.eclipse.papyrus.infra.core.serviceregistry.ServicesRegistry, java.lang.String)}.
	 * @throws IOException 
	 * @throws ServiceException 
	 * @throws DeclarationException 
	 */
	@Test
	public void testServicesWithExtends() throws IOException, ServiceException, DeclarationException {
		
		// Create a declaration provider, and a factory
		IExtensionRegistry extensionRegistry = EclipseExtensionUtils.instance.createRegistry("resources/plugin.xml");
		IServiceDescriptorsWithIdProvider declarationsProvider = new ExtensionServiceDescriptorsWithIdProviderFromFile(extensionRegistry);
		ServiceRegistryFactory factory = new ServiceRegistryFactory(declarationsProvider);	
		// Create ServiceRegistry from factory
		ServicesRegistry registry = factory.getServicesRegistry("dependantServicesRegistry");

//		String servicesSetName = "dependantServices";
		FakeService.getTrace().reset();
		registry.startNewServices();
	
	
		// check services
		Class<?> serviceA = FakeServiceA.class;
		Class<?> serviceB = FakeServiceB.class;
		Class<?> serviceC = FakeServiceC.class;
		// A and C should be started, B should not be started.
		assertTrue("A started", registry.isStarted(serviceA));
		assertFalse("B not started", registry.isStarted(serviceB));
		assertTrue("C started", registry.isStarted(serviceC));

		// Check if we can get them
		assertNotNull("got service started", registry.getService(serviceC));
		assertNotNull("got service started", registry.getService(serviceA));
		
		// check creation order	(C then A)	
		// order should be C, A
		TestTrace trace = FakeService.getTrace();
		int i = 0;
		assertEquals("order", serviceC.getSimpleName() + ",create", trace.getNameTrace(i++));
		assertEquals("order", serviceA.getSimpleName() + ",create", trace.getNameTrace(i++));

		assertEquals("order", serviceC.getSimpleName() + ",init", trace.getNameTrace(i++));
		assertEquals("order", serviceA.getSimpleName() + ",init", trace.getNameTrace(i++));

		assertEquals("order", serviceC.getSimpleName() + ",start", trace.getNameTrace(i++));
		assertEquals("order", serviceA.getSimpleName() + ",start", trace.getNameTrace(i++));

		// start B
		assertNotNull("got service started", registry.getService(serviceB));
		assertTrue("B started", registry.isStarted(serviceB));

		registry.disposeRegistry(true);
	}


	
	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.serviceregistry.internal.ServicesRegistryConfigurationReaderFromExtensions#loadServicesSetConfiguration(org.eclipse.papyrus.infra.core.serviceregistry.ServicesRegistry, java.lang.String)}.
	 */
	@Test
	public void testLoadServicesRegistryConfiguration() {
		fail("Not yet implemented");
	}

	/**
	 * Check if a serviceSet declared in several fragments with the same name is correctly loaded.
	 * 
	 * @throws IOException 
	 * @throws ServiceException 
	 * @throws DeclarationException 
	 */
	@Test
	public void testLoadServicesSetFromPartialFragments() throws IOException, ServiceException, DeclarationException {
		
		// Create a declaration provider, and a factory
		IExtensionRegistry extensionRegistry = EclipseExtensionUtils.instance.createRegistry("resources/plugin.xml");
		IServiceDescriptorsWithIdProvider declarationsProvider = new ExtensionServiceDescriptorsWithIdProviderFromFile(extensionRegistry);
		ServiceRegistryFactory factory = new ServiceRegistryFactory(declarationsProvider);	
		// Create ServiceRegistry from factory
		ServicesRegistry registry = factory.getServicesRegistry("doubleNameRegistry");
		
		// Create a ServiceRegistry
//		String servicesSetName = "doubleName";
		
		// Check if specified service are in the registry
		Class<?> serviceA = FakeServiceA.class;
		Class<?> serviceB = FakeServiceB.class;

		assertNotNull( "service registered", registry.serviceState(serviceA) );
		assertSame( "service registered", ServiceState.registered, registry.serviceState(serviceA) );
		assertSame( "service registered", ServiceState.registered, registry.serviceState(serviceB) );
		
		registry.startNewServices();
		assertNotNull( "service found", registry.getService(serviceA) );
		assertNotNull( "service found", registry.getService(serviceB) );
		
		registry.disposeRegistry(true);
	}

	/**
	 * Check if a serviceSet declared in several fragments with the same name is correctly loaded.
	 * 
	 * @throws IOException 
	 * @throws ServiceException 
	 * @throws DeclarationException 
	 * @throws ServiceException 
	 */
	@Test
	public void testLoadAlias() throws IOException, DeclarationException, ServiceException {
		
		// Create a declaration provider, and a factory
		IExtensionRegistry extensionRegistry = EclipseExtensionUtils.instance.createRegistry("resources/plugin.xml");
		IServiceDescriptorsWithIdProvider declarationsProvider = new ExtensionServiceDescriptorsWithIdProviderFromFile(extensionRegistry);
		ServiceRegistryFactory factory = new ServiceRegistryFactory(declarationsProvider);	
		// Create ServiceRegistry from factory
		ServicesRegistry registry = factory.getServicesRegistry("setWithAliasRegistry");
		registry.startNewServices();
		
		// Check if specified service are in the registry
		Class<?> serviceA = FakeServiceA.class;
		String aliasService = "AnAlias";
		assertNotNull( "service found", registry.getService(serviceA) );
		assertNotNull( "service found", registry.getService(aliasService) );
		assertSame("same service", registry.getService(serviceA), registry.getService(aliasService));
		registry.disposeRegistry(true);
	}


}
