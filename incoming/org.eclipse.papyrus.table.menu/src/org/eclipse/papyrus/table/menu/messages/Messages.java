package org.eclipse.papyrus.table.menu.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.table.menu.messages.messages"; //$NON-NLS-1$

	public static String EditTableHandler_EditDescription_Message;

	public static String EditTableHandler_EditDescription_Title;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
