/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AliasIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Alias Id Desc</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AliasIdDescTest extends AbstractServiceIdDescTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AliasIdDescTest.class);
	}

	/**
	 * Constructs a new Alias Id Desc test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AliasIdDescTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Alias Id Desc test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected AliasIdDesc getFixture() {
		return (AliasIdDesc)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ServicedescriptorswithidFactory.eINSTANCE.createAliasIdDesc());
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

} //AliasIdDescTest
