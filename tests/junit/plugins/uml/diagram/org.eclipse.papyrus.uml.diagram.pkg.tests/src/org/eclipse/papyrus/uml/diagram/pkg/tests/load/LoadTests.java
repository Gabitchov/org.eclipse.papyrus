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
package org.eclipse.papyrus.uml.diagram.pkg.tests.load;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All tests together.
 */
@RunWith(Suite.class)
@SuiteClasses({
// 10 classes
Load10PackageTest.class,
// 100 classes
Load100PackageTest.class,
// 200 classes
Load200PackageTest.class,
// 300 classes
Load300PackageTest.class,
// 400 classes
Load400PackageTest.class,
// 500 classes
Load500PackageTest.class, })
public class LoadTests {

}
