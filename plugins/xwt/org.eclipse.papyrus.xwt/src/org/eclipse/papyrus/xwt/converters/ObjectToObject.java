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

/**
 * Object to Object converter: null converter
 * 
 * @author yyang
 */
public class ObjectToObject implements IConverter {

	public static ObjectToObject instance = new ObjectToObject();

	public Object convert(Object fromObject) {
		return fromObject;
	}

	public Object getFromType() {
		return Object.class;
	}

	public Object getToType() {
		return Object.class;
	}
}
