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
 * Interface for all suite classes.
 */
public interface ITestSuiteClass {

	/**
	 * Returns the main test suite class for this entry
	 * 
	 * @return the main test suite class for this entry
	 */
	public Class<?> getMainTestSuiteClass();

}
