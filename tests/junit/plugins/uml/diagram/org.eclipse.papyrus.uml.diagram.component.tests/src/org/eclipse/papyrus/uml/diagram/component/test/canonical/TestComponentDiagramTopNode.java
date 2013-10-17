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
package org.eclipse.papyrus.uml.diagram.component.test.canonical;

import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.TestTopNode;
import org.eclipse.papyrus.uml.diagram.component.CreateComponentDiagramCommand;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.component.test.IComponentDiagramTestsConstants;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;

/**
 * The Class TestComponentDiagramTopNode.
 */
public class TestComponentDiagramTopNode extends TestTopNode {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateComponentDiagramCommand();
	}

	@Override
	protected String getProjectName() {
		return IComponentDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IComponentDiagramTestsConstants.FILE_NAME;
	}
	
	@Override
	protected CreateViewRequest createViewRequestShapeContainer() {
		return CreateViewRequestFactory.getCreateShapeRequest(UMLElementTypes.Package_3200, getDiagramEditPart().getDiagramPreferencesHint());
	}

	/**
	 * Test to manage Package
	 */
	@Test
	public void testToManagePackage() {
		testToManageNode(UMLElementTypes.Package_3200, UMLPackage.eINSTANCE.getPackage(), UMLElementTypes.Package_3200, true);
	}

	/**
	 * Test to manage Model
	 */
	@Test
	public void testToManageModel() {
		testToManageNode(UMLElementTypes.Model_3202, UMLPackage.eINSTANCE.getModel(), UMLElementTypes.Package_3200, true);
	}

	/**
	 * Test to manage Component
	 */
	@Test
	public void testToManageComponent() {
		testToManageNode(UMLElementTypes.Component_2002, UMLPackage.eINSTANCE.getComponent(), UMLElementTypes.Package_3200, true);
	}

	/**
	 * Test to manage Interface
	 */
	@Test
	public void testToManageInterface() {
		testToManageNode(UMLElementTypes.Interface_3205, UMLPackage.eINSTANCE.getInterface(), UMLElementTypes.Package_3200, true);
	}

	/**
	 * Test to manage Comment
	 */
	@Test
	public void testToManageComment() {
		testToManageNode(UMLElementTypes.Comment_3201, UMLPackage.eINSTANCE.getComment(), UMLElementTypes.Package_3200, true);
	}

	/**
	 * Test to manage Constraint
	 */
	@Test
	public void testToManageConstraint() {
		testToManageNode(UMLElementTypes.Constraint_3199, UMLPackage.eINSTANCE.getConstraint(), UMLElementTypes.Package_3200, true);
	}

}
