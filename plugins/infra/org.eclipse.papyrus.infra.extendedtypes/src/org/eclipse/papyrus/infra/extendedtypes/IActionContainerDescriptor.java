/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes;

import org.eclipse.gmf.runtime.emf.type.core.IContainerDescriptor;


/**
 * Descriptor for the configurable container descriptor
 */
public interface IActionContainerDescriptor<T extends ActionConfiguration> extends IContainerDescriptor {
	
	/**
	 * Initializes the container descriptor using the given configuration
	 * @param actionConfiguration the confiugration for this container descriptor
	 */
	void init(T actionConfiguration);
}
