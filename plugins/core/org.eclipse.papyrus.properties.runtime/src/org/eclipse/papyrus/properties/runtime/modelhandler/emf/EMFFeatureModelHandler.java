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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;


/**
 * Abstract class for EMF Model handlers
 */
public abstract class EMFFeatureModelHandler implements IEMFModelHandler {

	/** name of the feature to edit */
	private final String featureName;

	/**
	 * Creates a new EMFFeatureModelHandler.
	 * 
	 * @param featureName
	 *        the name of the feature to edit
	 */
	public EMFFeatureModelHandler(String featureName) {
		this.featureName = featureName;
	}

	/**
	 * @{inheritDoc
	 */
	public Object getValueToEdit(EObject objectToEdit) {
		EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
		if(featureToEdit == null) {
			return null;
		}
		return objectToEdit.eGet(featureToEdit);
	}

	/**
	 * {@inheritDoc}
	 */
	public abstract void setValueInModel(EObject objectToEdit, Object newValue);

	/**
	 * {@inheritDoc}
	 */
	public abstract void completeEditorDescriptor(IPropertyEditorDescriptor descriptor, List<EObject> objectToEdit);

	/**
	 * Returns the name of the feature to edit
	 * 
	 * @return the name of the feature to edit
	 */
	public String getFeatureName() {
		return featureName;
	}

	/**
	 * Retrieve a {@link EStructuralFeature} by its name
	 * 
	 * @param objectToEdit
	 *        the object being edited
	 * @return the feature found <code>null</code> if not found
	 */
	public EStructuralFeature getFeatureByName(EObject objectToEdit) {
		EStructuralFeature feature = objectToEdit.eClass().getEStructuralFeature(featureName);
		if(feature != null) {
			return feature;
		}
		Activator.log.error("impossible to find feature " + featureName + " for object " + objectToEdit, null);
		return null;
	}

	/**
	 * checks if the feature is changeable
	 * 
	 * @param objectsToEdit
	 *        the list of objects to edit
	 * @return <code>true</code> if the feature is changeable
	 */
	public boolean isChangeable(List<EObject> objectsToEdit) {
		if(objectsToEdit.size() < 1) {
			return false;
		}
		// retrieve the feature
		EStructuralFeature feature = getFeatureByName(objectsToEdit.get(0));
		return (feature != null) ? feature.isChangeable() : false;
	}

}
