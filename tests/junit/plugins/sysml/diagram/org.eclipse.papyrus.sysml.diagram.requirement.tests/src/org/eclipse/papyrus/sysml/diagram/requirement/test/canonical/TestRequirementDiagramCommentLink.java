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
import org.eclipse.papyrus.diagram.tests.canonical.TestCommentLink;
import org.eclipse.papyrus.junit.utils.classification.InvalidTest;
import org.eclipse.papyrus.sysml.diagram.requirement.RequirementDiagramCreateCommand;
import org.eclipse.papyrus.sysml.diagram.requirement.provider.ElementTypes;
import org.eclipse.papyrus.sysml.diagram.requirement.test.IRequirementDiagramTestsConstants;
import org.junit.Test;

@InvalidTest("UML Diagram Canonical Tests are not compatible with profiled models")
public class TestRequirementDiagramCommentLink extends TestCommentLink {

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
	 * Test to manage Comment
	 */
	@Test
	public void testToManageComment() {
		testToManageLink(ElementTypes.COMMENT, ElementTypes.CLASS, ElementTypes.COMMENT_ANNOTATED_ELEMENT, ElementTypes.PACKAGE, true);
	}
}
