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

package org.eclipse.papyrus.layers.stackmodel.exprmatcher;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.layers.stackmodel.util.NotationAndUmlModelsFactory;
import org.eclipse.uml2.uml.Class;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author cedric dumoulin
 *
 */
public class ValueChangedEventNotifierFactoryTest {

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
	public void testValueChangedEventNotifierFactory() {
		
		ValueChangedEventNotifierFactory notifierFactory = new ValueChangedEventNotifierFactory();
		NotationAndUmlModelsFactory modelsFactory = new NotationAndUmlModelsFactory();
		Diagram diagram1 = modelsFactory.newDiagram();
		Class c1 = modelsFactory.newClass(diagram1, "C1");
		
		// Action
		ValueChangedEventNotifier eventNotifier = (ValueChangedEventNotifier)notifierFactory.adapt(c1, ValueChangedEventNotifier.class);
	
		// Assert
		assertNotNull("object created", eventNotifier);
	}

	/**
	 * Test method for {@link org.eclipse.emf.common.notify.impl.AdapterFactoryImpl#AdapterFactoryImpl()}.
	 */
	@Test
	public void testReturnSameInstanceImpl() {
		
		ValueChangedEventNotifierFactory notifierFactory = new ValueChangedEventNotifierFactory();
		NotationAndUmlModelsFactory modelsFactory = new NotationAndUmlModelsFactory();
		Diagram diagram1 = modelsFactory.newDiagram();
		Class c1 = modelsFactory.newClass(diagram1, "C1");
		Class c2 = modelsFactory.newClass(diagram1, "C2");
		
		// Action
		ValueChangedEventNotifier eventNotifier11 = (ValueChangedEventNotifier)notifierFactory.adapt(c1, ValueChangedEventNotifier.class);
		ValueChangedEventNotifier eventNotifier12 = (ValueChangedEventNotifier)notifierFactory.adapt(c1, ValueChangedEventNotifier.class);
	
		ValueChangedEventNotifier eventNotifier21 = (ValueChangedEventNotifier)notifierFactory.adapt(c2, ValueChangedEventNotifier.class);
		ValueChangedEventNotifier eventNotifier22 = (ValueChangedEventNotifier)notifierFactory.adapt(c2, ValueChangedEventNotifier.class);
	
		// Assert
		assertNotNull("object created", eventNotifier11);
		assertNotNull("object created", eventNotifier21);
		
		assertNotEquals("instance are different between diagram", eventNotifier11, eventNotifier21);
		
		assertEquals("return the same instance", eventNotifier11, eventNotifier12);
		assertEquals("return the same instance", eventNotifier21, eventNotifier22);
	}

}
