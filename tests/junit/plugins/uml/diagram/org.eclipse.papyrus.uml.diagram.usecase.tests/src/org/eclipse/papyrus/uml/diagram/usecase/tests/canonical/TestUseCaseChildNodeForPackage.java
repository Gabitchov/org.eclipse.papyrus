/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.usecase.tests.canonical;

import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.TestChildNode;
import org.eclipse.papyrus.uml.diagram.usecase.CreateUseCaseDiagramCommand;
import org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes;
import org.junit.Test;


// TODO: Auto-generated Javadoc
/**
 * The Class TestUseCaseChildNodeForPackage.
 */
public class TestUseCaseChildNodeForPackage extends TestChildNode {

	
	@Override
	protected CreateViewRequest createViewRequestShapeContainer() {
		return CreateViewRequestFactory.getCreateShapeRequest(UMLElementTypes.Package_2016, getDiagramEditPart().getDiagramPreferencesHint());
	}
	
	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManagePackage() {
		testToManageChildNode(UMLElementTypes.Package_3014, UMLElementTypes.Package_3014, true);
	}
	
	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageActor() {
		testToManageChildNode(UMLElementTypes.Actor_3011, UMLElementTypes.Package_3014, true);
	}
	
	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageComment() {
		testToManageChildNode(UMLElementTypes.Comment_3015, UMLElementTypes.Package_3014, true);
	}
	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageConstraint() {
		testToManageChildNode(UMLElementTypes.Constraint_3010, UMLElementTypes.Package_3014, true);
	}
	@Test
	public void testToManageComponent() {
		testToManageChildNode(UMLElementTypes.Component_3013, UMLElementTypes.Package_3014, true);
	}
	@Test
	public void testToManageUseCase() {
		testToManageChildNode(UMLElementTypes.UseCase_3012, UMLElementTypes.Package_3014, true);
	}
	
	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return  new CreateUseCaseDiagramCommand();
	}
	
}
