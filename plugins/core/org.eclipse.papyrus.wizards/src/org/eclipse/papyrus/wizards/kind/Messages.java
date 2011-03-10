package org.eclipse.papyrus.wizards.kind;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.wizards.kind.messages"; //$NON-NLS-1$

	public static String DiagramKindLabelProvider_undefined_element;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
