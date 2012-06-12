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
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.junit.Test;


/**
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=364711
 * When a lifeline covered by a combined fragment are moved (horizontally), the
 * combined fragment does'nt follow the lifeline. Combined fragments should
 * automatically follow lifeline when they are moved.
 */
public class TestMovingCombinedFragment_364711 extends TestTopNode {

	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	@Test
	public void testMovingRight() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(20, 20));
		createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(10, 80));
		final LifelineEditPart lifeline = (LifelineEditPart)getRootEditPart().getChildren().get(0);

		final CombinedFragmentEditPart cep = (CombinedFragmentEditPart)getRootEditPart().getChildren().get(1);

		waitForComplete(); // wait for updating covered field 
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_MOVE); 
		req.setResizeDirection(PositionConstants.WEST);
		req.setLocation(getAbsoluteCenter(lifeline));
		req.setEditParts(lifeline);
		req.setMoveDelta(new Point(50, 0));

		Rectangle before = getAbsoluteBounds(cep);

		Command command = lifeline.getCommand(req);
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(command));

		Rectangle after = getAbsoluteBounds(cep);
		assertTrue("Move horizontal", after.x() - before.x() == 50);
		assertTrue("Move vertical", after.y() - before.y() == 0);

	}

	@Test
	public void testMovingLeft() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(70, 20));
		createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(60, 80));
		final LifelineEditPart lifeline = (LifelineEditPart)getRootEditPart().getChildren().get(0);

		final CombinedFragmentEditPart cep = (CombinedFragmentEditPart)getRootEditPart().getChildren().get(1);
		waitForComplete(); // wait for updating covered field 
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
		req.setResizeDirection(PositionConstants.EAST);
		req.setLocation(getAbsoluteCenter(lifeline));
		req.setEditParts(lifeline);
		req.setMoveDelta(new Point(-30, 0));

		Rectangle before = getAbsoluteBounds(cep);

		Command command = lifeline.getCommand(req);
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(command));

		Rectangle after = getAbsoluteBounds(cep);
		assertTrue("Move horizontal", after.x() - before.x() == -30);
		assertTrue("Move vertical", after.y() - before.y() == 0);

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
