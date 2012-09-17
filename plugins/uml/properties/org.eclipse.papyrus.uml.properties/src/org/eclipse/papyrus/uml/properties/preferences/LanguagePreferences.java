/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * A Preference page to let the user choose which editors are associated to
 * which languages, when editing UML expressions with the {@link ExpressionLanguageEditor}
 * 
 * @author Camille Letavernier
 */
//TODO : this class need to be implemented
public class LanguagePreferences extends PreferencePage implements IWorkbenchPreferencePage {

	@Override
	protected Control createContents(Composite parent) {
		return null;
	}

	public void init(IWorkbench workbench) {
		//Nothing
	}

	@Override
	public boolean performOk() {

		return super.performOk();
	}

	@Override
	public void performApply() {
		//TODO
	}

	@Override
	public void performDefaults() {
		//TODO
	}

}
