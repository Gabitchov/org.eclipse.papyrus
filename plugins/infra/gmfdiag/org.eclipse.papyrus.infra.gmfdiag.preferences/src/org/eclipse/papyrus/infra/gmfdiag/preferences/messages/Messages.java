package org.eclipse.papyrus.infra.gmfdiag.preferences.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.gmfdiag.preferences.messages.messages"; //$NON-NLS-1$

	public static String LabelGroup_Labels_To_Display;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
