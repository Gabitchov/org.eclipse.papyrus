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

import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.encapsulated.TestLinkCreationConnectorForSources;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.encapsulated.TestLinkCreationConnectorFromActorPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.encapsulated.TestLinkCreationConnectorFromFlowPortOnBlock;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.encapsulated.TestLinkCreationConnectorFromFlowPortOnNestedPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.encapsulated.TestLinkCreationConnectorFromFlowPortOnPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.encapsulated.TestLinkCreationConnectorFromNestedActorPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.encapsulated.TestLinkCreationConnectorFromNestedPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.encapsulated.TestLinkCreationConnectorFromNestedProperty;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.encapsulated.TestLinkCreationConnectorFromNestedReference;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.encapsulated.TestLinkCreationConnectorFromNestedValue;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.encapsulated.TestLinkCreationConnectorFromPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.encapsulated.TestLinkCreationConnectorFromPortOnBlock;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.encapsulated.TestLinkCreationConnectorFromPortOnNestedPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.encapsulated.TestLinkCreationConnectorFromPortOnPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.encapsulated.TestLinkCreationConnectorFromProperty;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.encapsulated.TestLinkCreationConnectorFromReference;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.encapsulated.TestLinkCreationConnectorFromValue;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	
	TestLinkCreationConnectorForSources.class,
	TestLinkCreationConnectorFromActorPart.class,
	TestLinkCreationConnectorFromFlowPortOnBlock.class,
	TestLinkCreationConnectorFromFlowPortOnNestedPart.class,
	TestLinkCreationConnectorFromFlowPortOnPart.class,
	TestLinkCreationConnectorFromNestedActorPart.class,
	TestLinkCreationConnectorFromNestedPart.class,
	TestLinkCreationConnectorFromNestedProperty.class,
	TestLinkCreationConnectorFromNestedReference.class,
	TestLinkCreationConnectorFromNestedValue.class,
	TestLinkCreationConnectorFromPortOnBlock.class,
	TestLinkCreationConnectorFromPortOnNestedPart.class,
	TestLinkCreationConnectorFromPortOnPart.class,
	TestLinkCreationConnectorFromPart.class,
	TestLinkCreationConnectorFromProperty.class,
	TestLinkCreationConnectorFromReference.class,
	TestLinkCreationConnectorFromValue.class
	
	})
public class AllCreationConnectorWithEncapsulatedPartTests {

}
