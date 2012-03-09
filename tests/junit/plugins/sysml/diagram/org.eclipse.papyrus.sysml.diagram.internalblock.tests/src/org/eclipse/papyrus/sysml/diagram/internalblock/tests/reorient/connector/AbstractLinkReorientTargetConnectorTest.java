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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.reorient.connector;

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestUtils.reorientConnectorTarget;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.reorient.AbstractLinkPrepareTest;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils;
import org.eclipse.uml2.uml.Property;
import org.junit.Test;

/**
 * JUnit abstract tests for Connector re-orient.
 */
public class AbstractLinkReorientTargetConnectorTest extends AbstractLinkPrepareTest {

	public static View relationshipView;

	public static Map<View, List<Property>> expectedNestedPath = new HashMap<View, List<Property>>();

	@Test
	public void reorientLinkTargetToDiagram() throws Exception {
		View newTargetView = EditorUtils.getDiagramView();
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToBlock() throws Exception {
		View newTargetView = blockTargetView;
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToActorPart() throws Exception {
		View newTargetView = actorPartTargetView;
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToNestedActorPart() throws Exception {
		View newTargetView = nestedActorPartTargetView;
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToPortOnBlock() throws Exception {
		View newTargetView = portOnBlockTargetView;
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToPortOnPart() throws Exception {
		View newTargetView = portOnPartTargetView;
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToPortOnNestedPart() throws Exception {
		View newTargetView = portOnNestedPartTargetView;
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToFlowPortOnBlock() throws Exception {
		View newTargetView = flowportOnBlockTargetView;
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToFlowPortOnPart() throws Exception {
		View newTargetView = flowportOnPartTargetView;
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToFlowPortOnNestedPart() throws Exception {
		View newTargetView = flowportOnNestedPartTargetView;
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToPart() throws Exception {
		View newTargetView = partTargetView;
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToNestedPart() throws Exception {
		View newTargetView = nestedPartTargetView;
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToProperty() throws Exception {
		View newTargetView = propertyTargetView;
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToNestedProperty() throws Exception {
		View newTargetView = nestedPropertyTargetView;
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToReference() throws Exception {
		View newTargetView = referenceTargetView;
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToNestedReference() throws Exception {
		View newTargetView = nestedReferenceTargetView;
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToValue() throws Exception {
		View newTargetView = valueTargetView;
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToNestedValue() throws Exception {
		View newTargetView = nestedValueTargetView;
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToComment() throws Exception {
		View newTargetView = commentTargetView;
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToCommentCN() throws Exception {
		View newTargetView = commentCNTargetView;
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToConstraint() throws Exception {
		View newTargetView = constraintTargetView;
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToConstraintCN() throws Exception {
		View newTargetView = constraintCNTargetView;
		reorientConnectorTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView), expectedNestedPath.get(newTargetView));
	}
}
