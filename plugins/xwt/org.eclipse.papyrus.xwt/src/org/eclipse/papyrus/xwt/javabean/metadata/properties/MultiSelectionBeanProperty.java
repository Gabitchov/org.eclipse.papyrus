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
package org.eclipse.papyrus.xwt.javabean.metadata.properties;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.xwt.metadata.ILoadingType;

/**
 * Handle manually the type conversion. Maybe it can be done using the
 * IConverter. Only the type of IProperty should be IObservableCollection
 * 
 * @author yyang
 * 
 */
public class MultiSelectionBeanProperty extends AbstractProperty {

	public MultiSelectionBeanProperty(String name) {
		this(name, ILoadingType.DEFAULT);
	}

	public MultiSelectionBeanProperty(String name, ILoadingType loadingType) {
		super(name, Object.class, loadingType);
	}

	public Object getValue(Object source) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		ISelection selection = ((ISelectionProvider)source).getSelection();
		if(selection instanceof IStructuredSelection) {
			return ((IStructuredSelection)selection).toList();
		}
		return Collections.EMPTY_LIST;
	}

	public void setValue(Object source, Object value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		if(value instanceof List<?>) {
			List<?> list = (List<?>)value;
			((ISelectionProvider)source).setSelection(new StructuredSelection(list));
		} else if(value instanceof Set<?>) {
			Set<?> set = (Set<?>)value;
			((ISelectionProvider)source).setSelection(new StructuredSelection(set.toArray()));
			return;
		} else if(value.getClass().isArray()) {
			((ISelectionProvider)source).setSelection(new StructuredSelection((Object[])value));
			return;
		}
		((ISelectionProvider)source).setSelection(StructuredSelection.EMPTY);
	}
}
