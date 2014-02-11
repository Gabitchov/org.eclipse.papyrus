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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.internal.core.feature.Feature;
import org.junit.Assert;
import org.junit.Test;
import org.osgi.framework.Bundle;

/**
 * suppress restriction for org.eclipse.pde.internal.core.feature.Feature;
 * 
 * @author VL222926
 *
 */
@SuppressWarnings("restriction")
public class BundlesTests {

	// Transform the version number to the regex format
	// Adds .* (Valid version numbers are e.g. 0.10.1.qualifier)
	private static final String REGEX_VERSION_NUMBER = BundleTestsUtils.PAPYRUS_VERSION.replaceAll("\\.", "\\\\.") + "\\..*"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

	private static final String REGEX_INCUBATION = ".*\\(Incubation\\)"; //$NON-NLS-1$

	private static final String BATIK_VERSION = "[1.6.0,1.7.0)"; //$NON-NLS-1$

	private static final String NATTABLE_VERSION = "1.0.0"; //$NON-NLS-1$

	private static final String PAPYRUS_VERSION = "1.0.0"; //$NON-NLS-1$

	@Test
	public void featureVersionNumberTest() {
		StringBuffer message = new StringBuffer("Wrong version number for the features:"); //$NON-NLS-1$
		int nbProblem = 0;
		final List<Feature> features = BundleTestsUtils.getPapyrusFeature();
		for(final Feature feature : features) {
			String version = feature.getVersion();
			if(!version.matches(REGEX_VERSION_NUMBER)) {
				message.append("\n"); //$NON-NLS-1$
				message.append(feature.getId());
				nbProblem++;
			}
		}
		StringBuffer errorMessage = new StringBuffer();
		errorMessage.append(nbProblem);
		errorMessage.append("problems!\n");//$NON-NLS-1$
		errorMessage.append(message.toString());
		Assert.assertTrue(errorMessage.toString(), nbProblem == 0);
	}

