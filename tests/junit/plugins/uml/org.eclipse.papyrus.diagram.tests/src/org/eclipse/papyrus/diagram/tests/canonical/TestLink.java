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

import java.util.ArrayList;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.uml2.uml.Element;

// TODO: Auto-generated Javadoc
/**
 * The Class TestTopLink to test when this is link . The link is attached to a semantic element that has to be contained by the source and the target.
 * To adapt when source owns the created link
 */
public abstract class TestLink extends AbstractPapyrusTestCase {

	protected static final String THE_LINK_RECONNECT_EXISTS = "The Link exist";

	protected static final String RECONNECTION_TARGET = "Reconnection of target";

	protected static final String LINK_EXISTS_RECONNECTION_ON_TARGET = "Link exist on the target";

	protected static final String THE_LINK_TO_RECONNECT_EXISTS = "The Link exist";

	protected static final String RECONNECTION_SOURCE = "Reconnection of source";

	protected static final String LINK_EXISTS_RECONNECTION_ON_SOURCE = "Link exist on the source";

	protected GraphicalEditPart source = null;

	protected GraphicalEditPart sourcePlayer = null;

	protected GraphicalEditPart target = null;

	protected GraphicalEditPart targetPlayer = null;

	/**
	 * Test view deletion.
	 * 
	 * @param type
	 *        the type
	 */
	public void testViewDeletion(IElementType type) {
		//DELETION OF THE VIEW
		assertTrue(VIEW_DELETION + INITIALIZATION_TEST, source.getSourceConnections().size() == 1);
		assertTrue(VIEW_DELETION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 5);
		Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
		Command command = ((ConnectionEditPart)source.getSourceConnections().get(0)).getCommand(deleteViewRequest);
		assertNotNull(VIEW_DELETION + COMMAND_NULL, command);
		assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, source.getSourceConnections().size() == 0);
		assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == 5);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(VIEW_DELETION + TEST_THE_UNDO, source.getSourceConnections().size() == 1);
		assertTrue(VIEW_DELETION + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == 5);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(VIEW_DELETION + TEST_THE_REDO, source.getSourceConnections().size() == 0);
		assertTrue(VIEW_DELETION + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == 5);
	}

	/**
	 * Retrieves the TransactionalEditingDomain
	 * 
	 * @return the editing domain (can be null)
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		ServiceUtilsForActionHandlers serviceUtils = ServiceUtilsForActionHandlers.getInstance();
		TransactionalEditingDomain editingDomain = null;
		try {
			editingDomain = serviceUtils.getTransactionalEditingDomain();
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		return editingDomain;
	}

	/**
	 * Test destroy.
	 * 
	 * @param type
	 *        the type
	 */
	public void testDestroy(IElementType type) {
		//DESTROY SEMANTIC+ VIEW
		assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == 1);
		assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, source.getSourceConnections().size() == 1);
		assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 5);
		Request deleteViewRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
		Command command = ((ConnectionEditPart)source.getSourceConnections().get(0)).getCommand(deleteViewRequest);
		assertNotNull(DESTROY_DELETION + COMMAND_NULL, command);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, ((Diagram)getRootView()).getEdges().size() == 0);
		assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, source.getSourceConnections().size() == 0);
		assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == 4);
		assertTrue(DESTROY_DELETION + TEST_THE_UNDO, diagramEditor.getDiagramEditDomain().getDiagramCommandStack().canUndo() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(DESTROY_DELETION + TEST_THE_UNDO, ((Diagram)getRootView()).getEdges().size() == 1);
		assertTrue(DESTROY_DELETION + TEST_THE_UNDO, source.getSourceConnections().size() == 1);
		assertTrue(DESTROY_DELETION + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == 5);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == 0);
		assertTrue(DESTROY_DELETION + TEST_THE_REDO, source.getSourceConnections().size() == 0);
		assertTrue(DESTROY_DELETION + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == 4);
	}

	/**
	 * Test drop.
	 * 
	 * @param type
	 *        the type
	 */
	public void testDrop(IElementType type) {
		//DROP
		assertTrue(DROP + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 4);
		assertTrue(DROP + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 5);
		assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == 0);
		DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
		ArrayList<Element> list = new ArrayList<Element>();
		list.add(getRootSemanticModel().getOwnedElements().get(4));
		dropObjectsRequest.setObjects(list);
		dropObjectsRequest.setLocation(new Point(20, 20));
		Command command = getDiagramEditPart().getCommand(dropObjectsRequest);
		assertNotNull(DROP + COMMAND_NULL, command);
		assertTrue(DROP + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(DROP + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(DROP + TEST_THE_EXECUTION, getDiagramEditPart().getChildren().size() == 4);
		assertTrue(DROP + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == 5);
		assertTrue(DROP + TEST_THE_EXECUTION, ((Diagram)getRootView()).getEdges().size() == 1);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(DROP + TEST_THE_UNDO, getDiagramEditPart().getChildren().size() == 4);
		assertTrue(DROP + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == 5);
		assertTrue(DROP + TEST_THE_UNDO, ((Diagram)getRootView()).getEdges().size() == 0);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(DROP + TEST_THE_REDO, getDiagramEditPart().getChildren().size() == 4);
		assertTrue(DROP + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == 5);
		assertTrue(DROP + TEST_THE_REDO, ((Diagram)getRootView()).getEdges().size() == 1);
	}

	/**
	 * Test change container.
	 * 
	 * @param type
	 *        the type
	 * @param containerType
	 *        the container type
	 */
	public void testChangeContainer(IElementType type, IElementType containerType) {
		//CHANGE CONTAINER
		assertTrue(CHANGE_CONTAINER + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 1);
		assertTrue(CHANGE_CONTAINER + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 1);
		Request requestcreation = CreateViewRequestFactory.getCreateShapeRequest(containerType, getDiagramEditPart().getDiagramPreferencesHint());
		Command command = getDiagramEditPart().getCommand(requestcreation);
		assertNotNull(CONTAINER_CREATION + COMMAND_NULL, command);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(CONTAINER_CREATION + TEST_THE_EXECUTION, getRootView().getChildren().size() == 2);
		GraphicalEditPart containerEditPart = (GraphicalEditPart)getDiagramEditPart().getChildren().get(1);
		ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(RequestConstants.REQ_ADD);
		changeBoundsRequest.setEditParts((EditPart)getDiagramEditPart().getChildren().get(0));
		changeBoundsRequest.setLocation(new Point(30, 30));
		ShapeCompartmentEditPart compartment = null;
		int index = 0;
		while(compartment == null && index < containerEditPart.getChildren().size()) {
			if((containerEditPart.getChildren().get(index)) instanceof ShapeCompartmentEditPart) {
				compartment = (ShapeCompartmentEditPart)(containerEditPart.getChildren().get(index));
			}
			index++;
		}
		assertTrue("Container not found", compartment != null);
		command = compartment.getCommand(changeBoundsRequest);
		assertNotNull(CHANGE_CONTAINER, command);
		assertTrue(CHANGE_CONTAINER + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CHANGE_CONTAINER + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(CHANGE_CONTAINER + TEST_THE_EXECUTION, getRootView().getChildren().size() == 1);
		assertTrue(CHANGE_CONTAINER + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == 1);
		assertTrue(CHANGE_CONTAINER + TEST_THE_EXECUTION, compartment.getChildren().size() == 1);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(CHANGE_CONTAINER + TEST_THE_UNDO, getRootView().getChildren().size() == 2);
		assertTrue(CHANGE_CONTAINER + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == 2);
		assertTrue(CHANGE_CONTAINER + TEST_THE_EXECUTION, compartment.getChildren().size() == 0);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(CHANGE_CONTAINER + TEST_THE_REDO, getRootView().getChildren().size() == 1);
		assertTrue(CHANGE_CONTAINER + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == 1);
		assertTrue(CHANGE_CONTAINER + TEST_THE_EXECUTION, compartment.getChildren().size() == 1);
	}

	/**
	 * Test to create a link.
	 * 
	 * @param linkType
	 *        the type
	 */
	public void testToCreateALink(IElementType linkType) {
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 4);
		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 4);
		Command command = target.getCommand(createConnectionViewRequest(linkType, source, target));
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == 1);
		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 5);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, getRootView().getChildren().size() == 4);
		assertTrue(CREATION + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == 4);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(CREATION + TEST_THE_REDO, ((Diagram)getRootView()).getEdges().size() == 1);
		assertTrue(CREATION + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == 5);
	}

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

	public CreateConnectionViewRequest createConnectionViewRequest(IElementType type, EditPart source, EditPart target) {
		CreateConnectionViewRequest connectionRequest = CreateViewRequestFactory.getCreateConnectionRequest(type, ((IGraphicalEditPart)getDiagramEditPart()).getDiagramPreferencesHint());
		connectionRequest.setSourceEditPart(null);
		connectionRequest.setTargetEditPart(source);
		connectionRequest.setType(RequestConstants.REQ_CONNECTION_START);
		source.getCommand(connectionRequest);
		// Now, setup the request in preparation to get the
		// connection end
		// command.
		connectionRequest.setSourceEditPart(source);
		connectionRequest.setTargetEditPart(target);
		connectionRequest.setType(RequestConstants.REQ_CONNECTION_END);
		return connectionRequest;
	}

	public void testTargetReconnectAMultiLink(IElementType type) {
		//target reconnection
		ReconnectRequest reconnectRequest = new ReconnectRequest();
		assertTrue(THE_LINK_RECONNECT_EXISTS, (ConnectionEditPart)target.getTargetConnections().get(0) != null);
		ConnectionEditPart binaryLink = (ConnectionEditPart)target.getTargetConnections().get(0);
		reconnectRequest.setConnectionEditPart(binaryLink);
		reconnectRequest.setTargetEditPart(targetPlayer);
		reconnectRequest.setType(RequestConstants.REQ_RECONNECT_TARGET);
		Command cmd = targetPlayer.getCommand(reconnectRequest);
		assertTrue(RECONNECTION_TARGET + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, cmd.canExecute() == true);
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().execute(cmd);
		// EditorUtils.getTransactionalEditingDomain().getCommandStack().execute(cmd);
		assertTrue(RECONNECTION_TARGET + TEST_THE_EXECUTION, ((Diagram)getRootView()).getEdges().size() == 1);
		assertTrue(RECONNECTION_TARGET + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == 5);
		assertTrue(LINK_EXISTS_RECONNECTION_ON_TARGET, binaryLink.getTarget().equals(targetPlayer));
		//undo
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(LINK_EXISTS_RECONNECTION_ON_TARGET + TEST_THE_UNDO, binaryLink.getTarget().equals(target));
		//redo
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(LINK_EXISTS_RECONNECTION_ON_TARGET + TEST_THE_REDO, binaryLink.getTarget().equals(targetPlayer));
	}

	public void testSourceReconnectAMultiLink(IElementType type) {
		//target reconnection
		ReconnectRequest reconnectRequest = new ReconnectRequest();
		assertTrue(THE_LINK_TO_RECONNECT_EXISTS, (ConnectionEditPart)source.getSourceConnections().get(0) != null);
		ConnectionEditPart branch = (ConnectionEditPart)source.getSourceConnections().get(0);
		reconnectRequest.setConnectionEditPart(branch);
		reconnectRequest.setTargetEditPart(sourcePlayer);
		reconnectRequest.setType(RequestConstants.REQ_RECONNECT_SOURCE);
		Command cmd = sourcePlayer.getCommand(reconnectRequest);
		assertTrue(RECONNECTION_SOURCE + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, cmd.canExecute() == true);
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().execute(cmd);
		assertTrue(RECONNECTION_SOURCE + TEST_THE_EXECUTION, ((Diagram)getRootView()).getEdges().size() == 1);
		assertTrue(RECONNECTION_SOURCE + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == 5);
		assertTrue(LINK_EXISTS_RECONNECTION_ON_SOURCE + TEST_THE_EXECUTION, branch.getSource().equals(sourcePlayer));
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(LINK_EXISTS_RECONNECTION_ON_SOURCE + TEST_THE_UNDO, branch.getSource().equals(source));
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(LINK_EXISTS_RECONNECTION_ON_SOURCE + TEST_THE_REDO, branch.getSource().equals(sourcePlayer));
	}

	/**
	 * Test to manage top node.
	 * 
	 * @param type
	 *        the type
	 * @param containerType
	 *        the container type
	 */
	public void testToManageLink(IElementType sourceType, IElementType targetType, IElementType linkType, IElementType containerType, boolean allowedOntheSame) {
		installEnvironment(sourceType, targetType);
		testToCreateALink(linkType);
		testDestroy(linkType);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		testViewDeletion(linkType);
		testDrop(linkType);
		testSourceReconnectAMultiLink(linkType);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		testTargetReconnectAMultiLink(linkType);
		testToCreateAlinkOnTheSame(linkType, allowedOntheSame);
		testToDropAlinkOnTheSame(linkType, allowedOntheSame);
	}

	/**
	 * test the drop of a link where the source and the target are the same objects
	 * 
	 * @param linkType
	 * @param allowed
	 */
	protected void testToDropAlinkOnTheSame(IElementType linkType, boolean allowed) {
		//DROP
		if(allowed) {
			assertTrue(DROP + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 4);
			assertTrue(DROP + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 6);
			assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == 2);
			DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
			ArrayList<Element> list = new ArrayList<Element>();
			list.add(getRootSemanticModel().getOwnedElements().get(5));
			dropObjectsRequest.setObjects(list);
			dropObjectsRequest.setLocation(new Point(20, 20));
			Command command = getDiagramEditPart().getCommand(dropObjectsRequest);
			assertNotNull(DROP + COMMAND_NULL, command);
			assertTrue(DROP + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
			assertTrue(DROP + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
			assertTrue(DROP + TEST_THE_EXECUTION, getDiagramEditPart().getChildren().size() == 4);
			assertTrue(DROP + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == 6);
			assertTrue(DROP + TEST_THE_EXECUTION, ((Diagram)getRootView()).getEdges().size() == 3);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
			assertTrue(DROP + TEST_THE_UNDO, getDiagramEditPart().getChildren().size() == 4);
			assertTrue(DROP + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == 6);
			assertTrue(DROP + TEST_THE_UNDO, ((Diagram)getRootView()).getEdges().size() == 2);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
			assertTrue(DROP + TEST_THE_REDO, getDiagramEditPart().getChildren().size() == 4);
			assertTrue(DROP + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == 6);
			assertTrue(DROP + TEST_THE_REDO, ((Diagram)getRootView()).getEdges().size() == 3);
		}
	}

	/**
	 * test the creation of a link where the source and the target are the same objects
	 * 
	 * @param linkType
	 * @param allowed
	 */
	protected void testToCreateAlinkOnTheSame(IElementType linkType, boolean allowed) {
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 4);
		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 5);
		Command command = target.getCommand(createConnectionViewRequest(linkType, source, source));
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == allowed);
		if(allowed) {
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
			assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == 2);
			assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 6);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
			assertTrue(CREATION + TEST_THE_UNDO, getRootView().getChildren().size() == 4);
			assertTrue(CREATION + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == 5);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
			assertTrue(CREATION + TEST_THE_REDO, ((Diagram)getRootView()).getEdges().size() == 2);
			assertTrue(CREATION + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == 6);
		}
	}
}
