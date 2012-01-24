/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.utils;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Utility class use to retrieve stereotype applications.
 * 
 * Copied from oep.umlutils to avoid dependency toward this plug-in.
 * 
 */
public class ElementUtil {

	/**
	 * The ID for Papyrus EAnnotations.
	 */
	private static final String PAPYRUS_URI = "org.eclipse.papyrus";

	/**
	 * The ID for element nature in Papyrus EAnnotations. 
	 */
	private static final String PAPYRUS_ELEMENT_NATURE = "nature";

	/**
	 * Convenient method to retrieve the StereotypeApplication by passing an
	 * element of the static profile.
	 * 
	 * @deprecated prefer using {@link UMLUtil#getStereotypeApplication(Element, Class)}
	 */
	@Deprecated
	public static <T extends EObject> T getStereotypeApplication(Element element, java.lang.Class<T> clazz) {
		return UMLUtil.getStereotypeApplication(element, clazz);
	}

	/**
	 * Adds the specified nature to this element.
	 * 
	 * @param element
	 *        The receiving '<em><b>Element</b></em>' model object.
	 * @param nature
	 *        The nature to add.
	 */
	public static void addNature(Element element, String nature) {
		EMap<String, String> details = UML2Util.getEAnnotation(element, PAPYRUS_URI, true).getDetails();

		if(!details.containsKey(PAPYRUS_ELEMENT_NATURE)) {
			details.put(PAPYRUS_ELEMENT_NATURE, nature);
		} else {
			details.removeKey(PAPYRUS_ELEMENT_NATURE);
			details.put(PAPYRUS_ELEMENT_NATURE, nature);
		}

	}

	/**
	 * Retrieves the nature for this element.
	 * 
	 * @param element
	 *        The receiving '<em><b>Element</b></em>' model object.
	 */
	public static String getNature(Element element) {
		EAnnotation eAnnotation = element.getEAnnotation(PAPYRUS_URI);

		if((eAnnotation != null) && (eAnnotation.getDetails().containsKey(PAPYRUS_ELEMENT_NATURE))) {
			return eAnnotation.getDetails().get(PAPYRUS_ELEMENT_NATURE);
		}

		return "";
	}

	/**
	 * Removes the nature from this element.
	 * 
	 * @param element
	 *        The receiving '<em><b>Element</b></em>' model object.
	 */
	public static boolean removeNature(Element element) {
		EAnnotation eAnnotation = element.getEAnnotation(PAPYRUS_URI);

		if(eAnnotation != null) {
			EMap<String, String> details = eAnnotation.getDetails();

			if(details.containsKey(PAPYRUS_ELEMENT_NATURE)) {
				details.removeKey(PAPYRUS_ELEMENT_NATURE);
				return true;
			}
		}

		return false;
	}

	/**
	 * Determines whether this element has the specified nature.
	 * 
	 * @param element
	 *        The receiving '<em><b>Element</b></em>' model object.
	 * @param nature
	 *        The nature in question.
	 */
	public static boolean hasNature(Element element, String nature) {
		EAnnotation eAnnotation = element.getEAnnotation(PAPYRUS_URI);

		if((eAnnotation != null) && (eAnnotation.getDetails().containsKey(PAPYRUS_ELEMENT_NATURE))) {
			if(nature.equals(eAnnotation.getDetails().get(PAPYRUS_ELEMENT_NATURE))) {
				return true;
			}
		}
		return false;
	}
}
