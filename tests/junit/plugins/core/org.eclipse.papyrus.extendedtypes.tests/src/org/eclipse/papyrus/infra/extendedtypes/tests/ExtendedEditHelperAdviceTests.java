/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes.tests;



/**
 * Test class for extended edit helper advice
 */
public class ExtendedEditHelperAdviceTests implements ITestConstants {

//	/** test class1 element type */
//	private static IElementType class1ElementType;
//
//	/** test class in package element type */
//	private static IElementType classInPackageElementType;
//
//	/** test class in model element type */
//	private static IElementType classInModelElementType;
//
//	/** class1 configuration element type */
//	private static ExtendedElementTypeConfiguration class1ElementTypeConfiguration;
//
//	/** class in package configuration element type */
//	private static ExtendedElementTypeConfiguration classInPackageElementTypeConfiguration;
//
//	/** class in model configuration element type */
//	private static ExtendedElementTypeConfiguration classInModelElementTypeConfiguration;
//
//	/** extended edit helper advice for class1 */
//	private static ExtendedEditHelperAdvice extendedClass1EditHelperAdvice;
//
//	/** extended edit helper advice for class in package */
//	private static ExtendedEditHelperAdvice extendedClassInPackageEditHelperAdvice;
//
//	/** extended edit helper advice for class in model */
//	private static ExtendedEditHelperAdvice extendedClassInModelEditHelperAdvice;
//
//	/** package with short name */
//	private static org.eclipse.uml2.uml.Package shortNamePackage;
//
//	/** package with long name */
//	private static org.eclipse.uml2.uml.Package longNamePackage;
//
//	/** model with short Name */
//	private static Package shortNameModel;
//
//	/** model with long name */
//	private static Package longNameModel;
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//		// create the configuration passes as argument
//		class1ElementType = ExtendedTypesRegistry.getInstance().getType(CLASS1_TEST_TYPE_ID);
//		assertNotNull("Class1 element type should not be null", class1ElementType);
//		classInPackageElementType = ExtendedTypesRegistry.getInstance().getType(CLASS_IN_PACKAGE_TEST_TYPE_ID);
//		assertNotNull("Class in package element type should not be null", classInPackageElementType);
//		classInModelElementType = ExtendedTypesRegistry.getInstance().getType(CLASS_IN_MODEL_TEST_TYPE_ID);
//		assertNotNull("Class in model element type should not be null", classInModelElementType);
//
//		ExtendedElementTypeSet set = ExtendedTypesRegistry.getInstance().getExtendedElementTypeSet(TEST1_CONFIGURATION_SET_ID, TEST1_MODEL_PATH, org.eclipse.papyrus.infra.extendedtypes.tests.Activator.PLUGIN_ID);
//		assertNotNull("extended type set should not be null", set);
//		for(ExtendedElementTypeConfiguration configuration : set.getElementType()) {
//			if(CLASS1_TEST_TYPE_CONFIGURATION_ID.equals(configuration.getId())) {
//				class1ElementTypeConfiguration = configuration;
//			} else if(CLASS_IN_PACKAGE_TEST_TYPE_CONFIGURATION_ID.equals(configuration.getId())) {
//				classInPackageElementTypeConfiguration = configuration;
//			} else if(CLASS_IN_MODEL_TEST_TYPE_CONFIGURATION_ID.equals(configuration.getId())) {
//				classInModelElementTypeConfiguration = configuration;
//			}
//		}
//		assertNotNull("extended type configuration should not be null", class1ElementTypeConfiguration);
//		assertNotNull("extended type configuration should not be null", classInPackageElementTypeConfiguration);
//		assertNotNull("extended type configuration should not be null", classInModelElementTypeConfiguration);
//		extendedClass1EditHelperAdvice = new ExtendedEditHelperAdvice();
//		extendedClassInPackageEditHelperAdvice = new ExtendedEditHelperAdvice();
//		extendedClassInModelEditHelperAdvice = new ExtendedEditHelperAdvice();
//
//		// create Test Model
//		Model model1 = UMLFactory.eINSTANCE.createModel();
//		model1.setName("Model1");
//		shortNamePackage = model1.createNestedPackage("P");
//		longNamePackage = model1.createNestedPackage("veryLongPackage");
//		shortNameModel = model1.createNestedPackage("tinyM", UMLPackage.eINSTANCE.getModel());
//		longNameModel = model1.createNestedPackage("veryLongModel", UMLPackage.eINSTANCE.getModel());
//
//	}
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//		class1ElementType = null;
//		class1ElementTypeConfiguration = null;
//		extendedClass1EditHelperAdvice = null;
//		shortNamePackage = null;
//		longNamePackage = null;
//		shortNameModel = null;
//		longNameModel = null;
//	}
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@After
//	public void tearDown() throws Exception {
//	}
//
//	/**
//	 * Test method for
//	 * {@link org.eclipse.papyrus.infra.extendedtypes.tests.ExtendedEditHelperAdvice#ExtendedEditHelperAdvice(org.eclipse.papyrus.infra.extendedtypes.tests.ExtendedElementTypeConfiguration)}
//	 * .
//	 */
//	@Test
//	public final void testExtendedEditHelperAdvice() {
//		assertNotNull("edit helper advice should not be null", extendedClass1EditHelperAdvice);
//	}
//
//	/**
//	 * Test method for
//	 * {@link org.eclipse.papyrus.infra.extendedtypes.tests.ExtendedEditHelperAdvice#approveRequest(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)}
//	 * .
//	 */
//	@Test
//	public final void testApproveRequestIEditCommandRequest() {
//		// get the request: create a class on the test packages
//
//		// simple test: test if it the name of the container is long or not enough
//		CreateElementRequest inShortPackageCreateRequest = new CreateElementRequest(shortNamePackage, class1ElementType);
//		boolean resultShort = extendedClass1EditHelperAdvice.approveRequest(inShortPackageCreateRequest);
//		assertTrue("request should always be approved", resultShort);
//
//		// simple test: test if it the name of the container is long or not enough
//		CreateElementRequest inLongPackageCreateRequest = new CreateElementRequest(longNamePackage, class1ElementType);
//		boolean resultLong = extendedClass1EditHelperAdvice.approveRequest(inLongPackageCreateRequest);
//		assertTrue("request should always be approved", resultLong);
//
//		// advanced tests: 2 queries at the same time (test true&false; false&false, false&true, true&true)
//		// false & false
//		CreateElementRequest requestShortPackageModel = new CreateElementRequest(shortNamePackage, classInModelElementType);
//		boolean shortPackageModel = extendedClassInModelEditHelperAdvice.approveRequest(requestShortPackageModel);
//		assertTrue("request should always be approved", shortPackageModel);
//
//		// true & false
//		CreateElementRequest requestLongPackageModel = new CreateElementRequest(longNamePackage, classInModelElementType);
//		boolean longPackageModel = extendedClassInModelEditHelperAdvice.approveRequest(requestLongPackageModel);
//		assertTrue("request should always be approved", longPackageModel);
//
//		// false & true
//		CreateElementRequest requestShortPackagePackage = new CreateElementRequest(shortNamePackage, classInPackageElementType);
//		boolean shortPackagePackage = extendedClassInPackageEditHelperAdvice.approveRequest(requestShortPackagePackage);
//		assertTrue("request should always be approved", shortPackagePackage);
//
//		// true & true
//		CreateElementRequest requestlongPackagePackage = new CreateElementRequest(longNamePackage, classInPackageElementType);
//		boolean longPackagePackage = extendedClassInPackageEditHelperAdvice.approveRequest(requestlongPackagePackage);
//		assertTrue("request should always be approved", longPackagePackage);
//	}
//
//	/**
//	 * Test method for
//	 * {@link org.eclipse.papyrus.infra.extendedtypes.tests.ExtendedEditHelperAdvice#getBeforeCreateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest)}
//	 * .
//	 */
//	@Test
//	public final void testGetBeforeCreateCommandCreateElementRequest() {
//		// not test here for now...
//	}
//
//	/**
//	 * Test method for
//	 * {@link org.eclipse.papyrus.infra.extendedtypes.tests.ExtendedEditHelperAdvice#getAfterCreateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest)}
//	 * .
//	 */
//	@Test
//	public final void testGetAfterCreateCommandCreateElementRequest() {
//		// test in {oep}.diagram.extendedtypes.uml.tests fragment
//	}

}
