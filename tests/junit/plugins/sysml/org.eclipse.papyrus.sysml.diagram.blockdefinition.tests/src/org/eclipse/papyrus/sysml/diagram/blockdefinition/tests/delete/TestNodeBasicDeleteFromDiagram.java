package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.delete;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils.dropFromModelExplorer;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestUtils.deleteView;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.ElementTypes;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.AbstractTest;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.junit.Test;

/**
 * JUnit tests for element Delete test (via palette tools) in diagram.
 */
public class TestNodeBasicDeleteFromDiagram extends AbstractTest {

	@Test
	public void testBasicDeleteFromDiagramActor() throws Exception {
		deleteView(UMLElementTypes.ACTOR, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromDiagramBlock() throws Exception {
		deleteView(SysMLElementTypes.BLOCK, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromDiagramComment() throws Exception {
		deleteView(UMLElementTypes.COMMENT, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromDiagramConstraintBlock() throws Exception {
		deleteView(SysMLElementTypes.CONSTRAINT_BLOCK, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromDiagramConstraint() throws Exception {
		deleteView(UMLElementTypes.CONSTRAINT, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromDiagramConstraintProperty() throws Exception {
		View intermediateContainer = dropFromModelExplorer(SysMLElementTypes.CONSTRAINT_BLOCK, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, SysMLGraphicalTypes.COMPARTMENT_SYSML_CONSTRAINT_AS_LIST_ID);
		View testedView = dropFromModelExplorer(SysMLElementTypes.CONSTRAINT_PROPERTY, compartment);
		deleteView(testedView, true);
	}

	@Test
	public void testBasicDeleteFromDiagramDataType() throws Exception {
		deleteView(UMLElementTypes.DATA_TYPE, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromDiagramDimension() throws Exception {
		deleteView(SysMLElementTypes.DIMENSION, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromDiagramEnumeration() throws Exception {
		deleteView(UMLElementTypes.ENUMERATION, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromDiagramEnumerationLiteral() throws Exception {
		View intermediateContainer = dropFromModelExplorer(UMLElementTypes.ENUMERATION, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, UMLGraphicalTypes.COMPARTMENT_UML_ENUMERATIONLITERAL_AS_LIST_ID);
		View testedView = dropFromModelExplorer(UMLElementTypes.ENUMERATION_LITERAL, compartment);
		deleteView(testedView, true);
	}

	@Test
	public void testBasicDeleteFromDiagramFlowPort() throws Exception {
		View intermediateContainer = dropFromModelExplorer(SysMLElementTypes.BLOCK, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID);
		View testedView = dropFromModelExplorer(SysMLElementTypes.FLOW_PORT, compartment);
		deleteView(testedView, true);
	}

	@Test
	public void testBasicDeleteFromDiagramFlowProperty() throws Exception {
		View intermediateContainer = dropFromModelExplorer(SysMLElementTypes.FLOW_SPECIFICATION, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, SysMLGraphicalTypes.COMPARTMENT_SYSML_FLOWPROPERTY_AS_LIST_ID);
		View testedView = dropFromModelExplorer(SysMLElementTypes.FLOW_PROPERTY, compartment);
		deleteView(testedView, true);
	}

	@Test
	public void testBasicDeleteFromDiagramFlowSpecification() throws Exception {
		deleteView(SysMLElementTypes.FLOW_SPECIFICATION, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromDiagramInstanceSpecification() throws Exception {
		deleteView(UMLElementTypes.INSTANCE_SPECIFICATION, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromDiagramInterface() throws Exception {
		deleteView(UMLElementTypes.INTERFACE, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromDiagramModel() throws Exception {
		deleteView(UMLElementTypes.MODEL, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromDiagramOperation() throws Exception {
		View intermediateContainer = dropFromModelExplorer(SysMLElementTypes.BLOCK, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, UMLGraphicalTypes.COMPARTMENT_UML_OPERATION_AS_LIST_ID);
		View testedView = dropFromModelExplorer(UMLElementTypes.OPERATION, compartment);
		deleteView(testedView, true);
	}

	@Test
	public void testBasicDeleteFromDiagramPackage() throws Exception {
		deleteView(UMLElementTypes.PACKAGE, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromDiagramPart() throws Exception {
		View intermediateContainer = dropFromModelExplorer(SysMLElementTypes.BLOCK, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID);
		View testedView = dropFromModelExplorer(SysMLElementTypes.PART_PROPERTY, compartment);
		deleteView(testedView, true);
	}

	@Test
	public void testBasicDeleteFromDiagramPort() throws Exception {
		View intermediateContainer = dropFromModelExplorer(SysMLElementTypes.BLOCK, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID);
		View testedView = dropFromModelExplorer(UMLElementTypes.PORT, compartment);
		deleteView(testedView, true);
	}

	@Test
	public void testBasicDeleteFromDiagramPrimitiveType() throws Exception {
		deleteView(UMLElementTypes.PRIMITIVE_TYPE, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromDiagramProperty() throws Exception {
		View intermediateContainer = dropFromModelExplorer(UMLElementTypes.INTERFACE, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, UMLGraphicalTypes.COMPARTMENT_UML_PROPERTY_AS_LIST_ID);
		View testedView = dropFromModelExplorer(UMLElementTypes.PROPERTY, compartment);
		deleteView(testedView, true);
	}

	@Test
	public void testBasicDeleteFromDiagramReception() throws Exception {
		View intermediateContainer = dropFromModelExplorer(SysMLElementTypes.BLOCK, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, UMLGraphicalTypes.COMPARTMENT_UML_OPERATION_AS_LIST_ID);
		View droppedElement = dropFromModelExplorer(UMLElementTypes.RECEPTION, compartment);
		deleteView(droppedElement, true);
	}

	@Test
	public void testBasicDeleteFromDiagramReference() throws Exception {
		View intermediateContainer = dropFromModelExplorer(SysMLElementTypes.BLOCK, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID);
		View testedView = dropFromModelExplorer(SysMLElementTypes.REFERENCE_PROPERTY, compartment);
		deleteView(testedView, true);
	}

	@Test
	public void testBasicDeleteFromDiagramSignal() throws Exception {
		deleteView(UMLElementTypes.SIGNAL, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromDiagramSlot() throws Exception {
		View intermediateContainer = dropFromModelExplorer(UMLElementTypes.INSTANCE_SPECIFICATION, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, ElementTypes.INSTANCE_SPECIFICATION_COMPARTMENT_SLOT_HINT);
		View testedView = dropFromModelExplorer(UMLElementTypes.SLOT, compartment);
		deleteView(testedView, true);
	}

	@Test
	public void testBasicDeleteFromDiagramUnit() throws Exception {
		deleteView(SysMLElementTypes.UNIT, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromDiagramValue() throws Exception {
		View intermediateContainer = dropFromModelExplorer(SysMLElementTypes.BLOCK, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID);
		View testedView = dropFromModelExplorer(SysMLElementTypes.VALUE_PROPERTY, compartment);
		deleteView(testedView, true);
	}

	@Test
	public void testBasicDeleteFromDiagramValueType() throws Exception {
		deleteView(SysMLElementTypes.VALUE_TYPE, getDiagramView(), true);
	}
}
