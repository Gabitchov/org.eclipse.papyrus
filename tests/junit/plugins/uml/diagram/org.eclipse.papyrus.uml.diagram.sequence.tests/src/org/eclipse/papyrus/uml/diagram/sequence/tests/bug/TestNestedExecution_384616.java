/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.junit.Test;


/**
 * Support all messages in nested actions and behaviors execution (delete, move and resize)
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=384616
 * 
 */
public class TestNestedExecution_384616 extends TestTopNode {

	private static final String RESIZE = "Resize: ";

	private static final String MOVE = "Move: ";

	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	@Test
	public void testActionExecutionSpecification() {
		manageActions(UMLElementTypes.ActionExecutionSpecification_3006);
	}

	@Test
	public void testBehaviorExecutionSpecification() {
		manageActions(UMLElementTypes.BehaviorExecutionSpecification_3003);
	}

	protected void manageActions(IElementType elementType) {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		waitForComplete();

		// create nested execution specification
		createNode(elementType, lifeline1, new Point(131, 200), new Dimension(20, 80));
		waitForComplete();

		/*
		 * Tips: 1. The real location of the first node would be (123, 200). 2. Make sure the bottom of nested Execution is less than the parent one. 
		 */
		
		createNode(elementType, lifeline1, new Point(131, 220), new Dimension(20, 40));
		waitForComplete();

		IGraphicalEditPart esp = (IGraphicalEditPart)lifeline1.getChildren().get(1);
		IGraphicalEditPart esp2 = (IGraphicalEditPart)lifeline1.getChildren().get(2);

		// move
		move(esp2, new Point(0, 20));
		// resize
		resize(esp, getAbsoluteBounds(esp2).getTop(), PositionConstants.NORTH, new Dimension(0, 30));

		{ // destroy semantic
			Request deleteViewRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
			Command command = esp2.getCommand(deleteViewRequest);
			assertNotNull(DESTROY_DELETION + COMMAND_NULL, command);
			assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
			assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
			getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(command));
			assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, lifeline1.getChildren().size() == 2); // action execution is deleted

			getEMFCommandStack().undo();
			assertTrue(DESTROY_DELETION + TEST_THE_UNDO, lifeline1.getChildren().size() == 3);

			getEMFCommandStack().redo();
			assertTrue(DESTROY_DELETION + TEST_THE_REDO, lifeline1.getChildren().size() == 2);
		}
		getEMFCommandStack().undo();
		esp2 = (IGraphicalEditPart)lifeline1.getChildren().get(2);
		{ // delete view
			Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
			Command command = esp2.getCommand(deleteViewRequest);

			assertNotNull(VIEW_DELETION + COMMAND_NULL, command);
			assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
			assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
			getDiagramCommandStack().execute(command);
			assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, lifeline1.getChildren().size() == 2);
			assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, getRootEditPart().getChildren().get(0) instanceof LifelineEditPart);

			getDiagramCommandStack().undo();
			assertTrue(VIEW_DELETION + TEST_THE_UNDO, lifeline1.getChildren().size() == 3);

			getDiagramCommandStack().redo();
			assertTrue(VIEW_DELETION + TEST_THE_REDO, lifeline1.getChildren().size() == 2);
		}
	}

	private void resize(IGraphicalEditPart op, Point p, int resizeDir, Dimension deltaSize) {
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		req.setLocation(p);
		req.setEditParts(op);
		req.setResizeDirection(resizeDir);
		req.setSizeDelta(deltaSize);
		if(resizeDir == PositionConstants.NORTH || resizeDir == PositionConstants.WEST)
			req.setMoveDelta(new Point(-deltaSize.width(), -deltaSize.height()));

		Command c = op.getCommand(req);
		manageResizeCommnad(op, deltaSize, c);
	}

	private void manageResizeCommnad(IGraphicalEditPart op, Dimension deltaSize, Command c) {
		assertNotNull(RESIZE + COMMAND_NULL, c);
		assertTrue(RESIZE + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, c.canExecute() == true);
		Rectangle before = getAbsoluteBounds(op);
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(c));
		waitForComplete();

		Rectangle after = getAbsoluteBounds(op);
		assertTrue(RESIZE + TEST_THE_EXECUTION, after.width() - before.width() == deltaSize.width());
		assertTrue(RESIZE + TEST_THE_EXECUTION, after.height() - before.height() == deltaSize.height());

		getEMFCommandStack().undo();
		waitForComplete();
		assertTrue(RESIZE + TEST_THE_UNDO, before.equals(getAbsoluteBounds(op)));

		getEMFCommandStack().redo();
		waitForComplete();
		assertTrue(RESIZE + TEST_THE_REDO, after.equals(getAbsoluteBounds(op)));
	}

	protected void move(IGraphicalEditPart part, Point moveDelta) {
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
		req.setResizeDirection(moveDelta.y > 0 ? PositionConstants.SOUTH : PositionConstants.NORTH);
		req.setLocation(getAbsoluteCenter(part));
		req.setEditParts(part);
		req.setMoveDelta(moveDelta);

		Command command = part.getCommand(req);
		assertNotNull(MOVE + COMMAND_NULL, command);
		assertTrue(MOVE + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		Rectangle before = getAbsoluteBounds(part);
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		waitForComplete();

		Rectangle after = getAbsoluteBounds(part);
		assertTrue(MOVE + TEST_THE_EXECUTION, after.x() - before.x() == moveDelta.x);
		assertTrue(MOVE + TEST_THE_EXECUTION, after.y() - before.y() == moveDelta.y);

		getEMFCommandStack().undo();
		waitForComplete();
		assertTrue(MOVE + TEST_THE_UNDO, before.equals(getAbsoluteBounds(part)));

		getEMFCommandStack().redo();
		waitForComplete();
		assertTrue(MOVE + TEST_THE_REDO, after.equals(getAbsoluteBounds(part)));
	}

	public void createNode(IElementType type, EditPart parentPart, Point location, Dimension size) {
		//CREATION
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getRootEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(location);
		requestcreation.setSize(size);
		Command command = parentPart.getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getDiagramCommandStack().execute(command);
	}
}
