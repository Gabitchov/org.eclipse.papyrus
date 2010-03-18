/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagramprofile.utils;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The Class StereotypeUtils.
 */
public class StereotypeUtils {

	/** extension point ID to load profile */
	public static final String extensionPointIdForProfile = "org.eclipse.uml2.uml.generated_package";

	/** URI for profile */
	public static final String uriExtensionPointIdForProfile = "uri";

	/** location for profile */
	public static final String locationExtensionPointIdForProfile = "location";
	
	/** URI for SysML profile */
	public static final String SYSML_URI = "http://www.eclipse.org/papyrus/0.7.0/SysML";

	/**
	 * Get the base Element from a stereotype application.
	 * 
	 * @param e
	 *            , the stereotype application
	 * 
	 * @return the base element
	 */
	public static EObject getBaseElement(EObject e) {
		if (e != null) {
			for (EStructuralFeature f : e.eClass().getEAllStructuralFeatures()) {
				if (f.getName().startsWith("base_")) {
					Object b = e.eGet(f);
					if (b instanceof EObject && b != null) {
						return (EObject) b;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Checks if is profile applied.
	 * 
	 * @param qualifiedName
	 *            the qualified name of the profile
	 * @param e
	 *            the element
	 * 
	 * @return true, if the profile is applied
	 */
	public static boolean isProfileApplied(String qualifiedName, Element e) {
		if (qualifiedName == null || e == null || qualifiedName.length() == 0) {
			return false;
		}
		Package p = e.getNearestPackage();
		for (Profile pr : p.getAllAppliedProfiles()) {
			if (qualifiedName.equals(pr.getQualifiedName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the is stereotype applied.
	 * 
	 * @param qualifiedName
	 *            the qualified name of the stereotype
	 * @param e
	 *            the element to check
	 * 
	 * @return true, if the stereotype is applied
	 */
	public static boolean isStereotypeApplied(String qualifiedName, Element e) {
		if (qualifiedName == null || e == null || qualifiedName.length() == 0) {
			return false;
		}
		Stereotype s = e.getAppliedStereotype(qualifiedName);
		return s != null;
	}

	/**
	 * Load a profile from an URI
	 * 
	 * @return the profile
	 */
	public static Profile loadProfile(String uri, ResourceSet set) {
		String locationURI = "";
		Profile profile = null;
		IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor(
				extensionPointIdForProfile);
		for (IConfigurationElement e : extensions) {
			String extensionURI = e.getAttribute(uriExtensionPointIdForProfile);
			if (extensionURI.equals(uri)) {
				locationURI = e.getAttribute(locationExtensionPointIdForProfile);
				URI profileURI = URI.createURI(locationURI);
				if (set != null) {
					Resource resource = set.getResource(profileURI, true);
					for (EObject obj : resource.getContents()) {
						if (obj instanceof Profile) {
							profile = (Profile) obj;
							return profile;
						}
					}
				}
			}
		}
		return profile;
	}

	/**
	 * Apply a profile on a package, from an URI
	 */
	public static void applyProfile(String uri, Package element) {
		Profile profile = loadProfile(uri, element.eResource().getResourceSet());
		if (profile != null) {
			element.applyProfile(profile);
		}
	}
	
	/**
	 * Apply the SysML profile on the specified element
	 */
	public static void applySysMLProfile(Package element) {
		Profile profile = loadProfile(SYSML_URI, element.eResource().getResourceSet());
		if (profile != null) {
			element.applyProfile(profile);
			// Apply sub profiles of SysML
			for(Element e : profile.getOwnedElements()){
				if(e instanceof Profile){
					element.applyProfile((Profile)e);
				}
			}
		}
	}
	
	/**
	 * Apply stereotype to element.
	 * 
	 * @param element the element
	 * @param stereotypeName the stereotype qualified name
	 */
	public static void applyStereotypeToElement(Element element, String stereotypeName) {
		for (Stereotype stereotype : element.getApplicableStereotypes()) {
			if (stereotype.getQualifiedName().equals(stereotypeName)) {
				element.applyStereotype(stereotype);
			}
		}
	}

}
