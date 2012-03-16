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

import org.eclipse.papyrus.sysml.diagram.internalblock.tests.reorient.dependency.TestLinkReorientSourceDependency;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.reorient.dependency.TestLinkReorientTargetDependency;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	
	TestLinkReorientSourceDependency.class,
	TestLinkReorientTargetDependency.class,
	org.eclipse.papyrus.sysml.diagram.internalblock.tests.reorient.connector.TestLinkReorientSourceConnector.class,
	org.eclipse.papyrus.sysml.diagram.internalblock.tests.reorient.connector.TestLinkReorientTargetConnector.class,
	org.eclipse.papyrus.sysml.diagram.internalblock.tests.reorient.connector.delegation.TestLinkReorientSourceConnector.class,
	org.eclipse.papyrus.sysml.diagram.internalblock.tests.reorient.connector.delegation.TestLinkReorientTargetConnector.class,
	org.eclipse.papyrus.sysml.diagram.internalblock.tests.reorient.connector.encapsulated.TestLinkReorientSourceConnector.class,
	org.eclipse.papyrus.sysml.diagram.internalblock.tests.reorient.connector.encapsulated.TestLinkReorientTargetConnector.class,
	})
public class AllReorientLinkTests {

}
