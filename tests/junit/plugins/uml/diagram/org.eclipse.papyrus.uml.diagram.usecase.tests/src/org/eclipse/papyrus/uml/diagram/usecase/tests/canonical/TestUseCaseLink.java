/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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

import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.TestLink;
import org.eclipse.papyrus.uml.diagram.usecase.CreateUseCaseDiagramCommand;
import org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.usecase.tests.IUseCaseDiagramTestsConstants;
import org.junit.Test;


/**
 * The Class TestUseCaseLink use to test link that are contained by the owner of the target and the source
 */
public class TestUseCaseLink extends TestLink {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return  new CreateUseCaseDiagramCommand();
	}
	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageDependency() {
		testToManageLink(UMLElementTypes.UseCase_2013,UMLElementTypes.UseCase_2013,UMLElementTypes.Dependency_4013,UMLElementTypes.Package_2016,true);
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
	public void testToManageDependencyUseCase_Actor() {
		testToManageLink(UMLElementTypes.UseCase_2013,UMLElementTypes.Actor_2011,UMLElementTypes.Dependency_4013,UMLElementTypes.Package_2016,true);
	}
	@Test
	public void testToManageAssociationUseCase_UseCase() {
		testToManageLink(UMLElementTypes.UseCase_2013,UMLElementTypes.UseCase_2013,UMLElementTypes.Association_4011,UMLElementTypes.Package_2016,true);
	}
	@Test
	public void testToManageAssociationUseCase_Actor() {
		testToManageLink(UMLElementTypes.UseCase_2013,UMLElementTypes.Actor_2011,UMLElementTypes.Association_4011,UMLElementTypes.Package_2016,true);
	}
	
	@Test
	public void testToManageAbstraction() {
		testToManageLink(UMLElementTypes.UseCase_2013,UMLElementTypes.UseCase_2013,UMLElementTypes.Abstraction_4015,UMLElementTypes.Package_2016,true);
	}
	@Test
	public void testToManageUsage() {
		testToManageLink(UMLElementTypes.UseCase_2013,UMLElementTypes.UseCase_2013,UMLElementTypes.Usage_4016,UMLElementTypes.Package_2016,true);
	}
	@Test
	public void testToManageRealization() {
		testToManageLink(UMLElementTypes.UseCase_2013,UMLElementTypes.UseCase_2013,UMLElementTypes.Realization_4017,UMLElementTypes.Package_2016,true);
	}
	
}
