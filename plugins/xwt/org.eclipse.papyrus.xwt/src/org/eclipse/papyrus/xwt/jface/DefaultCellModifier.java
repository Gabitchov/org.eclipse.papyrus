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

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.XWTException;
import org.eclipse.swt.widgets.TableItem;

public class DefaultCellModifier implements ICellModifier {

	protected TableViewer tableViewer;

	public DefaultCellModifier(TableViewer tableViewer) {
		this.tableViewer = tableViewer;
	}

	private BeanInfo getBeanInfo(Object element) {
		try {
			return java.beans.Introspector.getBeanInfo(element.getClass());
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean canModify(Object element, String property) {
		return getDescriptor(element, property) != null;
	}

	public Object getValue(Object element, String property) {
		PropertyDescriptor descriptor = getDescriptor(element, property);
		if(descriptor != null) {
			try {
				return descriptor.getReadMethod().invoke(element);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	public void modify(Object element, String property, Object value) {
		if(element instanceof TableItem) {
			TableItem tableItem = (TableItem)element;
			Object data = tableItem.getData();
			PropertyDescriptor descriptor = getDescriptor(data, property);
			if(descriptor != null) {
				try {
					Class<?> type = descriptor.getPropertyType();
					IConverter converter = XWT.findConvertor(value.getClass(), type);
					if(converter != null) {
						Object newValue = converter.convert(value);
						descriptor.getWriteMethod().invoke(data, newValue);
						tableViewer.refresh(data);
					} else {
						throw new XWTException("Converter doesn't exist from \"" + value.getClass().getName() + "\" to \"" + type.getName());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private PropertyDescriptor getDescriptor(Object element, String property) {
		BeanInfo beanInfo = getBeanInfo(element);
		if(beanInfo != null) {
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for(PropertyDescriptor propertyDescriptor : propertyDescriptors) {
				if(propertyDescriptor.getName().equalsIgnoreCase(property)) {
					return propertyDescriptor;
				}
			}
		}
		return null;
	}
}
