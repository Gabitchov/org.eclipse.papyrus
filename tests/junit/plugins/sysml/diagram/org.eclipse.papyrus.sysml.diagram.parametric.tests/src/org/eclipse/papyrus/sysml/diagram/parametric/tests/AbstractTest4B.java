/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.tests;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.junit.utils.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.sysml.diagram.parametric.Activator;
import org.eclipse.papyrus.sysml.diagram.parametric.tests.utils.Constants;
import org.eclipse.papyrus.sysml.diagram.parametric.tests.utils.EditorUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

/**
 * Abstract Papyrus initialization class (required to get Service activation).
 */
public abstract class AbstractTest4B extends AbstractPapyrusTest {

	public static boolean isInitialized = false;

	public static IEditorPart editor = null;

	public static String editorID = "org.eclipse.papyrus.infra.core.papyrusEditor";

	@BeforeClass
	public static void openPapyrusWithAParametricDiagramOwnedByBlock() throws Exception {
		// Prepare new project for tests
		IProject testProject = ResourcesPlugin.getWorkspace().getRoot().getProject("TestProject");
		if(!testProject.exists()) {
			testProject.create(new NullProgressMonitor());
		}

		if(!testProject.isOpen()) {
			testProject.open(new NullProgressMonitor());
		}

		// Copy EmptyModel from bundle to the test project
		final IFile emptyModel_di = testProject.getFile("ModelWithPD.di");
		IFile emptyModel_no = testProject.getFile("ModelWithPD.notation");
		IFile emptyModel_uml = testProject.getFile("ModelWithPD.uml");

		if(!isInitialized) {
			isInitialized = true;
			emptyModel_di.create(Activator.getInstance().getBundle().getResource("/model/ModelWithPD.di").openStream(), true, new NullProgressMonitor());
			emptyModel_no.create(Activator.getInstance().getBundle().getResource("/model/ModelWithPD.notation").openStream(), true, new NullProgressMonitor());
			emptyModel_uml.create(Activator.getInstance().getBundle().getResource("/model/ModelWithPD.uml").openStream(), true, new NullProgressMonitor());
		}

		// Open the EmptyModel.di file with Papyrus (assumed to be the default editor for "di" files here).
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					editor = page.openEditor(new FileEditorInput(emptyModel_di), editorID);
				} catch (Exception ex) {
					ex.printStackTrace(System.out);
				}
			}
		});

		setActiveDiagramViewByName(Constants.PARAMETRIC_OWNED_BY_BLOCK_DIAGRAM_NAME);

		Assert.assertNotNull("Failed to open the editor", editor);
	}

	public static boolean setActiveDiagramViewByName(String diagramName) throws Exception {
		if(diagramName == null) {
			return false;
		}
		ServicesRegistry serviceRegistry = (ServicesRegistry)EditorUtils.getEditor().getAdapter(ServicesRegistry.class);
		IPageManager iPageManager = ServiceUtils.getInstance().getIPageManager(serviceRegistry);
		List<Object> allPages = iPageManager.allPages();
		for(Object object : allPages) {
			if(object instanceof Diagram) {
				if(diagramName.equals(((Diagram)object).getName())) {
					iPageManager.selectPage(object);
					return true;
				}
			}
		}
		return false;
	}

	@AfterClass
	public static void closePapyrusAndCleanProject() throws Exception {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				// Close the editor without saving content created during tests
				editor.getSite().getPage().closeEditor(editor, false);
			}
		});
		editor = null;
	}
}
