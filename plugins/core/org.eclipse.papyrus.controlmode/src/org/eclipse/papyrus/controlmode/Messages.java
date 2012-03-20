package org.eclipse.papyrus.controlmode;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.controlmode.messages"; //$NON-NLS-1$

	public static String ControlResourceDialog_AlreadyExists;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
