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

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestLink;
import org.junit.Test;


/**
 * All lifelines (except lifelines that are result of a create message) should be
 * aligned vertically and must remain aligned.
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=364688
 * 
 */
public class TestLifelineAlignment_364688 extends TestLink {

	private static final String ALIGNMENT = "Alignment: ";

	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	@Test
	public void testAlignment() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(20, 20), new Dimension(62, 200));
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(150, 150), new Dimension(62, 200));

		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		final LifelineEditPart lifeline2 = (LifelineEditPart)getRootEditPart().getChildren().get(1);
		final LifelineEditPart lifeline3 = (LifelineEditPart)getRootEditPart().getChildren().get(2);

		assertTrue(ALIGNMENT + TEST_THE_EXECUTION, getAbsoluteBounds(lifeline1).y == getAbsoluteBounds(lifeline2).y);
		assertTrue(ALIGNMENT + TEST_THE_EXECUTION, getAbsoluteBounds(lifeline3).y == getAbsoluteBounds(lifeline2).y);
		waitForComplete();

		createLink(UMLElementTypes.Message_4006, lifeline2, lifeline3);
		assertTrue(ALIGNMENT + TEST_THE_EXECUTION, getAbsoluteBounds(lifeline1).y == getAbsoluteBounds(lifeline2).y);
		assertTrue(ALIGNMENT + TEST_THE_EXECUTION, getAbsoluteBounds(lifeline3).y > getAbsoluteBounds(lifeline2).y);
	}

	public void createLink(IElementType linkType, EditPart source, EditPart target) {
		CreateConnectionViewRequest req = createConnectionViewRequest(linkType, source, target);
		Command command = target.getCommand(req);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getDiagramCommandStack().execute(command);
	}

	public CreateConnectionViewRequest createConnectionViewRequest(IElementType type, EditPart source, EditPart target) {
		CreateConnectionViewRequest connectionRequest = CreateViewRequestFactory.getCreateConnectionRequest(type, ((IGraphicalEditPart)getDiagramEditPart()).getDiagramPreferencesHint());

		Point c = getAbsoluteCenter((IGraphicalEditPart)source);
		connectionRequest.setLocation(c);

		connectionRequest.setSourceEditPart(null);
		connectionRequest.setTargetEditPart(source);
		connectionRequest.setType(RequestConstants.REQ_CONNECTION_START);
		Command cmd = source.getCommand(connectionRequest);

		connectionRequest.setSourceEditPart(source);
		connectionRequest.setTargetEditPart(target);
		connectionRequest.setType(RequestConstants.REQ_CONNECTION_END);

		Point t = getAbsoluteCenter((IGraphicalEditPart)target);
		connectionRequest.setLocation(t);
		EObject container = getRootEditPart().resolveSemanticElement();
		connectionRequest.getExtendedData().put(SOURCE_MODEL_CONTAINER, container);
		connectionRequest.getExtendedData().put(TARGET_MODEL_CONTAINER, container);

		return connectionRequest;
	}

	public void createNode(IElementType type, GraphicalEditPart parent, Point location, Dimension size) {
		//CREATION
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getRootEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(location);
		requestcreation.setSize(size);
		Command command = parent.getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getDiagramCommandStack().execute(command);
	}
}
