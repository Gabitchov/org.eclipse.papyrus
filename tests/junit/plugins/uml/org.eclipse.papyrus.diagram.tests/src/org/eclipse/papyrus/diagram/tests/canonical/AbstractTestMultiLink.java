/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Relationship;
import org.junit.Before;



/**
 * The Class MultiLink.
 */
public abstract class AbstractTestMultiLink extends AbstractPapyrusTestCase {

	protected static final String THE_BRANCH_TO_RECONNECT_EXISTS = "the branch to reconnect exists";

	protected static final String BRANCH_EXISTS_RECONNECTION_ON_TARGET = "branch exists reconnection on target ";

	protected static final String RECONNECTION_TARGET = "Reconnection target ";

	protected static final String BRANCH_EXISTS_RECONNECTION_ON_SOURCE = "branch exists reconnection on Source ";

	protected static final String RECONNECTION_SOURCE = "Reconnection Source ";

	GraphicalEditPart source = null;

	GraphicalEditPart target = null;

	GraphicalEditPart thirdPlayer = null;

	GraphicalEditPart fourthPlayer = null;

	GraphicalEditPart guestPlayer = null;

	ConnectionEditPart binaryLink = null;

	ShapeNodeEditPart linkNode = null;

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

	/** The root compartment. */
	protected ShapeCompartmentEditPart rootCompartment = null;

