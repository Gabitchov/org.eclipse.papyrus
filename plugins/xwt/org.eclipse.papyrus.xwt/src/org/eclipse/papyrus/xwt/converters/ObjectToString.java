/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.xwt.converters;

import org.eclipse.core.databinding.conversion.IConverter;

/**
 * Safely SWT context values, it used to avoid a NullPointerException when set text values to SWT Widgets.
 * 
 * @author jliu
 */
public class ObjectToString implements IConverter {

	public static ObjectToString FROM_OBJECT = new ObjectToString(Object.class);

	public static ObjectToString FROM_INTEGER = new ObjectToString(Integer.class);

	public static ObjectToString FROM_SHORT = new ObjectToString(Short.class);

	public static ObjectToString FROM_LONG = new ObjectToString(Long.class);

	private Class<?> fromType;

	public ObjectToString(Class<?> fromType) {
		this.fromType = fromType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.conversion.IConverter#convert(java.lang.Object)
	 */
	public Object convert(Object fromObject) {
		if(fromObject == null) {
			return "";
		}
		return fromObject.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.conversion.IConverter#getFromType()
	 */
	public Object getFromType() {
		if(fromType == null) {
			return Object.class;
		}
		return fromType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.conversion.IConverter#getToType()
	 */
	public Object getToType() {
		return String.class;
	}

}
