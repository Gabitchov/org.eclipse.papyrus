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
package org.eclipse.papyrus.xwt.javabean.metadata.properties;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.TableColumn;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class TableViewerColumnTextProperty extends AbstractProperty {

	public TableViewerColumnTextProperty() {
		super(PropertiesConstants.PROPERTY_TEXT, String.class);
	}

	public Object getValue(Object target) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		return null;
	}

	public void setValue(Object target, Object value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		TableViewerColumn tableViewerColumn = (TableViewerColumn)target;
		TableColumn tableColumn = tableViewerColumn.getColumn();
		String text = (String)value;
		tableColumn.setText(text);
	}
}
