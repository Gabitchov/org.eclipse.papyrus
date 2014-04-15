package org.eclipse.papyrus.mwe2.utils.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.mwe.utils.messages.messages"; //$NON-NLS-1$

	public static String QvtoTransformationWorkflowComponent_1;

	public static String QvtoTransformationWorkflowComponent_4;

	public static String QvtoTransformationWorkflowComponent_5;

	public static String RegisterUmlProfile_1;

	public static String RegisterUmlProfile_2;

	public static String RegisterUmlProfile_3;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
