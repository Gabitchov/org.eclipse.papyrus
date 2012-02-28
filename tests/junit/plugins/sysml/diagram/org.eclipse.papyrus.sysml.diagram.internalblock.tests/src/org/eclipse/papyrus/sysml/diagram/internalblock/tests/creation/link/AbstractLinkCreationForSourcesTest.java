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
 * JUnit abstract tests for Link creation test (via palette tools).
 */
public class AbstractLinkCreationForSourcesTest extends AbstractLinkPrepareTest {

	public static String toolID;
		
	@Test
	public void createLinkWithSourceBlock() throws Exception {
		View sourceView = blockSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceActorPart() throws Exception {
		View sourceView = actorPartSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceNestedActorPart() throws Exception {
		View sourceView = nestedActorPartSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourcePortOnBlock() throws Exception {
		View sourceView = portOnBlockSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}

	@Test
	public void createLinkWithSourcePortOnPart() throws Exception {
		View sourceView = portOnPartSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourcePortOnNestedPart() throws Exception {
		View sourceView = portOnNestedPartSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceFlowPortOnBlock() throws Exception {
		View sourceView = flowportOnBlockSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}

	@Test
	public void createLinkWithSourceFlowPortOnPart() throws Exception {
		View sourceView = flowportOnPartSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceFlowPortOnNestedPart() throws Exception {
		View sourceView = flowportOnNestedPartSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourcePart() throws Exception {
		View sourceView = partSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceNestedPart() throws Exception {
		View sourceView = nestedPartSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceProperty() throws Exception {
		View sourceView = propertySourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceNestedProperty() throws Exception {
		View sourceView = nestedPropertySourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}

	@Test
	public void createLinkWithSourceReference() throws Exception {
		View sourceView = referenceSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceNestedReference() throws Exception {
		View sourceView = nestedReferenceSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}

	@Test
	public void createLinkWithSourceValue() throws Exception {
		View sourceView = valueSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceNestedValue() throws Exception {
		View sourceView = nestedValueSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceComment() throws Exception {
		View sourceView = commentSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceCommentCN() throws Exception {
		View sourceView = commentCNSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceConstraint() throws Exception {
		View sourceView = constraintSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
	
	@Test
	public void createLinkWithSourceConstraintCN() throws Exception {
		View sourceView = constraintCNSourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
}
