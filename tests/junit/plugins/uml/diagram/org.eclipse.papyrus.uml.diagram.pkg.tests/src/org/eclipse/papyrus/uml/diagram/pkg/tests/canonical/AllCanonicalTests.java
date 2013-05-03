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
package org.eclipse.papyrus.uml.diagram.pkg.tests.canonical;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All test in canonical package
 */
@RunWith(Suite.class)
@SuiteClasses({
// Top node
TestPackageDiagramTopNode.class,
// Child node
TestPackageDiagramChildNode.class,
// Link
TestPackageDiagramLink.class,
// Constraint Link
TestPackageDiagramConstraintLink.class,
// Comment Link
TestPackageDiagramCommentLink.class, })
public class AllCanonicalTests {

}
