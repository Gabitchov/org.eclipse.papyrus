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

import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.dependency.TestLinkCreationDependencyForSources;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.dependency.TestLinkCreationDependencyFromActorPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.dependency.TestLinkCreationDependencyFromBlock;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.dependency.TestLinkCreationDependencyFromConstraint;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.dependency.TestLinkCreationDependencyFromConstraintCN;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.dependency.TestLinkCreationDependencyFromFlowPortOnBlock;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.dependency.TestLinkCreationDependencyFromFlowPortOnNestedPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.dependency.TestLinkCreationDependencyFromFlowPortOnPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.dependency.TestLinkCreationDependencyFromNestedActorPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.dependency.TestLinkCreationDependencyFromNestedPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.dependency.TestLinkCreationDependencyFromNestedProperty;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.dependency.TestLinkCreationDependencyFromNestedReference;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.dependency.TestLinkCreationDependencyFromNestedValue;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.dependency.TestLinkCreationDependencyFromPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.dependency.TestLinkCreationDependencyFromPortOnBlock;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.dependency.TestLinkCreationDependencyFromPortOnNestedPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.dependency.TestLinkCreationDependencyFromPortOnPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.dependency.TestLinkCreationDependencyFromProperty;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.dependency.TestLinkCreationDependencyFromReference;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.dependency.TestLinkCreationDependencyFromValue;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	
	TestLinkCreationDependencyForSources.class,
	TestLinkCreationDependencyFromActorPart.class,
	TestLinkCreationDependencyFromBlock.class,
	TestLinkCreationDependencyFromConstraint.class,
	TestLinkCreationDependencyFromConstraintCN.class,
	TestLinkCreationDependencyFromFlowPortOnBlock.class,
	TestLinkCreationDependencyFromFlowPortOnNestedPart.class,
	TestLinkCreationDependencyFromFlowPortOnPart.class,
	TestLinkCreationDependencyFromNestedActorPart.class,
	TestLinkCreationDependencyFromNestedPart.class,
	TestLinkCreationDependencyFromNestedProperty.class,
	TestLinkCreationDependencyFromNestedReference.class,
	TestLinkCreationDependencyFromNestedValue.class,
	TestLinkCreationDependencyFromPart.class,
	TestLinkCreationDependencyFromPortOnBlock.class,
	TestLinkCreationDependencyFromPortOnNestedPart.class,
	TestLinkCreationDependencyFromPortOnPart.class,
	TestLinkCreationDependencyFromProperty.class,
	TestLinkCreationDependencyFromReference.class,
	TestLinkCreationDependencyFromValue.class
	
	})
public class AllCreationDependencyTests {

}
