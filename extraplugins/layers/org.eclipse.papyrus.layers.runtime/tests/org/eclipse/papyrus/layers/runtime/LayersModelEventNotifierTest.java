/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.runtime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.runtime.utils.TriggeredEventTraces;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.layers.BooleanInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.Layer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.util.PropertyUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/**
 * @author dumoulin
 *
 */
public class LayersModelEventNotifierTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventNotifier#LayersModelEventNotifier(org.eclipse.papyrus.layers.stackmodel.layers.LayersStack)}.
	 */
	@Test
	public void testLayersModelEventNotifier() {
		
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersModelEventNotifier notifier = new LayersModelEventNotifier(layersStack);
	
//		// Add a trace listener
//		ILayersModelEventListener listener = new TraceLayersModelEventListener();
//		notifier.addLayersModelEventListener(listener);
		
		// Check creation
		assertNotNull("notifier created", notifier);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventNotifier#activate()}.
	 */
	@Test
	@Ignore
	public void testActivate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventNotifier#deactivate()}.
	 */
	@Test
	@Ignore
	public void testDeactivate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventNotifier#dispose()}.
	 */
	@Test
	public void testDispose() {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersModelEventNotifier notifier = new LayersModelEventNotifier(layersStack);
	
		// Add a trace listener
		TraceLayersModelEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		
		TriggeredEventTraces traces = listener.traces;
		// Add a layer
		LayerOperator layerOp1 = LayersFactory.eINSTANCE.createStackedLayerOperator();
		layersStack.setLayers(layerOp1);
		
		// dispose notifier
		assertFalse("notifier disposed", notifier.isDisposed());
		notifier.dispose();
		assertTrue("notifier disposed", notifier.isDisposed());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventNotifier#addLayersModelEventListener(org.eclipse.papyrus.layers.runtime.ILayersModelEventListener)}.
	 */
	@Test
	public void testAddLayersModelEventListener() {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersModelEventNotifier notifier = new LayersModelEventNotifier(layersStack);
	
		// Add a trace listener
		ILayersModelEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		
		// Check creation
		assertNotNull("notifier created", notifier);
		assertTrue( "listener added to internal list", notifier.listeners.contains(listener) );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventNotifier#removeLayersModelEventListener(org.eclipse.papyrus.layers.runtime.ILayersModelEventListener)}.
	 */
	@Test
	public void testRemoveLayersModelEventListener() {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersModelEventNotifier notifier = new LayersModelEventNotifier(layersStack);
	
		// Add a trace listener
		ILayersModelEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		assertTrue( "listener added to internal list", notifier.listeners.contains(listener) );
		
		// Remove the listener
		notifier.removeLayersModelEventListener(listener);
		assertFalse( "listener removed from internal list", notifier.listeners.contains(listener) );
		
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventNotifier#firePropertyValueAddedEvent(org.eclipse.emf.common.notify.Notification)}.
	 * @throws LayersException 
	 */
	@Test
	public void testFirePropertyValueAddedEvent() throws LayersException {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersModelEventNotifier notifier = new LayersModelEventNotifier(layersStack);
	
		// Add a trace listener
		TraceLayersModelEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		
		TriggeredEventTraces traces = listener.traces;
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
		
		// Add an instance to layer1
		traces.traces.clear();
		Property isSunday = PropertyUtils.getInstance().createProperty("isSunday", LayersPackage.eINSTANCE.getBooleanType());
		layer1.addPropertyInstance(isSunday);
		// Check events
		assertEquals("one event recorded", "propertyValueAdded", traces.traces.get(0).name );
		assertTrue("event recorded", traces.contains("propertyValueAdded"));
		assertEquals("one event recorded", 1, traces.traces.size() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventNotifier#firePropertyValueRemoved(org.eclipse.emf.common.notify.Notification)}.
	 * @throws LayersException 
	 */
	@Test
	public void testFirePropertyValueRemoved() throws LayersException {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersModelEventNotifier notifier = new LayersModelEventNotifier(layersStack);
	
		// Add a trace listener
		TraceLayersModelEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		
		TriggeredEventTraces traces = listener.traces;
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
		
		// Add an instance to layer1
		String propertyName = "isSunday";
		Property isSunday = PropertyUtils.getInstance().createProperty(propertyName, LayersPackage.eINSTANCE.getBooleanType());
		layer1.addPropertyInstance(isSunday);
		
		// Remove the instance
		traces.traces.clear();
		layer1.removePropertyInstance(isSunday);
		
		// Check events
		assertEquals("one event recorded", "propertyValueRemoved", traces.traces.get(0).name );
		assertTrue("event recorded", traces.contains("propertyValueRemoved"));
		assertEquals("one event recorded", 1, traces.traces.size() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventNotifier#firePropertyValueChanged(org.eclipse.emf.common.notify.Notification)}.
	 * @throws LayersException 
	 */
	@Test
	public void testFirePropertyValueChanged() throws LayersException {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersModelEventNotifier notifier = new LayersModelEventNotifier(layersStack);
	
		// Add a trace listener
		TraceLayersModelEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		
		TriggeredEventTraces traces = listener.traces;
		// create layer op
		LayerOperator layerOp1 = LayersFactory.eINSTANCE.createStackedLayerOperator();
		layersStack.setLayers(layerOp1);
		
		// Add a layer
		Layer layer1 = LayersFactory.eINSTANCE.createLayer();
		layerOp1.getLayers().add(layer1);
		
		// Add an instance to layer1
		String propertyName = "isSunday";
		Property isSunday = PropertyUtils.getInstance().createProperty(propertyName, LayersPackage.eINSTANCE.getBooleanType());
		BooleanInstance isSundayInstance = (BooleanInstance)layer1.addPropertyInstance(isSunday);
		
		// Change the value of the instance
		traces.traces.clear();
		isSundayInstance.setValue(true);
		
		// Check events
		assertEquals("one event recorded", "propertyValueChanged", traces.traces.get(0).name );
		assertTrue("event recorded", traces.contains("propertyValueChanged"));
		assertEquals("one event recorded", 1, traces.traces.size() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventNotifier#fireLayerAdded(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testFireLayerAdded() {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersModelEventNotifier notifier = new LayersModelEventNotifier(layersStack);
	
		// Add a trace listener
		TraceLayersModelEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		
		TriggeredEventTraces traces = listener.traces;
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
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventNotifier#fireLayerRemoved(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testFireLayerRemoved() {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersModelEventNotifier notifier = new LayersModelEventNotifier(layersStack);
	
		// Add a trace listener
		TraceLayersModelEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		
		TriggeredEventTraces traces = listener.traces;
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
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventNotifier#fireLayerRemoved(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testFireLayerSetForRootLayer() {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersModelEventNotifier notifier = new LayersModelEventNotifier(layersStack);
	
		// Add a trace listener
		TraceLayersModelEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		
		TriggeredEventTraces traces = listener.traces;
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
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventNotifier#fireLayerRemoved(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testFireEventWhenRootLayerIsReplaced() {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersModelEventNotifier notifier = new LayersModelEventNotifier(layersStack);
	
		// Add a trace listener
		TraceLayersModelEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		
		TriggeredEventTraces traces = listener.traces;
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
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventNotifier#fireLayerRemoved(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testFireEventWhenLayerIsReplaced() {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersModelEventNotifier notifier = new LayersModelEventNotifier(layersStack);
	
		// Add a trace listener
		TraceLayersModelEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		
		TriggeredEventTraces traces = listener.traces;
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
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventNotifier#fireLayerMoved(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testFireLayerMoved() {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersModelEventNotifier notifier = new LayersModelEventNotifier(layersStack);
	
		// Add a trace listener
		TraceLayersModelEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		
		TriggeredEventTraces traces = listener.traces;
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

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventNotifier#fireViewAddedToLayer(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testFireViewAddedToLayer() {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersModelEventNotifier notifier = new LayersModelEventNotifier(layersStack);
	
		// Add a trace listener
		TraceLayersModelEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		
		TriggeredEventTraces traces = listener.traces;
		// Add a layer
		LayerOperator layerOp1 = LayersFactory.eINSTANCE.createStackedLayerOperator();
		layersStack.setLayers(layerOp1);
		
		// Add a layer
		Layer layer1 = LayersFactory.eINSTANCE.createLayer();
		layerOp1.getLayers().add(layer1);
		
		// Add a layer
		Layer layer2 = LayersFactory.eINSTANCE.createLayer();
		layerOp1.getLayers().add(layer2);
		
		// add a view to layer1
		traces.clear();
		View view1 = NotationFactory.eINSTANCE.createShape();
		layer1.getViews().add(view1);
		
		// Check events
		assertEquals("one event recorded", 1, traces.traces.size() );
		assertEquals("one event recorded", "viewAddedToLayer", traces.traces.get(0).name );
		assertTrue("event recorded", traces.contains("viewAddedToLayer"));
		
		// add a view to layer2
		traces.clear();
		View view2 = NotationFactory.eINSTANCE.createShape();
		layer2.getViews().add(view2);
		
		// Check events
		assertEquals("one event recorded", 1, traces.traces.size() );
		assertEquals("one event recorded", "viewAddedToLayer", traces.traces.get(0).name );
		assertTrue("event recorded", traces.contains("viewAddedToLayer"));
		
		// Use the same view 2 times
		traces.clear();
		layer2.getViews().add(view1);
		// Check events
		assertEquals("one event recorded", 1, traces.traces.size() );
		assertEquals("one event recorded", "viewAddedToLayer", traces.traces.get(0).name );
		assertTrue("event recorded", traces.contains("viewAddedToLayer"));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventNotifier#fireViewRemovedFromLayer(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testFireViewRemovedFromLayer() {
		// Create a notifier
		LayersStack layersStack = LayersFactory.eINSTANCE.createLayersStack();
		LayersModelEventNotifier notifier = new LayersModelEventNotifier(layersStack);
	
		// Add a trace listener
		TraceLayersModelEventListener listener = new TraceLayersModelEventListener();
		notifier.addLayersModelEventListener(listener);
		
		TriggeredEventTraces traces = listener.traces;
		// Add a layer
		LayerOperator layerOp1 = LayersFactory.eINSTANCE.createStackedLayerOperator();
		layersStack.setLayers(layerOp1);
		
		// Add a layer
		Layer layer1 = LayersFactory.eINSTANCE.createLayer();
		layerOp1.getLayers().add(layer1);
		
		// Add a layer
		Layer layer2 = LayersFactory.eINSTANCE.createLayer();
		layerOp1.getLayers().add(layer2);
		
		// add a view to layer1
		View view1 = NotationFactory.eINSTANCE.createShape();
		layer1.getViews().add(view1);
		
		// Remove the view
		traces.clear();
		layer1.getViews().remove(view1);
		
		// Check events
		assertEquals("one event recorded", 1, traces.traces.size() );
		assertEquals("one event recorded", "viewRemovedFromLayer", traces.traces.get(0).name );
		assertTrue("event recorded", traces.contains("viewRemovedFromLayer"));
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventNotifier#fireViewMovedBetweenLayer(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	@Ignore
	public void testFireViewMovedBetweenLayer() {
		fail("Not yet implemented");
	}

}
