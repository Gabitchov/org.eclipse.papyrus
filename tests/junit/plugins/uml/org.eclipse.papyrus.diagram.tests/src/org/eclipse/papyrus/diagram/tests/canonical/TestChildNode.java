/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
package org.eclipse.papyrus.diagram.tests.canonical;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.junit.Before;

/**
 * The Class TestChildNode.
 * Semantic tests shall be executed apart from the graphical test has one view may be related to a different number of UML elements
 * in different diagram
 */
public abstract class TestChildNode extends AbstractTestNode {

	/** The root compartment. */
	protected ShapeCompartmentEditPart rootCompartment = null;

	/**
	 * @see org.eclipse.papyrus.diagram.clazz.test.canonical.AbstractPapyrusTestCase#setUp()
	 * 
	 * @throws Exception
	 */
	@Before
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		CreateViewRequest requestcreation = createViewRequestShapeContainer();
		if(requestcreation !=null) {
			requestcreation.setSize(new Dimension(500, 500));
			Command command = getDiagramEditPart().getCommand(requestcreation);
			assertNotNull(CONTAINER_CREATION + COMMAND_NULL, command);
			assertNotSame(CONTAINER_CREATION + TEST_IF_THE_COMMAND_IS_CREATED, UnexecutableCommand.INSTANCE, command);
			assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute());
			executeOnUIThread(command);	
		}
		assertEquals(CREATION + INITIALIZATION_TEST, 1, getDiagramEditPart().getChildren().size());
		
		GraphicalEditPart containerEditPart = (GraphicalEditPart)getDiagramEditPart().getChildren().get(0);
		rootCompartment = null;
		int index = 0;
		while(rootCompartment == null && index < containerEditPart.getChildren().size()) {
			if((containerEditPart.getChildren().get(index)) instanceof ShapeCompartmentEditPart) {
				rootCompartment = (ShapeCompartmentEditPart)(containerEditPart.getChildren().get(index));
			}
			index++;
		}
		
		assertNotNull("There should be at least one container for the node tests", rootCompartment);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IGraphicalEditPart getContainerEditPart() {
		return rootCompartment;
	}
	
	/**
	 * @see org.eclipse.papyrus.diagram.clazz.test.canonical.AbstractPapyrusTestCase#getRootView()
	 * 
	 * @return
	 */

	@Override
	protected View getRootView() {
		return (View)rootCompartment.getModel();
	}
}
