/*******************************************************************************
 * Copyright (c) 2012 Original authors and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Original authors and others - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.infra.nattable.row.reorder;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.painter.IOverlayPainter;
import org.eclipse.nebula.widgets.nattable.reorder.command.ColumnReorderEndCommand;
import org.eclipse.nebula.widgets.nattable.reorder.command.ColumnReorderStartCommand;
import org.eclipse.nebula.widgets.nattable.selection.command.ClearAllSelectionsCommand;
import org.eclipse.nebula.widgets.nattable.ui.action.IDragMode;
import org.eclipse.nebula.widgets.nattable.ui.util.CellEdgeDetectUtil;
import org.eclipse.nebula.widgets.nattable.ui.util.CellEdgeEnum;
import org.eclipse.nebula.widgets.nattable.util.GUIHelper;
import org.eclipse.nebula.widgets.nattable.viewport.command.ViewportDragCommand;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

/**
 * Default {@link IDragMode} invoked for 'left click + drag' on the column header.<br/>
 * It does the following when invoked: <br/>
 * <ol>
 *    <li>Fires a column reorder command, to move columns</li>
 *    <li>Overlays a black line indicating the new column position</li>
 * </ol>
 */
public class RowReorderDragMode implements IDragMode {

	private NatTable natTable;
	private MouseEvent initialEvent;
	private MouseEvent currentEvent;
	private int dragFromGridRowPosition;

	protected RowReorderOverlayPainter targetOverlayPainter = new RowReorderOverlayPainter();//FIXME!

	@Override
	public void mouseDown(NatTable natTable, MouseEvent event) {
		this.natTable = natTable;
		this.initialEvent = event;
		this.currentEvent = this.initialEvent;
		this.dragFromGridRowPosition = getDragFromGridRowPosition();

        natTable.addOverlayPainter(this.targetOverlayPainter);

        natTable.doCommand(new ClearAllSelectionsCommand());

        fireMoveStartCommand(natTable, this.dragFromGridRowPosition);
	}

	@Override
	public void mouseMove(NatTable natTable, MouseEvent event) {
		this.currentEvent = event;

		natTable.doCommand(new ViewportDragCommand(event.x, -1));

		natTable.redraw();
	}

	@Override
	public void mouseUp(NatTable natTable, MouseEvent event) {
		natTable.removeOverlayPainter(this.targetOverlayPainter);

		int dragToGridRowPosition = getDragToGridRowPosition(getMoveDirection(event.y), natTable.getRowPositionByY(event.y));

		if(!isValidTargetRowPosition(natTable, this.dragFromGridRowPosition, dragToGridRowPosition, event)) {
			dragToGridRowPosition = -1;
		}

		fireMoveEndCommand(natTable, dragToGridRowPosition);

		natTable.doCommand(new ViewportDragCommand(-1, -1));  // Cancel any active viewport drag

		natTable.redraw();
	}

	private int getDragFromGridRowPosition() {
		return this.natTable.getRowPositionByY(this.initialEvent.y);
	}

	private int getDragToGridRowPosition(CellEdgeEnum moveDirection, int gridColumnPosition) {
		System.out.println(moveDirection);
		int dragToGridRowPosition = -1;

		if(moveDirection != null) {//FIXME
			switch (moveDirection) {
			case BOTTOM:
				dragToGridRowPosition = gridColumnPosition;
				break;
			case TOP:
				dragToGridRowPosition = gridColumnPosition + 1;
				break;
			}
		}

		return dragToGridRowPosition;
	}

	private CellEdgeEnum getMoveDirection(int y) {
	    ILayerCell cell = getRowCell(y);
	    if (cell != null) {
			Rectangle selectedRowHeaderRect = cell.getBounds();
//			System.out.println(selectedRowHeaderRect);Point(x, initialEvent.y)
			return CellEdgeDetectUtil.getVerticalCellEdge(selectedRowHeaderRect, new Point(this.initialEvent.x,y ), -1);
	    }

		return null;
	}

	private ILayerCell getRowCell(int y) {
	    int gridColumnPosition = natTable.getColumnPositionByX(initialEvent.x);
	    int gridRowPosition = natTable.getRowPositionByY(y);
	    return natTable.getCellByPosition(gridColumnPosition, gridRowPosition);
	}

	protected boolean isValidTargetRowPosition(ILayer natLayer, int dragFromGridColumnPosition, int dragToGridColumnPosition, MouseEvent event) {
		return dragFromGridColumnPosition >= 0 && dragToGridColumnPosition >= 0;
	}

	protected void fireMoveStartCommand(NatTable natTable, int dragFromGridColumnPosition) {
		natTable.doCommand(new RowReorderStartCommand(natTable, dragFromGridColumnPosition));
	}

	protected void fireMoveEndCommand(NatTable natTable, int dragToGridColumnPosition) {
		natTable.doCommand(new RowReorderEndCommand(natTable, dragToGridColumnPosition));
	}

	private class RowReorderOverlayPainter implements IOverlayPainter {

		@Override
		public void paintOverlay(GC gc, ILayer layer) {
			int dragFromGridRowPosition = getDragFromGridRowPosition();

			if (RowReorderDragMode.this.currentEvent.y > RowReorderDragMode.this.natTable.getHeight()) {
				return;
			}

			CellEdgeEnum moveDirection = getMoveDirection(RowReorderDragMode.this.currentEvent.y);
			int dragToGridRowPosition = getDragToGridRowPosition(moveDirection, RowReorderDragMode.this.natTable.getRowPositionByY(RowReorderDragMode.this.currentEvent.y));

			if(isValidTargetRowPosition(RowReorderDragMode.this.natTable, dragFromGridRowPosition, dragToGridRowPosition, RowReorderDragMode.this.currentEvent)) {
				int dragToColumnHandleY = -1;

				if (moveDirection != null) {
					Rectangle selectedRowHeaderRect = getRowCell(RowReorderDragMode.this.currentEvent.y).getBounds();

					switch (moveDirection) {
					case TOP:
						dragToColumnHandleY = selectedRowHeaderRect.y;
						break;
					case BOTTOM:
						dragToColumnHandleY = selectedRowHeaderRect.y + selectedRowHeaderRect.height;
						break;
					}
				}

				if (dragToColumnHandleY > 0) {
					Color orgBgColor = gc.getBackground();
					gc.setBackground(GUIHelper.COLOR_DARK_GRAY);

					gc.fillRectangle(0, dragToColumnHandleY - 1, layer.getHeight(), 2);

					gc.setBackground(orgBgColor);
				}
			}
		}

	}

}
