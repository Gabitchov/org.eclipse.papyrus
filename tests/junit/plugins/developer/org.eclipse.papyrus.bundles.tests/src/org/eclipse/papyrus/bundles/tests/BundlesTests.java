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

import org.eclipse.core.runtime.Assert;
import org.junit.Test;
import org.osgi.framework.Bundle;
import org.osgi.framework.Version;

public class BundlesTests {

	/**
	 * Tests that all Papyrus Bundle name are finished by {@link #INCUBATION}
	 */
	@Test
	public void incubationTests() {
		String message = null;
		int nb = 0;
		for(Bundle current : BundleTestsUtils.getPapyrusBundles()) {
			final String name = current.getHeaders().get(BundleTestsUtils.BUNDLE_NAME);
			if(name == null || name.equals("") || !name.endsWith(BundleTestsUtils.INCUBATION)) { //$NON-NLS-1$
				if(message == null) {
					message = "The following bundles have a problem with Incubation : "; //$NON-NLS-1$
				}
				message += "\n "; //$NON-NLS-1$
				message += current.getSymbolicName();
				nb++;
			}
		}
		Assert.isTrue(message == null, nb + " problems!" + message); //$NON-NLS-1$
	}

	/**
	 * Tests the provider name (should be EL
	 */
	@Test
	public void providerTest() {
		String message = null;
		int nb = 0;
		for(Bundle current : BundleTestsUtils.getPapyrusBundles()) {
			final String providerName = current.getHeaders().get(BundleTestsUtils.BUNDLE_VENDOR);
			if(providerName == null || providerName.equals("") || !providerName.equals(BundleTestsUtils.PROVIDER_NAME)) { //$NON-NLS-1$
				if(message == null) {
					message = "The following bundles have a problem with the providerName : "; //$NON-NLS-1$
				}
				message += " \n "; //$NON-NLS-1$
				message += current.getSymbolicName();
				nb++;
			}
		}
		Assert.isTrue(message == null, nb + " problems!" + message); //$NON-NLS-1$
	}

	/**
	 * Tests that each papyrus plugins have the correct version
	 */
	@Test
	public void versionTests() {
		String message = null;
		int nb = 0;
		for(Bundle current : BundleTestsUtils.getPapyrusBundles()) {
			final String version = current.getHeaders().get(BundleTestsUtils.BUNDLE_VERSION);
			if(version == null || version.equals("") || !version.startsWith(BundleTestsUtils.PAPYRUS_VERSION)) { //$NON-NLS-1$
				if(message == null) {
					message = "The following bundles have a problem with the version number "; //$NON-NLS-1$
				}
				message += "\n "; //$NON-NLS-1$
				message += current.getSymbolicName();
				nb++;
			}
		}
		Assert.isTrue(message == null, nb + " problems!" + message); //$NON-NLS-1$
	}

	/**
	 * Tests if the version number is qualified
	 */
	@Test
	public void isQualifiedVersionNumber() {
		String message = null;
		int nb = 0;
		for(Bundle current : BundleTestsUtils.getPapyrusBundles()) {
			final Version version = current.getVersion();
			if(version.getQualifier() == null || version.getQualifier().equals("")) { //$NON-NLS-1$
				if(message == null) {
					message = "The following bundles are nohave a problem with the version number "; //$NON-NLS-1$
				}
				message += "\n "; //$NON-NLS-1$
				message += current.getSymbolicName();
				nb++;
			}
		}
		Assert.isTrue(message == null, nb + " problems!" + message); //$NON-NLS-1$
	}
}
