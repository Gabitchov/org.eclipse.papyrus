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
package org.eclipse.papyrus.uml.diagram.sequence.tests.canonical;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.tests.canonical.AbstractPapyrusTestCase;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;


/**
 * The Class TestChildNode.
 */
public abstract class TestChildNode extends AbstractPapyrusTestCase {

	protected abstract CreateViewRequest createViewRequestShapeContainer();

	protected GraphicalEditPart rootPart;

	protected GraphicalEditPart getRootEditPart() {
		if(rootPart == null) {
			GraphicalEditPart part = (GraphicalEditPart)getDiagramEditPart().getChildren().get(0);
			rootPart = (GraphicalEditPart)part.getChildren().get(1);
		}
		return rootPart;
	}

	@Override
	protected View getRootView() {
		return getRootEditPart().getNotationView();
	}

	@Override
	protected Element getRootSemanticModel() {
		return (Element)getRootView().getElement();
	}

	protected DiagramCommandStack getDiagramCommandStack() {
		return getRootEditPart().getDiagramEditDomain().getDiagramCommandStack();
	}

	protected org.eclipse.emf.common.command.CommandStack getEMFCommandStack() {
		return getRootEditPart().getEditingDomain().getCommandStack();
	}

	protected void waitForComplete() {
		boolean run = true;
		while(run) {
			try {
				run = Display.getDefault().readAndDispatch();
			} catch (Exception e) {
				run = true;
			}
		}
	}

