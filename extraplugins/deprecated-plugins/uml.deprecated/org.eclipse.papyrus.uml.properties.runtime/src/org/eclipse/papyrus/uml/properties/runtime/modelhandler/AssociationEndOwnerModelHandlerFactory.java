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

import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.EMFModelHandlerFactory;
import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.IEMFModelHandler;
import org.w3c.dom.Node;


/**
 * factory for Multiplicity model handlers
 */
public class AssociationEndOwnerModelHandlerFactory extends EMFModelHandlerFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IEMFModelHandler createModelHandler(Node modelHandlerNode) {
		return new AssociationEndOwnerModelHandler();
	}

}
