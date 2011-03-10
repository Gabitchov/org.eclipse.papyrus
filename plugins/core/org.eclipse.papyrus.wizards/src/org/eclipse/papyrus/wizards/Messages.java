package org.eclipse.papyrus.wizards;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "messages"; //$NON-NLS-1$

	public static String CreateModelWizard_new_papyrus_model_title;

	public static String CreateSeveralModelsWizard_cannot_initiate_page;

	public static String CreateSeveralModelsWizard_new_model_file_page_title;

	public static String InitModelWizard_diagram_name_is_different_from_domain_model;

	public static String InitModelWizard_init_papyrus_diagram;

	public static String InitModelWizard_init_papyrus_model;

	public static String InitModelWizard_init_papyrus_model_desc;
	public static String NewPapyrusProjectWithMultiModelsWizard_exception_on_project_opening;

	public static String NewPapyrusProjectWizard_exception_on_opening;

	public static String NewPapyrusProjectWizard_new_papyrus_project;

	public static String NewPapyrusProjectWizard_papyrus_project;

	public static String NewPapyrusProjectWizard_papyrus_project_desc;

	public static String DiagramCategoryRegistry_bad_class_name_of_category;

	public static String DiagramKindLabelProvider_undefined_element;

	public static String ModelTemplatesLabelProvider_model_template_description_text;
	
	public static String NewModelFilePage_3;

	public static String NewModelFilePage_default_diagram_name;

	public static String NewModelFilePage_diagram_file_was_renamed;

	public static String NewModelFilePage_new_diagram_category_needs_specific_extension;

	public static String NewModelFilePage_page_desc;

	public static String SelectDiagramCategoryPage_cannot_find_category;

	public static String SelectDiagramCategoryPage_diagram_language_group;

	public static String SelectDiagramCategoryPage_select_language;

	public static String SelectDiagramCategoryPage_select_one_category;

	public static String SelectDiagramKindPage_default_diagram_name;

	public static String SelectDiagramKindPage_diagram_name_group;

	public static String SelectDiagramKindPage_diagram_name_is_empty;

	public static String SelectDiagramKindPage_load_template_group;

	public static String SelectDiagramKindPage_page_desc;

	public static String SelectDiagramKindPage_page_title;

	public static String SelectDiagramKindPage_remember_current_selection_text;

	public static String SelectDiagramKindPage_remember_current_selection_tooltip;

	public static String SelectDiagramKindPage_select_kind_group;

	public static String SelectRootElementPage_select_root_element_desc;

	public static String SelectRootElementPage_select_root_element_title;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
