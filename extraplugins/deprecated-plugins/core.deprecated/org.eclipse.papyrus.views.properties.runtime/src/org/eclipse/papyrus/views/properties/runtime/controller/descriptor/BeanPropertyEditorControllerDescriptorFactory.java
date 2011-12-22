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
 * Factory for Property editor controllers based on java.beans properties
 */
public class BeanPropertyEditorControllerDescriptorFactory implements IPropertyEditorControllerDescriptorFactory {

	/**
	 * {@inheritDoc}
	 */
	public IPropertyEditorControllerDescriptor createDescriptor(Node controllerNode, Bundle bundle) {
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

		String propertyName = null;
		IEMFModelHandler modelHandler = null;
		IPropertyEditorDescriptor editorDescriptor = null;
		List<IConstraintDescriptor> constraints = null;
		NodeList children = controllerNode.getChildNodes();
		for(int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if("property".equals(child.getNodeName())) {
				// retrieve feature name, handler Id, etc.
				NamedNodeMap featureAttributes = child.getAttributes();
				if(featureAttributes != null) {
					Node featureNameNode = featureAttributes.getNamedItem("name");
					if(featureNameNode != null) {
						propertyName = featureNameNode.getNodeValue();
					}

					// modelHandler = parseModelHandler(child);
				}
			} else if("editor".equals(child.getNodeName())) {
				// retrieve editor id
				if(child.hasAttributes()) {
					Node editorIDNode = child.getAttributes().getNamedItem("id");
					editorDescriptor = PropertyEditorService.getInstance().createPropertyEditorDescriptor(editorIDNode.getNodeValue(), child);
				}
			} else if("constraints".equals(child.getNodeName())) {
				constraints = ConstraintParser.parseConstraints(child, bundle);
			}
		}

		assert (modelHandler != null) : "impossible to find handler for controller " + controllerID;
		assert (propertyName != null && !"".equals(propertyName)) : "impossible to find feature name for controller " + controllerID;
		assert (editorDescriptor != null) : "impossible to create editor descriptor";
		assert (constraints != null) : "Impossible to parse constraints";

		return new BeanPropertyEditorControllerDescriptor(controllerID, multiSelection, propertyName, editorDescriptor, constraints);
	}


}
