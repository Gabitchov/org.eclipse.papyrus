/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.tests.canonical;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Element;

/**
 * The Class TestLinkWithParent use to test link between elements with parent.
 */
public abstract class TestLinkWithParent extends TestLink {


	/** The Constant DEFAULT_DROP_LOCATION. */
	protected static final Point DEFAULT_DROP_LOCATION = new Point(20, 20);

	/** The default source location. */
	protected static Point DEFAULT_SOURCE_LOCATION = new Point(300, 100);

	/** The default parent location. */
	protected static Point DEFAULT_PARENT_LOCATION = new Point(100, 100);

	// dyn values

	/** The begin root semantic owned element size. */
	protected int beginRootSemanticOwnedElementSize;

	/** The end root semantic owned element size. */
	protected int endRootSemanticOwnedElementSize;

	/** The begin diagram edit part children size. */
	protected int beginDiagramEditPartChildrenSize;

	/** The end diagram edit part children size. */
	protected int endDiagramEditPartChildrenSize;

	/** The begin root edge size. */
	protected int beginRootEdgeSize;

	/** The end root edge size. */
	protected int endRootEdgeSize;

	/** The begin source connections size. */
	protected int beginSourceConnectionsSize;

	/** The end source connections size. */
	protected int endSourceConnectionsSize;

	/** The begin root view children size. */
	protected int beginRootViewChildrenSize;

	/** The end root view children size. */
	protected int endRootViewChildrenSize;

	/** The parent type. */
	public IElementType parentType;

	/** The parent. */
	public GraphicalEditPart parent;

	/** The link element. */
	private Element linkElement;


	/**
	 * @see org.eclipse.papyrus.diagram.tests.canonical.TestLink#installEnvironment(org.eclipse.gmf.runtime.emf.type.core.IElementType,
	 *      org.eclipse.gmf.runtime.emf.type.core.IElementType)
	 *
	 * @param sourceType
	 * @param targetType
	 */

