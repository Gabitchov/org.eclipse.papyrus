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
 * JUnit tests for Comment-Constraint link creation test (via palette tools).
 */
public class TestLinkCreationCommentConstraintFromConstraint extends AbstractLinkCreationFromElementTest {

	@BeforeClass
	public static void initSource() throws Exception {
		sourceView = constraintSourceView;
	}

	@BeforeClass
	public static void initToolID() throws Exception {
		toolID = "blockdefinition.tool.comment_constraint_link";
	}

	@BeforeClass
	public static void initExpectedResults() throws Exception {

		// Initialize source creation results
		isCreationAllowed = new HashMap<View, Boolean>();
		isCreationAllowed.put(actorTargetView, true);
		isCreationAllowed.put(actorPartTargetView, true);
		isCreationAllowed.put(blockTargetView, true);
		isCreationAllowed.put(constraintBlockTargetView, true);
		isCreationAllowed.put(dataTypeTargetView, true);
		isCreationAllowed.put(dimensionTargetView, true);
		isCreationAllowed.put(enumerationTargetView, true);
		isCreationAllowed.put(flowSpecificationTargetView, true);
		isCreationAllowed.put(interfaceTargetView, true);
		isCreationAllowed.put(primitiveTypeTargetView, true);
		isCreationAllowed.put(signalTargetView, true);
		isCreationAllowed.put(unitTargetView, true);
		isCreationAllowed.put(valueTypeTargetView, true);

		isCreationAllowed.put(commentTargetView, true);
		isCreationAllowed.put(commentCNTargetView, true);
		isCreationAllowed.put(constraintTargetView, true);
		isCreationAllowed.put(constraintCNTargetView, true);
		isCreationAllowed.put(instanceSpecTargetView, true);
		isCreationAllowed.put(instanceSpecCNTargetView, true);
		isCreationAllowed.put(modelTargetView, true);
		isCreationAllowed.put(modelCNTargetView, true);
		isCreationAllowed.put(packageTargetView, true);
		isCreationAllowed.put(packageCNTargetView, true);

		isCreationAllowed.put(slotTargetView, true);

		isCreationAllowed.put(propertyTargetView, true);
		isCreationAllowed.put(portTargetView, true);
		isCreationAllowed.put(flowportTargetView, true);
		isCreationAllowed.put(partTargetView, true);
		isCreationAllowed.put(referenceTargetView, true);
		isCreationAllowed.put(valueTargetView, true);
		isCreationAllowed.put(operationTargetView, true);
		isCreationAllowed.put(receptionTargetView, true);
		isCreationAllowed.put(constraintCLNTargetView, true);
		isCreationAllowed.put(constraintPropertyTargetView, true);
		isCreationAllowed.put(flowPropertyTargetView, true);
		isCreationAllowed.put(enumerationLiteralTargetView, true);

		isCreationAllowed.put(associationTargetView, true);
	}

}
