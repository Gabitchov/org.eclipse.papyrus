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
import org.eclipse.papyrus.diagram.tests.canonical.TestLinkOwnedBySource;
import org.eclipse.papyrus.uml.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.junit.Test;


/**
 * The Class TestClassDiagramLink use to test link that are contained by the owner of the target and the source
 */
public class TestClassDiagramLinkOwnedBySource extends TestLinkOwnedBySource {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return  new CreateClassDiagramCommand();
	}
	
	/**
	 * Test to manage Association.
	 */
	@Test
	public void testToManageGeneralization() {
		testToManageLink(UMLElementTypes.Class_2008,UMLElementTypes.Class_2008,UMLElementTypes.Generalization_4002,UMLElementTypes.Package_2007,true);
	}
	
	/**
	 * Test to manage InterfaceRealization.
	 */
	@Test
	public void testToManageInterfaceRealization() {
		testToManageLink(UMLElementTypes.Class_2008,UMLElementTypes.Interface_2004,UMLElementTypes.InterfaceRealization_4003,UMLElementTypes.Package_2007,true);
	}
	
	/**
	 * Test to manage Substitution.
	 */
	@Test
	public void testToManageSubstitution() {
		testToManageLink(UMLElementTypes.Class_2008,UMLElementTypes.Class_2008,UMLElementTypes.Substitution_4004,UMLElementTypes.Package_2007,true);
	}
	
	/**
	 * Test to manage ElementImport.
	 */
	@Test
	public void testToManageElementImport() {
		testToManageLink(UMLElementTypes.Class_2008,UMLElementTypes.Class_2008,UMLElementTypes.ElementImport_4009,UMLElementTypes.Package_2007,true);
	}
	/**
	 * Test to manage ElementImport.
	 */
	@Test
	public void testToManagePackageImport() {
		testToManageLink(UMLElementTypes.Package_2007,UMLElementTypes.Package_2007,UMLElementTypes.PackageImport_4010,UMLElementTypes.Package_2007,true);
	}
	
	
	//test comment link
	//test constraintLink
	//test template binding
	//test containment link
	//test instancespecificationLink
	
}
