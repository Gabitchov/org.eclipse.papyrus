package org.eclipse.papyrus.compare.ui.action;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.compare.ui.action.messages"; //$NON-NLS-1$

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
