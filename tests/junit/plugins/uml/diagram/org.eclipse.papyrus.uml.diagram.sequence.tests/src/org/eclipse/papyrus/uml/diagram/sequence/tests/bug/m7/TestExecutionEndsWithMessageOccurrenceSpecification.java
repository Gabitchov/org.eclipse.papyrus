/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ExecutionSpecificationEndEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.junit.Test;


/**
 * Test Execution ends(one is MessageOccurrenceSpecification of linked message) when the message reconnected or deleted.
 *
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class TestExecutionEndsWithMessageOccurrenceSpecification extends AbstractNodeTest {

	private AbstractExecutionSpecificationEditPart createExecutionSpecificationWithLifeline(Point lifelineLocation, Dimension executionSize) {
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), lifelineLocation, null);
		assertNotNull("create ExecutionSpecification's Lifeline", lifeline);
		AbstractExecutionSpecificationEditPart es = (AbstractExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifeline, getAbsoluteBounds(lifeline).getCenter(), executionSize);
		assertNotNull("create ExecutionSpecification", es);
		return es;
	}

	@SuppressWarnings("rawtypes")
	private ExecutionSpecificationEndEditPart findEndEditPart(AbstractExecutionSpecificationEditPart parent, boolean startEnd) {
		if(parent == null) {
			return null;
		}
		ExecutionSpecification execution = (ExecutionSpecification)parent.resolveSemanticElement();
		OccurrenceSpecification end = startEnd ? execution.getStart() : execution.getFinish();
		List children = parent.getChildren();
		for(Object object : children) {
			if(object instanceof ExecutionSpecificationEndEditPart && ((ExecutionSpecificationEndEditPart)object).resolveSemanticElement() == end) {
				return (ExecutionSpecificationEndEditPart)object;
			}
		}
		return null;
	}

	private void checkExecutionEnds(ExecutionSpecification execution, OccurrenceSpecification start, OccurrenceSpecification finish) {
		checkExecutionValid(execution);
		assertNotNull("start", start);
		assertNotNull("finish", finish);
		assertEquals("execution start", start, execution.getStart());
		assertEquals("execution finish", finish, execution.getFinish());
	}

	private void checkExecutionValid(ExecutionSpecification execution) {
		assertNotNull("execution", execution);
		assertNotNull("start", execution.getStart());
		assertNotNull("finish", execution.getFinish());
	}

	@Test
	public void testReconnectSourceToExecution() {
		AbstractExecutionSpecificationEditPart execution1 = createExecutionSpecificationWithLifeline(new Point(100, 100), null);
		AbstractExecutionSpecificationEditPart execution2 = createExecutionSpecificationWithLifeline(new Point(300, 100), null);
		//1. create message: execution1.start ----message----> execution2
		ExecutionSpecificationEndEditPart source = findEndEditPart(execution1, true);
		AbstractMessageEditPart message = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, execution1.getViewer(), SequenceUtil.getAbsoluteBounds(execution1).getTop(), source, SequenceUtil.getAbsoluteBounds(execution2).getCenter(), execution2);
		assertNotNull("Message", message);
		Message umlMsg = (Message)message.resolveSemanticElement();
		ExecutionSpecification umlExecution = (ExecutionSpecification)execution1.resolveSemanticElement();
		// result: execution1.start == message.sendEvent
		checkExecutionEnds(umlExecution, (OccurrenceSpecification)umlMsg.getSendEvent(), umlExecution.getFinish());

		//2. reconnect message: execution1 ----message----> execution2
		reconnectSource(message, execution1, SequenceUtil.getAbsoluteBounds(execution1).getCenter().getTranslated(0, -5));
		// result: execution1.start != message.sendEvent && execution1.start = executionOccurrenceSpecification
		checkExecutionValid(umlExecution);
		assertNotSame("should not same: execution start", umlMsg.getSendEvent(), umlExecution.getStart());
		assertNotSame("should not same: execution finish", umlMsg.getSendEvent(), umlExecution.getFinish());

		//3. reconnect message: execution1.finish ----message----> execution2
		reconnectSource(message, findEndEditPart(execution1, false), SequenceUtil.getAbsoluteBounds(execution1).getBottom());
		//result: execution1.finish = message.sendEvent
		checkExecutionEnds(umlExecution, umlExecution.getStart(), (OccurrenceSpecification)umlMsg.getSendEvent());

		//4. REPEAT: reconnect message : execution1 ----message----> execution2
		reconnectSource(message, execution1, SequenceUtil.getAbsoluteBounds(execution1).getCenter().getTranslated(0, -5));
		// result: execution1.start != message.sendEvent && execution1.start = executionOccurrenceSpecification
		checkExecutionValid(umlExecution);
		assertNotSame("should not same: execution start", umlMsg.getSendEvent(), umlExecution.getStart());
		assertNotSame("should not same: execution finish", umlMsg.getSendEvent(), umlExecution.getFinish());
	}

	@Test
	public void testReconnectTargetToExecution() {
		AbstractExecutionSpecificationEditPart execution1 = createExecutionSpecificationWithLifeline(new Point(100, 100), null);
		AbstractExecutionSpecificationEditPart execution2 = createExecutionSpecificationWithLifeline(new Point(300, 100), null);
		//1. create message: execution1 ----message----> execution2.start
		ExecutionSpecificationEndEditPart target = findEndEditPart(execution2, true);
		AbstractMessageEditPart message = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, execution1.getViewer(), SequenceUtil.getAbsoluteBounds(execution1).getCenter(), execution1, SequenceUtil.getAbsoluteBounds(execution2).getTop(), target);
		assertNotNull("Message", message);
		Message umlMsg = (Message)message.resolveSemanticElement();
		ExecutionSpecification umlExecution = (ExecutionSpecification)execution2.resolveSemanticElement();
		// result: execution2.start == message.receiveEvent
		checkExecutionEnds(umlExecution, (OccurrenceSpecification)umlMsg.getReceiveEvent(), umlExecution.getFinish());

		//2. reconnect message: execution1 ----message----> execution2
		reconnectTarget(message, execution2, SequenceUtil.getAbsoluteBounds(execution2).getCenter().getTranslated(0, 5));
		// result: execution2.start != message.receiveEvent && execution2.start = executionOccurrenceSpecification
		// result: execution2.finish != message.receiveEvent && execution2.finish = executionOccurrenceSpecification
		checkExecutionValid(umlExecution);
		assertNotSame("should not same: execution start", umlMsg.getReceiveEvent(), umlExecution.getStart());
		assertNotSame("should not same: execution finish", umlMsg.getReceiveEvent(), umlExecution.getFinish());

		//3. reconnect message: execution1 ----message----> execution2.finish
		reconnectTarget(message, findEndEditPart(execution2, false), SequenceUtil.getAbsoluteBounds(execution2).getBottom());
		//result: execution2.finish = message.receiveEvent
		checkExecutionEnds(umlExecution, umlExecution.getStart(), (OccurrenceSpecification)umlMsg.getReceiveEvent());

		//4. REPEAT: reconnect message : execution1 ----message----> execution2
		reconnectTarget(message, execution2, SequenceUtil.getAbsoluteBounds(execution2).getCenter().getTranslated(0, 5));
		// result: execution2.start != message.receiveEvent && execution2.start = executionOccurrenceSpecification
		// result: execution2.finish != message.receiveEvent && execution2.finish = executionOccurrenceSpecification
		checkExecutionValid(umlExecution);
		assertNotSame("should not same: execution start", umlMsg.getReceiveEvent(), umlExecution.getStart());
		assertNotSame("should not same: execution finish", umlMsg.getReceiveEvent(), umlExecution.getFinish());

	}

	@Test
	public void testReconnectSourceToChildExecution() {
		AbstractExecutionSpecificationEditPart execution1 = createExecutionSpecificationWithLifeline(new Point(100, 100), new Dimension(16, 80));
		AbstractExecutionSpecificationEditPart execution2 = createExecutionSpecificationWithLifeline(new Point(300, 100), new Dimension(16, 150));
		AbstractExecutionSpecificationEditPart execution3 = (AbstractExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, execution1.getParent(), SequenceUtil.getAbsoluteBounds(execution1).getCenter(), null);
		//1. create message: execution1.start ----message----> execution2
		ExecutionSpecificationEndEditPart source = findEndEditPart(execution1, true);
		AbstractMessageEditPart message = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, execution1.getViewer(), SequenceUtil.getAbsoluteBounds(execution1).getTop(), source, SequenceUtil.getAbsoluteBounds(execution2).getCenter(), execution2);
		assertNotNull("Message", message);
		Message umlMsg = (Message)message.resolveSemanticElement();
		ExecutionSpecification umlExecution = (ExecutionSpecification)execution1.resolveSemanticElement();
		// result: execution1.start == message.sendEvent
		checkExecutionEnds(umlExecution, (OccurrenceSpecification)umlMsg.getSendEvent(), umlExecution.getFinish());

		//2. reconnect message: execution3 ----message----> execution2
		reconnectSource(message, execution3, SequenceUtil.getAbsoluteBounds(execution3).getCenter());
		//result: execution1.start != message.sendEvent
		checkExecutionValid(umlExecution);
		assertNotSame("should not same: execution start", umlMsg.getSendEvent(), umlExecution.getStart());
	}

	@Test
	public void testReconnectTargetToChildExecution() {
		AbstractExecutionSpecificationEditPart execution1 = createExecutionSpecificationWithLifeline(new Point(100, 100), new Dimension(16, 100));
		AbstractExecutionSpecificationEditPart execution2 = createExecutionSpecificationWithLifeline(new Point(300, 100), new Dimension(16, 80));
		AbstractExecutionSpecificationEditPart execution3 = (AbstractExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, execution1.getParent(), SequenceUtil.getAbsoluteBounds(execution1).getCenter(), null);
		//1. create message: execution2 ----message----> execution1.start
		ExecutionSpecificationEndEditPart target = findEndEditPart(execution1, true);
		AbstractMessageEditPart message = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, execution1.getViewer(), SequenceUtil.getAbsoluteBounds(execution2).getCenter(), execution2, SequenceUtil.getAbsoluteBounds(execution1).getTop(), target);
		assertNotNull("Message", message);
		Message umlMsg = (Message)message.resolveSemanticElement();
		ExecutionSpecification umlExecution = (ExecutionSpecification)execution1.resolveSemanticElement();
		// result: execution1.start == message.receiveEvent
		checkExecutionEnds(umlExecution, (OccurrenceSpecification)umlMsg.getReceiveEvent(), umlExecution.getFinish());

		//2. reconnect message: execution2 ----message----> execution3
		reconnectTarget(message, execution3, SequenceUtil.getAbsoluteBounds(execution3).getCenter());
		//result: execution1.start != message.receiveEvent
		checkExecutionValid(umlExecution);
		assertNotSame("should not same: execution start", umlMsg.getReceiveEvent(), umlExecution.getStart());
	}

	@Test
	public void testDeleteMessage() {
		AbstractExecutionSpecificationEditPart execution1 = createExecutionSpecificationWithLifeline(new Point(100, 100), null);
		AbstractExecutionSpecificationEditPart execution2 = createExecutionSpecificationWithLifeline(new Point(300, 100), null);
		//1. create message: execution1.start ----message----> execution2.start
		ExecutionSpecificationEndEditPart source = findEndEditPart(execution1, true);
		ExecutionSpecificationEndEditPart target = findEndEditPart(execution2, true);
		AbstractMessageEditPart message = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, execution1.getViewer(), SequenceUtil.getAbsoluteBounds(execution1).getTop(), source, SequenceUtil.getAbsoluteBounds(execution2).getTop(), target);
		assertNotNull("Message", message);
		Message umlMsg = (Message)message.resolveSemanticElement();
		ExecutionSpecification umlExecution1 = (ExecutionSpecification)execution1.resolveSemanticElement();
		ExecutionSpecification umlExecution2 = (ExecutionSpecification)execution2.resolveSemanticElement();
		checkExecutionEnds(umlExecution1, (OccurrenceSpecification)umlMsg.getSendEvent(), umlExecution1.getFinish());
		checkExecutionEnds(umlExecution2, (OccurrenceSpecification)umlMsg.getReceiveEvent(), umlExecution2.getFinish());

		//2. delete the message
		GroupRequest deleteReq = new GroupRequest(RequestConstants.REQ_DELETE);
		deleteReq.setEditParts(message);
		Command command = message.getCommand(deleteReq);
		assertNotNull("delete command", command);
		assertTrue("command can be executed", command.canExecute());
		getDiagramCommandStack().execute(command);
		checkExecutionValid(umlExecution1);
		checkExecutionValid(umlExecution2);
	}

	@Test
	public void testDeleteSourceExecution() {
		AbstractExecutionSpecificationEditPart execution1 = createExecutionSpecificationWithLifeline(new Point(100, 100), null);
		AbstractExecutionSpecificationEditPart execution2 = createExecutionSpecificationWithLifeline(new Point(300, 100), null);
		//1. create message: execution1.start ----message----> execution2.start
		ExecutionSpecificationEndEditPart source = findEndEditPart(execution1, true);
		ExecutionSpecificationEndEditPart target = findEndEditPart(execution2, true);
		AbstractMessageEditPart message = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, execution1.getViewer(), SequenceUtil.getAbsoluteBounds(execution1).getTop(), source, SequenceUtil.getAbsoluteBounds(execution2).getTop(), target);
		assertNotNull("Message", message);
		Message umlMsg = (Message)message.resolveSemanticElement();
		ExecutionSpecification umlExecution1 = (ExecutionSpecification)execution1.resolveSemanticElement();
		ExecutionSpecification umlExecution2 = (ExecutionSpecification)execution2.resolveSemanticElement();
		checkExecutionEnds(umlExecution1, (OccurrenceSpecification)umlMsg.getSendEvent(), umlExecution1.getFinish());
		checkExecutionEnds(umlExecution2, (OccurrenceSpecification)umlMsg.getReceiveEvent(), umlExecution2.getFinish());

		//2. delete execution1
		GroupRequest deleteReq = new GroupRequest(RequestConstants.REQ_DELETE);
		deleteReq.setEditParts(execution1);
		Command command = execution1.getCommand(deleteReq);
		assertNotNull("delete command", command);
		assertTrue("command can be executed", command.canExecute());
		getDiagramCommandStack().execute(command);
		checkExecutionValid(umlExecution2);
	}

	@Test
	public void testDeleteTargetExecution() {
		AbstractExecutionSpecificationEditPart execution1 = createExecutionSpecificationWithLifeline(new Point(100, 100), null);
		AbstractExecutionSpecificationEditPart execution2 = createExecutionSpecificationWithLifeline(new Point(300, 100), null);
		//1. create message: execution1.start ----message----> execution2.start
		ExecutionSpecificationEndEditPart source = findEndEditPart(execution1, true);
		ExecutionSpecificationEndEditPart target = findEndEditPart(execution2, true);
		AbstractMessageEditPart message = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, execution1.getViewer(), SequenceUtil.getAbsoluteBounds(execution1).getTop(), source, SequenceUtil.getAbsoluteBounds(execution2).getTop(), target);
		assertNotNull("Message", message);
		Message umlMsg = (Message)message.resolveSemanticElement();
		ExecutionSpecification umlExecution1 = (ExecutionSpecification)execution1.resolveSemanticElement();
		ExecutionSpecification umlExecution2 = (ExecutionSpecification)execution2.resolveSemanticElement();
		checkExecutionEnds(umlExecution1, (OccurrenceSpecification)umlMsg.getSendEvent(), umlExecution1.getFinish());
		checkExecutionEnds(umlExecution2, (OccurrenceSpecification)umlMsg.getReceiveEvent(), umlExecution2.getFinish());

		//2. delete execution2
		GroupRequest deleteReq = new GroupRequest(RequestConstants.REQ_DELETE);
		deleteReq.setEditParts(execution2);
		Command command = execution2.getCommand(deleteReq);
		assertNotNull("delete command", command);
		assertTrue("command can be executed", command.canExecute());
		getDiagramCommandStack().execute(command);
		checkExecutionValid(umlExecution1);
	}
}
