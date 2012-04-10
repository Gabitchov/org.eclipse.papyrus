/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.       *
 * All rights reserved. This program and the accompanying materials            *
 * are made available under the terms of the Eclipse Public License v1.0       *
 * which accompanies this distribution, and is available at                    *
 * http://www.eclipse.org/legal/epl-v10.html                                   *  
 * Contributors:                                                               *  
 *     Soyatec - initial API and implementation                                * 
 *******************************************************************************/
package org.eclipse.papyrus.xwt.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

import org.eclipse.papyrus.xwt.internal.utils.ObjectUtil;
import org.eclipse.swt.graphics.Color;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class NamedColorsUtil {

	private static ResourceBundle COLORS = ResourceBundle.getBundle("org.eclipse.papyrus.xwt.utils.colors");

	private static String[] colorNames;
	static {
		List<String> colors = new ArrayList<String>();
		Enumeration<String> keys = COLORS.getKeys();
		while(keys.hasMoreElements()) {
			String color = keys.nextElement();
			colors.add(color);
		}
		if(!colors.isEmpty()) {
			colorNames = colors.toArray(new String[0]);
			Arrays.sort(colorNames);
		}
	}

	public static String[] getColorNames() {
		return colorNames;
	}

	public static String getColorValue(String name) {
		if(!hasColor(name)) {
			return null;
		}
		String value = COLORS.getString(name);
		if(value != null) {
			value = value.trim();
		}
		return value;
	}

	public static boolean hasColor(String name) {
		if(name == null) {
			return false;
		}
		String[] colorNames = getColorNames();
		if(colorNames == null) {
			return false;
		}
		return Arrays.asList(colorNames).contains(name);
	}

	public static Color getColor(String name) {
		if(!hasColor(name)) {
			return null;
		}
		String colorValue = getColorValue(name);
		if(colorValue != null) {
			return (Color)ObjectUtil.resolveValue(colorValue, Color.class, null);
		}
		return null;
	}

	/**
	 * Utility class.
	 */
	private NamedColorsUtil() {
	}
}
