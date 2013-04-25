/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.controlmode.profile.helpers;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;

/**
 * This helper provides methods to manipulate profile applications on packages.
 * 
 * @author vhemery
 */
public class ProfileApplicationHelper {

	/** EAnnotation for duplicated profiles on controlled packages */
	public static final String DUPLICATED_PROFILE = "duplicatedProfile";

	/**
	 * Duplicate a profile application on a child package.
	 * 
	 * @param _package
	 *        package to duplicate profile application on
	 * @param profile
	 *        profile to apply
	 */
	public static void duplicateProfileApplication(Package _package, Profile profile) {
		if(profile != null && profile.getDefinition() != null) {
			if(!isSameProfileApplied(_package, profile)) {
				_package.applyProfile(profile);
				ProfileApplication profileAppl = _package.getProfileApplication(profile);
				if(profileAppl != null) {
					markAsDuplicate(profileAppl);
				}
			}
		}
	}

	/**
	 * Remove a profile application duplicate on a child package
	 * 
	 * @param _package
	 *        package to remove duplicated profile application from
	 * @param profile
	 *        profile to unapply
	 * @param force
	 *        true when package is no longer controlled for forcing profile application removal
	 */
	public static void removeProfileApplicationDuplication(Package _package, Profile profile, boolean force) {
		if(profile != null && profile.getDefinition() != null) {
			if(isSameProfileApplied(_package, profile)) {
				ProfileApplication profileAppl = _package.getProfileApplication(profile);
				// remove only duplicated profile applications with eannotation
				if(isDuplicatedProfileApplication(profileAppl)) {
					if(force || getParentPackageWithProfile(_package, profile, false) == null) {
						// first remove eannotation to ensure it will not added again by checker
						profileAppl.getEAnnotations().remove(profileAppl.getEAnnotation(DUPLICATED_PROFILE));
						_package.unapplyProfile(profile);
					}
					// else, there is another parent profile which justifies the duplication
				}
			}
		}
	}

	/**
	 * Check if the profile is applied on a package, or one similar
	 * 
	 * @param _package
	 *        package to test on
	 * @param profile
	 *        profile to check
	 * @return true if a similar profile is applied
	 */
	private static boolean isSameProfileApplied(Package _package, Profile profile) {
		for(Profile prof : _package.getAppliedProfiles()) {
			if(prof == null) {
				break;
			}
			if(prof.equals(profile)) {
				return true;
			}
			if(profile.getQualifiedName() != null && profile.getQualifiedName().equals(prof.getQualifiedName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Relocate stereotype applications for the nested elements of the selection in the controlled resource
	 * 
	 * @param pack
	 *        the package for which stereotype application must be relocated
	 * @param target
	 *        the target controlled resource
	 */
	public static void nestedRelocateStereotypeApplications(Package pack, Resource target) {
		relocateStereotypeApplications(pack, target);
		for(Iterator<EObject> i = EcoreUtil.getAllProperContents(pack, true); i.hasNext();) {
			EObject current = i.next();
			if(current instanceof Element) {
				relocateStereotypeApplications((Element)current, target);
			}
		}
	}
	
	/**
	 * Relocate stereotype applications for the an element in the controlled resource
	 * 
	 * @param element
	 *        the element for which stereotype application must be relocated
	 * @param target
	 *        the target controlled resource
	 */
	public static void relocateStereotypeApplications(Element element, Resource targetResource) {
		EList<EObject> stereotypeApplications = element.getStereotypeApplications();
			targetResource.getContents().addAll(stereotypeApplications);
	}

	/**
	 * Check if the profile application is a duplicated one
	 * 
	 * @param profileAppl
	 *        profile application to check
	 * @return true if it is a duplicated copy
	 */
	public static boolean isDuplicatedProfileApplication(ProfileApplication profileAppl) {
		return profileAppl.getEAnnotation(DUPLICATED_PROFILE) != null;
	}

	/**
	 * Get the nearest parent package which has the profile applied.
	 * 
	 * @param packageElement
	 *        child package
	 * @param profile
	 *        applied profile
	 * @param notControlledOnly
	 *        true to return only a not controlled package
	 * @return the parent package with profile application
	 */
	public static Package getParentPackageWithProfile(Package packageElement, Profile profile, boolean notControlledOnly) {
		if(profile != null && profile.getDefinition() != null) {
			Element parent = packageElement.getOwner();
			while(parent != null) {
				if(parent instanceof Package) {
					Package parentPackage = (Package)parent;
					if(isSameProfileApplied(parentPackage, profile)) {
						if(!notControlledOnly || !AdapterFactoryEditingDomain.isControlled(parentPackage)) {
							return parentPackage;
						}
					}
				}
				parent = parent.getOwner();
			}
		}
		return null;
	}

	/**
	 * Mark this profile application as the duplication of a parent profile
	 * 
	 * @param profileAppl
	 *        profile application to mark
	 */
	public static void markAsDuplicate(ProfileApplication profileAppl) {
		// add eannotation for duplicated profile applications
		profileAppl.createEAnnotation(DUPLICATED_PROFILE);
	}

}
