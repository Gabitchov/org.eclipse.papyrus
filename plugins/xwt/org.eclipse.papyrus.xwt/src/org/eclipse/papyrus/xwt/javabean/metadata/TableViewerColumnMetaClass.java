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

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.papyrus.xwt.IXWTLoader;
import org.eclipse.papyrus.xwt.metadata.IMetaclass;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;

public class TableViewerColumnMetaClass extends Metaclass {

	public TableViewerColumnMetaClass(IMetaclass superClass, IXWTLoader xwtLoader) {
		super(TableViewerColumn.class, superClass, xwtLoader);
	}

	/**
	 * @see org.eclipse.papyrus.xwt.javabean.metadata.Metaclass#newInstance(java.lang. Object[])
	 */
	@Override
	public Object newInstance(Object[] parameters) {
		Object object = doNewInstance(parameters);
		if(object != null) {
			initialize(object);
		}
		return object;
	}

	@Override
	public Object doNewInstance(Object[] parameters) {
		try {
			if(parameters.length == 1 && parameters[0] instanceof TableViewer) {
				Constructor<?> constructor = getType().getConstructor(TableViewer.class, int.class);
				return constructor.newInstance(parameters[0], SWT.NONE);
			} else if(parameters.length == 2) {
				if(parameters[0] instanceof TableViewer && parameters[1] instanceof Integer) {
					Constructor<?> constructor = getType().getConstructor(TableViewer.class, int.class);
					return constructor.newInstance(parameters);
				} else if(parameters[0] instanceof TableViewer && parameters[1] instanceof TableColumn) {
					Constructor<?> constructor = getType().getConstructor(TableViewer.class, TableColumn.class);
					return constructor.newInstance(parameters);
				}
			} else if(parameters.length == 3 && parameters[0] instanceof TableViewer && parameters[1] instanceof Integer && parameters[2] instanceof Integer) {
				Constructor<?> constructor = getType().getConstructor(TableViewer.class, int.class, int.class);
				return constructor.newInstance(parameters[0], ((Integer)parameters[1]).intValue(), ((Integer)parameters[2]).intValue());
			}
		} catch (SecurityException e) {
		} catch (IllegalArgumentException e) {
		} catch (NoSuchMethodException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		} catch (InvocationTargetException e) {
		}

		return super.newInstance(parameters);
	}
}
