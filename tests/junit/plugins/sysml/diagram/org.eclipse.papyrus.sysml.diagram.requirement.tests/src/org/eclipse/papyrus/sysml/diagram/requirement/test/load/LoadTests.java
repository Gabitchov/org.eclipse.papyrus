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
package org.eclipse.papyrus.sysml.diagram.requirement.test.load;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All tests together.
 */
@RunWith(Suite.class)
@SuiteClasses({
// 10 classes
Load10RequirementTest.class,
// 100 classes
Load100RequirementTest.class,
// 200 classes
Load200RequirementTest.class,
// 300 classes
Load300RequirementTest.class,
// 400 classes
Load400RequirementTest.class,
// 500 classes
Load500RequirementTest.class, })
public class LoadTests {

}
