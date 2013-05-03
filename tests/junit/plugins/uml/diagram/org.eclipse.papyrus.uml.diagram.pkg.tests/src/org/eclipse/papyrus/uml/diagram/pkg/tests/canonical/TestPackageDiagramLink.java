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

import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.TestLinkOwnedBySource;
import org.eclipse.papyrus.uml.diagram.pkg.PackageDiagramCreateCommand;
import org.eclipse.papyrus.uml.diagram.pkg.provider.ElementTypes;
import org.junit.Test;

/**
 * The Class TestClassDiagramLink.
 */
public class TestPackageDiagramLink extends TestLinkOwnedBySource {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new PackageDiagramCreateCommand();
	}

	/**
	 * Test to manage Abstraction
	 */
	@Test
	public void testToManageAbstraction() {
		testToManageLink(ElementTypes.PACKAGE, ElementTypes.PACKAGE, ElementTypes.ABSTRACTION, ElementTypes.PACKAGE, true);
	}

	/**
	 * Test to manage Dependency
	 */
	@Test
	public void testToManageDependency() {
		testToManageLink(ElementTypes.PACKAGE, ElementTypes.PACKAGE, ElementTypes.DEPENDENCY, ElementTypes.PACKAGE, true);
	}

	/**
	 * Test to manage Dependency
	 */
	@Test
	public void testToManagePackageImport() {
		testToManageLink(ElementTypes.PACKAGE, ElementTypes.PACKAGE, ElementTypes.PACKAGE_IMPORT, ElementTypes.PACKAGE, true);
	}

}
