/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.node;

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils.createElement;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestUtils.dropFromModelExplorer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.AbstractTest;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.junit.Test;

/**
 * JUnit tests for element Drop test (via palette tools) in diagram.
 */
public class TestNodeDropOnDiagram extends AbstractTest {

	@Test
	public void testDropBlockInDiagram() throws Exception {
		dropFromModelExplorer(SysMLElementTypes.BLOCK, getDiagramView(), false);
	}

	@Test
	public void testDropActorPartInDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.ACTOR_PART_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}
	
	@Test
	public void testDropPortInDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(UMLElementTypes.PORT, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}
	
	@Test
	public void testDropFlowPort_IN_InDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PORT_IN, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}
	
	@Test
	public void testDropFlowPort_OUT_InDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PORT_OUT, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}
	
	@Test
	public void testDropFlowPort_INOUT_InDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PORT_IN_OUT, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}
	
	@Test
	public void testDropFlowPort_NA_InDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PORT_NA, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}
	
	@Test
	public void testDropPartInDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.PART_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}
	
	@Test
	public void testDropPropertyInDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(UMLElementTypes.PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}
	
	@Test
	public void testDropReferenceInDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.REFERENCE_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}
	
	@Test
	public void testDropValueInDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.VALUE_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}
	
	@Test
	public void testDropCommentInDiagram() throws Exception {
		dropFromModelExplorer(UMLElementTypes.COMMENT, getDiagramView(), true);
	}

	@Test
	public void testDropConstraintInDiagram() throws Exception {
		dropFromModelExplorer(UMLElementTypes.CONSTRAINT, getDiagramView(), true);
	}
}
