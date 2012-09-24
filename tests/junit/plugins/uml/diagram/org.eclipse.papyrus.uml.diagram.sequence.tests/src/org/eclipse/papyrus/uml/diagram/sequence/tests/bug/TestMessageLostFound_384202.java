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

import org.eclipse.draw2d.AbstractPointListShape;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Anchor;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestLink;
import org.junit.Test;

/**
 * Within the sequence diagram editor, it not possible to model lost message,found message or general ordering.
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=384202
 * 
 */
public class TestMessageLostFound_384202 extends TestLink {

	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	@Test
	public void testMessageFound() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));

		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);

		waitForComplete();
		source = (GraphicalEditPart)getRootEditPart().getParent();

		createLink(UMLElementTypes.Message_4009, source, lifeline1, getAbsoluteCenter(source), getAbsoluteCenter(lifeline1)); // new Point(100,0)
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
	public void testMessageLost() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));

		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);

		waitForComplete();
		target = (GraphicalEditPart)getRootEditPart().getParent();

		createLink(UMLElementTypes.Message_4008, lifeline1, target, getAbsoluteCenter(lifeline1), getAbsoluteCenter(target)); // getAbsoluteBounds(target).getBottomRight());
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
	public void testGeneralOrderingOnExecution() {
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

		createLink(UMLElementTypes.GeneralOrdering_4012, source, target, getAbsoluteBounds(source).getTop(), getAbsoluteBounds(target).getTop());
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
	public void testGeneralOrderingOnMessage() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(200, 100), new Dimension(62, 200));
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), new Dimension(62, 200));
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(400, 100), new Dimension(62, 200));
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		final LifelineEditPart lifeline2 = (LifelineEditPart)getRootEditPart().getChildren().get(1);
		final LifelineEditPart lifeline3 = (LifelineEditPart)getRootEditPart().getChildren().get(2);
		final LifelineEditPart lifeline4 = (LifelineEditPart)getRootEditPart().getChildren().get(3);
		waitForComplete();

		createLink(UMLElementTypes.Message_4004, lifeline1, lifeline2, getAbsoluteCenter(lifeline1).translate(0, -20), getAbsoluteCenter(lifeline2).translate(0, -20));
		createLink(UMLElementTypes.Message_4004, lifeline3, lifeline4, getAbsoluteCenter(lifeline3).translate(0, 20), getAbsoluteCenter(lifeline4).translate(0, 20));
		waitForComplete();
		assertTrue(CREATION + TEST_THE_EXECUTION, lifeline1.getSourceConnections().size() == 1);
		assertTrue(CREATION + TEST_THE_EXECUTION, lifeline3.getSourceConnections().size() == 1);

		AbstractMessageEditPart s = (AbstractMessageEditPart)lifeline1.getSourceConnections().get(0);
		AbstractMessageEditPart t = (AbstractMessageEditPart)lifeline3.getSourceConnections().get(0);

		createLink(UMLElementTypes.GeneralOrdering_4012, lifeline1, lifeline3, getAbsoluteEdgeExtremity(s, true), getAbsoluteEdgeExtremity(t, true));
		waitForComplete();

		assertTrue(CREATION + TEST_THE_EXECUTION, lifeline3.getTargetConnections().size() == 1);

		assertTrue(CREATION + TEST_THE_UNDO, getDiagramCommandStack().canUndo());
		getEMFCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, lifeline3.getTargetConnections().size() == 0);

		assertTrue(CREATION + TEST_THE_REDO, getDiagramCommandStack().canRedo());
		getEMFCommandStack().redo();
		assertTrue(CREATION + TEST_THE_REDO, lifeline3.getTargetConnections().size() == 1);

	}

	/**
	 * Get the extremity of a connection edit part
	 * 
	 * @param connection
	 *        the connection edit part to find extremity
	 * @param isStart
	 *        true to find the start, false for the end
	 * @return connection's extremity in absolute coordinates or null
	 */
	public static Point getAbsoluteEdgeExtremity(ConnectionNodeEditPart connection, boolean isStart) {
		Connection msgFigure = connection.getConnectionFigure();
		if(connection.getNotationView() instanceof Edge) {
			// rather take up to date model information
			Edge edge = (Edge)connection.getNotationView();
			Anchor idAnchor = null;
			ConnectionAnchor conAnchor = null;
			Object part = null;
			if(isStart && connection.getSource() instanceof IGraphicalEditPart) {
				View linkedFigure = edge.getSource();
				// connection.getSource() may be not up to date, get part for linkedFigure
				part = connection.getSource().getViewer().getEditPartRegistry().get(linkedFigure);
				idAnchor = edge.getSourceAnchor();
				conAnchor = msgFigure.getSourceAnchor();
			} else if(!isStart && connection.getTarget() instanceof IGraphicalEditPart) {
				View linkedFigure = edge.getTarget();
				// connection.getTarget() may be not up to date, get part for linkedFigure
				part = connection.getTarget().getViewer().getEditPartRegistry().get(linkedFigure);
				idAnchor = edge.getTargetAnchor();
				conAnchor = msgFigure.getTargetAnchor();
			}
			if(part instanceof IGraphicalEditPart && idAnchor instanceof IdentityAnchor && conAnchor != null) {
				// take up to date bounds of the linked part in case it is moved
				Rectangle linkedPartBounds = getAbsoluteBounds((IGraphicalEditPart)part);

				IFigure anchorOwningFigure = conAnchor.getOwner();
				IFigure partFigure = ((IGraphicalEditPart)part).getFigure();
				Dimension delta = anchorOwningFigure.getBounds().getLocation().getDifference(partFigure.getBounds().getLocation());
				// get position from anchor id
				String oldTerminal = ((IdentityAnchor)idAnchor).getId();
				PrecisionPoint pp = BaseSlidableAnchor.parseTerminalString(oldTerminal);
				int xPos = linkedPartBounds.x + delta.width + (int)Math.round(anchorOwningFigure.getBounds().width * pp.preciseX);
				int yPos = linkedPartBounds.y + delta.height + (int)Math.round(anchorOwningFigure.getBounds().height * pp.preciseY);
				return new Point(xPos, yPos);
			}
		}
		// can not get from model, rely on figure
		if(msgFigure instanceof AbstractPointListShape) {
			Point extremity;
			if(isStart) {
				// start event of the message
				extremity = ((AbstractPointListShape)msgFigure).getStart().getCopy();
			} else {
				// finish event of the message
				extremity = ((AbstractPointListShape)msgFigure).getEnd().getCopy();
			}
			msgFigure.getParent().translateToAbsolute(extremity);
			return extremity;
		}
		return null;
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
