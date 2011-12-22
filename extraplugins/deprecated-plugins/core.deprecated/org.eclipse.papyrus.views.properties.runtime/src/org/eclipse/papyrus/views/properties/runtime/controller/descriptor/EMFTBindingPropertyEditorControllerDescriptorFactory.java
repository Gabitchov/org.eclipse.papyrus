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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.IEMFModelHandler;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.PropertyEditorService;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.ConstraintParser;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.osgi.framework.Bundle;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * Factory that creates the configuration for the EMFTPropertyEditorController.
 */
public class EMFTBindingPropertyEditorControllerDescriptorFactory extends EMFTPropertyEditorControllerDescriptorFactory {

	/** message to bind */
	private String message;

	/** name of the features */
	private List<String> featuresName = new ArrayList<String>();

	/**
	 * Creates a new EMFTPropertyEditorControllerDescriptorFactory.
	 */
	public EMFTBindingPropertyEditorControllerDescriptorFactory() {
	}

	/**
	 * {@inheritDoc}
	 */
	public EMFTPropertyEditorControllerDescriptor createDescriptor(Node controllerNode, Bundle bundle) {
		// parse content of the node

		String controllerID = "";
		boolean multiSelection = true;

		NamedNodeMap attributes = controllerNode.getAttributes();
		for(int i = 0; i < attributes.getLength(); i++) {
			Node attribute = attributes.item(i);

			if("id".equals(attribute.getNodeName())) {
				controllerID = attribute.getNodeValue();
			}
		}

		IEMFModelHandler modelHandler = null;
		String featureName = null;
		IPropertyEditorDescriptor editorDescriptor = null;
		List<IConstraintDescriptor> constraints = null;
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

					modelHandler = parseModelHandler(child);
				}
			} else if("editor".equals(child.getNodeName())) {
				// retrieve editor id
				if(child.hasAttributes()) {
					Node editorIDNode = child.getAttributes().getNamedItem("id");
					editorDescriptor = PropertyEditorService.getInstance().createPropertyEditorDescriptor(editorIDNode.getNodeValue(), child);
				}
			} else if("binding".equals(child.getNodeName())) {
				if(child.hasAttributes()) {
					Node messageNode = child.getAttributes().getNamedItem("message");
					message = messageNode.getNodeValue();
				}
				NodeList features = child.getChildNodes();
				for(int j = 0; j < features.getLength(); j++) {
					Node featureNode = features.item(j);
					if("feature".equals(featureNode.getNodeName())) {
						if(featureNode.hasAttributes()) {
							featuresName.add(featureNode.getAttributes().getNamedItem("name").getNodeValue());
						}
					}
				}
			} else if("constraints".equals(child.getNodeName())) {
				constraints = ConstraintParser.parseConstraints(child, bundle);
			}
		}

		assert (modelHandler != null) : "impossible to find handler for controller " + controllerID;
		assert (featureName != null && !"".equals(featureName)) : "impossible to find feature name for controller " + controllerID;
		assert (editorDescriptor != null) : "impossible to create editor descriptor";
		assert (constraints != null) : "Impossible to parse constraints";

		return new EMFTBindingPropertyEditorControllerDescriptor(controllerID, multiSelection, featureName, modelHandler, editorDescriptor, constraints, message, featuresName.toArray(new String[]{}));
	}
}
