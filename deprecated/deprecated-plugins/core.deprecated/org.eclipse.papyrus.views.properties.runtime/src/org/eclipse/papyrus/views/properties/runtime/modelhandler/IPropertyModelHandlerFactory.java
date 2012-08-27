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
package org.eclipse.papyrus.views.properties.runtime.modelhandler;

import org.w3c.dom.Node;

/**
 * Interface implemented by all model handler factories
 */
public interface IPropertyModelHandlerFactory {

	/**
	 * Creates an instance of the model handler, given the configuration node
	 * 
	 * @param modelHandlerNode
	 *        the configuration node for the instance of the model handler to create
	 * @return the created model handler
	 */
	Object createModelHandler(Node modelHandlerNode);
}
