/*****************************************************************************
 * Copyright (c) 2011-2012 CEA LIST.
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
package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link;

import java.util.HashMap;

import org.eclipse.gmf.runtime.notation.View;
import org.junit.BeforeClass;

/**
 * JUnit tests for InterfaceRealization creation test (via palette tools).
 */
public class TestLinkCreationInterfaceRealizationFromBlock extends AbstractLinkCreationFromElementTest {
	
	@BeforeClass
	public static void initSource() throws Exception {
		sourceView = blockSourceView;
	}	
	
	@BeforeClass
	public static void initToolID() throws Exception {
		toolID = "blockdefinition.tool.interfacerealization";
	}	
	
	@BeforeClass
	public static void initExpectedResults() throws Exception {
		
		// Initialize source creation results (must be an Interface)
		isCreationAllowed = new HashMap<View, Boolean>();
		isCreationAllowed.put(actorTargetView, false);
		isCreationAllowed.put(actorPartTargetView, false);
		isCreationAllowed.put(blockTargetView, false);
		isCreationAllowed.put(constraintBlockTargetView, false);
		isCreationAllowed.put(dataTypeTargetView, false);
		isCreationAllowed.put(dimensionTargetView, false);
		isCreationAllowed.put(enumerationTargetView, false);
		isCreationAllowed.put(flowSpecificationTargetView, true); // TODO : Verify if SysML provide a rule to forbid this
		isCreationAllowed.put(interfaceTargetView, true);
		isCreationAllowed.put(primitiveTypeTargetView, false);
		isCreationAllowed.put(signalTargetView, false);
		isCreationAllowed.put(unitTargetView, false);
		isCreationAllowed.put(valueTypeTargetView, false);
		
		isCreationAllowed.put(commentTargetView, false);
		isCreationAllowed.put(commentCNTargetView, false);
		isCreationAllowed.put(constraintTargetView, false);
		isCreationAllowed.put(constraintCNTargetView, false);
		isCreationAllowed.put(instanceSpecTargetView, false);
		isCreationAllowed.put(instanceSpecCNTargetView, false);
		isCreationAllowed.put(modelTargetView, false);
		isCreationAllowed.put(modelCNTargetView, false);
		isCreationAllowed.put(packageTargetView, false);
		isCreationAllowed.put(packageCNTargetView, false);
		
		isCreationAllowed.put(slotTargetView, false);
		
		isCreationAllowed.put(propertyTargetView, false);
		isCreationAllowed.put(portTargetView, false);
		isCreationAllowed.put(flowportTargetView, false);
		isCreationAllowed.put(partTargetView, false);
		isCreationAllowed.put(referenceTargetView, false);
		isCreationAllowed.put(valueTargetView, false);
		isCreationAllowed.put(operationTargetView, false);
		isCreationAllowed.put(receptionTargetView, false);
		isCreationAllowed.put(constraintCLNTargetView, false);
		isCreationAllowed.put(constraintPropertyTargetView, false);
		isCreationAllowed.put(flowPropertyTargetView, false);
		isCreationAllowed.put(enumerationLiteralTargetView, false);		

		isCreationAllowed.put(associationTargetView, false);
	}

}
