/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.bundles.tests;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.Enumeration;

import org.eclipse.osgi.framework.internal.core.BundleFragment;
import org.eclipse.osgi.util.NLS;
import org.junit.Assert;
import org.junit.Test;
import org.osgi.framework.Bundle;

public class BundlesTests {

	/**
	 * Tests that all Papyrus Bundle name are finished by {@link #INCUBATION}
	 */
	@Test
	public void incubationTest() {
		testManifestProperty(BundleTestsUtils.BUNDLE_NAME, ".*\\(Incubation\\)", false, false); //$NON-NLS-1$
	}

	/**
	 * Tests the provider name (should be EL
	 */
	@Test
	public void vendorTest() {
		testManifestProperty(BundleTestsUtils.BUNDLE_VENDOR, BundleTestsUtils.VENDOR_NAME, false, false);
	}

	/**
	 * Tests that each papyrus plugins have the correct version
	 */
	@Test
	public void versionTest() {
		testManifestProperty(BundleTestsUtils.BUNDLE_VERSION, "0\\.10\\.0\\..*", false, false); //$NON-NLS-1$
	}

	/**
	 * Tests if the file about.html is included to the plugin
	 */
	@Test
	public void aboutTest() {
		fileTest("/about.html"); //$NON-NLS-1$
	}

	/**
	 * Tests the java version
	 */
	@Test
	public void javaVersionTest() {
		testManifestProperty(BundleTestsUtils.BUNDLE_REQUIREDEXECUTIONENVIRONMENT, BundleTestsUtils.JAVA_VERSION_5, false, true);
	}

	/**
	 * Tests that we don't use import package
	 */
	@Test
	public void importPackage() {
		testManifestProperty(BundleTestsUtils.BUNDLE_IMPORT_PACKAGE, "", true, false); //$NON-NLS-1$
	}

	/**
	 * This test verify that we doesn't re-export dependencies
	 */
	@Test
	public void reexportDependencies() {
		String message = null;
		int nb = 0;
		for(final Bundle current : BundleTestsUtils.getPapyrusBundles()) {
			final String value = current.getHeaders().get(BundleTestsUtils.REQUIRE_BUNDLE);
			if(value == null) {
				continue;
			}
			final String[] bundles = value.split(","); //$NON-NLS-1$
			String localMessage = null;
			for(final String bundle : bundles) {
				if(bundle.contains("visibility:=reexport")) { //$NON-NLS-1$
					nb++;
					if(localMessage == null) {
						localMessage = NLS.bind("{0} re-exports:", current.getSymbolicName()); //$NON-NLS-1$
					}
					if(bundle.contains(";")) { //$NON-NLS-1$
						localMessage += NLS.bind("\n  - {0}", bundle.substring(0, bundle.indexOf(";"))); //$NON-NLS-1$ //$NON-NLS-2$
					} else {
						localMessage += NLS.bind("\n  - {0}", bundle); //$NON-NLS-1$ 
					}
				}
			}
			if(localMessage != null) {
				if(message == null) {
					message = ""; //$NON-NLS-1$
				}
				message += localMessage + "\n"; //$NON-NLS-1$
			}
		}
		Assert.assertNull(nb + " problems! " + message, message); //$NON-NLS-1$
	}

	/**
	 * Tests if a the value of a property in the Manifest is correct
	 * 
	 * @param property
	 *        the property to test
	 * @param regex
	 *        the regular expression to test the property
	 * @param mustBeNull
	 *        indicates that the value for the property must be <code>null</code>
	 * @param onlyOnJavaProject
	 *        boolean indicating if the tests should only be done on JavaProject
	 */
	private void testManifestProperty(final String property, final String regex, final boolean mustBeNull, final boolean onlyOnJavaProject) {
		String message = null;
		int nb = 0;
		for(final Bundle current : BundleTestsUtils.getPapyrusBundles()) {
			if(onlyOnJavaProject && !BundleTestsUtils.isJavaProject(current)) {
				continue; //useful for oep.infra.gmfdiag.css.theme for example
			}
			final String value = current.getHeaders().get(property);
			boolean result = false;
			if(mustBeNull) {
				result = (value == null);
			} else if(value != null) {
				result = value.matches(regex);
			}
			if(!result) {
				if(message == null) {
					message = "Wrong " + property + " for :"; //$NON-NLS-1$ //$NON-NLS-2$
				}
				message += "\n "; //$NON-NLS-1$
				message += current.getSymbolicName();
				nb++;
			}
		}
		Assert.assertNull(nb + " problems! " + message, message); //$NON-NLS-1$
	}

