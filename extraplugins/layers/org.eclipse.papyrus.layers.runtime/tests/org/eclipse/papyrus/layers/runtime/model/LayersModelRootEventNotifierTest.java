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
package org.eclipse.papyrus.layers.runtime.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/**
 * @author dumoulin
 *
 */
public class LayersModelRootEventNotifierTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventRootNotifier#LayersModelEventRootNotifier(org.eclipse.gmf.runtime.notation.Diagram)}.
	 */
	@Test
	public void testLayersModelEventRootNotifier() {
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);
		LayersModelEventRootNotifier notifier = new LayersModelEventRootNotifier(layersModel);
		
		
		assertNotNull("notifier created", notifier);

		// dispose
		notifier.dispose();
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventRootNotifier#dispose()}.
	 */
	@Test
	public void testDispose() {
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);
		LayersModelEventRootNotifier notifier = new LayersModelEventRootNotifier(layersModel);

		assertNotNull("notifier created", notifier);

		// dispose
		assertFalse("notifier is disposed", notifier.isDisposed());
		notifier.dispose();
		assertTrue("notifier is disposed", notifier.isDisposed());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventRootNotifier#addEventListener(org.eclipse.papyrus.layers.runtime.ILayersModelEventRootListener)}.
	 */
	@Test
	@Ignore
	public void testAddEventListener() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.LayersModelEventRootNotifier#removeEventListener(org.eclipse.papyrus.layers.runtime.ILayersModelEventRootListener)}.
	 */
	@Test
	@Ignore
	public void testRemoveEventListener() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link LayersModelEventRootNotifier#fireLayersModelRootAddedEvent(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testFireLayersModelRootAddedEvent() {
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);
		LayersModelEventRootNotifier notifier = new LayersModelEventRootNotifier(layersModel);
		
		TraceLayersModelRootEventListener listener = new TraceLayersModelRootEventListener();
		notifier.addEventListener(listener);
		
		// Add root
		@SuppressWarnings("unused")
		LayersStackApplication application = layersModel.getLayerStackApplication();
		
		// Check for event
		assertTrue("event sent", listener.traces.size() > 0);
		assertEquals("event found", "layersModelRootAdded", listener.traces.get(0).name);
		
		
	}

	/**
	 * Test method for {@link LayersModelEventRootNotifier#fireLayersModelRootRemovedEvent(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testFireLayersModelRootRemovedEvent() {
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);
		LayersModelEventRootNotifier notifier = new LayersModelEventRootNotifier(layersModel);
		
		TraceLayersModelRootEventListener listener = new TraceLayersModelRootEventListener();
		notifier.addEventListener(listener);
		
		// Add root
		LayersStackApplication application = layersModel.getLayerStackApplication();
		
		// Check remove
		listener.traces.clear();
		layersModel.removeRoot(application);
		assertTrue("event sent", listener.traces.size() > 0);
		assertEquals("event found", "layersModelRootRemoved", listener.traces.get(0).name);
	}

}
