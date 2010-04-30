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
package org.eclipse.papyrus.properties.runtime.dialogs;

import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.papyrus.properties.runtime.view.DialogDescriptor;
import org.eclipse.papyrus.properties.runtime.view.IPropertyViewOperation;
import org.eclipse.papyrus.properties.runtime.view.IPropertyViewProvider;


/**
 * Operation that retrieves a Dialog descriptor
 */
public class GetDialogDescriptorOperation implements IPropertyViewOperation {

	/** id of the dialog descriptor to retrieve */
	protected final String descriptorID;

	/**
	 * Creates a new GetDialogDescriptorOperation.
	 */
	public GetDialogDescriptorOperation(String descriptorID) {
		this.descriptorID = descriptorID;
	}

	/**
	 * Returns the descriptor id for this operation
	 * 
	 * @return the descriptor id for this operation
	 */
	public String getDescriptorID() {
		return descriptorID;
	}

	/**
	 * {@inheritDoc}
	 */
	public DialogDescriptor execute(IProvider provider) {
		System.err.println(provider);
		if(provider instanceof IPropertyViewProvider) {
			return ((IPropertyViewProvider)provider).getDialogDescriptor(descriptorID);
		}
		return null;
	}

}
