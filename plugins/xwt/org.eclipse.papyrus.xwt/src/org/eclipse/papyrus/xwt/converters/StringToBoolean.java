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
import org.eclipse.papyrus.xwt.XWTException;

/**
 * String to Boolean converter
 * 
 * @author yyang
 */
public class StringToBoolean implements IConverter {

	public static StringToBoolean instance = new StringToBoolean();

	public Object convert(Object fromObject) {
		String str = (String)fromObject;
		if(str == null || "".equalsIgnoreCase(str)) {
			return false;
		} else if("true".equalsIgnoreCase(str)) {
			return true;
		} else if("false".equalsIgnoreCase(str)) {
			return false;
		}
		throw new XWTException(str + " is not a boolean");
	}

	public Object getFromType() {
		return String.class;
	}

	public Object getToType() {
		return Boolean.class;
	}
}
