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
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.emf.type.core.EditHelperContext;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;

/**
 * Request to edit values of an object, after a dialog is opened to ask for the
 * values to set
 */
public class DynamicConfigureRequest extends AbstractEditCommandRequest {

	/** list of properties to define */
	protected List<String> propertiesToDefine;

	/** eobject to edit */
	protected EObject elementToEdit;

	/**
	 * Constructor.
	 * 
	 * @param objectToEdit
	 *        the object that will be modified
	 * @param propertiesToDefine
	 *        the list of properties to define, using their name
	 */
	protected DynamicConfigureRequest(EObject objectToEdit, List<String> propertiesToDefine) {
		super(TransactionUtil.getEditingDomain(objectToEdit));
		this.elementToEdit = objectToEdit;
		this.propertiesToDefine = propertiesToDefine;
	}

	/**
	 * @{inheritDoc
	 */
	public Object getEditHelperContext() {
		IClientContext context = getClientContext();

		if(context == null) {
			return elementToEdit;
		} else {
			return new EditHelperContext(elementToEdit, context);
		}
	}

	/**
	 * Gets the owner of the structural feature.
	 * 
	 * @return the owner of the structural feature
	 */
	public EObject getElementToEdit() {
		return elementToEdit;
	}

	/**
	 * Returns the list of properties to define, identified by their name
	 * 
	 * @return the list of properties to define
	 */
	public List<String> getPropertiesToDefine() {
		return propertiesToDefine;
	}

}
