package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestUtils.createFromPalette;

import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.AbstractTest;
import org.junit.Test;

/**
 * JUnit tests for element creation test (via palette tools) in diagram.
 */
public class TestNodeCreationOnDiagram extends AbstractTest {

	@Test
	public void testCreationActorInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.actor", getDiagramView(), true);
	}

	@Test
	public void testCreationBlockInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.block", getDiagramView(), true);
	}

	@Test
	public void testCreationCommentInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.comment", getDiagramView(), true);
	}

	@Test
	public void testCreationConstraintBlockInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.constraintblock", getDiagramView(), true);
	}

	@Test
	public void testCreationConstraintInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.constraint", getDiagramView(), true);
	}

	@Test
	public void testCreationConstraintPropertyInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.constraintproperty", getDiagramView(), false);
	}

	@Test
	public void testCreationDataTypeInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.datatype", getDiagramView(), true);
	}

	@Test
	public void testCreationDimensionInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.dimension", getDiagramView(), true);
	}

	@Test
	public void testCreationEnumerationInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.enumeration", getDiagramView(), true);
	}

	@Test
	public void testCreationEnumerationLiteralInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.enumerationliteral", getDiagramView(), false);
	}

	@Test
	public void testCreationFlowPortInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.flowport", getDiagramView(), false);
	}

	@Test
	public void testCreationFlowPropertyInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.flowproperty", getDiagramView(), false);
	}

	@Test
	public void testCreationFlowSpecificationInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.flowspecification", getDiagramView(), true);
	}

	@Test
	public void testCreationInstanceSpecificationInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.instancespecification", getDiagramView(), true);
	}

	@Test
	public void testCreationInterfaceInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.interface", getDiagramView(), true);
	}

	@Test
	public void testCreationModelInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.model", getDiagramView(), true);
	}

	@Test
	public void testCreationOperationInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.operation", getDiagramView(), false);
	}

	@Test
	public void testCreationPackageInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.package", getDiagramView(), true);
	}

	@Test
	public void testCreationPartInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.part", getDiagramView(), false);
	}

	@Test
	public void testCreationPortInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.port", getDiagramView(), false);
	}

	@Test
	public void testCreationPrimitiveTypeInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.primitivetype", getDiagramView(), true);
	}

	@Test
	public void testCreationPropertyInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.property", getDiagramView(), false);
	}

	@Test
	public void testCreationReceptionInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.reception", getDiagramView(), false);
	}

	@Test
	public void testCreationReferenceInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.reference", getDiagramView(), false);
	}

	@Test
	public void testCreationSignalInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.signal", getDiagramView(), true);
	}

	@Test
	public void testCreationSlotInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.slot", getDiagramView(), false);
	}

	@Test
	public void testCreationUnitInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.unit", getDiagramView(), true);
	}

	@Test
	public void testCreationValueInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.value", getDiagramView(), false);
	}

	@Test
	public void testCreationValueTypeInDiagram() throws Exception {
		createFromPalette("blockdefinition.tool.valuetype", getDiagramView(), true);
	}
}
