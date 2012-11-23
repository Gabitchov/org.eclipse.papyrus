/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
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
import org.eclipse.papyrus.infra.gmfdiag.css.theme.Theme;
import org.eclipse.papyrus.infra.gmfdiag.css.theme.ThemeManager;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * A Preference page for selecting the Workspace CSS Theme
 * 
 * @author Camille Letavernier
 */
public class ThemePreferencesPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public boolean needsRefresh = false;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ThemePreferencesPage() {
		super("CSS Theme", org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImageDescriptor("/icons/papyrus.png"), FLAT);
	}

	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Papyrus Theme preferences");
	}

	@Override
	protected void createFieldEditors() {
		String[][] themes = getFieldThemes();
		ComboFieldEditor editor = new ComboFieldEditor(ThemePreferences.CURRENT_THEME, "Current theme:", themes, getFieldEditorParent());
		addField(editor);
	}

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

	@Override
	public boolean performOk() {
		boolean result = super.performOk();
		if(needsRefresh) {
			WorkspaceCSSEngine.instance.reset();
			DiagramHelper.refreshDiagrams();
		}
		return result;
	}

	protected String[][] getFieldThemes() {
		List<Theme> themes = ThemeManager.instance.getThemes();

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
