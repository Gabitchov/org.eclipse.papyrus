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
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.junit.Test;


/**
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=364711
 * When a lifeline covered by a combined fragment are moved (horizontally), the
 * combined fragment does'nt follow the lifeline. Combined fragments should
 * automatically follow lifeline when they are moved.
 */
public class TestMovingCombinedFragment_364711 extends TestTopNode {

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
	public void testMovingRight() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(200, 20));
		final LifelineEditPart lifelineEP = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), SequenceUtil.getAbsoluteBounds(lifelineEP).getCenter().getTranslated(-210, 70));
		final CombinedFragmentEditPart cep = (CombinedFragmentEditPart)getRootEditPart().getChildren().get(1);
		waitForComplete(); // wait for updating covered field

		Point moveDelta = new Point(50, 0);
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
		req.setResizeDirection(PositionConstants.WEST);
		req.setLocation(getAbsoluteCenter(lifelineEP));
		req.setEditParts(lifelineEP);
		req.setMoveDelta(moveDelta);

		Command command = lifelineEP.getCommand(req);
		assertNotNull(MOVE + COMMAND_NULL, command);
		assertTrue(MOVE + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		Rectangle before = getAbsoluteBounds(cep);
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(command));

		Rectangle after = getAbsoluteBounds(cep);
		assertTrue(MOVE + TEST_THE_EXECUTION, after.x() - before.x() == moveDelta.x);
		assertTrue(MOVE + TEST_THE_EXECUTION, after.y() - before.y() == moveDelta.y);

		getEMFCommandStack().undo();
		assertTrue(MOVE + TEST_THE_UNDO, before.equals(getAbsoluteBounds(cep)));

		getEMFCommandStack().redo();
		assertTrue(MOVE + TEST_THE_REDO, after.equals(getAbsoluteBounds(cep)));
	}

	@Test
	public void testMovingLeft() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(70, 20));
		final LifelineEditPart lifelineEP = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), SequenceUtil.getAbsoluteBounds(lifelineEP).getCenter().getTranslated(-2, 70));
		final CombinedFragmentEditPart cep = (CombinedFragmentEditPart)getRootEditPart().getChildren().get(1);
		waitForComplete(); // wait for updating covered field

		Point moveDelta = new Point(-30, 0);
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
		req.setResizeDirection(PositionConstants.EAST);
		req.setLocation(getAbsoluteCenter(lifelineEP));
		req.setEditParts(lifelineEP);
		req.setMoveDelta(moveDelta);

		Command command = lifelineEP.getCommand(req);
		assertNotNull(MOVE + COMMAND_NULL, command);
		assertTrue(MOVE + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		Rectangle before = getAbsoluteBounds(cep);
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(command));

		Rectangle after = getAbsoluteBounds(cep);
		assertTrue(MOVE + TEST_THE_EXECUTION, after.x() - before.x() == moveDelta.x);
		assertTrue(MOVE + TEST_THE_EXECUTION, after.y() - before.y() == moveDelta.y);

		getEMFCommandStack().undo();
		assertTrue(MOVE + TEST_THE_UNDO, before.equals(getAbsoluteBounds(cep)));

		getEMFCommandStack().redo();
		assertTrue(MOVE + TEST_THE_REDO, after.equals(getAbsoluteBounds(cep)));
	}

	public void createNode(IElementType type, GraphicalEditPart parent, Point location) {
		//CREATION
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getRootEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(location);
		Command command = parent.getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		getDiagramCommandStack().execute(command);
	}
}
