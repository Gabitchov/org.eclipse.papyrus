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

import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.association.TestLinkCreationAssociationCompositeDirectedForSources;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.association.TestLinkCreationAssociationCompositeDirectedFromBlock;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.association.TestLinkCreationAssociationCompositeForSources;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.association.TestLinkCreationAssociationCompositeFromBlock;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.association.TestLinkCreationAssociationNoneDirectedForSources;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.association.TestLinkCreationAssociationNoneDirectedFromBlock;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.association.TestLinkCreationAssociationNoneForSources;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.association.TestLinkCreationAssociationNoneFromBlock;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.association.TestLinkCreationAssociationSharedDirectedForSources;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.association.TestLinkCreationAssociationSharedDirectedFromBlock;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.association.TestLinkCreationAssociationSharedForSources;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.association.TestLinkCreationAssociationSharedFromBlock;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ 
	TestLinkCreationAssociationCompositeDirectedForSources.class, 
	TestLinkCreationAssociationCompositeForSources.class, 
	TestLinkCreationAssociationNoneDirectedForSources.class, 
	TestLinkCreationAssociationNoneForSources.class, 
	TestLinkCreationAssociationSharedDirectedForSources.class, 
	TestLinkCreationAssociationSharedForSources.class, 
	TestLinkCreationAssociationCompositeFromBlock.class,
	TestLinkCreationAssociationCompositeDirectedFromBlock.class,
	TestLinkCreationAssociationNoneFromBlock.class,
	TestLinkCreationAssociationNoneDirectedFromBlock.class,
	TestLinkCreationAssociationSharedFromBlock.class,
	TestLinkCreationAssociationSharedDirectedFromBlock.class
	})
public class AllCreationAssociationTests {

}
