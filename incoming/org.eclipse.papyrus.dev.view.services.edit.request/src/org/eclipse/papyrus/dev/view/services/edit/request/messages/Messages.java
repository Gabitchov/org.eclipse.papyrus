package org.eclipse.papyrus.dev.view.services.edit.request.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.dev.view.services.edit.request.messages.messages"; //$NON-NLS-1$

	public static String RequestView_ClearTheView;

	public static String RequestView_Name;

	public static String RequestView_Time;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
