/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.tests.canonical;

import java.io.ByteArrayInputStream;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.utils.DiResourceSet;
import org.eclipse.papyrus.uml.diagram.common.commands.CreateUMLModelCommand;
import org.eclipse.papyrus.uml.diagram.common.part.UmlGmfDiagramEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.uml2.uml.Element;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;


/**
 * The Class AbstractPapyrusTestCase.
 */
@SuppressWarnings("deprecation")
public abstract class AbstractPapyrusTestCase extends TestCase {


	/** The Constant CREATION. */
	protected static final String CREATION = "CREATION:";

	/** The Constant CONTAINER_CREATION. */
	protected static final String CONTAINER_CREATION = "CONTAINER CREATION: ";

	/** The Constant DROP. */
	protected static final String DROP = "DROP: ";

	/** The Constant DESTROY_DELETION. */
	protected static final String DESTROY_DELETION = "DESTROY DELETION: ";

	/** The Constant COMMAND_NULL. */
	protected static final String COMMAND_NULL = " command null";

	/** The Constant VIEW_DELETION. */
	protected static final String VIEW_DELETION = "VIEW DELETION: ";

	/** The Constant TEST_THE_REDO. */
	protected static final String TEST_THE_REDO = "test the redo";

	/** The Constant TEST_THE_UNDO. */
	protected static final String TEST_THE_UNDO = "test the undo";

	/** The Constant TEST_THE_EXECUTION. */
	protected static final String TEST_THE_EXECUTION = "test the execution";

	/** The Constant TEST_IF_THE_COMMAND_CAN_BE_EXECUTED. */
	protected static final String TEST_IF_THE_COMMAND_CAN_BE_EXECUTED = "test if the command can be executed";

	/** The Constant TEST_IF_THE_COMMAND_IS_CREATED. */
	protected static final String TEST_IF_THE_COMMAND_IS_CREATED = "test if the command is created";

	/** The Constant INITIALIZATION_TEST. */
	protected static final String INITIALIZATION_TEST = "Intitial State";

	/** The Constant CHANGE_CONTAINER. */
	protected static final String CHANGE_CONTAINER = "CHANGE CONTAINER";

	/** The papyrus editor. */
	protected IMultiDiagramEditor papyrusEditor;

	/** The di resource set. */
	protected ModelSet diResourceSet;

	/** The project. */
	protected IProject project;

	/** The file. */
	protected IFile file;

	/** The root. */
	protected IWorkspaceRoot root;

	/** The page. */
	protected IWorkbenchPage page;

	/** The diagram editor. */
	protected UmlGmfDiagramEditor diagramEditor = null;

	/** The clazzdiagramedit part. */
	protected DiagramEditPart clazzdiagrameditPart;

	/**
	 * @see junit.framework.TestCase#setUp()
	 * 
	 * @throws Exception
	 */
	@Before
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		projectCreation();
	}

	/**
	 * Gets the root view.
	 * 
	 * @return the root view
	 */
	protected View getRootView() {
		return getDiagramEditPart().getDiagramView();
	}

	/**
	 * Gets the root semantic model.
	 * 
	 * @return the root semantic model
	 */
	protected Element getRootSemanticModel() {
		return (Element)getRootView().getElement();
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 * 
	 * @throws Exception
	 */
	@After
	@Override
	protected void tearDown() throws Exception {
		RunnableWithResult<Boolean> runnable = new RunnableWithResult.Impl<Boolean>() {

			public void run() {
				try {
					papyrusEditor.doSave(new NullProgressMonitor());
					//diResourceSet.save( new NullProgressMonitor());
					//diagramEditor.close(true);
					papyrusEditor = null;
					clazzdiagrameditPart = null;
					diagramEditor = null;
					page.closeAllEditors(true);
					project.delete(true, new NullProgressMonitor());

					setResult(true);
				} catch (Exception ex) {
					ex.printStackTrace(System.out);
					setResult(false);
				}
			}

		};

		Display.getDefault().syncExec(runnable);
		if(!runnable.getResult()) {
			fail("Cannot close the editor and delete the project");
		}
	}

	/**
	 * Gets the diagram edit part.
	 * 
	 * @return the diagram edit part
	 */
	protected DiagramEditPart getDiagramEditPart() {
		if(clazzdiagrameditPart == null) {
			diagramEditor = (UmlGmfDiagramEditor)papyrusEditor.getActiveEditor();
			clazzdiagrameditPart = (DiagramEditPart)papyrusEditor.getAdapter(DiagramEditPart.class);
		}
		return clazzdiagrameditPart;
	}

	protected abstract ICreationCommand getDiagramCommandCreation();

	/**
	 * Project creation.
	 */
	protected void projectCreation() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		root = workspace.getRoot();
		project = root.getProject("ClazzDiagramTestProject");
		file = project.getFile("ClazzDiagramTest.di");
		this.diResourceSet = new DiResourceSet();
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
				file.create(new ByteArrayInputStream(new byte[0]), true, new NullProgressMonitor());
				diResourceSet.createsModels(file);
				new CreateUMLModelCommand().createModel(this.diResourceSet);
				// diResourceSet.createsModels(file);
				ICreationCommand command = getDiagramCommandCreation();
				command.createDiagram(diResourceSet, null, "DiagramToTest");
				diResourceSet.save(new NullProgressMonitor());

			}

			Runnable runnable = new Runnable() {

				public void run() {
					try {
						page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
						IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
						papyrusEditor = (IMultiDiagramEditor)page.openEditor(new FileEditorInput(file), desc.getId());
					} catch (Exception ex) {
						ex.printStackTrace(System.out);
					}
				}
			};

			Display.getDefault().syncExec(runnable);
			Assert.assertNotNull("Failed to open the editor", papyrusEditor);
		} catch (Exception e) {
			e.printStackTrace(System.out);
			fail("Project creation failed: " + e.getMessage());
		}
	}

}
