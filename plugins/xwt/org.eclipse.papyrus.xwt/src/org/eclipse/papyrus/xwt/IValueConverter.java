/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt;

import org.eclipse.core.databinding.conversion.IConverter;

/**
 * For a data binding, the conversion could be bidirectional. The standard IConverter is not enough. This class is designed to meet this requirement.
 * 
 * @author yyang
 * 
 */
public interface IValueConverter extends IConverter {

	Object convertBack(Object value);
}
