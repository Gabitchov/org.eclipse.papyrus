package org.eclipse.papyrus.infra.nattable.views.config.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.nattable.views.config.messages.messages"; //$NON-NLS-1$

	public static String TableViewCreationTester_TheTableViewCanBeCreated;

	public static String TableViewCreationTester_TheTableViewCantBeCreated;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
