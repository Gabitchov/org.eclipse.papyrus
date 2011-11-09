package org.eclipse.papyrus.infra.gmfdiag.navigation.utils;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.gmfdiag.navigation.utils.messages"; //$NON-NLS-1$

	public static String MultiDiagramDialog_0;

	public static String MultiDiagramDialog_1;

	public static String IS_BACK_POSSIBLE;

	public static String IS_NEXT_POSSIBLE;

	public static String IS_UP_POSSIBLE;

	public static String IS_TOP_POSSIBLE;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
