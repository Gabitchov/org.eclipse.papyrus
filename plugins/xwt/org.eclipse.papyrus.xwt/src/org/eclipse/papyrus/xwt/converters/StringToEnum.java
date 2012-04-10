/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.       *
 * All rights reserved. This program and the accompanying materials            *
 * are made available under the terms of the Eclipse Public License v1.0       *
 * which accompanies this distribution, and is available at                    *
 * http://www.eclipse.org/legal/epl-v10.html                                   *  
 * Contributors:                                                               *  
 *     Soyatec - initial API and implementation                                * 
 *******************************************************************************/
package org.eclipse.papyrus.xwt.converters;

import org.eclipse.core.databinding.conversion.IConverter;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class StringToEnum implements IConverter {

	private Class<?> toType;

	public StringToEnum(Class<?> toType) {
		this.toType = toType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.conversion.IConverter#convert(java.lang.Object)
	 */
	public Object convert(Object fromObject) {
		if(fromObject == null || "".equals(fromObject)) {
			Class<?> type = (Class<?>)getToType();
			Object[] values = type.getEnumConstants();
			if(values != null && values.length > 0) {
				return values[0];
			}
		}

		return Enum.valueOf((Class)getToType(), (String)fromObject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.conversion.IConverter#getFromType()
	 */
	public Object getFromType() {
		return String.class;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.conversion.IConverter#getToType()
	 */
	public Object getToType() {
		return toType;
	}

	public void setToType(Class<?> toType) {
		this.toType = toType;
	}

}
