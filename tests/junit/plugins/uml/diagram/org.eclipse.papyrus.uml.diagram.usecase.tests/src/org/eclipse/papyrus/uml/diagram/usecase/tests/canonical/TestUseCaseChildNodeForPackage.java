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
import org.eclipse.papyrus.uml.diagram.usecase.tests.IUseCaseDiagramTestsConstants;
import org.eclipse.uml2.uml.UMLPackage;
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
	
	@Override
	protected String getProjectName() {
		return IUseCaseDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IUseCaseDiagramTestsConstants.FILE_NAME;
	}
	
	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManagePackage() {
		testToManageNode(UMLElementTypes.Package_3014, UMLPackage.eINSTANCE.getPackage(), UMLElementTypes.Package_3014, true);
	}
	
	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageActor() {
		testToManageNode(UMLElementTypes.Actor_3011, UMLPackage.eINSTANCE.getActor(), UMLElementTypes.Package_3014, true);
	}
	
	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageComment() {
		testToManageNode(UMLElementTypes.Comment_3015, UMLPackage.eINSTANCE.getComment(), UMLElementTypes.Package_3014, true);
	}
	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageConstraint() {
		testToManageNode(UMLElementTypes.Constraint_3010, UMLPackage.eINSTANCE.getConstraint(), UMLElementTypes.Package_3014, true);
	}
	@Test
	public void testToManageComponent() {
		testToManageNode(UMLElementTypes.Component_3013, UMLPackage.eINSTANCE.getComponent(), UMLElementTypes.Package_3014, true);
	}
	@Test
	public void testToManageUseCase() {
		testToManageNode(UMLElementTypes.UseCase_3012, UMLPackage.eINSTANCE.getUseCase(), UMLElementTypes.Package_3014, true);
	}
	
	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return  new CreateUseCaseDiagramCommand();
	}
	
}
