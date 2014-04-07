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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.draw2d.IFigure;
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
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.junit.Test;

/**
 * Adding of operands is allowed, but it is not possible to delete an operand
 * from a combined fragment. Moreover, the resize of operands is also not
 * possible. https://bugs.eclipse.org/bugs/show_bug.cgi?id=364701
 *
 */
public class TestCombinedFragmentOperand_364701 extends TestTopNode {

	private static final String OPERAND_RESIZE = "Operand Resize: ";

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
	public void testOperandAddDelete() {
		final CombinedFragmentCombinedFragmentCompartmentEditPart cfp = setupCombinedFragment();

		// add operand
		{
			createNode(UMLElementTypes.InteractionOperand_3005, cfp, new Point(50, 100), new Dimension(100, 100));
			assertTrue(CREATION + TEST_THE_EXECUTION, cfp.getChildren().size() == 2);

			getDiagramCommandStack().undo();
			assertTrue(CREATION + TEST_THE_UNDO, cfp.getChildren().size() == 1);

			getDiagramCommandStack().redo();
			assertTrue(CREATION + TEST_THE_REDO, cfp.getChildren().size() == 2);
		}

		{ // delete operand
			InteractionOperandEditPart op = (InteractionOperandEditPart)cfp.getChildren().get(0);
			Request deleteViewRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
			Command command = op.getCommand(deleteViewRequest);
			assertNotNull(DESTROY_DELETION + COMMAND_NULL, command);
			assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
			assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
			getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(command));
			waitForComplete();
			assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, cfp.getChildren().size() == 1);

			getEMFCommandStack().undo();
			assertTrue(DESTROY_DELETION + TEST_THE_UNDO, cfp.getChildren().size() == 2);

