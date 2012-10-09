/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.MethodInjection;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Method Injection</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MethodInjectionTest extends AbstractMethodInjectionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MethodInjectionTest.class);
	}

	/**
	 * Constructs a new Method Injection test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodInjectionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Method Injection test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected MethodInjection getFixture() {
		return (MethodInjection)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ServicedescriptorsFactory.eINSTANCE.createMethodInjection());
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

} //MethodInjectionTest
