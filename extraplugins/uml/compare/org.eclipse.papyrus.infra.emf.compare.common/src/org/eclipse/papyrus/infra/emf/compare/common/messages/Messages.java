package org.eclipse.papyrus.infra.emf.compare.common.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.emf.compare.common.messages.messages"; //$NON-NLS-1$

	public static String CloseEditorTriggerListener_ICantFoundTheIPageManager;

	public static String EMFCompareEditor_EditingDomainNotFound;

	public static String EMFCompareUtils_CompareTitle;

	public static String PapyrusModelCompareEditorInput_CompareTitle;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
