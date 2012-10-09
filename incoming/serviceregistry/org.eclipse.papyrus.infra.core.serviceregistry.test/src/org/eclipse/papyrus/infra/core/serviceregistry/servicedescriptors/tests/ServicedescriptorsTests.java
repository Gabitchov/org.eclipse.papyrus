/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>servicedescriptors</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class ServicedescriptorsTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new ServicedescriptorsTests("servicedescriptors Tests");
		suite.addTestSuite(RegistryDescTest.class);
		suite.addTestSuite(ServiceSetDescTest.class);
		suite.addTestSuite(DescriptorsTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicedescriptorsTests(String name) {
		super(name);
	}

} //ServicedescriptorsTests
