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
		
		isCreationAllowed.put(propertySourceView, false);
		isCreationAllowed.put(portSourceView, false);
		isCreationAllowed.put(flowportSourceView, false);
		isCreationAllowed.put(partSourceView, false);
		isCreationAllowed.put(referenceSourceView, false);
		isCreationAllowed.put(valueSourceView, false);
		isCreationAllowed.put(operationSourceView, false);
		isCreationAllowed.put(receptionSourceView, false);
		isCreationAllowed.put(constraintCLNSourceView, false);
		isCreationAllowed.put(constraintPropertySourceView, false);
		isCreationAllowed.put(flowPropertySourceView, false);
		isCreationAllowed.put(enumerationLiteralSourceView, false);		

	}

}
