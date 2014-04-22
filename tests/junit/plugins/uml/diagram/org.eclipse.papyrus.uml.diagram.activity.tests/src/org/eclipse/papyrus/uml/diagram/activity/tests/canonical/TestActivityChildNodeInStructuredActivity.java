/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.papyrus.junit.utils.classification.FailingTest;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.activity.tests.IActivityDiagramTestsConstants;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;


public class TestActivityChildNodeInStructuredActivity extends AbstractTestActivityChildNode {

	@Override
	protected String getProjectName() {
		return IActivityDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IActivityDiagramTestsConstants.FILE_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CreateViewRequest createViewRequestShapeContainer() {
		return CreateViewRequestFactory.getCreateShapeRequest(UMLElementTypes.StructuredActivityNode_3065, getDiagramEditPart().getDiagramPreferencesHint());
	}

	/**
	 * Test to manage opaque action.
	 */
	@FailingTest("Bug 425578, 431573")
	@Test
	public void testToManageOpaqueAction() {
		testToManageNode(UMLElementTypes.OpaqueAction_3007, UMLPackage.eINSTANCE.getOpaqueAction(), UMLElementTypes.StructuredActivityNode_3065, false);
	}
}
