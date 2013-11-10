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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
 * @author dumoulin
 *
 */
public class LayersStackApplicationEventNotifierTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersStackApplicationEventNotifier#LayersStackApplicationEventNotifier(org.eclipse.papyrus.layers.runtime.model.LayersModel)}.
	 */
	@Test
	public void testLayersStackApplicationEventNotifier() {
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);

		LayersStackApplicationEventNotifier notifier = new LayersStackApplicationEventNotifier(layersModel);
		assertNotNull("application created", notifier);

		// dispose
		notifier.dispose();
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersStackApplicationEventNotifier#dispose()}.
	 */
	@Test
	public void testDispose() {
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);

		LayersStackApplicationEventNotifier synchronizer = new LayersStackApplicationEventNotifier(layersModel);
		assertFalse("application created", synchronizer.isDisposed());
		
		// Try to dispose
		synchronizer.dispose();
		assertTrue("object is disposed", synchronizer.isDisposed());
	}

	/**
	 * Test Layer added event correctly catched
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersStackApplicationEventNotifier#layerStackAdded(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testLayerStackAdded() {
		NotationModel notationModel = (NotationModel)modelSet.getModel(NotationModel.MODEL_ID);
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);

		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		notationModel.addDiagram(diagram);
		// Create a helper used to attach a LayerStack to diagram.
		NotationDiagramHelper helper = new NotationDiagramHelper(layersModel, diagram);
		
		// Create the notifier
		TraceLayersStackApplicationEventListener traces = new TraceLayersStackApplicationEventListener();
		LayersStackApplicationEventNotifier notifier = new LayersStackApplicationEventNotifier(layersModel);
		notifier.addLayersModelEventListener(traces);
		
	    // Add a layer Stack to the diagram
		helper.attachLayersStack();
		
		// Check if the appropriate method is called
		assertTrue("event catched", traces.traces.contains("layerStackAdded"));
		
		// dispose
		notifier.dispose();
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersStackApplicationEventNotifier#layerStackRemoved(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testLayerStackRemoved() {
		NotationModel notationModel = (NotationModel)modelSet.getModel(NotationModel.MODEL_ID);
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);

		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		notationModel.addDiagram(diagram);
		// Create a helper used to attach a LayerStack to diagram.
		NotationDiagramHelper helper = new NotationDiagramHelper(layersModel, diagram);
		
		// Create the notifier
		TraceLayersStackApplicationEventListener traces = new TraceLayersStackApplicationEventListener();
		LayersStackApplicationEventNotifier notifier = new LayersStackApplicationEventNotifier(layersModel);
		notifier.addLayersModelEventListener(traces);
		
	    // Add a layer Stack to the diagram
		helper.attachLayersStack();
		
		traces.traces.clear();
		helper.removeLayersStack();
		
		// Check if the appropriate method is called
		assertTrue("event catched", traces.traces.contains("layerStackRemoved"));

		// dispose
		notifier.dispose();
	}

}
