package org.eclipse.papyrus.cpp.codegen;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.cpp.codegen.messages"; //$NON-NLS-1$
	public static String CppModelElementsCreator_CannotFormatContent;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
