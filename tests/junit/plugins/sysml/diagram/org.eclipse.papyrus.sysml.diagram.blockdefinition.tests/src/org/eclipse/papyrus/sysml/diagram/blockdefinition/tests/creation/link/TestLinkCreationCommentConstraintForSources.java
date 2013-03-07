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
public class TestLinkCreationCommentConstraintForSources extends AbstractLinkCreationForSourcesTest {

	@BeforeClass
	public static void initToolID() throws Exception {
		toolID = "blockdefinition.tool.comment_constraint_link";
	}

	@BeforeClass
	public static void initExpectedResults() throws Exception {

		// Initialize source creation results
		isCreationAllowed = new HashMap<View, Boolean>();
		isCreationAllowed.put(actorSourceView, false);
		isCreationAllowed.put(actorPartSourceView, false);
		isCreationAllowed.put(blockSourceView, false);
		isCreationAllowed.put(constraintBlockSourceView, false);
		isCreationAllowed.put(dataTypeSourceView, false);
		isCreationAllowed.put(dimensionSourceView, false);
		isCreationAllowed.put(enumerationSourceView, false);
		isCreationAllowed.put(flowSpecificationSourceView, false);
		isCreationAllowed.put(interfaceSourceView, false);
		isCreationAllowed.put(primitiveTypeSourceView, false);
		isCreationAllowed.put(signalSourceView, false);
		isCreationAllowed.put(unitSourceView, false);
		isCreationAllowed.put(valueTypeSourceView, false);

		isCreationAllowed.put(commentSourceView, true);
		isCreationAllowed.put(commentCNSourceView, true);
		isCreationAllowed.put(constraintSourceView, true);
		isCreationAllowed.put(constraintCNSourceView, true);
		isCreationAllowed.put(instanceSpecSourceView, false);
		isCreationAllowed.put(instanceSpecCNSourceView, false);
		isCreationAllowed.put(modelSourceView, false);
		isCreationAllowed.put(modelCNSourceView, false);
		isCreationAllowed.put(packageSourceView, false);
		isCreationAllowed.put(packageCNSourceView, false);

		isCreationAllowed.put(slotSourceView, false);

		isCreationAllowed.put(propertySourceView, false);
		isCreationAllowed.put(portSourceView, false);
		isCreationAllowed.put(flowportSourceView, false);
		isCreationAllowed.put(partSourceView, false);
		isCreationAllowed.put(referenceSourceView, false);
		isCreationAllowed.put(valueSourceView, false);
		isCreationAllowed.put(operationSourceView, false);
		isCreationAllowed.put(receptionSourceView, false);
		isCreationAllowed.put(constraintCLNSourceView, true);
		isCreationAllowed.put(constraintPropertySourceView, false);
		isCreationAllowed.put(flowPropertySourceView, false);
		isCreationAllowed.put(enumerationLiteralSourceView, false);

		isCreationAllowed.put(associationSourceView, false);
	}

}
