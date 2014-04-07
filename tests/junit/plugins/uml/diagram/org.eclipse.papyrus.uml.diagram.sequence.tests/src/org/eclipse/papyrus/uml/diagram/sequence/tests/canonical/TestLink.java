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
package org.eclipse.papyrus.uml.diagram.sequence.tests.canonical;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.tests.canonical.AbstractPapyrusTestCase;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.swt.widgets.Display;


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

	public static final String SOURCE_MODEL_CONTAINER = "Source model container"; //$NON-NLS-1$

	public static final String TARGET_MODEL_CONTAINER = "Target model container"; //$NON-NLS-1$

	protected GraphicalEditPart source = null;

	protected GraphicalEditPart sourcePlayer = null;

	protected GraphicalEditPart target = null;

	protected GraphicalEditPart targetPlayer = null;


	protected GraphicalEditPart rootPart;

	protected GraphicalEditPart getRootEditPart() {
		if(rootPart == null) {
			GraphicalEditPart part = (GraphicalEditPart)getDiagramEditPart().getChildren().get(0);
			rootPart = (GraphicalEditPart)part.getChildren().get(1); // compart
		}
		return rootPart;
	}

	protected DiagramCommandStack getDiagramCommandStack() {
		return getRootEditPart().getDiagramEditDomain().getDiagramCommandStack();
	}

	protected org.eclipse.emf.common.command.CommandStack getEMFCommandStack() {
		return getRootEditPart().getEditingDomain().getCommandStack();
	}

	protected void waitForComplete() {
		boolean run = true;
		while(run) {
			try {
				run = Display.getDefault().readAndDispatch();
			} catch (Exception e) {
				run = true;
			}
		}
	}

	protected Point getAbsoluteCenter(IGraphicalEditPart part) {
		IFigure f = part.getFigure();
		Rectangle b = f.getBounds().getCopy();
		f.translateToAbsolute(b);
		Point c = b.getCenter().getCopy();
		return c;
	}

	/**
	 * Get the bounds of an edit part
	 *
	 * @param part
	 *        edit part to find bounds
	 * @return part's bounds in absolute coordinates
	 */
	public static Rectangle getAbsoluteBounds(IGraphicalEditPart part) {
		// take bounds from figure
		Rectangle bounds = part.getFigure().getBounds().getCopy();

		if(part.getNotationView() instanceof Node) {
			// rather update with up to date model bounds
			Node node = (Node)part.getNotationView();
			LayoutConstraint cst = node.getLayoutConstraint();
			if(cst instanceof Bounds) {
				Bounds b = (Bounds)cst;
				Point parentLoc = part.getFigure().getParent().getBounds().getLocation();
				if(b.getX() > 0) {
					bounds.x = b.getX() + parentLoc.x;
				}
				if(b.getY() > 0) {
					bounds.y = b.getY() + parentLoc.y;
				}
				if(b.getHeight() != -1) {
					bounds.height = b.getHeight();
				}
				if(b.getWidth() != -1) {
					bounds.width = b.getWidth();
				}
			}
		}

		part.getFigure().getParent().translateToAbsolute(bounds);
		return bounds;
	}


	/**
	 * Test view deletion.
	 *
	 * @param type
	 *        the type
	 * @param provider
	 */
	public void testViewDeletion(IElementType type, ILinkTestProvider provider) {
		//DELETION OF THE VIEW
		assertTrue(VIEW_DELETION + INITIALIZATION_TEST, source.getSourceConnections().size() == 1);
		int initSemanticSize = provider.getSemanticChildrenSize();
		Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
		Command command = ((ConnectionEditPart)source.getSourceConnections().get(0)).getCommand(deleteViewRequest);
		assertNotNull(VIEW_DELETION + COMMAND_NULL, command);
		assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, source.getSourceConnections().size() == 0);
		assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, provider.getSemanticChildrenSize() == initSemanticSize);

		getEMFCommandStack().undo();
		assertTrue(VIEW_DELETION + TEST_THE_UNDO, source.getSourceConnections().size() == 1);
		assertTrue(VIEW_DELETION + TEST_THE_UNDO, provider.getSemanticChildrenSize() == initSemanticSize);

		getEMFCommandStack().redo();
		assertTrue(VIEW_DELETION + TEST_THE_REDO, source.getSourceConnections().size() == 0);
		assertTrue(VIEW_DELETION + TEST_THE_REDO, provider.getSemanticChildrenSize() == initSemanticSize);

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
	 * @param provider
	 */
	public void testDestroy(IElementType type, ILinkTestProvider provider) {

		//DESTROY SEMANTIC+ VIEW
		assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, provider.getEdgesSize() == 1);
		assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, source.getSourceConnections().size() == 1);

		Request deleteViewRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
		Command command = ((ConnectionEditPart)source.getSourceConnections().get(0)).getCommand(deleteViewRequest);
		assertNotNull(DESTROY_DELETION + COMMAND_NULL, command);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, provider.getEdgesSize() == 0);
		assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, source.getSourceConnections().size() == 0);
		assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, provider.getSemanticChildrenSize() == 4);

		assertTrue(DESTROY_DELETION + TEST_THE_UNDO, getDiagramCommandStack().canUndo() == true);
		getEMFCommandStack().undo();
		assertTrue(DESTROY_DELETION + TEST_THE_UNDO, provider.getEdgesSize() == 1);
		assertTrue(DESTROY_DELETION + TEST_THE_UNDO, source.getSourceConnections().size() == 1);

		getEMFCommandStack().redo();
		assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, provider.getEdgesSize() == 0);
		assertTrue(DESTROY_DELETION + TEST_THE_REDO, source.getSourceConnections().size() == 0);
		assertTrue(DESTROY_DELETION + TEST_THE_REDO, provider.getSemanticChildrenSize() == 4);
	}


	/**
	 * Test to create a link.
	 *
	 * @param linkType
	 *        the type
	 * @param provider
	 */
	public void testToCreateALink(IElementType linkType, ILinkTestProvider provider) {
		assertTrue(CREATION + INITIALIZATION_TEST, provider.getEditPartChildrenSize() == 4);
		assertTrue(CREATION + INITIALIZATION_TEST, provider.getSemanticChildrenSize() == 4);
		assertTrue(CREATION + INITIALIZATION_TEST, provider.getEdgesSize() == 0); //add

		CreateConnectionViewRequest req = createConnectionViewRequest(linkType, source, target, provider);
		Command command = target.getCommand(req);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getDiagramCommandStack().execute(command);
		assertTrue(CREATION + INITIALIZATION_TEST, provider.getEdgesSize() == 1);

		getDiagramCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, provider.getViewChildrenSize() == 4);
		assertTrue(CREATION + TEST_THE_UNDO, provider.getSemanticChildrenSize() == 4);
		assertTrue(CREATION + TEST_THE_UNDO, provider.getEdgesSize() == 0); // add

		getDiagramCommandStack().redo();
		assertTrue(CREATION + TEST_THE_REDO, provider.getEdgesSize() == 1);
	}


	public void installEnvironment(IElementType sourceType, IElementType targetType, ILinkTestProvider provider) {
		assertTrue(CREATION + INITIALIZATION_TEST, getRootEditPart().getChildren().size() == 0);
		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 0);

		//create the source
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(sourceType, getDiagramEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(new Point(100, 100));
		Command command = getRootEditPart().getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		getDiagramCommandStack().execute(command);

		//create the source player to test reconnect
		requestcreation = CreateViewRequestFactory.getCreateShapeRequest(sourceType, getDiagramEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(new Point(200, 100));
		command = getRootEditPart().getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		getDiagramCommandStack().execute(command);

		//create the target
		requestcreation = CreateViewRequestFactory.getCreateShapeRequest(targetType, getDiagramEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(new Point(300, 100));
		command = getRootEditPart().getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		getDiagramCommandStack().execute(command);

		//create the target player to test reconnect
		requestcreation = CreateViewRequestFactory.getCreateShapeRequest(targetType, getDiagramEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(new Point(400, 100));
		command = getRootEditPart().getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		getDiagramCommandStack().execute(command);

		source = (GraphicalEditPart)getRootEditPart().getChildren().get(0);
		sourcePlayer = (GraphicalEditPart)getRootEditPart().getChildren().get(1);
		target = (GraphicalEditPart)getRootEditPart().getChildren().get(2);
		targetPlayer = (GraphicalEditPart)getRootEditPart().getChildren().get(3);

		provider.setUp();
	}

	protected GraphicalEditPart createSubNode(GraphicalEditPart parent, IElementType type, Point c) {
		CreateViewRequest request = CreateViewRequestFactory.getCreateShapeRequest(type, getRootEditPart().getDiagramPreferencesHint());
		request.setLocation(c);

		Command command = parent.getCommand(request);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		getDiagramCommandStack().execute(command);

		// return last child
		List list = parent.getChildren();
		return (GraphicalEditPart)list.get(list.size() - 1);
	}

	public CreateConnectionViewRequest createConnectionViewRequest(IElementType type, EditPart source, EditPart target, ILinkTestProvider provider) {
		CreateConnectionViewRequest connectionRequest = CreateViewRequestFactory.getCreateConnectionRequest(type, ((IGraphicalEditPart)getDiagramEditPart()).getDiagramPreferencesHint());

		Point c = provider.getConnectionSourceLocation(source);
		connectionRequest.setLocation(c);

		connectionRequest.setSourceEditPart(null);
		connectionRequest.setTargetEditPart(source);
		connectionRequest.setType(RequestConstants.REQ_CONNECTION_START);
		Command cmd = source.getCommand(connectionRequest);
		// Now, setup the request in preparation to get the connection end command.
		connectionRequest.setSourceEditPart(source);
		connectionRequest.setTargetEditPart(target);
		connectionRequest.setType(RequestConstants.REQ_CONNECTION_END);

		Point t = provider.getConnectionTargetLocation(target);
		connectionRequest.setLocation(t);
		return connectionRequest;
	}

	public void testTargetReconnectAMultiLink(IElementType type, ILinkTestProvider provider) {
		//target reconnection
		ReconnectRequest reconnectRequest = new ReconnectRequest();
		assertTrue(THE_LINK_RECONNECT_EXISTS, (ConnectionEditPart)target.getTargetConnections().get(0) != null);
		ConnectionEditPart binaryLink = (ConnectionEditPart)target.getTargetConnections().get(0);
		reconnectRequest.setConnectionEditPart(binaryLink);
		reconnectRequest.setTargetEditPart(targetPlayer);
		reconnectRequest.setType(RequestConstants.REQ_RECONNECT_TARGET);
		reconnectRequest.setLocation(provider.getConnectionSourceLocation(targetPlayer));

		Command cmd = targetPlayer.getCommand(reconnectRequest);
		assertTrue(RECONNECTION_TARGET + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, cmd.canExecute() == true);
		int initSemanticSize = provider.getSemanticChildrenSize();

		getDiagramCommandStack().execute(cmd);
		assertTrue(RECONNECTION_TARGET + TEST_THE_EXECUTION, provider.getEdgesSize() == 1);
		assertTrue(RECONNECTION_TARGET + TEST_THE_EXECUTION, provider.getSemanticChildrenSize() == initSemanticSize);
		assertTrue(LINK_EXISTS_RECONNECTION_ON_TARGET, binaryLink.getTarget().equals(targetPlayer));

		//undo
		getDiagramCommandStack().undo();
		assertTrue(LINK_EXISTS_RECONNECTION_ON_TARGET + TEST_THE_UNDO, binaryLink.getTarget().equals(target));
		assertTrue(RECONNECTION_TARGET + TEST_THE_UNDO, provider.getEdgesSize() == 1);
		assertTrue(RECONNECTION_TARGET + TEST_THE_UNDO, provider.getSemanticChildrenSize() == initSemanticSize);

		//redo
		getDiagramCommandStack().redo();
		assertTrue(LINK_EXISTS_RECONNECTION_ON_TARGET + TEST_THE_REDO, binaryLink.getTarget().equals(targetPlayer));
		assertTrue(RECONNECTION_TARGET + TEST_THE_REDO, provider.getEdgesSize() == 1);
		assertTrue(RECONNECTION_TARGET + TEST_THE_REDO, provider.getSemanticChildrenSize() == initSemanticSize);
	}

	public void testSourceReconnectAMultiLink(IElementType type, ILinkTestProvider provider) {
		//target reconnection
		ReconnectRequest reconnectRequest = new ReconnectRequest();
		assertTrue(THE_LINK_TO_RECONNECT_EXISTS, (ConnectionEditPart)source.getSourceConnections().get(0) != null);
		ConnectionEditPart branch = (ConnectionEditPart)source.getSourceConnections().get(0);
		reconnectRequest.setConnectionEditPart(branch);
		reconnectRequest.setTargetEditPart(sourcePlayer);
		reconnectRequest.setType(RequestConstants.REQ_RECONNECT_SOURCE);
		reconnectRequest.setLocation(provider.getConnectionSourceLocation(sourcePlayer));

		Command cmd = sourcePlayer.getCommand(reconnectRequest);
		assertTrue(RECONNECTION_SOURCE + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, cmd.canExecute() == true);
		int initSemanticSize = provider.getSemanticChildrenSize();

		getDiagramCommandStack().execute(cmd);
		assertTrue(RECONNECTION_SOURCE + TEST_THE_EXECUTION, provider.getEdgesSize() == 1);
		assertTrue(RECONNECTION_SOURCE + TEST_THE_EXECUTION, provider.getSemanticChildrenSize() == initSemanticSize);
		assertTrue(LINK_EXISTS_RECONNECTION_ON_SOURCE + TEST_THE_EXECUTION, branch.getSource().equals(sourcePlayer));

		getDiagramCommandStack().undo();
		assertTrue(RECONNECTION_SOURCE + TEST_THE_UNDO, provider.getEdgesSize() == 1);
		assertTrue(RECONNECTION_SOURCE + TEST_THE_UNDO, provider.getSemanticChildrenSize() == initSemanticSize);
		assertTrue(LINK_EXISTS_RECONNECTION_ON_SOURCE + TEST_THE_UNDO, branch.getSource().equals(source));

		getDiagramCommandStack().redo();
		assertTrue(RECONNECTION_SOURCE + TEST_THE_REDO, provider.getEdgesSize() == 1);
		assertTrue(RECONNECTION_SOURCE + TEST_THE_REDO, provider.getSemanticChildrenSize() == initSemanticSize);
		assertTrue(LINK_EXISTS_RECONNECTION_ON_SOURCE + TEST_THE_REDO, branch.getSource().equals(sourcePlayer));
	}

	/**
	 * Test to manage top node.
	 *
	 * @param type
	 *        the type
	 * @param provider
	 *        the container type
	 */
	public void testToManageLink(IElementType sourceType, IElementType targetType, IElementType linkType, ILinkTestProvider provider, boolean allowedOntheSame) {
		installEnvironment(sourceType, targetType, provider);
		testToCreateALink(linkType, provider);
		testDestroy(linkType, provider);

		getEMFCommandStack().undo();
		testViewDeletion(linkType, provider);

		getEMFCommandStack().undo();
		testSourceReconnectAMultiLink(linkType, provider);

		getDiagramCommandStack().undo();
		testTargetReconnectAMultiLink(linkType, provider);

		testToCreateAlinkOnTheSame(linkType, provider, allowedOntheSame); // self link
	}

	/**
	 * test the creation of a link where the source and the target are the same objects
	 *
	 * @param linkType
	 * @param provider
	 * @param allowed
	 */
	protected void testToCreateAlinkOnTheSame(IElementType linkType, ILinkTestProvider provider, boolean allowed) {
		assertTrue(CREATION + INITIALIZATION_TEST, provider.getEditPartChildrenSize() == 4);
		int initSemanticSize = provider.getSemanticChildrenSize();

		CreateConnectionViewRequest request = createConnectionViewRequest(linkType, source, source, provider);
		request.setLocation(request.getLocation().translate(0, 10));

		Command command = source.getCommand(request);
		assertNotNull(CREATION + COMMAND_NULL, command);
		if(allowed) {
			assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == allowed);
			assertTrue(CREATION + INITIALIZATION_TEST, provider.getEdgesSize() == 1);
			getDiagramCommandStack().execute(command);
			assertTrue(CREATION + INITIALIZATION_TEST, provider.getEdgesSize() == 2);

			getDiagramCommandStack().undo();
			assertTrue(CREATION + TEST_THE_UNDO, provider.getSemanticChildrenSize() == initSemanticSize);
			assertTrue(CREATION + TEST_THE_UNDO, provider.getEdgesSize() == 1);
			assertTrue(CREATION + TEST_THE_UNDO, provider.getViewChildrenSize() == 4);

			getDiagramCommandStack().redo();
			assertTrue(CREATION + TEST_THE_REDO, provider.getEdgesSize() == 2);
		}
	}
}
