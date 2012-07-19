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
 * JUnit tests for element creation test (via palette tools) in a Reference "structure" compartment (meaningless compartment).
 */
public class TestNodeCreationOnNestedReferenceStructureCompartment extends AbstractTest {

	/** Structure Compartment of a nested Reference */
	public static View containerView;

	/** Structure Compartment of a deep nested Reference */
	public static View subContainerView;
	
	@BeforeClass
	public static void prepareContainerForTest() throws Exception {
		try {
			View blockView = ViewUtil.getChildBySemanticHint(getDiagramView(), SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID);
			View blockStructureView = ViewUtil.getChildBySemanticHint(blockView, SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID);
			View partView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
			View partStructureView = ViewUtil.getChildBySemanticHint(partView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);		
			View referencePropertyView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partStructureView);
			containerView = ViewUtil.getChildBySemanticHint(referencePropertyView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
			if(containerView == null) {
				throw new Exception("Unable to prepare container for test.");
			}
			// Ensure the compartment is visible (required for EditPart to be found)
			if(!containerView.isVisible()) {
				changeVisibility(containerView);
			}
		
			View nestedPartView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partStructureView);
			View nestedPartStructureView = ViewUtil.getChildBySemanticHint(nestedPartView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);		
			View subReferencePropertyView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartStructureView);
			subContainerView = ViewUtil.getChildBySemanticHint(subReferencePropertyView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
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
		// Don't try to run command (requires user action).
		createNodeFromPalette("internalblock.tool.actorpart", containerView, true, false);
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
		// Don't try to run command (requires user action).
		createNodeFromPalette("internalblock.tool.part", containerView, true, false);
	}
	
	@Test
	public void createProperty() throws Exception {
		createNodeFromPalette("internalblock.tool.property", containerView, true);
	}
	
	@Test
	public void createReference() throws Exception {
		// Don't try to run command (requires user action).
		createNodeFromPalette("internalblock.tool.reference", containerView, true, false);
	}
	
	@Test
	public void createValue() throws Exception {
		// Don't try to run command (requires user action).
		createNodeFromPalette("internalblock.tool.value", containerView, true, false);
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
	// test on deep nested Reference compartment
	//////////////////////////////////////////////////
	
	@Test
	public void createActorPartOnDeepNestedReferenceStructureCompartment() throws Exception {
		// Don't try to run command (requires user action).
		createNodeFromPalette("internalblock.tool.actorpart", containerView, true, false);
	}
	
	@Test
	public void createPortOnDeepNestedReferenceStructureCompartment() throws Exception {
		createNodeFromPalette("internalblock.tool.port", containerView, false);
	}

	@Test
	public void createFlowPort_INOnDeepNestedReferenceStructureCompartment() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_in", containerView, false);
	}
	
	@Test
	public void createFlowPort_OUTOnDeepNestedReferenceStructureCompartment() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_out", containerView, false);
	}
	
	@Test
	public void createFlowPort_INOUTOnDeepNestedReferenceStructureCompartment() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_inout", containerView, false);
	}
	
	@Test
	public void createFlowPort_NAOnDeepNestedReferenceStructureCompartment() throws Exception {
		createNodeFromPalette("internalblock.tool.flowport_na", containerView, false);
	}
	
	@Test
	public void createPartOnDeepNestedReferenceStructureCompartment() throws Exception {
		// Don't try to run command (requires user action).
		createNodeFromPalette("internalblock.tool.part", containerView, true, false);
	}
	
	@Test
	public void createPropertyOnDeepNestedReferenceStructureCompartment() throws Exception {
		createNodeFromPalette("internalblock.tool.property", containerView, true);
	}
	
	@Test
	public void createReferenceOnDeepNestedReferenceStructureCompartment() throws Exception {
		// Don't try to run command (requires user action).
		createNodeFromPalette("internalblock.tool.reference", containerView, true, false);
	}
	
	@Test
	public void createValueOnDeepNestedReferenceStructureCompartment() throws Exception {
		// Don't try to run command (requires user action).
		createNodeFromPalette("internalblock.tool.value", containerView, true, false);
	}
	
	@Test
	public void createCommentOnDeepNestedReferenceStructureCompartment() throws Exception {
		createNodeFromPalette("internalblock.tool.comment", containerView, true);
	}

	@Test
	public void createConstraintOnDeepNestedReferenceStructureCompartment() throws Exception {
		createNodeFromPalette("internalblock.tool.constraint", containerView, false);
	}
}
