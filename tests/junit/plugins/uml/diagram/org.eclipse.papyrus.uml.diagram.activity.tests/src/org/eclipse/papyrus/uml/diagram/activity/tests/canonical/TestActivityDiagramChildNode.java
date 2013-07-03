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
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.activity.tests.IActivityDiagramTestsConstants;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;

/**
 * The Class TestClassDiagramChildNode.
 */
public class TestActivityDiagramChildNode extends AbstractTestActivityChildNode {

	@Override
	protected String getProjectName() {
		return IActivityDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IActivityDiagramTestsConstants.FILE_NAME;
	}
	
	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageCentralBufferNode() {
		testToManageNode(UMLElementTypes.CentralBufferNode_3104, UMLPackage.eINSTANCE.getCentralBufferNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageOpaqueAction() {
		testToManageNode(UMLElementTypes.OpaqueAction_3007,  UMLPackage.eINSTANCE.getOpaqueAction(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage initialNode.
	 */
	@Test
	public void testToManageInitialNode() {
		testToManageNode(UMLElementTypes.InitialNode_3004,  UMLPackage.eINSTANCE.getInitialNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage finalNode.
	 */
	@Test
	public void testToManageActivityFinalNode() {
		testToManageNode(UMLElementTypes.ActivityFinalNode_3005,  UMLPackage.eINSTANCE.getActivityFinalNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage flow final.
	 */
	@Test
	public void testToManageFlowFinalNode() {
		testToManageNode(UMLElementTypes.FlowFinalNode_3006,  UMLPackage.eINSTANCE.getFlowFinalNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageDecisionNode() {
		testToManageNode(UMLElementTypes.DecisionNode_3038,  UMLPackage.eINSTANCE.getDecisionNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage MergeNode
	 */
	@Test
	public void testToManageMergeNode() {
		testToManageNode(UMLElementTypes.MergeNode_3039,  UMLPackage.eINSTANCE.getMergeNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage.JoinNode
	 */
	@Test
	public void testToManageJoinNode() {
		testToManageNode(UMLElementTypes.JoinNode_3041,  UMLPackage.eINSTANCE.getJoinNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage ForkNode_3040
	 */
	@Test
	public void testToManageForkNode() {
		testToManageNode(UMLElementTypes.ForkNode_3040,  UMLPackage.eINSTANCE.getForkNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageDataStoreNode() {
		testToManageNode(UMLElementTypes.DataStoreNode_3078,  UMLPackage.eINSTANCE.getDataStoreNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageSendObjectAction() {
		testToManageNode(UMLElementTypes.SendObjectAction_3042,  UMLPackage.eINSTANCE.getSendObjectAction(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageAcceptEventAction() {
		testToManageNode(UMLElementTypes.AcceptEventAction_3063, UMLPackage.eINSTANCE.getAcceptEventAction(),  UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageValueSpecificationAction() {
		testToManageNode(UMLElementTypes.ValueSpecificationAction_3076, UMLPackage.eINSTANCE.getValueSpecificationAction(),  UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageActivityPartition() {
		testToManageNode(UMLElementTypes.ActivityPartition_3067,  UMLPackage.eINSTANCE.getActivityPartition(), UMLElementTypes.StructuredActivityNode_3065, false);
	}

	/**
	 * Test to manageInteruptibleActivityRegion.
	 */
	@Test
	public void testToManageInteruptibleActivityRegion() {
		testToManageNode(UMLElementTypes.InterruptibleActivityRegion_3068,  UMLPackage.eINSTANCE.getInterruptibleActivityRegion(), UMLElementTypes.StructuredActivityNode_3065, false);
	}

	/**
	 * Test to manageStructuredActivity.
	 */
	@Test
	public void testToManageStructuredActivity() {
		testToManageNode(UMLElementTypes.StructuredActivityNode_3065,  UMLPackage.eINSTANCE.getStructuredActivityNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage ReadSelfAction.
	 */
	@Test
	public void testToManageReadSelfAction() {
		testToManageNode(UMLElementTypes.ReadSelfAction_3081,  UMLPackage.eINSTANCE.getReadSelfAction(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageConditionalNode() {
		testToManageNode(UMLElementTypes.ConditionalNode_3069,  UMLPackage.eINSTANCE.getConditionalNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageExpansionRegion() {
		testToManageNode(UMLElementTypes.ExpansionRegion_3070,  UMLPackage.eINSTANCE.getExpansionRegion(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageloopNode() {
		testToManageNode(UMLElementTypes.LoopNode_3071,  UMLPackage.eINSTANCE.getLoopNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageSequenceNode() {
		testToManageNode(UMLElementTypes.SequenceNode_3073,  UMLPackage.eINSTANCE.getSequenceNode(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage Activity
	 */
	@Test
	public void testToManageActivity() {
		testToManageNode(UMLElementTypes.Activity_3083,  UMLPackage.eINSTANCE.getActivity(), UMLElementTypes.StructuredActivityNode_3065, false);
	}

	/**
	 * Test to manage readStructuralFeatureAction
	 */
	@Test
	public void testToManageReadStructuralFeatureAction() {
		testToManageNode(UMLElementTypes.ReadStructuralFeatureAction_3088, UMLPackage.eINSTANCE.getReadStructuralFeatureAction(),  UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage DestroyObjectAction
	 */
	@Test
	public void testToManageDestroyObjectAction() {
		testToManageNode(UMLElementTypes.DestroyObjectAction_3095,  UMLPackage.eINSTANCE.getDestroyObjectAction(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage ReadVariableAction.
	 */
	@Test
	public void testToManageReadVariableAction() {
		testToManageNode(UMLElementTypes.ReadVariableAction_3097,  UMLPackage.eINSTANCE.getReadVariableAction(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageBroadCastSignalAction() {
		testToManageNode(UMLElementTypes.BroadcastSignalAction_3102,  UMLPackage.eINSTANCE.getBroadcastSignalAction(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage CreateObjectAction.
	 */
	@Test
	public void testToManageCreateObjectAction() {
		testToManageNode(UMLElementTypes.CreateObjectAction_3086,  UMLPackage.eINSTANCE.getCreateObjectAction(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * Test to manage AddVariableValueAction
	 */
	@Test
	public void testToManageAddVariableValueAction() {
		testToManageNode(UMLElementTypes.AddVariableValueAction_3099, UMLPackage.eINSTANCE.getAddVariableValueAction(), UMLElementTypes.StructuredActivityNode_3065, true);
	}

	/**
	 * {@inheritDoc}
	 */
	protected CreateViewRequest createViewRequestShapeContainer() {
		// no container, it should be created on the main activity, not the diagram edit part
		return null;
	}

}
