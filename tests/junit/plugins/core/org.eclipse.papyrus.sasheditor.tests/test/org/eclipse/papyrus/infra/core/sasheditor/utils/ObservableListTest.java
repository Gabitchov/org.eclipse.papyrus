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

package org.eclipse.papyrus.infra.core.sasheditor.utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class ObservableListTest {

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
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.utils.ObservableList#ObservableList()}.
	 */
	@Test
	public void testObservableList() {
		ObservableList<String> list = new ObservableList<String>();
		assertNotNull("list created", list);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.utils.ObservableList#addListener(org.eclipse.papyrus.infra.core.sasheditor.utils.IObservableListListener)}.
	 */
	@Test
	public void testAddListener() {
		ObservableList<String> list = new ObservableList<String>();
		assertNotNull("list created", list);
		
		FakeObservableListener<String> listener =  new FakeObservableListener<String>();
		
		// add a listener
		list.addListener(listener);
		// Check if added
		assertTrue("listener added", list.getListeners().contains(listener));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.utils.ObservableList#removeListener(org.eclipse.papyrus.infra.core.sasheditor.utils.IObservableListListener)}.
	 */
	@Test
	public void testRemoveListener() {
		ObservableList<String> list = new ObservableList<String>();
		assertNotNull("list created", list);
		
		FakeObservableListener<String> listener =  new FakeObservableListener<String>();
		
		// add a listener
		list.addListener(listener);
		// Check if added
		assertTrue("listener added", list.getListeners().contains(listener));

		list.removeListener(listener);
		// Check if added
		assertFalse("list contains listener", list.getListeners().contains(listener));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.utils.ObservableList#fireElementAddedEvent(java.lang.Object)}.
	 */
	@Test
	public void testFireElementAddedEvent() {
		ObservableList<String> list = new ObservableList<String>();
		assertNotNull("list created", list);
		
		FakeObservableListener<String> listener =  new FakeObservableListener<String>();
		
		// add a listener
		list.addListener(listener);
		// Check event
		
		list.fireElementAddedEvent("string1");
		assertEquals( "event fired", "string1", listener.getLastAddEvents() );
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.utils.ObservableList#fireElementRemovedEvent(java.lang.Object)}.
	 */
	@Test
	public void testFireElementRemovedEvent() {
		ObservableList<String> list = new ObservableList<String>();
		assertNotNull("list created", list);
		
		FakeObservableListener<String> listener =  new FakeObservableListener<String>();
		
		// add a listener
		list.addListener(listener);
		// Check event
		String element = "string1";
		list.fireElementRemovedEvent(element);
		assertEquals( "event fired", element, listener.getLastRemoveEvents() );
	}

	/**
	 * Test method for add}.
	 */
	@Test
	public void testAdd() {
		ObservableList<String> list = new ObservableList<String>();
		assertNotNull("list created", list);
		
		FakeObservableListener<String> listener =  new FakeObservableListener<String>();
		
		// add a listener
		list.addListener(listener);
		// Check event
		
		String element = "string1";

		list.add(element);
		assertEquals( "event fired", element, listener.getLastAddEvents() );
		assertEquals( "element added to list", element, list.get(list.size()-1) );
		
	}

	/**
	 * Test method for add}.
	 */
	@Test
	public void testRemove() {
		ObservableList<String> list = new ObservableList<String>();
		assertNotNull("list created", list);
		
		FakeObservableListener<String> listener =  new FakeObservableListener<String>();
		
		// add a listener
		list.addListener(listener);
		// Check event
		
		String element = "string1";
		list.add(element);
		assertEquals( "element added to list", element, list.get(list.size()-1) );

		list.remove(element);
		assertFalse( "element removed from list", list.contains(element) );
		assertEquals( "event fired", element, listener.getLastRemoveEvents() );
		
	}


}
