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
package org.eclipse.papyrus.uml.table.common.utils;

import java.util.Collection;

import org.eclipse.core.runtime.IStatus;

/**
 * 
 * This class allows to store the value created for a pasted String AND a result status associated to this pasted String
 * 
 * @param <T>
 */
public class MultiValueContainer<T> extends ValueContainer<Collection<T>>{



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
	public MultiValueContainer(final Collection<T> realValue, final IStatus status) {
		super(realValue, status);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param realValue
	 *        the value (can be <code>null</code>)
	 */
	public MultiValueContainer(final Collection<T> realValue) {
		this(realValue, null);
	}


}
