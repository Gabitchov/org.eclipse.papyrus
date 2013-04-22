/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.tests.canonical;

import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.activity.CreateActivityDiagramCommand;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Ignore;
import org.junit.Test;

/**
 * The Class TestClassDiagramChildNode.
 */
public class TestActivityDiagramChildNode extends AbstractTestActivityChildNode {

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageCentralBufferNode() {
		testToManageChildNode(UMLElementTypes.CentralBufferNode_3104, UMLPackage.eINSTANCE.getCentralBufferNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageOpaqueAction() {
		testToManageChildNode(UMLElementTypes.OpaqueAction_3007,  UMLPackage.eINSTANCE.getOpaqueAction(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage initialNode.
	 */
	@Test
	public void testToManageinitialNode() {
		testToManageChildNode(UMLElementTypes.InitialNode_3004,  UMLPackage.eINSTANCE.getInitialNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage finalNode.
	 */
	@Test
	public void testToManagefinalNode() {
		testToManageChildNode(UMLElementTypes.ActivityFinalNode_3005,  UMLPackage.eINSTANCE.getFinalNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage flow final.
	 */
	@Test
	public void testToManageflowfinal() {
		testToManageChildNode(UMLElementTypes.FlowFinalNode_3006,  UMLPackage.eINSTANCE.getFlowFinalNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageDecisionNode() {
		testToManageChildNode(UMLElementTypes.DecisionNode_3038,  UMLPackage.eINSTANCE.getDecisionNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage MergeNode
	 */
	@Test
	public void testToManageMergeNode() {
		testToManageChildNode(UMLElementTypes.MergeNode_3039,  UMLPackage.eINSTANCE.getMergeNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage.JoinNode
	 */
	@Test
	public void testToManageJoinNode() {
		testToManageChildNode(UMLElementTypes.JoinNode_3041,  UMLPackage.eINSTANCE.getJoinNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage ForkNode_3040
	 */
	@Test
	public void testToManageForkNode() {
		testToManageChildNode(UMLElementTypes.ForkNode_3040,  UMLPackage.eINSTANCE.getForkNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageDataStoreNode() {
		testToManageChildNode(UMLElementTypes.DataStoreNode_3078,  UMLPackage.eINSTANCE.getDataStoreNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageSendObjectAction() {
		testToManageChildNode(UMLElementTypes.SendObjectAction_3042,  UMLPackage.eINSTANCE.getSendObjectAction(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageAcceptEventAction() {
		testToManageChildNode(UMLElementTypes.AcceptEventAction_3063, UMLPackage.eINSTANCE.getAcceptEventAction(),  UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageValueSpecificationAction() {
		testToManageChildNode(UMLElementTypes.ValueSpecificationAction_3076, UMLPackage.eINSTANCE.getValueSpecificationAction(),  UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageActivityPartition() {
		testToManageChildNode(UMLElementTypes.ActivityPartition_3067,  UMLPackage.eINSTANCE.getActivityPartition(), UMLElementTypes.StructuredActivityNode_3065, false);
	}

	/**
	 * Test to manageInteruptibleActivityRegion.
	 */
	@Test
	public void testToManageInteruptibleActivityRegion() {
		testToManageChildNode(UMLElementTypes.InterruptibleActivityRegion_3068,  UMLPackage.eINSTANCE.getInterruptibleActivityRegion(), UMLElementTypes.StructuredActivityNode_3065, false);
	}

	/**
	 * Test to manageStructuredActivity.
	 */
	@Test
	public void testToManageStructuredActivity() {
		testToManageChildNode(UMLElementTypes.StructuredActivityNode_3065,  UMLPackage.eINSTANCE.getStructuredActivityNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage ReadSelfAction.
	 */
	@Test
	public void testToManageReadSelfAction() {
		testToManageChildNode(UMLElementTypes.ReadSelfAction_3081,  UMLPackage.eINSTANCE.getReadSelfAction(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageConditionalNode() {
		testToManageChildNode(UMLElementTypes.ConditionalNode_3069,  UMLPackage.eINSTANCE.getConditionalNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageExpansionRegion() {
		testToManageChildNode(UMLElementTypes.ExpansionRegion_3070,  UMLPackage.eINSTANCE.getExpansionRegion(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageloopNode() {
		testToManageChildNode(UMLElementTypes.LoopNode_3071,  UMLPackage.eINSTANCE.getLoopNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageSequenceNode() {
		testToManageChildNode(UMLElementTypes.SequenceNode_3073,  UMLPackage.eINSTANCE.getSequenceNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage Activity
	 */
	@Test
	public void testToManageActivity() {
		testToManageChildNode(UMLElementTypes.Activity_3083,  UMLPackage.eINSTANCE.getActivity(), UMLElementTypes.StructuredActivityNode_3065, false);
	}

	/**
	 * Test to manage readStructuralFeatureAction
	 */
	@Test
	public void testToManagereadStructuralFeatureAction() {
		testToManageChildNode(UMLElementTypes.ReadStructuralFeatureAction_3088, UMLPackage.eINSTANCE.getReadStructuralFeatureAction(),  UMLElementTypes.StructuredActivityNode_3065, true);
	}

	//readStructuralfeatureValueAction
	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManagereadStructuralfeatureValueAction() {
		//testToManageChildNode(UMLElementTypes.r, UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage DestroyObjectAction
	 */
	@Test
	public void testToManageDestroyObjectAction() {
		testToManageChildNode(UMLElementTypes.DestroyObjectAction_3095,  UMLPackage.eINSTANCE.getDestroyObjectAction(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage ReadVariableAction.
	 */
	@Test
	public void testToManageReadVariableAction() {
		testToManageChildNode(UMLElementTypes.ReadVariableAction_3097,  UMLPackage.eINSTANCE.getReadVariableAction(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	//ReadVariableValueAction
	/**
	 * Test to manageReadVariableValueAction.
	 */
	@Ignore
	@Test
	public void testToManageReadVariableValueAction() {
		//	testToManageChildNode(UMLElementTypes.ReadVariable, UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageBroadCastSignalAction() {
		testToManageChildNode(UMLElementTypes.BroadcastSignalAction_3102,  UMLPackage.eINSTANCE.getBroadcastSignalAction(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage CreateObjectAction.
	 */
	@Test
	public void testToManageCreateObjectAction() {
		testToManageChildNode(UMLElementTypes.CreateObjectAction_3086,  UMLPackage.eINSTANCE.getCreateObjectAction(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage AddVariableValueAction
	 */
	@Test
	public void testToManageAddVariableValueAction() {
		testToManageChildNode(UMLElementTypes.AddVariableValueAction_3099, UMLPackage.eINSTANCE.getAddVariableValueAction(), UMLElementTypes.Activity_3083, true);
	}

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateActivityDiagramCommand();
	}

	@Override
	protected CreateViewRequest createViewRequestShapeContainer() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean isSemanticTest() {
		return true;
	}
}
