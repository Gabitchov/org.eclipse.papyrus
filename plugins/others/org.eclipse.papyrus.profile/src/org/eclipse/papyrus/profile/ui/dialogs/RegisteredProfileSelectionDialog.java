/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.profile.ui.dialogs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.papyrus.extensionpoints.uml2.profile.RegisteredProfile;
import org.eclipse.papyrus.extensionpoints.uml2.standard.ExtensionLabelProvider;
import org.eclipse.papyrus.extensionpoints.uml2.utils.Util;
import org.eclipse.papyrus.umlutils.PackageUtil;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

/**
 * 
 */
public class RegisteredProfileSelectionDialog extends ElementListSelectionDialog {

	/**
	 * 
	 */
	private RegisteredProfile[] regProfiles;

	/**
	 * 
	 */
	private Package currentPackage;

	/**
	 * 
	 * 
	 * @param umlPackage
	 * @param parent
	 */
	public RegisteredProfileSelectionDialog(Composite parent, Package umlPackage) {
		super(parent.getShell(), new ExtensionLabelProvider());

		currentPackage = umlPackage;

		// Retrieve registered profiles
		regProfiles = RegisteredProfile.getRegisteredProfiles();

		this.setTitle("Apply profiles from Papyrus repository :");
		this.setElements(regProfiles);
		this.setMultipleSelection(true);
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public boolean run() {
		// /*String message= "List of profiles\n";
		// for(int i = 0; i < regProfiles.length ; i++) {
		// message+= "|"+regProfiles[i].name+": "+regProfiles[i].qualifiednames+"|";
		// }
		// MessageDialog dialog = new MessageDialog(new Shell(),
		// "Profiles available",
		// null,
		// message,
		// MessageDialog.INFORMATION,
		// new String[] {"OK"},
		// 0);
		// dialog.open();
		this.open();
		return this.treatSelection();
	}

	/**
	 * 
	 * 
	 * @return
	 */
	private boolean treatSelection() {

		// User selection
		Object[] selection = this.getResult();
		boolean hasChanged = false;

		ResourceSet resourceSet = Util.getResourceSet(currentPackage);

		if (selection == null) { // Cancel was selected
			return hasChanged;
		}

		// This first list (listOfProfileToApply) contain every selected profile
		// which owns sub-profiles (it is possible to select a set of sub-profiles)
		// The list is used to build a profile selection tree
		List<Package> listOfProfileToApply = new ArrayList<Package>();
		// try to parse the qualified names

		List<String> subprofilesList = new ArrayList<String>();
		for (int i = 0; i < selection.length; i++) {

			RegisteredProfile currentProfile = (RegisteredProfile) (selection[i]);
			URI modelUri = currentProfile.uri;
			Resource modelResource = resourceSet.getResource(modelUri, true);

			// retrieve registered sub-profiles to be selected
			String qualifiedNames = currentProfile.qualifiednames;

			// try to parse the qualified names
			String[] profiles = qualifiedNames.split(",");

			// make a collection with String with no space
			for (int j = 0; j < profiles.length; j++) {
				String string = profiles[j].trim();
				subprofilesList.add(string);
			}

			if (modelResource.getContents().get(0) instanceof Profile) {
				Message processMsg = new Message("Profile application", "Loading profiles...");
				processMsg.open();
				Profile profileToApply = (Profile) (modelResource.getContents().get(0));
				processMsg.close();
				if (PackageUtil.getSubProfiles(profileToApply).isEmpty()) {
					// No sub-profile -> apply profile directly
					PackageUtil.applyProfile(currentPackage, profileToApply, false);
				} else {

					listOfProfileToApply.add(profileToApply);
				}
			}
		}

		if (!listOfProfileToApply.isEmpty()) {
			// Open package/profile selection tree selection
			ProfileTreeSelectionDialog profileDialog = new ProfileTreeSelectionDialog(getShell(), listOfProfileToApply, subprofilesList);
			int returnValue = profileDialog.open();

			// Apply selected profile if ok was selected
			if (Dialog.OK == returnValue) {
				ArrayList<Profile> profilestoApply = (ArrayList<Profile>) profileDialog.getResult();
				Iterator<Profile> iterator = profilestoApply.iterator();
				while (iterator.hasNext()) {
					PackageUtil.applyProfile(currentPackage, iterator.next(), false);
				}
			}
		}

		return hasChanged;
	}
}
