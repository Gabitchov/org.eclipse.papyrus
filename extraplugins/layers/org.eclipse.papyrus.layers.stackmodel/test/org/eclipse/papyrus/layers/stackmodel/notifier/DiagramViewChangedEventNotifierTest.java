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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.util.NotationAndUmlModelsFactory;
import org.eclipse.papyrus.layers.stackmodel.util.TriggeredEventTraces;
import org.eclipse.papyrus.layers.stackmodel.util.TriggeredEventTraces.TriggeredEvent;
import org.eclipse.uml2.uml.Class;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author cedric dumoulin
 *
 */
public class DiagramViewChangedEventNotifierTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.notifier.DiagramViewChangedEventNotifier#DiagramViewChangedEventNotifier()}.
	 */
	@Test
	public void testDiagramViewChangedEventNotifier() {
		NotationAndUmlModelsFactory factory = new NotationAndUmlModelsFactory();
		
		Diagram diagram1 = factory.newDiagram();
		
		DiagramViewChangedEventNotifier notifier = new DiagramViewChangedEventNotifier();
		
		Class c1 = factory.newClass(diagram1, "C1");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.notifier.DiagramViewChangedEventNotifier#addEventListener(org.eclipse.papyrus.layers.stackmodel.notifier.IDiagramViewEventListener)}.
	 */
	@Test
	public void testAddEventListener() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.notifier.DiagramViewChangedEventNotifier#removeEventListener(org.eclipse.papyrus.layers.stackmodel.notifier.IDiagramViewEventListener)}.
	 */
	@Test
	public void testRemoveEventListener() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.notifier.DiagramViewChangedEventNotifier#fireDiagramViewAddedEvent(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testFireDiagramViewAddedEvent() {
		DiagramViewChangedEventNotifierFactory notifierFactory = new DiagramViewChangedEventNotifierFactory();
		NotationAndUmlModelsFactory modelsFactory = new NotationAndUmlModelsFactory();
		Diagram diagram1 = modelsFactory.newDiagram();
		Class c1 = modelsFactory.newClass(diagram1, "C1");
//		Shape shape1 = (Shape)modelsFactory.lookupViewFor(diagram1, c1);
		
		DiagramViewChangedEventNotifier eventNotifier = (DiagramViewChangedEventNotifier)notifierFactory.adapt(diagram1, DiagramViewChangedEventNotifier.class);

		TraceDiagramViewChangedEventListener listener = new TraceDiagramViewChangedEventListener();
		eventNotifier.addEventListener(listener);
		TriggeredEventTraces<Notification> traces = listener.traces;
		
		// Action
		traces.clear();
		// Modify diagram
		Class c2 = modelsFactory.newClass(diagram1, "C2");
		Shape shape2 = (Shape)modelsFactory.lookupViewFor(diagram1, c2);

		// Assert
		assertTrue("event recorded", traces.contains("diagramViewAdded"));
		assertEquals("one event recorded", 1, traces.traces.size() );
		
		TriggeredEventTraces<Notification>.TriggeredEvent event = traces.traces.get(0);
		
		assertEquals("right element in event", shape2, event.notifier.getNewValue() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.notifier.DiagramViewChangedEventNotifier#fireDiagramViewRemovedEvent(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testFireDiagramViewRemovedEvent() {
		DiagramViewChangedEventNotifierFactory notifierFactory = new DiagramViewChangedEventNotifierFactory();
		NotationAndUmlModelsFactory modelsFactory = new NotationAndUmlModelsFactory();
		Diagram diagram1 = modelsFactory.newDiagram();
		Class c1 = modelsFactory.newClass(diagram1, "C1");
		Shape shape1 = (Shape)modelsFactory.lookupViewFor(diagram1, c1);
		Class c2 = modelsFactory.newClass(diagram1, "C2");
		Shape shape2 = (Shape)modelsFactory.lookupViewFor(diagram1, c2);
		
		DiagramViewChangedEventNotifier eventNotifier = (DiagramViewChangedEventNotifier)notifierFactory.adapt(diagram1, DiagramViewChangedEventNotifier.class);

		TraceDiagramViewChangedEventListener listener = new TraceDiagramViewChangedEventListener();
		eventNotifier.addEventListener(listener);
		TriggeredEventTraces<Notification> traces = listener.traces;
		
		// Action
		traces.clear();
		// Modify diagram
		View removedShape = modelsFactory.remove(diagram1, c2);

		// Assert
		assertTrue("event recorded", traces.contains("diagramViewRemoved"));
		assertEquals("one event recorded", 1, traces.traces.size() );
		
		TriggeredEventTraces<Notification>.TriggeredEvent event = traces.traces.get(0);
		
		assertEquals("right element in event", shape2, event.notifier.getOldValue() );
	}

}
