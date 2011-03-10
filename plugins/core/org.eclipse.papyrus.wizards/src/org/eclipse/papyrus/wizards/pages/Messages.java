package org.eclipse.papyrus.wizards.pages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.wizards.pages.messages"; //$NON-NLS-1$

	public static String SelectRootElementPage_select_root_element_desc;

	public static String SelectRootElementPage_select_root_element_title;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
