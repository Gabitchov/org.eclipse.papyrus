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
import org.eclipse.papyrus.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;


/**
 * Extract or inject values for a string-typed feature.
 */
public class StringEMFModelHandler implements IEMFModelHandler {

	/** ID of this model handler */
	public static final String ID = "String";

	/**
	 * @{inheritDoc
	 */
	public Object getValueToEdit(EObject objectToEdit, EStructuralFeature featureToEdit, IPropertyEditorControllerDescriptor descriptor) {
		return objectToEdit.eGet(featureToEdit);
	}

	/**
	 * @{inheritDoc
	 */
	public void setValueInModel(EObject objectToEdit, EStructuralFeature featureToEdit, Object newValue) {
		objectToEdit.eSet(featureToEdit, newValue);
	}

	/**
	 * @{inheritDoc
	 */
	public void completeEditorDescriptor(IPropertyEditorDescriptor descriptor, List<EObject> objectToEdit, EStructuralFeature featureToEdit) {
		// nothing to do here
	}


}
