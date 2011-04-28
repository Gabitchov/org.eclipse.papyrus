package org.eclipse.papyrus.navigation;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.navigation.messages"; //$NON-NLS-1$

	public static String DoubleClickNaviagationText;

	public static String Explicit_ImplicitNavigation_Text;

	public static String ExplicitNavigation_Text;

	public static String No_Naviagation_Text;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
