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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.node;

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestUtils.createNodeFromPalette;

import org.eclipse.papyrus.sysml.diagram.internalblock.tests.AbstractTest;
import org.junit.Test;

/**
 * JUnit tests for element creation test (via palette tools) in diagram.
 */
public class TestNodeCreationOnDiagram extends AbstractTest {

	@Test
	public void testCreationActorPartInDiagram() throws Exception {
		createNodeFromPalette("internalblock.tool.actorpart", getDiagramView(), false);
	}
	
	@Test
	public void testCreationPortInDiagram() throws Exception {
		createNodeFromPalette("internalblock.tool.port", getDiagramView(), false);
	}

	@Test
	public void testCreationFlowPort_IN_InDiagram() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_in", getDiagramView(), false);
	}
	
	@Test
	public void testCreationFlowPort_OUT_InDiagram() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_out", getDiagramView(), false);
	}
	
	@Test
	public void testCreationFlowPort_INOUT_InDiagram() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_inout", getDiagramView(), false);
	}
	
	@Test
	public void testCreationFlowPort_NA_InDiagram() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_na", getDiagramView(), false);
	}

	@Test
	public void testCreationPartInDiagram() throws Exception {
		createNodeFromPalette("internalblock.tool.part", getDiagramView(), false);
	}

	@Test
	public void testCreationPropertyInDiagram() throws Exception {
		createNodeFromPalette("internalblock.tool.property", getDiagramView(), false);
	}
	
	@Test
	public void testCreationReferenceInDiagram() throws Exception {
		createNodeFromPalette("internalblock.tool.reference", getDiagramView(), false);
	}
	
	@Test
	public void testCreationValueInDiagram() throws Exception {
		createNodeFromPalette("internalblock.tool.value", getDiagramView(), false);
	}
	
	@Test
	public void testCreationCommentInDiagram() throws Exception {
		createNodeFromPalette("internalblock.tool.comment", getDiagramView(), true);
	}

	@Test
	public void testCreationConstraintInDiagram() throws Exception {
		createNodeFromPalette("internalblock.tool.constraint", getDiagramView(), true);
	}
}
