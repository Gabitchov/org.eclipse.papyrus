package org.eclipse.papyrus.table.common.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.table.common.messages.messages"; //$NON-NLS-1$

	public static String AbstractCreateNattableEditorCommand_New_Table_Title;

	public static String AbstractCreateNattableEditorCommand_Table_Description_Message;

	public static String AbstractCreateNattableEditorCommand_Table_Name_Message;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
