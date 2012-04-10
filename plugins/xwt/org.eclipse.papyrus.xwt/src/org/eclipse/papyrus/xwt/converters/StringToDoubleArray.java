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

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.papyrus.xwt.XWTException;

/**
 * String to double[] converter
 * 
 * @author jliu
 */
public class StringToDoubleArray implements IConverter {

	public static StringToDoubleArray instance = new StringToDoubleArray();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.conversion.IConverter#convert(java.lang. Object)
	 */
	public Object convert(Object fromObject) {
		String source = (String)fromObject;
		List<Double> result = new ArrayList<Double>();
		StringTokenizer stk = new StringTokenizer(source, ", \t\n\r\f");
		while(stk.hasMoreTokens()) {
			String nextToken = stk.nextToken();
			try {
				result.add(Double.parseDouble(nextToken.trim()));
			} catch (NumberFormatException e) {
				throw new XWTException(source + " is not integer array");
			}
		}
		double[] intArray = new double[result.size()];
		for(int i = 0; i < result.size(); i++) {
			intArray[i] = result.get(i);
		}
		return intArray;
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
		return double[].class;
	}

}
