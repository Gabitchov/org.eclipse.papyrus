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

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;


/**
 * Test Suite class entry for a test fragment
 */
public class FragmentTestSuiteClass implements ITestSuiteClass {

	/** unique identifier of the bundle host */
	private final String hostBundleId;

	/** qualified name of the test suite class */
	private final String classQualifiedName;

	/**
	 * Constructor.
	 * 
	 * @param hostBundleId
	 *        unique identifier of the bundle host
	 * @param classQualifiedName
	 *        qualified name of the test suite class
	 */
	public FragmentTestSuiteClass(String hostBundleId, String classQualifiedName) {
		this.hostBundleId = hostBundleId;
		this.classQualifiedName = classQualifiedName;
	}

	/**
	 * {@inheritDoc}
	 */
	public Class<?> getMainTestSuiteClass() {
		Bundle bundle = Platform.getBundle(hostBundleId);
		if(bundle == null) {
			System.err.println("Impossible to find bundle: " + hostBundleId);
		} else {
			try {
				Class<?> class_ = bundle.loadClass(classQualifiedName);
				return class_;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
