package org.eclipse.papyrus.core.resourceloading.tests;

import org.eclipse.papyrus.core.resourceloading.tests.testModel1.Strategy0TestModel1;
import org.eclipse.papyrus.core.resourceloading.tests.testModel1.Strategy1TestModel1;
import org.eclipse.papyrus.core.resourceloading.tests.testModel1.Strategy2TestModel1;
import org.eclipse.papyrus.core.resourceloading.tests.testModel2.Strategy0TestModel2WithModel1;
import org.eclipse.papyrus.core.resourceloading.tests.testModel2.Strategy0TestModel2WithPackage0;
import org.eclipse.papyrus.core.resourceloading.tests.testModel2.Strategy1TestModel2WithModel1;
import org.eclipse.papyrus.core.resourceloading.tests.testModel2.Strategy1TestModel2WithPackage0;
import org.eclipse.papyrus.core.resourceloading.tests.testModel2.Strategy2TestModel2WithModel1;
import org.eclipse.papyrus.core.resourceloading.tests.testModel2.Strategy2TestModel2WithPackage0;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * All tests together.
 */
@RunWith(Suite.class)
@SuiteClasses({
	// testModel1
Strategy1TestModel1.class,
Strategy2TestModel1.class,
 Strategy0TestModel1.class,
// testModel2
Strategy0TestModel2WithModel1.class,
Strategy0TestModel2WithPackage0.class,
Strategy1TestModel2WithModel1.class,
Strategy1TestModel2WithPackage0.class,
Strategy2TestModel2WithModel1.class,
Strategy2TestModel2WithPackage0.class
})
public class AllTests {
	//Test suite
}