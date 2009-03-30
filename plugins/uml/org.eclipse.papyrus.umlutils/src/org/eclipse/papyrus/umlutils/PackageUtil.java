/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.UMLFactory;

public class PackageUtil {

	/**
	 * Apply a profile and every subprofiles to a package. Also import types defined in profile
	 * 
	 * @param profileToApply
	 *            profile to apply on package
	 * @param package_
	 *            on which profiles are applied
	 * @param withSubProfiles
	 *            true if subprofiles must be automatically imported
	 */
	public static boolean applyProfile(org.eclipse.uml2.uml.Package package_, org.eclipse.uml2.uml.Profile profileToApply, boolean withSubProfiles) {

		// Return true if the model was modified
		boolean isChanged = false;

		// if profile is not defined abort treatment
		if (!profileToApply.isDefined()) {
			return isChanged;
		}

		// if same version of profile is applied do not reapply it
		ProfileApplication profileApplication = package_.getProfileApplication(profileToApply);
		if (profileApplication != null) {

			EPackage previous_definition = profileApplication.getAppliedDefinition();
			EPackage new_definition = profileToApply.getDefinition();
			if (previous_definition == new_definition) {
				return isChanged;
			}
		}

		// Apply main profile and import contained types
		package_.applyProfile(profileToApply);
		importTypes(package_, profileToApply);
		isChanged = true;

		if (withSubProfiles) {
			// Manage sub profiles
			ArrayList<Profile> subProfiles = new ArrayList<Profile>();
			subProfiles = getSubProfiles(profileToApply);

			Iterator<Profile> iter = subProfiles.iterator();
			while (iter.hasNext()) {
				Profile subProfile = (Profile) iter.next();
				package_.applyProfile(subProfile);
				importTypes(package_, subProfile);
			}
		}

		return isChanged;
	}

	/**
	 * Retrieve recursively the subprofiles of package.
	 * 
	 * @param profile
	 * 
	 * @return an arrayList containing the subprofiles
	 */
	public static ArrayList<Profile> getSubProfiles(org.eclipse.uml2.uml.Package package_) {
		ArrayList<Profile> subProfiles = new ArrayList<Profile>();

		Iterator<org.eclipse.uml2.uml.NamedElement> iter = package_.getMembers().iterator();
		while (iter.hasNext()) {

			Object element = iter.next();
			if (element instanceof Profile) {
				Profile currentSubProfile = (Profile) element;
				subProfiles.add(currentSubProfile);
				subProfiles.addAll(getSubProfiles(currentSubProfile));
			} else if (element instanceof org.eclipse.uml2.uml.Package) {
				org.eclipse.uml2.uml.Package currentSubPackage = (org.eclipse.uml2.uml.Package) element;
				subProfiles.addAll(getSubProfiles(currentSubPackage));
			}
		}
		return subProfiles;
	}

	/**
	 * Import public type contained in the profileToApply into pkg.
	 * 
	 * @param profileToApply
	 *            profile that contains type to import
	 * @param pkg
	 *            receive the types from profile
	 */
	private static void importTypes(Package pkg, Package profileToApply) {

		/** import public types of the profile */

		// get visible members of the profile
		EList<PackageableElement> visibleMemb = profileToApply.visibleMembers();
		Iterator<PackageableElement> iterator = visibleMemb.iterator();

		while (iterator.hasNext()) {
			Element elemt = iterator.next();

			if (elemt instanceof Package) {

				// if the package is a model library the import it
				// in the package on which the profile is applied
				if (((Package) elemt).isModelLibrary()) {
					PackageImport pi = UMLFactory.eINSTANCE.createPackageImport();
					pi.setImportedPackage((Package) elemt);
					pkg.getPackageImports().add(pi);
				}
			}
		}
	}

	/**
	 * returns the list of the names of imported packages
	 * 
	 * @param pkg
	 *            the package that has element imports
	 * @return the list of the name of imported packages
	 */
	public static List<String> getImportedPackagesNames(Package pkg) {
		List<String> packageNames = new ArrayList<String>();
		// iterate through package imports of the given package
		Iterator<PackageImport> importedIt = pkg.getPackageImports().iterator();
		while (importedIt.hasNext()) {
			PackageImport currentImport = importedIt.next();
			// get name of the imported package and adds it to the result list
			String currentName = currentImport.getImportedPackage().getName();
			packageNames.add(currentName);
		}
		return packageNames;
	}

	/**
	 * Removes the last definition of a profile, and in its nested profiles
	 * 
	 * @param thepackage
	 *            profile to clean
	 */
	public static void removeLastDefinition(Package thepackage) {
		removeLastDefinition(thepackage, true);
	}

	/**
	 * Removes the last definition of a profile
	 * 
	 * @param thepackage
	 *            profile to clean
	 * @param recursive
	 *            boolean <code>true</code> if the clean is recursive, i.e. nested profiles must be clean
	 */
	public static void removeLastDefinition(Package thepackage, boolean recursive) {
		// he wants to define
		if (thepackage instanceof Profile) {
			EPackage pak = ((Profile) thepackage).getDefinition();
			((EAnnotation) pak.eContainer()).getContents().remove(pak);
		}
		if (recursive) {
			Iterator<Package> it = thepackage.getNestedPackages().iterator();
			while (it.hasNext()) {
				Package p = it.next();
				removeLastDefinition(p, recursive);
			}
		}
	}

	/**
	 * Define this package if it is a profile and its sub-profiles
	 * 
	 * @param thePackage
	 *            the package to define (if it is a profile)
	 */
	public static void defineProfiles(Package thePackage) {
		// he wants to define
		if (thePackage instanceof Profile) {
			((Profile) thePackage).define();
		}
		Iterator<Package> it = thePackage.getNestedPackages().iterator();
		while (it.hasNext()) {
			Package p = it.next();
			defineProfiles(p);
		}
	}

	/**
	 * 
	 * 
	 * @return returns all nested elements of a package (classes, packages, interfaces, data types, properties, operations) Returned elements are of type org.eclipse.uml2.uml.Element
	 */
	public static Set<Element> getAllNestedElements(Package thePackage) {
		Set<org.eclipse.uml2.uml.Element> nestedElements = new HashSet<Element>();
		Iterator<org.eclipse.uml2.uml.NamedElement> i = thePackage.getOwnedMembers().iterator();
		org.eclipse.uml2.uml.Element currentElement;
		while (i.hasNext()) {
			currentElement = i.next();
			nestedElements.add(currentElement);
			// Package
			if (currentElement instanceof org.eclipse.uml2.uml.Package) {
				nestedElements.addAll((PackageUtil.getAllNestedElements((Package) currentElement)));
			}
			// Class
			else if (currentElement instanceof org.eclipse.uml2.uml.Class) {
				nestedElements.addAll(((org.eclipse.uml2.uml.Class) currentElement).getMembers());
			}
		}
		return nestedElements;
	}
}
