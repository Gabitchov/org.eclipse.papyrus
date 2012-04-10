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
package org.eclipse.papyrus.xwt;

/**
 * The operation to inverse the converter direction.
 * 
 * @author yyang
 * 
 */
public class InverseValueConverter implements IValueConverter {

	private IValueConverter source;

	public InverseValueConverter(IValueConverter source) {
		this.source = source;
	}

	public Object convertBack(Object value) {
		return source.convert(value);
	}

	public Object convert(Object fromObject) {
		return source.convertBack(fromObject);
	}

	public Object getFromType() {
		return source.getToType();
	}

	public Object getToType() {
		return source.getFromType();
	}
}
