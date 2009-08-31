/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann TANGUY (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

import java.lang.reflect.Method;
import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Stereotype;

public class ElementUtil {

	/**
	 * Check if the StereotypedElement has the given stereotype.
	 * 
	 * @param stereotypeName
	 *            The name of the stereotype to find.
	 * @return the Stereotype application EObject.
	 */
	public static EObject hasStereotype(Element elt, EClass stereotypeClass) {
		EObject stereotypeApplication = null;

		// Stereotype parsing
		Iterator<EObject> stAppIt = elt.getStereotypeApplications().iterator();
		while (stAppIt.hasNext() && (stereotypeApplication == null)) {
			EObject stApp = stAppIt.next();
			if (stApp.eClass().getEAllSuperTypes().contains(stereotypeClass)
					|| (stApp.eClass().equals(stereotypeClass))) {
				stereotypeApplication = stApp;
			}
		}

		return stereotypeApplication;
	}

	/**
	 * Getter to select an image for a stereotyped element (based on 1st applied stereotype)
	 * 
	 * @param element
	 *            the element for which we are looking the icon
	 * @param stereotype
	 *            the stereotype that should have the icon
	 * @param kind
	 *            kind of display, should be <code>"icon"</code> or <code>"shape"</code>
	 * @return the image corresponding to the stereotype or <code>null</code> if no image can be
	 *         found
	 */
	public static Image getStereotypeImage(Element element, Stereotype stereotype, String kind) {
		if (stereotype == null || element.getAppliedStereotypes() == null) {
			return null;
		}

		Image image = null;

		// Try to retrieve image based on getter implemented in static profile
		image = ElementUtil.getStereotypeImageFromGetter(element, stereotype, kind);

		if (image == null) {
			// No image found by getters
			// Search for the image verifying expressions
			EList<Image> availableImages = new BasicEList<Image>();
			if ("icon".equals(kind)) {
				availableImages = StereotypeUtil.getIcons(stereotype);
			} else if ("shape".equals(kind)) {
				availableImages = StereotypeUtil.getShapes(stereotype);
			}

			if (!(availableImages).isEmpty()) {
				// Retrieve first image verifying expression or
				// first image if no expression is verified
				image = ImageUtil.findImageVerifyingExpression(element, availableImages);

				if (image == null) {
					image = availableImages.get(0);
				}
			}
		}

		return image;
	}

	/**
	 * Getter to select an image for a stereotyped element (based on 1st applied stereotype)
	 * 
	 * @param element
	 *            to check
	 * @param kind
	 *            of image ("icon" | "shape")
	 * @return {@link Image} or null
	 */
	public static Image getStereotypeImage(Element element, String kind) {
		// Get first stereotype
		if (element.getAppliedStereotypes() == null || element.getAppliedStereotypes().isEmpty()) {
			return null; // null
		}

		// The image is one of the 1st stereotype
		Stereotype stereotype = element.getAppliedStereotypes().get(0);

		return getStereotypeImage(element, stereotype, kind);
	}

	/**
	 * Find the image using a getter implemented in a static profile
	 * 
	 * @param element
	 *            the stereotyped element
	 * @param stereotype
	 *            the applied stereotype
	 * @param kind
	 *            the kind of searched image ("icon" | "shape")
	 * @return {@link Image} or null
	 */
	public static Image getStereotypeImageFromGetter(Element element, Stereotype stereotype, String kind) {

		// Prepare getter method name
		String getterName = "";
		if ("icon".equals(kind)) {
			getterName += "getIcon";

		} else if ("shape".equals(kind)) {
			getterName += "getShape";

		} else {
			// Unknown kind : abort and return null (no image)
			return null;
		}

		// If the getter is implemented, it is implemented by the
		// StereotypeApplication class
		EObject stApp = element.getStereotypeApplication(stereotype);
		Method getter = null;
		try {
			getter = stApp.getClass().getDeclaredMethod(getterName);
		} catch (Exception e) {
			// Implementation not found
		}

		// If the getter exists, invoke
		if (getter != null) {
			try {

				// Retrieve image via getter in static profile
				Image image = (Image) getter.invoke(stApp);

				return image;

			} catch (Exception e) {
				// Invoke getter has failed
				return null;
			}
		}

		return null;
	}

	/**
	 * Test if the element has stereotype icons to display
	 * 
	 * @param element
	 *            the element for which icon are searched
	 * @return <code>true</code> if icons were found
	 */
	public static boolean hasIcons(Element element) {
		if (!element.getAppliedStereotypes().isEmpty()) {
			return hasIcons(element, element.getAppliedStereotypes().get(0));
		}
		return false;
	}

	/**
	 * Test if the element has icons for the given stereotype
	 * 
	 * @param stereotype
	 *            the stereotype we check to see if it has icon or not
	 * @param element
	 *            the stereotyped element
	 * @return <code>true</code> if icons were found
	 */
	public static boolean hasIcons(Element element, Stereotype stereotype) {
		return stereotype != null && !StereotypeUtil.getIcons(stereotype).isEmpty();
	}

	/**
	 * Test if the element has stereotype shape to display
	 * 
	 * @param element
	 *            the element for which shape are searched
	 * @return <code>true</code> if shape were found
	 */
	public static boolean hasShapes(Element element) {
		if (!element.getAppliedStereotypes().isEmpty()) {
			return hasShapes(element, element.getAppliedStereotypes().get(0));
		}
		return false;
	}

	/**
	 * Test if the stereotype has shapes
	 * 
	 * @param stereotype
	 * @return true if shapes were found
	 */
	public static boolean hasShapes(Element element, Stereotype stereotype) {
		return stereotype != null && !StereotypeUtil.getShapes(stereotype).isEmpty();
	}
}
