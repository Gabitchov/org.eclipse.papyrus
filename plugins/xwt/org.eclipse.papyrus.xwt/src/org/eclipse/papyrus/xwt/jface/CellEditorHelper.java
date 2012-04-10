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

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.papyrus.xwt.XWTException;

public class CellEditorHelper {

	protected TableViewer tableViewer;

	protected int index;

	public CellEditorHelper(TableViewer parent, int index) {
		this.index = index;
		this.tableViewer = parent;
	}

	public Class<?> getTargetType() {
		ISelection selection = this.tableViewer.getSelection();
		if(!selection.isEmpty() && selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			Object element = structuredSelection.getFirstElement();
			Object property = this.tableViewer.getColumnProperties()[index];
			String propertyName = property.toString();
			try {
				BeanInfo beanInfo = java.beans.Introspector.getBeanInfo(element.getClass());
				PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
				for(PropertyDescriptor propertyDescriptor : propertyDescriptors) {
					if(propertyDescriptor.getName().equalsIgnoreCase(propertyName)) {
						return propertyDescriptor.getPropertyType();
					}
				}
			} catch (IntrospectionException e) {
				throw new XWTException(e);
			}
		}

		return null;
	}

}
