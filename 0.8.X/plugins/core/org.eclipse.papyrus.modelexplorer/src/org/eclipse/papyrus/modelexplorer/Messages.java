package org.eclipse.papyrus.modelexplorer;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.modelexplorer.messages"; //$NON-NLS-1$
	public static String DoubleClickListener_Error_NoLoadManagerToOpen;
	public static String MoDiscoLabelProvider_ProxyLabel;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
