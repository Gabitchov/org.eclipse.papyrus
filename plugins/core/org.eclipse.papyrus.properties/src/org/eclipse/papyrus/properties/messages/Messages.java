package org.eclipse.papyrus.properties.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.properties.messages.messages"; //$NON-NLS-1$

	public static String Preferences_Contexts;

	public static String Preferences_Custom;

	public static String Preferences_Plugin;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
