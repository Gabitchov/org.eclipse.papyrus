package org.eclipse.papyrus.properties.customization.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.properties.customization.Activator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;


public class CustomizationPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public final static String OPEN_CUSTOMIZATION_PERSPECTIVE = "openCustomizationPerspective"; //$NON-NLS-1$

	public final static String ASK_FOR_CONFIRMATION = "askForConfirmation"; //$NON-NLS-1$

	public CustomizationPreferencePage() {
	}

	public CustomizationPreferencePage(int style) {
		super(style);
	}

	public CustomizationPreferencePage(String title, int style) {
		super(title, style);
	}

	public CustomizationPreferencePage(String title, ImageDescriptor image, int style) {
		super(title, image, style);
	}

	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Property view customization preferences");
	}

	@Override
	protected void createFieldEditors() {
		addField(new BooleanFieldEditor(OPEN_CUSTOMIZATION_PERSPECTIVE, "Open customization perspective", getFieldEditorParent()));
		addField(new BooleanFieldEditor(ASK_FOR_CONFIRMATION, "Ask for confirmation", getFieldEditorParent()));
	}

	public static boolean openCustomizationPerspective() {
		return Activator.getDefault().getPreferenceStore().getBoolean(OPEN_CUSTOMIZATION_PERSPECTIVE);
	}

	public static boolean askForConfirmation() {
		return Activator.getDefault().getPreferenceStore().getBoolean(ASK_FOR_CONFIRMATION);
	}
}
