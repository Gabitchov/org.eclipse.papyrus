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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.clazz.test.load;


import junit.framework.Test;
import junit.framework.TestSuite;


// TODO: Auto-generated Javadoc
/**
 * All tests together.
 */
public class LoadTests {

	/**
	 * Suite.
	 * 
	 * @return the test
	 */
	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.papyrus.diagram.common.tests.parser");
		//$JUnit-BEGIN$
		suite.addTestSuite(Load10ClassTest.class);
		suite.addTestSuite(Load100ClassTest.class);
		suite.addTestSuite(Load200ClassTest.class);
		suite.addTestSuite(Load300ClassTest.class);
		suite.addTestSuite(Load400ClassTest.class);
		suite.addTestSuite(Load500ClassTest.class);
		//$JUnit-END$
		return suite;
	}

}
