/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * Add the possibility to display or hide the guard of Operand
 * 
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=402966
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomInteractionOperandPreferencePage extends InteractionOperandPreferencePage {

	public static final String GUARD_VISIBILITY = PackageEditPart.MODEL_ID + "_InteractionOperand.guard.visibility";

	public static void initDefaults(IPreferenceStore store) {
		InteractionOperandPreferencePage.initDefaults(store);
		store.setDefault(GUARD_VISIBILITY, Boolean.TRUE);
	}

	private Button guardVisibleButton;

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusNodePreferencePage#createPageContents(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 */
	@Override
	protected void createPageContents(Composite parent) {
		super.createPageContents(parent);
		createGuardGroup(parent);
	}

	/**
	 * Create new group for guard preferences.
	 */
	protected void createGuardGroup(Composite parent) {
		Group group = new Group(parent, SWT.NONE);
		group.setText("Guard");
		group.setLayout(new GridLayout());
		//Guard Visibility
		guardVisibleButton = new Button(group, SWT.CHECK);
		guardVisibleButton.setText("Show");
		guardVisibleButton.setSelection(getPreferenceStore().getBoolean(GUARD_VISIBILITY));
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusPreferencePage#performDefaults()
	 * 
	 */
	@Override
	protected void performDefaults() {
		super.performDefaults();
		if(guardVisibleButton != null && !guardVisibleButton.isDisposed()) {
			guardVisibleButton.setSelection(getPreferenceStore().getDefaultBoolean(GUARD_VISIBILITY));
		}
	}

	/**
	 * @see org.eclipse.jface.preference.PreferencePage#performApply()
	 * 
	 */
	@Override
	protected void performApply() {
		super.performApply();
		if(guardVisibleButton != null && !guardVisibleButton.isDisposed()) {
			getPreferenceStore().setValue(GUARD_VISIBILITY, guardVisibleButton.getSelection());
		}
	}
}
