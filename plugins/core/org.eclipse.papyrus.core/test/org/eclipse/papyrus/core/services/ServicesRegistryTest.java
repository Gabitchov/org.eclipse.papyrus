/**
 * 
 */
package org.eclipse.papyrus.core.services;

import org.eclipse.papyrus.core.services.ServiceA.TraceKind;

import junit.framework.TestCase;


/**
 * @author dumoulin
 * 
 */
public class ServicesRegistryTest extends TestCase {

	/** The registry to test */
	ServicesRegistry servicesRegistry;

	ServiceDescriptor serviceADesc = new LazyServiceADescriptor();

	ServiceDescriptor serviceA10Desc = new LazyServiceA10Descriptor();

	ServiceDescriptor serviceBDesc = new LazyServiceBDescriptor();

	ServiceDescriptor serviceCDesc = new ServiceCDescriptor();

	ServiceDescriptor servicePojoADesc = new LazyServicePojoADescriptor();

	public ServicesRegistryTest(String name) {
		super(name);
	}

	/**
	 * @throws java.lang.Exception
	 */
	protected void setUp() throws Exception {
		servicesRegistry = new ServicesRegistry();
	}

	/**
	 * @throws java.lang.Exception
	 */
	protected void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.core.services.ServicesRegistry#add(org.eclipse.papyrus.core.services.ServiceDescriptor)} .
	 */
	public void testAdd() {

		servicesRegistry.add(serviceADesc);
		servicesRegistry.add(serviceBDesc);
		servicesRegistry.add(serviceCDesc);
		servicesRegistry.add(servicePojoADesc);


		// Test entries creation
		try {
			assertFalse("serviceA stopped", servicesRegistry.isStarted(serviceADesc.getKey()));
			assertFalse("serviceB stopped", servicesRegistry.isStarted(serviceBDesc.getKey()));
			assertFalse("serviceC stopped", servicesRegistry.isStarted(serviceCDesc.getKey()));
			assertFalse("servicePojoA stopped", servicesRegistry.isStarted(servicePojoADesc.getKey()));
		} catch (ServiceNotFoundException e) {
			fail("Service should exist.");
		}

		// Test startup
		servicesRegistry.startRegistry();

		// Test always started
		try {
			assertFalse("serviceA stopped", servicesRegistry.isStarted(serviceADesc.getKey()));
			assertFalse("serviceB stopped", servicesRegistry.isStarted(serviceBDesc.getKey()));
			assertEquals("serviceC state", ServiceState.started, servicesRegistry.serviceState(serviceCDesc.getKey()));
			assertTrue("serviceC started", servicesRegistry.isStarted(serviceCDesc.getKey()));
			assertFalse("servicePojoA stopped", servicesRegistry.isStarted(servicePojoADesc.getKey()));
		} catch (ServiceNotFoundException e) {
			fail("Service should exist.");
		}


	}

	/**
	 * Test method for {@link org.eclipse.papyrus.core.services.ServicesRegistry#getService(java.lang.Object)}.
	 * 
	 * @throws ServiceException
	 */
	public void testGetService() throws ServiceException {
		servicesRegistry.add(serviceADesc);
		servicesRegistry.add(serviceBDesc);
		servicesRegistry.add(serviceCDesc);
		servicesRegistry.add(servicePojoADesc);


		servicesRegistry.startRegistry();
		
		// Test lazy service
		Object serviceA = servicesRegistry.getService(serviceADesc.getKey());
		assertNotNull("service created", serviceA);
		assertEquals("right class", ServiceA.class, serviceA.getClass());

		Object serviceA2 = servicesRegistry.getService(serviceADesc.getKey());
		assertEquals("Second retrieve get the same service", serviceA, serviceA2);

		// test startup service
		Object serviceC = servicesRegistry.getService(serviceCDesc.getKey());
		assertNotNull("service created", serviceC);
		assertEquals("right class", ServiceC.class, serviceC.getClass());

		Object serviceC2 = servicesRegistry.getService(serviceCDesc.getKey());
		assertEquals("Second retrieve get the same service", serviceC, serviceC2);

		// test pojo service
		Object servicePojo = servicesRegistry.getService(servicePojoADesc.getKey());
		assertNotNull("service created", servicePojo);
		assertEquals("right class", ServicePojoA.class, servicePojo.getClass());

		Object servicePojo2 = servicesRegistry.getService(servicePojoADesc.getKey());
		assertEquals("Second retrieve get the same service", servicePojo, servicePojo2);


	}

	/**
	 * Try to register 2 services under the same name, but with different priorities.
	 * 
	 * @throws ServiceException
	 */
	public void testPriority() throws ServiceException {
		servicesRegistry.add(serviceADesc);
		servicesRegistry.add(serviceA10Desc);
		servicesRegistry.add(serviceBDesc);

		// Test creation
		try {
			assertFalse("serviceA stopped", servicesRegistry.isStarted(serviceADesc.getKey()));
			assertFalse("serviceB stopped", servicesRegistry.isStarted(serviceBDesc.getKey()));
		} catch (ServiceNotFoundException e) {
			fail("Service should exist.");
		}

		servicesRegistry.startRegistry();
		
		Object serviceA = servicesRegistry.getService(serviceADesc.getKey());

		assertNotNull("Service created", serviceA);
		assertEquals("right class", ServiceA10.class, serviceA.getClass());


	}

