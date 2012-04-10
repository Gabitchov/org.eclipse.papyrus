/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.javabean.metadata.properties;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.papyrus.xwt.IConstants;
import org.eclipse.papyrus.xwt.XWTException;
import org.eclipse.papyrus.xwt.core.Style;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class StyleProperty extends AbstractProperty {

	public StyleProperty() {
		super(IConstants.XAML_STYLE, Object.class);
	}

	public Object getValue(Object target) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		return null;
	}

	public void setValue(Object target, Object value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		if(!(value instanceof Style)) {
			throw new XWTException("Style is expected.");
		}
		Style style = (Style)value;
		style.apply(target);
	}
}
