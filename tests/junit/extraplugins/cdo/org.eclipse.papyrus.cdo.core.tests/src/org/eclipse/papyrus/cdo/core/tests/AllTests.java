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
package org.eclipse.papyrus.cdo.core.tests;

import org.eclipse.papyrus.cdo.core.resource.tests.CDOAwareModelSetTest;
import org.eclipse.papyrus.cdo.core.util.tests.AllUtilTests;
import org.eclipse.papyrus.cdo.internal.core.exporter.tests.AllModelExportTests;
import org.eclipse.papyrus.cdo.internal.core.expressions.tests.AllExpressionsTests;
import org.eclipse.papyrus.cdo.internal.core.importer.tests.AllModelImportTests;
import org.eclipse.papyrus.cdo.internal.core.tests.AllInternalCoreTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * This is the AllTests type. Enjoy.
 */
@RunWith(Suite.class)
@SuiteClasses({ AllUtilTests.class, AllExpressionsTests.class, //
AllInternalCoreTests.class, CDOAwareModelSetTest.class, //
AllModelImportTests.class, AllModelExportTests.class })
public class AllTests {

	public AllTests() {
		super();
	}

}
