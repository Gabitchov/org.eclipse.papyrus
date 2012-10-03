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

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.diagram.tests.canonical.TestChildNode;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.extension.commands.ICreationCommand;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;


public  abstract class TestActivityChildNode extends TestChildNode {


	@Override
	protected void setUp() throws Exception {
		projectCreation();

		while( !(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()instanceof IMultiDiagramEditor)){}
		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		papyrusEditor=((PapyrusMultiDiagramEditor)editorPart);
		
		assertTrue(CREATION +INITIALIZATION_TEST,getDiagramEditPart().getChildren().size()==1);
		GraphicalEditPart containerEditPart= (GraphicalEditPart)getDiagramEditPart().getChildren().get(0);
		rootCompartment = null;
		int index=0;
		while (rootCompartment==null && index <containerEditPart.getChildren().size()){
			if((containerEditPart.getChildren().get(index)) instanceof ShapeCompartmentEditPart){
				rootCompartment= (ShapeCompartmentEditPart)(containerEditPart.getChildren().get(index));
			}
			index++;
		}

	}
	
	/**
	 * Test change container.
	 * 
	 * @param type the type
	 * @param containerType the container type
	 */
	public void testChangeContainer(IElementType type, IElementType containerType) {
		//CHANGE CONTAINER
		assertTrue(CHANGE_CONTAINER +INITIALIZATION_TEST,getRootCompartment().getChildren().size()==1);
		assertTrue(CHANGE_CONTAINER +INITIALIZATION_TEST,getRootSemanticModel().getOwnedElements().size()==1);


		Request requestcreation=CreateViewRequestFactory.getCreateShapeRequest(containerType, getRootCompartment().getDiagramPreferencesHint());
		Command command=getRootCompartment().getCommand(requestcreation);
		assertNotNull(CONTAINER_CREATION+COMMAND_NULL,command);
		assertTrue(CONTAINER_CREATION +TEST_IF_THE_COMMAND_IS_CREATED,command!=UnexecutableCommand.INSTANCE);
		assertTrue(CONTAINER_CREATION+TEST_IF_THE_COMMAND_CAN_BE_EXECUTED,command.canExecute()==true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(CONTAINER_CREATION+TEST_THE_EXECUTION,getRootView().getChildren().size()==2);
		GraphicalEditPart containerEditPart= (GraphicalEditPart)getRootCompartment().getChildren().get(1);
		ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(RequestConstants.REQ_ADD);
		changeBoundsRequest.setEditParts((EditPart)getRootCompartment().getChildren().get(0));
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
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(CHANGE_CONTAINER+TEST_THE_EXECUTION,getRootView().getChildren().size()==1);
		assertTrue(CHANGE_CONTAINER+TEST_THE_EXECUTION,getRootSemanticModel().getOwnedElements().size()==1);
		assertTrue(CHANGE_CONTAINER+TEST_THE_EXECUTION,compartment.getChildren().size()==1);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(CHANGE_CONTAINER+TEST_THE_UNDO,getRootView().getChildren().size()==2);
		assertTrue(CHANGE_CONTAINER+TEST_THE_UNDO,getRootSemanticModel().getOwnedElements().size()==2);
		assertTrue(CHANGE_CONTAINER+TEST_THE_EXECUTION,compartment.getChildren().size()==0);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(CHANGE_CONTAINER+TEST_THE_REDO,getRootView().getChildren().size()==1);
		//Here there is a problem for activity diagram it is not clear 
		//assertTrue(CHANGE_CONTAINER+TEST_THE_REDO,getRootSemanticModel().getOwnedElements().size()==1);
		assertTrue(CHANGE_CONTAINER+TEST_THE_EXECUTION,compartment.getChildren().size()==1);
	}

}
