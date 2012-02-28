/*****************************************************************************
 * Copyright (c) 2011-2012 CEA LIST.
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
package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.suites;

import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.delete.TestLinkBasicDeleteFromDiagram;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.delete.TestLinkBasicDeleteFromModel;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.delete.TestNodeBasicDeleteFromDiagram;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.delete.TestNodeBasicDeleteFromModel;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ 
	TestLinkBasicDeleteFromDiagram.class, 
	TestLinkBasicDeleteFromModel.class, 
	TestNodeBasicDeleteFromDiagram.class,
	TestNodeBasicDeleteFromModel.class })
public class AllDeletionTests {

}