	/**
	 * Test view deletion.
	 * 
	 * @param type
	 *        the type
	 */
	public void testViewDeletion(IElementType type, IChildTestProvider provider) {
		//DELETION OF THE VIEW
		assertTrue(VIEW_DELETION + INITIALIZATION_TEST, provider.getEditPartChildrenSize() == 1);
		assertTrue(VIEW_DELETION + INITIALIZATION_TEST, !provider.hasSemanticChild() || provider.getSemanticChildrenSize() == 1);
		assertTrue(VIEW_DELETION + INITIALIZATION_TEST, provider.getViewChildrenSize() == 1);

		Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
		Command command = provider.getDestroyEditPart().getCommand(deleteViewRequest);

		assertNotNull(VIEW_DELETION + COMMAND_NULL, command);
		assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getDiagramCommandStack().execute(command);
		assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, provider.getEditPartChildrenSize() == 0);
		assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, !provider.hasSemanticChild() || provider.getSemanticChildrenSize() == 1);
		assertTrue(VIEW_DELETION + INITIALIZATION_TEST, provider.getViewChildrenSize() == 0);

		getDiagramCommandStack().undo();
		assertTrue(VIEW_DELETION + TEST_THE_UNDO, provider.getEditPartChildrenSize() == 1);
		assertTrue(VIEW_DELETION + TEST_THE_UNDO, !provider.hasSemanticChild() || provider.getSemanticChildrenSize() == 1);
		assertTrue(VIEW_DELETION + INITIALIZATION_TEST, provider.getViewChildrenSize() == 1);

		getDiagramCommandStack().redo();
		assertTrue(VIEW_DELETION + TEST_THE_REDO, provider.getEditPartChildrenSize() == 0);
		assertTrue(VIEW_DELETION + TEST_THE_REDO, !provider.hasSemanticChild() || provider.getSemanticChildrenSize() == 1);
		assertTrue(VIEW_DELETION + INITIALIZATION_TEST, provider.getViewChildrenSize() == 0);

	}


	/**
	 * Test destroy.
	 * 
	 * @param type
	 *        the type
	 */
	public void testDestroy(IElementType type, IChildTestProvider provider) {
		//DESTROY SEMANTIC+ VIEW
		assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, provider.getEditPartChildrenSize() == 1);
		assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, !provider.hasSemanticChild() || provider.getSemanticChildrenSize() == 1);

		Request deleteViewRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
		Command command = provider.getDestroyEditPart().getCommand(deleteViewRequest);
		assertNotNull(DESTROY_DELETION + COMMAND_NULL, command);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, provider.getEditPartChildrenSize() == 0);
		assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, provider.getViewChildrenSize() == 0);
		assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, provider.getSemanticChildrenSize() == 0);

		getEMFCommandStack().undo();
		assertTrue(DESTROY_DELETION + TEST_THE_UNDO, provider.getEditPartChildrenSize() == 1);
		assertTrue(DESTROY_DELETION + TEST_THE_UNDO, !provider.hasSemanticChild() || provider.getSemanticChildrenSize() == 1);
		assertTrue(DESTROY_DELETION + TEST_THE_UNDO, provider.getViewChildrenSize() == 1);

		getEMFCommandStack().redo();
		assertTrue(DESTROY_DELETION + TEST_THE_REDO, provider.getEditPartChildrenSize() == 0);
		assertTrue(DESTROY_DELETION + TEST_THE_REDO, provider.getSemanticChildrenSize() == 0);
		assertTrue(DESTROY_DELETION + TEST_THE_REDO, provider.getViewChildrenSize() == 0);
	}

	/**
	 * Test to create a node.
	 * 
	 * @param type
	 *        the type
	 */
	public void testToCreateChildNode(IElementType type, IChildTestProvider provider) {

		//CREATION
		assertTrue(CREATION + INITIALIZATION_TEST, provider.getEditPartChildrenSize() == 0);
		assertTrue(CREATION + INITIALIZATION_TEST, !provider.hasSemanticChild() || provider.getSemanticChildrenSize() == 0);

		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getRootEditPart().getDiagramPreferencesHint());

		requestcreation.setLocation(provider.getChildLocation(provider.getParentEditPart()));

		Command command = provider.getParentEditPart().getCommand(requestcreation);

		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		getDiagramCommandStack().execute(command);
		assertTrue(CREATION + TEST_THE_EXECUTION, provider.getViewChildrenSize() == 1);
		assertTrue(CREATION + TEST_THE_EXECUTION, !provider.hasSemanticChild() || provider.getSemanticChildrenSize() == 1);
		assertTrue(CREATION + TEST_THE_EXECUTION, provider.getEditPartChildrenSize() == 1);

		getDiagramCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, provider.getViewChildrenSize() == 0);
		assertTrue(CREATION + TEST_THE_UNDO, provider.getSemanticChildrenSize() == 0);
		assertTrue(CREATION + TEST_THE_UNDO, provider.getEditPartChildrenSize() == 0);

		getDiagramCommandStack().redo();
		assertTrue(CREATION + TEST_THE_REDO, provider.getEditPartChildrenSize() == 1);
		assertTrue(CREATION + TEST_THE_REDO, provider.getViewChildrenSize() == 1);
		assertTrue(CREATION + TEST_THE_REDO, !provider.hasSemanticChild() || provider.getSemanticChildrenSize() == 1);

	}

	public void createChildNode(IElementType type, IChildTestProvider provider) {
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getRootEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(provider.getChildLocation(provider.getParentEditPart()));
		Command command = provider.getParentEditPart().getCommand(requestcreation);

		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		getDiagramCommandStack().execute(command);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		createTopNode();
	}

	protected void createTopNode() {
		CreateViewRequest requestcreation = createViewRequestShapeContainer();
		requestcreation.setSize(new Dimension(100, 200));

		Command command = getRootEditPart().getCommand(requestcreation);
		assertNotNull(CONTAINER_CREATION + COMMAND_NULL, command);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		getDiagramCommandStack().execute(command);
		assertTrue(CREATION + INITIALIZATION_TEST, getRootEditPart().getChildren().size() == 1);
	}


	/**
	 * Test to manage child node.
	 * 
	 * @param type
	 *        the type
	 * @param containerType
	 *        the container type
	 */
	public void testToManageChildNode(IElementType type, IChildTestProvider provider) { //IElementType containerType, 
		testToCreateChildNode(type, provider);
		// the node is still present
		testDestroy(type, provider);
		// the node has been destroyed, the UML element also
		getEMFCommandStack().undo();
		// the node and the UML element are present
		testViewDeletion(type, provider);
	}
}
