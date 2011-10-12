/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.test.common.tests;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.facet.util.core.internal.FileUtils;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.osgi.framework.Bundle;

/**
 * An abstract class to do JUnit test
 * 
 * @author VL222926
 * 
 */
public class AbstractTest {

	/** the di extension */
	protected static final String EXTENSION_DI = ".di"; //$NON-NLS-1$

	/** the notation extension */
	protected static final String EXTENSION_NOTATION = ".notation"; //$NON-NLS-1$

	/** the uml extension */
	protected static final String EXTENSION_UML = ".uml"; //$NON-NLS-1$

	/** the ResourceSet of the model */
	private ResourceSet resourceSet;

	/** the Papyrus Editor */
	private IEditorPart editor;

	/**
	 * Clean the workspace and create the new project
	 * 
	 * @param projectName
	 *        the name of the new project
	 * @return
	 *         return the new project
	 * @throws CoreException
	 */
	protected IProject createProject(final String projectName) throws CoreException {
		//we clean the workspace and create a new project to test the handlers
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		for(IProject project : workspace.getRoot().getProjects()) {
			project.delete(true, new NullProgressMonitor());
		}
		IProject testProject = workspace.getRoot().getProject(projectName);
		testProject.create(new NullProgressMonitor());
		testProject.open(new NullProgressMonitor());
		return testProject;
	}

	/**
	 * 
	 * @param bundle
	 *        the bundle containing the resources
	 * @param project
	 *        the project name
	 * @param filename
	 *        the name of the file to copy
	 * @throws IOException
	 * @throws CoreException
	 */
	protected void copyPapyrusProjectToBundle(final Bundle bundle, final IProject project, final String filename) throws IOException, CoreException {
		copyFileFromBundle("/resources/" + filename + EXTENSION_UML, project, '/' + filename + EXTENSION_UML, bundle); //$NON-NLS-1$
		copyFileFromBundle("/resources/" + filename + EXTENSION_NOTATION, project, '/' + filename + EXTENSION_NOTATION, bundle); //$NON-NLS-1$
		copyFileFromBundle("/resources/" + filename + EXTENSION_DI, project, '/' + filename + EXTENSION_DI, bundle); //$NON-NLS-1$
	}

	/**
	 * 
	 * @param file
	 *        the file to open
	 * @return
	 *         the opened editor
	 * @throws PartInitException
	 */
	protected IEditorPart openEditor(final IFile file) throws PartInitException {
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		editor = IDE.openEditor(activePage, file);
		return editor;
	}

	/**
	 * 
	 * @return
	 *         the resourceSet to use for the test
	 */
	protected ResourceSet getResourceSet() {
		if(resourceSet == null) {
			if(editor != null) {
				if(editor instanceof CoreMultiDiagramEditor) {
					EObject diagram = ((CoreMultiDiagramEditor)editor).getDiagram();
					if(diagram != null) {
						resourceSet = diagram.eResource().getResourceSet();
					}
				}
			} else {
				//not tested
				//				resourceSet = new ResourceSetImpl();
			}
		}
		return resourceSet;
	}

	/**
	 * 
	 * @param projectName
	 *        the project name
	 * @param filenameWithExtension
	 *        the name of the file with its extension
	 * @return
	 */
	protected Resource getResource(final String projectName, final String filenameWithExtension) {
		ResourceSet set = getResourceSet();
		URI uri = URI.createPlatformResourceURI(projectName + "/" + filenameWithExtension, true); //$NON-NLS-1$
		Resource res = set.getResource(uri, false);
		if(res == null) {
			res = set.createResource(uri);
		}
		return res;
	}

	/**
	 * Returns the root of the model
	 * 
	 * @param projectName
	 *        the name of the project
	 * @param filename
	 *        the name of the file
	 * @return
	 *         the root of the models
	 * @throws IOException
	 */
	protected EObject getRootOfTheModel(final String projectName, final String filenameWithExtension) throws IOException {
		Resource res = getResource(projectName, filenameWithExtension);
		res.load(Collections.emptyMap());
		return res.getContents().get(0);
	}

	/**
	 * Return the editing domain for the command
	 * 
	 * @return
	 *         the editing domain for the command
	 * @throws ServiceException
	 */
	protected TransactionalEditingDomain getEditingDomain() throws ServiceException {
		TransactionalEditingDomain domain = null;
		domain = ServiceUtilsForActionHandlers.getInstance().getTransactionalEditingDomain();
		return domain;
	}

	/**
	 * 
	 * @param sourcePath
	 *        the source path
	 * @param project
	 *        the project
	 * @param destinationPath
	 *        the destination path
	 * @param bundle
	 *        the bundle
	 * @throws IOException
	 * @throws CoreException
	 */
	protected void copyFileFromBundle(final String sourcePath, final IProject project, final String destinationPath, final Bundle bundle) throws IOException, CoreException {
		FileUtils.copyFileFromBundle(sourcePath, project, destinationPath, bundle);
	}
}
