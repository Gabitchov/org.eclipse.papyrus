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
package org.eclipse.papyrus.tests.launcher;


/**
 * Entry for a test suite in a test plugin
 */
public class PluginTestSuiteClass implements ITestSuiteClass {

	/** main test suite class */
	private final Class<?> testClass;

	/**
	 * Constructor.
	 * 
	 * @param testClass
	 *        the main test suite class
	 */
	public PluginTestSuiteClass(Class<?> testClass) {
		this.testClass = testClass;
	}

	/**
	 * {@inheritDoc}
	 */
	public Class<?> getMainTestSuiteClass() {
		return testClass;
	}

}
