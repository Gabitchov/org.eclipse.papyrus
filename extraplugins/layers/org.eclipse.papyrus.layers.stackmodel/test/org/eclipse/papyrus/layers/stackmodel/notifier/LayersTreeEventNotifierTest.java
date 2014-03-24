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
package org.eclipse.papyrus.layers.stackmodel.notifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.layers.stackmodel.layers.Layer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.util.TriggeredEventTraces;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/**
 * @author dumoulin
 *
 */
public class LayersTreeEventNotifierTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersTreeEventNotifier#LayersTreeEventNotifier(org.eclipse.papyrus.layers.stackmodel.layers.LayersStack)}.
	 */
	@Test
	public void testLayersTreeEventNotifier() {
		
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersTreeEventNotifier notifier = LayersTreeEventNotifierFactory.instance.adapt(layersStack);
	
//		// Add a trace listener
//		ILayersTreeEventListener listener = new TraceLayersModelEventListener();
//		notifier.addLayersModelEventListener(listener);
		
		// Check creation
		assertNotNull("notifier created", notifier);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersTreeEventNotifier#activate()}.
	 */
	@Test
	@Ignore
	public void testActivate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersTreeEventNotifier#deactivate()}.
	 */
	@Test
	@Ignore
	public void testDeactivate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersTreeEventNotifier#dispose()}.
	 */
	@Test
	public void testDispose() {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersTreeEventNotifier notifier = LayersTreeEventNotifierFactory.instance.adapt(layersStack);
	
		// Add a trace listener
		TraceLayersModelEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		
		TriggeredEventTraces<Notification> traces = listener.traces;
		// Add a layer
		LayerOperator layerOp1 = LayersFactory.eINSTANCE.createStackedLayerOperator();
		layersStack.setLayers(layerOp1);
		
		// dispose notifier
		assertFalse("notifier disposed", notifier.isDisposed());
		notifier.dispose();
		assertTrue("notifier disposed", notifier.isDisposed());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersTreeEventNotifier#addLayersModelEventListener(org.eclipse.papyrus.layers.runtime.ILayersTreeEventListener)}.
	 */
	@Test
	public void testAddLayersModelEventListener() {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersTreeEventNotifier notifier = LayersTreeEventNotifierFactory.instance.adapt(layersStack);
	
		// Add a trace listener
		ILayersTreeEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		
		// Check creation
		assertNotNull("notifier created", notifier);
		assertTrue( "listener added to internal list", notifier.listeners.contains(listener) );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersTreeEventNotifier#removeLayersModelEventListener(org.eclipse.papyrus.layers.runtime.ILayersTreeEventListener)}.
	 */
	@Test
	public void testRemoveLayersModelEventListener() {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersTreeEventNotifier notifier = LayersTreeEventNotifierFactory.instance.adapt(layersStack);
	
		// Add a trace listener
		ILayersTreeEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		assertTrue( "listener added to internal list", notifier.listeners.contains(listener) );
		
		// Remove the listener
		notifier.removeLayersModelEventListener(listener);
		assertFalse( "listener removed from internal list", notifier.listeners.contains(listener) );
		
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersTreeEventNotifier#fireLayerAdded(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testFireLayerAdded() {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersTreeEventNotifier notifier = LayersTreeEventNotifierFactory.instance.adapt(layersStack);
	
		// Add a trace listener
		TraceLayersModelEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		
		TriggeredEventTraces<Notification> traces = listener.traces;
		// Add a layer
		LayerOperator layerOp1 = LayersFactory.eINSTANCE.createStackedLayerOperator();
		System.err.println("setLayers(layerOp1)");
		layersStack.setLayers(layerOp1);
		// Check events
		assertTrue("event recorded", traces.contains("layerSet"));
		assertEquals("one event recorded", 1, traces.traces.size() );
		assertEquals("one event recorded", "layerSet", traces.traces.get(0).name );
		
		// Add a layer
		Layer layer1 = LayersFactory.eINSTANCE.createLayer();
		System.err.println("layerOp1.getLayers().add(layer1)");
		layerOp1.getLayers().add(layer1);
		
		// Check events
		assertTrue("event recorded", traces.contains("layerAdded"));
		assertEquals("one event recorded", 2, traces.traces.size() );
		assertEquals("one event recorded", "layerAdded", traces.traces.get(1).name );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersTreeEventNotifier#fireLayerRemoved(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testFireLayerRemoved() {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersTreeEventNotifier notifier = LayersTreeEventNotifierFactory.instance.adapt(layersStack);
	
		// Add a trace listener
		TraceLayersModelEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		
		TriggeredEventTraces<Notification> traces = listener.traces;
		// Add a layer
		LayerOperator layerOp1 = LayersFactory.eINSTANCE.createStackedLayerOperator();
		layersStack.setLayers(layerOp1);
		
		// Add a layer
		Layer layer1 = LayersFactory.eINSTANCE.createLayer();
		layerOp1.getLayers().add(layer1);
		
		// Remove layer
		traces.clear();
		layerOp1.getLayers().remove(layer1);
		
		// Check events
		assertTrue("event recorded", traces.contains("layerRemoved"));
		assertEquals("one event recorded", 1, traces.traces.size() );
		assertEquals("one event recorded", "layerRemoved", traces.traces.get(0).name );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersTreeEventNotifier#fireLayerRemoved(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testFireLayerSetForRootLayer() {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersTreeEventNotifier notifier = LayersTreeEventNotifierFactory.instance.adapt(layersStack);
	
		// Add a trace listener
		TraceLayersModelEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		
		TriggeredEventTraces<Notification> traces = listener.traces;
		// Add a layer as root
		LayerOperator layerOp1 = LayersFactory.eINSTANCE.createStackedLayerOperator();
		layersStack.setLayers(layerOp1);
		
		// Add a layer
		Layer layer1 = LayersFactory.eINSTANCE.createLayer();
		layerOp1.getLayers().add(layer1);
		
		// Remove root layer
		traces.clear();
		layersStack.setLayers(null);
		
		// Check events
		assertTrue("event recorded", traces.contains("layerSet"));
		assertEquals("one event recorded", 1, traces.traces.size() );
		assertEquals("one event recorded", "layerSet", traces.traces.get(0).name );
		// Note that no event is sent for the nested layer
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersTreeEventNotifier#fireLayerRemoved(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testFireEventWhenRootLayerIsReplaced() {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersTreeEventNotifier notifier = LayersTreeEventNotifierFactory.instance.adapt(layersStack);
	
		// Add a trace listener
		TraceLayersModelEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		
		TriggeredEventTraces<Notification> traces = listener.traces;
		// Add a layer as root
		LayerOperator layerOp1 = LayersFactory.eINSTANCE.createStackedLayerOperator();
		layersStack.setLayers(layerOp1);
		
		// Add a layer
		Layer layer1 = LayersFactory.eINSTANCE.createLayer();
		layerOp1.getLayers().add(layer1);
		
		// replace root layer
		traces.clear();
		Layer layer2 = LayersFactory.eINSTANCE.createLayer();
		layersStack.setLayers(layer2);
		
		// Check events
		assertTrue("event recorded", traces.contains("layerSet"));
		assertEquals("one event recorded", 1, traces.traces.size() );
		assertEquals("one event recorded", "layerSet", traces.traces.get(0).name );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersTreeEventNotifier#fireLayerRemoved(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testFireEventWhenLayerIsReplaced() {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersTreeEventNotifier notifier = LayersTreeEventNotifierFactory.instance.adapt(layersStack);
	
		// Add a trace listener
		TraceLayersModelEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		
		TriggeredEventTraces<Notification> traces = listener.traces;
		// Add a layer as root
		LayerOperator layerOp1 = LayersFactory.eINSTANCE.createStackedLayerOperator();
		layersStack.setLayers(layerOp1);
		
		// Add a layer
		Layer layer1 = LayersFactory.eINSTANCE.createLayer();
		layerOp1.getLayers().add(layer1);
		
		// replace root layer
		traces.clear();
		Layer layer2 = LayersFactory.eINSTANCE.createLayer();
		layerOp1.getLayers().set(0, layer2);
		
		// Check events
		assertTrue("event recorded", traces.contains("layerSet"));
		assertEquals("one event recorded", 1, traces.traces.size() );
		assertEquals("one event recorded", "layerSet", traces.traces.get(0).name );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersTreeEventNotifier#fireLayerMoved(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testFireLayerMoved() {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersTreeEventNotifier notifier = LayersTreeEventNotifierFactory.instance.adapt(layersStack);
	
		// Add a trace listener
		TraceLayersModelEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		
		TriggeredEventTraces<Notification> traces = listener.traces;
		// Add a layer
		LayerOperator layerOp1 = LayersFactory.eINSTANCE.createStackedLayerOperator();
		layersStack.setLayers(layerOp1);
		
		// Add a layer
		Layer layer1 = LayersFactory.eINSTANCE.createLayer();
		layerOp1.getLayers().add(layer1);
		
		// Add a layer
		Layer layer2 = LayersFactory.eINSTANCE.createLayer();
		layerOp1.getLayers().add(layer2);
		
		// move layer
		// EMF list are EList, which contains a move operation
		traces.clear();
		EList<LayerExpression> list = (EList<LayerExpression>)layerOp1.getLayers();
		list.move(0, layer2);
		
		// Check events
		assertTrue("event recorded", traces.contains("layerMoved"));
		assertEquals("one event recorded", 1, traces.traces.size() );
		assertEquals("one event recorded", "layerMoved", traces.traces.get(0).name );
	}


}
