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
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.DiResourceSet;
import org.eclipse.papyrus.uml.diagram.common.commands.CreateUMLModelCommand;
import org.eclipse.papyrus.uml.diagram.common.part.UmlGmfDiagramEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.IntroPart;
import org.eclipse.uml2.uml.Element;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;


/**
 * The Class AbstractPapyrusTestCase.
 */
@SuppressWarnings("deprecation")
public abstract class AbstractPapyrusTestCase extends TestCase {

	protected boolean operationFailed = false;

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
			Assert.assertNotNull("Cannot find the diagram editor", diagramEditor);
			Assert.assertNotNull("Cannot find the Diagram edit part", clazzdiagrameditPart);
		}
		return clazzdiagrameditPart;
	}

	protected abstract ICreationCommand getDiagramCommandCreation();

	/**
	 * Project creation.
	 */
	protected void projectCreation() {
		
		// assert the intro is not visible
		Runnable closeIntroRunnable = new Runnable() {

			public void run() {
				try {
					IIntroPart introPart = PlatformUI.getWorkbench().getIntroManager().getIntro();
					if(introPart!=null) {
						PlatformUI.getWorkbench().getIntroManager().closeIntro(introPart);
					}
				} catch (Exception ex) {
					ex.printStackTrace(System.out);
					fail(ex.getMessage());
				}
			}
		};

		Display.getDefault().syncExec(closeIntroRunnable);
		
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		root = workspace.getRoot();
		project = root.getProject("ClazzDiagramTestProject");
		file = project.getFile("ClazzDiagramTest.di");
		this.diResourceSet = new DiResourceSet();

		//at this point, no resources have been created
		try {
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
				ServicesRegistry registry = new ExtensionServicesRegistry(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);
				try {
					registry.add(ModelSet.class, Integer.MAX_VALUE, diResourceSet); //High priority to override all contributions
					registry.startRegistry();
				} catch (ServiceException ex) {
					//Ignore exceptions
				}
				// diResourceSet.createsModels(file);
				ICreationCommand command = getDiagramCommandCreation();
				command.createDiagram(diResourceSet, null, "DiagramToTest");
				diResourceSet.save(new NullProgressMonitor());
			}

			Runnable runnable = new Runnable() {

				public void run() {
					try {
						page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
						papyrusEditor = (IMultiDiagramEditor)page.openEditor(new FileEditorInput(file), PapyrusMultiDiagramEditor.EDITOR_ID);
					} catch (Exception ex) {
						fail(ex.getMessage());
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
	
	/** Call {@link AbstractPapyrusTestCase#execute(Command) execute} on the UI thread. */
	protected void executeOnUIThread(final Command command) {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				execute(command);
			}
		});
	}

	/** Call {@link AbstractPapyrusTestCase#undo() undo} on the UI thread. */
	protected void undoOnUIThread() {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				undo();
			}
		});
	}

	/** Call {@link AbstractPapyrusTestCase#redo() redo} on the UI thread. */
	protected void redoOnUIThread() {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				redo();
			}
		});
	}
	
	protected void assertLastOperationSuccessful() {
		assertFalse(
				"The operation failed. Look at the log, or put a breakpoint on ExecutionException or DefaultOperationHistory#notifyNotOK to find the cause.",
				this.operationFailed);
	}
	
	
	/**
	 * Reset the "operation failed" state. Call this before executing each operation for which you want to test whether
	 * if failed with {@link AbstractPapyrusTestCase#assertLastOperationSuccessful()}.
	 */
	protected void resetLastOperationFailedState() {
		this.operationFailed = false;
	}
	
	/** Execute the given command in the diagram editor. */
	protected void execute(final Command command) {
		resetLastOperationFailedState();
		getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		assertLastOperationSuccessful();
	}

	/** Undo the last command done in the diagram editor. */
	protected void undo() {
		resetLastOperationFailedState();
		final CommandStack commandStack = getCommandStack();
		assertTrue("We should be able to undo", commandStack.canUndo());
		commandStack.undo();
		assertLastOperationSuccessful();
	}

	/** Redo the last command undone in the diagram editor. */
	protected void redo() {
		resetLastOperationFailedState();
		final CommandStack commandStack = getCommandStack();
		assertTrue("We should be able to redo", commandStack.canRedo());
		commandStack.redo();
		assertLastOperationSuccessful();
	}

	/** The command stack to use to execute commands on the diagram. */
	protected CommandStack getCommandStack() {
		// not "diagramEditor.getDiagramEditDomain().getDiagramCommandStack()" because it messes up undo contexts
		return this.diagramEditor.getEditingDomain().getCommandStack();
	}
	

}
