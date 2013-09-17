/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import static org.junit.Assert.*;

import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.layers.CustomPropertyOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.operators.BooleanAndOperator;
import org.eclipse.papyrus.layers.stackmodel.operators.CustomPropertyOperatorsInstance;
import org.eclipse.papyrus.layers.stackmodel.operators.FakePropertyOperator;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class CustomPropertyOperatorImplTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.CustomPropertyOperatorImpl#getComputePropertyValueCommand(org.eclipse.emf.common.util.EList)}.
	 * @throws LayersException 
	 */
	@Test
	public void testGetComputePropertyValueCommand() throws LayersException {
		CustomPropertyOperator operator = LayersFactory.eINSTANCE.createCustomPropertyOperator();

		FakePropertyOperator opInstance = new FakePropertyOperator();
		operator.setOperatorInstance(opInstance);
		
		// Check
		operator.getComputePropertyValueCommand(null);
		// Check if the corresponding method of the custom operator is called.
		assertTrue("custom op getCmd method is called", opInstance.isComputePropertyValueCommandCalled);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.CustomPropertyOperatorImpl#CustomPropertyOperatorImpl()}.
	 */
	@Test
	public void testCustomPropertyOperatorImpl() {
		CustomPropertyOperator operator = LayersFactory.eINSTANCE.createCustomPropertyOperator();

		assertNotNull("object created", operator);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.CustomPropertyOperatorImpl#setClassname(java.lang.String)}.
	 */
	@Test
	public void testSetClassname() {
		CustomPropertyOperator operator = LayersFactory.eINSTANCE.createCustomPropertyOperator();

		// Set a classname
		String classname = BooleanAndOperator.class.getName();
		operator.setClassname(classname);

		// check
		assertSame( "classname found", classname, operator.getClassname());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.CustomPropertyOperatorImpl#getOperatorInstance()}.
	 */
	@Test
	public void testGetOperatorInstance() {
		CustomPropertyOperator operator = LayersFactory.eINSTANCE.createCustomPropertyOperator();

		CustomPropertyOperatorsInstance opInstance = new BooleanAndOperator();
		operator.setOperatorInstance(opInstance);
		
		// Check
		assertSame("custom op found", opInstance, operator.getOperatorInstance());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.CustomPropertyOperatorImpl#getOperatorInstance()}.
	 */
	@Test
	public void testGetOperatorInstanceFromClassname() {
		CustomPropertyOperator operator = LayersFactory.eINSTANCE.createCustomPropertyOperator();

		// Set a classname
		operator.setClassname(BooleanAndOperator.class.getName());
		
		// Check
		assertNotNull("custom op created and found", operator.getOperatorInstance());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.CustomPropertyOperatorImpl#setOperatorInstance(org.eclipse.papyrus.layers.stackmodel.operators.CustomPropertyOperatorsInstance)}.
	 */
	@Test
	public void testSetOperatorInstance() {
		CustomPropertyOperator operator = LayersFactory.eINSTANCE.createCustomPropertyOperator();

		CustomPropertyOperatorsInstance opInstance = new BooleanAndOperator();
		operator.setOperatorInstance(opInstance);
		
		// Check
		assertSame("custom op found", opInstance, operator.getOperatorInstance());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.CustomPropertyOperatorImpl#setClassBundleID(java.lang.String)}.
	 */
	@Test
	@Ignore
	public void testSetClassBundleID() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.CustomPropertyOperatorImpl#resetOperatorInstance()}.
	 */
	@Test
	@Ignore
	public void testResetOperatorInstance() {
		fail("Not yet implemented");
	}

}
