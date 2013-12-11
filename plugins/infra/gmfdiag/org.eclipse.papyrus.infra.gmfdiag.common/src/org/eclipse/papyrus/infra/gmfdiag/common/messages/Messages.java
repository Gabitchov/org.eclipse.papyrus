package org.eclipse.papyrus.infra.gmfdiag.common.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.gmfdiag.common.messages.messages"; //$NON-NLS-1$

	public static String LineStyleLabelProvider_Custom;

	public static String LineStyleLabelProvider_Dash;

	public static String LineStyleLabelProvider_DashDot;

	public static String LineStyleLabelProvider_DashDotDot;

	public static String LineStyleLabelProvider_Dot;

	public static String LineStyleLabelProvider_Solid;

	public static String UnitsUtils_Centimeters;

	public static String UnitsUtils_Inches;

	public static String UnitsUtils_Pixels;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
