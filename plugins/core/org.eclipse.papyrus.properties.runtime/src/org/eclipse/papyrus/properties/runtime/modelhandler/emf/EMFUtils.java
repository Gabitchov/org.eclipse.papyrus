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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.properties.runtime.Activator;


/**
 * Util class for EMF
 */
public class EMFUtils {

	/**
	 * Retrieve a {@link EStructuralFeature} by its name
	 * 
	 * @param objectToEdit
	 *        the object being edited
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
}
