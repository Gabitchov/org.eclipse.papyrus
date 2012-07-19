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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.inherited;

import java.util.HashMap;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.AbstractLinkCreationForSourcesTest;
import org.junit.BeforeClass;

/**
 * JUnit tests for Comment-Constraint link creation test (via palette tools).
 */
public class TestLinkCreationCommentConstraintForSources extends AbstractLinkCreationForSourcesTest {
	
	@BeforeClass
	public static void initToolID() throws Exception {
		toolID = "internalblock.tool.comment_constraint_link";
	}	
	
	@BeforeClass
	public static void initExpectedResults() throws Exception {
		
		// Initialize source creation results
		isCreationAllowed = new HashMap<View, Boolean>();
		
		isCreationAllowed.put(blockSourceView, false);
		
		isCreationAllowed.put(actorPartSourceView, false);
		isCreationAllowed.put(nestedActorPartSourceView, false);
		isCreationAllowed.put(subNestedActorPartContainer1_1_1SourceView, false);
		
		isCreationAllowed.put(portOnBlockSourceView, false);
		isCreationAllowed.put(portOnPartSourceView, false);
		isCreationAllowed.put(portOnNestedPartSourceView, false);
		
		isCreationAllowed.put(flowportOnBlockSourceView, false);
		isCreationAllowed.put(flowportOnPartSourceView, false);
		isCreationAllowed.put(flowportOnNestedPartSourceView, false);
		
		isCreationAllowed.put(partSourceView, false);
		isCreationAllowed.put(nestedPartSourceView, false);
		isCreationAllowed.put(subNestedPartContainer1_1_1SourceView, false);
		
		isCreationAllowed.put(propertySourceView, false);
		isCreationAllowed.put(nestedPropertySourceView, false);
		isCreationAllowed.put(subNestedPropertyContainer1_1_1SourceView, false);
		isCreationAllowed.put(subNestedPartContainer1_1_1TargetView, false);
		isCreationAllowed.put(subNestedPartContainer1_2_1TargetView, false);
		isCreationAllowed.put(subNestedPartContainer1_1_2TargetView, false);
		
		isCreationAllowed.put(referenceSourceView, false);
		isCreationAllowed.put(nestedReferenceSourceView, false);
		isCreationAllowed.put(subNestedReferenceContainer1_1_1SourceView, false);
		
		isCreationAllowed.put(valueSourceView, false);
		isCreationAllowed.put(nestedValueSourceView, false);
		isCreationAllowed.put(subNestedValueContainer1_1_1SourceView, false);
		
		isCreationAllowed.put(commentSourceView, true);
		isCreationAllowed.put(commentCNSourceView, true);
		isCreationAllowed.put(constraintSourceView, true);
		isCreationAllowed.put(constraintCNSourceView, true);
	}

}
