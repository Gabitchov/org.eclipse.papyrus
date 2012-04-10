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

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.papyrus.xwt.core.IUserDataConstants;
import org.eclipse.papyrus.xwt.internal.utils.UserData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class ColumnViewerColumnsProperty extends AbstractProperty {

	public ColumnViewerColumnsProperty() {
		super(PropertiesConstants.PROPERTY_COLUMNS, TableViewerColumn.class);
	}

	public Object getValue(Object target) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		return null;
	}

	public void setValue(Object target, Object value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		TableViewer tableViewer = (TableViewer)target;
		Table table = (Table)tableViewer.getControl();
		int count = table.getColumnCount();
		if(count != 0) {
			String[] columnProperties = new String[count];
			for(int i = 0; i < columnProperties.length; i++) {
				TableColumn column = table.getColumn(i);
				columnProperties[i] = (String)UserData.getLocalData(column, IUserDataConstants.XWT_PROPERTY_DATA_KEY);
				if(columnProperties[i] != null) {
					UserData.setLocalData(column, IUserDataConstants.XWT_PROPERTY_DATA_KEY, null);
				}
			}
			tableViewer.setColumnProperties(columnProperties);
		}
	}
}
