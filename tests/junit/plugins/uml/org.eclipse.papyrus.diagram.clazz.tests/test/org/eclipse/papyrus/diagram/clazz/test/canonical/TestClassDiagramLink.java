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
package org.eclipse.papyrus.diagram.clazz.test.canonical;

import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.clazz.test.IClassDiagramTestsConstants;
import org.eclipse.papyrus.diagram.tests.canonical.TestLink;
import org.eclipse.papyrus.uml.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.junit.Test;

/**
 * The Class TestClassDiagramLink use to test link that are contained by the owner of the target and the source
 */
public class TestClassDiagramLink extends TestLink {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateClassDiagramCommand();
	}

	@Override
	protected String getProjectName() {
		return IClassDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IClassDiagramTestsConstants.FILE_NAME;
	}

	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageDependency() {
		testToManageLink(UMLElementTypes.Component_2002, UMLElementTypes.Component_2002, UMLElementTypes.Dependency_4008, UMLElementTypes.Package_2007, true);
	}

	/**
	 * Test to manage Association.
	 */
	@Test
	public void testToManageAssociation() {
		testToManageLink(UMLElementTypes.Class_2008, UMLElementTypes.Class_2008, UMLElementTypes.Association_4001, UMLElementTypes.Package_2007, true);
	}

	//test generatlization
	//test interfaceRealization
	//test substitution
	/**
	 * Test to manage Realization
	 */
	@Test
	public void testToManageRealization() {
		testToManageLink(UMLElementTypes.Class_2008, UMLElementTypes.Class_2008, UMLElementTypes.Realization_4005, UMLElementTypes.Package_2007, true);
	}

	/**
	 * Test to manage Abstraction
	 */
	@Test
	public void testToManageAbstraction() {
		testToManageLink(UMLElementTypes.Class_2008, UMLElementTypes.Class_2008, UMLElementTypes.Abstraction_4006, UMLElementTypes.Package_2007, true);
	}

	/**
	 * Test to manage Usage
	 */
	@Test
	public void testToManageUsage() {
		testToManageLink(UMLElementTypes.Class_2008, UMLElementTypes.Class_2008, UMLElementTypes.Usage_4007, UMLElementTypes.Package_2007, true);
	}

	/**
	 * Test to manage Usage
	 */
	@Test
	public void testToManageInformationFlow() {
		testToManageLink(UMLElementTypes.Class_2008, UMLElementTypes.Class_2008, UMLElementTypes.InformationFlow_4026, UMLElementTypes.Package_2007, true);
	}
	//test Element import
	//testPackageImport
	//test comment link
	//test constraintLink
	//test template binding
	//test instancespecificationLink
}
