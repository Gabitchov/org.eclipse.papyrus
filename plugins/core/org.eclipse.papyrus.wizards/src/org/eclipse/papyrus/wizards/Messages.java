package org.eclipse.papyrus.wizards;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.wizards.messages"; //$NON-NLS-1$

	public static String CreateModelWizard_new_papyrus_model_title;

	public static String InitModelWizard_init_papyrus_diagram;

	public static String InitModelWizard_init_papyrus_model;

	public static String InitModelWizard_init_papyrus_model_desc;
	public static String NewPapyrusProjectWithMultiModelsWizard_exception_on_project_opening;

	public static String NewPapyrusProjectWizard_exception_on_opening;

	public static String NewPapyrusProjectWizard_new_papyrus_project;

	public static String NewPapyrusProjectWizard_papyrus_project;

	public static String NewPapyrusProjectWizard_papyrus_project_desc;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
