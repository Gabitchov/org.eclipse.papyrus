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
package org.eclipse.papyrus.views.properties.runtime.controller.descriptor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.IEMFModelHandler;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.uml2.uml.StructuralFeature;

/**
 * Basic configuration for property editor controllers
 */
public class EMFTBindingPropertyEditorControllerDescriptor extends EMFTPropertyEditorControllerDescriptor implements IBindingLabelProviderDescriptor {

	/** message to bind */
	private String message;

	/** name of the features to bind */
	private String[] featuresName;

	/**
	 * Creates a new EMFTBindingPropertyEditorControllerDescriptor.
	 * 
	 * @param controllerID
	 *        the id of the controller
	 * @param multiSelection
	 *        indicates if the controller accepts multi-selection
	 * @param featureNameToEdit
	 *        name of the features to edit
	 * @param handler
	 *        model handler used to interact with the model
	 * @param editorDescriptor
	 *        descriptor of the editor
	 * @param constraints
	 *        the list of constraints for this descriptor
	 * @param message
	 *        message to bind
	 * @param featuresName
	 *        names of the features to bind
	 */
	public EMFTBindingPropertyEditorControllerDescriptor(String controllerID, boolean multiSelection, String featureNameToEdit, IEMFModelHandler handler, IPropertyEditorDescriptor editorDescriptor, List<IConstraintDescriptor> constraints, String message, String[] featuresName) {
		super(controllerID, multiSelection, featureNameToEdit, handler, editorDescriptor, constraints);
		this.message = message;
		this.featuresName = featuresName;
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
		return featuresName;
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
