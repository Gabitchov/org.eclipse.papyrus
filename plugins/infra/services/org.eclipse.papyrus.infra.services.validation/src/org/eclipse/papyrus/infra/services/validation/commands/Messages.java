package org.eclipse.papyrus.infra.services.validation.commands;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.services.validation.commands.messages"; //$NON-NLS-1$
	public static String AbstractValidateCommand_CreateNMarkers;
	public static String AbstractValidateCommand_DeleteExistingMarkers;
	public static String ValidateDelMarkersFromModelCommand_DeleteMarkersFromModel;
	public static String ValidateDelMarkersFromModelCommand_FailedToDeleteMarkers;
	public static String ValidateDelMarkersFromSubtreeCommand_DelMarkersFromSubtree;
	public static String ValidateModelCommand_ValidateModel;
	public static String ValidateSubtreeCommand_ValidateSubtree;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
