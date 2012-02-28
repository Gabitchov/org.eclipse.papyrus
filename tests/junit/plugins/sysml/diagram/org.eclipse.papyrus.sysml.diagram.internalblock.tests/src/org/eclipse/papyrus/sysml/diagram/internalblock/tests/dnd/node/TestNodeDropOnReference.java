/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.node;

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils.createElement;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils.createGraphicalNode;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestUtils.dropFromModelExplorer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.AbstractTest;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit tests for element Drop test (via palette tools) on Reference.
 */
public class TestNodeDropOnReference extends AbstractTest {

	public static View containerView;
	
	public static EObject containerPackage;

	@BeforeClass
	public static void prepareContainerForTest() throws Exception {
		try {
			// prepare container
			View blockView = ViewUtil.getChildBySemanticHint(getDiagramView(), SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID);
			View blockStructureView = ViewUtil.getChildBySemanticHint(blockView, SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID);
			containerView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
			if(containerView == null) {
				throw new Exception("Unable to prepare container for test.");
			}

			// prepare container package (getDiagramView references the shown Block).
			containerPackage = EMFCoreUtil.getContainer(getDiagramView().getElement(), UMLPackage.eINSTANCE.getPackage());
			
		} catch (Exception e) {
			throw new Exception("Unable to prepare container for test.", e);
		}
	}

	@Test
	public void testDropActorPart() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, containerPackage);
		EObject droppedElement = createElement(SysMLElementTypes.ACTOR_PART_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}
	
	@Test
	public void testDropActorPartContained() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.ACTOR_PART_PROPERTY, (EObject)containerView.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()));
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropPort() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, containerPackage);
		EObject droppedElement = createElement(UMLElementTypes.PORT, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}
	
	@Test
	public void testDropPortContained() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.PORT, (EObject)containerView.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()));
		dropFromModelExplorer(droppedElement, containerView, true);
	}
	
	@Test
	public void testDropFlowPort_IN() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK,containerPackage);
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PORT_IN, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}
	
	@Test
	public void testDropFlowPort_INContained() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PORT_IN, (EObject)containerView.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()));
		dropFromModelExplorer(droppedElement, containerView, true);
	}
	
	@Test
	public void testDropFlowPort_OUT() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, containerPackage);
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PORT_OUT, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}
	
	@Test
	public void testDropFlowPort_OUTContained() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PORT_OUT, (EObject)containerView.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()));
		dropFromModelExplorer(droppedElement, containerView, true);
	}
	
	@Test
	public void testDropFlowPort_INOUT() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, containerPackage);
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PORT_IN_OUT, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}
	
	@Test
	public void testDropFlowPort_INOUTContained() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PORT_IN_OUT, (EObject)containerView.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()));
		dropFromModelExplorer(droppedElement, containerView, true);
	}
	
	@Test
	public void testDropFlowPort_NA() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, containerPackage);
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PORT_NA, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}
	
	@Test
	public void testDropFlowPort_NAContained() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PORT_NA, (EObject)containerView.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()));
		dropFromModelExplorer(droppedElement, containerView, true);
	}
	
	@Test
	public void testDropPart() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, containerPackage);
		EObject droppedElement = createElement(SysMLElementTypes.PART_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}
	
	@Test
	public void testDropPartContained() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.PART_PROPERTY, (EObject)containerView.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()));
		dropFromModelExplorer(droppedElement, containerView, false);
	}
	
	@Test
	public void testDropProperty() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, containerPackage);
		EObject droppedElement = createElement(UMLElementTypes.PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}
	
	@Test
	public void testDropPropertyContained() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.PROPERTY, (EObject)containerView.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()));
		dropFromModelExplorer(droppedElement, containerView, false);
	}
	
	@Test
	public void testDropReference() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, containerPackage);
		EObject droppedElement = createElement(SysMLElementTypes.REFERENCE_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}
	
	@Test
	public void testDropReferenceContained() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.REFERENCE_PROPERTY, (EObject)containerView.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()));
		dropFromModelExplorer(droppedElement, containerView, false);
	}
	
	@Test
	public void testDropValue() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, containerPackage);
		EObject droppedElement = createElement(SysMLElementTypes.VALUE_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}
	
	@Test
	public void testDropValueContained() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.VALUE_PROPERTY, (EObject)containerView.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()));
		dropFromModelExplorer(droppedElement, containerView, false);
	}
	
	@Test
	public void testDropComment() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.COMMENT, containerPackage);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropCommentContained() throws Exception {
		dropFromModelExplorer(UMLElementTypes.COMMENT, containerView, false);
	}

	@Test
	public void testDropConstraint() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.CONSTRAINT, containerPackage);
		dropFromModelExplorer(droppedElement, containerView, false);
	}
}
