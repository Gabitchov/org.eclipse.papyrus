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
import org.eclipse.papyrus.diagram.tests.canonical.TestTopNode;
import org.eclipse.papyrus.uml.diagram.pkg.PackageDiagramCreateCommand;
import org.eclipse.papyrus.uml.diagram.pkg.provider.ElementTypes;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;

/**
 * The Class TestClassDiagramTopNode.
 */
public class TestPackageDiagramTopNode extends TestTopNode {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new PackageDiagramCreateCommand();
	}

	@Override
	protected CreateViewRequest createViewRequestShapeContainer() {
		return CreateViewRequestFactory.getCreateShapeRequest(ElementTypes.PACKAGE, getDiagramEditPart().getDiagramPreferencesHint());
	}

	/**
	 * Test to manage model.
	 */
	@Test
	public void testToManageModel() {
		testToManageNode(ElementTypes.MODEL, UMLPackage.eINSTANCE.getModel(), ElementTypes.PACKAGE, true);
	}

	/**
	 * Test to manage i package.
	 */
	@Test
	public void testToManageIPackage() {
		testToManageNode(ElementTypes.PACKAGE, UMLPackage.eINSTANCE.getPackage(), ElementTypes.PACKAGE, true);
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
