/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.sysml.modelexplorer.tests.suites;

import org.eclipse.papyrus.sysml.modelexplorer.tests.dragdrop.IBDDragDropTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * Tests suites for Drag And Drop inside the model explorer
 */
@RunWith(Suite.class)
@SuiteClasses({
IBDDragDropTest.class,
})
public class AllDragDropTests {
	//Test suite
}
