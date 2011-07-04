package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getDiagramEditor;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getEditPart;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getPaletteTool;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getTransactionalEditingDomain;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils.createElement;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.command.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeCreationTool;


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
				getTransactionalEditingDomain().getCommandStack().execute(new GEFtoEMFCommandWrapper(command));

				// Test undo
				getTransactionalEditingDomain().getCommandStack().execute(getTransactionalEditingDomain().getCommandStack().getUndoCommand());
				// Test redo
				getTransactionalEditingDomain().getCommandStack().execute(getTransactionalEditingDomain().getCommandStack().getRedoCommand());

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
				getTransactionalEditingDomain().getCommandStack().execute(new GEFtoEMFCommandWrapper(command));

				// Test undo
				getTransactionalEditingDomain().getCommandStack().execute(getTransactionalEditingDomain().getCommandStack().getUndoCommand());
				// Test redo
				getTransactionalEditingDomain().getCommandStack().execute(getTransactionalEditingDomain().getCommandStack().getRedoCommand());

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
		dropRequest.setLocation(new Point(20, 20));

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
				getTransactionalEditingDomain().getCommandStack().execute(new GEFtoEMFCommandWrapper(command));

				// Test undo
				getTransactionalEditingDomain().getCommandStack().execute(getTransactionalEditingDomain().getCommandStack().getUndoCommand());
				// Test redo
				getTransactionalEditingDomain().getCommandStack().execute(getTransactionalEditingDomain().getCommandStack().getRedoCommand());

				// Test the results then
				// fail("Result tests not implemented.");
			}
		}
	}

	public static void createFromPalette(String toolId, View containerView, boolean isAllowed) throws Exception {

		if(isAllowed) {
			createFromPalette(toolId, containerView, isAllowed, true);
		} else {
			createFromPalette(toolId, containerView, isAllowed, false);
		}

	}

	public static void createFromPalette(String toolId, View containerView, boolean isAllowed, boolean execute) throws Exception {

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
					getTransactionalEditingDomain().getCommandStack().execute(new GEFtoEMFCommandWrapper(command));

					// Test undo
					getTransactionalEditingDomain().getCommandStack().execute(getTransactionalEditingDomain().getCommandStack().getUndoCommand());
					// Test redo
					getTransactionalEditingDomain().getCommandStack().execute(getTransactionalEditingDomain().getCommandStack().getRedoCommand());
				}
				// Test the results then
				// fail("Result tests not implemented.");
			}

		}
	}

	public static Request getCreateRequest(Tool tool) throws Exception {

		if(tool instanceof AspectUnspecifiedTypeCreationTool) {
			AspectUnspecifiedTypeCreationTool creationTool = (AspectUnspecifiedTypeCreationTool)tool;
			// Don't forget to set the diagram viewer (required for preferenceHints to mimic manual creation)
			creationTool.setViewer(getDiagramEditor().getDiagramGraphicalViewer());

			return creationTool.createCreateRequest();

		} else if(tool instanceof AspectUnspecifiedTypeConnectionTool) {
			throw new Exception("Test support not implemented for this kind of tool.");
		}

		throw new Exception("Unexpected kind of creation tool.");
	}
}
