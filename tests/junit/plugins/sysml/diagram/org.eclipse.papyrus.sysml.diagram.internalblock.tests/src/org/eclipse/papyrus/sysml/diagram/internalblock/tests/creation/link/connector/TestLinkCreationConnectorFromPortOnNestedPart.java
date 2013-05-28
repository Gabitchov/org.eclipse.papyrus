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
public class TestLinkCreationConnectorFromPortOnNestedPart extends AbstractLinkCreationFromElementTest {

	@BeforeClass
	public static void initSource() throws Exception {
		sourceView = portOnNestedPartSourceView;
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
		isCreationAllowed.put(subNestedPartContainer1_1_1TargetView, true);
		isCreationAllowed.put(subNestedPartContainer1_2_1TargetView, true);
		isCreationAllowed.put(subNestedPartContainer1_1_2TargetView, true);

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
		Property part1 = (Property)partContainer1.getElement();
		Property part2 = (Property)partContainer2.getElement();
		Property nestedPartContainer1_1Property = (Property)nestedPartContainer1_1.getElement();
		Property nestedPartContainer1_2Property = (Property)nestedPartContainer1_2.getElement();
		Property nestedPartContainer2_1Property = (Property)nestedPartContainer2_1.getElement();
		List<Property> subNestedPath1_1 = Arrays.asList(new Property[]{ part1, nestedPartContainer1_1Property });
		List<Property> subNestedPath2_1 = Arrays.asList(new Property[]{ nestedPartContainer2_1Property });
		List<Property> subNestedPath1_2 = Arrays.asList(new Property[]{ part2, nestedPartContainer1_2Property });
		List<Property> emptyPath = Collections.emptyList();
		List<Property> nestedPath = Arrays.asList(new Property[]{ part1 });
		
		expectedSourceNestedPath = new HashMap<View, List<Property>>();
		expectedTargetNestedPath = new HashMap<View, List<Property>>();

		for(View view : isCreationAllowed.keySet()) {
			expectedSourceNestedPath.put(view, emptyPath);
			expectedTargetNestedPath.put(view, emptyPath);
		}

		expectedSourceNestedPath.put(blockTargetView, subNestedPath1_1);
		expectedSourceNestedPath.put(actorPartTargetView, subNestedPath1_1);
		expectedSourceNestedPath.put(portOnBlockTargetView, subNestedPath1_1);
		expectedSourceNestedPath.put(portOnPartTargetView, subNestedPath1_1);
		expectedTargetNestedPath.put(subNestedPartContainer1_1_1TargetView, emptyPath);
		expectedTargetNestedPath.put(subNestedPartContainer1_2_1TargetView, subNestedPath2_1);
		expectedTargetNestedPath.put(subNestedPartContainer1_1_2TargetView, subNestedPath1_2);
		expectedSourceNestedPath.put(subNestedPartContainer1_1_2TargetView, subNestedPath1_1);
		expectedSourceNestedPath.put(flowportOnBlockTargetView, subNestedPath1_1);
		expectedSourceNestedPath.put(flowportOnPartTargetView, subNestedPath1_1);
		expectedSourceNestedPath.put(partTargetView, subNestedPath1_1);
		expectedSourceNestedPath.put(propertyTargetView, subNestedPath1_1);
		expectedSourceNestedPath.put(referenceTargetView, subNestedPath1_1);
		expectedSourceNestedPath.put(valueTargetView, subNestedPath1_1);
	}

}
