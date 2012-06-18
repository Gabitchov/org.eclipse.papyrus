/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.tools.Activator;

/**
 * A Validator based on the Papyrus EditService
 * Tests whether a given Object is a valid value for a specific
 * feature on an EObject
 * 
 * @author Camille Letavernier
 * 
 */
public class EditServiceValidator {

	private EObject editedEObject;

	private EStructuralFeature editedFeature;

	private IElementEditService editingService;

	/**
	 * Constructor
	 * 
	 * @param editedEObject
	 * @param editedFeature
	 */
	public EditServiceValidator(EObject editedEObject, EStructuralFeature editedFeature) {
		this.editedEObject = editedEObject;
		this.editedFeature = editedFeature;

		if(editedEObject != null) {
			this.editingService = ElementEditServiceUtils.getCommandProvider(editedEObject);
		}

		if(this.editingService == null) {
			// log error service not found...
			Activator.log.warn("Could not create service for " + EMFCoreUtil.getQualifiedName(editedEObject, true));
		}
	}

	/**
	 * Tests whether the given element is a valid value,
	 * i.e. can be used as a value to edit this EObject/Feature pair
	 * 
	 * @param element
	 * @return
	 *         True if the given element is valid
	 */
	public boolean isValidValue(Object element) {
		// Get semantic element
		EObject semanticElement = EMFHelper.getEObject(element);
		if((semanticElement == null) && (element != null)) {
			return false;
		}

		// Test editing command...
		SetRequest req = new SetRequest(editedEObject, editedFeature, semanticElement);
		if((editingService != null) && (editingService.canEdit(req))) {
			return true;
		}

		return false;
	}
}
