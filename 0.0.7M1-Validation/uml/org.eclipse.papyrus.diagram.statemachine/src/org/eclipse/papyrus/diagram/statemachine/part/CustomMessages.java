package org.eclipse.papyrus.diagram.statemachine.part;

import org.eclipse.osgi.util.NLS;


public class CustomMessages extends NLS {
	public static String SelectStateMachineDialog_Title;
	public static String SelectConnectionPointsDialog_Title;
	public static String SelectConnectionPointsDialog_LabelProvider_EntryPointPrefix;
	public static String SelectConnectionPointsDialog_LabelProvider_ExitPointPrefix;

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.diagram.statemachine.part.customMessages"; //$NON-NLS-1$

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, CustomMessages.class);
	}
}
