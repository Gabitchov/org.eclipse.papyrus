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
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils.changeVisibility;
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
 * JUnit tests for element creation test (via palette tools) in a Value "structure" compartment (meaningless compartment).
 */
public class TestNodeCreationOnNestedValueStructureCompartment extends AbstractTest {

	/** Structure Compartment of a nested Value */
	public static View containerView;

	/** Structure Compartment of a deep nested Value */
	public static View subContainerView;
	
	@BeforeClass
	public static void prepareContainerForTest() throws Exception {
		try {
			View blockView = ViewUtil.getChildBySemanticHint(getDiagramView(), SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID);
			View blockStructureView = ViewUtil.getChildBySemanticHint(blockView, SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID);
			View partView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
			View partStructureView = ViewUtil.getChildBySemanticHint(partView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);		
			View valuePropertyView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partStructureView);
			containerView = ViewUtil.getChildBySemanticHint(valuePropertyView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
			if(containerView == null) {
				throw new Exception("Unable to prepare container for test.");
			}
			// Ensure the compartment is visible (required for EditPart to be found)
			if(!containerView.isVisible()) {
				changeVisibility(containerView);
			}
		
			View nestedPartView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partStructureView);
			View nestedPartStructureView = ViewUtil.getChildBySemanticHint(nestedPartView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);		
			View subValuePropertyView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartStructureView);
			subContainerView = ViewUtil.getChildBySemanticHint(subValuePropertyView , SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
			if(subContainerView == null) {
				throw new Exception("Unable to prepare container for test.");
			}
			// Ensure the compartment is visible (required for EditPart to be found)
			if(!subContainerView.isVisible()) {
				changeVisibility(subContainerView);
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
		createNodeFromPalette("internalblock.tool.port", containerView, false);
	}

	@Test
	public void createFlowPort_IN() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_in", containerView, false);
	}
	
	@Test
	public void createFlowPort_OUT() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_out", containerView, false);
	}
	
	@Test
	public void createFlowPort_INOUT() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_inout", containerView, false);
	}
	
	@Test
	public void createFlowPort_NA() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_na", containerView, false);
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
		createNodeFromPalette("internalblock.tool.comment", containerView, true);
	}

	@Test
	public void createConstraint() throws Exception {
		createNodeFromPalette("internalblock.tool.constraint", containerView, false);
	}
	
	//////////////////////////////////////////////////
	// test on deep nested Value compartment
	//////////////////////////////////////////////////

	@Test
	public void createActorPartOnDeepNestedValueCompartment() throws Exception {
		createNodeFromPalette("internalblock.tool.actorpart", subContainerView, false);
	}
	
	@Test
	public void createPortOnDeepNestedValueCompartment() throws Exception {
		createNodeFromPalette("internalblock.tool.port", subContainerView, false);
	}

	@Test
	public void createFlowPort_INOnDeepNestedValueCompartment() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_in", subContainerView, false);
	}
	
	@Test
	public void createFlowPort_OUTOnDeepNestedValueCompartment() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_out", subContainerView, false);
	}
	
	@Test
	public void createFlowPort_INOUTOnDeepNestedValueCompartment() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_inout", subContainerView, false);
	}
	
	@Test
	public void createFlowPort_NAOnDeepNestedValueCompartment() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_na", subContainerView, false);
	}
	
	@Test
	public void createPartOnDeepNestedValueCompartment() throws Exception {
		createNodeFromPalette("internalblock.tool.part", subContainerView, false);
	}
	
	@Test
	public void createPropertyOnDeepNestedValueCompartment() throws Exception {
		createNodeFromPalette("internalblock.tool.property", subContainerView, false);
	}
	
	@Test
	public void createReferenceOnDeepNestedValueCompartment() throws Exception {
		createNodeFromPalette("internalblock.tool.reference", subContainerView, false);
	}
	
	@Test
	public void createValueOnDeepNestedValueCompartment() throws Exception {
		createNodeFromPalette("internalblock.tool.value", subContainerView, false);
	}
	
	@Test
	public void createCommentOnDeepNestedValueCompartment() throws Exception {
		createNodeFromPalette("internalblock.tool.comment", subContainerView, true);
	}

	@Test
	public void createConstraintOnDeepNestedValueCompartment() throws Exception {
		createNodeFromPalette("internalblock.tool.constraint", subContainerView, false);
	}
}
