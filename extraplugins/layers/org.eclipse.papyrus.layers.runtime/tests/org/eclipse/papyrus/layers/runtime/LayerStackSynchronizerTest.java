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
package org.eclipse.papyrus.layers.runtime;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/**
 * @author dumoulin
 *
 */
public class LayerStackSynchronizerTest {

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
	 */
	@Test
	public void testLayerStackSynchronizer() {
		// Create a fake structure
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		LayersStack stack = LayersFactory.eINSTANCE.createLayersStack();
		stack.setDiagram(diagram);
		

		// Create the stack
		LayerStackSynchronizer synchronizer = new LayerStackSynchronizer(stack);
		
		// Check creation
		assertNotNull("object created", synchronizer);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#getDiagram()}.
	 */
	@Test
	public void testGetDiagram() {
		// Create a fake structure
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		LayersStack stack = LayersFactory.eINSTANCE.createLayersStack();
		stack.setDiagram(diagram);
		

		// Create the stack
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
		// Create a fake structure
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		LayersStack stack = LayersFactory.eINSTANCE.createLayersStack();
		stack.setDiagram(diagram);
		

		// Create the stack
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
	 */
	@Test
	@Ignore
	public void testPropertyValueAdded() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#propertyValueRemoved(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	@Ignore
	public void testPropertyValueRemoved() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackSynchronizer#propertyValueChanged(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	@Ignore
	public void testPropertyValueChanged() {
		fail("Not yet implemented");
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

}
