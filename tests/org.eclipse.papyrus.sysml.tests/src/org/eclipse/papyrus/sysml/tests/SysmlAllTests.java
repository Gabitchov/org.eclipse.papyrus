/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.eclipse.papyrus.sysml.allocations.tests.AllocationsTests;
import org.eclipse.papyrus.sysml.modelelements.tests.ModelelementsTests;
import org.eclipse.papyrus.sysml.portandflows.tests.PortandflowsTests;
import org.eclipse.papyrus.sysml.requirements.tests.RequirementsTests;

/**
 * <!-- begin-user-doc --> A test suite for the '<em><b>Sysml</b></em>' model. <!-- end-user-doc -->
 * 
 * @generated
 */
public class SysmlAllTests extends TestSuite {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new SysmlAllTests("Sysml Tests");
		suite.addTest(ModelelementsTests.suite());
		suite.addTest(PortandflowsTests.suite());
		suite.addTest(AllocationsTests.suite());
		suite.addTest(RequirementsTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SysmlAllTests(String name) {
		super(name);
	}

} // SysmlAllTests
