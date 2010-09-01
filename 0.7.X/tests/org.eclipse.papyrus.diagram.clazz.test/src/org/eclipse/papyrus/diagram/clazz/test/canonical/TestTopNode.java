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

import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.diagram.common.command.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.uml2.uml.Element;



// TODO: Auto-generated Javadoc
/**
 * The Class TestTopNode.
 */
public class TestTopNode extends AbstractPapyrusTestCase {
	
	
	/** The Constant CREATION. */
	protected static final String CREATION = "CREATION:";
	
	/** The Constant CONTAINER_CREATION. */
	protected static final String CONTAINER_CREATION = "CONTAINER CREATION: ";
	
	/** The Constant DROP. */
	protected static final String DROP = "DROP: ";
	
	/** The Constant DESTROY_DELETION. */
	protected static final String DESTROY_DELETION = "DESTROY DELETION: ";
	
	/** The Constant COMMAND_NULL. */
	protected static final String COMMAND_NULL = " command null";
	
	/** The Constant VIEW_DELETION. */
	protected static final String VIEW_DELETION = "VIEW DELETION: ";
	
	/** The Constant TEST_THE_REDO. */
	protected static final String TEST_THE_REDO = "test the redo";
	
	/** The Constant TEST_THE_UNDO. */
	protected static final String TEST_THE_UNDO = "test the undo";
	
	/** The Constant TEST_THE_EXECUTION. */
	protected static final String TEST_THE_EXECUTION = "test the execution";
	
	/** The Constant TEST_IF_THE_COMMAND_CAN_BE_EXECUTED. */
	protected static final String TEST_IF_THE_COMMAND_CAN_BE_EXECUTED = "test if the command can be executed";
	
	/** The Constant TEST_IF_THE_COMMAND_IS_CREATED. */
	protected static final String TEST_IF_THE_COMMAND_IS_CREATED = "test if the command is created";

	/** The Constant INITIALIZATION_TEST. */
	protected static final String INITIALIZATION_TEST = "Intitial State";
	
	/** The Constant CHANGE_CONTAINER. */
	protected static final String CHANGE_CONTAINER = "CHANGE CONTAINER";

	/**
	 * Test view deletion.
	 * 
	 * @param type the type
	 */
	public void testViewDeletion(IElementType type) {
		//DELETION OF THE VIEW
		assertTrue(VIEW_DELETION +INITIALIZATION_TEST,getDiagramEditPart().getChildren().size()==1);
		assertTrue(VIEW_DELETION +INITIALIZATION_TEST,getRootSemanticModel().getOwnedElements().size()==1);
		
		Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
		Command command = ((GraphicalEditPart)getDiagramEditPart().getChildren().get(0)).getCommand(deleteViewRequest);
		assertNotNull(VIEW_DELETION +COMMAND_NULL,command);
		assertTrue(VIEW_DELETION +TEST_IF_THE_COMMAND_IS_CREATED,command!=UnexecutableCommand.INSTANCE);
		assertTrue(VIEW_DELETION +TEST_IF_THE_COMMAND_CAN_BE_EXECUTED,command.canExecute()==true);
		diagramEditor.getEditingDomain().getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		assertTrue(VIEW_DELETION +TEST_THE_EXECUTION,getDiagramEditPart().getChildren().size()==0);
		assertTrue(VIEW_DELETION +TEST_THE_EXECUTION,getRootSemanticModel().getOwnedElements().size()==1);
		diagramEditor.getEditingDomain().getCommandStack().undo();
		assertTrue(VIEW_DELETION +TEST_THE_UNDO,getDiagramEditPart().getChildren().size()==1);
		assertTrue(VIEW_DELETION +TEST_THE_UNDO,getRootSemanticModel().getOwnedElements().size()==1);
		diagramEditor.getEditingDomain().getCommandStack().redo();
		assertTrue(VIEW_DELETION +TEST_THE_REDO,getDiagramEditPart().getChildren().size()==0);
		assertTrue(VIEW_DELETION +TEST_THE_REDO,getRootSemanticModel().getOwnedElements().size()==1);
		
	}
	
