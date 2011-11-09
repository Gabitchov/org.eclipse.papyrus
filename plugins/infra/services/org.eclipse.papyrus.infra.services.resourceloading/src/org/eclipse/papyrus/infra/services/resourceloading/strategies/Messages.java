package org.eclipse.papyrus.infra.services.resourceloading.strategies;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.services.resourceloading.strategies.messages"; //$NON-NLS-1$

	public static String AskUserStrategy_0;

	public static String AskUserStrategy_12;

	public static String AskUserStrategy_ERROR;

	public static String AskUserStrategy_LOAD_RESOURCE;

	public static String AskUserStrategy_MESSAGE_PART_1;

	public static String AskUserStrategy_MESSAGE_PART_2;

	public static String AskUserStrategy_MESSAGE_PART3;

	public static String AskUserStrategy_NO;

	public static String AskUserStrategy_NO_FOR_ALL;

	public static String AskUserStrategy_NO_FOR_ALL_URI;

	public static String AskUserStrategy_UNABLE_TO_LOAD;

	public static String AskUserStrategy_YES;

	public static String AskUserStrategy_YES_FOR_ALL_URI;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
