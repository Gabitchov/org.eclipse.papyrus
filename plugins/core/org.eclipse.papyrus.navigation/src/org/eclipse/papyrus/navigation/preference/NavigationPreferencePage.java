/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.navigation.preference;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.navigation.Messages;
import org.eclipse.papyrus.preferences.Activator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;


/**
 * preference page for the navigation
 * It proposes to choose among 3 possibilities: no navigation, explicit navigation, or explicit + implicit naviagation
 *
 */
public class NavigationPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	protected RadioGroupFieldEditor radioGroupFieldEditor;
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	@Override
	protected void createFieldEditors() {
		radioGroupFieldEditor = new RadioGroupFieldEditor(
			INavigationPreferenceConstant.PAPYRUS_NAVIGATION_DOUBLECLICK_KIND,
			Messages.DoubleClickNaviagationText,
			1,
			new String[][] {
				{Messages.No_Naviagation_Text,INavigationPreferenceConstant.NO_NAVIGATION},
				{Messages.ExplicitNavigation_Text,INavigationPreferenceConstant.EXPLICIT_NAVIGATION},
				{Messages.Explicit_ImplicitNavigation_Text,INavigationPreferenceConstant.EXPLICIT_IMPLICIT_NAVIGATION}
			},
			getFieldEditorParent());
		addField(radioGroupFieldEditor);
		radioGroupFieldEditor.setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

}
