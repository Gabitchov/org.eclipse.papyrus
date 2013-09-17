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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.layers.runtime.model.LayersModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class NotationDiagramMngrTest {

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
		LayersModel layersModel = new LayersModel();
		mngr.registerModel(layersModel);
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
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.NotationDiagramHelper#NotationDiagramMngr(org.eclipse.gmf.runtime.notation.Diagram)}.
	 */
	@Test
	public void testNotationDiagramHelper() {

		// Create a Diagram
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		// Get LayersModel
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);

		// Check creation
		NotationDiagramHelper diagramHelper = new NotationDiagramHelper(layersModel, diagram);
		assertNotNull("ManagerCreated", diagramHelper);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.NotationDiagramHelper#dispose()}.
	 */
	@Test
	public void testDispose() {
		// Create a Diagram
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		// Get LayersModel
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);


		// Create mngr
		NotationDiagramHelper diagramHelper = new NotationDiagramHelper(layersModel, diagram);

		// Do dispose
		diagramHelper.dispose();
		// Check disposal
		assertNull( "disposed", diagramHelper.getDiagram());
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.NotationDiagramHelper#getDiagram()}.
	 */
	@Test
	public void testGetDiagram() {
		// Create a Diagram
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		// Get LayersModel
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);


		// Create mngr
		NotationDiagramHelper diagramHelper = new NotationDiagramHelper(layersModel, diagram);

		// check
	    assertNotNull("getDiagram", diagramHelper.getDiagram());
	    assertSame("getDiagram", diagram, diagramHelper.getDiagram());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.NotationDiagramHelper#attachLayerStack()}.
	 */
	@Test
	public void testAttachLayerStack() {
		// Create a Diagram
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		// Get LayersModel
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);


		// Create mngr
		NotationDiagramHelper diagramHelper = new NotationDiagramHelper(layersModel, diagram);
		
		diagramHelper.attachLayersStack();
		
		assertTrue("LayerStack is attached to diagram", diagramHelper.isLayersStackAttached() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.NotationDiagramHelper#removeLayerStack()}.
	 */
	@Test
	public void testRemoveLayerStack() {
		// Create a Diagram
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		// Get LayersModel
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);


		// Create mngr
		NotationDiagramHelper diagramHelper = new NotationDiagramHelper(layersModel, diagram);
		
		diagramHelper.attachLayersStack();
		assertTrue("LayerStack is attached to diagram", diagramHelper.isLayersStackAttached() );

		// Try to remove LayerStack
		diagramHelper.removeLayersStack();	
		assertFalse("LayerStack is detached from diagram", diagramHelper.isLayersStackAttached() );
		
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.NotationDiagramHelper#isLayerStackAttached()}.
	 */
	@Test
	public void testIsLayerStackAttached() {
		// Create a Diagram
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		// Get LayersModel
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);


		// Create mngr
		NotationDiagramHelper diagramHelper = new NotationDiagramHelper(layersModel, diagram);
	}

}
