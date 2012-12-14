package org.eclipse.papyrus.infra.table.efacet.controlmode.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.table.efacet.controlmode.message.messages"; //$NON-NLS-1$

	public static String PapyrusTableEFacetMoveHelper_AddAdditionalContentsFacetSet;

	public static String PapyrusTableEFacetMoveHelper_AddPageCommand;

	public static String PapyrusTableEFacetMoveHelper_CopyXMIIDCommand;

	public static String PapyrusTableEFacetMoveHelper_MergeAdditionalContentsFacetSet;

	public static String PapyrusTableEFacetMoveHelper_ReplaceCalls;

	public static String PapyrusTableEFacetMoveHelper_UpdateAdditionalContentsFacetSet;

	public static String PapyrusTableEFacetMoveHelper_UpdateReferenceToFacetElementCommand;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
