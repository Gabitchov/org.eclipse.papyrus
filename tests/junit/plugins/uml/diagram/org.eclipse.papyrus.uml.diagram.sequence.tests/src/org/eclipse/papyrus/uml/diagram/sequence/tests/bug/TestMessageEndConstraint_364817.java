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
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageEndEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestLink;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.MessageEnd;
import org.junit.Test;

/**
 * It is not possible to link a constraint to a messageEnd with a constraint Link.
 * The selection of a messageEnd should be possible.
 * 
 */
public class TestMessageEndConstraint_364817 extends TestLink {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	public void checkConstraintLink(IElementType sourceType, IElementType targetType, IElementType linkType, IElementType subNodeType) {
		installEnvironment(sourceType, targetType, subNodeType);

		createNode(UMLElementTypes.Constraint_3008, getRootEditPart(), new Point(200, 400), new Dimension(100, 50));
		createLink(linkType, source, target, getAbsoluteCenter(source), getAbsoluteCenter(target));
		waitForComplete();

		AbstractMessageEditPart linkEditPart = (AbstractMessageEditPart)source.getSourceConnections().get(0);
		MessageEndEditPart linkEndPoint = null;
		for(Object child : linkEditPart.getChildren())
			if(child instanceof MessageEndEditPart)
			linkEndPoint = (MessageEndEditPart) child;
		
		ConstraintEditPart constraintEditPart = (ConstraintEditPart)getRootEditPart().getChildren().get(2);
		createLink(UMLElementTypes.ConstraintConstrainedElement_4011, constraintEditPart, linkEndPoint, getAbsoluteCenter(constraintEditPart), getAbsoluteCenter(linkEndPoint));

		Constraint constraint = (Constraint)constraintEditPart.resolveSemanticElement();
		assertTrue(CREATION + TEST_THE_EXECUTION, constraint.getConstrainedElements().get(0) instanceof MessageEnd);
		assertTrue(CREATION + TEST_THE_EXECUTION, constraintEditPart.getSourceConnections().size() == 1);

		getDiagramCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, constraintEditPart.getSourceConnections().size() == 0);

		getDiagramCommandStack().redo();
		assertTrue(CREATION + TEST_THE_REDO, constraintEditPart.getSourceConnections().size() == 1);
	}

	@Test
	public void testMessageAsync_4004() {
		checkConstraintLink(UMLElementTypes.Lifeline_3001, UMLElementTypes.Lifeline_3001, UMLElementTypes.Message_4004, null);
	}

	@Test
	public void testMessageSync_4003() {
		checkConstraintLink(UMLElementTypes.Lifeline_3001, UMLElementTypes.Lifeline_3001, UMLElementTypes.Message_4003, UMLElementTypes.ActionExecutionSpecification_3006);
	}

	@Test
	public void testMessageReply_4005() {
		checkConstraintLink(UMLElementTypes.Lifeline_3001, UMLElementTypes.Lifeline_3001, UMLElementTypes.Message_4005, UMLElementTypes.ActionExecutionSpecification_3006);
	}

	@Test
	public void testMessageDelete_4007() {
		checkConstraintLink(UMLElementTypes.Lifeline_3001, UMLElementTypes.Lifeline_3001, UMLElementTypes.Message_4007, null);
	}

	@Test
	public void testMessageCreate_4006() {
		checkConstraintLink(UMLElementTypes.Lifeline_3001, UMLElementTypes.Lifeline_3001, UMLElementTypes.Message_4006, null);
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

		// get the connection end command
		connectionRequest.setSourceEditPart(source);
		connectionRequest.setTargetEditPart(target);
		connectionRequest.setType(RequestConstants.REQ_CONNECTION_END);
		connectionRequest.setLocation(targetPoint);

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

	public void installEnvironment(IElementType sourceType, IElementType targetType, IElementType subNodeType) {
		//create the source
		createNode(sourceType, getRootEditPart(), new Point(100, 100), new Dimension(62, 250));

		//create the target
		createNode(targetType, getRootEditPart(), new Point(300, 100), new Dimension(62, 250));

		source = (GraphicalEditPart)getRootEditPart().getChildren().get(0);
		target = (GraphicalEditPart)getRootEditPart().getChildren().get(1);

		if(subNodeType != null) {
			waitForComplete();
			source = createSubNode(source, subNodeType, getAbsoluteCenter(source));
			target = createSubNode(target, subNodeType, getAbsoluteCenter(target).translate(0, 50));
			waitForComplete();
		}
	}
}
