/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.OpaqueInjectedValue;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Opaque Injected Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OpaqueInjectedValueTest extends InjectedValueTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OpaqueInjectedValueTest.class);
	}

	/**
	 * Constructs a new Opaque Injected Value test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpaqueInjectedValueTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Opaque Injected Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected OpaqueInjectedValue getFixture() {
		return (OpaqueInjectedValue)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ServicedescriptorsFactory.eINSTANCE.createOpaqueInjectedValue());
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

} //OpaqueInjectedValueTest
