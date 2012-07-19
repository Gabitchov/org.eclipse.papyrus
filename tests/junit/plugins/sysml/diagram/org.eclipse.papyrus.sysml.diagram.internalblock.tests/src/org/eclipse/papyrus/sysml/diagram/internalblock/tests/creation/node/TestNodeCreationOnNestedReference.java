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
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils.createGraphicalNode;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestUtils.createNodeFromPalette;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.AbstractTest;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit tests for element creation test (via palette tools) in a "nested" Reference.
 */
public class TestNodeCreationOnNestedReference extends AbstractTest {

	public static View containerView;

	/** reference in a nested part */
	public static View subContainerView;
	
	@BeforeClass
	public static void prepareContainerForTest() throws Exception {
		try {
			View blockView = ViewUtil.getChildBySemanticHint(getDiagramView(), SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID);
			View blockStructureView = ViewUtil.getChildBySemanticHint(blockView, SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID);
			View partView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
			View partStructureView = ViewUtil.getChildBySemanticHint(partView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
			containerView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partStructureView);

			if(containerView == null) {
				throw new Exception("Unable to prepare container for test.");
			}
			View nestedPartView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partStructureView);
			View nestedPartStructureView = ViewUtil.getChildBySemanticHint(nestedPartView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);		
			subContainerView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartStructureView);
			if(subContainerView == null) {
				throw new Exception("Unable to prepare sub-container for test.");
			}
			
		} catch (Exception e) {
			throw new Exception("Unable to prepare container for test.", e);
		}
	}

	@Test
	public void createActorPart() throws Exception {
		createNodeFromPalette("internalblock.tool.actorpart", containerView, false);
	}
	
	@Test
	public void createPort() throws Exception {
		createNodeFromPalette("internalblock.tool.port", containerView, true);
	}

	@Test
	public void createFlowPort_IN() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_in", containerView, true);
	}
	
	@Test
	public void createFlowPort_OUT() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_out", containerView, true);
	}
	
	@Test
	public void createFlowPort_INOUT() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_inout", containerView, true);
	}
	
	@Test
	public void createFlowPort_NA() throws Exception {
		// Don't try to run command (requires user action).
		createNodeFromPalette("internalblock.tool.flowport_na", containerView, true, false);
	}
	
	@Test
	public void createPart() throws Exception {
		createNodeFromPalette("internalblock.tool.part", containerView, false);
	}
	
	@Test
	public void createProperty() throws Exception {
		createNodeFromPalette("internalblock.tool.property", containerView, false);
	}
	
	@Test
	public void createReference() throws Exception {
		createNodeFromPalette("internalblock.tool.reference", containerView, false);
	}
	
	@Test
	public void createValue() throws Exception {
		createNodeFromPalette("internalblock.tool.value", containerView, false);
	}
	
	@Test
	public void createComment() throws Exception {
		createNodeFromPalette("internalblock.tool.comment", containerView, false);
	}

	@Test
	public void createConstraint() throws Exception {
		createNodeFromPalette("internalblock.tool.constraint", containerView, false);
	}
	
	/////////////////////////////////////////////////////////
	// Test on 2 level nested reference
	/////////////////////////////////////////////////////////
	
	@Test
	public void createActorPartOnDeepNestedReference() throws Exception {
		createNodeFromPalette("internalblock.tool.actorpart", containerView, false);
	}
	
	@Test
	public void createPortOnDeepNestedReference() throws Exception {
		createNodeFromPalette("internalblock.tool.port", containerView, true);
	}

	@Test
	public void createFlowPort_INOnDeepNestedReference() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_in", containerView, true);
	}
	
	@Test
	public void createFlowPort_OUTOnDeepNestedReference() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_out", containerView, true);
	}
	
	@Test
	public void createFlowPort_INOUTOnDeepNestedReference() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_inout", containerView, true);
	}
	
	@Test
	public void createFlowPort_NAOnDeepNestedReference() throws Exception {
		// Don't try to run command (requires user action).
		createNodeFromPalette("internalblock.tool.flowport_na", containerView, true, false);
	}
	
	@Test
	public void createPartOnDeepNestedReference() throws Exception {
		createNodeFromPalette("internalblock.tool.part", containerView, false);
	}
	
	@Test
	public void createPropertyOnDeepNestedReference() throws Exception {
		createNodeFromPalette("internalblock.tool.property", containerView, false);
	}
	
	@Test
	public void createReferenceOnDeepNestedReference() throws Exception {
		createNodeFromPalette("internalblock.tool.reference", containerView, false);
	}
	
	@Test
	public void createValueOnDeepNestedReference() throws Exception {
		createNodeFromPalette("internalblock.tool.value", containerView, false);
	}
	
	@Test
	public void createCommentOnDeepNestedReference() throws Exception {
		createNodeFromPalette("internalblock.tool.comment", containerView, false);
	}

	@Test
	public void createConstraintOnDeepNestedReference() throws Exception {
		createNodeFromPalette("internalblock.tool.constraint", containerView, false);
	}
}
