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

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelsReader;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;


/**
 * This class allows to create a Papyrus Editor programatically.
 * The creation require the name of a project and the name of the model to create.
 * This class is for use in tests.
 * 
 * @author cedric dumoulin
 *
 */
public class ProgramaticPapyrusEditor {

	protected static final String DEFAULT_PROJECT_NAME = "org.eclipse.org.infra.core.defaultproject.integration";
	protected static final String DEFAULT_MODEL_NAME = "papyrusModelForIntegration";
	
    /**
	 * Name of the project that will contains Model
	 */
	protected String projectName = DEFAULT_PROJECT_NAME;
	
	/**
	 * Name of the model to create.
	 */
	protected String modelName = DEFAULT_MODEL_NAME;

	/** The di resource set. */
//	protected ModelSet modelSet;

	/** The file. */
	protected IFile file;

	/** The page. */
	protected IWorkbenchPage page;

	/** The papyrus editor. */
	protected IMultiDiagramEditor papyrusEditor;

	/** The project. */
	protected IProject project;

	/** The root. */
	protected IWorkspaceRoot root;
	
	
	/**
	 * Constructor.
	 *
	 * @param projectName
	 * @param modelName
	 * @throws EditorCreationException If the creation fails.
	 */
	public ProgramaticPapyrusEditor(String projectName, String modelName) throws EditorCreationException {
		this.projectName = projectName;
		this.modelName = modelName;
		
		// Create editor
		createEditor();
	}


	/**
	 * 
	 * Constructor.
	 * @throws EditorCreationException If the creation fails.
	 *
	 */
	public ProgramaticPapyrusEditor() throws EditorCreationException {
		// Create editor
		createEditor();
	}


	/**
	 * Create a model suitable for Papyrus uml.
	 * Save it in the provided file.
	 * @param file
	 * @throws CoreException
	 * @throws IOException 
	 */
	protected void createModel(IFile file) throws CoreException, IOException {
		
		// Create ModelSet and initialize it with models declared in eclipse extensions
		ModelSet modelSet = new ModelSet();
		ModelsReader reader = new ModelsReader();
		reader.readModel(modelSet);

		file.create(new ByteArrayInputStream(new byte[0]), true, new NullProgressMonitor());
		modelSet.createsModels(file);
		// populate the model
		UmlModel umlModel = UmlUtils.getUmlModel(modelSet);
		umlModel.initializeEmptyModel();
		
		//	ICreationCommand command = getDiagramCommandCreation();
		//	command.createDiagram(modelSet, null, "DiagramToTest");
		modelSet.save(new NullProgressMonitor());
		
	}
	/**
	 * Create a papyrus editor.
	 * @return 
	 * @throws EditorCreationException 
	 */
	protected IMultiDiagramEditor createEditor() throws EditorCreationException {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		root = workspace.getRoot();
		project = root.getProject(projectName);
		file = project.getFile(modelName + ".di");

			try {
				//at this point, no resources have been created
				if(!project.exists()) {
					project.create(null);
				}
				if(!project.isOpen()) {
					project.open(null);
				}

				if(file.exists()) {
					file.delete(true, new NullProgressMonitor());
				}

				if(!file.exists()) {
					// Create the model
					createModel(file);
				}
				
				// Create the editor
				page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
				papyrusEditor = (IMultiDiagramEditor)page.openEditor(new FileEditorInput(file), desc.getId());
				return papyrusEditor;
			} catch (PartInitException e) {
				e.printStackTrace();
				throw new EditorCreationException("Can't create editor", e);
			} catch (CoreException e) {
				throw new EditorCreationException("Can't create editor", e);
			} catch (IOException e) {
				throw new EditorCreationException("Can't create editor", e);
			}

	}
	
	/**
	 * Dispose the editor.
	 */
	public void dispose() {
		
		if(papyrusEditor == null) {
			return;
		}
		
		// Save model, to avoid popup
		papyrusEditor.doSave(new NullProgressMonitor());
		papyrusEditor = null;
		
		// Dispose done from closeAllEditors ?
//		papyrusEditor.dispose();
		page.closeAllEditors(true);
		try {
			project.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 * @return
	 */
	public IMultiDiagramEditor getEditor() {
		return papyrusEditor;
	}
	
	/**
	 * Get the {@link ServicesRegistry} associated to the editor.
	 * @return The service registry.
	 */
	public ServicesRegistry getServiceRegistry() {
		return papyrusEditor.getServicesRegistry();
	}


	/**
	 * Cached value of modelSet.
	 */
	private ModelSet modelSet;
	public ModelSet getModelSet() throws ServiceException {
		if(modelSet == null) {
			modelSet = papyrusEditor.getServicesRegistry().getService(ModelSet.class);
		}
		return modelSet;
	}
	
	public void undo() throws ServiceException {
		TransactionalEditingDomain domain = getServiceRegistry().getService(TransactionalEditingDomain.class);
		
		if(domain.getCommandStack().canUndo()) {
			domain.getCommandStack().undo();
		}
	}
	
	public void redo() throws ServiceException {
		TransactionalEditingDomain domain = getServiceRegistry().getService(TransactionalEditingDomain.class);
		
		if(domain.getCommandStack().canRedo()) {
			domain.getCommandStack().redo();
		}
		
	}
	
	public IOperationHistory getIOperationHistory() {
		return papyrusEditor.getSite().getWorkbenchWindow().getWorkbench().getOperationSupport().getOperationHistory();
	}
}
