package org.eclipse.papyrus.uml.compare.ui.viewer.content;

import org.eclipse.osgi.util.NLS;

/**
 * The NLS Messages.
 */
public class Messages extends NLS {

	/** The Constant BUNDLE_NAME. */
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.compare.ui.viewer.content.messages"; //$NON-NLS-1$

	/** The UML model content merge viewer_action_show_all_properties_text. */
	public static String UMLModelContentMergeViewer_action_show_all_properties_text;

	/** The UML model content merge viewer_action_show_all_properties_tooltip. */
	public static String UMLModelContentMergeViewer_action_show_all_properties_tooltip;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	/**
	 * Instantiates a new messages.
	 */
	private Messages() {
	}
}
