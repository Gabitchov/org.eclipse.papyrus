package org.eclipse.papyrus.diagram.common.service.palette;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.diagram.common.service.palette.messages"; //$NON-NLS-1$

	public static String SetDynamicValueCommand_DialogMessage;

	public static String SetDynamicValueCommand_DialogTile;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
