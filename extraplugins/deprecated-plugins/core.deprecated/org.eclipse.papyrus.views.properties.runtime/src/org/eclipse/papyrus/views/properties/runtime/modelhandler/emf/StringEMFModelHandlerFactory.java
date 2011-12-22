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

import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.modelhandler.IPropertyModelHandlerFactory;
import org.w3c.dom.Node;


/**
 * Factory that creates {@link StringEMFModelHandler}.
 */
public class StringEMFModelHandlerFactory extends EMFModelHandlerFactory implements IPropertyModelHandlerFactory {

	/**
	 * Creates a new StringEMFModelHandlerFactory.
	 */
	public StringEMFModelHandlerFactory() {
	}

	/**
	 * {@inheritDoc}
	 */
	public StringEMFModelHandler createModelHandler(Node modelHandlerNode) {
		// specific code to parse the given element
		String featureName = retrieveFeatureName(modelHandlerNode);

		if(featureName == null) {
			Activator.log.warn("Impossible to retrieve feature from node " + modelHandlerNode);
			return null;
		}

		return new StringEMFModelHandler(featureName);
	}

}
