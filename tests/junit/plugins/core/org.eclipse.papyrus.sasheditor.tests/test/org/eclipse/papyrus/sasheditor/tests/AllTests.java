/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.sasheditor.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * All tests for this plugin
 */
@RunWith(Suite.class)
@SuiteClasses({
// testModel1
org.eclipse.papyrus.sasheditor.contentprovider.simple.AllTests.class, org.eclipse.papyrus.sasheditor.editor.AllTests.class, org.eclipse.papyrus.sasheditor.internal.AllTests.class })
public class AllTests {

}
