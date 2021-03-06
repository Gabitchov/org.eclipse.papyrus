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
package org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.link.connector;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.link.AbstractLinkCreationFromElementTest;
import org.eclipse.uml2.uml.Property;
import org.junit.BeforeClass;

/**
 * JUnit tests for Connector link creation test (via palette tools).
 */
public class TestLinkCreationConnectorFromConstraintParameter extends AbstractLinkCreationFromElementTest {

	@BeforeClass
	public static void initSource() throws Exception {
		sourceView = constraintParameterSourceView;
	}

	@BeforeClass
	public static void initToolID() throws Exception {
		toolID = "parametric.tool.connector";
	}

	@BeforeClass
	public static void initExpectedResults() throws Exception {

		// Initialize source creation results
		isCreationAllowed = new HashMap<View, Boolean>();

		isCreationAllowed.put(diagramContainerTargetView, false);

		isCreationAllowed.put(constraintPropertyTargetView, false);
		isCreationAllowed.put(constraintParameterTargetView, true);
		isCreationAllowed.put(nestedConstraintPropertyTargetView, false);
		isCreationAllowed.put(nestedConstraintParameterTargetView, true);
		
		isCreationAllowed.put(partTargetView, true);
		isCreationAllowed.put(nestedPartTargetView, true);
		isCreationAllowed.put(subNestedPartContainer1_1_1TargetView, true);
		isCreationAllowed.put(subNestedPartContainer1_2_1TargetView, true);
		isCreationAllowed.put(subNestedPartContainer1_1_2TargetView, true);

		isCreationAllowed.put(referenceTargetView, true);
		isCreationAllowed.put(nestedReferenceTargetView, true);

		isCreationAllowed.put(valueTargetView, true);
		isCreationAllowed.put(nestedValueTargetView, true);

		isCreationAllowed.put(commentTargetView, false);
		isCreationAllowed.put(commentCNTargetView, false);
		isCreationAllowed.put(constraintTargetView, false);
		isCreationAllowed.put(constraintCNTargetView, false);

		// Initialize nested property path for tests
		expectedSourceNestedPath = new HashMap<View, List<Property>>();
		expectedTargetNestedPath = new HashMap<View, List<Property>>();

		List<Property> nestedPath = Arrays.asList(new Property[]{ (Property)constraintPropertySourceView.getElement() });
		List<Property> emptyPath = Collections.emptyList();
		for(View view : isCreationAllowed.keySet()) {
			expectedSourceNestedPath.put(view, nestedPath);
			expectedTargetNestedPath.put(view, emptyPath);
		}
		
		nestedPath = Arrays.asList(new Property[]{ (Property)constraintPropertyTargetView.getElement() });
		expectedTargetNestedPath.put(constraintParameterTargetView, nestedPath);
		
		nestedPath = Arrays.asList(new Property[]{ (Property)partContainer2.getElement(),  (Property)nestedConstraintPropertyTargetView.getElement()});
		expectedTargetNestedPath.put(nestedConstraintParameterTargetView, nestedPath);
	
		nestedPath = Arrays.asList(new Property[]{ (Property)partContainer1.getElement()});
		expectedTargetNestedPath.put(nestedPartTargetView, nestedPath);
		
		nestedPath = Arrays.asList(new Property[]{ (Property)partContainer1.getElement()});
		expectedTargetNestedPath.put(nestedValueTargetView, nestedPath);
		
		nestedPath = Arrays.asList(new Property[]{ (Property)partContainer1.getElement()});
		expectedTargetNestedPath.put(nestedReferenceTargetView, nestedPath);
		
		nestedPath = Arrays.asList(new Property[]{ (Property)partContainer1.getElement(),  (Property)nestedPartContainer1_1.getElement()});
		expectedTargetNestedPath.put(subNestedPartContainer1_1_1TargetView, nestedPath);
		
		nestedPath = Arrays.asList(new Property[]{ (Property)partContainer1.getElement(),  (Property)nestedPartContainer2_1.getElement()});
		expectedTargetNestedPath.put(subNestedPartContainer1_2_1TargetView, nestedPath);
		
		nestedPath = Arrays.asList(new Property[]{ (Property)partContainer2.getElement(),  (Property)nestedPartContainer1_2.getElement()});
		expectedTargetNestedPath.put(subNestedPartContainer1_1_2TargetView, nestedPath);
		
	}

}
