/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.layers.stackmodel.notifier;

import static org.junit.Assert.*;

import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test if the factory return the same Notifier for a given {@link LayersStack}.
 * 
 * @author cedric dumoulin
 *
 */
public class LayersTreeEventNotifierFactoryTest {

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
	 * Test method for {@link org.eclipse.emf.common.notify.impl.AdapterFactoryImpl#AdapterFactoryImpl()}.
	 */
	@Test
	public void testAdapterFactoryImpl() {
		
		LayersStack stack = LayersFactory.eINSTANCE.createLayersStack();
		LayersTreeEventNotifierFactory factory = new LayersTreeEventNotifierFactory();
		
		// Action
		LayersTreeEventNotifier eventNotifier = (LayersTreeEventNotifier)factory.adapt(stack, LayersTreeEventNotifier.class);
	
		// Assert
		assertNotNull("object created", eventNotifier);
	}

	/**
	 * Test method for {@link org.eclipse.emf.common.notify.impl.AdapterFactoryImpl#AdapterFactoryImpl()}.
	 */
	@Test
	public void testReturnSameInstanceImpl() {
		
		LayersStack stack1 = LayersFactory.eINSTANCE.createLayersStack();
		LayersStack stack2 = LayersFactory.eINSTANCE.createLayersStack();
		LayersTreeEventNotifierFactory factory = new LayersTreeEventNotifierFactory();
		
		// Action
		LayersTreeEventNotifier eventNotifier11 = (LayersTreeEventNotifier)factory.adapt(stack1, LayersTreeEventNotifier.class);
		LayersTreeEventNotifier eventNotifier12 = (LayersTreeEventNotifier)factory.adapt(stack1, LayersTreeEventNotifier.class);

		LayersTreeEventNotifier eventNotifier21 = (LayersTreeEventNotifier)factory.adapt(stack2, LayersTreeEventNotifier.class);
		LayersTreeEventNotifier eventNotifier22 = (LayersTreeEventNotifier)factory.adapt(stack2, LayersTreeEventNotifier.class);
	
		// Assert
		assertNotNull("object created", eventNotifier11);
		assertNotNull("object created", eventNotifier21);
		
		assertNotEquals("instance are different between stack", eventNotifier11, eventNotifier21);
		
		assertEquals("return the same instance", eventNotifier11, eventNotifier12);
		assertEquals("return the same instance", eventNotifier21, eventNotifier22);
	}

}
