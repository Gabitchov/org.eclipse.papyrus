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
package org.eclipse.papyrus.uml.diagram.deployment.test.canonical;

import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.TestConstraintLink;
import org.eclipse.papyrus.uml.diagram.deployment.CreateDeploymentDiagramCommand;
import org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.deployment.test.IDeploymentDiagramTestsConstants;
import org.junit.Test;

public class TestDeploymentDiagramConstraintLink extends TestConstraintLink {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateDeploymentDiagramCommand();
	}

	@Override
	protected String getProjectName() {
		return IDeploymentDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IDeploymentDiagramTestsConstants.FILE_NAME;
	}
	
	/**
	 * Test to manage Constraint
	 */
	@Test
	public void testToManageConstraint() {
		testToManageLink(UMLElementTypes.Constraint_2005, UMLElementTypes.Package_2009, UMLElementTypes.ConstraintConstrainedElement_4009, UMLElementTypes.Package_2009, true);
	}
}
