/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.utils;

import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.swt.graphics.Point;

/**
 * 
 * This class allows to store information about a location
 * 
 */
public class LocationValue {

	/**
	 * the initial point (mouse information)
	 */
	final private Point absolutePoint;

	/**
	 * the same point, but in the coordinate of the widget
	 */
	final private Point widgetPoint;


	/**
	 * the kind of the location
	 */
	final private TableGridRegion kind;

	/**
	 * the column index
	 */
	final private int columnIndex;

	/**
	 * the row index
	 */
	final private int rowIndex;

	/**
	 * the layerCell if this location
	 */
	final private ILayerCell layerCell;

	/**
	 * the columnObject
	 */
	final private Object columnObject;

	/**
	 * the rowObject
	 */
	final private Object rowObject;

	/**
	 * Constructor.
	 * 
	 * @param kind
	 *        the kind of location
	 * @param cell
	 *        the cell located as this place
	 * @param columnIndex
	 *        the columnIndex
	 * @param rowIndex
	 *        the rowIndex
	 * @param columnObject
	 *        the column object
	 * @param rowObject
	 *        the row object
	 */
	public LocationValue(final TableGridRegion kind, final ILayerCell cell, final int columnIndex, final int rowIndex, final Object columnObject, final Object rowObject) {
		this(null, null, kind, cell, columnIndex, rowIndex, columnObject, rowObject);
	}




	/**
	 * Constructor.
	 * 
	 * @param absoluteLocation
	 *        a location in the absolute coordinate
	 * @param widgetLocation
	 *        the same point, but with the widget coordinate
	 * @param kind
	 *        the kind of location
	 * @param cell
	 *        the cell located as this place
	 * @param columnIndex
	 *        the columnIndex
	 * @param rowIndex
	 *        the rowIndex
	 * @param columnObject
	 *        the column object
	 * @param rowObject
	 *        the row object
	 */
	public LocationValue(final Point absoluteLocation, final Point widgetLocation, final TableGridRegion kind, final ILayerCell cell, final int columnIndex, final int rowIndex, final Object columnObject, final Object rowObject) {
		this.absolutePoint = absoluteLocation;
		this.widgetPoint = widgetLocation;
		this.kind = kind;
		this.layerCell = cell;
		this.columnIndex = columnIndex;
		this.rowIndex = rowIndex;
		this.columnObject = columnObject;
		this.rowObject = rowObject;
	}

	/**
	 * Gets the point.
	 * 
	 * @return the point
	 */
	public Point getPoint() {
		return absolutePoint;
	}


	/**
	 * Gets the translated point.
	 * 
	 * @return the translated point
	 */
	public Point getTranslatedPoint() {
		return widgetPoint;
	}

	/**
	 * Gets the kind.
	 * 
	 * @return the kind
	 */
	public TableGridRegion getKind() {
		return kind;
	}


	/**
	 * Gets the column index.
	 * 
	 * @return the column index
	 */
	public int getColumnIndex() {
		return columnIndex;
	}


	/**
	 * Gets the row index.
	 * 
	 * @return the row index
	 */
	public int getRowIndex() {
		return rowIndex;
	}


	/**
	 * Gets the layer cell.
	 * 
	 * @return the layer cell
	 */
	public ILayerCell getLayerCell() {
		return layerCell;
	}

	/**
	 * Gets the absolute point.
	 * 
	 * @return the absolute point
	 */
	public Point getAbsolutePoint() {
		return absolutePoint;
	}


	/**
	 * Gets the widget point.
	 * 
	 * @return the widget point
	 */
	public Point getWidgetPoint() {
		return widgetPoint;
	}


	/**
	 * Gets the column object.
	 * 
	 * @return the column object
	 */
	public Object getColumnObject() {
		return columnObject;
	}


	/**
	 * Gets the row object.
	 * 
	 * @return the row object
	 */
	public Object getRowObject() {
		return rowObject;
	}

	/**
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		String message = "location : " + this.kind + ", columnIndex :" + this.columnIndex + ", rowIndex :" + this.rowIndex + ", columnObject :" + this.columnObject + ", rowObject :" + this.rowObject;
		return message;
	}
}
