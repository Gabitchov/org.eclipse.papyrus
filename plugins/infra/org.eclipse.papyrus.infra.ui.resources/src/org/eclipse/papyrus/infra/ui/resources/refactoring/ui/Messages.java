package org.eclipse.papyrus.infra.ui.resources.refactoring.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.ui.resources.refactoring.ui.messages"; //$NON-NLS-1$

	public static String RenameParticipantsDialog_DESCRIPTION;

	public static String RenameParticipantsDialog_DESCRIPTION_LABEL;

	public static String RenameParticipantsDialog_DESCRIPTION_NO_ANALYSIS;

	public static String RenameParticipantsDialog_DESCRIPTION_PROJECT;

	public static String RenameParticipantsDialog_DESCRIPTION_WORKSPACE;

	public static String RenameParticipantsDialog_NAME_NO_ANALYSIS;

	public static String RenameParticipantsDialog_NAME_PROJECT;

	public static String RenameParticipantsDialog_NAME_WORKSPACE;

	public static String RenameParticipantsDialog_OPTIONS;

	public static String RenameParticipantsDialog_SELECT_RENAME_OPTION;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
