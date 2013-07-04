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
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.junit.Test;

/**
 * When childs are outside the current size, the parent bar should autoresize. The parent should always wrap the children.
 * Its size should be extended when we create, move, resize and reparent a child
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=385603
 * 
 */
public class TestParentBarAutoresize_385603 extends TestTopNode {

	private static final String RESIZE = "Resize: ";

	private static final String MOVE = "Move: ";

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	@Override
	protected String getProjectName() {
		return ISequenceDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return ISequenceDiagramTestsConstants.FILE_NAME;
	}
	
	@Test
	public void testActionExecutionSpecificationUp() {
		moveUp(UMLElementTypes.ActionExecutionSpecification_3006);
	}

	@Test
	public void testActionExecutionSpecificationDown() {
		moveDown(UMLElementTypes.ActionExecutionSpecification_3006);
	}

	@Test
	public void testBehaviorExecutionSpecificationDown() {
		moveDown(UMLElementTypes.BehaviorExecutionSpecification_3003);
	}

	@Test
	public void testBehaviorExecutionSpecificationUp() {
		moveUp(UMLElementTypes.BehaviorExecutionSpecification_3003);
	}

	private void moveUp(IElementType elementType) {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 300));
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		waitForComplete();

		// create nested execution specification
		createNode(elementType, lifeline1, new Point(131, 300), new Dimension(20, 40));
		waitForComplete();
		IGraphicalEditPart parent = (IGraphicalEditPart)lifeline1.getChildren().get(1);
		Rectangle before = getAbsoluteBounds(parent);

		// create child
		/* With location (131, 270), the new Execution will not the child of parent. */
		createNode(elementType, lifeline1, new Point(131, 310), new Dimension(20, 40));
		waitForComplete();
		IGraphicalEditPart child = (IGraphicalEditPart)lifeline1.getChildren().get(2);

		//The parent will not be expand when creation.
		assertTrue(RESIZE + TEST_THE_EXECUTION, getAbsoluteBounds(parent).getTop().y == before.getTop().y);
		assertTrue(RESIZE + TEST_THE_EXECUTION, getAbsoluteBounds(parent).height == before.height);

		// move up
		before = getAbsoluteBounds(parent);
		Point moveDelta = new Point(0, -20);
		move(child, moveDelta);
		assertTrue(MOVE + TEST_THE_EXECUTION, getAbsoluteBounds(parent).getTop().y == getAbsoluteBounds(child).getTop().y);
		/*
		 * the parent would not be always expanded.
		 * 
		 * assertTrue(MOVE + TEST_THE_EXECUTION, getAbsoluteBounds(parent).getTop().y - before.getTop().y == moveDelta.y);
		 */
		assertTrue(MOVE + TEST_THE_EXECUTION, getAbsoluteBounds(parent).getTop().y <= getAbsoluteBounds(child).getTop().y);

		// resize
		before = getAbsoluteBounds(parent);
		Dimension deltaSize = new Dimension(0, 20);
		resize(child, getAbsoluteBounds(child).getTop(), PositionConstants.NORTH, deltaSize);
		assertTrue(MOVE + TEST_THE_EXECUTION, getAbsoluteBounds(parent).getTop().y == getAbsoluteBounds(child).getTop().y);
		assertTrue(MOVE + TEST_THE_EXECUTION, getAbsoluteBounds(parent).height - before.height == deltaSize.height);
	}

	private void moveDown(IElementType elementType) {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		waitForComplete();

		// create nested execution specification
		createNode(elementType, lifeline1, new Point(131, 200), new Dimension(20, 50));
		waitForComplete();
		IGraphicalEditPart parent = (IGraphicalEditPart)lifeline1.getChildren().get(1);
		Rectangle before = getAbsoluteBounds(parent);

		// create child
		createNode(elementType, lifeline1, before.getRight().getTranslated(-1, 0), new Dimension(20, 50));
		waitForComplete();
		IGraphicalEditPart child = (IGraphicalEditPart)lifeline1.getChildren().get(2);

		/*
		 * DISABLED: the parent is not always expanded when adding a child.
		 * 
		 * assertTrue(RESIZE + TEST_THE_EXECUTION, getAbsoluteBounds(parent).getBottom().y > before.getBottom().y);
		 * assertTrue(RESIZE + TEST_THE_EXECUTION, getAbsoluteBounds(parent).getBottom().y == getAbsoluteBounds(child).getBottom().y);
		 */
		assertTrue(RESIZE + TEST_THE_EXECUTION, getAbsoluteBounds(parent).getBottom().y == before.getBottom().y);

		// move
		before = getAbsoluteBounds(parent);
		Point moveDelta = new Point(0, 20);
		move(child, moveDelta);
		assertTrue(MOVE + TEST_THE_EXECUTION, before.getLocation().equals(getAbsoluteBounds(parent).getLocation()));

		/*
		 * The height of parent will not be changed when move down child.
		 * assertTrue(MOVE + TEST_THE_EXECUTION, before.height + moveDelta.y == getAbsoluteBounds(parent).height);
		 * assertTrue(MOVE + TEST_THE_EXECUTION, getAbsoluteBounds(parent).getBottom().y == getAbsoluteBounds(child).getBottom().y);
		 */
		assertTrue(MOVE + TEST_THE_EXECUTION, before.height == getAbsoluteBounds(parent).height);

		// resize
		before = getAbsoluteBounds(parent);
		Dimension deltaSize = new Dimension(0, 30);
		resize(child, getAbsoluteBounds(child).getBottom(), PositionConstants.SOUTH, deltaSize);

		/*
		 * parent would not be changed.
		 * 
		 * assertTrue(RESIZE + TEST_THE_EXECUTION, getAbsoluteBounds(parent).getBottom().y == getAbsoluteBounds(child).getBottom().y);
		 * assertTrue(RESIZE + TEST_THE_EXECUTION, getAbsoluteBounds(parent).height == before.height + deltaSize.height);
		 */
		assertTrue(RESIZE + TEST_THE_EXECUTION, getAbsoluteBounds(parent).getTop().equals(before.getTop()));

		// move parent will move child bar
		before = getAbsoluteBounds(child);
		move(parent, moveDelta);
		assertTrue(MOVE + TEST_THE_EXECUTION, getAbsoluteBounds(child).x - before.x == moveDelta.x);
		assertTrue(MOVE + TEST_THE_EXECUTION, getAbsoluteBounds(child).y - before.y == moveDelta.y);

		// resize parent will not resize child
		before = getAbsoluteBounds(child);
		resize(parent, getAbsoluteBounds(parent).getBottom(), PositionConstants.SOUTH, deltaSize);
		assertTrue(RESIZE + TEST_THE_EXECUTION, getAbsoluteBounds(child).equals(before));
	}

	private void resize(IGraphicalEditPart op, Point p, int resizeDir, Dimension deltaSize) {
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		req.setLocation(p);
		req.setEditParts(op);
		req.setResizeDirection(resizeDir);
		req.setSizeDelta(deltaSize);
		if(resizeDir == PositionConstants.NORTH || resizeDir == PositionConstants.WEST) {
			req.setMoveDelta(new Point(-deltaSize.width(), -deltaSize.height()));
		}

		Command c = op.getCommand(req);
		assertNotNull(RESIZE + COMMAND_NULL, c);
		assertTrue(RESIZE + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, c.canExecute() == true);
		Rectangle before = getAbsoluteBounds(op);
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(c));
		waitForComplete();

		Rectangle after = getAbsoluteBounds(op);
		assertTrue(RESIZE + TEST_THE_EXECUTION, after.width() - before.width() == deltaSize.width());
		assertTrue(RESIZE + TEST_THE_EXECUTION, after.height() - before.height() == deltaSize.height());
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
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		waitForComplete();
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
