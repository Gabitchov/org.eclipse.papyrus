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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestLink;
import org.junit.Test;

/**
 * The active region to select the target Lifeline is very critical in the creation of the message Create. The active region should be header and the
 * vertical bar.
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=379661
 * 
 */
public class TestMessageCreate_379661 extends TestLink {

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
	public void testHeaderAnchor() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(150, 100), new Dimension(62, 200));
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		final LifelineEditPart lifeline2 = (LifelineEditPart)getRootEditPart().getChildren().get(1);
		waitForComplete();

		RectangleFigure fig = lifeline2.getPrimaryShape().getFigureLifelineNameContainerFigure();
		Rectangle bounds = fig.getBounds().getCopy();
		fig.translateToAbsolute(bounds);

		createLink(UMLElementTypes.Message_4006, lifeline1, lifeline2, getAbsoluteCenter(lifeline1), bounds.getCenter());
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
	public void testVerticalBarAnchor() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(150, 100), new Dimension(62, 200));
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		final LifelineEditPart lifeline2 = (LifelineEditPart)getRootEditPart().getChildren().get(1);
		waitForComplete();

		IFigure fig = lifeline2.getPrimaryShape().getFigureLifelineDotLineFigure();
		Rectangle bounds = fig.getBounds().getCopy();
		fig.translateToAbsolute(bounds);

		createLink(UMLElementTypes.Message_4006, lifeline1, lifeline2, getAbsoluteCenter(lifeline1), bounds.getCenter());
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
	public void testMove() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(150, 100), new Dimension(62, 200));
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		final LifelineEditPart lifeline2 = (LifelineEditPart)getRootEditPart().getChildren().get(1);
		waitForComplete();

		IFigure fig = lifeline2.getPrimaryShape().getFigureLifelineDotLineFigure();
		Rectangle bounds = fig.getBounds().getCopy();
		fig.translateToAbsolute(bounds);

		createLink(UMLElementTypes.Message_4006, lifeline1, lifeline2, getAbsoluteCenter(lifeline1), bounds.getCenter());
		waitForComplete();
		assertTrue(CREATION + TEST_THE_EXECUTION, lifeline1.getSourceConnections().size() == 1);

		moveLifeline(lifeline1, new Point(20, 0));
		moveLifeline(lifeline2, new Point(50, 0));
		moveLifeline(lifeline2, new Point(-20, 0));

		moveLifeline(lifeline2, new Point(0, 30));
		moveLifeline(lifeline2, new Point(0, -10));
	}

	protected void moveLifeline(LifelineEditPart lifelineEP, Point moveDelta) {
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
		if(moveDelta.x != 0) {
			req.setResizeDirection(moveDelta.x > 0 ? PositionConstants.EAST : PositionConstants.WEST);
		}
		if(moveDelta.y != 0) {
			req.setResizeDirection(moveDelta.y > 0 ? PositionConstants.SOUTH : PositionConstants.NORTH);
		}
		req.setLocation(getAbsoluteCenter(lifelineEP));
		req.setEditParts(lifelineEP);
		req.setMoveDelta(moveDelta);

		Command command = lifelineEP.getCommand(req);
		assertNotNull(MOVE + COMMAND_NULL, command);
		assertTrue(MOVE + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		Rectangle before = getAbsoluteBounds(lifelineEP);
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		waitForComplete();

		Rectangle after = getAbsoluteBounds(lifelineEP);
		assertTrue(MOVE + TEST_THE_EXECUTION, after.x() - before.x() == moveDelta.x);
		assertTrue(MOVE + TEST_THE_EXECUTION, after.y() - before.y() == moveDelta.y);

		getEMFCommandStack().undo();
		waitForComplete();
		assertTrue(MOVE + TEST_THE_UNDO, before.equals(getAbsoluteBounds(lifelineEP)));

		getEMFCommandStack().redo();
		waitForComplete();
		assertTrue(MOVE + TEST_THE_REDO, after.equals(getAbsoluteBounds(lifelineEP)));
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
