package org.eclipse.papyrus.commands.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.commands.messages.messages"; //$NON-NLS-1$

	public static String RenameDiagramHandler_NewName;

	public static String RenameDiagramHandler_RenameAnExistingDiagram;

	public static String RenameDiagramHandler_RenameDiagram;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
