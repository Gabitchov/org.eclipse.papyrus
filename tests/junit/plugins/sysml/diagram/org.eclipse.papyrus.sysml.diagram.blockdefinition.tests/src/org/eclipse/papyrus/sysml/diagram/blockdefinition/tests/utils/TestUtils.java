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
package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getDiagramEditor;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getEditPart;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getPaletteTool;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getTransactionalEditingDomain;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils.createElement;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.ui.action.global.GlobalAction;
import org.eclipse.gmf.runtime.common.ui.action.internal.actions.global.GlobalCopyAction;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.Activator;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool.CreateAspectUnspecifiedTypeConnectionRequest;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.junit.Assert;


public class TestUtils {

	public static void deleteView(IElementType elementType, View containerView, boolean isAllowed) throws Exception {
		View view = TestPrepareUtils.dropFromModelExplorer(elementType, getDiagramView());
		deleteView(view, isAllowed);
	}

	public static void deleteView(View view, boolean isAllowed) throws Exception {

		// Find container EditPart (for command creation)
		EditPart containerEditPart = getEditPart(view);

		// Get delete view command
		Command command = containerEditPart.getCommand(new GroupRequest(RequestConstants.REQ_DELETE));

		// if the view deletion is not allowed the command should not be executable
		if(!isAllowed) {
			if((command == null) || (!command.canExecute())) {
				// Ok the command cannot be executed.
			} else {
				fail("The command should not be executable.");
			}

		} else {
			if((command == null) || (!command.canExecute())) {
				fail("The command should be executable.");
			} else {
				// Ok the command can be executed.
				defaultExecutionTest(command);

				// Test the results then
				// fail("Result tests not implemented.");
			}
		}
	}

	public static void deleteElement(IElementType elementType, View containerView, boolean isAllowed) throws Exception {
		View view = TestPrepareUtils.dropFromModelExplorer(elementType, getDiagramView());
		deleteElement(view, isAllowed);
	}

	public static void deleteElement(View view, boolean isAllowed) throws Exception {

		// Find container EditPart (for command creation)
		EditPart containerEditPart = getEditPart(view);

		// Prepare request
		DestroyElementRequest destroyRequest = new DestroyElementRequest(getTransactionalEditingDomain(), false);

		// Get delete command
		Command command = containerEditPart.getCommand(new EditCommandRequestWrapper(destroyRequest));

		// if the deletion is not allowed the command should not be executable
		if(!isAllowed) {
			if((command == null) || (!command.canExecute())) {
				// Ok the command cannot be executed.
			} else {
				fail("The command should not be executable.");
			}

		} else {
			if((command == null) || (!command.canExecute())) {
				fail("The command should be executable.");
			} else {
				// Ok the command can be executed.
				defaultExecutionTest(command);

				// Test the results then
				// fail("Result tests not implemented.");
			}
		}
	}

	public static void dropFromModelExplorer(IElementType elementType, View containerView, boolean isAllowed) throws Exception {
		EObject newObject = createElement(elementType, containerView);
		dropFromModelExplorer(newObject, containerView, isAllowed);
	}

	public static void dropFromModelExplorer(EObject eObject, View containerView, boolean isAllowed) throws Exception {

		// Find container EditPart (for command creation)
		EditPart containerEditPart = getEditPart(containerView);

		// Prepare drop request
		DropObjectsRequest dropRequest = new DropObjectsRequest();
		ArrayList<EObject> list = new ArrayList<EObject>();
		list.add(eObject);
		dropRequest.setObjects(list);
		dropRequest.setLocation(new Point(200, 200));

		// Get drop command
		Command command = containerEditPart.getCommand(dropRequest);

		// if the drop is not allowed the command should not be executable
		if(!isAllowed) {
			if((command == null) || (!command.canExecute())) {
				// Ok the command cannot be executed.
			} else {
				fail("The command should not be executable.");
			}

		} else {
			if((command == null) || (!command.canExecute())) {
				fail("The command should be executable.");
			} else {
				// Ok the command can be executed.
				defaultExecutionTest(command);

				// Test the results then
				// fail("Result tests not implemented.");
			}
		}
	}

