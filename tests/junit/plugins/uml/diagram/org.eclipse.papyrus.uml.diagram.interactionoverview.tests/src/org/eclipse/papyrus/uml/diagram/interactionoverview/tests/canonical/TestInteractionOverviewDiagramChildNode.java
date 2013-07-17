/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.tests.canonical;

import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.interactionoverview.InteractionOverviewDiagramCreateCommand;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Before;
import org.junit.Test;

public class TestInteractionOverviewDiagramChildNode extends AbstractInteractionOverviewDiagramTestCase {

	@Before
	@Override
	protected void setUp() throws Exception {
		projectCreation();
		createActivity();

		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 1);
		GraphicalEditPart containerEditPart = (GraphicalEditPart)getDiagramEditPart().getChildren().get(0);
		rootCompartment = null;
		int index = 0;
		while(rootCompartment == null && index < containerEditPart.getChildren().size()) {
			if((containerEditPart.getChildren().get(index)) instanceof ShapeCompartmentEditPart) {
				rootCompartment = (ShapeCompartmentEditPart)(containerEditPart.getChildren().get(index));
			}
			index++;
		}

	}

	@Override
	protected CreateViewRequest createViewRequestShapeContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new InteractionOverviewDiagramCreateCommand();
	}

	@Test
	public void testToManageCallBehaviorAction() {
		testToManageNode(UMLElementTypes.CallBehaviorAction_3008, UMLPackage.eINSTANCE.getCallBehaviorAction(), UMLElementTypes.StructuredActivityNode_3065, false);
	}

	@Test
	public void testToManageInitialNode() {
		testToManageNode(UMLElementTypes.InitialNode_3004, UMLPackage.eINSTANCE.getInitialNode(), UMLElementTypes.StructuredActivityNode_3065, false);
	}

	@Test
	public void testToManageActivityFinalNode() {
		testToManageNode(UMLElementTypes.ActivityFinalNode_3005, UMLPackage.eINSTANCE.getActivityFinalNode(), UMLElementTypes.StructuredActivityNode_3065, false);
	}

	@Test
	public void testToManageDecisionNode() {
		testToManageNode(UMLElementTypes.DecisionNode_3038, UMLPackage.eINSTANCE.getDecisionNode(), UMLElementTypes.StructuredActivityNode_3065, false);
	}

	@Test
	public void testToManageFlowFinalNode() {
		testToManageNode(UMLElementTypes.FlowFinalNode_3006, UMLPackage.eINSTANCE.getFlowFinalNode(), UMLElementTypes.StructuredActivityNode_3065, false);
	}

	@Test
	public void testToManageForkNode() {
		testToManageNode(UMLElementTypes.ForkNode_3040, UMLPackage.eINSTANCE.getForkNode(), UMLElementTypes.StructuredActivityNode_3065, false);
	}

	@Test
	public void testToManageJoinNode() {
		testToManageNode(UMLElementTypes.JoinNode_3041, UMLPackage.eINSTANCE.getJoinNode(), UMLElementTypes.StructuredActivityNode_3065, false);
	}

	@Test
	public void testToManageMergeNode() {
		testToManageNode(UMLElementTypes.MergeNode_3039, UMLPackage.eINSTANCE.getMergeNode(), UMLElementTypes.StructuredActivityNode_3065, false);
	}

	@Test
	public void testToManageConditionalNode() {
		testToManageNode(UMLElementTypes.ConditionalNode_3069, UMLPackage.eINSTANCE.getConditionalNode(), UMLElementTypes.StructuredActivityNode_3065, false);
	}

	@Test
	public void testToManageLoopNode() {
		testToManageNode(UMLElementTypes.LoopNode_3071, UMLPackage.eINSTANCE.getLoopNode(), UMLElementTypes.StructuredActivityNode_3065, false);
	}

	@Test
	public void testToManageSequenceNode() {
		testToManageNode(UMLElementTypes.SequenceNode_3073, UMLPackage.eINSTANCE.getSequenceNode(), UMLElementTypes.StructuredActivityNode_3065, false);
	}
}
