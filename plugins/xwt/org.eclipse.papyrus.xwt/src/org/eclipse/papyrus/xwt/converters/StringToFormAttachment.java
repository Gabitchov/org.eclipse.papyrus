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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.swt.layout.FormAttachment;

/**
 * This converter can easily convert string value to FormAttachment object in these format:
 * <nl>
 * <li><FormData top="0"></li> would be parsed to FormAttachment(0).
 * <li><FormData top="0,20"></li> would be parsed to FormAttachment(0, 20).
 * <li><FormData top="0,100,20"></li> would be parsed to FormAttachment(0, 100, 20).
 * <nl>
 * This converter can not parse some arguments which have Control type.
 * 
 * @author jliu (jin.liu@soyatec.com)
 */
public class StringToFormAttachment implements IConverter {

	public static IConverter instance = new StringToFormAttachment();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.conversion.IConverter#convert(java.lang.Object)
	 */
	public Object convert(Object fromObject) {
		if(fromObject == null) {
			return null;
		}
		String strValue = fromObject.toString();
		int numerator = 0, denominator = 100, offset = 0;
		List<Integer> intValues = new ArrayList<Integer>();
		String[] split = strValue.split(",");
		for(int i = 0; i < split.length; i++) {
			String trim = split[i].trim();
			try {
				int value = Integer.parseInt(trim);
				intValues.add(value);
			} catch (NumberFormatException e) {
			}
		}
		FormAttachment result = new FormAttachment();
		int size = intValues.size();
		try {
			numerator = intValues.get(0);
			if(size == 2) {
				offset = intValues.get(1);
			} else if(size == 3) {
				denominator = intValues.get(1);
				offset = intValues.get(2);
			}
		} catch (Exception e) {
		}
		result.denominator = denominator;
		result.numerator = numerator;
		result.offset = offset;
		return result;
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
		return FormAttachment.class;
	}

}
