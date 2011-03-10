package org.eclipse.papyrus.compare.ui.viewer.content;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.compare.ui.viewer.content.messages"; //$NON-NLS-1$

	public static String UMLModelContentMergeViewer_action_show_all_properties_text;

	public static String UMLModelContentMergeViewer_action_show_all_properties_tooltip;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
