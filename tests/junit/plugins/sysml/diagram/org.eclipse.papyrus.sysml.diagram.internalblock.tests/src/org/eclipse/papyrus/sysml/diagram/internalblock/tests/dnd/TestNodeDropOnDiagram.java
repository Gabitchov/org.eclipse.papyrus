package org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd;

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils.createElement;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestUtils.dropFromModelExplorer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.AbstractTest;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.junit.Test;

/**
 * JUnit tests for element Drop test (via palette tools) in diagram.
 */
public class TestNodeDropOnDiagram extends AbstractTest {

	@Test
	public void testDropBlockInDiagram() throws Exception {
		dropFromModelExplorer(SysMLElementTypes.BLOCK, getDiagramView(), false);
	}

	@Test
	public void testDropPortInDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(UMLElementTypes.PORT, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}
	
	@Test
	public void testDropFlowPort_IN_InDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PORT_IN, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}
	
	@Test
	public void testDropFlowPort_OUT_InDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PORT_OUT, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}
	
	@Test
	public void testDropFlowPort_INOUT_InDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PORT_IN_OUT, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}
	
	@Test
	public void testDropFlowPort_NA_InDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PORT_NA, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}
	
	@Test
	public void testDropPartInDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.PART_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}
	
	@Test
	public void testDropReferenceInDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.REFERENCE_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}
	
	@Test
	public void testDropCommentInDiagram() throws Exception {
		dropFromModelExplorer(UMLElementTypes.COMMENT, getDiagramView(), true);
	}

	@Test
	public void testDropConstraintInDiagram() throws Exception {
		dropFromModelExplorer(UMLElementTypes.CONSTRAINT, getDiagramView(), true);
	}
}
