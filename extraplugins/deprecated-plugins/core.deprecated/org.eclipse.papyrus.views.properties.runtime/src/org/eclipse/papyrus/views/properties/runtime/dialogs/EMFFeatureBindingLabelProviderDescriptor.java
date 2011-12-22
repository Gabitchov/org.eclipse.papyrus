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
package org.eclipse.papyrus.views.properties.runtime.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.IBindingLabelProviderDescriptor;
import org.eclipse.uml2.uml.StructuralFeature;

/**
 * Descriptor used for message binding on features
 */
public class EMFFeatureBindingLabelProviderDescriptor implements IBindingLabelProviderDescriptor {

	/** message to bind */
	private final String message;

	/** name of features used to bind message */
	private String[] featuresNameToEdit;

	/**
	 * Creates a new EMFFeatureBindingLabelProviderDescriptor.
	 * 
	 * @param message
	 *        the message to bind
	 * @param featuresNameToEdit
	 *        the name of features binded
	 * 
	 */
	public EMFFeatureBindingLabelProviderDescriptor(String message, String[] featuresNameToEdit) {
		this.message = message;
		this.featuresNameToEdit = featuresNameToEdit;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * {@inheritDoc}
	 */
	public String[] getFeaturesNameToBind() {
		return featuresNameToEdit;
	}

	/**
	 * computes bindings from the given descriptor
	 * 
	 * @param objectToEdit
	 *        the object to edit
	 * @return the list of values to bind
	 */
	public String computeBindings(Object objectToEdit) {
		List<Object> bindings = new ArrayList<Object>();

		if(objectToEdit instanceof EObject) {
			for(String name : getFeaturesNameToBind()) {
				EStructuralFeature feature = getFeatureByName(((EObject)objectToEdit), name);
				if(feature != null) {
					Object value = ((EObject)objectToEdit).eGet(feature);
					bindings.add(value);
				} else {
					Activator.log.error("impossible to find the feature with name : " + name, null);
				}
			}
		}

		return NLS.bind(getMessage(), bindings.toArray(new String[]{}));
	}

	/**
	 * Returns the feature given its name
	 * 
	 * @param objectToEdit
	 *        the object to edit
	 * @param name
	 *        the name of the feature to find
	 * @return the {@link StructuralFeature} found
	 */
	protected EStructuralFeature getFeatureByName(EObject objectToEdit, String name) {
		EStructuralFeature feature = objectToEdit.eClass().getEStructuralFeature(name);
		if(feature != null) {
			return feature;
		}
		return null;
	}
}
