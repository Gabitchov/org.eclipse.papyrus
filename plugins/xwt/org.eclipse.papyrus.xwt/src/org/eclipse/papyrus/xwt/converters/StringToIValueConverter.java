/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.       *
 * All rights reserved. This program and the accompanying materials            *
 * are made available under the terms of the Eclipse Public License v1.0       *
 * which accompanies this distribution, and is available at                    *
 * http://www.eclipse.org/legal/epl-v10.html                                   *
 *                                                                             *  
 * Contributors:                                                               *        
 *     Soyatec - initial API and implementation                                *
 *******************************************************************************/
package org.eclipse.papyrus.xwt.converters;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.papyrus.xwt.IValueConverter;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.XWTException;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class StringToIValueConverter implements IConverter {

	public static StringToIValueConverter instance = new StringToIValueConverter();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.conversion.IConverter#convert(java.lang.Object)
	 */
	public Object convert(Object fromObject) {
		try {
			Class<?> type = XWT.getLoadingContext().loadClass(fromObject.toString());
			if(type == null) {
				throw new XWTException("Class " + fromObject.toString() + " is not found.");
			}
			return type.newInstance();
		} catch (Exception e) {
			throw new XWTException(e);
		}
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
		return IValueConverter.class;
	}
}
