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

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestUtils.reorientRelationshipSource;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils;
import org.junit.Test;

/**
 * JUnit tests for Link re-orient.
 */
public class AbstractLinkReorientSourceTest extends AbstractLinkPrepareTest {

	public static View relationshipView;
	
	@Test
	public void reorientLinkTargetToDiagram() throws Exception {
		View newSourceView = EditorUtils.getDiagramView();
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}
	
	@Test
	public void reorientLinkSourceToBlock() throws Exception {
		View newSourceView = blockSourceView;
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}
	
	@Test
	public void reorientLinkSourceToActorPart() throws Exception {
		View newSourceView = actorPartSourceView;
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}
	
	@Test
	public void reorientLinkSourceToNestedActorPart() throws Exception {
		View newSourceView = nestedActorPartSourceView;
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}
	
	@Test
	public void reorientLinkSourceToPortOnBlock() throws Exception {
		View newSourceView = portOnBlockSourceView;
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToPortOnPart() throws Exception {
		View newSourceView = portOnPartSourceView;
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}
	
	@Test
	public void reorientLinkSourceToPortOnNestedPart() throws Exception {
		View newSourceView = portOnNestedPartSourceView;
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}
	
	@Test
	public void reorientLinkSourceToFlowPortOnBlock() throws Exception {
		View newSourceView = flowportOnBlockSourceView;
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToFlowPortOnPart() throws Exception {
		View newSourceView = flowportOnPartSourceView;
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}
	
	@Test
	public void reorientLinkSourceToFlowPortOnNestedPart() throws Exception {
		View newSourceView = flowportOnNestedPartSourceView;
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}
	
	@Test
	public void reorientLinkSourceToPart() throws Exception {
		View newSourceView = partSourceView;
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}
	
	@Test
	public void reorientLinkSourceToNestedPart() throws Exception {
		View newSourceView = nestedPartSourceView;
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}
	
	@Test
	public void reorientLinkSourceToProperty() throws Exception {
		View newSourceView = propertySourceView;
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}
	
	@Test
	public void reorientLinkSourceToNestedProperty() throws Exception {
		View newSourceView = nestedPropertySourceView;
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToReference() throws Exception {
		View newSourceView = referenceSourceView;
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}
	
	@Test
	public void reorientLinkSourceToNestedReference() throws Exception {
		View newSourceView = nestedReferenceSourceView;
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}

	@Test
	public void reorientLinkSourceToValue() throws Exception {
		View newSourceView = valueSourceView;
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}
	
	@Test
	public void reorientLinkSourceToNestedValue() throws Exception {
		View newSourceView = nestedValueSourceView;
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}
	
	@Test
	public void reorientLinkSourceToComment() throws Exception {
		View newSourceView = commentSourceView;
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}
	
	@Test
	public void reorientLinkSourceToCommentCN() throws Exception {
		View newSourceView = commentCNSourceView;
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}
	
	@Test
	public void reorientLinkSourceToConstraint() throws Exception {
		View newSourceView = constraintSourceView;
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}
	
	@Test
	public void reorientLinkSourceToConstraintCN() throws Exception {
		View newSourceView = constraintCNSourceView;
		reorientRelationshipSource(relationshipView, newSourceView, isReorientAllowed.get(newSourceView));
	}
}
