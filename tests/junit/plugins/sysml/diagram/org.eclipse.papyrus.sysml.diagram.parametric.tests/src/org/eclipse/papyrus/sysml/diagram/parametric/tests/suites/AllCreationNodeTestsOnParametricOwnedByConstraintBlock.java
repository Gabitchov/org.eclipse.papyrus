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
package org.eclipse.papyrus.sysml.diagram.parametric.tests.suites;


import junit.framework.TestCase;

import org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.node.TestNodeCreationOnComment4CB;
import org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.node.TestNodeCreationOnConstraint4CB;
import org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.node.TestNodeCreationOnConstraintBlock4CB;
import org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.node.TestNodeCreationOnConstraintBlockStructureCompartment4CB;
import org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.node.TestNodeCreationOnConstraintProperty4CB;
import org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.node.TestNodeCreationOnDiagram4CB;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ 
	TestNodeCreationOnComment4CB.class,
	TestNodeCreationOnConstraint4CB.class,
	TestNodeCreationOnConstraintBlock4CB.class,
	TestNodeCreationOnConstraintBlockStructureCompartment4CB.class,
	TestNodeCreationOnConstraintProperty4CB.class,
	TestNodeCreationOnDiagram4CB.class
})

public class AllCreationNodeTestsOnParametricOwnedByConstraintBlock extends TestCase {
}
