package org.eclipse.papyrus.properties.uml.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.properties.uml.messages.messages"; //$NON-NLS-1$

	public static String MultiplicityObservableValue_setMultiplicityCommand;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
