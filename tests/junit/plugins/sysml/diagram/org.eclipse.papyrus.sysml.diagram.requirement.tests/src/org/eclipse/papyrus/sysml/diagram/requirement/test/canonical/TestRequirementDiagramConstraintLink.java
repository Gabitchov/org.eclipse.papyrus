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
package org.eclipse.papyrus.sysml.diagram.requirement.test.canonical;

import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.TestConstraintLink;
import org.eclipse.papyrus.sysml.diagram.requirement.RequirementDiagramCreateCommand;
import org.eclipse.papyrus.sysml.diagram.requirement.provider.ElementTypes;
import org.eclipse.papyrus.sysml.diagram.requirement.test.IRequirementDiagramTestsConstants;
import org.junit.Test;

public class TestRequirementDiagramConstraintLink extends TestConstraintLink {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new RequirementDiagramCreateCommand();
	}

	@Override
	protected String getProjectName() {
		return IRequirementDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IRequirementDiagramTestsConstants.FILE_NAME;
	}

	@Override
	protected String[] getRequiredProfiles() {
		return IRequirementDiagramTestsConstants.PROFILES;
	}

	/**
	 * Test to manage Constraint
	 */
	@Test
	public void testToManageConstraint() {
		testToManageLink(ElementTypes.CONSTRAINT, ElementTypes.CLASS, ElementTypes.CONSTRAINT_CONSTRAINED_ELEMENT, ElementTypes.PACKAGE, true);
	}
}
