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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.layers.runtime.utils.TriggeredEventTraces;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.layers.BooleanInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.Layer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.StringInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.TopLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/**
 * Test the {@link LayerStackSynchronizer} by initializing it from the {@link LayersStackApplication}
 * class.
 * 
 * 
 * @author cedric dumoulin
 *
 */
public class LayerStackSynchronizerWithApplicationTest {

	/**
	 * URI used to store the created model.
	 */
	protected static final String PROJECT_MODEL_URI = "org.eclipse.papyrus.infra.core/tmp/model1.di";

	/**
	 * ModelSet created for each test
	 */
	protected ModelSet modelSet;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
//		// Create ModelSet and Model
//		ModelSet mngr = new ModelSet();
//		// LayersModel
//		LayersModel layersModel = new LayersModel();
//		mngr.registerModel(layersModel);
//		// Notation model
//		NotationModel notationModel = new NotationModel();
//		mngr.registerModel(notationModel);
//		// Do create resources
//		URI uri = URI.createPlatformResourceURI(PROJECT_MODEL_URI, true);
//		mngr.createModels(uri);
//		
//		modelSet = mngr;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
//		modelSet.unload();
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#LayerStackSynchronizer(org.eclipse.papyrus.layers.stackmodel.layers.LayersStack)}.
	 * @throws LayersException 
	 */
	@Test
	public void testLayerStackSynchronizer() throws LayersException {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();

		// Create stack
		LayersStack stack = application.getLayersStackFor(diagram);
		
		// Create synchronizer
		LayerStackSynchronizer synchronizer = new LayerStackSynchronizer(stack);
		
		// Check creation
		assertNotNull("object created", synchronizer);

		// Create a TopLayer
		TopLayerOperator layer = LayersFactory.eINSTANCE.createTopLayerOperator();
		layer.setApplication(application);
		
		// Create Views
		View view1 = NotationFactory.eINSTANCE.createShape();
		View view2 = NotationFactory.eINSTANCE.createShape();
		View view3 = NotationFactory.eINSTANCE.createShape();
		View view4 = NotationFactory.eINSTANCE.createShape();
		
		// Create Properties
		int index = 0;
		Property property1 = propertyRegistry.getProperties().get(index++);
		Property property2 = propertyRegistry.getProperties().get(index++);
		Property property3 = propertyRegistry.getProperties().get(index++);
		Property property4 = propertyRegistry.getProperties().get(index++);
		
		// Create layer1: views ={} propInstances={}
		Layer layer1 = createLayer( layer, Arrays.asList(view1), Arrays.asList(property1));
		
		// Create layer2: views ={} propInstances={}
		Layer layer2 = createLayer( layer, Arrays.asList(view1, view2), Arrays.asList(property1, property2));
		
		// Create layer3: views ={} propInstances={}
		Layer layer3 = createLayer( layer, Arrays.asList(view3), Arrays.asList(property3));
		
		

		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#getDiagram()}.
	 */
	@Test
	public void testGetDiagram() {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();

		// Create stack
		LayersStack stack = application.getLayersStackFor(diagram);
		
		// Create synchronizer
		LayerStackSynchronizer synchronizer = new LayerStackSynchronizer(stack);
		
		
		// Check creation
		assertNotNull("getDiagram", synchronizer.getDiagram());
		assertSame("getDiagram", diagram, synchronizer.getDiagram());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#getLayersStack()}.
	 */
	@Test
	public void testGetLayersStack() {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();

		// Create stack
		LayersStack stack = application.getLayersStackFor(diagram);
		
		// Create synchronizer
		LayerStackSynchronizer synchronizer = new LayerStackSynchronizer(stack);
		
		
		// Check creation
		assertNotNull("getLayersStack", synchronizer.getLayersStack());
		assertSame("getLayersStack", stack, synchronizer.getLayersStack());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#dispose()}.
	 */
	@Test
	@Ignore
	public void testDispose() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#isDisposed()}.
	 */
	@Test
	@Ignore
	public void testIsDisposed() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#propertyValueAdded(org.eclipse.emf.common.notify.Notification)}.
	 * @throws LayersException 
	 */
	@Test
	public void testPropertyValueAdded() throws LayersException {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();

		// Create stack
		LayersStack stack = application.getLayersStackFor(diagram);
		
		// Create a TopLayer
		TopLayerOperator layer = LayersFactory.eINSTANCE.createTopLayerOperator();
		layer.setApplication(application);
		stack.setLayers(layer);

		// Create synchronizer
		LayerStackSynchronizerSubclass synchronizer = new LayerStackSynchronizerSubclass(stack);
		TriggeredEventTraces traces = synchronizer.traces;
		
		// Create Views
		View view1 = NotationFactory.eINSTANCE.createShape();
		
		// Create Properties
		int index = 0;
		Property property1 = propertyRegistry.getProperties().get(index++);
		Property property2 = propertyRegistry.getProperties().get(index++);
		
		// Create layer1: views ={} propInstances={}
		Layer layer1 = createLayer( layer, Arrays.asList(view1), Arrays.asList(property1));
		
		// Checks
		traces.clear();
		// add a property
		layer1.addPropertyInstance(property2);
		
		assertTrue("event sent", traces.size()>0);
		assertSame("event sent", "propertyValueAdded", traces.get(0).name);
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#propertyValueRemoved(org.eclipse.emf.common.notify.Notification)}.
	 * @throws LayersException 
	 */
	@Test
	public void testPropertyValueRemoved() throws LayersException {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();

		// Create stack
		LayersStack stack = application.getLayersStackFor(diagram);
		
		// Create a TopLayer
		TopLayerOperator layer = LayersFactory.eINSTANCE.createTopLayerOperator();
		layer.setApplication(application);
		stack.setLayers(layer);

		// Create synchronizer
		LayerStackSynchronizerSubclass synchronizer = new LayerStackSynchronizerSubclass(stack);
		TriggeredEventTraces traces = synchronizer.traces;
		
		// Create Views
		View view1 = NotationFactory.eINSTANCE.createShape();
		
		// Create Properties
		int index = 0;
		Property property1 = propertyRegistry.getProperties().get(index++);
		Property property2 = propertyRegistry.getProperties().get(index++);
		
		// Create layer1: views ={} propInstances={}
		Layer layer1 = createLayer( layer, Arrays.asList(view1), Arrays.asList(property1, property2));
		
		// Checks
		traces.clear();
		// remove a property
		layer1.removePropertyInstance(property2);
		
		assertTrue("event sent", traces.size()>0);
		assertSame("event sent", "propertyValueRemoved", traces.get(0).name);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#propertyValueChanged(org.eclipse.emf.common.notify.Notification)}.
	 * @throws LayersException 
	 */
	@Test
	public void testPropertyValueChanged() throws LayersException {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();

		// Create stack
		LayersStack stack = application.getLayersStackFor(diagram);
		
		// Create a TopLayer
		TopLayerOperator layer = LayersFactory.eINSTANCE.createTopLayerOperator();
		layer.setApplication(application);
		stack.setLayers(layer);

		// Create synchronizer
		LayerStackSynchronizerSubclass synchronizer = new LayerStackSynchronizerSubclass(stack);
		TriggeredEventTraces traces = synchronizer.traces;
		
		// Create Views
		View view1 = NotationFactory.eINSTANCE.createShape();
		
		// Create Properties
		int index = 0;
		Property property1 = propertyRegistry.getProperties().get(index++);
		Property property2 = propertyRegistry.getProperties().get(index++);
		
		// Create layer1: views ={} propInstances={}
		Layer layer1 = createLayer( layer, Arrays.asList(view1), Arrays.asList(property1, property2));
		
		// Checks
		traces.clear();
		// change a property value
		TypeInstance value = layer1.getPropertyInstance(property1);
		// Check the type of the instance
		// We don't know the type as it is set externally in the Property registry.
		if( value instanceof StringInstance)   {
			assertTrue("value is instance of String", value instanceof StringInstance);
			StringInstance stringValue = (StringInstance)value;
			stringValue.setValue("newValue");
		}
		else if( value instanceof BooleanInstance)   {
			BooleanInstance realValue = (BooleanInstance)value;
			realValue.setValue(true);
		}
		
		// What for ?
		layer1.removePropertyInstance(property2);
		
		assertTrue("event sent", traces.size()>0);
		assertSame("event sent", "propertyValueChanged", traces.get(0).name);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#layerAdded(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	@Ignore
	public void testLayerAdded() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#layerRemoved(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	@Ignore
	public void testLayerRemoved() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#layerMoved(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	@Ignore
	public void testLayerMoved() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#layerSet(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	@Ignore
	public void testLayerSet() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#viewAddedToLayer(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	@Ignore
	public void testViewAddedToLayer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#viewRemovedFromLayer(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	@Ignore
	public void testViewRemovedFromLayer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#viewMovedBetweenLayer(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	@Ignore
	public void testViewMovedBetweenLayer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#diagramViewAdded(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	@Ignore
	public void testDiagramViewAdded() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#diagramViewRemoved(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	@Ignore
	public void testDiagramViewRemoved() {
		fail("Not yet implemented");
	}

	/**
	 * Create a layer with the specified view and property set
	 * 
	 * @param asList
	 * @param asList2
	 * @return
	 * @throws LayersException 
	 */
	protected Layer createLayer(LayerOperator parent, List<View> views, List<Property> properties) throws LayersException {
	
		// Create the layer
		Layer layer = LayersFactory.eINSTANCE.createLayer();
		// Set the application (needed ?)
		layer.setApplication(parent.getApplication());
		// Attach it to its parent
		parent.getLayers().add(layer);
		
		
		// Add views
		for( View view : views) {
			layer.getViews().add(view);
		}
		
		// Add property instances
		for(Property property : properties) {
			layer.addPropertyInstance(property);
		}
		return layer;
	}

	/**
	 * Test method for {@link #createLayer(List, List)}
	 * @throws LayersException 
	 */
	@Test
	public void testCreateLayer() throws LayersException {
		
		// Create requested objects
		TopLayerOperator layerParent = LayersFactory.eINSTANCE.createTopLayerOperator();
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		layerParent.setApplication(application);
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();
	
		// Create Views
		View view1 = NotationFactory.eINSTANCE.createShape();
		View view2 = NotationFactory.eINSTANCE.createShape();
		View view3 = NotationFactory.eINSTANCE.createShape();
		
		// Create Properties
		int index = 0;
		Property property1 = propertyRegistry.getProperties().get(index++);
		Property property2 = propertyRegistry.getProperties().get(index++);
		Property property3 = propertyRegistry.getProperties().get(index++);
		
		// Create layer1: views ={} propInstances={}
		Layer layer = createLayer( layerParent, Arrays.asList(view1, view2), Arrays.asList(property1, property2));
		
		// Checks
		assertNotNull("layer created", layer);
		assertSame("views added", 2, layer.getViews().size());
		
		assertSame("property instance added", 2, layer.getPropertyValueMap().values().size());
		assertSame("property instance is correctly set", layer.getPropertyValueMap().get(property1.getName()), layer.getPropertyInstance(property1));
		assertSame("property instance is correctly set", layer.getPropertyValueMap().get(property2.getName()), layer.getPropertyInstance(property2));
	}

}
