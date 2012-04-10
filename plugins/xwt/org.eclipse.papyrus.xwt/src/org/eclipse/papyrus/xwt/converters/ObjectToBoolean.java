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
 * String to Boolean converter
 * 
 * @author yyang
 */
public class ObjectToBoolean implements IConverter {

	public static ObjectToBoolean instance = new ObjectToBoolean();

	public Object convert(Object fromObject) {
		return fromObject != null;
	}

	public Object getFromType() {
		return Object.class;
	}

	public Object getToType() {
		return Boolean.class;
	}
}
