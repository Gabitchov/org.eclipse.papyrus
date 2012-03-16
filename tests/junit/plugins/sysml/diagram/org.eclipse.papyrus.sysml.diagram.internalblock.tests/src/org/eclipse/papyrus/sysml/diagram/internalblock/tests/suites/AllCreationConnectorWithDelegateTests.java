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

import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.delegation.TestCreationAndTestDelegateFromActorPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.delegation.TestCreationAndTestDelegateFromFlowPortOnBlock;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.delegation.TestCreationAndTestDelegateFromFlowPortOnNestedPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.delegation.TestCreationAndTestDelegateFromFlowPortOnPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.delegation.TestCreationAndTestDelegateFromNestedActorPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.delegation.TestCreationAndTestDelegateFromNestedPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.delegation.TestCreationAndTestDelegateFromNestedProperty;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.delegation.TestCreationAndTestDelegateFromNestedReference;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.delegation.TestCreationAndTestDelegateFromNestedValue;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.delegation.TestCreationAndTestDelegateFromPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.delegation.TestCreationAndTestDelegateFromPortOnBlock;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.delegation.TestCreationAndTestDelegateFromPortOnNestedPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.delegation.TestCreationAndTestDelegateFromPortOnPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.delegation.TestCreationAndTestDelegateFromProperty;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.delegation.TestCreationAndTestDelegateFromReference;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.delegation.TestCreationAndTestDelegateFromValue;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	
	TestCreationAndTestDelegateFromActorPart.class,
	TestCreationAndTestDelegateFromFlowPortOnBlock.class,
	TestCreationAndTestDelegateFromFlowPortOnNestedPart.class,
	TestCreationAndTestDelegateFromFlowPortOnPart.class,
	TestCreationAndTestDelegateFromNestedActorPart.class,
	TestCreationAndTestDelegateFromNestedPart.class,
	TestCreationAndTestDelegateFromNestedProperty.class,
	TestCreationAndTestDelegateFromNestedReference.class,
	TestCreationAndTestDelegateFromNestedValue.class,
	TestCreationAndTestDelegateFromPortOnBlock.class,
	TestCreationAndTestDelegateFromPortOnNestedPart.class,
	TestCreationAndTestDelegateFromPortOnPart.class,
	TestCreationAndTestDelegateFromPart.class,
	TestCreationAndTestDelegateFromProperty.class,
	TestCreationAndTestDelegateFromReference.class,
	TestCreationAndTestDelegateFromValue.class
	
	})
public class AllCreationConnectorWithDelegateTests {

}
