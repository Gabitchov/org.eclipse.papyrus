package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestUtils.createNodeFromPalette;

import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.AbstractTest;
import org.junit.Test;

/**
 * JUnit tests for element creation test (via palette tools) in diagram.
 */
public class TestNodeCreationOnDiagram extends AbstractTest {

	@Test
	public void testCreationActorInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.actor", getDiagramView(), true);
	}

	@Test
	public void testCreationBlockInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.block", getDiagramView(), true);
	}

	@Test
	public void testCreationCommentInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.comment", getDiagramView(), true);
	}

	@Test
	public void testCreationConstraintBlockInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.constraintblock", getDiagramView(), true);
	}

	@Test
	public void testCreationConstraintInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.constraint", getDiagramView(), true);
	}

	@Test
	public void testCreationConstraintPropertyInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.constraintproperty", getDiagramView(), false);
	}

	@Test
	public void testCreationDataTypeInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.datatype", getDiagramView(), true);
	}

	@Test
	public void testCreationDimensionInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.dimension", getDiagramView(), true);
	}

	@Test
	public void testCreationEnumerationInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.enumeration", getDiagramView(), true);
	}

	@Test
	public void testCreationEnumerationLiteralInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.enumerationliteral", getDiagramView(), false);
	}

	@Test
	public void testCreationFlowPortInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.flowport", getDiagramView(), false);
	}

	@Test
	public void testCreationFlowPropertyInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.flowproperty", getDiagramView(), false);
	}

	@Test
	public void testCreationFlowSpecificationInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.flowspecification", getDiagramView(), true);
	}

	@Test
	public void testCreationInstanceSpecificationInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.instancespecification", getDiagramView(), true);
	}

	@Test
	public void testCreationInterfaceInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.interface", getDiagramView(), true);
	}

	@Test
	public void testCreationModelInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.model", getDiagramView(), true);
	}

	@Test
	public void testCreationOperationInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.operation", getDiagramView(), false);
	}

	@Test
	public void testCreationPackageInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.package", getDiagramView(), true);
	}

	@Test
	public void testCreationPartInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.part", getDiagramView(), false);
	}

	@Test
	public void testCreationPortInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.port", getDiagramView(), false);
	}

	@Test
	public void testCreationPrimitiveTypeInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.primitivetype", getDiagramView(), true);
	}

	@Test
	public void testCreationPropertyInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.property", getDiagramView(), false);
	}

	@Test
	public void testCreationReceptionInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.reception", getDiagramView(), false);
	}

	@Test
	public void testCreationReferenceInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.reference", getDiagramView(), false);
	}

	@Test
	public void testCreationSignalInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.signal", getDiagramView(), true);
	}

	@Test
	public void testCreationSlotInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.slot", getDiagramView(), false);
	}

	@Test
	public void testCreationUnitInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.unit", getDiagramView(), true);
	}

	@Test
	public void testCreationValueInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.value", getDiagramView(), false);
	}

	@Test
	public void testCreationValueTypeInDiagram() throws Exception {
		createNodeFromPalette("blockdefinition.tool.valuetype", getDiagramView(), true);
	}
}
