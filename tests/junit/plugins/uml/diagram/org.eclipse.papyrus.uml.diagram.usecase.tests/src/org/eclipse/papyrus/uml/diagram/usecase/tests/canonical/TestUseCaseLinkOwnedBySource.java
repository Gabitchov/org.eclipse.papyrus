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
import org.eclipse.papyrus.diagram.tests.canonical.TestLinkOwnedBySource;
import org.eclipse.papyrus.uml.diagram.usecase.CreateUseCaseDiagramCommand;
import org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes;
import org.junit.Test;


/**
 * The Class TestUseCaseLink use to test link that are contained by the owner of the target and the source
 */
public class TestUseCaseLinkOwnedBySource extends TestLinkOwnedBySource {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateUseCaseDiagramCommand();
	}

	/**
	 * Test to manage Association.
	 */
	@Test
	public void testToManageGeneralization() {
		testToManageLink(UMLElementTypes.Actor_2011, UMLElementTypes.Actor_2011, UMLElementTypes.Generalization_4010, UMLElementTypes.Package_2016, true);
	}

	@Test
	public void testToManagePackageMerge() {
		testToManageLink(UMLElementTypes.Package_2016, UMLElementTypes.Package_2016, UMLElementTypes.PackageMerge_4018, UMLElementTypes.Package_2016, true);
	}

	@Test
	public void testToManagePackageImport() {
		testToManageLink(UMLElementTypes.Package_2016, UMLElementTypes.Package_2016, UMLElementTypes.PackageImport_4019, UMLElementTypes.Package_2016, true);
	}

	@Test
	public void testToManageExtend() {
		testToManageLink(UMLElementTypes.UseCase_2013, UMLElementTypes.UseCase_2013, UMLElementTypes.Extend_4009, UMLElementTypes.Package_2016, true);
	}

	@Test
	public void testToManageInclude() {
		testToManageLink(UMLElementTypes.UseCase_2013, UMLElementTypes.UseCase_2013, UMLElementTypes.Include_4008, UMLElementTypes.Package_2016, true);
	}

}
