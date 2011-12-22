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
package org.eclipse.papyrus.views.properties.runtime.propertyeditor;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.w3c.dom.Node;


/**
 * Operation that creates the descriptor for a given editor
 */
public class CreatePropertyEditorDescriptorOperation implements IOperation {

	/** configuration node for this operation */
	private Node editorNode;

	/** editor unique identifier */
	private String editorID;

	/**
	 * Creates a new CreatePropertyEditorDescriptorOperation.
	 * 
	 * @param editorID
	 *        the id of the editor to create
	 * @param editorNode
	 *        the configuration node for this editor descriptor
	 */
	public CreatePropertyEditorDescriptorOperation(String editorID, Node editorNode) {
		this.editorNode = editorNode;
		this.editorID = editorID;
	}

	/**
	 * {@inheritDoc}
	 */
	public IPropertyEditorDescriptor execute(IProvider provider) {
		if(provider instanceof PropertyEditorProvider) {
			return ((PropertyEditorProvider)provider).createPropertyEditorDescriptor(editorID, editorNode);
		}

		return null;
	}

	/**
	 * Returns the editor identifier
	 * 
	 * @return the editor identifier
	 */
	public String getEditorId() {
		return editorID;
	}

}
