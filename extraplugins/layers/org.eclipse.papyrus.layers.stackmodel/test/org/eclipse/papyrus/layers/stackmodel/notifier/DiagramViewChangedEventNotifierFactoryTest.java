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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.layers.stackmodel.util.NotationAndUmlModelsFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dumoulin
 *
 */
public class DiagramViewChangedEventNotifierFactoryTest {

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
	public void testDiagramViewChangedEventNotifierFactory() {
		
		DiagramViewChangedEventNotifierFactory notifierFactory = new DiagramViewChangedEventNotifierFactory();
		NotationAndUmlModelsFactory modelsFactory = new NotationAndUmlModelsFactory();
		Diagram diagram1 = modelsFactory.newDiagram();
		
		// Action
		DiagramViewChangedEventNotifier eventNotifier = (DiagramViewChangedEventNotifier)notifierFactory.adapt(diagram1, DiagramViewChangedEventNotifier.class);
	
		// Assert
		assertNotNull("object created", eventNotifier);
	}

	/**
	 * Test method for {@link org.eclipse.emf.common.notify.impl.AdapterFactoryImpl#AdapterFactoryImpl()}.
	 */
	@Test
	public void testReturnSameInstanceImpl() {
		
		DiagramViewChangedEventNotifierFactory notifierFactory = new DiagramViewChangedEventNotifierFactory();
		NotationAndUmlModelsFactory modelsFactory = new NotationAndUmlModelsFactory();
		Diagram diagram1 = modelsFactory.newDiagram();
		Diagram diagram2 = modelsFactory.newDiagram();
		
		// Action
		DiagramViewChangedEventNotifier eventNotifier11 = (DiagramViewChangedEventNotifier)notifierFactory.adapt(diagram1, DiagramViewChangedEventNotifier.class);
		DiagramViewChangedEventNotifier eventNotifier12 = (DiagramViewChangedEventNotifier)notifierFactory.adapt(diagram1, DiagramViewChangedEventNotifier.class);
	
		DiagramViewChangedEventNotifier eventNotifier21 = (DiagramViewChangedEventNotifier)notifierFactory.adapt(diagram2, DiagramViewChangedEventNotifier.class);
		DiagramViewChangedEventNotifier eventNotifier22 = (DiagramViewChangedEventNotifier)notifierFactory.adapt(diagram2, DiagramViewChangedEventNotifier.class);
	
		// Assert
		assertNotNull("object created", eventNotifier11);
		assertNotNull("object created", eventNotifier21);
		
		assertNotEquals("instance are different between diagram", eventNotifier11, eventNotifier21);
		
		assertEquals("return the same instance", eventNotifier11, eventNotifier12);
		assertEquals("return the same instance", eventNotifier21, eventNotifier22);
	}

}
