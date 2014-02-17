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


/**
 * Interface implemented by all {@link ICreationElementValidator} configured by {@link ActionConfiguration}
 */
public interface IActionCreationElementValidator<T extends ActionConfiguration> extends ICreationElementValidator {
	
	
	/**
	 * Initialize the validator with the given action configuration
	 */
	void init(T configuration);
}
