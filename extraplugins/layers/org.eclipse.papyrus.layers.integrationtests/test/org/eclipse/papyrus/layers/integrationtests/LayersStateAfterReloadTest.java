/*****************************************************************************
 * Copyright (c) 2014 Cedric Dumoulin.
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

package org.eclipse.papyrus.layers.integrationtests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.papyrus.infra.core.resource.BadArgumentExcetion;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.integrationtests.editor.DiagramCreator;
import org.eclipse.papyrus.integrationtests.editor.EclipseProject;
import org.eclipse.papyrus.integrationtests.editor.ExecutionException;
import org.eclipse.papyrus.integrationtests.editor.ProgramaticPapyrusEditor;
import org.eclipse.papyrus.layers.runtime.model.LayersModel;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.Layer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerState;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersContainer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactoryForStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer;
import org.eclipse.papyrus.layers.stackmodel.layers.StackedLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.TopLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersFactoryForStackImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/**
 * Tests checking the states of the layers after a reload of the model.
 * The state should normally be "ATTACHED".
 * 
 * @author cedric dumoulin
 *
 */
public class LayersStateAfterReloadTest {

	/**
	 * Name of the plugin that is created.
	 */
	final protected String PLUGIN_PROJECT_NAME = "org.eclipse.papyrus.layers.integrationtests.tests";

	/**
	 * Name of the bundle containing resources to copied.
	 */
	final protected String BUNDLE_NAME = "org.eclipse.papyrus.layers.integrationtests";


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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersFactoryForStackImpl#createLayer(org.eclipse.papyrus.layers.stackmodel.layers.LayersContainer, org.eclipse.papyrus.layers.stackmodel.layers.LayersStack, org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication)}.
	 * @throws LayersException 
	 * @throws ServiceException 
	 * @throws BadArgumentExcetion 
	 * @throws NotFoundException 
	 * @throws ExecutionException 
	 */
	@Test
	public void testReloadLayer() throws LayersException, ServiceException, NotFoundException, BadArgumentExcetion, ExecutionException {
		// Create requested objects
		// Create Editor
		String modelName = "models/modeltestReload";
		String diagramName = "diagram1";
		
		
		EclipseProject eclipseProject = new EclipseProject(PLUGIN_PROJECT_NAME);
		eclipseProject.copyResources(BUNDLE_NAME, modelName+".di", modelName+".notation", modelName+".uml" );

		ProgramaticPapyrusEditor editorHandler = new ProgramaticPapyrusEditor(eclipseProject, modelName);
		DiagramCreator diagramCreator = new DiagramCreator(editorHandler);

		
		// Get the diagram:
		// First the ModelSet, then the NotationModel, then the diagram by its name
		ModelSet modelSet = editorHandler.getServiceRegistry().getService(ModelSet.class);
		NotationModel notationModel = NotationUtils.getNotationModel(modelSet);
		Diagram diagram = notationModel.getDiagram(diagramName );
				
		// Get the LayerStack for the Layer
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);
		LayersStackApplication application = layersModel.getLayerStackApplication();
		LayersStack owningStack = application.lookupLayersStackFor(diagram);
		
		// Recover tree
		TopLayerOperator rootLayer = (TopLayerOperator)owningStack.getLayers();
		Layer layer1 = (Layer)rootLayer.getLayers().get(0);
		
		// Assert
		assertNotNull("stack found in diagram", owningStack);
		assertSame("state attached", LayerState.ATTACHED, owningStack.getState() );
		
