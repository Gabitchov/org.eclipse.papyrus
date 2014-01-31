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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector;

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestUtils.createEdgeConnectorFromPalette;

import java.util.List;
import java.util.Map;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.AbstractLinkPrepareTest;
import org.eclipse.uml2.uml.Property;
import org.junit.Test;

/**
 * JUnit abstract tests for Link creation test (via palette tools).
 */
public abstract class AbstractLinkCreationFromElementTest extends AbstractLinkPrepareTest {

	public static String toolID;

	public static View sourceView;

	public static Map<View, List<Property>> expectedSourceNestedPath;

	public static Map<View, List<Property>> expectedTargetNestedPath;

	@Test
	public void createLinkWithTargetBlock() throws Exception {
		View targetView = blockTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithTargetActorPart() throws Exception {
		View targetView = actorPartTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithTargetNestedActorPart() throws Exception {
		View targetView = nestedActorPartTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithTargetPortOnBlock() throws Exception {
		View targetView = portOnBlockTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithTargetPortOnPart() throws Exception {
		View targetView = portOnPartTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithTargetPortOnNestedPart() throws Exception {
		View targetView = portOnNestedPartTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithTargetFlowPortOnBlock() throws Exception {
		View targetView = flowportOnBlockTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithTargetFlowPortOnPart() throws Exception {
		View targetView = flowportOnPartTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithTargetFlowPortOnNestedPart() throws Exception {
		View targetView = flowportOnNestedPartTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithTargetPart() throws Exception {
		View targetView = partTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithTargetNestedPart() throws Exception {
		View targetView = nestedPartTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithTargetProperty() throws Exception {
		View targetView = propertyTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithTargetNestedProperty() throws Exception {
		View targetView = nestedPropertyTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithTargetReference() throws Exception {
		View targetView = referenceTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithTargetNestedReference() throws Exception {
		View targetView = nestedReferenceTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithTargetValue() throws Exception {
		View targetView = valueTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithTargetNestedValue() throws Exception {
		View targetView = nestedValueTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithTargetComment() throws Exception {
		View targetView = commentTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithTargetCommentCN() throws Exception {
		View targetView = commentCNTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithTargetConstraint() throws Exception {
		View targetView = constraintTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithTargetConstraintCN() throws Exception {
		View targetView = constraintCNTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}
	
	// deep nested tests
	@Test
	public void createLinkWithTargetSubNestedPartContainer_1_1_1() throws Exception {
		View targetView = subNestedPartContainer1_1_1TargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetSubNestedPartContainer_1_2_1() throws Exception {
		View targetView = subNestedPartContainer1_2_1TargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetSubNestedPartContainer_1_1_2() throws Exception {
		View targetView = subNestedPartContainer1_1_2TargetView; 
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}
	
}
