/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.validation.problems.edit.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.eclipse.papyrus.cdo.validation.problems.tests.ProblemsAllTests;

/**
 * Test suite for the Problems Edit API.
 */
public class AllProblemsEditTests
		extends TestSuite {

	public AllProblemsEditTests(String name) {
		super(name);
	}

	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	public static Test suite() {
		TestSuite suite = new ProblemsAllTests("Problems Edit Tests"); //$NON-NLS-1$
		suite.addTest(ProblemEditUtilTest.suite());
		return suite;
	}

}
