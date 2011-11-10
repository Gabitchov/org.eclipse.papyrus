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

import org.osgi.framework.Bundle;
import org.w3c.dom.Node;


/**
 * factory for {@link IPropertyEditorControllerDescriptor}
 */
public interface IPropertyEditorControllerDescriptorFactory {

	/**
	 * Creates the descriptor for the given configuration
	 * 
	 * @param controllerNode
	 *        the configuration node
	 * @param bundle
	 *        the bundle used to load classes for the created controller
	 * @return a configured {@link IPropertyEditorControllerDescriptor}
	 */
	IPropertyEditorControllerDescriptor createDescriptor(Node controllerNode, Bundle bundle);
}
