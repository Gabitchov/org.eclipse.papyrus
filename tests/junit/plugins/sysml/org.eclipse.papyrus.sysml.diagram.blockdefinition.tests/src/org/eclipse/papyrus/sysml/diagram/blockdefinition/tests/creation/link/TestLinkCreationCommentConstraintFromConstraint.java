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

		isCreationAllowed.put(associationTargetView, true);
	}

}
