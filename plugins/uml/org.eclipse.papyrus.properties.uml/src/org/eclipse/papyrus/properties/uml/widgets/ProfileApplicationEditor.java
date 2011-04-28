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
package org.eclipse.papyrus.properties.uml.widgets;

import java.util.List;

import org.eclipse.papyrus.profile.ui.dialogs.RegisteredProfileSelectionDialog;
import org.eclipse.papyrus.properties.uml.Activator;
import org.eclipse.papyrus.widgets.editors.MultipleReferenceEditor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;


public class ProfileApplicationEditor extends MultipleReferenceEditor {

	protected Button addRegisteredProfile;

	protected Package umlPackage;

	public ProfileApplicationEditor(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * Creates the Add/Remove controls,
	 * and the Up/Down controls if the collection is ordered
	 * 
	 * @param ordered
	 */
	@Override
	protected void createListControls() {
		super.createListControls();
		up.dispose();
		down.dispose();
		edit.dispose();
		up = down = edit = null;

		add.setToolTipText("Apply profile");
		addRegisteredProfile = createButton(Activator.getDefault().getImage("/icons/AddReg.gif"), "Apply registered profile");
	}

	/**
	 * Applies a profile from workspace
	 * 
	 * @see org.eclipse.papyrus.widgets.editors.MultipleValueEditor#addAction()
	 * 
	 */
	@Override
	protected void addAction() {
		addRegisteredAction();
	}

	/**
	 * Applies a profile from the registry
	 */
	protected void addRegisteredAction() {
		RegisteredProfileSelectionDialog profileSelectionDialog = new RegisteredProfileSelectionDialog(getShell(), umlPackage);
		List<Profile> profilesToApply = profileSelectionDialog.run();
		for(Profile profile : profilesToApply) {
			modelProperty.add(profile);
		}

		commit();
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		super.widgetSelected(e);
		if(e.widget == addRegisteredProfile) {
			addRegisteredAction();
		}
	}

	public void setPackage(Package umlPackage) {
		this.umlPackage = umlPackage;
		updateControls();
	}

	@Override
	protected void updateControls() {
		boolean enabled = modelProperty != null && umlPackage != null;
		add.setEnabled(enabled);
		addRegisteredProfile.setEnabled(enabled);
		remove.setEnabled(enabled);
	}
}
