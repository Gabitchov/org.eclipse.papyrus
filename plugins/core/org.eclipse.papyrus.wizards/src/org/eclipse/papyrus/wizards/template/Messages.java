package org.eclipse.papyrus.wizards.template;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.wizards.template.messages"; //$NON-NLS-1$

	public static String ModelTemplatesLabelProvider_model_template_description_text;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
