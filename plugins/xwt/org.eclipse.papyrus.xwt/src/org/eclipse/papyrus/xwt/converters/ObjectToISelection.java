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

import java.util.Collection;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;

/**
 * Safely SWT context values, it used to avoid a NullPointerException when set
 * text values to SWT Widgets.
 * 
 * @author jliu
 */
public class ObjectToISelection implements IConverter {

	public static ObjectToISelection instance = new ObjectToISelection();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.databinding.conversion.IConverter#convert(java.lang.
	 * Object)
	 */
	public Object convert(Object fromObject) {
		if(fromObject == null) {
			return new StructuredSelection();
		}
		if(fromObject instanceof Collection<?>) {
			return new StructuredSelection(((Collection<?>)fromObject).toArray());
		} else if(fromObject.getClass().isArray()) {
			return new StructuredSelection((Object[])fromObject);
		}
		return new StructuredSelection(fromObject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.conversion.IConverter#getFromType()
	 */
	public Object getFromType() {
		return Object.class;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.conversion.IConverter#getToType()
	 */
	public Object getToType() {
		return ISelection.class;
	}

}
