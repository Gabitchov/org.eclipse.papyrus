/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.suites;

import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.inherited.TestNodeDropOnComment;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.inherited.TestNodeDropOnCommentCN;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.inherited.TestNodeDropOnConstraint;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.inherited.TestNodeDropOnConstraintCN;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	TestNodeDropOnComment.class,
	TestNodeDropOnCommentCN.class,
	TestNodeDropOnConstraint.class,
	TestNodeDropOnConstraintCN.class
})
public class AllDropInheritedTests {

}
