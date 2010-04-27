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
package org.eclipse.papyrus.properties.tabbed.core.view.subfeatures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.properties.runtime.Activator;


/**
 * Simple sub feature descriptor for emf objects. It only looks in a given feature of the list of given EObjects
 */
public class EMFSimpleSubFeatureDescriptor extends SubFeatureDescriptor {

	protected final String featureNameToEdit;


	/**
	 * Creates a new EMFSimpleSubFeatureDescriptor.
	 * 
	 * @param featureName
	 *        the nmae of the feature to edit
	 */
	public EMFSimpleSubFeatureDescriptor(String featureName) {
		this.featureNameToEdit = featureName;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getSubElementsToEdit(List<Object> editedObjects) {
		List<Object> results = new ArrayList<Object>();
		for(Object object : editedObjects) {
			if(object instanceof EObject) {
				EStructuralFeature feature = ((EObject)object).eClass().getEStructuralFeature(featureNameToEdit);
				if(feature != null) {
					Object values = ((EObject)object).eGet(feature);
					if(values instanceof List<?>) {
						results.addAll((List<Object>)values);
					} else if(values != null) {
						results.add(values);
					}
				} else {
					Activator.log.error("Impossible to find the feature [" + featureNameToEdit + "] for object: " + object, null);
				}
			}
		}
		return results;
	}
}
