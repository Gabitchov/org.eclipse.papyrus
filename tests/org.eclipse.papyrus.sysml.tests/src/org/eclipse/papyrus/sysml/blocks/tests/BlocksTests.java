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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.blocks.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test suite for the '<em><b>blocks</b></em>' package. <!-- end-user-doc
 * -->
 * 
 * @generated
 */
public class BlocksTests extends TestSuite {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new BlocksTests("blocks Tests");
		suite.addTestSuite(BlockTest.class);
		suite.addTestSuite(DistributedPropertyTest.class);
		suite.addTestSuite(DimensionTest.class);
		suite.addTestSuite(UnitTest.class);
		suite.addTestSuite(ValueTypeTest.class);
		suite.addTestSuite(NestedConnectorEndTest.class);
		suite.addTestSuite(ParticipantPropertyTest.class);
		suite.addTestSuite(ConnectorPropertyTest.class);
		suite.addTestSuite(BindingConnectorTest.class);
		suite.addTestSuite(PropertySpecificTypeTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BlocksTests(String name) {
		super(name);
	}

} // BlocksTests
