/*****************************************************************************
 * Copyright (c) 2008, 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *  Christian W. Damus (CEA) - Refactoring package/profile import/apply UI for CDO
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.dialogs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.extensionpoints.profile.RegisteredProfile;
import org.eclipse.papyrus.uml.extensionpoints.standard.FilteredRegisteredElementsSelectionDialog;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.papyrus.uml.profile.ui.dialogs.ElementImportTreeSelectionDialog.ImportSpec;
import org.eclipse.papyrus.uml.profile.ui.dialogs.ProfileTreeSelectionDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

/**
 *
 */
public class RegisteredProfileSelectionDialog extends FilteredRegisteredElementsSelectionDialog {

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
		super(parent.getShell(), true, RegisteredProfile.getRegisteredProfiles(), new ArrayList<Object>(), "Apply profiles from Papyrus repository :", "");
		currentPackage = umlPackage;
	}

	/**
	 *
	 *
	 * @return
	 */
	public List<Profile> run() {
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
		List<Profile> profilesToApply = this.treatSelection();

		List<Profile> result = new LinkedList<Profile>();
		for(Profile profile : profilesToApply) {
			result.add(EMFHelper.reloadIntoContext(profile, currentPackage));
		}
		return result;
	}

	/**
	 *
	 *
	 * @return
	 */
	private List<Profile> treatSelection() {

		// User selection
		Object[] selection = this.getResult();

		ResourceSet resourceSet = Util.createTemporaryResourceSet();

		if(selection == null) { // Cancel was selected
			return new ArrayList<Profile>();
		}

		// This first list (listOfProfileToApply) contain every selected profile
		// which owns sub-profiles (it is possible to select a set of sub-profiles)
		// The list is used to build a profile selection tree
		List<Package> listOfProfileToApply = new ArrayList<Package>();
		// try to parse the qualified names

		List<String> subprofilesList = new ArrayList<String>();
		for(int i = 0; i < selection.length; i++) {

			RegisteredProfile currentProfile = (RegisteredProfile)(selection[i]);
			URI modelUri = currentProfile.uri;
			Resource modelResource = resourceSet.getResource(modelUri, true);

			// retrieve registered sub-profiles to be selected
			String qualifiedNames = currentProfile.qualifiednames;

			// try to parse the qualified names
			String[] profiles = qualifiedNames.split(",");

			// make a collection with String with no space
			for(int j = 0; j < profiles.length; j++) {
				String string = profiles[j].trim();
				subprofilesList.add(string);
			}

			if((!modelResource.getContents().isEmpty()) && modelResource.getContents().get(0) instanceof Profile) {
				Message processMsg = new Message("Profile application", "Loading profiles...");
				processMsg.open();
				Profile profileToApply = (Profile)(modelResource.getContents().get(0));
				processMsg.close();
				// if (PackageUtil.getSubProfiles(profileToApply).isEmpty()) {
				// No sub-profile -> apply profile directly
				// PackageUtil.applyProfile(currentPackage, profileToApply, false);
				// } else {

				listOfProfileToApply.add(profileToApply);
				// }
			}
		}

		if(!listOfProfileToApply.isEmpty()) {
			// Open package/profile selection tree selection
			ProfileTreeSelectionDialog profileDialog = new ProfileTreeSelectionDialog(getShell(), listOfProfileToApply, subprofilesList);
			int returnValue = profileDialog.open();

			// Apply selected profile if ok was selected
			if(Dialog.OK == returnValue) {
				Collection<ImportSpec<Profile>> dlgResult = profileDialog.getResult();
				List<Profile> result = new java.util.ArrayList<Profile>(dlgResult.size());
				for(ImportSpec<Profile> next : dlgResult) {
					result.add(next.getElement());
				}
				return result;
			} else {
				new ArrayList<Profile>();
			}
		}
		return new ArrayList<Profile>();
	}
}
