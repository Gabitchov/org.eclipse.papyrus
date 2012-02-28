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

import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.node.TestNodeCreationOnActorPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.node.TestNodeCreationOnActorPartStructureCompartment;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.node.TestNodeCreationOnBlock;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.node.TestNodeCreationOnBlockStructureCompartment;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.node.TestNodeCreationOnNestedActorPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.node.TestNodeCreationOnNestedPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.node.TestNodeCreationOnNestedProperty;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.node.TestNodeCreationOnNestedReference;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.node.TestNodeCreationOnNestedValue;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.node.TestNodeCreationOnPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.node.TestNodeCreationOnPartStructureCompartment;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.node.TestNodeCreationOnProperty;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.node.TestNodeCreationOnPropertyStructureCompartment;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.node.TestNodeCreationOnReference;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.node.TestNodeCreationOnReferenceStructureCompartment;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.node.TestNodeCreationOnValue;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.node.TestNodeCreationOnValueStructureCompartment;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ 
	TestNodeCreationOnActorPart.class,
	TestNodeCreationOnActorPartStructureCompartment.class,
	TestNodeCreationOnBlock.class,
	TestNodeCreationOnBlockStructureCompartment.class,
	TestNodeCreationOnPart.class,
	TestNodeCreationOnPartStructureCompartment.class,
	TestNodeCreationOnProperty.class,
	TestNodeCreationOnPropertyStructureCompartment.class,
	TestNodeCreationOnReference.class,
	TestNodeCreationOnReferenceStructureCompartment.class,
	TestNodeCreationOnValue.class,
	TestNodeCreationOnValueStructureCompartment.class,
	TestNodeCreationOnNestedActorPart.class,
	TestNodeCreationOnNestedPart.class,
	TestNodeCreationOnNestedProperty.class,
	TestNodeCreationOnNestedReference.class,
	TestNodeCreationOnNestedValue.class
})
public class AllCreationCustomNodeTests {

}
