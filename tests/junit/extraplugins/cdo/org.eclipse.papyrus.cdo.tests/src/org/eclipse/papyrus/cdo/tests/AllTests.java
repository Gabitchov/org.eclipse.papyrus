/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * This is the AllTests type. Enjoy.
 */
@RunWith(Suite.class)
@SuiteClasses({ org.eclipse.papyrus.cdo.core.tests.AllTests.class, //
org.eclipse.papyrus.cdo.ui.tests.AllTests.class, //
org.eclipse.papyrus.cdo.uml.ui.tests.AllTests.class, //
org.eclipse.papyrus.cdo.validation.problems.tests.ProblemsAllTests.class })
public class AllTests {

	public AllTests() {
		super();
	}

}
