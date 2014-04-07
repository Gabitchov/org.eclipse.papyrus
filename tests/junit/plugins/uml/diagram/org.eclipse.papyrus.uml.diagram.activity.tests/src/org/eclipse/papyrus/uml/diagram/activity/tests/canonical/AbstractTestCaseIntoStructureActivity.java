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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.tests.canonical;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.TestChildNode;
import org.eclipse.papyrus.uml.diagram.activity.CreateActivityDiagramCommand;
import org.junit.Before;


/**
 * The Class AbstractPapyrusTestCase.
 */
public abstract class AbstractTestCaseIntoStructureActivity extends TestChildNode {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateActivityDiagramCommand();
	}

	@Before
	@Override
	public void setUp() throws Exception {
		projectCreation();
		assertEquals(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size(), 1);
		GraphicalEditPart containerEditPart = (GraphicalEditPart)getDiagramEditPart().getChildren().get(0);
		rootCompartment = null;
		int index = 0;
		while(rootCompartment == null && index < containerEditPart.getChildren().size()) {
			if((containerEditPart.getChildren().get(index)) instanceof ShapeCompartmentEditPart) {
				rootCompartment = (ShapeCompartmentEditPart)(containerEditPart.getChildren().get(index));
			}
			index++;
		}

		//create the structured Node
		CreateViewRequest requestcreation = createViewRequestShapeContainer();
		requestcreation.setSize(new Dimension(500, 500));
		Command command = rootCompartment.getCommand(requestcreation);
		assertNotNull(CONTAINER_CREATION + COMMAND_NULL, command);
		assertNotSame(CONTAINER_CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command, UnexecutableCommand.INSTANCE);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute());
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertEquals(CREATION + INITIALIZATION_TEST, rootCompartment.getChildren().size(), 1);
		containerEditPart = (GraphicalEditPart)rootCompartment.getChildren().get(0);
		rootCompartment = null;
		index = 0;
		while(rootCompartment == null && index < containerEditPart.getChildren().size()) {
			if((containerEditPart.getChildren().get(index)) instanceof ShapeCompartmentEditPart) {
				rootCompartment = (ShapeCompartmentEditPart)(containerEditPart.getChildren().get(index));
			}
			index++;
		}


	}
}
