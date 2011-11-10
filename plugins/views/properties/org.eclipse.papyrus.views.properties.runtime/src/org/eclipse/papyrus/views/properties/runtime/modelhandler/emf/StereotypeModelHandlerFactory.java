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
package org.eclipse.papyrus.views.properties.runtime.modelhandler.emf;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;


/**
 * Factory to manipulate stereotype features
 */
public abstract class StereotypeModelHandlerFactory extends EMFModelHandlerFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract IEMFModelHandler createModelHandler(Node modelHandlerNode);

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
}
