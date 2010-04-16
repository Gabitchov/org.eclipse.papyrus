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
package org.eclipse.papyrus.properties.runtime.controller;

import java.util.List;

import org.eclipse.emf.ecore.EObject;


/**
 * Property editor controller for EMF-based models
 */
public abstract class EMFPropertyEditorController extends PropertyEditorController {

	/**
	 * Constructor.
	 * 
	 * @param objectToEdit
	 *        the {@link EObject} to edit
	 * @param parent
	 *        the parent composite for all created controls by the property editor
	 */
	public EMFPropertyEditorController() {
	}

	/**
	 * @{inheritDoc
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected List<EObject> getObjectsToEdit() {
		return (List<EObject>)super.getObjectsToEdit();
	}

}
