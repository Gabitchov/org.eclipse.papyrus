/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST)  - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.tests.canonical;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Element;

public abstract class TestNested extends org.eclipse.papyrus.diagram.tests.canonical.AbstractPapyrusTestCase {

	/** The top node. */
	protected GraphicalEditPart topNode;

	/** The Child node. */
	protected GraphicalEditPart childNode;

	/**
	 * Test to create a nested classifier node.
	 * 
	 * @param type
	 *        the type
	 * @param containerType
	 *        the container type
	 */
	public void testToCreateAChildLabel(IElementType type, int containerType) {
		ListCompartmentEditPart compartment = null;
		int index = 0;
		while(compartment == null && index < getChildEditPart().getChildren().size()) {
			if((getChildEditPart().getChildren().get(index)) instanceof ListCompartmentEditPart && (((View)((ListCompartmentEditPart)(getChildEditPart().getChildren().get(index))).getModel()).getType().equals("" + containerType))) {
				compartment = (ListCompartmentEditPart)(getChildEditPart().getChildren().get(index));
			}
			index++;
		}
		assertTrue("Container not found", compartment != null);
		//CREATION
		assertTrue(CREATION + INITIALIZATION_TEST, compartment.getChildren().size() == 0);
		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModelchild().getOwnedElements().size() == 0);
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getDiagramEditPart().getDiagramPreferencesHint());
		Command command = compartment.getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(CREATION + TEST_THE_EXECUTION, compartment.getChildren().size() == 1);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, compartment.getChildren().size() == 0);
		assertTrue(CREATION + TEST_THE_UNDO, ((Element)((View)getChildEditPart().getModel()).getElement()).getOwnedElements().size() == 0);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue("CREATION: " + TEST_THE_REDO, compartment.getChildren().size() == 1);
	}

	/**
	 * Test to create a node.
	 * 
	 * @param type
	 *        the type
	 * @param containerType
	 *        the container type
	 */
	public void testToCreateANode(IElementType type, int containerType) {
		ResizableCompartmentEditPart compartment = null;
		int index = 0;
		while(compartment == null && index < getTopEditPart().getChildren().size()) {
			if((getTopEditPart().getChildren().get(index)) instanceof ResizableCompartmentEditPart) {
				if((((View)((ResizableCompartmentEditPart)(getTopEditPart().getChildren().get(index))).getModel()).getType().equals("" + containerType))) {
					compartment = (ResizableCompartmentEditPart)(getTopEditPart().getChildren().get(index));
				}
			}
			index++;
		}
		assertTrue("Container not found", compartment != null);
		//CREATION
		assertTrue(CREATION + INITIALIZATION_TEST, compartment.getChildren().size() == 0);
		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 0);
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getDiagramEditPart().getDiagramPreferencesHint());
		Command command = compartment.getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(CREATION + TEST_THE_EXECUTION, compartment.getChildren().size() == 1);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, compartment.getChildren().size() == 0);
		assertTrue(CREATION + TEST_THE_UNDO, ((Element)((View)getTopEditPart().getModel()).getElement()).getOwnedElements().size() == 0);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue("CREATION: " + TEST_THE_REDO, compartment.getChildren().size() == 1);
		childNode = (GraphicalEditPart)compartment.getChildren().get(0);
	}

	/**
	 * Gets the root semantic modelchild.
	 * 
	 * @return the root semantic modelchild
	 */
	private Element getRootSemanticModelchild() {
		return (Element)((View)getChildEditPart().getModel()).getElement();
	}

	/**
	 * Test to create a top node.
	 * 
	 * @param type
	 *        the type
	 */
	public void testToCreateATopNode(IElementType type) {
		//CREATION
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 0);
		assertTrue(CREATION + INITIALIZATION_TEST, ((Element)((View)getDiagramEditPart().getModel()).getElement()).getOwnedElements().size() == 0);
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getDiagramEditPart().getDiagramPreferencesHint());
		Command command = getDiagramEditPart().getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(CREATION + TEST_THE_EXECUTION, getRootView().getChildren().size() == 1);
		topNode = (GraphicalEditPart)getDiagramEditPart().getChildren().get(0);
	}

	/**
	 * Gets the top edit part.
	 * 
	 * @return the top edit part
	 */
	public GraphicalEditPart getTopEditPart() {
		return topNode;
	}

	/**
	 * Gets the Child edit part.
	 * 
	 * @return the Child edit part
	 */
	public GraphicalEditPart getChildEditPart() {
		return childNode;
	}

	/**
	 * @see org.eclipse.papyrus.diagram.clazz.test.canonical.AbstractPapyrusTestCase#getRootSemanticModel()
	 * 
	 * @return
	 */
	@Override
	protected Element getRootSemanticModel() {
		return (Element)((View)getTopEditPart().getModel()).getElement();
	}

	/**
	 * Test to manage top node.
	 * 
	 * @param type
	 *        the type
	 * @param containerType
	 *        the container type
	 */
	public void testToManageTopNode(IElementType parentNodeType, IElementType topNodeType, IElementType type, int containerChilType, int containerType) {
		//Parent Node
		testToCreateATopNode(parentNodeType);
		//Top Node
		testToCreateANode(topNodeType, containerChilType);
		//Nested classifier
		testToCreateAChildLabel(type, containerType);
	}
}
