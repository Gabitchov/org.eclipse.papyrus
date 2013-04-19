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

import java.util.ArrayList;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Element;
import org.junit.Before;



// TODO: Auto-generated Javadoc
/**
 * The Class TestChildNode.
 */
public abstract class TestChildNode extends org.eclipse.papyrus.diagram.tests.canonical.AbstractPapyrusTestCase {

	// Semantic tests shall be executed apart from the graphical test has one view may be related to a different number of UML elements
	// in different diagram


	/** The root compartment. */
	protected ShapeCompartmentEditPart rootCompartment = null;

	/**
	 * Test view deletion.
	 * 
	 * @param type
	 *        the type
	 */
	public void testViewDeletion(IElementType type) {
		//DELETION OF THE VIEW
		assertTrue(VIEW_DELETION + INITIALIZATION_TEST, getRootCompartment().getChildren().size() == 1);
		//assertTrue(VIEW_DELETION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == numberOfRelatedSemanticElement);

		Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
		Command command = ((GraphicalEditPart)getRootCompartment().getChildren().get(0)).getCommand(deleteViewRequest);
		assertNotNull(VIEW_DELETION + COMMAND_NULL, command);
		assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		executeOnUIThread(command);
		assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, getRootCompartment().getChildren().size() == 0);
		//assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == numberOfRelatedSemanticElement);
		undoOnUIThread();
		assertTrue(VIEW_DELETION + TEST_THE_UNDO, getRootCompartment().getChildren().size() == 1);
		//assertTrue(VIEW_DELETION + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == numberOfRelatedSemanticElement);
		redoOnUIThread();
		assertTrue(VIEW_DELETION + TEST_THE_REDO, getRootCompartment().getChildren().size() == 0);
		//assertTrue(VIEW_DELETION + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == numberOfRelatedSemanticElement);

	}

	/**
	 * Gets the root compartment.
	 * 
	 * @return the root compartment
	 */
	protected ShapeCompartmentEditPart getRootCompartment() {
		assertNotNull(rootCompartment);
		return rootCompartment;
	}

	/**
	 * Test destroy.
	 * 
	 * @param type
	 *        the type
	 */
	public void testDestroy(IElementType type) {
		//DESTROY SEMANTIC+ VIEW
		assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, getRootCompartment().getChildren().size() == 1);
		//assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 1);

		Request deleteViewRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
		Command command = ((GraphicalEditPart)getRootCompartment().getChildren().get(0)).getCommand(deleteViewRequest);
		assertNotNull(DESTROY_DELETION + COMMAND_NULL, command);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		executeOnUIThread(command);
		assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, getRootCompartment().getChildren().size() == 0);
		//assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == 0);
		undoOnUIThread();
		assertTrue(DESTROY_DELETION + TEST_THE_UNDO, getRootCompartment().getChildren().size() == 1);
		//assertTrue(DESTROY_DELETION + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == 1);
		redoOnUIThread();
		assertTrue(DESTROY_DELETION + TEST_THE_REDO, getRootCompartment().getChildren().size() == 0);
		//assertTrue(DESTROY_DELETION + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == 0);
	}


	/**
	 * Test drop.
	 * 
	 * @param type
	 *        the type
	 */
	public void testDrop(IElementType type, EClass eClass) {
		//DROP
		assertTrue(DROP + INITIALIZATION_TEST, getRootCompartment().getChildren().size() == 0);
		//assertTrue(DROP + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 1);


		DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
		ArrayList<Element> list = new ArrayList<Element>();
		for (Element element : getRootSemanticModel().getOwnedElements()) {
			if( element != null && element.eClass().equals(eClass)){
				list.add(element);
			}
		}
		
		dropObjectsRequest.setObjects(list);
		dropObjectsRequest.setLocation(new Point(40, 40));
		Command command = getRootCompartment().getCommand(dropObjectsRequest);
		assertNotNull(DROP + COMMAND_NULL, command);
		assertTrue(DROP + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(DROP + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		executeOnUIThread(command);
		assertTrue(DROP + TEST_THE_EXECUTION, getRootCompartment().getChildren().size() != 0);
		assertTrue(DROP + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() != 0);
		undoOnUIThread();
		assertTrue(DROP + TEST_THE_UNDO, getRootCompartment().getChildren().size() == 0);
		assertTrue(DROP + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() != 0);
		redoOnUIThread();
		assertTrue(DROP + TEST_THE_REDO, getRootCompartment().getChildren().size() != 0);
		assertTrue(DROP + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() != 0);
	}


	/**
	 * Test change container.
	 * 
	 * @param type
	 *        the type
	 * @param containerType
	 *        the container type
	 */
	public void testChangeContainer(IElementType type, IElementType containerType) {
		//CHANGE CONTAINER
		assertTrue(CHANGE_CONTAINER + INITIALIZATION_TEST, getRootCompartment().getChildren().size() == 1);
		assertTrue(CHANGE_CONTAINER + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 1);


		Request requestcreation = CreateViewRequestFactory.getCreateShapeRequest(containerType, getRootCompartment().getDiagramPreferencesHint());
		Command command = getRootCompartment().getCommand(requestcreation);
		assertNotNull(CONTAINER_CREATION + COMMAND_NULL, command);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		executeOnUIThread(command);
		assertTrue(CONTAINER_CREATION + TEST_THE_EXECUTION, getRootView().getChildren().size() == 2);
		GraphicalEditPart containerEditPart = (GraphicalEditPart)getRootCompartment().getChildren().get(1);
		ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(RequestConstants.REQ_ADD);
		changeBoundsRequest.setEditParts((EditPart)getRootCompartment().getChildren().get(0));
		changeBoundsRequest.setLocation(new Point(30, 30));
		ShapeCompartmentEditPart compartment = null;
		int index = 0;
		while(compartment == null && index < containerEditPart.getChildren().size()) {
			if((containerEditPart.getChildren().get(index)) instanceof ShapeCompartmentEditPart) {
				compartment = (ShapeCompartmentEditPart)(containerEditPart.getChildren().get(index));
			}
			index++;
		}
		assertTrue("Container not found", compartment != null);


		command = compartment.getCommand(changeBoundsRequest);
		assertNotNull(CHANGE_CONTAINER, command);
		assertTrue(CHANGE_CONTAINER + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CHANGE_CONTAINER + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		executeOnUIThread(command);
		assertTrue(CHANGE_CONTAINER + TEST_THE_EXECUTION, getRootView().getChildren().size() == 1);
		assertTrue(CHANGE_CONTAINER + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == 1);
		assertTrue(CHANGE_CONTAINER + TEST_THE_EXECUTION, compartment.getChildren().size() == 1);
		undoOnUIThread();
		assertTrue(CHANGE_CONTAINER + TEST_THE_UNDO, getRootView().getChildren().size() == 2);
		assertTrue(CHANGE_CONTAINER + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == 2);
		assertTrue(CHANGE_CONTAINER + TEST_THE_EXECUTION, compartment.getChildren().size() == 0);
		redoOnUIThread();
		assertTrue(CHANGE_CONTAINER + TEST_THE_REDO, getRootView().getChildren().size() == 1);
		assertTrue(CHANGE_CONTAINER + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == 1);
		assertTrue(CHANGE_CONTAINER + TEST_THE_EXECUTION, compartment.getChildren().size() == 1);

	}

	/**
	 * Test to create a node.
	 * 
	 * @param type
	 *        the type
	 */
	public void testToCreateANode(IElementType type) {

		//CREATION
		assertTrue(CREATION + INITIALIZATION_TEST, getRootCompartment().getChildren().size() == 0);
		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 0);

		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getRootCompartment().getDiagramPreferencesHint());
		Command command = getRootCompartment().getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		executeOnUIThread(command);
		assertTrue(CREATION + TEST_THE_EXECUTION, getRootView().getChildren().size() == 1);
		undoOnUIThread();
		assertTrue(CREATION + TEST_THE_UNDO, getRootView().getChildren().size() == 0);
		assertTrue(CREATION + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == 0);
		redoOnUIThread();
		assertTrue("CREATION: " + TEST_THE_REDO, getRootCompartment().getChildren().size() == 1);

	}

	protected abstract CreateViewRequest createViewRequestShapeContainer();

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
		requestcreation.setSize(new Dimension(500, 500));
		Command command = getDiagramEditPart().getCommand(requestcreation);
		assertNotNull(CONTAINER_CREATION + COMMAND_NULL, command);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		executeOnUIThread(command);
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 1);
		GraphicalEditPart containerEditPart = (GraphicalEditPart)getDiagramEditPart().getChildren().get(0);
		rootCompartment = null;
		int index = 0;
		while(rootCompartment == null && index < containerEditPart.getChildren().size()) {
			if((containerEditPart.getChildren().get(index)) instanceof ShapeCompartmentEditPart) {
				rootCompartment = (ShapeCompartmentEditPart)(containerEditPart.getChildren().get(index));
			}
			index++;
		}

	}

	/**
	 * @see org.eclipse.papyrus.diagram.clazz.test.canonical.AbstractPapyrusTestCase#getRootView()
	 * 
	 * @return
	 */

	@Override
	protected View getRootView() {
		return (View)getRootCompartment().getModel();
	}

	/**
	 * Test to manage child node.
	 * 
	 * @param type
	 *        the type
	 * @param containerType
	 *        the container type
	 */
	public void testToManageChildNode(IElementType type, EClass eClass, IElementType containerType, boolean containerMove) {
		testToCreateANode(type);
		// the node is still present
		testDestroy(type);
		// the node has been destroyed, the UML element also
		undoOnUIThread();
		// the node and the UML element are present
		testViewDeletion(type);
		// The node has been deleted, the uml element is still present
		testDrop(type, eClass);
		// the node and element are present
		if(containerMove) {
			testChangeContainer(type, containerType);
		}
	}

}
