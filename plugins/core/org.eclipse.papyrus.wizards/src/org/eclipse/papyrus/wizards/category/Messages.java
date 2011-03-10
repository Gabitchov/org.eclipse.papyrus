package org.eclipse.papyrus.wizards.category;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.wizards.category.messages"; //$NON-NLS-1$

	public static String DiagramCategoryRegistry_bad_class_name_of_category;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
