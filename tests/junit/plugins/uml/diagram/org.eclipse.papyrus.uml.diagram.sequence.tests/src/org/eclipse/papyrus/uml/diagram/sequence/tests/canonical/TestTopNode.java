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
package org.eclipse.papyrus.uml.diagram.sequence.tests.canonical;

import java.util.ArrayList;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.tests.canonical.AbstractPapyrusTestCase;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * The Class TestTopNode.
 */
public abstract class TestTopNode extends AbstractPapyrusTestCase {

	protected GraphicalEditPart rootPart;

	protected GraphicalEditPart getRootEditPart() {
		if(rootPart == null) {
			GraphicalEditPart part = (GraphicalEditPart)getDiagramEditPart().getChildren().get(0);
			rootPart = (GraphicalEditPart)part.getChildren().get(1); // compart
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

	protected org.eclipse.emf.common.command.CommandStack getEMFCommandStack() {
		return getRootEditPart().getEditingDomain().getCommandStack();
	}

	protected DiagramCommandStack getDiagramCommandStack() {
		return getRootEditPart().getDiagramEditDomain().getDiagramCommandStack();
	}

	protected Package getPackage() {
		Element container = (Element)getDiagramEditPart().getNotationView().getElement();
		while(container != null && !(container instanceof Package)) {
			container = (Element)container.eContainer();
		}
		return (Package)container;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}


	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
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

	protected Point getAbsoluteCenter(IGraphicalEditPart part) {
		IFigure f = part.getFigure();
		Rectangle b = f.getBounds().getCopy();
		f.translateToAbsolute(b);
		Point c = b.getCenter().getCopy();
		return c;
	}

	/**
	 * Get the bounds of an edit part
	 * 
	 * @param part
	 *        edit part to find bounds
	 * @return part's bounds in absolute coordinates
	 */
	public static Rectangle getAbsoluteBounds(IGraphicalEditPart part) {
		// take bounds from figure
		Rectangle bounds = part.getFigure().getBounds().getCopy();

		if(part.getNotationView() instanceof Node) {
			// rather update with up to date model bounds
			Node node = (Node)part.getNotationView();
			LayoutConstraint cst = node.getLayoutConstraint();
			if(cst instanceof Bounds) {
				Bounds b = (Bounds)cst;
				Point parentLoc = part.getFigure().getParent().getBounds().getLocation();
				if(b.getX() > 0) {
					bounds.x = b.getX() + parentLoc.x;
				}
				if(b.getY() > 0) {
					bounds.y = b.getY() + parentLoc.y;
				}
				if(b.getHeight() != -1) {
					bounds.height = b.getHeight();
				}
				if(b.getWidth() != -1) {
					bounds.width = b.getWidth();
				}
			}
		}

		part.getFigure().getParent().translateToAbsolute(bounds);
		return bounds;
	}

	/**
	 * Test view deletion.
	 * 
	 * @param type
	 *        the type
	 * @param provider
	 */
	public void testViewDeletion(IElementType type, ITestProvider provider) {
		//DELETION OF THE VIEW
		assertTrue(VIEW_DELETION + INITIALIZATION_TEST, provider.getEditPartChildrenSize() == 1);
		assertTrue(VIEW_DELETION + INITIALIZATION_TEST, provider.getSemanticChildrenSize() == 1);

		Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
		Command command = provider.getDestroyEditPart().getCommand(deleteViewRequest);
		assertNotNull(VIEW_DELETION + COMMAND_NULL, command);
		assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getDiagramCommandStack().execute(command);
		assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, provider.getEditPartChildrenSize() == 0);
		assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, provider.getSemanticChildrenSize() == 1);

		getDiagramCommandStack().undo();
		assertTrue(VIEW_DELETION + TEST_THE_UNDO, provider.getEditPartChildrenSize() == 1);
		assertTrue(VIEW_DELETION + TEST_THE_UNDO, provider.getSemanticChildrenSize() == 1);

		getDiagramCommandStack().redo();
		assertTrue(VIEW_DELETION + TEST_THE_REDO, provider.getEditPartChildrenSize() == 0);
		assertTrue(VIEW_DELETION + TEST_THE_REDO, provider.getSemanticChildrenSize() == 1);

	}

