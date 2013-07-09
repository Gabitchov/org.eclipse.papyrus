package org.eclipse.papyrus.uml.nattable.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.nattable.messages.messages"; //$NON-NLS-1$

	public static String StereotypePropertyHeaderLabelProvider_RequiredProfileNotFound;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
