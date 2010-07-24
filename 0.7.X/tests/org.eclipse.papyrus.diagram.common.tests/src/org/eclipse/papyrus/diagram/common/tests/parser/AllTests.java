/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.common.tests.parser;

import junit.framework.Test;
import junit.framework.TestSuite;


/**
 * All tests together
 */
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.papyrus.diagram.common.tests.parser");
		//$JUnit-BEGIN$
		suite.addTestSuite(HTMLCleanerTestCase.class);
		//$JUnit-END$
		return suite;
	}

}
