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
package org.eclipse.papyrus.diagram.clazz.test.canonical;

import java.util.ArrayList;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.TestChildLabel;
import org.eclipse.papyrus.uml.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Element;
import org.junit.Test;

/**
 * test in order to verify if the drop respect the order of the selection
 * Create an enumeration, create subenumerationliterals, select them, drop into the diagram
 * the order of enumeration list has to be the same that as the list in the request drop.
 *
 */

public  class TestDropfunction extends TestChildLabel {
	
	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return  new CreateClassDiagramCommand();
	}
	public static int MAX=20;
	@Test
	public void testDropWithOrder(){
		testToCreateATopNode(UMLElementTypes.Enumeration_2006);
		testToCreateSetOfNode(UMLElementTypes.EnumerationLiteral_3017, EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID);
		testSetOfDrop(UMLElementTypes.EnumerationLiteral_3017, EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID);
	}

	protected void testToCreateSetOfNode(IElementType type,int containerType) {
		ListCompartmentEditPart compartment=null;
		int index=0;
		while (compartment==null && index <getTopEditPart().getChildren().size()){
			if((getTopEditPart().getChildren().get(index)) instanceof ListCompartmentEditPart&& (((View)((ListCompartmentEditPart)(getTopEditPart().getChildren().get(index))).getModel()).getType().equals(""+containerType))){
				compartment= (ListCompartmentEditPart)(getTopEditPart().getChildren().get(index));
			}
			index++;
		}
		assertTrue("Container not found", compartment!=null);
		//CREATION
		assertTrue(CREATION +INITIALIZATION_TEST,compartment.getChildren().size()==0);
		assertTrue(CREATION +INITIALIZATION_TEST,getRootSemanticModel().getOwnedElements().size()==0);


		for(int i=0; i<MAX;i++){
			CreateViewRequest requestcreation=CreateViewRequestFactory.getCreateShapeRequest(type, getDiagramEditPart().getDiagramPreferencesHint());
			Command command=compartment.getCommand(requestcreation);
			assertNotNull(CREATION+COMMAND_NULL,command);
			assertTrue(CREATION+TEST_IF_THE_COMMAND_IS_CREATED,command!=UnexecutableCommand.INSTANCE);
			assertTrue("CREATION: "+TEST_IF_THE_COMMAND_CAN_BE_EXECUTED,command.canExecute()==true);
			//creation of label
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
			assertTrue(CREATION+TEST_THE_EXECUTION,compartment.getChildren().size()==1);
			//deletion view
			Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
			command = ((GraphicalEditPart)compartment.getChildren().get(0)).getCommand(deleteViewRequest);
			assertNotNull(VIEW_DELETION +COMMAND_NULL,command);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		}

	}
	/**
	 * Test drop.
	 * 
	 * @param type the type
	 * @param containerType the container type
	 */
	protected void testSetOfDrop(IElementType type,int containerType) {
		ListCompartmentEditPart compartment=null;
		int index=0;
		while (compartment==null && index <getTopEditPart().getChildren().size()){
			if((getTopEditPart().getChildren().get(index)) instanceof ListCompartmentEditPart&& (((View)((ListCompartmentEditPart)(getTopEditPart().getChildren().get(index))).getModel()).getType().equals(""+containerType))){
				compartment= (ListCompartmentEditPart)(getTopEditPart().getChildren().get(index));
			}
			index++;
		}
		assertTrue("Container not found", compartment!=null);
		//DROP
		assertTrue(DROP +INITIALIZATION_TEST,compartment.getChildren().size()==0);
		assertTrue(DROP +INITIALIZATION_TEST,((Element)((View)getTopEditPart().getModel()).getElement()).getOwnedElements().size()==MAX);


		DropObjectsRequest dropObjectsRequest= new DropObjectsRequest();
		ArrayList<Element> list = new ArrayList<Element>();
		for(int i=0; i<MAX;i++){
			list.add(getRootSemanticModel().getOwnedElements().get(i));
		}
		dropObjectsRequest.setObjects(list);
		dropObjectsRequest.setLocation(new Point(20,20));
		Command command= compartment.getCommand(dropObjectsRequest);
		assertNotNull(DROP+COMMAND_NULL,command);
		assertTrue(DROP +TEST_IF_THE_COMMAND_IS_CREATED,command!=UnexecutableCommand.INSTANCE);
		assertTrue(DROP+TEST_IF_THE_COMMAND_CAN_BE_EXECUTED,command.canExecute()==true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(DROP +TEST_THE_EXECUTION,compartment.getChildren().size()==MAX);
		assertTrue(DROP +TEST_THE_EXECUTION,((Element)((View)getTopEditPart().getModel()).getElement()).getOwnedElements().size()==MAX);

		for(int i=0; i<MAX;i++){
			assertEquals(getRootSemanticModel().getOwnedElements().get(i),((GraphicalEditPart) compartment.getChildren().get(i)).resolveSemanticElement());
		}

	}



}
