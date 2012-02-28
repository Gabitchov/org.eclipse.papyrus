/*****************************************************************************
 * Copyright (c) 2011-2012 CEA LIST.
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
package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils.createGraphicalNode;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestUtils.createEdgeFromPalette;

import java.util.HashMap;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * JUnit tests for Dependency creation test (via palette tools).
 */
public class TestLinkCreationGeneralizationFromBlock extends AbstractLinkCreationFromElementTest {
	
	@BeforeClass
	public static void initSource() throws Exception {
		sourceView = blockSourceView;
	}	
	
	@BeforeClass
	public static void initToolID() throws Exception {
		toolID = "blockdefinition.tool.generalization";
	}	
	
	@BeforeClass
	public static void initExpectedResults() throws Exception {
		
		// Initialize source creation results
		isCreationAllowed = new HashMap<View, Boolean>();
		isCreationAllowed.put(actorTargetView, true);
		isCreationAllowed.put(actorPartTargetView, false);
		isCreationAllowed.put(blockTargetView, true);
		isCreationAllowed.put(constraintBlockTargetView, true);
		isCreationAllowed.put(dataTypeTargetView, true);
		isCreationAllowed.put(dimensionTargetView, false);
		isCreationAllowed.put(enumerationTargetView, true);
		isCreationAllowed.put(flowSpecificationTargetView, true);
		isCreationAllowed.put(interfaceTargetView, true);
		isCreationAllowed.put(primitiveTypeTargetView, true);
		isCreationAllowed.put(signalTargetView, true);
		isCreationAllowed.put(unitTargetView, false);
		isCreationAllowed.put(valueTypeTargetView, true);
		
		isCreationAllowed.put(commentTargetView, false);
		isCreationAllowed.put(commentCNTargetView, false);
		isCreationAllowed.put(constraintTargetView, false);
		isCreationAllowed.put(constraintCNTargetView, false);
		isCreationAllowed.put(instanceSpecTargetView, false);
		isCreationAllowed.put(instanceSpecCNTargetView, false);
		isCreationAllowed.put(modelTargetView, false);
		isCreationAllowed.put(modelCNTargetView, false);
		isCreationAllowed.put(packageTargetView, false);
		isCreationAllowed.put(packageCNTargetView, false);
		
		isCreationAllowed.put(slotTargetView, false);
		
		isCreationAllowed.put(propertyTargetView, false);
		isCreationAllowed.put(portTargetView, false);
		isCreationAllowed.put(flowportTargetView, false);
		isCreationAllowed.put(partTargetView, false);
		isCreationAllowed.put(referenceTargetView, false);
		isCreationAllowed.put(valueTargetView, false);
		isCreationAllowed.put(operationTargetView, false);
		isCreationAllowed.put(receptionTargetView, false);
		isCreationAllowed.put(constraintCLNTargetView, false);
		isCreationAllowed.put(constraintPropertyTargetView, false);
		isCreationAllowed.put(flowPropertyTargetView, false);
		isCreationAllowed.put(enumerationLiteralTargetView, false);		

		isCreationAllowed.put(associationTargetView, true);
	}

	@Ignore("UML Rules not implemented.")
	@Test
	public void verifyUMLRulesForGeneralization() throws Exception {
		// TODO : check the spec. and decide which rule should be verified by 
		// construction (tested here).
		// ex.: generalization link from Class to Interface should probably not be allowed.
	}
	
	@Ignore("SysML Rule not implemented.")
	@Test
	public void onlyBlockCanSpecializeBlock() throws Exception {
		// [8] Any classifier which specializes a Block must also have the Block stereotype applied.
	}
	
	@Test
	public void createGeneralizationWithCycleIsForbidden() throws Exception {
		createEdgeFromPalette(toolID, blockSourceView, blockSourceView, false);
	}
	
	@Ignore("This is not tested on creation. This should be tested on validation.")
	@Test
	public void createGeneralizationWithIndirectCycleIsForbidden() throws Exception {
		View intermediate = createGraphicalNode(SysMLElementTypes.BLOCK, SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID, getDiagramView());
		createEdgeFromPalette(toolID, blockSourceView, intermediate, true);
		createEdgeFromPalette(toolID, intermediate, blockTargetView, true);
		createEdgeFromPalette(toolID, blockTargetView, blockSourceView, false);
	}
}
