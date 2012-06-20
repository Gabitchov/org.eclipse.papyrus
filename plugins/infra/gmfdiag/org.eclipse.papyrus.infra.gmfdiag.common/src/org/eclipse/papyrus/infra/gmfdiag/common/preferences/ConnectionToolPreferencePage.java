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
package org.eclipse.papyrus.infra.gmfdiag.common.preferences;

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;


public class ConnectionToolPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getInstance().getPreferenceStore());
	}

	@Override
	protected void createFieldEditors() {
		String[][] values = { { "Single click", ConnectionToolPreferences.SINGLE_CLICK }, { "Two clicks", ConnectionToolPreferences.TWO_CLICKS } };
		ComboFieldEditor fieldEditor = new ComboFieldEditor(ConnectionToolPreferences.DRAW_CONNECTION_MODE, "Draw links mode", values, getFieldEditorParent());
		addField(fieldEditor);
	}

}
