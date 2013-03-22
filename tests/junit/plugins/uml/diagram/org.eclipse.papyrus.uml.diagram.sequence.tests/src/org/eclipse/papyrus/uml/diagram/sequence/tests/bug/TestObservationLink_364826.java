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

import java.util.ArrayList;

import org.eclipse.draw2d.AbstractPointListShape;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Anchor;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.sequence.ObservationLinkMetamodelType;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestLink;
import org.junit.Test;


/**
 * To enhance the usability of time and duration observation, these elements have
 * to be handled like a classic UML constraint. In a first step, an observation
 * should be created, and in a second step it should be linked to a messageEnd or
 * execution specification event with a Link (like a constraint link). The
 * semantic of this link is different to the semantic of the constraintLink
 * because Observations are PackageableElements.
 */
public class TestObservationLink_364826 extends TestLink {

	public static final String OBSERVATION_LINK_TYPE = "observation link"; //$NON-NLS-1$

	public static final String OBSERVATION_LINK_REQUEST_START = "observation connection start"; //$NON-NLS-1$

	public static final String OBSERVATION_LINK_REQUEST_END = "observation connection end"; //$NON-NLS-1$

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
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

	@Test
	public void testTimeObservationExecution1() {
		manageTimeObservationExecution(UMLElementTypes.ActionExecutionSpecification_3006);
	}

	@Test
	public void testTimeObservationExecution2() {
		manageTimeObservationExecution(UMLElementTypes.BehaviorExecutionSpecification_3003);
	}

	@Test
	public void testTimeObservationLink1() {
		manageTimeObservationLink(UMLElementTypes.Message_4004, null);
	}

	@Test
	public void testTimeObservationLink2() {
		manageTimeObservationLink(UMLElementTypes.Message_4006, null);
	}

	@Test
	public void testTimeObservationLink3() {
		manageTimeObservationLink(UMLElementTypes.Message_4007, null);
	}

	@Test
	public void testTimeObservationLink4() {
		manageTimeObservationLink(UMLElementTypes.Message_4003, UMLElementTypes.ActionExecutionSpecification_3006);
	}

	@Test
	public void testTimeObservationLink5() {
		manageTimeObservationLink(UMLElementTypes.Message_4003, UMLElementTypes.BehaviorExecutionSpecification_3003);
	}

	@Test
	public void testTimeObservationLink6() {
		manageTimeObservationLink(UMLElementTypes.Message_4005, UMLElementTypes.ActionExecutionSpecification_3006);
	}

	@Test
	public void testTimeObservationLink7() {
		manageTimeObservationLink(UMLElementTypes.Message_4005, UMLElementTypes.BehaviorExecutionSpecification_3003);
	}

	@Test
	public void testDurationObservationLink1() {
		manageDurationObservationLink(UMLElementTypes.Message_4004, null);
	}

	@Test
	public void testDurationObservationLink2() {
		manageDurationObservationLink(UMLElementTypes.Message_4006, null);
	}

	@Test
	public void testDurationObservationLink3() {
		manageDurationObservationLink(UMLElementTypes.Message_4007, null);
	}

	@Test
	public void testDurationObservationLink4() {
		manageDurationObservationLink(UMLElementTypes.Message_4003, UMLElementTypes.ActionExecutionSpecification_3006);
	}

	@Test
	public void testDurationObservationLink5() {
		manageDurationObservationLink(UMLElementTypes.Message_4003, UMLElementTypes.BehaviorExecutionSpecification_3003);
	}

	@Test
	public void testDurationObservationLink6() {
		manageDurationObservationLink(UMLElementTypes.Message_4005, UMLElementTypes.ActionExecutionSpecification_3006);
	}

	@Test
	public void testDurationObservationLink7() {
		manageDurationObservationLink(UMLElementTypes.Message_4005, UMLElementTypes.BehaviorExecutionSpecification_3003);
	}


