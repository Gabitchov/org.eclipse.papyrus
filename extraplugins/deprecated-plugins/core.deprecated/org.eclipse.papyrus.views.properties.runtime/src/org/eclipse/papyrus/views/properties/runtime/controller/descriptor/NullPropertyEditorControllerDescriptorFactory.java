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

import org.eclipse.papyrus.views.properties.runtime.controller.NullPropertyEditorController;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.PropertyEditorService;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.osgi.framework.Bundle;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * Factory for {@link NullPropertyEditorController}.
 */
public class NullPropertyEditorControllerDescriptorFactory implements IPropertyEditorControllerDescriptorFactory {

	/**
	 * {@inheritDoc}
	 */
	public IPropertyEditorControllerDescriptor createDescriptor(Node controllerNode, Bundle bundle) {
		// parse content of the node

		IPropertyEditorDescriptor editorDescriptor = null;
		NodeList children = controllerNode.getChildNodes();
		for(int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if("editor".equals(child.getNodeName())) {
				// retrieve editor id
				if(child.hasAttributes()) {
					Node editorIDNode = child.getAttributes().getNamedItem("id");
					editorDescriptor = PropertyEditorService.getInstance().createPropertyEditorDescriptor(editorIDNode.getNodeValue(), child);
				}

			}
		}

		assert (editorDescriptor != null) : "impossible to create editor descriptor";

		return new NullPropertyEditorControllerDescriptor(editorDescriptor);
	}

}
