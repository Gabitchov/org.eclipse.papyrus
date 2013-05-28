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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils;

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils.getDiagramEditor;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils.getEditPart;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils.getPaletteTool;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils.getTransactionalEditingDomain;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils.createElement;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.action.global.GlobalAction;
import org.eclipse.gmf.runtime.common.ui.action.internal.actions.global.GlobalCopyAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.PopupMenuCommand;
import org.eclipse.gmf.runtime.diagram.ui.menus.PopupMenu;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.SelectAndExecuteCommand;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd;
import org.eclipse.papyrus.sysml.diagram.internalblock.Activator;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool.CreateAspectUnspecifiedTypeConnectionRequest;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLUtil;
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

	public static void altDropFromModelExplorer(EObject eObject, View containerView, List<String> expectedCommandNames, boolean isAllowed) throws Exception {
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
				// Simple command
				if(expectedCommandNames.size() == 1) {
					if(expectedCommandNames.get(0).equals(command.getLabel())) {
						// Ok the command can be executed.
						defaultExecutionTest(command);
						// Test the results then
						// fail("Result tests not implemented.");
						EditorUtils.getCommandStack().undo();
					} else {
						fail("The expected kind of command was {" + expectedCommandNames.get(0) + "}, but was {" + command.getLabel() + "}");
					}
				} else if(expectedCommandNames.size() > 1) {
					ICommand tmpCommand = (command instanceof ICommandProxy) ? ((ICommandProxy)command).getICommand() : null;
					if((tmpCommand == null) || !(tmpCommand instanceof SelectAndExecuteCommand)) {
						fail("The drop command is not a selact and execute command.");
					}
					// Field accessibility modification to review elementary drop command available as
					// SelectAndExecuteCommand choices.
					SelectAndExecuteCommand selectCommand = (SelectAndExecuteCommand)tmpCommand;
					Field popupField = PopupMenuCommand.class.getDeclaredField("popupMenu");
					popupField.setAccessible(true);
					PopupMenu menu = (PopupMenu)popupField.get(selectCommand);
					Field content = PopupMenu.class.getDeclaredField("content");
					content.setAccessible(true);
					List<CompoundCommand> commandList = (List<CompoundCommand>)content.get(menu);
					if(commandList.size() != expectedCommandNames.size()) {
						fail("Unexpected number of possible alternate drop command.");
					}
					for(int i = 0; i < commandList.size(); i++) {
						CompoundCommand subCommand = commandList.get(i);
						if(expectedCommandNames.get(i).equals(subCommand.getLabel())) {
							// Ok the command can be executed.
							defaultExecutionTest(subCommand);
							// Add one more undo to go back in initial state before testing next command
							EditorUtils.getCommandStack().undo();;
							// Test the results then
							// fail("Result tests not implemented.");
						} else {
							fail("The expected kind of command was {" + expectedCommandNames.get(i) + "}.");
						}
					}
				}
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

	public static Request getCreateRequest(final Tool tool) throws Exception {

		// Don't forget to set the diagram viewer (required for preferenceHints to mimic manual creation)
		final IDiagramGraphicalViewer viewer = getDiagramEditor().getDiagramGraphicalViewer();

		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				try {
					tool.setViewer(viewer);
				} catch (Exception ex) {
					ex.printStackTrace(System.out);
				}
			}
		});

		if(tool instanceof AspectUnspecifiedTypeCreationTool) {
			AspectUnspecifiedTypeCreationTool creationTool = (AspectUnspecifiedTypeCreationTool)tool;
			return creationTool.createCreateRequest();
		} else if(tool instanceof AspectUnspecifiedTypeConnectionTool) {
			AspectUnspecifiedTypeConnectionTool connectionTool = (AspectUnspecifiedTypeConnectionTool)tool;
			return connectionTool.new CreateAspectUnspecifiedTypeConnectionRequest(connectionTool.getElementTypes(), false, Activator.DIAGRAM_PREFERENCES_HINT);
		}

		throw new Exception("Unexpected kind of creation tool.");
	}

	public static void createEdgeFromPalette(String toolId, View sourceView, View targetView, boolean isAllowed) throws Exception {
		// Execute command only when the command is expected to be executable
		createEdgeFromPalette(toolId, sourceView, targetView, isAllowed, isAllowed);
	}

	public static EObject createEdgeFromPalette(String toolId, View sourceView, View targetView, boolean isAllowed, boolean execute) throws Exception {
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
					return null;
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
					return null;
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
						return null;
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
							// Retrieve created object via nested ElementAndViewCreationRequest.
							View newView = null;
							Iterator<?> it = createRequest.getAllRequests().iterator();
							while(it.hasNext() && newView == null) {
								CreateConnectionViewAndElementRequest subRequest = (CreateConnectionViewAndElementRequest)it.next();
								newView = (View)subRequest.getConnectionViewDescriptor().getAdapter(View.class);
							}
							if(newView != null) {
								return newView.getElement();
							} else {
								fail("No edge seem to have been created.");
							}
						}
						// Test the results then
						// fail("Result tests not implemented.");
					}
				}
			}
		}
		return null;
	}

	public static void createEdgeConnectorFromPalette(String toolId, View sourceView, View targetView, boolean isAllowed, List<Property> nestedSourcePath, List<Property> nestedTargetPath) throws Exception {
		createEdgeConnectorFromPalette(toolId, sourceView, targetView, isAllowed, isAllowed, nestedSourcePath, nestedTargetPath);
	}

	public static void createEdgeConnectorFromPalette(String toolId, View sourceView, View targetView, boolean isAllowed, boolean execute, List<Property> nestedSourcePath, List<Property> nestedTargetPath) throws Exception {
		EObject newLink = createEdgeFromPalette(toolId, sourceView, targetView, isAllowed, execute);
		// Abort if the command is not supposed to be executable
		if(!isAllowed) {
			return;
		}
		if((newLink == null) || (!(newLink instanceof org.eclipse.uml2.uml.Connector))) {
			fail("No edge or unexpected kind of edge created.");
		}
		// If previous test have not failed the execution / undo / re-do has been done
		org.eclipse.uml2.uml.Connector connector = (org.eclipse.uml2.uml.Connector)newLink;
		// Test source connector end	
		NestedConnectorEnd sourceNestedConnectorEnd = UMLUtil.getStereotypeApplication(connector.getEnds().get(0), NestedConnectorEnd.class);
		if(nestedSourcePath.isEmpty()) {
			Assert.assertNull("No nested connector end stereotype should be applied on source.", sourceNestedConnectorEnd);
		} else {
			Assert.assertNotNull("Nested connector end stereotype should be applied on source.", sourceNestedConnectorEnd);
			Assert.assertEquals("Nested property path is incorrect for source", nestedSourcePath, sourceNestedConnectorEnd.getPropertyPath());
			//			if(!sourceNestedConnectorEnd.getPropertyPath().equals(nestedSourcePath)) {
			//				fail("The nested property path is incorrect for source.");
			//			}
		}
		// Test target connector end	
		NestedConnectorEnd targetNestedConnectorEnd = UMLUtil.getStereotypeApplication(connector.getEnds().get(1), NestedConnectorEnd.class);
		if(nestedTargetPath.isEmpty()) {
			Assert.assertNull("No nested connector end stereotype should be applied on target.", targetNestedConnectorEnd);
		} else {
			Assert.assertNotNull("Nested connector end stereotype should be applied on target.", targetNestedConnectorEnd);
			Assert.assertEquals("Nested property path is incorrect for target", nestedTargetPath, targetNestedConnectorEnd.getPropertyPath());
			//			if(!targetNestedConnectorEnd.getPropertyPath().equals(nestedTargetPath)) {
			//				fail("The nested property path is incorrect for target.");
			//			}
		}
	}

	public static void createEdgeConnectorAndTestDelegateFromPalette(String toolId, View sourceView, View targetView, boolean isAllowed, ConnectableElement expectedSourcePartWithPort, ConnectableElement expectedTargetPartWithPort) throws Exception {
		createEdgeConnectorAndTestDelegateFromPalette(toolId, sourceView, targetView, isAllowed, isAllowed, expectedSourcePartWithPort, expectedTargetPartWithPort);
	}

	public static void createEdgeConnectorAndTestDelegateFromPalette(String toolId, View sourceView, View targetView, boolean isAllowed, boolean execute, ConnectableElement expectedSourcePartWithPort, ConnectableElement expectedTargetPartWithPort) throws Exception {
		EObject newLink = createEdgeFromPalette(toolId, sourceView, targetView, isAllowed, execute);
		// Abort if the command is not supposed to be executable
		if(!isAllowed) {
			return;
		}
		if((newLink == null) || (!(newLink instanceof org.eclipse.uml2.uml.Connector))) {
			fail("No edge or unexpected kind of edge created.");
		}
		// If previous test have not failed the execution / undo / re-do has been done
		org.eclipse.uml2.uml.Connector connector = (org.eclipse.uml2.uml.Connector)newLink;
		// Test source connector end	
		ConnectorEnd sourceConnectorEnd = connector.getEnds().get(0);
		if(sourceConnectorEnd.getPartWithPort() != expectedSourcePartWithPort) {
			fail("The partWithPort is incorrect for source.");
		}
		// Test target connector end	
		ConnectorEnd targetConnectorEnd = connector.getEnds().get(1);
		if(targetConnectorEnd.getPartWithPort() != expectedTargetPartWithPort) {
			fail("The partWithPort is incorrect for target.");
		}
	}

	public static void reorientRelationshipSource(View relationshipView, View newSourceView, boolean isAllowed) throws Exception {
		reorientRelationship((Connector)relationshipView, newSourceView, ReorientRelationshipRequest.REORIENT_SOURCE, isAllowed);
	}

	public static void reorientRelationshipTarget(View relationshipView, View newTargetView, boolean isAllowed) throws Exception {
		reorientRelationship((Connector)relationshipView, newTargetView, ReorientRelationshipRequest.REORIENT_TARGET, isAllowed);
	}

	public static void reorientRelationship(Connector relationshipView, View newEndView, int reorientDirection, boolean isAllowed) throws Exception {
		// Prepare request and add
		String reconnectDirection = (ReorientRelationshipRequest.REORIENT_SOURCE == reorientDirection) ? RequestConstants.REQ_RECONNECT_SOURCE : RequestConstants.REQ_RECONNECT_TARGET;
		ReconnectRequest reconnectRequest = new ReconnectRequest(relationshipView);
		reconnectRequest.setTargetEditPart(getEditPart(newEndView));
		reconnectRequest.setConnectionEditPart((ConnectionEditPart)getEditPart(relationshipView));
		reconnectRequest.setType(reconnectDirection);
		// Get command
		Command reorientCommand = getEditPart(newEndView).getCommand(reconnectRequest);
		// Test the target command
		if((reorientCommand == null) || !(reorientCommand.canExecute())) { // Non-executable command
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
				defaultExecutionTest(reorientCommand);
				// Test the results then
				// fail("Result tests not implemented.");
			}
		}
	}

	public static void reorientConnectorSource(View relationshipView, View newSourceView, boolean isAllowed) throws Exception {
		List<Property> nestedPath = Collections.emptyList();
		reorientConnectorSource(relationshipView, newSourceView, isAllowed, nestedPath);
	}

	public static void reorientConnectorTarget(View relationshipView, View newTargetView, boolean isAllowed) throws Exception {
		List<Property> nestedPath = Collections.emptyList();
		reorientConnectorTarget(relationshipView, newTargetView, isAllowed, nestedPath);
	}

	public static void reorientConnectorSource(View relationshipView, View newSourceView, boolean isAllowed, List<Property> nestedPath) throws Exception {
		reorientConnector((Connector)relationshipView, newSourceView, ReorientRelationshipRequest.REORIENT_SOURCE, isAllowed, nestedPath);
	}

	public static void reorientConnectorTarget(View relationshipView, View newTargetView, boolean isAllowed, List<Property> nestedPath) throws Exception {
		reorientConnector((Connector)relationshipView, newTargetView, ReorientRelationshipRequest.REORIENT_TARGET, isAllowed, nestedPath);
	}

	public static void reorientConnector(Connector relationshipView, View newEndView, int reorientDirection, boolean isAllowed, List<Property> nestedPath) throws Exception {
		reorientRelationship(relationshipView, newEndView, reorientDirection, isAllowed);
		// Abort if the command is not supposed to be executable
		if(!isAllowed) {
			return;
		}
		// If previous test have not failed the execution / undo / re-do has been done
		org.eclipse.uml2.uml.Connector connector = (org.eclipse.uml2.uml.Connector)relationshipView.getElement();
		ConnectorEnd modifiedConnectorEnd = (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) ? connector.getEnds().get(0) : connector.getEnds().get(1);
		NestedConnectorEnd nestedConnectorEnd = UMLUtil.getStereotypeApplication(modifiedConnectorEnd, NestedConnectorEnd.class);
		if(nestedPath.isEmpty()) {
			Assert.assertNull("No nested connector end stereotype should be applied.", nestedConnectorEnd);
		} else {
			Assert.assertNotNull("Nested connector end stereotype should be applied.", nestedConnectorEnd);
			Assert.assertEquals("Invalid nested path", nestedPath, nestedConnectorEnd.getPropertyPath()); 
		}
	}

	public static void reorientConnectorSourceAndTestDelegate(View relationshipView, View newSourceView, boolean isAllowed, ConnectableElement expectedSourcePartWithPort, ConnectableElement expectedTargetPartWithPort) throws Exception {
		reorientConnectorAndTestDelegate((Connector)relationshipView, newSourceView, ReorientRelationshipRequest.REORIENT_SOURCE, isAllowed, expectedSourcePartWithPort, expectedTargetPartWithPort);
	}

	public static void reorientConnectorTargetAndTestDelegate(View relationshipView, View newTargetView, boolean isAllowed, ConnectableElement expectedSourcePartWithPort, ConnectableElement expectedTargetPartWithPort) throws Exception {
		reorientConnectorAndTestDelegate((Connector)relationshipView, newTargetView, ReorientRelationshipRequest.REORIENT_TARGET, isAllowed, expectedSourcePartWithPort, expectedTargetPartWithPort);
	}

	public static void reorientConnectorAndTestDelegate(Connector relationshipView, View newEndView, int reorientDirection, boolean isAllowed, ConnectableElement expectedSourcePartWithPort, ConnectableElement expectedTargetPartWithPort) throws Exception {
		reorientRelationship(relationshipView, newEndView, reorientDirection, isAllowed);
		// Abort if the command is not supposed to be executable
		if(!isAllowed) {
			return;
		}
		// If previous test have not failed the execution / undo / re-do has been done
		org.eclipse.uml2.uml.Connector connector = (org.eclipse.uml2.uml.Connector)relationshipView.getElement();
		ConnectorEnd modifiedConnectorEnd = (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) ? connector.getEnds().get(0) : connector.getEnds().get(1);
		ConnectorEnd oppositeConnectorEnd = (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) ? connector.getEnds().get(1) : connector.getEnds().get(0);
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) { // re-orient source
			// Test source connector end
			Assert.assertEquals("The partWithPort is incorrect for source (re-oriented).", expectedSourcePartWithPort, modifiedConnectorEnd.getPartWithPort());
			//			if(modifiedConnectorEnd.getPartWithPort() != expectedSourcePartWithPort) {
			//				fail("The partWithPort is incorrect for source (re-oriented).");
			//			}
			// Test target connector end
			Assert.assertEquals("The partWithPort is incorrect for target (opposite end).", expectedTargetPartWithPort, oppositeConnectorEnd.getPartWithPort());
			//			if(oppositeConnectorEnd.getPartWithPort() != expectedTargetPartWithPort) {
			//				fail("The partWithPort is incorrect for target (opposite end).");
			//			}
		} else { // re-orient target
			// Test source connector end
			Assert.assertEquals("The partWithPort is incorrect for target (re-oriented).", expectedTargetPartWithPort, modifiedConnectorEnd.getPartWithPort());
			//			if(modifiedConnectorEnd.getPartWithPort() != expectedTargetPartWithPort) {
			//				fail("The partWithPort is incorrect for target .");
			//			}
			// Test target connector end
			Assert.assertEquals("The partWithPort is incorrect for source (opposite end).", expectedSourcePartWithPort, oppositeConnectorEnd.getPartWithPort());
			//			if(oppositeConnectorEnd.getPartWithPort() != expectedSourcePartWithPort) {
			//				fail("The partWithPort is incorrect for source (opposite end).");
			//			}
		}
	}

	public static void setEncapsulationDeleteConnectorTest(Element block, View sourceView, View targetView, boolean canCreateConnector, boolean isConnectorDestroyExpected) throws Exception {
		if(!canCreateConnector) {
			return; // abort
		}
		// Make sure the block is not encapsulated before Connector creation.
		TestPrepareUtils.setBlockIsEncapsulated(block, false);
		// Create connector
		org.eclipse.uml2.uml.Connector connector = (org.eclipse.uml2.uml.Connector)createEdgeFromPalette("internalblock.tool.connector", sourceView, targetView, true, true);
		// Prepare set encapsulated command and execute (with undo, re-do).
		Block blockApp = UMLUtil.getStereotypeApplication(block, Block.class);
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(blockApp);
		if(provider == null) {
			fail("Could not get IElementEditService for Block stereotype application.");
		}
		IEditCommandRequest setEncapsulationRequest = new SetRequest(getTransactionalEditingDomain(), blockApp, BlocksPackage.eINSTANCE.getBlock_IsEncapsulated(), true);
		ICommand setEncapsulationCommand = provider.getEditCommand(setEncapsulationRequest);
		defaultExecutionTest(new ICommandProxy(setEncapsulationCommand));
		// Test if the Connector have been destroyed
		if(isConnectorDestroyExpected) {
			if(connector.eResource() != null) { // connector destroyed has no container 
				fail("Connector was expected to be destroyed.");
			}
		} else {
			if(connector.eResource() == null) { // connector destroyed has no container 
				fail("Connector was not expected to be destroyed.");
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
		// Test execution
		historyEventType = OperationHistoryEvent.DONE;
		EditorUtils.getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		if(historyEventType == OperationHistoryEvent.OPERATION_NOT_OK) {
			fail("Command execution failed ()");
		}
		// Test undo
		historyEventType = OperationHistoryEvent.DONE;
		EditorUtils.getCommandStack().undo();
		if(historyEventType == OperationHistoryEvent.OPERATION_NOT_OK) {
			fail("Command undo failed ()");
		}
		// Test redo
		historyEventType = OperationHistoryEvent.DONE;
		EditorUtils.getCommandStack().redo();
		if(historyEventType == OperationHistoryEvent.OPERATION_NOT_OK) {
			fail("Command redo failed ()");
		}
		// Remove listener.
		history.removeOperationHistoryListener(historyChange);
	}
}
