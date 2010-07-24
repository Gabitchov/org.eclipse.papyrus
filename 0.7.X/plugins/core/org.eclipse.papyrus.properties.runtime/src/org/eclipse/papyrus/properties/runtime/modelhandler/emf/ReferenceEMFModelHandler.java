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
 * Model Handler for References
 */
public class ReferenceEMFModelHandler extends EMFFeatureModelHandler {

	/**
	 * Creates a new ReferenceEMFModelHandler.
	 * 
	 * @param featureName
	 *        the name of the feature to edit
	 */
	public ReferenceEMFModelHandler(String featureName) {
		super(featureName);
	}

	/** identifier fot this model handler */
	public static final String ID = "Reference";

	/**
	 * {@inheritDoc}
	 */
	public void setValueInModel(EObject objectToEdit, Object newValue) {
		EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
		if(featureToEdit == null) {
			return;
		}
		if(newValue instanceof EObject || newValue == null) {
			objectToEdit.eSet(featureToEdit, newValue);
		} else if(newValue instanceof List<?>) {
			objectToEdit.eSet(featureToEdit, newValue);
		} else {
			Activator.log.error("impossible to set the new value", null);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void completeEditorDescriptor(IPropertyEditorDescriptor descriptor, List<? extends EObject> objectToEdit) {

	}

	/**
	 * {@inheritDoc}
	 */
	public String getId() {
		return ID;
	}
}
