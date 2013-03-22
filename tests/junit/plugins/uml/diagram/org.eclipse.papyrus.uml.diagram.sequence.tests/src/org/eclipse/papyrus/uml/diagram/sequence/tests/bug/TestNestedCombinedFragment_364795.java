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
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.eclipse.uml2.uml.CombinedFragment;
import org.junit.Test;

/**
 * When a combined fragment is created inside another combined fragment, the
 * property "covered" of the nested combined fragment is empty. This property
 * should be initialized by the lifelines covered by this combined fragment and
 * kept up to date when the list of covered lifelines evolves.
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=364795
 */
public class TestNestedCombinedFragment_364795 extends TestTopNode {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	@Test
	public void testCover() {
		// create parent combined fragment
		createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(10, 80), new Dimension(300, 200));
		waitForComplete(); // wait for updating covered field
		CombinedFragmentEditPart parentCFP = (CombinedFragmentEditPart)getRootEditPart().getChildren().get(0);
		InteractionOperandEditPart oep = (InteractionOperandEditPart)((GraphicalEditPart)parentCFP.getChildren().get(0)).getChildren().get(0);

		// create child combined fragment
		createNode(UMLElementTypes.CombinedFragment_3004, oep, new Point(90, 90), new Dimension(200, 100));
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(120, 20), new Dimension(62, 240));
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(200, 20), new Dimension(62, 240));
		CombinedFragmentEditPart childCFP = (CombinedFragmentEditPart)oep.getChildren().get(0);
		final CombinedFragment parentCF = (CombinedFragment)parentCFP.resolveSemanticElement();
		final CombinedFragment childCF = (CombinedFragment)childCFP.resolveSemanticElement();

		waitForComplete(); // wait for updating covered field 
		assertTrue(CREATION + TEST_THE_EXECUTION, parentCF.getCovereds().size() == 2);
		assertTrue(CREATION + TEST_THE_EXECUTION, childCF.getCovereds().size() == 2);

		GraphicalEditPart lifelineEP = (GraphicalEditPart)getRootEditPart().getChildren().get(2);
		deleteNode(lifelineEP);
		waitForComplete(); // wait for updating covered field 
		assertTrue(CREATION + TEST_THE_EXECUTION, parentCF.getCovereds().size() == 1);
		assertTrue(CREATION + TEST_THE_EXECUTION, childCF.getCovereds().size() == 1);
	}

	protected void deleteNode(GraphicalEditPart graphicalEditPart) {
		Request deleteViewRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
		Command delCommand = graphicalEditPart.getCommand(deleteViewRequest);
		assertNotNull(DESTROY_DELETION + COMMAND_NULL, delCommand);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, delCommand != UnexecutableCommand.INSTANCE);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, delCommand.canExecute() == true);
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(delCommand));
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
