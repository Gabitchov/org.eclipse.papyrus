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

import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.modelhandler.ModelHandlerService;
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
public class EMFTPropertyEditorControllerDescriptorFactory implements IPropertyEditorControllerDescriptorFactory {


	/**
	 * Creates a new EMFTPropertyEditorControllerDescriptorFactory.
	 */
	public EMFTPropertyEditorControllerDescriptorFactory() {
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

		String featureName = null;
		IEMFModelHandler modelHandler = null;
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
					if(editorDescriptor == null) {
						Activator.log.error("impossible to create editor descriptor", null);
					}
				}

			} else if("constraints".equals(child.getNodeName())) {
				constraints = ConstraintParser.parseConstraints(child, bundle);
			}
		}

		assert (modelHandler != null) : "impossible to find handler for controller " + controllerID;
		assert (featureName != null && !"".equals(featureName)) : "impossible to find feature name for controller " + controllerID;
		assert (constraints != null) : "Impossible to parse constraints";

		return new EMFTPropertyEditorControllerDescriptor(controllerID, multiSelection, featureName, modelHandler, editorDescriptor, constraints);
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

		Object modelHandler = ModelHandlerService.getInstance().createModelHandler(handlerID, node);
		return (modelHandler instanceof IEMFModelHandler) ? (IEMFModelHandler)modelHandler : null;
	}

}
