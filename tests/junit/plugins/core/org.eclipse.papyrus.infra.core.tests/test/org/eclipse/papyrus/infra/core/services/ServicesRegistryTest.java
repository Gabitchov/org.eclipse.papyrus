/**
 * 
 */
package org.eclipse.papyrus.infra.core.services;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.papyrus.infra.core.services.FakeServiceFactory.FakeCreatedService;
import org.eclipse.papyrus.infra.core.services.ServiceA.TraceKind;
import org.junit.After;
import org.junit.Before;


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
	@Override
	@Before
	protected void setUp() throws Exception {
		servicesRegistry = new ServicesRegistry();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Override
	@After
	protected void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.services.ServicesRegistry#add(org.eclipse.papyrus.infra.core.services.ServiceDescriptor)}
	 * .
	 * 
	 * @throws ServiceMultiException
	 */
	public void testAdd() throws ServiceMultiException {

		servicesRegistry.add(serviceADesc);
		servicesRegistry.add(serviceBDesc);
		servicesRegistry.add(serviceCDesc);
		servicesRegistry.add(servicePojoADesc);

		// Test entries creation
		//		try {
		//			assertFalse("serviceA stopped", servicesRegistry.isStarted(serviceADesc.getKey()));
		//			assertFalse("serviceB stopped", servicesRegistry.isStarted(serviceBDesc.getKey()));
		//			assertFalse("serviceC stopped", servicesRegistry.isStarted(serviceCDesc.getKey()));
		//			assertFalse("servicePojoA stopped", servicesRegistry.isStarted(servicePojoADesc.getKey()));
		//		} catch (ServiceNotFoundException e) {
		//			fail("Service should exist." + e.getMessage());
		//		}

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
	 * Test method for {@link org.eclipse.papyrus.infra.core.services.ServicesRegistry#getService(java.lang.Object)}.
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
	 * Test method for {@link org.eclipse.papyrus.infra.core.services.ServicesRegistry#getService(java.lang.Object)}.
	 * 
	 * @throws ServiceException
	 */
	public void testGetServiceByClass() throws ServiceException {
		servicesRegistry.add(serviceADesc);
		servicesRegistry.add(serviceBDesc);
		servicesRegistry.add(serviceCDesc);
		servicesRegistry.add(servicePojoADesc);


		servicesRegistry.startRegistry();

		// Test lazy service
		ServiceA serviceA = servicesRegistry.getService(ServiceA.class);
		assertNotNull("service created", serviceA);
		assertEquals("right class", ServiceA.class, serviceA.getClass());

		ServiceA serviceA2 = servicesRegistry.getService(ServiceA.class);
		assertEquals("Second retrieve get the same service", serviceA, serviceA2);

		// test startup service
		ServiceC serviceC = servicesRegistry.getService(ServiceC.class);
		assertNotNull("service created", serviceC);
		assertEquals("right class", ServiceC.class, serviceC.getClass());

		// test pojo service
		ServicePojoA servicePojo = servicesRegistry.getService(ServicePojoA.class);
		assertNotNull("service created", servicePojo);
		assertEquals("right class", ServicePojoA.class, servicePojo.getClass());

		Object servicePojo2 = servicesRegistry.getService(ServicePojoA.class);
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
		//		try {
		//			assertFalse("serviceA stopped", servicesRegistry.isStarted(serviceADesc.getKey()));
		//			assertFalse("serviceB stopped", servicesRegistry.isStarted(serviceBDesc.getKey()));
		//		} catch (ServiceNotFoundException e) {
		//			fail("Service should exist.");
		//		}

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
	 * 
	 * @throws ServiceException
	 */
	public void testCallsOrder() throws ServiceException {
		// Register services as STARTUP !
		servicesRegistry.add(ServiceA.class, 1, new ServiceA());
		// Lazy - generate no trace
		servicesRegistry.add(ServiceB.class, 1, new ServiceB(), ServiceStartKind.LAZY);
		servicesRegistry.add(ServiceC.class, 1, new ServiceC());
		servicesRegistry.add(ServicePojoA.class, 1, new ServicePojoA());


		ServiceA.resetTrace();
		servicesRegistry.startRegistry();

		// Check orders
		// 
		int i = 0;
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
	 * Test life cycle for services registered wih descriptors
	 * 
	 * @throws ServiceException
	 */
	public void testCallsOrderForDescriptors() throws ServiceException {
		// Register services as STARTUP !
		// Lazy - generate no trace
		servicesRegistry.add(new LazyServiceBDescriptor());
		servicesRegistry.add(new ServiceCDescriptor());


		ServiceA.resetTrace();
		servicesRegistry.startRegistry();

		// Check orders
		// 
		int i = 0;
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

	/**
	 * Test the start order for services of type Start and Service
	 * 
	 * @throws ServiceException
	 */
	public void testStartDependantOrder() throws ServiceException {

		String A = "A";
		String B = "B";
		String C = "C";
		String D = "D";
		String E = "E";
		//		String F = "F";

		// Create services E --> D --> C --> B --> A
		FakeService.getTrace().reset();

		servicesRegistry.add(new ServiceDesc(E, ServiceStartKind.STARTUP, Arrays.asList(D)));
		servicesRegistry.add(new ServiceDesc(D, ServiceStartKind.STARTUP, Arrays.asList(C)));
		servicesRegistry.add(new ServiceDesc(C, ServiceStartKind.STARTUP, Arrays.asList(B)));
		servicesRegistry.add(new ServiceDesc(B, ServiceStartKind.STARTUP, Arrays.asList(A)));
		servicesRegistry.add(new ServiceDesc(A, ServiceStartKind.STARTUP));
		//		servicesRegistry.add( new ServiceDesc( F, ServiceStartKind.STARTUP, Arrays.asList(E) ));

		// Start services
		servicesRegistry.startRegistry();

		// check services
		assertTrue("service started", servicesRegistry.isStarted(A));
		assertTrue("service started", servicesRegistry.isStarted(B));
		assertNotSame("services are different", servicesRegistry.getService(A), servicesRegistry.getService(B));

		// Get names of created services
		String nameA = ((FakeService)servicesRegistry.getService(A)).getName();
		String nameB = ((FakeService)servicesRegistry.getService(B)).getName();
		String nameC = ((FakeService)servicesRegistry.getService(C)).getName();
		String nameD = ((FakeService)servicesRegistry.getService(D)).getName();
		String nameE = ((FakeService)servicesRegistry.getService(E)).getName();
		//		String nameF = ((FakeService)servicesRegistry.getService(F)).getName();


		// check order	(E and F order are not guaranteed)	
		// order should be A, B, C, D, E
		TestTrace trace = FakeService.getTrace();
		int i = 0;
		//		assertEquals("order", nameF + ",create", trace.getNameTrace(i++));
		assertEquals("order", nameA + ",create", trace.getNameTrace(i++));
		assertEquals("order", nameB + ",create", trace.getNameTrace(i++));
		assertEquals("order", nameC + ",create", trace.getNameTrace(i++));
		assertEquals("order", nameD + ",create", trace.getNameTrace(i++));
		assertEquals("order", nameE + ",create", trace.getNameTrace(i++));

		//		assertEquals("order", nameF + ",init", trace.getNameTrace(i++));
		assertEquals("order", nameA + ",init", trace.getNameTrace(i++));
		assertEquals("order", nameB + ",init", trace.getNameTrace(i++));
		assertEquals("order", nameC + ",init", trace.getNameTrace(i++));
		assertEquals("order", nameD + ",init", trace.getNameTrace(i++));
		assertEquals("order", nameE + ",init", trace.getNameTrace(i++));

		//		assertEquals("order", nameF + ",start", trace.getNameTrace(i++));
		assertEquals("order", nameA + ",start", trace.getNameTrace(i++));
		assertEquals("order", nameB + ",start", trace.getNameTrace(i++));
		assertEquals("order", nameC + ",start", trace.getNameTrace(i++));
		assertEquals("order", nameD + ",start", trace.getNameTrace(i++));
		assertEquals("order", nameE + ",start", trace.getNameTrace(i++));

	}

	/**
	 * Start regular services, then add a new service and try to start it.
	 * This should work.
	 * 
	 * @throws ServiceException
	 */
	public void testStartRegistryAndThenAddNewServiceAndStartIt() throws ServiceException {

		// Register some services
		String A = "A";
		String B = "B";
		String C = "C";
		servicesRegistry.add(new ServiceFactoryDesc(C, ServiceStartKind.STARTUP));
		servicesRegistry.add(new ServiceFactoryDesc(B, ServiceStartKind.STARTUP, Arrays.asList(C)));
		servicesRegistry.add(new ServiceFactoryDesc(A, ServiceStartKind.STARTUP, Arrays.asList(B)));

		// Start them
		servicesRegistry.startRegistry();

		// Register another services as pojo
		IService instanciatedService = new ServiceA();
		String key = instanciatedService.getClass().getName();
		servicesRegistry.add(key, 1, instanciatedService);

		// Try to start it
		servicesRegistry.startServices(key);

		// check services
		assertTrue("service started", servicesRegistry.isStarted(A));
		assertTrue("service started", servicesRegistry.isStarted(B));
		assertTrue("service started", servicesRegistry.isStarted(C));

		assertTrue("service started", servicesRegistry.isStarted(key));

		assertEquals("get registered service", instanciatedService, servicesRegistry.getService(key));

	}

	/**
	 * Test Service Factory creation
	 * 
	 * @throws ServiceException
	 */
	public void testServiceFactoryCreation() throws ServiceException {

		String A = "A";
		String B = "B";
		String C = "C";

		// Create services
		FakeService.getTrace().reset();

		servicesRegistry.add(new ServiceFactoryDesc(C, ServiceStartKind.STARTUP));
		servicesRegistry.add(new ServiceFactoryDesc(B, ServiceStartKind.STARTUP, Arrays.asList(C)));
		servicesRegistry.add(new ServiceFactoryDesc(A, ServiceStartKind.STARTUP, Arrays.asList(B)));

		// Start services
		servicesRegistry.startRegistry();

		// check services
		assertSame("service type", FakeCreatedService.class, servicesRegistry.getService(A).getClass());
		assertSame("service type", FakeCreatedService.class, servicesRegistry.getService(B).getClass());

		// Get names of created services
		String nameA = ((FakeCreatedService)servicesRegistry.getService(A)).getName();
		String nameB = ((FakeCreatedService)servicesRegistry.getService(B)).getName();
		String nameC = ((FakeCreatedService)servicesRegistry.getService(C)).getName();


		// check order	
		// Order should be: C, B, A
		TestTrace trace = FakeService.getTrace();
		int i = 0;
		assertEquals("order", nameC + ",create", trace.getNameTrace(i++));
		assertEquals("order", nameB + ",create", trace.getNameTrace(i++));
		assertEquals("order", nameA + ",create", trace.getNameTrace(i++));

		assertEquals("order", nameC + ",init", trace.getNameTrace(i++));
		assertEquals("order", nameB + ",init", trace.getNameTrace(i++));
		assertEquals("order", nameA + ",init", trace.getNameTrace(i++));

		assertEquals("order", nameC + ",start", trace.getNameTrace(i++));
		assertEquals("order", nameB + ",start", trace.getNameTrace(i++));
		assertEquals("order", nameA + ",start", trace.getNameTrace(i++));

		// next order is the order of getService()
		assertEquals("order", nameA + ",createInstance", trace.getNameTrace(i++));
		assertEquals("order", nameB + ",createInstance", trace.getNameTrace(i++));
		assertEquals("order", nameC + ",createInstance", trace.getNameTrace(i++));
	}

	/**
	 * Test Creation of Service Factory used with class as key.
	 * 
	 * @throws ServiceException
	 */
	public void testServiceFactoryWithClassKey() throws ServiceException {

		//
		Class<?> A = ServiceA.class;
		Class<?> B = ServiceB.class;
		Class<?> C = ServiceC.class;

		// Specify service types as String
		String serviceClassname1 = FakeServiceFactory.class.getName();;
		String serviceClassname2 = FakeServiceFactory.class.getName();
		String serviceClassname3 = FakeServiceFactory.class.getName();

		// Create services
		FakeService.getTrace().reset();

		servicesRegistry.add(new ServiceFactoryDesc(C, serviceClassname3, ServiceStartKind.STARTUP));
		servicesRegistry.add(new ServiceFactoryDesc(B, serviceClassname2, ServiceStartKind.STARTUP, Arrays.asList(C.getName())));
		servicesRegistry.add(new ServiceFactoryDesc(A, serviceClassname1, ServiceStartKind.STARTUP, Arrays.asList(B.getName())));

		// Start services
		servicesRegistry.startRegistry();

		// check services
		assertSame("service type", FakeCreatedService.class, servicesRegistry.getService(A).getClass());
		assertSame("service type", FakeCreatedService.class, servicesRegistry.getService(B).getClass());

		// Get names of created services
		String nameA = ((FakeCreatedService)servicesRegistry.getService(A)).getName();
		String nameB = ((FakeCreatedService)servicesRegistry.getService(B)).getName();
		String nameC = ((FakeCreatedService)servicesRegistry.getService(C)).getName();


		// check order	(E and F order are not guaranteed)	
		// Order should be
		TestTrace trace = FakeService.getTrace();
		int i = 0;
		assertEquals("order", nameC + ",create", trace.getNameTrace(i++));
		assertEquals("order", nameB + ",create", trace.getNameTrace(i++));
		assertEquals("order", nameA + ",create", trace.getNameTrace(i++));

		assertEquals("order", nameC + ",init", trace.getNameTrace(i++));
		assertEquals("order", nameB + ",init", trace.getNameTrace(i++));
		assertEquals("order", nameA + ",init", trace.getNameTrace(i++));

		assertEquals("order", nameC + ",start", trace.getNameTrace(i++));
		assertEquals("order", nameB + ",start", trace.getNameTrace(i++));
		assertEquals("order", nameA + ",start", trace.getNameTrace(i++));

		// next order is the order of getService()
		assertEquals("order", nameA + ",createInstance", trace.getNameTrace(i++));
		assertEquals("order", nameB + ",createInstance", trace.getNameTrace(i++));
		assertEquals("order", nameC + ",createInstance", trace.getNameTrace(i++));
	}

	/**
	 * Test Service Factory creation order.
	 * One of the factory try to get the required service from its init() method.
	 * 
	 * @throws ServiceException
	 */
	public void testServiceFactoryWithRequiredInInit() throws ServiceException {

		String A = "A";
		String B = "B";
		String C = "C";

		// Create services C --> A --> B
		FakeService.getTrace().reset();

		// FakeWithRequiredServiceFactory try to retrieve service "C"
		servicesRegistry.add(new ServiceFactoryDesc(B, FakeWithRequiredServiceFactory.class.getName(), ServiceStartKind.STARTUP, 1, Arrays.asList(C)));
		servicesRegistry.add(new ServiceFactoryDesc(A, FakeWithRequiredServiceFactory.class.getName(), ServiceStartKind.STARTUP, 1, Arrays.asList(B, C)));
		servicesRegistry.add(new ServiceFactoryDesc(C, FakeServiceFactory.class.getName(), ServiceStartKind.STARTUP, 1));

		// Start services
		servicesRegistry.startRegistry();

		// check services
		assertSame("service type", FakeCreatedService.class, servicesRegistry.getService(A).getClass());
		assertSame("service type", FakeCreatedService.class, servicesRegistry.getService(B).getClass());

		// Get names of created services
		String nameA = ((FakeCreatedService)servicesRegistry.getService(A)).getName();
		String nameB = ((FakeCreatedService)servicesRegistry.getService(B)).getName();
		String nameC = ((FakeCreatedService)servicesRegistry.getService(C)).getName();


		// check order	
		// Order should be: C, B, A
		TestTrace trace = FakeService.getTrace();
		int i = 0;
		assertEquals("order", nameC + ",create", trace.getNameTrace(i++));
		assertEquals("order", nameB + ",create", trace.getNameTrace(i++));
		assertEquals("order", nameA + ",create", trace.getNameTrace(i++));

		assertEquals("order", nameC + ",init", trace.getNameTrace(i++));
		assertEquals("order", nameB + ",init", trace.getNameTrace(i++));

		assertEquals("order", nameC + ",createInstance", trace.getNameTrace(i++));
		assertEquals("value", servicesRegistry.getService(C), trace.getValue(i));
		assertEquals("order", nameB + ",initEnd", trace.getNameTrace(i++));

		assertEquals("order", nameA + ",init", trace.getNameTrace(i++));
		assertEquals("order", nameA + ",initEnd", trace.getNameTrace(i++));

		assertEquals("order", nameC + ",start", trace.getNameTrace(i++));
		assertEquals("order", nameB + ",start", trace.getNameTrace(i++));
		assertEquals("order", nameA + ",start", trace.getNameTrace(i++));

		// next order is the order of getService()
		assertEquals("order", nameA + ",createInstance", trace.getNameTrace(i++));
		//		assertEquals("order", nameB + ",createInstance", trace.getNameTrace(i++));
		//		assertEquals("order", nameC + ",createInstance", trace.getNameTrace(i++));
	}

	/**
	 * Test {@link ServicesRegistry#startServicesByClassKeys(List)}.
	 * Check that services are started.
	 * 
	 * @throws ServiceException
	 */
	public void testStartService() throws ServiceException {

		String A = "A";
		String B = "B";
		String C = "C";
		String D = "D";
		String E = "E";

		// Create services E --> D --> C --> B --> A
		FakeService.getTrace().reset();

		servicesRegistry.add(new ServiceDesc(E, ServiceStartKind.STARTUP, Arrays.asList(D)));
		servicesRegistry.add(new ServiceDesc(D, ServiceStartKind.STARTUP, Arrays.asList(C)));
		servicesRegistry.add(new ServiceDesc(C, ServiceStartKind.STARTUP, Arrays.asList(A, B)));
		servicesRegistry.add(new ServiceDesc(B, ServiceStartKind.STARTUP, Arrays.asList(A)));
		servicesRegistry.add(new ServiceDesc(A, ServiceStartKind.STARTUP));

		// Start services
		servicesRegistry.startServices(Arrays.asList(C));

		// check services
		assertTrue("service started", servicesRegistry.isStarted(A));
		assertTrue("service started", servicesRegistry.isStarted(B));
		assertTrue("service started", servicesRegistry.isStarted(C));

		// Get names of created services
		String nameA = ((FakeService)servicesRegistry.getService(A)).getName();
		String nameB = ((FakeService)servicesRegistry.getService(B)).getName();
		String nameC = ((FakeService)servicesRegistry.getService(C)).getName();
		//		String nameD = ((FakeService)servicesRegistry.getService(D)).getName();
		//		String nameE = ((FakeService)servicesRegistry.getService(E)).getName();
		//		String nameF = ((FakeService)servicesRegistry.getService(F)).getName();


		// check order	(E and F order are not guaranteed)	
		// order should be A, B, C
		TestTrace trace = FakeService.getTrace();
		int i = 0;
		assertEquals("order", nameA + ",create", trace.getNameTrace(i++));
		assertEquals("order", nameB + ",create", trace.getNameTrace(i++));
		assertEquals("order", nameC + ",create", trace.getNameTrace(i++));
		//		assertEquals("order", nameD + ",create", trace.getNameTrace(i++));
		//		assertEquals("order", nameE + ",create", trace.getNameTrace(i++));

		assertEquals("order", nameA + ",init", trace.getNameTrace(i++));
		assertEquals("order", nameB + ",init", trace.getNameTrace(i++));
		assertEquals("order", nameC + ",init", trace.getNameTrace(i++));
		//		assertEquals("order", nameD + ",init", trace.getNameTrace(i++));
		//		assertEquals("order", nameE + ",init", trace.getNameTrace(i++));

		assertEquals("order", nameA + ",start", trace.getNameTrace(i++));
		assertEquals("order", nameB + ",start", trace.getNameTrace(i++));
		assertEquals("order", nameC + ",start", trace.getNameTrace(i++));
		//		assertEquals("order", nameD + ",start", trace.getNameTrace(i++));
		//		assertEquals("order", nameE + ",start", trace.getNameTrace(i++));

	}

	/* **************************************** */





	/**
	 * General purpose descriptor.
	 */
	public class ServiceDesc extends ServiceDescriptor {


		public ServiceDesc(String key, ServiceStartKind startKind) {
			super(key, FakeService.class.getName(), startKind, 1);
		}

		public ServiceDesc(String key, ServiceStartKind startKind, List<String> requiredService) {
			super(key, FakeService.class.getName(), startKind, 1, requiredService);
		}
	}

	/**
	 * General purpose descriptor.
	 */
	public class ServiceFactoryDesc extends ServiceDescriptor {


		public ServiceFactoryDesc(String key, ServiceStartKind startKind) {
			super(key, FakeServiceFactory.class.getName(), startKind, 1);
			setServiceTypeKind(ServiceTypeKind.serviceFactory);
		}

		public ServiceFactoryDesc(String key, ServiceStartKind startKind, List<String> requiredService) {
			super(key, FakeServiceFactory.class.getName(), startKind, 1, requiredService);
			setServiceTypeKind(ServiceTypeKind.serviceFactory);
		}

		/**
		 * Constructor with a classname and {@link ServiceDescriptor#isStartAtStartup()} = true.
		 * Constructor.
		 * 
		 * @param key
		 * @param startKind
		 * @param requiredService
		 */
		public ServiceFactoryDesc(Class<?> key, String classname, ServiceStartKind startKind, List<String> requiredService) {
			super(key, classname, startKind, 1, requiredService);
			setServiceTypeKind(ServiceTypeKind.serviceFactory);
		}

		/**
		 * Constructor with a classname and {@link ServiceDescriptor#isStartAtStartup()} = true.
		 * Constructor.
		 * 
		 * @param key
		 * @param startKind
		 * @param requiredService
		 */
		public ServiceFactoryDesc(Class<?> key, String classname, ServiceStartKind startKind) {
			super(key, classname, startKind, 1);
			setServiceTypeKind(ServiceTypeKind.serviceFactory);
		}

		public ServiceFactoryDesc(String key, String serviceClassname, ServiceStartKind serviceStartKind, int priority, List<String> requiredServices) {
			super(key, serviceClassname, serviceStartKind, priority, requiredServices);
			setServiceTypeKind(ServiceTypeKind.serviceFactory);
		}

		public ServiceFactoryDesc(String key, String serviceClassname, ServiceStartKind serviceStartKind, int priority) {
			super(key, serviceClassname, serviceStartKind, priority);
			setServiceTypeKind(ServiceTypeKind.serviceFactory);
		}
	}

	/**
	 * 
	 * @author dumoulin
	 * 
	 */
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
