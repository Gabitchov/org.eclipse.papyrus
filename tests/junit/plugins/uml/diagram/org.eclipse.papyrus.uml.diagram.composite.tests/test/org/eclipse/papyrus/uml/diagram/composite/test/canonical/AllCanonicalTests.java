/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.test.canonical;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All test in canonical package
 */
@RunWith(Suite.class)
@SuiteClasses({
//test links
TestCompositeDiagramSimpleLink.class, TestCompositeDiagramLinkOwnedBySource.class, TestCompositeDiagramElementWithSameParentLink.class, TestCompositeDiagramElementWithDifferentParentLink.class })
public class AllCanonicalTests {
}
