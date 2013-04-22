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
import org.junit.Ignore;
import org.junit.Test;


/**
 * The Class TestClassDiagramChildNode.
 */
public class TestActivityDiagramChildWithOtherCreationNode extends AbstractTestActivityChildwithOtherCreation {

	
	/**
	 * Test to manage callbehaviorAction
	 */
	@Test
	public void testToManageCallbehaviorAction() {
		testToManageChildNode(UMLElementTypes.CallBehaviorAction_3008, UMLElementTypes.StructuredActivityNode_3065, false);
	}
	/**
	 * Test to manage callOperationAction
	 */
	@Test
	public void testToManageCallOperationAction() {
		testToManageChildNode(UMLElementTypes.CallOperationAction_3010, UMLElementTypes.StructuredActivityNode_3065, false);
	}
	
	/**
	 * Test to manageDecision Node.
	 */
	@Test
	public void testToManageSendSignalAction() {
		testToManageChildNode(UMLElementTypes.SendSignalAction_3052, UMLElementTypes.StructuredActivityNode_3065, false);
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
