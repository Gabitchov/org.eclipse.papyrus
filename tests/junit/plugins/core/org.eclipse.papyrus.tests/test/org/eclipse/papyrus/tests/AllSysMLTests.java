package org.eclipse.papyrus.tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.papyrus.tests.launcher.FragmentTestSuiteClass;
import org.eclipse.papyrus.tests.launcher.ITestSuiteClass;
import org.eclipse.papyrus.tests.launcher.PluginTestSuiteClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;

@RunWith(AllSysMLTests.AllTestsRunner.class)
public class AllSysMLTests {

	public static final List<ITestSuiteClass> suiteClasses;

	static {
		suiteClasses = new ArrayList<ITestSuiteClass>();

		/* syml */
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.sysml.tests.SysmlAllTests.class));
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.sysml.service.types.Activator.PLUGIN_ID, "org.eclipse.papyrus.sysml.service.types.tests.suites.AllTests"));
		suiteClasses.add(new FragmentTestSuiteClass("org.eclipse.papyrus.sysml.modelexplorer", "org.eclipse.papyrus.sysml.modelexplorer.tests.suites.AllTests"));
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.sysml.diagram.internalblock.Activator.PLUGIN_ID, "org.eclipse.papyrus.sysml.diagram.internalblock.tests.suites.AllTests"));
		suiteClasses.add(new FragmentTestSuiteClass("org.eclipse.papyrus.sysml.diagram.blockdefinition", "org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.suites.AllTests"));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.sysml.diagram.requirement.test.AllTests.class));
		suiteClasses.add(new FragmentTestSuiteClass("org.eclipse.papyrus.sysml.diagram.parametric", "org.eclipse.papyrus.sysml.diagram.parametric.tests.suites.AllTests"));
	}


	/**
	 * Finds and runs tests.
	 */
	public static class AllTestsRunner extends Suite {

		/**
		 * Constructor.
		 * 
		 * @param clazz
		 *        the suite class � AllTests2
		 * @throws InitializationError
		 *         if there's a problem
		 * @throws org.junit.runners.model.InitializationError
		 */
		public AllTestsRunner(final Class<?> clazz) throws InitializationError {
			super(clazz, getSuites());
		}
	}

	/**
	 * Returns the list of test classes
	 * 
	 * @return the list of test classes
	 */
	private static Class<?>[] getSuites() {
		// retrieve all test suites.
		final Collection<Class<?>> suites = new ArrayList<Class<?>>();
		for(final ITestSuiteClass testSuiteClass : suiteClasses) {
			final Class<?> class_ = testSuiteClass.getMainTestSuiteClass();
			if(class_ != null) {
				suites.add(class_);
			} else {
				System.err.println(testSuiteClass + " does not give a correct test suite class");
			}
		}
		return suites.toArray(new Class<?>[]{});
	}
}
