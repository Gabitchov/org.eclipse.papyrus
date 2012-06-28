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
package org.eclipse.papyrus.uml.compare.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;
import org.eclipse.papyrus.junit.utils.EditorUtils;
import org.eclipse.papyrus.junit.utils.GenericUtils;
import org.eclipse.papyrus.junit.utils.HandlerUtils;
import org.eclipse.papyrus.junit.utils.ModelExplorerUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
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

public class CompareHandlerTest {//extends AbstractHandlerTest {

	private static final String OPEN_UML_COMPARE_EDITOR_COMMAND_ID = "org.eclipse.papyrus.uml.compare.command"; //$NON-NLS-1$

	private static final String MODEL = "model"; //$NON-NLS-1$

	private static ModelExplorerView modelExplorerView;

	private static IProject project;

	private static CoreMultiDiagramEditor papyrusEditor;

	@BeforeClass
	public static void init() throws CoreException, IOException {
		System.err.println("init method");
		GenericUtils.closeIntroPart();
		GenericUtils.cleanWorkspace();
		System.err.println("Create project");
		project = ProjectUtils.createProject("CompareUMLElement"); //$NON-NLS-1$
		System.err.println("Copy files");
		PapyrusProjectUtils.copyPapyrusModel(project, Activator.getDefault().getBundle(), "/resources/", MODEL); //$NON-NLS-1$
		final IFile file = project.getFile(MODEL + "." + SashModel.MODEL_FILE_EXTENSION); //$NON-NLS-1$
		Assert.assertNotNull(file);
		System.err.println("Opening Papyrus");
		papyrusEditor = (CoreMultiDiagramEditor)EditorUtils.openEditor(file);
		Assert.assertNotNull(papyrusEditor);
		System.err.println("Opening Model Explorer");
		modelExplorerView = ModelExplorerUtils.openModelExplorerView();
		System.err.println("End of init");
	}

	/**
	 * Test that the handler is enabled when the selected element have the same type
	 */
	@Test
	public void compareClassesHandlerActivation() throws Exception {
		System.err.println("begin the first test");
		final Model root = (Model)ModelExplorerUtils.getRootInModelExplorer(modelExplorerView);
		Class class1 = (Class)root.getOwnedMember("Class1"); //$NON-NLS-1$
		Class class2 = (Class)root.getOwnedMember("Class2"); //$NON-NLS-1$
		final List<Element> selection = new ArrayList<Element>();
		selection.add(class1);
		selection.add(class2);
		System.err.println("set selection in modelExplorer");
		ModelExplorerUtils.setSelectionInTheModelexplorer(modelExplorerView, selection);
		System.err.println("getting handler");
		final IHandler handler = HandlerUtils.getActiveHandlerFor(OPEN_UML_COMPARE_EDITOR_COMMAND_ID);
		Assert.assertNotNull(handler);
		Assert.assertTrue(handler.isEnabled());
		System.err.println("executing command handler");
		//TODO don't work on Hudson
		//		HandlerUtils.executeCommand(HandlerUtils.getCommand(OPEN_UML_COMPARE_EDITOR_COMMAND_ID));
		//		System.err.println("getting current papyrus editors");
		//		IEditorPart activeEditor = papyrusEditor.getActiveEditor();
		//		System.err.println("testing current editor");
		//		Assert.assertTrue(activeEditor instanceof UMLCompareEditor);
	}

	/**
	 * Test that the handler is disable when the selected element don't have the same type
	 */
	@Test
	public void compareHandlerClassWithModelActivation() {
		System.err.println("begin the second test");
		final Model root = (Model)ModelExplorerUtils.getRootInModelExplorer(modelExplorerView);
		final Model model2 = (Model)root.getOwnedMember("Model2"); //$NON-NLS-1$
		final Class class2 = (Class)root.getOwnedMember("Class2"); //$NON-NLS-1$
		final List<EObject> selection = new ArrayList<EObject>();
		selection.add(model2);
		selection.add(class2);
		ModelExplorerUtils.setSelectionInTheModelexplorer(modelExplorerView, selection);
		final IHandler handler = HandlerUtils.getActiveHandlerFor(OPEN_UML_COMPARE_EDITOR_COMMAND_ID);
		Assert.assertNotNull(handler);
		Assert.assertFalse(handler.isEnabled());
	}


	@AfterClass
	public static void endOfTests() {
		GenericUtils.closeAllEditors();
	}

}
