/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Service Desc</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ServiceDescTest extends AbstractServiceDescTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ServiceDescTest.class);
	}

	/**
	 * Constructs a new Service Desc test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceDescTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Service Desc test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ServiceDesc getFixture() {
		return (ServiceDesc)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ServicedescriptorsFactory.eINSTANCE.createServiceDesc());
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

} //ServiceDescTest