	/**
	 * Tests if the file is owned by the bundle
	 * 
	 * @param filepath
	 *        the file path
	 */
	private void fileTest(final String filepath) {
		String message = null;
		int nb = 0;
		for(final Bundle current : BundleTestsUtils.getPapyrusBundles()) {
			URL url = current.getResource(filepath);
			//specific behavior for the fragment!
			if((url == null) && (current instanceof BundleFragment)) {
				final BundleFragment fragment = (BundleFragment)current;
				final Enumeration<URL> entries = fragment.findEntries("/", filepath, false); //$NON-NLS-1$
				if(entries != null) {
					if(entries.hasMoreElements()) {
						url = entries.nextElement();
					}
				}
			}

			if(url == null) {
				if(message == null) {
					message = "The following bundles don't have the file about.html :"; //$NON-NLS-1$
				}
				message += "\n "; //$NON-NLS-1$
				message += current.getSymbolicName();
				nb++;
			}
		}
		Assert.assertNull(nb + " problems! " + message, message); //$NON-NLS-1$
	}

	/**
	 * We want that all Papyrus dependencies in the Papyrus plugin will be define
	 */
	@Test
	public void papyrusDependencyVersionTest() {
		String message = null;
		int nb = 0;
		for(final Bundle current : BundleTestsUtils.getPapyrusBundles()) {
			final String value = current.getHeaders().get(BundleTestsUtils.REQUIRE_BUNDLE);
			if(value == null) {
				continue;
			}
			final String[] bundles = value.split(","); //$NON-NLS-1$
			String localMessage = null;
			for(final String bundle : bundles) {
				if(bundle.contains("org.eclipse.papyrus")) { //$NON-NLS-1$
					if(!bundle.contains("bundle-version=" + '"' + "0.10.0" + '"')) { //$NON-NLS-1$ //$NON-NLS-2$
						nb++;
						if(localMessage == null) {
							localMessage = NLS.bind("{0} incorrect required bundle-version:", current.getSymbolicName()); //$NON-NLS-1$
						}
						if(bundle.contains(";")) { //$NON-NLS-1$
							localMessage += NLS.bind("\n  - {0}", bundle.substring(0, bundle.indexOf(";"))); //$NON-NLS-1$ //$NON-NLS-2$
						} else {
							localMessage += NLS.bind("\n  - {0}", bundle); //$NON-NLS-1$ 
						}
					}
				}
			}
			if(localMessage != null) {
				if(message == null) {
					message = ""; //$NON-NLS-1$
				}
				message += localMessage + "\n"; //$NON-NLS-1$
			}
		}
		Assert.assertNull(nb + " problems! " + message, message); //$NON-NLS-1$
	}

	/**
	 * This test verify that the plugin contains pdoc file
	 */
	@Test
	public void documentationFileTest() {
		String message = null;
		int nb = 0;
		for(final Bundle bundle : BundleTestsUtils.getPapyrusBundles()) {
			final URL res = bundle.getResource("plugin.pdoc"); //$NON-NLS-1$
			if(res == null) {
				nb++;
				if(message == null) {
					message = "No file plugin.pdoc found for:"; //$NON-NLS-1$
				}
				message += NLS.bind("\n  - {0}", bundle.getSymbolicName()); //$NON-NLS-1$
			}
		}
		Assert.assertNull(nb + " problems! " + message, message); //$NON-NLS-1$
	}

	/**
	 * verify that the field PLUGIN_ID is equals to the plugin name
	 */
	@Test
	public void PLUGIN_ID_Test() {
		String message = ""; //$NON-NLS-1$
		int nb = 0;
		for(final Bundle current : BundleTestsUtils.getPapyrusBundles()) {
			if(!BundleTestsUtils.isJavaProject(current)) {
				continue; //useful for oep.infra.gmfdiag.css.theme for example
			}
			final String activator = current.getHeaders().get("Bundle-Activator"); //$NON-NLS-1$
			if(activator != null) {
				try {
					final Class<?> activatorClass = current.loadClass(activator);
					Field plugin_id_field;
					plugin_id_field = activatorClass.getField("PLUGIN_ID"); //$NON-NLS-1$
					if(plugin_id_field != null) {
						final String plugin_id = (String)plugin_id_field.get(activatorClass);
						if(!plugin_id.equals(current.getSymbolicName())) {
							nb++;
							message += NLS.bind("The field PLUGIN_ID of the plugin {0} is not equals to the plugin name.\n", current.getSymbolicName()); //$NON-NLS-1$
						}
					} else {
						//Never happens. An exception is thrown.
						nb++;
						message += NLS.bind("The activator of {0} has no field named PLUGIN_ID.\n", current.getSymbolicName()); //$NON-NLS-1$
					}
				} catch (final Exception e) {
					message += NLS.bind("Exception occured with the plugin {0} \n {1} \n", new Object[]{ current.getSymbolicName(), e }); //$NON-NLS-1$
				}
			}

		}
		Assert.assertTrue(nb + " problems! " + message, nb == 0); //$NON-NLS-1$ 
	}

}