		assertNotNull("Layer created", layer1);
		assertSame("state attached", LayerState.ATTACHED, layer1.getState() );
		assertSame("application set", application, layer1.getApplication() );
		assertSame("owningStack set", owningStack, layer1.getOwningLayersStack() );
		assertSame("parent set", rootLayer, layer1.eContainer() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersFactoryForStackImpl#createRegExpLayer(org.eclipse.papyrus.layers.stackmodel.layers.LayersContainer, org.eclipse.papyrus.layers.stackmodel.layers.LayersStack, org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication)}.
	 * @throws LayersException 
	 * @throws ExecutionException 
	 * @throws ServiceException 
	 * @throws BadArgumentExcetion 
	 * @throws NotFoundException 
	 */
	@Test
	public void testReloadRegExpLayer() throws LayersException, ExecutionException, ServiceException, NotFoundException, BadArgumentExcetion {
		// Create requested objects
		// Create Editor
		String modelName = "models/modeltestReload";
		String diagramName = "diagram2";
		
		
		EclipseProject eclipseProject = new EclipseProject(PLUGIN_PROJECT_NAME);
		eclipseProject.copyResources(BUNDLE_NAME, modelName+".di", modelName+".notation", modelName+".uml" );

		ProgramaticPapyrusEditor editorHandler = new ProgramaticPapyrusEditor(eclipseProject, modelName);
		
		// Get the diagram:
		// First the ModelSet, then the NotationModel, then the diagram by its name
		ModelSet modelSet = editorHandler.getServiceRegistry().getService(ModelSet.class);
		NotationModel notationModel = NotationUtils.getNotationModel(modelSet);
		Diagram diagram = notationModel.getDiagram(diagramName );
				
		// Get the LayerStack for the Layer
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);
		LayersStackApplication application = layersModel.getLayerStackApplication();
		LayersStack owningStack = application.lookupLayersStackFor(diagram);
		
		// Recover tree
		TopLayerOperator rootLayer = (TopLayerOperator)owningStack.getLayers();
		RegExpLayer layer1 = (RegExpLayer)rootLayer.getLayers().get(0);
		
		// asserts
		assertNotNull("Layer created", layer1);
		assertSame("state attached", LayerState.ATTACHED, layer1.getState() );
		assertSame("application set", application, layer1.getApplication() );
		assertSame("owningStack set", owningStack, layer1.getOwningLayersStack() );
		assertSame("parent set", rootLayer, layer1.eContainer() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersFactoryForStackImpl#createTopLayerOperator(org.eclipse.papyrus.layers.stackmodel.layers.LayersContainer, org.eclipse.papyrus.layers.stackmodel.layers.LayersStack, org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication)}.
	 * @throws LayersException 
	 * @throws ServiceException 
	 * @throws ExecutionException 
	 * @throws BadArgumentExcetion 
	 * @throws NotFoundException 
	 */
	@Test
	public void testReloadTopLayerOperator() throws LayersException, ServiceException, ExecutionException, NotFoundException, BadArgumentExcetion {
		// Create requested objects
		// Create Editor
		String modelName = "models/modeltestReload";
		String diagramName = "diagram3";
		
		
		EclipseProject eclipseProject = new EclipseProject(PLUGIN_PROJECT_NAME);
		eclipseProject.copyResources(BUNDLE_NAME, modelName+".di", modelName+".notation", modelName+".uml" );

		ProgramaticPapyrusEditor editorHandler = new ProgramaticPapyrusEditor(eclipseProject, modelName);
		
		// Get the diagram:
		// First the ModelSet, then the NotationModel, then the diagram by its name
		ModelSet modelSet = editorHandler.getServiceRegistry().getService(ModelSet.class);
		NotationModel notationModel = NotationUtils.getNotationModel(modelSet);
		Diagram diagram = notationModel.getDiagram(diagramName );
				
		// Get the LayerStack for the Layer
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);
		LayersStackApplication application = layersModel.getLayerStackApplication();
		LayersStack owningStack = application.lookupLayersStackFor(diagram);
		
		// Recover tree
		TopLayerOperator rootLayer = (TopLayerOperator)owningStack.getLayers();
		TopLayerOperator layer1 = (TopLayerOperator)rootLayer.getLayers().get(0);
		
		// asserts
		assertNotNull("Layer created", layer1);
		assertSame("state attached", LayerState.ATTACHED, layer1.getState() );
		assertSame("application set", application, layer1.getApplication() );
		assertSame("owningStack set", owningStack, layer1.getOwningLayersStack() );
		assertSame("parent set", rootLayer, layer1.eContainer() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersFactoryForStackImpl#createStackedLayerOperator(org.eclipse.papyrus.layers.stackmodel.layers.LayersContainer, org.eclipse.papyrus.layers.stackmodel.layers.LayersStack, org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication)}.
	 * @throws LayersException 
	 * @throws ExecutionException 
	 * @throws ServiceException 
	 * @throws BadArgumentExcetion 
	 * @throws NotFoundException 
	 */
	@Test
	public void testCreateStackedLayerOperator() throws LayersException, ExecutionException, ServiceException, NotFoundException, BadArgumentExcetion {
		// Create requested objects
		// Create Editor
		String modelName = "models/modeltestReload";
		String diagramName = "diagram4";
		
		
		EclipseProject eclipseProject = new EclipseProject(PLUGIN_PROJECT_NAME);
		eclipseProject.copyResources(BUNDLE_NAME, modelName+".di", modelName+".notation", modelName+".uml" );

		ProgramaticPapyrusEditor editorHandler = new ProgramaticPapyrusEditor(eclipseProject, modelName);
		
		// Get the diagram:
		// First the ModelSet, then the NotationModel, then the diagram by its name
		ModelSet modelSet = editorHandler.getServiceRegistry().getService(ModelSet.class);
		NotationModel notationModel = NotationUtils.getNotationModel(modelSet);
		Diagram diagram = notationModel.getDiagram(diagramName );
				
		// Get the LayerStack for the Layer
		LayersModel layersModel = (LayersModel)modelSet.getModel(LayersModel.MODEL_ID);
		LayersStackApplication application = layersModel.getLayerStackApplication();
		LayersStack owningStack = application.lookupLayersStackFor(diagram);
		
		// Recover tree
		TopLayerOperator rootLayer = (TopLayerOperator)owningStack.getLayers();
		StackedLayerOperator layer1 = (StackedLayerOperator)rootLayer.getLayers().get(0);
		
		// asserts
		assertNotNull("Layer created", layer1);
		assertSame("state attached", LayerState.ATTACHED, layer1.getState() );
		assertSame("application set", application, layer1.getApplication() );
		assertSame("owningStack set", owningStack, layer1.getOwningLayersStack() );
		assertSame("parent set", rootLayer, layer1.eContainer() );
	}


}