	/**
	 * Tests that all Papyrus Bundle name are finished by {@link #INCUBATION}
	 */
	@Test
	public void incubationTest() {
		testManifestProperty(BundleTestsUtils.BUNDLE_NAME, REGEX_INCUBATION, false, false);
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
		testManifestProperty(BundleTestsUtils.BUNDLE_VERSION, REGEX_VERSION_NUMBER, false, false);
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
		testManifestProperty(BundleTestsUtils.BUNDLE_REQUIREDEXECUTIONENVIRONMENT, BundleTestsUtils.JAVA_VERSION_REGEX, false, true);
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
		StringBuffer message = new StringBuffer();
		int nb = 0;
		for(final Bundle current : BundleTestsUtils.getPapyrusBundles()) {
			final String value = current.getHeaders().get(BundleTestsUtils.REQUIRE_BUNDLE);
			if(value == null) {
				continue;
			}
			final String[] bundles = value.split(","); //$NON-NLS-1$
			StringBuffer localMessage = new StringBuffer();
			for(final String bundle : bundles) {
				if(bundle.contains("visibility:=reexport")) { //$NON-NLS-1$
					nb++;
					if(localMessage.length() == 0) {
						localMessage.append(NLS.bind("{0} re-exports:", current.getSymbolicName())); //$NON-NLS-1$
					}
					if(bundle.contains(";")) { //$NON-NLS-1$
						localMessage.append(NLS.bind("\n  - {0}", bundle.substring(0, bundle.indexOf(";")))); //$NON-NLS-1$ //$NON-NLS-2$
					} else {
						localMessage.append(NLS.bind("\n  - {0}", bundle)); //$NON-NLS-1$ 
					}
				}
			}
			if(localMessage.length() != 0) {
				message.append(localMessage);
				message.append("\n");//$NON-NLS-1$ 
			}
		}
		StringBuffer errorMessage = new StringBuffer();
		errorMessage.append(nb);
		errorMessage.append(" problems!");//$NON-NLS-1$ 
		errorMessage.append(message);
		Assert.assertTrue(errorMessage.toString(), nb == 0);
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
	 *        boolean indicating if the tests should only be done on
	 *        JavaProject
	 */
	private void testManifestProperty(final String property, final String regex, final boolean mustBeNull, final boolean onlyOnJavaProject) {
		String message = null;
		int nb = 0;
		for(final Bundle current : BundleTestsUtils.getPapyrusBundles()) {
			if(onlyOnJavaProject && !BundleTestsUtils.isJavaProject(current)) {
				continue; // useful for oep.infra.gmfdiag.css.theme for example
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
		Assert.assertNull(nb + " problems!", message); //$NON-NLS-1$
	}

	/**
	 * Tests if the file is owned by the bundle
	 * 
	 * @param filepath
	 *        the file path
	 */
	private void fileTest(final String filepath) {
		StringBuffer buffer = new StringBuffer();
		int nb = 0;
		for(final Bundle current : BundleTestsUtils.getPapyrusBundles()) {
			URL url = current.getEntry(filepath);
			if(url == null) {
				if(buffer.length() == 0) {
					buffer.append(NLS.bind("The following bundles don't have the file {0}.", filepath)); //$NON-NLS-1$
				}
				buffer.append("\n");//$NON-NLS-1$
				buffer.append(current.getSymbolicName());
				nb++;
			}
		}
		StringBuffer errorMessage = new StringBuffer();
		errorMessage.append(nb);
		errorMessage.append(" problems!\n"); //$NON-NLS-1$
		errorMessage.append(buffer.toString());
		Assert.assertTrue(errorMessage.toString(), buffer.toString().isEmpty());
	}

	/**
	 * We want that all Papyrus dependencies in the Papyrus plugin will be
	 * define
	 */
	@Test
	public void papyrusDependencyVersionTest() {
		testPapyrusDependencies2("org.eclipse.papyrus", PAPYRUS_VERSION);//$NON-NLS-1$
	}

	/**
	 * We want that all Papyrus batik dependencies will be defines
	 */
	@Test
	public void batikDependencyVersionTest() {
		testPapyrusDependencies2("org.apache.batik", BATIK_VERSION);//$NON-NLS-1$
	}

	@Test
	public void natTableDependencyVersionText() {
		testPapyrusDependencies2("org.eclipse.nebula.widgets.nattable", NATTABLE_VERSION);//$NON-NLS-1$
	}

	@Test
	public void guavaDependencyVersionText() {
		testPapyrusDependencies2("com.google.guava", "11.0.0");//$NON-NLS-1$ //$NON-NLS-2$
	}

	public final static String REGEX_PACKAGE_WORD = "\\w(?:\\w|\\d)*";// match a //$NON-NLS-1$
																		// package
																		// name

	public static final String REGEX_PLUGIN = "(?:\\." + REGEX_PACKAGE_WORD + ")*";// match plugin name //$NON-NLS-1$ //$NON-NLS-2$

	public static final String REGEX_DEPENDENCY = "(?:;bundle-version=\"([^\"]*)\")?"; //$NON-NLS-1$

	public static class Version {

		private boolean minIncluding;

		private boolean maxIncluding;

		private int[] min = null;

		private int[] max = null;

		public Version(final String versionAsString) {
			this.minIncluding = true;
			this.maxIncluding = true;
			if(versionAsString != null) {
				this.minIncluding = !versionAsString.startsWith("("); //$NON-NLS-1$
				this.maxIncluding = !versionAsString.endsWith(")"); //$NON-NLS-1$
				final Pattern versionNumber = Pattern.compile("\\d+(\\.\\d+)*"); //$NON-NLS-1$
				final Matcher matcher = versionNumber.matcher(versionAsString);
				while(matcher.find()) {
					final String grp = matcher.group();
					final String[] versions = grp.split("\\."); //$NON-NLS-1$
					int[] vers = new int[versions.length];
					for(int i = 0; i < versions.length; i++) {
						vers[i] = Integer.parseInt(versions[i]);
					}
					if(min == null) {
						min = vers;
					} else {
						max = vers;
					}
				}
			}
			if(min == null) {
				min = new int[]{ 0, 0, 0 };
			}
			if(max == null) {
				max = new int[]{ 99, 99, 99 };
			}
		}

		public boolean inIncludedIn(final Version version) {
			// verifying intersaction between versions!
			if(compare(this.max, version.min) < 0) {
				return false;
			}
			if(compare(version.max, this.min) < 0) {
				return false;
			}
			if(compare(this.max, version.min) == 0 && (!this.maxIncluding || !version.minIncluding)) {
				return false;
			}
			if(compare(version.max, this.min) == 0 && (!version.maxIncluding || !this.minIncluding)) {
				return false;
			}

			// verifying inclusion
			if(compare(this.min, version.min) < 0) {
				return false;
			}

			if(compare(this.min, version.min) == 0 && (this.minIncluding != version.minIncluding)) {
				return false;
			}

			if(compare(this.max, version.max) > 0) {
				return false;
			}

			if(compare(this.max, version.max) == 0 && (this.maxIncluding != version.maxIncluding)) {
				return false;
			}
			return true;
		}

		/**
		 * 
		 * @param first
		 * @param second
		 * @return <ul>
		 *         <li>0 when they are equal</li>
		 *         <li>1 if first is greater than second</li>
		 *         <li>-1 if first is smaller than second</li>
		 *         </ul>
		 */
		protected int compare(int[] first, int[] second) {
			int min = Math.min(first.length, second.length);
			for(int i = 0; i < min; i++) {
				if(first[i] < second[i]) {
					return -1;
				} else if(first[i] > second[i]) {
					return 1;
				}
			}
			if(first.length == second.length) {
				return 0;
			} else if(first.length > second.length) {
				return 1;
			}
			return -1;
		}
	}

	/**
	 * 
	 * @param partialDependencyName
	 *        the fullName or a part of the name of the plugin
	 * @param wantedBundleVersionRegex
	 *        a string like this : "bundle-version=\"[1.6.0,1.7.0)\")"
	 */
	protected void testPapyrusDependencies2(final String partialDependencyName, final String wantedVersion) {
		final StringBuilder builder = new StringBuilder();
		int nb = 0;
		final Version wanted = new Version(wantedVersion);
		for(final Bundle current : BundleTestsUtils.getPapyrusBundles()) {
			final String value = current.getHeaders().get(BundleTestsUtils.REQUIRE_BUNDLE);
			if(value == null) {
				continue;
			}
			Pattern pattern = Pattern.compile("(" + partialDependencyName + REGEX_PLUGIN + ")" + REGEX_DEPENDENCY); //$NON-NLS-1$ //$NON-NLS-2$
			Matcher matcher = pattern.matcher(value);
			final StringBuilder localBuilder = new StringBuilder();
			while(matcher.find()) {
				final String pluginName = matcher.group(1);
				String versionString = null;
				if(matcher.groupCount() > 1) {
					versionString = matcher.group(2);
				}
				if(versionString == null) {
					if(localBuilder.length() == 0) {
						localBuilder.append(NLS.bind("{0} incorrect required bundle-version:\n", current.getSymbolicName())); //$NON-NLS-1$
					}
					localBuilder.append(NLS.bind("No Version number for {0}\n", pluginName)); //$NON-NLS-1$
					nb++;
				} else {
					Version version = new Version(versionString);
					if(!version.inIncludedIn(wanted)) {
						if(localBuilder.length() == 0) {
							localBuilder.append(NLS.bind("{0} incorrect required bundle-version:\n", current.getSymbolicName())); //$NON-NLS-1$
						}
						localBuilder.append(NLS.bind("Bad version for {0}\n", pluginName)); //$NON-NLS-1$
						nb++;
					}
				}
			}
			if(localBuilder.length() != 0) {
				builder.append(localBuilder.toString());
				builder.append("\n");//$NON-NLS-1$
			}
		}
		if(builder.length() != 0) {
			builder.insert(0, NLS.bind("{0} problems. We want this version : {1} for the plugin {2}\n", new String[]{ Integer.toString(nb), wantedVersion, partialDependencyName })); //$NON-NLS-1$
		}
		Assert.assertTrue(builder.toString(), builder.length() == 0);
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
	public void pluginIDTest() {
		StringBuffer errorMessage = new StringBuffer();
		StringBuffer warningMessage = new StringBuffer();
		final Collection<String> possibleIds = new ArrayList<String>();
		possibleIds.add("ID");//$NON-NLS-1$ 
		possibleIds.add("PLUGIN_ID");//$NON-NLS-1$ 
		int nbError = 0;
		int nbWarning = 0;
		for(final Bundle current : BundleTestsUtils.getPapyrusBundles()) {
			if(!BundleTestsUtils.isJavaProject(current)) {
				continue; // useful for oep.infra.gmfdiag.css.theme for example
			}
			final String activator = current.getHeaders().get("Bundle-Activator"); //$NON-NLS-1$
			if(activator != null) {
				try {
					final Class<?> activatorClass = current.loadClass(activator);
					Field plugin_id_field = null;
					for(final Field currentField : activatorClass.getFields()) {
						final String fieldName = currentField.getName();
						if(possibleIds.contains(fieldName)) {
							plugin_id_field = currentField;
							break;
						}
					}
					if(plugin_id_field != null) {
						final String plugin_id = (String)plugin_id_field.get(activatorClass);
						if(!plugin_id.equals(current.getSymbolicName())) {
							nbError++;
							errorMessage.append(NLS.bind("The field PLUGIN_ID of the plugin {0} is not equals to the plugin name.\n", current.getSymbolicName())); //$NON-NLS-1$
						}
					} else {
						// Never happens. An exception is thrown.
						nbWarning++;
						warningMessage.append(NLS.bind("The activator of {0} has no field named PLUGIN_ID.\n", current.getSymbolicName())); //$NON-NLS-1$
					}
				} catch (final Exception e) {
					errorMessage.append(NLS.bind("Exception occured with the plugin {0} \n {1} \n", new Object[]{ current.getSymbolicName(), e })); //$NON-NLS-1$
				}
			}

		}
		StringBuffer finalErrorMessage = new StringBuffer();
		finalErrorMessage.append(nbError);
		finalErrorMessage.append(" problems! ");//$NON-NLS-1$
		finalErrorMessage.append(errorMessage);
		Assert.assertTrue(finalErrorMessage.toString(), nbError == 0); //$NON-NLS-1$

		// Do not fail on warnings
		//Assert.assertTrue(nbWarning + "warning!" + warningMessage, nbWarning == 0);//$NON-NLS-1$ 
	}

}
