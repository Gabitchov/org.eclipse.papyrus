package org.eclipse.papyrus.xwt.internal;

import org.eclipse.papyrus.xwt.IXWTInitializer;
import org.eclipse.papyrus.xwt.IXWTLoader;
import org.eclipse.papyrus.xwt.XWT;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator, IXWTInitializer {

	private boolean initialized;

	public void start(BundleContext context) throws Exception {
		initialized = false;
		XWT.addInitializer(this);
		XWT.runOnUIThread(new Runnable() {

			public void run() {
			}
		});
	}

	public void initialize(IXWTLoader loader) {
		initialized = true;
	}

	public void stop(BundleContext context) throws Exception {
	}

	public boolean isInitialized() {
		return initialized;
	}
}
