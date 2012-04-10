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

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.xwt.metadata.ILoadingType;

/**
 * IViewer property
 * 
 * @author yyang
 */
public class SingleSelectionBeanProperty extends AbstractProperty {

	public SingleSelectionBeanProperty(String name) {
		this(name, ILoadingType.DEFAULT);
	}

	public SingleSelectionBeanProperty(String name, ILoadingType loadingType) {
		super(name, Object.class, loadingType);
	}

	public Object getValue(Object source) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		ISelection selection = ((ISelectionProvider)source).getSelection();
		if(selection instanceof IStructuredSelection) {
			return ((IStructuredSelection)selection).getFirstElement();
		}
		return null;
	}

	public void setValue(Object source, Object value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		IStructuredSelection selection = value == null ? StructuredSelection.EMPTY : new StructuredSelection(value);
		if(source instanceof Viewer) {
			((Viewer)source).setSelection(selection, true);
		} else {
			((ISelectionProvider)source).setSelection(selection);
		}
	}
}
