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

/**
 * Default implementation of MultiValueConverter from a string
 * 
 * @author yyang <yesc.yang@soyatec.com>
 * 
 */
public class StringMultiValueConerter extends AbstractMultiValueConverter {

	private String separatorExpression = null;

	public Object[] convertBack(Object value) {
		if(value instanceof Object[]) {
			return (Object[])value;
		}
		String valueString = value.toString();
		return valueString.split(getSeparatorExpression());
	}

	public String getSeparatorExpression() {
		if(separatorExpression == null) {
			return "[ \t\r\n]+";
		}
		return separatorExpression;
	}

	public void setSeparatorExpression(String separatorExpression) {
		this.separatorExpression = separatorExpression;
	}

	protected String getSeparator() {
		if(separatorExpression == null || separatorExpression.length() == 0) {
			return " ";
		}
		return "" + separatorExpression.charAt(0);
	}

	public Object convert(Object[] value) {
		StringBuffer buffer = new StringBuffer();
		String separator = getSeparator();
		for(int i = 0; i < value.length; i++) {
			if(i != 0) {
				buffer.append(separator);
			}
			buffer.append(value[i]);
		}
		return buffer.toString();
	}

	public Object getFromType() {
		return String[].class;
	}

	public Object getToType() {
		return String.class;
	}
}
