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


import junit.framework.TestSuite;

import org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.node.TestNodeCreationOnBlock;
import org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.node.TestNodeCreationOnBlockStructureCompartment;
import org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.node.TestNodeCreationOnComment;
import org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.node.TestNodeCreationOnConstraint;
import org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.node.TestNodeCreationOnConstraintProperty;
import org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.node.TestNodeCreationOnDiagram;
import org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.node.TestNodeCreationOnPart;
import org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.node.TestNodeCreationOnPartStructureCompartement;
import org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.node.TestNodeCreationOnReference;
import org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.node.TestNodeCreationOnReferenceStructureCompartment;
import org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.node.TestNodeCreationOnValue;
import org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.node.TestNodeCreationOnValueStructureCompartment;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ 
	TestNodeCreationOnBlock.class,
	TestNodeCreationOnBlockStructureCompartment.class,
	TestNodeCreationOnComment.class,
	TestNodeCreationOnConstraint.class,
	TestNodeCreationOnConstraintProperty.class,
	TestNodeCreationOnDiagram.class,
	TestNodeCreationOnPart.class,
	TestNodeCreationOnPartStructureCompartement.class,
	TestNodeCreationOnReference.class,
	TestNodeCreationOnReferenceStructureCompartment.class,
	TestNodeCreationOnValue.class,
	TestNodeCreationOnValueStructureCompartment.class
})

public class AllCreationNodeTestsOnParametricOwnedByBlock extends TestSuite {
}
