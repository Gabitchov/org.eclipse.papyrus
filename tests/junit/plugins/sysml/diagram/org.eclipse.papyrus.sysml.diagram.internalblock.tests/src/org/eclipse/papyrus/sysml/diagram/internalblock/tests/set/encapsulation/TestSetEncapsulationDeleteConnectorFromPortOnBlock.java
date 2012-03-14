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
public class TestSetEncapsulationDeleteConnectorFromPortOnBlock extends AbstractSetEncapsulationDeleteConnectorTest {

	@BeforeClass
	public static void init() throws Exception {
		sourceView = portOnBlockSourceView;
	}

	@BeforeClass
	public static void initExpectedResults() throws Exception {

		// Initialize source creation results
		isConnectorDestroyed = new HashMap<View, Boolean>();

		isConnectorDestroyed.put(actorPartTargetView, false);
		isConnectorDestroyed.put(nestedActorPartTargetView, true);

		isConnectorDestroyed.put(portOnBlockTargetView, false);
		isConnectorDestroyed.put(portOnPartTargetView, false);
		isConnectorDestroyed.put(portOnNestedPartTargetView, true);

		isConnectorDestroyed.put(flowportOnBlockTargetView, false);
		isConnectorDestroyed.put(flowportOnPartTargetView, false);
		isConnectorDestroyed.put(flowportOnNestedPartTargetView, true);

		isConnectorDestroyed.put(partTargetView, false);
		isConnectorDestroyed.put(nestedPartTargetView, true);

		isConnectorDestroyed.put(propertyTargetView, false);
		isConnectorDestroyed.put(nestedPropertyTargetView, true);

		isConnectorDestroyed.put(referenceTargetView, false);
		isConnectorDestroyed.put(nestedReferenceTargetView, true);

		isConnectorDestroyed.put(valueTargetView, false);
		isConnectorDestroyed.put(nestedValueTargetView, true);
		
		// Initialize connector creation possibility
		for(View view : isConnectorDestroyed.keySet()) {
			isCreationAllowed.put(view, true);
		}
		isCreationAllowed.put(portOnBlockTargetView, false);
		isCreationAllowed.put(flowportOnBlockTargetView, false);

	}

}
