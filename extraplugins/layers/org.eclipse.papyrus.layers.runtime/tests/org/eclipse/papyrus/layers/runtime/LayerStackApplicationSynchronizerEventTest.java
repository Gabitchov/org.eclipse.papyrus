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

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.layers.runtime.model.LayersModel;
import org.eclipse.papyrus.layers.runtime.utils.TriggeredEventTraces;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class LayerStackApplicationSynchronizerEventTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayerStackApplicationSynchronizer#LayerStackApplicationSynchronizer(org.eclipse.papyrus.layers.runtime.model.LayersModel, org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel)}.
	 */
	@Test
	public void testDispose() {

		NotationModel notationModel = (NotationModel)modelSet.getModel(NotationModel.MODEL_ID);
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);

		LayerStackApplicationSynchronizer synchronizer = new LayerStackApplicationSynchronizer(layersModel, notationModel);
		assertNotNull("application created", synchronizer.getLayersModel());
		
		// Try to dispose
		synchronizer.dispose();
		assertNull("object is disposed", synchronizer.getLayersModel());
	}

	/**
	 * Test Layer added event correctly catched
	 */
	@Test
	public void testLayerAddedEventListener() {

		NotationModel notationModel = (NotationModel)modelSet.getModel(NotationModel.MODEL_ID);
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);

		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		notationModel.addDiagram(diagram);
		// Create a helper used to attach a LayerStack to diagram.
		NotationDiagramHelper helper = new NotationDiagramHelper(layersModel, diagram);
		
		// Create the synchronizer
		TriggeredEventTraces traces = new TriggeredEventTraces();
		LayerStackApplicationSynchronizer synchronizer = new LayerStackApplicationSynchronizerSubclass(layersModel, notationModel, traces);

	    // Add a layer Stack to the diagram
		helper.attachLayersStack();
		
		// Check if the appropriate method is called
		assertEquals("event catched", "layerStackAdded", traces.get(0).name);
		assertTrue("event catched", traces.contains("layerStackAdded"));
		
		// dispose
		synchronizer.dispose();
	}

	/**
	 * Test Layer added event correctly catched
	 */
	@Test
	public void testLayerRemovedEventListener() {

		NotationModel notationModel = (NotationModel)modelSet.getModel(NotationModel.MODEL_ID);
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);

		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		notationModel.addDiagram(diagram);
		// Create a helper used to attach a LayerStack to diagram.
		NotationDiagramHelper helper = new NotationDiagramHelper(layersModel, diagram);
		
		// Create the synchronizer
		TriggeredEventTraces traces = new TriggeredEventTraces();
		LayerStackApplicationSynchronizer synchronizer = new LayerStackApplicationSynchronizerSubclass(layersModel, notationModel, traces);

	    // Add a layer Stack to the diagram
		helper.attachLayersStack();
		
		traces.clear();
		helper.removeLayersStack();
		
		// Check if the appropriate method is called
		assertTrue("event catched", traces.contains("layerStackRemoved"));

		// dispose
		synchronizer.dispose();
	}

	/**
	 * Test Layer added event correctly catched
	 */
	@Test
	public void testDiagramRemovedEventListener() {

		NotationModel notationModel = (NotationModel)modelSet.getModel(NotationModel.MODEL_ID);
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);

		// Create a diagram
		Diagram diagram1 = NotationFactory.eINSTANCE.createDiagram();
		notationModel.addDiagram(diagram1);
		// Create a helper used to attach a LayerStack to diagram.
		NotationDiagramHelper helperForDiag1 = new NotationDiagramHelper(layersModel, diagram1);
		
		// Create a diagram
		Diagram diagram2 = NotationFactory.eINSTANCE.createDiagram();
		notationModel.addDiagram(diagram2);
		// Create a helper used to attach a LayerStack to diagram.
		NotationDiagramHelper helperForDiag2 = new NotationDiagramHelper(layersModel, diagram2);
		
		// Create the synchronizer
		TriggeredEventTraces traces = new TriggeredEventTraces();
		LayerStackApplicationSynchronizer synchronizer = new LayerStackApplicationSynchronizerSubclass(layersModel, notationModel, traces);

	    // Add a layer Stack to the diagram
		helperForDiag1.attachLayersStack();
		helperForDiag2.attachLayersStack();
		
		// Try to remove a diagram
		traces.clear();
		notationModel.getResource().getContents().remove(diagram2);
		
		
		// Check if the appropriate method is called
		assertTrue("event catched", traces.contains("diagramRemoved"));
		assertEquals("number of events", 1, traces.traces.size());
		assertEquals("diagram found in notification", diagram2, traces.traces.get(0).notifier.getOldValue());

		// dispose
		synchronizer.dispose();
	}


}
