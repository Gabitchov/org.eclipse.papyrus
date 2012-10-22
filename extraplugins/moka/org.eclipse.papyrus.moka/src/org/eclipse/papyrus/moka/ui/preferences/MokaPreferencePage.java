/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.ui.preferences;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.papyrus.moka.MokaActivator;
import org.eclipse.papyrus.moka.environment.MokaEnvironment;
import org.eclipse.papyrus.moka.messages.Messages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class MokaPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public static String PREF_EXECUTION_ENGINE = "PREF_BOOLEAN"; //$NON-NLS-1$

	public MokaPreferencePage() {
		super(GRID);
		setPreferenceStore(MokaActivator.getDefault().getPreferenceStore());
		setDescription(""); //$NON-NLS-1$
	}

	public void init(IWorkbench workbench) {
	}

	@Override
	protected void createFieldEditors() {
		String[][] names = getRegisteredExecutionEnginesAsStringArray();
		this.addField(new RadioGroupFieldEditor(MokaPreferencePage.PREF_EXECUTION_ENGINE, Messages.MokaPreferencePage_SELECTED_EXECUTION_ENGINE, 1, names, getFieldEditorParent()));
	}

	protected String[][] getRegisteredExecutionEnginesAsStringArray() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] config = registry.getConfigurationElementsFor(MokaEnvironment.ENGINE_EXTENSION_POINT_ID);
		String[][] names = new String[config.length][2];
		for(int i = 0; i < config.length; i++) {
			names[i][0] = config[i].getNamespaceIdentifier();
			names[i][1] = config[i].getNamespaceIdentifier();
		}
		return names;
	}
}
