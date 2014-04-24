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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.tests;

import org.eclipse.papyrus.sysml.allocations.tests.AllocationsTests;
import org.eclipse.papyrus.sysml.modelelements.tests.ModelelementsTests;
import org.eclipse.papyrus.sysml.portandflows.tests.PortandflowsTests;
import org.eclipse.papyrus.sysml.requirements.tests.RequirementsTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * A test suite for the '<em><b>Sysml</b></em>' model.
 */
@RunWith(Suite.class)
@SuiteClasses({ ModelelementsTests.class, PortandflowsTests.class, AllocationsTests.class, RequirementsTests.class

})
public class SysmlAllTests {
	// SysmlAllTests
}
