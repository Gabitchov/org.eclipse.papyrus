package org.eclipse.papyrus.infra.nattable.common.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.nattable.common.messages.messages"; //$NON-NLS-1$

	public static String TableLabelProvider_ErrorGettingIconForTable;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
