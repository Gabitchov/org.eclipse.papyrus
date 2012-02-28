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

import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.TestDiagramCreation;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.TestNodeCreationOnDiagram;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.TestLinkDropOnDiagram;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.TestNodeDropOnDiagram;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
	TestDiagramCreation.class,
	TestNodeCreationOnDiagram.class,
	TestNodeDropOnDiagram.class,
	TestLinkDropOnDiagram.class
})
public class AllDiagramTests {

}
