/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.junit.utils;



/**
 * This class is used to configure a test job. In strict mode, all tests are executed.
 * When the strict mode is disabled, the tests which are known to be failing are ignored.
 *
 * This is useful for test-driven development, when tests are implemented before the feature:
 * we can still have "green builds" (by ignoring these specific tests) and test for non-regression.
 *
 * Usage: When a test is known to be failing, add: Assume.assumeTrue("Why the test is disabled", TestMode.isStrict());
 *
 * The test will be run only in strict mode, and ignored during non-regression testing
 * 
 * @author Camille Letavernier
 *
 */
public class TestMode {

	private static boolean strictMode = false;

	public static boolean isStrict() {
		return strictMode;
	}

	public static void setStrict(boolean strictMode) {
		TestMode.strictMode = strictMode;
	}

}
