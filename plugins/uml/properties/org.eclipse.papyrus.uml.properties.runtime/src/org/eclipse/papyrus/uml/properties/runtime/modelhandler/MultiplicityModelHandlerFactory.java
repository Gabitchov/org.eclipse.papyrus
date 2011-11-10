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
package org.eclipse.papyrus.uml.properties.runtime.modelhandler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.EMFModelHandlerFactory;
import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.IEMFModelHandler;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * factory for Multiplicity model handlers
 */
public class MultiplicityModelHandlerFactory extends EMFModelHandlerFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IEMFModelHandler createModelHandler(Node modelHandlerNode) {
		List<String> availableValues = new ArrayList<String>();

		// parses proposed values by this model handler
		NodeList availableValueNodes = modelHandlerNode.getChildNodes();
		for(int i = 0; i < availableValueNodes.getLength(); i++) {
			Node availableValueNode = availableValueNodes.item(i);
			String availableValueNodeName = availableValueNode.getNodeName();
			if("availableValue".equals(availableValueNodeName)) {
				// this is an available value node, store the given value to display
				NamedNodeMap attributes = availableValueNode.getAttributes();
				if(attributes != null) {
					Node valueNode = attributes.getNamedItem("value");
					if(valueNode != null) {
						availableValues.add(valueNode.getNodeValue());
					}
				}
			}
		}

		return new MultiplicityModelHandler(availableValues);
	}

}