	public void manageDurationObservationLink(IElementType linkType, IElementType execType) {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), new Dimension(62, 250));
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(500, 100), new Dimension(62, 250));
		createNode(UMLElementTypes.DurationObservation_3024, getRootEditPart(), new Point(100, 100), new Dimension(20, 15));
		createNode(UMLElementTypes.DurationObservation_3024, getRootEditPart(), new Point(100, 200), new Dimension(20, 15));
		waitForComplete();

		GraphicalEditPart lifeline1 = (GraphicalEditPart)getRootEditPart().getChildren().get(0);
		GraphicalEditPart lifeline2 = (GraphicalEditPart)getRootEditPart().getChildren().get(1);
		GraphicalEditPart observation1 = (GraphicalEditPart)getRootEditPart().getChildren().get(2);
		GraphicalEditPart observation2 = (GraphicalEditPart)getRootEditPart().getChildren().get(3);

		AbstractMessageEditPart connPart = null;
		// create message link between lifeline
		if(execType == null) {
			createLink(linkType, lifeline1, lifeline2, getAbsoluteCenter(lifeline1), getAbsoluteCenter(lifeline2));

			connPart = (AbstractMessageEditPart)lifeline1.getSourceConnections().get(0);
		} else {
			createNode(execType, lifeline1, getAbsoluteCenter(lifeline1).translate(0, -20), null);
			createNode(execType, lifeline2, getAbsoluteCenter(lifeline2).translate(0, 40), null);
			IGraphicalEditPart start = (IGraphicalEditPart)lifeline1.getChildren().get(1);
			IGraphicalEditPart end = (IGraphicalEditPart)lifeline2.getChildren().get(1);

			waitForComplete();
			createLink(linkType, start, end, getAbsoluteTop(start), getAbsoluteTop(end));
			connPart = (AbstractMessageEditPart)start.getSourceConnections().get(0);
		}
		waitForComplete();

		manageObservationLink(observation1, connPart, getAbsoluteEdgeExtremity(connPart, true).translate(0, -5));
		manageObservationLink(observation2, connPart, getAbsoluteEdgeExtremity(connPart, false).translate(0, -5));
	}


	public void manageTimeObservationLink(IElementType linkType, IElementType execType) {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), new Dimension(62, 250));
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(500, 100), new Dimension(62, 250));
		createNode(UMLElementTypes.TimeObservation_3020, getRootEditPart(), new Point(100, 100), new Dimension(20, 15));
		createNode(UMLElementTypes.TimeObservation_3020, getRootEditPart(), new Point(100, 200), new Dimension(20, 15));
		waitForComplete();

		GraphicalEditPart lifeline1 = (GraphicalEditPart)getRootEditPart().getChildren().get(0);
		GraphicalEditPart lifeline2 = (GraphicalEditPart)getRootEditPart().getChildren().get(1);
		GraphicalEditPart observation1 = (GraphicalEditPart)getRootEditPart().getChildren().get(2);
		GraphicalEditPart observation2 = (GraphicalEditPart)getRootEditPart().getChildren().get(3);

		AbstractMessageEditPart connPart = null;
		// create message link between lifeline
		if(execType == null) {
			createLink(linkType, lifeline1, lifeline2, getAbsoluteCenter(lifeline1), getAbsoluteCenter(lifeline2));

			connPart = (AbstractMessageEditPart)lifeline1.getSourceConnections().get(0);
		} else {
			createNode(execType, lifeline1, getAbsoluteCenter(lifeline1).translate(0, -20), null);
			createNode(execType, lifeline2, getAbsoluteCenter(lifeline2).translate(0, 40), null);
			IGraphicalEditPart start = (IGraphicalEditPart)lifeline1.getChildren().get(1);
			IGraphicalEditPart end = (IGraphicalEditPart)lifeline2.getChildren().get(1);

			waitForComplete();
			createLink(linkType, start, end, getAbsoluteTop(start), getAbsoluteTop(end));
			connPart = (AbstractMessageEditPart)start.getSourceConnections().get(0);
		}
		waitForComplete();

		//TimeObservationLabelEditPart
		observation1 = (GraphicalEditPart)observation1.getChildren().get(0);
		observation2 = (GraphicalEditPart)observation2.getChildren().get(0);

		manageObservationLink(observation1, lifeline1, getAbsoluteEdgeExtremity(connPart, true).translate(0, -5));
		manageObservationLink(observation2, lifeline2, getAbsoluteEdgeExtremity(connPart, false).translate(0, -5));
	}


	public void manageTimeObservationExecution(IElementType type) {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), new Dimension(62, 250));
		createNode(UMLElementTypes.TimeObservation_3020, getRootEditPart(), new Point(100, 100), new Dimension(20, 15));
		createNode(UMLElementTypes.TimeObservation_3020, getRootEditPart(), new Point(100, 200), new Dimension(20, 15));
		waitForComplete();

		GraphicalEditPart lifeline1 = (GraphicalEditPart)getRootEditPart().getChildren().get(0);
		GraphicalEditPart observation1 = (GraphicalEditPart)getRootEditPart().getChildren().get(1);
		GraphicalEditPart observation2 = (GraphicalEditPart)getRootEditPart().getChildren().get(2);

		//TimeObservationLabelEditPart
		observation1 = (GraphicalEditPart)observation1.getChildren().get(0);
		observation2 = (GraphicalEditPart)observation2.getChildren().get(0);
		waitForComplete();

		createNode(type, lifeline1, getAbsoluteCenter(lifeline1).translate(0, -20), null);
		waitForComplete();

		manageObservationLink(observation1, lifeline1, getAbsoluteBounds((IGraphicalEditPart)lifeline1.getChildren().get(1)).getTop().getCopy().translate(0, -5));
		manageObservationLink(observation2, lifeline1, getAbsoluteBounds((IGraphicalEditPart)lifeline1.getChildren().get(1)).getBottom().getCopy().translate(0, 5));
	}

	protected void manageObservationLink(GraphicalEditPart start, EditPart end, Point t) {
		{
			ArrayList list = new ArrayList();
			list.add(ObservationLinkMetamodelType.getInstance());

			CreateUnspecifiedTypeConnectionRequest connectionRequest = new CreateUnspecifiedTypeConnectionRequest(list, false, getRootEditPart().getDiagramPreferencesHint());
			connectionRequest.setType(OBSERVATION_LINK_REQUEST_START);
			//connectionRequest.setFactory(new SimpleFactory(ObservationLink.class));

			connectionRequest.setLocation(getAbsoluteCenter(start));

			connectionRequest.setSourceEditPart(null);
			connectionRequest.setTargetEditPart(start);
			start.getCommand(connectionRequest);
			// Now, setup the request in preparation to get the
			// connection end
			// command.
			connectionRequest.setSourceEditPart(start);
			connectionRequest.setTargetEditPart(end);
			connectionRequest.setType(OBSERVATION_LINK_REQUEST_END);
			connectionRequest.setLocation(t);

			EObject container = getRootEditPart().resolveSemanticElement();
			connectionRequest.getExtendedData().put(SOURCE_MODEL_CONTAINER, container);
			connectionRequest.getExtendedData().put(TARGET_MODEL_CONTAINER, container);

			Command command = end.getCommand(connectionRequest);
			assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
			getDiagramCommandStack().execute(command);
			assertTrue(CREATION + INITIALIZATION_TEST, start.getSourceConnections().size() == 1);

			getDiagramCommandStack().undo();
			assertTrue(CREATION + TEST_THE_UNDO, start.getSourceConnections().size() == 0);

			getDiagramCommandStack().redo();
			assertTrue(CREATION + TEST_THE_REDO, start.getSourceConnections().size() == 1);
		}
		{ // destroy
			Request deleteViewRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
			Command command = ((ConnectionEditPart)start.getSourceConnections().get(0)).getCommand(deleteViewRequest);
			assertNotNull(DESTROY_DELETION + COMMAND_NULL, command);
			assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
			assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

			getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(command));
			assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, start.getSourceConnections().size() == 0);

			getEMFCommandStack().undo();
			assertTrue(DESTROY_DELETION + TEST_THE_UNDO, start.getSourceConnections().size() == 1);

			getEMFCommandStack().redo();
			assertTrue(DESTROY_DELETION + TEST_THE_REDO, start.getSourceConnections().size() == 0);
		}

		getEMFCommandStack().undo();
		{ // delete view
			Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
			Command command = ((ConnectionEditPart)start.getSourceConnections().get(0)).getCommand(deleteViewRequest);
			assertNotNull(VIEW_DELETION + COMMAND_NULL, command);
			assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
			assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

			getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(command));
			assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, start.getSourceConnections().size() == 0);

			getEMFCommandStack().undo();
			assertTrue(VIEW_DELETION + TEST_THE_UNDO, start.getSourceConnections().size() == 1);

			getEMFCommandStack().redo();
			assertTrue(VIEW_DELETION + TEST_THE_REDO, start.getSourceConnections().size() == 0);
		}
		getEMFCommandStack().undo();
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

	@Override
	protected Point getAbsoluteCenter(IGraphicalEditPart part) {
		IFigure f = part.getFigure();
		Rectangle b = f.getBounds().getCopy();
		f.translateToAbsolute(b);
		Point c = b.getCenter().getCopy();
		return c;
	}

	protected Point getAbsoluteTop(IGraphicalEditPart part) {
		IFigure f = part.getFigure();
		Rectangle b = f.getBounds().getCopy();
		f.translateToAbsolute(b);
		Point c = b.getTop().getCopy();
		return c;
	}

	/**
	 * Copy from org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil.getAbsoluteEdgeExtremity(ConnectionNodeEditPart, boolean)
	 * 
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
}
