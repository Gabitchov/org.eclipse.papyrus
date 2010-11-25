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
package org.eclipse.papyrus.sysml.allocations.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.papyrus.sysml.allocations.AllocateActivityPartition;
import org.eclipse.papyrus.sysml.allocations.AllocationsFactory;

/**
 * <!-- begin-user-doc --> A test case for the model object ' <em><b>Allocate Activity Partition</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class AllocateActivityPartitionTest extends TestCase {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AllocateActivityPartitionTest.class);
	}

	/**
	 * The fixture for this Allocate Activity Partition test case.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected AllocateActivityPartition fixture = null;

	/**
	 * Constructs a new Allocate Activity Partition test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AllocateActivityPartitionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Allocate Activity Partition test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AllocateActivityPartition getFixture() {
		return fixture;
	}

	/**
	 * Sets the fixture for this Allocate Activity Partition test case.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(AllocateActivityPartition fixture) {
		this.fixture = fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AllocationsFactory.eINSTANCE.createAllocateActivityPartition());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} // AllocateActivityPartitionTest
