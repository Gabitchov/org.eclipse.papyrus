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

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.junit.Test;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class TestMessageOccurrenceSpecification_402975 extends AbstractNodeTest {

	@Override
	protected String getProjectName() {
		return ISequenceDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return ISequenceDiagramTestsConstants.FILE_NAME;
	}
	
	protected EditPart createNode(IElementType type, EditPart parentPart, Point location, Dimension size) {
		EditPart node = super.createNode(type, parentPart, location, size);
		assertNotNull("Create Node Failed: " + type.getDisplayName(), node);
		return node;
	}

	protected AbstractExecutionSpecificationEditPart createExecutionSpecificationWithLifeline(Point lifelineLocation, Dimension lifelineSize) {
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), lifelineLocation, lifelineSize);
		assertNotNull("create ExecutionSpecification's Lifeline", lifeline);
		AbstractExecutionSpecificationEditPart es = (AbstractExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifeline, getAbsoluteBounds(lifeline).getCenter(), null);
		assertNotNull("create ExecutionSpecification", es);
		return es;
	}

	private void doCheckExecution(ExecutionSpecification execution, Message message, boolean isStart) {
		if(execution == null) {
			return;
		}
		OccurrenceSpecification start = execution.getStart();
		assertNotNull("execution start event", start);
		OccurrenceSpecification finish = execution.getFinish();
		assertNotNull("execution finish event", finish);
		//		if(message != null) {
		//			MessageSort messageSort = message.getMessageSort();
		//			if(isStart && MessageSort.SYNCH_CALL_LITERAL == messageSort) {
		//				assertEquals("execution start == message target", message.getReceiveEvent(), start);
		//			} else if(!isStart && MessageSort.REPLY_LITERAL == messageSort) {
		//				assertEquals("execution finish == message source", message.getSendEvent(), finish);
		//			}
		//		} else {
		//			assertTrue("execution start type", start instanceof ExecutionOccurrenceSpecification);
		//			assertTrue("execution finish type", finish instanceof ExecutionOccurrenceSpecification);
		//		}
	}

	private void doCheckExecution(ExecutionSpecification execution) {
		doCheckExecution(execution, null, false);
	}

	@Test
	public void testCreateSyncMessage() {
		AbstractExecutionSpecificationEditPart part1 = createExecutionSpecificationWithLifeline(new Point(50, 100), null);
		AbstractExecutionSpecificationEditPart part2 = createExecutionSpecificationWithLifeline(new Point(200, 100), null);
		Point startLocation = getAbsoluteBounds(part1).getCenter();
		Point endLocation = getAbsoluteCenter(part2).setY(startLocation.y + 1);
		ExecutionSpecification execution = (ExecutionSpecification)part2.resolveSemanticElement();
		assertNotNull("execution", execution);
		doCheckExecution(execution);
		MessageEditPart message = (MessageEditPart)createLink(UMLElementTypes.Message_4003, part1.getViewer(), startLocation, part1, endLocation, part2);
		assertNotNull("Sync message", message);
		Message msg = (Message)message.resolveSemanticElement();
		assertNotNull("message", msg);
		doCheckExecution(execution, msg, true);
		getDiagramCommandStack().undo();
		doCheckExecution(execution);
		getDiagramCommandStack().redo();
		message = (MessageEditPart)part2.getTargetConnections().get(0);
		msg = (Message)message.resolveSemanticElement();
		assertNotNull("message", msg);
		doCheckExecution(execution, msg, true);
	}

	@Test
	public void testReconnectSyncMessage() {
		AbstractExecutionSpecificationEditPart part1 = createExecutionSpecificationWithLifeline(new Point(50, 100), null);
		AbstractExecutionSpecificationEditPart part2 = createExecutionSpecificationWithLifeline(new Point(200, 100), null);
		Point startLocation = getAbsoluteBounds(part1).getCenter();
		Point endLocation = getAbsoluteCenter(part2).setY(startLocation.y + 1);
		ExecutionSpecification execution2 = (ExecutionSpecification)part2.resolveSemanticElement();
		assertNotNull("execution2", execution2);
		doCheckExecution(execution2);
		MessageEditPart messagePart = (MessageEditPart)createLink(UMLElementTypes.Message_4003, part1.getViewer(), startLocation, part1, endLocation, part2);
		assertNotNull("Sync message", messagePart);
		Message message = (Message)messagePart.resolveSemanticElement();
		assertNotNull("message", message);
		doCheckExecution(execution2, message, true);
		AbstractExecutionSpecificationEditPart part3 = (AbstractExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, part2.getParent(), getAbsoluteBounds(part2).getLocation().getTranslated(0, 100), null);
		ExecutionSpecification execution3 = (ExecutionSpecification)part3.resolveSemanticElement();
		assertNotNull("execution3", execution3);
		//reconnect from execution2 to execution3.
		reconnectTarget(messagePart, part3, getAbsoluteBounds(part3).getLocation());
		doCheckExecution(execution2);
		doCheckExecution(execution3, message, true);
		getDiagramCommandStack().undo();
		doCheckExecution(execution3);
		doCheckExecution(execution2, message, true);
		getDiagramCommandStack().redo();
		assertNotNull("message", message);
		doCheckExecution(execution2);
		doCheckExecution(execution3, message, true);
	}

	@Test
	public void testDeleteSyncMessage() {
		AbstractExecutionSpecificationEditPart part1 = createExecutionSpecificationWithLifeline(new Point(50, 100), null);
		AbstractExecutionSpecificationEditPart part2 = createExecutionSpecificationWithLifeline(new Point(200, 100), null);
		Point startLocation = getAbsoluteBounds(part1).getCenter();
		Point endLocation = getAbsoluteCenter(part2).setY(startLocation.y + 1);
		ExecutionSpecification execution2 = (ExecutionSpecification)part2.resolveSemanticElement();
		assertNotNull("execution2", execution2);
		doCheckExecution(execution2);
		MessageEditPart messagePart = (MessageEditPart)createLink(UMLElementTypes.Message_4003, part1.getViewer(), startLocation, part1, endLocation, part2);
		assertNotNull("Sync message", messagePart);
		Message message = (Message)messagePart.resolveSemanticElement();
		assertNotNull("message", message);
		doCheckExecution(execution2, message, true);
		deleteMessage(messagePart);
		doCheckExecution(execution2);
	}

	/**
	 * @param editPart
	 */
	private void deleteMessage(EditPart editPart) {
		assertNotNull(editPart);
		Request deleteViewRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
		Command command = editPart.getCommand(deleteViewRequest);
		assertNotNull("delete command", command);
		assertTrue("delete command executable", command.canExecute());
		getDiagramCommandStack().execute(command);
		waitForComplete();
	}

	@Test
	public void testCreateReplyMessage() {
		AbstractExecutionSpecificationEditPart part1 = createExecutionSpecificationWithLifeline(new Point(200, 100), null);
		AbstractExecutionSpecificationEditPart part2 = createExecutionSpecificationWithLifeline(new Point(50, 100), null);
		Point startLocation = getAbsoluteBounds(part1).getCenter();
		Point endLocation = getAbsoluteBounds(part2).getBottom();
		ExecutionSpecification execution = (ExecutionSpecification)part1.resolveSemanticElement();
		assertNotNull("execution", execution);
		doCheckExecution(execution);
		Message3EditPart messagePart = (Message3EditPart)createLink(UMLElementTypes.Message_4005, part1.getViewer(), startLocation, part1, endLocation, part2);
		assertNotNull("Reply message", messagePart);
		Message message = (Message)messagePart.resolveSemanticElement();
		assertNotNull("message", message);
		doCheckExecution(execution, message, false);
		getDiagramCommandStack().undo();
		doCheckExecution(execution);
		getDiagramCommandStack().redo();
		messagePart = (Message3EditPart)part1.getSourceConnections().get(0);
		message = (Message)messagePart.resolveSemanticElement();
		assertNotNull("message", message);
		doCheckExecution(execution, message, false);
	}

	@Test
	public void testReconnectReplyMessage() {
		AbstractExecutionSpecificationEditPart part1 = createExecutionSpecificationWithLifeline(new Point(200, 100), null);
		AbstractExecutionSpecificationEditPart part2 = createExecutionSpecificationWithLifeline(new Point(50, 100), null);
		Point startLocation = getAbsoluteBounds(part1).getCenter();
		Point endLocation = getAbsoluteBounds(part2).getBottom();
		ExecutionSpecification execution = (ExecutionSpecification)part1.resolveSemanticElement();
		assertNotNull("execution", execution);
		doCheckExecution(execution);
		Message3EditPart messagePart = (Message3EditPart)createLink(UMLElementTypes.Message_4005, part1.getViewer(), startLocation, part1, endLocation, part2);
		assertNotNull("Reply message", messagePart);
		Message message = (Message)messagePart.resolveSemanticElement();
		assertNotNull("message", message);
		doCheckExecution(execution, message, false);
		Point location = startLocation.getTranslated(0, -100);
		AbstractExecutionSpecificationEditPart part3 = (AbstractExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, part1.getParent(), location, null);
		ExecutionSpecification execution3 = (ExecutionSpecification)part3.resolveSemanticElement();
		assertNotNull("execution3", execution3);
		//reconnect from execution to execution3.
		reconnectSource(messagePart, part3, getAbsoluteBounds(part3).getLocation());
		doCheckExecution(execution);
		doCheckExecution(execution3, message, false);
		getDiagramCommandStack().undo();
		doCheckExecution(execution3);
		doCheckExecution(execution, message, false);
		getDiagramCommandStack().redo();
		assertNotNull("message", message);
		doCheckExecution(execution);
		doCheckExecution(execution3, message, false);
	}

	@Test
	public void testDeleteReplyMessage() {
		AbstractExecutionSpecificationEditPart part1 = createExecutionSpecificationWithLifeline(new Point(200, 100), null);
		AbstractExecutionSpecificationEditPart part2 = createExecutionSpecificationWithLifeline(new Point(50, 100), null);
		Point startLocation = getAbsoluteBounds(part1).getCenter();
		Point endLocation = getAbsoluteBounds(part2).getBottom();
		ExecutionSpecification execution = (ExecutionSpecification)part1.resolveSemanticElement();
		assertNotNull("execution", execution);
		doCheckExecution(execution);
		Message3EditPart messagePart = (Message3EditPart)createLink(UMLElementTypes.Message_4005, part1.getViewer(), startLocation, part1, endLocation, part2);
		assertNotNull("Reply message", messagePart);
		Message message = (Message)messagePart.resolveSemanticElement();
		assertNotNull("message", message);
		doCheckExecution(execution, message, false);
		deleteMessage(messagePart);
		doCheckExecution(execution);
	}
}
