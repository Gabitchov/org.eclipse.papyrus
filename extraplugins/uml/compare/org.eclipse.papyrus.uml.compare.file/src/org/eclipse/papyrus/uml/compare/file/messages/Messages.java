package org.eclipse.papyrus.uml.compare.file.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.compare.file.editor.messages.messages"; //$NON-NLS-1$

	public static String CompareUMLFileEditor_ICantLoadTheModel;

	public static String CompareUMLFileHandler_ICantOpenThePapyrusCompareEdito;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
