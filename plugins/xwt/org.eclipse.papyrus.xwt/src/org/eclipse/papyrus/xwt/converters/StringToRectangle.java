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
import org.eclipse.swt.graphics.Rectangle;

/**
 * String to Rectangle converter
 * 
 * @author yyang
 */
public class StringToRectangle implements IConverter {

	public static StringToRectangle instance = new StringToRectangle();

	public Object convert(Object fromObject) {
		int x = 0;
		int y = 0;
		int width = 0;
		int height = 0;
		if(fromObject != null) {
			StringToIntArray arrayConvertor = new StringToIntArray();
			int[] array = (int[])arrayConvertor.convert(fromObject);
			if(array.length == 4) {
				x = array[0];
				y = array[1];
				width = array[2];
				height = array[3];
			}
		}
		return new Rectangle(x, y, width, height);
	}

	public Object getFromType() {
		return String.class;
	}

	public Object getToType() {
		return Rectangle.class;
	}

}
