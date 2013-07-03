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

import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.TestTopNode;
import org.eclipse.papyrus.sysml.diagram.requirement.RequirementDiagramCreateCommand;
import org.eclipse.papyrus.sysml.diagram.requirement.provider.ElementTypes;
import org.eclipse.papyrus.sysml.diagram.requirement.test.IRequirementDiagramTestsConstants;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;

/**
 * The Class TestClassDiagramTopNode.
 */
public class TestRequirementDiagramTopNode extends TestTopNode {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new RequirementDiagramCreateCommand();
	}

	@Override
	protected CreateViewRequest createViewRequestShapeContainer() {
		return CreateViewRequestFactory.getCreateShapeRequest(ElementTypes.PACKAGE, getDiagramEditPart().getDiagramPreferencesHint());
	}

	@Override
	protected String getProjectName() {
		return IRequirementDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IRequirementDiagramTestsConstants.FILE_NAME;
	}

	/**
	 * Test to manage i package.
	 */
	@Test
	public void testToManageIPackage() {
		testToManageNode(ElementTypes.PACKAGE, UMLPackage.eINSTANCE.getPackage(), ElementTypes.PACKAGE, true);
	}

	/**
	 * Test to manage Requirement (inherite class).
	 */
	@Test
	public void testToManageRequirement() {
		testToManageNode(ElementTypes.CLASS, UMLPackage.eINSTANCE.getClass_(), ElementTypes.PACKAGE, true);
	}

	/**
	 * Test to manage Comment.
	 */
	@Test
	public void testToManageComment() {
		testToManageNode(ElementTypes.COMMENT, UMLPackage.eINSTANCE.getComment(), ElementTypes.PACKAGE, true);
	}

	/**
	 * Test to manage Constraint.
	 */
	@Test
	public void testToManageConstraint() {
		testToManageNode(ElementTypes.CONSTRAINT, UMLPackage.eINSTANCE.getConstraint(), ElementTypes.PACKAGE, true);
	}
}
