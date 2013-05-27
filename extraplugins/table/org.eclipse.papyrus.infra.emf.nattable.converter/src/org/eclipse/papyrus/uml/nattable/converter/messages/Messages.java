package org.eclipse.papyrus.uml.nattable.converter.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.nattable.converter.messages.messages"; //$NON-NLS-1$

	public static String ConvertOldTableHandler_AdvicesForUser;

	public static String ConvertOldTableHandler_Cancel;

	public static String ConvertOldTableHandler_ConvertOldTableQuestion;

	public static String ConvertOldTableHandler_ConvertToNewAllocationTable;

	public static String ConvertOldTableHandler_ConvertToNewRequirementTable;

	public static String ConvertOldTableHandler_ConvertToNewUMLGenericTable;

	public static String ConvertOldTableHandler_DestroyTheTableAtTheEndQuestion;

	public static String ConvertOldTableHandler_DialogMessage;

	public static String ConvertOldTableHandler_QuestionAboutCustomTable;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
