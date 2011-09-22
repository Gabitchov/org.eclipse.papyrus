package org.eclipse.papyrus.importt.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.importt.messages.messages"; //$NON-NLS-1$

	public static String ImportPackageFromFileHandler_SelectRegisteredModelLibrary;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
