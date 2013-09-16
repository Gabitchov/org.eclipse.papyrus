/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.cdo.validation.problems.tests;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.papyrus.cdo.validation.problems.edit.tests.AllProblemsEditTests;
import org.eclipse.papyrus.cdo.validation.problems.util.tests.AllUtilTests;

/**
 * <!-- begin-user-doc --> A test suite for the '<em><b>Problems</b></em>'
 * model. <!-- end-user-doc -->
 * @generated
 */
public class ProblemsAllTests extends TestSuite {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public static Test suite() {
		TestSuite suite = new ProblemsAllTests("Problems Tests"); //$NON-NLS-1$
		suite.addTest(ProblemsTests.suite());

		if(EMFPlugin.IS_ECLIPSE_RUNNING) {
			suite.addTest(new JUnit4TestAdapter(AllUtilTests.class));
		}

		suite.addTest(AllProblemsEditTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProblemsAllTests(String name) {
		super(name);
	}

} // ProblemsAllTests
