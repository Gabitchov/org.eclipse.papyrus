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
package org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor;

import org.w3c.dom.Node;

/**
 * factory for property editor descriptors
 */
public interface IPropertyEditorDescriptorFactory {

	/**
	 * Creates the descriptor for an editor, given its configuration node
	 * 
	 * @param editorNode
	 *        the configuration node
	 * @return the descriptor for the editor
	 */
	public IPropertyEditorDescriptor createEditorDescriptor(Node editorNode);
}
