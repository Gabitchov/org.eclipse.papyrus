package org.eclipse.papyrus.sysml.nattable.allocation.config.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.sysml.nattable.allocation.config.messages.messages"; //$NON-NLS-1$

	public static String TableAllocationCreationTester_NotAnUMLElement;

	public static String TableAllocationCreationTester_OKMessage;

	public static String TableAllocationCreationTester_ProfileNotApplied;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
