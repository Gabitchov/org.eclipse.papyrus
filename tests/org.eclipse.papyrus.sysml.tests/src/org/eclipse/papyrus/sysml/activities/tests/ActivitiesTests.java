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
package org.eclipse.papyrus.sysml.activities.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test suite for the '<em><b>activities</b></em>' package. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class ActivitiesTests extends TestSuite {

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
		TestSuite suite = new ActivitiesTests("activities Tests");
		suite.addTestSuite(OptionnalTest.class);
		suite.addTestSuite(RateTest.class);
		suite.addTestSuite(ProbabilityTest.class);
		suite.addTestSuite(ContinuousTest.class);
		suite.addTestSuite(DiscreteTest.class);
		suite.addTestSuite(ControlOperatorTest.class);
		suite.addTestSuite(NoBufferTest.class);
		suite.addTestSuite(OverwriteTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActivitiesTests(String name) {
		super(name);
	}

} // ActivitiesTests
