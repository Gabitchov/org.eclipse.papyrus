package org.eclipse.papyrus.uml.tools.utils.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.tools.utils.messages.messages"; //$NON-NLS-1$

	public static String UMLStringValueConverter_TheEnumerationLiteralXCantBeFound;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
