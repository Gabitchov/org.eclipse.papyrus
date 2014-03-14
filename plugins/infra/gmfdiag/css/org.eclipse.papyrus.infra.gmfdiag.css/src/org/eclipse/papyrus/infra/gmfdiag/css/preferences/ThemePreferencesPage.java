/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.preferences;

import java.util.List;

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.DiagramHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.Activator;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.WorkspaceCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.Theme;
import org.eclipse.papyrus.infra.gmfdiag.css.theme.ThemeManager;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * A Preference page for selecting the Workspace CSS Theme
 * 
 * @author Camille Letavernier
 */
public class ThemePreferencesPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/** Flag to define if refresh must be done. */
	public boolean needsRefresh = false;

	/**
	 * 
	 * Default constructor.
	 * 
	 */
	public ThemePreferencesPage() {
		super("CSS Theme", org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImageDescriptor("/icons/papyrus.png"), FLAT);
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 *
	 * @param workbench
	 */

	public void init(IWorkbench workbench) {

		//Used default preference store to save current theme
		setPreferenceStore(Activator.getDefault().getPreferenceStore());

		// Set description for page 
		setDescription("Papyrus Theme preferences");
	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 *
	 */

	@Override
	protected void createFieldEditors() {
		//Get all themes define in application instance
		String[][] themes = getFieldThemes();

		ComboFieldEditor editor = new ComboFieldEditor(ThemePreferences.CURRENT_THEME, "Current theme:", themes, getFieldEditorParent());
		addField(editor);
	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
	 *
	 * @param event
	 */

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		super.propertyChange(event);
		if(ThemePreferences.CURRENT_THEME.equals(event.getProperty())) {
			needsRefresh = true;
		}
		if(FieldEditor.VALUE.equals(event.getProperty())) {
			if(ThemePreferences.CURRENT_THEME.equals(((FieldEditor)event.getSource()).getPreferenceName())) {
				needsRefresh = true;
			}
		}
	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#performOk()
	 *
	 * @return
	 */

	@Override
	public boolean performOk() {
		boolean result = super.performOk();
		if(needsRefresh) {
			WorkspaceCSSEngine.instance.reset();
			DiagramHelper.setNeedsRefresh();
			DiagramHelper.refreshDiagrams();
		}
		return result;
	}

	/**
	 * @return Formatted themes list for combo field editor
	 */
	protected String[][] getFieldThemes() {

		// Use a manager to get all theme in application
		List<Theme> themes = ThemeManager.instance.getThemes();

		// Build theme list for combo editor
		String[][] result = new String[themes.size()][2];
		int i = 0;
		for(Theme theme : themes) {
			result[i][0] = theme.getLabel();
			result[i][1] = theme.getId();
			i++;
		}

		return result;
	}

}
