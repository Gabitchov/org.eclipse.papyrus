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
public class TestCreationAndTestDelegateFromPortOnNestedPart extends AbstractConnectorCreationAndTestDelegateFromElementTest {

	@BeforeClass
	public static void initSource() throws Exception {
		sourceView = port1OnNestedPart1_Part1SourceView;
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

		isCreationAllowed.put(actorPart2_BlockTargetView, true);
		isCreationAllowed.put(actorPart2_p1TargetView, true);

		isCreationAllowed.put(portOnBlockTargetView, true);
		isCreationAllowed.put(port1_Part1SourceView, true);
		isCreationAllowed.put(port2_Part1TargetView, true);		
		isCreationAllowed.put(port1_Part2TargetView, true);
		isCreationAllowed.put(port2OnNestedPart2_Part1TargetView, true);

		isCreationAllowed.put(flowportOnBlockTargetView, true);
		isCreationAllowed.put(flowport1_Part2TargetView, true);
		isCreationAllowed.put(flowport1_NestedPart2_Part1TargetView, true);

		isCreationAllowed.put(partTargetView, true);
		isCreationAllowed.put(nestedPart2_Part1TargetView, true);

		isCreationAllowed.put(propertyTargetView, true);
		isCreationAllowed.put(nestedPropertyTargetView, true);

		isCreationAllowed.put(referenceTargetView, true);
		isCreationAllowed.put(nestedReferenceTargetView, true);

		isCreationAllowed.put(valueTargetView, true);
		isCreationAllowed.put(nestedValueTargetView, true);

		// Initialize partWithPort for tests
		Property sourceNestedpart = (Property)p1_p1View.getElement();
		
		Property targetpart = (Property)p2View.getElement();
		Property targetNestedpart = (Property)p2_p1View.getElement();

		expectedSourcePartWithPort = new HashMap<View, ConnectableElement>();
		expectedTargetPartWithPort = new HashMap<View, ConnectableElement>();

		for (View view : isCreationAllowed.keySet()) {
			expectedSourcePartWithPort.put(view, sourceNestedpart);
		}
	
		expectedTargetPartWithPort.put(port1_Part2TargetView, targetpart);
		expectedTargetPartWithPort.put(flowport1_Part2TargetView, targetpart);
		
		expectedTargetPartWithPort.put(port2OnNestedPart2_Part1TargetView, targetNestedpart);
		expectedTargetPartWithPort.put(flowport1_NestedPart2_Part1TargetView, targetNestedpart);
	}

}
