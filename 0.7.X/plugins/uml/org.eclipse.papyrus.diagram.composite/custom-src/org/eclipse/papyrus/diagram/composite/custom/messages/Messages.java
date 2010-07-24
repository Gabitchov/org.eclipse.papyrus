package org.eclipse.papyrus.diagram.composite.custom.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.diagram.composite.custom.messages.messages"; //$NON-NLS-1$

	public static String CollaborationRoleSelectionDialog_Title;

	public static String CollaborationRoleSelectionDialog_Message;

	public static String ConnectorCreateCommand_INVALID_ARGS_MSG;

	public static String ConnectorCreateCommand_INVALID_SOURCE_MSG;

	public static String ConnectorCreateCommand_INVALID_TARGET_MSG;

	public static String RoleBindingCreateCommand_INVALID_ARGS_MSG;

	public static String RoleBindingRoleSelectionDialog_Title;

	public static String RoleBindingRoleSelectionDialog_Message;

	public static String InformationFlowSelectionDialog_Title;

	public static String InformationFlowSelectionDialog_Message;

	public static String InformationItemGetNameDialog_Error_Message;

	public static String SelectionValidated;

	public static String ShowElementAction_Message;

	public static String ShowElementAction_Title;

	public static String InformationFlowSelectInformationItem_ERROR;

	public static String NoSelectionFound;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
