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
package org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.link;

import static org.eclipse.papyrus.sysml.diagram.parametric.tests.utils.TestUtils.createEdgeFromPalette;

import org.eclipse.gmf.runtime.notation.View;
import org.junit.Test;

/**
 * JUnit abstract tests for Link creation test (via palette tools).
 */
public class AbstractLinkCreationForSourcesTest4CB extends AbstractLinkPrepareTest4CB {

	public static String toolID;
		
	@Test
	public void createLinkWithSourceBlock() throws Exception {
		View sourceView = diagramContainerSourceView;
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

	@Test
	public void createLinkWithSourceDeepNestedPart() throws Exception {
		View sourceView = subNestedPartContainer1_1_1SourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}

	@Test
	public void createLinkWithSourceDeepNestedProperty() throws Exception {
		View sourceView = subNestedPropertyContainer1_1_1SourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}

	@Test
	public void createLinkWithSourceDeepNestedReference() throws Exception {
		View sourceView = subNestedReferenceContainer1_1_1SourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}

	@Test
	public void createLinkWithSourceDeepNestedValue() throws Exception {
		View sourceView = subNestedValueContainer1_1_1SourceView;
		createEdgeFromPalette(toolID, sourceView, null, isCreationAllowed.get(sourceView));
	}
}
