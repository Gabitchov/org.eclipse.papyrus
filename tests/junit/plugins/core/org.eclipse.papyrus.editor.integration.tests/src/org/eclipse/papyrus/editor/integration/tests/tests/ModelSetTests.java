/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.editor.integration.tests.tests;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.editor.integration.tests.Activator;
import org.eclipse.papyrus.infra.core.extension.commands.IModelCreationCommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.DiResourceSet;
import org.eclipse.papyrus.junit.utils.EditorUtils;
import org.eclipse.papyrus.uml.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.uml.diagram.clazz.UmlClassDiagramForMultiEditor;
import org.eclipse.papyrus.uml.diagram.common.commands.CreateUMLModelCommand;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test case for handling models with special characters in their name/path
 * 
 * @author Camille Letavernier
 * 
 */
public class ModelSetTests extends AbstractEditorIntegrationTest {

	public static final String SOURCE_PATH = "/model/model set/";

	@Test
	public void testOpenModelWithSpecialChars() throws Exception {
		System.out.println("Begin");
		initModel("openSpecialChars", "^&_&^", getBundle());
		IPageManager pageManager = getPageManager();
		Assert.assertEquals("Some pages cannot be found", 3, pageManager.allPages().size());

		UmlModel umlModel = (UmlModel)getModelSet().getModel(UmlModel.MODEL_ID);
		Model rootModel = (Model)umlModel.lookupRoot();
		Assert.assertEquals("The UML Model has not been correctly loaded", 3, rootModel.getOwnedElements().size());
	}

	@Test
	public void testCreateModelWithSpecialChars() throws Exception {
		ModelSet modelSet = new DiResourceSet();
		IProject emptyModelCreationProject = ResourcesPlugin.getWorkspace().getRoot().getProject("diagramCreationWithSpecialChars");
		emptyModelCreationProject.create(new NullProgressMonitor());
		emptyModelCreationProject.open(new NullProgressMonitor());

		String modelName = "++nëw môdèl & spécîâl chàr$++";

		final IFile emptyModelDi = emptyModelCreationProject.getFile(modelName + ".di");

		modelSet.createsModels(emptyModelDi);

		IFile emptyModelNotation = emptyModelCreationProject.getFile(modelName + ".notation");
		IFile emptyModelUml = emptyModelCreationProject.getFile(modelName + ".uml");

		ServicesRegistry registry = new ExtensionServicesRegistry(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);
		try {
			registry.add(ModelSet.class, Integer.MAX_VALUE, modelSet);
			registry.startRegistry();
		} catch (ServiceException ex) {
			//Ignore
		}

		IModelCreationCommand creationCommand = new CreateUMLModelCommand();
		creationCommand.createModel(modelSet);

		//Create the root UML Model
		UmlModel umlModel = (UmlModel)modelSet.getModel(UmlModel.MODEL_ID);
		Model model = (Model)umlModel.lookupRoot();

		//Creates and opens a Papyrus Class Diagram
		ICreationCommand diagramCreationCommand = new CreateClassDiagramCommand();
		diagramCreationCommand.createDiagram(modelSet, model, modelName);

		modelSet.save(new NullProgressMonitor());

		Assert.assertTrue("The DI file has not been created", emptyModelDi.exists());
		Assert.assertTrue("The Notation file has not been created", emptyModelNotation.exists());
		Assert.assertTrue("The UML file has not been created", emptyModelUml.exists());

		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				try {
					editor = EditorUtils.openPapyrusEditor(emptyModelDi);
				} catch (Exception ex) {
					Activator.log.error(ex);
					Assert.fail(ex.getMessage());
				}
			}
		});

		Assert.assertNotNull("Cannot open the Papyrus editor", editor);
		Assert.assertTrue("The active editor should be a Papyrus Class Diagram editor", editor.getActiveEditor() instanceof UmlClassDiagramForMultiEditor);

		try {
			registry.disposeRegistry();
		} catch (ServiceException ex) {
			//Ignore
		}

	}

	@Override
	protected String getSourcePath() {
		return SOURCE_PATH;
	}
}
