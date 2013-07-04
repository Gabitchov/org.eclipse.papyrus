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
package org.eclipse.papyrus.uml.diagram.pkg.tests.canonical;

import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.TestChildNode;
import org.eclipse.papyrus.uml.diagram.pkg.PackageDiagramCreateCommand;
import org.eclipse.papyrus.uml.diagram.pkg.provider.ElementTypes;
import org.eclipse.papyrus.uml.diagram.pkg.tests.IPackageDiagramTestsConstants;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;

/**
 * The Class TestClassDiagramTopNode.
 */
public class TestPackageDiagramChildNode extends TestChildNode {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new PackageDiagramCreateCommand();
	}

	@Override
	protected CreateViewRequest createViewRequestShapeContainer() {
		return CreateViewRequestFactory.getCreateShapeRequest(ElementTypes.PACKAGE, getDiagramEditPart().getDiagramPreferencesHint());
	}

	@Override
	protected String getProjectName() {
		return IPackageDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IPackageDiagramTestsConstants.PROJECT_NAME;
	}
	
	/**
	 * Test to manage model.
	 */
	@Test
	public void testToManageModel() {
		testToManageNode(ElementTypes.MODEL_CN, UMLPackage.eINSTANCE.getModel(), ElementTypes.PACKAGE_CN, true);
	}

	/**
	 * Test to manage i package.
	 */
	@Test
	public void testToManageIPackage() {
		testToManageNode(ElementTypes.PACKAGE_CN, UMLPackage.eINSTANCE.getPackage(), ElementTypes.PACKAGE_CN, true);
	}

	/**
	 * Test to manage Comment.
	 */
	@Test
	public void testToManageComment() {
		testToManageNode(ElementTypes.COMMENT_CN, UMLPackage.eINSTANCE.getComment(), ElementTypes.PACKAGE_CN, true);
	}

	/**
	 * Test to manage Constraint.
	 */
	@Test
	public void testToManageConstraint() {
		testToManageNode(ElementTypes.CONSTRAINT_CN, UMLPackage.eINSTANCE.getConstraint(), ElementTypes.PACKAGE_CN, true);
	}
}