	/**
	 * Test view deletion.
	 * 
	 * @param type
	 *        the type
	 */
	public void testViewDeletion(IElementType type) {
		//DELETION OF THE VIEW
		//DELETION OF ALL THE VIEW
		assertTrue(VIEW_DELETION + INITIALIZATION_TEST, linkNode != null);

		Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
		Command command = linkNode.getCommand(deleteViewRequest);
		assertNotNull(VIEW_DELETION + COMMAND_NULL, command);
		assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, getDiagramEditPart().getChildren().size() == 5);
		assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, ((Diagram)getRootView()).getEdges().size() == 0);

		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(VIEW_DELETION + TEST_THE_UNDO, getDiagramEditPart().getChildren().size() == 6);
		assertTrue(VIEW_DELETION + TEST_THE_UNDO, ((Diagram)getRootView()).getEdges().size() == 4);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(VIEW_DELETION + TEST_THE_REDO, getDiagramEditPart().getChildren().size() == 5);
		assertTrue(VIEW_DELETION + TEST_THE_REDO, ((Diagram)getRootView()).getEdges().size() == 0);



	}

	public static Point getIntersectionPoint(ConnectionEditPart connEP, boolean source) {

		ConnectionAnchor sourceAnchor;
		ConnectionAnchor targetAnchor;

		NodeEditPart sourceEP = (NodeEditPart)connEP.getSource();
		NodeEditPart targetEP = (NodeEditPart)connEP.getTarget();

		Point endLocation;

		sourceAnchor = sourceEP.getSourceConnectionAnchor(connEP);
		targetAnchor = targetEP.getTargetConnectionAnchor(connEP);

		if(source) {
			endLocation = sourceAnchor.getLocation(targetAnchor.getReferencePoint()).getCopy();
		} else {
			endLocation = targetAnchor.getLocation(sourceAnchor.getReferencePoint()).getCopy();
		}

		return endLocation;
	}

	/**
	 * Test destroy.
	 * 
	 * @param type
	 *        the type
	 */
	public void testDestroy(IElementType type) {
		//DESTROY SEMANTIC+ VIEW
		assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 6);

		Request deleteViewRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
		Command command = linkNode.getCommand(deleteViewRequest);
		assertNotNull(DESTROY_DELETION + COMMAND_NULL, command);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, getDiagramEditPart().getChildren().size() == 5);
		assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, ((Diagram)getRootView()).getEdges().size() == 0);


		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(DESTROY_DELETION + TEST_THE_UNDO, getDiagramEditPart().getChildren().size() == 6);
		assertTrue(DESTROY_DELETION + TEST_THE_UNDO, ((Diagram)getRootView()).getEdges().size() == 4);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(DESTROY_DELETION + TEST_THE_REDO, getDiagramEditPart().getChildren().size() == 5);
		assertTrue(DESTROY_DELETION + TEST_THE_REDO, ((Diagram)getRootView()).getEdges().size() == 0);
	}


	/**
	 * Test drop.
	 * 
	 * @param type
	 *        the type
	 */
	public void testDrop(IElementType type) {
		//DROP
		//INIT
		assertTrue(DROP + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 5);
		assertTrue(DROP + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 6);
		assertTrue(DROP + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == 0);
		assertTrue(DROP + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().get(5) instanceof Relationship);
		Relationship relationship = (Relationship)getRootSemanticModel().getOwnedElements().get(5);


		//DO
		DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
		ArrayList<Element> list = new ArrayList<Element>();
		list.add(relationship);
		dropObjectsRequest.setObjects(list);
		dropObjectsRequest.setLocation(new Point(20, 20));
		Command command = getDiagramEditPart().getCommand(dropObjectsRequest);
		assertNotNull(DROP + COMMAND_NULL, command);
		assertTrue(DROP + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(DROP + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(DROP + TEST_THE_EXECUTION, getDiagramEditPart().getChildren().size() == 6);
		assertTrue(DROP + TEST_THE_EXECUTION, ((Diagram)getRootView()).getEdges().size() == 4);

		//UNDO
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(DROP + TEST_THE_UNDO, getDiagramEditPart().getChildren().size() == 5);
		assertTrue(DROP + TEST_THE_UNDO, ((Diagram)getRootView()).getEdges().size() == 0);

		//REDO
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(DROP + TEST_THE_REDO, getDiagramEditPart().getChildren().size() == 6);
		assertTrue(DROP + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == 6);
		assertTrue(DROP + TEST_THE_REDO, ((Diagram)getRootView()).getEdges().size() == 4);
	}



	/**
	 * Test to create a node.
	 * 
	 * @param branchType
	 *        type of the branch to create
	 * @param flow
	 *        TODO
	 * 
	 */
	public void testToCreateAMultiLink(IElementType branchType, boolean flow) {


		//test to create the branch for dependency to node
		Command cmd = target.getCommand(createConnectionViewRequest(branchType, binaryLink, thirdPlayer));
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, cmd.canExecute() == true);
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().execute(cmd);
		// EditorUtils.getTransactionalEditingDomain().getCommandStack().execute(cmd);
		assertTrue(CREATION + TEST_THE_EXECUTION, ((Diagram)getRootView()).getEdges().size() == 3);
		assertTrue(CREATION + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == 6);

		//Undo
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, ((Diagram)getRootView()).getEdges().size() == 1);
		assertTrue(CREATION + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == 6);


		//redo
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(CREATION + TEST_THE_REDO, ((Diagram)getRootView()).getEdges().size() == 3);
		assertTrue(CREATION + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == 6);
		assertTrue(CREATION + TEST_THE_REDO, getDiagramEditPart().getChildren().get(5) != null);
		linkNode = (ShapeNodeEditPart)getDiagramEditPart().getChildren().get(5);

		//test to create the branch from node to multidependency
		if(flow) {
			cmd = linkNode.getCommand(createConnectionViewRequest(branchType, fourthPlayer, linkNode));

		} else {//test to create the branch from  multidependency to node
			cmd = linkNode.getCommand(createConnectionViewRequest(branchType, linkNode, fourthPlayer));
		}

		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, cmd.canExecute() == true);
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().execute(cmd);
		assertTrue(CREATION + TEST_THE_EXECUTION, ((Diagram)getRootView()).getEdges().size() == 4);
		assertTrue(CREATION + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == 6);

		//undo
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, ((Diagram)getRootView()).getEdges().size() == 3);
		assertTrue(CREATION + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == 6);

		//redo
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(CREATION + TEST_THE_REDO, ((Diagram)getRootView()).getEdges().size() == 4);
		assertTrue(CREATION + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == 6);
	}



	public void testTargetReconnectAMultiLink(IElementType type) {

		//target reconnection
		ReconnectRequest reconnectRequest = new ReconnectRequest();
		assertTrue(THE_BRANCH_TO_RECONNECT_EXISTS, (ConnectionEditPart)target.getTargetConnections().get(0) != null);
		ConnectionEditPart branch = (ConnectionEditPart)target.getTargetConnections().get(0);
		reconnectRequest.setConnectionEditPart(branch);
		reconnectRequest.setTargetEditPart(guestPlayer);
		reconnectRequest.setType(RequestConstants.REQ_RECONNECT_TARGET);

		Command cmd = guestPlayer.getCommand(reconnectRequest);

		assertTrue(RECONNECTION_TARGET + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, cmd.canExecute() == true);
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().execute(cmd);
		// EditorUtils.getTransactionalEditingDomain().getCommandStack().execute(cmd);
		assertTrue(RECONNECTION_TARGET + TEST_THE_EXECUTION, ((Diagram)getRootView()).getEdges().size() == 4);
		assertTrue(RECONNECTION_TARGET + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == 6);
		assertTrue(BRANCH_EXISTS_RECONNECTION_ON_TARGET, branch.getTarget().equals(guestPlayer));

		//undo
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(BRANCH_EXISTS_RECONNECTION_ON_TARGET + TEST_THE_UNDO, branch.getTarget().equals(target));

		//redo
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(BRANCH_EXISTS_RECONNECTION_ON_TARGET + TEST_THE_REDO, branch.getTarget().equals(guestPlayer));

		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().undo();


	}

	public void testSourceReconnectAMultiLink(IElementType type) {

		//target reconnection
		ReconnectRequest reconnectRequest = new ReconnectRequest();
		assertTrue(THE_BRANCH_TO_RECONNECT_EXISTS, (ConnectionEditPart)source.getSourceConnections().get(0) != null);
		ConnectionEditPart branch = (ConnectionEditPart)source.getSourceConnections().get(0);
		reconnectRequest.setConnectionEditPart(branch);
		reconnectRequest.setTargetEditPart(guestPlayer);
		reconnectRequest.setType(RequestConstants.REQ_RECONNECT_SOURCE);

		Command cmd = guestPlayer.getCommand(reconnectRequest);

		assertTrue(RECONNECTION_SOURCE + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, cmd.canExecute() == true);
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().execute(cmd);
		assertTrue(RECONNECTION_SOURCE + TEST_THE_EXECUTION, ((Diagram)getRootView()).getEdges().size() == 4);
		assertTrue(RECONNECTION_SOURCE + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == 6);
		assertTrue(BRANCH_EXISTS_RECONNECTION_ON_SOURCE + TEST_THE_EXECUTION, branch.getSource().equals(guestPlayer));

		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(BRANCH_EXISTS_RECONNECTION_ON_SOURCE + TEST_THE_UNDO, branch.getSource().equals(source));

		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(BRANCH_EXISTS_RECONNECTION_ON_SOURCE + TEST_THE_REDO, branch.getSource().equals(guestPlayer));

		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().undo();
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


	protected abstract CreateViewRequest createViewRequestShapeContainer();

	/**
	 * @see org.eclipse.papyrus.diagram.clazz.test.canonical.AbstractPapyrusTestCase#setUp()
	 * 
	 * @throws Exception
	 */
	@Before
	@Override
	protected void setUp() throws Exception {
		super.setUp();

		CreateViewRequest requestcreation = createViewRequestShapeContainer();
		//1st node
		requestcreation.setLocation(new Point(10, 10));
		Command command = getDiagramEditPart().getCommand(requestcreation);
		assertNotNull(CONTAINER_CREATION + COMMAND_NULL, command);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 1);


		requestcreation.setLocation(new Point(400, 10));
		//2d node
		command = getDiagramEditPart().getCommand(requestcreation);
		assertNotNull(CONTAINER_CREATION + COMMAND_NULL, command);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 2);

		requestcreation.setLocation(new Point(200, 200));
		//3d node
		command = getDiagramEditPart().getCommand(requestcreation);
		assertNotNull(CONTAINER_CREATION + COMMAND_NULL, command);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 3);
		source = (GraphicalEditPart)getDiagramEditPart().getChildren().get(0);
		target = (GraphicalEditPart)getDiagramEditPart().getChildren().get(1);
		thirdPlayer = (GraphicalEditPart)getDiagramEditPart().getChildren().get(2);

		//4d node
		requestcreation.setLocation(new Point(400, 400));
		command = getDiagramEditPart().getCommand(requestcreation);
		assertNotNull(CONTAINER_CREATION + COMMAND_NULL, command);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 4);
		fourthPlayer = (GraphicalEditPart)getDiagramEditPart().getChildren().get(3);
		//4d guest
		requestcreation.setLocation(new Point(600, 400));
		command = getDiagramEditPart().getCommand(requestcreation);
		assertNotNull(CONTAINER_CREATION + COMMAND_NULL, command);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 5);
		guestPlayer = (GraphicalEditPart)getDiagramEditPart().getChildren().get(4);





	}

	public void installbinaryLink(IElementType type) {
		//binaryLink
		Command command = target.getCommand(createConnectionViewRequest(type, source, target));

		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == 1);
		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 6);

		binaryLink = (ConnectionEditPart)source.getSourceConnections().get(0);

	}

	/**
	 * @see org.eclipse.papyrus.diagram.clazz.test.canonical.AbstractPapyrusTestCase#getRootView()
	 * 
	 * @return
	 */

	@Override
	protected View getRootView() {
		return (View)getDiagramEditPart().getModel();
	}

	/**
	 * Test to manage child node.
	 * 
	 * @param type
	 *        the type
	 * @param containerType
	 *        the container type
	 */
	public void testToManageMultiLink(IElementType binaryLinkType, IElementType branchType, boolean flow) {
		installbinaryLink(binaryLinkType);
		testToCreateAMultiLink(branchType, flow);
		testTargetReconnectAMultiLink(branchType);
		if(flow) {
			testSourceReconnectAMultiLink(branchType);
		}
		testDestroy(branchType);
		//end of the test
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, getDiagramEditPart().getChildren().get(5) instanceof ShapeNodeEditPart);
		linkNode = (ShapeNodeEditPart)getDiagramEditPart().getChildren().get(5);

		testViewDeletion(branchType);
		testDrop(branchType);
	}


}
