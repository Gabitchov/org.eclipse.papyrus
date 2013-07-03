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
import org.junit.Ignore;
import org.junit.Test;


/**
 * The Class TestClassDiagramChildNode.
 */
public class TestActivityDiagramChildWithOtherCreationNode extends AbstractTestActivityChildNode {

	@Override
	protected String getProjectName() {
		return IActivityDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IActivityDiagramTestsConstants.FILE_NAME;
	}
	
	/**
	 * Test to manage callbehaviorAction
	 */
	@Test
	@Ignore
	public void testToManageCallbehaviorAction() {
		testToManageNode(UMLElementTypes.CallBehaviorAction_3008, UMLPackage.eINSTANCE.getCallBehaviorAction(), UMLElementTypes.StructuredActivityNode_3065, false);
	}
	/**
	 * Test to manage callOperationAction
	 */
	@Ignore
	@Test
	public void testToManageCallOperationAction() {
		testToManageNode(UMLElementTypes.CallOperationAction_3010, UMLPackage.eINSTANCE.getCallOperationAction(), UMLElementTypes.StructuredActivityNode_3065, false);
	}
	
	/**
	 * Test to manage SendSignalAction Node.
	 */
	@Ignore
	@Test
	public void testToManageSendSignalAction() {
		testToManageNode(UMLElementTypes.SendSignalAction_3052, UMLPackage.eINSTANCE.getSendSignalAction(), UMLElementTypes.StructuredActivityNode_3065, false);
	}
	
	/**
	 * Test to SendObjectAction Node.
	 */
	@Test
	public void testToManageSendObjectAction() {
		testToManageNode(UMLElementTypes.SendObjectAction_3042, UMLPackage.eINSTANCE.getSendObjectAction(), UMLElementTypes.StructuredActivityNode_3065, false);
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected CreateViewRequest createViewRequestShapeContainer() {
		return null;
	}

	
}
