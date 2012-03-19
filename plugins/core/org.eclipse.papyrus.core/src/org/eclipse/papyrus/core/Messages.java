package org.eclipse.papyrus.core;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "messages"; //$NON-NLS-1$

	public static String CoreMultiDiagramEditor_do_you_want_to_close;

	public static String CoreMultiDiagramEditor_if_not_close;

	public static String CoreMultiDiagramEditor_only_one;

	public static String CoreMultiDiagramEditor_warning;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
