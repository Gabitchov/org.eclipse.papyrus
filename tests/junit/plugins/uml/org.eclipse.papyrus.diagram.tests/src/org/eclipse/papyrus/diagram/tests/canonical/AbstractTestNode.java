/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.tests.canonical;

import java.util.ArrayList;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.junit.Before;


/**
 *  Abstract class to test nodes
 */
public abstract class AbstractTestNode extends org.eclipse.papyrus.diagram.tests.canonical.AbstractPapyrusTestCase{
	
	/** <code>true</code> if semantic tests should be run on graphical manipulation */
	private boolean testSemantic;

	/** command computed on the ui thread */
	private Command command;

	/**
	 * @see org.eclipse.papyrus.diagram.clazz.test.canonical.AbstractPapyrusTestCase#setUp()
	 * 
	 * @throws Exception
	 */
	@Before
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		testSemantic = isSemanticTest();
	}

	/**
	 * Returns <code>true</code> if semantic tests should be also performed
	 * 
	 * @return <code>true</code> if semantic tests should be also performed
	 */
	protected boolean isSemanticTest() {
		return false;
	}

	/**
	 * @see org.eclipse.papyrus.diagram.clazz.test.canonical.AbstractPapyrusTestCase#getRootView()
	 * 
	 * @return
	 */

	protected abstract View getRootView();

	/**
	 * Returns the container edit part 
	 */
	protected abstract IGraphicalEditPart getContainerEditPart();
	
	/**
	 * Test to manage child node.
	 * 
	 * @param type
	 *        the type
	 * @param containerType
	 *        the container type
	 */
	public void testToManageNode(IElementType type, EClass eClass, IElementType containerType, boolean containerMove) {
		// create a node
		testToCreateANode(type);
		// creates a second one
		testToCreateANode(type, 1, 1, 1, 1);
		// destroy the first element
		testDestroy(type, 2, 2, 1, 1);
		// destroy the second one 
		testDestroy(type, 1, 1, 1, 1);
		// the node has been destroyed, the UML element also. restore one element
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
	
	/**
	 * Test to manage child node.
	 * 
	 * @param type
	 *        the type
	 * @param containerType
	 *        the container type
	 */
	public void testToManageNode(IElementType type, EClass eClass, IElementType containerType, boolean containerMove, EReference containmentFeature) {
		// create a node
		testToCreateANode(type);
		// creates a second one
		testToCreateANode(type, 1, 1, 1, 1);
		// destroy the first element
		testDestroy(type, 2, 2, 1, 1);
		// destroy the second one 
		testDestroy(type, 1, 1, 1, 1);
		// the node has been destroyed, the UML element also. restore one element
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
	
	
	/**
	 * Test to manage child node.
	 * 
	 * @param type
	 *        the type
	 * @param containerType
	 *        the container type
	 *        @deprecated, @use {@link AbstractTestNode#testToManageNode(IElementType, EClass, IElementType, boolean)}
	 */
	@Deprecated
	public void testToManageChildNode(IElementType type, EClass eClass, IElementType containerType, boolean containerMove) {
		testToManageNode(type, eClass, containerType, containerMove);
	}

	/**
	 * Test destroy.
	 * 
	 * @param type
	 *        the type
	 */
	public void testDestroy(IElementType type) {
		testDestroy(type, 1, 1, 1, 1);
	}

	/**
	 * Test destroy.
	 * 
	 * @param type
	 *        the type
	 */
	public void testDestroy(IElementType type, int expectedGraphicalChildren, int expectedSemanticChildren, int removedGraphicalChildren, int removedSemanticChildren) {
		// DESTROY SEMANTIC + VIEW
		assertEquals(DESTROY_DELETION + INITIALIZATION_TEST, expectedGraphicalChildren, getContainerEditPart().getChildren().size());
		if(testSemantic) {
			assertEquals(DESTROY_DELETION + INITIALIZATION_TEST, expectedSemanticChildren, getRootSemanticModel().getOwnedElements().size());
		}

		Request deleteViewRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
		Command command = ((GraphicalEditPart)getContainerEditPart().getChildren().get(0)).getCommand(deleteViewRequest);
		assertNotNull(DESTROY_DELETION + COMMAND_NULL, command);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute());
		executeOnUIThread(command);
		assertEquals(DESTROY_DELETION + TEST_THE_EXECUTION, expectedGraphicalChildren - removedGraphicalChildren, getContainerEditPart().getChildren().size());
		if(testSemantic) {
			assertEquals(DESTROY_DELETION + INITIALIZATION_TEST, expectedSemanticChildren - removedSemanticChildren, getRootSemanticModel().getOwnedElements().size());
		}

		undoOnUIThread();
		assertEquals(DESTROY_DELETION + TEST_THE_UNDO, expectedGraphicalChildren, getContainerEditPart().getChildren().size());
		if(testSemantic) {
			assertEquals(DESTROY_DELETION + TEST_THE_UNDO, expectedSemanticChildren, getRootSemanticModel().getOwnedElements().size());
		}

		redoOnUIThread();
		assertEquals(DESTROY_DELETION + TEST_THE_REDO, expectedGraphicalChildren - removedGraphicalChildren, getContainerEditPart().getChildren().size());
		if(testSemantic) {
			assertEquals(DESTROY_DELETION + TEST_THE_UNDO, expectedSemanticChildren - removedSemanticChildren, getRootSemanticModel().getOwnedElements().size());
		}
	}

	/**
	 * Test drop.
	 * 
	 * @param type
	 *        the type
	 */
	public void testDrop(IElementType type, EClass eClass) {
		//DROP
		assertEquals(DROP + INITIALIZATION_TEST, 0, getContainerEditPart().getChildren().size());
		if(testSemantic) {
			assertEquals(DROP + INITIALIZATION_TEST, 1, getRootSemanticModel().getOwnedElements().size());
		}

		DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
		ArrayList<Element> list = new ArrayList<Element>();
		for(Element element : getRootSemanticModel().getOwnedElements()) {
			if(element != null && element.eClass().equals(eClass)) {
				list.add(element);
			}
		}
		dropObjectsRequest.setObjects(list);
		dropObjectsRequest.setLocation(new Point(40, 40));
		Command command = getContainerEditPart().getCommand(dropObjectsRequest);
		assertNotNull(DROP + COMMAND_NULL, command);
		assertTrue(DROP + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(DROP + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute());

		// execute the drop
		executeOnUIThread(command);
		assertTrue(DROP + TEST_THE_EXECUTION, getContainerEditPart().getChildren().size() != 0);
		assertTrue(DROP + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() != 0);

		// undo the drop
		undoOnUIThread();
		assertEquals(DROP + TEST_THE_UNDO, 0, getContainerEditPart().getChildren().size());
		assertTrue(DROP + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() != 0);

		// redo the drop
		redoOnUIThread();
		assertTrue(DROP + TEST_THE_REDO, getContainerEditPart().getChildren().size() != 0);
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
		assertEquals(CHANGE_CONTAINER + INITIALIZATION_TEST, 1, getContainerEditPart().getChildren().size());
		assertTrue(CHANGE_CONTAINER + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 1);

		Request requestcreation = CreateViewRequestFactory.getCreateShapeRequest(containerType, getContainerEditPart().getDiagramPreferencesHint());
		Command command = getContainerEditPart().getCommand(requestcreation);
		assertNotNull(CONTAINER_CREATION + COMMAND_NULL, command);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute());
		executeOnUIThread(command);
		assertTrue(CONTAINER_CREATION + TEST_THE_EXECUTION, getRootView().getChildren().size() == 2);
		GraphicalEditPart containerEditPart = (GraphicalEditPart)getContainerEditPart().getChildren().get(1);
		ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(RequestConstants.REQ_ADD);
		changeBoundsRequest.setEditParts((EditPart)getContainerEditPart().getChildren().get(0));
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
		assertTrue(CHANGE_CONTAINER + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute());

		// execute change container
		executeOnUIThread(command);
		assertEquals(CHANGE_CONTAINER + TEST_THE_EXECUTION, 1, getRootView().getChildren().size());
		assertEquals(CHANGE_CONTAINER + TEST_THE_EXECUTION, 1, getRootSemanticModel().getOwnedElements().size());
		assertEquals(CHANGE_CONTAINER + TEST_THE_EXECUTION, 1, compartment.getChildren().size());

		// undo change container
		undoOnUIThread();
		assertEquals(CHANGE_CONTAINER + TEST_THE_UNDO, 2, getRootView().getChildren().size());
		assertEquals(CHANGE_CONTAINER + TEST_THE_UNDO, 2, getRootSemanticModel().getOwnedElements().size());
		assertEquals(CHANGE_CONTAINER + TEST_THE_EXECUTION, 0, compartment.getChildren().size());

		// redo change container
		redoOnUIThread();
		assertEquals(CHANGE_CONTAINER + TEST_THE_REDO, 1, getRootView().getChildren().size());
		assertEquals(CHANGE_CONTAINER + TEST_THE_REDO, 1, getRootSemanticModel().getOwnedElements().size());
		assertEquals(CHANGE_CONTAINER + TEST_THE_EXECUTION, 1, compartment.getChildren().size());

	}

	/**
	 * Test to create a node.
	 * 
	 * @param type
	 *        the type
	 */
	public void testToCreateANode(IElementType type, int expectedGraphicalChildren, int expectedSemanticChildren, int addedGraphicalChildren, int addedSemanticChildren) {
		command = null;
		//CREATION
		assertEquals(CREATION + INITIALIZATION_TEST, expectedGraphicalChildren, getContainerEditPart().getChildren().size());
		assertEquals(CREATION + INITIALIZATION_TEST, expectedSemanticChildren, getRootSemanticModel().getOwnedElements().size());

		final CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getContainerEditPart().getDiagramPreferencesHint());
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				command = getContainerEditPart().getCommand(requestcreation); 
			}
		});
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute());

		// execute the creation
		executeOnUIThread(command);
		assertEquals(CREATION + TEST_THE_EXECUTION, expectedGraphicalChildren + addedGraphicalChildren, getRootView().getChildren().size());
		if(testSemantic) {
			assertEquals(CREATION + TEST_THE_EXECUTION, expectedSemanticChildren + addedSemanticChildren, getRootSemanticModel().getOwnedElements().size());
		}

		// undo the creation
		undoOnUIThread();
		assertEquals(CREATION + TEST_THE_UNDO, expectedGraphicalChildren, getRootView().getChildren().size());
		if(testSemantic) {
			assertEquals(CREATION + TEST_THE_UNDO, expectedSemanticChildren, getRootSemanticModel().getOwnedElements().size());
		}

		// redo the creation test
		redoOnUIThread();
		assertEquals(CREATION + TEST_THE_REDO, expectedGraphicalChildren + addedGraphicalChildren, getRootView().getChildren().size());
		if(testSemantic) {
			assertEquals(CREATION + TEST_THE_REDO, expectedSemanticChildren + addedSemanticChildren, getRootSemanticModel().getOwnedElements().size());
		}

	}

	/**
	 * Test to create a node.
	 * 
	 * @param type
	 *        the type
	 */
	public void testToCreateANode(IElementType type) {
		testToCreateANode(type, 0, 0, 1, 1);
	}

	/**
	 * Test view deletion.
	 * 
	 * @param type
	 *        the type
	 */
	public void testViewDeletion(IElementType type) {
		//DELETION OF THE VIEW
		assertEquals(VIEW_DELETION + INITIALIZATION_TEST, 1, getContainerEditPart().getChildren().size());
		if(testSemantic) {

		}

		Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
		Command command = ((IGraphicalEditPart)getContainerEditPart().getChildren().get(0)).getCommand(deleteViewRequest);
		assertNotNull(VIEW_DELETION + COMMAND_NULL, command);
		assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute());

		// execute hide the view
		executeOnUIThread(command);
		assertEquals(VIEW_DELETION + TEST_THE_EXECUTION, 0, getContainerEditPart().getChildren().size());
		if(testSemantic) {
			//assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == numberOfRelatedSemanticElement);
		}

		// undo hide the view
		undoOnUIThread();
		assertEquals(VIEW_DELETION + TEST_THE_UNDO, 1, getContainerEditPart().getChildren().size());
		if(testSemantic) {
			//assertTrue(VIEW_DELETION + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == numberOfRelatedSemanticElement);
		}

		// redo hide the view
		redoOnUIThread();
		assertEquals(VIEW_DELETION + TEST_THE_REDO, 0, getContainerEditPart().getChildren().size());
		if(testSemantic) {
			//assertTrue(VIEW_DELETION + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == numberOfRelatedSemanticElement);	
		}

	}

	protected abstract CreateViewRequest createViewRequestShapeContainer();
}