			getEMFCommandStack().redo();
			assertTrue(DESTROY_DELETION + TEST_THE_REDO, cfp.getChildren().size() == 1);
		}
		getEMFCommandStack().undo();

		{ // delete view
			assertTrue(VIEW_DELETION + INITIALIZATION_TEST, cfp.getChildren().size() == 2);
			InteractionOperandEditPart op = (InteractionOperandEditPart)cfp.getChildren().get(0);
			Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
			Command command = op.getCommand(deleteViewRequest);
			assertNotNull(VIEW_DELETION + COMMAND_NULL, command);
			assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
			assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

			getDiagramCommandStack().execute(command);
			assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, cfp.getChildren().size() == 1);

			getDiagramCommandStack().undo();
			assertTrue(VIEW_DELETION + TEST_THE_UNDO, cfp.getChildren().size() == 2);

			getDiagramCommandStack().redo();
			assertTrue(VIEW_DELETION + TEST_THE_REDO, cfp.getChildren().size() == 1);
		}
	}

	private CombinedFragmentCombinedFragmentCompartmentEditPart setupCombinedFragment() {
		createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(30, 80), new Dimension(100, 100));
		CombinedFragmentEditPart cep = (CombinedFragmentEditPart)getRootEditPart().getChildren().get(0);
		final CombinedFragmentCombinedFragmentCompartmentEditPart cfp = (CombinedFragmentCombinedFragmentCompartmentEditPart)cep.getChildren().get(0);
		assertTrue(CREATION + INITIALIZATION_TEST, cfp.getChildren().size() == 1);
		return cfp;
	}

	@Test
	public void testOperandResizeHeight() {
		final CombinedFragmentCombinedFragmentCompartmentEditPart cfp = setupCombinedFragment();
		waitForComplete();
		InteractionOperandEditPart op = (InteractionOperandEditPart)cfp.getChildren().get(0);
		// resize operand north
		{
			Dimension deltaSize = new Dimension(0, 30);
			Rectangle before = getAbsoluteBounds(op);
			assertTrue(OPERAND_RESIZE + INITIALIZATION_TEST, before.height() == getAbsoluteBounds(cfp).height());

			resizeNorth(op, deltaSize);
			Rectangle after = getAbsoluteBounds(op);
			assertTrue(OPERAND_RESIZE + TEST_THE_EXECUTION, after.height() == getAbsoluteBounds(cfp).height());
		}

		// resize operand south
		{
			Dimension deltaSize = new Dimension(0, 20);
			resizeSouth(op, deltaSize);
			Rectangle after = getAbsoluteBounds(op);
			assertTrue(OPERAND_RESIZE + TEST_THE_EXECUTION, after.height() == getAbsoluteBounds(cfp).height());
		}

		// resize operand north
		{
			Dimension deltaSize = new Dimension(0, -20);
			Rectangle before = getAbsoluteBounds(op);
			assertTrue(OPERAND_RESIZE + INITIALIZATION_TEST, before.height() == getAbsoluteBounds(cfp).height());

			resizeNorth(op, deltaSize);
			Rectangle after = getAbsoluteBounds(op);
			assertTrue(OPERAND_RESIZE + TEST_THE_EXECUTION, after.height() == getAbsoluteBounds(cfp).height());
		}

		// resize operand south
		{
			Dimension deltaSize = new Dimension(0, -20);
			resizeSouth(op, deltaSize);
			Rectangle after = getAbsoluteBounds(op);
			assertTrue(OPERAND_RESIZE + TEST_THE_EXECUTION, after.height() == getAbsoluteBounds(cfp).height());
		}
	}

	@Test
	public void testOperandResizeWidth() {
		final CombinedFragmentCombinedFragmentCompartmentEditPart cfp = setupCombinedFragment();
		waitForComplete();
		InteractionOperandEditPart op = (InteractionOperandEditPart)cfp.getChildren().get(0);

		// resize operand east
		{
			Dimension deltaSize = new Dimension(100, 0);
			Rectangle before = getAbsoluteBounds(op);
			assertTrue(OPERAND_RESIZE + INITIALIZATION_TEST, before.width() == getAbsoluteBounds(cfp).width());
			resizeEast(op, deltaSize);
			Rectangle after = getAbsoluteBounds(op);
			assertTrue(OPERAND_RESIZE + TEST_THE_EXECUTION, after.width() == getAbsoluteBounds(cfp).width());
		}

		// resize operand west
		{
			Dimension deltaSize = new Dimension(20, 0);
			resizeWest(op, deltaSize);
			Rectangle after = getAbsoluteBounds(op);
			assertTrue(OPERAND_RESIZE + TEST_THE_EXECUTION, after.width() == getAbsoluteBounds(cfp).width());
		}

		// resize operand east
		{
			Dimension deltaSize = new Dimension(-20, 0);
			Rectangle before = getAbsoluteBounds(op);
			assertTrue(OPERAND_RESIZE + INITIALIZATION_TEST, before.width() == getAbsoluteBounds(cfp).width());
			resizeEast(op, deltaSize);
			Rectangle after = getAbsoluteBounds(op);
			assertTrue(OPERAND_RESIZE + TEST_THE_EXECUTION, after.width() == getAbsoluteBounds(cfp).width());
		}

		// resize operand west
		{
			Dimension deltaSize = new Dimension(-20, 0);
			resizeWest(op, deltaSize);
			Rectangle after = getAbsoluteBounds(op);
			assertTrue(OPERAND_RESIZE + TEST_THE_EXECUTION, after.width() == getAbsoluteBounds(cfp).width());
		}
	}

	protected void resizeEast(IGraphicalEditPart op, Dimension deltaSize) {
		Point p = getRight(op);
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		req.setLocation(p);
		req.setEditParts(op);
		req.setResizeDirection(PositionConstants.EAST);
		req.setSizeDelta(deltaSize);

		Command c = op.getCommand(req);
		manageResizeCommnad(op, deltaSize, c);
	}

	protected void resizeWest(IGraphicalEditPart op, Dimension deltaSize) {
		Point p = getLeft(op);
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		req.setLocation(p);
		req.setEditParts(op);
		req.setResizeDirection(PositionConstants.WEST);
		req.setSizeDelta(deltaSize);
		req.setMoveDelta(new Point(-deltaSize.width(), -deltaSize.height()));

		Command c = op.getCommand(req);
		manageResizeCommnad(op, deltaSize, c);
	}

	private void resizeSouth(IGraphicalEditPart op, Dimension deltaSize) {
		Point p = getBottom(op);
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		req.setLocation(p);
		req.setEditParts(op);
		req.setResizeDirection(PositionConstants.SOUTH);
		req.setSizeDelta(deltaSize);

		Command c = op.getCommand(req);
		manageResizeCommnad(op, deltaSize, c);
	}

	private void resizeNorth(IGraphicalEditPart op, Dimension deltaSize) {
		Point p = getTop(op);
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		req.setLocation(p);
		req.setEditParts(op);
		req.setResizeDirection(PositionConstants.NORTH);
		req.setSizeDelta(deltaSize);
		req.setMoveDelta(new Point(-deltaSize.width(), -deltaSize.height()));

		Command c = op.getCommand(req);
		manageResizeCommnad(op, deltaSize, c);
	}

	private void manageResizeCommnad(IGraphicalEditPart op, Dimension deltaSize, Command c) {
		assertNotNull(OPERAND_RESIZE + COMMAND_NULL, c);
		assertTrue(OPERAND_RESIZE + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, c.canExecute() == true);
		Rectangle before = getAbsoluteBounds(op);
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(c));
		waitForComplete();

		Rectangle after = getAbsoluteBounds(op);
		assertTrue(OPERAND_RESIZE + TEST_THE_EXECUTION, after.width() - before.width() == deltaSize.width());
		assertTrue(OPERAND_RESIZE + TEST_THE_EXECUTION, after.height() - before.height() == deltaSize.height());

		getEMFCommandStack().undo();
		waitForComplete();
		assertTrue(OPERAND_RESIZE + TEST_THE_UNDO, before.equals(getAbsoluteBounds(op)));

		getEMFCommandStack().redo();
		waitForComplete();
		assertTrue(OPERAND_RESIZE + TEST_THE_REDO, after.equals(getAbsoluteBounds(op)));
	}

	public void createNode(IElementType type, EditPart parentPart, Point location, Dimension size) {
		// CREATION
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getRootEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(location);
		requestcreation.setSize(size);
		Command command = parentPart.getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getDiagramCommandStack().execute(command);
	}

	protected Point getRight(IGraphicalEditPart op) {
		IFigure f = op.getFigure();
		Rectangle b = f.getBounds().getCopy();
		f.translateToAbsolute(b);
		Point p = b.getRight();
		return p;
	}

	protected Point getLeft(IGraphicalEditPart op) {
		IFigure f = op.getFigure();
		Rectangle b = f.getBounds().getCopy();
		f.translateToAbsolute(b);
		Point p = b.getLeft();
		return p;
	}

	private Point getBottom(IGraphicalEditPart op) {
		IFigure f = op.getFigure();
		Rectangle b = f.getBounds().getCopy();
		f.translateToAbsolute(b);
		Point p = b.getBottom();
		return p;
	}

	private Point getTop(IGraphicalEditPart op) {
		IFigure f = op.getFigure();
		Rectangle b = f.getBounds().getCopy();
		f.translateToAbsolute(b);
		Point p = b.getTop();
		return p;
	}

}