	/**
	 * Retrieves the TransactionalEditingDomain
	 * 
	 * @return the editing domain (can be null)
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		ServiceUtilsForActionHandlers serviceUtils = ServiceUtilsForActionHandlers.getInstance();
		TransactionalEditingDomain editingDomain = null;
		try {
			editingDomain = serviceUtils.getTransactionalEditingDomain();

		} catch (ServiceException e) {
			Activator.log.error(e);
		}

		return editingDomain;
	}

	/**
	 * Test destroy.
	 * 
	 * @param type
	 *        the type
	 * @param provider
	 */
	public void testDestroy(IElementType type, ITestProvider provider) {
		//DESTROY SEMANTIC+ VIEW
		assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, provider.getEditPartChildrenSize() == 1);
		assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, provider.getSemanticChildrenSize() == 1);

		Request deleteViewRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
		Command command = provider.getDestroyEditPart().getCommand(deleteViewRequest);
		assertNotNull(DESTROY_DELETION + COMMAND_NULL, command);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, provider.getEditPartChildrenSize() == 0);
		assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, provider.getSemanticChildrenSize() == 0);

		getEMFCommandStack().undo();
		assertTrue(DESTROY_DELETION + TEST_THE_UNDO, provider.getEditPartChildrenSize() == 1);
		assertTrue(DESTROY_DELETION + TEST_THE_UNDO, provider.getSemanticChildrenSize() == 1);

		getEMFCommandStack().redo();
		assertTrue(DESTROY_DELETION + TEST_THE_REDO, provider.getEditPartChildrenSize() == 0);
		assertTrue(DESTROY_DELETION + TEST_THE_REDO, provider.getSemanticChildrenSize() == 0);
	}


	/**
	 * Test drop.
	 * 
	 * @param type
	 *        the type
	 * @param provider
	 */
	public void testDrop(IElementType type, ITestProvider provider) {
		if(provider.getDropElement() == null) {
			return;
		}
		//DROP
		assertTrue(DROP + INITIALIZATION_TEST, provider.getEditPartChildrenSize() == 0);
		assertTrue(DROP + INITIALIZATION_TEST, provider.getSemanticChildrenSize() == 1);

		DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
		ArrayList<Element> list = new ArrayList<Element>();
		list.add(provider.getDropElement());
		dropObjectsRequest.setObjects(list);
		dropObjectsRequest.setLocation(new Point(20, 20));
		Command command = getRootEditPart().getCommand(dropObjectsRequest);
		assertNotNull(DROP + COMMAND_NULL, command);
		assertTrue(DROP + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(DROP + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getDiagramCommandStack().execute(command);
		assertTrue(DROP + TEST_THE_EXECUTION, provider.getEditPartChildrenSize() != 0);
		assertTrue(DROP + TEST_THE_EXECUTION, provider.getSemanticChildrenSize() != 0);

		getDiagramCommandStack().undo();
		assertTrue(DROP + TEST_THE_UNDO, provider.getEditPartChildrenSize() == 0);
		assertTrue(DROP + TEST_THE_UNDO, provider.getSemanticChildrenSize() != 0);

		getDiagramCommandStack().redo();
		assertTrue(DROP + TEST_THE_REDO, provider.getEditPartChildrenSize() != 0);
		assertTrue(DROP + TEST_THE_REDO, provider.getSemanticChildrenSize() != 0);
	}


	public void testToCreateANode(IElementType type, ITestProvider provider) {
		//CREATION
		assertTrue(CREATION + INITIALIZATION_TEST, provider.getEditPartChildrenSize() == 0);
		assertTrue(CREATION + INITIALIZATION_TEST, provider.getSemanticChildrenSize() == 0);

		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getRootEditPart().getDiagramPreferencesHint());
		Command command = provider.getParentEditPart().getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getDiagramCommandStack().execute(command);
		assertTrue(CREATION + TEST_THE_EXECUTION, provider.getViewChildrenSize() == 1);
		assertTrue(CREATION + TEST_THE_EXECUTION, provider.getSemanticChildrenSize() == 1);
		assertTrue(CREATION + TEST_THE_EXECUTION, provider.getEditPartChildrenSize() == 1);

		getDiagramCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, provider.getViewChildrenSize() == 0);
		assertTrue(CREATION + TEST_THE_UNDO, provider.getSemanticChildrenSize() == 0);

		getDiagramCommandStack().redo();
		assertTrue(CREATION + TEST_THE_REDO, provider.getEditPartChildrenSize() == 1);
		assertTrue(CREATION + TEST_THE_REDO, provider.getSemanticChildrenSize() == 1);
		assertTrue(CREATION + TEST_THE_REDO, provider.getViewChildrenSize() == 1);
	}

	/**
	 * Test to manage top node.
	 * 
	 * @param type
	 *        the type
	 * @param containerType
	 *        the container type
	 */
	public void testToManageTopNode(IElementType type, ITestProvider provider) {
		testToCreateANode(type, provider);
		testDestroy(type, provider);

		getEMFCommandStack().undo();
		testViewDeletion(type, provider);

		testDrop(type, provider);
	}
}
