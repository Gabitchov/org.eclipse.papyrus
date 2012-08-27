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
package org.eclipse.papyrus.views.properties.runtime.modelhandler.emf;

import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.swt.widgets.Composite;


/**
 * Model handler for reference properties of stereotypes
 */
public class ReferenceStereotypeModelHandler extends EMFStereotypeFeatureModelHandler {

	/** identifier for this model handler */
	public final static String ID = "ReferenceStereotype";

	/**
	 * Creates a new ReferenceStereotypeModelHandler.
	 * 
	 * @param stereotypeName
	 *        the name of the stereotype that holds the property
	 * @param featureName
	 *        the name of the feature to modify
	 */
	public ReferenceStereotypeModelHandler(String stereotypeName, String featureName) {
		super(stereotypeName, featureName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setValueForElement(org.eclipse.uml2.uml.Element elementToEdit, org.eclipse.uml2.uml.Stereotype stereotype, Object newValue) {

		if(newValue instanceof EObject || newValue == null) {
			elementToEdit.setValue(stereotype, getFeatureName(), newValue);
		} else if(newValue instanceof EList<?>) {
			elementToEdit.setValue(stereotype, getFeatureName(), newValue);
		} else {
			Activator.log.error("impossible to set the new value", null);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getId() {
		return ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IUndoableOperation> getCreateValueOperations(List<? extends EObject> objectsToEdit, Composite parent) {
		// TODO Auto-generated method stub
		return null;
	}
}
