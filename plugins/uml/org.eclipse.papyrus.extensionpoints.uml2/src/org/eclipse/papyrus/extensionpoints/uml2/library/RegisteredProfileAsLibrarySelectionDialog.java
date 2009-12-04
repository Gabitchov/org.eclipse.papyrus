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
package org.eclipse.papyrus.extensionpoints.uml2.library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.extensionpoints.uml2.Activator;
import org.eclipse.papyrus.extensionpoints.uml2.profile.RegisteredProfile;
import org.eclipse.papyrus.extensionpoints.uml2.standard.ExtensionLabelProvider;
import org.eclipse.papyrus.extensionpoints.uml2.utils.Util;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * 
 */
public class RegisteredProfileAsLibrarySelectionDialog extends ElementListSelectionDialog {

	/**
	 * 
	 */
	private EList importedProfiles;

	/**
	 * 
	 */
	private List<String> importedProfilesNames;

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
	public RegisteredProfileAsLibrarySelectionDialog(Composite parent, Package umlPackage) {
		super(parent.getShell(), new ExtensionLabelProvider());

		currentPackage = umlPackage;
		importedProfiles = umlPackage.getPackageImports();
		importedProfilesNames = getImportedProfileNames(importedProfiles);

		// Retrieve registered profiles
		regProfiles = RegisteredProfile.getRegisteredProfiles();
		// remove already applied profiles from the list
		regProfiles = removeAlreadyImportedFromSelection();

		this.setTitle("Apply profiles from Papyrus repository :");
		this.setElements(regProfiles);
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public boolean run() {
		this.open();
		return this.treatSelection();
	}

	/**
	 * 
	 * 
	 * @param appliedProfiles
	 * 
	 * @return
	 */
	private List<String> getImportedProfileNames(EList appliedProfiles) {

		List<String> Libraries = new ArrayList<String>();
		Iterator importedIt = importedProfiles.iterator();

		while(importedIt.hasNext()) {
			org.eclipse.uml2.uml.PackageImport currentImport = (org.eclipse.uml2.uml.PackageImport)importedIt.next();
			String currentName = currentImport.getImportedPackage().getName();
			Libraries.add(currentName);
		}

		return Libraries;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	private RegisteredProfile[] removeAlreadyImportedFromSelection() {

		List<RegisteredProfile> profiles = new ArrayList<RegisteredProfile>();

		for(int i = 0; i < regProfiles.length; i++) {

			String currentName = regProfiles[i].name;
			if(!importedProfilesNames.contains(currentName)) {
				profiles.add(regProfiles[i]);
			}
		}

		RegisteredProfile[] cleandList;
		cleandList = profiles.toArray(new RegisteredProfile[profiles.size()]);

		return cleandList;
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

		if(selection == null) { // Cancel was selected
			return hasChanged;
		}

		for(int i = 0; i < selection.length; i++) {

			RegisteredProfile currentProfile = (RegisteredProfile)(selection[i]);
			URI modelUri = currentProfile.uri;

			PackageImport pi = getModelLibraryImportFromURI(modelUri);

			if(pi != null) {
				currentPackage.getPackageImports().add(pi);
			}
		}
		return hasChanged;
	}

	/**
	 * 
	 * 
	 * @param uri
	 * 
	 * @return
	 */
	public PackageImport getModelLibraryImportFromURI(URI uri) {

		ResourceSet resourceSet = Util.getResourceSet(currentPackage);
		Resource modelResource = resourceSet.getResource(uri, true);

		if(modelResource.getContents().size() <= 0) {
			Activator.getDefault().getLog().log(
					new Status(IStatus.ERROR, Activator.PLUGIN_ID, "No element found in model from URI "
					+ uri.toString()));
			return null;
		}

		// Try to reach model
		Element root = (Element)modelResource.getContents().get(0);

		if(root instanceof Package) {

			// Import model library
			Package libToImport = (Package)(modelResource.getContents().get(0));
			// create import package
			PackageImport modelLibImport = UMLFactory.eINSTANCE.createPackageImport();
			modelLibImport.setImportedPackage(libToImport);

			return modelLibImport;
		}
		Activator.getDefault().getLog().log(
				new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The selected uri (" + uri.toString()
				+ ") does not contain any model library !"));
		return null;
	}
}
