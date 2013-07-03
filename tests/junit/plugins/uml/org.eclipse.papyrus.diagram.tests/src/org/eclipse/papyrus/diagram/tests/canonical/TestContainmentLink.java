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

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.uml2.uml.Element;

public abstract class TestContainmentLink extends TestLink {

	/**
	 * Test view deletion.
	 * 
	 * @param type
	 *        the type
	 */
	@Override
	public void testViewDeletion(IElementType type) {
		//DELETION OF THE VIEW
		assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == 1);
		assertTrue(VIEW_DELETION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 3);
		assertTrue(VIEW_DELETION + INITIALIZATION_TEST, ((Element)source.resolveSemanticElement()).getOwnedElements().size() == 1);
		Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
		Command command = ((ConnectionEditPart)source.getChildBySemanticHint("3032").getSourceConnections().get(0)).getCommand(deleteViewRequest);
		assertNotNull(VIEW_DELETION + COMMAND_NULL, command);
		assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == 0);
		assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == 3);
		assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, ((Element)source.resolveSemanticElement()).getOwnedElements().size() == 1);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == 1);
		assertTrue(VIEW_DELETION + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == 3);
		assertTrue(VIEW_DELETION + TEST_THE_UNDO, ((Element)source.resolveSemanticElement()).getOwnedElements().size() == 1);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == 0);
		assertTrue(VIEW_DELETION + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == 3);
		assertTrue(VIEW_DELETION + TEST_THE_REDO, ((Element)source.resolveSemanticElement()).getOwnedElements().size() == 1);
	}

	/**
	 * Test destroy.
	 * 
	 * @param type
	 *        the type
	 */
	@Override
	public void testDestroy(IElementType type) {
		//DESTROY SEMANTIC+ VIEW
		assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == 1);
		assertTrue(CREATION + INITIALIZATION_TEST, ((Element)source.resolveSemanticElement()).getOwnedElements().size() == 1);
		assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 3);
		Request deleteViewRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
		Command command = ((ConnectionEditPart)source.getChildBySemanticHint("3032").getSourceConnections().get(0)).getCommand(deleteViewRequest);
		assertNotNull(DESTROY_DELETION + COMMAND_NULL, command);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == 0);
		assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == 4);
		assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, ((Element)source.resolveSemanticElement()).getOwnedElements().size() == 0);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == 1);
		assertTrue(DESTROY_DELETION + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == 3);
		assertTrue(DESTROY_DELETION + TEST_THE_UNDO, ((Element)source.resolveSemanticElement()).getOwnedElements().size() == 1);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == 0);
		assertTrue(DESTROY_DELETION + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == 4);
		assertTrue(DESTROY_DELETION + TEST_THE_REDO, ((Element)source.resolveSemanticElement()).getOwnedElements().size() == 0);
	}

	/**
	 * Test drop.
	 * 
	 * @param type
	 *        the type
	 */
	@Override
	public void testDrop(IElementType type) {
		//DROP
		//it is impossible to drop but you can recreat the link between this element
		assertTrue(DROP + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 4);
		assertTrue(DROP + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 3);
		assertTrue(DROP + INITIALIZATION_TEST, ((Element)source.resolveSemanticElement()).getOwnedElements().size() == 1);
		assertTrue(DROP + TEST_THE_REDO, ((Diagram)getRootView()).getEdges().size() == 0);
	}

	/**
	 * Test to create a link.
	 * 
	 * @param linkType
	 *        the type
	 */
	@Override
	public void testToCreateALink(IElementType linkType) {
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 4);
		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 4);
		assertTrue(CREATION + INITIALIZATION_TEST, ((Element)source.resolveSemanticElement()).getOwnedElements().size() == 0);
		Command command = target.getCommand(createConnectionViewRequest(linkType, source, target));
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(CREATION + TEST_THE_EXECUTION, ((Diagram)getRootView()).getEdges().size() == 1);
		assertTrue(CREATION + TEST_THE_EXECUTION, ((Element)source.resolveSemanticElement()).getOwnedElements().size() == 1);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(CREATION + TEST_THE_EXECUTION, ((Diagram)getRootView()).getEdges().size() == 0);
		assertTrue(CREATION + TEST_THE_UNDO, ((Element)source.resolveSemanticElement()).getOwnedElements().size() == 0);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(CREATION + TEST_THE_EXECUTION, ((Diagram)getRootView()).getEdges().size() == 1);
		assertTrue(CREATION + TEST_THE_EXECUTION, ((Element)source.resolveSemanticElement()).getOwnedElements().size() == 1);
	}

	@Override
	public void installEnvironment(IElementType sourceType, IElementType targetType) {
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 0);
		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 0);
		//create the source
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(sourceType, getDiagramEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(new Point(100, 100));
		Command command = getDiagramEditPart().getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		//create the source player to test reconnect
		requestcreation = CreateViewRequestFactory.getCreateShapeRequest(sourceType, getDiagramEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(new Point(100, 300));
		command = getDiagramEditPart().getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		//create the target
		requestcreation = CreateViewRequestFactory.getCreateShapeRequest(targetType, getDiagramEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(new Point(300, 100));
		command = getDiagramEditPart().getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		//create the target player to test reconnect
		requestcreation = CreateViewRequestFactory.getCreateShapeRequest(targetType, getDiagramEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(new Point(300, 300));
		command = getDiagramEditPart().getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		source = (GraphicalEditPart)getDiagramEditPart().getChildren().get(0);
		sourcePlayer = (GraphicalEditPart)getDiagramEditPart().getChildren().get(1);
		target = (GraphicalEditPart)getDiagramEditPart().getChildren().get(2);
		targetPlayer = (GraphicalEditPart)getDiagramEditPart().getChildren().get(3);
	}

	@Override
	public void testTargetReconnectAMultiLink(IElementType type) {
		//target reconnection
		ReconnectRequest reconnectRequest = new ReconnectRequest();
		assertTrue(THE_LINK_RECONNECT_EXISTS, ((ConnectionEditPart)source.getChildBySemanticHint("3032").getSourceConnections().get(0)) != null);
		ConnectionEditPart binaryLink = ((ConnectionEditPart)source.getChildBySemanticHint("3032").getSourceConnections().get(0));
		reconnectRequest.setConnectionEditPart(binaryLink);
		reconnectRequest.setTargetEditPart(targetPlayer);
		reconnectRequest.setType(RequestConstants.REQ_RECONNECT_TARGET);
		Command cmd = targetPlayer.getCommand(reconnectRequest);
		assertTrue(RECONNECTION_TARGET + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, cmd.canExecute() == true);
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().execute(cmd);
		// EditorUtils.getTransactionalEditingDomain().getCommandStack().execute(cmd);
		assertTrue(RECONNECTION_TARGET + TEST_THE_EXECUTION, ((Diagram)getRootView()).getEdges().size() == 1);
		assertTrue(RECONNECTION_TARGET + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == 3);
		assertTrue(LINK_EXISTS_RECONNECTION_ON_TARGET, binaryLink.getTarget().equals(targetPlayer));
		//undo
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(LINK_EXISTS_RECONNECTION_ON_TARGET + TEST_THE_UNDO, binaryLink.getTarget().equals(target));
		//redo
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(LINK_EXISTS_RECONNECTION_ON_TARGET + TEST_THE_REDO, binaryLink.getTarget().equals(targetPlayer));
	}

	@Override
	public void testSourceReconnectAMultiLink(IElementType type) {
		//target reconnection
		ReconnectRequest reconnectRequest = new ReconnectRequest();
		assertTrue(THE_LINK_TO_RECONNECT_EXISTS, ((ConnectionEditPart)source.getChildBySemanticHint("3032").getSourceConnections().get(0)) != null);
		ConnectionEditPart branch = ((ConnectionEditPart)source.getChildBySemanticHint("3032").getSourceConnections().get(0));
		reconnectRequest.setConnectionEditPart(branch);
		reconnectRequest.setTargetEditPart(sourcePlayer);
		reconnectRequest.setType(RequestConstants.REQ_RECONNECT_SOURCE);
		Command cmd = sourcePlayer.getCommand(reconnectRequest);
		//it is impossible to reconnect source of the link
		assertTrue(RECONNECTION_SOURCE + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, cmd.canExecute() == false);
	}

	/**
	 * Test to manage top node.
	 * 
	 * @param type
	 *        the type
	 * @param containerType
	 *        the container type
	 */
	public void testToManageLink(IElementType sourceType, IElementType targetType, IElementType linkType, IElementType containerType) {
		installEnvironment(sourceType, targetType);
		testToCreateALink(linkType);
		testDestroy(linkType);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		testViewDeletion(linkType);
		testDrop(linkType);
		testRecreation(linkType);
		testSourceReconnectAMultiLink(linkType);
		testTargetReconnectAMultiLink(linkType);
	}

	public void testRecreation(IElementType linkType) {
		assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == 0);
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 4);
		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 3);
		assertTrue(CREATION + INITIALIZATION_TEST, ((Element)source.resolveSemanticElement()).getOwnedElements().size() == 1);
		Command command = target.getCommand(createConnectionViewRequest(linkType, source, target));
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == 1);
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 4);
		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 3);
		assertTrue(CREATION + INITIALIZATION_TEST, ((Element)source.resolveSemanticElement()).getOwnedElements().size() == 1);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == 0);
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 4);
		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 3);
		assertTrue(CREATION + INITIALIZATION_TEST, ((Element)source.resolveSemanticElement()).getOwnedElements().size() == 1);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == 1);
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 4);
		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 3);
		assertTrue(CREATION + INITIALIZATION_TEST, ((Element)source.resolveSemanticElement()).getOwnedElements().size() == 1);
	}
}