	public static void createNodeFromPalette(String toolId, View containerView, boolean isAllowed) throws Exception {

		if(isAllowed) {
			createNodeFromPalette(toolId, containerView, isAllowed, true);
		} else {
			createNodeFromPalette(toolId, containerView, isAllowed, false);
		}

	}

	public static void createNodeFromPalette(String toolId, View containerView, boolean isAllowed, boolean execute) throws Exception {

		// Find container EditPart (for command creation)
		EditPart containerEditPart = getEditPart(containerView);

		// Find palette tool to simulate element creation
		Tool tool = getPaletteTool(toolId);
		Request createRequest = getCreateRequest(tool);

		// Get creation command for request
		Command command = containerEditPart.getCommand(createRequest);

		// if the creation is not allowed the command should not be executable
		if(!isAllowed) {
			if((command == null) || (!command.canExecute())) {
				// Ok the command cannot be executed.
			} else {
				fail("The command should not be executable.");
			}

		} else {
			if((command == null) || (!command.canExecute())) {
				fail("The command should be executable.");
			} else {
				// Ok the command can be executed.
				if(execute) {
					defaultExecutionTest(command);
				}

				// Test the results then
				// fail("Result tests not implemented.");
			}

		}
	}

	public static Request getCreateRequest(Tool tool) throws Exception {

		if(tool instanceof AspectUnspecifiedTypeCreationTool) {
			final AspectUnspecifiedTypeCreationTool creationTool = (AspectUnspecifiedTypeCreationTool)tool;
			// Don't forget to set the diagram viewer (required for preferenceHints to mimic manual creation)
			Display.getDefault().syncExec(new Runnable() {

				public void run() {
					try {
						creationTool.setViewer(getDiagramEditor().getDiagramGraphicalViewer());
					} catch (Exception ex) {
						ex.printStackTrace(System.out);
					}
				}
			});

			return creationTool.createCreateRequest();

		} else if(tool instanceof AspectUnspecifiedTypeConnectionTool) {
			final AspectUnspecifiedTypeConnectionTool connectionTool = (AspectUnspecifiedTypeConnectionTool)tool;

			// Don't forget to set the diagram viewer (required for preferenceHints to mimic manual creation)
			Display.getDefault().syncExec(new Runnable() {

				public void run() {
					try {
						connectionTool.setViewer(getDiagramEditor().getDiagramGraphicalViewer());
					} catch (Exception ex) {
						ex.printStackTrace(System.out);
					}
				}
			});

			return connectionTool.new CreateAspectUnspecifiedTypeConnectionRequest(connectionTool.getElementTypes(), false, Activator.DIAGRAM_PREFERENCES_HINT);
		}

		throw new Exception("Unexpected kind of creation tool.");
	}

	public static void createEdgeFromPalette(String toolId, View sourceView, View targetView, boolean isAllowed) throws Exception {

		if(isAllowed) {
			createEdgeFromPalette(toolId, sourceView, targetView, isAllowed, true);
		} else {
			createEdgeFromPalette(toolId, sourceView, targetView, isAllowed, false);
		}

	}

	public static void createEdgeFromPalette(String toolId, View sourceView, View targetView, boolean isAllowed, boolean execute) throws Exception {

		// Find palette tool to simulate element creation and prepare request
		Tool tool = getPaletteTool(toolId);
		CreateAspectUnspecifiedTypeConnectionRequest createRequest = (CreateAspectUnspecifiedTypeConnectionRequest)getCreateRequest(tool);

		// Test source creation command
		createRequest.setSourceEditPart(getEditPart(sourceView));
		createRequest.setType(RequestConstants.REQ_CONNECTION_START);
		Command srcCommand = getEditPart(sourceView).getCommand(createRequest);

		// Test source command
		if((srcCommand == null) || !(srcCommand.canExecute())) { // Non-executable command
			if(targetView == null) { // Only test behavior on source
				if(!isAllowed) {
					// Current behavior matches the expected results
					return;
				} else {
					fail("The command should be executable.");
				}

			} else { // Test complete creation, the command should necessary be executable
				fail("The command should be executable.");
			}

		} else { // Executable command
			if(targetView == null) { // Only test behavior on source
				if(!isAllowed) {
					fail("The command should not be executable.");
				} else {
					// Current behavior matches the expected results - no execution test.
					return;
				}

			} else { // The command is executable and a target is provided - continue the test

				// Get target command (complete link creation)
				createRequest.setSourceEditPart(getEditPart(sourceView));
				createRequest.setTargetEditPart(getEditPart(targetView));
				createRequest.setType(RequestConstants.REQ_CONNECTION_END);
				Command tgtCommand = getEditPart(targetView).getCommand(createRequest);

				// Test the target command
				if((tgtCommand == null) || !(tgtCommand.canExecute())) { // Non-executable command
					if(!isAllowed) {
						// Current behavior matches the expected results
						return;
					} else {
						fail("The command should be executable.");
					}

				} else { // Executable command
					if(!isAllowed) {
						fail("The command should not be executable.");
					} else {
						// Current behavior matches the expected results
						if(execute) { // Test command execution
							defaultExecutionTest(tgtCommand);
						}

						// Test the results then
						// fail("Result tests not implemented.");
					}
				}
			}

		}
	}

