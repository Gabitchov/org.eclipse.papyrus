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
import org.eclipse.papyrus.xwt.utils.ResourceManager;
import org.eclipse.swt.graphics.Font;

/**
 * String to Font converter
 * 
 * @author yyang
 */
public class StringToFont implements IConverter {

	public static StringToFont instance = new StringToFont();

	public Object convert(Object fromObject) {
		return ResourceManager.resources.getFont((String)fromObject);
	}

	public Object getFromType() {
		return String.class;
	}

	public Object getToType() {
		return Font.class;
	}

}
