package org.eclipse.papyrus.bundles.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.internal.runtime.InternalPlatform;
import org.eclipse.osgi.launch.EquinoxFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

public class BundleTestsUtils {

	// This version number should be changed at each release
	public static final String PAPYRUS_VERSION = "0.9.0"; //$NON-NLS-1$

	public static final String INCUBATION = "(Incubation)"; //$NON-NLS-1$

	public static final String VENDOR_NAME = "Eclipse Modeling Project"; //$NON-NLS-1$

	public static final String BUNDLE_NAME = "Bundle-Name"; //$NON-NLS-1$

	public static final String BUNDLE_VENDOR = "Bundle-Vendor"; //$NON-NLS-1$

	public static final String BUNDLE_VERSION = "Bundle-Version"; //$NON-NLS-1$

	public static final String PAPYRUS_PREFIX = "org.eclipse.papyrus."; //$NON-NLS-1$

	public static final String BUNDLE_REQUIREDEXECUTIONENVIRONMENT = "Bundle-RequiredExecutionEnvironment"; //$NON-NLS-1$

	public static final String JAVA_VERSION_5 = "J2SE-1.5";//$NON-NLS-1$

	private BundleTestsUtils() {
		// to prevent instanciation
	}

	/**
	 * 
	 * @return the Bundle with a name beginning by {@link #PAPYRUS_PREFIX}
	 */
	public static List<Bundle> getPapyrusBundles() {
		final List<Bundle> papyrusBundle = new ArrayList<Bundle>();
		BundleContext context = InternalPlatform.getDefault().getBundleContext();
		org.osgi.framework.Bundle[] bundles = context.getBundles();
		for(int i = 0; i < bundles.length; i++) {
			String currentName = bundles[i].getSymbolicName();
			if(currentName.startsWith(PAPYRUS_PREFIX)) {
				papyrusBundle.add(bundles[i]);
			}
		}
		EquinoxFactory factory = new EquinoxFactory();

		return papyrusBundle;
	}
}