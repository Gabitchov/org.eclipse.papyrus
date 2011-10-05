package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getEditPart;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils.changeVisibility;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestUtils.createNodeFromPalette;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.AbstractTest;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.junit.Test;

/**
 * JUnit tests for element creation test (via palette tools) in diagram.
 */
public class TestNodeCreationOnDiagram extends AbstractTest {

	@Test // https://bugs.eclipse.org/bugs/show_bug.cgi?id=348549
	public void dropExceptionToFix_bug348549() throws Exception {
		
		View propertyView;
		View containerView;
		
		try {
			View elementView = TestPrepareUtils.createGraphicalNode(SysMLElementTypes.BLOCK, SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID, getDiagramView());
			containerView = ViewUtil.getChildBySemanticHint(elementView, SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID);
			if(containerView == null) {
				throw new Exception("Unable to prepare container for test.");
			}

			// Ensure the compartment is visible (required for EditPart to be found)
			if(!containerView.isVisible()) {
				changeVisibility(containerView);
			}
			
			propertyView = TestPrepareUtils.createGraphicalNode(UMLElementTypes.PROPERTY, UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_LABEL_ID, containerView);
			
		} catch (Exception e) {
			throw new Exception("Failure during test preparation.", e);
		}
		
		getEditPart(getDiagramView()).setFocus(true);
		getEditPart(propertyView).setFocus(true); // This should not throw the following exception
//		getEditPart(containerView).setFocus(true); // This should throw the following exception (assuming the owner does not have the focus).
//		java.lang.IllegalArgumentException: An EditPart has to be selectable (isSelectable() == true) in order to obtain focus.
//		at org.eclipse.core.runtime.Assert.isLegal(Assert.java:63)
//		at org.eclipse.gef.editparts.AbstractEditPart.setFocus(AbstractEditPart.java:1005)
//		at org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.link.TestLinkDropOnModel.dropDependency(TestLinkDropOnModel.java:71)
	}
	
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
