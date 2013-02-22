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
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.editor.integration.tests.Activator;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.junit.utils.EditorUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.junit.After;
import org.junit.Assert;


public abstract class AbstractEditorIntegrationTest {

	protected IMultiDiagramEditor editor;

	protected IProject project;

	/**
	 * Inits this.editor
	 * Fails or throws an exception if an error occurs
	 */
	protected void initModel(String projectName, String modelName) throws Exception {
		project = ProjectUtils.createProject(projectName);
		final IFile diModelFile = PapyrusProjectUtils.copyPapyrusModel(project, Activator.getDefault().getBundle(), getSourcePath(), modelName);
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
