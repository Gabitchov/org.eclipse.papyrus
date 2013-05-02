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
package org.eclipse.papyrus.sysml.diagram.requirement.test.canonical;

import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.TestLink;
import org.eclipse.papyrus.sysml.diagram.requirement.RequirementDiagramCreateCommand;
import org.eclipse.papyrus.sysml.diagram.requirement.provider.ElementTypes;
import org.junit.Test;

/**
 * The Class TestClassDiagramLink.
 */
public class TestRequirementDiagramLink extends TestLink {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new RequirementDiagramCreateCommand();
	}

	/**
	 * Test to manage Abstraction
	 */
	@Test
	public void testToManageAbstraction() {
		testToManageLink(ElementTypes.CLASS, ElementTypes.CLASS, ElementTypes.ABSTRACTION, ElementTypes.PACKAGE, true);
	}

	/**
	 * Test to manage Dependency
	 */
	@Test
	public void testToManageDependency() {
		testToManageLink(ElementTypes.CLASS, ElementTypes.CLASS, ElementTypes.DEPENDENCY, ElementTypes.PACKAGE, true);
	}

}