	/**
	 * Test add for a direct instance of service.
	 * 
	 * @throws ServiceException
	 */
	public void testAddDirectInstance() throws ServiceException {
		IService instanciatedService = new ServiceA();
		String key = instanciatedService.getClass().getName();

		servicesRegistry.add(key, 1, instanciatedService);

		servicesRegistry.add(serviceCDesc);
		servicesRegistry.add(serviceBDesc);

		servicesRegistry.startRegistry();

		Object serviceA = servicesRegistry.getService(key);

		assertNotNull("Service created", serviceA);
		assertEquals("right object", instanciatedService, serviceA);
		assertEquals("right class", ServiceA.class, serviceA.getClass());


	}

	/**
	 * Test life cycle for directly registered services
	 * @throws ServiceException
	 */
	public void testCallsOrder() throws ServiceException {
		// Register services as STARTUP !
		servicesRegistry.add(ServiceA.class, 1, new ServiceA() );
		// Lazy - generate no trace
		servicesRegistry.add(ServiceB.class, 1, new ServiceB(), ServiceStartKind.LAZY);
		servicesRegistry.add(ServiceC.class, 1, new ServiceC());
		servicesRegistry.add(ServicePojoA.class, 1, new ServicePojoA());
		

		ServiceA.resetTrace();
		servicesRegistry.startRegistry();
		
		// Check orders
		// 
		int i=0;
		assertEquals("service", TraceKind.init, ServiceA.getEvent(i++));
		assertEquals("service", TraceKind.init, ServiceA.getEvent(i++));
		assertEquals("service", TraceKind.init, ServiceA.getEvent(i++));
//		assertEquals("service", TraceKind.init, ServiceA.getEvent(i++));
		
		assertEquals("service", TraceKind.start, ServiceA.getEvent(i++));
		assertEquals("service", TraceKind.start, ServiceA.getEvent(i++));
		assertEquals("service", TraceKind.start, ServiceA.getEvent(i++));
//		assertEquals("service", TraceKind.start, ServiceA.getEvent(i++));
		
		// Now, start lazy service
		ServiceB service = servicesRegistry.getService(ServiceB.class);
		assertNotNull("service found", service);
		assertEquals("service", TraceKind.init, ServiceA.getEvent(i++));
		assertEquals("service", TraceKind.start, ServiceA.getEvent(i++));
			
		
		// Check dispose
		servicesRegistry.disposeRegistry();
		assertEquals("service", TraceKind.dispose, ServiceA.getEvent(i++));
		assertEquals("service", TraceKind.dispose, ServiceA.getEvent(i++));
		assertEquals("service", TraceKind.dispose, ServiceA.getEvent(i++));
//		assertEquals("service", TraceKind.dispose, ServiceA.getEvent(i++));
		
		// 
	}
	
	/**
	 * Test life cycle for   services registered wih descriptors
	 * @throws ServiceException
	 */
	public void testCallsOrderForDescriptors() throws ServiceException {
		// Register services as STARTUP !
		// Lazy - generate no trace
		servicesRegistry.add( new LazyServiceBDescriptor() );
		servicesRegistry.add( new ServiceCDescriptor());
		

		ServiceA.resetTrace();
		servicesRegistry.startRegistry();

		// Check orders
		// 
		int i=0;
		assertEquals("service", TraceKind.init, ServiceA.getEvent(i++));
//		assertEquals("service", TraceKind.init, ServiceA.getEvent(i++));
		
		assertEquals("service", TraceKind.start, ServiceA.getEvent(i++));
//		assertEquals("service", TraceKind.start, ServiceA.getEvent(i++));
		
		// Now, start lazy service
		ServiceB service = (ServiceB)servicesRegistry.getService(ServiceB.class.getName());
		assertNotNull("service found", service);
		assertEquals("service", TraceKind.init, ServiceA.getEvent(i++));
		assertEquals("service", TraceKind.start, ServiceA.getEvent(i++));
			
		
		// Check dispose
		servicesRegistry.disposeRegistry();
		assertEquals("service", TraceKind.dispose, ServiceA.getEvent(i++));
		assertEquals("service", TraceKind.dispose, ServiceA.getEvent(i++));
//		assertEquals("service", TraceKind.dispose, ServiceA.getEvent(i++));
		
		// 
	}
	
	/* **************************************** */




	public class LazyServiceADescriptor extends ServiceDescriptor {


		public LazyServiceADescriptor() {
			super(ServiceA.class.getName(), ServiceStartKind.LAZY, 1);
		}
	}

	public class LazyServiceA10Descriptor extends ServiceDescriptor {


		public LazyServiceA10Descriptor() {
			super(ServiceA.class.getName(), ServiceA10.class.getName(), ServiceStartKind.LAZY, 10);
		}
	}

	public class LazyServiceBDescriptor extends ServiceDescriptor {


		public LazyServiceBDescriptor() {
			super(ServiceB.class.getName(), ServiceStartKind.LAZY, 1);
		}
	}

	public class ServiceCDescriptor extends ServiceDescriptor {


		public ServiceCDescriptor() {
			super(ServiceC.class.getName(), ServiceStartKind.STARTUP, 1);
		}
	}

	public class LazyServicePojoADescriptor extends ServiceDescriptor {


		public LazyServicePojoADescriptor() {
			super(ServicePojoA.class.getName(), ServiceStartKind.LAZY, 1);
		}
	}

	public class PojoServiceDescriptor extends ServiceDescriptor {


		public PojoServiceDescriptor() {
			super(Object.class.getName(), ServiceStartKind.STARTUP, 1);
		}
	}


}
