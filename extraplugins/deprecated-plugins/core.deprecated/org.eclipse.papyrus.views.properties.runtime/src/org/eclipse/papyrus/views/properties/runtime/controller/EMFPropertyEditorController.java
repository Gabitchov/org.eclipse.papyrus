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
package org.eclipse.papyrus.views.properties.runtime.controller;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;


/**
 * Property editor controller for EMF-based models
 */
public abstract class EMFPropertyEditorController extends PropertyEditorController implements Adapter {

	/**
	 * Creates a new EMFPropertyEditorController.
	 */
	public EMFPropertyEditorController() {
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<? extends EObject> getObjectsToEdit() {
		return (List<? extends EObject>)super.getObjectsToEdit();
	}

}
