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

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.parametric.tests.AbstractTest4B;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit tests for element creation test (via palette tools) in diagram.
 */
public class TestNodeCreationOnBlock extends AbstractTest4B {

	public static View blockView;
	
	@BeforeClass
	public static void prepareContainerForTest() throws Exception {
		try {
			blockView = ViewUtil.getChildBySemanticHint(getDiagramView(), SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID);
			
			if(blockView == null) {
				throw new Exception("Unable to prepare container for test.");
			}			
		} catch (Exception e) {
			throw new Exception("Unable to prepare container for test.", e);
		}
	}

	@Test
	public void testCreationConstraintProperty() throws Exception {
		createNodeFromPalette("parametric.tool.constraintblockpropertycomposite", blockView, false);
	}
	
	@Test
	public void testCreationConstraintParameter() throws Exception {
		createNodeFromPalette("parametric.tool.parameter", blockView, false);
	}
	
	@Test
	public void testCreationPart() throws Exception {
		createNodeFromPalette("parametric.tool.blockpropertycomposite", blockView, false);
	}
	
	@Test
	public void testCreationReference() throws Exception {
		createNodeFromPalette("parametric.tool.reference", blockView, false);
	}
	
	@Test
	public void testCreationValue() throws Exception {
		createNodeFromPalette("parametric.tool.value", blockView, false);
	}
	
	@Test
	public void testCreationComment() throws Exception {
		createNodeFromPalette("parametric.tool.comment", blockView, false);
	}
	
	@Test
	public void testCreationConstraint() throws Exception {
		createNodeFromPalette("parametric.tool.constraint", blockView, false);
	}
	
}
