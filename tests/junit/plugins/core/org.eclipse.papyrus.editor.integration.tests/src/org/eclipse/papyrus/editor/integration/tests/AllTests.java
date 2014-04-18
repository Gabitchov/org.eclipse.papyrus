/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 422257
 *  
 *****************************************************************************/
package org.eclipse.papyrus.editor.integration.tests;

import org.eclipse.papyrus.editor.integration.tests.tests.EditorMemoryLeakTest;
import org.eclipse.papyrus.editor.integration.tests.tests.ModelSetTests;
import org.eclipse.papyrus.editor.integration.tests.tests.PageManagerTests;
import org.eclipse.papyrus.editor.integration.tests.tests.RecoveryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * The {@link EditorMemoryLeakTest} suite <b>must</b> run first, because some test case in one of the other suites
 * breaks the Outline view:  it causes a pair of Overview/Outline actions from some diagram editor to linger in
 * the outline view's toolbar even after the editor was closed, and these persistent actions cause leaks of
 * models opened later.
 */
@RunWith(Suite.class)
@SuiteClasses({ EditorMemoryLeakTest.class, PageManagerTests.class, RecoveryTest.class, ModelSetTests.class })
public class AllTests {

}
