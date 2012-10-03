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
import org.eclipse.papyrus.diagram.tests.canonical.TestChildNode;
import org.eclipse.papyrus.infra.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.activity.CreateActivityDiagramCommand;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.junit.Test;


/**
 * The Class TestClassDiagramChildNode.
 */
public class TestActivityDiagramChildNode extends TestActivityChildNode {

	
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
	//merge Node
	//join Node
	//forkNode
	//activityParameterNode
	//DataStoreNode
	//callbehaviorAction
	//callOperationAction
	//SendObjectAction
	//SendSignalAction
	//AcceptEventAction
	//ValueSpecificationAction
	//ActivityPartition
	//InteruptibleActivityRegion
	//StructuredActivity
	//ReadSelfAction
	//ConditionalNode
	//ExpansionRegion
	//loopNode
	//sequenceNode
	//Activity
	//Create ObjectAction
	//readStructuralFeatureAction
	//readStructuralfeatureValueAction
	//DestroyObjectAction
	//ReadVariableAction
	//ReadVariableValueAction
	//BroadCastSignalAction
	//CentralBufferNode
	
	
	
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
