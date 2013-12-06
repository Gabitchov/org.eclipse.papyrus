package org.eclipse.papyrus.infra.gmfdiag.preferences.messages;

import org.eclipse.osgi.util.NLS;

public class DiagramUIMessages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.gmfdiag.preferences.messages.messages"; //$NON-NLS-1$

	public static String RulersAndGridGroup_GridColor;

	public static String RulersAndGridGroup_GridInFront;

	public static String RulersAndGridGroup_GridStyle;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, DiagramUIMessages.class);
	}

	private DiagramUIMessages() {
	}
}
