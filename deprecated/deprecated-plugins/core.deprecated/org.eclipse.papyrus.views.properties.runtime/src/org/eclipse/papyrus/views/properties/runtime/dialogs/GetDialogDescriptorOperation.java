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

import java.util.List;

import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.papyrus.views.properties.runtime.view.DialogDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.IPropertyViewOperation;
import org.eclipse.papyrus.views.properties.runtime.view.IPropertyViewProvider;


/**
 * Operation that retrieves a Dialog descriptor
 */
public class GetDialogDescriptorOperation implements IPropertyViewOperation {

	/** id of the dialog descriptor to retrieve */
	private final List<Object> objectstoEdit;

	/**
	 * Creates a new GetDialogDescriptorOperationById.
	 * 
	 * @param objectstoEdit
	 *        list of objects to edit
	 */
	public GetDialogDescriptorOperation(List<Object> objectstoEdit) {
		this.objectstoEdit = objectstoEdit;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<DialogDescriptor> execute(IProvider provider) {
		if(provider instanceof IPropertyViewProvider) {
			return ((IPropertyViewProvider)provider).getDialogDescriptor(getObjectstoEdit());
		}
		return null;
	}

	/**
	 * Returns the list of objects to edit
	 * 
	 * @return the list of objects to edit
	 */
	public List<Object> getObjectstoEdit() {
		return objectstoEdit;
	}

}
