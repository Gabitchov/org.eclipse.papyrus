/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.tests;

import org.eclipse.papyrus.sysml.diagram.parametric.tests.utils.Constants;
import org.junit.Assert;
import org.junit.BeforeClass;

/**
 * Abstract Papyrus initialization class (required to get Service activation).
 */
public abstract class AbstractTest4CB extends AbstractTest4B {

	@BeforeClass
	public static void openPapyrusWithAParametricDiagramOwnedByConstraintBlock() throws Exception {
		setActiveDiagramViewByName(Constants.PARAMETRIC_OWNED_BY_CONSTRAINTBLOCK_DIAGRAM_NAME);
		
		Assert.assertNotNull("Failed to open the editor", editor);
	}
}
