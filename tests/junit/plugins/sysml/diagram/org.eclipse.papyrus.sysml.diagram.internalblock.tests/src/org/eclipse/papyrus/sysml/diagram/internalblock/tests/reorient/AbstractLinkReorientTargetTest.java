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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.reorient;

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestUtils.reorientRelationshipTarget;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils;
import org.junit.Test;

/**
 * JUnit tests for Link re-orient.
 */
public class AbstractLinkReorientTargetTest extends AbstractLinkPrepareTest {

	public static View relationshipView;

	@Test
	public void reorientLinkTargetToDiagram() throws Exception {
		View newTargetView = EditorUtils.getDiagramView();
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}
	
	@Test
	public void reorientLinkTargetToBlock() throws Exception {
		View newTargetView = blockTargetView;
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}
	
	@Test
	public void reorientLinkTargetToActorPart() throws Exception {
		View newTargetView = actorPartTargetView;
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}
	
	@Test
	public void reorientLinkTargetToNestedActorPart() throws Exception {
		View newTargetView = nestedActorPartTargetView;
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}
	
	@Test
	public void reorientLinkTargetToPortOnBlock() throws Exception {
		View newTargetView = portOnBlockTargetView;
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToPortOnPart() throws Exception {
		View newTargetView = portOnPartTargetView;
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}
	
	@Test
	public void reorientLinkTargetToPortOnNestedPart() throws Exception {
		View newTargetView = portOnNestedPartTargetView;
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}
	
	@Test
	public void reorientLinkTargetToFlowPortOnBlock() throws Exception {
		View newTargetView = flowportOnBlockTargetView;
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToFlowPortOnPart() throws Exception {
		View newTargetView = flowportOnPartTargetView;
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}
	
	@Test
	public void reorientLinkTargetToFlowPortOnNestedPart() throws Exception {
		View newTargetView = flowportOnNestedPartTargetView;
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}
	
	@Test
	public void reorientLinkTargetToPart() throws Exception {
		View newTargetView = partTargetView;
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}
	
	@Test
	public void reorientLinkTargetToNestedPart() throws Exception {
		View newTargetView = nestedPartTargetView;
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}
	
	@Test
	public void reorientLinkTargetToProperty() throws Exception {
		View newTargetView = propertyTargetView;
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}
	
	@Test
	public void reorientLinkTargetToNestedProperty() throws Exception {
		View newTargetView = nestedPropertyTargetView;
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToReference() throws Exception {
		View newTargetView = referenceTargetView;
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}
	
	@Test
	public void reorientLinkTargetToNestedReference() throws Exception {
		View newTargetView = nestedReferenceTargetView;
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}

	@Test
	public void reorientLinkTargetToValue() throws Exception {
		View newTargetView = valueTargetView;
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}
	
	@Test
	public void reorientLinkTargetToNestedValue() throws Exception {
		View newTargetView = nestedValueTargetView;
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}
	
	@Test
	public void reorientLinkTargetToComment() throws Exception {
		View newTargetView = commentTargetView;
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}
	
	@Test
	public void reorientLinkTargetToCommentCN() throws Exception {
		View newTargetView = commentCNTargetView;
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}
	
	@Test
	public void reorientLinkTargetToConstraint() throws Exception {
		View newTargetView = constraintTargetView;
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}
	
	@Test
	public void reorientLinkTargetToConstraintCN() throws Exception {
		View newTargetView = constraintCNTargetView;
		reorientRelationshipTarget(relationshipView, newTargetView, isReorientAllowed.get(newTargetView));
	}
}
