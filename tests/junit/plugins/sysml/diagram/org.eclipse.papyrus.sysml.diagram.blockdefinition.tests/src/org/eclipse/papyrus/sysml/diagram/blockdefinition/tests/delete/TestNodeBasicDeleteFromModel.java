package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.delete;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils.dropFromModelExplorer;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestUtils.deleteElement;

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
public class TestNodeBasicDeleteFromModel extends AbstractTest {

	@Test
	public void testBasicDeleteFromModelActor() throws Exception {
		deleteElement(UMLElementTypes.ACTOR, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromDiagramActorPart() throws Exception {
		View intermediateContainer = dropFromModelExplorer(SysMLElementTypes.BLOCK, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID);
		View testedView = dropFromModelExplorer(SysMLElementTypes.ACTOR_PART_PROPERTY, compartment);
		deleteElement(testedView, true);
	}
	
	@Test
	public void testBasicDeleteFromModelBlock() throws Exception {
		deleteElement(SysMLElementTypes.BLOCK, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromModelComment() throws Exception {
		deleteElement(UMLElementTypes.COMMENT, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromModelConstraintBlock() throws Exception {
		deleteElement(SysMLElementTypes.CONSTRAINT_BLOCK, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromModelConstraint() throws Exception {
		deleteElement(UMLElementTypes.CONSTRAINT, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromModelConstraintProperty() throws Exception {
		View intermediateContainer = dropFromModelExplorer(SysMLElementTypes.CONSTRAINT_BLOCK, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, SysMLGraphicalTypes.COMPARTMENT_SYSML_CONSTRAINT_AS_LIST_ID);
		View testedView = dropFromModelExplorer(SysMLElementTypes.CONSTRAINT_PROPERTY, compartment);
		deleteElement(testedView, true);
	}

	@Test
	public void testBasicDeleteFromModelDataType() throws Exception {
		deleteElement(UMLElementTypes.DATA_TYPE, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromModelDimension() throws Exception {
		deleteElement(SysMLElementTypes.DIMENSION, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromModelEnumeration() throws Exception {
		deleteElement(UMLElementTypes.ENUMERATION, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromModelEnumerationLiteral() throws Exception {
		View intermediateContainer = dropFromModelExplorer(UMLElementTypes.ENUMERATION, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, UMLGraphicalTypes.COMPARTMENT_UML_ENUMERATIONLITERAL_AS_LIST_ID);
		View testedView = dropFromModelExplorer(UMLElementTypes.ENUMERATION_LITERAL, compartment);
		deleteElement(testedView, true);
	}

	@Test
	public void testBasicDeleteFromModelFlowPort() throws Exception {
		View intermediateContainer = dropFromModelExplorer(SysMLElementTypes.BLOCK, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID);
		View testedView = dropFromModelExplorer(SysMLElementTypes.FLOW_PORT, compartment);
		deleteElement(testedView, true);
	}

	@Test
	public void testBasicDeleteFromModelFlowProperty() throws Exception {
		View intermediateContainer = dropFromModelExplorer(SysMLElementTypes.FLOW_SPECIFICATION, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, SysMLGraphicalTypes.COMPARTMENT_SYSML_FLOWPROPERTY_AS_LIST_ID);
		View testedView = dropFromModelExplorer(SysMLElementTypes.FLOW_PROPERTY, compartment);
		deleteElement(testedView, true);
	}

	@Test
	public void testBasicDeleteFromModelFlowSpecification() throws Exception {
		deleteElement(SysMLElementTypes.FLOW_SPECIFICATION, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromModelInstanceSpecification() throws Exception {
		deleteElement(UMLElementTypes.INSTANCE_SPECIFICATION, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromModelInterface() throws Exception {
		deleteElement(UMLElementTypes.INTERFACE, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromModelModel() throws Exception {
		deleteElement(UMLElementTypes.MODEL, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromModelOperation() throws Exception {
		View intermediateContainer = dropFromModelExplorer(SysMLElementTypes.BLOCK, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, UMLGraphicalTypes.COMPARTMENT_UML_OPERATION_AS_LIST_ID);
		View testedView = dropFromModelExplorer(UMLElementTypes.OPERATION, compartment);
		deleteElement(testedView, true);
	}

	@Test
	public void testBasicDeleteFromModelPackage() throws Exception {
		deleteElement(UMLElementTypes.PACKAGE, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromModelPart() throws Exception {
		View intermediateContainer = dropFromModelExplorer(SysMLElementTypes.BLOCK, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID);
		View testedView = dropFromModelExplorer(SysMLElementTypes.PART_PROPERTY, compartment);
		deleteElement(testedView, true);
	}

	@Test
	public void testBasicDeleteFromModelPort() throws Exception {
		View intermediateContainer = dropFromModelExplorer(SysMLElementTypes.BLOCK, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID);
		View testedView = dropFromModelExplorer(UMLElementTypes.PORT, compartment);
		deleteElement(testedView, true);
	}

	@Test
	public void testBasicDeleteFromModelPrimitiveType() throws Exception {
		deleteElement(UMLElementTypes.PRIMITIVE_TYPE, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromModelProperty() throws Exception {
		View intermediateContainer = dropFromModelExplorer(UMLElementTypes.INTERFACE, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, UMLGraphicalTypes.COMPARTMENT_UML_PROPERTY_AS_LIST_ID);
		View testedView = dropFromModelExplorer(UMLElementTypes.PROPERTY, compartment);
		deleteElement(testedView, true);
	}

	@Test
	public void testBasicDeleteFromModelReception() throws Exception {
		View intermediateContainer = dropFromModelExplorer(SysMLElementTypes.BLOCK, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, UMLGraphicalTypes.COMPARTMENT_UML_OPERATION_AS_LIST_ID);
		View droppedElement = dropFromModelExplorer(UMLElementTypes.RECEPTION, compartment);
		deleteElement(droppedElement, true);
	}

	@Test
	public void testBasicDeleteFromModelReference() throws Exception {
		View intermediateContainer = dropFromModelExplorer(SysMLElementTypes.BLOCK, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID);
		View testedView = dropFromModelExplorer(SysMLElementTypes.REFERENCE_PROPERTY, compartment);
		deleteElement(testedView, true);
	}

	@Test
	public void testBasicDeleteFromModelSignal() throws Exception {
		deleteElement(UMLElementTypes.SIGNAL, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromModelSlot() throws Exception {
		View intermediateContainer = dropFromModelExplorer(UMLElementTypes.INSTANCE_SPECIFICATION, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, ElementTypes.INSTANCE_SPECIFICATION_COMPARTMENT_SLOT_HINT);
		View testedView = dropFromModelExplorer(UMLElementTypes.SLOT, compartment);
		deleteElement(testedView, true);
	}

	@Test
	public void testBasicDeleteFromModelUnit() throws Exception {
		deleteElement(SysMLElementTypes.UNIT, getDiagramView(), true);
	}

	@Test
	public void testBasicDeleteFromModelValue() throws Exception {
		View intermediateContainer = dropFromModelExplorer(SysMLElementTypes.BLOCK, getDiagramView());
		View compartment = ViewUtil.getChildBySemanticHint(intermediateContainer, SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID);
		View testedView = dropFromModelExplorer(SysMLElementTypes.VALUE_PROPERTY, compartment);
		deleteElement(testedView, true);
	}

	@Test
	public void testBasicDeleteFromModelValueType() throws Exception {
		deleteElement(SysMLElementTypes.VALUE_TYPE, getDiagramView(), true);
	}
}
