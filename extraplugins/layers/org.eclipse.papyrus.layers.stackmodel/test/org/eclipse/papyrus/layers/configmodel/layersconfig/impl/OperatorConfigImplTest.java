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
package org.eclipse.papyrus.layers.configmodel.layersconfig.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.eclipse.papyrus.layers.configmodel.layersconfig.ClassnameKind;
import org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigFactory;
import org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorConfig;
import org.eclipse.papyrus.layers.stackmodel.InstanciationException;
import org.eclipse.papyrus.layers.stackmodel.layers.CustomPropertyOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.DefaultPropertyOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyOperator;
import org.eclipse.papyrus.layers.stackmodel.operators.BooleanAndOperator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class OperatorConfigImplTest {

	protected String BUNDLE_ID = "org.eclipse.papyrus.layers.stackmodel";
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
	 * Test method for {@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.OperatorConfigImpl#OperatorConfigImpl()}.
	 */
	@Test
	public void testOperatorConfigImpl() {
		// Create new object
		OperatorConfig opConfig = LayersconfigFactory.eINSTANCE.createOperatorConfig();
		
		assertNotNull("instance created", opConfig);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.OperatorConfigImpl#createOperatorDescriptor()}.
	 */
//	@Test
//	public void testCreateOperatorDescriptor() {
//		// Create new object
//		OperatorConfig opConfig = LayersconfigFactory.eINSTANCE.createOperatorConfig();
//		
//		assertNotNull("instance created", opConfig);
//	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.OperatorConfigImpl#createPojoInstance()}.
	 * @throws InstanciationException 
	 */
	@Test
	public void testCreatePojoInstance() throws InstanciationException {
		// Create new object
		OperatorConfig opConfig = LayersconfigFactory.eINSTANCE.createOperatorConfig();
		opConfig.setClassname(BooleanAndOperator.class.getName());
		opConfig.setBundleID(BUNDLE_ID);
		
		PropertyOperator operator = opConfig.createOperatorDescriptor();
				
		assertNotNull("operator created", operator);
		assertTrue("operator type", operator instanceof CustomPropertyOperator);
		assertNotNull("operator nested instance created", ((CustomPropertyOperator)operator).getOperatorInstance());
		assertSame("classnameKind is changed", ClassnameKind.POJO_CLASSNAME, opConfig.getClassnameKind());
		// Try a second time
		operator = opConfig.createOperatorDescriptor();
		
		assertNotNull("operator created", operator);
		assertTrue("operator type", operator instanceof CustomPropertyOperator);
		assertNotNull("operator nested instance created", ((CustomPropertyOperator)operator).getOperatorInstance());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.OperatorConfigImpl#createEmfInstance()}.
	 * @throws InstanciationException 
	 */
	@Test
	public void testCreateEmfInstance() throws InstanciationException {
		// Create new object
		OperatorConfig opConfig = LayersconfigFactory.eINSTANCE.createOperatorConfig();
		opConfig.setClassname(LayersPackage.eINSTANCE.getDefaultPropertyOperator().getName());
		
		PropertyOperator operator = opConfig.createOperatorDescriptor();
				
		assertNotNull("operator created", operator);
		assertTrue("operator type", operator instanceof DefaultPropertyOperator);
			assertSame("classnameKind is changed", ClassnameKind.EMF_CLASSNAME, opConfig.getClassnameKind());
		// Try a second time
		operator = opConfig.createOperatorDescriptor();
		
		assertNotNull("operator created", operator);
		assertTrue("operator type", operator instanceof DefaultPropertyOperator);
	}

}
