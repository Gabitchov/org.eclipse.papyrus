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

package org.eclipse.papyrus.diagram.clazz.test.canonical;


import junit.framework.Test;
import junit.framework.TestSuite;


// TODO: Auto-generated Javadoc
/**
 * All tests together.
 */
public class AllTests extends TestSuite {

	/**
	 * Suite.
	 * 
	 * @return the test
	 */
	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.papyrus.diagram.clazz");
		//$JUnit-BEGIN$
		
		suite.addTestSuite(TestClassDiagramTopNode.class);
		suite.addTestSuite(TestClassDiagramChildNode.class);
		//suite.addTestSuite(TestClassDiagramChildLabel.class);
		suite.addTestSuite(TestMutliLink.class);
		//$JUnit-END$
		return suite;
	}

}
