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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link;

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestUtils.createEdgeFromPalette;

import org.eclipse.gmf.runtime.notation.View;
import org.junit.Test;

/**
 * JUnit tests for Link creation with specified source element (via palette tools).
 */
public class AbstractLinkCreationFromElementTest extends AbstractLinkPrepareTest {

	public static String toolID;
	public static View sourceView;
	
	@Test
	public void createLinkWithTargetBlock() throws Exception {
		View targetView = blockTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetActorPart() throws Exception {
		View targetView = actorPartTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetNestedActorPart() throws Exception {
		View targetView = nestedActorPartTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetPortOnBlock() throws Exception {
		View targetView = portOnBlockTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}

	@Test
	public void createLinkWithTargetPortOnPart() throws Exception {
		View targetView = portOnPartTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetPortOnNestedPart() throws Exception {
		View targetView = portOnNestedPartTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetFlowPortOnBlock() throws Exception {
		View targetView = flowportOnBlockTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}

	@Test
	public void createLinkWithTargetFlowPortOnPart() throws Exception {
		View targetView = flowportOnPartTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetFlowPortOnNestedPart() throws Exception {
		View targetView = flowportOnNestedPartTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetPart() throws Exception {
		View targetView = partTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetNestedPart() throws Exception {
		View targetView = nestedPartTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetProperty() throws Exception {
		View targetView = propertyTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetNestedProperty() throws Exception {
		View targetView = nestedPropertyTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}

	@Test
	public void createLinkWithTargetReference() throws Exception {
		View targetView = referenceTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetNestedReference() throws Exception {
		View targetView = nestedReferenceTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}

	@Test
	public void createLinkWithTargetValue() throws Exception {
		View targetView = valueTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetNestedValue() throws Exception {
		View targetView = nestedValueTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetComment() throws Exception {
		View targetView = commentTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetCommentCN() throws Exception {
		View targetView = commentCNTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetConstraint() throws Exception {
		View targetView = constraintTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetConstraintCN() throws Exception {
		View targetView = constraintCNTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
}
