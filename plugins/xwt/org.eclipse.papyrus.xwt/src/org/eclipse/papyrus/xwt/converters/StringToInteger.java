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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.conversion.StringToNumberConverter;
import org.eclipse.papyrus.xwt.IConstants;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.XWTException;
import org.eclipse.papyrus.xwt.XWTMaps;
import org.eclipse.papyrus.xwt.metadata.IMetaclass;
import org.eclipse.swt.layout.GridData;

/**
 * String to Integer converter
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class StringToInteger implements IConverter {

	private static final String GRIDDATA_PREFIX = "GRIDDATA.";

	private static final String STYLES_SEP = "|";

	public static StringToInteger instance = new StringToInteger();

	protected StringToNumberConverter toNumberConverter = StringToNumberConverter.toInteger(false);

	public Object convert(Object fromObject) {
		String str = (String)fromObject;
		if(str.indexOf(STYLES_SEP) != -1) {
			List<String> values = new ArrayList<String>();
			StringTokenizer stk = new StringTokenizer(str, STYLES_SEP);
			while(stk.hasMoreTokens()) {
				values.add(stk.nextToken());
			}
			int result = 0;
			for(String value : values) {
				result |= convertInt(value.trim());
			}
			return result;
		}
		return convertInt(str);
	}

	protected int convertInt(String str) {
		if(str == null || str.equals("")) {
			return 0;
		}
		try {
			// Quick solution for numbers.			
			return (Integer)toNumberConverter.convert(str);
		} catch (Exception e) {
			String normalizedStr = str.toUpperCase().trim();
			if(normalizedStr.startsWith(GRIDDATA_PREFIX)) {
				return convertGridDataInt(normalizedStr);
			}
			try {
				int index = str.lastIndexOf('.');
				if(str.indexOf('.') != -1) {
					String className = str.substring(0, index);
					if(className.startsWith("(") && className.endsWith("")) {
						className = className.substring(1, className.length() - 1);
						Class<?> type = XWT.getLoadingContext().loadClass(className);
						if(type != null) {
							String memberName = str.substring(index + 1);
							Field field = type.getField(memberName);
							if(Modifier.isStatic(field.getModifiers())) {
								return field.getInt(null);
							}
						}
					} else {
						IMetaclass metaclass = XWT.getMetaclass(className, IConstants.XWT_NAMESPACE);
						if(metaclass != null) {
							Class<?> type = metaclass.getType();
							if(type != null) {
								String memberName = str.substring(index + 1);
								Field field = type.getField(memberName);
								if(Modifier.isStatic(field.getModifiers())) {
									return field.getInt(null);
								}
							}
						}
					}
				}
			} catch (SecurityException e1) {
			} catch (IllegalArgumentException e1) {
			} catch (NoSuchFieldException e1) {
			} catch (IllegalAccessException e1) {
			} catch (XWTException e1) {
			}
			return defaultConvertInt(str);
		}
	}

	protected int convertGridDataInt(String str) {
		if("GridData.BEGINNING".equalsIgnoreCase(str)) {
			return GridData.BEGINNING;
		} else if("GridData.CENTER".equalsIgnoreCase(str)) {
			return GridData.CENTER;
		} else if("GridData.END".equalsIgnoreCase(str)) {
			return GridData.END;
		} else if("GridData.FILL".equalsIgnoreCase(str)) {
			return GridData.FILL;
		} else if("GridData.FILL_BOTH".equalsIgnoreCase(str)) {
			return GridData.FILL_BOTH;
		} else if("GridData.FILL_HORIZONTAL".equalsIgnoreCase(str)) {
			return GridData.FILL_HORIZONTAL;
		} else if("GridData.GRAB_HORIZONTAL".equalsIgnoreCase(str)) {
			return GridData.GRAB_HORIZONTAL;
		} else if("GridData.GRAB_VERTICAL".equalsIgnoreCase(str)) {
			return GridData.GRAB_VERTICAL;
		} else if("GridData.HORIZONTAL_ALIGN_BEGINNING".equalsIgnoreCase(str)) {
			return GridData.HORIZONTAL_ALIGN_BEGINNING;
		} else if("GridData.HORIZONTAL_ALIGN_CENTER".equalsIgnoreCase(str)) {
			return GridData.HORIZONTAL_ALIGN_CENTER;
		} else if("GridData.HORIZONTAL_ALIGN_END".equalsIgnoreCase(str)) {
			return GridData.HORIZONTAL_ALIGN_END;
		} else if("GridData.HORIZONTAL_ALIGN_FILL".equalsIgnoreCase(str)) {
			return GridData.HORIZONTAL_ALIGN_FILL;
		} else if("GridData.VERTICAL_ALIGN_BEGINNING".equalsIgnoreCase(str)) {
			return GridData.VERTICAL_ALIGN_BEGINNING;
		} else if("GridData.VERTICAL_ALIGN_CENTER".equalsIgnoreCase(str)) {
			return GridData.VERTICAL_ALIGN_CENTER;
		} else if("GridData.VERTICAL_ALIGN_END".equalsIgnoreCase(str)) {
			return GridData.VERTICAL_ALIGN_END;
		} else if("GridData.VERTICAL_ALIGN_FILL".equalsIgnoreCase(str)) {
			return GridData.VERTICAL_ALIGN_FILL;
		}
		return 0;
	}

	protected int defaultConvertInt(String str) {
		return XWTMaps.getValue(str);
	}

	public Object getFromType() {
		return String.class;
	}

	public Object getToType() {
		return Integer.class;
	}
}
