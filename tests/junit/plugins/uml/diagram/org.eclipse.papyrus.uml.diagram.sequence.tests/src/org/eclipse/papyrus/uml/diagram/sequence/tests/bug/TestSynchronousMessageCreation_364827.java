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
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestLink;
import org.junit.Test;

/**
 * When a synchronous message is created, an executionSpecification (Action or
 * Behavior: a popup menu should give the choice to the user) has to be created in
 * case it does'nt exist.
 * 
 */
public class TestSynchronousMessageCreation_364827 extends TestLink {

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
	
	public void selectActionExecution(IElementType sourceType, IElementType targetType, IElementType linkType, IElementType subNodeType) {
		installEnvironment(sourceType, targetType, subNodeType);
		target = createSubNode(target, subNodeType, getAbsoluteCenter(target));

		assertTrue(CREATION + TEST_THE_EXECUTION, target instanceof ActionExecutionSpecificationEditPart);

		//		assertTrue(CREATION + INITIALIZATION_TEST, target.getChildren().size() == 1);
		waitForComplete();
		PopupUtil.addMenuListener(0);
		createLink(linkType, source, target, getAbsoluteCenter(source), getAbsoluteCenter(target).translate(0, 60));

		assertTrue(CREATION + TEST_THE_EXECUTION, source.getSourceConnections().size() == 1);
		assertTrue(CREATION + TEST_THE_EXECUTION, source.getSourceConnections().get(0) instanceof AbstractMessageEditPart);
		AbstractMessageEditPart p = (AbstractMessageEditPart)source.getSourceConnections().get(0);
		assertTrue(CREATION + TEST_THE_EXECUTION, ((View)p.getModel()).getType().equals(((IHintedType)linkType).getSemanticHint()));

		//		assertTrue(CREATION + TEST_THE_EXECUTION, target.getChildren().size() == 2); // LifelineNameEditPart 
		assertTrue(CREATION + TEST_THE_EXECUTION, target instanceof ActionExecutionSpecificationEditPart);

		getDiagramCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, source.getSourceConnections().size() == 0);
		assertTrue(CREATION + TEST_THE_UNDO, target.getTargetConnections().size() == 0);

		getDiagramCommandStack().redo();
		assertTrue(CREATION + TEST_THE_REDO, source.getSourceConnections().size() == 1);
		assertTrue(CREATION + TEST_THE_UNDO, target.getTargetConnections().size() == 1);
	}

	public void selectBehaviorExecution(IElementType sourceType, IElementType targetType, IElementType linkType, IElementType subNodeType) {
		installEnvironment(sourceType, targetType, subNodeType);
		target = createSubNode(target, subNodeType, getAbsoluteCenter(target));
		assertTrue(CREATION + TEST_THE_EXECUTION, target instanceof BehaviorExecutionSpecificationEditPart);

		//		assertTrue(CREATION + INITIALIZATION_TEST, target.getChildren().size() == 1);
		waitForComplete();
		PopupUtil.addMenuListener(1);
		createLink(linkType, source, target, getAbsoluteCenter(source), getAbsoluteCenter(target).translate(0, 60));

		assertTrue(CREATION + TEST_THE_EXECUTION, source.getSourceConnections().size() == 1);
		assertTrue(CREATION + TEST_THE_EXECUTION, source.getSourceConnections().get(0) instanceof AbstractMessageEditPart);
		AbstractMessageEditPart p = (AbstractMessageEditPart)source.getSourceConnections().get(0);
		assertTrue(CREATION + TEST_THE_EXECUTION, ((View)p.getModel()).getType().equals(((IHintedType)linkType).getSemanticHint()));

		//		assertTrue(CREATION + TEST_THE_EXECUTION, target.getChildren().size() == 2);

		getDiagramCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, source.getSourceConnections().size() == 0);
		assertTrue(CREATION + TEST_THE_UNDO, target.getTargetConnections().size() == 0);

		getDiagramCommandStack().redo();
		assertTrue(CREATION + TEST_THE_REDO, source.getSourceConnections().size() == 1);
		assertTrue(CREATION + TEST_THE_REDO, target.getTargetConnections().size() == 1);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		waitForComplete();
		PopupUtil.removeMenuListener();
	}

	@Test
	public void testMessageSync_4003_Action() {
		selectActionExecution(UMLElementTypes.Lifeline_3001, UMLElementTypes.Lifeline_3001, UMLElementTypes.Message_4003, UMLElementTypes.ActionExecutionSpecification_3006);
	}

	@Test
	public void testMessageSync_4003_Behavior() {
		selectBehaviorExecution(UMLElementTypes.Lifeline_3001, UMLElementTypes.Lifeline_3001, UMLElementTypes.Message_4003, UMLElementTypes.BehaviorExecutionSpecification_3003);
	}

	@Test
	public void testMessageReply_4005_Action() {
		selectActionExecution(UMLElementTypes.Lifeline_3001, UMLElementTypes.Lifeline_3001, UMLElementTypes.Message_4005, UMLElementTypes.ActionExecutionSpecification_3006);
	}

	@Test
	public void testMessageReply_4005_Behavior() {
		selectBehaviorExecution(UMLElementTypes.Lifeline_3001, UMLElementTypes.Lifeline_3001, UMLElementTypes.Message_4005, UMLElementTypes.BehaviorExecutionSpecification_3003);
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

		waitForComplete();
		source = createSubNode(source, subNodeType, getAbsoluteCenter(source));

		waitForComplete();
	}
}
