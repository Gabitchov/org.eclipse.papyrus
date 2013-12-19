package org.eclipse.papyrus.qompass.designer.vsl;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.qompass.designer.vsl.messages"; //$NON-NLS-1$
	public static String ParseVSL_ErrorInExp_SIZE;
	public static String ParseVSL_ErrorInExp_TIME;
	public static String ParseVSL_ErrotInExp_FREQ;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
