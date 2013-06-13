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

import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.TestTopNode;
import org.eclipse.papyrus.uml.diagram.deployment.CreateDeploymentDiagramCommand;
import org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;

/**
 * The Class TestDeploymentDiagramTopNode.
 */
public class TestDeploymentDiagramTopNode extends TestTopNode {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateDeploymentDiagramCommand();
	}

	@Override
	protected CreateViewRequest createViewRequestShapeContainer() {
		return CreateViewRequestFactory.getCreateShapeRequest(UMLElementTypes.Package_2009, getDiagramEditPart().getDiagramPreferencesHint());
	}

	/**
	 * Test to manage i package.
	 */
	@Test
	public void testToManageIPackage() {
		testToManageNode(UMLElementTypes.Package_2009, UMLPackage.eINSTANCE.getPackage(), UMLElementTypes.Package_2009, true);
	}

	/**
	 * Test to manage Model
	 */
	@Test
	public void testToManageModel() {
		testToManageNode(UMLElementTypes.Model_2010, UMLPackage.eINSTANCE.getModel(), UMLElementTypes.Package_2009, true);
	}

	/**
	 * Test to manage Node
	 */
	@Test
	public void testToManageNode() {
		testToManageNode(UMLElementTypes.Node_2008, UMLPackage.eINSTANCE.getNode(), UMLElementTypes.Package_2009, true);
	}

	/**
	 * Test to manage Artifact
	 */
	@Test
	public void testToManageArtifact() {
		testToManageNode(UMLElementTypes.Artifact_2006, UMLPackage.eINSTANCE.getArtifact(), UMLElementTypes.Package_2009, true);
	}

	/**
	 * Test to manage device
	 */
	@Test
	public void testToManageDevice() {
		testToManageNode(UMLElementTypes.Device_2003, UMLPackage.eINSTANCE.getDevice(), UMLElementTypes.Package_2009, true);
	}

	/**
	 * Test to manage Execution Environment
	 */
	@Test
	public void testToManageExecutionEnvironment() {
		testToManageNode(UMLElementTypes.ExecutionEnvironment_2002, UMLPackage.eINSTANCE.getExecutionEnvironment(), UMLElementTypes.Package_2009, true);
	}

	/**
	 * Test to manage Comment.
	 */
	@Test
	public void testToManageComment() {
		testToManageNode(UMLElementTypes.Comment_2001, UMLPackage.eINSTANCE.getComment(), UMLElementTypes.Package_2009, true);
	}

	/**
	 * Test to manage Constraint.
	 */
	@Test
	public void testToManageConstraint() {
		testToManageNode(UMLElementTypes.Constraint_2005, UMLPackage.eINSTANCE.getConstraint(), UMLElementTypes.Package_2009, true);
	}

}
