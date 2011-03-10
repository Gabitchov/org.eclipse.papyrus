package org.eclipse.papyrus.compare.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "messages"; //$NON-NLS-1$

	public static String Activator_log_error_message;

	public static String CompareTwoElementsAction_left_element_is_null;

	public static String CompareTwoElementsAction_only_only_element_is_selected;

	public static String CompareTwoElementsAction_right_element_is_null;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
