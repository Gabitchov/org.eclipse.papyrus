package org.eclipse.papyrus.diagram.menu.actions;

import org.eclipse.osgi.util.NLS;

public class DiagramUIActionsMessages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.diagram.menu.actions.messages"; //$NON-NLS-1$

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, DiagramUIActionsMessages.class);
	}

	private DiagramUIActionsMessages() {
	}

	public static String PropertyDescriptorFactory_Font;
}
