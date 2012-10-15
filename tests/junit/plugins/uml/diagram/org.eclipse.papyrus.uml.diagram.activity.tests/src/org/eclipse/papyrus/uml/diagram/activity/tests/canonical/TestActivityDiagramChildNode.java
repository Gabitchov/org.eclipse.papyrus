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
import org.junit.Test;


/**
 * The Class TestClassDiagramChildNode.
 */
public class TestActivityDiagramChildNode extends AbstractTestActivityChildNode {

	
	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageOpaqueAction() {
		testToManageChildNode(UMLElementTypes.OpaqueAction_3007, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	
	/**
	 * Test to manage initialNode.
	 */
	@Test
	public void testToManageinitialNode() {
		testToManageChildNode(UMLElementTypes.InitialNode_3004, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	/**
	 * Test to manage finalNode.
	 */
	@Test
	public void testToManagefinalNode() {
		testToManageChildNode(UMLElementTypes.ActivityFinalNode_3005, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	
	/**
	 * Test to manage flow final.
	 */
	@Test
	public void testToManageflowfinal() {
		testToManageChildNode(UMLElementTypes.FlowFinalNode_3006, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	
	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageDecisionNode() {
		testToManageChildNode(UMLElementTypes.DecisionNode_3038, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	
	
	/**
	 * Test to manage MergeNode
	 */
	@Test
	public void testToManageMergeNode() {
		testToManageChildNode(UMLElementTypes.MergeNode_3039, UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage.JoinNode
	 */
	@Test
	public void testToManageJoinNode() {
		testToManageChildNode(UMLElementTypes.JoinNode_3041, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	/**
	 * Test to manage ForkNode_3040
	 */
	@Test
	public void testToManageForkNode() {
		testToManageChildNode(UMLElementTypes.ForkNode_3040, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageDataStoreNode() {
		testToManageChildNode(UMLElementTypes.DataStoreNode_3078, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	
	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageSendObjectAction() {
		testToManageChildNode(UMLElementTypes.SendObjectAction_3042, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageSendSignalAction() {
		testToManageChildNode(UMLElementTypes.SendSignalAction_3052, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageAcceptEventAction() {
		testToManageChildNode(UMLElementTypes.AcceptEventAction_3063, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageValueSpecificationAction() {
		testToManageChildNode(UMLElementTypes.ValueSpecificationAction_3076, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageActivityPartition() {
		testToManageChildNode(UMLElementTypes.ActivityPartition_3067, UMLElementTypes.StructuredActivityNode_3065, false);
	}
	/**
	 * Test to manageInteruptibleActivityRegion.
	 */
	@Test
	public void testToManageInteruptibleActivityRegion() {
		testToManageChildNode(UMLElementTypes.InterruptibleActivityRegion_3068, UMLElementTypes.StructuredActivityNode_3065, false);
	}
	/**
	 * Test to manageStructuredActivity.
	 */
	@Test
	public void testToManageStructuredActivity() {
		testToManageChildNode(UMLElementTypes.StructuredActivityNode_3065, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	/**
	 * Test to manage ReadSelfAction.
	 */
	@Test
	public void testToManageReadSelfAction() {
		testToManageChildNode(UMLElementTypes.ReadSelfAction_3081, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageConditionalNode() {
		testToManageChildNode(UMLElementTypes.ConditionalNode_3069, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageExpansionRegion() {
		testToManageChildNode(UMLElementTypes.ExpansionRegion_3070, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageloopNode() {
		testToManageChildNode(UMLElementTypes.LoopNode_3071, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageSequenceNode() {
		testToManageChildNode(UMLElementTypes.SequenceNode_3073, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	/**
	 * Test to manage Activity
	 */
	@Test
	public void testToManageActivity() {
		testToManageChildNode(UMLElementTypes.Activity_3083, UMLElementTypes.StructuredActivityNode_3065, false);
	}
	//Create ObjectAction
	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageObjectAction() {
		testToManageChildNode(UMLElementTypes.CreateObjectAction_3086, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	/**
	 * Test to manage readStructuralFeatureAction
	 */
	@Test
	public void testToManagereadStructuralFeatureAction() {
		testToManageChildNode(UMLElementTypes.ReadStructuralFeatureAction_3088, UMLElementTypes.StructuredActivityNode_3065, true);
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
		testToManageChildNode(UMLElementTypes.DestroyObjectAction_3095, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	/**
	 * Test to manage ReadVariableAction.
	 */
	@Test
	public void testToManageReadVariableAction() {
		testToManageChildNode(UMLElementTypes.ReadVariableAction_3097, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	//ReadVariableValueAction
	/**
	 * Test to manageReadVariableValueAction.
	 */
	@Test
	public void testToManageReadVariableValueAction() {
	//	testToManageChildNode(UMLElementTypes.ReadVariable, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageBroadCastSignalAction() {
		testToManageChildNode(UMLElementTypes.BroadcastSignalAction_3102, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageCentralBufferNode() {
		testToManageChildNode(UMLElementTypes.CentralBufferNode_3104, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	
	/**
	 * Test to manage CreateObjectAction.
	 */
	@Test
	public void testToManageCreateObjectAction() {
		testToManageChildNode(UMLElementTypes.CreateObjectAction_3086, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	
	/**
	 * Test to manage AddVariableValueAction
	 */
	@Test
	public void testToManageAddVariableValueAction() {
		testToManageChildNode(UMLElementTypes.AddVariableValueAction_3099, UMLElementTypes.StructuredActivityNode_3065, true);
	}
	
	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return  new CreateActivityDiagramCommand();
	}

	@Override
	protected CreateViewRequest createViewRequestShapeContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
