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
package org.eclipse.papyrus.uml.properties.widgets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.widgets.editors.MultipleReferenceEditor;
import org.eclipse.papyrus.uml.profile.ui.dialogs.ProfileTreeSelectionDialog;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.properties.messages.Messages;
import org.eclipse.papyrus.uml.properties.profile.ui.dialogs.FileSelectionFilter;
import org.eclipse.papyrus.uml.properties.profile.ui.dialogs.Message;
import org.eclipse.papyrus.uml.properties.profile.ui.dialogs.RegisteredProfileSelectionDialog;
import org.eclipse.papyrus.uml.tools.utils.ProfileUtil;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

/**
 * An editor for Profile application
 * 
 * @author Camille Letavernier
 */
public class ProfileApplicationEditor extends MultipleReferenceEditor {

	/**
	 * The button to add profiles from the list of registered ones
	 */
	protected Button addRegisteredProfile;

	/**
	 * The button to reapply a profile
	 */
	protected Button reapplyProfile;

	/**
	 * The umlPackage being edited
	 */
	protected Package umlPackage;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 * @param style
	 */
	public ProfileApplicationEditor(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected void createListControls() {
		super.createListControls();
		up.dispose();
		down.dispose();
		edit.dispose();
		up = down = edit = null;

		add.setToolTipText(Messages.ProfileApplicationEditor_ApplyProfile);
		addRegisteredProfile = createButton(Activator.getDefault().getImage("/icons/AddReg.gif"), Messages.ProfileApplicationEditor_ApplyRegisteredProfile); //$NON-NLS-1$

		reapplyProfile = createButton(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("/icons/refresh.gif"), "Reapply profile");
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				updateControls();
			}
		});
	}

	/**
	 * Applies a profile from workspace
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.editors.MultipleValueEditor#addAction()
	 * 
	 */
	@Override
	protected void addAction() {
		//Code from org.eclipse.papyrus.uml.profile.ui.compositesformodel.AppliedProfileCompositeOnModel#applyProfileButtonPressed()


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
		dialog.setValidator(new org.eclipse.papyrus.uml.properties.profile.ui.dialogs.FileSelectionValidator());
		dialog.setDoubleClickSelects(true);
		dialog.setHelpAvailable(false);
		dialog.setAllowMultiple(true);

		if(dialog.open() != Window.OK) {
			return;
		}

		// If nothing is selected : abort
		if((dialog.getResult() == null) || (dialog.getResult().length < 1)) {
			return;
		}

		ArrayList<Package> importedModels = new ArrayList<Package>();

		for(int i = 0; i < dialog.getResult().length; i++) {
			IFile selectedFile = (IFile)dialog.getResult()[i];
			URI profileUri = URI.createPlatformResourceURI(selectedFile.getFullPath().toString(), true);

			ResourceSet resourceSet = umlPackage.eResource().getResourceSet();

			Resource profileResource = resourceSet.getResource(profileUri, true);

			if(profileResource.getContents().get(0) instanceof Package) {
				Package importedModel = (Package)profileResource.getContents().get(0);
				importedModels.add(importedModel);
			}

		}

		if(importedModels.size() > 0) {
			ProfileTreeSelectionDialog profileDialog = new ProfileTreeSelectionDialog(getShell(), importedModels, true);

			if(profileDialog.open() != Window.OK) {
				return;
			}

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

	protected void reapplyProfileAction() {
		ISelection selectedElements = treeViewer.getSelection();
		if(!selectedElements.isEmpty() && selectedElements instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection)selectedElements;
			Iterator<?> iterator = selection.iterator();
			while(iterator.hasNext()) {
				Object element = iterator.next();
				if(element instanceof Profile) {
					modelProperty.add(element);
				}
			}
		}
		commit();
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		super.widgetSelected(e);
		if(e.widget == addRegisteredProfile) {
			addRegisteredAction();
		}
		if(e.widget == reapplyProfile) {
			reapplyProfileAction();
		}
	}

	/**
	 * Sets the package on which the profiles will be applied
	 * 
	 * @param umlPackage
	 */
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

		// check whether the selection can be reapplied
		IStructuredSelection selection = (IStructuredSelection)treeViewer.getSelection();
		enabled = false;
		Iterator<?> iterator = selection.iterator();
		while(iterator.hasNext()) {
			Object element = iterator.next();
			if(element instanceof Profile) {
				if(ProfileUtil.isDirty(umlPackage, (Profile)element)) {
					enabled = true; //At least one dirty profile is selected
					break;
				}
			}
		}

		reapplyProfile.setEnabled(enabled);
	}
}
