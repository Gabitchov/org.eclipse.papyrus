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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.dependency;

import java.util.HashMap;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.AbstractLinkCreationForSourcesTest;
import org.junit.BeforeClass;

/**
 * JUnit tests for Dependency link creation test (via palette tools).
 */
public class TestLinkCreationDependencyForSources extends AbstractLinkCreationForSourcesTest {
	
	@BeforeClass
	public static void initToolID() throws Exception {
		toolID = "internalblock.tool.dependency";
	}	
	
	@BeforeClass
	public static void initExpectedResults() throws Exception {
		
		// Initialize source creation results
		isCreationAllowed = new HashMap<View, Boolean>();
		
		isCreationAllowed.put(blockSourceView, true);
		
		isCreationAllowed.put(actorPartSourceView, true);
		isCreationAllowed.put(nestedActorPartSourceView, true);
		isCreationAllowed.put(subNestedActorPartContainer1_1_1SourceView, true);
		
		isCreationAllowed.put(portOnBlockSourceView, true);
		isCreationAllowed.put(portOnPartSourceView, true);
		isCreationAllowed.put(portOnNestedPartSourceView, true);
		isCreationAllowed.put(subNestedPartContainer1_1_1SourceView, true);
		
		isCreationAllowed.put(flowportOnBlockSourceView, true);
		isCreationAllowed.put(flowportOnPartSourceView, true);
		isCreationAllowed.put(flowportOnNestedPartSourceView, true);
		
		isCreationAllowed.put(partSourceView, true);
		isCreationAllowed.put(nestedPartSourceView, true);
		isCreationAllowed.put(subNestedPartContainer1_1_1TargetView, true);
		isCreationAllowed.put(subNestedPartContainer1_2_1TargetView, true);
		isCreationAllowed.put(subNestedPartContainer1_1_2TargetView, true);
		
		isCreationAllowed.put(propertySourceView, true);
		isCreationAllowed.put(nestedPropertySourceView, true);
		isCreationAllowed.put(subNestedPropertyContainer1_1_1SourceView, true);
		
		isCreationAllowed.put(referenceSourceView, true);
		isCreationAllowed.put(nestedReferenceSourceView, true);
		isCreationAllowed.put(subNestedReferenceContainer1_1_1SourceView, true);
		
		isCreationAllowed.put(valueSourceView, true);
		isCreationAllowed.put(nestedValueSourceView, true);
		isCreationAllowed.put(subNestedValueContainer1_1_1SourceView, true);
		
		isCreationAllowed.put(commentSourceView, false);
		isCreationAllowed.put(commentCNSourceView, false);
		isCreationAllowed.put(constraintSourceView, true);
		isCreationAllowed.put(constraintCNSourceView, true);
	}

}
