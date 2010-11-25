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
import org.eclipse.papyrus.sysml.tests.SysmlAllTests;
import org.eclipse.papyrus.tests.launcher.FragmentTestSuiteClass;
import org.eclipse.papyrus.tests.launcher.ITestSuiteClass;
import org.eclipse.papyrus.tests.launcher.PluginTestSuiteClass;
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
	public static final List<ITestSuiteClass> suiteClasses = Arrays.asList(

	/* **************** plugins *********************** */
	/* core */
	// {oep}.core
	new FragmentTestSuiteClass(org.eclipse.papyrus.core.Activator.PLUGIN_ID, "org.eclipse.papyrus.core.tests.AllTests"),
	// {oep}.sasheditor.tests
	new FragmentTestSuiteClass(org.eclipse.papyrus.sasheditor.Activator.PLUGIN_ID, "org.eclipse.papyrus.sasheditor.tests.AllTests"),
	// {oep}.core.resourceloading.tests
	new FragmentTestSuiteClass(org.eclipse.papyrus.core.resourceloading.Activator.PLUGIN_ID, "org.eclipse.papyrus.core.resourceloading.tests.AllTests"),

	/* uml */
	// {oep}.diagram.common.tests
	new FragmentTestSuiteClass(org.eclipse.papyrus.diagram.common.Activator.ID, "org.eclipse.papyrus.diagram.common.tests.AllTests"),
	// {oep}.diagram.clazz.tests
	new PluginTestSuiteClass(org.eclipse.papyrus.diagram.clazz.test.AllTests.class),
	// {oep}.sysml.tests
	new PluginTestSuiteClass(SysmlAllTests.class));




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
