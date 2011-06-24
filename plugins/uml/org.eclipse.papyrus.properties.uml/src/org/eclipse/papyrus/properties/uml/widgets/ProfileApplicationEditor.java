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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.papyrus.profile.ui.dialogs.FileSelectionFilter;
import org.eclipse.papyrus.profile.ui.dialogs.Message;
import org.eclipse.papyrus.profile.ui.dialogs.ProfileTreeSelectionDialog;
import org.eclipse.papyrus.profile.ui.dialogs.RegisteredProfileSelectionDialog;
import org.eclipse.papyrus.properties.uml.Activator;
import org.eclipse.papyrus.properties.uml.messages.Messages;
import org.eclipse.papyrus.widgets.editors.MultipleReferenceEditor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
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

		add.setToolTipText(Messages.ProfileApplicationEditor_ApplyProfile);
		addRegisteredProfile = createButton(Activator.getDefault().getImage("/icons/AddReg.gif"), Messages.ProfileApplicationEditor_ApplyRegisteredProfile); //$NON-NLS-1$
	}

	/**
	 * Applies a profile from workspace
	 * 
	 * @see org.eclipse.papyrus.widgets.editors.MultipleValueEditor#addAction()
	 * 
	 */
	@Override
	protected void addAction() {
		//Code from org.eclipse.papyrus.profile.ui.compositesformodel.AppliedProfileCompositeOnModel#applyProfileButtonPressed()


		// Create and open the dialog box
		// ResourceSelectionDialog dialog =
		// new ResourceSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(), "Apply Profiles");

		ILabelProvider lp = new WorkbenchLabelProvider();
		ITreeContentProvider cp = new WorkbenchContentProvider();

		ArrayList<String> filetypes = new ArrayList<String>();
		filetypes.add("uml"); //$NON-NLS-1$

		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(), lp, cp);
		dialog.setTitle(Messages.ProfileApplicationEditor_ApplyProfilesDialogTitle);
		dialog.setMessage(Messages.ProfileApplicationEditor_ApplyProfilesDialogDescription);
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		dialog.addFilter(new FileSelectionFilter(filetypes));
		dialog.setValidator(new org.eclipse.papyrus.profile.ui.dialogs.FileSelectionValidator());
		dialog.setDoubleClickSelects(true);
		dialog.setHelpAvailable(false);
		dialog.setAllowMultiple(true);

		dialog.open();

		// If nothing is selected : abort
		if((dialog.getResult() == null) || (dialog.getResult().length < 1)) {
			return;
		}

		ArrayList<Package> importedModels = new ArrayList<Package>();

		for(int i = 0; i < dialog.getResult().length; i++) {
			IFile selectedFile = (IFile)dialog.getResult()[i];
			URI profileUri = URI.createURI("platform:/resource" + selectedFile.getFullPath().toString()); //$NON-NLS-1$

			ResourceSet resourceSet = umlPackage.eResource().getResourceSet();

			Resource profileResource = resourceSet.getResource(profileUri, true);

			if(profileResource.getContents().get(0) instanceof Package) {
				Package importedModel = (Package)profileResource.getContents().get(0);
				importedModels.add(importedModel);
			}

		}

		if(importedModels.size() > 0) {
			ProfileTreeSelectionDialog profileDialog = new ProfileTreeSelectionDialog(getShell(), importedModels);

			profileDialog.open();
			ArrayList<Profile> profilesToApply = profileDialog.getResult();

			Message message = new Message(Messages.ProfileApplicationEditor_WaitMessageTitle, Messages.ProfileApplicationEditor_WaitMessage);
			message.open();
			for(Profile profile : profilesToApply) {
				modelProperty.add(profile);
			}
			message.close();
			commit();
		}
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
