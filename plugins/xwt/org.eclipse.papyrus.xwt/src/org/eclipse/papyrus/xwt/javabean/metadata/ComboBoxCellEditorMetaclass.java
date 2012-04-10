/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.       *
 * All rights reserved. This program and the accompanying materials            *
 * are made available under the terms of the Eclipse Public License v1.0       *
 * which accompanies this distribution, and is available at                    *
 * http://www.eclipse.org/legal/epl-v10.html                                   *
 *                                                                             *  
 * Contributors:                                                               *        
 *     Soyatec - initial API and implementation                                *
 *******************************************************************************/
package org.eclipse.papyrus.xwt.javabean.metadata;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.papyrus.xwt.IXWTLoader;
import org.eclipse.papyrus.xwt.jface.ComboBoxCellEditor;
import org.eclipse.papyrus.xwt.jface.JFacesHelper;
import org.eclipse.papyrus.xwt.metadata.IMetaclass;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

public class ComboBoxCellEditorMetaclass extends Metaclass {

	public ComboBoxCellEditorMetaclass(IMetaclass superClass, IXWTLoader xwtLoader) {
		super(ComboBoxCellEditor.class, superClass, xwtLoader);
	}

	/**
	 * @see org.eclipse.papyrus.xwt.javabean.metadata.Metaclass#newInstance(java.lang. Object[])
	 */
	@Override
	public Object newInstance(Object[] parameters) {
		try {
			if(parameters.length == 1) {
				Constructor<?> constructor = getType().getConstructor(Composite.class, String[].class);
				return constructor.newInstance(getParent(parameters[0]), new String[]{});
			} else if(parameters.length == 2) {
				Constructor<?> constructor = getType().getConstructor(Composite.class, String[].class, int.class);
				return constructor.newInstance(getParent(parameters[0]), new String[]{}, parameters[2]);
			} else if(parameters.length == 3) {
				Constructor<?> constructor = getType().getConstructor(Composite.class, String[].class, int.class);
				return constructor.newInstance(getParent(parameters[0]), parameters[1], parameters[2]);
			}
		} catch (SecurityException e1) {
		} catch (IllegalArgumentException e1) {
		} catch (NoSuchMethodException e1) {
		} catch (InstantiationException e1) {
		} catch (IllegalAccessException e1) {
		} catch (InvocationTargetException e1) {
		}
		return super.newInstance(parameters);
	}

	private Widget getParent(Object object) {
		Widget parent = null;
		Widget directParent = null;

		if(object instanceof Widget) {
			directParent = parent = (Widget)object;
		} else if(JFacesHelper.isViewer(object)) {
			directParent = parent = JFacesHelper.getControl(object);
		} else
			throw new IllegalStateException();
		if(Control.class.isAssignableFrom(getType()) && !(parent instanceof Composite)) {
			directParent = xwtLoader.findCompositeParent(parent);
		}

		return directParent;
	}
}
