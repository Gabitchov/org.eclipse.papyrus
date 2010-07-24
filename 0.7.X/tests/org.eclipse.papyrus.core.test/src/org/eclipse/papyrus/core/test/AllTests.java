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

import org.eclipse.papyrus.core.test.testModel1.Strategy0TestModel1;
import org.eclipse.papyrus.core.test.testModel1.Strategy1TestModel1;
import org.eclipse.papyrus.core.test.testModel1.Strategy2TestModel1;
import org.eclipse.papyrus.core.test.testModel2.Strategy0TestModel2WithModel1;
import org.eclipse.papyrus.core.test.testModel2.Strategy0TestModel2WithPackage0;
import org.eclipse.papyrus.core.test.testModel2.Strategy1TestModel2WithModel1;
import org.eclipse.papyrus.core.test.testModel2.Strategy1TestModel2WithPackage0;
import org.eclipse.papyrus.core.test.testModel2.Strategy2TestModel2WithModel1;
import org.eclipse.papyrus.core.test.testModel2.Strategy2TestModel2WithPackage0;


public class AllTests {
	
	public static Test suite()
    {
        TestSuite suite = new TestSuite("Test for org.eclipse.papyrus.core.resourceloading");
        //$JUnit-BEGIN$
        // Test suite for TestModel1
        suite.addTestSuite(Strategy0TestModel1.class);
        suite.addTestSuite(Strategy1TestModel1.class);
        suite.addTestSuite(Strategy2TestModel1.class);
        
        // Test suite for TestModel2
        suite.addTestSuite(Strategy0TestModel2WithModel1.class);
        suite.addTestSuite(Strategy0TestModel2WithPackage0.class);
        suite.addTestSuite(Strategy1TestModel2WithModel1.class);
        suite.addTestSuite(Strategy1TestModel2WithPackage0.class);
        suite.addTestSuite(Strategy2TestModel2WithModel1.class);
        suite.addTestSuite(Strategy2TestModel2WithPackage0.class);
        //$JUnit-END$
        return suite;
    }

}
