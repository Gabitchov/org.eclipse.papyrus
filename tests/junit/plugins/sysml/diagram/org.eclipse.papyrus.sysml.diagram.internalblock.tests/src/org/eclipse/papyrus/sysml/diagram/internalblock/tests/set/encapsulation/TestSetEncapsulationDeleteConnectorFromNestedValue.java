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
public class TestSetEncapsulationDeleteConnectorFromNestedValue extends AbstractSetEncapsulationDeleteConnectorTest {

	@BeforeClass
	public static void init() throws Exception {
		sourceView = nestedValueSourceView;
	}

	@BeforeClass
	public static void initExpectedResults() throws Exception {

		// Initialize source creation results
		isConnectorDestroyed = new HashMap<View, Boolean>();

		isConnectorDestroyed.put(actorPartTargetView, true);
		isConnectorDestroyed.put(nestedActorPartTargetView, false);

		isConnectorDestroyed.put(portOnBlockTargetView, true);
		isConnectorDestroyed.put(portOnPartTargetView, true);
		isConnectorDestroyed.put(portOnNestedPartTargetView, false);

		isConnectorDestroyed.put(flowportOnBlockTargetView, true);
		isConnectorDestroyed.put(flowportOnPartTargetView, true);
		isConnectorDestroyed.put(flowportOnNestedPartTargetView, false);

		isConnectorDestroyed.put(partTargetView, true);
		isConnectorDestroyed.put(nestedPartTargetView, false);

		isConnectorDestroyed.put(propertyTargetView, true);
		isConnectorDestroyed.put(nestedPropertyTargetView, false);

		isConnectorDestroyed.put(referenceTargetView, true);
		isConnectorDestroyed.put(nestedReferenceTargetView, false);

		isConnectorDestroyed.put(valueTargetView, true);
		isConnectorDestroyed.put(nestedValueTargetView, false);
		
		// Initialize connector creation possibility
		for(View view : isConnectorDestroyed.keySet()) {
			isCreationAllowed.put(view, true);
		}

	}

}
