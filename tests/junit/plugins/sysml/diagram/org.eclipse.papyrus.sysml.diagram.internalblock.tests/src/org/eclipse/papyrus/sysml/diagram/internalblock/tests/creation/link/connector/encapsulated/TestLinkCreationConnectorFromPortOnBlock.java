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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.encapsulated;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Property;
import org.junit.BeforeClass;

/**
 * JUnit tests for Connector link creation test (via palette tools).
 */
public class TestLinkCreationConnectorFromPortOnBlock extends AbstractLinkCreationFromElementTest {

	@BeforeClass
	public static void initSource() throws Exception {
		sourceView = portOnBlockSourceView;
	}

	@BeforeClass
	public static void initToolID() throws Exception {
		toolID = "internalblock.tool.connector";
	}

	@BeforeClass
	public static void initExpectedResults() throws Exception {

		// Initialize source creation results
		isCreationAllowed = new HashMap<View, Boolean>();

		isCreationAllowed.put(blockTargetView, false);

		isCreationAllowed.put(actorPartTargetView, true);
		isCreationAllowed.put(nestedActorPartTargetView, false);

		isCreationAllowed.put(portOnBlockTargetView, true);
		isCreationAllowed.put(portOnPartTargetView, true);
		isCreationAllowed.put(portOnNestedPartTargetView, false);

		isCreationAllowed.put(flowportOnBlockTargetView, true);
		isCreationAllowed.put(flowportOnPartTargetView, true);
		isCreationAllowed.put(flowportOnNestedPartTargetView, false);

		isCreationAllowed.put(partTargetView, true);
		isCreationAllowed.put(nestedPartTargetView, false);
		isCreationAllowed.put(subNestedPartContainer1_1_1TargetView, false);
		isCreationAllowed.put(subNestedPartContainer1_2_1TargetView, false);
		isCreationAllowed.put(subNestedPartContainer1_1_2TargetView, false);
		
		isCreationAllowed.put(propertyTargetView, true);
		isCreationAllowed.put(nestedPropertyTargetView, false);

		isCreationAllowed.put(referenceTargetView, true);
		isCreationAllowed.put(nestedReferenceTargetView, false);

		isCreationAllowed.put(valueTargetView, true);
		isCreationAllowed.put(nestedValueTargetView, false);

		isCreationAllowed.put(commentTargetView, false);
		isCreationAllowed.put(commentCNTargetView, false);
		isCreationAllowed.put(constraintTargetView, false);
		isCreationAllowed.put(constraintCNTargetView, false);

		// Initialize nested property path for tests
		List<Property> emptyPath = Collections.emptyList();

		expectedSourceNestedPath = new HashMap<View, List<Property>>();
		expectedTargetNestedPath = new HashMap<View, List<Property>>();

		for(View view : isCreationAllowed.keySet()) {
			expectedSourceNestedPath.put(view, emptyPath);
			expectedTargetNestedPath.put(view, emptyPath);
		}
	}

}
