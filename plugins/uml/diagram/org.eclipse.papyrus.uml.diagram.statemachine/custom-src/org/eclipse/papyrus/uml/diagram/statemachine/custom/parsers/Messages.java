package org.eclipse.papyrus.uml.diagram.statemachine.custom.parsers;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.diagram.statemachine.custom.parsers.messages"; //$NON-NLS-1$

	public static String DoActivityStateBehaviorParser_DO_KEYWORD;

	public static String EntryStateBehaviorParser_ENTRY_KEYWORD;

	public static String ExitStateBehaviorParser_EXIT_KEYWORD;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
