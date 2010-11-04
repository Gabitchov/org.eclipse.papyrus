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
package org.eclipse.papyrus.sysml.service.types.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;

/**
 * Utility class use to retrieve stereotype applications.
 * 
 * Copied from oep.umlutils to avoid dependency toward this plug-in.
 * 
 */
public class ElementUtil {

	/**
	 * Convenient method to retrieve the StereotypeApplication by passing an element of the static profile.
	 * 
	 * @param <T>
	 *        the type of stereotype to look for
	 * @param element
	 *        an UML model element
	 * @param clazz
	 *        the class of an element of a static profile. Compatible sub-types will be returned as well
	 * @return the stereotype application or null if such stereotype is not applied
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> T getStereotypeApplication(Element element, Class<T> clazz) {
		for(EObject stereoApplication : element.getStereotypeApplications()) {
			// check whether the stereotype is an instance of the passed parameter class
			if(clazz.isInstance(stereoApplication)) {
				return (T)stereoApplication;
			}
		}
		return null;
	}
}