	/**
	 * Test destroy.
	 * 
	 * @param type the type
	 */
	public void testDestroy(IElementType type) {
		//DESTROY SEMANTIC+ VIEW
		assertTrue(DESTROY_DELETION +INITIALIZATION_TEST,getDiagramEditPart().getChildren().size()==1);
		assertTrue(DESTROY_DELETION +INITIALIZATION_TEST,getRootSemanticModel().getOwnedElements().size()==1);
	
		Request deleteViewRequest =	new EditCommandRequestWrapper( new DestroyElementRequest(false));
		Command command = ((GraphicalEditPart)getDiagramEditPart().getChildren().get(0)).getCommand(deleteViewRequest);
		assertNotNull(DESTROY_DELETION +COMMAND_NULL,command);
		assertTrue(DESTROY_DELETION +TEST_IF_THE_COMMAND_IS_CREATED,command!=UnexecutableCommand.INSTANCE);
		assertTrue(DESTROY_DELETION+TEST_IF_THE_COMMAND_CAN_BE_EXECUTED,command.canExecute()==true);
		diagramEditor.getEditingDomain().getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		assertTrue(DESTROY_DELETION +TEST_THE_EXECUTION,getDiagramEditPart().getChildren().size()==0);
		assertTrue(DESTROY_DELETION +TEST_THE_EXECUTION,getRootSemanticModel().getOwnedElements().size()==0);
		
		diagramEditor.getEditingDomain().getCommandStack().undo();
		assertTrue(DESTROY_DELETION +TEST_THE_UNDO,getDiagramEditPart().getChildren().size()==1);
		assertTrue(DESTROY_DELETION +TEST_THE_UNDO,getRootSemanticModel().getOwnedElements().size()==1);
		diagramEditor.getEditingDomain().getCommandStack().redo();
		assertTrue(DESTROY_DELETION +TEST_THE_REDO,getDiagramEditPart().getChildren().size()==0);
		assertTrue(DESTROY_DELETION +TEST_THE_REDO,getRootSemanticModel().getOwnedElements().size()==0);
	}
	
	
	/**
	 * Test drop.
	 * 
	 * @param type the type
	 */
	public void testDrop(IElementType type) {
		//DROP
		assertTrue(DROP +INITIALIZATION_TEST,getDiagramEditPart().getChildren().size()==0);
		assertTrue(DROP +INITIALIZATION_TEST,getRootSemanticModel().getOwnedElements().size()==1);
		
		
		DropObjectsRequest dropObjectsRequest= new DropObjectsRequest();
		ArrayList<Element> list = new ArrayList<Element>();
		list.add(getRootSemanticModel().getOwnedElements().get(0));
		dropObjectsRequest.setObjects(list);
		dropObjectsRequest.setLocation(new Point(20,20));
		Command command= getDiagramEditPart().getCommand(dropObjectsRequest);
		assertNotNull(DROP+COMMAND_NULL,command);
		assertTrue(DROP +TEST_IF_THE_COMMAND_IS_CREATED,command!=UnexecutableCommand.INSTANCE);
		assertTrue(DROP+TEST_IF_THE_COMMAND_CAN_BE_EXECUTED,command.canExecute()==true);
		diagramEditor.getEditingDomain().getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		assertTrue(DROP +TEST_THE_EXECUTION,getDiagramEditPart().getChildren().size()!=0);
		assertTrue(DROP +TEST_THE_EXECUTION,getRootSemanticModel().getOwnedElements().size()!=0);
		diagramEditor.getEditingDomain().getCommandStack().undo();
		assertTrue(DROP+TEST_THE_UNDO,getDiagramEditPart().getChildren().size()==0);
		assertTrue(DROP+TEST_THE_UNDO,getRootSemanticModel().getOwnedElements().size()!=0);
		diagramEditor.getEditingDomain().getCommandStack().redo();
		assertTrue(DROP+TEST_THE_REDO,getDiagramEditPart().getChildren().size()!=0);
		assertTrue(DROP+TEST_THE_REDO,getRootSemanticModel().getOwnedElements().size()!=0);
		}
	
	
	/**
	 * Test change container.
	 * 
	 * @param type the type
	 * @param containerType the container type
	 */
	public void testChangeContainer(IElementType type, IElementType containerType) {
		//CHANGE CONTAINER
		assertTrue(CHANGE_CONTAINER +INITIALIZATION_TEST,getDiagramEditPart().getChildren().size()==1);
		assertTrue(CHANGE_CONTAINER +INITIALIZATION_TEST,getRootSemanticModel().getOwnedElements().size()==1);
		
		
		Request requestcreation=CreateViewRequestFactory.getCreateShapeRequest(containerType, getDiagramEditPart().getDiagramPreferencesHint());
		Command command=getDiagramEditPart().getCommand(requestcreation);
		assertNotNull(CONTAINER_CREATION+COMMAND_NULL,command);
		assertTrue(CONTAINER_CREATION +TEST_IF_THE_COMMAND_IS_CREATED,command!=UnexecutableCommand.INSTANCE);
		assertTrue(CONTAINER_CREATION+TEST_IF_THE_COMMAND_CAN_BE_EXECUTED,command.canExecute()==true);
		diagramEditor.getEditingDomain().getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		assertTrue(CONTAINER_CREATION+TEST_THE_EXECUTION,getRootView().getChildren().size()==2);
		GraphicalEditPart containerEditPart= (GraphicalEditPart)getDiagramEditPart().getChildren().get(1);
		ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(RequestConstants.REQ_ADD);
		changeBoundsRequest.setEditParts((EditPart)getDiagramEditPart().getChildren().get(0));
		changeBoundsRequest.setLocation(new Point(30,30));
		ShapeCompartmentEditPart compartment=null;
		int index=0;
		while (compartment==null && index <containerEditPart.getChildren().size()){
			if((containerEditPart.getChildren().get(index)) instanceof ShapeCompartmentEditPart){
				compartment= (ShapeCompartmentEditPart)(containerEditPart.getChildren().get(index));
			}
			index++;
		}
		assertTrue("Container not found", compartment!=null);
		
		
		command=compartment.getCommand(changeBoundsRequest);
		assertNotNull(CHANGE_CONTAINER,command);
		assertTrue(CHANGE_CONTAINER+TEST_IF_THE_COMMAND_IS_CREATED,command!=UnexecutableCommand.INSTANCE);
		assertTrue(CHANGE_CONTAINER+TEST_IF_THE_COMMAND_CAN_BE_EXECUTED,command.canExecute()==true);
		diagramEditor.getEditingDomain().getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		assertTrue(CHANGE_CONTAINER+TEST_THE_EXECUTION,getRootView().getChildren().size()==1);
		assertTrue(CHANGE_CONTAINER+TEST_THE_EXECUTION,getRootSemanticModel().getOwnedElements().size()==1);
		assertTrue(CHANGE_CONTAINER+TEST_THE_EXECUTION,compartment.getChildren().size()==1);
		diagramEditor.getEditingDomain().getCommandStack().undo();
		assertTrue(CHANGE_CONTAINER+TEST_THE_UNDO,getRootView().getChildren().size()==2);
		assertTrue(CHANGE_CONTAINER+TEST_THE_UNDO,getRootSemanticModel().getOwnedElements().size()==2);
		assertTrue(CHANGE_CONTAINER+TEST_THE_EXECUTION,compartment.getChildren().size()==0);
		diagramEditor.getEditingDomain().getCommandStack().redo();
		assertTrue(CHANGE_CONTAINER+TEST_THE_REDO,getRootView().getChildren().size()==1);
		assertTrue(CHANGE_CONTAINER+TEST_THE_REDO,getRootSemanticModel().getOwnedElements().size()==1);
		assertTrue(CHANGE_CONTAINER+TEST_THE_EXECUTION,compartment.getChildren().size()==1);
		
		}
	
