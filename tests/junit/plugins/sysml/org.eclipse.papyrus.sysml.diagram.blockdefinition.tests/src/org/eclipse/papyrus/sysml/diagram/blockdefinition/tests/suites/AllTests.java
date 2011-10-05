package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ 
	AllCreationCustomTests.class, 
	AllCreationInheritedTests.class, 
	AllDiagramTests.class, 
	AllDnDCustomTests.class, 
	AllDnDInheritedTests.class,
	AllCreationLinkTests.class,
	AllCreationAssociationTests.class,
	AllDnDLinkTests.class,
	AllDeletionTests.class })
public class AllTests {

}
