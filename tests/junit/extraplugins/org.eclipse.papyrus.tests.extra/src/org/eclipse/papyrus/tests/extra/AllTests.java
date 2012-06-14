/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.tests.extra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.papyrus.tests.extra.launcher.ITestSuiteClass;
import org.eclipse.papyrus.tests.extra.launcher.PluginTestSuiteClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;

@RunWith(AllTests.AllTestsRunner.class)
public class AllTests {

	public static final List<ITestSuiteClass> suiteClasses;

	static {
		suiteClasses = new ArrayList<ITestSuiteClass>();

		/*Bundle tests*/
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.bundles.tests.AllTests.class));
		
		/* **************** plugins *********************** */
		/* css */
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.gmfdiag.css.tests.tests.AllTests.class));

	}

	/**
	 * Finds and runs tests.
	 */
	public static class AllTestsRunner extends Suite {

		/**
		 * Constructor.
		 * 
		 * @param clazz
		 *        the suite class – AllTests2
		 * @throws InitializationError
		 *         if there's a problem
		 * @throws org.junit.runners.model.InitializationError
		 */
		public AllTestsRunner(final Class<?> clazz) throws InitializationError {
			super(clazz, getSuites());
		}
	}

	/**
	 * Returns the list of test classes
	 * 
	 * @return the list of test classes
	 */
	private static Class<?>[] getSuites() {
		// retrieve all test suites.
		Collection<Class<?>> suites = new ArrayList<Class<?>>();
		for(ITestSuiteClass testSuiteClass : suiteClasses) {
			Class<?> class_ = testSuiteClass.getMainTestSuiteClass();
			if(class_ != null) {
				suites.add(class_);
			} else {
				System.err.println(testSuiteClass + " does not give a correct test suite class");
			}
		}
		return suites.toArray(new Class<?>[]{});
	}
}
