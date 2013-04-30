package org.eclipse.papyrus.sysml.diagram.requirement.test;

import org.eclipse.papyrus.sysml.diagram.requirement.test.canonical.AllCanonicalTests;
import org.eclipse.papyrus.sysml.diagram.requirement.test.load.LoadTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All tests together.
 */
@RunWith(Suite.class)
@SuiteClasses({
// canonical
AllCanonicalTests.class,

// load
//LoadTests.class
})
public class AllTests {

}