	/**
	 * Test to create a node.
	 * 
	 * @param type the type
	 */
	public void testToCreateANode(IElementType type) {
		
		//CREATION
		assertTrue(CREATION +INITIALIZATION_TEST,getDiagramEditPart().getChildren().size()==0);
		assertTrue(CREATION +INITIALIZATION_TEST,getRootSemanticModel().getOwnedElements().size()==0);
		
		CreateViewRequest requestcreation=CreateViewRequestFactory.getCreateShapeRequest(type, getDiagramEditPart().getDiagramPreferencesHint());
		Command command=getDiagramEditPart().getCommand(requestcreation);
		assertNotNull(CREATION+COMMAND_NULL,command);
		assertTrue(CREATION+TEST_IF_THE_COMMAND_IS_CREATED,command!=UnexecutableCommand.INSTANCE);
		assertTrue("CREATION: "+TEST_IF_THE_COMMAND_CAN_BE_EXECUTED,command.canExecute()==true);
		diagramEditor.getEditingDomain().getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		assertTrue(CREATION+TEST_THE_EXECUTION,getRootView().getChildren().size()==1);
		diagramEditor.getEditingDomain().getCommandStack().undo();
		assertTrue(CREATION+TEST_THE_UNDO,getRootView().getChildren().size()==0);
		assertTrue(CREATION+TEST_THE_UNDO,getRootSemanticModel().getOwnedElements().size()==0);
		diagramEditor.getEditingDomain().getCommandStack().redo();
		assertTrue("CREATION: "+TEST_THE_REDO,getDiagramEditPart().getChildren().size()==1);
						
	}
	
	/**
	 * Test to manage top node.
	 * 
	 * @param type the type
	 * @param containerType the container type
	 */
	public void testToManageTopNode(IElementType type, IElementType containerType) {
		testToCreateANode(type);
		testDestroy(type);
		diagramEditor.getEditingDomain().getCommandStack().undo();
		testViewDeletion(type);
		testDrop(type);
		testChangeContainer(type, containerType);
	}
	
	
}
