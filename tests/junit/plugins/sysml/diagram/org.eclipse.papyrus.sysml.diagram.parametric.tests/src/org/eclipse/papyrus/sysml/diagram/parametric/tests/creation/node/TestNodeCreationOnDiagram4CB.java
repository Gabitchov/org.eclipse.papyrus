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
package org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.node;

import static org.eclipse.papyrus.sysml.diagram.parametric.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.parametric.tests.utils.TestUtils.createNodeFromPalette;

import org.eclipse.papyrus.sysml.diagram.parametric.tests.AbstractTest4CB;
import org.junit.Test;

/**
 * JUnit tests for element creation test (via palette tools) in diagram.
 */
public class TestNodeCreationOnDiagram4CB extends AbstractTest4CB {

	@Test
	public void testCreationConstraintProperty() throws Exception {
		createNodeFromPalette("parametric.tool.constraintblockpropertycomposite", getDiagramView(), false);
	}
	
	@Test
	public void testCreationConstraintParameter() throws Exception {
		createNodeFromPalette("parametric.tool.parameter", getDiagramView(), false);
	}
	
	@Test
	public void testCreationPart() throws Exception {
		createNodeFromPalette("parametric.tool.blockpropertycomposite", getDiagramView(), false);
	}
	
	@Test
	public void testCreationReference() throws Exception {
		createNodeFromPalette("parametric.tool.reference", getDiagramView(), false);
	}
	
	@Test
	public void testCreationValue() throws Exception {
		createNodeFromPalette("parametric.tool.value", getDiagramView(), false);
	}
	
	@Test
	public void testCreationComment() throws Exception {
		createNodeFromPalette("parametric.tool.comment", getDiagramView(), true);
	}
	
	@Test
	public void testCreationConstraint() throws Exception {
		createNodeFromPalette("parametric.tool.constraint", getDiagramView(), true);
	}
	
}
