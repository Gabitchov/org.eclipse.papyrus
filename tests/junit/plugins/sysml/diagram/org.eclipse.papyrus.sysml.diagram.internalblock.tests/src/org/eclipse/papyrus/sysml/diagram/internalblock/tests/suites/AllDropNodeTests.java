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

import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.node.TestNodeDropOnActorPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.node.TestNodeDropOnActorPartStructureCompartment;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.node.TestNodeDropOnBlock;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.node.TestNodeDropOnBlockStructureCompartment;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.node.TestNodeDropOnNestedActorPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.node.TestNodeDropOnNestedPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.node.TestNodeDropOnNestedProperty;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.node.TestNodeDropOnNestedReference;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.node.TestNodeDropOnNestedValue;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.node.TestNodeDropOnPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.node.TestNodeDropOnPartStructureCompartment;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.node.TestNodeDropOnProperty;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.node.TestNodeDropOnPropertyStructureCompartment;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.node.TestNodeDropOnReference;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.node.TestNodeDropOnReferenceStructureCompartment;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.node.TestNodeDropOnValue;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.node.TestNodeDropOnValueStructureCompartment;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ 
	TestNodeDropOnActorPart.class,
	TestNodeDropOnActorPartStructureCompartment.class,
	TestNodeDropOnBlock.class,
	TestNodeDropOnBlockStructureCompartment.class,
	TestNodeDropOnPart.class, 
	TestNodeDropOnPartStructureCompartment.class,
	TestNodeDropOnProperty.class,
	TestNodeDropOnPropertyStructureCompartment.class,
	TestNodeDropOnReference.class,
	TestNodeDropOnReferenceStructureCompartment.class,
	TestNodeDropOnValue.class,
	TestNodeDropOnValueStructureCompartment.class,
	TestNodeDropOnNestedActorPart.class,
	TestNodeDropOnNestedPart.class,
	TestNodeDropOnNestedProperty.class,
	TestNodeDropOnNestedReference.class,
	TestNodeDropOnNestedValue.class
})
public class AllDropNodeTests {

}
