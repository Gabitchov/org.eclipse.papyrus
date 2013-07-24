/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.tools.converter;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;


/**
 * 
 * This class allows to store the value created for a pasted String AND a result status associated to this pasted String
 * 
 * @param <T>
 */

public class ConvertedValueContainer<T> {

	/**
	 * this field is used when the pasted value is monovalued
	 */
	private final T value;

	/**
	 * the resulting status of the parsing
	 */
	private final IStatus status;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param realValue
	 *        a monovalued Value (can be <code>null</code>)
	 * @param realListValue
	 *        a collection value (can be <code>null</code>)
	 * @param status
	 *        a status (can be <code>null</code>)
	 */
	public ConvertedValueContainer(final T realValue, final IStatus status) {
		this.value = realValue;
		this.status = status;
		Assert.isNotNull(status);
	}


	/**
	 * 
	 * @return
	 *         the status of the conversion
	 */
	public final IStatus getStatus() {
		return this.status;
	}

	/**
	 * 
	 * @return
	 *         the value
	 */
	public final T getConvertedValue() {
		return this.value;
	}

}
