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

import java.util.List;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;


/**
 * {@link ICreationElementValidator} composed by several validators
 */
public class ComposedElementCreationValidator implements ICreationElementValidator {

	
	private final List<ICreationElementValidator> composedValidators;

	/**
	 * Default Constructor
	 * @param composedValidators the list of composed validators
	 */
	public ComposedElementCreationValidator(List<ICreationElementValidator> composedValidators) {
		this.composedValidators = composedValidators;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean canCreate(CreateElementRequest request) {
		for(ICreationElementValidator validator : getComposedValidators()) {
			if(!validator.canCreate(request)) {
				return false;
			}
		}
		// all validators were OK => element can be created
		return true;
	}

	/**
	 * Returns the list of composed validators
	 * @return the list of composed validators
	 */
	protected List<ICreationElementValidator> getComposedValidators() {
		return composedValidators;
	}
}
