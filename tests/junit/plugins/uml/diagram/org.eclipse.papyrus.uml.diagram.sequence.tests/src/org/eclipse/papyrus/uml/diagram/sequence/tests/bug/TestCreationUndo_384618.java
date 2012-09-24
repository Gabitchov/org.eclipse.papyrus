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
 * Undo doesn't work anymore for creation of the following elements: lifelines, messages, action and behavior executions.
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=384618
 * 
 */
public class TestCreationUndo_384618 extends TestLink {

	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	@Test
	public void testLifeline() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		waitForComplete();
		assertTrue(CREATION + TEST_THE_EXECUTION, getRootEditPart().getChildren().size() == 1);

		assertTrue(CREATION + TEST_THE_UNDO, getDiagramCommandStack().canUndo());
		getEMFCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, getRootEditPart().getChildren().size() == 0);

		assertTrue(CREATION + TEST_THE_REDO, getDiagramCommandStack().canRedo());
		getEMFCommandStack().redo();
		assertTrue(CREATION + TEST_THE_REDO, getRootEditPart().getChildren().size() == 1);
	}

	@Test
	public void testActionExecution() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		waitForComplete();

		createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifeline1, new Point(131, 200), new Dimension(20, 40));
		waitForComplete();
		assertTrue(CREATION + TEST_THE_EXECUTION, lifeline1.getChildren().size() == 2);

		assertTrue(CREATION + TEST_THE_UNDO, getDiagramCommandStack().canUndo());
		getEMFCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, lifeline1.getChildren().size() == 1);

		assertTrue(CREATION + TEST_THE_REDO, getDiagramCommandStack().canRedo());
		getEMFCommandStack().redo();
		assertTrue(CREATION + TEST_THE_REDO, lifeline1.getChildren().size() == 2);
	}

	@Test
	public void testBehaviorExecution() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		waitForComplete();

		createNode(UMLElementTypes.BehaviorExecutionSpecification_3003, lifeline1, new Point(131, 200), new Dimension(20, 40));
		waitForComplete();
		assertTrue(CREATION + TEST_THE_EXECUTION, lifeline1.getChildren().size() == 2);

		assertTrue(CREATION + TEST_THE_UNDO, getDiagramCommandStack().canUndo());
		getEMFCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, lifeline1.getChildren().size() == 1);

		assertTrue(CREATION + TEST_THE_REDO, getDiagramCommandStack().canRedo());
		getEMFCommandStack().redo();
		assertTrue(CREATION + TEST_THE_REDO, lifeline1.getChildren().size() == 2);
	}

	@Test
	public void testMessageAsync() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), new Dimension(62, 200));
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		final LifelineEditPart lifeline2 = (LifelineEditPart)getRootEditPart().getChildren().get(1);
		waitForComplete();

		createLink(UMLElementTypes.Message_4004, lifeline1, lifeline2, getAbsoluteCenter(lifeline1), getAbsoluteCenter(lifeline2).translate(0, 10));
		waitForComplete();
		assertTrue(CREATION + TEST_THE_EXECUTION, lifeline1.getSourceConnections().size() == 1);

		assertTrue(CREATION + TEST_THE_UNDO, getDiagramCommandStack().canUndo());
		getEMFCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, lifeline1.getSourceConnections().size() == 0);

		assertTrue(CREATION + TEST_THE_REDO, getDiagramCommandStack().canRedo());
		getEMFCommandStack().redo();
		assertTrue(CREATION + TEST_THE_REDO, lifeline1.getSourceConnections().size() == 1);
	}

	@Test
	public void testMessageDelete() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), new Dimension(62, 200));
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		final LifelineEditPart lifeline2 = (LifelineEditPart)getRootEditPart().getChildren().get(1);
		waitForComplete();

		createLink(UMLElementTypes.Message_4007, lifeline1, lifeline2, getAbsoluteCenter(lifeline1), getAbsoluteCenter(lifeline2).translate(0, 10));
		waitForComplete();
		assertTrue(CREATION + TEST_THE_EXECUTION, lifeline1.getSourceConnections().size() == 1);

		assertTrue(CREATION + TEST_THE_UNDO, getDiagramCommandStack().canUndo());
		getEMFCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, lifeline1.getSourceConnections().size() == 0);

		assertTrue(CREATION + TEST_THE_REDO, getDiagramCommandStack().canRedo());
		getEMFCommandStack().redo();
		assertTrue(CREATION + TEST_THE_REDO, lifeline1.getSourceConnections().size() == 1);
	}


	@Test
	public void testMessageCreate() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(150, 150), new Dimension(62, 200));
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		final LifelineEditPart lifeline2 = (LifelineEditPart)getRootEditPart().getChildren().get(1);
		waitForComplete();

		createLink(UMLElementTypes.Message_4006, lifeline1, lifeline2, getAbsoluteCenter(lifeline1), getAbsoluteCenter(lifeline2));
		waitForComplete();
		assertTrue(CREATION + TEST_THE_EXECUTION, lifeline1.getSourceConnections().size() == 1);

		assertTrue(CREATION + TEST_THE_UNDO, getDiagramCommandStack().canUndo());
		getEMFCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, lifeline1.getSourceConnections().size() == 0);

		assertTrue(CREATION + TEST_THE_REDO, getDiagramCommandStack().canRedo());
		getEMFCommandStack().redo();
		assertTrue(CREATION + TEST_THE_REDO, lifeline1.getSourceConnections().size() == 1);
	}

	@Test
	public void testMessageSync() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), new Dimension(62, 200));
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		final LifelineEditPart lifeline2 = (LifelineEditPart)getRootEditPart().getChildren().get(1);
		waitForComplete();

		createNode(UMLElementTypes.BehaviorExecutionSpecification_3003, lifeline1, new Point(131, 140), new Dimension(20, 60));
		createNode(UMLElementTypes.BehaviorExecutionSpecification_3003, lifeline2, new Point(331, 200), new Dimension(20, 60));
		waitForComplete();

		IGraphicalEditPart source = (IGraphicalEditPart)lifeline1.getChildren().get(1);
		IGraphicalEditPart target = (IGraphicalEditPart)lifeline2.getChildren().get(1);

		createLink(UMLElementTypes.Message_4003, source, target, getAbsoluteCenter(source), getAbsoluteCenter(target).translate(0, -28));
		waitForComplete();
		assertTrue(CREATION + TEST_THE_EXECUTION, source.getSourceConnections().size() == 1);

		assertTrue(CREATION + TEST_THE_UNDO, getDiagramCommandStack().canUndo());
		getEMFCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, source.getSourceConnections().size() == 0);

		assertTrue(CREATION + TEST_THE_REDO, getDiagramCommandStack().canRedo());
		getEMFCommandStack().redo();
		assertTrue(CREATION + TEST_THE_REDO, source.getSourceConnections().size() == 1);

	}

	@Test
	public void testMessageReply() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), new Dimension(62, 200));
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		final LifelineEditPart lifeline2 = (LifelineEditPart)getRootEditPart().getChildren().get(1);
		waitForComplete();

		createNode(UMLElementTypes.BehaviorExecutionSpecification_3003, lifeline1, new Point(131, 140), new Dimension(20, 60));
		createNode(UMLElementTypes.BehaviorExecutionSpecification_3003, lifeline2, new Point(331, 200), new Dimension(20, 60));
		waitForComplete();

		IGraphicalEditPart source = (IGraphicalEditPart)lifeline1.getChildren().get(1);
		IGraphicalEditPart target = (IGraphicalEditPart)lifeline2.getChildren().get(1);

		createLink(UMLElementTypes.Message_4005, source, target, getAbsoluteCenter(source), getAbsoluteCenter(target).translate(0, -28));
		waitForComplete();
		assertTrue(CREATION + TEST_THE_EXECUTION, source.getSourceConnections().size() == 1);

		assertTrue(CREATION + TEST_THE_UNDO, getDiagramCommandStack().canUndo());
		getEMFCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, source.getSourceConnections().size() == 0);

		assertTrue(CREATION + TEST_THE_REDO, getDiagramCommandStack().canRedo());
		getEMFCommandStack().redo();
		assertTrue(CREATION + TEST_THE_REDO, source.getSourceConnections().size() == 1);

	}

	public void createLink(IElementType linkType, EditPart source, EditPart target, Point sourcePoint, Point targetPoint) {
		CreateConnectionViewRequest req = createConnectionViewRequest(linkType, source, target, sourcePoint, targetPoint);
		Command command = target.getCommand(req);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getDiagramCommandStack().execute(command);
	}

	CreateConnectionViewRequest createConnectionViewRequest(IElementType type, EditPart source, EditPart target, Point sourcePoint, Point targetPoint) {
		CreateConnectionViewRequest connectionRequest = CreateViewRequestFactory.getCreateConnectionRequest(type, ((IGraphicalEditPart)getDiagramEditPart()).getDiagramPreferencesHint());
		connectionRequest.setLocation(sourcePoint);

		connectionRequest.setSourceEditPart(null);
		connectionRequest.setTargetEditPart(source);
		connectionRequest.setType(RequestConstants.REQ_CONNECTION_START);
		Command cmd = source.getCommand(connectionRequest);
		// Now, setup the request in preparation to get the
		// connection end
		// command.
		connectionRequest.setSourceEditPart(source);
		connectionRequest.setTargetEditPart(target);
		connectionRequest.setType(RequestConstants.REQ_CONNECTION_END);
		connectionRequest.setLocation(targetPoint);

		EObject container = getRootEditPart().resolveSemanticElement();
		connectionRequest.getExtendedData().put(SOURCE_MODEL_CONTAINER, container);
		connectionRequest.getExtendedData().put(TARGET_MODEL_CONTAINER, container);

		return connectionRequest;
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
