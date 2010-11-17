/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.osgi.framework.Bundle;


/**
 * Test class for all tests for Papyrus
 */
@RunWith(AllTests.AllTestsRunner.class)
public class AllTests {

	/** list of classes to launch */
	public static final List<SuiteClasses> suiteClasses = Arrays.asList(
	// {oep}.core.tests
	//new SuiteClasses("org.eclipse.papyrus.core", "org.eclipse.papyrus.core.tests.AllTests"),
	// {oep}.diagram.common.tests
	new SuiteClasses("org.eclipse.papyrus.diagram.common", "org.eclipse.papyrus.diagram.common.tests.AllTests"));
	

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
		// retrieve all fragments for the test suite.
		Collection<Class<?>> suites = new ArrayList<Class<?>>();
		for(SuiteClasses classes : suiteClasses) {
			Bundle bundle = Platform.getBundle(classes.getBundleName());
			if(bundle == null) {
				System.err.println("Impossible to find bundle: " + classes.getBundleName());
			} else {
				try {
					Class<?> class_ = bundle.loadClass(classes.getSuiteClassName());
					suites.add(class_);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		return suites.toArray(new Class<?>[]{});
	}

	/**
	 * Holder for test cases
	 */
	public static class SuiteClasses {

		/** identifier of the bundle (or host bundle in case of fragment) for the test class */
		private final String bundleName;

		/** qualified name of the suite class */
		private final String suiteClassName;

		/**
		 * Constructor.
		 * 
		 * @param bundleName
		 *        the identifier of the bundle
		 * @param suiteClassName
		 *        qualified name of the suite class
		 */
		public SuiteClasses(String bundleName, String suiteClassName) {
			this.bundleName = bundleName;
			this.suiteClassName = suiteClassName;
		}

		/**
		 * Returns the unique identifier of the bundle
		 * 
		 * @return the unique identifier of the bundle
		 */
		public String getBundleName() {
			return bundleName;
		}

		/**
		 * Returns the qualified name of the suite class
		 * 
		 * @return the qualified name of the suite class
		 */
		public String getSuiteClassName() {
			return suiteClassName;
		}

	}


}
