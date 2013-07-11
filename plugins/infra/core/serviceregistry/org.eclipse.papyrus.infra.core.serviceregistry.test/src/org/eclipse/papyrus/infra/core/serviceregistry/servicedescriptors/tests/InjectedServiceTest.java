/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.InjectedService;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Injected Service</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class InjectedServiceTest extends InjectedValueTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(InjectedServiceTest.class);
	}

	/**
	 * Constructs a new Injected Service test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InjectedServiceTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Injected Service test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected InjectedService getFixture() {
		return (InjectedService)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ServicedescriptorsFactory.eINSTANCE.createInjectedService());
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

} //InjectedServiceTest
