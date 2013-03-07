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
 * JUnit tests for Usage creation test (via palette tools).
 */
public class TestLinkCreationUsageForSources extends AbstractLinkCreationForSourcesTest {

	@BeforeClass
	public static void initToolID() throws Exception {
		toolID = "blockdefinition.tool.usage";
	}

	@BeforeClass
	public static void initExpectedResults() throws Exception {

		// Initialize source creation results
		isCreationAllowed = new HashMap<View, Boolean>();
		isCreationAllowed.put(actorSourceView, true);
		isCreationAllowed.put(actorPartSourceView, true);
		isCreationAllowed.put(blockSourceView, true);
		isCreationAllowed.put(constraintBlockSourceView, true);
		isCreationAllowed.put(dataTypeSourceView, true);
		isCreationAllowed.put(dimensionSourceView, true);
		isCreationAllowed.put(enumerationSourceView, true);
		isCreationAllowed.put(flowSpecificationSourceView, true);
		isCreationAllowed.put(interfaceSourceView, true);
		isCreationAllowed.put(primitiveTypeSourceView, true);
		isCreationAllowed.put(signalSourceView, true);
		isCreationAllowed.put(unitSourceView, true);
		isCreationAllowed.put(valueTypeSourceView, true);

		isCreationAllowed.put(commentSourceView, false);
		isCreationAllowed.put(commentCNSourceView, false);
		isCreationAllowed.put(constraintSourceView, true);
		isCreationAllowed.put(constraintCNSourceView, true);
		isCreationAllowed.put(instanceSpecSourceView, true);
		isCreationAllowed.put(instanceSpecCNSourceView, true);
		isCreationAllowed.put(modelSourceView, true);
		isCreationAllowed.put(modelCNSourceView, true);
		isCreationAllowed.put(packageSourceView, true);
		isCreationAllowed.put(packageCNSourceView, true);

		isCreationAllowed.put(slotSourceView, false);

		isCreationAllowed.put(propertySourceView, true);
		isCreationAllowed.put(portSourceView, true);
		isCreationAllowed.put(flowportSourceView, true);
		isCreationAllowed.put(partSourceView, true);
		isCreationAllowed.put(referenceSourceView, true);
		isCreationAllowed.put(valueSourceView, true);
		isCreationAllowed.put(operationSourceView, true);
		isCreationAllowed.put(receptionSourceView, true);
		isCreationAllowed.put(constraintCLNSourceView, true);
		isCreationAllowed.put(constraintPropertySourceView, true);
		isCreationAllowed.put(flowPropertySourceView, true);
		isCreationAllowed.put(enumerationLiteralSourceView, true);

		isCreationAllowed.put(associationSourceView, true);
	}

}
