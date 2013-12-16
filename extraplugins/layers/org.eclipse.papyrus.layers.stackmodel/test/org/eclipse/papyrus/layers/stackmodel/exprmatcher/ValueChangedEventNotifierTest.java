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

import static org.junit.Assert.*;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.util.NotationAndUmlModelsFactory;
import org.eclipse.papyrus.layers.stackmodel.util.TriggeredEventTraces;
import org.eclipse.papyrus.layers.stackmodel.util.TriggeredEventTraces.TriggeredEvent;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author cedric dumoulin
 *
 */
public class ValueChangedEventNotifierTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.notifier.ValueChangedEventNotifier#ValueChangedEventNotifier()}.
	 */
	@Test
	public void testValueChangedEventNotifier() {
		NotationAndUmlModelsFactory modelsFactory = new NotationAndUmlModelsFactory();
		Diagram diagram1 = modelsFactory.newDiagram();
		Class c1 = modelsFactory.newClass(diagram1, "C1");

		ValueChangedEventNotifierFactory notifierFactory = new ValueChangedEventNotifierFactory();		
		ValueChangedEventNotifier eventNotifier = (ValueChangedEventNotifier)notifierFactory.adapt(c1, ValueChangedEventNotifier.class);

		// Assert
		assertNotNull("notifier created", eventNotifier);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.notifier.ValueChangedEventNotifier#addEventListener(org.eclipse.papyrus.layers.stackmodel.notifier.IDiagramViewEventListener)}.
	 */
	@Test
	public void testAddEventListener() {
		NotationAndUmlModelsFactory modelsFactory = new NotationAndUmlModelsFactory();
		Diagram diagram1 = modelsFactory.newDiagram();
		Class c1 = modelsFactory.newClass(diagram1, "C1");

		ValueChangedEventNotifierFactory notifierFactory = new ValueChangedEventNotifierFactory();		
		ValueChangedEventNotifier eventNotifier = (ValueChangedEventNotifier)notifierFactory.adapt(diagram1, ValueChangedEventNotifier.class);

		TraceValueChangedEventListener listener = new TraceValueChangedEventListener();
		eventNotifier.addEventListener(listener);

		// Assert
		assertTrue("listener added", eventNotifier.listeners.contains(listener));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.notifier.ValueChangedEventNotifier#removeEventListener(org.eclipse.papyrus.layers.stackmodel.notifier.IDiagramViewEventListener)}.
	 */
	@Test
	public void testRemoveEventListener() {
		NotationAndUmlModelsFactory modelsFactory = new NotationAndUmlModelsFactory();
		Diagram diagram1 = modelsFactory.newDiagram();
		Class c1 = modelsFactory.newClass(diagram1, "C1");

		ValueChangedEventNotifierFactory notifierFactory = new ValueChangedEventNotifierFactory();		
		ValueChangedEventNotifier eventNotifier = (ValueChangedEventNotifier)notifierFactory.adapt(diagram1, ValueChangedEventNotifier.class);

		TraceValueChangedEventListener listener = new TraceValueChangedEventListener();
		eventNotifier.addEventListener(listener);
		eventNotifier.removeEventListener(listener);

		// Assert
		assertFalse("listener removed", eventNotifier.listeners.contains(listener));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.notifier.ValueChangedEventNotifier#fireDiagramViewAddedEvent(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testNameChangedEvent() {
		NotationAndUmlModelsFactory modelsFactory = new NotationAndUmlModelsFactory();
		Diagram diagram1 = modelsFactory.newDiagram();
		Class c1 = modelsFactory.newClass(diagram1, "C1");

		ValueChangedEventNotifierFactory notifierFactory = new ValueChangedEventNotifierFactory();		
		ValueChangedEventNotifier eventNotifier = (ValueChangedEventNotifier)notifierFactory.adapt(diagram1, ValueChangedEventNotifier.class);

		TraceValueChangedEventListener listener = new TraceValueChangedEventListener();
		eventNotifier.addEventListener(listener);
		TriggeredEventTraces<Notification> traces = listener.traces;
		int expectedEventCount = 1;
		
		// Action
		traces.clear();
		// Modify ele
		c1.setName("newName");

		// Assert
		// Assert
		assertTrue("event recorded", traces.contains("valueChanged"));
		assertEquals("right number of events", expectedEventCount, traces.traces.size() );
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.notifier.ValueChangedEventNotifier#fireDiagramViewRemovedEvent(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testPropertyAdded() {
		NotationAndUmlModelsFactory modelsFactory = new NotationAndUmlModelsFactory();
		Diagram diagram1 = modelsFactory.newDiagram();
		Class c1 = modelsFactory.newClass(diagram1, "C1");

		ValueChangedEventNotifierFactory notifierFactory = new ValueChangedEventNotifierFactory();		
		ValueChangedEventNotifier eventNotifier = (ValueChangedEventNotifier)notifierFactory.adapt(diagram1, ValueChangedEventNotifier.class);

		TraceValueChangedEventListener listener = new TraceValueChangedEventListener();
		eventNotifier.addEventListener(listener);
		TriggeredEventTraces<Notification> traces = listener.traces;
		int expectedEventCount = 1;
		
		// Action
		traces.clear();
		// Modify ele
		Property p1 = modelsFactory.newProperty(c1, "p1");

		// Assert
		// Assert
		assertTrue("event recorded", traces.contains("valueChanged"));
		assertEquals("one event recorded", expectedEventCount, traces.traces.size() );
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.notifier.ValueChangedEventNotifier#fireDiagramViewRemovedEvent(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testPropertyNameChanged() {
		NotationAndUmlModelsFactory modelsFactory = new NotationAndUmlModelsFactory();
		Diagram diagram1 = modelsFactory.newDiagram();
		Class c1 = modelsFactory.newClass(diagram1, "C1");
		Property p1 = modelsFactory.newProperty(c1, "p1");

		ValueChangedEventNotifierFactory notifierFactory = new ValueChangedEventNotifierFactory();		
		ValueChangedEventNotifier eventNotifier = (ValueChangedEventNotifier)notifierFactory.adapt(diagram1, ValueChangedEventNotifier.class);

		TraceValueChangedEventListener listener = new TraceValueChangedEventListener();
		eventNotifier.addEventListener(listener);
		TriggeredEventTraces<Notification> traces = listener.traces;
		int expectedEventCount = 1;
		
		// Action
		traces.clear();
		// Modify ele
		p1.setName("NewName");

		// Assert
		assertTrue("event recorded", traces.contains("valueChanged"));
		assertEquals("one event recorded", expectedEventCount, traces.traces.size() );
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.notifier.ValueChangedEventNotifier#fireDiagramViewRemovedEvent(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testClassAdded() {
		NotationAndUmlModelsFactory modelsFactory = new NotationAndUmlModelsFactory();
		Diagram diagram1 = modelsFactory.newDiagram();
		Class c1 = modelsFactory.newClass(diagram1, "C1");

		ValueChangedEventNotifierFactory notifierFactory = new ValueChangedEventNotifierFactory();		
		ValueChangedEventNotifier eventNotifier = (ValueChangedEventNotifier)notifierFactory.adapt(diagram1, ValueChangedEventNotifier.class);

		TraceValueChangedEventListener listener = new TraceValueChangedEventListener();
		eventNotifier.addEventListener(listener);
		TriggeredEventTraces<Notification> traces = listener.traces;
		int expectedEventCount = 1; // Name is set before attachment ==> no corresponding event.
		
		// Action
		traces.clear();
		Class c2 = modelsFactory.newClass(diagram1, "C2");

		// Assert
		assertTrue("event recorded", traces.contains("valueChanged"));
		assertEquals("one event recorded", expectedEventCount, traces.traces.size() );
		
	}


}
