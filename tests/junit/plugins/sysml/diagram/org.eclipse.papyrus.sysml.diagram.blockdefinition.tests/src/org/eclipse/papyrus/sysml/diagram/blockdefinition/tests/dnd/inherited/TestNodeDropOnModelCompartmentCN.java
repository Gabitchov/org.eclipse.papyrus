package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.inherited;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils.createElement;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestUtils.dropFromModelExplorer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.ElementTypes;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.AbstractTest;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit tests for element Drop test (via palette tools) on Model Compartment CN.
 */
public class TestNodeDropOnModelCompartmentCN extends AbstractTest {

	public static View containerView;

	@BeforeClass
	public static void prepareContainerForTest() throws Exception {
		try {
			View elementView = TestPrepareUtils.createGraphicalNode(UMLElementTypes.MODEL, ElementTypes.MODEL_CN.getSemanticHint(), getDiagramView());
			containerView = ViewUtil.getChildBySemanticHint(elementView, ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT);
			if(containerView == null) {
				throw new Exception("Unable to prepare container for test.");
			}
		} catch (Exception e) {
			throw new Exception("Unable to prepare container for test.", e);
		}
	}

	@Test
	public void testDropActor() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.ACTOR, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropActorContained() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.ACTOR, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, true);
	}

	@Test
	public void testDropActorPart() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.ACTOR_PART_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropBlock() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropBlockContained() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.BLOCK, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, true);
	}

	@Test
	public void testDropComment() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.COMMENT, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropCommentContained() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.COMMENT, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, true);
	}

	@Test
	public void testDropConstraintBlock() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.CONSTRAINT_BLOCK, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropConstraintBlockContained() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.CONSTRAINT_BLOCK, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, true);
	}

	@Test
	public void testDropConstraint() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.CONSTRAINT, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropConstraintContained() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.CONSTRAINT, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, true);
	}

	@Test
	public void testDropConstraintProperty() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.CONSTRAINT_BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.CONSTRAINT_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropDataType() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.DATA_TYPE, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropDataTypeContained() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.DATA_TYPE, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, true);
	}

	@Test
	public void testDropDimension() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.DIMENSION, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropDimensionContained() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.DIMENSION, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, true);
	}

	@Test
	public void testDropEnumeration() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.ENUMERATION, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropEnumerationContained() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.ENUMERATION, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, true);
	}

	@Test
	public void testDropEnumerationLiteral() throws Exception {
		EObject intermediateContainer = createElement(UMLElementTypes.ENUMERATION, getDiagramView());
		EObject droppedElement = createElement(UMLElementTypes.ENUMERATION_LITERAL, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropFlowPort() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PORT, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropFlowProperty() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.FLOW_SPECIFICATION, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropFlowSpecification() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_SPECIFICATION, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropFlowSpecificationContained() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_SPECIFICATION, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, true);
	}

	@Test
	public void testDropInstanceSpecification() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.INSTANCE_SPECIFICATION, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropInstanceSpecificationContained() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.INSTANCE_SPECIFICATION, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, true);
	}

	@Test
	public void testDropInterface() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.INTERFACE, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropInterfaceContained() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.INTERFACE, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, true);
	}

	@Test
	public void testDropModel() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.MODEL, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropModelContained() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.MODEL, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, true);
	}

	@Test
	public void testDropOperation() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(UMLElementTypes.OPERATION, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropPackage() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.PACKAGE, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropPackageContained() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.PACKAGE, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, true);
	}

	@Test
	public void testDropPart() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.PART_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropPort() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(UMLElementTypes.PORT, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropPrimitiveType() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.PRIMITIVE_TYPE, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropPrimitiveTypeContained() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.PRIMITIVE_TYPE, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, true);
	}

	@Test
	public void testDropProperty() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(UMLElementTypes.PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropReception() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(UMLElementTypes.RECEPTION, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropReference() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.REFERENCE_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropSignal() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.SIGNAL, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropSignalContained() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.SIGNAL, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, true);
	}

	@Test
	public void testDropSlot() throws Exception {
		EObject intermediateContainer = createElement(UMLElementTypes.INSTANCE_SPECIFICATION, getDiagramView());
		EObject droppedElement = createElement(UMLElementTypes.SLOT, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropUnit() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.UNIT, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropUnitContained() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.UNIT, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, true);
	}

	@Test
	public void testDropValue() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.VALUE_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropValueType() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.VALUE_TYPE, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropValueTypeContained() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.VALUE_TYPE, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, true);
	}
}
