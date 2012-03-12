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

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Property;
import org.junit.BeforeClass;

/**
 * JUnit tests for Connector link creation test (via palette tools).
 */
public class TestLinkCreationConnectorFromNestedActorPart extends AbstractLinkCreationFromElementTest {

	@BeforeClass
	public static void initSource() throws Exception {
		sourceView = nestedActorPartSourceView;
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
		isCreationAllowed.put(nestedActorPartTargetView, true);

		isCreationAllowed.put(portOnBlockTargetView, true);
		isCreationAllowed.put(portOnPartTargetView, true);
		isCreationAllowed.put(portOnNestedPartTargetView, true);

		isCreationAllowed.put(flowportOnBlockTargetView, true);
		isCreationAllowed.put(flowportOnPartTargetView, true);
		isCreationAllowed.put(flowportOnNestedPartTargetView, true);

		isCreationAllowed.put(partTargetView, true);
		isCreationAllowed.put(nestedPartTargetView, true);

		isCreationAllowed.put(propertyTargetView, true);
		isCreationAllowed.put(nestedPropertyTargetView, true);

		isCreationAllowed.put(referenceTargetView, true);
		isCreationAllowed.put(nestedReferenceTargetView, true);

		isCreationAllowed.put(valueTargetView, true);
		isCreationAllowed.put(nestedValueTargetView, true);

		isCreationAllowed.put(commentTargetView, false);
		isCreationAllowed.put(commentCNTargetView, false);
		isCreationAllowed.put(constraintTargetView, false);
		isCreationAllowed.put(constraintCNTargetView, false);

		// Initialize nested property path for tests
		Property part = (Property)partContainer1.getElement();
		List<Property> nestedPath = Arrays.asList(new Property[]{ part });
		List<Property> emptyPath = Collections.emptyList();

		expectedSourceNestedPath = new HashMap<View, List<Property>>();
		expectedTargetNestedPath = new HashMap<View, List<Property>>();

		for(View view : isCreationAllowed.keySet()) {
			expectedSourceNestedPath.put(view, emptyPath);
			expectedTargetNestedPath.put(view, emptyPath);
		}

		expectedSourceNestedPath.put(blockTargetView, nestedPath);
		expectedSourceNestedPath.put(actorPartTargetView, nestedPath);
		expectedSourceNestedPath.put(portOnBlockTargetView, nestedPath);
		expectedSourceNestedPath.put(portOnPartTargetView, nestedPath);
		expectedSourceNestedPath.put(flowportOnBlockTargetView, nestedPath);
		expectedSourceNestedPath.put(flowportOnPartTargetView, nestedPath);
		expectedSourceNestedPath.put(partTargetView, nestedPath);
		expectedSourceNestedPath.put(propertyTargetView, nestedPath);
		expectedSourceNestedPath.put(referenceTargetView, nestedPath);
		expectedSourceNestedPath.put(valueTargetView, nestedPath);
	}

}
