package org.eclipse.papyrus.uml.compare.ui;

import org.eclipse.osgi.util.NLS;

/**
 * The NLS Messages.
 */
public class Messages extends NLS {

	/** The Constant BUNDLE_NAME. */
	private static final String BUNDLE_NAME = "messages"; //$NON-NLS-1$

	/** The Activator_log_error_message. */
	public static String Activator_log_error_message;

	/** The Compare two elements action_left_element_is_null. */
	public static String CompareTwoElementsAction_left_element_is_null;

	/** The Compare two elements action_only_only_element_is_selected. */
	public static String CompareTwoElementsAction_only_only_element_is_selected;

	/** The Compare two elements action_right_element_is_null. */
	public static String CompareTwoElementsAction_right_element_is_null;
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