	/**
	 * Copy the list of objects into the Clipboard
	 * 
	 * @param objectsToCopy
	 *        the list of objects to copy. should not be <code>null</code>, at least an empty list
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	public static void copyEditParts(List<Object> objectsToCopy) throws Exception {
		// select elements to copy
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(EditorUtils.getEditor());
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().bringToTop(EditorUtils.getEditor());
		EditorUtils.getDiagramEditor().getEditorSite().getSelectionProvider().setSelection(new StructuredSelection(objectsToCopy));

		ISelection selection = EditorUtils.getEditor().getSite().getSelectionProvider().getSelection();
		Assert.assertEquals("Selection size should be " + objectsToCopy.size(), objectsToCopy.size(), ((IStructuredSelection)selection).size());

		// retrieve the command for copy
		ICommandService commandService = (ICommandService)PlatformUI.getWorkbench().getService(ICommandService.class);
		commandService.refreshElements(IWorkbenchCommandConstants.EDIT_COPY, null);
		org.eclipse.core.commands.Command copyCommand = commandService.getCommand(IWorkbenchCommandConstants.EDIT_COPY);
		((GlobalCopyAction)((ActionHandler)copyCommand.getHandler()).getAction()).setEnabled(true);
		Assert.assertNotNull("Impossible to find copy command", copyCommand);

		//EditorUtils.getDiagramEditor().getEditingDomain().setClipboard(objectsToCopy);

		// retrieve handler service for the copy command
		IHandlerService handlerService = (IHandlerService)PlatformUI.getWorkbench().getService(IHandlerService.class);
		Assert.assertNotNull("Impossible to find handler service", handlerService);

		final ParameterizedCommand parameterizedCommand = new ParameterizedCommand(copyCommand, null);

		// retrieve the command and set some parameters on it
		copyCommand.setEnabled(handlerService.getCurrentState());
		final boolean commandEnabled = copyCommand.isEnabled();
		Assert.assertTrue("Command should be enabled", commandEnabled);

		// execute the copy command
		handlerService.executeCommand(parameterizedCommand, null);
	}

	/**
	 * paste the list of objects into the Clipboard into the current diagram
	 * 
	 * @param target
	 *        object on which content of the clipboard should be added
	 * @param executable
	 *        indicates if the paste command should be executable.
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	public static void pasteEditParts(Object target, boolean executable) throws Exception {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(EditorUtils.getEditor());
		EditorUtils.getDiagramEditor().getEditorSite().getSelectionProvider().setSelection(new StructuredSelection(target));

		// retrieve the command for copy
		ICommandService commandService = (ICommandService)PlatformUI.getWorkbench().getService(ICommandService.class);
		commandService.refreshElements(IWorkbenchCommandConstants.EDIT_PASTE, null);
		org.eclipse.core.commands.Command pasteCommand = commandService.getCommand(IWorkbenchCommandConstants.EDIT_PASTE);
		Assert.assertNotNull("Impossible to find paste command", pasteCommand);
		((GlobalAction)((ActionHandler)pasteCommand.getHandler()).getAction()).refresh();

		IHandlerService handlerService = (IHandlerService)PlatformUI.getWorkbench().getService(IHandlerService.class);
		Assert.assertNotNull("Impossible to find handler service", handlerService);
		final ParameterizedCommand parameterizedCommand = new ParameterizedCommand(pasteCommand, null);
		Assert.assertEquals("Command is not executable as expected", pasteCommand.isEnabled(), executable);

		if(executable) {
			// execute the copy command
			handlerService.executeCommand(parameterizedCommand, null);
		}
	}

	/**
	 * paste with model element the list of objects into the Clipboard into the current diagram
	 * 
	 * @param target
	 *        object on which content of the clipboard should be added
	 * @param executable
	 *        indicates if the paste command should be executable.
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	public static void pasteWithModelEditParts(Object target, boolean executable) throws Exception {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(EditorUtils.getEditor());
		EditorUtils.getDiagramEditor().getEditorSite().getSelectionProvider().setSelection(new StructuredSelection(target));

		// retrieve the command for copy
		ICommandService commandService = (ICommandService)PlatformUI.getWorkbench().getService(ICommandService.class);
		commandService.refreshElements(IWorkbenchCommandConstants.EDIT_PASTE, null);
		org.eclipse.core.commands.Command pasteWithModelCommand = commandService.getCommand("org.eclipse.papyrus.uml.diagram.common.commands.PasteWithModelCommand");
		Assert.assertNotNull("Impossible to find paste command", pasteWithModelCommand);
		// ((GlobalAction)((AbstractHandlerWithState)pasteWithModelCommand.getHandler()).getAction()).refresh();

		IHandlerService handlerService = (IHandlerService)PlatformUI.getWorkbench().getService(IHandlerService.class);
		Assert.assertNotNull("Impossible to find handler service", handlerService);
		final ParameterizedCommand parameterizedCommand = new ParameterizedCommand(pasteWithModelCommand, null);
		Assert.assertEquals("Command is not executable as expected", pasteWithModelCommand.isEnabled(), executable);

		if(executable) {
			// execute the copy command
			handlerService.executeCommand(parameterizedCommand, null);
		}
	}

	// History event type variable to store history error events.
	public static int historyEventType = OperationHistoryEvent.DONE;

	/**
	 * Test execution, undo, redo of the given command.
	 * 
	 * @param command
	 *        the command to test.
	 * @throws Exception
	 */
	public static void defaultExecutionTest(Command command) throws Exception {

		// Execution in the diagram command stack (like Papyrus usual execution for GEF commands). This is important especially for
		// composed command like Drop links which create intermediate view during execution. With EMF command stack, the whole command
		// tries to execute and the edit part of the intermediate created views are not created before the command ends. 
		// The diagram command stack let edit part being created after each view creation.

		// The problem in using the DiagramCommandStack (vs EMF CommandStack) is that it hides any exception that can possibly occur during
		// command execution. This would let the test finish without error (the command result is not tested currently) while the execution failed.

		// For this matter the DiagramCommandStack history is observed to detect execution issues.

		// Add diagram command stack operation history listener
		IOperationHistory history = EditorUtils.getDiagramEditingDomain().getActionManager().getOperationHistory();
		IOperationHistoryListener historyChange = new IOperationHistoryListener() {

			public void historyNotification(OperationHistoryEvent event) {
				// Store history events
				historyEventType = event.getEventType();
			}
		};
		history.addOperationHistoryListener(historyChange);

		try {
			// Test execution
			historyEventType = OperationHistoryEvent.DONE;
			EditorUtils.getDiagramCommandStack().execute(command);
			if(historyEventType == OperationHistoryEvent.OPERATION_NOT_OK) {
				fail("Command execution failed ()");
			}

			// Test undo
			historyEventType = OperationHistoryEvent.DONE;
			EditorUtils.getDiagramCommandStack().undo();
			if(historyEventType == OperationHistoryEvent.OPERATION_NOT_OK) {
				fail("Command undo failed ()");
			}

			// Test redo
			historyEventType = OperationHistoryEvent.DONE;
			EditorUtils.getDiagramCommandStack().redo();
			if(historyEventType == OperationHistoryEvent.OPERATION_NOT_OK) {
				fail("Command redo failed ()");
			}
		} finally {
			// Remove listener, even when the test has failed.
			history.removeOperationHistoryListener(historyChange);
		}
	}
}
