package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getDiagramCommandStack;
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
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeConnectionTool.CreateAspectUnspecifiedTypeConnectionRequest;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.Activator;


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
				getDiagramCommandStack().execute(command);

				// Test undo - redo
				getDiagramCommandStack().undo();
				getDiagramCommandStack().redo();

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
				getDiagramCommandStack().execute(command);

				// Test undo - redo
				getDiagramCommandStack().undo();
				getDiagramCommandStack().redo();

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
				getDiagramCommandStack().execute(command);

				// Test undo - redo
				getDiagramCommandStack().undo();
				getDiagramCommandStack().redo();

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
					getDiagramCommandStack().execute(command);

					// Test undo - redo
					getDiagramCommandStack().undo();
					getDiagramCommandStack().redo();
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
			AspectUnspecifiedTypeConnectionTool connectionTool = (AspectUnspecifiedTypeConnectionTool)tool;
			// Don't forget to set the diagram viewer (required for preferenceHints to mimic manual creation)
			connectionTool.setViewer(getDiagramEditor().getDiagramGraphicalViewer());
			
			return  connectionTool.new CreateAspectUnspecifiedTypeConnectionRequest(connectionTool.getElementTypes(), false, Activator.DIAGRAM_PREFERENCES_HINT);
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
		CreateAspectUnspecifiedTypeConnectionRequest createRequest = (CreateAspectUnspecifiedTypeConnectionRequest) getCreateRequest(tool);
		
		// Test source creation command
		createRequest.setSourceEditPart(getEditPart(sourceView));	
		createRequest.setType(RequestConstants.REQ_CONNECTION_START);	
		Command srcCommand = getEditPart(sourceView).getCommand(createRequest);
		
		// Test source command
		if ((srcCommand == null) || !(srcCommand.canExecute())) { // Non-executable command
			if (targetView == null) { // Only test behavior on source
				if (!isAllowed) { 
					// Current behavior matches the expected results
					return;
				} else {
					fail("The command should be executable.");
				}
				
			} else { // Test complete creation, the command should necessary be executable
				fail("The command should be executable.");
			}

		} else { // Executable command
			if (targetView == null) { // Only test behavior on source
				if (!isAllowed) { 
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
				if ((tgtCommand == null) || !(tgtCommand.canExecute())) { // Non-executable command
						if (!isAllowed) { 
							// Current behavior matches the expected results
							return;
						} else {
							fail("The command should be executable.");
						}
				
				} else { // Executable command
					if (!isAllowed) {
						fail("The command should not be executable.");
					} else {
						// Current behavior matches the expected results
						if(execute) { // Test command execution
							getDiagramCommandStack().execute(tgtCommand);
			
							// Test undo - redo
							getDiagramCommandStack().undo();
							getDiagramCommandStack().redo();
						}
						
						// Test the results then
						// fail("Result tests not implemented.");
					}
				}
			}			
			
		}
	}
}
