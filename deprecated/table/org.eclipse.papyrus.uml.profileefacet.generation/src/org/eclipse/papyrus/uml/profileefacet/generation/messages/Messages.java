package org.eclipse.papyrus.uml.profileefacet.generation.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.profileefacet.generation.messages.messages"; //$NON-NLS-1$

	public static String ProfileEFacetGenericFactory_FacetAttributeDocumentation;

	public static String ProfileEFacetGenericFactory_FacetDocumentation;

	public static String ProfileEFacetGenericFactory_FacetReferenceDocumentation;

	public static String ProfileEFacetGenericFactory_FacetSetDocumentation;

	public static String ProfileEFacetGenericFactory_TypeNotManagedMessage;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
