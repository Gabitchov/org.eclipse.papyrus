/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bugs 402525, 323802
 *  
 *****************************************************************************/
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


/**
 * Test class for all tests for Papyrus
 */
@RunWith(AllTests.AllTestsRunner.class)
public class AllTests {

	public static final List<ITestSuiteClass> suiteClasses;
	/** list of classes to launch */
	static {
		suiteClasses = new ArrayList<ITestSuiteClass>();

		/* **************** plugins *********************** */
		/* developper */
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.bundles.tests.AllTests.class));

		/* core */
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID, "org.eclipse.papyrus.infra.core.tests.AllTests"));
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.infra.core.sasheditor.Activator.PLUGIN_ID, "org.eclipse.papyrus.infra.core.sasheditor.tests.AllTests"));
		suiteClasses.add(new FragmentTestSuiteClass("org.eclipse.papyrus.infra.core.sasheditor.di", "org.eclipse.papyrus.infra.core.sasheditor.di.tests.AllTests"));
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.infra.services.resourceloading.Activator.PLUGIN_ID, "org.eclipse.papyrus.core.resourceloading.tests.AllTests"));

		/* infra */
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.infra.services.edit.Activator.PLUGIN_ID, "org.eclipse.papyrus.infra.services.edit.tests.suites.AllTests"));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.services.labelprovider.tests.AllTests.class));
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.infra.emf.Activator.PLUGIN_ID, "org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceTest"));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.extendedtypes.tests.AllTests.class));
		//		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.services.openelement.tests.AllTests.class));
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.commands.Activator.PLUGIN_ID, "org.eclipse.papyrus.infra.gmfdiag.commands.tests.AllTests"));
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.infra.emf.readonly.Activator.PLUGIN_ID, "org.eclipse.papyrus.infra.emf.readonly.tests.AllTests"));

		/* views */
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.views.modelexplorer.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.customization.properties.tests.AllTests.class));

		/* integration */
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.editor.integration.tests.AllTests.class));

		/* search */
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.search.tests.suites.AllTests.class));

		/* css */
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.gmfdiag.css.tests.tests.AllTests.class));

		//
		/* sysml moved to a separate launcher */
		//

		/* uml */
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.uml.diagram.common.Activator.ID, "org.eclipse.papyrus.diagram.common.tests.AllTests"));
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.uml.service.types.Activator.PLUGIN_ID, "org.eclipse.papyrus.uml.service.types.tests.suites.AllTests"));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.modelexplorer.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.dnd.tests.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.tools.tests.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.diagram.stereotypeproperty.AllTests.class));

		/* uml idagrams */
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.diagram.clazz.test.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.activity.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.pkg.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.deployment.test.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.component.test.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.timing.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.usecase.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.composite.test.AllTests.class));
		//suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.sequence.tests.AllTests.class)); //Disabled. They currently do not run on Hudson
		//		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.interactionoverview.tests.AllTests.class)); //Disabled. They currently do not run on Hudson
		//

		//nattable tests
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.nattable.tests.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.sysml.nattable.requirement.tests.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.nattable.views.tests.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.nattable.model.editor.tests.tests.AllTests.class));


		//end
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
