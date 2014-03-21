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
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.AbstractBaseModel;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.junit.utils.Activator;
import org.eclipse.papyrus.junit.utils.EditorUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPage;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.IPage;
import org.junit.After;
import org.junit.Assert;
import org.osgi.framework.Bundle;


public abstract class AbstractEditorTest extends AbstractPapyrusTest {
	/** the id of the model explorer */
	public static final String MODELEXPLORER_VIEW_ID = "org.eclipse.papyrus.views.modelexplorer.modelexplorer"; //$NON-NLS-1$


	protected IMultiDiagramEditor editor;

	protected IProject project;


	protected ModelExplorerView modelExplorerView;

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
	 * @param bundle the source bundle where the model is store
	 * @param projectName the project that will created at runtime to execute test
	 * @param modelName the model that will be copied and test executed on.
	 */
	protected void initModel(String projectName, String modelName, Bundle bundle) throws Exception {
		project = ProjectUtils.createProject(projectName);
		final IFile diModelFile = PapyrusProjectUtils.copyPapyrusModel(project, bundle, getSourcePath(), modelName);
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				try {
					editor = EditorUtils.openPapyrusEditor(diModelFile);
				} catch (Exception ex) {
					Activator.log.error(ex);
					Assert.fail(ex.getMessage());
				}
			}
		});

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


	public ModelExplorerView getModelExplorerView(){

		Display.getDefault().syncExec( new Runnable() {

			public void run() {
				IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

				// we look for the modelexplorer
				IViewPart modelexplorer;
				try {
					modelexplorer = activeWorkbenchWindow.getActivePage().showView(MODELEXPLORER_VIEW_ID);
				} catch (PartInitException ex) {
					ex.printStackTrace(System.out);
					return;
				}
				ModelExplorerPageBookView view = (ModelExplorerPageBookView)modelexplorer;
				IPage currentPage = view.getCurrentPage();
				ModelExplorerPage page = (ModelExplorerPage)currentPage;
				IViewPart viewer = page.getViewer();
				modelExplorerView = (ModelExplorerView)viewer;

			}
		});
		return modelExplorerView;
	}

	/**
	 * 
	 * @return the current UML model 
	 */
	protected org.eclipse.uml2.uml.Package getRootUMLModel(){

		IModel umlIModel;
		try {
			umlIModel = getModelSet().getModel("org.eclipse.papyrus.infra.core.resource.uml.UmlModel");

			AbstractBaseModel umlModel = null;
			if(umlIModel instanceof AbstractBaseModel) {
				umlModel = (AbstractBaseModel)umlIModel;
			}


			Assert.assertFalse("umlRessource contains nothing", umlModel.getResource().getContents().size()>1);
			Object root =umlModel.getResource().getContents().get(0);
			Assert.assertFalse("the root of UML model is not a package", root instanceof Package);

			return  (org.eclipse.uml2.uml.Package)root;
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

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
