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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The Class StereotypeUtils.
 */
public class StereotypeUtils {

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

}
