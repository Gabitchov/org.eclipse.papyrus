/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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

import org.eclipse.ui.services.IDisposable;

/**
 * Common interface for string converter
 * 
 * @author VL222926
 * 
 */
public interface IStringValueConverter extends IDisposable {

	/**
	 * 
	 * @param type
	 *        an object representing the type of the in which we want to convert the string
	 * @param valueAsString
	 *        the value represented by a string
	 * @return
	 *         a {@link ConvertedValueContainer}
	 */
	public ConvertedValueContainer<?> deduceValueFromString(final Object type, final String valueAsString);
}
