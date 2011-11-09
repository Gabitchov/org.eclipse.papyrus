package org.eclipse.papyrus.infra.core.sasheditor.internal.preferences;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.ScaleFieldEditor;
import org.eclipse.papyrus.infra.core.sasheditor.Activator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to 
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They
 * are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can
 * be accessed directly via the preference store.
 */

public class TabTooltipPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public TabTooltipPreferencePage() {
		super(GRID);
		
//		IPreferenceStore store = new ScopedPreferenceStore(new InstanceScope(), Activator.getDefault().getBundle().getSymbolicName());
		IPreferenceStore store = createPreferenceStore();
		setPreferenceStore(store);
		setDescription("SashWindows Tabs Tooltip Preferences");
		
	}
	
	/**
	 * Subclasses may implements this method in order to provide the requested preferenceStore.
	 * @return
	 */
	protected IPreferenceStore createPreferenceStore() {
		IPreferenceStore store = new ScopedPreferenceStore(InstanceScope.INSTANCE, Activator.getDefault().getBundle().getSymbolicName());
		
		return store;
	}


	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
		addField( 
				   new BooleanFieldEditor( ITabTooltipPreferences.isTooltipEnable, "Is Tooltip &Enable", getFieldEditorParent()));

		addField( 
				   new BooleanFieldEditor( ITabTooltipPreferences.isTooltipForCurrentTabShown, "Is Tooltip For &Current Tab Shown", getFieldEditorParent()));

		addField(
				new IntegerFieldEditor(ITabTooltipPreferences.tooltipAutoCloseDelay, "Auto Close &Delay (in ms)", getFieldEditorParent(), 10));

		addField(
				new ScaleFieldEditor(ITabTooltipPreferences.scaledFactor, "Tooltip &Scale", getFieldEditorParent(), 0, 100, 1, 10));

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
	
}