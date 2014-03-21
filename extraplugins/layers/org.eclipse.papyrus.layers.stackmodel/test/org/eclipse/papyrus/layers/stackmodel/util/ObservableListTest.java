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

package org.eclipse.papyrus.layers.stackmodel.util;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.util.ObservableListView#ObservableList(java.util.List)}.
	 */
	@Test
	public void testObservableList() {
		
		List<String> list = Lists.newArrayList( "red", "orange", "yellow", "green", "blue",  "purple");
		
		ObservableListView<String> notyfyingList = new ObservableListView<String>(list);
		
		assertNotNull("Object created", notyfyingList);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.util.ObservableListView#delegate()}.
	 */
	@Test
	public void testDelegate() {
		List<String> list = Lists.newArrayList( "red", "orange", "yellow", "green", "blue",  "purple");
		
		ObservableListView<String> notyfyingList = new ObservableListView<String>(list);
		
		assertSame("delegate is set", list, notyfyingList.delegate() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.util.ObservableListView#getEventBus()}.
	 */
	@Test
	public void testGetEventBus() {
		List<String> list = Lists.newArrayList( "red", "orange", "yellow", "green", "blue",  "purple");
		
		ObservableListView<String> notyfyingList = new ObservableListView<String>(list);
		
		assertNotNull("eventBus found", notyfyingList.getEventBus() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.util.ObservableListView#add(java.lang.Object)}.
	 */
	@Test
	public void testAddE() {
		List<String> list = Lists.newArrayList( "red", "orange", "yellow", "green", "blue",  "purple");
		String addedElement = "purple";
		int listSizeBefore = list.size();
		int expectedListSizeAfter = listSizeBefore+1;

		FakeObservableListListener<String> notifyingListListener = new FakeObservableListListener<String>();
		ObservableListView<String> notyfyingList = new ObservableListView<String>(list);
		
		notyfyingList.getEventBus().register(notifyingListListener );
		
		// Action
		notyfyingList.add(addedElement);
		
		// Assertions
		assertSame("event propagated", 1, notifyingListListener.traces.size());
		assertTrue("event addedElement is correct", notifyingListListener.traces.get(0).notifier.getAddedElements().contains(addedElement));

		Collection<? extends String> eventAddedElements = notifyingListListener.traces.get(0).notifier.getAddedElements();
		assertEquals("event elements size", 1 , eventAddedElements.size());
		
		assertEquals("result list size", expectedListSizeAfter , notyfyingList.size());
		assertEquals("result list size", expectedListSizeAfter , list.size());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.util.ObservableListView#addAll(java.util.Collection)}.
	 */
	@Test
	public void testAddAllCollectionOfQextendsE() {
		List<String> list = Lists.newArrayList( "red", "orange", "yellow");
		List<String> addedElements = Lists.newArrayList( "green", "blue",  "purple");
		int listSizeBefore = list.size();
		int expectedListSizeAfter = listSizeBefore+addedElements.size();
		
		ObservableListView<String> notyfyingList = new ObservableListView<String>(list);
		FakeObservableListListener<String> notifyingListListener = new FakeObservableListListener<String>();
		
		notyfyingList.getEventBus().register(notifyingListListener );
		
		// Action
		notyfyingList.addAll(addedElements);
		
		assertSame("event propagated", 1, notifyingListListener.traces.size());
		
		Collection<? extends String> eventAddedElements = notifyingListListener.traces.get(0).notifier.getAddedElements();
		assertEquals("event elements size", addedElements.size() , eventAddedElements.size());
		
		assertEquals("result list size", expectedListSizeAfter , notyfyingList.size());
		assertEquals("result list size", expectedListSizeAfter , list.size());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.util.ObservableListView#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntE() {
		List<String> list = Lists.newArrayList( "red", "orange", "yellow", "green", "blue",  "purple");
		String addedElement = "purple";
		int listSizeBefore = list.size();
		int expectedListSizeAfter = listSizeBefore+1;

		FakeObservableListListener<String> notifyingListListener = new FakeObservableListListener<String>();
		ObservableListView<String> notyfyingList = new ObservableListView<String>(list);
		
		notyfyingList.getEventBus().register(notifyingListListener );
		
		// Action
		notyfyingList.add(3, addedElement);
		
		// Assertions
		assertSame("event propagated", 1, notifyingListListener.traces.size());
		assertTrue("event addedElement is correct", notifyingListListener.traces.get(0).notifier.getAddedElements().contains(addedElement));

		Collection<? extends String> eventAddedElements = notifyingListListener.traces.get(0).notifier.getAddedElements();
		assertEquals("event elements size", 1 , eventAddedElements.size());
		
		assertEquals("result list size", expectedListSizeAfter , notyfyingList.size());
		assertEquals("result list size", expectedListSizeAfter , list.size());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.util.ObservableListView#addAll(int, java.util.Collection)}.
	 */
	@Test
	public void testAddAllIntCollectionOfQextendsE() {
		List<String> list = Lists.newArrayList( "red", "orange", "yellow");
		List<String> addedElements = Lists.newArrayList( "green", "blue",  "purple");
		int listSizeBefore = list.size();
		int expectedListSizeAfter = listSizeBefore+addedElements.size();
		
		ObservableListView<String> notyfyingList = new ObservableListView<String>(list);
		FakeObservableListListener<String> notifyingListListener = new FakeObservableListListener<String>();
		
		notyfyingList.getEventBus().register(notifyingListListener );
		
		// Action
		notyfyingList.addAll(2, addedElements);
		
		assertSame("event propagated", 1, notifyingListListener.traces.size());
		
		Collection<? extends String> eventAddedElements = notifyingListListener.traces.get(0).notifier.getAddedElements();
		assertEquals("event elements size", addedElements.size() , eventAddedElements.size());
		
		assertEquals("result list size", expectedListSizeAfter , notyfyingList.size());
		assertEquals("result list size", expectedListSizeAfter , list.size());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.util.ObservableListView#remove(int)}.
	 */
	@Test
	public void testRemoveInt() {
		List<String> list = Lists.newArrayList( "red", "orange", "yellow", "green", "blue",  "purple");
		String removedElement = "purple";
		int listSizeBefore = list.size();
		int expectedListSizeAfter = listSizeBefore-1;

		FakeObservableListListener<String> notifyingListListener = new FakeObservableListListener<String>();
		ObservableListView<String> notyfyingList = new ObservableListView<String>(list);
		
		notyfyingList.getEventBus().register(notifyingListListener );
		
		// Action
		notyfyingList.remove( removedElement);
		
		// Assertions
		assertSame("event propagated", 1, notifyingListListener.traces.size());
		ObservableListView<String>.ObservableListEvent event = notifyingListListener.traces.get(0).notifier;
		assertTrue("event removesElement is correct", event.getRemovedElements().contains(removedElement));
		
		assertEquals("addedElement size", 0, event.getAddedElements().size() );
		assertEquals("removedElement size", 1, event.getRemovedElements().size() );
		
		assertEquals("result list size", expectedListSizeAfter , notyfyingList.size());
		assertEquals("result list size", expectedListSizeAfter , list.size());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.util.ObservableListView#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveObject() {
		List<String> list = Lists.newArrayList( "red", "orange", "yellow", "green", "blue",  "purple");
		int removedIndex = 3;
		String removedElement = list.get(removedIndex);
		int listSizeBefore = list.size();
		int expectedListSizeAfter = listSizeBefore-1;

		FakeObservableListListener<String> notifyingListListener = new FakeObservableListListener<String>();
		ObservableListView<String> notyfyingList = new ObservableListView<String>(list);
		
		notyfyingList.getEventBus().register(notifyingListListener );
		
		// Action
		notyfyingList.remove( removedIndex);
		
		// Assertions
		assertSame("event propagated", 1, notifyingListListener.traces.size());
		ObservableListView<String>.ObservableListEvent event = notifyingListListener.traces.get(0).notifier;
		assertTrue("event removesElement is correct", event.getRemovedElements().contains(removedElement));
		
		assertEquals("addedElement size", 0, event.getAddedElements().size() );
		assertEquals("removedElement size", 1, event.getRemovedElements().size() );
		
		assertEquals("result list size", expectedListSizeAfter , notyfyingList.size());
		assertEquals("result list size", expectedListSizeAfter , list.size());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.util.ObservableListView#removeAll(java.util.Collection)}.
	 */
	@Test
	public void testRemoveAllCollectionOfQ() {
		List<String> list = Lists.newArrayList( "red", "orange", "yellow", "green", "blue",  "purple");
		List<String> elementsToRemove = Lists.newArrayList( "orange", "green",  "purple");
		int listSizeBefore = list.size();
		int removedElementsCount = elementsToRemove.size();
		int expectedListSizeAfter = listSizeBefore-removedElementsCount;

		FakeObservableListListener<String> notifyingListListener = new FakeObservableListListener<String>();
		ObservableListView<String> notyfyingList = new ObservableListView<String>(list);
		
		notyfyingList.getEventBus().register(notifyingListListener );
		
		// Action
		notyfyingList.removeAll( elementsToRemove);
		
		// Assertions
		assertSame("event propagated", 1, notifyingListListener.traces.size());
		
		ObservableListView<String>.ObservableListEvent event = notifyingListListener.traces.get(0).notifier;
		assertTrue("event removesElement is correct", event.getRemovedElements().containsAll(elementsToRemove));
		
		assertEquals("addedElement size", 0, event.getAddedElements().size() );
		assertEquals("removedElement size", removedElementsCount, event.getRemovedElements().size() );
		
		assertEquals("result list size", expectedListSizeAfter , notyfyingList.size());
		assertEquals("result list size", expectedListSizeAfter , list.size());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.util.ObservableListView#removeAll(java.util.Collection)}.
	 */
	@Test
	public void testRemoveAllCollectionOfQWithTooMuchElements() {
		List<String> list = Lists.newArrayList( "red", "orange", "yellow", "green", "blue",  "purple");
		List<String> elementsToRemove = Lists.newArrayList( "orange", "falseColor1", "green",  "purple", "falseColor");
		int listSizeBefore = list.size();
		int removedElementsCount = elementsToRemove.size()-2; // 2 = falseColors
		int expectedListSizeAfter = listSizeBefore-removedElementsCount;

		FakeObservableListListener<String> notifyingListListener = new FakeObservableListListener<String>();
		ObservableListView<String> notyfyingList = new ObservableListView<String>(list);
		
		notyfyingList.getEventBus().register(notifyingListListener );
		
		// Action
		notyfyingList.removeAll( elementsToRemove);
		
		// Assertions
		assertSame("event propagated", 1, notifyingListListener.traces.size());
		
		ObservableListView<String>.ObservableListEvent event = notifyingListListener.traces.get(0).notifier;
//		assertTrue("event removesElement is correct", event.getRemovedElements().containsAll(elementsToRemove));
		assertTrue("removed elements are from the required list", elementsToRemove.containsAll(event.getRemovedElements()));
		
		assertEquals("addedElement size", 0, event.getAddedElements().size() );
		assertEquals("removedElement size", removedElementsCount, event.getRemovedElements().size() );
		
		assertEquals("result list size", expectedListSizeAfter , notyfyingList.size());
		assertEquals("result list size", expectedListSizeAfter , list.size());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.util.ObservableListView#resetTo(java.util.Collection)}.
	 */
	@Test
	public void testResetTo() {
		List<String> list = Lists.newArrayList( "red", "orange", "yellow", "green", "blue",  "purple");
		
		List<String> listToReset = Lists.newArrayList( "orange", "green",  "purple", "falseColor");
		List<String> expectedRemovedElement = Lists.newArrayList( "red", "yellow", "blue");
		List<String> expectedAddedElement = Lists.newArrayList( "falseColor");
		
		int expectedEventCount = 1;

		FakeObservableListListener<String> notifyingListListener = new FakeObservableListListener<String>();
		ObservableListView<String> notyfyingList = new ObservableListView<String>(list);
		
		notyfyingList.getEventBus().register(notifyingListListener );
		
		// Action
		notyfyingList.resetTo(listToReset);
		
		// Assertions
		assertSame("event propagated", expectedEventCount, notifyingListListener.traces.size());
		assertArrayEquals("List equals", listToReset.toArray(), notyfyingList.toArray());
		
		ObservableListView<String>.ObservableListEvent event = notifyingListListener.traces.get(0).notifier;
		assertArrayEquals("Removed list ok", expectedRemovedElement.toArray(), event.getRemovedElements().toArray());
		assertArrayEquals("Added list ok", expectedAddedElement.toArray(), event.getAddedElements().toArray());	
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.util.ObservableListView#resetTo(java.util.Collection)}.
	 */
	@Test
	public void testResetToNoAdded() {
		List<String> list = Lists.newArrayList( "red", "orange", "yellow", "green", "blue",  "purple");
		
		List<String> listToReset = Lists.newArrayList( "orange", "green",  "purple");
		List<String> expectedRemovedElement = Lists.newArrayList( "red", "yellow", "blue");
		List<String> expectedAddedElement = Collections.emptyList();
		
		int expectedEventCount = 1;

		FakeObservableListListener<String> notifyingListListener = new FakeObservableListListener<String>();
		ObservableListView<String> notyfyingList = new ObservableListView<String>(list);
		
		notyfyingList.getEventBus().register(notifyingListListener );
		
		// Action
		notyfyingList.resetTo(listToReset);
		
		// Assertions
		assertSame("event propagated", expectedEventCount, notifyingListListener.traces.size());
		assertArrayEquals("List equals", listToReset.toArray(), notyfyingList.toArray());
		
		ObservableListView<String>.ObservableListEvent event = notifyingListListener.traces.get(0).notifier;
		assertArrayEquals("Removed list ok", expectedRemovedElement.toArray(), event.getRemovedElements().toArray());
		assertArrayEquals("Added list ok", expectedAddedElement.toArray(), event.getAddedElements().toArray());	
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.util.ObservableListView#resetTo(java.util.Collection)}.
	 */
	@Test
	public void testResetToWithAddition() {
		List<String> list = Lists.newArrayList( "red", "orange", "yellow", "green", "blue",  "purple");
		
		List<String> listToReset = Lists.newArrayList( "red", "orange", "yellow", "green", "blue",  "purple", "falseColor");
		List<String> expectedRemovedElement = Collections.emptyList();
		List<String> expectedAddedElement = Lists.newArrayList( "falseColor");
		
		int expectedEventCount = 1;

		FakeObservableListListener<String> notifyingListListener = new FakeObservableListListener<String>();
		ObservableListView<String> notyfyingList = new ObservableListView<String>(list);
		
		notyfyingList.getEventBus().register(notifyingListListener );
		
		// Action
		notyfyingList.resetTo(listToReset);
		
		// Assertions
		assertSame("event propagated", expectedEventCount, notifyingListListener.traces.size());
		assertArrayEquals("List equals", listToReset.toArray(), notyfyingList.toArray());
		
		ObservableListView<String>.ObservableListEvent event = notifyingListListener.traces.get(0).notifier;
		assertArrayEquals("Removed list ok", expectedRemovedElement.toArray(), event.getRemovedElements().toArray());
		assertArrayEquals("Added list ok", expectedAddedElement.toArray(), event.getAddedElements().toArray());	
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.util.ObservableListView#resetTo(java.util.Collection)}.
	 */
	@Test
	public void testResetToNoChanges() {
		List<String> list = Lists.newArrayList( "red", "orange", "yellow", "green", "blue",  "purple");
		
		List<String> listToReset = Lists.newArrayList( "red", "orange", "yellow", "green", "blue",  "purple");
		List<String> expectedRemovedElement = Collections.emptyList();
		List<String> expectedAddedElement = Collections.emptyList();
		
		// No change, no events
		int expectedEventCount = 0;

		FakeObservableListListener<String> notifyingListListener = new FakeObservableListListener<String>();
		ObservableListView<String> notyfyingList = new ObservableListView<String>(list);
		
		notyfyingList.getEventBus().register(notifyingListListener );
		
		// Action
		notyfyingList.resetTo(listToReset);
		
		// Assertions
		assertSame("event propagated", expectedEventCount, notifyingListListener.traces.size());
		assertArrayEquals("List equals", listToReset.toArray(), notyfyingList.toArray());
		
//		ObservableList<String>.NotifyingListEvent event = notifyingListListener.traces.get(0).notifier;
//		assertArrayEquals("Removed list ok", expectedRemovedElement.toArray(), event.getRemovedElements().toArray());
//		assertArrayEquals("Added list ok", expectedAddedElement.toArray(), event.getAddedElements().toArray());	
	}



}
