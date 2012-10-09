/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceFactoryIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Service Factory Id Desc</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ServiceFactoryIdDescTest extends ServiceIdDescTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ServiceFactoryIdDescTest.class);
	}

	/**
	 * Constructs a new Service Factory Id Desc test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceFactoryIdDescTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Service Factory Id Desc test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ServiceFactoryIdDesc getFixture() {
		return (ServiceFactoryIdDesc)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ServicedescriptorswithidFactory.eINSTANCE.createServiceFactoryIdDesc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ServiceFactoryIdDescTest
