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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Tests ServicesRegistry with a parent registry.
 * 
 * @author cedric dumoulin
 *
 */
public class ServicesRegistryWithParentTest {

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
	 * Test method for {@link org.eclipse.papyrus.infra.core.serviceregistry.ServicesRegistry#addParentRegistry(org.eclipse.papyrus.infra.core.serviceregistry.ServicesRegistry)}.
	 */
	@Test
	public void testAddParentRegistry() {
		
		// Create a service registry
		ServicesRegistry registry = new ServicesRegistry();
		// Add a parent
		ServicesRegistry parentRegistry1 = new ServicesRegistry();
		registry.addParentRegistry(parentRegistry1);
		
		// Add a second parent
		ServicesRegistry parentRegistry2 = new ServicesRegistry();
		registry.addParentRegistry(parentRegistry2);
		
		// Check if parents are set
		// No way to do that. Just check the registry (but this will always succeed)
		assertNotNull("registry created", registry);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.serviceregistry.ServicesRegistry#getService(java.lang.Object)}.
	 * Create a registry with 2 parents. 
	 * Add a service in each registry
	 * Try to get each service from the main regitry.
	 * @throws ServiceException 
	 * 
	 */
	@Test
	public void testGetServiceObject() throws ServiceException {
		
		String A = "serviceA";
		String B = "serviceB";
		String C = "serviceC";

		FakeService.getTrace().reset();
		
		// Create a service registry
		ServicesRegistry registry = new ServicesRegistry();
		// Add a service
		registry.add( new FakeServiceDescriptor( A, ServiceStartKind.STARTUP ));
		registry.startNewServices();

		
		// Create parent registry with one service
		ServicesRegistry registryB = new ServicesRegistry();
		registryB.add( new FakeServiceDescriptor( B, ServiceStartKind.STARTUP ));
		registryB.startNewServices();
		// Add as parent
		registry.addParentRegistry(registryB);
		
		// Create parent registry with one service
		ServicesRegistry registryC = new ServicesRegistry();
		registryC.add( new FakeServiceDescriptor( C, ServiceStartKind.STARTUP ));
		registryC.startNewServices();
		// Add as parent
		registry.addParentRegistry(registryC);
		
		// Check if we can retrieve service
		
		assertNotNull("got service", registry.getService(A));
		assertTrue("Right type", FakeServiceDescriptor.getServiceType().isInstance(registry.getService(A)));
		
		assertNotNull("got service", registry.getService(B));
		assertTrue("Right type", FakeServiceDescriptor.getServiceType().isInstance(registry.getService(B)));
		
		assertNotNull("got service", registry.getService(C));
		assertTrue("Right type", FakeServiceDescriptor.getServiceType().isInstance(registry.getService(C)));
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.serviceregistry.ServicesRegistry#getService(java.lang.Class)}.
	 * @throws ServiceException 
	 */
	@Test
	public void testGetServiceClassOfS() throws ServiceException {

		FakeService.getTrace().reset();
		
		// Create a service registry
		ServicesRegistry registry = new ServicesRegistry();
		// Add a service
		registry.add( new ServiceDescriptor( FakeServiceA.class.getName(), ServiceStartKind.STARTUP, 1 ));
		registry.startNewServices();

		
		// Create parent registry with one service
		ServicesRegistry registryB = new ServicesRegistry();
		registryB.add( new ServiceDescriptor( FakeServiceB.class.getName(), ServiceStartKind.STARTUP, 1 ));
		registryB.startNewServices();
		// Add as parent
		registry.addParentRegistry(registryB);
		
		// Create parent registry with one service
		ServicesRegistry registryC = new ServicesRegistry();
		registryC.add( new ServiceDescriptor( FakeServiceC.class.getName(), ServiceStartKind.STARTUP, 1 ));
		registryC.startNewServices();
		// Add as parent
		registry.addParentRegistry(registryC);
		
		// Check if we can retrieve service
		
		assertNotNull("got service", registry.getService(FakeServiceA.class));
		assertTrue("Right type", FakeServiceDescriptor.getServiceType().isInstance(registry.getService(FakeServiceA.class)));
		
		assertNotNull("got service", registry.getService(FakeServiceB.class));
		assertTrue("Right type", FakeServiceDescriptor.getServiceType().isInstance(registry.getService(FakeServiceB.class)));
		
		assertNotNull("got service", registry.getService(FakeServiceC.class));
		assertTrue("Right type", FakeServiceDescriptor.getServiceType().isInstance(registry.getService(FakeServiceC.class)));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.serviceregistry.ServicesRegistry#startRegistry()}.
	 * @throws ServiceException 
	 */
	@Test
	public void testStartRegistry() throws ServiceException {
		FakeService.getTrace().reset();
		
		// Create a service registry
		ServicesRegistry registry = new ServicesRegistry();
		// Add a service
		registry.add( new ServiceDescriptor( FakeServiceA.class.getName(), ServiceStartKind.STARTUP, 1 ));
		registry.startNewServices();
		
		assertTrue("registry and service started", registry.isStarted(FakeServiceA.class.getName()) );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.serviceregistry.ServicesRegistry#disposeRegistry()}.
	 * @throws ServiceMultiException 
	 */
	@Test
	public void testDisposeRegistry() throws ServiceMultiException {
		FakeService.getTrace().reset();
		
		// Create a service registry
		ServicesRegistry registry = new ServicesRegistry();
		// Add a service
		registry.add( new ServiceDescriptor( FakeServiceA.class.getName(), ServiceStartKind.STARTUP, 1 ));
		registry.startNewServices();

		
		// Create parent registry with one service
		ServicesRegistry registryB = new ServicesRegistry();
		registryB.add( new ServiceDescriptor( FakeServiceB.class.getName(), ServiceStartKind.STARTUP, 1 ));
		registryB.startNewServices();
		// Add as parent
		registry.addParentRegistry(registryB);
		
		// Create parent registry with one service
		ServicesRegistry registryC = new ServicesRegistry();
		registryC.add( new ServiceDescriptor( FakeServiceC.class.getName(), ServiceStartKind.STARTUP, 1 ));
		registryC.startNewServices();
		// Add as parent
		registry.addParentRegistry(registryC);
		
		// Check recursive dispose
		FakeService.getTrace().reset();
		registry.disposeRegistry();
		
		// 
		TestTrace trace = FakeService.getTrace();
		assertTrue("dispose called", trace.contains(FakeServiceA.class.getSimpleName(), "dispose"));
		assertTrue("dispose called", trace.contains(FakeServiceB.class.getSimpleName(), "dispose"));
		assertTrue("dispose called", trace.contains(FakeServiceC.class.getSimpleName(), "dispose"));
	}

	/**
	 * Test the start order for services having a dependency in a parent registry
	 * @throws ServiceException
	 */
	@Test
	public void testStartServicesWithOutsideDependencies() throws ServiceException {

		Class<?> serviceA = FakeServiceA.class;
		Class<?> serviceB = FakeServiceB.class;

		// services A --> B
		FakeService.getTrace().reset();

		// Create parent registry B with one service
		ServicesRegistry registryB = new ServicesRegistry();
		registryB.add( new ServiceDescriptor( serviceB.getName(), ServiceStartKind.STARTUP, 1 ));
		registryB.startNewServices();

		// Create a service registry A -parent-> B
		ServicesRegistry registryA = new ServicesRegistry();
		registryA.add( new ServiceDescriptor( serviceA.getName(), ServiceStartKind.STARTUP, 1,  Arrays.asList(serviceB.getName())));

		registryA.addParentRegistry(registryB);
		registryA.startNewServices();


		// check services
		assertTrue("service started", registryA.isStarted(serviceA));
		assertTrue("service started", registryB.isStarted(serviceB));
		assertTrue("service started", registryA.isStarted(serviceB));

	}

	/**
	 * Test {@link ServicesRegistry#isStarted(Object)} for services in a parent registry
	 * @throws ServiceException
	 */
	@Test
	public void testIsStarted() throws ServiceException {

		Class<?> serviceA = FakeServiceA.class;
		Class<?> serviceB = FakeServiceB.class;

		// services A --> B
		FakeService.getTrace().reset();

		// Create parent registry B with one service
		ServicesRegistry registryB = new ServicesRegistry();
		registryB.add( new ServiceDescriptor( serviceB.getName(), ServiceStartKind.STARTUP, 1 ));
		registryB.startNewServices();

		// Create a service registry A -parent-> B
		ServicesRegistry registryA = new ServicesRegistry();
		registryA.add( new ServiceDescriptor( serviceA.getName(), ServiceStartKind.STARTUP, 1 ));

		registryA.addParentRegistry(registryB);
		registryA.startNewServices();


		// check services
		assertTrue("service started", registryA.isStarted(serviceA));
		assertTrue("service started", registryB.isStarted(serviceB));
		// Access from registryA
		assertTrue("service started", registryA.isStarted(serviceB));

	}

	/**
	 * Test {@link ServicesRegistry#isStarted(Object)} for services in a parent registry
	 * @throws ServiceException
	 */
	@Test
	public void testServiceState() throws ServiceException {

		Class<?> serviceA = FakeServiceA.class;
		Class<?> serviceB = FakeServiceB.class;

		// services A --> B
		FakeService.getTrace().reset();

		// Create parent registry B with one service
		ServicesRegistry registryB = new ServicesRegistry();
		registryB.add( new ServiceDescriptor( serviceB.getName(), ServiceStartKind.STARTUP, 1 ));
		registryB.startNewServices();

		// Create a service registry A -parent-> B
		ServicesRegistry registryA = new ServicesRegistry();
		registryA.add( new ServiceDescriptor( serviceA.getName(), ServiceStartKind.STARTUP, 1 ));

		registryA.addParentRegistry(registryB);
		registryA.startNewServices();


		// check services
		assertEquals("service started", ServiceState.started, registryA.serviceState(serviceA));
		assertEquals("service started", ServiceState.started, registryB.serviceState(serviceB));
		// Access from registryA
		assertEquals("service started", ServiceState.started, registryA.serviceState(serviceB));

	}

	/**
	 * Test the alias service.
	 * @throws ServiceException
	 */
	@Test
	public void testAliasServices() throws ServiceException {
	
		Class<?> serviceA = FakeServiceA.class;
		Class<?> serviceB = FakeServiceB.class;
	
		// services A --> B
		FakeService.getTrace().reset();
	
		// Create parent registry B with one service
		ServicesRegistry registryB = new ServicesRegistry();
		registryB.add( new ServiceDescriptor( serviceB.getName(), ServiceStartKind.STARTUP, 1 ));
		registryB.startNewServices();
	
		// Create an alias to B
		ServicesRegistry registryA = new ServicesRegistry();
		registryA.add( new AliasDescriptor( serviceA.getName(), serviceB.getName(), 1) );
	
		registryA.addParentRegistry(registryB);
		registryA.startNewServices();
	
	
		// check services
		assertNotNull("got service started", registryA.getService(serviceA));
		assertNotNull("got service started", registryB.getService(serviceB));
		
		assertEquals("Got the same service", registryA.getService(serviceA), registryA.getService(serviceB) );
	
	}


}
