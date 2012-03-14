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

import org.eclipse.papyrus.sysml.diagram.internalblock.tests.set.encapsulation.TestSetEncapsulationDeleteConnectorFromActorPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.set.encapsulation.TestSetEncapsulationDeleteConnectorFromFlowPortOnBlock;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.set.encapsulation.TestSetEncapsulationDeleteConnectorFromFlowPortOnNestedPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.set.encapsulation.TestSetEncapsulationDeleteConnectorFromFlowPortOnPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.set.encapsulation.TestSetEncapsulationDeleteConnectorFromNestedActorPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.set.encapsulation.TestSetEncapsulationDeleteConnectorFromNestedPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.set.encapsulation.TestSetEncapsulationDeleteConnectorFromNestedProperty;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.set.encapsulation.TestSetEncapsulationDeleteConnectorFromNestedReference;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.set.encapsulation.TestSetEncapsulationDeleteConnectorFromNestedValue;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.set.encapsulation.TestSetEncapsulationDeleteConnectorFromPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.set.encapsulation.TestSetEncapsulationDeleteConnectorFromPortOnBlock;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.set.encapsulation.TestSetEncapsulationDeleteConnectorFromPortOnNestedPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.set.encapsulation.TestSetEncapsulationDeleteConnectorFromPortOnPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.set.encapsulation.TestSetEncapsulationDeleteConnectorFromProperty;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.set.encapsulation.TestSetEncapsulationDeleteConnectorFromReference;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.set.encapsulation.TestSetEncapsulationDeleteConnectorFromValue;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	
	// Lot of duplicate tests, more subtle situation should be tested.
	// These test should most probably be done in SysML service type tests, but 
	// the connector creation still require to use the end views.
	
	TestSetEncapsulationDeleteConnectorFromActorPart.class,
	TestSetEncapsulationDeleteConnectorFromFlowPortOnBlock.class,
	TestSetEncapsulationDeleteConnectorFromFlowPortOnNestedPart.class,
	TestSetEncapsulationDeleteConnectorFromFlowPortOnPart.class,
	TestSetEncapsulationDeleteConnectorFromNestedActorPart.class,
	TestSetEncapsulationDeleteConnectorFromNestedPart.class,
	TestSetEncapsulationDeleteConnectorFromNestedProperty.class,
	TestSetEncapsulationDeleteConnectorFromNestedReference.class,
	TestSetEncapsulationDeleteConnectorFromNestedValue.class,
	TestSetEncapsulationDeleteConnectorFromPart.class,
	TestSetEncapsulationDeleteConnectorFromPortOnBlock.class,
	TestSetEncapsulationDeleteConnectorFromPortOnNestedPart.class,
	TestSetEncapsulationDeleteConnectorFromPortOnPart.class,
	TestSetEncapsulationDeleteConnectorFromProperty.class,
	TestSetEncapsulationDeleteConnectorFromReference.class,
	TestSetEncapsulationDeleteConnectorFromValue.class,
	
})
public class AllSetEncapsulationTests {

}
