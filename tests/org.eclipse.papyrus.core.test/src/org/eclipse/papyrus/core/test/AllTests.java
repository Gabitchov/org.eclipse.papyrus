/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.core.test;

import junit.framework.Test;
import junit.framework.TestSuite;


public class AllTests {
	
	public static Test suite()
    {
        TestSuite suite = new TestSuite("Test for org.eclipse.papyrus.core");
        //$JUnit-BEGIN$
        suite.addTestSuite(LoadAllStrategyTestModel1.class);
        suite.addTestSuite(LoadAllStrategyTestModel2.class);
        //$JUnit-END$
        return suite;
    }

}
