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

import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.link.TestLinkDropOnBlockPropertyStructureCpt;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.link.TestLinkDropOnBlockStructureCpt;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.link.TestLinkDropOnDiagram;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	TestLinkDropOnDiagram.class,
	TestLinkDropOnBlockStructureCpt.class,
	TestLinkDropOnBlockPropertyStructureCpt.class
})
public class AllDropLinkTests {

}
