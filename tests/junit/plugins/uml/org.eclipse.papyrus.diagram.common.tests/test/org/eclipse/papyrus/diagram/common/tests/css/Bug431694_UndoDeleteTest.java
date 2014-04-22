/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.tests.css;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.tests.canonical.AbstractPapyrusTestCase;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.CSSHelper;
import org.eclipse.papyrus.junit.utils.DiagramUtils;
import org.eclipse.papyrus.junit.utils.classification.FailingTest;
import org.eclipse.papyrus.junit.utils.tests.AbstractEditorTest;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Package;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.Bundle;

/**
 * Test for bug 431694: [All diagrams] Problem with Surfboard display after Delete -> Undo
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=431694
 */
public class Bug431694_UndoDeleteTest extends AbstractEditorTest {

	private static final String DIAGRAM_MAIN_NAME = "Main";

	private static final String PROJECT_NAME = "431694_UndoDeleteTest";

	public final static String SOURCE_PATH = "resources/431694/";

	protected boolean operationFailed = false;

	
	@Before
	public void prepareTest() throws Exception {
		initModel(PROJECT_NAME, "model", getBundle());
	}

	/**
	 * Test with a {@link Package} with a css style already applied
	 */
	@Test
	@FailingTest("Bug 431694")
	public void testDeleteOnPackageWithStyle() throws Exception {
		// check css on the package P1
		// get Package 1 view on the open diagram
		// get the rootModel
		Assert.assertNotNull("RootModel is null", getRootUMLModel());
		
		Diagram mainDiagram = DiagramUtils.getNotationDiagram(getModelSet(), DIAGRAM_MAIN_NAME);
		getPageManager().openPage(mainDiagram);
		Assert.assertEquals("current opened diagram is not the expected one", mainDiagram.getName(), DIAGRAM_MAIN_NAME);

		// check css is working 
		Assert.assertTrue("CSS is not supported on the given model", CSSHelper.isCSSSupported(getModelSet()));
		Shape package1View = DiagramUtils.findShape(mainDiagram, "Package1");
		if(package1View == null) {
			return;
		}
		checkPackage1CSS(package1View);
		
		// delete P1
		// get edit part for this view and send a delete request
		IGraphicalEditPart packageEditPart = DiagramUtils.findEditPartforView(editor, package1View, IGraphicalEditPart.class);
		Assert.assertNotNull("Impossible to find package edit part", packageEditPart);
		Request deleteViewRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
		Command command = packageEditPart.getCommand(deleteViewRequest);
		assertNotNull("Impossible to create a delete command", command);
		Assert.assertNotEquals("This should not be an unexecutable command", command, UnexecutableCommand.INSTANCE);
		assertTrue("command should be executable", command.canExecute());
		execute(command);
		
		// undo
		undo();

		// check css on P1
		Shape newPackage1View = DiagramUtils.findShape(mainDiagram, "Package1");
		if(newPackage1View == null) {
			return;
		}
		checkPackage1CSS(newPackage1View);
		
	}

	protected void checkPackage1CSS(Shape packageShape) {
		// named style: fill red and horizontal green gradient 
		Assert.assertEquals("Invalid Fill color", DiagramUtils.rgb(255, 0, 0), packageShape.getFillColor()); //Red = #FF0000
		Assert.assertEquals("Gradient should be horizontal", packageShape.getGradient().getGradientStyle(), GradientStyle.HORIZONTAL);
		Assert.assertEquals("Invalid Gradient Color", DiagramUtils.rgb(0, 255, 0), packageShape.getGradient().getGradientColor1()); // GREEN
		
		// unnamed style: font color is blue
		Assert.assertEquals("Invalid gradient", DiagramUtils.rgb(0, 0, 255), packageShape.getFontColor()); // Blue font by the named style
	}


	@Override
	protected String getSourcePath() {
		return SOURCE_PATH;
	}

	@Override
	protected Bundle getBundle() {
		return org.eclipse.papyrus.uml.diagram.common.Activator.getDefault().getBundle();
	}
	
	/**
	 * Call {@link AbstractPapyrusTestCase#execute(Command) execute} on the UI
	 * thread.
	 */
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
		Assert.assertFalse("The operation failed. Look at the log, or put a breakpoint on ExecutionException or DefaultOperationHistory#notifyNotOK to find the cause.", this.operationFailed);
	}
	
	/**
	 * Reset the "operation failed" state. Call this before executing each
	 * operation for which you want to test whether if failed with {@link AbstractPapyrusTestCase#assertLastOperationSuccessful()}.
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
		Assert.assertTrue("We should be able to undo", commandStack.canUndo());
		commandStack.undo();
		assertLastOperationSuccessful();
	}

	/** Redo the last command undone in the diagram editor. */
	protected void redo() {
		resetLastOperationFailedState();
		final CommandStack commandStack = getCommandStack();
		Assert.assertTrue("We should be able to redo", commandStack.canRedo());
		commandStack.redo();
		assertLastOperationSuccessful();
	}

	/** The command stack to use to execute commands on the diagram. */
	protected CommandStack getCommandStack() {
		// not "diagramEditor.getDiagramEditDomain().getDiagramCommandStack()"
		// because it messes up undo contexts
		try {
			return getTransactionalEditingDomain().getCommandStack();
		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}
		return null;
	}
	

}
