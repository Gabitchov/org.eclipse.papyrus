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

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.layers.runtime.model.LayersModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Tests for the {@link LayerStackApplicationSynchronizer} class.
 * This tests do not tests event received when models are modified.
 * This tests tests method behavior when they are called directly.
 * 
 * @author cedric dumoulin
 *
 */
public class LayerStackApplicationSynchronizerTest {

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
		// Create ModelSet and Model
		ModelSet mngr = new ModelSet();
		// LayersModel
		LayersModel layersModel = new LayersModel();
		mngr.registerModel(layersModel);
		// Notation model
		NotationModel notationModel = new NotationModel();
		mngr.registerModel(notationModel);
		// Do create resources
		URI uri = URI.createPlatformResourceURI(PROJECT_MODEL_URI, true);
		mngr.createModels(uri);
		
		modelSet = mngr;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		modelSet.unload();
		
	}

	/**
	 * Test the correct creation of the modelSet
	 */
	@Test
	public void testModelSetCreation() {

		NotationModel notationModel = (NotationModel)modelSet.getModel(NotationModel.MODEL_ID);
		assertNotNull("NotationModel is created", notationModel);
		// Try to create a Diagram
		notationModel.addDiagram(NotationFactory.eINSTANCE.createDiagram());
		// 
		assertNotNull("Diagram is in the roots", notationModel.getResource().getContents().get(0));
		
		
		
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);
		assertNotNull("LayerModel is created", layersModel);
		assertNotNull("LayerStackApplication is created", layersModel.getLayerStackApplication());

		
	}
	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackApplicationSynchronizer#LayerStackApplicationSynchronizer(org.eclipse.papyrus.layers.runtime.model.LayersModel, org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel)}.
	 */
	@Test
	public void testLayerStackApplicationSynchronizer() {
		NotationModel notationModel = (NotationModel)modelSet.getModel(NotationModel.MODEL_ID);
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);

		LayerStackApplicationSynchronizer synchronizer = new LayerStackApplicationSynchronizer(layersModel, notationModel);
		assertNotNull("application created", synchronizer);

		// dispose
		synchronizer.dispose();
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackApplicationSynchronizer#getLayersModel()}.
	 */
	@Test
	public void testGetLayersModel() {
		NotationModel notationModel = (NotationModel)modelSet.getModel(NotationModel.MODEL_ID);
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);

		LayerStackApplicationSynchronizer synchronizer = new LayerStackApplicationSynchronizer(layersModel, notationModel);
		assertNotNull("layers model exist", synchronizer.getLayersModel());
		assertSame("right layer model", layersModel, synchronizer.getLayersModel());

		// dispose
		synchronizer.dispose();
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackApplicationSynchronizer#getNotationModel()}.
	 */
	@Test
	public void testGetNotationModel() {
		NotationModel notationModel = (NotationModel)modelSet.getModel(NotationModel.MODEL_ID);
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);

		LayerStackApplicationSynchronizer synchronizer = new LayerStackApplicationSynchronizer(layersModel, notationModel);
		assertNotNull("layers model exist", synchronizer.getNotationModel());
		assertSame("right layer model", notationModel, synchronizer.getNotationModel());

		// dispose
		synchronizer.dispose();
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackApplicationSynchronizer#dispose()}.
	 */
	@Test
	public void testDispose() {
		NotationModel notationModel = (NotationModel)modelSet.getModel(NotationModel.MODEL_ID);
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);

		LayerStackApplicationSynchronizer synchronizer = new LayerStackApplicationSynchronizer(layersModel, notationModel);
		assertNotNull("application created", synchronizer.getLayersModel());
		
		// Try to dispose
		assertFalse("object is disposed", synchronizer.isDisposed());
		synchronizer.dispose();
		assertTrue("object is disposed", synchronizer.isDisposed());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackApplicationSynchronizer#layerStackAdded(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testLayerStackAdded() {
		NotationModel notationModel = (NotationModel)modelSet.getModel(NotationModel.MODEL_ID);
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);

		// Init models
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		notationModel.addDiagram(diagram);
		// Create a helper used to attach a LayerStack to diagram.
		NotationDiagramHelper helper = new NotationDiagramHelper(layersModel, diagram);

		
		LayerStackApplicationSynchronizer synchronizer = new LayerStackApplicationSynchronizer(layersModel, notationModel);
		assertNotNull("application created", synchronizer);

		// add a LayerStack to models
		// in result, the method should be called
		helper.attachLayersStack();
		
		// Check if the appropriate LayerStackSynchronizer is created
		assertNotNull( "LayerStackSynchronizer added", synchronizer.getSynchronizers().get(diagram));
		
		synchronizer.dispose();
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackApplicationSynchronizer#layerStackRemoved(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testLayerStackRemoved() {
		NotationModel notationModel = (NotationModel)modelSet.getModel(NotationModel.MODEL_ID);
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);

		// Init models
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		notationModel.addDiagram(diagram);
		// Create a helper used to attach a LayerStack to diagram.
		NotationDiagramHelper helper = new NotationDiagramHelper(layersModel, diagram);

		
		LayerStackApplicationSynchronizer synchronizer = new LayerStackApplicationSynchronizer(layersModel, notationModel);
		assertNotNull("application created", synchronizer);

		// add a LayerStack to models
		// in result, the method should be called
		helper.attachLayersStack();
		
		// Check if the appropriate LayerStackSynchronizer is created
		assertNotNull( "LayerStackSynchronizer added", synchronizer.getSynchronizers().get(diagram));
		
		// Remove layer
		helper.removeLayersStack();
		
		assertNull( "LayerStackSynchronizer removed", synchronizer.getSynchronizers().get(diagram));
		
		synchronizer.dispose();
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackApplicationSynchronizer#diagramRemoved(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testDiagramRemoved() {
		NotationModel notationModel = (NotationModel)modelSet.getModel(NotationModel.MODEL_ID);
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);

		// Init models
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		notationModel.addDiagram(diagram);
		// Create a helper used to attach a LayerStack to diagram.
		NotationDiagramHelper helper = new NotationDiagramHelper(layersModel, diagram);

		
		LayerStackApplicationSynchronizer synchronizer = new LayerStackApplicationSynchronizer(layersModel, notationModel);
		assertNotNull("application created", synchronizer);

		// add a LayerStack to models
		// in result, the method should be called
		helper.attachLayersStack();
		
		// Check if the appropriate LayerStackSynchronizer is created
		assertNotNull( "LayerStackSynchronizer added", synchronizer.getSynchronizers().get(diagram));
		
		// Remove diagram
		notationModel.getResource().getContents().remove(diagram);
		
		assertNull( "LayerStackSynchronizer removed", synchronizer.getSynchronizers().get(diagram));
		
		synchronizer.dispose();
	}

	/**
	 * Test {@link LayerStackApplicationSynchronizer} start when an application object
	 * with LayerStack already exist in the LayerModel.
	 * Test if synchronizer are restarted for already existing Stacks.
	 * 
	 */
	@Test
	public void testLayerStackApplicationSynchronizerRestartSynchronizer() {
		NotationModel notationModel = (NotationModel)modelSet.getModel(NotationModel.MODEL_ID);
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);
	
		// Init models
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		notationModel.addDiagram(diagram);
		// Create a helper used to attach a LayerStack to diagram.
		NotationDiagramHelper helper = new NotationDiagramHelper(layersModel, diagram);
	
		
		// create a stack: this also create the application object in model.
		helper.attachLayersStack();
		
		// create synchronizer
		LayerStackApplicationSynchronizer synchronizer = new LayerStackApplicationSynchronizer(layersModel, notationModel);
		assertNotNull("application created", synchronizer);
	

		// Check if the appropriate LayerStackSynchronizer is created
		assertNotNull( "LayerStackSynchronizer created", synchronizer.getSynchronizers().get(diagram));
		
		// Check if we can add new LayerStack
		Diagram diagram2 = NotationFactory.eINSTANCE.createDiagram();
		notationModel.addDiagram(diagram2);
		NotationDiagramHelper helper2 = new NotationDiagramHelper(layersModel, diagram2);
		helper2.attachLayersStack();
		
		// Check if the appropriate LayerStackSynchronizer is created
		assertNotNull( "LayerStackSynchronizer created", synchronizer.getSynchronizers().get(diagram2));
		
		
		synchronizer.dispose();
	}

	/**
	 * Test {@link LayerStackApplicationSynchronizer} start when NO application object
	 * exist in the LayerModel.
	 * Test if synchronizer is correctly started and accept new stack attachment.
	 * 
	 */
	@Test
	public void testLayerStackApplicationSynchronizerStartWithNoApplicationInModel() {
		NotationModel notationModel = (NotationModel)modelSet.getModel(NotationModel.MODEL_ID);
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);
	
		// create synchronizer
		LayerStackApplicationSynchronizer synchronizer = new LayerStackApplicationSynchronizer(layersModel, notationModel);
		assertNotNull("application created", synchronizer);
		// Here, the synchronizer should have not create an application !
		assertNull( "Application is not created in model", layersModel.lookupLayerStackApplication() );
	
		// Create a stack: first the diagram, then an helper, then the stack
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		notationModel.addDiagram(diagram);
		// Create a helper used to attach a LayerStack to diagram.
		NotationDiagramHelper helper = new NotationDiagramHelper(layersModel, diagram);	
		// create a stack: this also create the application object in model.
		helper.attachLayersStack();
		
		// Check if the appropriate LayerStackSynchronizer is created
		assertNotNull( "LayerStackSynchronizer created", synchronizer.getSynchronizers().get(diagram));
		// Here, the application should be created (by the stack creation)
		assertNotNull( "Application is created in model", layersModel.lookupLayerStackApplication() );
		
		
		synchronizer.dispose();
	}


}
