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
public class AbstractLinkCreationFromElementTest extends AbstractLinkPrepareTest {

	public static String toolID;

	public static View sourceView;

	public static Map<View, List<Property>> expectedSourceNestedPath;

	public static Map<View, List<Property>> expectedTargetNestedPath;

	@Test
	public void createLinkWithSourceBlock() throws Exception {
		View targetView = blockTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithSourceActorPart() throws Exception {
		View targetView = actorPartTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithSourceNestedActorPart() throws Exception {
		View targetView = nestedActorPartTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithSourcePortOnBlock() throws Exception {
		View targetView = portOnBlockTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithSourcePortOnPart() throws Exception {
		View targetView = portOnPartTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithSourcePortOnNestedPart() throws Exception {
		View targetView = portOnNestedPartTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithSourceFlowPortOnBlock() throws Exception {
		View targetView = flowportOnBlockTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithSourceFlowPortOnPart() throws Exception {
		View targetView = flowportOnPartTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithSourceFlowPortOnNestedPart() throws Exception {
		View targetView = flowportOnNestedPartTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithSourcePart() throws Exception {
		View targetView = partTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithSourceNestedPart() throws Exception {
		View targetView = nestedPartTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithSourceProperty() throws Exception {
		View targetView = propertyTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithSourceNestedProperty() throws Exception {
		View targetView = nestedPropertyTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithSourceReference() throws Exception {
		View targetView = referenceTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithSourceNestedReference() throws Exception {
		View targetView = nestedReferenceTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithSourceValue() throws Exception {
		View targetView = valueTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithSourceNestedValue() throws Exception {
		View targetView = nestedValueTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithSourceComment() throws Exception {
		View targetView = commentTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithSourceCommentCN() throws Exception {
		View targetView = commentCNTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithSourceConstraint() throws Exception {
		View targetView = constraintTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}

	@Test
	public void createLinkWithSourceConstraintCN() throws Exception {
		View targetView = constraintCNTargetView;
		createEdgeConnectorFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView), expectedSourceNestedPath.get(targetView), expectedTargetNestedPath.get(targetView));
	}
}
