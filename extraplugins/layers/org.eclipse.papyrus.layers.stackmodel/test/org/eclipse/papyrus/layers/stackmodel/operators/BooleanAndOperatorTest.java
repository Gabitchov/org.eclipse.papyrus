/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.stackmodel.operators;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.command.ComputePropertyValueCommand;
import org.eclipse.papyrus.layers.stackmodel.layers.BooleanInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class BooleanAndOperatorTest {

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
	 * Create an instance of boolean value cmd.
	 * @param b
	 * @return
	 */
	protected BooleanInstance createBooleanInstance(boolean value) {
		BooleanInstance val = LayersFactory.eINSTANCE.createBooleanInstance();
		val.setValue(value);
		return val;
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.operators.BooleanAndOperator#getComputePropertyValueCommand(org.eclipse.emf.common.util.EList)}.
	 * @throws LayersException 
	 */
	@Test
	public void testGetComputePropertyValueCommandReturnTrue() throws LayersException {
		
		// Create a list of nested commands
		EList<ComputePropertyValueCommand> nestedCommand = new BasicEList<ComputePropertyValueCommand>();
		BooleanInstance val1 = createBooleanInstance(true);
		nestedCommand.add(val1);
		BooleanInstance val2 = createBooleanInstance(true);
		nestedCommand.add(val2);
		BooleanInstance val3 = createBooleanInstance(true);
		nestedCommand.add(val3);
		
		
		// Create the command 
		BooleanAndOperator op = new BooleanAndOperator();
		assertNotNull("command created", op.getComputePropertyValueCommand(nestedCommand));

		assertSame("return the right value", true, ((BooleanInstance)op.getComputePropertyValueCommand(nestedCommand).getCmdValue()).isValue());

	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.operators.BooleanAndOperator#getComputePropertyValueCommand(org.eclipse.emf.common.util.EList)}.
	 * @throws LayersException 
	 */
	@Test
	public void testGetComputePropertyValueCommandReturnFalse() throws LayersException {
		
		// Create a list of nested commands
		EList<ComputePropertyValueCommand> nestedCommand = new BasicEList<ComputePropertyValueCommand>();
		BooleanInstance val1 = createBooleanInstance(true);
		nestedCommand.add(val1);
		BooleanInstance val2 = createBooleanInstance(false);
		nestedCommand.add(val2);
		BooleanInstance val3 = createBooleanInstance(true);
		nestedCommand.add(val3);
		
		
		// Create the command 
		BooleanAndOperator op = new BooleanAndOperator();
		assertNotNull("command created", op.getComputePropertyValueCommand(nestedCommand));

		assertSame("return the right value", false, ((BooleanInstance)op.getComputePropertyValueCommand(nestedCommand).getCmdValue()).isValue());

	}

}
