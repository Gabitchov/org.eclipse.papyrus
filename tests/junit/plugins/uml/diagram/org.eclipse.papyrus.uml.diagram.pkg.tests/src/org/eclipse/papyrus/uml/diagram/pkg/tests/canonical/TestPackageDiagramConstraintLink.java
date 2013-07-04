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
import org.eclipse.papyrus.diagram.tests.canonical.TestConstraintLink;
import org.eclipse.papyrus.uml.diagram.pkg.PackageDiagramCreateCommand;
import org.eclipse.papyrus.uml.diagram.pkg.provider.ElementTypes;
import org.eclipse.papyrus.uml.diagram.pkg.tests.IPackageDiagramTestsConstants;
import org.junit.Test;

public class TestPackageDiagramConstraintLink extends TestConstraintLink {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new PackageDiagramCreateCommand();
	}
	
	@Override
	protected String getProjectName() {
		return IPackageDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IPackageDiagramTestsConstants.PROJECT_NAME;
	}

	/**
	 * Test to manage Constraint
	 */
	@Test
	public void testToManageConstraint() {
		testToManageLink(ElementTypes.CONSTRAINT, ElementTypes.PACKAGE, ElementTypes.CONSTRAINT_CONSTRAINED_ELEMENT, ElementTypes.PACKAGE, true);
	}
}
