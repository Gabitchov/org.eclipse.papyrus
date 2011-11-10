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

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.swt.SWT;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Factory for multiple primitive typed property editor descriptors
 */
public class MultiplePrimitiveTypedPropertyEditorDescriptorFactory implements IPropertyEditorDescriptorFactory {

	/**
	 * {@inheritDoc}
	 */
	public IPropertyEditorDescriptor createEditorDescriptor(Node editorNode) {
		String identifier = "";
		String label = "";
		String tooltipText = "";
		int labelPosition = SWT.LEFT;
		ImageDescriptor imageDescriptor = null;

		// retrieve id, label, label position and tooltipText
		NamedNodeMap attributes = editorNode.getAttributes();
		if(attributes != null) {
			for(int i = 0; i < attributes.getLength(); i++) {
				Node attribute = attributes.item(i);
				String nodeName = attribute.getNodeName();
				if("label".equals(nodeName)) {
					label = attribute.getNodeValue();
				} else if("labelPosition".equals(nodeName)) {
					labelPosition = Integer.parseInt(attribute.getNodeValue());
				} else if("id".equals(nodeName)) {
					identifier = attribute.getNodeValue();
				} else if("tooltip".equals(nodeName)) {
					tooltipText = attribute.getNodeValue();
				}
			}
		}

		// retrieve icon
		NodeList children = editorNode.getChildNodes();
		for(int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if("icon".equals(child.getNodeName())) {
				NamedNodeMap iconAttributes = child.getAttributes();
				if(iconAttributes != null) {
					// retrieve plugin id and path
					Node pluginIDNode = iconAttributes.getNamedItem("pluginID");
					Node pathNode = iconAttributes.getNamedItem("path");
					if(pluginIDNode != null && pathNode != null) {
						imageDescriptor = Activator.imageDescriptorFromPlugin(pluginIDNode.getNodeValue(), pathNode.getNodeValue());
					}
				}
			}
		}

		return new MultiplePrimitiveTypedPropertyEditorDescriptor(identifier, label, labelPosition, tooltipText, imageDescriptor);
	}

}
