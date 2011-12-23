package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Main test suite class
 */
@RunWith(Suite.class)
@SuiteClasses({ 
 AllCopyPasteTests.class,
 AllCreationCustomTests.class,
 AllCreationInheritedTests.class,
 AllDiagramTests.class,
 AllDnDCustomTests.class,
 AllDnDInheritedTests.class,
 AllCreationLinkTests.class,
 AllCreationAssociationTests.class,
 AllDnDLinkTests.class,
 AllDeletionTests.class, 
 AllUtilsTests.class
 })
public class AllTests {

}
