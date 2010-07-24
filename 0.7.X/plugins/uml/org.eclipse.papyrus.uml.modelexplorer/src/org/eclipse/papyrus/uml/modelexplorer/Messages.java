package org.eclipse.papyrus.uml.modelexplorer;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.modelexplorer.messages"; //$NON-NLS-1$

	public static String new_name;

	public static String rename;

	public static String rename_element;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
