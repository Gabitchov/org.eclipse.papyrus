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
package org.eclipse.papyrus.junit.utils.tests;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.junit.utils.Activator;
import org.eclipse.papyrus.junit.utils.EditorUtils;
import org.eclipse.papyrus.junit.utils.ModelExplorerUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.uml2.uml.Model;
import org.junit.After;
import org.junit.Assert;
import org.osgi.framework.Bundle;


public abstract class AbstractEditorTest {

	protected IMultiDiagramEditor editor;

	protected IProject project;

	protected static ModelExplorerView view;
	
	protected static Model rootModel;
	/**
	 * 
	 * @return
	 *         the current bundle
	 */
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	/**
	 * Inits this.editor
	 * Fails or throws an exception if an error occurs
	 * 
	 * @param bundle
	 *        the bundle to use to create the project and init the model
	 */
	protected void initModel(String projectName, String modelName, final  Bundle bundle) throws Exception {
		ProjectUtils.removeAllProjectFromTheWorkspace();
		IProject testProject = ProjectUtils.createProject(projectName);
		final IFile file = PapyrusProjectUtils.copyPapyrusModel(testProject, bundle, getSourcePath(), modelName);
		RunnableWithResult<?> runnableWithResult = new RunnableWithResult.Impl<Object>() {

			
			public void run() {
				try {
					editor = EditorUtils.openPapyrusEditor(file);
				} catch (PartInitException e) {
					setStatus(new Status(IStatus.ERROR, bundle.getSymbolicName(), e.getMessage()));
				}
				try {
					AbstractEditorTest.view = ModelExplorerUtils.openModelExplorerView();
				} catch (PartInitException e) {
					setStatus(new Status(IStatus.ERROR, bundle.getSymbolicName(), e.getMessage()));
				}
				EObject root = ModelExplorerUtils.getRootInModelExplorer(AbstractEditorTest.view);
				rootModel = (Model)root;
				
				if(rootModel != null) {
					setStatus(Status.OK_STATUS);

				} else {
					setStatus(new Status(IStatus.ERROR, bundle.getSymbolicName(), "Requirement1 not found")); //$NON-NLS-1$

				}

			}

		};
		Display.getDefault().syncExec(runnableWithResult);

		Assert.assertEquals(runnableWithResult.getStatus().getMessage(), IStatus.OK, runnableWithResult.getStatus().getSeverity());
		Assert.assertNotNull(editor);
	}

	@After
	public void dispose() throws Exception {
		if(editor != null) {
			Display.getDefault().syncExec(new Runnable() {

				public void run() {
					((IEditorPart)editor).getSite().getPage().closeEditor(editor, false);
				}
			});

			editor = null;
		}

		if(project != null) {
			project.delete(true, new NullProgressMonitor());
			project = null;
		}
	}

	protected IPageManager getPageManager() throws ServiceException {
		return getServicesRegistry().getService(IPageManager.class);
	}

	protected ServicesRegistry getServicesRegistry() throws ServiceException {
		return editor.getServicesRegistry();
	}

	protected TransactionalEditingDomain getTransactionalEditingDomain() throws ServiceException {
		return getServicesRegistry().getService(TransactionalEditingDomain.class);
	}

	protected ModelSet getModelSet() throws ServiceException {
		return getServicesRegistry().getService(ModelSet.class);
	}

	/**
	 * The path to the source model folder
	 * 
	 * @return
	 */
	protected abstract String getSourcePath();
}
