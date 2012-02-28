/*****************************************************************************
 * Copyright (c) 2011-2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils.createElement;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestUtils.dropFromModelExplorer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.AbstractTest;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.junit.Test;

/**
 * JUnit tests for element Drop test (via palette tools) in diagram.
 */
public class TestNodeDropOnDiagram extends AbstractTest {

	@Test
	public void testDropActorInDiagram() throws Exception {
		dropFromModelExplorer(UMLElementTypes.ACTOR, getDiagramView(), true);
	}

	@Test
	public void testDropActorPartInDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.ACTOR_PART_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}

	@Test
	public void testDropBlockInDiagram() throws Exception {
		dropFromModelExplorer(SysMLElementTypes.BLOCK, getDiagramView(), true);
	}

	@Test
	public void testDropCommentInDiagram() throws Exception {
		dropFromModelExplorer(UMLElementTypes.COMMENT, getDiagramView(), true);
	}

	@Test
	public void testDropConstraintBlockInDiagram() throws Exception {
		dropFromModelExplorer(SysMLElementTypes.CONSTRAINT_BLOCK, getDiagramView(), true);
	}

	@Test
	public void testDropConstraintInDiagram() throws Exception {
		dropFromModelExplorer(UMLElementTypes.CONSTRAINT, getDiagramView(), true);
	}

	@Test
	public void testDropConstraintPropertyInDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.CONSTRAINT_BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.CONSTRAINT_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}

	@Test
	public void testDropDataTypeInDiagram() throws Exception {
		dropFromModelExplorer(UMLElementTypes.DATA_TYPE, getDiagramView(), true);
	}

	@Test
	public void testDropDimensionInDiagram() throws Exception {
		dropFromModelExplorer(SysMLElementTypes.DIMENSION, getDiagramView(), true);
	}

	@Test
	public void testDropEnumerationInDiagram() throws Exception {
		dropFromModelExplorer(UMLElementTypes.ENUMERATION, getDiagramView(), true);
	}

	@Test
	public void testDropEnumerationLiteralInDiagram() throws Exception {
		EObject intermediateContainer = createElement(UMLElementTypes.ENUMERATION, getDiagramView());
		EObject droppedElement = createElement(UMLElementTypes.ENUMERATION_LITERAL, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}

	@Test
	public void testDropFlowPortInDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PORT, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}

	@Test
	public void testDropFlowPropertyInDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.FLOW_SPECIFICATION, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}

	@Test
	public void testDropFlowSpecificationInDiagram() throws Exception {
		dropFromModelExplorer(SysMLElementTypes.FLOW_SPECIFICATION, getDiagramView(), true);
	}

	@Test
	public void testDropInstanceSpecificationInDiagram() throws Exception {
		dropFromModelExplorer(UMLElementTypes.INSTANCE_SPECIFICATION, getDiagramView(), true);
	}

	@Test
	public void testDropInterfaceInDiagram() throws Exception {
		dropFromModelExplorer(UMLElementTypes.INTERFACE, getDiagramView(), true);
	}

	@Test
	public void testDropModelInDiagram() throws Exception {
		dropFromModelExplorer(UMLElementTypes.MODEL, getDiagramView(), true);
	}

	@Test
	public void testDropOperationInDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(UMLElementTypes.OPERATION, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}

	@Test
	public void testDropPackageInDiagram() throws Exception {
		dropFromModelExplorer(UMLElementTypes.PACKAGE, getDiagramView(), true);
	}

	@Test
	public void testDropPartInDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.PART_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}

	@Test
	public void testDropPortInDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(UMLElementTypes.PORT, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}

	@Test
	public void testDropPrimitiveTypeInDiagram() throws Exception {
		dropFromModelExplorer(UMLElementTypes.PRIMITIVE_TYPE, getDiagramView(), true);
	}

	@Test
	public void testDropPropertyInDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(UMLElementTypes.PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}

	@Test
	public void testDropReceptionInDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(UMLElementTypes.RECEPTION, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}

	@Test
	public void testDropReferenceInDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.REFERENCE_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}

	@Test
	public void testDropSignalInDiagram() throws Exception {
		dropFromModelExplorer(UMLElementTypes.SIGNAL, getDiagramView(), true);
	}

	@Test
	public void testDropSlotInDiagram() throws Exception {
		EObject intermediateContainer = createElement(UMLElementTypes.INSTANCE_SPECIFICATION, getDiagramView());
		EObject droppedElement = createElement(UMLElementTypes.SLOT, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}

	@Test
	public void testDropUnitInDiagram() throws Exception {
		dropFromModelExplorer(SysMLElementTypes.UNIT, getDiagramView(), true);
	}

	@Test
	public void testDropValueInDiagram() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.VALUE_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, getDiagramView(), false);
	}

	@Test
	public void testDropValueTypeInDiagram() throws Exception {
		dropFromModelExplorer(SysMLElementTypes.VALUE_TYPE, getDiagramView(), true);
	}
}
