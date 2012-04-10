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
package org.eclipse.papyrus.xwt.converters;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.papyrus.xwt.IValueConverter;
import org.eclipse.papyrus.xwt.XWT;

/**
 * The operation to inverse the converter direction.
 * 
 * @author yyang
 * 
 */
public class ValueConverterAdapter implements IValueConverter {

	private IConverter fromConvertor;

	private IConverter toConvertor;

	public ValueConverterAdapter(IConverter fromConvertor, IConverter toConvertor) {
		this.fromConvertor = fromConvertor;
		this.toConvertor = toConvertor;
	}

	public Object convertBack(Object value) {
		return toConvertor.convert(value);
	}

	public Object convert(Object fromObject) {
		return fromConvertor.convert(fromObject);
	}

	public Object getFromType() {
		return fromConvertor.getFromType();
	}

	public Object getToType() {
		return toConvertor.getFromType();
	}

	public static ValueConverterAdapter create(Class<?> sourceType, Class<?> targetType) {
		IConverter fromConvertor = XWT.findConvertor(sourceType, targetType);
		if(fromConvertor == null) {
			return null;
		}
		IConverter toConvertor = XWT.findConvertor(targetType, sourceType);
		if(toConvertor == null) {
			return null;
		}
		return new ValueConverterAdapter(fromConvertor, toConvertor);
	}
}
