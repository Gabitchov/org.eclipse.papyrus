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
package org.eclipse.papyrus.infra.nattable.common.listener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.command.LayerCommandUtil;
import org.eclipse.nebula.widgets.nattable.coordinate.PositionCoordinate;
import org.eclipse.nebula.widgets.nattable.grid.layer.GridLayer;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.papyrus.infra.nattable.common.layerstack.BodyLayerStack;
import org.eclipse.papyrus.infra.nattable.common.layerstack.ColumnHeaderLayerStack;
import org.eclipse.papyrus.infra.nattable.common.layerstack.RowHeaderLayerStack;
import org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.tools.util.IntegerAndSpreadsheetNumberConverter;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.graphics.Point;


public class NatTableDropListener implements DropTargetListener {

	private final NatTable natTable;

	private final Table pTable;

	private final INattableModelManager manager;

	private BodyLayerStack bodyLayer;

	private GridLayer gridLayer;

	private DropKindValue dropKindValue;

	public NatTableDropListener(final NatTable fNatTable, final INattableModelManager manager, final Table rawModel, final GridLayer gridLayer, final BodyLayerStack bodyLayer) {
		this.natTable = fNatTable;
		this.pTable = rawModel;
		this.manager = manager;
		this.gridLayer = gridLayer;
		this.bodyLayer = bodyLayer;
	}

	public void dragEnter(final DropTargetEvent event) {

	}

	public void dragLeave(final DropTargetEvent event) {

	}

	public void dragOperationChanged(final DropTargetEvent event) {

	}

	/**
	 * Return the position of a cell in grid coordinates, from a pixel location
	 * relative to the table control.
	 */
	public PositionCoordinate getCellPositionAt(final GridLayer gridLayer, final BodyLayerStack fBodyLayer, final int x, final int y) {
		int column = this.natTable.getColumnPositionByX(x);
		int row = this.natTable.getRowPositionByY(y);
		//		System.out.println("column" + column);
		//		System.out.println("row" + row);
		PositionCoordinate convertedPosition = LayerCommandUtil.convertPositionToTargetContext(new PositionCoordinate(gridLayer, column, row), fBodyLayer.getSelectionLayer());

		return convertedPosition;
	}

	public void dragOver(final DropTargetEvent event) {
		this.dropKindValue = null;
		final LocalTransfer localTransfer = LocalTransfer.getInstance();
		final Object data = localTransfer.nativeToJava(event.currentDataType);
		IStructuredSelection structuredSelection = null;
		if(data instanceof IStructuredSelection) {
			structuredSelection = (IStructuredSelection)data;
		}
		final Collection<Object> objectsToAdd = new ArrayList<Object>(structuredSelection.toList());
		this.dropKindValue = getDropKind(event);

		int drop = DND.DROP_NONE;
		switch(this.dropKindValue.getKind()) {
		case ADD_COLUMN:
			if(this.manager.canDropColumnsElement(objectsToAdd)) {
				drop = DND.DROP_DEFAULT;
			}
			break;
		case ADD_ROW:
			if(this.manager.canDropRowElement(objectsToAdd)) {
				drop = DND.DROP_DEFAULT;
			}
			break;
		case INSERT_COLUMN:
			if(this.manager.canInsertColumns(objectsToAdd, this.dropKindValue.getIndex())) {
				drop = DND.DROP_DEFAULT;
			}
			break;
		case INSERT_ROW:
			if(this.manager.canInsertRow(objectsToAdd, this.dropKindValue.getIndex())) {
				drop = DND.DROP_DEFAULT;
			}
			break;
		case SET_VALUE:
			//FIXME
			drop = DND.DROP_NONE;
			break;
		case UNKNOWN:
			drop = DND.DROP_NONE;
			break;
		default:
			drop = DND.DROP_NONE;
			break;
		}
		event.detail = drop;
	}

	public void drop(final DropTargetEvent event) {
		//we drop the elements into the table
		LocalTransfer localTransfer = LocalTransfer.getInstance();
		Object data = localTransfer.nativeToJava(event.currentDataType);
		if(data instanceof StructuredSelection) {
			final IStructuredSelection selection = (IStructuredSelection)data;
			final List<Object> droppedElements = selection.toList();
			switch(this.dropKindValue.getKind()) {
			case ADD_COLUMN:
				this.manager.addColumns(droppedElements);
				break;
			case ADD_ROW:
				this.manager.addRows(droppedElements);
				break;
			case INSERT_COLUMN:
				this.manager.insertColumns(droppedElements, this.dropKindValue.getIndex());
				break;
			case INSERT_ROW:
				this.manager.insertRows(droppedElements, this.dropKindValue.getIndex());
				break;
			case SET_VALUE:
				//FIXME
				break;
			case UNKNOWN:
				break;
			default:
				break;
			}
		}
		this.dropKindValue = null;
	}

	/**
	 *
	 * @param event
	 *        an event
	 * @return
	 *         the DropKind associated to this event
	 */
	private DropKindValue getDropKind(final DropTargetEvent event) {
		final Point point = this.natTable.toControl(event.x, event.y);
		DropKind kind = DropKind.UNKNOWN;
		final ILayer currentLayer = this.gridLayer.getChildLayerByLayoutCoordinate(point.x, point.y);
		int column = this.natTable.getColumnPositionByX(point.x);
		int row = this.natTable.getRowPositionByY(point.y);
		int index = -1;
		if(currentLayer instanceof BodyLayerStack) {
			//we set values
			kind = DropKind.SET_VALUE;
		} else if(currentLayer instanceof ColumnHeaderLayerStack) {
			//we insert columns
			kind = DropKind.INSERT_COLUMN;
			//FIXME : maybe not the better to get the index
			final ILayerCell cell = this.natTable.getCellByPosition(column, 0); //0, because we assume that we always display the numbers of the column
			assert cell != null;
			if(cell != null) {
				Object value = cell.getDataValue();
				assert value instanceof String;
				index = (IntegerAndSpreadsheetNumberConverter.toInt((String)value) - 1);
			}
		} else if(currentLayer instanceof RowHeaderLayerStack) {
			//we insert lines
			kind = DropKind.INSERT_ROW;
			//FIXME : maybe not the better to get the index
			final ILayerCell cell = this.natTable.getCellByPosition(0, row); //0, because we assume that we always display the numbers of the column
			assert cell != null;
			if(cell != null) {
				Object value = cell.getDataValue();
				assert value instanceof Integer;
				index = (Integer)value;
			}
		} else if(currentLayer == null) {
			int gridWidth = this.gridLayer.getWidth();
			int gridHeight = this.gridLayer.getHeight();
			if(point.x > gridWidth && point.y > gridHeight) {
				kind = DropKind.UNKNOWN;
			} else {
				if(point.x > gridWidth) {
					kind = DropKind.ADD_COLUMN;
				} else if(point.y > gridHeight) {
					kind = DropKind.ADD_ROW;
				}
			}

		}
		return new DropKindValue(kind, index);
	}

	public void dropAccept(final DropTargetEvent event) {

	}

	public enum DropKind {
		ADD_COLUMN, ADD_ROW, INSERT_ROW, INSERT_COLUMN, SET_VALUE, UNKNOWN;
	}

	public class DropKindValue {

		final private DropKind kind;


		public DropKind getKind() {
			return this.kind;
		}


		public int getIndex() {
			return this.index;
		}

		final private int index;

		public DropKindValue(final DropKind kind) {
			this(kind, -1);
		}

		public DropKindValue(final DropKind kind, final int index) {
			this.index = index;
			this.kind = kind;
		}
	}

}
