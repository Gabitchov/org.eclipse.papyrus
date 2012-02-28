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

import java.util.HashMap;

import org.eclipse.gmf.runtime.notation.View;
import org.junit.BeforeClass;

/**
 * JUnit tests for Connector link creation test (via palette tools).
 */
public class TestLinkCreationConnectorFromNestedProperty extends AbstractLinkCreationFromElementTest {
	
	@BeforeClass
	public static void initSource() throws Exception {
		sourceView = nestedPropertySourceView;
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

		isCreationAllowed.put(actorPartTargetView, false);
		isCreationAllowed.put(nestedActorPartTargetView, true);
		
		isCreationAllowed.put(portOnBlockTargetView, false);
		isCreationAllowed.put(portOnPartTargetView, false);
		isCreationAllowed.put(portOnNestedPartTargetView, true);
		
		isCreationAllowed.put(flowportOnBlockTargetView, false);
		isCreationAllowed.put(flowportOnPartTargetView, false);
		isCreationAllowed.put(flowportOnNestedPartTargetView, true);
		
		isCreationAllowed.put(partTargetView, false);
		isCreationAllowed.put(nestedPartTargetView, true);
		
		isCreationAllowed.put(propertyTargetView, false);
		isCreationAllowed.put(nestedPropertyTargetView, true);
		
		isCreationAllowed.put(referenceTargetView, false);
		isCreationAllowed.put(nestedReferenceTargetView, true);
		
		isCreationAllowed.put(valueTargetView, false);
		isCreationAllowed.put(nestedValueTargetView, true);
		
		isCreationAllowed.put(commentTargetView, false);
		isCreationAllowed.put(commentCNTargetView, false);
		isCreationAllowed.put(constraintTargetView, false);
		isCreationAllowed.put(constraintCNTargetView, false);
	}

}
