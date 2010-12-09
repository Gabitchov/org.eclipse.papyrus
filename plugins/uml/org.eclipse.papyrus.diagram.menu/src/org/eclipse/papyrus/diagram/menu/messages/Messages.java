package org.eclipse.papyrus.diagram.menu.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.diagram.menu.messages.messages"; //$NON-NLS-1$

	public static String ShowHideCompartmentAction_Messages;

	public static String ShowHideCompartmentAction_No_Name;

	public static String ShowHideCompartmentAction_Title;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
