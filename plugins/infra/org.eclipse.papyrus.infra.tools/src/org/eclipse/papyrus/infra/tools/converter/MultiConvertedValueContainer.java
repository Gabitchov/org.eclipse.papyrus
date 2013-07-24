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

import java.util.Collection;

import org.eclipse.core.runtime.IStatus;

/**
 * 
 * This class allows to store the value created for a pasted String AND a result status associated to this pasted String
 * 
 * @param <T>
 */
public class MultiConvertedValueContainer<T> extends ConvertedValueContainer<Collection<T>> {


	/**
	 * 
	 * Constructor.
	 * 
	 * @param realValue
	 * @param status
	 */
	public MultiConvertedValueContainer(final Collection<T> realValue, final IStatus status) {
		super(realValue, status);
	}
}
