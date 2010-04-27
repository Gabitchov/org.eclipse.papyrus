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

import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.modelhandler.emf.BooleanEMFModelHandler;
import org.eclipse.papyrus.properties.runtime.modelhandler.emf.BooleanStereotypeModelHandler;
import org.eclipse.papyrus.properties.runtime.modelhandler.emf.EnumerationEMFModelHandler;
import org.eclipse.papyrus.properties.runtime.modelhandler.emf.EnumerationStereotypeModelHandler;
import org.eclipse.papyrus.properties.runtime.modelhandler.emf.IEMFModelHandler;
import org.eclipse.papyrus.properties.runtime.modelhandler.emf.ReferenceEMFModelHandler;
import org.eclipse.papyrus.properties.runtime.modelhandler.emf.ReferenceStereotypeModelHandler;
import org.eclipse.papyrus.properties.runtime.modelhandler.emf.StringEMFModelHandler;
import org.eclipse.papyrus.properties.runtime.modelhandler.emf.StringStereotypeModelHandler;
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

		NamedNodeMap attributes = controllerNode.getAttributes();
		for(int i = 0; i < attributes.getLength(); i++) {
			Node attribute = attributes.item(i);

			if("id".equals(attribute.getNodeName())) {
				controllerID = attribute.getNodeValue();
			}
		}

		String featureName = null;
		IEMFModelHandler modelHandler = null;
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

					modelHandler = parseModelHandler(child);
				}
			} else if("editor".equals(child.getNodeName())) {
				// retrieve editor id
				if(child.hasAttributes()) {
					Node editorIDNode = child.getAttributes().getNamedItem("id");
					editorDescriptor = PropertyEditorService.getInstance().createPropertyEditorDescriptor(editorIDNode.getNodeValue(), child);
				}

			}
		}

		assert (modelHandler != null) : "impossible to find handler for controller " + controllerID;
		assert (featureName != null && !"".equals(featureName)) : "impossible to find feature name for controller " + controllerID;
		assert (editorDescriptor != null) : "impossible to create editor descriptor";

		return new EMFTPropertyEditorControllerDescriptor(controllerID, multiSelection, featureName, modelHandler, editorDescriptor);
	}

	/**
	 * Parses the feature node to retrieve the right model handler
	 * 
	 * @param node
	 *        the feature node
	 * @return the model handler created
	 */
	protected IEMFModelHandler parseModelHandler(Node node) {
		String handlerID = null;
		NamedNodeMap featureAttributes = node.getAttributes();
		if(featureAttributes != null) {
			// retrieve handler id
			Node handlerIDNameNode = featureAttributes.getNamedItem("handlerID");
			if(handlerIDNameNode != null) {
				handlerID = handlerIDNameNode.getNodeValue();
			}
		}

		// check found handler id
		if(handlerID == null) {
			Activator.log.error("impossible to find model handler for node " + node, null);
			return null;
		}

		if(handlerID.equals(StringEMFModelHandler.ID)) {
			String featureName = retrieveFeatureName(node);
			return new StringEMFModelHandler(featureName);
		} else if(handlerID.equals(BooleanEMFModelHandler.ID)) {
			String featureName = retrieveFeatureName(node);
			return new BooleanEMFModelHandler(featureName);
		} else if(handlerID.equals(EnumerationEMFModelHandler.ID)) {
			String featureName = retrieveFeatureName(node);
			return new EnumerationEMFModelHandler(featureName);
		} else if(handlerID.equals(ReferenceEMFModelHandler.ID)) {
			String featureName = retrieveFeatureName(node);
			return new ReferenceEMFModelHandler(featureName);
		} else if(handlerID.equals(StringStereotypeModelHandler.ID)) {
			String featureName = retrieveFeatureName(node);
			String stereotypeName = retrieveStereotypeName(node);
			return new StringStereotypeModelHandler(stereotypeName, featureName);
		} else if(handlerID.equals(BooleanStereotypeModelHandler.ID)) {
			String featureName = retrieveFeatureName(node);
			String stereotypeName = retrieveStereotypeName(node);
			return new BooleanStereotypeModelHandler(stereotypeName, featureName);
		} else if(handlerID.equals(EnumerationStereotypeModelHandler.ID)) {
			String featureName = retrieveFeatureName(node);
			String stereotypeName = retrieveStereotypeName(node);
			return new EnumerationStereotypeModelHandler(stereotypeName, featureName);
		} else if(handlerID.equals(ReferenceStereotypeModelHandler.ID)) {
			String featureName = retrieveFeatureName(node);
			String stereotypeName = retrieveStereotypeName(node);
			return new ReferenceStereotypeModelHandler(stereotypeName, featureName);
		}

		Activator.log.error("impossible to find handler with id " + handlerID + " from node " + node, null);
		return null;
	}

	/**
	 * Retrieve the name of the stereotype to modify
	 * 
	 * @param node
	 *        the configuration node
	 * @return the name of the stereotype to modify or <code>null</code>
	 */
	protected String retrieveStereotypeName(Node node) {
		String stereotypeName = null;
		NamedNodeMap attributes = node.getAttributes();
		if(attributes != null) {
			Node stereotypeNameNode = attributes.getNamedItem("stereotypeName");
			if(stereotypeNameNode != null) {
				stereotypeName = stereotypeNameNode.getNodeValue();
			}
		}
		return stereotypeName;
	}

	/**
	 * Retrieve the name of the feature to modify
	 * 
	 * @param node
	 *        the configuration node
	 * @return the name of the feature to modify or <code>null</code>
	 */
	protected String retrieveFeatureName(Node node) {
		String featureName = null;
		NamedNodeMap featureAttributes = node.getAttributes();
		if(featureAttributes != null) {
			Node featureNameNode = featureAttributes.getNamedItem("name");
			if(featureNameNode != null) {
				featureName = featureNameNode.getNodeValue();
			}
		}
		return featureName;
	}
}
