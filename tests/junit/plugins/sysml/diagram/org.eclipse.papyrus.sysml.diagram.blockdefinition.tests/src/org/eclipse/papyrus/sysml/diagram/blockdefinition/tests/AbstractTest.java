/*****************************************************************************
 * Copyright (c) 2011-2012 CEA LIST.
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
package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests;

import static org.junit.Assert.assertNotNull;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.junit.utils.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.Activator;
import org.eclipse.papyrus.uml.diagram.common.helper.CreateOrShowExistingElementHelper;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroPart;
import org.eclipse.ui.part.FileEditorInput;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Abstract Papyrus initialization class (required to get Service activation).
 */
public abstract class AbstractTest extends AbstractPapyrusTest {

	public static boolean isInitialized = false;

	public static IEditorPart editor = null;

	public static String editorID = "org.eclipse.papyrus.infra.core.papyrusEditor";

	@BeforeClass
	public static void openPapyrusWithAnEmptyProject() throws Exception {
		Runnable closeIntroRunnable = new Runnable() {

			public void run() {
				IIntroPart introPart = PlatformUI.getWorkbench().getIntroManager().getIntro();
				PlatformUI.getWorkbench().getIntroManager().closeIntro(introPart);
			}
		};
		PlatformUI.getWorkbench().getDisplay().syncExec(closeIntroRunnable);

		// Prepare new project for tests
		IProject testProject = ResourcesPlugin.getWorkspace().getRoot().getProject("TestProject");
		if(!testProject.exists()) {
			testProject.create(new NullProgressMonitor());
		}

		if(!testProject.isOpen()) {
			testProject.open(new NullProgressMonitor());
		}

		// Copy EmptyModel from bundle to the test project
		final IFile emptyModel_di = testProject.getFile("ModelWithBDD.di");
		IFile emptyModel_no = testProject.getFile("ModelWithBDD.notation");
		IFile emptyModel_uml = testProject.getFile("ModelWithBDD.uml");

		// isInitialized = isInitialized || emptyModel_di.exists();

		if(!isInitialized) {
			isInitialized = true;
			emptyModel_di.create(Activator.getInstance().getBundle().getResource("/model/ModelWithBDD.di").openStream(), true, new NullProgressMonitor());
			emptyModel_no.create(Activator.getInstance().getBundle().getResource("/model/ModelWithBDD.notation").openStream(), true, new NullProgressMonitor());
			emptyModel_uml.create(Activator.getInstance().getBundle().getResource("/model/ModelWithBDD.uml").openStream(), true, new NullProgressMonitor());
		}

		// Open the EmptyModel.di file with Papyrus (assumed to be the default editor for "di" files here).
		Runnable openEditorRunnable = new Runnable() {

			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					editor = page.openEditor(new FileEditorInput(emptyModel_di), editorID);
				} catch (Exception ex) {
					ex.printStackTrace(System.out);
				}
			}
		};

		Display.getDefault().syncExec(openEditorRunnable);
		assertNotNull("Failed to open an Editor", editor);

		//set the preference to never for the dialog to display existing link instead of create a new one.
		final IPreferenceStore store = org.eclipse.papyrus.uml.diagram.common.Activator.getDefault().getPreferenceStore();
		boolean contains = store.contains(CreateOrShowExistingElementHelper.DISPLAY_DIALOG_FOR_CREATE_OR_RESTORE_ELEMENT);
		if(!contains) {
			store.setValue(CreateOrShowExistingElementHelper.DISPLAY_DIALOG_FOR_CREATE_OR_RESTORE_ELEMENT, MessageDialogWithToggle.NEVER);
			store.setDefault(CreateOrShowExistingElementHelper.DISPLAY_DIALOG_FOR_CREATE_OR_RESTORE_ELEMENT, MessageDialogWithToggle.NEVER);
		}
	}

	@AfterClass
	public static void closePapyrusAndCleanProject() throws Exception {
		// Close the editor without saving content created during tests
		Runnable closeEditorRunnable = new Runnable() {

			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				page.closeEditor(editor, false);
			}
		};
		Display.getDefault().syncExec(closeEditorRunnable);
	}
}
