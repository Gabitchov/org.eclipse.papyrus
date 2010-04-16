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
package org.eclipse.papyrus.properties.runtime.controller.descriptor;

import org.eclipse.papyrus.properties.runtime.propertyeditor.PropertyEditorService;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * Factory that creates the configuration for the EMFTPropertyEditorController.
 */
public class EMFTPropertyEditorControllerDescriptorFactory implements IPropertyEditorControllerDescriptorFactory {


	/**
	 * Creates a new EMFTPropertyEditorControllerDescriptorFactory.
	 */
	public EMFTPropertyEditorControllerDescriptorFactory() {
	}

	/**
	 * @{inheritDoc
	 */
	public EMFTPropertyEditorControllerDescriptor createDescriptor(Node controllerNode) {
		// parse content of the node

		String controllerID = "";
		boolean multiSelection = true;
		String handlerID = "";

		NamedNodeMap attributes = controllerNode.getAttributes();
		for(int i = 0; i < attributes.getLength(); i++) {
			Node attribute = attributes.item(i);

			if("id".equals(attribute.getNodeName())) {
				controllerID = attribute.getNodeValue();
			}
		}

		String featureName = null;
		IPropertyEditorDescriptor editorDescriptor = null;
		NodeList children = controllerNode.getChildNodes();
		for(int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if("feature".equals(child.getNodeName())) {
				// retrieve feature name, handler Id, etc.
				NamedNodeMap featureAttributes = child.getAttributes();
				if(featureAttributes != null) {
					Node featureNameNode = featureAttributes.getNamedItem("name");
					if(featureNameNode != null) {
						featureName = featureNameNode.getNodeValue();
					}

					// retrieve handler id
					Node handlerIDNameNode = featureAttributes.getNamedItem("handlerID");
					if(handlerIDNameNode != null) {
						handlerID = handlerIDNameNode.getNodeValue();
					}
				}
			} else if("editor".equals(child.getNodeName())) {
				// retrieve editor id
				if(child.hasAttributes()) {
					Node editorIDNode = child.getAttributes().getNamedItem("id");
					editorDescriptor = PropertyEditorService.getInstance().createPropertyEditorDescriptor(editorIDNode.getNodeValue(), child);
				}

			}
		}

		assert (handlerID != null && !"".equals(handlerID)) : "impossible to find handler Id for controller " + controllerID;
		assert (featureName != null && !"".equals(featureName)) : "impossible to find feature name for controller " + controllerID;
		assert (editorDescriptor != null) : "impossible to create editor descriptor";

		return new EMFTPropertyEditorControllerDescriptor(controllerID, multiSelection, featureName, handlerID, editorDescriptor);
	}
}
