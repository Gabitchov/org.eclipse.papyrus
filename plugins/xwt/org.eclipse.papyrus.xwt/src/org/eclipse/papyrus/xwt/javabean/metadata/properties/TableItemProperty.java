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

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.TableItem;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class TableItemProperty extends AbstractProperty {

	public static class Cell {

		public Cell() {
		}

		private TableItem parent;

		private String text;

		private Image image;

		public TableItem getParent() {
			return parent;
		}

		public void setParent(TableItem parent) {
			this.parent = parent;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public Image getImage() {
			return image;
		}

		public void setImage(Image image) {
			this.image = image;
		}
	}

	public TableItemProperty() {
		super(PropertiesConstants.PROPERTY_CELLS, Collection.class);
	}

	public void setValue(Object target, Object value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {

		Collection<Cell> cells = (Collection<Cell>)value;
		TableItem tableItem = (TableItem)target;

		String[] texts = new String[cells.size()];
		Image[] images = new Image[cells.size()];

		int i = 0;
		for(Cell cell : cells) {
			String text = (cell).getText();
			texts[i] = text == null ? "" : text;
			images[i] = cell.getImage();
			i++;
		}
		tableItem.setText(texts);
		tableItem.setImage(images);
	}

	public Object getValue(Object target) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		return null;
	}
}
