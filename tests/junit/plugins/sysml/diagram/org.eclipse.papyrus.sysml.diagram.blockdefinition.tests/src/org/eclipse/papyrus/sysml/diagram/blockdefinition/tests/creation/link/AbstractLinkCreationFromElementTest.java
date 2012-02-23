package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestUtils.createEdgeFromPalette;

import org.eclipse.gmf.runtime.notation.View;
import org.junit.Test;

/**
 * JUnit tests for Link creation with Block source (via palette tools).
 */
public class AbstractLinkCreationFromElementTest extends AbstractLinkPrepareTest {

	public static String toolID;
	public static View sourceView;
	
	@Test
	public void createLinkWithTargetActor() throws Exception {
		View targetView = actorTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetActorPart() throws Exception {
		View targetView = actorPartTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetBlock() throws Exception {
		View targetView = blockTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetConstraintBlock() throws Exception {
		View targetView = constraintBlockTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetDataType() throws Exception {
		View targetView = dataTypeTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetDimension() throws Exception {
		View targetView = dimensionTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetEnumeration() throws Exception {
		View targetView = enumerationTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetFlowSpecification() throws Exception {
		View targetView = flowSpecificationTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetInterface() throws Exception {
		View targetView = interfaceTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetPrimitiveType() throws Exception {
		View targetView = primitiveTypeTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetSignal() throws Exception {
		View targetView = signalTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetUnit() throws Exception {
		View targetView = unitTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetValueType() throws Exception {
		View targetView = valueTypeTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
		
	@Test
	public void createLinkWithTargetComment() throws Exception {
		View targetView = commentTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
		
	@Test
	public void createLinkWithTargetCommentCN() throws Exception {
		View targetView = commentCNTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
		
	@Test
	public void createLinkWithTargetConstraint() throws Exception {
		View targetView = constraintTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetConstraintCN() throws Exception {
		View targetView = constraintCNTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
		
	@Test
	public void createLinkWithTargetInstanceSpec() throws Exception {
		View targetView = instanceSpecTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
		
	@Test
	public void createLinkWithTargetInstanceSpecCN() throws Exception {
		View targetView = instanceSpecCNTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetModel() throws Exception {
		View targetView = modelTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetModelCN() throws Exception {
		View targetView = modelCNTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetPackage() throws Exception {
		View targetView = packageTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetPackageCN() throws Exception {
		View targetView = packageCNTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	// Test child label nodes
	
	@Test
	public void createLinkWithTargetSlot() throws Exception {
		View targetView = slotTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetProperty() throws Exception {
		View targetView = propertyTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetPort() throws Exception {
		View targetView = portTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetFlowPort() throws Exception {
		View targetView = flowportTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetPart() throws Exception {
		View targetView = partTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetReference() throws Exception {
		View targetView = referenceTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetValue() throws Exception {
		View targetView = valueTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetOperation() throws Exception {
		View targetView = operationTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetReception() throws Exception {
		View targetView = receptionTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetConstraintCLN() throws Exception {
		View targetView = constraintCLNTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetConstraintProperty() throws Exception {
		View targetView = constraintPropertyTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}

	@Test
	public void createLinkWithTargetAssociation() throws Exception {
		View targetView = associationTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	
	@Test
	public void createLinkWithTargetEnumerationLiteral() throws Exception {
		View targetView = enumerationLiteralTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
		System.out.println("I succeed for the test : createLinkWithTargetEnumerationLiteral");
	}
	
	@Test
	public void createLinkWithTargetFlowProperty() throws Exception {
		View targetView = flowPropertyTargetView;
		createEdgeFromPalette(toolID, sourceView, targetView, isCreationAllowed.get(targetView));
	}
	

}
