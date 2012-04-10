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
import java.util.Collection;

import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class TableItemEditorProperty extends AbstractProperty {

	public TableItemEditorProperty() {
		super(PropertiesConstants.PROPERTY_EDITORS, Collection.class);
	}

	public Object getValue(Object target) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		return null;
	}

	public void setValue(Object target, Object value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		TableItem tableItem = (TableItem)target;
		Collection<TableEditor> tableEditors = (Collection<TableEditor>)value;

		for(TableEditor tableEditor : tableEditors) {
			if(tableEditor != null) {
				disposeOldEditor(tableEditor.getColumn(), tableItem);
				tableEditor.setItem(tableItem);
			}
		}
	}

	/**
	 * Dispose old Table editors for current tableItem at given column index.
	 * 
	 * @param column
	 * @param tableItem
	 */
	private void disposeOldEditor(int column, TableItem tableItem) {
		Table table = tableItem.getParent();
		Control[] children = table.getChildren();
		for(Control control : children) {
			Object editor = control.getData(PropertiesConstants.DATA_CONTROLEDITOR_OF_CONTROL);
			if(editor == null || !(editor instanceof TableEditor)) {
				continue;
			}
			if(column == ((TableEditor)editor).getColumn() && tableItem == ((TableEditor)editor).getItem()) {
				control.dispose();
			}
		}
	}
}
