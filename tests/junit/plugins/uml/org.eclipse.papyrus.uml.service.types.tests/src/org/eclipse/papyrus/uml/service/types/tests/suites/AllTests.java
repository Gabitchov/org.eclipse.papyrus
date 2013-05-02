package org.eclipse.papyrus.uml.service.types.tests.suites;

import org.eclipse.papyrus.uml.service.types.tests.creation.CreateElementTest;
import org.eclipse.papyrus.uml.service.types.tests.creation.CreatePureUMLElementTest;
import org.eclipse.papyrus.uml.service.types.tests.deletion.DeletePureUMLElementTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Main Test suite.
 */
@RunWith(Suite.class)
@SuiteClasses({ 
	//TestElementTypeRegistryContent.class,
	CreatePureUMLElementTest.class, // pure uml tests, only element edit service
	CreateElementTest.class, 
	DeletePureUMLElementTest.class,
	})
public class AllTests {

}
