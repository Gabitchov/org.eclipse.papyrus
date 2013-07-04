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
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.junit.Test;

/**
 * Currently, deleting a combined fragments deletes all its contents. Sometimes,
 * the user just wants to delete the combined fragment and keeping its content.
 * It would be useful to give the possibility to not delete the combined
 * fragment content. This would imply a refactoring of the model.
 * 
 */
public class TestCombinedFragmentDeletion_364804 extends TestTopNode {

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
	public void testCombinedFragmentDeleteAll() {
		deleteAll(UMLElementTypes.CombinedFragment_3004);
	}

	@Test
	public void testConsiderIgnoreFragmentDeleteAll() {
		deleteAll(UMLElementTypes.ConsiderIgnoreFragment_3007);
	}

	@Test
	public void testCombinedFragmentKeepContents() {
		keepContents(UMLElementTypes.CombinedFragment_3004);
	}

	@Test
	public void testConsiderIgnoreFragmentKeepContents() {
		keepContents(UMLElementTypes.ConsiderIgnoreFragment_3007);
	}

	protected void deleteAll(IElementType type) {
		createNode(type, getRootEditPart(), new Point(100, 100), new Dimension(200, 200));
		waitForComplete();

		// create child combined fragment
		CombinedFragmentEditPart parentCFP = (CombinedFragmentEditPart)getRootEditPart().getChildren().get(0);
		CombinedFragmentCombinedFragmentCompartmentEditPart cfp = (CombinedFragmentCombinedFragmentCompartmentEditPart)parentCFP.getChildren().get(0);
		InteractionOperandEditPart op = (InteractionOperandEditPart)cfp.getChildren().get(0);
		createNode(type, op, new Point(150, 150), new Dimension(100, 100));
		assertTrue(CREATION + TEST_THE_EXECUTION, getRootEditPart().getChildren().size() == 1);

		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(200, 200), new Dimension(60, 240));
		waitForComplete();
		assertTrue(CREATION + TEST_THE_EXECUTION, getRootEditPart().getChildren().size() == 2);
		LifelineEditPart lifelineEP = (LifelineEditPart)getRootEditPart().getChildren().get(1);

		waitForComplete();
		createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifelineEP, getAbsoluteCenter(lifelineEP).translate(0, 10), null);
		waitForComplete();
		assertTrue(CREATION + TEST_THE_EXECUTION, lifelineEP.getChildren().size() == 2);

		PopupUtil.addMenuListener(0);

		{ // destroy semantic
			Request deleteViewRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
			Command command = parentCFP.getCommand(deleteViewRequest);
			assertNotNull(DESTROY_DELETION + COMMAND_NULL, command);
			assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
			assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
			getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(command));

			assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, getRootEditPart().getChildren().size() == 1);
			assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, getRootEditPart().getChildren().get(0) instanceof LifelineEditPart);
			assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, lifelineEP.getChildren().size() == 1); // action execution is deleted

			getEMFCommandStack().undo();
			assertTrue(DESTROY_DELETION + TEST_THE_UNDO, getRootEditPart().getChildren().size() == 2);
			assertTrue(DESTROY_DELETION + TEST_THE_UNDO, lifelineEP.getChildren().size() == 2);

			getEMFCommandStack().redo();
			assertTrue(DESTROY_DELETION + TEST_THE_REDO, getRootEditPart().getChildren().size() == 1);
			assertTrue(DESTROY_DELETION + TEST_THE_REDO, lifelineEP.getChildren().size() == 1);
		}
		getEMFCommandStack().undo();

		{ // delete view
			Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
			Command command = parentCFP.getCommand(deleteViewRequest);

			assertNotNull(VIEW_DELETION + COMMAND_NULL, command);
			assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
			assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
			getDiagramCommandStack().execute(command);
			assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, getRootEditPart().getChildren().size() == 1);
			assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, getRootEditPart().getChildren().get(0) instanceof LifelineEditPart);

			getDiagramCommandStack().undo();
			assertTrue(VIEW_DELETION + TEST_THE_UNDO, getRootEditPart().getChildren().size() == 2);

			getDiagramCommandStack().redo();
			assertTrue(VIEW_DELETION + TEST_THE_REDO, getRootEditPart().getChildren().size() == 1);
		}
	}

	protected void keepContents(IElementType type) {
		createNode(type, getRootEditPart(), new Point(100, 100), new Dimension(200, 200));
		waitForComplete();

		// create child combined fragment
		CombinedFragmentEditPart parentCFP = (CombinedFragmentEditPart)getRootEditPart().getChildren().get(0);
		CombinedFragmentCombinedFragmentCompartmentEditPart cfp = (CombinedFragmentCombinedFragmentCompartmentEditPart)parentCFP.getChildren().get(0);
		InteractionOperandEditPart op = (InteractionOperandEditPart)cfp.getChildren().get(0);
		createNode(type, op, new Point(150, 150), new Dimension(100, 100));
		assertTrue(CREATION + TEST_THE_EXECUTION, getRootEditPart().getChildren().size() == 1);

		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(200, 200), new Dimension(60, 240));
		waitForComplete();
		assertTrue(CREATION + TEST_THE_EXECUTION, getRootEditPart().getChildren().size() == 2);
		LifelineEditPart lifelineEP = (LifelineEditPart)getRootEditPart().getChildren().get(1);

		waitForComplete();
		createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifelineEP, getAbsoluteCenter(lifelineEP).translate(0, 10), null);
		waitForComplete();
		assertTrue(CREATION + TEST_THE_EXECUTION, lifelineEP.getChildren().size() == 2);

		PopupUtil.addMenuListener(1);

		{ // destroy semantic
			Request deleteViewRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
			Command command = parentCFP.getCommand(deleteViewRequest);
			assertNotNull(DESTROY_DELETION + COMMAND_NULL, command);
			assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
			assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
			getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(command));

			assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, getRootEditPart().getChildren().size() == 2);
			assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, getRootEditPart().getChildren().get(1) instanceof CombinedFragmentEditPart);
			assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, lifelineEP.getChildren().size() == 2);

			getEMFCommandStack().undo();
			assertTrue(DESTROY_DELETION + TEST_THE_UNDO, getRootEditPart().getChildren().size() == 2);
			assertTrue(DESTROY_DELETION + TEST_THE_UNDO, lifelineEP.getChildren().size() == 2);

			getEMFCommandStack().redo();
			assertTrue(DESTROY_DELETION + TEST_THE_REDO, getRootEditPart().getChildren().size() == 2);
			assertTrue(DESTROY_DELETION + TEST_THE_REDO, lifelineEP.getChildren().size() == 2);
		}
		getEMFCommandStack().undo();

		{ // delete view
			Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
			Command command = parentCFP.getCommand(deleteViewRequest);

			assertNotNull(VIEW_DELETION + COMMAND_NULL, command);
			assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
			assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

			getDiagramCommandStack().execute(command);
			assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, getRootEditPart().getChildren().size() == 2);

			getDiagramCommandStack().undo();
			assertTrue(VIEW_DELETION + TEST_THE_UNDO, getRootEditPart().getChildren().size() == 2);

			getDiagramCommandStack().redo();
			assertTrue(VIEW_DELETION + TEST_THE_REDO, getRootEditPart().getChildren().size() == 2);
		}
	}

	@Override
	protected void tearDown() throws Exception {
		page.closeAllEditors(false);
		papyrusEditor = null;

		waitForComplete();
		PopupUtil.removeMenuListener();
	}


	public void createNode(IElementType type, EditPart parentPart, Point location, Dimension size) {
		// CREATION
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
