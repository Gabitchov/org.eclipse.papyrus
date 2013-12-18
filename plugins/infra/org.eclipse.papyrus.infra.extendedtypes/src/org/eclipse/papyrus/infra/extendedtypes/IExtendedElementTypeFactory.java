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

import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;


/**
 * Interface for all factories that will create element types from a given configuration 
 */
public interface IExtendedElementTypeFactory<T extends ElementTypeConfiguration> /* extends IElementTypeFactory */ {
	
	/**
	 * Creates an element type for the given configuration
	 * @param configuration configuration of the element type to create
	 * @return the newly created element type or <code>null</code> if no element type could be created
	 */
	IExtendedHintedElementType createElementType(T configuration);
	
	
	/**
	 * Creates the element creation validator which will be used to know if the element can be created or not 
	 * @param configuration the configuration of the new element type 
	 * @return the element creation Validator or <code>null</code> if none could be created
	 */
	ICreationElementValidator createElementCreationValidator(T configuration);
	
}
