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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.set.encapsulation;

import java.util.HashMap;

import org.eclipse.gmf.runtime.notation.View;
import org.junit.BeforeClass;

/**
 * JUnit tests for Connector link removal during Block#setIsEncapsulated() test (via palette tools).
 */
public class TestSetEncapsulationDeleteConnectorFromReference extends AbstractSetEncapsulationDeleteConnectorTest {

	@BeforeClass
	public static void initSource() throws Exception {
		sourceView = referenceSourceView;
	}

	@BeforeClass
	public static void initExpectedResults() throws Exception {

		// Initialize source creation results
		isConnectorDestroyed = new HashMap<View, Boolean>();

		isConnectorDestroyed.put(actorPartTargetView, false);
		isConnectorDestroyed.put(nestedActorPartTargetView, true);
		isConnectorDestroyed.put(subNestedActorPartContainer1_1_1TargetView, true);
		isConnectorDestroyed.put(subNestedActorPartContainer1_2_1TargetView, true);
		isConnectorDestroyed.put(subNestedActorPartContainer1_1_2TargetView, false); // block which is changed is in the other hierarchy of part

		isConnectorDestroyed.put(portOnBlockTargetView, false);
		isConnectorDestroyed.put(portOnPartTargetView, false);
		isConnectorDestroyed.put(portOnNestedPartTargetView, true);

		isConnectorDestroyed.put(flowportOnBlockTargetView, false);
		isConnectorDestroyed.put(flowportOnPartTargetView, false);
		isConnectorDestroyed.put(flowportOnNestedPartTargetView, true);

		isConnectorDestroyed.put(partTargetView, false);
		isConnectorDestroyed.put(nestedPartTargetView, true);
		isConnectorDestroyed.put(subNestedPartContainer1_1_1TargetView, true);
		isConnectorDestroyed.put(subNestedPartContainer1_2_1TargetView, true);
		isConnectorDestroyed.put(subNestedPartContainer1_1_2TargetView, false); // block which is changed is in the other hierarchy of part

		isConnectorDestroyed.put(propertyTargetView, false);
		isConnectorDestroyed.put(nestedPropertyTargetView, true);
		isConnectorDestroyed.put(subNestedPropertyContainer1_1_1TargetView, true);
		isConnectorDestroyed.put(subNestedPropertyContainer1_2_1TargetView, true);
		isConnectorDestroyed.put(subNestedPropertyContainer1_1_2TargetView, false); // block which is changed is in the other hierarchy of part

		isConnectorDestroyed.put(referenceTargetView, false);
		isConnectorDestroyed.put(nestedReferenceTargetView, true);
		isConnectorDestroyed.put(subNestedReferenceContainer1_1_1TargetView, true);
		isConnectorDestroyed.put(subNestedReferenceContainer1_2_1TargetView, true);
		isConnectorDestroyed.put(subNestedReferenceContainer1_1_2TargetView, false); // block which is changed is in the other hierarchy of part

		isConnectorDestroyed.put(valueTargetView, false);
		isConnectorDestroyed.put(nestedValueTargetView, true);
		isConnectorDestroyed.put(subNestedValueContainer1_1_1TargetView, true);
		isConnectorDestroyed.put(subNestedValueContainer1_2_1TargetView, true);
		isConnectorDestroyed.put(subNestedValueContainer1_1_2TargetView, false); // block which is changed is in the other hierarchy of part

		// Initialize connector creation possibility
		for(View view : isConnectorDestroyed.keySet()) {
			isCreationAllowed.put(view, true);
		}
	}

}

