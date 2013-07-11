package org.eclipse.papyrus.infra.table.efacet.modelexplorer.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.table.efacet.modelexplorer.messages.messages"; //$NON-NLS-1$

	public static String DuplicateTableEFacetHandler_CopyOf;

	public static String RenameTableEFacetHandler_NewName;

	public static String RenameTableEFacetHandler_RenameAnExistingTable;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
