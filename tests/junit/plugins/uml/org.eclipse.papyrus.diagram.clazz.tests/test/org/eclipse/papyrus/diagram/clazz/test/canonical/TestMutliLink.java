/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.test.canonical;

import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.clazz.test.IClassDiagramTestsConstants;
import org.eclipse.papyrus.diagram.tests.canonical.AbstractTestMultiLink;
import org.eclipse.papyrus.uml.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.junit.Test;

public class TestMutliLink extends AbstractTestMultiLink {

	@Override
	protected CreateViewRequest createViewRequestShapeContainer() {
		// TODO Auto-generated method stub
		return CreateViewRequestFactory.getCreateShapeRequest(UMLElementTypes.Class_2008, getDiagramEditPart().getDiagramPreferencesHint());
	}

	@Override
	protected String getProjectName() {
		return IClassDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IClassDiagramTestsConstants.FILE_NAME;
	}

	/**
	 * Test to manage dependency.
	 */
	@Test
	public void testToManageMultiDependency() {
		testToManageMultiLink(UMLElementTypes.Dependency_4008, UMLElementTypes.Dependency_4018, true);
	}

	/**
	 * Test to manage multiassociation.
	 */
	@Test
	public void testToManageMultiAssociation() {
		testToManageMultiLink(UMLElementTypes.Association_4001, UMLElementTypes.Association_4019, false);
	}

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateClassDiagramCommand();
	}
}
