package org.eclipse.papyrus.preferences.ui;

import org.eclipse.gmf.runtime.diagram.ui.properties.internal.l10n.DiagramUIPropertiesImages;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.preferences.jface.preference.ColorFieldEditor;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.widgets.Composite;

public class ColorGroupForNodeComposite extends ColorGroupForLinkComposite {

	protected ColorFieldEditor fontColorEditor;

	protected ColorFieldEditor lineColorEditor;

	protected ColorFieldEditor fillColorEditor;

	/**
	 * 
	 * @param parent
	 * @param title
	 */

	public ColorGroupForNodeComposite(Composite parent, String title, DialogPage dialogPage) {
		super(parent, title, dialogPage);
	}

	/**
	 * 
	 * @param parent
	 */
	protected void createContent(Composite parent) {
		super.createContent(parent);

		Composite fillColorEditorCompo = getEncapsulatedCompo(getToolbar());
		fillColorEditor = new ColorFieldEditor(getPreferenceConstant(PreferenceConstantHelper.COLOR_FILL),
				DiagramUIPropertiesImages.get(DiagramUIPropertiesImages.IMG_FILL_COLOR), fillColorEditorCompo);
		fillColorEditor.setPage(dialogPage);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void setPreferenceStore(IPreferenceStore preferenceStore) {
		super.setPreferenceStore(preferenceStore);
		fillColorEditor.setPreferenceStore(preferenceStore);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void load() {
		super.load();
		fillColorEditor.load();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void storePreferences() {
		super.storePreferences();
		fillColorEditor.store();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void loadDefault() {
		super.loadDefault();
		fillColorEditor.loadDefault();
	}
}
