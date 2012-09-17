/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.compare.file.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.ui.IPackagesViewPart;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.core.resource.notation.NotationModel;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;
import org.eclipse.papyrus.infra.core.resource.uml.UmlModel;
import org.eclipse.papyrus.junit.utils.GenericUtils;
import org.eclipse.papyrus.junit.utils.HandlerUtils;
import org.eclipse.papyrus.junit.utils.PackageExplorerUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.ui.PlatformUI;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author VL222926
 * 
 *         This plugin tests the activation of the correct handler for
 *         differents selection in the ModelExplorer
 */

public class CompareFileHandlerTest {//extends AbstractHandlerTest {

	private static final String OPEN_UML_COMPARE_FILE_EDITOR_COMMAND_ID = "org.eclipse.papyrus.uml.compare.file.command"; //$NON-NLS-1$

	private static final String LEFT_MODEL = "leftModel"; //$NON-NLS-1$

	private static final String RIGHT_MODEL = "rightModel"; //$NON-NLS-1$

	private static IPackagesViewPart packageExplorer;

	private static IProject project;

	@BeforeClass
	public static void init() throws CoreException, IOException {
		GenericUtils.closeIntroPart();
		GenericUtils.cleanWorkspace();
		project = ProjectUtils.createProject("CompareUMLFile"); //$NON-NLS-1$
		PapyrusProjectUtils.copyPapyrusModel(project, Activator.getDefault().getBundle(), "/resources/", LEFT_MODEL); //$NON-NLS-1$
		PapyrusProjectUtils.copyPapyrusModel(project, Activator.getDefault().getBundle(), "/resources/", RIGHT_MODEL); //$NON-NLS-1$
		packageExplorer = PackageExplorerUtils.openPackageExplorerView();
	}

	/**
	 * test the handler enablement on 2 notations files : should be false
	 */
	@Test
	public void openCompareUMLFileEditorWithDiFile() {
		final List<IFile> files = new ArrayList<IFile>();
		final IFile file_left = project.getFile(LEFT_MODEL + "." + SashModel.MODEL_FILE_EXTENSION); //$NON-NLS-1$
		final IFile file_right = project.getFile(RIGHT_MODEL + "." + SashModel.MODEL_FILE_EXTENSION); //$NON-NLS-1$
		files.add(file_left);
		files.add(file_right);
		final IStructuredSelection newSelection = new StructuredSelection(files);
		PackageExplorerUtils.setSelectionInPackageExplorerView(packageExplorer, newSelection);
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(packageExplorer);
		IHandler handler = HandlerUtils.getActiveHandlerFor(OPEN_UML_COMPARE_FILE_EDITOR_COMMAND_ID);
		Assert.assertNotNull(handler);
		Assert.assertFalse(handler.isEnabled());
	}

	/**
	 * test the handler enablement on 2 notations files : should be false
	 */
	@Test
	public void openCompareUMLFileEditorWithNotationFile() {
		final List<IFile> files = new ArrayList<IFile>();
		final IFile file_left = project.getFile(LEFT_MODEL + "." + NotationModel.NOTATION_FILE_EXTENSION); //$NON-NLS-1$
		final IFile file_right = project.getFile(RIGHT_MODEL + "." + NotationModel.NOTATION_FILE_EXTENSION); //$NON-NLS-1$
		files.add(file_left);
		files.add(file_right);
		final IStructuredSelection newSelection = new StructuredSelection(files);
		PackageExplorerUtils.setSelectionInPackageExplorerView(packageExplorer, newSelection);
		packageExplorer.setFocus();
		IHandler handler = HandlerUtils.getActiveHandlerFor(OPEN_UML_COMPARE_FILE_EDITOR_COMMAND_ID);
		Assert.assertNotNull(handler);
		Assert.assertFalse(handler.isEnabled());
	}

	/**
	 * test the handler enablement on 2 uml files : should be true
	 */
	@Test
	public void openCompareUMLFileEditorWithUMLFile() throws Exception {
		final List<IFile> files = new ArrayList<IFile>();
		final IFile file_left = project.getFile(LEFT_MODEL + "." + UmlModel.UML_FILE_EXTENSION); //$NON-NLS-1$
		final IFile file_right = project.getFile(RIGHT_MODEL + "." + UmlModel.UML_FILE_EXTENSION); //$NON-NLS-1$
		files.add(file_left);
		files.add(file_right);
		final IStructuredSelection newSelection = new StructuredSelection(files);
		PackageExplorerUtils.setSelectionInPackageExplorerView(packageExplorer, newSelection);
		packageExplorer.setFocus();
		IHandler handler = HandlerUtils.getActiveHandlerFor(OPEN_UML_COMPARE_FILE_EDITOR_COMMAND_ID);
		Assert.assertNotNull(handler);
		Assert.assertTrue(handler.isEnabled());
		//TODO : don't work on Hudson...
		//		HandlerUtils.executeCommand(HandlerUtils.getCommand(OPEN_UML_COMPARE_FILE_EDITOR_COMMAND_ID));
		//		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		//		Assert.assertTrue("I don't get the correct editor", editor instanceof CompareUMLFileEditor); //$NON-NLS-1$
	}



	@AfterClass
	public static void endOfTests() {
		GenericUtils.closeAllEditors();
	}

}
