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
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DestructionOccurrenceSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.junit.Test;

/**
 * The icon of the tool "destruction node" is missing in the palette of the sequence diagram editor.
 * The default size of the figure associated to the destruction node is too big and should be resizable.
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=384201
 * 
 */
public class TestDestructionNode_384201 extends TestTopNode {

	private static final String RESIZE = "Resize: ";


	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	@Test
	public void testResizeNorth() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		waitForComplete();

		createNode(UMLElementTypes.DestructionOccurrenceSpecification_3022, lifeline1, new Point(131, 150), new Dimension(20, 20));
		DestructionOccurrenceSpecificationEditPart dsep = (DestructionOccurrenceSpecificationEditPart)lifeline1.getChildren().get(1);
		resize(dsep, getAbsoluteBounds(dsep).getTop(), PositionConstants.NORTH, new Dimension(0, 20));
		resize(dsep, getAbsoluteBounds(dsep).getTop(), PositionConstants.NORTH, new Dimension(0, -20));
	}


	@Test
	public void testResizeWest() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		waitForComplete();

		createNode(UMLElementTypes.DestructionOccurrenceSpecification_3022, lifeline1, new Point(131, 150), new Dimension(20, 20));
		DestructionOccurrenceSpecificationEditPart dsep = (DestructionOccurrenceSpecificationEditPart)lifeline1.getChildren().get(1);
		resize(dsep, getAbsoluteBounds(dsep).getLeft(), PositionConstants.WEST, new Dimension(20, 0));
		resize(dsep, getAbsoluteBounds(dsep).getLeft(), PositionConstants.WEST, new Dimension(-20, 0));
	}

	@Test
	public void testResizeEast() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		waitForComplete();

		createNode(UMLElementTypes.DestructionOccurrenceSpecification_3022, lifeline1, new Point(131, 150), new Dimension(20, 20));
		DestructionOccurrenceSpecificationEditPart dsep = (DestructionOccurrenceSpecificationEditPart)lifeline1.getChildren().get(1);
		resize(dsep, getAbsoluteBounds(dsep).getRight(), PositionConstants.EAST, new Dimension(20, 0));
		resize(dsep, getAbsoluteBounds(dsep).getRight(), PositionConstants.EAST, new Dimension(-20, 0));
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
		verifyResizeCommnad(op, deltaSize, c);
	}

	private void verifyResizeCommnad(IGraphicalEditPart op, Dimension deltaSize, Command c) {
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