	@Override
	public void installEnvironment(IElementType sourceType, IElementType targetType) {

		//create the parent source
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(parentType, getDiagramEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(DEFAULT_PARENT_LOCATION);
		Command command = getDiagramEditPart().getCommand(requestcreation);
		assertTrue(command.canExecute());
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);;
		parent = (GraphicalEditPart)getDiagramEditPart().getChildren().get(0);

		//create the source
		requestcreation = CreateViewRequestFactory.getCreateShapeRequest(sourceType, getDiagramEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(DEFAULT_SOURCE_LOCATION);
		command = parent.getCommand(requestcreation);
		assertTrue(command.canExecute());
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		// FIXME : get(0) : header; get(1) : container
		List<GraphicalEditPart> children = parent.getChildren();
		source = children.get(2);
	}



	/**
	 * Check that the link is impossible to create
	 *
	 * @param sourceType
	 *        the source type
	 * @param targetType
	 *        the target type
	 * @param linkType
	 *        the link type
	 */
	public void testImpossibleToManageLink(IElementType sourceType, IElementType targetType, IElementType linkType) {
		installEnvironment(sourceType, targetType);
		Command command = target.getCommand(createConnectionViewRequest(linkType, source, target));
		assertFalse(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command != null && command.canExecute());
	}


	/**
	 * @see org.eclipse.papyrus.diagram.tests.canonical.TestLink#testToManageLink(org.eclipse.gmf.runtime.emf.type.core.IElementType,
	 *      org.eclipse.gmf.runtime.emf.type.core.IElementType, org.eclipse.gmf.runtime.emf.type.core.IElementType,
	 *      org.eclipse.gmf.runtime.emf.type.core.IElementType, boolean)
	 *
	 * @param sourceType
	 * @param targetType
	 * @param linkType
	 * @param containerType
	 * @param allowedOntheSame
	 */

	@Override
	public void testToManageLink(IElementType sourceType, IElementType targetType, IElementType linkType, IElementType containerType, boolean allowedOntheSame) {
		installEnvironment(sourceType, targetType);
		testToCreateALink(linkType);
		testDestroy(linkType);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		testViewDeletion(linkType);
		testDrop(linkType);
		// destroy the element
		Request deleteViewRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
		Command command = ((ConnectionEditPart)source.getSourceConnections().get(0)).getCommand(deleteViewRequest);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		// test link on the same
		testToCreateAlinkOnTheSame(linkType, allowedOntheSame);

		if(allowedOntheSame) {

			ConnectionEditPart graphicalEditPart = (ConnectionEditPart)source.getSourceConnections().get(0);
			View view = (View)graphicalEditPart.getModel();
			linkElement = (Element)view.getElement();

			deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
			command = ((ConnectionEditPart)source.getSourceConnections().get(0)).getCommand(deleteViewRequest);
			assertNotNull(VIEW_DELETION + COMMAND_NULL, command);
			assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
			assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
			testToDropAlinkOnTheSame(linkType, allowedOntheSame);
		}


	}

	/**
	 * @see org.eclipse.papyrus.diagram.tests.canonical.TestLink#testToCreateALink(org.eclipse.gmf.runtime.emf.type.core.IElementType)
	 *
	 * @param linkType
	 */

	@Override
	public void testToCreateALink(IElementType linkType) {
		assertEquals(CREATION + INITIALIZATION_TEST, beginDiagramEditPartChildrenSize, getDiagramEditPart().getChildren().size());
		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == beginRootSemanticOwnedElementSize);
		assertTrue(CREATION + INITIALIZATION_TEST, source.getSourceConnections().size() == beginSourceConnectionsSize);
		Command command = target.getCommand(createConnectionViewRequest(linkType, source, target));
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(CREATION + INITIALIZATION_TEST, source.getSourceConnections().size() == endSourceConnectionsSize);
		ConnectionEditPart graphicalEditPart = (ConnectionEditPart)source.getSourceConnections().get(0);
		View view = (View)graphicalEditPart.getModel();
		linkElement = (Element)view.getElement();
		assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == endRootEdgeSize);
		assertEquals(CREATION + INITIALIZATION_TEST, endRootSemanticOwnedElementSize, getRootSemanticModel().getOwnedElements().size());
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertEquals(CREATION + TEST_THE_UNDO, endRootViewChildrenSize, getRootView().getChildren().size());
		assertTrue(CREATION + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == beginRootSemanticOwnedElementSize);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(CREATION + TEST_THE_REDO, ((Diagram)getRootView()).getEdges().size() == endRootEdgeSize);
		assertTrue(CREATION + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == endRootSemanticOwnedElementSize);
	}

	/**
	 * @see org.eclipse.papyrus.diagram.tests.canonical.TestLink#testDestroy(org.eclipse.gmf.runtime.emf.type.core.IElementType)
	 *
	 * @param type
	 */

	@Override
	public void testDestroy(IElementType type) { // BMA : FIXME : unused param
		//DESTROY SEMANTIC+ VIEW
		assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == endRootEdgeSize);
		assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, source.getSourceConnections().size() == endSourceConnectionsSize);
		assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == endRootSemanticOwnedElementSize);
		Request deleteViewRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
		Command command = ((ConnectionEditPart)source.getSourceConnections().get(0)).getCommand(deleteViewRequest);
		assertNotNull(DESTROY_DELETION + COMMAND_NULL, command);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, ((Diagram)getRootView()).getEdges().size() == beginRootEdgeSize);
		assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, source.getSourceConnections().size() == beginSourceConnectionsSize);
		assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == beginRootSemanticOwnedElementSize);
		assertTrue(DESTROY_DELETION + TEST_THE_UNDO, diagramEditor.getDiagramEditDomain().getDiagramCommandStack().canUndo() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(DESTROY_DELETION + TEST_THE_UNDO, ((Diagram)getRootView()).getEdges().size() == endRootEdgeSize);
		assertTrue(DESTROY_DELETION + TEST_THE_UNDO, source.getSourceConnections().size() == endSourceConnectionsSize);
		assertTrue(DESTROY_DELETION + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == endRootSemanticOwnedElementSize);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == beginRootEdgeSize);
		assertTrue(DESTROY_DELETION + TEST_THE_REDO, source.getSourceConnections().size() == beginSourceConnectionsSize);
		assertTrue(DESTROY_DELETION + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == beginRootSemanticOwnedElementSize);
	}


	/**
	 * @see org.eclipse.papyrus.diagram.tests.canonical.TestLink#testViewDeletion(org.eclipse.gmf.runtime.emf.type.core.IElementType)
	 *
	 * @param type
	 */

	@Override
	public void testViewDeletion(IElementType type) { // BMA : FIXME : unused param
		//DELETION OF THE VIEW
		assertTrue(VIEW_DELETION + INITIALIZATION_TEST, source.getSourceConnections().size() == endSourceConnectionsSize);
		assertTrue(VIEW_DELETION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == endRootSemanticOwnedElementSize);
		Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
		Command command = ((ConnectionEditPart)source.getSourceConnections().get(0)).getCommand(deleteViewRequest);
		assertNotNull(VIEW_DELETION + COMMAND_NULL, command);
		assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(VIEW_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, source.getSourceConnections().size() == beginSourceConnectionsSize);
		assertTrue(VIEW_DELETION + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == endRootSemanticOwnedElementSize);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(VIEW_DELETION + TEST_THE_UNDO, source.getSourceConnections().size() == endSourceConnectionsSize);
		assertTrue(VIEW_DELETION + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == endRootSemanticOwnedElementSize);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(VIEW_DELETION + TEST_THE_REDO, source.getSourceConnections().size() == beginSourceConnectionsSize);
		assertTrue(VIEW_DELETION + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == endRootSemanticOwnedElementSize);
	}

	/**
	 * @see org.eclipse.papyrus.diagram.tests.canonical.TestLink#testDrop(org.eclipse.gmf.runtime.emf.type.core.IElementType)
	 *
	 * @param type
	 */

	@Override
	public void testDrop(IElementType type) {// BMA : FIXME : unused param
		//DROP
		assertTrue(DROP + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == beginDiagramEditPartChildrenSize);
		assertTrue(DROP + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == endRootSemanticOwnedElementSize);
		assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == beginRootEdgeSize);
		DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
		List<Element> list = new ArrayList<Element>();
		list.add(linkElement);
		dropObjectsRequest.setObjects(list);
		dropObjectsRequest.setLocation(DEFAULT_DROP_LOCATION);
		Command command = getDiagramEditPart().getCommand(dropObjectsRequest);
		assertNotNull(DROP + COMMAND_NULL, command);
		assertTrue(DROP + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(DROP + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(DROP + TEST_THE_EXECUTION, getDiagramEditPart().getChildren().size() == endDiagramEditPartChildrenSize);
		assertTrue(DROP + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == endRootSemanticOwnedElementSize);
		assertTrue(DROP + TEST_THE_EXECUTION, ((Diagram)getRootView()).getEdges().size() == endRootEdgeSize);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertTrue(DROP + TEST_THE_UNDO, getDiagramEditPart().getChildren().size() == beginDiagramEditPartChildrenSize);
		assertTrue(DROP + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == endRootSemanticOwnedElementSize);
		assertTrue(DROP + TEST_THE_UNDO, ((Diagram)getRootView()).getEdges().size() == beginRootEdgeSize);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertTrue(DROP + TEST_THE_REDO, getDiagramEditPart().getChildren().size() == endDiagramEditPartChildrenSize);
		assertTrue(DROP + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == endRootSemanticOwnedElementSize);
		assertTrue(DROP + TEST_THE_REDO, ((Diagram)getRootView()).getEdges().size() == endRootEdgeSize);
	}



	/**
	 * test the drop of a link where the source and the target are the same objects.
	 *
	 * @param linkType
	 *        the link type
	 * @param allowed
	 *        the allowed
	 */
	@Override
	protected void testToDropAlinkOnTheSame(IElementType linkType, boolean allowed) {
		//DROP
		if(allowed) {
			assertTrue(DROP + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == beginDiagramEditPartChildrenSize);
			assertTrue(DROP + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == endRootSemanticOwnedElementSize);
			assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram)getRootView()).getEdges().size() == beginRootEdgeSize);
			DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
			List<Element> list = new ArrayList<Element>();
			list.add(linkElement);
			dropObjectsRequest.setObjects(list);
			dropObjectsRequest.setLocation(DEFAULT_DROP_LOCATION);
			Command command = getDiagramEditPart().getCommand(dropObjectsRequest);
			assertNotNull(DROP + COMMAND_NULL, command);
			assertTrue(DROP + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
			assertTrue(DROP + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
			assertTrue(DROP + TEST_THE_EXECUTION, getDiagramEditPart().getChildren().size() == endDiagramEditPartChildrenSize);
			assertTrue(DROP + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == endRootSemanticOwnedElementSize);
			assertTrue(DROP + TEST_THE_EXECUTION, ((Diagram)getRootView()).getEdges().size() == endRootEdgeSize);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
			assertTrue(DROP + TEST_THE_UNDO, getDiagramEditPart().getChildren().size() == beginDiagramEditPartChildrenSize);
			assertTrue(DROP + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == endRootSemanticOwnedElementSize);
			assertTrue(DROP + TEST_THE_UNDO, ((Diagram)getRootView()).getEdges().size() == beginRootEdgeSize);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
			assertTrue(DROP + TEST_THE_REDO, getDiagramEditPart().getChildren().size() == endDiagramEditPartChildrenSize);
			assertTrue(DROP + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == endRootSemanticOwnedElementSize);
			assertTrue(DROP + TEST_THE_REDO, ((Diagram)getRootView()).getEdges().size() == endRootEdgeSize);
		}
	}

	/**
	 * test the creation of a link where the source and the target are the same objects.
	 *
	 * @param linkType
	 *        the link type
	 * @param allowed
	 *        the allowed
	 */
	@Override
	protected void testToCreateAlinkOnTheSame(IElementType linkType, boolean allowed) {
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == beginDiagramEditPartChildrenSize);
		assertEquals(CREATION + INITIALIZATION_TEST, beginRootSemanticOwnedElementSize, getRootSemanticModel().getOwnedElements().size());
		Command command = target.getCommand(createConnectionViewRequest(linkType, source, source));
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertEquals(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute(), allowed);
		if(allowed) {
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
			assertEquals(CREATION + INITIALIZATION_TEST, endRootEdgeSize, ((Diagram)getRootView()).getEdges().size());
			assertEquals(CREATION + INITIALIZATION_TEST, endRootSemanticOwnedElementSize, getRootSemanticModel().getOwnedElements().size());
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
			assertEquals(CREATION + TEST_THE_UNDO, beginRootViewChildrenSize, getRootView().getChildren().size());
			assertEquals(CREATION + TEST_THE_UNDO, beginRootSemanticOwnedElementSize, getRootSemanticModel().getOwnedElements().size());
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
			assertEquals(CREATION + TEST_THE_REDO, endRootEdgeSize, ((Diagram)getRootView()).getEdges().size());
			assertEquals(CREATION + TEST_THE_REDO, endRootSemanticOwnedElementSize, getRootSemanticModel().getOwnedElements().size());
		}
	}

}
