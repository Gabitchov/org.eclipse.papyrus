/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.runtime.modelhandler.emf;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;


/**
 * Util class for EMF and UML
 */
public class EMFUtils {

	/**
	 * Retrieve a {@link EStructuralFeature} by its name
	 * 
	 * @param objectToEdit
	 *        the object being edited
	 * @param featureName
	 *        the name of the feature to retrieve
	 * @return the feature found <code>null</code> if not found
	 */
	public static EStructuralFeature getFeatureByName(EObject objectToEdit, String featureName) {
		EStructuralFeature feature = objectToEdit.eClass().getEStructuralFeature(featureName);
		if(feature != null) {
			return feature;
		}
		Activator.log.error("impossible to find feature " + featureName + " for object " + objectToEdit, null);
		return null;
	}

	/**
	 * Retrieve the stereotype structural feature
	 * 
	 * @param elementToEdit
	 *        the UML element on which the stereotype is applied
	 * @param stereotype
	 *        the stereotype for which estructural feature is searched
	 * @param featureName
	 *        the name of the feature to find
	 * @return the feature found or <code>null</code>
	 */
	public static EStructuralFeature getStereotypeFeatureByName(Element elementToEdit, Stereotype stereotype, String featureName) {
		EObject eObject = elementToEdit.getStereotypeApplication(stereotype);

		if(eObject == null) {
			throw new IllegalArgumentException(String.valueOf(stereotype));
		}

		EClass eClass = eObject.eClass();
		String[] segments = featureName.split(NamedElement.SEPARATOR);

		for(int i = 0, length = segments.length; i < length; i++) {
			String segment = segments[i];
			EStructuralFeature eStructuralFeature = null;

			if(segment.indexOf('[') == -1) {
				eStructuralFeature = eClass.getEStructuralFeature(UML2Util.getValidJavaIdentifier(segment));
			} else {
				eStructuralFeature = eClass.getEStructuralFeature(UML2Util.getValidJavaIdentifier(segment.substring(0, segment.indexOf('['))));
			}

			if(eStructuralFeature == null) {
				throw new IllegalArgumentException(String.valueOf(featureName));
			}

			return eStructuralFeature;
		}

		Activator.log.error("impossible to find feature " + featureName + " for object " + elementToEdit, null);
		return null;
	}

}
