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

import org.eclipse.papyrus.xwt.XWTMaps;
import org.eclipse.papyrus.xwt.metadata.ILoadingType;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class TableEditorDynamicProperty extends AbstractProperty {

	public TableEditorDynamicProperty() {
		super(PropertiesConstants.PROPERTY_DYNAMIC, Boolean.class);
	}

	public TableEditorDynamicProperty(ILoadingType loadingType) {
		super(PropertiesConstants.PROPERTY_DYNAMIC, Boolean.class, loadingType);
	}

	/**
	 * @see org.eclipse.papyrus.xwt.metadata.IProperty#getValue(java.lang.Object)
	 */
	public Object getValue(Object target) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		return null;
	}

	/**
	 * @see org.eclipse.papyrus.xwt.metadata.IProperty#setValue(java.lang.Object, java.lang.Object)
	 */
	public void setValue(Object target, Object value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {

		Boolean isDynamic = (Boolean)value;
		TableEditor tableEditor = (TableEditor)target;
		final Control control = tableEditor.getEditor();
		Table tableParent = null;
		Composite parent = control.getParent();
		if(parent instanceof Table) {
			tableParent = (Table)parent;
		} else if(tableEditor.getItem() != null) {
			tableParent = tableEditor.getItem().getParent();
		}
		if(tableParent == null) {
			return;
		}
		final Table table = tableParent;
		if(isDynamic) {
			control.setVisible(false);
			control.addFocusListener(new FocusAdapter() {

				@Override
				public void focusLost(FocusEvent e) {
					control.setVisible(false);
				}
			});

			control.addKeyListener(new KeyAdapter() {

				@Override
				public void keyPressed(KeyEvent e) {
					if(e.character == SWT.CR && control.isFocusControl()) {
						table.notifyListeners(SWT.DefaultSelection, new Event());
					}
				}
			});

			Object mouseHander = table.getData(PropertiesConstants.DATA_TABLE_UTIL);
			if(mouseHander == null) {
				TableUtil tableUtil = new TableUtil(table);
				table.setData(PropertiesConstants.DATA_TABLE_UTIL, tableUtil);
			}

			table.addSelectionListener(new TableSelectionHandler(table, tableEditor));
		}
	}

	static private class TableSelectionHandler implements SelectionListener {

		private Table table;

		private TableEditor tableEditor;

		public TableSelectionHandler(Table table, TableEditor tableEditor) {
			this.table = table;
			this.tableEditor = tableEditor;
		}

		public void widgetDefaultSelected(SelectionEvent e) {
			Control editor = tableEditor.getEditor();
			if(editor.isDisposed()) {
				return;
			}
			if(editor.isFocusControl()) {
				editor.setVisible(false);
			} else {
				editor.setFocus();
			}
		}

		public void widgetSelected(SelectionEvent e) {
			Control editor = tableEditor.getEditor();
			if(editor.isDisposed()) {
				return;
			}
			TableUtil tableUtil = (TableUtil)table.getData(PropertiesConstants.DATA_TABLE_UTIL);
			TableItem item = tableUtil.getItem();
			int column = tableUtil.getColumn();

			if(item == tableEditor.getItem() && column == tableEditor.getColumn()) {
				editor.setVisible(true);
			} else {
				editor.setVisible(false);
			}
		}
	}

	private static class TableUtil extends MouseAdapter implements KeyListener {

		private Table table;

		private TableItem item;

		private TableColumn column;

		public TableUtil(Table table) {
			this.table = table;
			table.addMouseListener(this);
			table.addKeyListener(this);
		}

		@Override
		public void mouseDown(MouseEvent e) {
			if(table.isDisposed() || !table.isVisible())
				return;
			Point pt = new Point(e.x, e.y);
			int lineWidth = table.getLinesVisible() ? table.getGridLineWidth() : 0;
			TableItem item = table.getItem(pt);

			int start = item != null ? table.indexOf(item) : table.getTopIndex();
			int end = table.getItemCount();
			Rectangle clientRect = table.getClientArea();
			for(int i = start; i < end; i++) {
				TableItem nextItem = table.getItem(i);
				Rectangle rect = nextItem.getBounds(0);
				if(pt.y >= rect.y && pt.y < rect.y + rect.height + lineWidth) {
					item = nextItem;
					break;
				}
				if(rect.y > clientRect.y + clientRect.height)
					return;
			}
			if(item == null)
				return;

			this.item = item;

			TableColumn newColumn = null;
			int columnCount = table.getColumnCount();
			if(columnCount == 0) {
				if((table.getStyle() & SWT.FULL_SELECTION) == 0) {
					Rectangle rect = item.getBounds(0);
					rect.width += lineWidth;
					rect.height += lineWidth;
					if(!rect.contains(pt))
						return;
				}
			} else {
				for(int i = 0; i < columnCount; i++) {
					Rectangle rect = item.getBounds(i);
					rect.width += lineWidth;
					rect.height += lineWidth;
					if(rect.contains(pt)) {
						newColumn = table.getColumn(i);
						break;
					}
				}
				if(newColumn == null) {
					if((table.getStyle() & SWT.FULL_SELECTION) == 0)
						return;
					newColumn = table.getColumn(0);
				}
			}

			column = newColumn;
			table.notifyListeners(SWT.DefaultSelection, new Event());
		}

		public TableItem getItem() {
			return item;
		}

		public int getRow() {
			return item == null ? (table.getItemCount() > 0 ? 0 : -1) : table.indexOf(item);
		}

		public void setRow(int rowIndex) {
			if(rowIndex >= 0 && rowIndex < table.getItemCount()) {
				item = table.getItem(rowIndex);
			} else {
				item = null;
			}
		}

		public int getColumn() {
			return column == null ? (table.getColumnCount() > 0 ? 0 : -1) : table.indexOf(column);
		}

		public void setColumn(int columnIndex) {
			if(columnIndex >= 0 && columnIndex < table.getColumnCount()) {
				column = table.getColumn(columnIndex);
			} else {
				column = null;
			}
		}

		public void keyPressed(KeyEvent event) {
			int rowIndex = getRow();
			int columnIndex = column == null ? 0 : table.indexOf(column);

			switch(event.keyCode) {
			case SWT.ARROW_UP:
				setRow(Math.max(0, rowIndex - 1));
				break;
			case SWT.ARROW_DOWN:
				setRow(Math.min(rowIndex + 1, table.getItemCount() - 1));
				break;
			case SWT.ARROW_LEFT:
			case SWT.ARROW_RIGHT:
				int columnCount = table.getColumnCount();
				if(columnCount == 0)
					break;
				int[] order = table.getColumnOrder();
				int index = 0;
				while(index < order.length) {
					if(order[index] == columnIndex)
						break;
					index++;
				}
				if(index == order.length)
					index = 0;
				int leadKey = (XWTMaps.getStyle("SWT.RIGHT_TO_LEFT") != SWT.NONE) ? ((table.getStyle() & XWTMaps.getStyle("SWT.RIGHT_TO_LEFT")) != 0 ? SWT.ARROW_RIGHT : SWT.ARROW_LEFT) : SWT.ARROW_LEFT;
				if(event.keyCode == leadKey) {
					setColumn(order[Math.max(0, index - 1)]);
				} else {
					setColumn(order[Math.min(columnCount - 1, index + 1)]);
				}
				table.notifyListeners(SWT.Selection, new Event());
				break;
			case SWT.HOME:
				setRow(0);
				setColumn(columnIndex);
				break;
			case SWT.END:
				setRow(table.getItemCount() - 1);
				setColumn(columnIndex);
				break;
			case SWT.PAGE_UP:
				int topIndex = table.getTopIndex();
				if(topIndex == rowIndex) {
					Rectangle rect = table.getClientArea();
					TableItem item = table.getItem(topIndex);
					Rectangle itemRect = item.getBounds(0);
					rect.height -= itemRect.y;
					int height = table.getItemHeight();
					int page = Math.max(1, rect.height / height);
					topIndex = Math.max(0, topIndex - page + 1);
				}

				setRow(topIndex);
				break;
			case SWT.PAGE_DOWN:
				int downIndex = table.getTopIndex();
				Rectangle rect = table.getClientArea();
				TableItem item = table.getItem(downIndex);
				Rectangle itemRect = item.getBounds(0);
				rect.height -= itemRect.y;
				int height = table.getItemHeight();
				int page = Math.max(1, rect.height / height);
				int end = table.getItemCount() - 1;
				downIndex = Math.min(end, downIndex + page - 1);
				if(downIndex == rowIndex) {
					downIndex = Math.min(end, downIndex + page - 1);
				}
				setRow(downIndex);
				break;
			}
		}

		public void keyReleased(KeyEvent e) {
			// Ignore
		}
	}
}
