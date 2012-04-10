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
package org.eclipse.papyrus.xwt.jface;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.papyrus.xwt.IIndexedElement;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.XWTException;
import org.eclipse.swt.widgets.Composite;

public class TextCellEditor extends org.eclipse.jface.viewers.TextCellEditor implements IIndexedElement {

	protected CellEditorHelper cellEditorHelper;

	public TextCellEditor(Composite parent) {
		super(parent);
	}

	public TextCellEditor(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected void doSetValue(Object value) {
		if(value == null) {
			super.doSetValue("");
		} else {
			Class<?> targetType = getTargetType();
			if(targetType != String.class) {
				IConverter converter = XWT.findConvertor(targetType, String.class);
				if(converter != null) {
					value = converter.convert(value);
				}
			}
			super.doSetValue(value);
		}
	}

	@Override
	protected Object doGetValue() {
		Object value = super.doGetValue();
		Class<?> targetType = getTargetType();
		if(targetType != value.getClass()) {
			IConverter converter = XWT.findConvertor(value.getClass(), targetType);
			if(converter != null) {
				value = converter.convert(value);
			}
		}
		return value;
	}

	protected Class<?> getTargetType() {
		if(cellEditorHelper != null) {
			return cellEditorHelper.getTargetType();
		}
		return Object.class;
	}

	public void setIndex(Object parent, int index) {
		if(!(parent instanceof TableViewer)) {
			throw new XWTException("TableView is expected, not \"" + parent.getClass().getName() + "\"");
		}
		cellEditorHelper = new CellEditorHelper((TableViewer)parent, index);
	}
}
