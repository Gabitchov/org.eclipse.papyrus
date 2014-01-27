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

package org.eclipse.papyrus.integrationtests.editor;

import static org.junit.Assert.*;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.BadArgumentExcetion;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Test for the utility class {@link ProgramaticPapyrusEditor}
 * 
 * @author cedric dumoulin
 *
 */
public class ProgramaticPapyrusEditorTest {

	/**
	 * Name of the plugin that is created.
	 */
	final protected String PLUGIN_PROJECT_NAME = "org.eclipse.papyrus.integrationtests.editor.tests";

	/**
	 * Name of the bundle containing resources to copied.
	 */
	final protected String BUNDLE_NAME = "org.eclipse.papyrus.integrationtests.editor";


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
	 * Test method for {@link org.eclipse.papyrus.integrationtests.editor.ProgramaticPapyrusEditor#createEditor()}.
	 * @throws ExecutionException 
	 */
	@Test
	public void testCreateEditor() throws ExecutionException {
		ProgramaticPapyrusEditor editorHandler = new ProgramaticPapyrusEditor();
		IMultiDiagramEditor editor = editorHandler.getEditor();
		
		assertNotNull("editor created", editor);
		editorHandler.dispose();
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.integrationtests.editor.ProgramaticPapyrusEditor#dispose()}.
	 * @throws ExecutionException 
	 */
	@Test
	public void testDispose() throws ExecutionException {
		ProgramaticPapyrusEditor editorHandler = new ProgramaticPapyrusEditor();
		IMultiDiagramEditor editor = editorHandler.getEditor();
		
		assertNotNull("editor created", editor);
		// Try to dispose
		editorHandler.dispose();
		assertNull("editor cleaned", editorHandler.getEditor());		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.integrationtests.editor.ProgramaticPapyrusEditor#getEditor()}.
	 * @throws ExecutionException 
	 */
	@Test
	public void testGetEditor() throws ExecutionException {
		ProgramaticPapyrusEditor editorHandler = new ProgramaticPapyrusEditor();
		IMultiDiagramEditor editor = editorHandler.getEditor();
		
		assertNotNull("editor created", editor);
		
		editorHandler.dispose();
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.integrationtests.editor.ProgramaticPapyrusEditor#getServiceRegistry()}.
	 * @throws ExecutionException 
	 */
	@Test
	public void testGetServiceRegistry() throws ExecutionException {
		ProgramaticPapyrusEditor editorHandler = new ProgramaticPapyrusEditor();
		IMultiDiagramEditor editor = editorHandler.getEditor();
		
		assertNotNull("editor created", editor);
		
		// Try to get the Registry
		ServicesRegistry servicesRegistry = editorHandler.getServiceRegistry();
		assertNotNull("registry initialized", servicesRegistry);

		editorHandler.dispose();
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.integrationtests.editor.ProgramaticPapyrusEditor#getEditor()}.
	 * @throws ServiceException 
	 * @throws BadArgumentExcetion 
	 * @throws NotFoundException 
	 * @throws ExecutionException 
	 */
	@Test
	public void testGetEditorAndLoadModel() throws ServiceException, NotFoundException, BadArgumentExcetion, ExecutionException {
		
		String modelName = "models/modelTestLoadModel";
//		String modelName = "modelTestLoadModel";
		String diagramName = "diagram1";
		EclipseProject eclipseProject = new EclipseProject(PLUGIN_PROJECT_NAME);
		eclipseProject.copyResources(BUNDLE_NAME, modelName+".di", modelName+".notation", modelName+".uml" );
		
		ProgramaticPapyrusEditor editorHandler = new ProgramaticPapyrusEditor(eclipseProject, modelName);
		IMultiDiagramEditor editor = editorHandler.getEditor();
		
		assertNotNull("editor created", editor);
		
		NotationModel notationModel = (NotationModel)editorHandler.getModelSet().getModel(NotationModel.MODEL_ID);
		assertNotNull("notation model loaded", notationModel);
		
		// If the following assertion is false, this means that the model is not loaded from file (it has been created)
		Diagram diagram = notationModel.getDiagram(diagramName);
		assertNotNull("diagram loaded", diagram);
		
		editorHandler.dispose();
	}


}
