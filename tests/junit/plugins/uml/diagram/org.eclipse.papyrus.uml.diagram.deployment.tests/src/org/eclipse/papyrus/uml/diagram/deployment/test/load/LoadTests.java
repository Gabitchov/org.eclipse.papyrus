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
package org.eclipse.papyrus.uml.diagram.deployment.test.load;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All tests together.
 */
@RunWith(Suite.class)
@SuiteClasses({
// 10 Node
Load10NodeTest.class,
//100 Node
Load100NodeTest.class,
//200 Node
Load200NodeTest.class,
//300 Node
Load300NodeTest.class,
//400 Node
Load400NodeTest.class,
//500 Node
Load500NodeTest.class,
//1000 Node
Load1000NodeTest.class, })
public class LoadTests {

}
