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
package org.eclipse.papyrus.infra.queries.core.converter;

import org.eclipse.uml2.uml.ValueSpecification;


/**
 * Exception thrown when no converter was found
 */
public class ConverterNotfoundException extends Exception {

	/** serialization id */
	private static final long serialVersionUID = -8863603362830475612L;

	/** target parameter type */
	private final Class<?> parameterType;

	/** source value instance */
	private final ValueSpecification valueInstance;

	/**
	 * Creates a new {@link ConverterNotfoundException}.
	 * 
	 * @param parameterType
	 *        the target type of the value
	 * @param valueInstance
	 *        the value specification defining the entering value and type
	 */
	public ConverterNotfoundException(Class<?> parameterType, ValueSpecification valueInstance) {
		this.parameterType = parameterType;
		this.valueInstance = valueInstance;
	}

	/**
	 * Returns the target parameter type
	 * 
	 * @return the target parameter type
	 */
	public Class<?> getParameterType() {
		return parameterType;
	}

	/**
	 * Returns the value specification defining the entering value and type
	 * 
	 * @return the value specification defining the entering value and type
	 */
	public ValueSpecification getValueInstance() {
		return valueInstance;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMessage() {
		return "Converter not found for target type: " + getParameterType() + " and for initial value: " + getValueInstance();
	}

}
