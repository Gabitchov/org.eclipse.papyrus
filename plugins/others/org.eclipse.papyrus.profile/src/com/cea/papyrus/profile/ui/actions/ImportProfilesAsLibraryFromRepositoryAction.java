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
package com.cea.papyrus.profile.ui.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.common.edit.command.ChangeCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.UMLFactory;

import com.cea.papyrus.extensionpoints.uml2.profile.FilteredRegisteredProfilesAsLibrarySelectionDialog;
import com.cea.papyrus.extensionpoints.uml2.profile.RegisteredProfile;
import com.cea.papyrus.extensionpoints.uml2.utils.Util;
import com.cea.papyrus.profile.ui.dialogs.PackageImportTreeSelectionDialog;
import com.cea.papyrus.umlutils.PackageUtil;

/**
 * Action that imports a profile as a library from the profiles registry
 * @see RegisteredProfile
 */
public class ImportProfilesAsLibraryFromRepositoryAction extends AbstractPackageImportAction {

	/**
	 * returns the command that is executed by this action.
	 * @param domain EMF editing domain used by the command
	 * @return the command that is executed by this action
	 */
	public ImportProfilesAsLibraryFromRepositoryCommand getCommand(EditingDomain domain) {
		if(command==null) {
			command = new ImportProfilesAsLibraryFromRepositoryCommand(domain);
		}
		return (ImportProfilesAsLibraryFromRepositoryCommand)command;
	}
	
	/**
	 * Apply the result of the dialog, i.e. it adds package imports to libraries
	 * @param librariesToImport the array of Libraries to import
	 */
	protected void importProfiles(RegisteredProfile[] profilesToImport) {
		// retrieve the current resource set
		ResourceSet resourceSet = Util.getResourceSet(selectedElement);

		for (int i = 0 ; i < profilesToImport.length ; i++) {
			RegisteredProfile currentProfile	= (RegisteredProfile) (profilesToImport[i]);
			URI modelUri = currentProfile.uri;

			Resource modelResource = resourceSet.getResource(modelUri,true);
			PackageImportTreeSelectionDialog eisd = new PackageImportTreeSelectionDialog(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					((Package)modelResource.getContents().get(0)));
			int ret = eisd.open();

			if(ret==Window.OK){
				ArrayList result = eisd.getResult();
				Iterator resultIter = result.iterator();
				while(resultIter.hasNext()){
					Element element = (Element)resultIter.next();
					PackageImport ei = UMLFactory.eINSTANCE.createPackageImport();
					ei.setImportedPackage((Package)element);
					getSelectedElement().getPackageImports().add(ei);
				}
			}
		}
	}

	/**
	 * Returns the array of available profiles for the currently selected package.
	 * <p>It returns all registered profiles except the already imported ones.</p> 
	 * @return the array of available profiles for the currently selected package
	 */
	protected RegisteredProfile[] getAvailableProfiles() {
		List<RegisteredProfile> profiles = new ArrayList<RegisteredProfile>();
		RegisteredProfile[] allprofiles = RegisteredProfile.getRegisteredProfiles();
		for (int i = 0; i < allprofiles.length; i++) {
			RegisteredProfile registeredProfile = allprofiles[i];
			List<String> importedPackageNames = PackageUtil.getImportedPackagesNames(getSelectedElement());
			if(!(importedPackageNames.contains(registeredProfile.getName()))) {
				profiles.add(registeredProfile);
			}
		}
		return (RegisteredProfile[]) profiles.toArray(new RegisteredProfile[profiles.size()]);
	}
	
	/**
	 * Returns the array of already selected profiles for the currently selected package.
	 * <p>It returns all already imported profiles.</p> 
	 * @return the array of already selected profiles for the currently selected package
	 */
	protected Collection<RegisteredProfile> getImportedProfiles() {
		List<RegisteredProfile> profiles = new ArrayList<RegisteredProfile>();
		RegisteredProfile[] allProfiles = RegisteredProfile.getRegisteredProfiles();
		for (int i = 0; i < allProfiles.length; i++) {
			RegisteredProfile registeredProfile = allProfiles[i];
			List<String> importedPackageNames = PackageUtil.getImportedPackagesNames(getSelectedElement());
			if(importedPackageNames.contains(registeredProfile.getName())) {
				profiles.add(registeredProfile);
			}
		}
		return profiles;
	}
	
	
	/**
	 * Specific {@link ChangeCommand} that imports profiles as libraries from repository
	 */
	public class ImportProfilesAsLibraryFromRepositoryCommand extends ChangeCommand { 

		/**
		 * Creates a new ImportProfilesAsLibraryFromRepositoryCommand
		 * @param editingDomain editing domain that manages the changed objects 
		 * @param runnable process that executes the modifications
		 * @param label the label of the command
		 * @param description description of the command
		 */
		public ImportProfilesAsLibraryFromRepositoryCommand(EditingDomain editingDomain) {
			super(editingDomain, new Runnable() {
				public void run() {
					// Retrieve shell instance
					Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

					// get the set of registered profiles available
					RegisteredProfile[] allProfiles = RegisteredProfile.getRegisteredProfiles();

					// Open Registered ModelLibrary selection dialog
					FilteredRegisteredProfilesAsLibrarySelectionDialog dialog = new FilteredRegisteredProfilesAsLibrarySelectionDialog(shell, true, allProfiles, getImportedProfiles());
					dialog.open();
					if (Dialog.OK == dialog.getReturnCode()) {
						// get the result, which is the set of libraries to import
						List<Object> profilesToImport = Arrays.asList(dialog.getResult());
						importProfiles(((RegisteredProfile[]) profilesToImport.toArray(new RegisteredProfile[profilesToImport.size()])));
					}
				}
			}, "Import Profiles as libraries", "Import Profiles as libraries from Repository");
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean canExecute() {
			return (getSelectedElement()!=null);
		}
	}
}
