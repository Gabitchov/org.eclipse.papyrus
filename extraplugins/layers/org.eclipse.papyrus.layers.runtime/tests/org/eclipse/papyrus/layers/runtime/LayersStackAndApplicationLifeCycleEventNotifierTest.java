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
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author dumoulin
 *
 */
public class LayersStackAndApplicationLifeCycleEventNotifierTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersStackAndApplicationLifeCycleEventNotifier#LayersStackAndApplicationLifeCycleEventNotifier(org.eclipse.papyrus.layers.runtime.model.LayersModel)}.
	 */
	@Test
	public void testLayersStackAndApplicationLifeCycleEventNotifier() {
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);

		LayersStackAndApplicationLifeCycleEventNotifier notifier = new LayersStackAndApplicationLifeCycleEventNotifier(layersModel);
		assertNotNull("application created", notifier);

		// dispose
		notifier.dispose();
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersStackAndApplicationLifeCycleEventNotifier#dispose()}.
	 */
	@Test
	public void testDispose() {
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);

		LayersStackAndApplicationLifeCycleEventNotifier synchronizer = new LayersStackAndApplicationLifeCycleEventNotifier(layersModel);
		assertFalse("application created", synchronizer.isDisposed());
		
		// Try to dispose
		synchronizer.dispose();
		assertTrue("object is disposed", synchronizer.isDisposed());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersStackAndApplicationLifeCycleEventNotifier#isDisposed()}.
	 */
	@Test
	public void testIsDisposed() {
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);

		LayersStackAndApplicationLifeCycleEventNotifier synchronizer = new LayersStackAndApplicationLifeCycleEventNotifier(layersModel);
		assertFalse("application created", synchronizer.isDisposed());
		
		// Try to dispose
		synchronizer.dispose();
		assertTrue("object is disposed", synchronizer.isDisposed());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersStackAndApplicationLifeCycleEventNotifier#addLayersModelEventListener(org.eclipse.papyrus.layers.runtime.ILayersStackApplicationEventListener)}.
	 */
	@Test
	@Ignore
	public void testAddLayersModelEventListener() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersStackAndApplicationLifeCycleEventNotifier#removeLayersModelEventListener(org.eclipse.papyrus.layers.runtime.ILayersStackApplicationEventListener)}.
	 */
	@Test
	@Ignore
	public void testRemoveLayersModelEventListener() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersStackAndApplicationLifeCycleEventNotifier#addLayersStackApplicationLifeCycleEventListener(org.eclipse.papyrus.layers.runtime.model.ILayersModelRootEventListener)}.
	 */
	@Test
	@Ignore
	public void testAddLayersStackApplicationLifeCycleEventListener() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersStackAndApplicationLifeCycleEventNotifier#removeLayersStackApplicationLifeCycleEventListener(org.eclipse.papyrus.layers.runtime.model.ILayersModelRootEventListener)}.
	 */
	@Test
	@Ignore
	public void testRemoveLayersStackApplicationLifeCycleEventListener() {
		fail("Not yet implemented");
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
		LayersStackAndApplicationLifeCycleEventNotifier notifier = new LayersStackAndApplicationLifeCycleEventNotifier(layersModel);
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
		LayersStackAndApplicationLifeCycleEventNotifier notifier = new LayersStackAndApplicationLifeCycleEventNotifier(layersModel);
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
