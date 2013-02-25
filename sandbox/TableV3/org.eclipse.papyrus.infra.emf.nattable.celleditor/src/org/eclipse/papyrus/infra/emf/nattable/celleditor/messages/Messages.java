package org.eclipse.papyrus.infra.emf.nattable.celleditor.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.emf.nattable.celleditor.messages.messages"; //$NON-NLS-1$

	public static String EMFFeatureCellEditorFactory_SeveralCellEditorAreDeclaredWithTheSameId;

	public static String EMFFeatureCellEditorFactory_TheCellEditorProvidesANullCellId;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
