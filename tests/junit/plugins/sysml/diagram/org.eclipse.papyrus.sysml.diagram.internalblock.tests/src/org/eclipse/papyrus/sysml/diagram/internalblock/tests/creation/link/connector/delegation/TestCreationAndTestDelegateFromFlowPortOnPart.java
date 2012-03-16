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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.delegation;

import java.util.HashMap;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Property;
import org.junit.BeforeClass;

/**
 * JUnit tests for Connector link creation test (via palette tools).
 */
public class TestCreationAndTestDelegateFromFlowPortOnPart extends AbstractConnectorCreationAndTestDelegateFromElementTest {

	@BeforeClass
	public static void initSource() throws Exception {
		sourceView = flowportOnPartSourceView;
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

		// Initialize partWithPort for tests
		Property part1 = (Property)partContainer1.getElement();
		Property part2 = (Property)partContainer2.getElement();
		Property nestedPart2 = (Property)nestedPartContainer2.getElement();

		expectedSourcePartWithPort = new HashMap<View, ConnectableElement>();
		expectedTargetPartWithPort = new HashMap<View, ConnectableElement>();

		for (View view : isCreationAllowed.keySet()) {
			expectedSourcePartWithPort.put(view, part1);
		}
		
		expectedSourcePartWithPort.remove(portOnNestedPartTargetView);
		expectedSourcePartWithPort.remove(flowportOnNestedPartTargetView);
		expectedSourcePartWithPort.remove(nestedActorPartTargetView);
		expectedSourcePartWithPort.remove(nestedPartTargetView);
		expectedSourcePartWithPort.remove(nestedPropertyTargetView);
		expectedSourcePartWithPort.remove(nestedReferenceTargetView);
		expectedSourcePartWithPort.remove(nestedValueTargetView);
		
		expectedTargetPartWithPort.put(portOnPartTargetView, part2);
		expectedTargetPartWithPort.put(flowportOnPartTargetView, part2);
		
		expectedTargetPartWithPort.put(portOnNestedPartTargetView, nestedPart2);
		expectedTargetPartWithPort.put(flowportOnNestedPartTargetView, nestedPart2);
	}

}
